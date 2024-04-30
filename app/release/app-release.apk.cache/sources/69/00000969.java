package r;

import androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import q.j;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    public q.e f6441a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f6442b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f6443c;

    /* renamed from: d  reason: collision with root package name */
    public q.e f6444d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList f6445e;

    /* renamed from: f  reason: collision with root package name */
    public c f6446f;

    /* renamed from: g  reason: collision with root package name */
    public b f6447g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList f6448h;

    /* JADX WARN: Type inference failed for: r10v2, types: [java.lang.Object, r.h] */
    public final void a(androidx.constraintlayout.solver.widgets.analyzer.a aVar, int i4, ArrayList arrayList, h hVar) {
        androidx.constraintlayout.solver.widgets.analyzer.f fVar = aVar.f1151d;
        if (fVar.f1166c == null) {
            q.e eVar = this.f6441a;
            if (fVar != eVar.f6202d) {
                h hVar2 = hVar;
                if (fVar != eVar.f6204e) {
                    if (hVar == null) {
                        ?? obj = new Object();
                        obj.f6449a = null;
                        obj.f6450b = new ArrayList();
                        obj.f6449a = fVar;
                        arrayList.add(obj);
                        hVar2 = obj;
                    }
                    fVar.f1166c = hVar2;
                    hVar2.f6450b.add(fVar);
                    androidx.constraintlayout.solver.widgets.analyzer.a aVar2 = fVar.f1171h;
                    Iterator it = aVar2.f1158k.iterator();
                    while (it.hasNext()) {
                        e eVar2 = (e) it.next();
                        if (eVar2 instanceof androidx.constraintlayout.solver.widgets.analyzer.a) {
                            a((androidx.constraintlayout.solver.widgets.analyzer.a) eVar2, i4, arrayList, hVar2);
                        }
                    }
                    androidx.constraintlayout.solver.widgets.analyzer.a aVar3 = fVar.f1172i;
                    Iterator it2 = aVar3.f1158k.iterator();
                    while (it2.hasNext()) {
                        e eVar3 = (e) it2.next();
                        if (eVar3 instanceof androidx.constraintlayout.solver.widgets.analyzer.a) {
                            a((androidx.constraintlayout.solver.widgets.analyzer.a) eVar3, i4, arrayList, hVar2);
                        }
                    }
                    if (i4 == 1 && (fVar instanceof androidx.constraintlayout.solver.widgets.analyzer.e)) {
                        Iterator it3 = ((androidx.constraintlayout.solver.widgets.analyzer.e) fVar).f1162k.f1158k.iterator();
                        while (it3.hasNext()) {
                            e eVar4 = (e) it3.next();
                            if (eVar4 instanceof androidx.constraintlayout.solver.widgets.analyzer.a) {
                                a((androidx.constraintlayout.solver.widgets.analyzer.a) eVar4, i4, arrayList, hVar2);
                            }
                        }
                    }
                    Iterator it4 = aVar2.f1159l.iterator();
                    while (it4.hasNext()) {
                        a((androidx.constraintlayout.solver.widgets.analyzer.a) it4.next(), i4, arrayList, hVar2);
                    }
                    Iterator it5 = aVar3.f1159l.iterator();
                    while (it5.hasNext()) {
                        a((androidx.constraintlayout.solver.widgets.analyzer.a) it5.next(), i4, arrayList, hVar2);
                    }
                    if (i4 == 1 && (fVar instanceof androidx.constraintlayout.solver.widgets.analyzer.e)) {
                        Iterator it6 = ((androidx.constraintlayout.solver.widgets.analyzer.e) fVar).f1162k.f1159l.iterator();
                        while (it6.hasNext()) {
                            a((androidx.constraintlayout.solver.widgets.analyzer.a) it6.next(), i4, arrayList, hVar2);
                        }
                    }
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0068, code lost:
        if (r2.f6213k == 0) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void b(q.e r21) {
        /*
            Method dump skipped, instructions count: 652
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: r.f.b(q.e):void");
    }

    public final void c() {
        androidx.constraintlayout.solver.widgets.analyzer.f fVar;
        ArrayList arrayList = this.f6445e;
        arrayList.clear();
        q.e eVar = this.f6444d;
        eVar.f6202d.f();
        androidx.constraintlayout.solver.widgets.analyzer.e eVar2 = eVar.f6204e;
        eVar2.f();
        arrayList.add(eVar.f6202d);
        arrayList.add(eVar2);
        Iterator it = eVar.f6229h0.iterator();
        HashSet hashSet = null;
        while (it.hasNext()) {
            q.d dVar = (q.d) it.next();
            if (dVar instanceof q.h) {
                fVar = new androidx.constraintlayout.solver.widgets.analyzer.f(dVar);
                dVar.f6202d.f();
                dVar.f6204e.f();
                fVar.f1169f = ((q.h) dVar).f6283l0;
            } else {
                if (dVar.s()) {
                    if (dVar.f6198b == null) {
                        dVar.f6198b = new d(dVar, 0);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(dVar.f6198b);
                } else {
                    arrayList.add(dVar.f6202d);
                }
                if (dVar.t()) {
                    if (dVar.f6200c == null) {
                        dVar.f6200c = new d(dVar, 1);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(dVar.f6200c);
                } else {
                    arrayList.add(dVar.f6204e);
                }
                if (dVar instanceof j) {
                    fVar = new androidx.constraintlayout.solver.widgets.analyzer.f(dVar);
                }
            }
            arrayList.add(fVar);
        }
        if (hashSet != null) {
            arrayList.addAll(hashSet);
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            ((androidx.constraintlayout.solver.widgets.analyzer.f) it2.next()).f();
        }
        Iterator it3 = arrayList.iterator();
        while (it3.hasNext()) {
            androidx.constraintlayout.solver.widgets.analyzer.f fVar2 = (androidx.constraintlayout.solver.widgets.analyzer.f) it3.next();
            if (fVar2.f1165b != eVar) {
                fVar2.d();
            }
        }
        ArrayList arrayList2 = this.f6448h;
        arrayList2.clear();
        q.e eVar3 = this.f6441a;
        e(eVar3.f6202d, 0, arrayList2);
        e(eVar3.f6204e, 1, arrayList2);
        this.f6442b = false;
    }

    public final int d(q.e eVar, int i4) {
        androidx.constraintlayout.solver.widgets.analyzer.f fVar;
        androidx.constraintlayout.solver.widgets.analyzer.f fVar2;
        ArrayList arrayList;
        int i5;
        int i6;
        long j4;
        long j5;
        long j6;
        float f4;
        long j7;
        q.e eVar2 = eVar;
        ArrayList arrayList2 = this.f6448h;
        int size = arrayList2.size();
        int i7 = 0;
        long j8 = 0;
        while (i7 < size) {
            androidx.constraintlayout.solver.widgets.analyzer.f fVar3 = ((h) arrayList2.get(i7)).f6449a;
            if (!(fVar3 instanceof d) ? !(i4 != 0 ? (fVar3 instanceof androidx.constraintlayout.solver.widgets.analyzer.e) : (fVar3 instanceof androidx.constraintlayout.solver.widgets.analyzer.d)) : ((d) fVar3).f1169f != i4) {
                arrayList = arrayList2;
                i5 = size;
                i6 = i7;
                j4 = 0;
            } else {
                if (i4 == 0) {
                    fVar = eVar2.f6202d;
                } else {
                    fVar = eVar2.f6204e;
                }
                androidx.constraintlayout.solver.widgets.analyzer.a aVar = fVar.f1171h;
                if (i4 == 0) {
                    fVar2 = eVar2.f6202d;
                } else {
                    fVar2 = eVar2.f6204e;
                }
                androidx.constraintlayout.solver.widgets.analyzer.a aVar2 = fVar2.f1172i;
                boolean contains = fVar3.f1171h.f1159l.contains(aVar);
                androidx.constraintlayout.solver.widgets.analyzer.a aVar3 = fVar3.f1172i;
                boolean contains2 = aVar3.f1159l.contains(aVar2);
                long j9 = fVar3.j();
                androidx.constraintlayout.solver.widgets.analyzer.a aVar4 = fVar3.f1171h;
                if (contains && contains2) {
                    long b5 = h.b(aVar4, 0L);
                    ArrayList arrayList3 = arrayList2;
                    i5 = size;
                    long a5 = h.a(aVar3, 0L);
                    long j10 = b5 - j9;
                    int i8 = aVar3.f1153f;
                    arrayList = arrayList3;
                    i6 = i7;
                    if (j10 >= (-i8)) {
                        j10 += i8;
                    }
                    long j11 = aVar4.f1153f;
                    long j12 = ((-a5) - j9) - j11;
                    if (j12 >= j11) {
                        j12 -= j11;
                    }
                    q.d dVar = fVar3.f1165b;
                    if (i4 == 0) {
                        f4 = dVar.U;
                    } else if (i4 == 1) {
                        f4 = dVar.V;
                    } else {
                        dVar.getClass();
                        f4 = -1.0f;
                    }
                    if (f4 > 0.0f) {
                        j7 = (((float) j10) / (1.0f - f4)) + (((float) j12) / f4);
                    } else {
                        j7 = 0;
                    }
                    float f5 = (float) j7;
                    j4 = (aVar4.f1153f + ((((f5 * f4) + 0.5f) + j9) + androidx.activity.j.a(1.0f, f4, f5, 0.5f))) - aVar3.f1153f;
                } else {
                    arrayList = arrayList2;
                    i5 = size;
                    i6 = i7;
                    if (contains) {
                        j6 = h.b(aVar4, aVar4.f1153f);
                        j5 = aVar4.f1153f + j9;
                    } else if (contains2) {
                        j5 = (-aVar3.f1153f) + j9;
                        j6 = -h.a(aVar3, aVar3.f1153f);
                    } else {
                        j4 = (fVar3.j() + aVar4.f1153f) - aVar3.f1153f;
                    }
                    j4 = Math.max(j6, j5);
                }
            }
            j8 = Math.max(j8, j4);
            i7 = i6 + 1;
            eVar2 = eVar;
            size = i5;
            arrayList2 = arrayList;
        }
        return (int) j8;
    }

    public final void e(androidx.constraintlayout.solver.widgets.analyzer.f fVar, int i4, ArrayList arrayList) {
        androidx.constraintlayout.solver.widgets.analyzer.a aVar;
        androidx.constraintlayout.solver.widgets.analyzer.a aVar2;
        androidx.constraintlayout.solver.widgets.analyzer.a aVar3;
        Iterator it = fVar.f1171h.f1158k.iterator();
        while (true) {
            boolean hasNext = it.hasNext();
            aVar = fVar.f1172i;
            if (!hasNext) {
                break;
            }
            e eVar = (e) it.next();
            if (eVar instanceof androidx.constraintlayout.solver.widgets.analyzer.a) {
                aVar3 = (androidx.constraintlayout.solver.widgets.analyzer.a) eVar;
            } else if (eVar instanceof androidx.constraintlayout.solver.widgets.analyzer.f) {
                aVar3 = ((androidx.constraintlayout.solver.widgets.analyzer.f) eVar).f1171h;
            }
            a(aVar3, i4, arrayList, null);
        }
        Iterator it2 = aVar.f1158k.iterator();
        while (it2.hasNext()) {
            e eVar2 = (e) it2.next();
            if (eVar2 instanceof androidx.constraintlayout.solver.widgets.analyzer.a) {
                aVar2 = (androidx.constraintlayout.solver.widgets.analyzer.a) eVar2;
            } else if (eVar2 instanceof androidx.constraintlayout.solver.widgets.analyzer.f) {
                aVar2 = ((androidx.constraintlayout.solver.widgets.analyzer.f) eVar2).f1172i;
            }
            a(aVar2, i4, arrayList, null);
        }
        if (i4 == 1) {
            Iterator it3 = ((androidx.constraintlayout.solver.widgets.analyzer.e) fVar).f1162k.f1158k.iterator();
            while (it3.hasNext()) {
                e eVar3 = (e) it3.next();
                if (eVar3 instanceof androidx.constraintlayout.solver.widgets.analyzer.a) {
                    a((androidx.constraintlayout.solver.widgets.analyzer.a) eVar3, i4, arrayList, null);
                }
            }
        }
    }

    public final void f(q.d dVar, ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour, int i4, ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour2, int i5) {
        boolean z4;
        b bVar = this.f6447g;
        bVar.f6429a = constraintWidget$DimensionBehaviour;
        bVar.f6430b = constraintWidget$DimensionBehaviour2;
        bVar.f6431c = i4;
        bVar.f6432d = i5;
        ((androidx.constraintlayout.widget.b) this.f6446f).a(dVar, bVar);
        dVar.A(bVar.f6433e);
        dVar.x(bVar.f6434f);
        dVar.f6225w = bVar.f6436h;
        int i6 = bVar.f6435g;
        dVar.R = i6;
        if (i6 > 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        dVar.f6225w = z4;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0076, code lost:
        if (r11 == r12) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0078, code lost:
        r0.f1160m = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x007b, code lost:
        r0.d(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0096, code lost:
        if (r9 == r12) goto L35;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void g() {
        /*
            r17 = this;
            r6 = r17
            q.e r0 = r6.f6441a
            java.util.ArrayList r0 = r0.f6229h0
            java.util.Iterator r7 = r0.iterator()
        La:
            boolean r0 = r7.hasNext()
            if (r0 == 0) goto La8
            java.lang.Object r0 = r7.next()
            r8 = r0
            q.d r8 = (q.d) r8
            boolean r0 = r8.f6196a
            if (r0 == 0) goto L1c
            goto La
        L1c:
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r8.J
            r1 = 0
            r9 = r0[r1]
            r10 = 1
            r11 = r0[r10]
            int r0 = r8.f6212j
            int r2 = r8.f6213k
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r4 = androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour.f1132b
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r12 = androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour.f1133c
            if (r9 == r4) goto L35
            if (r9 != r12) goto L33
            if (r0 != r10) goto L33
            goto L35
        L33:
            r0 = r1
            goto L36
        L35:
            r0 = r10
        L36:
            if (r11 == r4) goto L3c
            if (r11 != r12) goto L3d
            if (r2 != r10) goto L3d
        L3c:
            r1 = r10
        L3d:
            androidx.constraintlayout.solver.widgets.analyzer.d r13 = r8.f6202d
            androidx.constraintlayout.solver.widgets.analyzer.b r2 = r13.f1168e
            boolean r3 = r2.f1157j
            androidx.constraintlayout.solver.widgets.analyzer.e r14 = r8.f6204e
            androidx.constraintlayout.solver.widgets.analyzer.b r5 = r14.f1168e
            boolean r15 = r5.f1157j
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r16 = androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour.f1131a
            if (r3 == 0) goto L60
            if (r15 == 0) goto L60
            int r3 = r2.f1154g
            int r5 = r5.f1154g
            r0 = r17
            r1 = r8
            r2 = r16
            r4 = r16
            r0.f(r1, r2, r3, r4, r5)
        L5d:
            r8.f6196a = r10
            goto L99
        L60:
            if (r3 == 0) goto L7f
            if (r1 == 0) goto L7f
            int r3 = r2.f1154g
            int r5 = r5.f1154g
            r0 = r17
            r1 = r8
            r2 = r16
            r0.f(r1, r2, r3, r4, r5)
            androidx.constraintlayout.solver.widgets.analyzer.b r0 = r14.f1168e
            int r1 = r8.k()
            if (r11 != r12) goto L7b
        L78:
            r0.f1160m = r1
            goto L99
        L7b:
            r0.d(r1)
            goto L5d
        L7f:
            if (r15 == 0) goto L99
            if (r0 == 0) goto L99
            int r3 = r2.f1154g
            int r5 = r5.f1154g
            r0 = r17
            r1 = r8
            r2 = r4
            r4 = r16
            r0.f(r1, r2, r3, r4, r5)
            androidx.constraintlayout.solver.widgets.analyzer.b r0 = r13.f1168e
            int r1 = r8.n()
            if (r9 != r12) goto L7b
            goto L78
        L99:
            boolean r0 = r8.f6196a
            if (r0 == 0) goto La
            r.a r0 = r14.f1163l
            if (r0 == 0) goto La
            int r1 = r8.R
            r0.d(r1)
            goto La
        La8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: r.f.g():void");
    }
}