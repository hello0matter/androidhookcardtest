package androidx.appcompat.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import androidx.appcompat.widget.AppCompatSpinner;

/* loaded from: classes.dex */
public final class p0 implements Parcelable.Creator {
    /* JADX WARN: Type inference failed for: r0v0, types: [android.view.View$BaseSavedState, androidx.appcompat.widget.AppCompatSpinner$SavedState, java.lang.Object] */
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        boolean z4;
        ?? baseSavedState = new View.BaseSavedState(parcel);
        if (parcel.readByte() != 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        baseSavedState.f529a = z4;
        return baseSavedState;
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i4) {
        return new AppCompatSpinner.SavedState[i4];
    }
}