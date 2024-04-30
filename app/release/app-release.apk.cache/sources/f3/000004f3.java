package com.google.android.material.datepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.l1;
import com.example.msphone.R;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Locale;

/* loaded from: classes.dex */
public final class j0 extends androidx.recyclerview.widget.j0 {

    /* renamed from: c  reason: collision with root package name */
    public final MaterialCalendar f3343c;

    public j0(MaterialCalendar materialCalendar) {
        this.f3343c = materialCalendar;
    }

    @Override // androidx.recyclerview.widget.j0
    public final int a() {
        return this.f3343c.V.f3251f;
    }

    @Override // androidx.recyclerview.widget.j0
    public final void d(l1 l1Var, int i4) {
        String format;
        androidx.appcompat.widget.w wVar;
        MaterialCalendar materialCalendar = this.f3343c;
        int i5 = materialCalendar.V.f3246a.f3292c + i4;
        String format2 = String.format(Locale.getDefault(), "%d", Integer.valueOf(i5));
        TextView textView = ((i0) l1Var).f3340t;
        textView.setText(format2);
        Context context = textView.getContext();
        if (g0.f().get(1) == i5) {
            format = String.format(context.getString(R.string.mtrl_picker_navigate_to_current_year_description), Integer.valueOf(i5));
        } else {
            format = String.format(context.getString(R.string.mtrl_picker_navigate_to_year_description), Integer.valueOf(i5));
        }
        textView.setContentDescription(format);
        c cVar = materialCalendar.Z;
        Calendar f4 = g0.f();
        if (f4.get(1) == i5) {
            wVar = cVar.f3316f;
        } else {
            wVar = cVar.f3314d;
        }
        Iterator it = materialCalendar.U.k().iterator();
        while (it.hasNext()) {
            f4.setTimeInMillis(((Long) it.next()).longValue());
            if (f4.get(1) == i5) {
                wVar = cVar.f3315e;
            }
        }
        wVar.k(textView);
        textView.setOnClickListener(new h0(this, i5));
    }

    @Override // androidx.recyclerview.widget.j0
    public final l1 e(RecyclerView recyclerView, int i4) {
        return new i0((TextView) LayoutInflater.from(recyclerView.getContext()).inflate(R.layout.mtrl_calendar_year, (ViewGroup) recyclerView, false));
    }
}