package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.activity.result.a;
import java.util.Arrays;
import l1.d;

@Deprecated
/* loaded from: classes.dex */
public final class GeobFrame extends Id3Frame {
    public static final Parcelable.Creator<GeobFrame> CREATOR = new a(19);

    /* renamed from: b  reason: collision with root package name */
    public final String f2790b;

    /* renamed from: c  reason: collision with root package name */
    public final String f2791c;

    /* renamed from: d  reason: collision with root package name */
    public final String f2792d;

    /* renamed from: e  reason: collision with root package name */
    public final byte[] f2793e;

    public GeobFrame(Parcel parcel) {
        super("GEOB");
        String readString = parcel.readString();
        int i4 = d.f5272a;
        this.f2790b = readString;
        this.f2791c = parcel.readString();
        this.f2792d = parcel.readString();
        this.f2793e = parcel.createByteArray();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || GeobFrame.class != obj.getClass()) {
            return false;
        }
        GeobFrame geobFrame = (GeobFrame) obj;
        return d.a(this.f2790b, geobFrame.f2790b) && d.a(this.f2791c, geobFrame.f2791c) && d.a(this.f2792d, geobFrame.f2792d) && Arrays.equals(this.f2793e, geobFrame.f2793e);
    }

    public final int hashCode() {
        String str = this.f2790b;
        int hashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f2791c;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f2792d;
        return Arrays.hashCode(this.f2793e) + ((hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31);
    }

    @Override // com.google.android.exoplayer2.metadata.id3.Id3Frame
    public final String toString() {
        return this.f2794a + ": mimeType=" + this.f2790b + ", filename=" + this.f2791c + ", description=" + this.f2792d;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(this.f2790b);
        parcel.writeString(this.f2791c);
        parcel.writeString(this.f2792d);
        parcel.writeByteArray(this.f2793e);
    }
}