package com.google.android.exoplayer2.offline;

import android.os.Parcel;
import android.os.Parcelable;
import k1.b;
import l1.d;

@Deprecated
/* loaded from: classes.dex */
public final class StreamKey implements Comparable<StreamKey>, Parcelable {
    public static final Parcelable.Creator<StreamKey> CREATOR = new b(5);

    /* renamed from: a  reason: collision with root package name */
    public final int f2851a;

    /* renamed from: b  reason: collision with root package name */
    public final int f2852b;

    /* renamed from: c  reason: collision with root package name */
    public final int f2853c;

    static {
        d.b(0);
        d.b(1);
        d.b(2);
    }

    public StreamKey(Parcel parcel) {
        this.f2851a = parcel.readInt();
        this.f2852b = parcel.readInt();
        this.f2853c = parcel.readInt();
    }

    @Override // java.lang.Comparable
    public final int compareTo(StreamKey streamKey) {
        StreamKey streamKey2 = streamKey;
        int i4 = this.f2851a - streamKey2.f2851a;
        if (i4 == 0) {
            int i5 = this.f2852b - streamKey2.f2852b;
            if (i5 == 0) {
                return this.f2853c - streamKey2.f2853c;
            }
            return i5;
        }
        return i4;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || StreamKey.class != obj.getClass()) {
            return false;
        }
        StreamKey streamKey = (StreamKey) obj;
        return this.f2851a == streamKey.f2851a && this.f2852b == streamKey.f2852b && this.f2853c == streamKey.f2853c;
    }

    public final int hashCode() {
        return (((this.f2851a * 31) + this.f2852b) * 31) + this.f2853c;
    }

    public final String toString() {
        return this.f2851a + "." + this.f2852b + "." + this.f2853c;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeInt(this.f2851a);
        parcel.writeInt(this.f2852b);
        parcel.writeInt(this.f2853c);
    }
}