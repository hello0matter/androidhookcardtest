package com.example.msphone;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.GestureDescription;
import android.graphics.Bitmap;
import android.graphics.Path;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Display;
import android.view.accessibility.AccessibilityEvent;

import java.io.ByteArrayOutputStream;

public class MyAccessibilityService extends AccessibilityService {

    private static volatile MyAccessibilityService instance;

    public static MyAccessibilityService getInstance() { return instance; }

    @Override
    public void onServiceConnected() {
        instance = this;
    }

    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {}

    @Override
    public void onInterrupt() {}

    @Override
    public void onDestroy() {
        super.onDestroy();
        instance = null;
    }

    // ---- 截图（Android 11+ / API 30+ 无障碍截图）----
    public interface ScreenshotCallback {
        void onResult(byte[] pngBytes); // null 表示失败
    }

    public void takeScreenshotAsync(ScreenshotCallback callback) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.R) {
            callback.onResult(null);
            return;
        }
        takeScreenshot(Display.DEFAULT_DISPLAY, getMainExecutor(), new TakeScreenshotCallback() {
            @Override
            public void onSuccess(ScreenshotResult screenshot) {
                try {
                    Bitmap bmp = Bitmap.wrapHardwareBuffer(screenshot.getHardwareBuffer(), screenshot.getColorSpace());
                    screenshot.getHardwareBuffer().close();
                    Bitmap soft = bmp.copy(Bitmap.Config.ARGB_8888, false);
                    bmp.recycle();
                    ByteArrayOutputStream bos = new ByteArrayOutputStream();
                    soft.compress(Bitmap.CompressFormat.PNG, 90, bos);
                    soft.recycle();
                    callback.onResult(bos.toByteArray());
                } catch (Throwable t) {
                    callback.onResult(null);
                }
            }
            @Override
            public void onFailure(int errorCode) { callback.onResult(null); }
        });
    }

    // ---- 模拟点击 ----
    public boolean tap(float x, float y) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) return false;
        try {
            Path path = new Path();
            path.moveTo(x, y);
            GestureDescription.StrokeDescription stroke =
                    new GestureDescription.StrokeDescription(path, 0, 50);
            GestureDescription gesture = new GestureDescription.Builder().addStroke(stroke).build();
            return dispatchGesture(gesture, null, null);
        } catch (Throwable t) { return false; }
    }

    // ---- 模拟滑动 ----
    public boolean swipe(float x1, float y1, float x2, float y2, long durationMs) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) return false;
        try {
            Path path = new Path();
            path.moveTo(x1, y1);
            path.lineTo(x2, y2);
            GestureDescription.StrokeDescription stroke =
                    new GestureDescription.StrokeDescription(path, 0, Math.max(100, durationMs));
            GestureDescription gesture = new GestureDescription.Builder().addStroke(stroke).build();
            return dispatchGesture(gesture, null, null);
        } catch (Throwable t) { return false; }
    }
}
