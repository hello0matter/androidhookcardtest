package com.google.android.material.navigation;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.material.internal.ParcelableSparseArray;

/* loaded from: classes.dex */
class NavigationBarPresenter$SavedState implements Parcelable {
    public static final Parcelable.Creator<NavigationBarPresenter$SavedState> CREATOR = new Object();

    /* renamed from: a  reason: collision with root package name */
    public int f3667a;

    /* renamed from: b  reason: collision with root package name */
    public ParcelableSparseArray f3668b;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeInt(this.f3667a);
        parcel.writeParcelable(this.f3668b, 0);
    }
}