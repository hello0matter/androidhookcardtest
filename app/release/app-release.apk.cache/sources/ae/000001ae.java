package androidx.constraintlayout.solver.widgets.analyzer;

import java.util.Iterator;

/* loaded from: classes.dex */
public class b extends a {

    /* renamed from: m  reason: collision with root package name */
    public int f1160m;

    public b(f fVar) {
        super(fVar);
        this.f1152e = fVar instanceof d ? DependencyNode$Type.f1137b : DependencyNode$Type.f1138c;
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.a
    public final void d(int i4) {
        if (this.f1157j) {
            return;
        }
        this.f1157j = true;
        this.f1154g = i4;
        Iterator it = this.f1158k.iterator();
        while (it.hasNext()) {
            r.e eVar = (r.e) it.next();
            eVar.a(eVar);
        }
    }
}