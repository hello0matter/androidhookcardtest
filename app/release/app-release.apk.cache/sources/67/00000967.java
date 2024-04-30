package r;

import androidx.activity.j;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class d extends androidx.constraintlayout.solver.widgets.analyzer.f {

    /* renamed from: k  reason: collision with root package name */
    public final ArrayList f6439k;

    /* renamed from: l  reason: collision with root package name */
    public int f6440l;

    public d(q.d dVar, int i4) {
        super(dVar);
        q.d dVar2;
        androidx.constraintlayout.solver.widgets.analyzer.f fVar;
        int i5;
        androidx.constraintlayout.solver.widgets.analyzer.f fVar2;
        this.f6439k = new ArrayList();
        this.f1169f = i4;
        q.d dVar3 = this.f1165b;
        while (true) {
            q.d m4 = dVar3.m(i4);
            dVar2 = dVar3;
            dVar3 = m4;
            if (dVar3 == null) {
                break;
            }
            i4 = this.f1169f;
        }
        this.f1165b = dVar2;
        int i6 = this.f1169f;
        if (i6 == 0) {
            fVar = dVar2.f6202d;
        } else if (i6 == 1) {
            fVar = dVar2.f6204e;
        } else {
            fVar = null;
        }
        ArrayList arrayList = this.f6439k;
        arrayList.add(fVar);
        q.d l4 = dVar2.l(this.f1169f);
        while (l4 != null) {
            int i7 = this.f1169f;
            if (i7 == 0) {
                fVar2 = l4.f6202d;
            } else if (i7 == 1) {
                fVar2 = l4.f6204e;
            } else {
                fVar2 = null;
            }
            arrayList.add(fVar2);
            l4 = l4.l(this.f1169f);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            androidx.constraintlayout.solver.widgets.analyzer.f fVar3 = (androidx.constraintlayout.solver.widgets.analyzer.f) it.next();
            int i8 = this.f1169f;
            if (i8 == 0) {
                fVar3.f1165b.f6198b = this;
            } else if (i8 == 1) {
                fVar3.f1165b.f6200c = this;
            }
        }
        if (this.f1169f == 0 && ((q.e) this.f1165b.K).f6233l0 && arrayList.size() > 1) {
            this.f1165b = ((androidx.constraintlayout.solver.widgets.analyzer.f) arrayList.get(arrayList.size() - 1)).f1165b;
        }
        if (this.f1169f == 0) {
            i5 = this.f1165b.f6197a0;
        } else {
            i5 = this.f1165b.f6199b0;
        }
        this.f6440l = i5;
    }

    /* JADX WARN: Code restructure failed: missing block: B:287:0x03de, code lost:
        r3 = r3 - r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0111, code lost:
        r4 = r17;
        r6 = r18;
     */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0250  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x025f  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x02ef  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00e3  */
    @Override // r.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(r.e r28) {
        /*
            Method dump skipped, instructions count: 1018
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: r.d.a(r.e):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0069, code lost:
        if (r1 != null) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x009d, code lost:
        if (r1 != null) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x009f, code lost:
        androidx.constraintlayout.solver.widgets.analyzer.f.b(r5, r1, -r0);
     */
    @Override // androidx.constraintlayout.solver.widgets.analyzer.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void d() {
        /*
            r7 = this;
            java.util.ArrayList r0 = r7.f6439k
            java.util.Iterator r1 = r0.iterator()
        L6:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L16
            java.lang.Object r2 = r1.next()
            androidx.constraintlayout.solver.widgets.analyzer.f r2 = (androidx.constraintlayout.solver.widgets.analyzer.f) r2
            r2.d()
            goto L6
        L16:
            int r1 = r0.size()
            r2 = 1
            if (r1 >= r2) goto L1e
            return
        L1e:
            r3 = 0
            java.lang.Object r4 = r0.get(r3)
            androidx.constraintlayout.solver.widgets.analyzer.f r4 = (androidx.constraintlayout.solver.widgets.analyzer.f) r4
            q.d r4 = r4.f1165b
            int r1 = r1 - r2
            java.lang.Object r0 = r0.get(r1)
            androidx.constraintlayout.solver.widgets.analyzer.f r0 = (androidx.constraintlayout.solver.widgets.analyzer.f) r0
            q.d r0 = r0.f1165b
            int r1 = r7.f1169f
            androidx.constraintlayout.solver.widgets.analyzer.a r5 = r7.f1172i
            androidx.constraintlayout.solver.widgets.analyzer.a r6 = r7.f1171h
            if (r1 != 0) goto L6c
            q.c r1 = r4.f6227y
            q.c r0 = r0.A
            androidx.constraintlayout.solver.widgets.analyzer.a r2 = androidx.constraintlayout.solver.widgets.analyzer.f.i(r1, r3)
            int r1 = r1.c()
            q.d r4 = r7.m()
            if (r4 == 0) goto L50
            q.c r1 = r4.f6227y
            int r1 = r1.c()
        L50:
            if (r2 == 0) goto L55
            androidx.constraintlayout.solver.widgets.analyzer.f.b(r6, r2, r1)
        L55:
            androidx.constraintlayout.solver.widgets.analyzer.a r1 = androidx.constraintlayout.solver.widgets.analyzer.f.i(r0, r3)
            int r0 = r0.c()
            q.d r2 = r7.n()
            if (r2 == 0) goto L69
            q.c r0 = r2.A
            int r0 = r0.c()
        L69:
            if (r1 == 0) goto La3
            goto L9f
        L6c:
            q.c r1 = r4.f6228z
            q.c r0 = r0.B
            androidx.constraintlayout.solver.widgets.analyzer.a r3 = androidx.constraintlayout.solver.widgets.analyzer.f.i(r1, r2)
            int r1 = r1.c()
            q.d r4 = r7.m()
            if (r4 == 0) goto L84
            q.c r1 = r4.f6228z
            int r1 = r1.c()
        L84:
            if (r3 == 0) goto L89
            androidx.constraintlayout.solver.widgets.analyzer.f.b(r6, r3, r1)
        L89:
            androidx.constraintlayout.solver.widgets.analyzer.a r1 = androidx.constraintlayout.solver.widgets.analyzer.f.i(r0, r2)
            int r0 = r0.c()
            q.d r2 = r7.n()
            if (r2 == 0) goto L9d
            q.c r0 = r2.B
            int r0 = r0.c()
        L9d:
            if (r1 == 0) goto La3
        L9f:
            int r0 = -r0
            androidx.constraintlayout.solver.widgets.analyzer.f.b(r5, r1, r0)
        La3:
            r6.f1148a = r7
            r5.f1148a = r7
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: r.d.d():void");
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.f
    public final void e() {
        int i4 = 0;
        while (true) {
            ArrayList arrayList = this.f6439k;
            if (i4 < arrayList.size()) {
                ((androidx.constraintlayout.solver.widgets.analyzer.f) arrayList.get(i4)).e();
                i4++;
            } else {
                return;
            }
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.f
    public final void f() {
        this.f1166c = null;
        Iterator it = this.f6439k.iterator();
        while (it.hasNext()) {
            ((androidx.constraintlayout.solver.widgets.analyzer.f) it.next()).f();
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.f
    public final long j() {
        ArrayList arrayList = this.f6439k;
        int size = arrayList.size();
        long j4 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            androidx.constraintlayout.solver.widgets.analyzer.f fVar = (androidx.constraintlayout.solver.widgets.analyzer.f) arrayList.get(i4);
            j4 = fVar.f1172i.f1153f + fVar.j() + j4 + fVar.f1171h.f1153f;
        }
        return j4;
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.f
    public final boolean k() {
        ArrayList arrayList = this.f6439k;
        int size = arrayList.size();
        for (int i4 = 0; i4 < size; i4++) {
            if (!((androidx.constraintlayout.solver.widgets.analyzer.f) arrayList.get(i4)).k()) {
                return false;
            }
        }
        return true;
    }

    public final q.d m() {
        int i4 = 0;
        while (true) {
            ArrayList arrayList = this.f6439k;
            if (i4 < arrayList.size()) {
                q.d dVar = ((androidx.constraintlayout.solver.widgets.analyzer.f) arrayList.get(i4)).f1165b;
                if (dVar.X != 8) {
                    return dVar;
                }
                i4++;
            } else {
                return null;
            }
        }
    }

    public final q.d n() {
        ArrayList arrayList = this.f6439k;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            q.d dVar = ((androidx.constraintlayout.solver.widgets.analyzer.f) arrayList.get(size)).f1165b;
            if (dVar.X != 8) {
                return dVar;
            }
        }
        return null;
    }

    public final String toString() {
        String str;
        if (this.f1169f == 0) {
            str = "horizontal : ";
        } else {
            str = "vertical : ";
        }
        String concat = "ChainRun ".concat(str);
        Iterator it = this.f6439k.iterator();
        while (it.hasNext()) {
            String c4 = j.c(concat, "<");
            concat = j.c(c4 + ((androidx.constraintlayout.solver.widgets.analyzer.f) it.next()), "> ");
        }
        return concat;
    }
}