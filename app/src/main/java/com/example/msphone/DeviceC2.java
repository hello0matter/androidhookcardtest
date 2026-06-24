package com.example.msphone;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 设备 C2 通道：对接 card_server 的 /device/register | /device/heartbeat | /device/ack。
 *
 * 启动后注册本机，按服务端下发的 poll_interval 周期心跳，拉取并执行 pending_commands
 * （self_destruct / message / kick / update_config），执行后 ack。自包含线程，不依赖悬浮窗服务。
 */
final class DeviceC2 {

    private static final Gson GSON = new Gson();
    private static volatile boolean running = false;
    private static volatile int pollSeconds = 60;
    private static volatile boolean c2Allowed = true;
    private static volatile boolean selfDestructAllowed = true;

    private DeviceC2() {}

    static synchronized void start(final Context context) {
        if (running) return;
        running = true;
        final Context ctx = context.getApplicationContext();
        Thread t = new Thread(() -> loop(ctx), "c2");
        t.setDaemon(true);
        t.start();
    }

    static void stop() { running = false; }

    private static void loop(Context ctx) {
        // 先注册
        handle(ctx, post(ctx, Vault.urlRegister(), baseFields(ctx)));
        while (running) {
            try {
                TimeUnit.SECONDS.sleep(Math.max(5, pollSeconds));
            } catch (InterruptedException e) {
                return;
            }
            if (!running) return;
            handle(ctx, post(ctx, Vault.urlHeartbeat(), baseFields(ctx)));
        }
    }

    private static Map<String, String> baseFields(Context ctx) {
        Map<String, String> f = new HashMap<>();
        f.put("device_id", FileUtils.getDeviceIdentifier(ctx));
        f.put("software_type", ctx.getPackageName());
        f.put("software_version", versionName(ctx));
        f.put("os", "android");
        f.put("name", Build.MODEL);
        f.put("model", Build.MODEL);
        f.put("manufacturer", Build.MANUFACTURER);
        f.put("sdk", Integer.toString(Build.VERSION.SDK_INT));
        f.put("os_version", Build.VERSION.RELEASE);
        try { f.put("arch", Build.SUPPORTED_ABIS[0]); } catch (Throwable ignored) {}
        String kami = Store.getKami(ctx);
        if (kami != null && !kami.isEmpty()) f.put("card", kami);
        return f;
    }

    private static String post(Context ctx, String url, Map<String, String> fields) {
        try {
            return httphelp.postForm(url, fields).get(12, TimeUnit.SECONDS);
        } catch (Throwable t) {
            return null;
        }
    }

    private static void handle(Context ctx, String resp) {
        if (resp == null) return;
        try {
            JsonObject root = JsonParser.parseString(resp).getAsJsonObject();
            if (!root.has("data") || !root.get("data").isJsonObject()) return;
            JsonObject data = root.getAsJsonObject("data");

            // 应用配置（poll_interval / enable_self_destruct）
            if (data.has("config") && data.get("config").isJsonObject()) {
                RemoteConfig cfg = GSON.fromJson(data.get("config"), RemoteConfig.class);
                if (cfg != null) {
                    pollSeconds = cfg.pollIntervalSeconds();
                    c2Allowed = cfg.c2Enabled();
                    selfDestructAllowed = cfg.selfDestructEnabled();
                }
            }

            // 执行命令
            if (data.has("pending_commands") && data.get("pending_commands").isJsonArray()) {
                JsonArray cmds = data.getAsJsonArray("pending_commands");
                List<String> doneIds = new ArrayList<>();
                boolean destruct = false;
                boolean blocked = !c2Allowed;
                for (JsonElement el : cmds) {
                    if (!el.isJsonObject()) continue;
                    JsonObject c = el.getAsJsonObject();
                    String id = optString(c, "id");
                    String type = optString(c, "type");
                    JsonObject payload = c.has("payload") && c.get("payload").isJsonObject()
                            ? c.getAsJsonObject("payload") : new JsonObject();
                    if (id.isEmpty()) continue;
                    if (blocked) {
                        doneIds.add(id);
                    } else if ("self_destruct".equals(type)) {
                        if (selfDestructAllowed) destruct = true;
                        doneIds.add(id);
                    } else {
                        execute(ctx, type, payload);
                        doneIds.add(id);
                    }
                }
                if (!doneIds.isEmpty()) {
                    ack(ctx, doneIds, destruct, blocked);
                }
                if (destruct) {
                    selfDestruct(ctx);
                }
            }
        } catch (Throwable ignored) {}
    }

    private static void execute(Context ctx, String type, JsonObject payload) {
        if ("message".equals(type)) {
            final String text = optString(payload, "text");
            if (!text.isEmpty()) {
                new Handler(Looper.getMainLooper()).post(() ->
                        Toast.makeText(ctx, text, Toast.LENGTH_LONG).show());
            }
        } else if ("kick".equals(type)) {
            Store.clearLicense(ctx);
            running = false;
            exitApp();
        } else if ("update_config".equals(type)) {
            if (payload.has("config") && payload.get("config").isJsonObject()) {
                RemoteConfig cfg = GSON.fromJson(payload.get("config"), RemoteConfig.class);
                if (cfg != null) {
                    pollSeconds = cfg.pollIntervalSeconds();
                    c2Allowed = cfg.c2Enabled();
                    selfDestructAllowed = cfg.selfDestructEnabled();
                }
            }
        }
    }

    private static void ack(Context ctx, List<String> ids, boolean destruct, boolean blocked) {
        Map<String, String> f = new HashMap<>();
        f.put("device_id", FileUtils.getDeviceIdentifier(ctx));
        f.put("software_type", ctx.getPackageName());
        f.put("command_ids", android.text.TextUtils.join(",", ids));
        if (destruct) {
            f.put("result", "self_destructed");
        } else if (blocked) {
            f.put("result", "blocked_by_config");
        } else {
            f.put("result", "ok");
        }
        post(ctx, Vault.urlAck(), f);
    }

    private static void selfDestruct(Context ctx) {
        Store.clearLicense(ctx);
        running = false;
        try {
            RootUtils.executeAsRoot("pm uninstall " + ctx.getPackageName());
        } catch (Throwable ignored) {}
        exitApp();
    }

    private static void exitApp() {
        new Handler(Looper.getMainLooper()).post(() -> {
            try { android.os.Process.killProcess(android.os.Process.myPid()); } catch (Throwable ignored) {}
            System.exit(0);
        });
    }

    private static String versionName(Context ctx) {
        try {
            return ctx.getPackageManager().getPackageInfo(ctx.getPackageName(), 0).versionName;
        } catch (Throwable t) {
            return "";
        }
    }

    private static String optString(JsonObject o, String k) {
        return o.has(k) && !o.get(k).isJsonNull() ? o.get(k).getAsString() : "";
    }
}
