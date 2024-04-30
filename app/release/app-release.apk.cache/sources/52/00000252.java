package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: Access modifiers changed from: package-private */
@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class FragmentState implements Parcelable {
    public static final Parcelable.Creator<FragmentState> CREATOR = new b(3);

    /* renamed from: a  reason: collision with root package name */
    public final String f1603a;

    /* renamed from: b  reason: collision with root package name */
    public final String f1604b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f1605c;

    /* renamed from: d  reason: collision with root package name */
    public final int f1606d;

    /* renamed from: e  reason: collision with root package name */
    public final int f1607e;

    /* renamed from: f  reason: collision with root package name */
    public final String f1608f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f1609g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f1610h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f1611i;

    /* renamed from: j  reason: collision with root package name */
    public final Bundle f1612j;

    /* renamed from: k  reason: collision with root package name */
    public final boolean f1613k;

    /* renamed from: l  reason: collision with root package name */
    public final int f1614l;

    /* renamed from: m  reason: collision with root package name */
    public Bundle f1615m;

    public FragmentState(Parcel parcel) {
        this.f1603a = parcel.readString();
        this.f1604b = parcel.readString();
        this.f1605c = parcel.readInt() != 0;
        this.f1606d = parcel.readInt();
        this.f1607e = parcel.readInt();
        this.f1608f = parcel.readString();
        this.f1609g = parcel.readInt() != 0;
        this.f1610h = parcel.readInt() != 0;
        this.f1611i = parcel.readInt() != 0;
        this.f1612j = parcel.readBundle();
        this.f1613k = parcel.readInt() != 0;
        this.f1615m = parcel.readBundle();
        this.f1614l = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentState{");
        sb.append(this.f1603a);
        sb.append(" (");
        sb.append(this.f1604b);
        sb.append(")}:");
        if (this.f1605c) {
            sb.append(" fromLayout");
        }
        int i4 = this.f1607e;
        if (i4 != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(i4));
        }
        String str = this.f1608f;
        if (str != null && !str.isEmpty()) {
            sb.append(" tag=");
            sb.append(str);
        }
        if (this.f1609g) {
            sb.append(" retainInstance");
        }
        if (this.f1610h) {
            sb.append(" removing");
        }
        if (this.f1611i) {
            sb.append(" detached");
        }
        if (this.f1613k) {
            sb.append(" hidden");
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(this.f1603a);
        parcel.writeString(this.f1604b);
        parcel.writeInt(this.f1605c ? 1 : 0);
        parcel.writeInt(this.f1606d);
        parcel.writeInt(this.f1607e);
        parcel.writeString(this.f1608f);
        parcel.writeInt(this.f1609g ? 1 : 0);
        parcel.writeInt(this.f1610h ? 1 : 0);
        parcel.writeInt(this.f1611i ? 1 : 0);
        parcel.writeBundle(this.f1612j);
        parcel.writeInt(this.f1613k ? 1 : 0);
        parcel.writeBundle(this.f1615m);
        parcel.writeInt(this.f1614l);
    }

    public FragmentState(t tVar) {
        this.f1603a = tVar.getClass().getName();
        this.f1604b = tVar.f1805e;
        this.f1605c = tVar.f1813m;
        this.f1606d = tVar.f1822v;
        this.f1607e = tVar.f1823w;
        this.f1608f = tVar.f1824x;
        this.f1609g = tVar.A;
        this.f1610h = tVar.f1812l;
        this.f1611i = tVar.f1826z;
        this.f1612j = tVar.f1806f;
        this.f1613k = tVar.f1825y;
        this.f1614l = tVar.L.ordinal();
    }
}