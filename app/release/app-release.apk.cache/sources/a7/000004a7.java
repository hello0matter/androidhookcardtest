package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import androidx.appcompat.widget.ActionMenuView;

/* loaded from: classes.dex */
public final class e extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public boolean f3050a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ActionMenuView f3051b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f3052c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ boolean f3053d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ BottomAppBar f3054e;

    public e(BottomAppBar bottomAppBar, ActionMenuView actionMenuView, int i4, boolean z4) {
        this.f3054e = bottomAppBar;
        this.f3051b = actionMenuView;
        this.f3052c = i4;
        this.f3053d = z4;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        this.f3050a = true;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        boolean z4;
        if (!this.f3050a) {
            BottomAppBar bottomAppBar = this.f3054e;
            int i4 = bottomAppBar.f3029l0;
            if (i4 != 0) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (i4 != 0) {
                bottomAppBar.f3029l0 = 0;
                bottomAppBar.getMenu().clear();
                bottomAppBar.n(i4);
            }
            bottomAppBar.K(this.f3051b, this.f3052c, this.f3053d, z4);
        }
    }
}