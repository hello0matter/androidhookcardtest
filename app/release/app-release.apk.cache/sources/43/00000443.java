package com.google.android.exoplayer2.offline;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import k1.b;
import l1.d;

@Deprecated
/* loaded from: classes.dex */
public final class DownloadRequest implements Parcelable {
    public static final Parcelable.Creator<DownloadRequest> CREATOR = new b(4);

    /* renamed from: a  reason: collision with root package name */
    public final String f2843a;

    /* renamed from: b  reason: collision with root package name */
    public final Uri f2844b;

    /* renamed from: c  reason: collision with root package name */
    public final String f2845c;

    /* renamed from: d  reason: collision with root package name */
    public final List f2846d;

    /* renamed from: e  reason: collision with root package name */
    public final byte[] f2847e;

    /* renamed from: f  reason: collision with root package name */
    public final String f2848f;

    /* renamed from: g  reason: collision with root package name */
    public final byte[] f2849g;

    public DownloadRequest(Parcel parcel) {
        String readString = parcel.readString();
        int i4 = d.f5272a;
        this.f2843a = readString;
        this.f2844b = Uri.parse(parcel.readString());
        this.f2845c = parcel.readString();
        int readInt = parcel.readInt();
        ArrayList arrayList = new ArrayList(readInt);
        for (int i5 = 0; i5 < readInt; i5++) {
            arrayList.add((StreamKey) parcel.readParcelable(StreamKey.class.getClassLoader()));
        }
        this.f2846d = Collections.unmodifiableList(arrayList);
        this.f2847e = parcel.createByteArray();
        this.f2848f = parcel.readString();
        this.f2849g = parcel.createByteArray();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof DownloadRequest) {
            DownloadRequest downloadRequest = (DownloadRequest) obj;
            return this.f2843a.equals(downloadRequest.f2843a) && this.f2844b.equals(downloadRequest.f2844b) && d.a(this.f2845c, downloadRequest.f2845c) && this.f2846d.equals(downloadRequest.f2846d) && Arrays.equals(this.f2847e, downloadRequest.f2847e) && d.a(this.f2848f, downloadRequest.f2848f) && Arrays.equals(this.f2849g, downloadRequest.f2849g);
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = (this.f2844b.hashCode() + (this.f2843a.hashCode() * 961)) * 31;
        String str = this.f2845c;
        int hashCode2 = str != null ? str.hashCode() : 0;
        int hashCode3 = (Arrays.hashCode(this.f2847e) + ((this.f2846d.hashCode() + ((hashCode + hashCode2) * 31)) * 31)) * 31;
        String str2 = this.f2848f;
        return Arrays.hashCode(this.f2849g) + ((hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31);
    }

    public final String toString() {
        return this.f2845c + ":" + this.f2843a;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(this.f2843a);
        parcel.writeString(this.f2844b.toString());
        parcel.writeString(this.f2845c);
        List list = this.f2846d;
        parcel.writeInt(list.size());
        for (int i5 = 0; i5 < list.size(); i5++) {
            parcel.writeParcelable((Parcelable) list.get(i5), 0);
        }
        parcel.writeByteArray(this.f2847e);
        parcel.writeString(this.f2848f);
        parcel.writeByteArray(this.f2849g);
    }
}