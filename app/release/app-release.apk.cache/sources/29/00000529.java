package com.google.android.material.internal;

import android.animation.ValueAnimator;
import android.view.View;
import androidx.appcompat.widget.ActionMenuView;

/* loaded from: classes.dex */
public final class g implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final View f3550a;

    /* renamed from: b  reason: collision with root package name */
    public final View f3551b;

    /* renamed from: c  reason: collision with root package name */
    public final float[] f3552c = new float[2];

    public g(ActionMenuView actionMenuView, ActionMenuView actionMenuView2) {
        this.f3550a = actionMenuView;
        this.f3551b = actionMenuView2;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        float[] fArr = this.f3552c;
        com.google.common.collect.c.t(floatValue, fArr);
        View view = this.f3550a;
        if (view != null) {
            view.setAlpha(fArr[0]);
        }
        View view2 = this.f3551b;
        if (view2 != null) {
            view2.setAlpha(fArr[1]);
        }
    }
}