package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.material.datepicker.CalendarConstraints;
import java.util.Arrays;

/* loaded from: classes.dex */
public class DateValidatorPointForward implements CalendarConstraints.DateValidator {
    public static final Parcelable.Creator<DateValidatorPointForward> CREATOR = new w(2);

    /* renamed from: a  reason: collision with root package name */
    public final long f3258a;

    public DateValidatorPointForward(long j4) {
        this.f3258a = j4;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof DateValidatorPointForward) && this.f3258a == ((DateValidatorPointForward) obj).f3258a;
    }

    @Override // com.google.android.material.datepicker.CalendarConstraints.DateValidator
    public final boolean f(long j4) {
        return j4 >= this.f3258a;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.f3258a)});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeLong(this.f3258a);
    }
}