package com.google.android.material.slider;

import android.animation.ValueAnimator;
import i0.g0;
import i0.y0;
import java.util.Iterator;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class a implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BaseSlider f3878a;

    public a(BaseSlider baseSlider) {
        this.f3878a = baseSlider;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        BaseSlider baseSlider = this.f3878a;
        Iterator it = baseSlider.f3853k.iterator();
        while (it.hasNext()) {
            q2.a aVar = (q2.a) it.next();
            aVar.L = 1.2f;
            aVar.J = floatValue;
            aVar.K = floatValue;
            aVar.M = p1.a.b(0.0f, 1.0f, 0.19f, 1.0f, floatValue);
            aVar.invalidateSelf();
        }
        WeakHashMap weakHashMap = y0.f4999a;
        g0.k(baseSlider);
    }
}