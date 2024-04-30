package androidx.appcompat.app;

import android.view.MenuItem;
import android.view.ViewGroup;
import i0.g1;
import i0.y0;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class u implements f.b {

    /* renamed from: a  reason: collision with root package name */
    public final f.b f340a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ f0 f341b;

    public u(f0 f0Var, f.h hVar) {
        this.f341b = f0Var;
        this.f340a = hVar;
    }

    @Override // f.b
    public final boolean a(f.c cVar, MenuItem menuItem) {
        return this.f340a.a(cVar, menuItem);
    }

    @Override // f.b
    public final boolean b(f.c cVar, g.p pVar) {
        return this.f340a.b(cVar, pVar);
    }

    @Override // f.b
    public final void c(f.c cVar) {
        this.f340a.c(cVar);
        f0 f0Var = this.f341b;
        if (f0Var.f250w != null) {
            f0Var.f239l.getDecorView().removeCallbacks(f0Var.f251x);
        }
        if (f0Var.f249v != null) {
            g1 g1Var = f0Var.f252y;
            if (g1Var != null) {
                g1Var.b();
            }
            g1 a5 = y0.a(f0Var.f249v);
            a5.a(0.0f);
            f0Var.f252y = a5;
            a5.d(new t(2, this));
        }
        f0Var.f248u = null;
        ViewGroup viewGroup = f0Var.A;
        WeakHashMap weakHashMap = y0.f4999a;
        i0.k0.c(viewGroup);
        f0Var.I();
    }

    @Override // f.b
    public final boolean d(f.c cVar, g.p pVar) {
        ViewGroup viewGroup = this.f341b.A;
        WeakHashMap weakHashMap = y0.f4999a;
        i0.k0.c(viewGroup);
        return this.f340a.d(cVar, pVar);
    }
}