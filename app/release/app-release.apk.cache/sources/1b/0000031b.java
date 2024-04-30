package androidx.recyclerview.widget;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

/* loaded from: classes.dex */
public final class s1 implements Parcelable.Creator {
    /* JADX WARN: Type inference failed for: r0v0, types: [androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState, java.lang.Object] */
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        boolean z4;
        boolean z5;
        ?? obj = new Object();
        obj.f2032a = parcel.readInt();
        obj.f2033b = parcel.readInt();
        int readInt = parcel.readInt();
        obj.f2034c = readInt;
        if (readInt > 0) {
            int[] iArr = new int[readInt];
            obj.f2035d = iArr;
            parcel.readIntArray(iArr);
        }
        int readInt2 = parcel.readInt();
        obj.f2036e = readInt2;
        if (readInt2 > 0) {
            int[] iArr2 = new int[readInt2];
            obj.f2037f = iArr2;
            parcel.readIntArray(iArr2);
        }
        boolean z6 = false;
        if (parcel.readInt() == 1) {
            z4 = true;
        } else {
            z4 = false;
        }
        obj.f2039h = z4;
        if (parcel.readInt() == 1) {
            z5 = true;
        } else {
            z5 = false;
        }
        obj.f2040i = z5;
        if (parcel.readInt() == 1) {
            z6 = true;
        }
        obj.f2041j = z6;
        obj.f2038g = parcel.readArrayList(StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem.class.getClassLoader());
        return obj;
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i4) {
        return new StaggeredGridLayoutManager.SavedState[i4];
    }
}