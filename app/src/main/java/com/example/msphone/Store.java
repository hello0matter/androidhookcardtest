package com.example.msphone;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * 本地保险库：所有缓存（卡密、到期时间、绑定标记）都经 {@link Codec} 包裹后落盘，
 * 直接 dump SharedPreferences 看到的是乱码，键名也做了无意义化。
 */
final class Store {

    private static final String SP = "syscache";
    private static final String K_KAMI   = "k";
    private static final String K_EXPIRE = "e";   // 到期 epoch 毫秒
    private static final String K_BOUND  = "b";

    private Store() {}

    private static SharedPreferences sp(Context ctx) {
        return ctx.getSharedPreferences(SP, Context.MODE_PRIVATE);
    }

    static void putString(Context ctx, String key, String value) {
        sp(ctx).edit().putString(key, Codec.vaultEncode(value)).apply();
    }

    static String getString(Context ctx, String key) {
        return Codec.vaultDecode(sp(ctx).getString(key, ""));
    }

    static String getKami(Context ctx) {
        return getString(ctx, K_KAMI);
    }

    /** 验证成功后写入卡密与到期时间。 */
    static void setLicense(Context ctx, String card, long remainingSeconds) {
        long expire = System.currentTimeMillis() + Math.max(0, remainingSeconds) * 1000L;
        SharedPreferences.Editor e = sp(ctx).edit();
        e.putString(K_KAMI, Codec.vaultEncode(card));
        e.putString(K_EXPIRE, Codec.vaultEncode(Long.toString(expire)));
        e.putString(K_BOUND, Codec.vaultEncode("1"));
        e.apply();
    }

    static long expireAt(Context ctx) {
        try {
            String s = getString(ctx, K_EXPIRE);
            return s.isEmpty() ? 0L : Long.parseLong(s);
        } catch (Exception ex) {
            return 0L;
        }
    }

    /** 本地许可是否仍在有效期内。 */
    static boolean isLicenseValid(Context ctx) {
        long exp = expireAt(ctx);
        return exp > 0 && System.currentTimeMillis() < exp;
    }

    static long remainingSeconds(Context ctx) {
        long exp = expireAt(ctx);
        if (exp <= 0) return 0;
        return Math.max(0, (exp - System.currentTimeMillis()) / 1000L);
    }

    /** 自毁/踢出时清空许可。 */
    static void clearLicense(Context ctx) {
        sp(ctx).edit().clear().apply();
    }
}
