package androidx.versionedparcelable;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.activity.result.a;
import androidx.annotation.RestrictTo;
import e1.b;
import e1.c;

@SuppressLint({"BanParcelableUsage"})
@RestrictTo({RestrictTo.Scope.f169a})
/* loaded from: classes.dex */
public class ParcelImpl implements Parcelable {
    public static final Parcelable.Creator<ParcelImpl> CREATOR = new a(2);

    /* renamed from: a  reason: collision with root package name */
    public final c f2376a;

    public ParcelImpl(Parcel parcel) {
        this.f2376a = new b(parcel).g();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        new b(parcel).i(this.f2376a);
    }
}