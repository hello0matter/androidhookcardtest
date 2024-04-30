package com.google.android.material.datepicker;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.util.Calendar;

/* loaded from: classes.dex */
public final class l implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f3348a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a0 f3349b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MaterialCalendar f3350c;

    public /* synthetic */ l(MaterialCalendar materialCalendar, a0 a0Var, int i4) {
        this.f3348a = i4;
        this.f3350c = materialCalendar;
        this.f3349b = a0Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i4 = this.f3348a;
        a0 a0Var = this.f3349b;
        MaterialCalendar materialCalendar = this.f3350c;
        switch (i4) {
            case 0:
                int K0 = ((LinearLayoutManager) materialCalendar.f3261b0.getLayoutManager()).K0() - 1;
                if (K0 >= 0) {
                    Calendar c4 = g0.c(a0Var.f3303c.f3246a.f3290a);
                    c4.add(2, K0);
                    materialCalendar.I(new Month(c4));
                    return;
                }
                return;
            default:
                int J0 = ((LinearLayoutManager) materialCalendar.f3261b0.getLayoutManager()).J0() + 1;
                if (J0 < materialCalendar.f3261b0.getAdapter().a()) {
                    Calendar c5 = g0.c(a0Var.f3303c.f3246a.f3290a);
                    c5.add(2, J0);
                    materialCalendar.I(new Month(c5));
                    return;
                }
                return;
        }
    }
}