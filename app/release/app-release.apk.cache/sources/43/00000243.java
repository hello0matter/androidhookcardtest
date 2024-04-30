package androidx.emoji2.text;

import android.util.SparseArray;

/* loaded from: classes.dex */
public final class u {

    /* renamed from: a  reason: collision with root package name */
    public int f1545a = 1;

    /* renamed from: b  reason: collision with root package name */
    public final c0 f1546b;

    /* renamed from: c  reason: collision with root package name */
    public c0 f1547c;

    /* renamed from: d  reason: collision with root package name */
    public c0 f1548d;

    /* renamed from: e  reason: collision with root package name */
    public int f1549e;

    /* renamed from: f  reason: collision with root package name */
    public int f1550f;

    public u(c0 c0Var) {
        this.f1546b = c0Var;
        this.f1547c = c0Var;
    }

    public final int a(int i4) {
        c0 c0Var;
        SparseArray sparseArray = this.f1547c.f1505a;
        if (sparseArray == null) {
            c0Var = null;
        } else {
            c0Var = (c0) sparseArray.get(i4);
        }
        int i5 = 1;
        int i6 = 2;
        if (this.f1545a != 2) {
            if (c0Var != null) {
                this.f1545a = 2;
                this.f1547c = c0Var;
                this.f1550f = 1;
                i5 = i6;
            }
            b();
        } else {
            if (c0Var != null) {
                this.f1547c = c0Var;
                this.f1550f++;
            } else {
                if (i4 != 65038) {
                    if (i4 != 65039) {
                        c0 c0Var2 = this.f1547c;
                        if (c0Var2.f1506b != null) {
                            i6 = 3;
                            if (this.f1550f == 1) {
                                if (c()) {
                                    c0Var2 = this.f1547c;
                                }
                            }
                            this.f1548d = c0Var2;
                            b();
                        }
                    }
                }
                b();
            }
            i5 = i6;
        }
        this.f1549e = i4;
        return i5;
    }

    public final void b() {
        this.f1545a = 1;
        this.f1547c = this.f1546b;
        this.f1550f = 0;
    }

    public final boolean c() {
        r0.a c4 = this.f1547c.f1506b.c();
        int a5 = c4.a(6);
        if ((a5 != 0 && c4.f6452b.get(a5 + c4.f6451a) != 0) || this.f1549e == 65039) {
            return true;
        }
        return false;
    }
}