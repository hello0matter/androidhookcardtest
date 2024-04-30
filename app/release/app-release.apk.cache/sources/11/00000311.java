package androidx.recyclerview.widget;

import android.view.View;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class p0 {

    /* renamed from: a  reason: collision with root package name */
    public i0 f2229a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList f2230b;

    /* renamed from: c  reason: collision with root package name */
    public long f2231c;

    /* renamed from: d  reason: collision with root package name */
    public long f2232d;

    /* renamed from: e  reason: collision with root package name */
    public long f2233e;

    /* renamed from: f  reason: collision with root package name */
    public long f2234f;

    public static void b(l1 l1Var) {
        RecyclerView recyclerView;
        int i4 = l1Var.f2179j;
        if (!l1Var.h() && (i4 & 4) == 0 && (recyclerView = l1Var.f2187r) != null) {
            recyclerView.G(l1Var);
        }
    }

    public abstract boolean a(l1 l1Var, l1 l1Var2, o0 o0Var, o0 o0Var2);

    public final void c(l1 l1Var) {
        i0 i0Var = this.f2229a;
        if (i0Var != null) {
            boolean z4 = true;
            l1Var.p(true);
            if (l1Var.f2177h != null && l1Var.f2178i == null) {
                l1Var.f2177h = null;
            }
            l1Var.f2178i = null;
            if ((l1Var.f2179j & 16) == 0) {
                RecyclerView recyclerView = (RecyclerView) i0Var.f2125a;
                recyclerView.e0();
                d dVar = recyclerView.f1974e;
                i0 i0Var2 = dVar.f2071a;
                View view = l1Var.f2170a;
                int indexOfChild = ((RecyclerView) i0Var2.f2125a).indexOfChild(view);
                if (indexOfChild == -1) {
                    dVar.i(view);
                } else {
                    c cVar = dVar.f2072b;
                    if (cVar.d(indexOfChild)) {
                        cVar.f(indexOfChild);
                        dVar.i(view);
                        i0Var2.o(indexOfChild);
                    } else {
                        z4 = false;
                    }
                }
                if (z4) {
                    l1 J = RecyclerView.J(view);
                    b1 b1Var = recyclerView.f1968b;
                    b1Var.j(J);
                    b1Var.g(J);
                }
                recyclerView.f0(!z4);
                if (!z4 && l1Var.l()) {
                    recyclerView.removeDetachedView(view, false);
                }
            }
        }
    }

    public abstract void d(l1 l1Var);

    public abstract void e();

    public abstract boolean f();
}