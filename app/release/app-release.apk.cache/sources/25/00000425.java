package com.google.android.exoplayer2.metadata.icy;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.activity.result.a;
import com.google.android.exoplayer2.metadata.Metadata;
import l1.d;

@Deprecated
/* loaded from: classes.dex */
public final class IcyHeaders implements Metadata.Entry {
    public static final Parcelable.Creator<IcyHeaders> CREATOR = new a(12);

    /* renamed from: a  reason: collision with root package name */
    public final int f2762a;

    /* renamed from: b  reason: collision with root package name */
    public final String f2763b;

    /* renamed from: c  reason: collision with root package name */
    public final String f2764c;

    /* renamed from: d  reason: collision with root package name */
    public final String f2765d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f2766e;

    /* renamed from: f  reason: collision with root package name */
    public final int f2767f;

    public IcyHeaders(Parcel parcel) {
        boolean z4;
        this.f2762a = parcel.readInt();
        this.f2763b = parcel.readString();
        this.f2764c = parcel.readString();
        this.f2765d = parcel.readString();
        int i4 = d.f5272a;
        if (parcel.readInt() != 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        this.f2766e = z4;
        this.f2767f = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || IcyHeaders.class != obj.getClass()) {
            return false;
        }
        IcyHeaders icyHeaders = (IcyHeaders) obj;
        return this.f2762a == icyHeaders.f2762a && d.a(this.f2763b, icyHeaders.f2763b) && d.a(this.f2764c, icyHeaders.f2764c) && d.a(this.f2765d, icyHeaders.f2765d) && this.f2766e == icyHeaders.f2766e && this.f2767f == icyHeaders.f2767f;
    }

    public final int hashCode() {
        int i4 = (527 + this.f2762a) * 31;
        String str = this.f2763b;
        int hashCode = (i4 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f2764c;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f2765d;
        return ((((hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + (this.f2766e ? 1 : 0)) * 31) + this.f2767f;
    }

    public final String toString() {
        return "IcyHeaders: name=\"" + this.f2764c + "\", genre=\"" + this.f2763b + "\", bitrate=" + this.f2762a + ", metadataInterval=" + this.f2767f;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeInt(this.f2762a);
        parcel.writeString(this.f2763b);
        parcel.writeString(this.f2764c);
        parcel.writeString(this.f2765d);
        int i5 = d.f5272a;
        parcel.writeInt(this.f2766e ? 1 : 0);
        parcel.writeInt(this.f2767f);
    }
}