package com.example.msphone;

import android.content.Context;
import android.os.Build;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * 启动期安全策略评估。各检测项仅在远程配置对应 ban_* 开关打开时才「拦截」，
 * 默认全关 → 不误杀，由后台按需开启。返回非 null 表示违规原因（调用方据此锁定/退出）。
 *
 * 反调试/反注入（Frida、ptrace）归入 ban_Xposed 这一族「instrumentation」开关下强制。
 */
final class Guard {

    private Guard() {}

    static String evaluate(Context ctx, RemoteConfig cfg) {
        if (cfg == null) return null; // 离线宽限，由调用方决定是否放行

        if (cfg.banRoot && isRooted()) return "root";

        if (cfg.banXposed) {
            if (isXposedPresent()) return "xposed";
            int ad = Vault.antiDebug();
            if ((ad & 1) != 0) return "debugger";
            if ((ad & 2) != 0) return "frida";
        }

        if (cfg.banEmulator && isEmulator()) return "emulator";

        if ((cfg.banVirtualApp || cfg.banDualApp) && isVirtualApp(ctx)) return "virtualapp";

        return null;
    }

    static boolean isRooted() {
        String[] paths = {
                "/system/bin/su", "/system/xbin/su", "/sbin/su", "/su/bin/su",
                "/system/app/Superuser.apk", "/data/local/xbin/su", "/data/local/bin/su",
                "/system/sd/xbin/su", "/data/local/su", "/system/bin/failsafe/su"
        };
        for (String p : paths) {
            if (new File(p).exists()) return true;
        }
        String tags = Build.TAGS;
        if (tags != null && tags.contains("test-keys")) return true;
        try {
            Process p = Runtime.getRuntime().exec(new String[]{"which", "su"});
            BufferedReader r = new BufferedReader(new java.io.InputStreamReader(p.getInputStream()));
            boolean found = r.readLine() != null;
            r.close();
            if (found) return true;
        } catch (Throwable ignored) {}
        return false;
    }

    static boolean isXposedPresent() {
        try {
            ClassLoader cl = Guard.class.getClassLoader();
            if (cl != null) {
                Class.forName("de.robv.android.xposed.XposedBridge", false, cl);
                return true;
            }
        } catch (Throwable ignored) {}
        // 扫描自身 maps，看 hook 框架是否注入本进程
        try (BufferedReader r = new BufferedReader(new FileReader("/proc/self/maps"))) {
            String line;
            while ((line = r.readLine()) != null) {
                if (line.contains("XposedBridge") || line.contains("lspd")
                        || line.contains("liblsp") || line.contains("edxp")
                        || line.contains("riru") || line.contains("zygisk")) {
                    return true;
                }
            }
        } catch (Throwable ignored) {}
        return false;
    }

    static boolean isEmulator() {
        String fp = nz(Build.FINGERPRINT);
        String model = nz(Build.MODEL);
        String product = nz(Build.PRODUCT);
        String manufacturer = nz(Build.MANUFACTURER);
        String hardware = nz(Build.HARDWARE);
        String brand = nz(Build.BRAND);
        if (fp.startsWith("generic") || fp.startsWith("unknown") || fp.contains("vbox") || fp.contains("test-keys")) return true;
        if (model.contains("google_sdk") || model.contains("Emulator") || model.contains("Android SDK built for")) return true;
        if (manufacturer.contains("Genymotion")) return true;
        if (hardware.contains("goldfish") || hardware.contains("ranchu") || hardware.contains("vbox") || hardware.contains("ttVM")) return true;
        if (product.contains("sdk") || product.contains("emulator") || product.contains("simulator")) return true;
        if (brand.startsWith("generic") && Build.DEVICE.startsWith("generic")) return true;
        return new File("/dev/socket/qemud").exists() || new File("/dev/qemu_pipe").exists();
    }

    static boolean isVirtualApp(Context ctx) {
        try {
            String dataDir = ctx.getApplicationInfo().dataDir;
            String pkg = ctx.getPackageName();
            // 正常路径形如 /data/data/<pkg> 或 /data/user/0/<pkg>
            // 虚拟/双开框架常把目录套在自己的私有目录下
            if (dataDir != null && !dataDir.contains("/" + pkg)) return true;
            if (dataDir != null) {
                int idx = dataDir.indexOf("/data/data/");
                if (idx >= 0) {
                    String after = dataDir.substring(idx + "/data/data/".length());
                    // 形如 hostpkg/virtual/0/<pkg>
                    if (after.contains("/") && !after.startsWith(pkg)) return true;
                }
            }
        } catch (Throwable ignored) {}
        return false;
    }

    private static String nz(String s) { return s == null ? "" : s; }
}
