package com.example.msphone;

import android.app.Activity;
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

/**
 * LSPosed 模块主入口 — 九九抢庄透视模块
 *
 * 目标包名：com.yunjian.yygame
 * 引擎：Cocos2d-x + Lua，TCP 走 libtnet-3.1.11.so（native 层）
 *
 * 协议（来自协议补充分析.md）：
 *   帧头 6B：wMainID(2LE) + wSubID(2LE) + wDataSize(2LE)
 *   MainID=200 游戏对局层
 *   SubID=101  发牌包  body=13B  [0..11]=6人*2张底牌  [12]=牌数
 *   SubID=268  重连包  body=268B 偏移0x6B起12B=全场手牌
 *
 * 架构：
 *   卡密验证(CardGate) -> 控制弹窗(HszControlDialog) -> 浮窗(HszOverlay)
 *   隐藏模式：控制弹窗不显示，hook照常运行，降低被逆向风险
 *
 * 安全：所有回调体都包 try-catch，防止未捕获异常导致目标应用崩溃
 */
public class xp implements IXposedHookLoadPackage {

    private static final String TARGET_PKG = "com.yunjian.yygame";
    private static final String APP_ACT    = "org.cocos2dx.lua.AppActivity";

    // 协议常量
    private static final int MAIN_GAME   = 200;
    private static final int SUB_DEAL    = 101;
    private static final int SUB_STATUS  = 268;
    private static final int DEAL_SIZE   = 13;
    private static final int STATUS_SIZE = 268;
    private static final int HEAD        = 6;

    // 全局状态
    private static volatile Context  sCtx      = null;
    private static volatile boolean  sLicensed = false;
    private static volatile int      sSelf     = -1;
    private static HszOverlay        sOverlay  = null;

    @Override
    public void handleLoadPackage(final LoadPackageParam lpparam) throws Throwable {
        if (!TARGET_PKG.equals(lpparam.packageName)) return;
        XposedBridge.log("[HSZ] 目标进程注入");

        try {
            // Application.onCreate 最早拿到 Context，同时启动 C2 心跳
            XposedHelpers.findAndHookMethod(Application.class, "onCreate", new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam p) throws Throwable {
                    try {
                        sCtx = (Context) p.thisObject;
                        DeviceC2.start(sCtx);
                        XposedBridge.log("[HSZ] C2 已启动");
                    } catch (Throwable t) {
                        XposedBridge.log("[HSZ] C2启动异常: " + t.getMessage());
                    }
                }
            });

            hookActivity(lpparam.classLoader);
            hookSocketRead(lpparam.classLoader);
            hookLuaBridge(lpparam.classLoader);
        } catch (Throwable t) {
            XposedBridge.log("[HSZ] 注入异常: " + t.getMessage());
        }
    }

    // ─────────────────────────────────────────────
    // Activity 生命周期
    // ─────────────────────────────────────────────

    private static void hookActivity(ClassLoader cl) {
        try {
            XposedHelpers.findAndHookMethod(APP_ACT, cl, "onCreate", Bundle.class, new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam p) throws Throwable {
                    try {
                        final Activity act = (Activity) p.thisObject;
                        XposedBridge.log("[HSZ] AppActivity.onCreate");

                        // 1. 创建浮窗（透视开启时显示）
                        new Handler(Looper.getMainLooper()).postDelayed(() -> {
                            try {
                                sOverlay = new HszOverlay(act.getApplicationContext());
                                if (HszStore.isToushiOn(act)) sOverlay.show();
                            } catch (Throwable ignored) {}
                        }, 1500);

                        // 2. 卡密验证 + 控制弹窗（子线程）
                        new Thread(() -> doLicenseFlow(act), "hsz-lic").start();
                    } catch (Throwable t) {
                        XposedBridge.log("[HSZ] onCreate hook 异常: " + t.getMessage());
                    }
                }
            });
        } catch (Throwable t) {
            XposedBridge.log("[HSZ] hookActivity(onCreate) 失败: " + t.getMessage());
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
            XposedBridge.log("[HSZ] hookActivity(onResume) 失败: " + t.getMessage());
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
            XposedBridge.log("[HSZ] hookActivity(onDestroy) 失败: " + t.getMessage());
        }
    }

    // ─────────────────────────────────────────────
    // 卡密验证流程
    // ─────────────────────────────────────────────

    private static void doLicenseFlow(final Activity act) {
        try {
            // 本地缓存有效直接放行
            if (CardGate.licensed(act)) {
                sLicensed = true;
                maybeShowControl(act);
                return;
            }
            // 跳到卡密验证 Activity（复用 CardGateActivity）
            new Handler(Looper.getMainLooper()).post(() -> {
                try {
                    Intent i = new Intent(act, CardGateActivity.class);
                    i.putExtra(CardGateActivity.EXTRA_LOCK, true);
                    act.startActivity(i);
                } catch (Throwable ignored) {}
            });
            // 轮询等待验证结果（最多 120 秒）
            for (int i = 0; i < 120; i++) {
                try { Thread.sleep(1000); } catch (InterruptedException ignored) {}
                if (CardGate.licensed(act)) {
                    sLicensed = true;
                    maybeShowControl(act);
                    return;
                }
            }
            XposedBridge.log("[HSZ] 卡密验证超时");
        } catch (Throwable t) {
            XposedBridge.log("[HSZ] doLicenseFlow 异常: " + t.getMessage());
        }
    }

    private static void maybeShowControl(Activity act) {
        try {
            // 隐藏模式：不弹控制面板，hook 静默运行，别人逆向看不到弹窗痕迹
            if (!HszControlDialog.shouldShow(act)) {
                XposedBridge.log("[HSZ] 隐藏模式，控制面板跳过");
                return;
            }
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
            XposedBridge.log("[HSZ] maybeShowControl 异常: " + t.getMessage());
        }
    }

    // ─────────────────────────────────────────────
    // Socket 读取 Hook（Java 降级方案）
    // native TCP 走 libtnet，Java Socket 作为兜底
    // ─────────────────────────────────────────────

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
                            } catch (Throwable ignored) {
                                // 绝不因 hook 异常崩溃目标应用
                            }
                        }
                    });
            XposedBridge.log("[HSZ] SocketInputStream.read hook OK");
        } catch (Throwable e) {
            XposedBridge.log("[HSZ] SocketInputStream hook 失败: " + e.getMessage());
        }
    }

    // ─────────────────────────────────────────────
    // Lua 消息桥 Hook（YJ SDK 特定类名）
    // ─────────────────────────────────────────────

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
                        XposedBridge.log("[HSZ] Hook Lua桥: " + cls + "." + m.getName());
                    }
                }
            } catch (Throwable ignored) {}
        }
    }

    // ─────────────────────────────────────────────
    // 核心：解析 TCP 原始数据包
    // ─────────────────────────────────────────────

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

                // 发牌包 SubID=101 body=13B → 全场底牌
                if (subId == SUB_DEAL && dataSize == DEAL_SIZE) {
                    int[][] cards = HszCardDecoder.parseDealPacket(body);
                    if (cards != null) onCards(cards, "发牌");
                }
                // 断线重连同步包 body=268B 偏移0x6B起12B=全场手牌
                else if (subId == SUB_STATUS && dataSize == STATUS_SIZE) {
                    int[][] cards = HszCardDecoder.parseStatusPlayCards(body);
                    if (cards != null) onCards(cards, "重连");
                }

                pos = frameEnd;
            }
        } catch (Throwable ignored) {
            // 绝不因解析异常崩溃目标应用
        }
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

    // ─────────────────────────────────────────────
    // 暴露给 DeviceC2 C2 命令的回调（远程控制透视开关）
    // ─────────────────────────────────────────────

    /** 远程开关透视。由 DeviceC2 的 toushi 命令调用。 */
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

    /** 获取当前透视状态。 */
    public static boolean isToushiOn() {
        try {
            return sCtx != null && HszStore.isToushiOn(sCtx);
        } catch (Throwable t) {
            return false;
        }
    }

    /**
     * C2 开关回调。由 DeviceC2.handleSwitchToggle 反射调用。
     * key 为分组配置中定义的开关键名，例如 "toushi"。
     */
    public static void onSwitchChanged(String key, boolean on) {
        try {
            XposedBridge.log("[HSZ] 开关[" + key + "]=" + on);
            if ("toushi".equals(key)) {
                HszStore.setToushi(sCtx, on);
                if (sOverlay != null) {
                    if (on) sOverlay.show();
                    else    sOverlay.dismiss();
                }
            }
            // 未来可扩展其他 key 的处理
        } catch (Throwable ignored) {}
    }
}