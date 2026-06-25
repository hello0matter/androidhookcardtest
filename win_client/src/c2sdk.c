/*
 * c2sdk.c — DLL 入口
 * 编译为 c2sdk.dll：
 *   mingw: gcc -shared -o c2sdk.dll c2sdk.c -lwininet -lrpcrt4 -lcredui -mwindows -O2 -s
 *   msvc:  cl /LD c2sdk.c /link wininet.lib rpcrt4.lib credui.lib /SUBSYSTEM:WINDOWS
 */
#include "c2.h"

BOOL WINAPI DllMain(HINSTANCE hInst, DWORD reason, LPVOID _) {
    (void)hInst; (void)_;
    if (reason == DLL_PROCESS_DETACH) C2_Stop();
    return TRUE;
}
