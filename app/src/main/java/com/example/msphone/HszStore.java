package com.example.msphone;

import android.content.Context;
import android.content.SharedPreferences;

/** hsz 模块开关状态（透视 / 隐藏模式） */
final class HszStore {
    private static final String SP       = "hsz_cfg";
    private static final String K_TOUSHI = "t";
    private static final String K_HIDE   = "h";
    private HszStore() {}
    private static SharedPreferences sp(Context ctx) {
        return ctx.getApplicationContext().getSharedPreferences(SP, Context.MODE_PRIVATE);
    }
    static boolean isToushiOn(Context ctx) { return ctx != null && sp(ctx).getBoolean(K_TOUSHI, true); }
    static void setToushi(Context ctx, boolean on) { sp(ctx).edit().putBoolean(K_TOUSHI, on).apply(); }
    static boolean isHideMode(Context ctx) { return ctx != null && sp(ctx).getBoolean(K_HIDE, false); }
    static void setHideMode(Context ctx, boolean on) { sp(ctx).edit().putBoolean(K_HIDE, on).apply(); }
}