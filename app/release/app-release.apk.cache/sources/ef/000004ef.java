package com.google.android.material.datepicker;

import android.view.View;
import com.google.android.material.datepicker.MaterialCalendar;
import java.util.Calendar;

/* loaded from: classes.dex */
public final class h0 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f3330a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ j0 f3331b;

    public h0(j0 j0Var, int i4) {
        this.f3331b = j0Var;
        this.f3330a = i4;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        j0 j0Var = this.f3331b;
        Month l4 = Month.l(this.f3330a, j0Var.f3343c.X.f3291b);
        MaterialCalendar materialCalendar = j0Var.f3343c;
        CalendarConstraints calendarConstraints = materialCalendar.V;
        Month month = calendarConstraints.f3246a;
        Calendar calendar = month.f3290a;
        Calendar calendar2 = l4.f3290a;
        if (calendar2.compareTo(calendar) < 0) {
            l4 = month;
        } else {
            Month month2 = calendarConstraints.f3247b;
            if (calendar2.compareTo(month2.f3290a) > 0) {
                l4 = month2;
            }
        }
        materialCalendar.I(l4);
        materialCalendar.J(MaterialCalendar.CalendarSelector.f3266a);
    }
}