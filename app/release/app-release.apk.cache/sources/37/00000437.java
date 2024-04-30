package com.google.android.exoplayer2.metadata.mp4;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.metadata.Metadata;

@Deprecated
/* loaded from: classes.dex */
public final class SmtaMetadataEntry implements Metadata.Entry {
    public static final Parcelable.Creator<SmtaMetadataEntry> CREATOR = new androidx.activity.result.a(27);

    /* renamed from: a  reason: collision with root package name */
    public final float f2822a;

    /* renamed from: b  reason: collision with root package name */
    public final int f2823b;

    public SmtaMetadataEntry(Parcel parcel) {
        this.f2822a = parcel.readFloat();
        this.f2823b = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || SmtaMetadataEntry.class != obj.getClass()) {
            return false;
        }
        SmtaMetadataEntry smtaMetadataEntry = (SmtaMetadataEntry) obj;
        return this.f2822a == smtaMetadataEntry.f2822a && this.f2823b == smtaMetadataEntry.f2823b;
    }

    public final int hashCode() {
        return ((Float.valueOf(this.f2822a).hashCode() + 527) * 31) + this.f2823b;
    }

    public final String toString() {
        return "smta: captureFrameRate=" + this.f2822a + ", svcTemporalLayerCount=" + this.f2823b;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeFloat(this.f2822a);
        parcel.writeInt(this.f2823b);
    }
}