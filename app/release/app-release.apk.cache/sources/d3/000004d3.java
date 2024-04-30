package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.material.datepicker.CalendarConstraints;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class CompositeDateValidator implements CalendarConstraints.DateValidator {

    /* renamed from: a  reason: collision with root package name */
    public final g f3255a;

    /* renamed from: b  reason: collision with root package name */
    public final List f3256b;

    /* renamed from: c  reason: collision with root package name */
    public static final d f3253c = new Object();

    /* renamed from: d  reason: collision with root package name */
    public static final e f3254d = new Object();
    public static final Parcelable.Creator<CompositeDateValidator> CREATOR = new Object();

    public CompositeDateValidator(ArrayList arrayList, g gVar) {
        this.f3256b = arrayList;
        this.f3255a = gVar;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CompositeDateValidator) {
            CompositeDateValidator compositeDateValidator = (CompositeDateValidator) obj;
            return this.f3256b.equals(compositeDateValidator.f3256b) && this.f3255a.getId() == compositeDateValidator.f3255a.getId();
        }
        return false;
    }

    @Override // com.google.android.material.datepicker.CalendarConstraints.DateValidator
    public final boolean f(long j4) {
        return this.f3255a.a(this.f3256b, j4);
    }

    public final int hashCode() {
        return this.f3256b.hashCode();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeList(this.f3256b);
        parcel.writeInt(this.f3255a.getId());
    }
}