package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.activity.result.a;
import l1.d;

@Deprecated
/* loaded from: classes.dex */
public final class InternalFrame extends Id3Frame {
    public static final Parcelable.Creator<InternalFrame> CREATOR = new a(20);

    /* renamed from: b  reason: collision with root package name */
    public final String f2795b;

    /* renamed from: c  reason: collision with root package name */
    public final String f2796c;

    /* renamed from: d  reason: collision with root package name */
    public final String f2797d;

    public InternalFrame(Parcel parcel) {
        super("----");
        String readString = parcel.readString();
        int i4 = d.f5272a;
        this.f2795b = readString;
        this.f2796c = parcel.readString();
        this.f2797d = parcel.readString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || InternalFrame.class != obj.getClass()) {
            return false;
        }
        InternalFrame internalFrame = (InternalFrame) obj;
        return d.a(this.f2796c, internalFrame.f2796c) && d.a(this.f2795b, internalFrame.f2795b) && d.a(this.f2797d, internalFrame.f2797d);
    }

    public final int hashCode() {
        String str = this.f2795b;
        int hashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f2796c;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f2797d;
        return hashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    @Override // com.google.android.exoplayer2.metadata.id3.Id3Frame
    public final String toString() {
        return this.f2794a + ": domain=" + this.f2795b + ", description=" + this.f2796c;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(this.f2794a);
        parcel.writeString(this.f2795b);
        parcel.writeString(this.f2797d);
    }
}