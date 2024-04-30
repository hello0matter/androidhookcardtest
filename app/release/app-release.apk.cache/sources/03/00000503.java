package com.google.android.material.datepicker;

import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.l1;
import com.example.msphone.R;
import i0.y0;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class z extends l1 {

    /* renamed from: t  reason: collision with root package name */
    public final TextView f3377t;

    /* renamed from: u  reason: collision with root package name */
    public final MaterialCalendarGridView f3378u;

    public z(LinearLayout linearLayout, boolean z4) {
        super(linearLayout);
        TextView textView = (TextView) linearLayout.findViewById(R.id.month_title);
        this.f3377t = textView;
        WeakHashMap weakHashMap = y0.f4999a;
        new i0.c0(R.id.tag_accessibility_heading, 3).b(textView, Boolean.TRUE);
        this.f3378u = (MaterialCalendarGridView) linearLayout.findViewById(R.id.month_grid);
        if (!z4) {
            textView.setVisibility(8);
        }
    }
}