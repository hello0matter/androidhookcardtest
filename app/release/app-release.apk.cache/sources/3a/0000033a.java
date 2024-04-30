package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import c1.l0;
import c1.m0;
import java.util.HashMap;

/* loaded from: classes.dex */
public class ChangeScroll extends Transition {

    /* renamed from: y  reason: collision with root package name */
    public static final String[] f2343y = {"android:changeScroll:x", "android:changeScroll:y"};

    public ChangeScroll(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public static void H(m0 m0Var) {
        HashMap hashMap = m0Var.f2646a;
        View view = m0Var.f2647b;
        hashMap.put("android:changeScroll:x", Integer.valueOf(view.getScrollX()));
        hashMap.put("android:changeScroll:y", Integer.valueOf(view.getScrollY()));
    }

    @Override // androidx.transition.Transition
    public final void d(m0 m0Var) {
        H(m0Var);
    }

    @Override // androidx.transition.Transition
    public final void g(m0 m0Var) {
        H(m0Var);
    }

    @Override // androidx.transition.Transition
    public final Animator k(ViewGroup viewGroup, m0 m0Var, m0 m0Var2) {
        ObjectAnimator objectAnimator;
        ObjectAnimator objectAnimator2 = null;
        if (m0Var == null || m0Var2 == null) {
            return null;
        }
        HashMap hashMap = m0Var.f2646a;
        int intValue = ((Integer) hashMap.get("android:changeScroll:x")).intValue();
        HashMap hashMap2 = m0Var2.f2646a;
        int intValue2 = ((Integer) hashMap2.get("android:changeScroll:x")).intValue();
        int intValue3 = ((Integer) hashMap.get("android:changeScroll:y")).intValue();
        int intValue4 = ((Integer) hashMap2.get("android:changeScroll:y")).intValue();
        View view = m0Var2.f2647b;
        if (intValue != intValue2) {
            view.setScrollX(intValue);
            objectAnimator = ObjectAnimator.ofInt(view, "scrollX", intValue, intValue2);
        } else {
            objectAnimator = null;
        }
        if (intValue3 != intValue4) {
            view.setScrollY(intValue3);
            objectAnimator2 = ObjectAnimator.ofInt(view, "scrollY", intValue3, intValue4);
        }
        boolean z4 = l0.f2643a;
        if (objectAnimator == null) {
            return objectAnimator2;
        }
        if (objectAnimator2 != null) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(objectAnimator, objectAnimator2);
            return animatorSet;
        }
        return objectAnimator;
    }

    @Override // androidx.transition.Transition
    public final String[] p() {
        return f2343y;
    }
}