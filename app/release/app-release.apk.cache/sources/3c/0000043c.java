package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.activity.result.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Deprecated
/* loaded from: classes.dex */
public final class SpliceInsertCommand extends SpliceCommand {
    public static final Parcelable.Creator<SpliceInsertCommand> CREATOR = new a(29);

    /* renamed from: a  reason: collision with root package name */
    public final long f2827a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f2828b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f2829c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f2830d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f2831e;

    /* renamed from: f  reason: collision with root package name */
    public final long f2832f;

    /* renamed from: g  reason: collision with root package name */
    public final long f2833g;

    /* renamed from: h  reason: collision with root package name */
    public final List f2834h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f2835i;

    /* renamed from: j  reason: collision with root package name */
    public final long f2836j;

    /* renamed from: k  reason: collision with root package name */
    public final int f2837k;

    /* renamed from: l  reason: collision with root package name */
    public final int f2838l;

    /* renamed from: m  reason: collision with root package name */
    public final int f2839m;

    public SpliceInsertCommand(Parcel parcel) {
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        this.f2827a = parcel.readLong();
        if (parcel.readByte() == 1) {
            z4 = true;
        } else {
            z4 = false;
        }
        this.f2828b = z4;
        if (parcel.readByte() == 1) {
            z5 = true;
        } else {
            z5 = false;
        }
        this.f2829c = z5;
        if (parcel.readByte() == 1) {
            z6 = true;
        } else {
            z6 = false;
        }
        this.f2830d = z6;
        if (parcel.readByte() == 1) {
            z7 = true;
        } else {
            z7 = false;
        }
        this.f2831e = z7;
        this.f2832f = parcel.readLong();
        this.f2833g = parcel.readLong();
        int readInt = parcel.readInt();
        ArrayList arrayList = new ArrayList(readInt);
        for (int i4 = 0; i4 < readInt; i4++) {
            arrayList.add(new k1.a(parcel.readInt(), parcel.readLong(), parcel.readLong()));
        }
        this.f2834h = Collections.unmodifiableList(arrayList);
        this.f2835i = parcel.readByte() == 1;
        this.f2836j = parcel.readLong();
        this.f2837k = parcel.readInt();
        this.f2838l = parcel.readInt();
        this.f2839m = parcel.readInt();
    }

    @Override // com.google.android.exoplayer2.metadata.scte35.SpliceCommand
    public final String toString() {
        return "SCTE-35 SpliceInsertCommand { programSplicePts=" + this.f2832f + ", programSplicePlaybackPositionUs= " + this.f2833g + " }";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeLong(this.f2827a);
        parcel.writeByte(this.f2828b ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f2829c ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f2830d ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f2831e ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.f2832f);
        parcel.writeLong(this.f2833g);
        List list = this.f2834h;
        int size = list.size();
        parcel.writeInt(size);
        for (int i5 = 0; i5 < size; i5++) {
            k1.a aVar = (k1.a) list.get(i5);
            parcel.writeInt(aVar.f5115a);
            parcel.writeLong(aVar.f5116b);
            parcel.writeLong(aVar.f5117c);
        }
        parcel.writeByte(this.f2835i ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.f2836j);
        parcel.writeInt(this.f2837k);
        parcel.writeInt(this.f2838l);
        parcel.writeInt(this.f2839m);
    }
}