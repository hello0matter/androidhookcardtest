package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.transition.Transition;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class f0 extends Transition {
    @Override // androidx.transition.Transition
    public final void d(c1.m0 m0Var) {
        View view = m0Var.f2647b;
        if (view instanceof TextView) {
            m0Var.f2646a.put("android:textscale:scale", Float.valueOf(((TextView) view).getScaleX()));
        }
    }

    @Override // androidx.transition.Transition
    public final void g(c1.m0 m0Var) {
        View view = m0Var.f2647b;
        if (view instanceof TextView) {
            m0Var.f2646a.put("android:textscale:scale", Float.valueOf(((TextView) view).getScaleX()));
        }
    }

    @Override // androidx.transition.Transition
    public final Animator k(ViewGroup viewGroup, c1.m0 m0Var, c1.m0 m0Var2) {
        float f4;
        if (m0Var != null && m0Var2 != null && (m0Var.f2647b instanceof TextView)) {
            View view = m0Var2.f2647b;
            if (view instanceof TextView) {
                TextView textView = (TextView) view;
                HashMap hashMap = m0Var.f2646a;
                HashMap hashMap2 = m0Var2.f2646a;
                float f5 = 1.0f;
                if (hashMap.get("android:textscale:scale") != null) {
                    f4 = ((Float) hashMap.get("android:textscale:scale")).floatValue();
                } else {
                    f4 = 1.0f;
                }
                if (hashMap2.get("android:textscale:scale") != null) {
                    f5 = ((Float) hashMap2.get("android:textscale:scale")).floatValue();
                }
                if (f4 == f5) {
                    return null;
                }
                ValueAnimator ofFloat = ValueAnimator.ofFloat(f4, f5);
                ofFloat.addUpdateListener(new e0(0, textView, this));
                return ofFloat;
            }
        }
        return null;
    }
}