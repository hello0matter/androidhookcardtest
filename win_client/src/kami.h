/*
 * kami.h — 卡密存储（注册表）+ 验证流程
 */
#pragma once
#define WIN32_LEAN_AND_MEAN
#include <windows.h>
#include "http.h"
#include "json.h"
#include <string.h>
#include <stdio.h>

#define KAMI_REG_PATH "SOFTWARE\\C2Agent"
#define KAMI_REG_KEY  "kami"

static void kami_save(const char* kami) {
    HKEY hKey;
    if (RegCreateKeyExA(HKEY_CURRENT_USER, KAMI_REG_PATH, 0, NULL,
                        REG_OPTION_NON_VOLATILE, KEY_WRITE, NULL, &hKey, NULL) == ERROR_SUCCESS) {
        RegSetValueExA(hKey, KAMI_REG_KEY, 0, REG_SZ, (LPBYTE)kami, (DWORD)(strlen(kami) + 1));
        RegCloseKey(hKey);
    }
}

static int kami_load(char* out, int len) {
    HKEY hKey;
    if (RegOpenKeyExA(HKEY_CURRENT_USER, KAMI_REG_PATH, 0, KEY_READ, &hKey) == ERROR_SUCCESS) {
        DWORD type, sz = (DWORD)len;
        int ok = (RegQueryValueExA(hKey, KAMI_REG_KEY, NULL, &type, (LPBYTE)out, &sz) == ERROR_SUCCESS);
        RegCloseKey(hKey);
        return ok && strlen(out) > 0;
    }
    return 0;
}

/*
 * 弹出卡密输入对话框（简单 InputBox）
 * 返回 1 表示用户输入了内容，out 填充卡密字符串
 */
static int kami_prompt(char* out, int len, const char* title, const char* message) {
    /* 用简单的 WM_GETTEXT 对话框实现 */
    static char s_buf[256];
    s_buf[0] = '\0';
    /* 弹出输入框：用 DialogBox 太复杂，这里用简单方案：
       先 MessageBox 提示，再用剪贴板或 shell 输入 */
    /* 实际用 CreateDialog 实现的轻量 InputBox */
    char prompt[512];
    snprintf(prompt, sizeof(prompt), "%s\n\n%s\n\n（请在接下来的对话框中输入）", title, message);
    MessageBoxA(NULL, prompt, title, MB_OK | MB_ICONINFORMATION | MB_TOPMOST);

    /* 使用 CredUI 做输入（系统级，无需额外资源） */
    CREDUI_INFOA cui = {0};
    cui.cbSize = sizeof(cui);
    cui.pszMessageText = message;
    cui.pszCaptionText = title;
    char user[2] = {0};
    char pass[256] = {0};
    DWORD err = CredUIPromptForCredentialsA(&cui, "card", NULL, 0,
        user, 2, pass, sizeof(pass), NULL,
        CREDUI_FLAGS_DO_NOT_PERSIST | CREDUI_FLAGS_GENERIC_CREDENTIALS |
        CREDUI_FLAGS_ALWAYS_SHOW_UI | CREDUI_FLAGS_EXCLUDE_CERTIFICATES);
    if (err == ERROR_SUCCESS && strlen(pass) > 0) {
        strncpy(out, pass, len - 1);
        out[len - 1] = '\0';
        SecureZeroMemory(pass, sizeof(pass));
        return 1;
    }
    SecureZeroMemory(pass, sizeof(pass));
    return 0;
}

#pragma comment(lib, "credui.lib")

/*
 * 验证卡密，返回 1 成功，0 失败。
 * verify_url: 完整验证接口 URL
 * kami: 卡密字符串
 * device_id: 设备标识
 */
static int kami_verify(const char* verify_url, const char* kami, const char* device_id) {
    kv_t fields[] = {
        {"input",     kami},
        {"deviceId",  device_id}
    };
    char* resp = http_post_form(verify_url, fields, 2);
    if (!resp) return 0;
    int code = json_int(resp, "code", -1);
    free(resp);
    return code == 0;
}
