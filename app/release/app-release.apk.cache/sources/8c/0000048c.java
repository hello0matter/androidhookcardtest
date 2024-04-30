package com.google.android.material.appbar;

import android.view.View;
import j0.v;

/* loaded from: classes.dex */
public final class e implements v {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AppBarLayout f2961a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f2962b;

    public e(AppBarLayout appBarLayout, boolean z4) {
        this.f2961a = appBarLayout;
        this.f2962b = z4;
    }

    @Override // j0.v
    public final boolean e(View view) {
        this.f2961a.setExpanded(this.f2962b);
        return true;
    }
}