package com.google.android.exoplayer2.metadata.flac;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.activity.result.a;
import com.google.android.exoplayer2.metadata.Metadata;
import java.util.Arrays;
import l1.d;

@Deprecated
/* loaded from: classes.dex */
public final class PictureFrame implements Metadata.Entry {
    public static final Parcelable.Creator<PictureFrame> CREATOR = new a(10);

    /* renamed from: a  reason: collision with root package name */
    public final int f2752a;

    /* renamed from: b  reason: collision with root package name */
    public final String f2753b;

    /* renamed from: c  reason: collision with root package name */
    public final String f2754c;

    /* renamed from: d  reason: collision with root package name */
    public final int f2755d;

    /* renamed from: e  reason: collision with root package name */
    public final int f2756e;

    /* renamed from: f  reason: collision with root package name */
    public final int f2757f;

    /* renamed from: g  reason: collision with root package name */
    public final int f2758g;

    /* renamed from: h  reason: collision with root package name */
    public final byte[] f2759h;

    public PictureFrame(Parcel parcel) {
        this.f2752a = parcel.readInt();
        String readString = parcel.readString();
        int i4 = d.f5272a;
        this.f2753b = readString;
        this.f2754c = parcel.readString();
        this.f2755d = parcel.readInt();
        this.f2756e = parcel.readInt();
        this.f2757f = parcel.readInt();
        this.f2758g = parcel.readInt();
        this.f2759h = parcel.createByteArray();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || PictureFrame.class != obj.getClass()) {
            return false;
        }
        PictureFrame pictureFrame = (PictureFrame) obj;
        return this.f2752a == pictureFrame.f2752a && this.f2753b.equals(pictureFrame.f2753b) && this.f2754c.equals(pictureFrame.f2754c) && this.f2755d == pictureFrame.f2755d && this.f2756e == pictureFrame.f2756e && this.f2757f == pictureFrame.f2757f && this.f2758g == pictureFrame.f2758g && Arrays.equals(this.f2759h, pictureFrame.f2759h);
    }

    public final int hashCode() {
        int hashCode = this.f2753b.hashCode();
        int hashCode2 = this.f2754c.hashCode();
        return Arrays.hashCode(this.f2759h) + ((((((((((hashCode2 + ((hashCode + ((527 + this.f2752a) * 31)) * 31)) * 31) + this.f2755d) * 31) + this.f2756e) * 31) + this.f2757f) * 31) + this.f2758g) * 31);
    }

    public final String toString() {
        return "Picture: mimeType=" + this.f2753b + ", description=" + this.f2754c;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeInt(this.f2752a);
        parcel.writeString(this.f2753b);
        parcel.writeString(this.f2754c);
        parcel.writeInt(this.f2755d);
        parcel.writeInt(this.f2756e);
        parcel.writeInt(this.f2757f);
        parcel.writeInt(this.f2758g);
        parcel.writeByteArray(this.f2759h);
    }
}