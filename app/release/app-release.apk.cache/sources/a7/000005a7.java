package com.google.android.material.tabs;

import android.view.View;
import com.google.android.material.tabs.TabLayout;

/* loaded from: classes.dex */
public final class c implements View.OnLayoutChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ View f3948a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TabLayout.TabView f3949b;

    public c(TabLayout.TabView tabView, View view) {
        this.f3949b = tabView;
        this.f3948a = view;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View view, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
        View view2 = this.f3948a;
        if (view2.getVisibility() == 0) {
            int i12 = TabLayout.TabView.f3928l;
            this.f3949b.c(view2);
        }
    }
}