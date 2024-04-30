package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.view.View;
import androidx.recyclerview.widget.o0;
import com.google.android.material.internal.m0;
import i0.g2;

/* loaded from: classes.dex */
public final class b implements m0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BottomAppBar f3046a;

    @Override // com.google.android.material.internal.m0
    public final g2 s(View view, g2 g2Var, o0 o0Var) {
        boolean z4;
        BottomAppBar bottomAppBar = this.f3046a;
        if (bottomAppBar.f3026i0) {
            bottomAppBar.f3033p0 = g2Var.a();
        }
        boolean z5 = true;
        boolean z6 = false;
        if (bottomAppBar.f3027j0) {
            if (bottomAppBar.f3035r0 != g2Var.b()) {
                z4 = true;
            } else {
                z4 = false;
            }
            bottomAppBar.f3035r0 = g2Var.b();
        } else {
            z4 = false;
        }
        if (bottomAppBar.f3028k0) {
            if (bottomAppBar.f3034q0 == g2Var.c()) {
                z5 = false;
            }
            bottomAppBar.f3034q0 = g2Var.c();
            z6 = z5;
        }
        if (z4 || z6) {
            Animator animator = bottomAppBar.W;
            if (animator != null) {
                animator.cancel();
            }
            Animator animator2 = bottomAppBar.V;
            if (animator2 != null) {
                animator2.cancel();
            }
            bottomAppBar.I();
            bottomAppBar.H();
        }
        return g2Var;
    }
}