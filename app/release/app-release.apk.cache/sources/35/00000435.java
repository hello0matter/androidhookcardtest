package com.google.android.exoplayer2.metadata.mp4;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.common.collect.c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import l1.d;

@Deprecated
/* loaded from: classes.dex */
public final class SlowMotionData implements Metadata.Entry {
    public static final Parcelable.Creator<SlowMotionData> CREATOR = new Object();

    /* renamed from: a  reason: collision with root package name */
    public final List f2818a;

    /* loaded from: classes.dex */
    public static final class Segment implements Parcelable {
        public static final Parcelable.Creator<Segment> CREATOR = new Object();

        /* renamed from: a  reason: collision with root package name */
        public final long f2819a;

        /* renamed from: b  reason: collision with root package name */
        public final long f2820b;

        /* renamed from: c  reason: collision with root package name */
        public final int f2821c;

        public Segment(int i4, long j4, long j5) {
            boolean z4;
            if (j4 < j5) {
                z4 = true;
            } else {
                z4 = false;
            }
            c.z(z4);
            this.f2819a = j4;
            this.f2820b = j5;
            this.f2821c = i4;
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || Segment.class != obj.getClass()) {
                return false;
            }
            Segment segment = (Segment) obj;
            return this.f2819a == segment.f2819a && this.f2820b == segment.f2820b && this.f2821c == segment.f2821c;
        }

        public final int hashCode() {
            return Arrays.hashCode(new Object[]{Long.valueOf(this.f2819a), Long.valueOf(this.f2820b), Integer.valueOf(this.f2821c)});
        }

        public final String toString() {
            int i4 = d.f5272a;
            Locale locale = Locale.US;
            return "Segment: startTimeMs=" + this.f2819a + ", endTimeMs=" + this.f2820b + ", speedDivisor=" + this.f2821c;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i4) {
            parcel.writeLong(this.f2819a);
            parcel.writeLong(this.f2820b);
            parcel.writeInt(this.f2821c);
        }
    }

    public SlowMotionData(ArrayList arrayList) {
        this.f2818a = arrayList;
        boolean z4 = false;
        if (!arrayList.isEmpty()) {
            long j4 = ((Segment) arrayList.get(0)).f2820b;
            int i4 = 1;
            while (true) {
                if (i4 >= arrayList.size()) {
                    break;
                } else if (((Segment) arrayList.get(i4)).f2819a < j4) {
                    z4 = true;
                    break;
                } else {
                    j4 = ((Segment) arrayList.get(i4)).f2820b;
                    i4++;
                }
            }
        }
        c.z(!z4);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || SlowMotionData.class != obj.getClass()) {
            return false;
        }
        return this.f2818a.equals(((SlowMotionData) obj).f2818a);
    }

    public final int hashCode() {
        return this.f2818a.hashCode();
    }

    public final String toString() {
        return "SlowMotion: segments=" + this.f2818a;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeList(this.f2818a);
    }
}