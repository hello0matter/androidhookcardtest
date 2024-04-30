package com.google.android.material.internal;

import android.animation.ValueAnimator;
import android.view.View;
import androidx.annotation.VisibleForTesting;

/* loaded from: classes.dex */
public final class k implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final j f3558a;

    /* renamed from: b  reason: collision with root package name */
    public final View[] f3559b;

    public k(i1.b bVar, View... viewArr) {
        this.f3558a = bVar;
        this.f3559b = viewArr;
    }

    public static k a(View... viewArr) {
        return new k(new i1.b(3), viewArr);
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        View[] viewArr;
        for (View view : this.f3559b) {
            switch (((i1.b) this.f3558a).f5020a) {
                case 2:
                    view.setTranslationX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    break;
                case VisibleForTesting.PACKAGE_PRIVATE /* 3 */:
                    view.setTranslationY(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    break;
                case VisibleForTesting.PROTECTED /* 4 */:
                    Float f4 = (Float) valueAnimator.getAnimatedValue();
                    view.setScaleX(f4.floatValue());
                    view.setScaleY(f4.floatValue());
                    break;
                default:
                    view.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    break;
            }
        }
    }
}