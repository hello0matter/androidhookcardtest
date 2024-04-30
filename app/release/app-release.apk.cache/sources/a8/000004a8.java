package com.google.android.material.bottomappbar;

import androidx.appcompat.widget.ActionMenuView;

/* loaded from: classes.dex */
public final class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ActionMenuView f3055a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f3056b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f3057c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ BottomAppBar f3058d;

    public f(BottomAppBar bottomAppBar, ActionMenuView actionMenuView, int i4, boolean z4) {
        this.f3058d = bottomAppBar;
        this.f3055a = actionMenuView;
        this.f3056b = i4;
        this.f3057c = z4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i4 = this.f3056b;
        boolean z4 = this.f3057c;
        BottomAppBar bottomAppBar = this.f3058d;
        ActionMenuView actionMenuView = this.f3055a;
        actionMenuView.setTranslationX(bottomAppBar.D(actionMenuView, i4, z4));
    }
}