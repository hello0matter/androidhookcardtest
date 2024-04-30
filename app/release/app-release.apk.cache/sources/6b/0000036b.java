package androidx.viewpager2.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import androidx.viewpager2.widget.ViewPager2;

/* loaded from: classes.dex */
public final class p implements Parcelable.ClassLoaderCreator {
    /* JADX WARN: Type inference failed for: r0v0, types: [android.view.View$BaseSavedState, androidx.viewpager2.widget.ViewPager2$SavedState, java.lang.Object] */
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        ?? baseSavedState = new View.BaseSavedState(parcel, null);
        baseSavedState.f2453a = parcel.readInt();
        baseSavedState.f2454b = parcel.readInt();
        baseSavedState.f2455c = parcel.readParcelable(null);
        return baseSavedState;
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i4) {
        return new ViewPager2.SavedState[i4];
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [android.view.View$BaseSavedState, androidx.viewpager2.widget.ViewPager2$SavedState, java.lang.Object] */
    @Override // android.os.Parcelable.ClassLoaderCreator
    public final Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
        ?? baseSavedState = new View.BaseSavedState(parcel, classLoader);
        baseSavedState.f2453a = parcel.readInt();
        baseSavedState.f2454b = parcel.readInt();
        baseSavedState.f2455c = parcel.readParcelable(classLoader);
        return baseSavedState;
    }
}