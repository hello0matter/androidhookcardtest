package q;

import androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class g extends j {
    public d[] R0;

    /* renamed from: j0  reason: collision with root package name */
    public int f6262j0 = 0;

    /* renamed from: k0  reason: collision with root package name */
    public int f6263k0 = 0;

    /* renamed from: l0  reason: collision with root package name */
    public int f6264l0 = 0;

    /* renamed from: m0  reason: collision with root package name */
    public int f6265m0 = 0;

    /* renamed from: n0  reason: collision with root package name */
    public int f6266n0 = 0;

    /* renamed from: o0  reason: collision with root package name */
    public int f6267o0 = 0;

    /* renamed from: p0  reason: collision with root package name */
    public boolean f6268p0 = false;

    /* renamed from: q0  reason: collision with root package name */
    public int f6269q0 = 0;

    /* renamed from: r0  reason: collision with root package name */
    public int f6270r0 = 0;

    /* renamed from: s0  reason: collision with root package name */
    public final r.b f6271s0 = new Object();

    /* renamed from: t0  reason: collision with root package name */
    public r.c f6272t0 = null;

    /* renamed from: u0  reason: collision with root package name */
    public int f6273u0 = -1;

    /* renamed from: v0  reason: collision with root package name */
    public int f6274v0 = -1;

    /* renamed from: w0  reason: collision with root package name */
    public int f6275w0 = -1;

    /* renamed from: x0  reason: collision with root package name */
    public int f6276x0 = -1;

    /* renamed from: y0  reason: collision with root package name */
    public int f6277y0 = -1;

    /* renamed from: z0  reason: collision with root package name */
    public int f6278z0 = -1;
    public float A0 = 0.5f;
    public float B0 = 0.5f;
    public float C0 = 0.5f;
    public float D0 = 0.5f;
    public float E0 = 0.5f;
    public float F0 = 0.5f;
    public int G0 = 0;
    public int H0 = 0;
    public int I0 = 2;
    public int J0 = 2;
    public int K0 = 0;
    public int L0 = -1;
    public int M0 = 0;
    public final ArrayList N0 = new ArrayList();
    public d[] O0 = null;
    public d[] P0 = null;
    public int[] Q0 = null;
    public int S0 = 0;

    public final int E(d dVar, int i4) {
        if (dVar == null) {
            return 0;
        }
        if (dVar.J[1] == ConstraintWidget$DimensionBehaviour.f1133c) {
            int i5 = dVar.f6213k;
            if (i5 == 0) {
                return 0;
            }
            if (i5 == 2) {
                int i6 = (int) (dVar.f6220r * i4);
                if (i6 != dVar.k()) {
                    G(dVar, dVar.J[0], dVar.n(), ConstraintWidget$DimensionBehaviour.f1131a, i6);
                }
                return i6;
            } else if (i5 == 1) {
                return dVar.k();
            } else {
                if (i5 == 3) {
                    return (int) ((dVar.n() * dVar.N) + 0.5f);
                }
            }
        }
        return dVar.k();
    }

    public final int F(d dVar, int i4) {
        if (dVar == null) {
            return 0;
        }
        if (dVar.J[0] == ConstraintWidget$DimensionBehaviour.f1133c) {
            int i5 = dVar.f6212j;
            if (i5 == 0) {
                return 0;
            }
            if (i5 == 2) {
                int i6 = (int) (dVar.f6217o * i4);
                if (i6 != dVar.n()) {
                    G(dVar, ConstraintWidget$DimensionBehaviour.f1131a, i6, dVar.J[1], dVar.k());
                }
                return i6;
            } else if (i5 == 1) {
                return dVar.n();
            } else {
                if (i5 == 3) {
                    return (int) ((dVar.k() * dVar.N) + 0.5f);
                }
            }
        }
        return dVar.n();
    }

    public final void G(d dVar, ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour, int i4, ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour2, int i5) {
        r.c cVar;
        boolean z4;
        d dVar2;
        while (true) {
            cVar = this.f6272t0;
            if (cVar != null || (dVar2 = this.K) == null) {
                break;
            }
            this.f6272t0 = ((e) dVar2).f6232k0;
        }
        r.b bVar = this.f6271s0;
        bVar.f6429a = constraintWidget$DimensionBehaviour;
        bVar.f6430b = constraintWidget$DimensionBehaviour2;
        bVar.f6431c = i4;
        bVar.f6432d = i5;
        ((androidx.constraintlayout.widget.b) cVar).a(dVar, bVar);
        dVar.A(this.f6271s0.f6433e);
        dVar.x(this.f6271s0.f6434f);
        r.b bVar2 = this.f6271s0;
        dVar.f6225w = bVar2.f6436h;
        int i6 = bVar2.f6435g;
        dVar.R = i6;
        if (i6 > 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        dVar.f6225w = z4;
    }

    @Override // q.j, q.i
    public final void a() {
        for (int i4 = 0; i4 < this.f6285i0; i4++) {
            d dVar = this.f6284h0[i4];
        }
    }

    @Override // q.d
    public final void b(p.f fVar) {
        boolean z4;
        boolean z5;
        d dVar;
        int i4;
        super.b(fVar);
        d dVar2 = this.K;
        if (dVar2 != null) {
            z4 = ((e) dVar2).f6233l0;
        } else {
            z4 = false;
        }
        int i5 = this.K0;
        ArrayList arrayList = this.N0;
        if (i5 != 0) {
            if (i5 != 1) {
                if (i5 == 2 && this.Q0 != null && this.P0 != null && this.O0 != null) {
                    for (int i6 = 0; i6 < this.S0; i6++) {
                        this.R0[i6].v();
                    }
                    int[] iArr = this.Q0;
                    int i7 = iArr[0];
                    int i8 = iArr[1];
                    d dVar3 = null;
                    for (int i9 = 0; i9 < i7; i9++) {
                        if (z4) {
                            i4 = (i7 - i9) - 1;
                        } else {
                            i4 = i9;
                        }
                        d dVar4 = this.P0[i4];
                        if (dVar4 != null && dVar4.X != 8) {
                            c cVar = dVar4.f6227y;
                            if (i9 == 0) {
                                dVar4.f(cVar, this.f6227y, this.f6266n0);
                                dVar4.f6197a0 = this.f6273u0;
                                dVar4.U = this.A0;
                            }
                            if (i9 == i7 - 1) {
                                dVar4.f(dVar4.A, this.A, this.f6267o0);
                            }
                            if (i9 > 0) {
                                dVar4.f(cVar, dVar3.A, this.G0);
                                dVar3.f(dVar3.A, cVar, 0);
                            }
                            dVar3 = dVar4;
                        }
                    }
                    for (int i10 = 0; i10 < i8; i10++) {
                        d dVar5 = this.O0[i10];
                        if (dVar5 != null && dVar5.X != 8) {
                            c cVar2 = dVar5.f6228z;
                            if (i10 == 0) {
                                dVar5.f(cVar2, this.f6228z, this.f6262j0);
                                dVar5.f6199b0 = this.f6274v0;
                                dVar5.V = this.B0;
                            }
                            if (i10 == i8 - 1) {
                                dVar5.f(dVar5.B, this.B, this.f6263k0);
                            }
                            if (i10 > 0) {
                                dVar5.f(cVar2, dVar3.B, this.H0);
                                dVar3.f(dVar3.B, cVar2, 0);
                            }
                            dVar3 = dVar5;
                        }
                    }
                    for (int i11 = 0; i11 < i7; i11++) {
                        for (int i12 = 0; i12 < i8; i12++) {
                            int i13 = (i12 * i7) + i11;
                            if (this.M0 == 1) {
                                i13 = (i11 * i8) + i12;
                            }
                            d[] dVarArr = this.R0;
                            if (i13 < dVarArr.length && (dVar = dVarArr[i13]) != null && dVar.X != 8) {
                                d dVar6 = this.P0[i11];
                                d dVar7 = this.O0[i12];
                                if (dVar != dVar6) {
                                    dVar.f(dVar.f6227y, dVar6.f6227y, 0);
                                    dVar.f(dVar.A, dVar6.A, 0);
                                }
                                if (dVar != dVar7) {
                                    dVar.f(dVar.f6228z, dVar7.f6228z, 0);
                                    dVar.f(dVar.B, dVar7.B, 0);
                                }
                            }
                        }
                    }
                }
            } else {
                int size = arrayList.size();
                for (int i14 = 0; i14 < size; i14++) {
                    f fVar2 = (f) arrayList.get(i14);
                    if (i14 == size - 1) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    fVar2.b(i14, z4, z5);
                }
            }
        } else if (arrayList.size() > 0) {
            ((f) arrayList.get(0)).b(0, z4, true);
        }
        this.f6268p0 = false;
    }

    @Override // q.j, q.d
    public final void g(d dVar, HashMap hashMap) {
        super.g(dVar, hashMap);
        g gVar = (g) dVar;
        this.f6273u0 = gVar.f6273u0;
        this.f6274v0 = gVar.f6274v0;
        this.f6275w0 = gVar.f6275w0;
        this.f6276x0 = gVar.f6276x0;
        this.f6277y0 = gVar.f6277y0;
        this.f6278z0 = gVar.f6278z0;
        this.A0 = gVar.A0;
        this.B0 = gVar.B0;
        this.C0 = gVar.C0;
        this.D0 = gVar.D0;
        this.E0 = gVar.E0;
        this.F0 = gVar.F0;
        this.G0 = gVar.G0;
        this.H0 = gVar.H0;
        this.I0 = gVar.I0;
        this.J0 = gVar.J0;
        this.K0 = gVar.K0;
        this.L0 = gVar.L0;
        this.M0 = gVar.M0;
    }
}