package p;

import androidx.constraintlayout.solver.SolverVariable$Type;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: o  reason: collision with root package name */
    public static int f6078o = 1000;

    /* renamed from: p  reason: collision with root package name */
    public static boolean f6079p = true;

    /* renamed from: b  reason: collision with root package name */
    public final i f6081b;

    /* renamed from: e  reason: collision with root package name */
    public c[] f6084e;

    /* renamed from: k  reason: collision with root package name */
    public final d f6090k;

    /* renamed from: n  reason: collision with root package name */
    public c f6093n;

    /* renamed from: a  reason: collision with root package name */
    public int f6080a = 0;

    /* renamed from: c  reason: collision with root package name */
    public int f6082c = 32;

    /* renamed from: d  reason: collision with root package name */
    public int f6083d = 32;

    /* renamed from: f  reason: collision with root package name */
    public boolean f6085f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean[] f6086g = new boolean[32];

    /* renamed from: h  reason: collision with root package name */
    public int f6087h = 1;

    /* renamed from: i  reason: collision with root package name */
    public int f6088i = 0;

    /* renamed from: j  reason: collision with root package name */
    public int f6089j = 32;

    /* renamed from: l  reason: collision with root package name */
    public j[] f6091l = new j[f6078o];

    /* renamed from: m  reason: collision with root package name */
    public int f6092m = 0;

    /* JADX WARN: Type inference failed for: r2v5, types: [p.c, p.i] */
    public f() {
        c cVar;
        this.f6084e = null;
        this.f6084e = new c[32];
        q();
        d dVar = new d(0);
        this.f6090k = dVar;
        ?? cVar2 = new c(dVar);
        cVar2.f6099f = new j[128];
        cVar2.f6100g = new j[128];
        cVar2.f6101h = 0;
        cVar2.f6102i = new h(cVar2);
        this.f6081b = cVar2;
        if (f6079p) {
            cVar = new e(dVar);
        } else {
            cVar = new c(dVar);
        }
        this.f6093n = cVar;
    }

    public static int m(q.c cVar) {
        j jVar = cVar.f6195g;
        if (jVar != null) {
            return (int) (jVar.f6107e + 0.5f);
        }
        return 0;
    }

    public final j a(SolverVariable$Type solverVariable$Type) {
        j jVar = (j) ((g) this.f6090k.f6076c).a();
        if (jVar == null) {
            jVar = new j(solverVariable$Type);
        } else {
            jVar.c();
        }
        jVar.f6111i = solverVariable$Type;
        int i4 = this.f6092m;
        int i5 = f6078o;
        if (i4 >= i5) {
            int i6 = i5 * 2;
            f6078o = i6;
            this.f6091l = (j[]) Arrays.copyOf(this.f6091l, i6);
        }
        j[] jVarArr = this.f6091l;
        int i7 = this.f6092m;
        this.f6092m = i7 + 1;
        jVarArr[i7] = jVar;
        return jVar;
    }

    public final void b(j jVar, j jVar2, int i4, float f4, j jVar3, j jVar4, int i5, int i6) {
        int i7;
        float f5;
        c k4 = k();
        if (jVar2 == jVar3) {
            k4.f6071d.f(jVar, 1.0f);
            k4.f6071d.f(jVar4, 1.0f);
            k4.f6071d.f(jVar2, -2.0f);
        } else {
            if (f4 == 0.5f) {
                k4.f6071d.f(jVar, 1.0f);
                k4.f6071d.f(jVar2, -1.0f);
                k4.f6071d.f(jVar3, -1.0f);
                k4.f6071d.f(jVar4, 1.0f);
                if (i4 > 0 || i5 > 0) {
                    i7 = (-i4) + i5;
                    f5 = i7;
                }
            } else if (f4 <= 0.0f) {
                k4.f6071d.f(jVar, -1.0f);
                k4.f6071d.f(jVar2, 1.0f);
                f5 = i4;
            } else if (f4 >= 1.0f) {
                k4.f6071d.f(jVar4, -1.0f);
                k4.f6071d.f(jVar3, 1.0f);
                i7 = -i5;
                f5 = i7;
            } else {
                float f6 = 1.0f - f4;
                k4.f6071d.f(jVar, f6 * 1.0f);
                k4.f6071d.f(jVar2, f6 * (-1.0f));
                k4.f6071d.f(jVar3, (-1.0f) * f4);
                k4.f6071d.f(jVar4, 1.0f * f4);
                if (i4 > 0 || i5 > 0) {
                    k4.f6069b = (i5 * f4) + ((-i4) * f6);
                }
            }
            k4.f6069b = f5;
        }
        if (i6 != 8) {
            k4.a(this, i6);
        }
        c(k4);
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x00ba, code lost:
        if (r4.f6114l <= 1) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00bd, code lost:
        r12 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00c7, code lost:
        if (r4.f6114l <= 1) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00dc, code lost:
        if (r4.f6114l <= 1) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00df, code lost:
        r14 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x00e9, code lost:
        if (r4.f6114l <= 1) goto L88;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void c(p.c r17) {
        /*
            Method dump skipped, instructions count: 417
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p.f.c(p.c):void");
    }

    public final void d(j jVar, int i4) {
        c k4;
        b bVar;
        float f4;
        int i5 = jVar.f6105c;
        if (i5 == -1) {
            jVar.f6107e = i4;
            jVar.f6108f = true;
            int i6 = jVar.f6113k;
            for (int i7 = 0; i7 < i6; i7++) {
                jVar.f6112j[i7].g(jVar, false);
            }
            jVar.f6113k = 0;
            return;
        }
        if (i5 != -1) {
            c cVar = this.f6084e[i5];
            if (!cVar.f6072e) {
                if (cVar.f6071d.k() == 0) {
                    cVar.f6072e = true;
                } else {
                    k4 = k();
                    if (i4 < 0) {
                        k4.f6069b = i4 * (-1);
                        bVar = k4.f6071d;
                        f4 = 1.0f;
                    } else {
                        k4.f6069b = i4;
                        bVar = k4.f6071d;
                        f4 = -1.0f;
                    }
                    bVar.f(jVar, f4);
                }
            }
            cVar.f6069b = i4;
            return;
        }
        k4 = k();
        k4.f6068a = jVar;
        float f5 = i4;
        jVar.f6107e = f5;
        k4.f6069b = f5;
        k4.f6072e = true;
        c(k4);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0055  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void e(p.j r7, p.j r8, int r9, int r10) {
        /*
            r6 = this;
            r0 = 0
            r1 = 1
            r2 = 8
            if (r10 != r2) goto L29
            boolean r3 = r8.f6108f
            if (r3 == 0) goto L29
            int r3 = r7.f6105c
            r4 = -1
            if (r3 != r4) goto L29
            float r8 = r8.f6107e
            float r9 = (float) r9
            float r8 = r8 + r9
            r7.f6107e = r8
            r7.f6108f = r1
            int r8 = r7.f6113k
            r9 = r0
        L1a:
            if (r9 >= r8) goto L26
            p.c[] r10 = r7.f6112j
            r10 = r10[r9]
            r10.g(r7, r0)
            int r9 = r9 + 1
            goto L1a
        L26:
            r7.f6113k = r0
            return
        L29:
            p.c r3 = r6.k()
            r4 = 1065353216(0x3f800000, float:1.0)
            r5 = -1082130432(0xffffffffbf800000, float:-1.0)
            if (r9 == 0) goto L49
            if (r9 >= 0) goto L38
            int r9 = r9 * (-1)
            r0 = r1
        L38:
            float r9 = (float) r9
            r3.f6069b = r9
            if (r0 != 0) goto L3e
            goto L49
        L3e:
            p.b r9 = r3.f6071d
            r9.f(r7, r4)
            p.b r7 = r3.f6071d
            r7.f(r8, r5)
            goto L53
        L49:
            p.b r9 = r3.f6071d
            r9.f(r7, r5)
            p.b r7 = r3.f6071d
            r7.f(r8, r4)
        L53:
            if (r10 == r2) goto L58
            r3.a(r6, r10)
        L58:
            r6.c(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p.f.e(p.j, p.j, int, int):void");
    }

    public final void f(j jVar, j jVar2, int i4, int i5) {
        c k4 = k();
        j l4 = l();
        l4.f6106d = 0;
        k4.b(jVar, jVar2, l4, i4);
        if (i5 != 8) {
            k4.f6071d.f(i(i5), (int) (k4.f6071d.e(l4) * (-1.0f)));
        }
        c(k4);
    }

    public final void g(j jVar, j jVar2, int i4, int i5) {
        c k4 = k();
        j l4 = l();
        l4.f6106d = 0;
        k4.c(jVar, jVar2, l4, i4);
        if (i5 != 8) {
            k4.f6071d.f(i(i5), (int) (k4.f6071d.e(l4) * (-1.0f)));
        }
        c(k4);
    }

    public final void h(c cVar) {
        c cVar2;
        Object obj;
        boolean z4 = f6079p;
        d dVar = this.f6090k;
        if (z4) {
            cVar2 = this.f6084e[this.f6088i];
            if (cVar2 != null) {
                obj = dVar.f6074a;
                ((g) obj).b(cVar2);
            }
        } else {
            cVar2 = this.f6084e[this.f6088i];
            if (cVar2 != null) {
                obj = dVar.f6075b;
                ((g) obj).b(cVar2);
            }
        }
        c[] cVarArr = this.f6084e;
        int i4 = this.f6088i;
        cVarArr[i4] = cVar;
        j jVar = cVar.f6068a;
        jVar.f6105c = i4;
        this.f6088i = i4 + 1;
        jVar.d(cVar);
    }

    public final j i(int i4) {
        if (this.f6087h + 1 >= this.f6083d) {
            n();
        }
        j a5 = a(SolverVariable$Type.f1119c);
        int i5 = this.f6080a + 1;
        this.f6080a = i5;
        this.f6087h++;
        a5.f6104b = i5;
        a5.f6106d = i4;
        ((j[]) this.f6090k.f6077d)[i5] = a5;
        i iVar = this.f6081b;
        iVar.f6102i.f6097a = a5;
        float[] fArr = a5.f6110h;
        Arrays.fill(fArr, 0.0f);
        fArr[a5.f6106d] = 1.0f;
        iVar.i(a5);
        return a5;
    }

    public final j j(Object obj) {
        j jVar = null;
        if (obj == null) {
            return null;
        }
        if (this.f6087h + 1 >= this.f6083d) {
            n();
        }
        if (obj instanceof q.c) {
            q.c cVar = (q.c) obj;
            jVar = cVar.f6195g;
            if (jVar == null) {
                cVar.i();
                jVar = cVar.f6195g;
            }
            int i4 = jVar.f6104b;
            d dVar = this.f6090k;
            if (i4 == -1 || i4 > this.f6080a || ((j[]) dVar.f6077d)[i4] == null) {
                if (i4 != -1) {
                    jVar.c();
                }
                int i5 = this.f6080a + 1;
                this.f6080a = i5;
                this.f6087h++;
                jVar.f6104b = i5;
                jVar.f6111i = SolverVariable$Type.f1117a;
                ((j[]) dVar.f6077d)[i5] = jVar;
            }
        }
        return jVar;
    }

    public final c k() {
        c cVar;
        boolean z4 = f6079p;
        d dVar = this.f6090k;
        if (z4) {
            cVar = (c) ((g) dVar.f6074a).a();
            if (cVar == null) {
                return new e(dVar);
            }
        } else {
            cVar = (c) ((g) dVar.f6075b).a();
            if (cVar == null) {
                return new c(dVar);
            }
        }
        cVar.f6068a = null;
        cVar.f6071d.clear();
        cVar.f6069b = 0.0f;
        cVar.f6072e = false;
        return cVar;
    }

    public final j l() {
        if (this.f6087h + 1 >= this.f6083d) {
            n();
        }
        j a5 = a(SolverVariable$Type.f1118b);
        int i4 = this.f6080a + 1;
        this.f6080a = i4;
        this.f6087h++;
        a5.f6104b = i4;
        ((j[]) this.f6090k.f6077d)[i4] = a5;
        return a5;
    }

    public final void n() {
        int i4 = this.f6082c * 2;
        this.f6082c = i4;
        this.f6084e = (c[]) Arrays.copyOf(this.f6084e, i4);
        d dVar = this.f6090k;
        dVar.f6077d = (j[]) Arrays.copyOf((j[]) dVar.f6077d, this.f6082c);
        int i5 = this.f6082c;
        this.f6086g = new boolean[i5];
        this.f6083d = i5;
        this.f6089j = i5;
    }

    public final void o(i iVar) {
        d dVar;
        int i4 = 0;
        while (true) {
            if (i4 >= this.f6088i) {
                break;
            }
            c cVar = this.f6084e[i4];
            SolverVariable$Type solverVariable$Type = cVar.f6068a.f6111i;
            SolverVariable$Type solverVariable$Type2 = SolverVariable$Type.f1117a;
            if (solverVariable$Type != solverVariable$Type2) {
                float f4 = 0.0f;
                if (cVar.f6069b < 0.0f) {
                    boolean z4 = false;
                    int i5 = 0;
                    while (!z4) {
                        int i6 = 1;
                        i5++;
                        float f5 = Float.MAX_VALUE;
                        int i7 = 0;
                        int i8 = -1;
                        int i9 = -1;
                        int i10 = 0;
                        while (true) {
                            int i11 = this.f6088i;
                            dVar = this.f6090k;
                            if (i7 >= i11) {
                                break;
                            }
                            c cVar2 = this.f6084e[i7];
                            if (cVar2.f6068a.f6111i != solverVariable$Type2 && !cVar2.f6072e && cVar2.f6069b < f4) {
                                int i12 = i6;
                                while (i12 < this.f6087h) {
                                    j jVar = ((j[]) dVar.f6077d)[i12];
                                    float e4 = cVar2.f6071d.e(jVar);
                                    if (e4 > f4) {
                                        for (int i13 = 0; i13 < 9; i13++) {
                                            float f6 = jVar.f6109g[i13] / e4;
                                            if ((f6 < f5 && i13 == i10) || i13 > i10) {
                                                i10 = i13;
                                                f5 = f6;
                                                i8 = i7;
                                                i9 = i12;
                                            }
                                        }
                                    }
                                    i12++;
                                    f4 = 0.0f;
                                }
                            }
                            i7++;
                            f4 = 0.0f;
                            i6 = 1;
                        }
                        if (i8 != -1) {
                            c cVar3 = this.f6084e[i8];
                            cVar3.f6068a.f6105c = -1;
                            cVar3.f(((j[]) dVar.f6077d)[i9]);
                            j jVar2 = cVar3.f6068a;
                            jVar2.f6105c = i8;
                            jVar2.d(cVar3);
                        } else {
                            z4 = true;
                        }
                        if (i5 > this.f6087h / 2) {
                            z4 = true;
                        }
                        f4 = 0.0f;
                    }
                }
            }
            i4++;
        }
        p(iVar);
        for (int i14 = 0; i14 < this.f6088i; i14++) {
            c cVar4 = this.f6084e[i14];
            cVar4.f6068a.f6107e = cVar4.f6069b;
        }
    }

    public final void p(c cVar) {
        for (int i4 = 0; i4 < this.f6087h; i4++) {
            this.f6086g[i4] = false;
        }
        boolean z4 = false;
        int i5 = 0;
        while (!z4) {
            i5++;
            if (i5 >= this.f6087h * 2) {
                return;
            }
            j jVar = cVar.f6068a;
            if (jVar != null) {
                this.f6086g[jVar.f6104b] = true;
            }
            j d4 = cVar.d(this.f6086g);
            if (d4 != null) {
                boolean[] zArr = this.f6086g;
                int i6 = d4.f6104b;
                if (zArr[i6]) {
                    return;
                }
                zArr[i6] = true;
            }
            if (d4 != null) {
                float f4 = Float.MAX_VALUE;
                int i7 = -1;
                for (int i8 = 0; i8 < this.f6088i; i8++) {
                    c cVar2 = this.f6084e[i8];
                    if (cVar2.f6068a.f6111i != SolverVariable$Type.f1117a && !cVar2.f6072e && cVar2.f6071d.g(d4)) {
                        float e4 = cVar2.f6071d.e(d4);
                        if (e4 < 0.0f) {
                            float f5 = (-cVar2.f6069b) / e4;
                            if (f5 < f4) {
                                i7 = i8;
                                f4 = f5;
                            }
                        }
                    }
                }
                if (i7 > -1) {
                    c cVar3 = this.f6084e[i7];
                    cVar3.f6068a.f6105c = -1;
                    cVar3.f(d4);
                    j jVar2 = cVar3.f6068a;
                    jVar2.f6105c = i7;
                    jVar2.d(cVar3);
                }
            } else {
                z4 = true;
            }
        }
    }

    public final void q() {
        boolean z4 = f6079p;
        d dVar = this.f6090k;
        int i4 = 0;
        if (z4) {
            while (true) {
                c[] cVarArr = this.f6084e;
                if (i4 < cVarArr.length) {
                    c cVar = cVarArr[i4];
                    if (cVar != null) {
                        ((g) dVar.f6074a).b(cVar);
                    }
                    this.f6084e[i4] = null;
                    i4++;
                } else {
                    return;
                }
            }
        } else {
            while (true) {
                c[] cVarArr2 = this.f6084e;
                if (i4 < cVarArr2.length) {
                    c cVar2 = cVarArr2[i4];
                    if (cVar2 != null) {
                        ((g) dVar.f6075b).b(cVar2);
                    }
                    this.f6084e[i4] = null;
                    i4++;
                } else {
                    return;
                }
            }
        }
    }

    public final void r() {
        d dVar;
        c cVar;
        int i4 = 0;
        while (true) {
            dVar = this.f6090k;
            j[] jVarArr = (j[]) dVar.f6077d;
            if (i4 >= jVarArr.length) {
                break;
            }
            j jVar = jVarArr[i4];
            if (jVar != null) {
                jVar.c();
            }
            i4++;
        }
        g gVar = (g) dVar.f6076c;
        j[] jVarArr2 = this.f6091l;
        int i5 = this.f6092m;
        gVar.getClass();
        if (i5 > jVarArr2.length) {
            i5 = jVarArr2.length;
        }
        for (int i6 = 0; i6 < i5; i6++) {
            j jVar2 = jVarArr2[i6];
            int i7 = gVar.f6096c;
            Object[] objArr = gVar.f6095b;
            if (i7 < objArr.length) {
                objArr[i7] = jVar2;
                gVar.f6096c = i7 + 1;
            }
        }
        this.f6092m = 0;
        Arrays.fill((j[]) dVar.f6077d, (Object) null);
        this.f6080a = 0;
        i iVar = this.f6081b;
        iVar.f6101h = 0;
        iVar.f6069b = 0.0f;
        this.f6087h = 1;
        for (int i8 = 0; i8 < this.f6088i; i8++) {
            this.f6084e[i8].getClass();
        }
        q();
        this.f6088i = 0;
        if (f6079p) {
            cVar = new e(dVar);
        } else {
            cVar = new c(dVar);
        }
        this.f6093n = cVar;
    }
}