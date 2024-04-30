package com.google.android.material.bottomappbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

/* loaded from: classes.dex */
public final class d extends com.google.common.collect.c {

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ int f3048q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ BottomAppBar f3049r;

    public d(BottomAppBar bottomAppBar, int i4) {
        this.f3049r = bottomAppBar;
        this.f3048q = i4;
    }

    @Override // com.google.common.collect.c
    public final void p1(FloatingActionButton floatingActionButton) {
        int i4 = BottomAppBar.f3017u0;
        floatingActionButton.setTranslationX(this.f3049r.E(this.f3048q));
        floatingActionButton.l(new c(this), true);
    }
}