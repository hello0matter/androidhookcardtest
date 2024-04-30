package androidx.recyclerview.widget;

import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class f0 extends w0 {

    /* renamed from: a  reason: collision with root package name */
    public RecyclerView f2088a;

    /* renamed from: b  reason: collision with root package name */
    public final o1 f2089b = new o1(this);

    /* renamed from: c  reason: collision with root package name */
    public c0 f2090c;

    /* renamed from: d  reason: collision with root package name */
    public b0 f2091d;

    public static int c(View view, d0 d0Var) {
        return ((d0Var.c(view) / 2) + d0Var.e(view)) - ((d0Var.l() / 2) + d0Var.k());
    }

    public static View d(u0 u0Var, d0 d0Var) {
        int v2 = u0Var.v();
        View view = null;
        if (v2 == 0) {
            return null;
        }
        int l4 = (d0Var.l() / 2) + d0Var.k();
        int i4 = Integer.MAX_VALUE;
        for (int i5 = 0; i5 < v2; i5++) {
            View u4 = u0Var.u(i5);
            int abs = Math.abs(((d0Var.c(u4) / 2) + d0Var.e(u4)) - l4);
            if (abs < i4) {
                view = u4;
                i4 = abs;
            }
        }
        return view;
    }

    public final void a(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.f2088a;
        if (recyclerView2 != recyclerView) {
            o1 o1Var = this.f2089b;
            if (recyclerView2 != null) {
                ArrayList arrayList = recyclerView2.f1977f0;
                if (arrayList != null) {
                    arrayList.remove(o1Var);
                }
                this.f2088a.setOnFlingListener(null);
            }
            this.f2088a = recyclerView;
            if (recyclerView != null) {
                if (recyclerView.getOnFlingListener() == null) {
                    this.f2088a.h(o1Var);
                    this.f2088a.setOnFlingListener(this);
                    new Scroller(this.f2088a.getContext(), new DecelerateInterpolator());
                    h();
                    return;
                }
                throw new IllegalStateException("An instance of OnFlingListener already set.");
            }
        }
    }

    public final int[] b(u0 u0Var, View view) {
        int[] iArr = new int[2];
        if (u0Var.d()) {
            iArr[0] = c(view, f(u0Var));
        } else {
            iArr[0] = 0;
        }
        if (u0Var.e()) {
            iArr[1] = c(view, g(u0Var));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }

    public View e(u0 u0Var) {
        d0 f4;
        if (u0Var.e()) {
            f4 = g(u0Var);
        } else if (!u0Var.d()) {
            return null;
        } else {
            f4 = f(u0Var);
        }
        return d(u0Var, f4);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [androidx.recyclerview.widget.d0, androidx.recyclerview.widget.b0] */
    public final d0 f(u0 u0Var) {
        b0 b0Var = this.f2091d;
        if (b0Var == null || b0Var.f2074a != u0Var) {
            this.f2091d = new d0(u0Var);
        }
        return this.f2091d;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [androidx.recyclerview.widget.d0, androidx.recyclerview.widget.c0] */
    public final d0 g(u0 u0Var) {
        c0 c0Var = this.f2090c;
        if (c0Var == null || c0Var.f2074a != u0Var) {
            this.f2090c = new d0(u0Var);
        }
        return this.f2090c;
    }

    public final void h() {
        u0 layoutManager;
        View e4;
        RecyclerView recyclerView = this.f2088a;
        if (recyclerView != null && (layoutManager = recyclerView.getLayoutManager()) != null && (e4 = e(layoutManager)) != null) {
            int[] b5 = b(layoutManager, e4);
            int i4 = b5[0];
            if (i4 != 0 || b5[1] != 0) {
                this.f2088a.c0(i4, b5[1], false);
            }
        }
    }
}