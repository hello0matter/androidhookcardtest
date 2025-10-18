#!/system/bin-sh

# 【v16.0 - 绝对兼容守护版】
# 移除了 'declare -f'，使用更基础的后台化方法，兼容toybox/busybox。

# ------------------- 配置区 -------------------
# (这部分保持不变)
MY_PKG="com.example.msphone"
MY_MAIN_ACTIVITY="$MY_PKG/.MainActivity"
TARGET_APP_PACKAGE="com.android.contacts"
BROADCAST_ACTION="TOGGLE_FLOATING_WINDOW"
TOGGLE_INTERVAL=5
CHECK_INTERVAL=10
LOG_FILE="/data/local/tmp/final_monitor.log"
PID_FILE="/data/local/tmp/final_monitor.pid"

# ------------------- 核心逻辑 (不再封装在函数中) -------------------

# ------------------- 启动与防重复的“自主可控”逻辑 -------------------

# 脚本被触发时，首先记录日志。
# 使用 'touch' 和 'echo' 分开，更稳妥。
touch "$LOG_FILE"
echo "$(date '+%Y-%m-%d %H:%M:%S') - [$$] ------ Magisk service.d 脚本被触发 ------" >> "$LOG_FILE"

# 检查PID文件是否存在
if [ -f "$PID_FILE" ]; then
    existing_pid=$(cat "$PID_FILE" 2>/dev/null)
    if [ -n "$existing_pid" ] && ps -p $existing_pid > /dev/null; then
        echo "$(date '+%Y-%m-%d %H:%M:%S') - [$$] 守护检查: 监控进程 (PID: $existing_pid) 已在运行，退出。" >> "$LOG_FILE"
        exit 0
    fi
fi

# 【【【 核心修改 】】】
# 我们将整个无限循环的主体包裹在一个子shell `(...)` 中，
# 然后将这个子shell整体放到后台执行 `&`。
# 并且使用 `nohup` 来保护它。

(
    # 循环开始时，将自己的PID写入文件
    echo $$ > "$PID_FILE"
    echo "$(date '+%Y-%m-%d %H:%M:%S') - [$$] 核心监控循环已启动 (PID: $$)。" >> "$LOG_FILE"

    # 等待系统完全启动
    while [ "$(getprop sys.boot_completed)" != "1" ]; do sleep 1; done
    echo "$(date '+%Y-%m-%d %H:%M:%S') - [$$] 系统启动完成，开始正式监控。" >> "$LOG_FILE"

    while true; do
        # --- 功能一：守护您自己的App ---
        if ! dumpsys activity processes | grep -q "$MY_PKG"; then
            echo "$(date '+%Y-%m-%d %H:%M:%S') - [$$] 守护: '$MY_PKG' 未运行，正在拉起..." >> "$LOG_FILE"
            am start -n "$MY_MAIN_ACTIVITY" > /dev/null 2>&1
        fi

        # --- 功能二：监控目标前台App ---
        current_focus=$(dumpsys window | grep mCurrentFocus 2>/dev/null)

        if echo "$current_focus" | grep -q "$TARGET_APP_PACKAGE"; then
            echo "$(date '+%Y-%m-%d %H:%M:%S') - [$$] 监控: '$TARGET_APP_PACKAGE' 在前台，发送广播。" >> "$LOG_FILE"
            am broadcast -a "$BROADCAST_ACTION" > /dev/null 2>&1
            sleep $TOGGLE_INTERVAL
        else
            sleep $CHECK_INTERVAL
        fi
    done
) >/dev/null 2>&1 &

echo "$(date '+%Y-%m-%d %H:%M:%S') - [$$] 守护检查: 新的后台监控进程已启动。脚本退出。" >> "$LOG_FILE"
exit 0