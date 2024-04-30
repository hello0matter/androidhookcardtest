package com.google.android.material.search;

import android.view.View;
import androidx.recyclerview.widget.o0;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.internal.m0;
import com.google.android.material.internal.n0;
import i0.g2;
import i0.w;

/* loaded from: classes.dex */
public final /* synthetic */ class d implements m0, w {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SearchView f3778a;

    public /* synthetic */ d(SearchView searchView) {
        this.f3778a = searchView;
    }

    @Override // i0.w
    public final g2 i(View view, g2 g2Var) {
        SearchView.e(this.f3778a, g2Var);
        return g2Var;
    }

    @Override // com.google.android.material.internal.m0
    public final g2 s(View view, g2 g2Var, o0 o0Var) {
        int i4;
        int i5;
        MaterialToolbar materialToolbar = this.f3778a.f3748g;
        boolean f4 = n0.f(materialToolbar);
        if (f4) {
            i4 = o0Var.f2199c;
        } else {
            i4 = o0Var.f2197a;
        }
        if (f4) {
            i5 = o0Var.f2197a;
        } else {
            i5 = o0Var.f2199c;
        }
        materialToolbar.setPadding(g2Var.b() + i4, o0Var.f2198b, g2Var.c() + i5, o0Var.f2200d);
        return g2Var;
    }
}