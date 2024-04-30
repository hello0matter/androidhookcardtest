package w1;

import android.graphics.Rect;
import android.view.MenuItem;
import android.view.View;
import androidx.recyclerview.widget.o0;
import com.google.android.material.internal.ScrimInsetsFrameLayout;
import com.google.android.material.internal.m0;
import com.google.android.material.internal.n0;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.navigationrail.NavigationRailView;
import g.n;
import g.p;
import i0.d2;
import i0.g0;
import i0.g2;
import i0.h0;
import i0.w;
import i0.y0;
import java.util.LinkedHashSet;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import q3.l;

/* loaded from: classes.dex */
public final class g implements com.google.android.material.internal.h, w, n, m0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f7055a;

    /* renamed from: b  reason: collision with root package name */
    public Object f7056b;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public g(int i4) {
        this(TimeUnit.MINUTES);
        this.f7055a = i4;
        if (i4 == 10) {
        } else if (i4 != 11) {
        } else {
            this.f7056b = new LinkedHashSet();
        }
    }

    @Override // i0.w
    public final g2 i(View view, g2 g2Var) {
        ScrimInsetsFrameLayout scrimInsetsFrameLayout = (ScrimInsetsFrameLayout) this.f7056b;
        if (scrimInsetsFrameLayout.f3461b == null) {
            scrimInsetsFrameLayout.f3461b = new Rect();
        }
        ((ScrimInsetsFrameLayout) this.f7056b).f3461b.set(g2Var.b(), g2Var.d(), g2Var.c(), g2Var.a());
        ((ScrimInsetsFrameLayout) this.f7056b).e(g2Var);
        ScrimInsetsFrameLayout scrimInsetsFrameLayout2 = (ScrimInsetsFrameLayout) this.f7056b;
        d2 d2Var = g2Var.f4931a;
        boolean z4 = true;
        if ((!d2Var.j().equals(b0.c.f2489e)) && ((ScrimInsetsFrameLayout) this.f7056b).f3460a != null) {
            z4 = false;
        }
        scrimInsetsFrameLayout2.setWillNotDraw(z4);
        WeakHashMap weakHashMap = y0.f4999a;
        g0.k((ScrimInsetsFrameLayout) this.f7056b);
        return d2Var.c();
    }

    @Override // g.n
    public final boolean p(p pVar, MenuItem menuItem) {
        switch (this.f7055a) {
            case 6:
                int i4 = NavigationBarView.f3669e;
                ((NavigationBarView) this.f7056b).getClass();
                ((NavigationBarView) this.f7056b).getClass();
                return false;
            default:
                ((NavigationView) this.f7056b).getClass();
                return false;
        }
    }

    @Override // com.google.android.material.internal.m0
    public final g2 s(View view, g2 g2Var, o0 o0Var) {
        boolean b5;
        boolean b6;
        boolean b7;
        int i4;
        b0.c f4 = g2Var.f4931a.f(7);
        NavigationRailView navigationRailView = (NavigationRailView) this.f7056b;
        Boolean bool = navigationRailView.f3701h;
        navigationRailView.getClass();
        if (bool != null) {
            b5 = bool.booleanValue();
        } else {
            WeakHashMap weakHashMap = y0.f4999a;
            b5 = g0.b(navigationRailView);
        }
        if (b5) {
            o0Var.f2198b += f4.f2491b;
        }
        NavigationRailView navigationRailView2 = (NavigationRailView) this.f7056b;
        Boolean bool2 = navigationRailView2.f3702i;
        navigationRailView2.getClass();
        if (bool2 != null) {
            b6 = bool2.booleanValue();
        } else {
            WeakHashMap weakHashMap2 = y0.f4999a;
            b6 = g0.b(navigationRailView2);
        }
        if (b6) {
            o0Var.f2200d += f4.f2493d;
        }
        NavigationRailView navigationRailView3 = (NavigationRailView) this.f7056b;
        Boolean bool3 = navigationRailView3.f3703j;
        navigationRailView3.getClass();
        if (bool3 != null) {
            b7 = bool3.booleanValue();
        } else {
            WeakHashMap weakHashMap3 = y0.f4999a;
            b7 = g0.b(navigationRailView3);
        }
        if (b7) {
            int i5 = o0Var.f2197a;
            if (n0.f(view)) {
                i4 = f4.f2492c;
            } else {
                i4 = f4.f2490a;
            }
            o0Var.f2197a = i5 + i4;
        }
        int i6 = o0Var.f2197a;
        int i7 = o0Var.f2198b;
        int i8 = o0Var.f2199c;
        int i9 = o0Var.f2200d;
        WeakHashMap weakHashMap4 = y0.f4999a;
        h0.k(view, i6, i7, i8, i9);
        return g2Var;
    }

    public /* synthetic */ g(int i4, Object obj) {
        this.f7055a = i4;
        this.f7056b = obj;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public g(TimeUnit timeUnit) {
        this(new l(p3.f.f6160i, timeUnit));
        this.f7055a = 10;
        com.google.common.collect.c.F(timeUnit, "timeUnit");
    }

    public g(l lVar) {
        this.f7055a = 10;
        this.f7056b = lVar;
    }

    @Override // g.n
    public final void b(p pVar) {
    }
}