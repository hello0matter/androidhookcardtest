#!/system/bin/sh

# 【v22.0 - 硬重启版 + 联系人遥控器 + 日志】
# 修改说明：检测到安装后，执行系统级重启(reboot)，确保脚本能重新自动运行。

# ================= 配置区 =================

# 1. 你的辅助APP
MY_PKG="com.example.msphone"
MY_MAIN_ACTIVITY="$MY_PKG/.MainActivity"

# 2. 开关APP：联系人 (遥控器)
CONTACTS_PKG="com.android.contacts"

# 3. 监听安装的目标：本地云出行
CLOUD_PKG="com.eastedge.taxidriverforpad"

# 4. 广播动作
BROADCAST_ACTION="TOGGLE_FLOATING_WINDOW"

# 5. 日志文件
LOG_FILE="/sdcard/ms_monitor_log.txt"
# 标记文件
FLAG_FILE="/data/local/tmp/cloud_reboot_done.flag"

# ================= 工具函数 =================

log_msg() {
    #local timestamp=$(date '+%Y-%m-%d %H:%M:%S')
    #echo "[$timestamp] $1"
    #echo "[$timestamp] $1" >> "$LOG_FILE"
    :
}

# ================= 主逻辑 =================

main_loop() {
    log_msg ">>> 脚本启动 v22.0 (硬重启版) PID:$$ <<<"

    # --- 1. 等待开机 ---
    # 硬重启后，这里会重新等待，直到系统准备好
    while [ "$(getprop sys.boot_completed)" != "1" ]; do
        sleep 2
    done
    sleep 5

    # --- 2. 启动辅助APP ---
    am start -n "$MY_MAIN_ACTIVITY" >/dev/null 2>&1
    log_msg "系统启动完成，辅助APP已启动"

    # --- 3. 初始化状态锁 ---
    # 0=不在联系人, 1=在联系人
    last_state=0

    # --- 4. 进入监控循环 ---
    while true; do

        # ---------------------------------------------------
        # 任务 A：安装检测 -> 硬重启
        # ---------------------------------------------------
        if pm list packages | grep -q "$CLOUD_PKG"; then
            if [ ! -f "$FLAG_FILE" ]; then
                log_msg "【重要】检测到 $CLOUD_PKG 安装！"
                log_msg "正在创建标记并执行系统重启..."

                # 1. 创建标记 (防止重启后无限重启)
                touch "$FLAG_FILE"

                # 2. 同步磁盘 (防止标记文件没写进去就断电了)
                sync
                sleep 1

                # 3. 执行硬重启 (完全重启手机)
                reboot

                # 退出脚本
                exit 0
            fi
        else
            # 如果软件被卸载了，清除标记
            if [ -f "$FLAG_FILE" ]; then
                log_msg "检测到目标卸载，清除重启标记"
                rm -f "$FLAG_FILE"
            fi
        fi

        # ---------------------------------------------------
        # 任务 B：联系人遥控器 (进=切换，出=保持)
        # ---------------------------------------------------

        current_focus=$(dumpsys window | grep mCurrentFocus 2>/dev/null)

        # 判断是否在联系人界面
        if echo "$current_focus" | grep -q "$CONTACTS_PKG"; then

            # === 进入联系人 ===
            if [ "$last_state" -eq 0 ]; then
                log_msg "进入联系人 -> 触发开关广播"
                am broadcast -a "$BROADCAST_ACTION" >/dev/null 2>&1
                last_state=1
            fi

        else

            # === 离开联系人 ===
            if [ "$last_state" -eq 1 ]; then
                # 离开时不操作，保持悬浮窗状态
                # 方便去调节参数
                last_state=0
            fi

        fi

        sleep 1

    done
}

# 后台运行
main_loop &