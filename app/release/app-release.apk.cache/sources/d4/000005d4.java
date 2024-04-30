package com.google.android.material.timepicker;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class f implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        return new TimeModel(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i4) {
        return new TimeModel[i4];
    }
}