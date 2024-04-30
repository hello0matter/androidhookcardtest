package com.google.android.exoplayer2.metadata.emsg;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.activity.result.a;
import com.google.android.exoplayer2.metadata.Metadata;
import i1.d;
import java.util.Arrays;

@Deprecated
/* loaded from: classes.dex */
public final class EventMessage implements Metadata.Entry {
    public static final Parcelable.Creator<EventMessage> CREATOR;

    /* renamed from: a  reason: collision with root package name */
    public final String f2746a;

    /* renamed from: b  reason: collision with root package name */
    public final String f2747b;

    /* renamed from: c  reason: collision with root package name */
    public final long f2748c;

    /* renamed from: d  reason: collision with root package name */
    public final long f2749d;

    /* renamed from: e  reason: collision with root package name */
    public final byte[] f2750e;

    /* renamed from: f  reason: collision with root package name */
    public int f2751f;

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, i1.c] */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, i1.c] */
    static {
        ?? obj = new Object();
        obj.f5021a = "application/id3";
        new d(obj);
        ?? obj2 = new Object();
        obj2.f5021a = "application/x-scte35";
        new d(obj2);
        CREATOR = new a(9);
    }

    public EventMessage(Parcel parcel) {
        String readString = parcel.readString();
        int i4 = l1.d.f5272a;
        this.f2746a = readString;
        this.f2747b = parcel.readString();
        this.f2748c = parcel.readLong();
        this.f2749d = parcel.readLong();
        this.f2750e = parcel.createByteArray();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || EventMessage.class != obj.getClass()) {
            return false;
        }
        EventMessage eventMessage = (EventMessage) obj;
        return this.f2748c == eventMessage.f2748c && this.f2749d == eventMessage.f2749d && l1.d.a(this.f2746a, eventMessage.f2746a) && l1.d.a(this.f2747b, eventMessage.f2747b) && Arrays.equals(this.f2750e, eventMessage.f2750e);
    }

    public final int hashCode() {
        if (this.f2751f == 0) {
            String str = this.f2746a;
            int hashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.f2747b;
            int hashCode2 = str2 != null ? str2.hashCode() : 0;
            long j4 = this.f2748c;
            long j5 = this.f2749d;
            this.f2751f = Arrays.hashCode(this.f2750e) + ((((((hashCode + hashCode2) * 31) + ((int) (j4 ^ (j4 >>> 32)))) * 31) + ((int) (j5 ^ (j5 >>> 32)))) * 31);
        }
        return this.f2751f;
    }

    public final String toString() {
        return "EMSG: scheme=" + this.f2746a + ", id=" + this.f2749d + ", durationMs=" + this.f2748c + ", value=" + this.f2747b;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(this.f2746a);
        parcel.writeString(this.f2747b);
        parcel.writeLong(this.f2748c);
        parcel.writeLong(this.f2749d);
        parcel.writeByteArray(this.f2750e);
    }
}