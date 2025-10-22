package com.example.msphone;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Base64;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class BootCompletedReceiver extends BroadcastReceiver {
    // 【优化】合并 TAG，方便统一查看日志
    private static final String TAG = "BootReceiver_MsPhone";

    // 【优化】将脚本路径定义为常量，避免硬编码错误
    private static final String SCRIPT_TARGET_PATH = "/data/adb/service.d/99-mymonitor.sh";
    private static final String SCRIPT_ASSET_NAME = "monitor_script.sh";

    @Override
    public void onReceive(Context context, Intent intent) {
        if (Intent.ACTION_BOOT_COMPLETED.equals(intent.getAction())) {
//            Log.d(TAG, "检测到手机开机...");

            // 【第一步】检查并部署核心脚本
            checkAndInstallScript(context);

            // 【第二步】推送运行时配置
//            sendSettingsBroadcast(context);
        }
    }

    /**
     * 检查脚本是否存在，如果不存在，则从 assets 中读取并安装。
     * 这是一个幂等操作，可以安全地每次开机都调用。
     * @param context 应用上下文
     */
    private void checkAndInstallScript(Context context) {
        File scriptFile = new File(SCRIPT_TARGET_PATH);

        // 1. 检查文件是否已经存在。如果存在，就没必要重复安装了。
        if (scriptFile.exists()) {
//            Log.d(TAG, "脚本 " + SCRIPT_TARGET_PATH + " 已存在，无需部署。");
            return;
        }

        Log.d(TAG, "脚本不存在，开始从 assets 部署...");

        // 2. 从 assets 读取脚本内容
        String scriptContent = readScriptFromAssets(context, SCRIPT_ASSET_NAME);
        if (scriptContent == null) {
            Log.e(TAG, "从 assets 读取脚本失败，部署中止！");
            return;
        }

        // 3. 执行 Root 命令进行安装
        String encodedScript = Base64.encodeToString(scriptContent.getBytes(), Base64.NO_WRAP);
        String command = "echo '" + encodedScript + "' | base64 -d > " + SCRIPT_TARGET_PATH + " && " +
                "chmod 755 " + SCRIPT_TARGET_PATH;

        boolean success = RootUtils.executeAsRoot(command);
        if (success) {
//            Log.d(TAG, "脚本成功部署到 " + SCRIPT_TARGET_PATH);
        } else {
            String error = RootUtils.getLastError();
//            Log.e(TAG, "脚本部署失败！错误: " + error);
        }
    }

    /**
     * 从 SharedPreferences 读取配置并发送广播给 Xposed 模块。
     * @param context 应用上下文
     */
    private void sendSettingsBroadcast(Context context) {
        Log.d(TAG, "正在准备推送配置...");
        try {
            SharedPreferences prefs = context.getSharedPreferences("XposedModulePrefs", Context.MODE_PRIVATE);

            // ... 您原有的读取配置逻辑完全正确，无需修改 ...
            int progress = prefs.getInt("currentSpeed", 100);
            float speed = ((progress * 1.7f) / 170.0f) + 0.3f;
            int rob_delay_ms = prefs.getInt("rob_delay_ms", 5000);
            int rob_delay_ms_delay = prefs.getInt("rob_delay_ms_delay", 0);
            int test1 = prefs.getInt("test1", 0);
            int test2 = prefs.getInt("test2", 0);
            int test3 = prefs.getInt("test3", 0);
            int cdkValue = prefs.getInt("fdg341", 0);

            Intent settingsIntent = new Intent("com.example.msphone.SEND_SETTINGS_TO_XPOSED");
            settingsIntent.setFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);

            settingsIntent.putExtra("currentSpeed", speed);
            settingsIntent.putExtra("rob_delay_ms", rob_delay_ms);
            settingsIntent.putExtra("rob_delay_ms_delay", rob_delay_ms_delay);
            settingsIntent.putExtra("test1", test1);
            settingsIntent.putExtra("test2", test2);
            settingsIntent.putExtra("test3", test3);
            settingsIntent.putExtra("xsfvs", cdkValue);

            context.sendBroadcast(settingsIntent);
            Log.d(TAG, "配置已通过广播成功发送。");

        } catch (Exception e) {
            Log.e(TAG, "开机推送配置时发生错误", e);
        }
    }

    /**
     * 从 assets 目录读取文件内容的辅助方法。
     * @param context  应用上下文
     * @param fileName assets 目录下的文件名
     * @return 文件内容字符串，失败则返回 null
     */
    private String readScriptFromAssets(Context context, String fileName) {
        StringBuilder scriptBuilder = new StringBuilder();
        try (InputStream is = context.getAssets().open(fileName);
             BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            String line;
            while ((line = reader.readLine()) != null) {
                scriptBuilder.append(line).append("\n");
            }
            return scriptBuilder.toString();
        } catch (IOException e) {
            Log.e(TAG, "读取 assets 文件失败: " + fileName, e);
            return null;
        }
    }
}