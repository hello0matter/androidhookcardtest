package k1;

import android.os.Parcel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public final long f5121a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f5122b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f5123c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f5124d;

    /* renamed from: e  reason: collision with root package name */
    public final long f5125e;

    /* renamed from: f  reason: collision with root package name */
    public final List f5126f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f5127g;

    /* renamed from: h  reason: collision with root package name */
    public final long f5128h;

    /* renamed from: i  reason: collision with root package name */
    public final int f5129i;

    /* renamed from: j  reason: collision with root package name */
    public final int f5130j;

    /* renamed from: k  reason: collision with root package name */
    public final int f5131k;

    public d(Parcel parcel) {
        boolean z4;
        boolean z5;
        boolean z6;
        this.f5121a = parcel.readLong();
        if (parcel.readByte() == 1) {
            z4 = true;
        } else {
            z4 = false;
        }
        this.f5122b = z4;
        if (parcel.readByte() == 1) {
            z5 = true;
        } else {
            z5 = false;
        }
        this.f5123c = z5;
        if (parcel.readByte() == 1) {
            z6 = true;
        } else {
            z6 = false;
        }
        this.f5124d = z6;
        int readInt = parcel.readInt();
        ArrayList arrayList = new ArrayList(readInt);
        for (int i4 = 0; i4 < readInt; i4++) {
            arrayList.add(new c(parcel.readInt(), parcel.readLong()));
        }
        this.f5126f = Collections.unmodifiableList(arrayList);
        this.f5125e = parcel.readLong();
        this.f5127g = parcel.readByte() == 1;
        this.f5128h = parcel.readLong();
        this.f5129i = parcel.readInt();
        this.f5130j = parcel.readInt();
        this.f5131k = parcel.readInt();
    }
}