package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;

@SuppressLint({"BanParcelableUsage, ParcelClassLoader"})
/* loaded from: classes.dex */
public class Fragment$SavedState implements Parcelable {
    @NonNull
    public static final Parcelable.Creator<Fragment$SavedState> CREATOR = new Object();

    /* renamed from: a  reason: collision with root package name */
    public final Bundle f1583a;

    public Fragment$SavedState(Parcel parcel, ClassLoader classLoader) {
        Bundle readBundle = parcel.readBundle();
        this.f1583a = readBundle;
        if (classLoader == null || readBundle == null) {
            return;
        }
        readBundle.setClassLoader(classLoader);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeBundle(this.f1583a);
    }
}