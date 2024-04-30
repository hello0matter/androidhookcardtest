package androidx.drawerlayout.widget;

import android.view.View;
import androidx.activity.k;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.common.collect.c;
import n0.e;

/* loaded from: classes.dex */
public final class b extends c {

    /* renamed from: q  reason: collision with root package name */
    public final int f1497q;

    /* renamed from: r  reason: collision with root package name */
    public e f1498r;

    /* renamed from: s  reason: collision with root package name */
    public final k f1499s = new k(6, this);

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ DrawerLayout f1500t;

    public b(DrawerLayout drawerLayout, int i4) {
        this.f1500t = drawerLayout;
        this.f1497q = i4;
    }

    @Override // com.google.common.collect.c
    public final int M(View view, int i4) {
        int width;
        int width2;
        DrawerLayout drawerLayout = this.f1500t;
        if (drawerLayout.a(3, view)) {
            width2 = -view.getWidth();
            width = 0;
        } else {
            width = drawerLayout.getWidth();
            width2 = width - view.getWidth();
        }
        return Math.max(width2, Math.min(i4, width));
    }

    @Override // com.google.common.collect.c
    public final int N(View view, int i4) {
        return view.getTop();
    }

    @Override // com.google.common.collect.c
    public final int R0(View view) {
        this.f1500t.getClass();
        if (DrawerLayout.l(view)) {
            return view.getWidth();
        }
        return 0;
    }

    @Override // com.google.common.collect.c
    public final boolean c2(int i4, View view) {
        DrawerLayout drawerLayout = this.f1500t;
        drawerLayout.getClass();
        if (DrawerLayout.l(view) && drawerLayout.a(this.f1497q, view) && drawerLayout.g(view) == 0) {
            return true;
        }
        return false;
    }

    @Override // com.google.common.collect.c
    public final void i1(int i4, int i5) {
        int i6 = i4 & 1;
        DrawerLayout drawerLayout = this.f1500t;
        View d4 = drawerLayout.d(i6 == 1 ? 3 : 5);
        if (d4 == null || drawerLayout.g(d4) != 0) {
            return;
        }
        this.f1498r.b(i5, d4);
    }

    @Override // com.google.common.collect.c
    public final void j1() {
        this.f1500t.postDelayed(this.f1499s, 160L);
    }

    @Override // com.google.common.collect.c
    public final void t1(int i4, View view) {
        ((DrawerLayout.LayoutParams) view.getLayoutParams()).f1490c = false;
        int i5 = 3;
        if (this.f1497q == 3) {
            i5 = 5;
        }
        DrawerLayout drawerLayout = this.f1500t;
        View d4 = drawerLayout.d(i5);
        if (d4 != null) {
            drawerLayout.b(d4, true);
        }
    }

    @Override // com.google.common.collect.c
    public final void u1(int i4) {
        this.f1500t.r(i4, this.f1498r.f5735t);
    }

    @Override // com.google.common.collect.c
    public final void v1(View view, int i4, int i5) {
        float width;
        int i6;
        int width2 = view.getWidth();
        DrawerLayout drawerLayout = this.f1500t;
        if (drawerLayout.a(3, view)) {
            width = i4 + width2;
        } else {
            width = drawerLayout.getWidth() - i4;
        }
        float f4 = width / width2;
        drawerLayout.o(view, f4);
        if (f4 == 0.0f) {
            i6 = 4;
        } else {
            i6 = 0;
        }
        view.setVisibility(i6);
        drawerLayout.invalidate();
    }

    @Override // com.google.common.collect.c
    public final void w1(View view, float f4, float f5) {
        int i4;
        DrawerLayout drawerLayout = this.f1500t;
        drawerLayout.getClass();
        float f6 = ((DrawerLayout.LayoutParams) view.getLayoutParams()).f1489b;
        int width = view.getWidth();
        if (drawerLayout.a(3, view)) {
            int i5 = (f4 > 0.0f ? 1 : (f4 == 0.0f ? 0 : -1));
            if (i5 <= 0 && (i5 != 0 || f6 <= 0.5f)) {
                i4 = -width;
            } else {
                i4 = 0;
            }
        } else {
            int width2 = drawerLayout.getWidth();
            if (f4 < 0.0f || (f4 == 0.0f && f6 > 0.5f)) {
                width2 -= width;
            }
            i4 = width2;
        }
        this.f1498r.q(i4, view.getTop());
        drawerLayout.invalidate();
    }
}