package androidx.recyclerview.widget;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class t implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public static final ThreadLocal f2255e = new ThreadLocal();

    /* renamed from: f  reason: collision with root package name */
    public static final q f2256f = new Object();

    /* renamed from: a  reason: collision with root package name */
    public ArrayList f2257a;

    /* renamed from: b  reason: collision with root package name */
    public long f2258b;

    /* renamed from: c  reason: collision with root package name */
    public long f2259c;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList f2260d;

    public static l1 c(RecyclerView recyclerView, int i4, long j4) {
        int f4 = recyclerView.f1974e.f2071a.f();
        for (int i5 = 0; i5 < f4; i5++) {
            l1 J = RecyclerView.J(recyclerView.f1974e.f2071a.e(i5));
            if (J.f2172c == i4 && !J.h()) {
                return null;
            }
        }
        b1 b1Var = recyclerView.f1968b;
        try {
            recyclerView.Q();
            l1 i6 = b1Var.i(i4, j4);
            if (i6 != null) {
                if (i6.g() && !i6.h()) {
                    b1Var.f(i6.f2170a);
                } else {
                    b1Var.a(i6, false);
                }
            }
            recyclerView.R(false);
            return i6;
        } catch (Throwable th) {
            recyclerView.R(false);
            throw th;
        }
    }

    public final void a(RecyclerView recyclerView, int i4, int i5) {
        if (recyclerView.f1996p && this.f2258b == 0) {
            this.f2258b = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        r rVar = recyclerView.f1971c0;
        rVar.f2242a = i4;
        rVar.f2243b = i5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b(long j4) {
        s sVar;
        RecyclerView recyclerView;
        long j5;
        RecyclerView recyclerView2;
        s sVar2;
        boolean z4;
        ArrayList arrayList = this.f2257a;
        int size = arrayList.size();
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            RecyclerView recyclerView3 = (RecyclerView) arrayList.get(i5);
            if (recyclerView3.getWindowVisibility() == 0) {
                r rVar = recyclerView3.f1971c0;
                rVar.b(recyclerView3, false);
                i4 += rVar.f2245d;
            }
        }
        ArrayList arrayList2 = this.f2260d;
        arrayList2.ensureCapacity(i4);
        int i6 = 0;
        for (int i7 = 0; i7 < size; i7++) {
            RecyclerView recyclerView4 = (RecyclerView) arrayList.get(i7);
            if (recyclerView4.getWindowVisibility() == 0) {
                r rVar2 = recyclerView4.f1971c0;
                int abs = Math.abs(rVar2.f2243b) + Math.abs(rVar2.f2242a);
                for (int i8 = 0; i8 < rVar2.f2245d * 2; i8 += 2) {
                    if (i6 >= arrayList2.size()) {
                        Object obj = new Object();
                        arrayList2.add(obj);
                        sVar2 = obj;
                    } else {
                        sVar2 = (s) arrayList2.get(i6);
                    }
                    int[] iArr = rVar2.f2244c;
                    int i9 = iArr[i8 + 1];
                    if (i9 <= abs) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    sVar2.f2249a = z4;
                    sVar2.f2250b = abs;
                    sVar2.f2251c = i9;
                    sVar2.f2252d = recyclerView4;
                    sVar2.f2253e = iArr[i8];
                    i6++;
                }
            }
        }
        Collections.sort(arrayList2, f2256f);
        for (int i10 = 0; i10 < arrayList2.size() && (recyclerView = (sVar = (s) arrayList2.get(i10)).f2252d) != null; i10++) {
            if (sVar.f2249a) {
                j5 = Long.MAX_VALUE;
            } else {
                j5 = j4;
            }
            l1 c4 = c(recyclerView, sVar.f2253e, j5);
            if (c4 != null && c4.f2171b != null && c4.g() && !c4.h() && (recyclerView2 = (RecyclerView) c4.f2171b.get()) != null) {
                if (recyclerView2.f2010z && recyclerView2.f1974e.f2071a.f() != 0) {
                    p0 p0Var = recyclerView2.I;
                    if (p0Var != null) {
                        p0Var.e();
                    }
                    u0 u0Var = recyclerView2.f1988l;
                    b1 b1Var = recyclerView2.f1968b;
                    if (u0Var != null) {
                        u0Var.f0(b1Var);
                        recyclerView2.f1988l.g0(b1Var);
                    }
                    b1Var.f2061a.clear();
                    b1Var.d();
                }
                r rVar3 = recyclerView2.f1971c0;
                rVar3.b(recyclerView2, true);
                if (rVar3.f2245d != 0) {
                    try {
                        int i11 = e0.j.f4429a;
                        e0.i.a("RV Nested Prefetch");
                        i1 i1Var = recyclerView2.f1973d0;
                        j0 j0Var = recyclerView2.f1986k;
                        i1Var.f2129d = 1;
                        i1Var.f2130e = j0Var.a();
                        i1Var.f2132g = false;
                        i1Var.f2133h = false;
                        i1Var.f2134i = false;
                        for (int i12 = 0; i12 < rVar3.f2245d * 2; i12 += 2) {
                            c(recyclerView2, rVar3.f2244c[i12], j4);
                        }
                        e0.i.b();
                        sVar.f2249a = false;
                        sVar.f2250b = 0;
                        sVar.f2251c = 0;
                        sVar.f2252d = null;
                        sVar.f2253e = 0;
                    } catch (Throwable th) {
                        int i13 = e0.j.f4429a;
                        e0.i.b();
                        throw th;
                    }
                }
            }
            sVar.f2249a = false;
            sVar.f2250b = 0;
            sVar.f2251c = 0;
            sVar.f2252d = null;
            sVar.f2253e = 0;
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            int i4 = e0.j.f4429a;
            e0.i.a("RV Prefetch");
            ArrayList arrayList = this.f2257a;
            if (arrayList.isEmpty()) {
                this.f2258b = 0L;
                e0.i.b();
                return;
            }
            int size = arrayList.size();
            long j4 = 0;
            for (int i5 = 0; i5 < size; i5++) {
                RecyclerView recyclerView = (RecyclerView) arrayList.get(i5);
                if (recyclerView.getWindowVisibility() == 0) {
                    j4 = Math.max(recyclerView.getDrawingTime(), j4);
                }
            }
            if (j4 == 0) {
                this.f2258b = 0L;
                e0.i.b();
                return;
            }
            b(TimeUnit.MILLISECONDS.toNanos(j4) + this.f2259c);
            this.f2258b = 0L;
            e0.i.b();
        } catch (Throwable th) {
            this.f2258b = 0L;
            int i6 = e0.j.f4429a;
            e0.i.b();
            throw th;
        }
    }
}