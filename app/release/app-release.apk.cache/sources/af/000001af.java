package androidx.constraintlayout.solver.widgets.analyzer;

import java.util.Iterator;

/* loaded from: classes.dex */
public final class c extends f {
    @Override // r.e
    public final void a(r.e eVar) {
        q.a aVar = (q.a) this.f1165b;
        int i4 = aVar.f6169j0;
        a aVar2 = this.f1171h;
        Iterator it = aVar2.f1159l.iterator();
        int i5 = 0;
        int i6 = -1;
        while (it.hasNext()) {
            int i7 = ((a) it.next()).f1154g;
            if (i6 == -1 || i7 < i6) {
                i6 = i7;
            }
            if (i5 < i7) {
                i5 = i7;
            }
        }
        if (i4 != 0 && i4 != 2) {
            aVar2.d(i5 + aVar.f6171l0);
        } else {
            aVar2.d(i6 + aVar.f6171l0);
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.f
    public final void d() {
        f fVar;
        q.d dVar = this.f1165b;
        if (dVar instanceof q.a) {
            a aVar = this.f1171h;
            aVar.f1149b = true;
            q.a aVar2 = (q.a) dVar;
            int i4 = aVar2.f6169j0;
            boolean z4 = aVar2.f6170k0;
            int i5 = 0;
            if (i4 != 0) {
                if (i4 != 1) {
                    if (i4 != 2) {
                        if (i4 == 3) {
                            aVar.f1152e = DependencyNode$Type.f1142g;
                            while (i5 < aVar2.f6285i0) {
                                q.d dVar2 = aVar2.f6284h0[i5];
                                if (z4 || dVar2.X != 8) {
                                    a aVar3 = dVar2.f6204e.f1172i;
                                    aVar3.f1158k.add(aVar);
                                    aVar.f1159l.add(aVar3);
                                }
                                i5++;
                            }
                        } else {
                            return;
                        }
                    } else {
                        aVar.f1152e = DependencyNode$Type.f1141f;
                        while (i5 < aVar2.f6285i0) {
                            q.d dVar3 = aVar2.f6284h0[i5];
                            if (z4 || dVar3.X != 8) {
                                a aVar4 = dVar3.f6204e.f1171h;
                                aVar4.f1158k.add(aVar);
                                aVar.f1159l.add(aVar4);
                            }
                            i5++;
                        }
                    }
                    m(this.f1165b.f6204e.f1171h);
                    fVar = this.f1165b.f6204e;
                    m(fVar.f1172i);
                }
                aVar.f1152e = DependencyNode$Type.f1140e;
                while (i5 < aVar2.f6285i0) {
                    q.d dVar4 = aVar2.f6284h0[i5];
                    if (z4 || dVar4.X != 8) {
                        a aVar5 = dVar4.f6202d.f1172i;
                        aVar5.f1158k.add(aVar);
                        aVar.f1159l.add(aVar5);
                    }
                    i5++;
                }
            } else {
                aVar.f1152e = DependencyNode$Type.f1139d;
                while (i5 < aVar2.f6285i0) {
                    q.d dVar5 = aVar2.f6284h0[i5];
                    if (z4 || dVar5.X != 8) {
                        a aVar6 = dVar5.f6202d.f1171h;
                        aVar6.f1158k.add(aVar);
                        aVar.f1159l.add(aVar6);
                    }
                    i5++;
                }
            }
            m(this.f1165b.f6202d.f1171h);
            fVar = this.f1165b.f6202d;
            m(fVar.f1172i);
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.f
    public final void e() {
        q.d dVar = this.f1165b;
        if (dVar instanceof q.a) {
            int i4 = ((q.a) dVar).f6169j0;
            a aVar = this.f1171h;
            if (i4 != 0 && i4 != 1) {
                dVar.Q = aVar.f1154g;
            } else {
                dVar.P = aVar.f1154g;
            }
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.f
    public final void f() {
        this.f1166c = null;
        this.f1171h.c();
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.f
    public final boolean k() {
        return false;
    }

    public final void m(a aVar) {
        a aVar2 = this.f1171h;
        aVar2.f1158k.add(aVar);
        aVar.f1159l.add(aVar2);
    }
}