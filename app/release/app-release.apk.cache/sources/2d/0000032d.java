package androidx.recyclerview.widget;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.recyclerview.widget.LinearLayoutManager;

/* loaded from: classes.dex */
public final class z implements Parcelable.Creator {
    /* JADX WARN: Type inference failed for: r0v0, types: [androidx.recyclerview.widget.LinearLayoutManager$SavedState, java.lang.Object] */
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        ?? obj = new Object();
        obj.f1960a = parcel.readInt();
        obj.f1961b = parcel.readInt();
        boolean z4 = true;
        if (parcel.readInt() != 1) {
            z4 = false;
        }
        obj.f1962c = z4;
        return obj;
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i4) {
        return new LinearLayoutManager.SavedState[i4];
    }
}