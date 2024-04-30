package com.google.android.material.datepicker;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.y0;
import com.google.android.material.button.MaterialButton;
import java.util.Calendar;

/* loaded from: classes.dex */
public final class q extends y0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a0 f3357a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MaterialButton f3358b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MaterialCalendar f3359c;

    public q(MaterialCalendar materialCalendar, a0 a0Var, MaterialButton materialButton) {
        this.f3359c = materialCalendar;
        this.f3357a = a0Var;
        this.f3358b = materialButton;
    }

    @Override // androidx.recyclerview.widget.y0
    public final void a(int i4, RecyclerView recyclerView) {
        if (i4 == 0) {
            recyclerView.announceForAccessibility(this.f3358b.getText());
        }
    }

    @Override // androidx.recyclerview.widget.y0
    public final void b(RecyclerView recyclerView, int i4, int i5) {
        int K0;
        MaterialCalendar materialCalendar = this.f3359c;
        if (i4 < 0) {
            K0 = ((LinearLayoutManager) materialCalendar.f3261b0.getLayoutManager()).J0();
        } else {
            K0 = ((LinearLayoutManager) materialCalendar.f3261b0.getLayoutManager()).K0();
        }
        a0 a0Var = this.f3357a;
        Calendar c4 = g0.c(a0Var.f3303c.f3246a.f3290a);
        c4.add(2, K0);
        materialCalendar.X = new Month(c4);
        Calendar c5 = g0.c(a0Var.f3303c.f3246a.f3290a);
        c5.add(2, K0);
        this.f3358b.setText(new Month(c5).n());
    }
}