package i0;

import android.animation.ValueAnimator;
import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import android.view.animation.DecelerateInterpolator;
import java.util.Objects;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class m1 implements View.OnApplyWindowInsetsListener {

    /* renamed from: a  reason: collision with root package name */
    public final t.n f4955a;

    /* renamed from: b  reason: collision with root package name */
    public g2 f4956b;

    public m1(View view, t.n nVar) {
        g2 g2Var;
        x1 t1Var;
        this.f4955a = nVar;
        WeakHashMap weakHashMap = y0.f4999a;
        g2 a5 = n0.a(view);
        if (a5 != null) {
            int i4 = Build.VERSION.SDK_INT;
            if (i4 >= 30) {
                t1Var = new w1(a5);
            } else if (i4 >= 29) {
                t1Var = new v1(a5);
            } else {
                t1Var = new t1(a5);
            }
            g2Var = t1Var.b();
        } else {
            g2Var = null;
        }
        this.f4956b = g2Var;
    }

    @Override // android.view.View.OnApplyWindowInsetsListener
    public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        d2 d2Var;
        if (!view.isLaidOut()) {
            this.f4956b = g2.h(view, windowInsets);
            return n1.i(view, windowInsets);
        }
        g2 h4 = g2.h(view, windowInsets);
        if (this.f4956b == null) {
            WeakHashMap weakHashMap = y0.f4999a;
            this.f4956b = n0.a(view);
        }
        if (this.f4956b == null) {
            this.f4956b = h4;
            return n1.i(view, windowInsets);
        }
        t.n j4 = n1.j(view);
        if (j4 != null && Objects.equals((WindowInsets) j4.f6680d, windowInsets)) {
            return n1.i(view, windowInsets);
        }
        g2 g2Var = this.f4956b;
        int i4 = 1;
        int i5 = 0;
        while (true) {
            d2Var = h4.f4931a;
            if (i4 > 256) {
                break;
            }
            if (!d2Var.f(i4).equals(g2Var.f4931a.f(i4))) {
                i5 |= i4;
            }
            i4 <<= 1;
        }
        if (i5 == 0) {
            return n1.i(view, windowInsets);
        }
        g2 g2Var2 = this.f4956b;
        r1 r1Var = new r1(i5, new DecelerateInterpolator(), 160L);
        r1Var.f4973a.d(0.0f);
        ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(r1Var.f4973a.a());
        b0.c f4 = d2Var.f(i5);
        b0.c f5 = g2Var2.f4931a.f(i5);
        int min = Math.min(f4.f2490a, f5.f2490a);
        int i6 = f4.f2491b;
        int i7 = f5.f2491b;
        int min2 = Math.min(i6, i7);
        int i8 = f4.f2492c;
        int i9 = f5.f2492c;
        int min3 = Math.min(i8, i9);
        int i10 = f4.f2493d;
        int i11 = i5;
        int i12 = f5.f2493d;
        androidx.appcompat.widget.c0 c0Var = new androidx.appcompat.widget.c0(5, b0.c.b(min, min2, min3, Math.min(i10, i12)), b0.c.b(Math.max(f4.f2490a, f5.f2490a), Math.max(i6, i7), Math.max(i8, i9), Math.max(i10, i12)));
        n1.f(view, windowInsets, false);
        duration.addUpdateListener(new k1(r1Var, h4, g2Var2, i11, view));
        duration.addListener(new e1(this, r1Var, view, 1));
        z.a(view, new l1(view, r1Var, c0Var, duration));
        this.f4956b = h4;
        return n1.i(view, windowInsets);
    }
}