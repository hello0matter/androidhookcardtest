package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Objects;

/* loaded from: classes.dex */
public final class CalendarConstraints implements Parcelable {
    public static final Parcelable.Creator<CalendarConstraints> CREATOR = new Object();

    /* renamed from: a  reason: collision with root package name */
    public final Month f3246a;

    /* renamed from: b  reason: collision with root package name */
    public final Month f3247b;

    /* renamed from: c  reason: collision with root package name */
    public final DateValidator f3248c;

    /* renamed from: d  reason: collision with root package name */
    public final Month f3249d;

    /* renamed from: e  reason: collision with root package name */
    public final int f3250e;

    /* renamed from: f  reason: collision with root package name */
    public final int f3251f;

    /* renamed from: g  reason: collision with root package name */
    public final int f3252g;

    /* loaded from: classes.dex */
    public interface DateValidator extends Parcelable {
        boolean f(long j4);
    }

    public CalendarConstraints(Month month, Month month2, DateValidator dateValidator, Month month3, int i4) {
        Objects.requireNonNull(month, "start cannot be null");
        Objects.requireNonNull(month2, "end cannot be null");
        Objects.requireNonNull(dateValidator, "validator cannot be null");
        this.f3246a = month;
        this.f3247b = month2;
        this.f3249d = month3;
        this.f3250e = i4;
        this.f3248c = dateValidator;
        if (month3 != null && month.f3290a.compareTo(month3.f3290a) > 0) {
            throw new IllegalArgumentException("start Month cannot be after current Month");
        }
        if (month3 != null && month3.f3290a.compareTo(month2.f3290a) > 0) {
            throw new IllegalArgumentException("current Month cannot be after end Month");
        }
        if (i4 >= 0 && i4 <= g0.g(null).getMaximum(7)) {
            this.f3252g = month.o(month2) + 1;
            this.f3251f = (month2.f3292c - month.f3292c) + 1;
            return;
        }
        throw new IllegalArgumentException("firstDayOfWeek is not valid");
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CalendarConstraints)) {
            return false;
        }
        CalendarConstraints calendarConstraints = (CalendarConstraints) obj;
        if (this.f3246a.equals(calendarConstraints.f3246a) && this.f3247b.equals(calendarConstraints.f3247b) && h0.b.a(this.f3249d, calendarConstraints.f3249d) && this.f3250e == calendarConstraints.f3250e && this.f3248c.equals(calendarConstraints.f3248c)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f3246a, this.f3247b, this.f3249d, Integer.valueOf(this.f3250e), this.f3248c});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeParcelable(this.f3246a, 0);
        parcel.writeParcelable(this.f3247b, 0);
        parcel.writeParcelable(this.f3249d, 0);
        parcel.writeParcelable(this.f3248c, 0);
        parcel.writeInt(this.f3250e);
    }
}