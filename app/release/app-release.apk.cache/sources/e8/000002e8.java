package androidx.recyclerview.widget;

import android.util.SparseArray;
import android.view.View;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class b1 {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList f2061a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList f2062b;

    /* renamed from: c  reason: collision with root package name */
    public final ArrayList f2063c;

    /* renamed from: d  reason: collision with root package name */
    public final List f2064d;

    /* renamed from: e  reason: collision with root package name */
    public int f2065e;

    /* renamed from: f  reason: collision with root package name */
    public int f2066f;

    /* renamed from: g  reason: collision with root package name */
    public a1 f2067g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ RecyclerView f2068h;

    public b1(RecyclerView recyclerView) {
        this.f2068h = recyclerView;
        ArrayList arrayList = new ArrayList();
        this.f2061a = arrayList;
        this.f2062b = null;
        this.f2063c = new ArrayList();
        this.f2064d = Collections.unmodifiableList(arrayList);
        this.f2065e = 2;
        this.f2066f = 2;
    }

    public final void a(l1 l1Var, boolean z4) {
        i0.c cVar;
        RecyclerView.j(l1Var);
        RecyclerView recyclerView = this.f2068h;
        n1 n1Var = recyclerView.f1987k0;
        if (n1Var != null) {
            m1 m1Var = n1Var.f2195e;
            boolean z5 = m1Var instanceof m1;
            View view = l1Var.f2170a;
            if (z5) {
                cVar = (i0.c) m1Var.f2190e.remove(view);
            } else {
                cVar = null;
            }
            i0.y0.p(view, cVar);
        }
        if (z4) {
            j0 j0Var = recyclerView.f1986k;
            if (j0Var != null) {
                j0Var.f(l1Var);
            }
            if (recyclerView.f1973d0 != null) {
                recyclerView.f1976f.h(l1Var);
            }
        }
        l1Var.f2187r = null;
        a1 c4 = c();
        c4.getClass();
        int i4 = l1Var.f2175f;
        ArrayList arrayList = c4.a(i4).f2329a;
        if (((z0) c4.f2054a.get(i4)).f2330b > arrayList.size()) {
            l1Var.o();
            arrayList.add(l1Var);
        }
    }

    public final int b(int i4) {
        RecyclerView recyclerView = this.f2068h;
        if (i4 >= 0 && i4 < recyclerView.f1973d0.b()) {
            if (!recyclerView.f1973d0.f2132g) {
                return i4;
            }
            return recyclerView.f1972d.f(i4, 0);
        }
        throw new IndexOutOfBoundsException("invalid position " + i4 + ". State item count is " + recyclerView.f1973d0.b() + recyclerView.z());
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, androidx.recyclerview.widget.a1] */
    public final a1 c() {
        if (this.f2067g == null) {
            ?? obj = new Object();
            obj.f2054a = new SparseArray();
            obj.f2055b = 0;
            this.f2067g = obj;
        }
        return this.f2067g;
    }

    public final void d() {
        ArrayList arrayList = this.f2063c;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            e(size);
        }
        arrayList.clear();
        int[] iArr = RecyclerView.f1963t0;
        r rVar = this.f2068h.f1971c0;
        int[] iArr2 = rVar.f2244c;
        if (iArr2 != null) {
            Arrays.fill(iArr2, -1);
        }
        rVar.f2245d = 0;
    }

    public final void e(int i4) {
        ArrayList arrayList = this.f2063c;
        a((l1) arrayList.get(i4), true);
        arrayList.remove(i4);
    }

    public final void f(View view) {
        l1 J = RecyclerView.J(view);
        boolean l4 = J.l();
        RecyclerView recyclerView = this.f2068h;
        if (l4) {
            recyclerView.removeDetachedView(view, false);
        }
        if (J.k()) {
            J.f2183n.j(J);
        } else if (J.r()) {
            J.f2179j &= -33;
        }
        g(J);
        if (recyclerView.I != null && !J.i()) {
            recyclerView.I.d(J);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x0092, code lost:
        r5 = r5 - 1;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00a8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void g(androidx.recyclerview.widget.l1 r12) {
        /*
            Method dump skipped, instructions count: 281
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.b1.g(androidx.recyclerview.widget.l1):void");
    }

    public final void h(View view) {
        ArrayList arrayList;
        p0 p0Var;
        l1 J = RecyclerView.J(view);
        boolean e4 = J.e(12);
        RecyclerView recyclerView = this.f2068h;
        if (!e4 && J.m() && (p0Var = recyclerView.I) != null) {
            k kVar = (k) p0Var;
            if (J.d().isEmpty() && kVar.f2148g && !J.h()) {
                if (this.f2062b == null) {
                    this.f2062b = new ArrayList();
                }
                J.f2183n = this;
                J.f2184o = true;
                arrayList = this.f2062b;
                arrayList.add(J);
            }
        }
        if (J.h() && !J.j() && !recyclerView.f1986k.f2146b) {
            throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool." + recyclerView.z());
        }
        J.f2183n = this;
        J.f2184o = false;
        arrayList = this.f2061a;
        arrayList.add(J);
    }

    /* JADX WARN: Code restructure failed: missing block: B:102:0x01b8, code lost:
        if (r3.f2132g == false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x01e8, code lost:
        if (r10.f2174e != r6.b(r10.f2172c)) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:240:0x044d, code lost:
        if ((r14 + r11) >= r27) goto L219;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:220:0x03ef  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x043e  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x045a  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x0478  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x0489  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x04a4  */
    /* JADX WARN: Removed duplicated region for block: B:260:0x04c3  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x04cb  */
    /* JADX WARN: Removed duplicated region for block: B:279:0x04fa  */
    /* JADX WARN: Removed duplicated region for block: B:283:0x0503  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x050d  */
    /* JADX WARN: Removed duplicated region for block: B:291:0x051e A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0144  */
    /* JADX WARN: Type inference failed for: r5v34, types: [java.lang.Object, androidx.recyclerview.widget.o0] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final androidx.recyclerview.widget.l1 i(int r26, long r27) {
        /*
            Method dump skipped, instructions count: 1367
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.b1.i(int, long):androidx.recyclerview.widget.l1");
    }

    public final void j(l1 l1Var) {
        ArrayList arrayList;
        if (l1Var.f2184o) {
            arrayList = this.f2062b;
        } else {
            arrayList = this.f2061a;
        }
        arrayList.remove(l1Var);
        l1Var.f2183n = null;
        l1Var.f2184o = false;
        l1Var.f2179j &= -33;
    }

    public final void k() {
        u0 u0Var = this.f2068h.f1988l;
        this.f2066f = this.f2065e + (u0Var != null ? u0Var.f2282j : 0);
        ArrayList arrayList = this.f2063c;
        for (int size = arrayList.size() - 1; size >= 0 && arrayList.size() > this.f2066f; size--) {
            e(size);
        }
    }
}