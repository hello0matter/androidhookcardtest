# 加固与反逆向说明（HARDENING）

本工程已在「源码 + 构建」层面做了分层防护。本文件说明已内置的防护、如何复现，以及
**构建之后**还需手工接入的商业加固步骤。

> 诚实前提：没有任何方案能让 APK「绝对不可逆」。目标是让**自动化/AI 静态分析不可行、
> 让人工逆向代价极高**。下面每一层都针对不同攻击面。

---

## 1. 已内置的分层防护

### (A) 原生密钥层 `libsecure.so`（专打静态分析 / 字符串提取）
- 路径：`app/src/main/cpp/secure.c`、`CMakeLists.txt`。
- 服务端地址、AES 密钥、各端点路径、版本号**不以明文存在于 DEX**，而是以 XOR 编码字节
  存放在 `.so` 中（`nb(id)` 返回**仍是编码态**的字节，由 Java 侧 `Codec.unblob` 还原）。
  → 逆向 DEX 看不到字符串，逆向 `.so` 也只看到编码字节，必须同时拿到两侧 + 算法。
- `ad()`：运行期反调试/反注入（`/proc/self/status` 的 TracerPid + `/proc/self/maps` 扫 Frida/gum/gadget）。
- `sig()`：预留签名校验基线（默认空 → 不校验，见第 4 节）。

### (B) 自定义高熵编码 `Codec`（专打通用工具 / AI 特征识别）
- 路径：`Codec.java`。融合了本项目原有的非标准手法：字符级 XOR、滚动 XOR + URL-safe Base64
  的本地保险库、分层 DES。**不匹配任何通用库特征**，自动反混淆器与 AI 无法套用现成套路。
- 本地缓存（卡密 / 到期 / 绑定标记）经 `Store` + `Codec` 包裹落盘 → `dump` SharedPreferences 是乱码。

### (C) R8 full mode + 收紧的 ProGuard 规则（专打类/方法语义）
- `app/proguard-rules.pro`：`-repackageclasses ''`、`-allowaccessmodification`、激进优化。
- 仅保号：manifest 组件、JNI `native <methods>`、`@JavascriptInterface` 成员、Gson 模型、Xposed 入口 `com.example.msphone.xp`。
- release 已开启 `minifyEnabled` + `shrinkResources`。

### (D) 运行期安全闸门 `Guard`（专打运行环境）
- 按服务端 `ban_Root / ban_Xposed / ban_Emulator / ban_VirtualApp / ban_DualApp` 开关，
  检测 root / Xposed-LSPosed / 模拟器 / 虚拟多开 / 调试器 / Frida，违规即锁定退出。
- 默认全关（不误杀），由后台 `/admin` 按需开启。

---

## 2. 多设备兼容

- `minSdk 24`（Android 7+），所有版本相关调用已 `SDK_INT` 守卫。
- 原生 `abiFilters arm64-v8a, armeabi-v7a`（覆盖绝大多数真机；模拟器可在 `build.gradle` 加 `x86_64`）。
- WebView 缺失/被禁用时，卡密弹窗自动回退到**原生输入框**。
- root 仅用于**可选**的自毁/卸载；无 root 时闸门与心跳照常工作。

---

## 3. 复现构建

```bash
# 调试包（不混淆，便于联调；仍编译 NDK）
gradlew :app:assembleDebug

# 发布包（R8 + 资源压缩 + NDK 多 ABI）
gradlew :app:assembleRelease
```

修改密钥/端点后，用生成器重算原生编码字节并回填 `secure.c`：

```bash
python tools/gen_blobs.py
```

---

## 4. 启用签名自校验（可选，推荐）

1. 在 `app/build.gradle` 配好 release `signingConfig`（用你的 keystore）。
2. 取签名证书 SHA-256：
   ```bash
   keytool -list -v -keystore your.keystore -alias your_alias
   ```
3. 把该哈希按 `id=99` 的掩码编码（改 `tools/gen_blobs.py` 增加一条），回填 `secure.c` 的 `SIGEXP[]` 与 `SIGEXP_LEN`。
4. 在 `Guard.evaluate` 增加：取 `PackageManager` 当前签名 SHA-256 与 `Vault.expectedSignature()` 比对，
   不一致即判违规。→ 二次打包/重签会被拦截。

---

## 5. 构建之后：接入商业加固（DEX 抽取壳 / VMP）

Gradle 产出的 release APK 仍是标准 DEX，**强烈建议**再过一层商业加固（这一步**无法在本工程内完成**，
需对产物 APK 操作）：

| 方案 | 能力 | 备注 |
|------|------|------|
| 360 加固保 | DEX 抽取/壳、反调试、防二次打包 | 免费档够用 |
| 腾讯乐固（legu） | DEX 加壳、SO 加固、VMP | 需企业账号 |
| Bangcle / 爱加密 | DEX/SO 加固 | |
| DexProtector | 字符串加密、类抽取、SO 加固、商业级 | 收费，最强 |

接入流程（通用）：
1. `gradlew :app:assembleRelease` 得到**未签名或已签名**的 APK。
2. 上传到加固平台 → 下载加固后的 APK。
3. **重新签名**（加固通常会破坏原签名）：
   ```bash
   apksigner sign --ks your.keystore --ks-key-alias your_alias out-hardened.apk
   ```
4. 校验：`apksigner verify -v out-hardened.apk`。

注意事项：
- 本工程已内置多 ABI `.so`，选择加固方案时确认其**支持对 SO 加固**且不丢 ABI。
- 加固后务必在 arm64 与 armv7 真机各回归一次（部分壳与 WebView/前台服务有兼容性差异）。
- 若启用了第 4 节签名自校验，请在**最终签名后**再取哈希回填，否则会自锁。

---

## 6. 攻击面对照表（这套做法为什么不同）

| 攻击手段 | 被哪一层挡 |
|----------|-----------|
| jadx/JEB 直接读字符串拿密钥 | (A) 密钥在 SO 且为编码态 |
| AI / 通用反混淆器识别「这是 AES/OkHttp」 | (B) 非标准高熵编码，无特征可匹配 |
| 读 SharedPreferences 拿卡密 | (B) Store+Codec 乱码落盘 |
| 类名/方法名猜语义 | (C) R8 重命名 + 重打包 |
| Frida hook 解密函数 | (A) `ad()` 检测注入 + (D) 闸门退出 |
| 调试器单步 | (A) TracerPid 检测 |
| 模拟器/多开批量跑 | (D) `ban_Emulator/VirtualApp` |
| 二次打包重签 | 第 4 节签名自校验 + 第 5 节壳防重打包 |
| 直接脱 DEX | 第 5 节商业抽取壳 |
