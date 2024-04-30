package i0;

import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class g2 {

    /* renamed from: b  reason: collision with root package name */
    public static final g2 f4930b;

    /* renamed from: a  reason: collision with root package name */
    public final d2 f4931a;

    static {
        g2 g2Var;
        if (Build.VERSION.SDK_INT >= 30) {
            g2Var = c2.f4915q;
        } else {
            g2Var = d2.f4917b;
        }
        f4930b = g2Var;
    }

    public g2() {
        this.f4931a = new d2(this);
    }

    public static b0.c e(b0.c cVar, int i4, int i5, int i6, int i7) {
        int max = Math.max(0, cVar.f2490a - i4);
        int max2 = Math.max(0, cVar.f2491b - i5);
        int max3 = Math.max(0, cVar.f2492c - i6);
        int max4 = Math.max(0, cVar.f2493d - i7);
        if (max == i4 && max2 == i5 && max3 == i6 && max4 == i7) {
            return cVar;
        }
        return b0.c.b(max, max2, max3, max4);
    }

    public static g2 h(View view, WindowInsets windowInsets) {
        windowInsets.getClass();
        g2 g2Var = new g2(windowInsets);
        if (view != null) {
            WeakHashMap weakHashMap = y0.f4999a;
            if (j0.b(view)) {
                g2 a5 = n0.a(view);
                d2 d2Var = g2Var.f4931a;
                d2Var.p(a5);
                d2Var.d(view.getRootView());
            }
        }
        return g2Var;
    }

    public final int a() {
        return this.f4931a.j().f2493d;
    }

    public final int b() {
        return this.f4931a.j().f2490a;
    }

    public final int c() {
        return this.f4931a.j().f2492c;
    }

    public final int d() {
        return this.f4931a.j().f2491b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g2)) {
            return false;
        }
        return h0.b.a(this.f4931a, ((g2) obj).f4931a);
    }

    public final g2 f(int i4, int i5, int i6, int i7) {
        x1 t1Var;
        int i8 = Build.VERSION.SDK_INT;
        if (i8 >= 30) {
            t1Var = new w1(this);
        } else if (i8 >= 29) {
            t1Var = new v1(this);
        } else {
            t1Var = new t1(this);
        }
        t1Var.g(b0.c.b(i4, i5, i6, i7));
        return t1Var.b();
    }

    public final WindowInsets g() {
        d2 d2Var = this.f4931a;
        if (d2Var instanceof y1) {
            return ((y1) d2Var).f5010c;
        }
        return null;
    }

    public final int hashCode() {
        d2 d2Var = this.f4931a;
        if (d2Var == null) {
            return 0;
        }
        return d2Var.hashCode();
    }

    public g2(WindowInsets windowInsets) {
        int i4 = Build.VERSION.SDK_INT;
        this.f4931a = i4 >= 30 ? new c2(this, windowInsets) : i4 >= 29 ? new b2(this, windowInsets) : i4 >= 28 ? new a2(this, windowInsets) : new z1(this, windowInsets);
    }
}