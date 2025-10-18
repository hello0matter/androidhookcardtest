// BootCompletedReceiver.java
package com.example.msphone;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;

public class BootCompletedReceiver extends BroadcastReceiver {
    private static final String TAG = "XposedHook_Boot";

    @Override
    public void onReceive(Context context, Intent intent) {
        // 确保收到的确实是开机广播
        if (Intent.ACTION_BOOT_COMPLETED.equals(intent.getAction())) {
//            Log.d(TAG, "检测到手机开机，正在准备推送配置...");

            try {
                // 1. 读取自己App的 SharedPreferences
                SharedPreferences prefs = context.getSharedPreferences("XposedModulePrefs", Context.MODE_PRIVATE);

                // 2. 获取所有需要的配置
                // 【重要】这里的 Key 和数据类型必须和你保存时完全一致
                int progress = prefs.getInt("currentSpeed", 100); // 这是整数进度
                float speed = ((progress * 1.7f) / 170.0f) + 0.3f; // 在这里反算出 float 速度

                int rob_delay_ms = prefs.getInt("rob_delay_ms", 5000);
                int rob_delay_ms_delay = prefs.getInt("rob_delay_ms_delay", 0);
                int test1 = prefs.getInt("test1", 0);
                int test2 = prefs.getInt("test2", 0);
                int test3 = prefs.getInt("test3", 0);
                int cdkValue = prefs.getInt("fdg341", 0);

                // 3. 创建一个新的 Intent 用于推送
                Intent settingsIntent = new Intent("com.example.msphone.SEND_SETTINGS_TO_XPOSED");
                settingsIntent.setFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES); // 必须加，否则模块收不到

                // 4. 把所有配置都放进去
                settingsIntent.putExtra("currentSpeed", speed); // 【注意】这里直接放计算好的 float 速度
                settingsIntent.putExtra("rob_delay_ms", rob_delay_ms);
                settingsIntent.putExtra("rob_delay_ms_delay", rob_delay_ms_delay);
                settingsIntent.putExtra("test1", test1);
                settingsIntent.putExtra("test2", test2);
                settingsIntent.putExtra("test3", test3);
                settingsIntent.putExtra("xsfvs", cdkValue);

                // 5. 发送广播
                context.sendBroadcast(settingsIntent);

//                Log.d(TAG, "配置已通过广播发送 -> Speed: " + speed + ", Delay: " + rob_delay_ms);

            } catch (Exception e) {
//                Log.e(TAG, "开机推送配置时发生错误", e);
            }
        }
    }
}