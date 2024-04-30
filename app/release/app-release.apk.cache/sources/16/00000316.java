package androidx.recyclerview.widget;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class r {

    /* renamed from: a  reason: collision with root package name */
    public int f2242a;

    /* renamed from: b  reason: collision with root package name */
    public int f2243b;

    /* renamed from: c  reason: collision with root package name */
    public int[] f2244c;

    /* renamed from: d  reason: collision with root package name */
    public int f2245d;

    public final void a(int i4, int i5) {
        if (i4 < 0) {
            throw new IllegalArgumentException("Layout positions must be non-negative");
        }
        if (i5 < 0) {
            throw new IllegalArgumentException("Pixel distance must be non-negative");
        }
        int i6 = this.f2245d;
        int i7 = i6 * 2;
        int[] iArr = this.f2244c;
        if (iArr == null) {
            int[] iArr2 = new int[4];
            this.f2244c = iArr2;
            Arrays.fill(iArr2, -1);
        } else if (i7 >= iArr.length) {
            int[] iArr3 = new int[i6 * 4];
            this.f2244c = iArr3;
            System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
        }
        int[] iArr4 = this.f2244c;
        iArr4[i7] = i4;
        iArr4[i7 + 1] = i5;
        this.f2245d++;
    }

    public final void b(RecyclerView recyclerView, boolean z4) {
        this.f2245d = 0;
        int[] iArr = this.f2244c;
        if (iArr != null) {
            Arrays.fill(iArr, -1);
        }
        u0 u0Var = recyclerView.f1988l;
        if (recyclerView.f1986k == null || u0Var == null || !u0Var.f2281i) {
            return;
        }
        if (z4) {
            if (!recyclerView.f1972d.g()) {
                u0Var.i(recyclerView.f1986k.a(), this);
            }
        } else if (!recyclerView.L()) {
            u0Var.h(this.f2242a, this.f2243b, recyclerView.f1973d0, this);
        }
        int i4 = this.f2245d;
        if (i4 > u0Var.f2282j) {
            u0Var.f2282j = i4;
            u0Var.f2283k = z4;
            recyclerView.f1968b.k();
        }
    }
}