package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class BackStackState implements Parcelable {
    public static final Parcelable.Creator<BackStackState> CREATOR = new b(0);

    /* renamed from: a  reason: collision with root package name */
    public final int[] f1568a;

    /* renamed from: b  reason: collision with root package name */
    public final ArrayList f1569b;

    /* renamed from: c  reason: collision with root package name */
    public final int[] f1570c;

    /* renamed from: d  reason: collision with root package name */
    public final int[] f1571d;

    /* renamed from: e  reason: collision with root package name */
    public final int f1572e;

    /* renamed from: f  reason: collision with root package name */
    public final String f1573f;

    /* renamed from: g  reason: collision with root package name */
    public final int f1574g;

    /* renamed from: h  reason: collision with root package name */
    public final int f1575h;

    /* renamed from: i  reason: collision with root package name */
    public final CharSequence f1576i;

    /* renamed from: j  reason: collision with root package name */
    public final int f1577j;

    /* renamed from: k  reason: collision with root package name */
    public final CharSequence f1578k;

    /* renamed from: l  reason: collision with root package name */
    public final ArrayList f1579l;

    /* renamed from: m  reason: collision with root package name */
    public final ArrayList f1580m;

    /* renamed from: n  reason: collision with root package name */
    public final boolean f1581n;

    public BackStackState(Parcel parcel) {
        this.f1568a = parcel.createIntArray();
        this.f1569b = parcel.createStringArrayList();
        this.f1570c = parcel.createIntArray();
        this.f1571d = parcel.createIntArray();
        this.f1572e = parcel.readInt();
        this.f1573f = parcel.readString();
        this.f1574g = parcel.readInt();
        this.f1575h = parcel.readInt();
        Parcelable.Creator creator = TextUtils.CHAR_SEQUENCE_CREATOR;
        this.f1576i = (CharSequence) creator.createFromParcel(parcel);
        this.f1577j = parcel.readInt();
        this.f1578k = (CharSequence) creator.createFromParcel(parcel);
        this.f1579l = parcel.createStringArrayList();
        this.f1580m = parcel.createStringArrayList();
        this.f1581n = parcel.readInt() != 0;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeIntArray(this.f1568a);
        parcel.writeStringList(this.f1569b);
        parcel.writeIntArray(this.f1570c);
        parcel.writeIntArray(this.f1571d);
        parcel.writeInt(this.f1572e);
        parcel.writeString(this.f1573f);
        parcel.writeInt(this.f1574g);
        parcel.writeInt(this.f1575h);
        TextUtils.writeToParcel(this.f1576i, parcel, 0);
        parcel.writeInt(this.f1577j);
        TextUtils.writeToParcel(this.f1578k, parcel, 0);
        parcel.writeStringList(this.f1579l);
        parcel.writeStringList(this.f1580m);
        parcel.writeInt(this.f1581n ? 1 : 0);
    }

    public BackStackState(a aVar) {
        int size = aVar.f1631a.size();
        this.f1568a = new int[size * 5];
        if (!aVar.f1637g) {
            throw new IllegalStateException("Not on back stack");
        }
        this.f1569b = new ArrayList(size);
        this.f1570c = new int[size];
        this.f1571d = new int[size];
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            s0 s0Var = (s0) aVar.f1631a.get(i5);
            int i6 = i4 + 1;
            this.f1568a[i4] = s0Var.f1793a;
            ArrayList arrayList = this.f1569b;
            t tVar = s0Var.f1794b;
            arrayList.add(tVar != null ? tVar.f1805e : null);
            int[] iArr = this.f1568a;
            iArr[i6] = s0Var.f1795c;
            iArr[i4 + 2] = s0Var.f1796d;
            int i7 = i4 + 4;
            iArr[i4 + 3] = s0Var.f1797e;
            i4 += 5;
            iArr[i7] = s0Var.f1798f;
            this.f1570c[i5] = s0Var.f1799g.ordinal();
            this.f1571d[i5] = s0Var.f1800h.ordinal();
        }
        this.f1572e = aVar.f1636f;
        this.f1573f = aVar.f1638h;
        this.f1574g = aVar.f1648r;
        this.f1575h = aVar.f1639i;
        this.f1576i = aVar.f1640j;
        this.f1577j = aVar.f1641k;
        this.f1578k = aVar.f1642l;
        this.f1579l = aVar.f1643m;
        this.f1580m = aVar.f1644n;
        this.f1581n = aVar.f1645o;
    }
}