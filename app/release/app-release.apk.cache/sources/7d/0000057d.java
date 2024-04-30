package com.google.android.material.search;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.search.SearchView;

/* loaded from: classes.dex */
public final class n extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ p f3793a;

    public n(p pVar) {
        this.f3793a = pVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        p pVar = this.f3793a;
        if (!pVar.f3795a.h()) {
            pVar.f3795a.j();
        }
        pVar.f3795a.setTransitionState(SearchView.TransitionState.f3773d);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        p pVar = this.f3793a;
        pVar.f3797c.setVisibility(0);
        pVar.f3795a.setTransitionState(SearchView.TransitionState.f3772c);
    }
}