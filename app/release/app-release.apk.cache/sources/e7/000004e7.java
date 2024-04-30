package com.google.android.material.datepicker;

import com.google.android.material.textfield.TextInputLayout;
import java.text.SimpleDateFormat;

/* loaded from: classes.dex */
public final class d0 extends i {

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f3319i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ TextInputLayout f3320j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ TextInputLayout f3321k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ b0 f3322l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ RangeDateSelector f3323m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ d0(RangeDateSelector rangeDateSelector, String str, SimpleDateFormat simpleDateFormat, TextInputLayout textInputLayout, CalendarConstraints calendarConstraints, TextInputLayout textInputLayout2, TextInputLayout textInputLayout3, u uVar, int i4) {
        super(str, simpleDateFormat, textInputLayout, calendarConstraints);
        this.f3319i = i4;
        this.f3323m = rangeDateSelector;
        this.f3320j = textInputLayout2;
        this.f3321k = textInputLayout3;
        this.f3322l = uVar;
    }

    @Override // com.google.android.material.datepicker.i
    public final void a() {
        int i4 = this.f3319i;
        TextInputLayout textInputLayout = this.f3320j;
        b0 b0Var = this.f3322l;
        TextInputLayout textInputLayout2 = this.f3321k;
        RangeDateSelector rangeDateSelector = this.f3323m;
        switch (i4) {
            case 0:
                rangeDateSelector.f3300d = null;
                RangeDateSelector.l(rangeDateSelector, textInputLayout, textInputLayout2, b0Var);
                return;
            default:
                rangeDateSelector.f3301e = null;
                RangeDateSelector.l(rangeDateSelector, textInputLayout, textInputLayout2, b0Var);
                return;
        }
    }

    @Override // com.google.android.material.datepicker.i
    public final void b(Long l4) {
        int i4 = this.f3319i;
        TextInputLayout textInputLayout = this.f3320j;
        b0 b0Var = this.f3322l;
        TextInputLayout textInputLayout2 = this.f3321k;
        RangeDateSelector rangeDateSelector = this.f3323m;
        switch (i4) {
            case 0:
                rangeDateSelector.f3300d = l4;
                RangeDateSelector.l(rangeDateSelector, textInputLayout, textInputLayout2, b0Var);
                return;
            default:
                rangeDateSelector.f3301e = l4;
                RangeDateSelector.l(rangeDateSelector, textInputLayout, textInputLayout2, b0Var);
                return;
        }
    }
}