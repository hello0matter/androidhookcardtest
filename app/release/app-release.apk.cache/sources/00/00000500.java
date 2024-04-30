package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.VisibleForTesting;

/* loaded from: classes.dex */
public final class w implements Parcelable.Creator {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f3366a;

    /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.Object, com.google.android.material.datepicker.RangeDateSelector] */
    /* JADX WARN: Type inference failed for: r0v5, types: [com.google.android.material.datepicker.SingleDateSelector, java.lang.Object] */
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        switch (this.f3366a) {
            case 0:
                return Month.l(parcel.readInt(), parcel.readInt());
            case 1:
                return new DateValidatorPointBackward(parcel.readLong());
            case 2:
                return new DateValidatorPointForward(parcel.readLong());
            case VisibleForTesting.PACKAGE_PRIVATE /* 3 */:
                ?? obj = new Object();
                obj.f3298b = null;
                obj.f3299c = null;
                obj.f3300d = null;
                obj.f3301e = null;
                obj.f3298b = (Long) parcel.readValue(Long.class.getClassLoader());
                obj.f3299c = (Long) parcel.readValue(Long.class.getClassLoader());
                return obj;
            default:
                ?? obj2 = new Object();
                obj2.f3302a = (Long) parcel.readValue(Long.class.getClassLoader());
                return obj2;
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i4) {
        switch (this.f3366a) {
            case 0:
                return new Month[i4];
            case 1:
                return new DateValidatorPointBackward[i4];
            case 2:
                return new DateValidatorPointForward[i4];
            case VisibleForTesting.PACKAGE_PRIVATE /* 3 */:
                return new RangeDateSelector[i4];
            default:
                return new SingleDateSelector[i4];
        }
    }
}