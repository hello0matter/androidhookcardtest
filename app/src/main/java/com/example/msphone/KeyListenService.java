package com.example.msphone;

import android.accessibilityservice.AccessibilityService;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.KeyEvent;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Toast;

public class KeyListenService extends AccessibilityService {
    private static final String TAG = "KeyListenService";
    private Handler longPressHandler;
    private static final int LONG_PRESS_TIMEOUT = 1000; // 长按1秒触发

    @Override
    public void onServiceConnected() {
        super.onServiceConnected();
        longPressHandler = new Handler(Looper.getMainLooper());
        Log.i(TAG, "Accessibility Service is connected!");
    }

    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {}

    @Override
    public void onInterrupt() {}

    @Override
    protected boolean onKeyEvent(KeyEvent event) {
        if (longPressHandler == null) return super.onKeyEvent(event);
        int keyCode = event.getKeyCode();
        int action = event.getAction();

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (action == KeyEvent.ACTION_DOWN) {
                longPressHandler.removeCallbacks(longPressRunnable);
                longPressHandler.postDelayed(longPressRunnable, LONG_PRESS_TIMEOUT);
            } else if (action == KeyEvent.ACTION_UP) {
                longPressHandler.removeCallbacks(longPressRunnable);
            }
            return false; // 始终返回false，不拦截正常的短按返回操作
        }
        return super.onKeyEvent(event);
    }

    private final Runnable longPressRunnable = new Runnable() {
        @Override
        public void run() {
            Log.i(TAG, "Long press on BACK key confirmed! Sending broadcast...");
            sendBroadcast(new Intent("TOGGLE_FLOATING_WINDOW"));
//            Toast.makeText(KeyListenService.this, "悬浮窗状态已切换", Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (longPressHandler != null) {
            longPressHandler.removeCallbacksAndMessages(null);
        }
    }
}