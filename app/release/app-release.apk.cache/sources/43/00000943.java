package q;

import androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class e extends d {

    /* renamed from: h0  reason: collision with root package name */
    public ArrayList f6229h0 = new ArrayList();

    /* renamed from: i0  reason: collision with root package name */
    public final androidx.appcompat.app.c f6230i0;

    /* renamed from: j0  reason: collision with root package name */
    public final r.f f6231j0;

    /* renamed from: k0  reason: collision with root package name */
    public r.c f6232k0;

    /* renamed from: l0  reason: collision with root package name */
    public boolean f6233l0;

    /* renamed from: m0  reason: collision with root package name */
    public final p.f f6234m0;

    /* renamed from: n0  reason: collision with root package name */
    public int f6235n0;

    /* renamed from: o0  reason: collision with root package name */
    public int f6236o0;

    /* renamed from: p0  reason: collision with root package name */
    public int f6237p0;

    /* renamed from: q0  reason: collision with root package name */
    public int f6238q0;

    /* renamed from: r0  reason: collision with root package name */
    public b[] f6239r0;

    /* renamed from: s0  reason: collision with root package name */
    public b[] f6240s0;

    /* renamed from: t0  reason: collision with root package name */
    public int f6241t0;

    /* renamed from: u0  reason: collision with root package name */
    public boolean f6242u0;

    /* renamed from: v0  reason: collision with root package name */
    public boolean f6243v0;

    /* JADX WARN: Type inference failed for: r0v1, types: [androidx.appcompat.app.c, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, r.f] */
    /* JADX WARN: Type inference failed for: r2v0, types: [r.b, java.lang.Object] */
    public e() {
        ?? obj = new Object();
        obj.f192a = new ArrayList();
        obj.f193b = new Object();
        obj.f194c = this;
        this.f6230i0 = obj;
        ?? obj2 = new Object();
        obj2.f6442b = true;
        obj2.f6443c = true;
        obj2.f6445e = new ArrayList();
        new ArrayList();
        obj2.f6446f = null;
        obj2.f6447g = new Object();
        obj2.f6448h = new ArrayList();
        obj2.f6441a = this;
        obj2.f6444d = this;
        this.f6231j0 = obj2;
        this.f6232k0 = null;
        this.f6233l0 = false;
        this.f6234m0 = new p.f();
        this.f6237p0 = 0;
        this.f6238q0 = 0;
        this.f6239r0 = new b[4];
        this.f6240s0 = new b[4];
        this.f6241t0 = 263;
        this.f6242u0 = false;
        this.f6243v0 = false;
    }

    @Override // q.d
    public final void B(boolean z4, boolean z5) {
        super.B(z4, z5);
        int size = this.f6229h0.size();
        for (int i4 = 0; i4 < size; i4++) {
            ((d) this.f6229h0.get(i4)).B(z4, z5);
        }
    }

    public final void D(d dVar, int i4) {
        if (i4 == 0) {
            int i5 = this.f6237p0 + 1;
            b[] bVarArr = this.f6240s0;
            if (i5 >= bVarArr.length) {
                this.f6240s0 = (b[]) Arrays.copyOf(bVarArr, bVarArr.length * 2);
            }
            b[] bVarArr2 = this.f6240s0;
            int i6 = this.f6237p0;
            bVarArr2[i6] = new b(dVar, 0, this.f6233l0);
            this.f6237p0 = i6 + 1;
        } else if (i4 == 1) {
            int i7 = this.f6238q0 + 1;
            b[] bVarArr3 = this.f6239r0;
            if (i7 >= bVarArr3.length) {
                this.f6239r0 = (b[]) Arrays.copyOf(bVarArr3, bVarArr3.length * 2);
            }
            b[] bVarArr4 = this.f6239r0;
            int i8 = this.f6238q0;
            bVarArr4[i8] = new b(dVar, 1, this.f6233l0);
            this.f6238q0 = i8 + 1;
        }
    }

    public final void E(p.f fVar) {
        b(fVar);
        int size = this.f6229h0.size();
        boolean z4 = false;
        for (int i4 = 0; i4 < size; i4++) {
            d dVar = (d) this.f6229h0.get(i4);
            boolean[] zArr = dVar.I;
            zArr[0] = false;
            zArr[1] = false;
            if (dVar instanceof a) {
                z4 = true;
            }
        }
        if (z4) {
            for (int i5 = 0; i5 < size; i5++) {
                d dVar2 = (d) this.f6229h0.get(i5);
                if (dVar2 instanceof a) {
                    a aVar = (a) dVar2;
                    for (int i6 = 0; i6 < aVar.f6285i0; i6++) {
                        d dVar3 = aVar.f6284h0[i6];
                        int i7 = aVar.f6169j0;
                        if (i7 != 0 && i7 != 1) {
                            if (i7 == 2 || i7 == 3) {
                                dVar3.I[1] = true;
                            }
                        } else {
                            dVar3.I[0] = true;
                        }
                    }
                }
            }
        }
        for (int i8 = 0; i8 < size; i8++) {
            d dVar4 = (d) this.f6229h0.get(i8);
            dVar4.getClass();
            if ((dVar4 instanceof g) || (dVar4 instanceof h)) {
                dVar4.b(fVar);
            }
        }
        for (int i9 = 0; i9 < size; i9++) {
            d dVar5 = (d) this.f6229h0.get(i9);
            boolean z5 = dVar5 instanceof e;
            ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour = ConstraintWidget$DimensionBehaviour.f1132b;
            if (z5) {
                ConstraintWidget$DimensionBehaviour[] constraintWidget$DimensionBehaviourArr = dVar5.J;
                ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour2 = constraintWidget$DimensionBehaviourArr[0];
                ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour3 = constraintWidget$DimensionBehaviourArr[1];
                ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour4 = ConstraintWidget$DimensionBehaviour.f1131a;
                if (constraintWidget$DimensionBehaviour2 == constraintWidget$DimensionBehaviour) {
                    dVar5.y(constraintWidget$DimensionBehaviour4);
                }
                if (constraintWidget$DimensionBehaviour3 == constraintWidget$DimensionBehaviour) {
                    dVar5.z(constraintWidget$DimensionBehaviour4);
                }
                dVar5.b(fVar);
                if (constraintWidget$DimensionBehaviour2 == constraintWidget$DimensionBehaviour) {
                    dVar5.y(constraintWidget$DimensionBehaviour2);
                }
                if (constraintWidget$DimensionBehaviour3 == constraintWidget$DimensionBehaviour) {
                    dVar5.z(constraintWidget$DimensionBehaviour3);
                }
            } else {
                dVar5.f6210h = -1;
                dVar5.f6211i = -1;
                ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour5 = this.J[0];
                ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour6 = ConstraintWidget$DimensionBehaviour.f1134d;
                if (constraintWidget$DimensionBehaviour5 != constraintWidget$DimensionBehaviour && dVar5.J[0] == constraintWidget$DimensionBehaviour6) {
                    c cVar = dVar5.f6227y;
                    int i10 = cVar.f6193e;
                    int n4 = n();
                    c cVar2 = dVar5.A;
                    int i11 = n4 - cVar2.f6193e;
                    cVar.f6195g = fVar.j(cVar);
                    cVar2.f6195g = fVar.j(cVar2);
                    fVar.d(cVar.f6195g, i10);
                    fVar.d(cVar2.f6195g, i11);
                    dVar5.f6210h = 2;
                    dVar5.P = i10;
                    int i12 = i11 - i10;
                    dVar5.L = i12;
                    int i13 = dVar5.S;
                    if (i12 < i13) {
                        dVar5.L = i13;
                    }
                }
                if (this.J[1] != constraintWidget$DimensionBehaviour && dVar5.J[1] == constraintWidget$DimensionBehaviour6) {
                    c cVar3 = dVar5.f6228z;
                    int i14 = cVar3.f6193e;
                    int k4 = k();
                    c cVar4 = dVar5.B;
                    int i15 = k4 - cVar4.f6193e;
                    cVar3.f6195g = fVar.j(cVar3);
                    cVar4.f6195g = fVar.j(cVar4);
                    fVar.d(cVar3.f6195g, i14);
                    fVar.d(cVar4.f6195g, i15);
                    if (dVar5.R > 0 || dVar5.X == 8) {
                        c cVar5 = dVar5.C;
                        p.j j4 = fVar.j(cVar5);
                        cVar5.f6195g = j4;
                        fVar.d(j4, dVar5.R + i14);
                    }
                    dVar5.f6211i = 2;
                    dVar5.Q = i14;
                    int i16 = i15 - i14;
                    dVar5.M = i16;
                    int i17 = dVar5.T;
                    if (i16 < i17) {
                        dVar5.M = i17;
                    }
                }
                if (!(dVar5 instanceof g) && !(dVar5 instanceof h)) {
                    dVar5.b(fVar);
                }
            }
        }
        if (this.f6237p0 > 0) {
            com.google.common.collect.c.l(this, fVar, 0);
        }
        if (this.f6238q0 > 0) {
            com.google.common.collect.c.l(this, fVar, 1);
        }
    }

    public final boolean F(int i4, boolean z4) {
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour;
        androidx.constraintlayout.solver.widgets.analyzer.b bVar;
        int k4;
        boolean z9 = z4 & true;
        r.f fVar = this.f6231j0;
        e eVar = fVar.f6441a;
        ConstraintWidget$DimensionBehaviour j4 = eVar.j(0);
        ConstraintWidget$DimensionBehaviour j5 = eVar.j(1);
        int o4 = eVar.o();
        int p4 = eVar.p();
        ArrayList arrayList = fVar.f6445e;
        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour2 = ConstraintWidget$DimensionBehaviour.f1131a;
        androidx.constraintlayout.solver.widgets.analyzer.e eVar2 = eVar.f6204e;
        androidx.constraintlayout.solver.widgets.analyzer.d dVar = eVar.f6202d;
        if (z9 && (j4 == (constraintWidget$DimensionBehaviour = ConstraintWidget$DimensionBehaviour.f1132b) || j5 == constraintWidget$DimensionBehaviour)) {
            Iterator it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                androidx.constraintlayout.solver.widgets.analyzer.f fVar2 = (androidx.constraintlayout.solver.widgets.analyzer.f) it.next();
                if (fVar2.f1169f == i4 && !fVar2.k()) {
                    z9 = false;
                    break;
                }
            }
            if (i4 == 0) {
                if (z9 && j4 == constraintWidget$DimensionBehaviour) {
                    eVar.y(constraintWidget$DimensionBehaviour2);
                    eVar.A(fVar.d(eVar, 0));
                    bVar = dVar.f1168e;
                    k4 = eVar.n();
                    bVar.d(k4);
                }
            } else if (z9 && j5 == constraintWidget$DimensionBehaviour) {
                eVar.z(constraintWidget$DimensionBehaviour2);
                eVar.x(fVar.d(eVar, 1));
                bVar = eVar2.f1168e;
                k4 = eVar.k();
                bVar.d(k4);
            }
        }
        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour3 = ConstraintWidget$DimensionBehaviour.f1134d;
        if (i4 == 0) {
            z5 = false;
            ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour4 = eVar.J[0];
            if (constraintWidget$DimensionBehaviour4 != constraintWidget$DimensionBehaviour2 && constraintWidget$DimensionBehaviour4 != constraintWidget$DimensionBehaviour3) {
                z6 = true;
                z7 = z5;
            } else {
                int n4 = eVar.n() + o4;
                dVar.f1172i.d(n4);
                dVar.f1168e.d(n4 - o4);
                z7 = true;
                z6 = true;
            }
        } else {
            z5 = false;
            z6 = true;
            ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour5 = eVar.J[1];
            if (constraintWidget$DimensionBehaviour5 == constraintWidget$DimensionBehaviour2 || constraintWidget$DimensionBehaviour5 == constraintWidget$DimensionBehaviour3) {
                int k5 = eVar.k() + p4;
                eVar2.f1172i.d(k5);
                eVar2.f1168e.d(k5 - p4);
                z7 = true;
            }
            z7 = z5;
        }
        fVar.g();
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            androidx.constraintlayout.solver.widgets.analyzer.f fVar3 = (androidx.constraintlayout.solver.widgets.analyzer.f) it2.next();
            if (fVar3.f1169f == i4 && (fVar3.f1165b != eVar || fVar3.f1170g)) {
                fVar3.e();
            }
        }
        Iterator it3 = arrayList.iterator();
        while (it3.hasNext()) {
            androidx.constraintlayout.solver.widgets.analyzer.f fVar4 = (androidx.constraintlayout.solver.widgets.analyzer.f) it3.next();
            if (fVar4.f1169f == i4 && (z7 || fVar4.f1165b != eVar)) {
                if (!fVar4.f1171h.f1157j || !fVar4.f1172i.f1157j || (!(fVar4 instanceof r.d) && !fVar4.f1168e.f1157j)) {
                    z8 = z5;
                    break;
                }
            }
        }
        z8 = z6;
        eVar.y(j4);
        eVar.z(j5);
        return z8;
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x00fd A[LOOP:5: B:59:0x00fb->B:60:0x00fd, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01c2  */
    /* JADX WARN: Type inference failed for: r7v10, types: [boolean] */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void G() {
        /*
            Method dump skipped, instructions count: 532
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: q.e.G():void");
    }

    public final void H() {
        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour;
        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour2;
        ArrayList arrayList = (ArrayList) this.f6230i0.f192a;
        arrayList.clear();
        int size = this.f6229h0.size();
        for (int i4 = 0; i4 < size; i4++) {
            d dVar = (d) this.f6229h0.get(i4);
            ConstraintWidget$DimensionBehaviour[] constraintWidget$DimensionBehaviourArr = dVar.J;
            ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour3 = constraintWidget$DimensionBehaviourArr[0];
            ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour4 = ConstraintWidget$DimensionBehaviour.f1133c;
            if (constraintWidget$DimensionBehaviour3 == constraintWidget$DimensionBehaviour4 || constraintWidget$DimensionBehaviour3 == (constraintWidget$DimensionBehaviour = ConstraintWidget$DimensionBehaviour.f1134d) || (constraintWidget$DimensionBehaviour2 = constraintWidget$DimensionBehaviourArr[1]) == constraintWidget$DimensionBehaviour4 || constraintWidget$DimensionBehaviour2 == constraintWidget$DimensionBehaviour) {
                arrayList.add(dVar);
            }
        }
        this.f6231j0.f6442b = true;
    }

    @Override // q.d
    public final void u() {
        this.f6234m0.r();
        this.f6235n0 = 0;
        this.f6236o0 = 0;
        this.f6229h0.clear();
        super.u();
    }

    @Override // q.d
    public final void w(p.d dVar) {
        super.w(dVar);
        int size = this.f6229h0.size();
        for (int i4 = 0; i4 < size; i4++) {
            ((d) this.f6229h0.get(i4)).w(dVar);
        }
    }
}