package androidx.recyclerview.widget;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class q1 implements Parcelable.Creator {
    /* JADX WARN: Type inference failed for: r0v0, types: [androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem, java.lang.Object] */
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        ?? obj = new Object();
        obj.f2028a = parcel.readInt();
        obj.f2029b = parcel.readInt();
        boolean z4 = true;
        if (parcel.readInt() != 1) {
            z4 = false;
        }
        obj.f2031d = z4;
        int readInt = parcel.readInt();
        if (readInt > 0) {
            int[] iArr = new int[readInt];
            obj.f2030c = iArr;
            parcel.readIntArray(iArr);
        }
        return obj;
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i4) {
        return new StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem[i4];
    }
}