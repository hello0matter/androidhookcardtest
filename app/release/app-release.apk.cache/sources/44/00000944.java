package q;

import androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    public int f6244a;

    /* renamed from: d  reason: collision with root package name */
    public c f6247d;

    /* renamed from: e  reason: collision with root package name */
    public c f6248e;

    /* renamed from: f  reason: collision with root package name */
    public c f6249f;

    /* renamed from: g  reason: collision with root package name */
    public c f6250g;

    /* renamed from: h  reason: collision with root package name */
    public int f6251h;

    /* renamed from: i  reason: collision with root package name */
    public int f6252i;

    /* renamed from: j  reason: collision with root package name */
    public int f6253j;

    /* renamed from: k  reason: collision with root package name */
    public int f6254k;

    /* renamed from: q  reason: collision with root package name */
    public int f6260q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ g f6261r;

    /* renamed from: b  reason: collision with root package name */
    public d f6245b = null;

    /* renamed from: c  reason: collision with root package name */
    public int f6246c = 0;

    /* renamed from: l  reason: collision with root package name */
    public int f6255l = 0;

    /* renamed from: m  reason: collision with root package name */
    public int f6256m = 0;

    /* renamed from: n  reason: collision with root package name */
    public int f6257n = 0;

    /* renamed from: o  reason: collision with root package name */
    public int f6258o = 0;

    /* renamed from: p  reason: collision with root package name */
    public int f6259p = 0;

    public f(g gVar, int i4, c cVar, c cVar2, c cVar3, c cVar4, int i5) {
        this.f6261r = gVar;
        this.f6251h = 0;
        this.f6252i = 0;
        this.f6253j = 0;
        this.f6254k = 0;
        this.f6260q = 0;
        this.f6244a = i4;
        this.f6247d = cVar;
        this.f6248e = cVar2;
        this.f6249f = cVar3;
        this.f6250g = cVar4;
        this.f6251h = gVar.f6266n0;
        this.f6252i = gVar.f6262j0;
        this.f6253j = gVar.f6267o0;
        this.f6254k = gVar.f6263k0;
        this.f6260q = i5;
    }

    public final void a(d dVar) {
        int i4 = this.f6244a;
        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour = ConstraintWidget$DimensionBehaviour.f1133c;
        int i5 = 0;
        g gVar = this.f6261r;
        if (i4 == 0) {
            int F = gVar.F(dVar, this.f6260q);
            if (dVar.J[0] == constraintWidget$DimensionBehaviour) {
                this.f6259p++;
                F = 0;
            }
            int i6 = gVar.G0;
            if (dVar.X != 8) {
                i5 = i6;
            }
            this.f6255l = F + i5 + this.f6255l;
            int E = gVar.E(dVar, this.f6260q);
            if (this.f6245b == null || this.f6246c < E) {
                this.f6245b = dVar;
                this.f6246c = E;
                this.f6256m = E;
            }
        } else {
            int F2 = gVar.F(dVar, this.f6260q);
            int E2 = gVar.E(dVar, this.f6260q);
            if (dVar.J[1] == constraintWidget$DimensionBehaviour) {
                this.f6259p++;
                E2 = 0;
            }
            int i7 = gVar.H0;
            if (dVar.X != 8) {
                i5 = i7;
            }
            this.f6256m = E2 + i5 + this.f6256m;
            if (this.f6245b == null || this.f6246c < F2) {
                this.f6245b = dVar;
                this.f6246c = F2;
                this.f6255l = F2;
            }
        }
        this.f6258o++;
    }

    public final void b(int i4, boolean z4, boolean z5) {
        g gVar;
        boolean z6;
        int i5;
        int i6;
        int i7;
        int i8;
        d dVar;
        int i9;
        char c4;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18 = this.f6258o;
        int i19 = 0;
        while (true) {
            gVar = this.f6261r;
            if (i19 >= i18 || (i17 = this.f6257n + i19) >= gVar.S0) {
                break;
            }
            d dVar2 = gVar.R0[i17];
            if (dVar2 != null) {
                dVar2.v();
            }
            i19++;
        }
        if (i18 != 0 && this.f6245b != null) {
            if (z5 && i4 == 0) {
                z6 = true;
            } else {
                z6 = false;
            }
            int i20 = -1;
            int i21 = -1;
            for (int i22 = 0; i22 < i18; i22++) {
                if (z4) {
                    i16 = (i18 - 1) - i22;
                } else {
                    i16 = i22;
                }
                int i23 = this.f6257n + i16;
                if (i23 >= gVar.S0) {
                    break;
                }
                if (gVar.R0[i23].X == 0) {
                    if (i20 == -1) {
                        i20 = i22;
                    }
                    i21 = i22;
                }
            }
            if (this.f6244a == 0) {
                d dVar3 = this.f6245b;
                dVar3.f6199b0 = gVar.f6274v0;
                int i24 = this.f6252i;
                if (i4 > 0) {
                    i24 += gVar.H0;
                }
                c cVar = this.f6248e;
                c cVar2 = dVar3.f6228z;
                cVar2.a(cVar, i24);
                c cVar3 = dVar3.B;
                if (z5) {
                    cVar3.a(this.f6250g, this.f6254k);
                }
                if (i4 > 0) {
                    this.f6248e.f6190b.B.a(cVar2, 0);
                }
                if (gVar.J0 == 3 && !dVar3.f6225w) {
                    for (int i25 = 0; i25 < i18; i25++) {
                        if (z4) {
                            i15 = (i18 - 1) - i25;
                        } else {
                            i15 = i25;
                        }
                        int i26 = this.f6257n + i15;
                        if (i26 >= gVar.S0) {
                            break;
                        }
                        dVar = gVar.R0[i26];
                        if (dVar.f6225w) {
                            break;
                        }
                    }
                }
                dVar = dVar3;
                int i27 = 0;
                d dVar4 = null;
                while (i27 < i18) {
                    if (z4) {
                        i9 = (i18 - 1) - i27;
                    } else {
                        i9 = i27;
                    }
                    int i28 = this.f6257n + i9;
                    if (i28 < gVar.S0) {
                        d dVar5 = gVar.R0[i28];
                        if (i27 == 0) {
                            dVar5.f(dVar5.f6227y, this.f6247d, this.f6251h);
                        }
                        if (i9 == 0) {
                            int i29 = gVar.f6273u0;
                            float f4 = gVar.A0;
                            if (this.f6257n == 0) {
                                i14 = gVar.f6275w0;
                                i11 = i29;
                                i12 = -1;
                                if (i14 != -1) {
                                    f4 = gVar.C0;
                                    i13 = i14;
                                    dVar5.f6197a0 = i13;
                                    dVar5.U = f4;
                                }
                            } else {
                                i11 = i29;
                                i12 = -1;
                            }
                            if (z5 && (i14 = gVar.f6277y0) != i12) {
                                f4 = gVar.E0;
                                i13 = i14;
                                dVar5.f6197a0 = i13;
                                dVar5.U = f4;
                            } else {
                                i13 = i11;
                                dVar5.f6197a0 = i13;
                                dVar5.U = f4;
                            }
                        }
                        if (i27 == i18 - 1) {
                            dVar5.f(dVar5.A, this.f6249f, this.f6253j);
                        }
                        if (dVar4 != null) {
                            c cVar4 = dVar5.f6227y;
                            int i30 = gVar.G0;
                            c cVar5 = dVar4.A;
                            cVar4.a(cVar5, i30);
                            c cVar6 = dVar5.f6227y;
                            if (i27 == i20) {
                                int i31 = this.f6251h;
                                if (cVar6.f()) {
                                    cVar6.f6194f = i31;
                                }
                            }
                            cVar5.a(cVar6, 0);
                            if (i27 == i21 + 1) {
                                int i32 = this.f6253j;
                                if (cVar5.f()) {
                                    cVar5.f6194f = i32;
                                }
                            }
                        }
                        if (dVar5 != dVar3) {
                            int i33 = gVar.J0;
                            c4 = 3;
                            if (i33 == 3 && dVar.f6225w && dVar5 != dVar && dVar5.f6225w) {
                                dVar5.C.a(dVar.C, 0);
                            } else if (i33 != 0) {
                                if (i33 != 1) {
                                    c cVar7 = dVar5.f6228z;
                                    if (z6) {
                                        cVar7.a(this.f6248e, this.f6252i);
                                        dVar5.B.a(this.f6250g, this.f6254k);
                                    } else {
                                        i10 = 0;
                                        cVar7.a(cVar2, 0);
                                    }
                                } else {
                                    i10 = 0;
                                }
                                dVar5.B.a(cVar3, i10);
                            } else {
                                dVar5.f6228z.a(cVar2, 0);
                            }
                        } else {
                            c4 = 3;
                        }
                        i27++;
                        dVar4 = dVar5;
                    } else {
                        return;
                    }
                }
                return;
            }
            d dVar6 = this.f6245b;
            dVar6.f6197a0 = gVar.f6273u0;
            int i34 = this.f6251h;
            if (i4 > 0) {
                i34 += gVar.G0;
            }
            c cVar8 = dVar6.f6227y;
            c cVar9 = dVar6.A;
            if (z4) {
                cVar9.a(this.f6249f, i34);
                if (z5) {
                    cVar8.a(this.f6247d, this.f6253j);
                }
                if (i4 > 0) {
                    this.f6249f.f6190b.f6227y.a(cVar9, 0);
                }
            } else {
                cVar8.a(this.f6247d, i34);
                if (z5) {
                    cVar9.a(this.f6249f, this.f6253j);
                }
                if (i4 > 0) {
                    this.f6247d.f6190b.A.a(cVar8, 0);
                }
            }
            int i35 = 0;
            d dVar7 = null;
            while (i35 < i18) {
                int i36 = this.f6257n + i35;
                if (i36 < gVar.S0) {
                    d dVar8 = gVar.R0[i36];
                    if (i35 == 0) {
                        dVar8.f(dVar8.f6228z, this.f6248e, this.f6252i);
                        int i37 = gVar.f6274v0;
                        float f5 = gVar.B0;
                        if (this.f6257n == 0) {
                            i8 = gVar.f6276x0;
                            i7 = -1;
                            if (i8 != -1) {
                                f5 = gVar.D0;
                                i37 = i8;
                                dVar8.f6199b0 = i37;
                                dVar8.V = f5;
                            }
                        } else {
                            i7 = -1;
                        }
                        if (z5 && (i8 = gVar.f6278z0) != i7) {
                            f5 = gVar.F0;
                            i37 = i8;
                        }
                        dVar8.f6199b0 = i37;
                        dVar8.V = f5;
                    }
                    if (i35 == i18 - 1) {
                        dVar8.f(dVar8.B, this.f6250g, this.f6254k);
                    }
                    if (dVar7 != null) {
                        c cVar10 = dVar8.f6228z;
                        int i38 = gVar.H0;
                        c cVar11 = dVar7.B;
                        cVar10.a(cVar11, i38);
                        c cVar12 = dVar8.f6228z;
                        if (i35 == i20) {
                            int i39 = this.f6252i;
                            if (cVar12.f()) {
                                cVar12.f6194f = i39;
                            }
                        }
                        cVar11.a(cVar12, 0);
                        if (i35 == i21 + 1) {
                            int i40 = this.f6254k;
                            if (cVar11.f()) {
                                cVar11.f6194f = i40;
                            }
                        }
                    }
                    if (dVar8 != dVar6) {
                        if (z4) {
                            int i41 = gVar.I0;
                            if (i41 != 0) {
                                if (i41 != 1) {
                                    if (i41 == 2) {
                                        i6 = 0;
                                        dVar8.f6227y.a(cVar8, 0);
                                    }
                                } else {
                                    dVar8.f6227y.a(cVar8, 0);
                                }
                            } else {
                                i6 = 0;
                            }
                            dVar8.A.a(cVar9, i6);
                        } else {
                            int i42 = gVar.I0;
                            if (i42 != 0) {
                                if (i42 != 1) {
                                    if (i42 == 2) {
                                        c cVar13 = dVar8.f6227y;
                                        if (z6) {
                                            cVar13.a(this.f6247d, this.f6251h);
                                            dVar8.A.a(this.f6249f, this.f6253j);
                                        } else {
                                            i5 = 0;
                                            cVar13.a(cVar8, 0);
                                        }
                                    }
                                } else {
                                    i5 = 0;
                                }
                                dVar8.A.a(cVar9, i5);
                            } else {
                                dVar8.f6227y.a(cVar8, 0);
                            }
                            i35++;
                            dVar7 = dVar8;
                        }
                    }
                    i35++;
                    dVar7 = dVar8;
                } else {
                    return;
                }
            }
        }
    }

    public final int c() {
        if (this.f6244a == 1) {
            return this.f6256m - this.f6261r.H0;
        }
        return this.f6256m;
    }

    public final int d() {
        if (this.f6244a == 0) {
            return this.f6255l - this.f6261r.G0;
        }
        return this.f6255l;
    }

    public final void e(int i4) {
        g gVar;
        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour;
        int n4;
        int i5;
        int i6 = this.f6259p;
        if (i6 == 0) {
            return;
        }
        int i7 = this.f6258o;
        int i8 = i4 / i6;
        for (int i9 = 0; i9 < i7; i9++) {
            int i10 = this.f6257n;
            int i11 = i10 + i9;
            g gVar2 = this.f6261r;
            if (i11 >= gVar2.S0) {
                break;
            }
            d dVar = gVar2.R0[i10 + i9];
            int i12 = this.f6244a;
            ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour2 = ConstraintWidget$DimensionBehaviour.f1131a;
            ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour3 = ConstraintWidget$DimensionBehaviour.f1133c;
            if (i12 == 0) {
                if (dVar != null) {
                    ConstraintWidget$DimensionBehaviour[] constraintWidget$DimensionBehaviourArr = dVar.J;
                    if (constraintWidget$DimensionBehaviourArr[0] == constraintWidget$DimensionBehaviour3 && dVar.f6212j == 0) {
                        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour4 = constraintWidget$DimensionBehaviourArr[1];
                        gVar = gVar2;
                        constraintWidget$DimensionBehaviour = constraintWidget$DimensionBehaviour2;
                        n4 = i8;
                        constraintWidget$DimensionBehaviour2 = constraintWidget$DimensionBehaviour4;
                        i5 = dVar.k();
                        gVar.G(dVar, constraintWidget$DimensionBehaviour, n4, constraintWidget$DimensionBehaviour2, i5);
                    }
                }
            } else {
                if (dVar != null) {
                    ConstraintWidget$DimensionBehaviour[] constraintWidget$DimensionBehaviourArr2 = dVar.J;
                    if (constraintWidget$DimensionBehaviourArr2[1] == constraintWidget$DimensionBehaviour3 && dVar.f6213k == 0) {
                        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour5 = constraintWidget$DimensionBehaviourArr2[0];
                        gVar = gVar2;
                        constraintWidget$DimensionBehaviour = constraintWidget$DimensionBehaviour5;
                        n4 = dVar.n();
                        i5 = i8;
                        gVar.G(dVar, constraintWidget$DimensionBehaviour, n4, constraintWidget$DimensionBehaviour2, i5);
                    }
                }
            }
        }
        this.f6255l = 0;
        this.f6256m = 0;
        this.f6245b = null;
        this.f6246c = 0;
        int i13 = this.f6258o;
        for (int i14 = 0; i14 < i13; i14++) {
            int i15 = this.f6257n + i14;
            g gVar3 = this.f6261r;
            if (i15 < gVar3.S0) {
                d dVar2 = gVar3.R0[i15];
                if (this.f6244a == 0) {
                    int n5 = dVar2.n();
                    int i16 = gVar3.G0;
                    if (dVar2.X == 8) {
                        i16 = 0;
                    }
                    this.f6255l = n5 + i16 + this.f6255l;
                    int E = gVar3.E(dVar2, this.f6260q);
                    if (this.f6245b == null || this.f6246c < E) {
                        this.f6245b = dVar2;
                        this.f6246c = E;
                        this.f6256m = E;
                    }
                } else {
                    int F = gVar3.F(dVar2, this.f6260q);
                    int E2 = gVar3.E(dVar2, this.f6260q);
                    int i17 = gVar3.H0;
                    if (dVar2.X == 8) {
                        i17 = 0;
                    }
                    this.f6256m = E2 + i17 + this.f6256m;
                    if (this.f6245b == null || this.f6246c < F) {
                        this.f6245b = dVar2;
                        this.f6246c = F;
                        this.f6255l = F;
                    }
                }
            } else {
                return;
            }
        }
    }

    public final void f(int i4, c cVar, c cVar2, c cVar3, c cVar4, int i5, int i6, int i7, int i8, int i9) {
        this.f6244a = i4;
        this.f6247d = cVar;
        this.f6248e = cVar2;
        this.f6249f = cVar3;
        this.f6250g = cVar4;
        this.f6251h = i5;
        this.f6252i = i6;
        this.f6253j = i7;
        this.f6254k = i8;
        this.f6260q = i9;
    }
}