package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class FragmentManagerState implements Parcelable {
    public static final Parcelable.Creator<FragmentManagerState> CREATOR = new b(2);

    /* renamed from: a  reason: collision with root package name */
    public ArrayList f1595a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList f1596b;

    /* renamed from: c  reason: collision with root package name */
    public BackStackState[] f1597c;

    /* renamed from: d  reason: collision with root package name */
    public int f1598d;

    /* renamed from: e  reason: collision with root package name */
    public String f1599e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList f1600f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList f1601g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList f1602h;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeTypedList(this.f1595a);
        parcel.writeStringList(this.f1596b);
        parcel.writeTypedArray(this.f1597c, i4);
        parcel.writeInt(this.f1598d);
        parcel.writeString(this.f1599e);
        parcel.writeStringList(this.f1600f);
        parcel.writeTypedList(this.f1601g);
        parcel.writeTypedList(this.f1602h);
    }
}