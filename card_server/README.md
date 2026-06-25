# 百步召月卡服务端

这是给手工改包 `http://50.114.113.121` 用的最小服务端，包含：

- APP 远程配置接口：`GET/POST /`
- 卡密验证接口：`POST /kami/verify`
- 可视化后台：`GET /admin`
- JSON 数据库：`data/db.json`

## 1. 安装

```bash
cd card_server
cp .env.example .env
node server.js
```

默认让 Node 监听 `3000`，由 Nginx 的 `80` 端口反代到 `127.0.0.1:3000`：

```env
PORT=3000
PUBLIC_BASE_URL=http://50.114.113.121
ADMIN_USER=admin
ADMIN_PASSWORD=你的强密码
```

不要让 Node 直接监听 `80`，否则会和 Nginx 冲突并报 `EADDRINUSE: address already in use 0.0.0.0:80`。

Nginx 反代示例：

```nginx
location / {
    proxy_pass http://127.0.0.1:3000;
    proxy_set_header Host $host;
    proxy_set_header X-Real-IP $remote_addr;
    proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
}
```

## 2. 后台登录

浏览器打开：

```text
http://50.114.113.121/admin
```

默认账号密码在 `.env.example`：

```text
admin / change-me-123
```

上线前务必改密码。

## 3. 月卡逻辑

- 后台生成卡密，默认 30 天。
- 用户首次验证成功时开始计时。
- 首次验证时绑定设备 ID。
- 同一卡密在其他设备上会提示“卡密已绑定其他设备”。
- 后台可禁用、删除、解绑设备。

## 4. APP 请求格式

卡密验证接口接收表单：

```text
input=卡密
appId=29131
appKey=6312
deviceId=设备ID
package=com.corget.driver
version_name=...
version_code=...
version_shell=155
```

成功返回：

```json
{"code":0,"message":"验证成功","data":{"remaining_seconds":86400}}
```

失败返回：

```json
{"code":-1,"message":"卡密不存在","data":{"remaining_seconds":0}}
```

## 5. 重要说明

APP 根接口 `/` 返回的是 AES 加密后的远程配置，密钥默认 `1234567890abcdef`，与 APK 中的配置解析逻辑匹配。

如果 APP 不弹窗：

1. 确认 Node 监听 `3000`，Nginx 监听 `80` 并反代到 `3000`。
2. 浏览器访问 `http://50.114.113.121/health`。
3. 确认改包 APK 是 `baibu_7.1.37_manualbackend-signed.apk`。
4. 查看服务器控制台是否收到 `POST /` 请求。

