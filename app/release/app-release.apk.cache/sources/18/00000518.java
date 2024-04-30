package com.google.android.material.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseIntArray;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.f170b})
/* loaded from: classes.dex */
public class ParcelableSparseIntArray extends SparseIntArray implements Parcelable {
    public static final Parcelable.Creator<ParcelableSparseIntArray> CREATOR = new k1.b(9);

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int[] iArr = new int[size()];
        int[] iArr2 = new int[size()];
        for (int i5 = 0; i5 < size(); i5++) {
            iArr[i5] = keyAt(i5);
            iArr2[i5] = valueAt(i5);
        }
        parcel.writeInt(size());
        parcel.writeIntArray(iArr);
        parcel.writeIntArray(iArr2);
    }
}