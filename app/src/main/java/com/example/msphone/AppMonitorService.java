package com.example.msphone;

import android.app.Service;
import android.app.usage.UsageStats;
import android.app.usage.UsageStatsManager;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;

import androidx.annotation.Nullable;

import java.util.List;

public class AppMonitorService extends Service {
    private static final String TARGET_PACKAGE = "com.eastedge.taxidriverforpad"; // 本地云出行的包名
    private Handler handler = new Handler();
    private boolean isRunning = false;



    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (!isRunning) {
            isRunning = true;
            handler.post(monitorRunnable);
        }
        return START_STICKY;
    }

    private Runnable monitorRunnable = new Runnable() {
        @Override
        public void run() {
            if (isAppInForeground(AppMonitorService.this)) {
                // 检测到目标App在前台，启动我们自己的App
                Intent launchIntent = new Intent(AppMonitorService.this, MainActivity.class);
                launchIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(launchIntent);
            }
            // 每2秒检查一次
            handler.postDelayed(this, 5000);
        }
    };

    private boolean isAppInForeground(Context context) {
        UsageStatsManager usm = (UsageStatsManager) context.getSystemService(Context.USAGE_STATS_SERVICE);
        long endTime = System.currentTimeMillis();
        long beginTime = endTime - 1000 * 60; // 检查最近一分钟的记录
        List<UsageStats> stats = usm.queryUsageStats(UsageStatsManager.INTERVAL_DAILY, beginTime, endTime);
        if (stats != null) {
            for (UsageStats usageStats : stats) {
                if (TARGET_PACKAGE.equals(usageStats.getPackageName()) && usageStats.getLastTimeUsed() > beginTime) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(monitorRunnable);
        isRunning = false;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}