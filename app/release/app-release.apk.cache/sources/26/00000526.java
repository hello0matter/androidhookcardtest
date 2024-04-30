package com.google.android.material.internal;

import android.animation.ValueAnimator;
import android.view.View;
import android.widget.TextView;

/* loaded from: classes.dex */
public final class e0 implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f3543a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f3544b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object f3545c;

    public /* synthetic */ e0(int i4, View view, Object obj) {
        this.f3543a = i4;
        this.f3545c = obj;
        this.f3544b = view;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        int i4 = this.f3543a;
        View view = this.f3544b;
        switch (i4) {
            case 0:
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                TextView textView = (TextView) view;
                textView.setScaleX(floatValue);
                textView.setScaleY(floatValue);
                return;
            default:
                view.invalidate();
                return;
        }
    }
}