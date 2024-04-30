package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.activity.result.a;
import java.util.Arrays;
import l1.d;

@Deprecated
/* loaded from: classes.dex */
public final class ChapterTocFrame extends Id3Frame {
    public static final Parcelable.Creator<ChapterTocFrame> CREATOR = new a(17);

    /* renamed from: b  reason: collision with root package name */
    public final String f2782b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f2783c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f2784d;

    /* renamed from: e  reason: collision with root package name */
    public final String[] f2785e;

    /* renamed from: f  reason: collision with root package name */
    public final Id3Frame[] f2786f;

    public ChapterTocFrame(Parcel parcel) {
        super("CTOC");
        boolean z4;
        String readString = parcel.readString();
        int i4 = d.f5272a;
        this.f2782b = readString;
        if (parcel.readByte() != 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        this.f2783c = z4;
        this.f2784d = parcel.readByte() != 0;
        this.f2785e = parcel.createStringArray();
        int readInt = parcel.readInt();
        this.f2786f = new Id3Frame[readInt];
        for (int i5 = 0; i5 < readInt; i5++) {
            this.f2786f[i5] = (Id3Frame) parcel.readParcelable(Id3Frame.class.getClassLoader());
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ChapterTocFrame.class != obj.getClass()) {
            return false;
        }
        ChapterTocFrame chapterTocFrame = (ChapterTocFrame) obj;
        return this.f2783c == chapterTocFrame.f2783c && this.f2784d == chapterTocFrame.f2784d && d.a(this.f2782b, chapterTocFrame.f2782b) && Arrays.equals(this.f2785e, chapterTocFrame.f2785e) && Arrays.equals(this.f2786f, chapterTocFrame.f2786f);
    }

    public final int hashCode() {
        int i4 = (((527 + (this.f2783c ? 1 : 0)) * 31) + (this.f2784d ? 1 : 0)) * 31;
        String str = this.f2782b;
        return i4 + (str != null ? str.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(this.f2782b);
        parcel.writeByte(this.f2783c ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f2784d ? (byte) 1 : (byte) 0);
        parcel.writeStringArray(this.f2785e);
        Id3Frame[] id3FrameArr = this.f2786f;
        parcel.writeInt(id3FrameArr.length);
        for (Id3Frame id3Frame : id3FrameArr) {
            parcel.writeParcelable(id3Frame, 0);
        }
    }
}