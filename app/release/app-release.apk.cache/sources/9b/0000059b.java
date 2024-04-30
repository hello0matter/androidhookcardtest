package com.google.android.material.stateful;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.customview.view.AbsSavedState;
import androidx.customview.view.a;
import l.k;

/* loaded from: classes.dex */
public class ExtendableSavedState extends AbsSavedState {
    public static final Parcelable.Creator<ExtendableSavedState> CREATOR = new a(2);

    /* renamed from: c  reason: collision with root package name */
    public final k f3897c;

    public ExtendableSavedState(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        int readInt = parcel.readInt();
        String[] strArr = new String[readInt];
        parcel.readStringArray(strArr);
        Bundle[] bundleArr = new Bundle[readInt];
        parcel.readTypedArray(bundleArr, Bundle.CREATOR);
        this.f3897c = new k(readInt);
        for (int i4 = 0; i4 < readInt; i4++) {
            this.f3897c.put(strArr[i4], bundleArr[i4]);
        }
    }

    public final String toString() {
        return "ExtendableSavedState{" + Integer.toHexString(System.identityHashCode(this)) + " states=" + this.f3897c + "}";
    }

    @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        k kVar = this.f3897c;
        int i5 = kVar.f5252c;
        parcel.writeInt(i5);
        String[] strArr = new String[i5];
        Bundle[] bundleArr = new Bundle[i5];
        for (int i6 = 0; i6 < i5; i6++) {
            strArr[i6] = (String) kVar.h(i6);
            bundleArr[i6] = (Bundle) kVar.j(i6);
        }
        parcel.writeStringArray(strArr);
        parcel.writeTypedArray(bundleArr, 0);
    }

    public ExtendableSavedState(Parcelable parcelable) {
        super(parcelable);
        this.f3897c = new k();
    }
}