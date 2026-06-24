package com.example.msphone;

/**
 * 原生密钥保险库的 Java 门面。
 *
 * 所有敏感常量（服务端地址、AES 密钥、各端点路径、版本号）都不以明文存在于 DEX 中：
 * 它们以 XOR 编码字节存放于 libsecure.so，经 {@link Codec#unblob} 在用时还原。
 * 这样静态反编译 DEX 看不到字符串，逆向 .so 也只看到编码字节。
 *
 * 该类含 native 方法，会被 ProGuard 的 `native <methods>` 规则保号（JNI 绑定依赖类名/方法名）。
 */
final class Vault {

    // blob id —— 必须与 cpp/secure.c 中 BLOBS[] 的顺序一致
    private static final int ID_BASE_URL  = 0;
    private static final int ID_AES_KEY   = 1;
    private static final int ID_EP_CONFIG = 2;
    private static final int ID_EP_VERIFY = 3;
    private static final int ID_EP_REG    = 4;
    private static final int ID_EP_BEAT   = 5;
    private static final int ID_EP_ACK    = 6;
    private static final int ID_VERSION   = 7;

    private static boolean available = false;

    static {
        try {
            System.loadLibrary("secure");
            available = true;
        } catch (Throwable t) {
            available = false;
        }
    }

    private Vault() {}

    static boolean isAvailable() {
        return available;
    }

    // --- native ---
    private static native byte[] nb(int id);   // 返回 XOR 编码字节
    private static native int ad();             // 反调试/反注入位标志
    private static native byte[] sig();         // 期望签名哈希（编码字节，可能为空）

    private static String s(int id) {
        if (!available) return "";
        return Codec.unblob(nb(id), id);
    }

    static String baseUrl()      { return s(ID_BASE_URL); }
    static String aesKey()       { return s(ID_AES_KEY); }
    static String versionShell() { return s(ID_VERSION); }

    static String urlConfig()    { return baseUrl() + s(ID_EP_CONFIG); }
    static String urlVerify()    { return baseUrl() + s(ID_EP_VERIFY); }
    static String urlRegister()  { return baseUrl() + s(ID_EP_REG); }
    static String urlHeartbeat() { return baseUrl() + s(ID_EP_BEAT); }
    static String urlAck()       { return baseUrl() + s(ID_EP_ACK); }

    /**
     * 反调试/反注入。返回 0 表示干净；bit0=被调试器附加，bit1=检测到 Frida 注入痕迹。
     * 原生不可用时保守返回 0（不误杀）。
     */
    static int antiDebug() {
        if (!available) return 0;
        try {
            return ad();
        } catch (Throwable t) {
            return 0;
        }
    }

    /** 期望的签名证书哈希（SHA-256），未配置时长度为 0 表示「不校验」。 */
    static byte[] expectedSignature() {
        if (!available) return new byte[0];
        try {
            byte[] enc = sig();
            if (enc == null || enc.length == 0) return new byte[0];
            // 与 secure.c 一致：id 99 的掩码
            byte[] out = new byte[enc.length];
            for (int i = 0; i < enc.length; i++) {
                int m = (0x5A ^ ((i * 0x1F) & 0xFF) ^ ((99 * 0x47) & 0xFF)) & 0xFF;
                out[i] = (byte) ((enc[i] ^ m) & 0xFF);
            }
            return out;
        } catch (Throwable t) {
            return new byte[0];
        }
    }
}
