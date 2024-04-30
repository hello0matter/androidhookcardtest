package androidx.transition;

import a0.t;
import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.n;
import c1.c0;
import c1.j;
import c1.m0;
import c1.p0;

/* loaded from: classes.dex */
public class Fade extends Visibility {
    public Fade(int i4) {
        L(i4);
    }

    @Override // androidx.transition.Visibility
    public final Animator J(ViewGroup viewGroup, View view, m0 m0Var, m0 m0Var2) {
        float f4;
        Float f5;
        float f6 = 0.0f;
        if (m0Var != null && (f5 = (Float) m0Var.f2646a.get("android:fade:transitionAlpha")) != null) {
            f4 = f5.floatValue();
        } else {
            f4 = 0.0f;
        }
        if (f4 != 1.0f) {
            f6 = f4;
        }
        return M(view, f6, 1.0f);
    }

    @Override // androidx.transition.Visibility
    public final Animator K(ViewGroup viewGroup, View view, m0 m0Var) {
        float f4;
        Float f5;
        p0.f2666a.getClass();
        if (m0Var != null && (f5 = (Float) m0Var.f2646a.get("android:fade:transitionAlpha")) != null) {
            f4 = f5.floatValue();
        } else {
            f4 = 1.0f;
        }
        return M(view, f4, 0.0f);
    }

    public final ObjectAnimator M(View view, float f4, float f5) {
        if (f4 == f5) {
            return null;
        }
        p0.b(view, f4);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, p0.f2667b, f5);
        ofFloat.addListener(new n(view));
        a(new j(1, this, view));
        return ofFloat;
    }

    @Override // androidx.transition.Visibility, androidx.transition.Transition
    public final void g(m0 m0Var) {
        Visibility.H(m0Var);
        m0Var.f2646a.put("android:fade:transitionAlpha", Float.valueOf(p0.f2666a.y(m0Var.f2647b)));
    }

    @SuppressLint({"RestrictedApi"})
    public Fade(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c0.f2582d);
        L(t.b(obtainStyledAttributes, (XmlResourceParser) attributeSet, "fadingMode", 0, this.f2375y));
        obtainStyledAttributes.recycle();
    }
}