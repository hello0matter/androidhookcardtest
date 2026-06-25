/*
 * json.h — 极简 JSON 字段提取（无第三方依赖）
 * 只做字符串/整数提取，够用于解析服务端心跳响应。
 */
#pragma once
#include <string.h>
#include <stdlib.h>

/* 在 json 字符串中找 "key": value，返回 value 起始指针 */
static const char* json_find_value(const char* json, const char* key) {
    char needle[256];
    snprintf(needle, sizeof(needle), "\"%s\"", key);
    const char* p = strstr(json, needle);
    if (!p) return NULL;
    p += strlen(needle);
    while (*p == ' ' || *p == '\t' || *p == '\n' || *p == '\r') p++;
    if (*p != ':') return NULL;
    p++;
    while (*p == ' ' || *p == '\t' || *p == '\n' || *p == '\r') p++;
    return p;
}

/* 提取字符串值到 buf（去掉引号，处理 \\" 转义），返回 1 成功 */
static int json_str(const char* json, const char* key, char* buf, int buflen) {
    const char* v = json_find_value(json, key);
    if (!v || *v != '"') return 0;
    v++;
    int i = 0;
    while (*v && *v != '"' && i < buflen - 1) {
        if (*v == '\\' && *(v+1)) { v++; }
        buf[i++] = *v++;
    }
    buf[i] = '\0';
    return 1;
}

/* 提取整数值 */
static int json_int(const char* json, const char* key, int def) {
    const char* v = json_find_value(json, key);
    if (!v) return def;
    return atoi(v);
}

/* 提取布尔值（true=1, false=0, default=def） */
static int json_bool(const char* json, const char* key, int def) {
    const char* v = json_find_value(json, key);
    if (!v) return def;
    if (strncmp(v, "true", 4) == 0) return 1;
    if (strncmp(v, "false", 5) == 0) return 0;
    return def;
}

/*
 * 迭代 JSON 数组中的对象
 * 每次调用返回下一个 '{...}' 对象的起始指针，*end 指向 '}' 之后
 * ctx 传 NULL 从头开始，返回 NULL 表示结束
 */
static const char* json_array_next(const char* array_start, const char** ctx, const char** end) {
    const char* p = *ctx ? *ctx : array_start;
    while (*p && *p != '{' && *p != ']') p++;
    if (!*p || *p == ']') return NULL;
    const char* obj = p++;
    int depth = 1;
    while (*p && depth > 0) {
        if (*p == '{') depth++;
        else if (*p == '}') depth--;
        p++;
    }
    *end = p;
    *ctx = p;
    return obj;
}
