package com.google.android.material.behavior;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import androidx.activity.j;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.e;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.example.msphone.R;
import com.google.common.collect.c;
import java.util.Iterator;
import java.util.LinkedHashSet;
import p1.a;

/* loaded from: classes.dex */
public class HideBottomViewOnScrollBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {

    /* renamed from: a  reason: collision with root package name */
    public final LinkedHashSet f3000a;

    /* renamed from: b  reason: collision with root package name */
    public int f3001b;

    /* renamed from: c  reason: collision with root package name */
    public int f3002c;

    /* renamed from: d  reason: collision with root package name */
    public TimeInterpolator f3003d;

    /* renamed from: e  reason: collision with root package name */
    public TimeInterpolator f3004e;

    /* renamed from: f  reason: collision with root package name */
    public int f3005f;

    /* renamed from: g  reason: collision with root package name */
    public int f3006g;

    /* renamed from: h  reason: collision with root package name */
    public int f3007h;

    /* renamed from: i  reason: collision with root package name */
    public ViewPropertyAnimator f3008i;

    @RestrictTo({RestrictTo.Scope.f170b})
    /* loaded from: classes.dex */
    public @interface ScrollState {
    }

    public HideBottomViewOnScrollBehavior() {
        this.f3000a = new LinkedHashSet();
        this.f3005f = 0;
        this.f3006g = 2;
        this.f3007h = 0;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean l(CoordinatorLayout coordinatorLayout, View view, int i4) {
        this.f3005f = view.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).bottomMargin;
        this.f3001b = c.K1(view.getContext(), R.attr.motionDurationLong2, 225);
        this.f3002c = c.K1(view.getContext(), R.attr.motionDurationMedium4, 175);
        this.f3003d = c.L1(view.getContext(), R.attr.motionEasingEmphasizedInterpolator, a.f6131d);
        this.f3004e = c.L1(view.getContext(), R.attr.motionEasingEmphasizedInterpolator, a.f6130c);
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void p(CoordinatorLayout coordinatorLayout, View view, int i4, int i5, int i6, int[] iArr) {
        LinkedHashSet linkedHashSet = this.f3000a;
        if (i4 > 0) {
            if (this.f3006g != 1) {
                ViewPropertyAnimator viewPropertyAnimator = this.f3008i;
                if (viewPropertyAnimator != null) {
                    viewPropertyAnimator.cancel();
                    view.clearAnimation();
                }
                this.f3006g = 1;
                Iterator it = linkedHashSet.iterator();
                if (!it.hasNext()) {
                    int i7 = this.f3005f + this.f3007h;
                    this.f3008i = view.animate().translationY(i7).setInterpolator(this.f3004e).setDuration(this.f3002c).setListener(new e(3, this));
                    return;
                }
                j.f(it.next());
                throw null;
            }
        } else if (i4 < 0 && this.f3006g != 2) {
            ViewPropertyAnimator viewPropertyAnimator2 = this.f3008i;
            if (viewPropertyAnimator2 != null) {
                viewPropertyAnimator2.cancel();
                view.clearAnimation();
            }
            this.f3006g = 2;
            Iterator it2 = linkedHashSet.iterator();
            if (!it2.hasNext()) {
                this.f3008i = view.animate().translationY(0).setInterpolator(this.f3003d).setDuration(this.f3001b).setListener(new e(3, this));
                return;
            }
            j.f(it2.next());
            throw null;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean t(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i4, int i5) {
        return i4 == 2;
    }

    public HideBottomViewOnScrollBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3000a = new LinkedHashSet();
        this.f3005f = 0;
        this.f3006g = 2;
        this.f3007h = 0;
    }
}