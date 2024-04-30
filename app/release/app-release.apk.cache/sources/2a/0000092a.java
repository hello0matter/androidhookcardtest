package p;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class i extends c {

    /* renamed from: f  reason: collision with root package name */
    public j[] f6099f;

    /* renamed from: g  reason: collision with root package name */
    public j[] f6100g;

    /* renamed from: h  reason: collision with root package name */
    public int f6101h;

    /* renamed from: i  reason: collision with root package name */
    public h f6102i;

    @Override // p.c
    public final j d(boolean[] zArr) {
        int i4 = -1;
        for (int i5 = 0; i5 < this.f6101h; i5++) {
            j[] jVarArr = this.f6099f;
            j jVar = jVarArr[i5];
            if (!zArr[jVar.f6104b]) {
                h hVar = this.f6102i;
                hVar.f6097a = jVar;
                int i6 = 8;
                if (i4 == -1) {
                    while (i6 >= 0) {
                        float f4 = hVar.f6097a.f6110h[i6];
                        if (f4 <= 0.0f) {
                            if (f4 < 0.0f) {
                                i4 = i5;
                                break;
                            }
                            i6--;
                        }
                    }
                } else {
                    j jVar2 = jVarArr[i4];
                    while (true) {
                        if (i6 >= 0) {
                            float f5 = jVar2.f6110h[i6];
                            float f6 = hVar.f6097a.f6110h[i6];
                            if (f6 == f5) {
                                i6--;
                            } else if (f6 >= f5) {
                            }
                        }
                    }
                }
            }
        }
        if (i4 == -1) {
            return null;
        }
        return this.f6099f[i4];
    }

    @Override // p.c
    public final void h(c cVar, boolean z4) {
        j jVar = cVar.f6068a;
        if (jVar == null) {
            return;
        }
        b bVar = cVar.f6071d;
        int k4 = bVar.k();
        for (int i4 = 0; i4 < k4; i4++) {
            j d4 = bVar.d(i4);
            float a5 = bVar.a(i4);
            h hVar = this.f6102i;
            hVar.f6097a = d4;
            boolean z5 = d4.f6103a;
            float[] fArr = jVar.f6110h;
            if (z5) {
                boolean z6 = true;
                for (int i5 = 0; i5 < 9; i5++) {
                    float[] fArr2 = hVar.f6097a.f6110h;
                    float f4 = (fArr[i5] * a5) + fArr2[i5];
                    fArr2[i5] = f4;
                    if (Math.abs(f4) < 1.0E-4f) {
                        hVar.f6097a.f6110h[i5] = 0.0f;
                    } else {
                        z6 = false;
                    }
                }
                if (z6) {
                    hVar.f6098b.j(hVar.f6097a);
                }
            } else {
                for (int i6 = 0; i6 < 9; i6++) {
                    float f5 = fArr[i6];
                    if (f5 != 0.0f) {
                        float f6 = f5 * a5;
                        if (Math.abs(f6) < 1.0E-4f) {
                            f6 = 0.0f;
                        }
                        hVar.f6097a.f6110h[i6] = f6;
                    } else {
                        hVar.f6097a.f6110h[i6] = 0.0f;
                    }
                }
                i(d4);
            }
            this.f6069b = (cVar.f6069b * a5) + this.f6069b;
        }
        j(jVar);
    }

    public final void i(j jVar) {
        int i4;
        int i5 = this.f6101h + 1;
        j[] jVarArr = this.f6099f;
        if (i5 > jVarArr.length) {
            j[] jVarArr2 = (j[]) Arrays.copyOf(jVarArr, jVarArr.length * 2);
            this.f6099f = jVarArr2;
            this.f6100g = (j[]) Arrays.copyOf(jVarArr2, jVarArr2.length * 2);
        }
        j[] jVarArr3 = this.f6099f;
        int i6 = this.f6101h;
        jVarArr3[i6] = jVar;
        int i7 = i6 + 1;
        this.f6101h = i7;
        if (i7 > 1 && jVarArr3[i6].f6104b > jVar.f6104b) {
            int i8 = 0;
            while (true) {
                i4 = this.f6101h;
                if (i8 >= i4) {
                    break;
                }
                this.f6100g[i8] = this.f6099f[i8];
                i8++;
            }
            Arrays.sort(this.f6100g, 0, i4, new o.d(1, this));
            for (int i9 = 0; i9 < this.f6101h; i9++) {
                this.f6099f[i9] = this.f6100g[i9];
            }
        }
        jVar.f6103a = true;
        jVar.a(this);
    }

    public final void j(j jVar) {
        int i4 = 0;
        while (i4 < this.f6101h) {
            if (this.f6099f[i4] == jVar) {
                while (true) {
                    int i5 = this.f6101h;
                    if (i4 < i5 - 1) {
                        j[] jVarArr = this.f6099f;
                        int i6 = i4 + 1;
                        jVarArr[i4] = jVarArr[i6];
                        i4 = i6;
                    } else {
                        this.f6101h = i5 - 1;
                        jVar.f6103a = false;
                        return;
                    }
                }
            } else {
                i4++;
            }
        }
    }

    @Override // p.c
    public final String toString() {
        String str = " goal -> (" + this.f6069b + ") : ";
        for (int i4 = 0; i4 < this.f6101h; i4++) {
            j jVar = this.f6099f[i4];
            h hVar = this.f6102i;
            hVar.f6097a = jVar;
            str = str + hVar + " ";
        }
        return str;
    }
}