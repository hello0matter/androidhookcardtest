package androidx.customview.view;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public abstract class AbsSavedState implements Parcelable {

    /* renamed from: a  reason: collision with root package name */
    public final Parcelable f1460a;

    /* renamed from: b  reason: collision with root package name */
    public static final AbsSavedState f1459b = new AbsSavedState();
    public static final Parcelable.Creator<AbsSavedState> CREATOR = new a(0);

    /* renamed from: androidx.customview.view.AbsSavedState$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass1 extends AbsSavedState {
    }

    public AbsSavedState() {
        this.f1460a = null;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeParcelable(this.f1460a, i4);
    }

    public AbsSavedState(Parcel parcel, ClassLoader classLoader) {
        Parcelable readParcelable = parcel.readParcelable(classLoader);
        this.f1460a = readParcelable == null ? f1459b : readParcelable;
    }

    public AbsSavedState(Parcelable parcelable) {
        if (parcelable == null) {
            throw new IllegalArgumentException("superState must not be null");
        }
        this.f1460a = parcelable == f1459b ? null : parcelable;
    }
}