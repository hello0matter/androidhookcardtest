package com.google.android.material.datepicker;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.msphone.R;
import java.util.Calendar;
import java.util.Locale;

/* loaded from: classes.dex */
public final class k extends BaseAdapter {

    /* renamed from: d  reason: collision with root package name */
    public static final int f3344d;

    /* renamed from: a  reason: collision with root package name */
    public final Calendar f3345a;

    /* renamed from: b  reason: collision with root package name */
    public final int f3346b;

    /* renamed from: c  reason: collision with root package name */
    public final int f3347c;

    static {
        f3344d = Build.VERSION.SDK_INT >= 26 ? 4 : 1;
    }

    public k() {
        Calendar g4 = g0.g(null);
        this.f3345a = g4;
        this.f3346b = g4.getMaximum(7);
        this.f3347c = g4.getFirstDayOfWeek();
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return this.f3346b;
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i4) {
        int i5 = this.f3346b;
        if (i4 >= i5) {
            return null;
        }
        int i6 = i4 + this.f3347c;
        if (i6 > i5) {
            i6 -= i5;
        }
        return Integer.valueOf(i6);
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i4) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public final View getView(int i4, View view, ViewGroup viewGroup) {
        TextView textView = (TextView) view;
        if (view == null) {
            textView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mtrl_calendar_day_of_week, viewGroup, false);
        }
        int i5 = i4 + this.f3347c;
        int i6 = this.f3346b;
        if (i5 > i6) {
            i5 -= i6;
        }
        Calendar calendar = this.f3345a;
        calendar.set(7, i5);
        textView.setText(calendar.getDisplayName(7, f3344d, textView.getResources().getConfiguration().locale));
        textView.setContentDescription(String.format(viewGroup.getContext().getString(R.string.mtrl_picker_day_of_week_column_header), calendar.getDisplayName(7, 2, Locale.getDefault())));
        return textView;
    }

    public k(int i4) {
        Calendar g4 = g0.g(null);
        this.f3345a = g4;
        this.f3346b = g4.getMaximum(7);
        this.f3347c = i4;
    }
}