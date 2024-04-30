package com.google.android.exoplayer2.metadata.mp4;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.common.collect.c;

@Deprecated
/* loaded from: classes.dex */
public final class MotionPhotoMetadata implements Metadata.Entry {
    public static final Parcelable.Creator<MotionPhotoMetadata> CREATOR = new androidx.activity.result.a(26);

    /* renamed from: a  reason: collision with root package name */
    public final long f2813a;

    /* renamed from: b  reason: collision with root package name */
    public final long f2814b;

    /* renamed from: c  reason: collision with root package name */
    public final long f2815c;

    /* renamed from: d  reason: collision with root package name */
    public final long f2816d;

    /* renamed from: e  reason: collision with root package name */
    public final long f2817e;

    public MotionPhotoMetadata(Parcel parcel) {
        this.f2813a = parcel.readLong();
        this.f2814b = parcel.readLong();
        this.f2815c = parcel.readLong();
        this.f2816d = parcel.readLong();
        this.f2817e = parcel.readLong();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || MotionPhotoMetadata.class != obj.getClass()) {
            return false;
        }
        MotionPhotoMetadata motionPhotoMetadata = (MotionPhotoMetadata) obj;
        return this.f2813a == motionPhotoMetadata.f2813a && this.f2814b == motionPhotoMetadata.f2814b && this.f2815c == motionPhotoMetadata.f2815c && this.f2816d == motionPhotoMetadata.f2816d && this.f2817e == motionPhotoMetadata.f2817e;
    }

    public final int hashCode() {
        int U0 = c.U0(this.f2814b);
        int U02 = c.U0(this.f2815c);
        int U03 = c.U0(this.f2816d);
        return c.U0(this.f2817e) + ((U03 + ((U02 + ((U0 + ((c.U0(this.f2813a) + 527) * 31)) * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "Motion photo metadata: photoStartPosition=" + this.f2813a + ", photoSize=" + this.f2814b + ", photoPresentationTimestampUs=" + this.f2815c + ", videoStartPosition=" + this.f2816d + ", videoSize=" + this.f2817e;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeLong(this.f2813a);
        parcel.writeLong(this.f2814b);
        parcel.writeLong(this.f2815c);
        parcel.writeLong(this.f2816d);
        parcel.writeLong(this.f2817e);
    }
}