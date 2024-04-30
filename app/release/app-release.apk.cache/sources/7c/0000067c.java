package e1;

import android.os.Parcel;
import android.util.SparseIntArray;
import androidx.activity.j;
import l.k;

/* loaded from: classes.dex */
public final class b extends a {

    /* renamed from: d  reason: collision with root package name */
    public final SparseIntArray f4433d;

    /* renamed from: e  reason: collision with root package name */
    public final Parcel f4434e;

    /* renamed from: f  reason: collision with root package name */
    public final int f4435f;

    /* renamed from: g  reason: collision with root package name */
    public final int f4436g;

    /* renamed from: h  reason: collision with root package name */
    public final String f4437h;

    /* renamed from: i  reason: collision with root package name */
    public int f4438i;

    /* renamed from: j  reason: collision with root package name */
    public int f4439j;

    /* renamed from: k  reason: collision with root package name */
    public int f4440k;

    /* JADX WARN: Type inference failed for: r5v0, types: [l.b, l.k] */
    /* JADX WARN: Type inference failed for: r6v0, types: [l.b, l.k] */
    /* JADX WARN: Type inference failed for: r7v0, types: [l.b, l.k] */
    public b(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "", new k(), new k(), new k());
    }

    @Override // e1.a
    public final b a() {
        Parcel parcel = this.f4434e;
        int dataPosition = parcel.dataPosition();
        int i4 = this.f4439j;
        if (i4 == this.f4435f) {
            i4 = this.f4436g;
        }
        return new b(parcel, dataPosition, i4, j.e(new StringBuilder(), this.f4437h, "  "), this.f4430a, this.f4431b, this.f4432c);
    }

    @Override // e1.a
    public final boolean e(int i4) {
        while (this.f4439j < this.f4436g) {
            int i5 = this.f4440k;
            if (i5 == i4) {
                return true;
            }
            if (String.valueOf(i5).compareTo(String.valueOf(i4)) > 0) {
                return false;
            }
            int i6 = this.f4439j;
            Parcel parcel = this.f4434e;
            parcel.setDataPosition(i6);
            int readInt = parcel.readInt();
            this.f4440k = parcel.readInt();
            this.f4439j += readInt;
        }
        if (this.f4440k != i4) {
            return false;
        }
        return true;
    }

    @Override // e1.a
    public final void h(int i4) {
        int i5 = this.f4438i;
        SparseIntArray sparseIntArray = this.f4433d;
        Parcel parcel = this.f4434e;
        if (i5 >= 0) {
            int i6 = sparseIntArray.get(i5);
            int dataPosition = parcel.dataPosition();
            parcel.setDataPosition(i6);
            parcel.writeInt(dataPosition - i6);
            parcel.setDataPosition(dataPosition);
        }
        this.f4438i = i4;
        sparseIntArray.put(i4, parcel.dataPosition());
        parcel.writeInt(0);
        parcel.writeInt(i4);
    }

    public b(Parcel parcel, int i4, int i5, String str, l.b bVar, l.b bVar2, l.b bVar3) {
        super(bVar, bVar2, bVar3);
        this.f4433d = new SparseIntArray();
        this.f4438i = -1;
        this.f4440k = -1;
        this.f4434e = parcel;
        this.f4435f = i4;
        this.f4436g = i5;
        this.f4439j = i4;
        this.f4437h = str;
    }
}