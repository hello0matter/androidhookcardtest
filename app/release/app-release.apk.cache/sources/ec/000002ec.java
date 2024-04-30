package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public final i0 f2071a;

    /* renamed from: b  reason: collision with root package name */
    public final c f2072b = new c();

    /* renamed from: c  reason: collision with root package name */
    public final ArrayList f2073c = new ArrayList();

    public d(i0 i0Var) {
        this.f2071a = i0Var;
    }

    public final void a(View view, int i4, boolean z4) {
        int f4;
        i0 i0Var = this.f2071a;
        if (i4 < 0) {
            f4 = i0Var.f();
        } else {
            f4 = f(i4);
        }
        this.f2072b.e(f4, z4);
        if (z4) {
            g(view);
        }
        RecyclerView recyclerView = (RecyclerView) i0Var.f2125a;
        recyclerView.addView(view, f4);
        RecyclerView.J(view);
        ArrayList arrayList = recyclerView.f2009y;
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((androidx.viewpager2.widget.g) ((v0) recyclerView.f2009y.get(size))).getClass();
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                if (((ViewGroup.MarginLayoutParams) layoutParams).width != -1 || ((ViewGroup.MarginLayoutParams) layoutParams).height != -1) {
                    throw new IllegalStateException("Pages must fill the whole ViewPager2 (use match_parent)");
                }
            }
        }
    }

    public final void b(View view, int i4, ViewGroup.LayoutParams layoutParams, boolean z4) {
        int f4;
        i0 i0Var = this.f2071a;
        if (i4 < 0) {
            f4 = i0Var.f();
        } else {
            f4 = f(i4);
        }
        this.f2072b.e(f4, z4);
        if (z4) {
            g(view);
        }
        i0Var.getClass();
        l1 J = RecyclerView.J(view);
        Object obj = i0Var.f2125a;
        if (J != null) {
            if (!J.l() && !J.q()) {
                throw new IllegalArgumentException("Called attach on a child which is not detached: " + J + ((RecyclerView) obj).z());
            }
            J.f2179j &= -257;
        }
        ((RecyclerView) obj).attachViewToParent(view, f4, layoutParams);
    }

    public final void c(int i4) {
        l1 J;
        int f4 = f(i4);
        this.f2072b.f(f4);
        i0 i0Var = this.f2071a;
        View e4 = i0Var.e(f4);
        Object obj = i0Var.f2125a;
        if (e4 != null && (J = RecyclerView.J(e4)) != null) {
            if (J.l() && !J.q()) {
                throw new IllegalArgumentException("called detach on an already detached child " + J + ((RecyclerView) obj).z());
            }
            J.b(256);
        }
        ((RecyclerView) obj).detachViewFromParent(f4);
    }

    public final View d(int i4) {
        return this.f2071a.e(f(i4));
    }

    public final int e() {
        return this.f2071a.f() - this.f2073c.size();
    }

    public final int f(int i4) {
        if (i4 < 0) {
            return -1;
        }
        int f4 = this.f2071a.f();
        int i5 = i4;
        while (i5 < f4) {
            c cVar = this.f2072b;
            int b5 = i4 - (i5 - cVar.b(i5));
            if (b5 == 0) {
                while (cVar.d(i5)) {
                    i5++;
                }
                return i5;
            }
            i5 += b5;
        }
        return -1;
    }

    public final void g(View view) {
        this.f2073c.add(view);
        i0 i0Var = this.f2071a;
        i0Var.getClass();
        l1 J = RecyclerView.J(view);
        if (J != null) {
            RecyclerView recyclerView = (RecyclerView) i0Var.f2125a;
            int i4 = J.f2186q;
            View view2 = J.f2170a;
            if (i4 != -1) {
                J.f2185p = i4;
            } else {
                WeakHashMap weakHashMap = i0.y0.f4999a;
                J.f2185p = i0.g0.c(view2);
            }
            if (recyclerView.M()) {
                J.f2186q = 4;
                recyclerView.f1999q0.add(J);
                return;
            }
            WeakHashMap weakHashMap2 = i0.y0.f4999a;
            i0.g0.s(view2, 4);
        }
    }

    public final boolean h(View view) {
        return this.f2073c.contains(view);
    }

    public final void i(View view) {
        if (this.f2073c.remove(view)) {
            i0 i0Var = this.f2071a;
            i0Var.getClass();
            l1 J = RecyclerView.J(view);
            if (J != null) {
                RecyclerView recyclerView = (RecyclerView) i0Var.f2125a;
                int i4 = J.f2185p;
                if (recyclerView.M()) {
                    J.f2186q = i4;
                    recyclerView.f1999q0.add(J);
                } else {
                    WeakHashMap weakHashMap = i0.y0.f4999a;
                    i0.g0.s(J.f2170a, i4);
                }
                J.f2185p = 0;
            }
        }
    }

    public final String toString() {
        return this.f2072b.toString() + ", hidden list:" + this.f2073c.size();
    }
}