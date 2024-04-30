package p;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class a implements b {

    /* renamed from: b  reason: collision with root package name */
    public final c f6059b;

    /* renamed from: c  reason: collision with root package name */
    public final d f6060c;

    /* renamed from: a  reason: collision with root package name */
    public int f6058a = 0;

    /* renamed from: d  reason: collision with root package name */
    public int f6061d = 8;

    /* renamed from: e  reason: collision with root package name */
    public int[] f6062e = new int[8];

    /* renamed from: f  reason: collision with root package name */
    public int[] f6063f = new int[8];

    /* renamed from: g  reason: collision with root package name */
    public float[] f6064g = new float[8];

    /* renamed from: h  reason: collision with root package name */
    public int f6065h = -1;

    /* renamed from: i  reason: collision with root package name */
    public int f6066i = -1;

    /* renamed from: j  reason: collision with root package name */
    public boolean f6067j = false;

    public a(c cVar, d dVar) {
        this.f6059b = cVar;
        this.f6060c = dVar;
    }

    @Override // p.b
    public final float a(int i4) {
        int i5 = this.f6065h;
        for (int i6 = 0; i5 != -1 && i6 < this.f6058a; i6++) {
            if (i6 == i4) {
                return this.f6064g[i5];
            }
            i5 = this.f6063f[i5];
        }
        return 0.0f;
    }

    @Override // p.b
    public final float b(c cVar, boolean z4) {
        float e4 = e(cVar.f6068a);
        c(cVar.f6068a, z4);
        b bVar = cVar.f6071d;
        int k4 = bVar.k();
        for (int i4 = 0; i4 < k4; i4++) {
            j d4 = bVar.d(i4);
            i(d4, bVar.e(d4) * e4, z4);
        }
        return e4;
    }

    @Override // p.b
    public final float c(j jVar, boolean z4) {
        int i4 = this.f6065h;
        if (i4 == -1) {
            return 0.0f;
        }
        int i5 = 0;
        int i6 = -1;
        while (i4 != -1 && i5 < this.f6058a) {
            if (this.f6062e[i4] == jVar.f6104b) {
                if (i4 == this.f6065h) {
                    this.f6065h = this.f6063f[i4];
                } else {
                    int[] iArr = this.f6063f;
                    iArr[i6] = iArr[i4];
                }
                if (z4) {
                    jVar.b(this.f6059b);
                }
                jVar.f6114l--;
                this.f6058a--;
                this.f6062e[i4] = -1;
                if (this.f6067j) {
                    this.f6066i = i4;
                }
                return this.f6064g[i4];
            }
            i5++;
            i6 = i4;
            i4 = this.f6063f[i4];
        }
        return 0.0f;
    }

    @Override // p.b
    public final void clear() {
        int i4 = this.f6065h;
        for (int i5 = 0; i4 != -1 && i5 < this.f6058a; i5++) {
            j jVar = ((j[]) this.f6060c.f6077d)[this.f6062e[i4]];
            if (jVar != null) {
                jVar.b(this.f6059b);
            }
            i4 = this.f6063f[i4];
        }
        this.f6065h = -1;
        this.f6066i = -1;
        this.f6067j = false;
        this.f6058a = 0;
    }

    @Override // p.b
    public final j d(int i4) {
        int i5 = this.f6065h;
        for (int i6 = 0; i5 != -1 && i6 < this.f6058a; i6++) {
            if (i6 == i4) {
                return ((j[]) this.f6060c.f6077d)[this.f6062e[i5]];
            }
            i5 = this.f6063f[i5];
        }
        return null;
    }

    @Override // p.b
    public final float e(j jVar) {
        int i4 = this.f6065h;
        for (int i5 = 0; i4 != -1 && i5 < this.f6058a; i5++) {
            if (this.f6062e[i4] == jVar.f6104b) {
                return this.f6064g[i4];
            }
            i4 = this.f6063f[i4];
        }
        return 0.0f;
    }

    @Override // p.b
    public final void f(j jVar, float f4) {
        if (f4 == 0.0f) {
            c(jVar, true);
            return;
        }
        int i4 = this.f6065h;
        c cVar = this.f6059b;
        if (i4 == -1) {
            this.f6065h = 0;
            this.f6064g[0] = f4;
            this.f6062e[0] = jVar.f6104b;
            this.f6063f[0] = -1;
            jVar.f6114l++;
            jVar.a(cVar);
            this.f6058a++;
            if (!this.f6067j) {
                int i5 = this.f6066i + 1;
                this.f6066i = i5;
                int[] iArr = this.f6062e;
                if (i5 >= iArr.length) {
                    this.f6067j = true;
                    this.f6066i = iArr.length - 1;
                    return;
                }
                return;
            }
            return;
        }
        int i6 = -1;
        for (int i7 = 0; i4 != -1 && i7 < this.f6058a; i7++) {
            int i8 = this.f6062e[i4];
            int i9 = jVar.f6104b;
            if (i8 == i9) {
                this.f6064g[i4] = f4;
                return;
            }
            if (i8 < i9) {
                i6 = i4;
            }
            i4 = this.f6063f[i4];
        }
        int i10 = this.f6066i;
        int i11 = i10 + 1;
        if (this.f6067j) {
            int[] iArr2 = this.f6062e;
            if (iArr2[i10] != -1) {
                i10 = iArr2.length;
            }
        } else {
            i10 = i11;
        }
        int[] iArr3 = this.f6062e;
        if (i10 >= iArr3.length && this.f6058a < iArr3.length) {
            int i12 = 0;
            while (true) {
                int[] iArr4 = this.f6062e;
                if (i12 >= iArr4.length) {
                    break;
                } else if (iArr4[i12] == -1) {
                    i10 = i12;
                    break;
                } else {
                    i12++;
                }
            }
        }
        int[] iArr5 = this.f6062e;
        if (i10 >= iArr5.length) {
            i10 = iArr5.length;
            int i13 = this.f6061d * 2;
            this.f6061d = i13;
            this.f6067j = false;
            this.f6066i = i10 - 1;
            this.f6064g = Arrays.copyOf(this.f6064g, i13);
            this.f6062e = Arrays.copyOf(this.f6062e, this.f6061d);
            this.f6063f = Arrays.copyOf(this.f6063f, this.f6061d);
        }
        this.f6062e[i10] = jVar.f6104b;
        this.f6064g[i10] = f4;
        int[] iArr6 = this.f6063f;
        if (i6 != -1) {
            iArr6[i10] = iArr6[i6];
            iArr6[i6] = i10;
        } else {
            iArr6[i10] = this.f6065h;
            this.f6065h = i10;
        }
        jVar.f6114l++;
        jVar.a(cVar);
        int i14 = this.f6058a + 1;
        this.f6058a = i14;
        if (!this.f6067j) {
            this.f6066i++;
        }
        int[] iArr7 = this.f6062e;
        if (i14 >= iArr7.length) {
            this.f6067j = true;
        }
        if (this.f6066i >= iArr7.length) {
            this.f6067j = true;
            this.f6066i = iArr7.length - 1;
        }
    }

    @Override // p.b
    public final boolean g(j jVar) {
        int i4 = this.f6065h;
        if (i4 == -1) {
            return false;
        }
        for (int i5 = 0; i4 != -1 && i5 < this.f6058a; i5++) {
            if (this.f6062e[i4] == jVar.f6104b) {
                return true;
            }
            i4 = this.f6063f[i4];
        }
        return false;
    }

    @Override // p.b
    public final void h(float f4) {
        int i4 = this.f6065h;
        for (int i5 = 0; i4 != -1 && i5 < this.f6058a; i5++) {
            float[] fArr = this.f6064g;
            fArr[i4] = fArr[i4] / f4;
            i4 = this.f6063f[i4];
        }
    }

    @Override // p.b
    public final void i(j jVar, float f4, boolean z4) {
        if (f4 > -0.001f && f4 < 0.001f) {
            return;
        }
        int i4 = this.f6065h;
        c cVar = this.f6059b;
        if (i4 == -1) {
            this.f6065h = 0;
            this.f6064g[0] = f4;
            this.f6062e[0] = jVar.f6104b;
            this.f6063f[0] = -1;
            jVar.f6114l++;
            jVar.a(cVar);
            this.f6058a++;
            if (!this.f6067j) {
                int i5 = this.f6066i + 1;
                this.f6066i = i5;
                int[] iArr = this.f6062e;
                if (i5 >= iArr.length) {
                    this.f6067j = true;
                    this.f6066i = iArr.length - 1;
                    return;
                }
                return;
            }
            return;
        }
        int i6 = -1;
        for (int i7 = 0; i4 != -1 && i7 < this.f6058a; i7++) {
            int i8 = this.f6062e[i4];
            int i9 = jVar.f6104b;
            if (i8 == i9) {
                float[] fArr = this.f6064g;
                float f5 = fArr[i4] + f4;
                if (f5 > -0.001f && f5 < 0.001f) {
                    f5 = 0.0f;
                }
                fArr[i4] = f5;
                if (f5 == 0.0f) {
                    if (i4 == this.f6065h) {
                        this.f6065h = this.f6063f[i4];
                    } else {
                        int[] iArr2 = this.f6063f;
                        iArr2[i6] = iArr2[i4];
                    }
                    if (z4) {
                        jVar.b(cVar);
                    }
                    if (this.f6067j) {
                        this.f6066i = i4;
                    }
                    jVar.f6114l--;
                    this.f6058a--;
                    return;
                }
                return;
            }
            if (i8 < i9) {
                i6 = i4;
            }
            i4 = this.f6063f[i4];
        }
        int i10 = this.f6066i;
        int i11 = i10 + 1;
        if (this.f6067j) {
            int[] iArr3 = this.f6062e;
            if (iArr3[i10] != -1) {
                i10 = iArr3.length;
            }
        } else {
            i10 = i11;
        }
        int[] iArr4 = this.f6062e;
        if (i10 >= iArr4.length && this.f6058a < iArr4.length) {
            int i12 = 0;
            while (true) {
                int[] iArr5 = this.f6062e;
                if (i12 >= iArr5.length) {
                    break;
                } else if (iArr5[i12] == -1) {
                    i10 = i12;
                    break;
                } else {
                    i12++;
                }
            }
        }
        int[] iArr6 = this.f6062e;
        if (i10 >= iArr6.length) {
            i10 = iArr6.length;
            int i13 = this.f6061d * 2;
            this.f6061d = i13;
            this.f6067j = false;
            this.f6066i = i10 - 1;
            this.f6064g = Arrays.copyOf(this.f6064g, i13);
            this.f6062e = Arrays.copyOf(this.f6062e, this.f6061d);
            this.f6063f = Arrays.copyOf(this.f6063f, this.f6061d);
        }
        this.f6062e[i10] = jVar.f6104b;
        this.f6064g[i10] = f4;
        int[] iArr7 = this.f6063f;
        if (i6 != -1) {
            iArr7[i10] = iArr7[i6];
            iArr7[i6] = i10;
        } else {
            iArr7[i10] = this.f6065h;
            this.f6065h = i10;
        }
        jVar.f6114l++;
        jVar.a(cVar);
        this.f6058a++;
        if (!this.f6067j) {
            this.f6066i++;
        }
        int i14 = this.f6066i;
        int[] iArr8 = this.f6062e;
        if (i14 >= iArr8.length) {
            this.f6067j = true;
            this.f6066i = iArr8.length - 1;
        }
    }

    @Override // p.b
    public final void j() {
        int i4 = this.f6065h;
        for (int i5 = 0; i4 != -1 && i5 < this.f6058a; i5++) {
            float[] fArr = this.f6064g;
            fArr[i4] = fArr[i4] * (-1.0f);
            i4 = this.f6063f[i4];
        }
    }

    @Override // p.b
    public final int k() {
        return this.f6058a;
    }

    public final String toString() {
        int i4 = this.f6065h;
        String str = "";
        for (int i5 = 0; i4 != -1 && i5 < this.f6058a; i5++) {
            str = (androidx.activity.j.c(str, " -> ") + this.f6064g[i4] + " : ") + ((j[]) this.f6060c.f6077d)[this.f6062e[i4]];
            i4 = this.f6063f[i4];
        }
        return str;
    }
}