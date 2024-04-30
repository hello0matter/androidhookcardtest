package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/* loaded from: classes.dex */
public final class a extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f3044a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BottomAppBar f3045b;

    public /* synthetic */ a(BottomAppBar bottomAppBar, int i4) {
        this.f3044a = i4;
        this.f3045b = bottomAppBar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        int i4 = this.f3044a;
        BottomAppBar bottomAppBar = this.f3045b;
        switch (i4) {
            case 1:
                int i5 = BottomAppBar.f3017u0;
                bottomAppBar.getClass();
                bottomAppBar.V = null;
                return;
            case 2:
                int i6 = BottomAppBar.f3017u0;
                bottomAppBar.getClass();
                bottomAppBar.f3030m0 = false;
                bottomAppBar.W = null;
                return;
            default:
                super.onAnimationEnd(animator);
                return;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        float fabTranslationX;
        int i4 = this.f3044a;
        BottomAppBar bottomAppBar = this.f3045b;
        switch (i4) {
            case 0:
                if (!bottomAppBar.f3030m0) {
                    bottomAppBar.G(bottomAppBar.f3018a0, bottomAppBar.f3031n0);
                    return;
                }
                return;
            case 1:
                int i5 = BottomAppBar.f3017u0;
                bottomAppBar.getClass();
                return;
            case 2:
                int i6 = BottomAppBar.f3017u0;
                bottomAppBar.getClass();
                return;
            default:
                bottomAppBar.f3036s0.onAnimationStart(animator);
                FloatingActionButton B = bottomAppBar.B();
                if (B != null) {
                    fabTranslationX = bottomAppBar.getFabTranslationX();
                    B.setTranslationX(fabTranslationX);
                    return;
                }
                return;
        }
    }
}