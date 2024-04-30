package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.activity.result.a;
import java.util.Arrays;
import l1.d;

@Deprecated
/* loaded from: classes.dex */
public final class PrivFrame extends Id3Frame {
    public static final Parcelable.Creator<PrivFrame> CREATOR = new a(22);

    /* renamed from: b  reason: collision with root package name */
    public final String f2803b;

    /* renamed from: c  reason: collision with root package name */
    public final byte[] f2804c;

    public PrivFrame(Parcel parcel) {
        super("PRIV");
        String readString = parcel.readString();
        int i4 = d.f5272a;
        this.f2803b = readString;
        this.f2804c = parcel.createByteArray();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || PrivFrame.class != obj.getClass()) {
            return false;
        }
        PrivFrame privFrame = (PrivFrame) obj;
        return d.a(this.f2803b, privFrame.f2803b) && Arrays.equals(this.f2804c, privFrame.f2804c);
    }

    public final int hashCode() {
        String str = this.f2803b;
        return Arrays.hashCode(this.f2804c) + ((527 + (str != null ? str.hashCode() : 0)) * 31);
    }

    @Override // com.google.android.exoplayer2.metadata.id3.Id3Frame
    public final String toString() {
        return this.f2794a + ": owner=" + this.f2803b;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(this.f2803b);
        parcel.writeByteArray(this.f2804c);
    }
}