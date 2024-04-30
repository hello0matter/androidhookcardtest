package com.google.android.material.search;

import android.view.View;

/* loaded from: classes.dex */
public final /* synthetic */ class e implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f3779a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SearchView f3780b;

    public /* synthetic */ e(SearchView searchView, int i4) {
        this.f3779a = i4;
        this.f3780b = searchView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i4 = this.f3779a;
        SearchView searchView = this.f3780b;
        switch (i4) {
            case 0:
                int i5 = SearchView.D;
                searchView.l();
                return;
            case 1:
                int i6 = SearchView.D;
                searchView.g();
                return;
            default:
                searchView.f3751j.setText("");
                searchView.j();
                return;
        }
    }
}