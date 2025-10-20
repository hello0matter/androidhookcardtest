package com.example.msphone;

import android.accessibilityservice.AccessibilityService;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

public class MyAccessibilityService extends AccessibilityService {

    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
        int eventType = event.getEventType();
        if (eventType == AccessibilityEvent.TYPE_VIEW_CLICKED) {
            AccessibilityNodeInfo nodeInfo = event.getSource();
            if (nodeInfo != null && nodeInfo.getText() != null && nodeInfo.getText().toString().equals("三指截屏")) {
                // 执行三指截屏的操作
//                //Log.e("aaaaaa", "asdsadasd");
            }
        }
    }

    @Override
    public void onInterrupt() {
        // 中断服务时的操作
    }
}