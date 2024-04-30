package com.google.android.exoplayer2.drm;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.drm.DrmInitData;

/* loaded from: classes.dex */
public final class a implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        return new DrmInitData.SchemeData(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i4) {
        return new DrmInitData.SchemeData[i4];
    }
}