package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.activity.result.a;
import l1.d;

@Deprecated
/* loaded from: classes.dex */
public final class CommentFrame extends Id3Frame {
    public static final Parcelable.Creator<CommentFrame> CREATOR = new a(18);

    /* renamed from: b  reason: collision with root package name */
    public final String f2787b;

    /* renamed from: c  reason: collision with root package name */
    public final String f2788c;

    /* renamed from: d  reason: collision with root package name */
    public final String f2789d;

    public CommentFrame(Parcel parcel) {
        super("COMM");
        String readString = parcel.readString();
        int i4 = d.f5272a;
        this.f2787b = readString;
        this.f2788c = parcel.readString();
        this.f2789d = parcel.readString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || CommentFrame.class != obj.getClass()) {
            return false;
        }
        CommentFrame commentFrame = (CommentFrame) obj;
        return d.a(this.f2788c, commentFrame.f2788c) && d.a(this.f2787b, commentFrame.f2787b) && d.a(this.f2789d, commentFrame.f2789d);
    }

    public final int hashCode() {
        String str = this.f2787b;
        int hashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f2788c;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f2789d;
        return hashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    @Override // com.google.android.exoplayer2.metadata.id3.Id3Frame
    public final String toString() {
        return this.f2794a + ": language=" + this.f2787b + ", description=" + this.f2788c;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(this.f2794a);
        parcel.writeString(this.f2787b);
        parcel.writeString(this.f2789d);
    }
}