# deploy_vps.ps1 — 部署 card_server 到 VPS
param([switch]$AdminOnly, [switch]$ServerOnly)

$hostname = "50.114.113.121"
$port = 22
$user = "root"
$root = "D:\tmp\anjian\pj\st\tmp\tmp\androidhookcardtest\card_server"

$password = Read-Host "SSH password for root@${hostname}" -AsSecureString
$ptr = [System.Runtime.InteropServices.Marshal]::SecureStringToBSTR($password)
$plain = [System.Runtime.InteropServices.Marshal]::PtrToStringBSTR($ptr)
[System.Runtime.InteropServices.Marshal]::ZeroFreeBSTR($ptr)

$files = @()
if (-not $AdminOnly) {
    $files += @("$root\server.js", "/root/card_server/server.js")
}
if (-not $ServerOnly) {
    $files += @("$root\public\admin.html", "/root/card_server/public/admin.html")
}

python -c @"
import paramiko, sys, os

ssh = paramiko.SSHClient()
ssh.set_missing_host_key_policy(paramiko.AutoAddPolicy())
try:
    ssh.connect('$hostname', $port, '$user', '$plain', timeout=15)
    sftp = ssh.open_sftp()
    files = $(for ($i = 0; $i -lt $files.Count; $i += 2) { "'$($files[$i])' : '$($files[$i+1])'" }) -join ",`n        "
    for local, remote in [($files -join ',')]:
        local = local.replace('\\', '/')
        sftp.put(local, remote)
        sftp.chmod(remote, 0o644)
        print(f'  {local.split(\"/\")[-1]} -> {remote}')
    sftp.close()
    if not $AdminOnly:
        stdin, stdout, stderr = ssh.exec_command('cd /root/card_server && pm2 restart card_server 2>&1')
        result = stdout.read().decode() + stderr.read().decode()
        print('PM2 restart: ' + (result.strip() if result.strip() else 'ok'))
    ssh.close()
    print('DONE')
except Exception as e:
    print(f'ERROR: {e}', file=sys.stderr)
    sys.exit(1)
"@

$plain = $null
