package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RestrictTo;
import com.example.msphone.R;
import java.util.ArrayList;
import java.util.Locale;

@RestrictTo({RestrictTo.Scope.f170b})
/* loaded from: classes.dex */
public class SingleDateSelector implements DateSelector<Long> {
    public static final Parcelable.Creator<SingleDateSelector> CREATOR = new w(4);

    /* renamed from: a  reason: collision with root package name */
    public Long f3302a;

    @Override // com.google.android.material.datepicker.DateSelector
    public final Object a() {
        return this.f3302a;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public final String b(Context context) {
        String T0;
        Resources resources = context.getResources();
        Long l4 = this.f3302a;
        if (l4 == null) {
            T0 = resources.getString(R.string.mtrl_picker_announce_current_selection_none);
        } else {
            T0 = com.google.common.collect.c.T0(l4.longValue(), Locale.getDefault());
        }
        return resources.getString(R.string.mtrl_picker_announce_current_selection, T0);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public final String c(Context context) {
        Resources resources = context.getResources();
        Long l4 = this.f3302a;
        if (l4 == null) {
            return resources.getString(R.string.mtrl_picker_date_header_unselected);
        }
        return resources.getString(R.string.mtrl_picker_date_header_selected, com.google.common.collect.c.T0(l4.longValue(), Locale.getDefault()));
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public final int d(Context context) {
        return i2.c.c(R.attr.materialCalendarTheme, context, MaterialDatePicker.class.getCanonicalName()).data;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public final ArrayList e() {
        return new ArrayList();
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x003a, code lost:
        if (r1.equals("samsung") != false) goto L16;
     */
    @Override // com.google.android.material.datepicker.DateSelector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.view.View g(android.view.LayoutInflater r10, android.view.ViewGroup r11, com.google.android.material.datepicker.CalendarConstraints r12, com.google.android.material.datepicker.u r13) {
        /*
            r9 = this;
            r0 = 2131427421(0x7f0b005d, float:1.8476458E38)
            r1 = 0
            android.view.View r10 = r10.inflate(r0, r11, r1)
            r11 = 2131230983(0x7f080107, float:1.8078034E38)
            android.view.View r11 = r10.findViewById(r11)
            r7 = r11
            com.google.android.material.textfield.TextInputLayout r7 = (com.google.android.material.textfield.TextInputLayout) r7
            android.widget.EditText r11 = r7.getEditText()
            java.lang.String r0 = android.os.Build.MANUFACTURER
            java.lang.String r1 = ""
            if (r0 == 0) goto L23
            java.util.Locale r2 = java.util.Locale.ENGLISH
            java.lang.String r2 = r0.toLowerCase(r2)
            goto L24
        L23:
            r2 = r1
        L24:
            java.lang.String r3 = "lge"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L3c
            if (r0 == 0) goto L34
            java.util.Locale r1 = java.util.Locale.ENGLISH
            java.lang.String r1 = r0.toLowerCase(r1)
        L34:
            java.lang.String r0 = "samsung"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L41
        L3c:
            r0 = 17
            r11.setInputType(r0)
        L41:
            java.text.SimpleDateFormat r3 = com.google.android.material.datepicker.g0.d()
            android.content.res.Resources r0 = r10.getResources()
            java.lang.String r2 = com.google.android.material.datepicker.g0.e(r0, r3)
            r7.setPlaceholderText(r2)
            java.lang.Long r0 = r9.f3302a
            if (r0 == 0) goto L5b
            java.lang.String r0 = r3.format(r0)
            r11.setText(r0)
        L5b:
            com.google.android.material.datepicker.e0 r8 = new com.google.android.material.datepicker.e0
            r0 = r8
            r1 = r9
            r4 = r7
            r5 = r12
            r6 = r13
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            r11.addTextChangedListener(r8)
            android.widget.EditText[] r11 = new android.widget.EditText[]{r11}
            com.google.android.material.datepicker.DateSelector.j(r11)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.datepicker.SingleDateSelector.g(android.view.LayoutInflater, android.view.ViewGroup, com.google.android.material.datepicker.CalendarConstraints, com.google.android.material.datepicker.u):android.view.View");
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public final boolean h() {
        return this.f3302a != null;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public final void i(long j4) {
        this.f3302a = Long.valueOf(j4);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public final ArrayList k() {
        ArrayList arrayList = new ArrayList();
        Long l4 = this.f3302a;
        if (l4 != null) {
            arrayList.add(l4);
        }
        return arrayList;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeValue(this.f3302a);
    }
}