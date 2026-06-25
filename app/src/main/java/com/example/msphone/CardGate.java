package com.example.msphone;

import android.content.Context;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 卡密验证闸门（业务逻辑层，UI 见 {@link CardGateActivity}）。
 *
 * 无论 WebView 还是原生弹窗，最终都走这里向 card_server 的 /kami/verify 发起
 * 表单 POST，由服务端按 deviceId 做「一机一卡」绑定，并返回 remaining_seconds。
 * 验证成功后写入本地保险库 {@link Store}。
 */
final class CardGate {

    private CardGate() {}

    static class Result {
        final boolean success;
        final long remainingSeconds;
        final String message;
        Result(boolean s, long r, String m) { success = s; remainingSeconds = r; message = m; }
    }

    /** 同步验证，必须在子线程调用。 */
    static Result verify(Context ctx, String card) {
        if (card == null || card.trim().isEmpty()) {
            return new Result(false, 0, "Please enter a card key");
        }
        card = card.trim();
        try {
            String deviceId = FileUtils.getDeviceIdentifier(ctx);
            Map<String, String> form = new HashMap<>();
            form.put("input", card);
            form.put("card", card);
            form.put("kami", card);
            form.put("deviceId", deviceId);
            form.put("package", ctx.getPackageName());
            form.put("version_shell", Vault.versionShell());

            String resp = httphelp.postForm(Vault.urlVerify(), form).get(12, TimeUnit.SECONDS);
            if (resp == null) return new Result(false, 0, "Network error");

            JsonObject root = JsonParser.parseString(resp).getAsJsonObject();
            int code = root.has("code") && !root.get("code").isJsonNull()
                    ? root.get("code").getAsInt() : -1;
            String message = root.has("message") && !root.get("message").isJsonNull()
                    ? root.get("message").getAsString() : "";
            long remaining = 0;
            if (root.has("data") && root.get("data").isJsonObject()) {
                JsonObject data = root.getAsJsonObject("data");
                if (data.has("remaining_seconds") && !data.get("remaining_seconds").isJsonNull()) {
                    remaining = data.get("remaining_seconds").getAsLong();
                }
            }
            if (code == 0 && (remaining > 0 || remaining == -1)) {
                long secs = remaining > 0 ? remaining : 365L * 24 * 60 * 60;
                Store.setLicense(ctx, card, secs);
                return new Result(true, remaining, message.isEmpty() ? "Verified" : message);
            }
            return new Result(false, remaining, message.isEmpty() ? "Invalid card" : message);
        } catch (Throwable t) {
            return new Result(false, 0, "Network error, retry");
        }
    }

    /** Silent auto-verify using deviceId only (for auto-issue groups). Must run on background thread. */
    static Result autoVerify(Context ctx) {
        // Retry up to 6 times (≈6s total) to wait for C2 registration + auto-issue card creation
        for (int i = 0; i < 6; i++) {
            try {
                if (i > 0) Thread.sleep(1000);
                String deviceId = FileUtils.getDeviceIdentifier(ctx);
                Map<String, String> form = new HashMap<>();
                form.put("deviceId", deviceId);
                form.put("auto", "true");

                String resp = httphelp.postForm(Vault.urlVerify(), form).get(12, TimeUnit.SECONDS);
                if (resp == null) continue;

                JsonObject root = JsonParser.parseString(resp).getAsJsonObject();
                int code = root.has("code") && !root.get("code").isJsonNull()
                        ? root.get("code").getAsInt() : -1;
                if (code != 0) continue; // retry

                String message = root.has("message") && !root.get("message").isJsonNull()
                        ? root.get("message").getAsString() : "";
                long remaining = 0;
                String card = "";
                if (root.has("data") && root.get("data").isJsonObject()) {
                    JsonObject data = root.getAsJsonObject("data");
                    if (data.has("remaining_seconds") && !data.get("remaining_seconds").isJsonNull()) {
                        remaining = data.get("remaining_seconds").getAsLong();
                    }
                    if (data.has("card") && !data.get("card").isJsonNull()) {
                        card = data.get("card").getAsString();
                    }
                }
                if (remaining > 0 || remaining == -1) {
                    if (!card.isEmpty()) {
                        long secs = remaining > 0 ? remaining : 365L * 24 * 60 * 60;
                        Store.setLicense(ctx, card, secs);
                    }
                    return new Result(true, remaining, "ok");
                }
            } catch (Throwable ignored) {}
        }
        return new Result(false, 0, "not bound");
    }

    /** 已验证且未过期则直接放行。 */
    static boolean licensed(Context ctx) {
        return Store.isLicenseValid(ctx);
    }
}
