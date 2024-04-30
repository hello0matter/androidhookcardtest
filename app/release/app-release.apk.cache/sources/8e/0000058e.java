package com.google.android.material.slider;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewOverlay;
import c1.o0;
import com.google.android.material.internal.n0;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class b extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BaseSlider f3879a;

    public b(BaseSlider baseSlider) {
        this.f3879a = baseSlider;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        BaseSlider baseSlider = this.f3879a;
        o0 e4 = n0.e(baseSlider);
        Iterator it = baseSlider.f3853k.iterator();
        while (it.hasNext()) {
            q2.a aVar = (q2.a) it.next();
            int i4 = e4.f2662a;
            ViewOverlay viewOverlay = e4.f2663b;
            switch (i4) {
                case 0:
                    viewOverlay.remove(aVar);
                    break;
                default:
                    viewOverlay.remove(aVar);
                    break;
            }
        }
    }
}