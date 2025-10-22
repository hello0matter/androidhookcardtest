package com.example.msphone;

import static android.media.tv.TvContract.AUTHORITY;

import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.media.PlaybackParams;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

import dalvik.system.DexFile;
import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;

public class xp implements IXposedHookLoadPackage {
    private static final String TAG = "XposedHook_XP_Dynamic";
    // [修改] 目标包名需要确认
    private static final String TARGET_PACKAGE_NAME = "com.eastedge.taxidriverforpad";

    private float currentSpeed = 1.0f;
    private int cdkValue = 0;
    // 【新增】用于保存秒抢功能状态的变量
    private int instantRobEnabled = 1;
    private long lastVolumeUpClickTime = 0;
    // 【修改】主Hook入口，现在只部署Hook，不直接执行逻辑
    private int rob_delay_ms = 5000; // 默认延迟，会被悬浮窗设置覆盖
    private int rob_delay_ms_delay = 0; // 默认延迟，会被悬浮窗设置覆盖
    private int test1 = 0; // 默认延迟，会被悬浮窗设置覆盖
    private int test2 = 0; // 默认延迟，会被悬浮窗设置覆盖
    private int test3 = 0; // 默认延迟，会被悬浮窗设置覆盖

    private static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/settings");

    /**
     * 【核心逻辑】Hook OrderView 和 OrderViewWithMap
     */
    private void hookOrderView(final LoadPackageParam lpparam) {
        final String[] orderViewClasses = {
                "com.jiuzhou.TaxiDriver.Views.OrderView",
                "com.jiuzhou.TaxiDriver.Views.OrderViewWithMap"
        };
        for (String className : orderViewClasses) {
            hookClassEntryPoints(className, lpparam);
        }
    }


    // 【新增】一个辅助方法，用于Hook指定类的 doinit 和 onNewIntent 方法
    private void hookClassMethods(final String className, final LoadPackageParam lpparam) {
        try {
            // Hook点1: doinit(Intent) for OrderView, 或者 doinit(Intent, Bundle) for OrderViewWithMap
            // Xposed会自动处理参数差异，我们只需要找到名字即可
            XposedHelpers.findAndHookMethod(className, lpparam.classLoader, "doinit", Intent.class, new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    ////Log.d(TAG, "【入口1: doinit】 " + className + " 被触发！");
                    changeButtonToRobMode(param.thisObject, lpparam.packageName);
                }
            });
        } catch (Throwable t) {
            // 捕获OrderView没有 (Intent, Bundle) 版本的doinit时可能发生的错误
            try {
                XposedHelpers.findAndHookMethod(className, lpparam.classLoader, "doinit", Intent.class, Bundle.class, new XC_MethodHook() {
                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        ////Log.d(TAG, "【入口1: doinit with Bundle】 " + className + " 被触发！");
                        changeButtonToRobMode(param.thisObject, lpparam.packageName);
                    }
                });
            } catch (Throwable t2) {
                ////Log.e(TAG, "Hook " + className + " 的 doinit 方法失败: " + t2.getMessage());
            }
        }

        try {
            // Hook点2: onNewIntent(Intent)
            XposedHelpers.findAndHookMethod(className, lpparam.classLoader, "onNewIntent", Intent.class, new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    ////Log.d(TAG, "【入口2: onNewIntent】 " + className + " 被触发！");
                    // onNewIntent 之后UI会立即刷新，所以延迟一小段时间再修改，确保App自身的UI操作已完成
                    new Handler().postDelayed(() -> {
                        changeButtonToRobMode(param.thisObject, lpparam.packageName);
                    }, 100); // 延迟100毫秒
                }
            });
        } catch (Throwable t) {
            ////Log.e(TAG, "Hook " + className + " 的 onNewIntent 方法失败: " + t.getMessage());
        }
    }

    /**
     * 【核心逻辑】为指定的类Hook doinit 和 onNewIntent
     */
    private void hookClassEntryPoints(final String className, final LoadPackageParam lpparam) {
        try {
            Class<?> clazz = XposedHelpers.findClass(className, lpparam.classLoader);
            for (Method method : clazz.getDeclaredMethods()) {
                if (method.getName().equals("doinit") || method.getName().equals("onNewIntent")) {
                    XposedBridge.hookMethod(method, new XC_MethodHook() {
                        @Override
                        protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                            Context context = (Context) param.thisObject;
                            // 【核心修改】在真正执行抢单逻辑前，检查并应用新设置
//                            applyPendingSettings(context);
                            ////Log.d(TAG, "【入口触发】" + className + "." + method.getName() + " 命中！");
                            ////Log.d(TAG, "准备在 " + rob_delay_ms + "ms 后强制修改按钮...");

                            final Object orderViewInstance = param.thisObject;
                            final String packageName = lpparam.packageName;
                            Log.d(TAG, "【 rob_delay_ms_delay】 " + rob_delay_ms_delay + " rob_delay_ms" + rob_delay_ms);
                            if (rob_delay_ms_delay == 0) {
                                // 200秒就是不hook
//                                new Handler(Looper.getMainLooper()).postDelayed(() -> {
//                                    changeButtonToRobMode(orderViewInstance, packageName);
//                                }, rob_delay_ms);
                            } else if (rob_delay_ms_delay == 100000) {
                                // 100秒就是不限制
                                new Handler(Looper.getMainLooper()).postDelayed(() -> {
                                    changeButtonToRobMode(orderViewInstance, packageName);
                                }, rob_delay_ms);
                            } else {
                                // 使用我们可控的延迟来执行修改,防止太快
                                if (rob_delay_ms_delay > rob_delay_ms) {
                                    ////Log.d(TAG, "【快了");

                                    new Handler(Looper.getMainLooper()).postDelayed(() -> {
                                        changeButtonToRobMode(orderViewInstance, packageName);
                                    }, rob_delay_ms_delay);
                                }else{
                                    new Handler(Looper.getMainLooper()).postDelayed(() -> {
                                        changeButtonToRobMode(orderViewInstance, packageName);
                                    }, rob_delay_ms);
                                }

                            }

                        }
                    });
                }
            }
        } catch (Throwable t) {
            ////Log.e(TAG, "Hook " + className + " 失败: ", t);
        }
    }

    /**
     * 统一的按钮修改逻辑（【最关键的修改】已删除防重复的if判断）
     */
    private void changeButtonToRobMode(Object orderViewInstance, String packageName) {
        try {
            Context context = (Context) orderViewInstance;
            Button robBtn = (Button) XposedHelpers.getObjectField(orderViewInstance, "RobTheOrder_Btn");

            // 【关键优化】如果按钮已经是可点击状态，说明我们已经修改过了，或者App自己变了
            // 此时直接返回，避免重复操作导致UI紊乱或消失
//            if (robBtn.isClickable()) {
//                ////Log.d(TAG, "按钮已经是可点击状态，本次跳过修改。");
//                return;
//            }

            ////Log.d(TAG, "开始执行按钮状态修改...");

            RelativeLayout robRL = (RelativeLayout) XposedHelpers.getObjectField(orderViewInstance, "RobTheOrder_RL");

            // 1. 设为可点击
            robRL.setClickable(true);
            robBtn.setClickable(true);

            ViewGroup.LayoutParams layoutParams = robBtn.getLayoutParams();
            float density = context.getResources().getDisplayMetrics().density;
            layoutParams.width = (int) (30.0f * density + 0.5f);
            layoutParams.height = (int) (30.0f * density + 0.5f);
            robBtn.setLayoutParams(layoutParams);

            int pbfDrawableId = context.getResources().getIdentifier("pbf", "drawable", packageName);
            if (pbfDrawableId != 0) {
                robBtn.setBackgroundResource(pbfDrawableId);
                ////Log.d(TAG, "[成功] 按钮已修改为方形可点击状态！");
            } else {
                ////Log.w(TAG, "[警告] 未找到名为 'pbf' 的drawable资源。");
            }

        } catch (Exception e) {
            ////Log.e(TAG, "[错误] 修改按钮状态时发生异常: ", e);
        }
    }

    // 【核心新增】为新的订单界面创建一个新的Hook方法
    private void hookNewTypeOrderView(final LoadPackageParam lpparam) {
        // 假设您通过第一步侦查到，新类名叫 com.jiuzhou.TaxiDriver.Views.AnotherOrderActivity
        final String newClassName = "com.jiuzhou.TaxiDriver.Views.AnotherOrderActivity";
        // 假设您通过第二步侦查到，它的初始化方法是 onCreate
        final String newMethodName = "onCreate";

        try {
            XposedHelpers.findAndHookMethod(
                    newClassName,
                    lpparam.classLoader,
                    newMethodName,
                    android.os.Bundle.class, // onCreate 方法的参数是 Bundle
                    new XC_MethodHook() {
                        @Override
                        protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                            super.afterHookedMethod(param);

                            XposedBridge.log("【新界面】AnotherOrderActivity.onCreate 被Hook了！");

                            if (instantRobEnabled == 1) { // 同样使用全局开关控制
                                XposedBridge.log("【新界面】秒抢开启，开始修改按钮...");

                                Object activityInstance = param.thisObject;
                                Context context = (Context) activityInstance;

                                // 假设您侦查到新的按钮变量名叫 mConfirmButton 和 mConfirmLayout
                                RelativeLayout newRobRL = (RelativeLayout) XposedHelpers.getObjectField(activityInstance, "mConfirmLayout");
                                Button newRobBtn = (Button) XposedHelpers.getObjectField(activityInstance, "mConfirmButton");

                                // 执行和之前完全一样的修改逻辑
                                newRobRL.setClickable(true);
                                newRobBtn.setClickable(true);
                                // ... 修改尺寸和背景的代码 ...
                                // 2. 修改尺寸
                                ViewGroup.LayoutParams layoutParams = newRobBtn.getLayoutParams();
                                float density = context.getResources().getDisplayMetrics().density;
                                layoutParams.width = (int) (30.0f * density + 0.5f);
                                layoutParams.height = (int) (30.0f * density + 0.5f);
                                newRobBtn.setLayoutParams(layoutParams);

                                // 3. 更换背景为方形
                                int pbfDrawableId = context.getResources().getIdentifier("pbf", "drawable", newClassName);
                                if (pbfDrawableId != 0) {
                                    newRobBtn.setBackgroundResource(pbfDrawableId);
                                    ////Log.d(TAG, "[成功] 按钮已修改为方形可点击状态！");
                                } else {
                                    ////Log.w(TAG, "[警告] 未找到名为 'pbf' 的drawable资源。");
                                }
                                XposedBridge.log("【新界面】按钮修改成功！");
                            }
                        }
                    }
            );
        } catch (Throwable t) {
            XposedBridge.log("Hook新界面 " + newClassName + " 失败: " + t.getMessage());
        }
    }

    /**
     * 【核心新增】侦查兵方法：扫描并Hook整个App中所有参数为 (Intent) 的方法
     *
     * @param lpparam LoadPackageParam
     */
    private void spyOnIntentMethods(final LoadPackageParam lpparam) {
        ////Log.d(TAG, "【侦查兵】开始扫描所有 (Intent) 签名的方法...");

        List<String> classNames = getAllClassNames((Context) XposedHelpers.callMethod(XposedHelpers.findClass("android.app.ActivityThread", null), "currentApplication"));

        for (String className : classNames) {
            // 过滤掉一些系统类，减少干扰
            if (className.startsWith("android.") || className.startsWith("java.") || className.startsWith("com.google.") || className.startsWith("androidx.")) {
                continue;
            }

            try {
                Class<?> clazz = XposedHelpers.findClass(className, lpparam.classLoader);

                // 遍历当前类的所有方法
                for (final Method method : clazz.getDeclaredMethods()) {
                    // 关键！我们根据方法的 "签名" 来识别它：只有一个参数，且类型是 Intent
                    if (method.getParameterCount() == 1 && method.getParameterTypes()[0] == Intent.class) {

                        // 找到一个就Hook一个，我们不return，要Hook所有符合条件的
                        XposedBridge.hookMethod(method, new XC_MethodHook() {
                            @Override
                            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                                // 在方法执行前打印，这样可以看到传入的原始参数
                                Intent intent = (Intent) param.args[0];
                                if (intent == null) return;

                                // --- 开始打印详细的上下文信息 ---
                                ////Log.d(TAG, "===================== (Intent) 方法被调用 =====================");
                                ////Log.d(TAG, "【类名】: " + param.method.getDeclaringClass().getName());
                                ////Log.d(TAG, "【方法名】: " + param.method.getName());
                                ////Log.d(TAG, "【Intent Action】: " + intent.getAction());
                                ////Log.d(TAG, "【Intent Type】: " + intent.getType());
                                ////Log.d(TAG, "【Intent Component】: " + (intent.getComponent() != null ? intent.getComponent().toString() : "null"));

                                // 打印Intent中携带的所有附加数据(Extras)
                                Bundle extras = intent.getExtras();
                                if (extras != null && !extras.isEmpty()) {
                                    ////Log.d(TAG, "【Intent Extras】:");
                                    for (String key : extras.keySet()) {
                                        Object value = extras.get(key);
                                        String valueStr = (value != null) ? value.toString() : "null";
                                        // 避免打印过长的内容导致Logcat卡顿
                                        if (valueStr.length() > 200) {
                                            valueStr = valueStr.substring(0, 200) + "...";
                                        }
                                        ////Log.d(TAG, "    " + key + " = " + valueStr);
                                    }
                                } else {
                                    ////Log.d(TAG, "【Intent Extras】: null or empty");
                                }
                                ////Log.d(TAG, "================================================================");
                            }
                        });
                    }
                }
            } catch (Throwable ignored) {
                // 忽略
            }
        }
        ////Log.d(TAG, "【侦查兵】所有 (Intent) 签名方法的扫描和Hook部署完毕。");
    }

    /**
     * 辅助方法：对单个指定的类，Hook其 doinit 和 onNewIntent 两个入口点
     *
     * @param className 要Hook的目标类名
     * @param lpparam   LoadPackageParam
     */
    private void hookAllEntryPointsForClass(final String className, final LoadPackageParam lpparam) {
        // --- Hook 入口1: doinit ---
        try {
            // 尝试Hook带Bundle参数的版本，主要用于OrderViewWithMap
            XposedHelpers.findAndHookMethod(className, lpparam.classLoader, "doinit", Intent.class, Bundle.class, new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    ////Log.d(TAG, "【入口 doinit with Bundle】" + className + " 被触发！");
                    changeButtonToRobMode(param.thisObject, lpparam.packageName);
                }
            });
        } catch (Throwable t) {
            // 如果带Bundle的版本失败，说明是OrderView，尝试Hook不带Bundle的版本
            try {
                XposedHelpers.findAndHookMethod(className, lpparam.classLoader, "doinit", Intent.class, new XC_MethodHook() {
                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        ////Log.d(TAG, "【入口 doinit】" + className + " 被触发！");
                        changeButtonToRobMode(param.thisObject, lpparam.packageName);
                    }
                });
            } catch (Throwable t2) {
                ////Log.e(TAG, "Hook " + className + " 的 doinit 方法彻底失败: " + t2.getMessage());
            }
        }

        // --- Hook 入口2: onNewIntent ---
        try {
            XposedHelpers.findAndHookMethod(className, lpparam.classLoader, "onNewIntent", Intent.class, new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    ////Log.d(TAG, "【入口 onNewIntent】" + className + " 被触发！");

                    // onNewIntent后，App自身的UI更新需要一点时间，我们延迟修改以避免冲突
                    // 使用主线程的Handler来确保UI操作的线程安全
                    new Handler(Looper.getMainLooper()).postDelayed(() -> {
                        changeButtonToRobMode(param.thisObject, lpparam.packageName);
                    }, 150); // 延迟150毫秒，这个值可以微调
                }
            });
        } catch (Throwable t) {
            ////Log.e(TAG, "Hook " + className + " 的 onNewIntent 方法失败: " + t.getMessage());
        }
    }

    /**
     * 【核心】部署对两个订单界面的所有入口进行Hook
     *
     * @param lpparam LoadPackageParam
     */
    private void deployOrderViewHooks(final LoadPackageParam lpparam) {
        // 定义两个已知的订单界面类名
        final String className1 = "com.jiuzhou.TaxiDriver.Views.OrderView";
        final String className2 = "com.jiuzhou.TaxiDriver.Views.OrderViewWithMap";

        // 分别对这两个类部署Hook
        hookAllEntryPointsForClass(className1, lpparam);
        hookAllEntryPointsForClass(className2, lpparam);
    }

    @Override
    public void handleLoadPackage(final LoadPackageParam lpparam) throws Throwable {
        if (!lpparam.packageName.equals(TARGET_PACKAGE_NAME)) return;

        XposedHelpers.findAndHookMethod(Application.class, "onCreate", new XC_MethodHook() {
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                Context appContext = (Context) param.thisObject;
                ////Log.d(TAG, "模块已注入，开始部署...");
                // 【核心修改】在这里调用我们新的“直接访问”方法//无法使用 会坏掉
//                loadSettingsDirectly(appContext);
                // 启动时加载一次
//                loadSettingsFromProvider(appContext);
                registerBroadcastReceiver(appContext);
                ////Log.d(TAG, "模块已注入，开始部署2...");

                // 直接使用我们最熟悉、最稳定的Hook入口
                hookOrderView(lpparam);
                ////Log.d(TAG, "模块已注入，开始部署3...");

                new Thread(() -> findAndHookPlayMethod(appContext)).start();
            }
        });
    }

    // 1. 把上面的 `calculateSpeedFromProgress` 方法复制到 xp.java 类里面
    public static float calculateSpeedFromProgress(int progress) {
        float speed = ((progress * 1.7f) / 170.0f) + 0.3f;
        return speed;
    }

    private void loadSettingsFromProvider(Context context) {
        Cursor cursor = null;
        try {
            if (context == null) return;
            // 通过 ContentResolver 查询我们的 Provider
            cursor = context.getContentResolver().query(CONTENT_URI, null, null, null, null);
            if (cursor == null) return;

            if (cursor.moveToFirst()) {
                // 【取值】使用 Provider 对外暴露的 Key
                currentSpeed = cursor.getFloat(cursor.getColumnIndex("currentSpeed")); // Provider已经算好了float
                rob_delay_ms = cursor.getInt(cursor.getColumnIndex("rob_delay_ms"));
                rob_delay_ms_delay = cursor.getInt(cursor.getColumnIndex("rob_delay_ms_delay"));
                test1 = cursor.getInt(cursor.getColumnIndex("test1"));
                test2 = cursor.getInt(cursor.getColumnIndex("test2"));
                test3 = cursor.getInt(cursor.getColumnIndex("test3"));
                cdkValue = cursor.getInt(cursor.getColumnIndex("xsfvs")); // Provider 暴露的是 xsfvs

//                //Log.d(TAG, "Provider加载成功 -> Speed:" + currentSpeed + ", UserDelay:" + rob_delay_ms);
            }
        } catch (Exception e) {
//            //Log.e(TAG, "从Provider加载配置异常!", e);
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    /**
     * 【核心新增】精准侦查兵：只扫描并Hook一个特定类中所有符合 (Intent) 签名的方法
     *
     * @param lpparam         LoadPackageParam
     * @param targetClassName 要侦查的目标类的完整名称
     */
    private void spyOnSpecificClassMethods(final LoadPackageParam lpparam, String targetClassName) {
        ////Log.d(TAG, "【精准侦查】开始扫描类: " + targetClassName);

        try {
            Class<?> clazz = XposedHelpers.findClass(targetClassName, lpparam.classLoader);

            // 遍历当前类的所有方法
            for (final Method method : clazz.getDeclaredMethods()) {
                // 侦查参数为 (Intent) 的方法
                if (method.getParameterCount() == 1 && method.getParameterTypes()[0] == Intent.class) {
                    ////Log.d(TAG, "【精准侦查】发现目标方法: " + method.getName() + "，已部署Hook。");

                    XposedBridge.hookMethod(method, new XC_MethodHook() {
                        @Override
                        protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                            // 打印日志的逻辑和之前完全一样
                            Intent intent = (Intent) param.args[0];
                            if (intent == null) return;

                            ////Log.d(TAG, "===================== (Intent) 方法被调用 =====================");
                            ////Log.d(TAG, "【类名】: " + param.method.getDeclaringClass().getName());
                            ////Log.d(TAG, "【方法名】: " + param.method.getName());
                            // ... 其他打印Intent信息的代码 ...
                            ////Log.d(TAG, "================================================================");
                        }
                    });
                }
            }
            ////Log.d(TAG, "【精准侦查】" + targetClassName + " 扫描完毕。");
        } catch (Throwable t) {
            ////Log.e(TAG, "【精准侦查】扫描类 " + targetClassName + " 失败: ", t);
        }
    }
// 在 xp.java 中

// ... 其他代码 ...

    /**
     * 【精准修改版】在指定的类中寻找并Hook订单界面的初始化方法。
     * 这个方法不再进行全局扫描，以避免触发加固保护。
     *
     * @param lpparam         LoadPackageParam
     * @param targetClassName 要处理的目标类的完整名称
     */
    private void findAndHookOrderViewDynamically(final LoadPackageParam lpparam, String targetClassName) {
        ////Log.d(TAG, "【精准修改】开始处理类: " + targetClassName);

        try {
            // 1. 直接通过名字找到我们已经确定的目标类
            Class<?> clazz = XposedHelpers.findClass(targetClassName, lpparam.classLoader);

            ////Log.d(TAG, "【精准修改】成功定位到类: " + clazz.getName());

            // 2. 遍历这个类中声明的所有方法
            for (final Method method : clazz.getDeclaredMethods()) {

                // 3. 寻找符合我们“签名”的方法：只有一个参数，且类型是 Intent
                if (method.getParameterCount() == 1 && method.getParameterTypes()[0] == Intent.class) {

                    // 找到了一个符合条件的方法 (可能是 doinit, onNewIntent, 或者被混淆后的 a, b 等)
                    ////Log.d(TAG, "【精准修改】发现目标方法: " + method.getName() + "，已部署修改按钮的Hook。");

                    // 4. 对这个找到的方法实施Hook
                    XposedBridge.hookMethod(method, new XC_MethodHook() {
                        @Override
                        protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                            ////Log.d(TAG, "【精准修改】Hook的方法 " + method.getName() + " 已被触发！");

                            // 调用我们统一的按钮修改逻辑
                            changeButtonToRobMode(param.thisObject, lpparam.packageName);
                        }
                    });
                }
            }
            ////Log.d(TAG, "【精准修改】" + targetClassName + " 的方法扫描和Hook部署完毕。");

        } catch (Throwable t) {
            ////Log.e(TAG, "【精准修改】处理类 " + targetClassName + " 失败: ", t);
        }
    }

    // 在 xp.java 中
    private void findAndHookPlayMethod(Context context) {
        ////Log.d(TAG, "开始动态扫描所有类以寻找播放方法...");

        // 【关键修改】不再使用 return; 语句

        List<String> classNames = getAllClassNames(context);

        for (String className : classNames) {
            // 【优化】直接锁定我们已知的两个目标类，大幅提高效率和稳定性
            if (!className.equals("com.jiuzhou.TaxiDriver.Views.OrderView") &&
                    !className.equals("com.jiuzhou.TaxiDriver.Views.OrderViewWithMap")) {
                continue;
            }

            try {
                Class<?> clazz = XposedHelpers.findClass(className, context.getClassLoader());
                ////Log.d(TAG, "模块已注入，开始部署4...");

                for (Method method : clazz.getDeclaredMethods()) {
                    // 签名 (File, int)，方法名叫 ManualPlay
                    if (method.getName().equals("ManualPlay") && // 增加方法名判断，更精确
                            method.getParameterCount() == 2 &&
                            method.getParameterTypes()[0] == File.class &&
                            method.getParameterTypes()[1] == int.class) {

                        ////Log.d(TAG, "[成功!] 动态找到目标播放方法: " + method.toGenericString());

                        // 找到后立即Hook
                        XposedBridge.hookMethod(method, new XC_MethodHook() {
                            @Override
                            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                                if (cdkValue == 0) {
                                    return;
                                }
                                try {
                                    Object orderViewInstance = param.thisObject;
                                    Field playerField = XposedHelpers.findField(orderViewInstance.getClass(), "iMediaPlayer");
                                    Object iMediaPlayerInstance = playerField.get(orderViewInstance);

                                    if (iMediaPlayerInstance != null) {
                                        setPlayerSpeed(iMediaPlayerInstance);
                                        ////Log.d(TAG, "已对 " + orderViewInstance.getClass().getSimpleName() + " 的播放器设置速度。");
                                    }
                                } catch (Exception e) {
//                                    ////Log.e(TAG, "设置播放速度时出错: ", e);
                                }
                            }
                        });

                        // 【关键修改】注释掉或者删除这一行！让循环继续，去寻找下一个符合条件的方法。
                        // return;
                    }
                }
            } catch (Throwable ignored) {
                // ...
            }
        }
        ////Log.d(TAG, "[扫描结束] 所有已知的播放方法Hook部署完毕。");
    }

    /**
     * 辅助函数：通过DexFile获取应用的所有类名
     */
    private List<String> getAllClassNames(Context context) {
        List<String> classNames = new ArrayList<>();
        try {
            DexFile df = new DexFile(context.getPackageCodePath());
            Enumeration<String> enumeration = df.entries();
            while (enumeration.hasMoreElements()) {
                classNames.add(enumeration.nextElement());
            }
        } catch (Exception e) {
        }
        return classNames;
    }
    // --- 辅助方法区 ---

    private void registerBroadcastReceiver(Context context) {
        IntentFilter filter = new IntentFilter();
        filter.addAction("com.example.CHANGE_PLAYBACK_SPEED");
        filter.addAction("com.example.msphone.UPDATE_DELAY");
        filter.addAction("com.example.msphone.THISSHOWTIME");
        filter.addAction("com.example.msphone.SEND_SETTINGS_TO_XPOSED");
        filter.addAction("com.example.msphone.SETTINGS_UPDATED_SIGNAL");
        filter.addAction("com.example.msphone.SEND_SETTINGS_TO_XPOSED");
        BroadcastReceiver receiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                if (intent == null || intent.getAction() == null) return;
                switch (intent.getAction()) {
                    case "com.example.CHANGE_PLAYBACK_SPEED":
                        //位置
                        currentSpeed = intent.getFloatExtra("playback_speed", 1.0f);
                        break;
                    case "com.example.msphone.UPDATE_DELAY":
                        if (intent.hasExtra("rob_delay_ms")) {
                            rob_delay_ms = intent.getIntExtra("rob_delay_ms", 5000);
//                            //Log.d(TAG, "成功设置延迟" + rob_delay_ms);

                        }
                        if (intent.hasExtra("rob_delay_ms_delay")) {
                            rob_delay_ms_delay = intent.getIntExtra("rob_delay_ms_delay", 0);
//                            //Log.d(TAG, "成功设置最低延迟" + rob_delay_ms_delay);
                        } else {
//                            //Log.d(TAG, "未成功设置最低延迟" + rob_delay_ms_delay);

                        }
                        if (intent.hasExtra("test1")) {
                            test1 = intent.getIntExtra("test1", 0);
                        }
                        if (intent.hasExtra("test2")) {
                            test1 = intent.getIntExtra("test2", 0);
                        }
                        if (intent.hasExtra("test3")) {
                            test1 = intent.getIntExtra("test3", 0);
                        }

                        break;
                    case "com.example.msphone.THISSHOWTIME":
                        //最大值
                        cdkValue = intent.getIntExtra("xsfvs", 0);
                        break;
                    case "com.example.msphone.SEND_SETTINGS_TO_XPOSED":
                        //最大值
                        // 收到广播，就用里面的数据无条件覆盖内存中的所有配置
                        currentSpeed = intent.getFloatExtra("currentSpeed", 1.0f);
                        rob_delay_ms = intent.getIntExtra("rob_delay_ms", 5000);
                        rob_delay_ms_delay = intent.getIntExtra("rob_delay_ms_delay", 0);
                        cdkValue = intent.getIntExtra("xsfvs", 0);
                        test1 = intent.getIntExtra("test1", 0);

//                        //Log.d(TAG, "接收到全量配置更新 -> Speed: " + currentSpeed + ", Delay: " + rob_delay_ms);
                        break;
                    case "com.example.msphone.SETTINGS_UPDATED_SIGNAL":
                        //最大值
                        // 收到广播，就用里面的数据无条件覆盖内存中的所有配置
//                        currentSpeed = intent.getFloatExtra("currentSpeed", 1.0f);
//                        rob_delay_ms = intent.getIntExtra("rob_delay_ms", 5000);
//                        rob_delay_ms_delay = intent.getIntExtra("rob_delay_ms_delay", 0);
//                        cdkValue = intent.getIntExtra("xsfvs", 0);
//                        test1 = intent.getIntExtra("test1", 0);

//                        //Log.d(TAG, "接收到全量配置更新 -> Speed: " + currentSpeed + ", Delay: " + rob_delay_ms);
                        loadSettingsFromProvider(context);
                        break;
                }
            }
        };

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            context.registerReceiver(receiver, filter, Context.RECEIVER_EXPORTED);
        } else {
            context.registerReceiver(receiver, filter);
        }
    }

    private void hookActivityEvents(ClassLoader classLoader) {
        XposedHelpers.findAndHookMethod(Activity.class, "dispatchKeyEvent", KeyEvent.class, new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                KeyEvent event = (KeyEvent) param.args[0];
                if (event.getAction() == KeyEvent.ACTION_UP && event.getKeyCode() == KeyEvent.KEYCODE_VOLUME_UP) {
                    long currentTime = System.currentTimeMillis();
                    if (currentTime - lastVolumeUpClickTime <= 300) {
                        ((Context) param.thisObject).sendBroadcast(new Intent("TOGGLE_FLOATING_WINDOW"));
                    }
                    lastVolumeUpClickTime = currentTime;
                }
            }
        });
    }

    private void setPlayerSpeed(Object playerInstance) {
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && playerInstance instanceof MediaPlayer) {
                PlaybackParams params = ((MediaPlayer) playerInstance).getPlaybackParams();
                params.setSpeed(currentSpeed);

                ((MediaPlayer) playerInstance).setPlaybackParams(params);
                // ////Log.d(TAG , ": 通过标准API设置速度为 -> " + currentSpeed);
            } else {
                Method setSpeedMethod = XposedHelpers.findMethodExactIfExists(playerInstance.getClass(), "setSpeed", float.class);
                if (setSpeedMethod != null) {
                    setSpeedMethod.invoke(playerInstance, currentSpeed);
                    // ////Log.d(TAG , ": 通过反射调用setSpeed方法设置速度为 -> " + currentSpeed);
                } else {
                    // ////Log.d(TAG , ": 在播放器中未找到setSpeed(float)方法。");
                }
            }
        } catch (Exception e) {
            // ////Log.d(TAG , ": 设置播放器速度时发生异常: " + e.getMessage());
        }
    }
}