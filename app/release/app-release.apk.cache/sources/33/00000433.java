package com.google.android.exoplayer2.metadata.mp4;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.common.collect.c;
import java.util.Arrays;
import l1.d;

@Deprecated
/* loaded from: classes.dex */
public final class MdtaMetadataEntry implements Metadata.Entry {
    public static final Parcelable.Creator<MdtaMetadataEntry> CREATOR = new androidx.activity.result.a(25);

    /* renamed from: a  reason: collision with root package name */
    public final String f2809a;

    /* renamed from: b  reason: collision with root package name */
    public final byte[] f2810b;

    /* renamed from: c  reason: collision with root package name */
    public final int f2811c;

    /* renamed from: d  reason: collision with root package name */
    public final int f2812d;

    public MdtaMetadataEntry(Parcel parcel) {
        String readString = parcel.readString();
        int i4 = d.f5272a;
        this.f2809a = readString;
        this.f2810b = parcel.createByteArray();
        this.f2811c = parcel.readInt();
        this.f2812d = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || MdtaMetadataEntry.class != obj.getClass()) {
            return false;
        }
        MdtaMetadataEntry mdtaMetadataEntry = (MdtaMetadataEntry) obj;
        return this.f2809a.equals(mdtaMetadataEntry.f2809a) && Arrays.equals(this.f2810b, mdtaMetadataEntry.f2810b) && this.f2811c == mdtaMetadataEntry.f2811c && this.f2812d == mdtaMetadataEntry.f2812d;
    }

    public final int hashCode() {
        return ((((Arrays.hashCode(this.f2810b) + ((this.f2809a.hashCode() + 527) * 31)) * 31) + this.f2811c) * 31) + this.f2812d;
    }

    public final String toString() {
        String str;
        boolean z4;
        boolean z5;
        byte[] bArr = this.f2810b;
        int i4 = this.f2812d;
        if (i4 != 1) {
            if (i4 != 23) {
                if (i4 != 67) {
                    str = d.c(bArr);
                } else {
                    int i5 = d.f5272a;
                    if (bArr.length == 4) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    c.z(z5);
                    str = String.valueOf((bArr[1] << 16) | (bArr[0] << 24) | (bArr[2] << 8) | bArr[3]);
                }
            } else {
                int i6 = d.f5272a;
                if (bArr.length == 4) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                c.z(z4);
                str = String.valueOf(Float.intBitsToFloat(((bArr[1] & 255) << 16) | (bArr[0] << 24) | ((bArr[2] & 255) << 8) | (bArr[3] & 255)));
            }
        } else {
            int i7 = d.f5272a;
            str = new String(bArr, com.google.common.base.a.f4175a);
        }
        return "mdta: key=" + this.f2809a + ", value=" + str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(this.f2809a);
        parcel.writeByteArray(this.f2810b);
        parcel.writeInt(this.f2811c);
        parcel.writeInt(this.f2812d);
    }
}