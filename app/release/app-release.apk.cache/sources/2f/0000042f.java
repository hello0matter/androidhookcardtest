package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.activity.result.a;
import java.util.Arrays;
import l1.d;

@Deprecated
/* loaded from: classes.dex */
public final class MlltFrame extends Id3Frame {
    public static final Parcelable.Creator<MlltFrame> CREATOR = new a(21);

    /* renamed from: b  reason: collision with root package name */
    public final int f2798b;

    /* renamed from: c  reason: collision with root package name */
    public final int f2799c;

    /* renamed from: d  reason: collision with root package name */
    public final int f2800d;

    /* renamed from: e  reason: collision with root package name */
    public final int[] f2801e;

    /* renamed from: f  reason: collision with root package name */
    public final int[] f2802f;

    public MlltFrame(Parcel parcel) {
        super("MLLT");
        this.f2798b = parcel.readInt();
        this.f2799c = parcel.readInt();
        this.f2800d = parcel.readInt();
        int[] createIntArray = parcel.createIntArray();
        int i4 = d.f5272a;
        this.f2801e = createIntArray;
        this.f2802f = parcel.createIntArray();
    }

    @Override // com.google.android.exoplayer2.metadata.id3.Id3Frame, android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || MlltFrame.class != obj.getClass()) {
            return false;
        }
        MlltFrame mlltFrame = (MlltFrame) obj;
        return this.f2798b == mlltFrame.f2798b && this.f2799c == mlltFrame.f2799c && this.f2800d == mlltFrame.f2800d && Arrays.equals(this.f2801e, mlltFrame.f2801e) && Arrays.equals(this.f2802f, mlltFrame.f2802f);
    }

    public final int hashCode() {
        int hashCode = Arrays.hashCode(this.f2801e);
        return Arrays.hashCode(this.f2802f) + ((hashCode + ((((((527 + this.f2798b) * 31) + this.f2799c) * 31) + this.f2800d) * 31)) * 31);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeInt(this.f2798b);
        parcel.writeInt(this.f2799c);
        parcel.writeInt(this.f2800d);
        parcel.writeIntArray(this.f2801e);
        parcel.writeIntArray(this.f2802f);
    }
}