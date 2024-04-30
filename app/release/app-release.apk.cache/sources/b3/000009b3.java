package t3;

/* loaded from: classes.dex */
public final class d0 {

    /* renamed from: a  reason: collision with root package name */
    public int f6732a;

    /* renamed from: b  reason: collision with root package name */
    public final int[] f6733b = new int[10];

    public final int a() {
        if ((this.f6732a & 128) != 0) {
            return this.f6733b[7];
        }
        return 65535;
    }

    public final void b(d0 d0Var) {
        com.google.common.collect.c.F(d0Var, "other");
        for (int i4 = 0; i4 < 10; i4++) {
            boolean z4 = true;
            if (((1 << i4) & d0Var.f6732a) == 0) {
                z4 = false;
            }
            if (z4) {
                c(i4, d0Var.f6733b[i4]);
            }
        }
    }

    public final void c(int i4, int i5) {
        if (i4 >= 0) {
            int[] iArr = this.f6733b;
            if (i4 < iArr.length) {
                this.f6732a = (1 << i4) | this.f6732a;
                iArr[i4] = i5;
            }
        }
    }
}