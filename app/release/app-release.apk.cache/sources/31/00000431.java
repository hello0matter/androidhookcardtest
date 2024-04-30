package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.activity.result.a;
import com.google.common.collect.ImmutableList;
import l1.d;

@Deprecated
/* loaded from: classes.dex */
public final class TextInformationFrame extends Id3Frame {
    public static final Parcelable.Creator<TextInformationFrame> CREATOR = new a(23);

    /* renamed from: b  reason: collision with root package name */
    public final String f2805b;

    /* renamed from: c  reason: collision with root package name */
    public final ImmutableList f2806c;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public TextInformationFrame(android.os.Parcel r3) {
        /*
            r2 = this;
            java.lang.String r0 = r3.readString()
            r0.getClass()
            java.lang.String r1 = r3.readString()
            java.lang.String[] r3 = r3.createStringArray()
            r3.getClass()
            com.google.common.collect.ImmutableList r3 = com.google.common.collect.ImmutableList.h(r3)
            r2.<init>(r0)
            boolean r0 = r3.isEmpty()
            r0 = r0 ^ 1
            com.google.common.collect.c.z(r0)
            r2.f2805b = r1
            com.google.common.collect.ImmutableList r3 = com.google.common.collect.ImmutableList.g(r3)
            r2.f2806c = r3
            r0 = 0
            java.lang.Object r3 = r3.get(r0)
            java.lang.String r3 = (java.lang.String) r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.metadata.id3.TextInformationFrame.<init>(android.os.Parcel):void");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || TextInformationFrame.class != obj.getClass()) {
            return false;
        }
        TextInformationFrame textInformationFrame = (TextInformationFrame) obj;
        return d.a(this.f2794a, textInformationFrame.f2794a) && d.a(this.f2805b, textInformationFrame.f2805b) && this.f2806c.equals(textInformationFrame.f2806c);
    }

    public final int hashCode() {
        int hashCode = (this.f2794a.hashCode() + 527) * 31;
        String str = this.f2805b;
        return this.f2806c.hashCode() + ((hashCode + (str != null ? str.hashCode() : 0)) * 31);
    }

    @Override // com.google.android.exoplayer2.metadata.id3.Id3Frame
    public final String toString() {
        return this.f2794a + ": description=" + this.f2805b + ": values=" + this.f2806c;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(this.f2794a);
        parcel.writeString(this.f2805b);
        parcel.writeStringArray((String[]) this.f2806c.toArray(new String[0]));
    }
}