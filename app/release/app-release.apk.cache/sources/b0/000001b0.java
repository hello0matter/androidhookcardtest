package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type;
import androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour;
import java.util.ArrayList;
import q.i;

/* loaded from: classes.dex */
public final class d extends f {

    /* renamed from: k  reason: collision with root package name */
    public static final int[] f1161k = new int[2];

    public d(q.d dVar) {
        super(dVar);
        this.f1171h.f1152e = DependencyNode$Type.f1139d;
        this.f1172i.f1152e = DependencyNode$Type.f1140e;
        this.f1169f = 0;
    }

    public static void m(int[] iArr, int i4, int i5, int i6, int i7, float f4, int i8) {
        int i9 = i5 - i4;
        int i10 = i7 - i6;
        if (i8 != -1) {
            if (i8 != 0) {
                if (i8 == 1) {
                    iArr[0] = i9;
                    iArr[1] = (int) ((i9 * f4) + 0.5f);
                    return;
                }
                return;
            }
            iArr[0] = (int) ((i10 * f4) + 0.5f);
            iArr[1] = i10;
            return;
        }
        int i11 = (int) ((i10 * f4) + 0.5f);
        int i12 = (int) ((i9 / f4) + 0.5f);
        if (i11 <= i9) {
            iArr[0] = i11;
            iArr[1] = i10;
        } else if (i12 <= i10) {
            iArr[0] = i9;
            iArr[1] = i12;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:112:0x0239, code lost:
        if (r8 != 1) goto L128;
     */
    @Override // r.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(r.e r24) {
        /*
            Method dump skipped, instructions count: 888
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.analyzer.d.a(r.e):void");
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.f
    public final void d() {
        q.d dVar;
        q.d dVar2;
        q.d dVar3;
        q.c cVar;
        ArrayList arrayList;
        q.d dVar4;
        q.d dVar5 = this.f1165b;
        boolean z4 = dVar5.f6196a;
        b bVar = this.f1168e;
        if (z4) {
            bVar.d(dVar5.n());
        }
        boolean z5 = bVar.f1157j;
        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour = ConstraintWidget$DimensionBehaviour.f1134d;
        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour2 = ConstraintWidget$DimensionBehaviour.f1133c;
        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour3 = ConstraintWidget$DimensionBehaviour.f1131a;
        a aVar = this.f1172i;
        a aVar2 = this.f1171h;
        if (!z5) {
            q.d dVar6 = this.f1165b;
            ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour4 = dVar6.J[0];
            this.f1167d = constraintWidget$DimensionBehaviour4;
            if (constraintWidget$DimensionBehaviour4 != constraintWidget$DimensionBehaviour2) {
                if (constraintWidget$DimensionBehaviour4 == constraintWidget$DimensionBehaviour && (((dVar4 = dVar6.K) != null && dVar4.J[0] == constraintWidget$DimensionBehaviour3) || dVar4.J[0] == constraintWidget$DimensionBehaviour)) {
                    int n4 = (dVar4.n() - this.f1165b.f6227y.c()) - this.f1165b.A.c();
                    d dVar7 = dVar4.f6202d;
                    f.b(aVar2, dVar7.f1171h, this.f1165b.f6227y.c());
                    f.b(aVar, dVar7.f1172i, -this.f1165b.A.c());
                    bVar.d(n4);
                    return;
                } else if (constraintWidget$DimensionBehaviour4 == constraintWidget$DimensionBehaviour3) {
                    bVar.d(dVar6.n());
                }
            }
        } else if (this.f1167d == constraintWidget$DimensionBehaviour && (((dVar2 = (dVar = this.f1165b).K) != null && dVar2.J[0] == constraintWidget$DimensionBehaviour3) || dVar2.J[0] == constraintWidget$DimensionBehaviour)) {
            f.b(aVar2, dVar2.f6202d.f1171h, dVar.f6227y.c());
            f.b(aVar, dVar2.f6202d.f1172i, -this.f1165b.A.c());
            return;
        }
        if (bVar.f1157j) {
            q.d dVar8 = this.f1165b;
            if (dVar8.f6196a) {
                q.c[] cVarArr = dVar8.G;
                q.c cVar2 = cVarArr[0];
                q.c cVar3 = cVar2.f6192d;
                if (cVar3 != null && cVarArr[1].f6192d != null) {
                    if (dVar8.s()) {
                        aVar2.f1153f = this.f1165b.G[0].c();
                        cVar = this.f1165b.G[1];
                        aVar.f1153f = -cVar.c();
                        return;
                    }
                    a h4 = f.h(this.f1165b.G[0]);
                    if (h4 != null) {
                        f.b(aVar2, h4, this.f1165b.G[0].c());
                    }
                    a h5 = f.h(this.f1165b.G[1]);
                    if (h5 != null) {
                        f.b(aVar, h5, -this.f1165b.G[1].c());
                    }
                    aVar2.f1149b = true;
                    aVar.f1149b = true;
                    return;
                }
                if (cVar3 != null) {
                    a h6 = f.h(cVar2);
                    if (h6 != null) {
                        f.b(aVar2, h6, this.f1165b.G[0].c());
                    } else {
                        return;
                    }
                } else {
                    q.c cVar4 = cVarArr[1];
                    if (cVar4.f6192d != null) {
                        a h7 = f.h(cVar4);
                        if (h7 != null) {
                            f.b(aVar, h7, -this.f1165b.G[1].c());
                            f.b(aVar2, aVar, -bVar.f1154g);
                            return;
                        }
                        return;
                    } else if (!(dVar8 instanceof i) && dVar8.K != null && dVar8.i(ConstraintAnchor$Type.f1127f).f6192d == null) {
                        q.d dVar9 = this.f1165b;
                        f.b(aVar2, dVar9.K.f6202d.f1171h, dVar9.o());
                    } else {
                        return;
                    }
                }
                f.b(aVar, aVar2, bVar.f1154g);
                return;
            }
        }
        if (this.f1167d == constraintWidget$DimensionBehaviour2) {
            q.d dVar10 = this.f1165b;
            int i4 = dVar10.f6212j;
            if (i4 != 2) {
                if (i4 == 3) {
                    if (dVar10.f6213k == 3) {
                        aVar2.f1148a = this;
                        aVar.f1148a = this;
                        e eVar = dVar10.f6204e;
                        eVar.f1171h.f1148a = this;
                        eVar.f1172i.f1148a = this;
                        bVar.f1148a = this;
                        if (dVar10.t()) {
                            bVar.f1159l.add(this.f1165b.f6204e.f1168e);
                            this.f1165b.f6204e.f1168e.f1158k.add(bVar);
                            e eVar2 = this.f1165b.f6204e;
                            eVar2.f1168e.f1148a = this;
                            bVar.f1159l.add(eVar2.f1171h);
                            bVar.f1159l.add(this.f1165b.f6204e.f1172i);
                            this.f1165b.f6204e.f1171h.f1158k.add(bVar);
                            arrayList = this.f1165b.f6204e.f1172i.f1158k;
                        } else if (this.f1165b.s()) {
                            this.f1165b.f6204e.f1168e.f1159l.add(bVar);
                            bVar.f1158k.add(this.f1165b.f6204e.f1168e);
                        } else {
                            arrayList = this.f1165b.f6204e.f1168e.f1159l;
                        }
                    } else {
                        b bVar2 = dVar10.f6204e.f1168e;
                        bVar.f1159l.add(bVar2);
                        bVar2.f1158k.add(bVar);
                        this.f1165b.f6204e.f1171h.f1158k.add(bVar);
                        this.f1165b.f6204e.f1172i.f1158k.add(bVar);
                        bVar.f1149b = true;
                        bVar.f1158k.add(aVar2);
                        bVar.f1158k.add(aVar);
                        aVar2.f1159l.add(bVar);
                        arrayList = aVar.f1159l;
                    }
                    arrayList.add(bVar);
                }
            } else {
                q.d dVar11 = dVar10.K;
                if (dVar11 != null) {
                    b bVar3 = dVar11.f6204e.f1168e;
                    bVar.f1159l.add(bVar3);
                    bVar3.f1158k.add(bVar);
                    bVar.f1149b = true;
                    bVar.f1158k.add(aVar2);
                    bVar.f1158k.add(aVar);
                }
            }
        }
        q.d dVar12 = this.f1165b;
        q.c[] cVarArr2 = dVar12.G;
        q.c cVar5 = cVarArr2[0];
        q.c cVar6 = cVar5.f6192d;
        if (cVar6 != null && cVarArr2[1].f6192d != null) {
            if (dVar12.s()) {
                aVar2.f1153f = this.f1165b.G[0].c();
                cVar = this.f1165b.G[1];
                aVar.f1153f = -cVar.c();
                return;
            }
            a h8 = f.h(this.f1165b.G[0]);
            a h9 = f.h(this.f1165b.G[1]);
            h8.b(this);
            h9.b(this);
            this.f1173j = WidgetRun$RunType.f1146b;
            return;
        }
        if (cVar6 != null) {
            a h10 = f.h(cVar5);
            if (h10 != null) {
                f.b(aVar2, h10, this.f1165b.G[0].c());
            } else {
                return;
            }
        } else {
            q.c cVar7 = cVarArr2[1];
            if (cVar7.f6192d != null) {
                a h11 = f.h(cVar7);
                if (h11 != null) {
                    f.b(aVar, h11, -this.f1165b.G[1].c());
                    c(aVar2, aVar, -1, bVar);
                    return;
                }
                return;
            } else if (!(dVar12 instanceof i) && (dVar3 = dVar12.K) != null) {
                f.b(aVar2, dVar3.f6202d.f1171h, dVar12.o());
            } else {
                return;
            }
        }
        c(aVar, aVar2, 1, bVar);
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.f
    public final void e() {
        a aVar = this.f1171h;
        if (aVar.f1157j) {
            this.f1165b.P = aVar.f1154g;
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.f
    public final void f() {
        this.f1166c = null;
        this.f1171h.c();
        this.f1172i.c();
        this.f1168e.c();
        this.f1170g = false;
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.f
    public final boolean k() {
        return this.f1167d != ConstraintWidget$DimensionBehaviour.f1133c || this.f1165b.f6212j == 0;
    }

    public final void n() {
        this.f1170g = false;
        a aVar = this.f1171h;
        aVar.c();
        aVar.f1157j = false;
        a aVar2 = this.f1172i;
        aVar2.c();
        aVar2.f1157j = false;
        this.f1168e.f1157j = false;
    }

    public final String toString() {
        return "HorizontalRun " + this.f1165b.Y;
    }
}