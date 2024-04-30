package com.google.android.material.timepicker;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.recyclerview.widget.i0;
import com.example.msphone.R;

/* loaded from: classes.dex */
public final class c extends i0.c {

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ ClockFaceView f4158d;

    public c(ClockFaceView clockFaceView) {
        this.f4158d = clockFaceView;
    }

    @Override // i0.c
    public final void d(View view, j0.h hVar) {
        View.AccessibilityDelegate accessibilityDelegate = this.f4912a;
        AccessibilityNodeInfo accessibilityNodeInfo = hVar.f5093a;
        accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
        int intValue = ((Integer) view.getTag(R.id.material_value_index)).intValue();
        if (intValue > 0) {
            accessibilityNodeInfo.setTraversalAfter((View) this.f4158d.f4131x.get(intValue - 1));
        }
        hVar.h(i0.i(0, 1, intValue, 1, false, view.isSelected()));
        accessibilityNodeInfo.setClickable(true);
        hVar.b(j0.g.f5079g);
    }

    @Override // i0.c
    public final boolean g(View view, int i4, Bundle bundle) {
        if (i4 == 16) {
            long uptimeMillis = SystemClock.uptimeMillis();
            ClockFaceView clockFaceView = this.f4158d;
            view.getHitRect(clockFaceView.f4128u);
            float centerX = clockFaceView.f4128u.centerX();
            float centerY = clockFaceView.f4128u.centerY();
            clockFaceView.f4127t.onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, centerX, centerY, 0));
            clockFaceView.f4127t.onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 1, centerX, centerY, 0));
            return true;
        }
        return super.g(view, i4, bundle);
    }
}