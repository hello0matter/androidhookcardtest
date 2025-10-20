#!/system/bin-sh

# 【v23.0 - 最终版 - 基于输出判断】
# 使用您验证可行的方法，并通过检查命令输出是否为空来判断进程是否存在。
# 这是最稳健、最不依赖特定工具行为的方法。

# ------------------- 配置区 -------------------
MY_PKG="com.example.msphone"
MY_MAIN_ACTIVITY="$MY_PKG/.MainActivity"
TARGET_APP_PACKAGE="com.android.contacts"
BROADCAST_ACTION="TOGGLE_FLOATING_WINDOW"
TOGGLE_INTERVAL=5
CHECK_INTERVAL=10
LOG_FILE="/data/local/tmp/final_monitor_log.txt"

# ------------------- 核心逻辑 -------------------
(
    echo "--- Final Monitor v23.0 Started at $(date) ---" > "$LOG_FILE"
    while [ "$(getprop sys.boot_completed)" != "1" ]; do sleep 1; done
    echo "$(date '+%Y-%m-%d %H:%M:%S') - System boot completed. Starting loop..." >> "$LOG_FILE"

    while true; do

        # --- 【【【 核心修正：直接判断输出内容 】】】 ---

        # 1. 执行命令并将其输出捕获到变量 `process_info` 中
        process_info=$(ps -A | grep "$MY_PKG" | grep -v "grep")

        # 2. 使用 [ -z "$variable" ] 来判断字符串是否为空
        #    -z 表示 "is zero length" (长度为零)
        #    ! -z 表示 "is not zero length" (长度不为零)
        #    我们用 if [ -z ... ] 来判断是否没找到

        if [ -z "$process_info" ]; then
            # --- 字符串为空，说明进程确实不存在 ---
            echo "$(date '+%Y-%m-%d %H:%M:%S') - DAEMON: '$MY_PKG' is NOT running. Starting it..." >> "$LOG_FILE"
            am start -n "$MY_MAIN_ACTIVITY" >/dev/null 2>&1
            sleep 2
        fi

        # --- 功能二：监控目标前台App (保持不变) ---
        current_focus=$(dumpsys window | grep mCurrentFocus 2>/dev/null)

        if echo "$current_focus" | grep -q "$TARGET_APP_PACKAGE"; then
            echo "$(date '+%Y-%m-%d %H:%M:%S') - MONITOR: '$TARGET_APP_PACKAGE' is foreground. Broadcasting..." >> "$LOG_FILE"
            am broadcast -a "$BROADCAST_ACTION" >/dev/null 2>&1
            sleep $TOGGLE_INTERVAL
        else
            sleep $CHECK_INTERVAL
        fi

    done
) &