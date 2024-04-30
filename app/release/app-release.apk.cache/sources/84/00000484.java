package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class HeaderBehavior<V extends View> extends ViewOffsetBehavior<V> {

    /* renamed from: c  reason: collision with root package name */
    public l f2934c;

    /* renamed from: d  reason: collision with root package name */
    public OverScroller f2935d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f2936e;

    /* renamed from: f  reason: collision with root package name */
    public int f2937f;

    /* renamed from: g  reason: collision with root package name */
    public int f2938g;

    /* renamed from: h  reason: collision with root package name */
    public int f2939h;

    /* renamed from: i  reason: collision with root package name */
    public VelocityTracker f2940i;

    public HeaderBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2937f = -1;
        this.f2939h = -1;
    }

    public boolean A(View view) {
        return false;
    }

    public int B(View view) {
        return -view.getHeight();
    }

    public int C(View view) {
        return view.getHeight();
    }

    public void D(View view, CoordinatorLayout coordinatorLayout) {
    }

    public int E(CoordinatorLayout coordinatorLayout, View view, int i4, int i5, int i6) {
        int L;
        int w4 = w();
        if (i5 == 0 || w4 < i5 || w4 > i6 || w4 == (L = com.google.common.collect.c.L(i4, i5, i6))) {
            return 0;
        }
        z(L);
        return w4 - L;
    }

    public final void F(CoordinatorLayout coordinatorLayout, View view, int i4) {
        E(coordinatorLayout, view, i4, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean k(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        boolean z4;
        int findPointerIndex;
        if (this.f2939h < 0) {
            this.f2939h = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        if (motionEvent.getActionMasked() == 2 && this.f2936e) {
            int i4 = this.f2937f;
            if (i4 == -1 || (findPointerIndex = motionEvent.findPointerIndex(i4)) == -1) {
                return false;
            }
            int y4 = (int) motionEvent.getY(findPointerIndex);
            if (Math.abs(y4 - this.f2938g) > this.f2939h) {
                this.f2938g = y4;
                return true;
            }
        }
        if (motionEvent.getActionMasked() == 0) {
            this.f2937f = -1;
            int x4 = (int) motionEvent.getX();
            int y5 = (int) motionEvent.getY();
            if (A(view) && coordinatorLayout.t(view, x4, y5)) {
                z4 = true;
            } else {
                z4 = false;
            }
            this.f2936e = z4;
            if (z4) {
                this.f2938g = y5;
                this.f2937f = motionEvent.getPointerId(0);
                if (this.f2940i == null) {
                    this.f2940i = VelocityTracker.obtain();
                }
                OverScroller overScroller = this.f2935d;
                if (overScroller != null && !overScroller.isFinished()) {
                    this.f2935d.abortAnimation();
                    return true;
                }
            }
        }
        VelocityTracker velocityTracker = this.f2940i;
        if (velocityTracker != null) {
            velocityTracker.addMovement(motionEvent);
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00dc A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:47:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean v(androidx.coordinatorlayout.widget.CoordinatorLayout r20, android.view.View r21, android.view.MotionEvent r22) {
        /*
            Method dump skipped, instructions count: 225
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.HeaderBehavior.v(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.MotionEvent):boolean");
    }
}