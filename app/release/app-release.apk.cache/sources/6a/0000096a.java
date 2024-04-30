package r;

/* loaded from: classes.dex */
public final class g extends androidx.constraintlayout.solver.widgets.analyzer.f {
    @Override // r.e
    public final void a(e eVar) {
        androidx.constraintlayout.solver.widgets.analyzer.a aVar = this.f1171h;
        if (!aVar.f1150c || aVar.f1157j) {
            return;
        }
        aVar.d((int) ((((androidx.constraintlayout.solver.widgets.analyzer.a) aVar.f1159l.get(0)).f1154g * ((q.h) this.f1165b).f6279h0) + 0.5f));
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.f
    public final void d() {
        androidx.constraintlayout.solver.widgets.analyzer.f fVar;
        q.d dVar = this.f1165b;
        q.h hVar = (q.h) dVar;
        int i4 = hVar.f6280i0;
        int i5 = hVar.f6281j0;
        int i6 = hVar.f6283l0;
        androidx.constraintlayout.solver.widgets.analyzer.a aVar = this.f1171h;
        if (i6 == 1) {
            if (i4 != -1) {
                aVar.f1159l.add(dVar.K.f6202d.f1171h);
                this.f1165b.K.f6202d.f1171h.f1158k.add(aVar);
                aVar.f1153f = i4;
            } else if (i5 != -1) {
                aVar.f1159l.add(dVar.K.f6202d.f1172i);
                this.f1165b.K.f6202d.f1172i.f1158k.add(aVar);
                aVar.f1153f = -i5;
            } else {
                aVar.f1149b = true;
                aVar.f1159l.add(dVar.K.f6202d.f1172i);
                this.f1165b.K.f6202d.f1172i.f1158k.add(aVar);
            }
            m(this.f1165b.f6202d.f1171h);
            fVar = this.f1165b.f6202d;
        } else {
            if (i4 != -1) {
                aVar.f1159l.add(dVar.K.f6204e.f1171h);
                this.f1165b.K.f6204e.f1171h.f1158k.add(aVar);
                aVar.f1153f = i4;
            } else if (i5 != -1) {
                aVar.f1159l.add(dVar.K.f6204e.f1172i);
                this.f1165b.K.f6204e.f1172i.f1158k.add(aVar);
                aVar.f1153f = -i5;
            } else {
                aVar.f1149b = true;
                aVar.f1159l.add(dVar.K.f6204e.f1172i);
                this.f1165b.K.f6204e.f1172i.f1158k.add(aVar);
            }
            m(this.f1165b.f6204e.f1171h);
            fVar = this.f1165b.f6204e;
        }
        m(fVar.f1172i);
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.f
    public final void e() {
        q.d dVar = this.f1165b;
        int i4 = ((q.h) dVar).f6283l0;
        androidx.constraintlayout.solver.widgets.analyzer.a aVar = this.f1171h;
        if (i4 == 1) {
            dVar.P = aVar.f1154g;
        } else {
            dVar.Q = aVar.f1154g;
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.f
    public final void f() {
        this.f1171h.c();
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.f
    public final boolean k() {
        return false;
    }

    public final void m(androidx.constraintlayout.solver.widgets.analyzer.a aVar) {
        androidx.constraintlayout.solver.widgets.analyzer.a aVar2 = this.f1171h;
        aVar2.f1158k.add(aVar);
        aVar.f1159l.add(aVar2);
    }
}