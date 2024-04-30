package r;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    public androidx.constraintlayout.solver.widgets.analyzer.f f6449a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList f6450b;

    public static long a(androidx.constraintlayout.solver.widgets.analyzer.a aVar, long j4) {
        androidx.constraintlayout.solver.widgets.analyzer.f fVar = aVar.f1151d;
        if (fVar instanceof androidx.constraintlayout.solver.widgets.analyzer.c) {
            return j4;
        }
        ArrayList arrayList = aVar.f1158k;
        int size = arrayList.size();
        long j5 = j4;
        for (int i4 = 0; i4 < size; i4++) {
            e eVar = (e) arrayList.get(i4);
            if (eVar instanceof androidx.constraintlayout.solver.widgets.analyzer.a) {
                androidx.constraintlayout.solver.widgets.analyzer.a aVar2 = (androidx.constraintlayout.solver.widgets.analyzer.a) eVar;
                if (aVar2.f1151d != fVar) {
                    j5 = Math.min(j5, a(aVar2, aVar2.f1153f + j4));
                }
            }
        }
        if (aVar == fVar.f1172i) {
            long j6 = fVar.j();
            androidx.constraintlayout.solver.widgets.analyzer.a aVar3 = fVar.f1171h;
            long j7 = j4 - j6;
            return Math.min(Math.min(j5, a(aVar3, j7)), j7 - aVar3.f1153f);
        }
        return j5;
    }

    public static long b(androidx.constraintlayout.solver.widgets.analyzer.a aVar, long j4) {
        androidx.constraintlayout.solver.widgets.analyzer.f fVar = aVar.f1151d;
        if (fVar instanceof androidx.constraintlayout.solver.widgets.analyzer.c) {
            return j4;
        }
        ArrayList arrayList = aVar.f1158k;
        int size = arrayList.size();
        long j5 = j4;
        for (int i4 = 0; i4 < size; i4++) {
            e eVar = (e) arrayList.get(i4);
            if (eVar instanceof androidx.constraintlayout.solver.widgets.analyzer.a) {
                androidx.constraintlayout.solver.widgets.analyzer.a aVar2 = (androidx.constraintlayout.solver.widgets.analyzer.a) eVar;
                if (aVar2.f1151d != fVar) {
                    j5 = Math.max(j5, b(aVar2, aVar2.f1153f + j4));
                }
            }
        }
        if (aVar == fVar.f1171h) {
            long j6 = fVar.j();
            androidx.constraintlayout.solver.widgets.analyzer.a aVar3 = fVar.f1172i;
            long j7 = j4 + j6;
            return Math.max(Math.max(j5, b(aVar3, j7)), j7 - aVar3.f1153f);
        }
        return j5;
    }
}