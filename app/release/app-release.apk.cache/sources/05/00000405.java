package com.google.android.exoplayer2.container;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.activity.result.a;
import com.google.android.exoplayer2.metadata.Metadata;
import java.util.Arrays;
import l1.d;

@Deprecated
/* loaded from: classes.dex */
public final class XmpData implements Metadata.Entry {
    public static final Parcelable.Creator<XmpData> CREATOR = new a(5);

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f2733a;

    public XmpData(Parcel parcel) {
        byte[] createByteArray = parcel.createByteArray();
        int i4 = d.f5272a;
        this.f2733a = createByteArray;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || XmpData.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.f2733a, ((XmpData) obj).f2733a);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f2733a);
    }

    public final String toString() {
        return "XMP: " + d.c(this.f2733a);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeByteArray(this.f2733a);
    }
}