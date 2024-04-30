package com.google.android.exoplayer2.metadata;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.activity.result.a;
import com.google.common.collect.c;
import java.util.Arrays;

@Deprecated
/* loaded from: classes.dex */
public final class Metadata implements Parcelable {
    public static final Parcelable.Creator<Metadata> CREATOR = new a(7);

    /* renamed from: a  reason: collision with root package name */
    public final Entry[] f2742a;

    /* renamed from: b  reason: collision with root package name */
    public final long f2743b;

    /* loaded from: classes.dex */
    public interface Entry extends Parcelable {
    }

    public Metadata(Parcel parcel) {
        this.f2742a = new Entry[parcel.readInt()];
        int i4 = 0;
        while (true) {
            Entry[] entryArr = this.f2742a;
            if (i4 >= entryArr.length) {
                this.f2743b = parcel.readLong();
                return;
            } else {
                entryArr[i4] = (Entry) parcel.readParcelable(Entry.class.getClassLoader());
                i4++;
            }
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Metadata.class != obj.getClass()) {
            return false;
        }
        Metadata metadata = (Metadata) obj;
        return Arrays.equals(this.f2742a, metadata.f2742a) && this.f2743b == metadata.f2743b;
    }

    public final int hashCode() {
        return c.U0(this.f2743b) + (Arrays.hashCode(this.f2742a) * 31);
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder("entries=");
        sb.append(Arrays.toString(this.f2742a));
        long j4 = this.f2743b;
        if (j4 == -9223372036854775807L) {
            str = "";
        } else {
            str = ", presentationTimeUs=" + j4;
        }
        sb.append(str);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        Entry[] entryArr = this.f2742a;
        parcel.writeInt(entryArr.length);
        for (Entry entry : entryArr) {
            parcel.writeParcelable(entry, 0);
        }
        parcel.writeLong(this.f2743b);
    }
}