package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* loaded from: classes.dex */
public final class b extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f4016a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ c f4017b;

    public /* synthetic */ b(c cVar, int i4) {
        this.f4016a = i4;
        this.f4017b = cVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        switch (this.f4016a) {
            case 1:
                this.f4017b.f4072b.h(false);
                return;
            default:
                super.onAnimationEnd(animator);
                return;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        switch (this.f4016a) {
            case 0:
                this.f4017b.f4072b.h(true);
                return;
            default:
                super.onAnimationStart(animator);
                return;
        }
    }
}