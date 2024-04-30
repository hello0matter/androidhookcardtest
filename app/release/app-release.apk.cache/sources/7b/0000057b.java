package com.google.android.material.search;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.google.android.material.search.SearchView;

/* loaded from: classes.dex */
public final class l extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ p f3791a;

    public l(p pVar) {
        this.f3791a = pVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        p pVar = this.f3791a;
        if (!pVar.f3795a.h()) {
            pVar.f3795a.j();
        }
        pVar.f3795a.setTransitionState(SearchView.TransitionState.f3773d);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        p pVar = this.f3791a;
        pVar.f3797c.setVisibility(0);
        SearchBar searchBar = pVar.f3809o;
        searchBar.W.getClass();
        View centerView = searchBar.getCenterView();
        if (centerView != null) {
            centerView.setAlpha(0.0f);
        }
    }
}