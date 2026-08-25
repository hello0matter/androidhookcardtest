#!/usr/bin/env python3
"""从生产服务器同步 /root/card_server 到本地主仓库。

零参数运行即可。脚本会：
1. 通过 SSH 密码连接服务器；
2. 完整下载远程 card_server；
3. 校验 server.js 并创建本地 ZIP 备份；
4. 原子替换本地主目录；
5. 删除已确认的重复旧副本。

密码只从交互输入或 CARD_SERVER_SSH_PASSWORD 环境变量读取，不写入文件或日志。
"""

from __future__ import annotations

import getpass
import hashlib
import os
import shutil
import stat
import subprocess
import sys
import tempfile
import time
from pathlib import Path, PurePosixPath

import paramiko

HOST = os.environ.get("CARD_SERVER_SSH_HOST", "50.114.113.121")
PORT = int(os.environ.get("CARD_SERVER_SSH_PORT", "22"))
USER = os.environ.get("CARD_SERVER_SSH_USER", "root")
REMOTE_DIR = PurePosixPath(os.environ.get("CARD_SERVER_REMOTE_DIR", "/root/card_server"))

REPO_ROOT = Path(r"D:\tmp\anjian\pj\st\tmp\tmp\androidhookcardtest")
TARGET_DIR = REPO_ROOT / "card_server"
BACKUP_DIR = Path(r"D:\tmp\card_server_sync_backups")

# 这些路径是用户明确确认不再需要的重复源码目录。不得动态扩大删除范围。
OBSOLETE_DIRS = (
    Path(r"D:\tmp\anjian\pj\bz\baibu\card_server"),
    Path(r"D:\tmp\anjian\pj\bz\baibu\card_server - 副本 (2)准备ds"),
    Path(r"D:\tmp\anjian\pj\bz\baibu\card_server - 副本准备cc"),
    Path(r"D:\tmp\hsz_card_server_runtime"),
    REPO_ROOT / "_backup_card_server_merge_20260717_110652",
    REPO_ROOT / "_backup_local_runtime_full_20260717_110955",
)


def sha256(path: Path) -> str:
    digest = hashlib.sha256()
    with path.open("rb") as stream:
        for chunk in iter(lambda: stream.read(1024 * 1024), b""):
            digest.update(chunk)
    return digest.hexdigest()


def assert_safe_delete(path: Path) -> None:
    resolved = path.resolve()
    allowed = {item.resolve() for item in OBSOLETE_DIRS}
    if resolved not in allowed:
        raise RuntimeError(f"拒绝删除未列入白名单的路径：{resolved}")
    if resolved == TARGET_DIR.resolve() or resolved == REPO_ROOT.resolve():
        raise RuntimeError(f"拒绝删除主目录：{resolved}")


def remote_is_dir(mode: int) -> bool:
    return stat.S_ISDIR(mode)


def remote_is_link(mode: int) -> bool:
    return stat.S_ISLNK(mode)


def download_tree(sftp: paramiko.SFTPClient, remote: PurePosixPath, local: Path) -> tuple[int, int]:
    local.mkdir(parents=True, exist_ok=True)
    file_count = 0
    total_bytes = 0
    for entry in sftp.listdir_attr(str(remote)):
        remote_path = remote / entry.filename
        local_path = local / entry.filename
        if remote_is_dir(entry.st_mode):
            child_files, child_bytes = download_tree(sftp, remote_path, local_path)
            file_count += child_files
            total_bytes += child_bytes
            continue
        if remote_is_link(entry.st_mode):
            # 源码目录若存在符号链接，保存链接目标文本，避免在 Windows 上错误跟随到目录外。
            target = sftp.readlink(str(remote_path))
            local_path.with_suffix(local_path.suffix + ".symlink").write_text(target, encoding="utf-8")
            file_count += 1
            continue
        print(f"下载 {remote_path}")
        sftp.get(str(remote_path), str(local_path))
        file_count += 1
        total_bytes += entry.st_size or 0
    return file_count, total_bytes


def validate_download(downloaded: Path) -> None:
    server_js = downloaded / "server.js"
    if not server_js.is_file() or server_js.stat().st_size < 1024:
        raise RuntimeError("远程目录中缺少有效的 server.js，终止替换。")
    package_json = downloaded / "package.json"
    if not package_json.is_file():
        raise RuntimeError("远程目录中缺少 package.json，终止替换。")

    node = shutil.which("node")
    if node:
        result = subprocess.run(
            [node, "--check", str(server_js)],
            capture_output=True,
            text=True,
            encoding="utf-8",
            errors="replace",
        )
        if result.returncode != 0:
            raise RuntimeError(f"远程 server.js 语法检查失败：\n{result.stdout}{result.stderr}")
        print("server.js 语法检查：通过")
    else:
        print("警告：本机没有 node，已跳过 JavaScript 语法检查。")


def replace_target(downloaded: Path) -> Path | None:
    BACKUP_DIR.mkdir(parents=True, exist_ok=True)
    stamp = time.strftime("%Y%m%d_%H%M%S")
    backup_zip: Path | None = None
    if TARGET_DIR.exists():
        backup_base = BACKUP_DIR / f"card_server_before_sync_{stamp}"
        backup_zip = Path(shutil.make_archive(str(backup_base), "zip", TARGET_DIR))
        print(f"已备份原目录：{backup_zip}")

    staging = TARGET_DIR.parent / f".card_server_remote_{stamp}"
    old = TARGET_DIR.parent / f".card_server_old_{stamp}"
    if staging.exists() or old.exists():
        raise RuntimeError("同步暂存目录已存在，请稍后重新运行。")

    shutil.move(str(downloaded), str(staging))
    try:
        if TARGET_DIR.exists():
            TARGET_DIR.rename(old)
        staging.rename(TARGET_DIR)
    except Exception:
        if TARGET_DIR.exists() and not old.exists():
            shutil.rmtree(TARGET_DIR, ignore_errors=True)
        if old.exists() and not TARGET_DIR.exists():
            old.rename(TARGET_DIR)
        raise
    else:
        if old.exists():
            shutil.rmtree(old)
    return backup_zip


def remove_obsolete_dirs() -> None:
    for path in OBSOLETE_DIRS:
        assert_safe_delete(path)
        if not path.exists():
            print(f"旧副本不存在，跳过：{path}")
            continue
        shutil.rmtree(path)
        print(f"已删除旧副本：{path}")


def main() -> int:
    if not REPO_ROOT.is_dir():
        raise RuntimeError(f"本地仓库不存在：{REPO_ROOT}")

    password = os.environ.get("CARD_SERVER_SSH_PASSWORD")
    if not password:
        password = getpass.getpass(f"请输入 {USER}@{HOST} 的 SSH 密码：")
    if not password:
        raise RuntimeError("SSH 密码不能为空。")

    temp_root = Path(tempfile.mkdtemp(prefix="card_server_remote_", dir=str(REPO_ROOT.parent)))
    downloaded = temp_root / "card_server"
    client = paramiko.SSHClient()
    # 某些 Windows known_hosts 文件是 UTF-16，Paramiko 会按系统 GBK 解码并报错。
    # 同步脚本不依赖该文件，首次连接仅在本次进程内接受服务器主机密钥。
    client.set_missing_host_key_policy(paramiko.AutoAddPolicy())

    try:
        print(f"连接 {USER}@{HOST}:{PORT} ...")
        client.connect(
            HOST,
            port=PORT,
            username=USER,
            password=password,
            timeout=20,
            auth_timeout=20,
            banner_timeout=20,
            look_for_keys=False,
            allow_agent=False,
        )
        print(f"下载 {REMOTE_DIR} ...")
        with client.open_sftp() as sftp:
            attrs = sftp.stat(str(REMOTE_DIR))
            if not remote_is_dir(attrs.st_mode):
                raise RuntimeError(f"远程路径不是目录：{REMOTE_DIR}")
            count, size = download_tree(sftp, REMOTE_DIR, downloaded)
        print(f"下载完成：{count} 个文件，约 {size / 1024 / 1024:.2f} MiB")

        validate_download(downloaded)
        remote_hash = sha256(downloaded / "server.js")
        print(f"远程 server.js SHA256：{remote_hash}")
        backup = replace_target(downloaded)
        local_hash = sha256(TARGET_DIR / "server.js")
        if local_hash != remote_hash:
            raise RuntimeError("替换后的 server.js 哈希不一致。")
        print(f"本地 server.js SHA256：{local_hash}")

        remove_obsolete_dirs()
        print("\n同步成功。")
        print(f"主目录：{TARGET_DIR}")
        if backup:
            print(f"回滚备份：{backup}")
        print("下一步请检查 git diff，确认敏感配置未被纳入提交后再推送。")
        return 0
    finally:
        password = ""
        client.close()
        if temp_root.exists():
            shutil.rmtree(temp_root, ignore_errors=True)


if __name__ == "__main__":
    try:
        raise SystemExit(main())
    except KeyboardInterrupt:
        print("\n用户取消。", file=sys.stderr)
        raise SystemExit(130)
    except Exception as error:
        print(f"同步失败：{error}", file=sys.stderr)
        raise SystemExit(1)
