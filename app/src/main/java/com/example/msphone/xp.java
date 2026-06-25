package com.example.msphone;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;

public class xp implements IXposedHookLoadPackage {

    private static final String TARGET_PKG = "com.yunjian.yygame";
    private static final String APP_ACT    = "org.cocos2dx.lua.AppActivity";

    private static final int MAIN_GAME   = 200;
    private static final int SUB_DEAL    = 101;
    private static final int SUB_STATUS  = 268;
    private static final int DEAL_SIZE   = 13;
    private static final int STATUS_SIZE = 268;
    private static final int HEAD        = 6;

    private static volatile Context  sCtx      = null;
    private static volatile boolean  sLicensed = false;
    private static volatile int      sSelf     = -1;
    private static HszOverlay        sOverlay  = null;

    @Override
    public void handleLoadPackage(final LoadPackageParam lpparam) throws Throwable {
        if (!TARGET_PKG.equals(lpparam.packageName)) return;
        XposedBridge.log("[HSZ] inject " + lpparam.processName);

        try {
            XposedHelpers.findAndHookMethod(Application.class, "onCreate", new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam p) throws Throwable {
                    try {
                        sCtx = (Context) p.thisObject;
                        if (!isMainProcess(sCtx)) {
                            XposedBridge.log("[HSZ] skip non-main");
                            return;
                        }
                        DeviceC2.start(sCtx);
                        XposedBridge.log("[HSZ] c2 started");
                    } catch (Throwable t) {
                        XposedBridge.log("[HSZ] c2 err: " + t.getMessage());
                    }
                }
            });

            hookActivity(lpparam.classLoader);
            hookSocketRead(lpparam.classLoader);
            hookLuaBridge(lpparam.classLoader);
        } catch (Throwable t) {
            XposedBridge.log("[HSZ] init err: " + t.getMessage());
        }
    }

    private static void hookActivity(ClassLoader cl) {
        try {
            XposedHelpers.findAndHookMethod(APP_ACT, cl, "onCreate", Bundle.class, new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam p) throws Throwable {
                    try {
                        final Activity act = (Activity) p.thisObject;
                        new Handler(Looper.getMainLooper()).postDelayed(() -> {
                            try {
                                sOverlay = new HszOverlay(act.getApplicationContext());
                                if (HszStore.isToushiOn(act)) sOverlay.show();
                            } catch (Throwable ignored) {}
                        }, 1500);
                        new Thread(() -> doLicenseFlow(act), "hsz-lic").start();
                    } catch (Throwable t) {
                        XposedBridge.log("[HSZ] onCreate err: " + t.getMessage());
                    }
                }
            });
        } catch (Throwable t) {
            XposedBridge.log("[HSZ] hook onCreate fail: " + t.getMessage());
        }

        try {
            XposedHelpers.findAndHookMethod(APP_ACT, cl, "onResume", new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam p) throws Throwable {
                    try {
                        if (sOverlay != null && HszStore.isToushiOn((Context) p.thisObject))
                            sOverlay.show();
                    } catch (Throwable ignored) {}
                }
            });
        } catch (Throwable t) {
            XposedBridge.log("[HSZ] hook onResume fail: " + t.getMessage());
        }

        try {
            XposedHelpers.findAndHookMethod(APP_ACT, cl, "onDestroy", new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam p) throws Throwable {
                    try {
                        if (sOverlay != null) { sOverlay.dismiss(); sOverlay = null; }
                    } catch (Throwable ignored) {}
                }
            });
        } catch (Throwable t) {
            XposedBridge.log("[HSZ] hook onDestroy fail: " + t.getMessage());
        }
    }

    private static void doLicenseFlow(final Activity act) {
        try {
            if (CardGate.licensed(act)) {
                sLicensed = true;
                maybeShowControl(act);
                return;
            }
            new Handler(Looper.getMainLooper()).post(() -> {
                try {
                    Intent i = new Intent(act, CardGateActivity.class);
                    i.putExtra(CardGateActivity.EXTRA_LOCK, true);
                    act.startActivity(i);
                } catch (Throwable ignored) {}
            });
            for (int i = 0; i < 120; i++) {
                try { Thread.sleep(1000); } catch (InterruptedException ignored) {}
                if (CardGate.licensed(act)) {
                    sLicensed = true;
                    maybeShowControl(act);
                    return;
                }
            }
            XposedBridge.log("[HSZ] license timeout");
        } catch (Throwable t) {
            XposedBridge.log("[HSZ] license err: " + t.getMessage());
        }
    }

    private static void maybeShowControl(Activity act) {
        try {
            if (!HszControlDialog.shouldShow(act)) return;
            new Handler(Looper.getMainLooper()).post(() ->
                HszControlDialog.show(act, on -> {
                    try {
                        if (sOverlay == null) return;
                        if (on) sOverlay.show();
                        else    sOverlay.dismiss();
                    } catch (Throwable ignored) {}
                })
            );
        } catch (Throwable t) {
            XposedBridge.log("[HSZ] ctrl err: " + t.getMessage());
        }
    }

    private static void hookSocketRead(ClassLoader cl) {
        try {
            XposedHelpers.findAndHookMethod(
                    "java.net.SocketInputStream", cl,
                    "read", byte[].class, int.class, int.class,
                    new XC_MethodHook() {
                        @Override
                        protected void afterHookedMethod(MethodHookParam p) throws Throwable {
                            try {
                                int n = p.getResult() instanceof Integer ? (int) p.getResult() : 0;
                                if (n <= 0) return;
                                byte[] buf = (byte[]) p.args[0];
                                int off = p.args[1] instanceof Integer ? (int) p.args[1] : 0;
                                byte[] copy = new byte[n];
                                System.arraycopy(buf, off, copy, 0, n);
                                parsePacket(copy, n);
                            } catch (Throwable ignored) {}
                        }
                    });
        } catch (Throwable e) {
            XposedBridge.log("[HSZ] sock hook fail: " + e.getMessage());
        }
    }

    private static void hookLuaBridge(ClassLoader cl) {
        String[] candidates = {
            "com.tencent.tnet.TNetCallback",
            "com.yj.sdk.NetCallback",
            "com.yunjian.sdk.NetHelper",
            "com.yj.tnet.TNetManager"
        };
        for (String cls : candidates) {
            try {
                Class<?> c = XposedHelpers.findClass(cls, cl);
                for (Method m : c.getDeclaredMethods()) {
                    String mn = m.getName().toLowerCase();
                    if ((mn.contains("recv") || mn.contains("receive") || mn.contains("ondata"))
                            && m.getParameterCount() >= 1) {
                        XposedBridge.hookMethod(m, new XC_MethodHook() {
                            @Override
                            protected void afterHookedMethod(MethodHookParam p) {
                                try {
                                    for (Object arg : p.args) {
                                        if (arg instanceof byte[]) {
                                            parsePacket((byte[]) arg, ((byte[]) arg).length);
                                            break;
                                        }
                                    }
                                } catch (Throwable ignored) {}
                            }
                        });
                    }
                }
            } catch (Throwable ignored) {}
        }
    }

    private static void parsePacket(byte[] raw, int length) {
        try {
            if (!sLicensed || raw == null || length < HEAD) return;
            if (sCtx == null || !HszStore.isToushiOn(sCtx)) return;

            int pos = 0;
            while (pos + HEAD <= length) {
                ByteBuffer buf = ByteBuffer.wrap(raw, pos, length - pos)
                        .order(ByteOrder.LITTLE_ENDIAN);
                int mainId   = buf.getShort() & 0xFFFF;
                int subId    = buf.getShort() & 0xFFFF;
                int dataSize = buf.getShort() & 0xFFFF;

                if (mainId != MAIN_GAME) { pos++; continue; }

                int frameEnd = pos + HEAD + dataSize;
                if (frameEnd > length) break;

                byte[] body = new byte[dataSize];
                System.arraycopy(raw, pos + HEAD, body, 0, dataSize);

                if (subId == SUB_DEAL && dataSize == DEAL_SIZE) {
                    int[][] cards = HszCardDecoder.parseDealPacket(body);
                    if (cards != null) onCards(cards, "deal");
                }
                else if (subId == SUB_STATUS && dataSize == STATUS_SIZE) {
                    int[][] cards = HszCardDecoder.parseStatusPlayCards(body);
                    if (cards != null) onCards(cards, "sync");
                }

                pos = frameEnd;
            }
        } catch (Throwable ignored) {}
    }

    private static void onCards(int[][] cards, String src) {
        try {
            XposedBridge.log("[HSZ][" + src + "] " + HszCardDecoder.formatAll(cards, sSelf));
            Handler h = new Handler(Looper.getMainLooper());
            h.post(() -> {
                try {
                    if (sOverlay != null) sOverlay.updateCards(cards, sSelf);
                } catch (Throwable ignored) {}
            });
        } catch (Throwable ignored) {}
    }

    public static boolean setToushiRemote(boolean on) {
        try {
            HszStore.setToushi(sCtx, on);
            if (sOverlay != null) {
                if (on) sOverlay.show();
                else    sOverlay.dismiss();
            }
            return true;
        } catch (Throwable t) {
            return false;
        }
    }

    public static boolean isToushiOn() {
        try {
            return sCtx != null && HszStore.isToushiOn(sCtx);
        } catch (Throwable t) {
            return false;
        }
    }

    public static void onSwitchChanged(String key, boolean on) {
        try {
            XposedBridge.log("[HSZ] sw[" + key + "]=" + on);
            if ("toushi".equals(key)) {
                HszStore.setToushi(sCtx, on);
                if (sOverlay != null) {
                    if (on) sOverlay.show();
                    else    sOverlay.dismiss();
                }
            }
        } catch (Throwable ignored) {}
    }

    private static boolean isMainProcess(Context ctx) {
        try {
            int pid = android.os.Process.myPid();
            ActivityManager am = (ActivityManager) ctx.getSystemService(Context.ACTIVITY_SERVICE);
            if (am == null) return true;
            for (ActivityManager.RunningAppProcessInfo info : am.getRunningAppProcesses()) {
                if (info.pid == pid) {
                    return TARGET_PKG.equals(info.processName);
                }
            }
        } catch (Throwable ignored) {}
        return true;
    }
}
