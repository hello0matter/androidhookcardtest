package com.google.android.material.datepicker;

import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.l1;
import com.example.msphone.R;
import java.util.Calendar;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class a0 extends androidx.recyclerview.widget.j0 {

    /* renamed from: c  reason: collision with root package name */
    public final CalendarConstraints f3303c;

    /* renamed from: d  reason: collision with root package name */
    public final DateSelector f3304d;

    /* renamed from: e  reason: collision with root package name */
    public final DayViewDecorator f3305e;

    /* renamed from: f  reason: collision with root package name */
    public final r f3306f;

    /* renamed from: g  reason: collision with root package name */
    public final int f3307g;

    public a0(ContextThemeWrapper contextThemeWrapper, DateSelector dateSelector, CalendarConstraints calendarConstraints, DayViewDecorator dayViewDecorator, o oVar) {
        int i4;
        Month month = calendarConstraints.f3246a;
        Month month2 = calendarConstraints.f3249d;
        if (month.f3290a.compareTo(month2.f3290a) <= 0) {
            if (month2.f3290a.compareTo(calendarConstraints.f3247b.f3290a) <= 0) {
                int i5 = x.f3367g;
                int i6 = MaterialCalendar.f3259g0;
                int dimensionPixelSize = contextThemeWrapper.getResources().getDimensionPixelSize(R.dimen.mtrl_calendar_day_height) * i5;
                if (MaterialDatePicker.L(contextThemeWrapper, 16843277)) {
                    i4 = contextThemeWrapper.getResources().getDimensionPixelSize(R.dimen.mtrl_calendar_day_height);
                } else {
                    i4 = 0;
                }
                this.f3307g = dimensionPixelSize + i4;
                this.f3303c = calendarConstraints;
                this.f3304d = dateSelector;
                this.f3305e = dayViewDecorator;
                this.f3306f = oVar;
                if (!this.f2145a.a()) {
                    this.f2146b = true;
                    return;
                }
                throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
            }
            throw new IllegalArgumentException("currentPage cannot be after lastPage");
        }
        throw new IllegalArgumentException("firstPage cannot be after currentPage");
    }

    @Override // androidx.recyclerview.widget.j0
    public final int a() {
        return this.f3303c.f3252g;
    }

    @Override // androidx.recyclerview.widget.j0
    public final long b(int i4) {
        Calendar c4 = g0.c(this.f3303c.f3246a.f3290a);
        c4.add(2, i4);
        return new Month(c4).f3290a.getTimeInMillis();
    }

    @Override // androidx.recyclerview.widget.j0
    public final void d(l1 l1Var, int i4) {
        z zVar = (z) l1Var;
        CalendarConstraints calendarConstraints = this.f3303c;
        Calendar c4 = g0.c(calendarConstraints.f3246a.f3290a);
        c4.add(2, i4);
        Month month = new Month(c4);
        zVar.f3377t.setText(month.n());
        MaterialCalendarGridView materialCalendarGridView = (MaterialCalendarGridView) zVar.f3378u.findViewById(R.id.month_grid);
        if (materialCalendarGridView.a() != null && month.equals(materialCalendarGridView.a().f3369a)) {
            materialCalendarGridView.invalidate();
            x a5 = materialCalendarGridView.a();
            for (Long l4 : a5.f3371c) {
                a5.e(materialCalendarGridView, l4.longValue());
            }
            DateSelector dateSelector = a5.f3370b;
            if (dateSelector != null) {
                Iterator it = dateSelector.k().iterator();
                while (it.hasNext()) {
                    a5.e(materialCalendarGridView, ((Long) it.next()).longValue());
                }
                a5.f3371c = dateSelector.k();
            }
        } else {
            x xVar = new x(month, this.f3304d, calendarConstraints, this.f3305e);
            materialCalendarGridView.setNumColumns(month.f3293d);
            materialCalendarGridView.setAdapter((ListAdapter) xVar);
        }
        materialCalendarGridView.setOnItemClickListener(new y(this, materialCalendarGridView));
    }

    @Override // androidx.recyclerview.widget.j0
    public final l1 e(RecyclerView recyclerView, int i4) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(recyclerView.getContext()).inflate(R.layout.mtrl_calendar_month_labeled, (ViewGroup) recyclerView, false);
        if (MaterialDatePicker.L(recyclerView.getContext(), 16843277)) {
            linearLayout.setLayoutParams(new RecyclerView.LayoutParams(-1, this.f3307g));
            return new z(linearLayout, true);
        }
        return new z(linearLayout, false);
    }
}