package com.google.android.material.navigation;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.material.internal.ParcelableSparseArray;

/* loaded from: classes.dex */
public final class f implements Parcelable.Creator {
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, com.google.android.material.navigation.NavigationBarPresenter$SavedState] */
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        ?? obj = new Object();
        obj.f3667a = parcel.readInt();
        obj.f3668b = (ParcelableSparseArray) parcel.readParcelable(NavigationBarPresenter$SavedState.class.getClassLoader());
        return obj;
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i4) {
        return new NavigationBarPresenter$SavedState[i4];
    }
}