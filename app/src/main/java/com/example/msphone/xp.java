package com.example.msphone;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;

import com.google.android.exoplayer2.SimpleExoPlayer;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

/* loaded from: classes3.dex */
public class xp implements IXposedHookLoadPackage {
    private static final int DOUBLE_CLICK_THRESHOLD = 300;
    private String TAG = "chenxin";
    private float currentSpeed = 1.0f;
    private long lastVolumeUpClickTime = 0;
    // 全局变量来追踪当前播放的音频源
    private static String currentPlayingUri = null;
    private static SimpleExoPlayer player = null;

    public static void init(Context context) {
        // 初始化ExoPlayer实例
        if (player == null) {
            player = new SimpleExoPlayer.Builder(context.getApplicationContext()).build();
        }
    }

    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam loadPackageParam) throws Throwable {
        BroadcastReceiver playbackSpeedReceiver = new BroadcastReceiver() { // from class: cx.xp.test.xp.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                if (FloatingWindowService.ACTION_CHANGE_PLAYBACK_SPEED.equals(intent.getAction())) {
                    xp.this.currentSpeed = intent.getFloatExtra(FloatingWindowService.EXTRA_PLAYBACK_SPEED, 1.0f);
                    SharedPreferences prefs = xp.this.getSharedPreferences(context);
                    SharedPreferences.Editor editor = prefs.edit();
                    if(MainActivity.daks() != 0){
                        editor.putFloat("currentSpeed", xp.this.currentSpeed);
                    }
                    editor.apply();
                }
            }
        };
        if (loadPackageParam.packageName.equals("com.eastedge.taxidriverforpad")) {
            XposedHelpers.findAndHookMethod("com.stub.StubApp", loadPackageParam.classLoader, "attachBaseContext", new Object[]{Context.class, new AnonymousClass2(playbackSpeedReceiver)});
        }
    }

    /* renamed from: cx.xp.test.xp$2  reason: invalid class name */
    /* loaded from: classes3.dex */
    private int findAudioTrack(MediaExtractor extractor) {
        int numTracks = extractor.getTrackCount();
        for (int i = 0; i < numTracks; i++) {
            MediaFormat format = extractor.getTrackFormat(i);
            String mime = format.getString(MediaFormat.KEY_MIME);
            if (mime.startsWith("audio/")) {
                return i;
            }
        }
        return -1;
    }


    class AnonymousClass2 extends XC_MethodHook {
        final /* synthetic */ BroadcastReceiver val$playbackSpeedReceiver;

        AnonymousClass2(BroadcastReceiver broadcastReceiver) {
            this.val$playbackSpeedReceiver = broadcastReceiver;
        }

        protected void afterHookedMethod(XC_MethodHook.MethodHookParam param) throws Throwable {
            super.afterHookedMethod(param);
            Context context = (Context) param.args[0];
            ClassLoader classLoader = context.getClassLoader();
            SharedPreferences prefs = xp.this.getSharedPreferences(context);
            xp.this.currentSpeed = prefs.getFloat("currentSpeed", 1.0f);
            XposedHelpers.findAndHookMethod("android.app.Activity", classLoader, "onCreate", new Object[]{Bundle.class, new XC_MethodHook() { // from class: cx.xp.test.xp.2.1
                protected void afterHookedMethod(MethodHookParam param2) {
                    Activity activity = (Activity) param2.thisObject;
                    IntentFilter filter = new IntentFilter(FloatingWindowService.ACTION_CHANGE_PLAYBACK_SPEED);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        activity.registerReceiver(AnonymousClass2.this.val$playbackSpeedReceiver, filter,Context.RECEIVER_EXPORTED);
                    }else{
                        activity.registerReceiver(AnonymousClass2.this.val$playbackSpeedReceiver, filter);
                    }
                }
            }});
            XposedHelpers.findAndHookMethod("android.app.Activity", classLoader, "dispatchKeyEvent", new Object[]{KeyEvent.class, new XC_MethodHook() { // from class: cx.xp.test.xp.2.2
                protected void beforeHookedMethod(XC_MethodHook.MethodHookParam param2) throws Throwable {
                    KeyEvent event = (KeyEvent) param2.args[0];
                    int keyCode = event.getKeyCode();
                    int action = event.getAction();
                    if (action == 1 && keyCode == 24) {
                        long currentTime = System.currentTimeMillis();
                        if (currentTime - xp.this.lastVolumeUpClickTime <= 300) {
                            Context context2 = (Context) param2.thisObject;
                            Intent intent = new Intent("TOGGLE_FLOATING_WINDOW");
                            context2.sendBroadcast(intent);
                        }
                        xp.this.lastVolumeUpClickTime = currentTime;
                    }
                }
            }});
            try {
                final Class<?> orderViewClass = XposedHelpers.findClass("com.jiuzhou.TaxiDriver.Views.OrderView", classLoader);
                Method manualPlayMethod = orderViewClass.getDeclaredMethod("ManualPlay", File.class, Integer.TYPE);
                XposedBridge.hookMethod(manualPlayMethod, new XC_MethodHook() { // from class: cx.xp.test.xp.2.3
                    protected void afterHookedMethod(XC_MethodHook.MethodHookParam param2) throws Throwable {

                        super.afterHookedMethod(param);
                        Context context = (Context) param.args[0];
                        ClassLoader classLoader = context.getClassLoader();
                        SharedPreferences prefs = xp.this.getSharedPreferences(context);
                        xp.this.currentSpeed = prefs.getFloat("currentSpeed", 1.0f);
                        XposedHelpers.findAndHookMethod("android.app.Activity", classLoader, "onCreate", new Object[]{Bundle.class, new XC_MethodHook() { // from class: cx.xp.test.xp.2.1
                            protected void afterHookedMethod(MethodHookParam param2) {
                                Activity activity = (Activity) param2.thisObject;
                                IntentFilter filter = new IntentFilter(FloatingWindowService.ACTION_CHANGE_PLAYBACK_SPEED);
                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                                    activity.registerReceiver(AnonymousClass2.this.val$playbackSpeedReceiver, filter,Context.RECEIVER_EXPORTED);
                                }else{
                                    activity.registerReceiver(AnonymousClass2.this.val$playbackSpeedReceiver, filter);
                                }
                            }
                        }});
                        XposedHelpers.findAndHookMethod("android.app.Activity", classLoader, "dispatchKeyEvent", new Object[]{KeyEvent.class, new XC_MethodHook() { // from class: cx.xp.test.xp.2.2
                            protected void beforeHookedMethod(XC_MethodHook.MethodHookParam param2) throws Throwable {
                                KeyEvent event = (KeyEvent) param2.args[0];
                                int keyCode = event.getKeyCode();
                                int action = event.getAction();
                                if (action == 1 && keyCode == 24) {
                                    long currentTime = System.currentTimeMillis();
                                    if (currentTime - xp.this.lastVolumeUpClickTime <= 300) {
                                        Context context2 = (Context) param2.thisObject;
                                        Intent intent = new Intent("TOGGLE_FLOATING_WINDOW");
                                        context2.sendBroadcast(intent);
                                    }
                                    xp.this.lastVolumeUpClickTime = currentTime;
                                }
                            }
                        }});
                        try {
                            final Class<?> orderViewClass = XposedHelpers.findClass("com.jiuzhou.TaxiDriver.Views.OrderView", classLoader);
                            Method manualPlayMethod = orderViewClass.getDeclaredMethod("ManualPlay", File.class, Integer.TYPE);
                            XposedBridge.hookMethod(manualPlayMethod, new XC_MethodHook() { // from class: cx.xp.test.xp.2.3
                                protected void afterHookedMethod(XC_MethodHook.MethodHookParam param2) throws Throwable {
                                    Object orderViewInstance = param2.thisObject;
                                    Field iMediaPlayerField = orderViewClass.getDeclaredField("iMediaPlayer");
                                    iMediaPlayerField.setAccessible(true);
                                    Object iMediaPlayerInstance = iMediaPlayerField.get(orderViewInstance);
                                    Class<?> iMediaPlayerClass = iMediaPlayerInstance.getClass();
                                    Method[] methods = iMediaPlayerClass.getDeclaredMethods();
                                    for (Method method : methods) {
                                        if (method.getName().equals("setDataSource")) {
                                            XposedBridge.hookMethod(method, new XC_MethodHook() { // from class: cx.xp.test.xp.2.3.1
                                                protected void beforeHookedMethod(XC_MethodHook.MethodHookParam param3) throws Throwable {
                                                    Object ijkMediaPlayerInstance = param3.thisObject;
                                                    try {
                                                        Method setSpeedMethod = ijkMediaPlayerInstance.getClass().getDeclaredMethod("setSpeed", Float.TYPE);
                                                        setSpeedMethod.invoke(ijkMediaPlayerInstance, Float.valueOf(xp.this.currentSpeed));

                                                    } catch (Exception e) {

                                                    }
                                                }
                                            });
                                        }
                                    }
                                }
                            });
                        } catch (NoSuchMethodException e) {
//                            XposedBridge.log(xp.this.TAG + ": " + e.getMessage());
                        }

                    }
                });
            } catch (NoSuchMethodException e) {
//                XposedBridge.log(xp.this.TAG + ": " + e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SharedPreferences getSharedPreferences(Context context) {
        return context.getSharedPreferences("XposedModulePrefs", 0);
    }
}
