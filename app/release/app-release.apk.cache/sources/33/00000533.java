package com.google.android.material.internal;

import android.view.SubMenu;

/* loaded from: classes.dex */
public final class l extends g.p {
    @Override // g.p, android.view.Menu
    public final SubMenu addSubMenu(int i4, int i5, int i6, CharSequence charSequence) {
        g.r a5 = a(i4, i5, i6, charSequence);
        g.j0 j0Var = new g.j0(this.f4695a, this, a5);
        a5.f4736o = j0Var;
        j0Var.setHeaderTitle(a5.f4726e);
        return j0Var;
    }
}