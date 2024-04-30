package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.activity.result.a;
import java.util.Arrays;
import l1.d;

@Deprecated
/* loaded from: classes.dex */
public final class ApicFrame extends Id3Frame {
    public static final Parcelable.Creator<ApicFrame> CREATOR = new a(14);

    /* renamed from: b  reason: collision with root package name */
    public final String f2771b;

    /* renamed from: c  reason: collision with root package name */
    public final String f2772c;

    /* renamed from: d  reason: collision with root package name */
    public final int f2773d;

    /* renamed from: e  reason: collision with root package name */
    public final byte[] f2774e;

    public ApicFrame(Parcel parcel) {
        super("APIC");
        String readString = parcel.readString();
        int i4 = d.f5272a;
        this.f2771b = readString;
        this.f2772c = parcel.readString();
        this.f2773d = parcel.readInt();
        this.f2774e = parcel.createByteArray();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ApicFrame.class != obj.getClass()) {
            return false;
        }
        ApicFrame apicFrame = (ApicFrame) obj;
        return this.f2773d == apicFrame.f2773d && d.a(this.f2771b, apicFrame.f2771b) && d.a(this.f2772c, apicFrame.f2772c) && Arrays.equals(this.f2774e, apicFrame.f2774e);
    }

    public final int hashCode() {
        int i4 = (527 + this.f2773d) * 31;
        String str = this.f2771b;
        int hashCode = (i4 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f2772c;
        return Arrays.hashCode(this.f2774e) + ((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31);
    }

    @Override // com.google.android.exoplayer2.metadata.id3.Id3Frame
    public final String toString() {
        return this.f2794a + ": mimeType=" + this.f2771b + ", description=" + this.f2772c;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(this.f2771b);
        parcel.writeString(this.f2772c);
        parcel.writeInt(this.f2773d);
        parcel.writeByteArray(this.f2774e);
    }
}