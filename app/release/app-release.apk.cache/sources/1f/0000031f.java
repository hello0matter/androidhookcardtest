package androidx.recyclerview.widget;

import android.util.SparseIntArray;

/* loaded from: classes.dex */
public final class u {

    /* renamed from: a  reason: collision with root package name */
    public final SparseIntArray f2271a = new SparseIntArray();

    /* renamed from: b  reason: collision with root package name */
    public final SparseIntArray f2272b = new SparseIntArray();

    public static int a(int i4, int i5) {
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < i4; i8++) {
            i6++;
            if (i6 == i5) {
                i7++;
                i6 = 0;
            } else if (i6 > i5) {
                i7++;
                i6 = 1;
            }
        }
        return i6 + 1 > i5 ? i7 + 1 : i7;
    }

    public final void b() {
        this.f2271a.clear();
    }
}