package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.activity.result.a;
import l1.d;

@Deprecated
/* loaded from: classes.dex */
public final class PrivateCommand extends SpliceCommand {
    public static final Parcelable.Creator<PrivateCommand> CREATOR = new a(28);

    /* renamed from: a  reason: collision with root package name */
    public final long f2824a;

    /* renamed from: b  reason: collision with root package name */
    public final long f2825b;

    /* renamed from: c  reason: collision with root package name */
    public final byte[] f2826c;

    public PrivateCommand(Parcel parcel) {
        this.f2824a = parcel.readLong();
        this.f2825b = parcel.readLong();
        byte[] createByteArray = parcel.createByteArray();
        int i4 = d.f5272a;
        this.f2826c = createByteArray;
    }

    @Override // com.google.android.exoplayer2.metadata.scte35.SpliceCommand
    public final String toString() {
        return "SCTE-35 PrivateCommand { ptsAdjustment=" + this.f2824a + ", identifier= " + this.f2825b + " }";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeLong(this.f2824a);
        parcel.writeLong(this.f2825b);
        parcel.writeByteArray(this.f2826c);
    }
}