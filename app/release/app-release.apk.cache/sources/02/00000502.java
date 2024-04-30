package com.google.android.material.datepicker;

import android.view.View;
import android.widget.AdapterView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class y implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MaterialCalendarGridView f3375a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a0 f3376b;

    public y(a0 a0Var, MaterialCalendarGridView materialCalendarGridView) {
        this.f3376b = a0Var;
        this.f3375a = materialCalendarGridView;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i4, long j4) {
        MaterialCalendarGridView materialCalendarGridView = this.f3375a;
        x a5 = materialCalendarGridView.a();
        if (i4 >= a5.a() && i4 <= a5.c()) {
            r rVar = this.f3376b.f3306f;
            long longValue = materialCalendarGridView.a().getItem(i4).longValue();
            MaterialCalendar materialCalendar = ((o) rVar).f3353a;
            if (materialCalendar.V.f3248c.f(longValue)) {
                materialCalendar.U.i(longValue);
                Iterator it = materialCalendar.S.iterator();
                while (it.hasNext()) {
                    ((b0) it.next()).b(materialCalendar.U.a());
                }
                materialCalendar.f3261b0.getAdapter().f2145a.b();
                RecyclerView recyclerView = materialCalendar.f3260a0;
                if (recyclerView != null) {
                    recyclerView.getAdapter().f2145a.b();
                }
            }
        }
    }
}