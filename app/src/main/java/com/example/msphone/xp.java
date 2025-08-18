package com.example.msphone;

import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Build;
import android.media.PlaybackParams;
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
    // 【核心新增】用于Hook订单界面并修改按钮的方法
    private void hookOrderView(final LoadPackageParam lpparam) {
        // 目标类和方法，注意如果App有混淆，需要改成混淆后的名称
        final String targetClassName = "com.jiuzhou.TaxiDriver.Views.OrderView";
        final String targetMethodName = "doinit";

        try {
            XposedHelpers.findAndHookMethod(
                    targetClassName,
                    lpparam.classLoader,
                    targetMethodName,
                    Intent.class, // 方法参数
                    new XC_MethodHook() {
                        @Override
                        protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                            super.afterHookedMethod(param);

                            XposedBridge.log(TAG + ": OrderView.doinit方法被Hook。");

                            // 首先检查秒抢功能是否开启
                            if (instantRobEnabled == 0) {
                                XposedBridge.log(TAG + ": 秒抢功能未开启，不执行任何操作。");
                                return;
                            }

                            XposedBridge.log(TAG + ": 秒抢功能已开启，开始修改按钮状态...");

                            try {
                                Object orderViewInstance = param.thisObject;
                                Context context = (Context) orderViewInstance;

                                // 通过反射获取私有字段，注意字段名可能被混淆
                                RelativeLayout robRL = (RelativeLayout) XposedHelpers.getObjectField(orderViewInstance, "RobTheOrder_RL");
                                Button robBtn = (Button) XposedHelpers.getObjectField(orderViewInstance, "RobTheOrder_Btn");

                                // 1. 设为可点击
                                robRL.setClickable(true);
                                robBtn.setClickable(true);

                                // 2. 修改尺寸
                                ViewGroup.LayoutParams layoutParams = robBtn.getLayoutParams();
                                float density = context.getResources().getDisplayMetrics().density;
                                layoutParams.width = (int) (30.0f * density + 0.5f);
                                layoutParams.height = (int) (30.0f * density + 0.5f);
                                robBtn.setLayoutParams(layoutParams);

                                // 3. 更换背景为方形 (通过资源名获取ID，更稳定)
                                int pbfDrawableId = context.getResources().getIdentifier("pbf", "drawable", lpparam.packageName);
                                if (pbfDrawableId != 0) {
                                    robBtn.setBackgroundResource(pbfDrawableId);
                                    XposedBridge.log(TAG + ": [成功] 按钮已修改为方形可点击状态！");
                                } else {
                                    XposedBridge.log(TAG + ": [警告] 未找到名为 'pbf' 的drawable资源。");
                                }

                            } catch (Exception e) {
                                XposedBridge.log(TAG + ": [错误] 修改按钮状态时发生异常: " + e.getMessage());
                            }
                        }
                    }
            );
        } catch (Throwable t) {
            XposedBridge.log(TAG + ": [错误] Hook OrderView 失败: " + t.getMessage());
        }
    }
    @Override
    public void handleLoadPackage(final LoadPackageParam lpparam) throws Throwable {
        if (!lpparam.packageName.equals(TARGET_PACKAGE_NAME)) {
            return;
        }
        //XposedBridge.log(TAG + ": 成功注入目标App -> " + lpparam.packageName);

        XposedHelpers.findAndHookMethod(Application.class, "onCreate", new XC_MethodHook() {
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                super.afterHookedMethod(param);

                final Context appContext = (Context) param.thisObject;

                loadInitialState(appContext);
                registerBroadcastReceiver(appContext);
                hookActivityEvents(lpparam.classLoader);

                // 【新增】调用新的Hook方法
                hookOrderView(lpparam);

                new Thread(() -> findAndHookPlayMethod(appContext)).start();
            }
        });
    }

    /**
     * [重构核心] 动态扫描并Hook目标播放方法
     */
    private void findAndHookPlayMethod(Context context) {
        //XposedBridge.log(TAG + ": 开始动态扫描所有类以寻找目标方法...");
        long startTime = System.currentTimeMillis();

        List<String> classNames = getAllClassNames(context);
        //XposedBridge.log(TAG + ": 找到 " + classNames.size() + " 个类，开始遍历...");

        for (String className : classNames) {
            // 过滤掉一些明显不可能的系统类和常用库，提高效率
            if (className.startsWith("android.") || className.startsWith("java.") || className.startsWith("com.google.") || className.startsWith("androidx.")) {
                continue;
            }

            try {
                Class<?> clazz = XposedHelpers.findClass(className, context.getClassLoader());

                // 遍历当前类的所有方法
                for (Method method : clazz.getDeclaredMethods()) {
                    // 关键！我们根据方法的 "签名" 来识别它：(File, int)
                    if (method.getParameterCount() == 2 &&
                            method.getParameterTypes()[0] == File.class &&
                            method.getParameterTypes()[1] == int.class) { // 注意这里是 int.class

                        long endTime = System.currentTimeMillis();
                        //XposedBridge.log(TAG + ": [成功!] 动态找到目标方法: " + method.toGenericString());
                        //XposedBridge.log(TAG + ": 扫描耗时: " + (endTime - startTime) + " ms");

                        // 找到后立即Hook
                        XposedBridge.hookMethod(method, new XC_MethodHook() {
                            @Override
                            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                                if (cdkValue == 0) {
                                    //XposedBridge.log(TAG + ": CDK为0，禁用加速功能。");
                                    return;
                                }

                                try {
                                    Object orderViewInstance = param.thisObject;
                                    // 播放器实例的变量名也可能被混淆，需要逆向分析
                                    Field playerField = XposedHelpers.findField(orderViewInstance.getClass(), "iMediaPlayer");
                                    Object iMediaPlayerInstance = playerField.get(orderViewInstance);

                                    if (iMediaPlayerInstance != null) {
                                        setPlayerSpeed(iMediaPlayerInstance);
                                    }
                                } catch (Exception e) {
                                   // XposedBridge.log(TAG + ": Hook回调中获取或设置播放器速度时出错: " + e.getMessage());
                                }
                            }
                        });
                        return; // 找到并Hook后，立即终止扫描
                    }
                }
            } catch (Throwable ignored) {
                // 忽略掉一些无法加载或分析的类
            }
        }
       // XposedBridge.log(TAG + ": [扫描结束] 未找到符合签名 (File, int) 的方法。");
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
           // XposedBridge.log(TAG + ": 获取所有类名时出错: " + e.getMessage());
        }
        return classNames;
    }

    // --- 以下是其他辅助方法，与上一版相同，保持清晰的结构 ---

    private void loadInitialState(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("XposedModulePrefs", Context.MODE_PRIVATE);
        this.currentSpeed = prefs.getFloat("currentSpeed", 1.0f);
        this.cdkValue = prefs.getInt("xsfvs", 0);
        // 【新增】从本地加载秒抢开关的状态
        this.instantRobEnabled = prefs.getInt("instant_rob", 0);
        //XposedBridge.log(TAG + ": 初始状态加载完成。Speed: " + currentSpeed + ", CDK: " + cdkValue);
    }

    private void registerBroadcastReceiver(Context context) {
        IntentFilter filter = new IntentFilter();
        filter.addAction("com.example.CHANGE_PLAYBACK_SPEED");
        filter.addAction("com.example.msphone.THISSHOWTIME");
        IntentFilter filter1 = new IntentFilter("com.example.msphone.UPDATE_SETTINGS");
        BroadcastReceiver receiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                SharedPreferences.Editor editor = context.getSharedPreferences("XposedModulePrefs", Context.MODE_PRIVATE).edit();
                String action = intent.getAction();
                if ("com.example.CHANGE_PLAYBACK_SPEED".equals(action)) {
                    currentSpeed = intent.getFloatExtra("playback_speed", 1.0f);
                    editor.putFloat("currentSpeed", currentSpeed);
                    //XposedBridge.log(TAG + ": 接收到速度变更命令，新速度: " + currentSpeed);
                } else if ("com.example.msphone.THISSHOWTIME".equals(action)) {
                    cdkValue = intent.getIntExtra("xsfvs", 0);
                    editor.putInt("xsfvs", cdkValue);
                    //XposedBridge.log(TAG + ": 接收到认证状态变更，新CDK: " + cdkValue);
                } else  if ("com.example.msphone.UPDATE_SETTINGS".equals(action)) {
                    // 同时接收两个控制参数
                    cdkValue = intent.getIntExtra("xsfvs", 0);
                    instantRobEnabled = intent.getIntExtra("instant_rob", 0);

                    // 保存到本地，以便下次启动时能恢复状态
                    editor.putInt("xsfvs", cdkValue);
                    editor.putInt("instant_rob", instantRobEnabled);

                    XposedBridge.log(TAG + ": 接收到设置更新 -> CDK: " + cdkValue + ", InstantRob: " + instantRobEnabled);
                }
                editor.apply();
            }
        };

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            context.registerReceiver(receiver, filter, Context.RECEIVER_EXPORTED);
        } else {
            context.registerReceiver(receiver, filter);
        }
        //XposedBridge.log(TAG + ": 广播接收器注册成功。");
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
               // XposedBridge.log(TAG + ": 通过标准API设置速度为 -> " + currentSpeed);
            } else {
                Method setSpeedMethod = XposedHelpers.findMethodExactIfExists(playerInstance.getClass(), "setSpeed", float.class);
                if (setSpeedMethod != null) {
                    setSpeedMethod.invoke(playerInstance, currentSpeed);
                   // XposedBridge.log(TAG + ": 通过反射调用setSpeed方法设置速度为 -> " + currentSpeed);
                } else {
                   // XposedBridge.log(TAG + ": 在播放器中未找到setSpeed(float)方法。");
                }
            }
        } catch (Exception e) {
           // XposedBridge.log(TAG + ": 设置播放器速度时发生异常: " + e.getMessage());
        }
    }
}