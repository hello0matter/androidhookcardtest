package com.google.android.exoplayer2.drm;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.UUID;
import l1.d;

@Deprecated
/* loaded from: classes.dex */
public final class DrmInitData implements Comparator<SchemeData>, Parcelable {
    public static final Parcelable.Creator<DrmInitData> CREATOR = new androidx.activity.result.a(6);

    /* renamed from: a  reason: collision with root package name */
    public final SchemeData[] f2734a;

    /* renamed from: b  reason: collision with root package name */
    public int f2735b;

    /* renamed from: c  reason: collision with root package name */
    public final String f2736c;

    /* loaded from: classes.dex */
    public static final class SchemeData implements Parcelable {
        public static final Parcelable.Creator<SchemeData> CREATOR = new Object();

        /* renamed from: a  reason: collision with root package name */
        public int f2737a;

        /* renamed from: b  reason: collision with root package name */
        public final UUID f2738b;

        /* renamed from: c  reason: collision with root package name */
        public final String f2739c;

        /* renamed from: d  reason: collision with root package name */
        public final String f2740d;

        /* renamed from: e  reason: collision with root package name */
        public final byte[] f2741e;

        public SchemeData(Parcel parcel) {
            this.f2738b = new UUID(parcel.readLong(), parcel.readLong());
            this.f2739c = parcel.readString();
            String readString = parcel.readString();
            int i4 = d.f5272a;
            this.f2740d = readString;
            this.f2741e = parcel.createByteArray();
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final boolean equals(Object obj) {
            if (obj instanceof SchemeData) {
                if (obj == this) {
                    return true;
                }
                SchemeData schemeData = (SchemeData) obj;
                return d.a(this.f2739c, schemeData.f2739c) && d.a(this.f2740d, schemeData.f2740d) && d.a(this.f2738b, schemeData.f2738b) && Arrays.equals(this.f2741e, schemeData.f2741e);
            }
            return false;
        }

        public final int hashCode() {
            if (this.f2737a == 0) {
                int hashCode = this.f2738b.hashCode() * 31;
                String str = this.f2739c;
                int hashCode2 = str == null ? 0 : str.hashCode();
                this.f2737a = Arrays.hashCode(this.f2741e) + ((this.f2740d.hashCode() + ((hashCode + hashCode2) * 31)) * 31);
            }
            return this.f2737a;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i4) {
            UUID uuid = this.f2738b;
            parcel.writeLong(uuid.getMostSignificantBits());
            parcel.writeLong(uuid.getLeastSignificantBits());
            parcel.writeString(this.f2739c);
            parcel.writeString(this.f2740d);
            parcel.writeByteArray(this.f2741e);
        }
    }

    public DrmInitData(Parcel parcel) {
        this.f2736c = parcel.readString();
        SchemeData[] schemeDataArr = (SchemeData[]) parcel.createTypedArray(SchemeData.CREATOR);
        int i4 = d.f5272a;
        this.f2734a = schemeDataArr;
        int length = schemeDataArr.length;
    }

    @Override // java.util.Comparator
    public final int compare(SchemeData schemeData, SchemeData schemeData2) {
        SchemeData schemeData3 = schemeData;
        SchemeData schemeData4 = schemeData2;
        UUID uuid = i1.a.f5019a;
        if (uuid.equals(schemeData3.f2738b)) {
            if (uuid.equals(schemeData4.f2738b)) {
                return 0;
            }
            return 1;
        }
        return schemeData3.f2738b.compareTo(schemeData4.f2738b);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // java.util.Comparator
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || DrmInitData.class != obj.getClass()) {
            return false;
        }
        DrmInitData drmInitData = (DrmInitData) obj;
        return d.a(this.f2736c, drmInitData.f2736c) && Arrays.equals(this.f2734a, drmInitData.f2734a);
    }

    public final int hashCode() {
        if (this.f2735b == 0) {
            String str = this.f2736c;
            this.f2735b = ((str == null ? 0 : str.hashCode()) * 31) + Arrays.hashCode(this.f2734a);
        }
        return this.f2735b;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(this.f2736c);
        parcel.writeTypedArray(this.f2734a, 0);
    }
}