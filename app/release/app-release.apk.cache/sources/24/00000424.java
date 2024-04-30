package com.google.android.exoplayer2.metadata.flac;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.activity.result.a;
import com.google.android.exoplayer2.metadata.Metadata;
import l1.d;

@Deprecated
/* loaded from: classes.dex */
public class VorbisComment implements Metadata.Entry {
    public static final Parcelable.Creator<VorbisComment> CREATOR = new a(11);

    /* renamed from: a  reason: collision with root package name */
    public final String f2760a;

    /* renamed from: b  reason: collision with root package name */
    public final String f2761b;

    public VorbisComment(Parcel parcel) {
        String readString = parcel.readString();
        int i4 = d.f5272a;
        this.f2760a = readString;
        this.f2761b = parcel.readString();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        VorbisComment vorbisComment = (VorbisComment) obj;
        return this.f2760a.equals(vorbisComment.f2760a) && this.f2761b.equals(vorbisComment.f2761b);
    }

    public final int hashCode() {
        return this.f2761b.hashCode() + ((this.f2760a.hashCode() + 527) * 31);
    }

    public final String toString() {
        return "VC: " + this.f2760a + "=" + this.f2761b;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(this.f2760a);
        parcel.writeString(this.f2761b);
    }
}