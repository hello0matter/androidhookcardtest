package com.example.msphone;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class InstallReceiver extends BroadcastReceiver {

    private static final String TAG = "InstallReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        // 确保接收到的广播是我们关心的
        if (intent == null || intent.getAction() == null) {
            return;
        }

        // 检查广播的动作是否是 "应用包被添加"
        if (intent.getAction().equals(Intent.ACTION_PACKAGE_ADDED) || intent.getAction().equals(Intent.ACTION_PACKAGE_REPLACED)) {
            // 获取被安装应用的包名
            String packageName = intent.getData().getSchemeSpecificPart();

            // 关键一步：判断被安装的是不是我们自己的应用
            if (packageName != null && packageName.equals(context.getPackageName())) {
                Log.d(TAG, "我们的应用刚刚被安装成功了！");

                // 在这里执行你想要的操作！
                // 比如调用你的脚本种植方法
                installMonitorScript(context);
            }
        }
    }
    /**
     * 从App的assets目录读取脚本文件内容，并返回字符串。
     * @param fileName assets目录下的脚本文件名，例如 "monitor_script.sh"
     * @return 脚本内容的字符串，如果读取失败则返回 null。
     */
    private String readScriptFromAssets(String fileName,Context context) {
        StringBuilder scriptBuilder = new StringBuilder();
        try (InputStream is = context.getAssets().open(fileName);
             BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            String line;
            while ((line = reader.readLine()) != null) {
                scriptBuilder.append(line).append("\n");
            }
            return scriptBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
            //Log.e("ReadAssets", "Failed to read script from assets: " + fileName, e);
            return null;
        }
    }
    private void installMonitorScript(Context context) {
        // 从 assets 目录读取脚本内容
        String scriptContent = readScriptFromAssets("monitor_script.sh",context);

        if (scriptContent == null) {
//            Toast.makeText(this, "读取内置脚本失败！", Toast.LENGTH_LONG).show();
            return;
        }

        // 调用我们已经写好的、健壮的脚本安装方法
        installScript(scriptContent, "/data/adb/service.d/99-mymonitor.sh");
    }
    private void installScript(String scriptContent, String targetPath) {
        File scriptFile = new File(targetPath);

        // 1. 检查文件是否已经存在。如果存在，就没必要重复安装了。
//        if (scriptFile.exists()) {
//            return;
//        }
        String encodedScript = Base64.encodeToString(scriptContent.getBytes(), Base64.NO_WRAP);
        String command = "echo '" + encodedScript + "' | base64 -d > " + targetPath + " && " +
                "chmod 755 " + targetPath;

        boolean success = RootUtils.executeAsRoot(command);

        if (success) {
//            Toast.makeText(this, new File(targetPath).getName() + " 部署成功！重启生效。", Toast.LENGTH_LONG).show();
        } else {
            // 【关键】从 RootUtils 获取详细的错误信息并显示
            String error = RootUtils.getLastError();
//            Toast.makeText(this, "部署失败！\n错误: " + error, Toast.LENGTH_LONG).show();
            //Log.e("InstallScript", "Failed to deploy script. Reason: " + error);
        }
    }
}