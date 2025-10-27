#!/system/bin-sh

# 【最终版 v14.0 - 开机启动一次 + 前台监控】
# 1. 在系统启动完成后，只启动一次主Activity。
# 2. 持续监控前台应用，并在目标App在前台时，定时发送广播。

# ------------------- 配置区 -------------------
MY_PKG="com.example.msphone"
MY_MAIN_ACTIVITY="$MY_PKG/.MainActivity"
TARGET_APP_PACKAGE="com.android.contacts"
BROADCAST_ACTION="TOGGLE_FLOATING_WINDOW"
TOGGLE_INTERVAL=5
# 监控间隔（秒），当目标App不在前台时
CHECK_INTERVAL=2

# ------------------- 核心逻辑 -------------------

# 将所有逻辑放在一个函数中，以便在后台运行
main_loop() {
    # --- 阶段一：等待系统启动并执行一次性任务 ---

    # 1. 循环等待，直到系统属性 sys.boot_completed 变为 "1"
    while [ "$(getprop sys.boot_completed)" != "1" ]; do
        sleep 2
    done
    sleep 5
    # 2. 系统已启动，现在执行“只启动一次”的操作
    #    使用 am start 启动我们的主 Activity
    #    >/dev/null 2>&1 表示忽略所有输出和错误，实现“静默”执行
    am start  "$MY_MAIN_ACTIVITY"


    # --- 阶段二：进入持续监控的无限循环 ---
    while true; do
        # 1. 获取当前拥有焦点的窗口信息
        #    2>/dev/null 表示忽略 dumpsys 可能产生的错误信息
        current_focus=$(dumpsys window | grep mCurrentFocus 2>/dev/null)

        # 2. 检查当前焦点是否是我们的目标App
        if echo "$current_focus" | grep -q "$TARGET_APP_PACKAGE"; then
            # --- 目标App正在前台 ---
            # 发送广播
            am broadcast -a "$BROADCAST_ACTION"
            # 等待“捣蛋鬼”间隔
            sleep $TOGGLE_INTERVAL
        else
            # --- 目标App不在前台 ---
            # 等待较短的检查间隔
            sleep $CHECK_INTERVAL
        fi
    done
}

# 将整个 main_loop 函数放到后台(&)执行
main_loop &