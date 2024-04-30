package com.google.android.material.slider;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import com.google.android.material.slider.BaseSlider;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class e implements Parcelable.Creator {
    /* JADX WARN: Type inference failed for: r0v0, types: [android.view.View$BaseSavedState, com.google.android.material.slider.BaseSlider$SliderState, java.lang.Object] */
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        ?? baseSavedState = new View.BaseSavedState(parcel);
        baseSavedState.f3869a = parcel.readFloat();
        baseSavedState.f3870b = parcel.readFloat();
        ArrayList arrayList = new ArrayList();
        baseSavedState.f3871c = arrayList;
        parcel.readList(arrayList, Float.class.getClassLoader());
        baseSavedState.f3872d = parcel.readFloat();
        baseSavedState.f3873e = parcel.createBooleanArray()[0];
        return baseSavedState;
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i4) {
        return new BaseSlider.SliderState[i4];
    }
}