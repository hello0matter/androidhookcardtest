package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour;

/* loaded from: classes.dex */
public final class e extends f {

    /* renamed from: k  reason: collision with root package name */
    public final a f1162k;

    /* renamed from: l  reason: collision with root package name */
    public r.a f1163l;

    public e(q.d dVar) {
        super(dVar);
        a aVar = new a(this);
        this.f1162k = aVar;
        this.f1163l = null;
        this.f1171h.f1152e = DependencyNode$Type.f1141f;
        this.f1172i.f1152e = DependencyNode$Type.f1142g;
        aVar.f1152e = DependencyNode$Type.f1143h;
        this.f1169f = 1;
    }

    @Override // r.e
    public final void a(r.e eVar) {
        b bVar;
        float f4;
        int i4;
        float f5;
        if (this.f1173j.ordinal() != 3) {
            b bVar2 = this.f1168e;
            boolean z4 = bVar2.f1150c;
            ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour = ConstraintWidget$DimensionBehaviour.f1133c;
            if (z4 && !bVar2.f1157j && this.f1167d == constraintWidget$DimensionBehaviour) {
                q.d dVar = this.f1165b;
                int i5 = dVar.f6213k;
                if (i5 != 2) {
                    if (i5 == 3) {
                        b bVar3 = dVar.f6202d.f1168e;
                        if (bVar3.f1157j) {
                            int i6 = dVar.O;
                            if (i6 != -1) {
                                if (i6 != 0) {
                                    if (i6 != 1) {
                                        i4 = 0;
                                    } else {
                                        f5 = bVar3.f1154g;
                                    }
                                } else {
                                    f4 = bVar3.f1154g * dVar.N;
                                    i4 = (int) (f4 + 0.5f);
                                }
                            } else {
                                f5 = bVar3.f1154g;
                            }
                            f4 = f5 / dVar.N;
                            i4 = (int) (f4 + 0.5f);
                        }
                    }
                } else {
                    q.d dVar2 = dVar.K;
                    if (dVar2 != null) {
                        if (dVar2.f6204e.f1168e.f1157j) {
                            f4 = bVar.f1154g * dVar.f6220r;
                            i4 = (int) (f4 + 0.5f);
                        }
                    }
                }
                bVar2.d(i4);
            }
            a aVar = this.f1171h;
            if (aVar.f1150c) {
                a aVar2 = this.f1172i;
                if (aVar2.f1150c) {
                    if (aVar.f1157j && aVar2.f1157j && bVar2.f1157j) {
                        return;
                    }
                    if (!bVar2.f1157j && this.f1167d == constraintWidget$DimensionBehaviour) {
                        q.d dVar3 = this.f1165b;
                        if (dVar3.f6212j == 0 && !dVar3.t()) {
                            int i7 = ((a) aVar.f1159l.get(0)).f1154g + aVar.f1153f;
                            int i8 = ((a) aVar2.f1159l.get(0)).f1154g + aVar2.f1153f;
                            aVar.d(i7);
                            aVar2.d(i8);
                            bVar2.d(i8 - i7);
                            return;
                        }
                    }
                    if (!bVar2.f1157j && this.f1167d == constraintWidget$DimensionBehaviour && this.f1164a == 1 && aVar.f1159l.size() > 0 && aVar2.f1159l.size() > 0) {
                        int i9 = (((a) aVar2.f1159l.get(0)).f1154g + aVar2.f1153f) - (((a) aVar.f1159l.get(0)).f1154g + aVar.f1153f);
                        int i10 = bVar2.f1160m;
                        if (i9 < i10) {
                            bVar2.d(i9);
                        } else {
                            bVar2.d(i10);
                        }
                    }
                    if (bVar2.f1157j && aVar.f1159l.size() > 0 && aVar2.f1159l.size() > 0) {
                        a aVar3 = (a) aVar.f1159l.get(0);
                        a aVar4 = (a) aVar2.f1159l.get(0);
                        int i11 = aVar3.f1154g;
                        int i12 = aVar.f1153f + i11;
                        int i13 = aVar4.f1154g;
                        int i14 = aVar2.f1153f + i13;
                        float f6 = this.f1165b.V;
                        if (aVar3 == aVar4) {
                            f6 = 0.5f;
                        } else {
                            i11 = i12;
                            i13 = i14;
                        }
                        aVar.d((int) ((((i13 - i11) - bVar2.f1154g) * f6) + i11 + 0.5f));
                        aVar2.d(aVar.f1154g + bVar2.f1154g);
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        q.d dVar4 = this.f1165b;
        l(dVar4.f6228z, dVar4.B, 1);
    }

    /* JADX WARN: Code restructure failed: missing block: B:106:0x025c, code lost:
        if (r15.f1165b.f6225w != false) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x025e, code lost:
        c(r1, r6, 1, r15.f1163l);
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x0299, code lost:
        if (r0.f1167d == r4) goto L119;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x02bf, code lost:
        if (r15.f1165b.f6225w != false) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x030b, code lost:
        if (r0.f1167d == r4) goto L119;
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x030d, code lost:
        r0.f1168e.f1158k.add(r2);
        r2.f1159l.add(r15.f1165b.f6202d.f1168e);
        r2.f1148a = r15;
     */
    /* JADX WARN: Type inference failed for: r0v116, types: [androidx.constraintlayout.solver.widgets.analyzer.b, r.a] */
    @Override // androidx.constraintlayout.solver.widgets.analyzer.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void d() {
        /*
            Method dump skipped, instructions count: 812
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.analyzer.e.d():void");
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.f
    public final void e() {
        a aVar = this.f1171h;
        if (aVar.f1157j) {
            this.f1165b.Q = aVar.f1154g;
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.f
    public final void f() {
        this.f1166c = null;
        this.f1171h.c();
        this.f1172i.c();
        this.f1162k.c();
        this.f1168e.c();
        this.f1170g = false;
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.f
    public final boolean k() {
        return this.f1167d != ConstraintWidget$DimensionBehaviour.f1133c || this.f1165b.f6213k == 0;
    }

    public final void m() {
        this.f1170g = false;
        a aVar = this.f1171h;
        aVar.c();
        aVar.f1157j = false;
        a aVar2 = this.f1172i;
        aVar2.c();
        aVar2.f1157j = false;
        a aVar3 = this.f1162k;
        aVar3.c();
        aVar3.f1157j = false;
        this.f1168e.f1157j = false;
    }

    public final String toString() {
        return "VerticalRun " + this.f1165b.Y;
    }
}