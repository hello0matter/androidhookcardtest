package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/* loaded from: classes.dex */
final class Month implements Comparable<Month>, Parcelable {
    public static final Parcelable.Creator<Month> CREATOR = new w(0);

    /* renamed from: a  reason: collision with root package name */
    public final Calendar f3290a;

    /* renamed from: b  reason: collision with root package name */
    public final int f3291b;

    /* renamed from: c  reason: collision with root package name */
    public final int f3292c;

    /* renamed from: d  reason: collision with root package name */
    public final int f3293d;

    /* renamed from: e  reason: collision with root package name */
    public final int f3294e;

    /* renamed from: f  reason: collision with root package name */
    public final long f3295f;

    /* renamed from: g  reason: collision with root package name */
    public String f3296g;

    public Month(Calendar calendar) {
        calendar.set(5, 1);
        Calendar c4 = g0.c(calendar);
        this.f3290a = c4;
        this.f3291b = c4.get(2);
        this.f3292c = c4.get(1);
        this.f3293d = c4.getMaximum(7);
        this.f3294e = c4.getActualMaximum(5);
        this.f3295f = c4.getTimeInMillis();
    }

    public static Month l(int i4, int i5) {
        Calendar g4 = g0.g(null);
        g4.set(1, i4);
        g4.set(2, i5);
        return new Month(g4);
    }

    public static Month m(long j4) {
        Calendar g4 = g0.g(null);
        g4.setTimeInMillis(j4);
        return new Month(g4);
    }

    @Override // java.lang.Comparable
    public final int compareTo(Month month) {
        return this.f3290a.compareTo(month.f3290a);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Month) {
            Month month = (Month) obj;
            return this.f3291b == month.f3291b && this.f3292c == month.f3292c;
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f3291b), Integer.valueOf(this.f3292c)});
    }

    public final String n() {
        if (this.f3296g == null) {
            this.f3296g = g0.b("yMMMM", Locale.getDefault()).format(new Date(this.f3290a.getTimeInMillis()));
        }
        return this.f3296g;
    }

    public final int o(Month month) {
        if (this.f3290a instanceof GregorianCalendar) {
            return (month.f3291b - this.f3291b) + ((month.f3292c - this.f3292c) * 12);
        }
        throw new IllegalArgumentException("Only Gregorian calendars are supported.");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeInt(this.f3292c);
        parcel.writeInt(this.f3291b);
    }
}