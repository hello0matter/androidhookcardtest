package androidx.appcompat.app;

import android.view.View;
import android.view.Window;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.widget.j1;
import androidx.appcompat.widget.v1;
import i0.g2;
import i0.y0;

/* loaded from: classes.dex */
public final class s implements i0.w, v1, j1, g.c0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f329a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ f0 f330b;

    public /* synthetic */ s(f0 f0Var, int i4) {
        this.f329a = i4;
        this.f330b = f0Var;
    }

    @Override // g.c0
    public final void a(g.p pVar, boolean z4) {
        boolean z5;
        int i4;
        e0 e0Var;
        int i5 = this.f329a;
        f0 f0Var = this.f330b;
        switch (i5) {
            case VisibleForTesting.PACKAGE_PRIVATE /* 3 */:
                f0Var.r(pVar);
                return;
            default:
                g.p k4 = pVar.k();
                int i6 = 0;
                if (k4 != pVar) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (z5) {
                    pVar = k4;
                }
                e0[] e0VarArr = f0Var.L;
                if (e0VarArr != null) {
                    i4 = e0VarArr.length;
                } else {
                    i4 = 0;
                }
                while (true) {
                    if (i6 < i4) {
                        e0Var = e0VarArr[i6];
                        if (e0Var == null || e0Var.f216h != pVar) {
                            i6++;
                        }
                    } else {
                        e0Var = null;
                    }
                }
                if (e0Var != null) {
                    if (z5) {
                        f0Var.q(e0Var.f209a, e0Var, k4);
                        f0Var.s(e0Var, true);
                        return;
                    }
                    f0Var.s(e0Var, z4);
                    return;
                }
                return;
        }
    }

    @Override // g.c0
    public final boolean f(g.p pVar) {
        Window.Callback callback;
        int i4 = this.f329a;
        f0 f0Var = this.f330b;
        switch (i4) {
            case VisibleForTesting.PACKAGE_PRIVATE /* 3 */:
                Window.Callback callback2 = f0Var.f239l.getCallback();
                if (callback2 != null) {
                    callback2.onMenuOpened(108, pVar);
                }
                return true;
            default:
                if (pVar == pVar.k() && f0Var.F && (callback = f0Var.f239l.getCallback()) != null && !f0Var.Q) {
                    callback.onMenuOpened(108, pVar);
                }
                return true;
        }
    }

    @Override // i0.w
    public final g2 i(View view, g2 g2Var) {
        int d4 = g2Var.d();
        int J = this.f330b.J(g2Var, null);
        if (d4 != J) {
            g2Var = g2Var.f(g2Var.b(), J, g2Var.c(), g2Var.a());
        }
        return y0.j(view, g2Var);
    }
}