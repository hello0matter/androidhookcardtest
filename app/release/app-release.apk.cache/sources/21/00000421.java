package com.google.android.exoplayer2.metadata.dvbsi;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.activity.j;
import androidx.activity.result.a;
import com.google.android.exoplayer2.metadata.Metadata;

@Deprecated
/* loaded from: classes.dex */
public final class AppInfoTable implements Metadata.Entry {
    public static final Parcelable.Creator<AppInfoTable> CREATOR = new a(8);

    /* renamed from: a  reason: collision with root package name */
    public final int f2744a;

    /* renamed from: b  reason: collision with root package name */
    public final String f2745b;

    public AppInfoTable(String str, int i4) {
        this.f2744a = i4;
        this.f2745b = str;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Ait(controlCode=");
        sb.append(this.f2744a);
        sb.append(",url=");
        return j.e(sb, this.f2745b, ")");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(this.f2745b);
        parcel.writeInt(this.f2744a);
    }
}