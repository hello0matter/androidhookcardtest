package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import androidx.annotation.RestrictTo;
import com.example.msphone.R;
import java.util.ArrayList;

@RestrictTo({RestrictTo.Scope.f170b})
/* loaded from: classes.dex */
public class RangeDateSelector implements DateSelector<h0.c> {
    public static final Parcelable.Creator<RangeDateSelector> CREATOR = new w(3);

    /* renamed from: a  reason: collision with root package name */
    public String f3297a;

    /* renamed from: b  reason: collision with root package name */
    public Long f3298b;

    /* renamed from: c  reason: collision with root package name */
    public Long f3299c;

    /* renamed from: d  reason: collision with root package name */
    public Long f3300d;

    /* renamed from: e  reason: collision with root package name */
    public Long f3301e;

    /* JADX WARN: Removed duplicated region for block: B:24:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x006e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void l(com.google.android.material.datepicker.RangeDateSelector r6, com.google.android.material.textfield.TextInputLayout r7, com.google.android.material.textfield.TextInputLayout r8, com.google.android.material.datepicker.b0 r9) {
        /*
            java.lang.Long r0 = r6.f3300d
            java.lang.String r1 = " "
            if (r0 == 0) goto L36
            java.lang.Long r2 = r6.f3301e
            if (r2 != 0) goto Lb
            goto L36
        Lb:
            long r2 = r0.longValue()
            java.lang.Long r0 = r6.f3301e
            long r4 = r0.longValue()
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 > 0) goto L2a
            java.lang.Long r0 = r6.f3300d
            r6.f3298b = r0
            java.lang.Long r1 = r6.f3301e
            r6.f3299c = r1
            h0.c r6 = new h0.c
            r6.<init>(r0, r1)
            r9.b(r6)
            goto L60
        L2a:
            java.lang.String r6 = r6.f3297a
            r7.setError(r6)
            r8.setError(r1)
        L32:
            r9.a()
            goto L60
        L36:
            java.lang.CharSequence r0 = r7.getError()
            r2 = 0
            if (r0 == 0) goto L4c
            java.lang.String r6 = r6.f3297a
            java.lang.CharSequence r0 = r7.getError()
            boolean r6 = r6.contentEquals(r0)
            if (r6 == 0) goto L4c
            r7.setError(r2)
        L4c:
            java.lang.CharSequence r6 = r8.getError()
            if (r6 == 0) goto L32
            java.lang.CharSequence r6 = r8.getError()
            boolean r6 = r1.contentEquals(r6)
            if (r6 == 0) goto L32
            r8.setError(r2)
            goto L32
        L60:
            java.lang.CharSequence r6 = r7.getError()
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 != 0) goto L6e
            r7.getError()
            goto L7b
        L6e:
            java.lang.CharSequence r6 = r8.getError()
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 != 0) goto L7b
            r8.getError()
        L7b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.datepicker.RangeDateSelector.l(com.google.android.material.datepicker.RangeDateSelector, com.google.android.material.textfield.TextInputLayout, com.google.android.material.textfield.TextInputLayout, com.google.android.material.datepicker.b0):void");
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public final Object a() {
        return new h0.c(this.f3298b, this.f3299c);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public final String b(Context context) {
        Resources resources = context.getResources();
        h0.c q02 = com.google.common.collect.c.q0(this.f3298b, this.f3299c);
        Object obj = q02.f4797a;
        String string = obj == null ? resources.getString(R.string.mtrl_picker_announce_current_selection_none) : (String) obj;
        Object obj2 = q02.f4798b;
        return resources.getString(R.string.mtrl_picker_announce_current_range_selection, string, obj2 == null ? resources.getString(R.string.mtrl_picker_announce_current_selection_none) : (String) obj2);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public final String c(Context context) {
        Resources resources = context.getResources();
        Long l4 = this.f3298b;
        if (l4 == null && this.f3299c == null) {
            return resources.getString(R.string.mtrl_picker_range_header_unselected);
        }
        Long l5 = this.f3299c;
        if (l5 == null) {
            return resources.getString(R.string.mtrl_picker_range_header_only_start_selected, com.google.common.collect.c.r0(l4.longValue()));
        }
        if (l4 == null) {
            return resources.getString(R.string.mtrl_picker_range_header_only_end_selected, com.google.common.collect.c.r0(l5.longValue()));
        }
        h0.c q02 = com.google.common.collect.c.q0(l4, l5);
        return resources.getString(R.string.mtrl_picker_range_header_selected, q02.f4797a, q02.f4798b);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public final int d(Context context) {
        int i4;
        Resources resources = context.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        if (Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels) > resources.getDimensionPixelSize(R.dimen.mtrl_calendar_maximum_default_fullscreen_minor_axis)) {
            i4 = R.attr.materialCalendarTheme;
        } else {
            i4 = R.attr.materialCalendarFullscreenTheme;
        }
        return i2.c.c(i4, context, MaterialDatePicker.class.getCanonicalName()).data;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public final ArrayList e() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new h0.c(this.f3298b, this.f3299c));
        return arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x004e, code lost:
        if (r1.equals("samsung") != false) goto L19;
     */
    @Override // com.google.android.material.datepicker.DateSelector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.view.View g(android.view.LayoutInflater r21, android.view.ViewGroup r22, com.google.android.material.datepicker.CalendarConstraints r23, com.google.android.material.datepicker.u r24) {
        /*
            r20 = this;
            r10 = r20
            r0 = 2131427422(0x7f0b005e, float:1.847646E38)
            r1 = 0
            r2 = r21
            r3 = r22
            android.view.View r11 = r2.inflate(r0, r3, r1)
            r0 = 2131230985(0x7f080109, float:1.8078038E38)
            android.view.View r0 = r11.findViewById(r0)
            r12 = r0
            com.google.android.material.textfield.TextInputLayout r12 = (com.google.android.material.textfield.TextInputLayout) r12
            r0 = 2131230984(0x7f080108, float:1.8078036E38)
            android.view.View r0 = r11.findViewById(r0)
            r13 = r0
            com.google.android.material.textfield.TextInputLayout r13 = (com.google.android.material.textfield.TextInputLayout) r13
            android.widget.EditText r14 = r12.getEditText()
            android.widget.EditText r15 = r13.getEditText()
            java.lang.String r0 = android.os.Build.MANUFACTURER
            java.lang.String r1 = ""
            if (r0 == 0) goto L37
            java.util.Locale r2 = java.util.Locale.ENGLISH
            java.lang.String r2 = r0.toLowerCase(r2)
            goto L38
        L37:
            r2 = r1
        L38:
            java.lang.String r3 = "lge"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L50
            if (r0 == 0) goto L48
            java.util.Locale r1 = java.util.Locale.ENGLISH
            java.lang.String r1 = r0.toLowerCase(r1)
        L48:
            java.lang.String r0 = "samsung"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L58
        L50:
            r0 = 17
            r14.setInputType(r0)
            r15.setInputType(r0)
        L58:
            android.content.res.Resources r0 = r11.getResources()
            r1 = 2131689597(0x7f0f007d, float:1.9008214E38)
            java.lang.String r0 = r0.getString(r1)
            r10.f3297a = r0
            java.text.SimpleDateFormat r9 = com.google.android.material.datepicker.g0.d()
            java.lang.Long r0 = r10.f3298b
            if (r0 == 0) goto L78
            java.lang.String r0 = r9.format(r0)
            r14.setText(r0)
            java.lang.Long r0 = r10.f3298b
            r10.f3300d = r0
        L78:
            java.lang.Long r0 = r10.f3299c
            if (r0 == 0) goto L87
            java.lang.String r0 = r9.format(r0)
            r15.setText(r0)
            java.lang.Long r0 = r10.f3299c
            r10.f3301e = r0
        L87:
            android.content.res.Resources r0 = r11.getResources()
            java.lang.String r8 = com.google.android.material.datepicker.g0.e(r0, r9)
            r12.setPlaceholderText(r8)
            r13.setPlaceholderText(r8)
            com.google.android.material.datepicker.d0 r7 = new com.google.android.material.datepicker.d0
            r16 = 0
            r0 = r7
            r1 = r20
            r2 = r8
            r3 = r9
            r4 = r12
            r5 = r23
            r6 = r12
            r17 = r7
            r7 = r13
            r18 = r8
            r8 = r24
            r19 = r9
            r9 = r16
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            r0 = r17
            r14.addTextChangedListener(r0)
            com.google.android.material.datepicker.d0 r9 = new com.google.android.material.datepicker.d0
            r16 = 1
            r0 = r9
            r2 = r18
            r3 = r19
            r4 = r13
            r12 = r9
            r9 = r16
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            r15.addTextChangedListener(r12)
            android.widget.EditText[] r0 = new android.widget.EditText[]{r14, r15}
            com.google.android.material.datepicker.DateSelector.j(r0)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.datepicker.RangeDateSelector.g(android.view.LayoutInflater, android.view.ViewGroup, com.google.android.material.datepicker.CalendarConstraints, com.google.android.material.datepicker.u):android.view.View");
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public final boolean h() {
        Long l4 = this.f3298b;
        return (l4 == null || this.f3299c == null || l4.longValue() > this.f3299c.longValue()) ? false : true;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public final void i(long j4) {
        Long l4 = this.f3298b;
        if (l4 == null) {
            this.f3298b = Long.valueOf(j4);
        } else if (this.f3299c == null && l4.longValue() <= j4) {
            this.f3299c = Long.valueOf(j4);
        } else {
            this.f3299c = null;
            this.f3298b = Long.valueOf(j4);
        }
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public final ArrayList k() {
        ArrayList arrayList = new ArrayList();
        Long l4 = this.f3298b;
        if (l4 != null) {
            arrayList.add(l4);
        }
        Long l5 = this.f3299c;
        if (l5 != null) {
            arrayList.add(l5);
        }
        return arrayList;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeValue(this.f3298b);
        parcel.writeValue(this.f3299c);
    }
}