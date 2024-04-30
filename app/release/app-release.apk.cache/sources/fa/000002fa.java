package androidx.recyclerview.widget;

import android.graphics.PointF;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;

/* loaded from: classes.dex */
public abstract class h1 {

    /* renamed from: a  reason: collision with root package name */
    public int f2111a = -1;

    /* renamed from: b  reason: collision with root package name */
    public RecyclerView f2112b;

    /* renamed from: c  reason: collision with root package name */
    public u0 f2113c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f2114d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f2115e;

    /* renamed from: f  reason: collision with root package name */
    public View f2116f;

    /* renamed from: g  reason: collision with root package name */
    public final f1 f2117g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f2118h;

    /* JADX WARN: Type inference failed for: r1v0, types: [androidx.recyclerview.widget.f1, java.lang.Object] */
    public h1() {
        ?? obj = new Object();
        obj.f2095d = -1;
        obj.f2097f = false;
        obj.f2098g = 0;
        obj.f2092a = 0;
        obj.f2093b = 0;
        obj.f2094c = Integer.MIN_VALUE;
        obj.f2096e = null;
        this.f2117g = obj;
    }

    public PointF a(int i4) {
        u0 u0Var = this.f2113c;
        if (u0Var instanceof g1) {
            return ((g1) u0Var).a(i4);
        }
        Log.w("RecyclerView", "You should override computeScrollVectorForPosition when the LayoutManager does not implement " + g1.class.getCanonicalName());
        return null;
    }

    public final void b(int i4, int i5) {
        float f4;
        PointF a5;
        RecyclerView recyclerView = this.f2112b;
        int i6 = -1;
        if (this.f2111a == -1 || recyclerView == null) {
            d();
        }
        if (this.f2114d && this.f2116f == null && this.f2113c != null && (a5 = a(this.f2111a)) != null) {
            float f5 = a5.x;
            if (f5 != 0.0f || a5.y != 0.0f) {
                recyclerView.a0((int) Math.signum(f5), (int) Math.signum(a5.y), null);
            }
        }
        boolean z4 = false;
        this.f2114d = false;
        View view = this.f2116f;
        f1 f1Var = this.f2117g;
        if (view != null) {
            this.f2112b.getClass();
            l1 J = RecyclerView.J(view);
            if (J != null) {
                i6 = J.c();
            }
            if (i6 == this.f2111a) {
                c(this.f2116f, recyclerView.f1973d0, f1Var);
                f1Var.a(recyclerView);
                d();
            } else {
                Log.e("RecyclerView", "Passed over target position while smooth scrolling.");
                this.f2116f = null;
            }
        }
        if (this.f2115e) {
            i1 i1Var = recyclerView.f1973d0;
            a0 a0Var = (a0) this;
            if (a0Var.f2112b.f1988l.v() == 0) {
                a0Var.d();
            } else {
                int i7 = a0Var.f2052o;
                int i8 = i7 - i4;
                if (i7 * i8 <= 0) {
                    i8 = 0;
                }
                a0Var.f2052o = i8;
                int i9 = a0Var.f2053p;
                int i10 = i9 - i5;
                if (i9 * i10 <= 0) {
                    i10 = 0;
                }
                a0Var.f2053p = i10;
                if (i8 == 0 && i10 == 0) {
                    PointF a6 = a0Var.a(a0Var.f2111a);
                    if (a6 != null) {
                        if (a6.x != 0.0f || a6.y != 0.0f) {
                            float f6 = a6.y;
                            float sqrt = (float) Math.sqrt((f6 * f6) + (f4 * f4));
                            float f7 = a6.x / sqrt;
                            a6.x = f7;
                            float f8 = a6.y / sqrt;
                            a6.y = f8;
                            a0Var.f2048k = a6;
                            a0Var.f2052o = (int) (f7 * 10000.0f);
                            a0Var.f2053p = (int) (f8 * 10000.0f);
                            int i11 = a0Var.i(10000);
                            LinearInterpolator linearInterpolator = a0Var.f2046i;
                            f1Var.f2092a = (int) (a0Var.f2052o * 1.2f);
                            f1Var.f2093b = (int) (a0Var.f2053p * 1.2f);
                            f1Var.f2094c = (int) (i11 * 1.2f);
                            f1Var.f2096e = linearInterpolator;
                            f1Var.f2097f = true;
                        }
                    }
                    f1Var.f2095d = a0Var.f2111a;
                    a0Var.d();
                }
            }
            if (f1Var.f2095d >= 0) {
                z4 = true;
            }
            f1Var.a(recyclerView);
            if (z4 && this.f2115e) {
                this.f2114d = true;
                recyclerView.f1967a0.a();
            }
        }
    }

    public abstract void c(View view, i1 i1Var, f1 f1Var);

    public final void d() {
        if (!this.f2115e) {
            return;
        }
        this.f2115e = false;
        a0 a0Var = (a0) this;
        a0Var.f2053p = 0;
        a0Var.f2052o = 0;
        a0Var.f2048k = null;
        this.f2112b.f1973d0.f2126a = -1;
        this.f2116f = null;
        this.f2111a = -1;
        this.f2114d = false;
        u0 u0Var = this.f2113c;
        if (u0Var.f2277e == this) {
            u0Var.f2277e = null;
        }
        this.f2113c = null;
        this.f2112b = null;
    }
}