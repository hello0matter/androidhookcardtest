package androidx.appcompat.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
class AppCompatDelegateImpl$PanelFeatureState$SavedState implements Parcelable {
    public static final Parcelable.Creator<AppCompatDelegateImpl$PanelFeatureState$SavedState> CREATOR = new Object();

    /* renamed from: a  reason: collision with root package name */
    public int f181a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f182b;

    /* renamed from: c  reason: collision with root package name */
    public Bundle f183c;

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState$SavedState] */
    public static AppCompatDelegateImpl$PanelFeatureState$SavedState l(Parcel parcel, ClassLoader classLoader) {
        ?? obj = new Object();
        obj.f181a = parcel.readInt();
        boolean z4 = true;
        if (parcel.readInt() != 1) {
            z4 = false;
        }
        obj.f182b = z4;
        if (z4) {
            obj.f183c = parcel.readBundle(classLoader);
        }
        return obj;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeInt(this.f181a);
        parcel.writeInt(this.f182b ? 1 : 0);
        if (this.f182b) {
            parcel.writeBundle(this.f183c);
        }
    }
}