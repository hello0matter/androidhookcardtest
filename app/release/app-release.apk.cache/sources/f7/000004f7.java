package com.google.android.material.datepicker;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.i1;

/* loaded from: classes.dex */
public final class n extends LinearLayoutManager {
    public final /* synthetic */ int E;
    public final /* synthetic */ MaterialCalendar F;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(MaterialCalendar materialCalendar, int i4, int i5) {
        super(i4);
        this.F = materialCalendar;
        this.E = i5;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.u0
    public final void w0(RecyclerView recyclerView, int i4) {
        androidx.recyclerview.widget.e0 e0Var = new androidx.recyclerview.widget.e0(this, recyclerView.getContext(), 2);
        e0Var.f2111a = i4;
        x0(e0Var);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final void z0(i1 i1Var, int[] iArr) {
        int i4 = this.E;
        MaterialCalendar materialCalendar = this.F;
        if (i4 == 0) {
            iArr[0] = materialCalendar.f3261b0.getWidth();
            iArr[1] = materialCalendar.f3261b0.getWidth();
            return;
        }
        iArr[0] = materialCalendar.f3261b0.getHeight();
        iArr[1] = materialCalendar.f3261b0.getHeight();
    }
}