package com.example.msphone;

import android.util.Base64;

import java.nio.charset.StandardCharsets;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

/**
 * 集中化的编码原语库。
 *
 * 这里融合了本项目原有的、非标准的高熵编码手法（字符级 XOR、分层 DES + Base64/Hex、
 * ASCII 偏移）。它们的价值不在密码学强度，而在于「不匹配任何通用特征」——自动反混淆器
 * 与 AI 静态分析无法套用现成套路，必须从零重建语义，从而大幅抬高逆向成本。
 *
 * 真正的密钥/端点明文存放在原生层 libsecure.so（仅存 XOR 编码字节），由 {@link #unblob}
 * 在 Java 侧用与 secure.c 一致的掩码还原。两侧都不出现明文常量。
 */
final class Codec {

    private Codec() {}

    /* ============================================================
     * 1) 原生 blob 还原 —— 掩码公式必须与 cpp/secure.c 完全一致
     * ============================================================ */

    /** plain[i] = enc[i] ^ (0x5A ^ (i*0x1F) ^ (id*0x47))，与 secure.c 对称。 */
    static String unblob(byte[] enc, int id) {
        if (enc == null) return "";
        byte[] out = new byte[enc.length];
        for (int i = 0; i < enc.length; i++) {
            int m = (0x5A ^ ((i * 0x1F) & 0xFF) ^ ((id * 0x47) & 0xFF)) & 0xFF;
            out[i] = (byte) ((enc[i] ^ m) & 0xFF);
        }
        return new String(out, StandardCharsets.UTF_8);
    }

    /* ============================================================
     * 2) 字符级 XOR（沿用原有 xorObfuscate）
     * ============================================================ */

    static String xor(String input, char key) {
        if (input == null) return null;
        char[] chars = input.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char) (chars[i] ^ key);
        }
        return new String(chars);
    }

    /* ============================================================
     * 3) 本地存储保险库 —— 包裹 SharedPreferences 里的卡密/到期/配置缓存。
     *    滚动 XOR + URL-safe Base64：prefs dump 出来是乱码，且非标准。
     * ============================================================ */

    static String vaultEncode(String plain) {
        if (plain == null) return "";
        byte[] b = plain.getBytes(StandardCharsets.UTF_8);
        for (int i = 0; i < b.length; i++) {
            int k = (0x3D + (i * 0x11)) & 0xFF;
            b[i] = (byte) ((b[i] ^ k) & 0xFF);
        }
        return Base64.encodeToString(b, Base64.NO_WRAP | Base64.URL_SAFE);
    }

    static String vaultDecode(String stored) {
        if (stored == null || stored.isEmpty()) return "";
        try {
            byte[] b = Base64.decode(stored, Base64.NO_WRAP | Base64.URL_SAFE);
            for (int i = 0; i < b.length; i++) {
                int k = (0x3D + (i * 0x11)) & 0xFF;
                b[i] = (byte) ((b[i] ^ k) & 0xFF);
            }
            return new String(b, StandardCharsets.UTF_8);
        } catch (Exception e) {
            return "";
        }
    }

    /* ============================================================
     * 4) 分层 DES（沿用原有 timess/godtimes/helols/helolss/shopsg）
     *    保留作为字符串保险库的兜底变换，维持工程整体的非标准熵。
     * ============================================================ */

    static String desEnc(String str, String key) {
        try {
            DESKeySpec desKey = new DESKeySpec(key.getBytes());
            SecretKeyFactory factory = SecretKeyFactory.getInstance("DES");
            SecretKey secure = factory.generateSecret(desKey);
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.ENCRYPT_MODE, secure);
            return Base64.encodeToString(cipher.doFinal(str.getBytes()), Base64.NO_WRAP);
        } catch (Exception e) {
            return "";
        }
    }

    static String desDec(String buff, String key) {
        try {
            DESKeySpec desKey = new DESKeySpec(key.getBytes());
            SecretKeyFactory factory = SecretKeyFactory.getInstance("DES");
            SecretKey secure = factory.generateSecret(desKey);
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.DECRYPT_MODE, secure);
            return new String(cipher.doFinal(Base64.decode(buff, Base64.NO_WRAP)));
        } catch (Exception e) {
            return "";
        }
    }
}
