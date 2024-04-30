package com.google.android.material.datepicker;

import android.text.Editable;
import android.text.TextUtils;
import androidx.appcompat.app.l0;
import com.example.msphone.R;
import com.google.android.material.textfield.TextInputLayout;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes.dex */
public abstract class i extends com.google.android.material.internal.g0 {

    /* renamed from: a  reason: collision with root package name */
    public final TextInputLayout f3332a;

    /* renamed from: b  reason: collision with root package name */
    public final String f3333b;

    /* renamed from: c  reason: collision with root package name */
    public final DateFormat f3334c;

    /* renamed from: d  reason: collision with root package name */
    public final CalendarConstraints f3335d;

    /* renamed from: e  reason: collision with root package name */
    public final String f3336e;

    /* renamed from: f  reason: collision with root package name */
    public final l0 f3337f;

    /* renamed from: g  reason: collision with root package name */
    public h f3338g;

    /* renamed from: h  reason: collision with root package name */
    public int f3339h = 0;

    public i(String str, SimpleDateFormat simpleDateFormat, TextInputLayout textInputLayout, CalendarConstraints calendarConstraints) {
        this.f3333b = str;
        this.f3334c = simpleDateFormat;
        this.f3332a = textInputLayout;
        this.f3335d = calendarConstraints;
        this.f3336e = textInputLayout.getContext().getString(R.string.mtrl_picker_out_of_range);
        this.f3337f = new l0(5, this, str);
    }

    public abstract void a();

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        if (Locale.getDefault().getLanguage().equals(Locale.KOREAN.getLanguage()) || editable.length() == 0) {
            return;
        }
        int length = editable.length();
        String str = this.f3333b;
        if (length >= str.length() || editable.length() < this.f3339h) {
            return;
        }
        char charAt = str.charAt(editable.length());
        if (Character.isDigit(charAt)) {
            return;
        }
        editable.append(charAt);
    }

    public abstract void b(Long l4);

    @Override // com.google.android.material.internal.g0, android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
        this.f3339h = charSequence.length();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v3, types: [com.google.android.material.datepicker.h, java.lang.Runnable] */
    @Override // com.google.android.material.internal.g0, android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
        CalendarConstraints calendarConstraints = this.f3335d;
        TextInputLayout textInputLayout = this.f3332a;
        l0 l0Var = this.f3337f;
        textInputLayout.removeCallbacks(l0Var);
        textInputLayout.removeCallbacks(this.f3338g);
        textInputLayout.setError(null);
        b(null);
        if (!TextUtils.isEmpty(charSequence) && charSequence.length() >= this.f3333b.length()) {
            try {
                Date parse = this.f3334c.parse(charSequence.toString());
                textInputLayout.setError(null);
                final long time = parse.getTime();
                if (calendarConstraints.f3248c.f(time)) {
                    Calendar c4 = g0.c(calendarConstraints.f3246a.f3290a);
                    c4.set(5, 1);
                    if (c4.getTimeInMillis() <= time) {
                        Month month = calendarConstraints.f3247b;
                        int i7 = month.f3294e;
                        Calendar c5 = g0.c(month.f3290a);
                        c5.set(5, i7);
                        if (time <= c5.getTimeInMillis()) {
                            b(Long.valueOf(parse.getTime()));
                            return;
                        }
                    }
                }
                ?? r7 = new Runnable() { // from class: com.google.android.material.datepicker.h
                    @Override // java.lang.Runnable
                    public final void run() {
                        i iVar = i.this;
                        iVar.getClass();
                        iVar.f3332a.setError(String.format(iVar.f3336e, com.google.common.collect.c.r0(time).replace(' ', (char) 160)));
                        iVar.a();
                    }
                };
                this.f3338g = r7;
                textInputLayout.post(r7);
            } catch (ParseException unused) {
                textInputLayout.post(l0Var);
            }
        }
    }
}