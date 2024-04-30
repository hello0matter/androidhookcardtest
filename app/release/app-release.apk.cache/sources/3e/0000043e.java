package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import k1.b;
import k1.c;
import k1.d;

@Deprecated
/* loaded from: classes.dex */
public final class SpliceScheduleCommand extends SpliceCommand {
    public static final Parcelable.Creator<SpliceScheduleCommand> CREATOR = new b(1);

    /* renamed from: a  reason: collision with root package name */
    public final List f2840a;

    public SpliceScheduleCommand(Parcel parcel) {
        int readInt = parcel.readInt();
        ArrayList arrayList = new ArrayList(readInt);
        for (int i4 = 0; i4 < readInt; i4++) {
            arrayList.add(new d(parcel));
        }
        this.f2840a = Collections.unmodifiableList(arrayList);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        List list = this.f2840a;
        int size = list.size();
        parcel.writeInt(size);
        for (int i5 = 0; i5 < size; i5++) {
            d dVar = (d) list.get(i5);
            parcel.writeLong(dVar.f5121a);
            parcel.writeByte(dVar.f5122b ? (byte) 1 : (byte) 0);
            parcel.writeByte(dVar.f5123c ? (byte) 1 : (byte) 0);
            parcel.writeByte(dVar.f5124d ? (byte) 1 : (byte) 0);
            List list2 = dVar.f5126f;
            int size2 = list2.size();
            parcel.writeInt(size2);
            for (int i6 = 0; i6 < size2; i6++) {
                c cVar = (c) list2.get(i6);
                parcel.writeInt(cVar.f5119a);
                parcel.writeLong(cVar.f5120b);
            }
            parcel.writeLong(dVar.f5125e);
            parcel.writeByte(dVar.f5127g ? (byte) 1 : (byte) 0);
            parcel.writeLong(dVar.f5128h);
            parcel.writeInt(dVar.f5129i);
            parcel.writeInt(dVar.f5130j);
            parcel.writeInt(dVar.f5131k);
        }
    }
}