package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.material.datepicker.CalendarConstraints;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class f implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        ArrayList readArrayList = parcel.readArrayList(CalendarConstraints.DateValidator.class.getClassLoader());
        int readInt = parcel.readInt();
        g gVar = CompositeDateValidator.f3254d;
        if (readInt != 2 && readInt == 1) {
            gVar = CompositeDateValidator.f3253c;
        }
        readArrayList.getClass();
        return new CompositeDateValidator(readArrayList, gVar);
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i4) {
        return new CompositeDateValidator[i4];
    }
}