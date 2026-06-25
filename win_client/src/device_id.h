/*
 * device_id.h — 生成/缓存稳定设备标识
 * 优先读注册表，首次运行生成 UUID 写入。
 */
#pragma once
#define WIN32_LEAN_AND_MEAN
#include <windows.h>
#include <rpc.h>
#include <string.h>
#include <stdio.h>

#pragma comment(lib, "rpcrt4.lib")

#define DID_REG_PATH "SOFTWARE\\C2Agent"
#define DID_REG_KEY  "did"

static void _generate_uuid(char* out, int len) {
    UUID uuid;
    UuidCreate(&uuid);
    unsigned char* str = NULL;
    UuidToStringA(&uuid, &str);
    if (str) {
        strncpy(out, (char*)str, len - 1);
        out[len - 1] = '\0';
        RpcStringFreeA(&str);
    } else {
        /* fallback: 时间戳 + 进程ID */
        snprintf(out, len, "win-%lu-%lu", GetTickCount(), GetCurrentProcessId());
    }
}

static void get_device_id(char* out, int len) {
    HKEY hKey;
    /* 尝试读取 */
    if (RegOpenKeyExA(HKEY_CURRENT_USER, DID_REG_PATH, 0, KEY_READ, &hKey) == ERROR_SUCCESS) {
        DWORD type, sz = (DWORD)len;
        if (RegQueryValueExA(hKey, DID_REG_KEY, NULL, &type, (LPBYTE)out, &sz) == ERROR_SUCCESS) {
            RegCloseKey(hKey);
            return;
        }
        RegCloseKey(hKey);
    }
    /* 首次：生成并写入 */
    _generate_uuid(out, len);
    if (RegCreateKeyExA(HKEY_CURRENT_USER, DID_REG_PATH, 0, NULL,
                        REG_OPTION_NON_VOLATILE, KEY_WRITE, NULL, &hKey, NULL) == ERROR_SUCCESS) {
        RegSetValueExA(hKey, DID_REG_KEY, 0, REG_SZ, (LPBYTE)out, (DWORD)(strlen(out) + 1));
        RegCloseKey(hKey);
    }
}
