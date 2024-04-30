package com.google.android.material.datepicker;

import android.content.Context;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.msphone.R;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;

/* loaded from: classes.dex */
public final class x extends BaseAdapter {

    /* renamed from: g  reason: collision with root package name */
    public static final int f3367g = g0.g(null).getMaximum(4);

    /* renamed from: h  reason: collision with root package name */
    public static final int f3368h = (g0.g(null).getMaximum(7) + g0.g(null).getMaximum(5)) - 1;

    /* renamed from: a  reason: collision with root package name */
    public final Month f3369a;

    /* renamed from: b  reason: collision with root package name */
    public final DateSelector f3370b;

    /* renamed from: c  reason: collision with root package name */
    public Collection f3371c;

    /* renamed from: d  reason: collision with root package name */
    public c f3372d;

    /* renamed from: e  reason: collision with root package name */
    public final CalendarConstraints f3373e;

    /* renamed from: f  reason: collision with root package name */
    public final DayViewDecorator f3374f;

    public x(Month month, DateSelector dateSelector, CalendarConstraints calendarConstraints, DayViewDecorator dayViewDecorator) {
        this.f3369a = month;
        this.f3370b = dateSelector;
        this.f3373e = calendarConstraints;
        this.f3374f = dayViewDecorator;
        this.f3371c = dateSelector.k();
    }

    public final int a() {
        int i4 = this.f3373e.f3250e;
        Month month = this.f3369a;
        Calendar calendar = month.f3290a;
        int i5 = calendar.get(7);
        if (i4 <= 0) {
            i4 = calendar.getFirstDayOfWeek();
        }
        int i6 = i5 - i4;
        if (i6 < 0) {
            return i6 + month.f3293d;
        }
        return i6;
    }

    @Override // android.widget.Adapter
    /* renamed from: b */
    public final Long getItem(int i4) {
        if (i4 >= a() && i4 <= c()) {
            Calendar c4 = g0.c(this.f3369a.f3290a);
            c4.set(5, (i4 - a()) + 1);
            return Long.valueOf(c4.getTimeInMillis());
        }
        return null;
    }

    public final int c() {
        return (a() + this.f3369a.f3294e) - 1;
    }

    public final void d(TextView textView, long j4, int i4) {
        boolean z4;
        boolean z5;
        boolean z6;
        String format;
        androidx.appcompat.widget.w wVar;
        if (textView == null) {
            return;
        }
        Context context = textView.getContext();
        boolean z7 = false;
        if (g0.f().getTimeInMillis() == j4) {
            z4 = true;
        } else {
            z4 = false;
        }
        DateSelector dateSelector = this.f3370b;
        Iterator it = dateSelector.e().iterator();
        while (true) {
            if (it.hasNext()) {
                Object obj = ((h0.c) it.next()).f4797a;
                if (obj != null && ((Long) obj).longValue() == j4) {
                    z5 = true;
                    break;
                }
            } else {
                z5 = false;
                break;
            }
        }
        Iterator it2 = dateSelector.e().iterator();
        while (true) {
            if (it2.hasNext()) {
                Object obj2 = ((h0.c) it2.next()).f4798b;
                if (obj2 != null && ((Long) obj2).longValue() == j4) {
                    z6 = true;
                    break;
                }
            } else {
                z6 = false;
                break;
            }
        }
        Calendar f4 = g0.f();
        Calendar g4 = g0.g(null);
        g4.setTimeInMillis(j4);
        if (f4.get(1) == g4.get(1)) {
            format = g0.b("MMMMEEEEd", Locale.getDefault()).format(new Date(j4));
        } else {
            format = g0.b("yMMMMEEEEd", Locale.getDefault()).format(new Date(j4));
        }
        if (z4) {
            format = String.format(context.getString(R.string.mtrl_picker_today_description), format);
        }
        if (z5) {
            format = String.format(context.getString(R.string.mtrl_picker_start_date_description), format);
        } else if (z6) {
            format = String.format(context.getString(R.string.mtrl_picker_end_date_description), format);
        }
        textView.setContentDescription(format);
        if (this.f3373e.f3248c.f(j4)) {
            textView.setEnabled(true);
            Iterator it3 = dateSelector.k().iterator();
            while (true) {
                if (!it3.hasNext()) {
                    break;
                }
                if (g0.a(j4) == g0.a(((Long) it3.next()).longValue())) {
                    z7 = true;
                    break;
                }
            }
            textView.setSelected(z7);
            if (z7) {
                wVar = this.f3372d.f3312b;
            } else if (g0.f().getTimeInMillis() == j4) {
                wVar = this.f3372d.f3313c;
            } else {
                wVar = this.f3372d.f3311a;
            }
        } else {
            textView.setEnabled(false);
            wVar = this.f3372d.f3317g;
        }
        if (this.f3374f != null && i4 != -1) {
            int i5 = this.f3369a.f3292c;
            wVar.k(textView);
            textView.setCompoundDrawables(null, null, null, null);
            textView.setContentDescription(format);
            return;
        }
        wVar.k(textView);
    }

    public final void e(MaterialCalendarGridView materialCalendarGridView, long j4) {
        Month m4 = Month.m(j4);
        Month month = this.f3369a;
        if (m4.equals(month)) {
            Calendar c4 = g0.c(month.f3290a);
            c4.setTimeInMillis(j4);
            int i4 = c4.get(5);
            d((TextView) materialCalendarGridView.getChildAt((materialCalendarGridView.a().a() + (i4 - 1)) - materialCalendarGridView.getFirstVisiblePosition()), j4, i4);
        }
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return f3368h;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i4) {
        return i4 / this.f3369a.f3293d;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x006d  */
    @Override // android.widget.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.view.View getView(int r6, android.view.View r7, android.view.ViewGroup r8) {
        /*
            r5 = this;
            android.content.Context r0 = r8.getContext()
            com.google.android.material.datepicker.c r1 = r5.f3372d
            if (r1 != 0) goto Lf
            com.google.android.material.datepicker.c r1 = new com.google.android.material.datepicker.c
            r1.<init>(r0)
            r5.f3372d = r1
        Lf:
            r0 = r7
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1 = 0
            if (r7 != 0) goto L27
            android.content.Context r7 = r8.getContext()
            android.view.LayoutInflater r7 = android.view.LayoutInflater.from(r7)
            r0 = 2131427400(0x7f0b0048, float:1.8476415E38)
            android.view.View r7 = r7.inflate(r0, r8, r1)
            r0 = r7
            android.widget.TextView r0 = (android.widget.TextView) r0
        L27:
            int r7 = r5.a()
            int r7 = r6 - r7
            if (r7 < 0) goto L5d
            com.google.android.material.datepicker.Month r8 = r5.f3369a
            int r2 = r8.f3294e
            if (r7 < r2) goto L36
            goto L5d
        L36:
            r2 = 1
            int r7 = r7 + r2
            r0.setTag(r8)
            android.content.res.Resources r8 = r0.getResources()
            android.content.res.Configuration r8 = r8.getConfiguration()
            java.util.Locale r8 = r8.locale
            java.lang.Integer r3 = java.lang.Integer.valueOf(r7)
            java.lang.Object[] r3 = new java.lang.Object[]{r3}
            java.lang.String r4 = "%d"
            java.lang.String r8 = java.lang.String.format(r8, r4, r3)
            r0.setText(r8)
            r0.setVisibility(r1)
            r0.setEnabled(r2)
            goto L66
        L5d:
            r7 = 8
            r0.setVisibility(r7)
            r0.setEnabled(r1)
            r7 = -1
        L66:
            java.lang.Long r6 = r5.getItem(r6)
            if (r6 != 0) goto L6d
            goto L74
        L6d:
            long r1 = r6.longValue()
            r5.d(r0, r1, r7)
        L74:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.datepicker.x.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final boolean hasStableIds() {
        return true;
    }
}