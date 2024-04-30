package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import k1.b;

@Deprecated
/* loaded from: classes.dex */
public final class TimeSignalCommand extends SpliceCommand {
    public static final Parcelable.Creator<TimeSignalCommand> CREATOR = new b(2);

    /* renamed from: a  reason: collision with root package name */
    public final long f2841a;

    /* renamed from: b  reason: collision with root package name */
    public final long f2842b;

    public TimeSignalCommand(long j4, long j5) {
        this.f2841a = j4;
        this.f2842b = j5;
    }

    @Override // com.google.android.exoplayer2.metadata.scte35.SpliceCommand
    public final String toString() {
        return "SCTE-35 TimeSignalCommand { ptsTime=" + this.f2841a + ", playbackPositionUs= " + this.f2842b + " }";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeLong(this.f2841a);
        parcel.writeLong(this.f2842b);
    }
}