"""Deploy and verify the updated card_server on 50.114.113.121.

Reads SSH password from env (PASSWD). Never echoes it.
"""
import os
import sys
import time
import json
import posixpath
from pathlib import Path

import paramiko

HOST = "50.114.113.121"
USER = "root"
PASSWORD = os.environ["PASSWD"]
REMOTE_DIR = "/root/card_server"
LOCAL_DIR = Path(r"D:\tmp\anjian\pj\bz\百步\card_server")

def run(client, cmd, *, check=False, get_pty=False):
    print(f"$ {cmd}")
    stdin, stdout, stderr = client.exec_command(cmd, get_pty=get_pty)
    out = stdout.read().decode("utf-8", "replace")
    err = stderr.read().decode("utf-8", "replace")
    code = stdout.channel.recv_exit_status()
    if out:
        print(out.rstrip())
    if err:
        print("STDERR:", err.rstrip())
    if check and code != 0:
        raise RuntimeError(f"command failed ({code}): {cmd}")
    return code, out, err

def main():
    client = paramiko.SSHClient()
    client.set_missing_host_key_policy(paramiko.AutoAddPolicy())
    print(f"connecting to {USER}@{HOST}...")
    client.connect(HOST, username=USER, password=PASSWORD, timeout=20, look_for_keys=False, allow_agent=False)
    print("connected.")

    # 1. Inventory remote.
    run(client, f"ls -la {REMOTE_DIR}")
    run(client, f"head -1 {REMOTE_DIR}/server.js 2>/dev/null; wc -l {REMOTE_DIR}/server.js 2>/dev/null")
    run(client, f"head -1 {REMOTE_DIR}/public/admin.html 2>/dev/null; wc -l {REMOTE_DIR}/public/admin.html 2>/dev/null")

    # Detect how it's running.
    run(client, "ss -ltnp | grep -E ':80|:3000' || netstat -ltnp 2>/dev/null | grep -E ':80|:3000'")
    run(client, "systemctl status card_server 2>/dev/null | head -5; systemctl status card-server 2>/dev/null | head -5")
    run(client, "pm2 list 2>/dev/null | head -20")
    run(client, "ps aux | grep -E 'node .*server\\.js' | grep -v grep")

    # 2. Backup remote files (timestamped).
    ts = time.strftime("%Y%m%d_%H%M%S")
    backup = f"{REMOTE_DIR}/_backup_{ts}"
    run(client, f"mkdir -p {backup} && cp -a {REMOTE_DIR}/server.js {backup}/ 2>/dev/null && cp -a {REMOTE_DIR}/public/admin.html {backup}/ 2>/dev/null && cp -a {REMOTE_DIR}/data/db.json {backup}/ 2>/dev/null; ls {backup}", check=True)

    # 3. Upload new files via SFTP.
    sftp = client.open_sftp()
    uploads = [
        (LOCAL_DIR / "server.js", posixpath.join(REMOTE_DIR, "server.js")),
        (LOCAL_DIR / "public" / "admin.html", posixpath.join(REMOTE_DIR, "public", "admin.html")),
    ]
    for local_path, remote_path in uploads:
        print(f"upload {local_path} -> {remote_path}")
        sftp.put(str(local_path), remote_path)
    sftp.close()

    # 4. Syntax check on the remote node.
    run(client, f"cd {REMOTE_DIR} && node -c server.js && echo SYNTAX_OK", check=True)

    # 5. Restart. Try systemd, pm2, then fallback to killing process and starting in nohup.
    restarted = False
    code, _, _ = run(client, "systemctl is-active card_server 2>/dev/null || systemctl is-active card-server 2>/dev/null")
    if code == 0:
        for svc in ("card_server", "card-server"):
            c, _, _ = run(client, f"systemctl restart {svc} 2>&1")
            if c == 0:
                run(client, f"systemctl status {svc} --no-pager | head -6")
                restarted = True
                break
    if not restarted:
        code, out, _ = run(client, "pm2 list 2>/dev/null")
        if code == 0 and ("card" in out.lower() or "server" in out.lower()):
            run(client, "pm2 restart card_server 2>&1 || pm2 restart server 2>&1 || pm2 restart all 2>&1")
            restarted = True
    if not restarted:
        # Kill anything on 3000 and re-spawn under nohup.
        run(client, "pkill -f 'node .*server\\.js' || true")
        time.sleep(1)
        run(client, f"cd {REMOTE_DIR} && nohup node server.js > /var/log/card_server.log 2>&1 & disown; sleep 2; ss -ltnp | grep :3000")

    # 6. Verify via public IP.
    time.sleep(2)
    run(client, "curl -sS http://127.0.0.1:3000/health")
    run(client, "curl -sS -X POST http://127.0.0.1:3000/device/register -H 'Content-Type: application/json' -d '{\"device_id\":\"deploy-test\",\"software_type\":\"deploy_check\",\"os\":\"linux\"}'")

    client.close()
    print("done.")

if __name__ == "__main__":
    main()
