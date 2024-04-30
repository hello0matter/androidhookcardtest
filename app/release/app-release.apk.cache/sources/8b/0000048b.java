package com.google.android.material.appbar;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import j0.v;

/* loaded from: classes.dex */
public final class d implements v {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CoordinatorLayout f2956a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AppBarLayout f2957b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View f2958c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f2959d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ AppBarLayout.BaseBehavior f2960e;

    public d(AppBarLayout.BaseBehavior baseBehavior, CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i4) {
        this.f2960e = baseBehavior;
        this.f2956a = coordinatorLayout;
        this.f2957b = appBarLayout;
        this.f2958c = view;
        this.f2959d = i4;
    }

    @Override // j0.v
    public final boolean e(View view) {
        View view2 = this.f2958c;
        int i4 = this.f2959d;
        this.f2960e.I(this.f2956a, this.f2957b, view2, i4, new int[]{0, 0});
        return true;
    }
}