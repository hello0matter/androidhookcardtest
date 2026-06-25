#!/usr/bin/env python3
"""deploy_vps.py — Upload card_server files to VPS and restart PM2.

Usage:
  python deploy_vps.py              # upload both server.js and admin.html
  python deploy_vps.py --server     # server.js only
  python deploy_vps.py --admin      # admin.html only
"""
import paramiko, os, sys, getpass

HOST = "50.114.113.121"
PORT = 22
USER = "root"
LOCAL_DIR = os.path.join(os.path.dirname(__file__), "card_server")

def deploy(files, password):
    ssh = paramiko.SSHClient()
    ssh.set_missing_host_key_policy(paramiko.AutoAddPolicy())
    ssh.connect(HOST, PORT, USER, password, timeout=15)
    sftp = ssh.open_sftp()
    for local, remote in files:
        sftp.put(local, remote)
        sftp.chmod(remote, 0o644)
        print(f"  {os.path.basename(local)} -> {remote}")
    sftp.close()
    restart = "--server" not in sys.argv
    if restart:
        stdin, stdout, stderr = ssh.exec_command("cd /root/card_server && pm2 restart card_server 2>&1")
        print("PM2:", (stdout.read().decode() + stderr.read().decode()).strip())
    ssh.close()
    print("DONE")

if __name__ == "__main__":
    pw = os.environ.get("SSH_PASS") or getpass.getpass(f"SSH password for {USER}@{HOST}: ")
    files = []
    if "--admin" not in sys.argv:
        files.append((os.path.join(LOCAL_DIR, "server.js"), "/root/card_server/server.js"))
    if "--server" not in sys.argv:
        files.append((os.path.join(LOCAL_DIR, "public", "admin.html"), "/root/card_server/public/admin.html"))
    deploy(files, pw)
