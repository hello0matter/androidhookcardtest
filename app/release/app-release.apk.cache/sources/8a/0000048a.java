package com.google.android.material.appbar;

import android.view.View;
import android.widget.ScrollView;
import com.google.android.material.appbar.AppBarLayout;

/* loaded from: classes.dex */
public final class c extends i0.c {

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ AppBarLayout.BaseBehavior f2955d;

    public c(AppBarLayout.BaseBehavior baseBehavior) {
        this.f2955d = baseBehavior;
    }

    @Override // i0.c
    public final void d(View view, j0.h hVar) {
        this.f4912a.onInitializeAccessibilityNodeInfo(view, hVar.f5093a);
        hVar.j(this.f2955d.f2897o);
        hVar.g(ScrollView.class.getName());
    }
}