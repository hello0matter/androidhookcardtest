package com.google.android.material.navigation;

import android.animation.ValueAnimator;

/* loaded from: classes.dex */
public final class b implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ float f3692a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ NavigationBarItemView f3693b;

    public b(NavigationBarItemView navigationBarItemView, float f4) {
        this.f3693b = navigationBarItemView;
        this.f3692a = f4;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        int[] iArr = NavigationBarItemView.G;
        this.f3693b.e(floatValue, this.f3692a);
    }
}