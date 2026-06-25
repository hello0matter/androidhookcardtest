#!/usr/bin/env python3
"""
win_client/gen_blobs.py — 生成 src/blobs.h 的加密常量

用法：
    cd win_client
    python gen_blobs.py

修改下方 secrets[] 后运行，输出直接覆盖 src/blobs.h。
索引顺序必须与 src/config.h 中 BLOB_* 宏一一对应。
"""

import os

secrets = [
    "http://50.114.113.121",   # 0 BLOB_BASE_URL
    "1234567890abcdef",        # 1 BLOB_AES_KEY（暂未使用，占位）
    "/device/register",        # 2 BLOB_EP_REG
    "/device/heartbeat",       # 3 BLOB_EP_BEAT
    "/device/ack",             # 4 BLOB_EP_ACK
    "/device/upload",          # 5 BLOB_EP_UPLOAD
    "1.0.0",                   # 6 BLOB_VERSION
]

def mask(i, idd):
    return (0x5A ^ ((i * 0x1F) & 0xFF) ^ ((idd * 0x47) & 0xFF)) & 0xFF

lines = ['/*']
lines.append(' * blobs.h — 由 gen_blobs.py 自动生成，不要手动编辑')
lines.append(' */')
lines.append('#pragma once')
lines.append('#include <stddef.h>')
lines.append('')

for idd, s in enumerate(secrets):
    b = s.encode('utf-8')
    enc = [(b[i] ^ mask(i, idd)) & 0xFF for i in range(len(b))]
    arr = ','.join('0x%02x' % x for x in enc)
    lines.append('static const unsigned char B%d[] = {%s}; /* %s */' % (idd, arr, s))

lines.append('')
lines.append('static const unsigned char* const BLOBS[] = {%s};' % ','.join('B%d' % i for i in range(len(secrets))))
lines.append('static const int LENS[] = {%s};' % ','.join(str(len(s.encode('utf-8'))) for s in secrets))
lines.append('')

out = '\n'.join(lines)
out_path = os.path.join(os.path.dirname(__file__), 'src', 'blobs.h')
with open(out_path, 'w', encoding='utf-8') as f:
    f.write(out)
print('已写入 ' + out_path)
