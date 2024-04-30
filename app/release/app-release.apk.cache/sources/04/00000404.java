package com.google.android.exoplayer2.container;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.activity.result.a;
import com.google.android.exoplayer2.metadata.Metadata;

@Deprecated
/* loaded from: classes.dex */
public final class Mp4LocationData implements Metadata.Entry {
    public static final Parcelable.Creator<Mp4LocationData> CREATOR = new a(4);

    /* renamed from: a  reason: collision with root package name */
    public final float f2731a;

    /* renamed from: b  reason: collision with root package name */
    public final float f2732b;

    public Mp4LocationData(Parcel parcel) {
        this.f2731a = parcel.readFloat();
        this.f2732b = parcel.readFloat();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Mp4LocationData.class != obj.getClass()) {
            return false;
        }
        Mp4LocationData mp4LocationData = (Mp4LocationData) obj;
        return this.f2731a == mp4LocationData.f2731a && this.f2732b == mp4LocationData.f2732b;
    }

    public final int hashCode() {
        return Float.valueOf(this.f2732b).hashCode() + ((Float.valueOf(this.f2731a).hashCode() + 527) * 31);
    }

    public final String toString() {
        return "xyz: latitude=" + this.f2731a + ", longitude=" + this.f2732b;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeFloat(this.f2731a);
        parcel.writeFloat(this.f2732b);
    }
}