package com.google.android.exoplayer2.metadata.icy;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.activity.result.a;
import com.google.android.exoplayer2.metadata.Metadata;
import java.util.Arrays;

@Deprecated
/* loaded from: classes.dex */
public final class IcyInfo implements Metadata.Entry {
    public static final Parcelable.Creator<IcyInfo> CREATOR = new a(13);

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f2768a;

    /* renamed from: b  reason: collision with root package name */
    public final String f2769b;

    /* renamed from: c  reason: collision with root package name */
    public final String f2770c;

    public IcyInfo(Parcel parcel) {
        byte[] createByteArray = parcel.createByteArray();
        createByteArray.getClass();
        this.f2768a = createByteArray;
        this.f2769b = parcel.readString();
        this.f2770c = parcel.readString();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || IcyInfo.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.f2768a, ((IcyInfo) obj).f2768a);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f2768a);
    }

    public final String toString() {
        int length = this.f2768a.length;
        return "ICY: title=\"" + this.f2769b + "\", url=\"" + this.f2770c + "\", rawMetadata.length=\"" + length + "\"";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeByteArray(this.f2768a);
        parcel.writeString(this.f2769b);
        parcel.writeString(this.f2770c);
    }
}