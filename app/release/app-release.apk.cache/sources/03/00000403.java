package com.google.android.exoplayer2.container;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.activity.result.a;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.common.collect.c;

/* loaded from: classes.dex */
public final class CreationTime implements Metadata.Entry {
    public static final Parcelable.Creator<CreationTime> CREATOR = new a(3);

    /* renamed from: a  reason: collision with root package name */
    public final long f2730a;

    public CreationTime(Parcel parcel) {
        this.f2730a = parcel.readLong();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CreationTime) {
            return this.f2730a == ((CreationTime) obj).f2730a;
        }
        return false;
    }

    public final int hashCode() {
        return c.U0(this.f2730a);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Creation time: ");
        long j4 = this.f2730a;
        sb.append(j4 == -2082844800000L ? "unset" : Long.valueOf(j4));
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeLong(this.f2730a);
    }
}