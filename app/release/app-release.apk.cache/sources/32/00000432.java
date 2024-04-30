package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.activity.result.a;
import l1.d;

@Deprecated
/* loaded from: classes.dex */
public final class UrlLinkFrame extends Id3Frame {
    public static final Parcelable.Creator<UrlLinkFrame> CREATOR = new a(24);

    /* renamed from: b  reason: collision with root package name */
    public final String f2807b;

    /* renamed from: c  reason: collision with root package name */
    public final String f2808c;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public UrlLinkFrame(android.os.Parcel r3) {
        /*
            r2 = this;
            java.lang.String r0 = r3.readString()
            int r1 = l1.d.f5272a
            r2.<init>(r0)
            java.lang.String r0 = r3.readString()
            r2.f2807b = r0
            java.lang.String r3 = r3.readString()
            r2.f2808c = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.metadata.id3.UrlLinkFrame.<init>(android.os.Parcel):void");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || UrlLinkFrame.class != obj.getClass()) {
            return false;
        }
        UrlLinkFrame urlLinkFrame = (UrlLinkFrame) obj;
        return this.f2794a.equals(urlLinkFrame.f2794a) && d.a(this.f2807b, urlLinkFrame.f2807b) && d.a(this.f2808c, urlLinkFrame.f2808c);
    }

    public final int hashCode() {
        int hashCode = (this.f2794a.hashCode() + 527) * 31;
        String str = this.f2807b;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f2808c;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    @Override // com.google.android.exoplayer2.metadata.id3.Id3Frame
    public final String toString() {
        return this.f2794a + ": url=" + this.f2808c;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(this.f2794a);
        parcel.writeString(this.f2807b);
        parcel.writeString(this.f2808c);
    }
}