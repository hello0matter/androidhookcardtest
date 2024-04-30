package com.google.android.material.search;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.search.SearchView;

/* loaded from: classes.dex */
public final class o extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ p f3794a;

    public o(p pVar) {
        this.f3794a = pVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        p pVar = this.f3794a;
        pVar.f3797c.setVisibility(8);
        if (!pVar.f3795a.h()) {
            pVar.f3795a.f();
        }
        pVar.f3795a.setTransitionState(SearchView.TransitionState.f3771b);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        this.f3794a.f3795a.setTransitionState(SearchView.TransitionState.f3770a);
    }
}