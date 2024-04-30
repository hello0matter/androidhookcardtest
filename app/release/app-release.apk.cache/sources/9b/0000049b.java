package com.google.android.material.behavior;

import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.app.o0;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import i0.g0;
import i0.y0;
import j0.g;
import java.util.WeakHashMap;
import n0.e;
import r1.a;

/* loaded from: classes.dex */
public class SwipeDismissBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {

    /* renamed from: a  reason: collision with root package name */
    public e f3009a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f3010b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f3011c;

    /* renamed from: d  reason: collision with root package name */
    public int f3012d = 2;

    /* renamed from: e  reason: collision with root package name */
    public final float f3013e = 0.5f;

    /* renamed from: f  reason: collision with root package name */
    public float f3014f = 0.0f;

    /* renamed from: g  reason: collision with root package name */
    public float f3015g = 0.5f;

    /* renamed from: h  reason: collision with root package name */
    public final a f3016h = new a(this);

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean k(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        boolean z4 = this.f3010b;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked == 1 || actionMasked == 3) {
                this.f3010b = false;
            }
        } else {
            z4 = coordinatorLayout.t(view, (int) motionEvent.getX(), (int) motionEvent.getY());
            this.f3010b = z4;
        }
        if (!z4) {
            return false;
        }
        if (this.f3009a == null) {
            this.f3009a = new e(coordinatorLayout.getContext(), coordinatorLayout, this.f3016h);
        }
        if (!this.f3011c && this.f3009a.r(motionEvent)) {
            return true;
        }
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean l(CoordinatorLayout coordinatorLayout, View view, int i4) {
        WeakHashMap weakHashMap = y0.f4999a;
        if (g0.c(view) == 0) {
            g0.s(view, 1);
            y0.m(1048576, view);
            y0.i(0, view);
            if (w(view)) {
                y0.n(view, g.f5084l, null, new o0(27, this));
            }
        }
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean v(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        if (this.f3009a != null) {
            if (this.f3011c && motionEvent.getActionMasked() == 3) {
                return true;
            }
            this.f3009a.k(motionEvent);
            return true;
        }
        return false;
    }

    public boolean w(View view) {
        return true;
    }
}