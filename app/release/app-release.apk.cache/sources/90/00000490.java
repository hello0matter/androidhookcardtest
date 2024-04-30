package com.google.android.material.appbar;

import android.animation.ValueAnimator;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.textfield.TextInputLayout;

/* loaded from: classes.dex */
public final class i implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f2963a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f2964b;

    public /* synthetic */ i(int i4, Object obj) {
        this.f2963a = i4;
        this.f2964b = obj;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        int i4 = this.f2963a;
        Object obj = this.f2964b;
        switch (i4) {
            case 0:
                ((CollapsingToolbarLayout) obj).setScrimAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
                return;
            case 1:
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                l2.j jVar = ((BottomSheetBehavior) obj).f3080i;
                if (jVar != null) {
                    jVar.p(floatValue);
                    return;
                }
                return;
            case 2:
                ((TabLayout) obj).scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
                return;
            default:
                ((TextInputLayout) obj).f4001u0.p(((Float) valueAnimator.getAnimatedValue()).floatValue());
                return;
        }
    }
}