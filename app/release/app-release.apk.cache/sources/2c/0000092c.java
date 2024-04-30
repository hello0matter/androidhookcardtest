package p;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class k implements b {

    /* renamed from: a  reason: collision with root package name */
    public int f6115a = 16;

    /* renamed from: b  reason: collision with root package name */
    public final int[] f6116b = new int[16];

    /* renamed from: c  reason: collision with root package name */
    public int[] f6117c = new int[16];

    /* renamed from: d  reason: collision with root package name */
    public int[] f6118d = new int[16];

    /* renamed from: e  reason: collision with root package name */
    public float[] f6119e = new float[16];

    /* renamed from: f  reason: collision with root package name */
    public int[] f6120f = new int[16];

    /* renamed from: g  reason: collision with root package name */
    public int[] f6121g = new int[16];

    /* renamed from: h  reason: collision with root package name */
    public int f6122h = 0;

    /* renamed from: i  reason: collision with root package name */
    public int f6123i = -1;

    /* renamed from: j  reason: collision with root package name */
    public final c f6124j;

    /* renamed from: k  reason: collision with root package name */
    public final d f6125k;

    public k(c cVar, d dVar) {
        this.f6124j = cVar;
        this.f6125k = dVar;
        clear();
    }

    @Override // p.b
    public final float a(int i4) {
        int i5 = this.f6122h;
        int i6 = this.f6123i;
        for (int i7 = 0; i7 < i5; i7++) {
            if (i7 == i4) {
                return this.f6119e[i6];
            }
            i6 = this.f6121g[i6];
            if (i6 == -1) {
                return 0.0f;
            }
        }
        return 0.0f;
    }

    @Override // p.b
    public final float b(c cVar, boolean z4) {
        float e4 = e(cVar.f6068a);
        c(cVar.f6068a, z4);
        k kVar = (k) cVar.f6071d;
        int i4 = kVar.f6122h;
        int i5 = 0;
        int i6 = 0;
        while (i5 < i4) {
            int i7 = kVar.f6118d[i6];
            if (i7 != -1) {
                i(((j[]) this.f6125k.f6077d)[i7], kVar.f6119e[i6] * e4, z4);
                i5++;
            }
            i6++;
        }
        return e4;
    }

    @Override // p.b
    public final float c(j jVar, boolean z4) {
        int[] iArr;
        int i4;
        int n4 = n(jVar);
        if (n4 == -1) {
            return 0.0f;
        }
        int i5 = jVar.f6104b;
        int i6 = i5 % 16;
        int[] iArr2 = this.f6116b;
        int i7 = iArr2[i6];
        if (i7 != -1) {
            if (this.f6118d[i7] == i5) {
                int[] iArr3 = this.f6117c;
                iArr2[i6] = iArr3[i7];
                iArr3[i7] = -1;
            } else {
                while (true) {
                    iArr = this.f6117c;
                    i4 = iArr[i7];
                    if (i4 == -1 || this.f6118d[i4] == i5) {
                        break;
                    }
                    i7 = i4;
                }
                if (i4 != -1 && this.f6118d[i4] == i5) {
                    iArr[i7] = iArr[i4];
                    iArr[i4] = -1;
                }
            }
        }
        float f4 = this.f6119e[n4];
        if (this.f6123i == n4) {
            this.f6123i = this.f6121g[n4];
        }
        this.f6118d[n4] = -1;
        int[] iArr4 = this.f6120f;
        int i8 = iArr4[n4];
        if (i8 != -1) {
            int[] iArr5 = this.f6121g;
            iArr5[i8] = iArr5[n4];
        }
        int i9 = this.f6121g[n4];
        if (i9 != -1) {
            iArr4[i9] = iArr4[n4];
        }
        this.f6122h--;
        jVar.f6114l--;
        if (z4) {
            jVar.b(this.f6124j);
        }
        return f4;
    }

    @Override // p.b
    public final void clear() {
        int i4 = this.f6122h;
        for (int i5 = 0; i5 < i4; i5++) {
            j d4 = d(i5);
            if (d4 != null) {
                d4.b(this.f6124j);
            }
        }
        for (int i6 = 0; i6 < this.f6115a; i6++) {
            this.f6118d[i6] = -1;
            this.f6117c[i6] = -1;
        }
        for (int i7 = 0; i7 < 16; i7++) {
            this.f6116b[i7] = -1;
        }
        this.f6122h = 0;
        this.f6123i = -1;
    }

    @Override // p.b
    public final j d(int i4) {
        int i5 = this.f6122h;
        if (i5 == 0) {
            return null;
        }
        int i6 = this.f6123i;
        for (int i7 = 0; i7 < i5; i7++) {
            if (i7 == i4 && i6 != -1) {
                return ((j[]) this.f6125k.f6077d)[this.f6118d[i6]];
            }
            i6 = this.f6121g[i6];
            if (i6 == -1) {
                break;
            }
        }
        return null;
    }

    @Override // p.b
    public final float e(j jVar) {
        int n4 = n(jVar);
        if (n4 != -1) {
            return this.f6119e[n4];
        }
        return 0.0f;
    }

    @Override // p.b
    public final void f(j jVar, float f4) {
        if (f4 > -0.001f && f4 < 0.001f) {
            c(jVar, true);
            return;
        }
        int i4 = 0;
        if (this.f6122h == 0) {
            m(0, jVar, f4);
            l(jVar, 0);
            this.f6123i = 0;
            return;
        }
        int n4 = n(jVar);
        if (n4 != -1) {
            this.f6119e[n4] = f4;
            return;
        }
        int i5 = this.f6122h + 1;
        int i6 = this.f6115a;
        if (i5 >= i6) {
            int i7 = i6 * 2;
            this.f6118d = Arrays.copyOf(this.f6118d, i7);
            this.f6119e = Arrays.copyOf(this.f6119e, i7);
            this.f6120f = Arrays.copyOf(this.f6120f, i7);
            this.f6121g = Arrays.copyOf(this.f6121g, i7);
            this.f6117c = Arrays.copyOf(this.f6117c, i7);
            for (int i8 = this.f6115a; i8 < i7; i8++) {
                this.f6118d[i8] = -1;
                this.f6117c[i8] = -1;
            }
            this.f6115a = i7;
        }
        int i9 = this.f6122h;
        int i10 = this.f6123i;
        int i11 = -1;
        for (int i12 = 0; i12 < i9; i12++) {
            int i13 = this.f6118d[i10];
            int i14 = jVar.f6104b;
            if (i13 == i14) {
                this.f6119e[i10] = f4;
                return;
            }
            if (i13 < i14) {
                i11 = i10;
            }
            i10 = this.f6121g[i10];
            if (i10 == -1) {
                break;
            }
        }
        while (true) {
            if (i4 < this.f6115a) {
                if (this.f6118d[i4] == -1) {
                    break;
                }
                i4++;
            } else {
                i4 = -1;
                break;
            }
        }
        m(i4, jVar, f4);
        int[] iArr = this.f6120f;
        if (i11 != -1) {
            iArr[i4] = i11;
            int[] iArr2 = this.f6121g;
            iArr2[i4] = iArr2[i11];
            iArr2[i11] = i4;
        } else {
            iArr[i4] = -1;
            if (this.f6122h > 0) {
                this.f6121g[i4] = this.f6123i;
                this.f6123i = i4;
            } else {
                this.f6121g[i4] = -1;
            }
        }
        int i15 = this.f6121g[i4];
        if (i15 != -1) {
            this.f6120f[i15] = i4;
        }
        l(jVar, i4);
    }

    @Override // p.b
    public final boolean g(j jVar) {
        if (n(jVar) != -1) {
            return true;
        }
        return false;
    }

    @Override // p.b
    public final void h(float f4) {
        int i4 = this.f6122h;
        int i5 = this.f6123i;
        for (int i6 = 0; i6 < i4; i6++) {
            float[] fArr = this.f6119e;
            fArr[i5] = fArr[i5] / f4;
            i5 = this.f6121g[i5];
            if (i5 == -1) {
                return;
            }
        }
    }

    @Override // p.b
    public final void i(j jVar, float f4, boolean z4) {
        if (f4 > -0.001f && f4 < 0.001f) {
            return;
        }
        int n4 = n(jVar);
        if (n4 == -1) {
            f(jVar, f4);
            return;
        }
        float[] fArr = this.f6119e;
        float f5 = fArr[n4] + f4;
        fArr[n4] = f5;
        if (f5 > -0.001f && f5 < 0.001f) {
            fArr[n4] = 0.0f;
            c(jVar, z4);
        }
    }

    @Override // p.b
    public final void j() {
        int i4 = this.f6122h;
        int i5 = this.f6123i;
        for (int i6 = 0; i6 < i4; i6++) {
            float[] fArr = this.f6119e;
            fArr[i5] = fArr[i5] * (-1.0f);
            i5 = this.f6121g[i5];
            if (i5 == -1) {
                return;
            }
        }
    }

    @Override // p.b
    public final int k() {
        return this.f6122h;
    }

    public final void l(j jVar, int i4) {
        int[] iArr;
        int i5 = jVar.f6104b % 16;
        int[] iArr2 = this.f6116b;
        int i6 = iArr2[i5];
        if (i6 == -1) {
            iArr2[i5] = i4;
        } else {
            while (true) {
                iArr = this.f6117c;
                int i7 = iArr[i6];
                if (i7 == -1) {
                    break;
                }
                i6 = i7;
            }
            iArr[i6] = i4;
        }
        this.f6117c[i4] = -1;
    }

    public final void m(int i4, j jVar, float f4) {
        this.f6118d[i4] = jVar.f6104b;
        this.f6119e[i4] = f4;
        this.f6120f[i4] = -1;
        this.f6121g[i4] = -1;
        jVar.a(this.f6124j);
        jVar.f6114l++;
        this.f6122h++;
    }

    public final int n(j jVar) {
        if (this.f6122h == 0) {
            return -1;
        }
        int i4 = jVar.f6104b;
        int i5 = this.f6116b[i4 % 16];
        if (i5 == -1) {
            return -1;
        }
        if (this.f6118d[i5] == i4) {
            return i5;
        }
        do {
            i5 = this.f6117c[i5];
            if (i5 == -1) {
                break;
            }
        } while (this.f6118d[i5] != i4);
        if (i5 == -1 || this.f6118d[i5] != i4) {
            return -1;
        }
        return i5;
    }

    public final String toString() {
        String c4;
        String c5;
        String str = hashCode() + " { ";
        int i4 = this.f6122h;
        for (int i5 = 0; i5 < i4; i5++) {
            j d4 = d(i5);
            if (d4 != null) {
                String str2 = str + d4 + " = " + a(i5) + " ";
                int n4 = n(d4);
                String c6 = androidx.activity.j.c(str2, "[p: ");
                int i6 = this.f6120f[n4];
                d dVar = this.f6125k;
                if (i6 != -1) {
                    c4 = c6 + ((j[]) dVar.f6077d)[this.f6118d[this.f6120f[n4]]];
                } else {
                    c4 = androidx.activity.j.c(c6, "none");
                }
                String c7 = androidx.activity.j.c(c4, ", n: ");
                if (this.f6121g[n4] != -1) {
                    c5 = c7 + ((j[]) dVar.f6077d)[this.f6118d[this.f6121g[n4]]];
                } else {
                    c5 = androidx.activity.j.c(c7, "none");
                }
                str = androidx.activity.j.c(c5, "]");
            }
        }
        return androidx.activity.j.c(str, " }");
    }
}