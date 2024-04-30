package com.google.android.material.datepicker;

import com.google.android.material.textfield.TextInputLayout;
import java.text.SimpleDateFormat;

/* loaded from: classes.dex */
public final class e0 extends i {

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ b0 f3324i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ TextInputLayout f3325j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ SingleDateSelector f3326k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e0(SingleDateSelector singleDateSelector, String str, SimpleDateFormat simpleDateFormat, TextInputLayout textInputLayout, CalendarConstraints calendarConstraints, u uVar, TextInputLayout textInputLayout2) {
        super(str, simpleDateFormat, textInputLayout, calendarConstraints);
        this.f3326k = singleDateSelector;
        this.f3324i = uVar;
        this.f3325j = textInputLayout2;
    }

    @Override // com.google.android.material.datepicker.i
    public final void a() {
        this.f3325j.getError();
        this.f3326k.getClass();
        this.f3324i.a();
    }

    @Override // com.google.android.material.datepicker.i
    public final void b(Long l4) {
        SingleDateSelector singleDateSelector = this.f3326k;
        if (l4 == null) {
            singleDateSelector.f3302a = null;
        } else {
            singleDateSelector.f3302a = l4;
        }
        singleDateSelector.getClass();
        this.f3324i.b(singleDateSelector.f3302a);
    }
}