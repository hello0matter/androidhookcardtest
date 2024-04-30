package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.activity.result.a;
import java.util.Arrays;
import l1.d;

@Deprecated
/* loaded from: classes.dex */
public final class ChapterFrame extends Id3Frame {
    public static final Parcelable.Creator<ChapterFrame> CREATOR = new a(16);

    /* renamed from: b  reason: collision with root package name */
    public final String f2776b;

    /* renamed from: c  reason: collision with root package name */
    public final int f2777c;

    /* renamed from: d  reason: collision with root package name */
    public final int f2778d;

    /* renamed from: e  reason: collision with root package name */
    public final long f2779e;

    /* renamed from: f  reason: collision with root package name */
    public final long f2780f;

    /* renamed from: g  reason: collision with root package name */
    public final Id3Frame[] f2781g;

    public ChapterFrame(Parcel parcel) {
        super("CHAP");
        String readString = parcel.readString();
        int i4 = d.f5272a;
        this.f2776b = readString;
        this.f2777c = parcel.readInt();
        this.f2778d = parcel.readInt();
        this.f2779e = parcel.readLong();
        this.f2780f = parcel.readLong();
        int readInt = parcel.readInt();
        this.f2781g = new Id3Frame[readInt];
        for (int i5 = 0; i5 < readInt; i5++) {
            this.f2781g[i5] = (Id3Frame) parcel.readParcelable(Id3Frame.class.getClassLoader());
        }
    }

    @Override // com.google.android.exoplayer2.metadata.id3.Id3Frame, android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ChapterFrame.class != obj.getClass()) {
            return false;
        }
        ChapterFrame chapterFrame = (ChapterFrame) obj;
        return this.f2777c == chapterFrame.f2777c && this.f2778d == chapterFrame.f2778d && this.f2779e == chapterFrame.f2779e && this.f2780f == chapterFrame.f2780f && d.a(this.f2776b, chapterFrame.f2776b) && Arrays.equals(this.f2781g, chapterFrame.f2781g);
    }

    public final int hashCode() {
        int i4 = (((((((527 + this.f2777c) * 31) + this.f2778d) * 31) + ((int) this.f2779e)) * 31) + ((int) this.f2780f)) * 31;
        String str = this.f2776b;
        return i4 + (str != null ? str.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(this.f2776b);
        parcel.writeInt(this.f2777c);
        parcel.writeInt(this.f2778d);
        parcel.writeLong(this.f2779e);
        parcel.writeLong(this.f2780f);
        Id3Frame[] id3FrameArr = this.f2781g;
        parcel.writeInt(id3FrameArr.length);
        for (Id3Frame id3Frame : id3FrameArr) {
            parcel.writeParcelable(id3Frame, 0);
        }
    }
}