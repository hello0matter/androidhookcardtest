package com.google.android.material.timepicker;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* loaded from: classes.dex */
class TimeModel implements Parcelable {
    public static final Parcelable.Creator<TimeModel> CREATOR = new Object();

    /* renamed from: a  reason: collision with root package name */
    public final int f4150a;

    /* renamed from: b  reason: collision with root package name */
    public final int f4151b;

    /* renamed from: c  reason: collision with root package name */
    public final int f4152c;

    /* renamed from: d  reason: collision with root package name */
    public final int f4153d;

    public TimeModel(Parcel parcel) {
        int readInt = parcel.readInt();
        int readInt2 = parcel.readInt();
        int readInt3 = parcel.readInt();
        int readInt4 = parcel.readInt();
        this.f4151b = readInt;
        this.f4152c = readInt2;
        this.f4153d = readInt3;
        this.f4150a = readInt4;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TimeModel) {
            TimeModel timeModel = (TimeModel) obj;
            return this.f4151b == timeModel.f4151b && this.f4152c == timeModel.f4152c && this.f4150a == timeModel.f4150a && this.f4153d == timeModel.f4153d;
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f4150a), Integer.valueOf(this.f4151b), Integer.valueOf(this.f4152c), Integer.valueOf(this.f4153d)});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeInt(this.f4151b);
        parcel.writeInt(this.f4152c);
        parcel.writeInt(this.f4153d);
        parcel.writeInt(this.f4150a);
    }
}