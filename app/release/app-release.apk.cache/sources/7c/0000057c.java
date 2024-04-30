package com.google.android.material.search;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.search.SearchView;

/* loaded from: classes.dex */
public final class m extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ p f3792a;

    public m(p pVar) {
        this.f3792a = pVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        p pVar = this.f3792a;
        pVar.f3797c.setVisibility(8);
        if (!pVar.f3795a.h()) {
            pVar.f3795a.f();
        }
        pVar.f3795a.setTransitionState(SearchView.TransitionState.f3771b);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        this.f3792a.f3795a.setTransitionState(SearchView.TransitionState.f3770a);
    }
}