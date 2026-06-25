/*
 * vault.h — 解码混淆字符串
 */
#pragma once
#include "blobs.h"
#include "config.h"
#include <string.h>
#include <stdlib.h>

/* 解码一条 blob，返回堆上 NUL 结尾字符串，调用方负责 free() */
static char* vault_get(int id) {
    if (id < 0 || id >= NBLOBS) return _strdup("");
    int len = LENS[id];
    char* out = (char*)malloc(len + 1);
    if (!out) return NULL;
    const unsigned char* src = BLOBS[id];
    for (int i = 0; i < len; i++) {
        unsigned char m = (unsigned char)((0x5A ^ ((i * 0x1F) & 0xFF) ^ ((id * 0x47) & 0xFF)) & 0xFF);
        out[i] = (char)((src[i] ^ m) & 0xFF);
    }
    out[len] = '\0';
    return out;
}

/* 便捷宏：声明局部变量，用完记得 free */
#define VAULT_STR(var, id)  char* var = vault_get(id)
