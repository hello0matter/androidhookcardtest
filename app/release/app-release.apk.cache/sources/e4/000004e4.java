package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import com.example.msphone.R;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final androidx.appcompat.widget.w f3311a;

    /* renamed from: b  reason: collision with root package name */
    public final androidx.appcompat.widget.w f3312b;

    /* renamed from: c  reason: collision with root package name */
    public final androidx.appcompat.widget.w f3313c;

    /* renamed from: d  reason: collision with root package name */
    public final androidx.appcompat.widget.w f3314d;

    /* renamed from: e  reason: collision with root package name */
    public final androidx.appcompat.widget.w f3315e;

    /* renamed from: f  reason: collision with root package name */
    public final androidx.appcompat.widget.w f3316f;

    /* renamed from: g  reason: collision with root package name */
    public final androidx.appcompat.widget.w f3317g;

    /* renamed from: h  reason: collision with root package name */
    public final Paint f3318h;

    public c(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i2.c.c(R.attr.materialCalendarStyle, context, MaterialCalendar.class.getCanonicalName()).data, o1.a.A);
        this.f3311a = androidx.appcompat.widget.w.b(context, obtainStyledAttributes.getResourceId(4, 0));
        this.f3317g = androidx.appcompat.widget.w.b(context, obtainStyledAttributes.getResourceId(2, 0));
        this.f3312b = androidx.appcompat.widget.w.b(context, obtainStyledAttributes.getResourceId(3, 0));
        this.f3313c = androidx.appcompat.widget.w.b(context, obtainStyledAttributes.getResourceId(5, 0));
        ColorStateList a5 = i2.d.a(context, obtainStyledAttributes, 7);
        this.f3314d = androidx.appcompat.widget.w.b(context, obtainStyledAttributes.getResourceId(9, 0));
        this.f3315e = androidx.appcompat.widget.w.b(context, obtainStyledAttributes.getResourceId(8, 0));
        this.f3316f = androidx.appcompat.widget.w.b(context, obtainStyledAttributes.getResourceId(10, 0));
        Paint paint = new Paint();
        this.f3318h = paint;
        paint.setColor(a5.getDefaultColor());
        obtainStyledAttributes.recycle();
    }
}