/*
 * http.h — WinInet HTTP POST 工具（无第三方依赖）
 */
#pragma once
#define WIN32_LEAN_AND_MEAN
#include <windows.h>
#include <wininet.h>
#include <stdlib.h>
#include <string.h>
#include <stdio.h>

#pragma comment(lib, "wininet.lib")

/* URL 编码，返回堆上字符串，调用方 free() */
static char* url_encode(const char* s) {
    size_t len = strlen(s);
    char* out = (char*)malloc(len * 3 + 1);
    if (!out) return NULL;
    char* p = out;
    for (size_t i = 0; i < len; i++) {
        unsigned char c = (unsigned char)s[i];
        if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') ||
            (c >= '0' && c <= '9') || c == '-' || c == '_' || c == '.' || c == '~') {
            *p++ = (char)c;
        } else {
            sprintf(p, "%%%02X", c);
            p += 3;
        }
    }
    *p = '\0';
    return out;
}

typedef struct { const char* key; const char* value; } kv_t;

/* 构建 application/x-www-form-urlencoded body */
static char* build_form(const kv_t* fields, int n) {
    char* body = (char*)calloc(1, 1);
    size_t blen = 0;
    for (int i = 0; i < n; i++) {
        char* ek = url_encode(fields[i].key);
        char* ev = url_encode(fields[i].value ? fields[i].value : "");
        size_t seg = strlen(ek) + 1 + strlen(ev) + 1;
        char* tmp = (char*)realloc(body, blen + seg + 2);
        if (!tmp) { free(ek); free(ev); free(body); return NULL; }
        body = tmp;
        if (blen > 0) { body[blen++] = '&'; }
        memcpy(body + blen, ek, strlen(ek)); blen += strlen(ek);
        body[blen++] = '=';
        memcpy(body + blen, ev, strlen(ev)); blen += strlen(ev);
        body[blen] = '\0';
        free(ek); free(ev);
    }
    return body;
}

/*
 * HTTP POST，返回堆上响应体字符串（调用方 free()），失败返回 NULL。
 * url 格式：http://host[:port]/path
 */
static char* http_post_form(const char* url, const kv_t* fields, int n) {
    /* 解析 URL */
    URL_COMPONENTSA uc = {0};
    uc.dwStructSize = sizeof(uc);
    char host[256] = {0}, path[1024] = {0};
    uc.lpszHostName = host; uc.dwHostNameLength = sizeof(host);
    uc.lpszUrlPath = path; uc.dwUrlPathLength = sizeof(path);
    if (!InternetCrackUrlA(url, 0, 0, &uc)) return NULL;

    HINTERNET hInet = InternetOpenA("c2agent/1.0", INTERNET_OPEN_TYPE_PRECONFIG, NULL, NULL, 0);
    if (!hInet) return NULL;

    HINTERNET hConn = InternetConnectA(hInet, host, uc.nPort ? uc.nPort : 80,
                                       NULL, NULL, INTERNET_SERVICE_HTTP, 0, 0);
    if (!hConn) { InternetCloseHandle(hInet); return NULL; }

    DWORD flags = INTERNET_FLAG_RELOAD | INTERNET_FLAG_NO_CACHE_WRITE;
    if (uc.nScheme == INTERNET_SCHEME_HTTPS) flags |= INTERNET_FLAG_SECURE;
    HINTERNET hReq = HttpOpenRequestA(hConn, "POST", path, NULL, NULL, NULL, flags, 0);
    if (!hReq) { InternetCloseHandle(hConn); InternetCloseHandle(hInet); return NULL; }

    /* 设置超时 12s */
    DWORD timeout = 12000;
    InternetSetOptionA(hReq, INTERNET_OPTION_RECEIVE_TIMEOUT, &timeout, sizeof(timeout));
    InternetSetOptionA(hReq, INTERNET_OPTION_SEND_TIMEOUT, &timeout, sizeof(timeout));

    char* body = build_form(fields, n);
    if (!body) { InternetCloseHandle(hReq); InternetCloseHandle(hConn); InternetCloseHandle(hInet); return NULL; }
    DWORD bodyLen = (DWORD)strlen(body);

    BOOL ok = HttpSendRequestA(hReq,
        "Content-Type: application/x-www-form-urlencoded\r\n",
        (DWORD)-1, body, bodyLen);
    free(body);
    if (!ok) { InternetCloseHandle(hReq); InternetCloseHandle(hConn); InternetCloseHandle(hInet); return NULL; }

    /* 读取响应 */
    size_t respCap = 4096, respLen = 0;
    char* resp = (char*)malloc(respCap);
    if (!resp) { InternetCloseHandle(hReq); InternetCloseHandle(hConn); InternetCloseHandle(hInet); return NULL; }
    DWORD read = 0;
    while (InternetReadFile(hReq, resp + respLen, (DWORD)(respCap - respLen - 1), &read) && read > 0) {
        respLen += read;
        if (respLen + 512 >= respCap) {
            respCap *= 2;
            char* tmp = (char*)realloc(resp, respCap);
            if (!tmp) { free(resp); resp = NULL; break; }
            resp = tmp;
        }
    }
    if (resp) resp[respLen] = '\0';

    InternetCloseHandle(hReq); InternetCloseHandle(hConn); InternetCloseHandle(hInet);
    return resp;
}
