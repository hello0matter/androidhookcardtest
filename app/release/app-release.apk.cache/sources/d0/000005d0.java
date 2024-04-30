package com.google.android.material.timepicker;

import android.view.ViewTreeObserver;

/* loaded from: classes.dex */
public final class b implements ViewTreeObserver.OnPreDrawListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ClockFaceView f4157a;

    public b(ClockFaceView clockFaceView) {
        this.f4157a = clockFaceView;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        ClockFaceView clockFaceView = this.f4157a;
        if (!clockFaceView.isShown()) {
            return true;
        }
        clockFaceView.getViewTreeObserver().removeOnPreDrawListener(this);
        int height = ((clockFaceView.getHeight() / 2) - clockFaceView.f4127t.f4137d) - clockFaceView.B;
        if (height != clockFaceView.f4148r) {
            clockFaceView.f4148r = height;
            clockFaceView.o();
            int i4 = clockFaceView.f4148r;
            ClockHandView clockHandView = clockFaceView.f4127t;
            clockHandView.f4145l = i4;
            clockHandView.invalidate();
        }
        return true;
    }
}