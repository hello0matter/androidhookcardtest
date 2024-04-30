package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
class StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem implements Parcelable {
    public static final Parcelable.Creator<StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem> CREATOR = new Object();

    /* renamed from: a  reason: collision with root package name */
    public int f2028a;

    /* renamed from: b  reason: collision with root package name */
    public int f2029b;

    /* renamed from: c  reason: collision with root package name */
    public int[] f2030c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f2031d;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return "FullSpanItem{mPosition=" + this.f2028a + ", mGapDir=" + this.f2029b + ", mHasUnwantedGapAfter=" + this.f2031d + ", mGapPerSpan=" + Arrays.toString(this.f2030c) + '}';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeInt(this.f2028a);
        parcel.writeInt(this.f2029b);
        parcel.writeInt(this.f2031d ? 1 : 0);
        int[] iArr = this.f2030c;
        if (iArr == null || iArr.length <= 0) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(iArr.length);
        parcel.writeIntArray(this.f2030c);
    }
}