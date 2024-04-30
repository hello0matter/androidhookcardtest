package com.zy.devicelibrary.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import w2.c;

/* loaded from: classes.dex */
public class BatteryBroadcastReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if ("android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
            intent.getIntExtra("status", 1);
            intent.getIntExtra("health", 1);
            intent.getIntExtra("plugged", 0);
            intent.getIntExtra("level", 0);
            intent.getIntExtra("temperature", 0);
            int i4 = c.f7062a;
            Settings.System.getInt(com.google.common.collect.c.o0().getContentResolver(), "screen_brightness", 255);
        }
    }
}