package com.example.msphone;

import android.content.Context;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.UUID;

public class FileUtils {

    private static final String DEVICE_ID_FILENAME = "device_identifier.txt";

    // World-readable path created by module app (root).
    // Both module process and game process read from here so they share the same device_id.
    static final String SHARED_ID_PATH = "/data/local/tmp/.hsz_devid";

    // Target game package — used for cross-process sync
    private static final String GAME_PKG = "com.yunjian.yygame";

    // In-process cache — valid for the lifetime of this process
    private static volatile String sCache = null;

    public static String getDeviceIdentifier(Context context) {
        if (sCache != null) return sCache;
        synchronized (FileUtils.class) {
            if (sCache != null) return sCache;
            sCache = resolve(context);
        }
        return sCache;
    }

    private static String resolve(Context context) {
        // 1. Shared cross-process path (world-readable, set up by module app via root)
        String id = readFile(SHARED_ID_PATH);
        if (valid(id)) return id;

        // 2. Own app's external files dir
        File dir = context.getExternalFilesDir(null);
        if (dir != null) {
            if (!dir.exists()) dir.mkdirs();
            id = readFile(new File(dir, DEVICE_ID_FILENAME).getAbsolutePath());
            if (valid(id)) {
                writeShared(id);   // promote to shared path so other process can see it
                return id;
            }
        }

        // 3. Generate a new UUID, persist it
        id = UUID.randomUUID().toString();
        if (dir != null) writeToFile(new File(dir, DEVICE_ID_FILENAME).getAbsolutePath(), id);
        writeShared(id);
        return id;
    }

    /**
     * Called once by the module app (which has root) on startup.
     * Ensures both the module app and the game use the same device_id.
     */
    public static void syncSharedId(Context context) {
        // If shared path already valid, nothing to do
        if (valid(readFile(SHARED_ID_PATH))) return;

        // Try to read the game's existing device_id via root (game may have run first)
        try {
            String gameId = RootUtils.execAsRootWithOutput(
                "cat '/sdcard/Android/data/" + GAME_PKG + "/files/" + DEVICE_ID_FILENAME + "' 2>/dev/null"
            ).trim();
            if (valid(gameId)) {
                // Adopt game's device_id so we're consistent
                writeShared(gameId);
                sCache = gameId;
                // Also write to our own external files dir so our context path is consistent
                File dir = context.getExternalFilesDir(null);
                if (dir != null) {
                    if (!dir.exists()) dir.mkdirs();
                    writeToFile(new File(dir, DEVICE_ID_FILENAME).getAbsolutePath(), gameId);
                }
                return;
            }
        } catch (Throwable ignored) {}

        // No game device_id yet — establish ours and push it to the game's dir
        String ourId = getDeviceIdentifier(context);
        writeShared(ourId);
        try {
            RootUtils.executeAsRoot(
                "mkdir -p '/sdcard/Android/data/" + GAME_PKG + "/files/'",
                "echo '" + sanitize(ourId) + "' > '/sdcard/Android/data/" + GAME_PKG + "/files/" + DEVICE_ID_FILENAME + "'",
                "chmod 644 '/sdcard/Android/data/" + GAME_PKG + "/files/" + DEVICE_ID_FILENAME + "'"
            );
        } catch (Throwable ignored) {}
    }

    // ---- helpers ----

    private static boolean valid(String s) {
        return s != null && !s.trim().isEmpty();
    }

    static String readFile(String path) {
        try (BufferedReader r = new BufferedReader(new InputStreamReader(new FileInputStream(path)))) {
            return r.readLine();
        } catch (IOException e) {
            return null;
        }
    }

    private static void writeToFile(String path, String content) {
        try (OutputStreamWriter w = new OutputStreamWriter(new FileOutputStream(path))) {
            w.write(content);
        } catch (IOException ignored) {}
    }

    private static void writeShared(String id) {
        if (!valid(id)) return;
        // Try direct write + setReadable (works if process already has access)
        try {
            File f = new File(SHARED_ID_PATH);
            writeToFile(SHARED_ID_PATH, id);
            f.setReadable(true, false);
            return;
        } catch (Throwable ignored) {}
        // Fall back to root (module app always has root)
        try {
            RootUtils.executeAsRoot(
                "echo '" + sanitize(id) + "' > " + SHARED_ID_PATH,
                "chmod 644 " + SHARED_ID_PATH
            );
        } catch (Throwable ignored) {}
    }

    private static String sanitize(String s) {
        // Strip shell-dangerous characters from a UUID (which should only be hex + hyphens)
        return s.replaceAll("[^a-zA-Z0-9\\-]", "");
    }
}
