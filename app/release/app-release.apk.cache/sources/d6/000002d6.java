package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.RestrictTo;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/* loaded from: classes.dex */
public class LinearLayoutManager extends u0 implements g1 {
    public final w A;
    public final x B;
    public final int C;
    public final int[] D;

    /* renamed from: p  reason: collision with root package name */
    public int f1949p;

    /* renamed from: q  reason: collision with root package name */
    public y f1950q;

    /* renamed from: r  reason: collision with root package name */
    public d0 f1951r;

    /* renamed from: s  reason: collision with root package name */
    public boolean f1952s;

    /* renamed from: t  reason: collision with root package name */
    public final boolean f1953t;

    /* renamed from: u  reason: collision with root package name */
    public boolean f1954u;

    /* renamed from: v  reason: collision with root package name */
    public boolean f1955v;

    /* renamed from: w  reason: collision with root package name */
    public final boolean f1956w;

    /* renamed from: x  reason: collision with root package name */
    public int f1957x;

    /* renamed from: y  reason: collision with root package name */
    public int f1958y;

    /* renamed from: z  reason: collision with root package name */
    public SavedState f1959z;

    @SuppressLint({"BanParcelableUsage"})
    @RestrictTo({RestrictTo.Scope.f169a})
    /* loaded from: classes.dex */
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Object();

        /* renamed from: a  reason: collision with root package name */
        public int f1960a;

        /* renamed from: b  reason: collision with root package name */
        public int f1961b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f1962c;

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i4) {
            parcel.writeInt(this.f1960a);
            parcel.writeInt(this.f1961b);
            parcel.writeInt(this.f1962c ? 1 : 0);
        }
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [androidx.recyclerview.widget.x, java.lang.Object] */
    public LinearLayoutManager(int i4) {
        this.f1949p = 1;
        this.f1953t = false;
        this.f1954u = false;
        this.f1955v = false;
        this.f1956w = true;
        this.f1957x = -1;
        this.f1958y = Integer.MIN_VALUE;
        this.f1959z = null;
        this.A = new w();
        this.B = new Object();
        this.C = 2;
        this.D = new int[2];
        Z0(i4);
        c(null);
        if (this.f1953t) {
            this.f1953t = false;
            k0();
        }
    }

    public void A0(i1 i1Var, y yVar, r rVar) {
        int i4 = yVar.f2320d;
        if (i4 >= 0 && i4 < i1Var.b()) {
            rVar.a(i4, Math.max(0, yVar.f2323g));
        }
    }

    public final int B0(i1 i1Var) {
        if (v() == 0) {
            return 0;
        }
        F0();
        d0 d0Var = this.f1951r;
        boolean z4 = !this.f1956w;
        return com.google.common.collect.c.S(i1Var, d0Var, I0(z4), H0(z4), this, this.f1956w);
    }

    public final int C0(i1 i1Var) {
        if (v() == 0) {
            return 0;
        }
        F0();
        d0 d0Var = this.f1951r;
        boolean z4 = !this.f1956w;
        return com.google.common.collect.c.T(i1Var, d0Var, I0(z4), H0(z4), this, this.f1956w, this.f1954u);
    }

    public final int D0(i1 i1Var) {
        if (v() == 0) {
            return 0;
        }
        F0();
        d0 d0Var = this.f1951r;
        boolean z4 = !this.f1956w;
        return com.google.common.collect.c.U(i1Var, d0Var, I0(z4), H0(z4), this, this.f1956w);
    }

    public final int E0(int i4) {
        return i4 != 1 ? i4 != 2 ? i4 != 17 ? i4 != 33 ? i4 != 66 ? (i4 == 130 && this.f1949p == 1) ? 1 : Integer.MIN_VALUE : this.f1949p == 0 ? 1 : Integer.MIN_VALUE : this.f1949p == 1 ? -1 : Integer.MIN_VALUE : this.f1949p == 0 ? -1 : Integer.MIN_VALUE : (this.f1949p != 1 && S0()) ? -1 : 1 : (this.f1949p != 1 && S0()) ? 1 : -1;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [androidx.recyclerview.widget.y, java.lang.Object] */
    public final void F0() {
        if (this.f1950q == null) {
            ?? obj = new Object();
            obj.f2317a = true;
            obj.f2324h = 0;
            obj.f2325i = 0;
            obj.f2327k = null;
            this.f1950q = obj;
        }
    }

    public final int G0(b1 b1Var, y yVar, i1 i1Var, boolean z4) {
        int i4;
        int i5 = yVar.f2319c;
        int i6 = yVar.f2323g;
        if (i6 != Integer.MIN_VALUE) {
            if (i5 < 0) {
                yVar.f2323g = i6 + i5;
            }
            V0(b1Var, yVar);
        }
        int i7 = yVar.f2319c + yVar.f2324h;
        while (true) {
            if ((!yVar.f2328l && i7 <= 0) || (i4 = yVar.f2320d) < 0 || i4 >= i1Var.b()) {
                break;
            }
            x xVar = this.B;
            xVar.f2311a = 0;
            xVar.f2312b = false;
            xVar.f2313c = false;
            xVar.f2314d = false;
            T0(b1Var, i1Var, yVar, xVar);
            if (!xVar.f2312b) {
                int i8 = yVar.f2318b;
                int i9 = xVar.f2311a;
                yVar.f2318b = (yVar.f2322f * i9) + i8;
                if (!xVar.f2313c || yVar.f2327k != null || !i1Var.f2132g) {
                    yVar.f2319c -= i9;
                    i7 -= i9;
                }
                int i10 = yVar.f2323g;
                if (i10 != Integer.MIN_VALUE) {
                    int i11 = i10 + i9;
                    yVar.f2323g = i11;
                    int i12 = yVar.f2319c;
                    if (i12 < 0) {
                        yVar.f2323g = i11 + i12;
                    }
                    V0(b1Var, yVar);
                }
                if (z4 && xVar.f2314d) {
                    break;
                }
            } else {
                break;
            }
        }
        return i5 - yVar.f2319c;
    }

    public final View H0(boolean z4) {
        int v2;
        int i4;
        if (this.f1954u) {
            v2 = 0;
            i4 = v();
        } else {
            v2 = v() - 1;
            i4 = -1;
        }
        return M0(v2, i4, z4);
    }

    public final View I0(boolean z4) {
        int i4;
        int v2;
        if (this.f1954u) {
            i4 = v() - 1;
            v2 = -1;
        } else {
            i4 = 0;
            v2 = v();
        }
        return M0(i4, v2, z4);
    }

    @Override // androidx.recyclerview.widget.u0
    public final boolean J() {
        return true;
    }

    public final int J0() {
        View M0 = M0(0, v(), false);
        if (M0 == null) {
            return -1;
        }
        return u0.F(M0);
    }

    public final int K0() {
        View M0 = M0(v() - 1, -1, false);
        if (M0 == null) {
            return -1;
        }
        return u0.F(M0);
    }

    public final View L0(int i4, int i5) {
        int i6;
        int i7;
        F0();
        if (i5 <= i4 && i5 >= i4) {
            return u(i4);
        }
        if (this.f1951r.e(u(i4)) < this.f1951r.k()) {
            i6 = 16644;
            i7 = 16388;
        } else {
            i6 = 4161;
            i7 = 4097;
        }
        return (this.f1949p == 0 ? this.f2275c : this.f2276d).d(i4, i5, i6, i7);
    }

    public final View M0(int i4, int i5, boolean z4) {
        int i6;
        x1 x1Var;
        F0();
        if (z4) {
            i6 = 24579;
        } else {
            i6 = 320;
        }
        if (this.f1949p == 0) {
            x1Var = this.f2275c;
        } else {
            x1Var = this.f2276d;
        }
        return x1Var.d(i4, i5, i6, 320);
    }

    public View N0(b1 b1Var, i1 i1Var, int i4, int i5, int i6) {
        int i7;
        F0();
        int k4 = this.f1951r.k();
        int g4 = this.f1951r.g();
        if (i5 > i4) {
            i7 = 1;
        } else {
            i7 = -1;
        }
        View view = null;
        View view2 = null;
        while (i4 != i5) {
            View u4 = u(i4);
            int F = u0.F(u4);
            if (F >= 0 && F < i6) {
                if (((RecyclerView.LayoutParams) u4.getLayoutParams()).f2011a.j()) {
                    if (view2 == null) {
                        view2 = u4;
                    }
                } else if (this.f1951r.e(u4) < g4 && this.f1951r.b(u4) >= k4) {
                    return u4;
                } else {
                    if (view == null) {
                        view = u4;
                    }
                }
            }
            i4 += i7;
        }
        if (view == null) {
            return view2;
        }
        return view;
    }

    @Override // androidx.recyclerview.widget.u0
    public final void O(RecyclerView recyclerView) {
    }

    public final int O0(int i4, b1 b1Var, i1 i1Var, boolean z4) {
        int g4;
        int g5 = this.f1951r.g() - i4;
        if (g5 > 0) {
            int i5 = -Y0(-g5, b1Var, i1Var);
            int i6 = i4 + i5;
            if (!z4 || (g4 = this.f1951r.g() - i6) <= 0) {
                return i5;
            }
            this.f1951r.p(g4);
            return g4 + i5;
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.u0
    public View P(View view, int i4, b1 b1Var, i1 i1Var) {
        int E0;
        View L0;
        View Q0;
        X0();
        if (v() == 0 || (E0 = E0(i4)) == Integer.MIN_VALUE) {
            return null;
        }
        F0();
        b1(E0, (int) (this.f1951r.l() * 0.33333334f), false, i1Var);
        y yVar = this.f1950q;
        yVar.f2323g = Integer.MIN_VALUE;
        yVar.f2317a = false;
        G0(b1Var, yVar, i1Var, true);
        if (E0 == -1) {
            if (this.f1954u) {
                L0 = L0(v() - 1, -1);
            } else {
                L0 = L0(0, v());
            }
        } else if (this.f1954u) {
            L0 = L0(0, v());
        } else {
            L0 = L0(v() - 1, -1);
        }
        if (E0 == -1) {
            Q0 = R0();
        } else {
            Q0 = Q0();
        }
        if (Q0.hasFocusable()) {
            if (L0 == null) {
                return null;
            }
            return Q0;
        }
        return L0;
    }

    public final int P0(int i4, b1 b1Var, i1 i1Var, boolean z4) {
        int k4;
        int k5 = i4 - this.f1951r.k();
        if (k5 > 0) {
            int i5 = -Y0(k5, b1Var, i1Var);
            int i6 = i4 + i5;
            if (!z4 || (k4 = i6 - this.f1951r.k()) <= 0) {
                return i5;
            }
            this.f1951r.p(-k4);
            return i5 - k4;
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.u0
    public final void Q(AccessibilityEvent accessibilityEvent) {
        super.Q(accessibilityEvent);
        if (v() > 0) {
            accessibilityEvent.setFromIndex(J0());
            accessibilityEvent.setToIndex(K0());
        }
    }

    public final View Q0() {
        return u(this.f1954u ? 0 : v() - 1);
    }

    public final View R0() {
        return u(this.f1954u ? v() - 1 : 0);
    }

    public final boolean S0() {
        return A() == 1;
    }

    public void T0(b1 b1Var, i1 i1Var, y yVar, x xVar) {
        boolean z4;
        int i4;
        int i5;
        int i6;
        int i7;
        boolean z5;
        View b5 = yVar.b(b1Var);
        if (b5 == null) {
            xVar.f2312b = true;
            return;
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) b5.getLayoutParams();
        if (yVar.f2327k == null) {
            boolean z6 = this.f1954u;
            if (yVar.f2322f == -1) {
                z5 = true;
            } else {
                z5 = false;
            }
            if (z6 == z5) {
                b(b5, -1, false);
            } else {
                b(b5, 0, false);
            }
        } else {
            boolean z7 = this.f1954u;
            if (yVar.f2322f == -1) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (z7 == z4) {
                b(b5, -1, true);
            } else {
                b(b5, 0, true);
            }
        }
        RecyclerView.LayoutParams layoutParams2 = (RecyclerView.LayoutParams) b5.getLayoutParams();
        Rect K = this.f2274b.K(b5);
        int i8 = K.left + K.right;
        int i9 = K.top + K.bottom;
        int w4 = u0.w(d(), this.f2286n, this.f2284l, D() + C() + ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin + i8, ((ViewGroup.MarginLayoutParams) layoutParams2).width);
        int w5 = u0.w(e(), this.f2287o, this.f2285m, B() + E() + ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin + i9, ((ViewGroup.MarginLayoutParams) layoutParams2).height);
        if (t0(b5, w4, w5, layoutParams2)) {
            b5.measure(w4, w5);
        }
        xVar.f2311a = this.f1951r.c(b5);
        if (this.f1949p == 1) {
            if (S0()) {
                i7 = this.f2286n - D();
                i4 = i7 - this.f1951r.d(b5);
            } else {
                i4 = C();
                i7 = this.f1951r.d(b5) + i4;
            }
            if (yVar.f2322f == -1) {
                i5 = yVar.f2318b;
                i6 = i5 - xVar.f2311a;
            } else {
                i6 = yVar.f2318b;
                i5 = xVar.f2311a + i6;
            }
        } else {
            int E = E();
            int d4 = this.f1951r.d(b5) + E;
            int i10 = yVar.f2322f;
            int i11 = yVar.f2318b;
            if (i10 == -1) {
                int i12 = i11 - xVar.f2311a;
                i7 = i11;
                i5 = d4;
                i4 = i12;
                i6 = E;
            } else {
                int i13 = xVar.f2311a + i11;
                i4 = i11;
                i5 = d4;
                i6 = E;
                i7 = i13;
            }
        }
        u0.L(b5, i4, i6, i7, i5);
        if (layoutParams.f2011a.j() || layoutParams.f2011a.m()) {
            xVar.f2313c = true;
        }
        xVar.f2314d = b5.hasFocusable();
    }

    public void U0(b1 b1Var, i1 i1Var, w wVar, int i4) {
    }

    public final void V0(b1 b1Var, y yVar) {
        if (yVar.f2317a && !yVar.f2328l) {
            int i4 = yVar.f2323g;
            int i5 = yVar.f2325i;
            if (yVar.f2322f == -1) {
                int v2 = v();
                if (i4 >= 0) {
                    int f4 = (this.f1951r.f() - i4) + i5;
                    if (this.f1954u) {
                        for (int i6 = 0; i6 < v2; i6++) {
                            View u4 = u(i6);
                            if (this.f1951r.e(u4) < f4 || this.f1951r.o(u4) < f4) {
                                W0(b1Var, 0, i6);
                                return;
                            }
                        }
                        return;
                    }
                    int i7 = v2 - 1;
                    for (int i8 = i7; i8 >= 0; i8--) {
                        View u5 = u(i8);
                        if (this.f1951r.e(u5) < f4 || this.f1951r.o(u5) < f4) {
                            W0(b1Var, i7, i8);
                            return;
                        }
                    }
                }
            } else if (i4 >= 0) {
                int i9 = i4 - i5;
                int v4 = v();
                if (this.f1954u) {
                    int i10 = v4 - 1;
                    for (int i11 = i10; i11 >= 0; i11--) {
                        View u6 = u(i11);
                        if (this.f1951r.b(u6) > i9 || this.f1951r.n(u6) > i9) {
                            W0(b1Var, i10, i11);
                            return;
                        }
                    }
                    return;
                }
                for (int i12 = 0; i12 < v4; i12++) {
                    View u7 = u(i12);
                    if (this.f1951r.b(u7) > i9 || this.f1951r.n(u7) > i9) {
                        W0(b1Var, 0, i12);
                        return;
                    }
                }
            }
        }
    }

    public final void W0(b1 b1Var, int i4, int i5) {
        if (i4 == i5) {
            return;
        }
        if (i5 > i4) {
            for (int i6 = i5 - 1; i6 >= i4; i6--) {
                View u4 = u(i6);
                i0(i6);
                b1Var.f(u4);
            }
            return;
        }
        while (i4 > i5) {
            View u5 = u(i4);
            i0(i4);
            b1Var.f(u5);
            i4--;
        }
    }

    public final void X0() {
        this.f1954u = (this.f1949p == 1 || !S0()) ? this.f1953t : !this.f1953t;
    }

    public final int Y0(int i4, b1 b1Var, i1 i1Var) {
        int i5;
        if (v() == 0 || i4 == 0) {
            return 0;
        }
        F0();
        this.f1950q.f2317a = true;
        if (i4 > 0) {
            i5 = 1;
        } else {
            i5 = -1;
        }
        int abs = Math.abs(i4);
        b1(i5, abs, true, i1Var);
        y yVar = this.f1950q;
        int G0 = G0(b1Var, yVar, i1Var, false) + yVar.f2323g;
        if (G0 < 0) {
            return 0;
        }
        if (abs > G0) {
            i4 = i5 * G0;
        }
        this.f1951r.p(-i4);
        this.f1950q.f2326j = i4;
        return i4;
    }

    @Override // androidx.recyclerview.widget.u0
    public void Z(b1 b1Var, i1 i1Var) {
        View focusedChild;
        int i4;
        View focusedChild2;
        View N0;
        int k4;
        int i5;
        int k5;
        int i6;
        int g4;
        int i7;
        boolean z4;
        boolean z5;
        int e4;
        int i8;
        int i9;
        boolean z6;
        int i10;
        int i11;
        List list;
        boolean z7;
        int i12;
        int i13;
        int O0;
        int i14;
        View q4;
        int e5;
        int i15;
        int i16;
        int i17 = -1;
        if ((this.f1959z != null || this.f1957x != -1) && i1Var.b() == 0) {
            f0(b1Var);
            return;
        }
        SavedState savedState = this.f1959z;
        if (savedState != null && (i16 = savedState.f1960a) >= 0) {
            this.f1957x = i16;
        }
        F0();
        this.f1950q.f2317a = false;
        X0();
        RecyclerView recyclerView = this.f2274b;
        if (recyclerView == null || (focusedChild = recyclerView.getFocusedChild()) == null || this.f2273a.h(focusedChild)) {
            focusedChild = null;
        }
        w wVar = this.A;
        if (wVar.f2306e && this.f1957x == -1 && this.f1959z == null) {
            if (focusedChild != null && (this.f1951r.e(focusedChild) >= this.f1951r.g() || this.f1951r.b(focusedChild) <= this.f1951r.k())) {
                wVar.c(u0.F(focusedChild), focusedChild);
            }
        } else {
            wVar.d();
            wVar.f2305d = this.f1954u ^ this.f1955v;
            if (!i1Var.f2132g && (i5 = this.f1957x) != -1) {
                if (i5 >= 0 && i5 < i1Var.b()) {
                    int i18 = this.f1957x;
                    wVar.f2303b = i18;
                    SavedState savedState2 = this.f1959z;
                    if (savedState2 != null && savedState2.f1960a >= 0) {
                        boolean z8 = savedState2.f1962c;
                        wVar.f2305d = z8;
                        if (z8) {
                            g4 = this.f1951r.g();
                            i7 = this.f1959z.f1961b;
                            i8 = g4 - i7;
                        } else {
                            k5 = this.f1951r.k();
                            i6 = this.f1959z.f1961b;
                            i8 = k5 + i6;
                        }
                    } else if (this.f1958y == Integer.MIN_VALUE) {
                        View q5 = q(i18);
                        if (q5 != null) {
                            if (this.f1951r.c(q5) <= this.f1951r.l()) {
                                if (this.f1951r.e(q5) - this.f1951r.k() < 0) {
                                    wVar.f2304c = this.f1951r.k();
                                    wVar.f2305d = false;
                                } else if (this.f1951r.g() - this.f1951r.b(q5) < 0) {
                                    wVar.f2304c = this.f1951r.g();
                                    wVar.f2305d = true;
                                } else {
                                    if (wVar.f2305d) {
                                        e4 = this.f1951r.m() + this.f1951r.b(q5);
                                    } else {
                                        e4 = this.f1951r.e(q5);
                                    }
                                    wVar.f2304c = e4;
                                }
                                wVar.f2306e = true;
                            }
                        } else if (v() > 0) {
                            if (this.f1957x < u0.F(u(0))) {
                                z4 = true;
                            } else {
                                z4 = false;
                            }
                            if (z4 == this.f1954u) {
                                z5 = true;
                            } else {
                                z5 = false;
                            }
                            wVar.f2305d = z5;
                        }
                        wVar.a();
                        wVar.f2306e = true;
                    } else {
                        boolean z9 = this.f1954u;
                        wVar.f2305d = z9;
                        if (z9) {
                            g4 = this.f1951r.g();
                            i7 = this.f1958y;
                            i8 = g4 - i7;
                        } else {
                            k5 = this.f1951r.k();
                            i6 = this.f1958y;
                            i8 = k5 + i6;
                        }
                    }
                    wVar.f2304c = i8;
                    wVar.f2306e = true;
                } else {
                    this.f1957x = -1;
                    this.f1958y = Integer.MIN_VALUE;
                }
            }
            if (v() != 0) {
                RecyclerView recyclerView2 = this.f2274b;
                if (recyclerView2 == null || (focusedChild2 = recyclerView2.getFocusedChild()) == null || this.f2273a.h(focusedChild2)) {
                    focusedChild2 = null;
                }
                if (focusedChild2 != null) {
                    RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) focusedChild2.getLayoutParams();
                    if (!layoutParams.f2011a.j() && layoutParams.f2011a.c() >= 0 && layoutParams.f2011a.c() < i1Var.b()) {
                        wVar.c(u0.F(focusedChild2), focusedChild2);
                        wVar.f2306e = true;
                    }
                }
                if (this.f1952s == this.f1955v) {
                    if (wVar.f2305d) {
                        if (this.f1954u) {
                            N0 = N0(b1Var, i1Var, 0, v(), i1Var.b());
                        } else {
                            N0 = N0(b1Var, i1Var, v() - 1, -1, i1Var.b());
                        }
                    } else if (this.f1954u) {
                        N0 = N0(b1Var, i1Var, v() - 1, -1, i1Var.b());
                    } else {
                        N0 = N0(b1Var, i1Var, 0, v(), i1Var.b());
                    }
                    if (N0 != null) {
                        wVar.b(u0.F(N0), N0);
                        if (!i1Var.f2132g && y0() && (this.f1951r.e(N0) >= this.f1951r.g() || this.f1951r.b(N0) < this.f1951r.k())) {
                            if (wVar.f2305d) {
                                k4 = this.f1951r.g();
                            } else {
                                k4 = this.f1951r.k();
                            }
                            wVar.f2304c = k4;
                        }
                        wVar.f2306e = true;
                    }
                }
            }
            wVar.a();
            if (this.f1955v) {
                i4 = i1Var.b() - 1;
            } else {
                i4 = 0;
            }
            wVar.f2303b = i4;
            wVar.f2306e = true;
        }
        y yVar = this.f1950q;
        if (yVar.f2326j >= 0) {
            i9 = 1;
        } else {
            i9 = -1;
        }
        yVar.f2322f = i9;
        int[] iArr = this.D;
        iArr[0] = 0;
        iArr[1] = 0;
        z0(i1Var, iArr);
        int k6 = this.f1951r.k() + Math.max(0, iArr[0]);
        int h4 = this.f1951r.h() + Math.max(0, iArr[1]);
        if (i1Var.f2132g && (i14 = this.f1957x) != -1 && this.f1958y != Integer.MIN_VALUE && (q4 = q(i14)) != null) {
            if (this.f1954u) {
                i15 = this.f1951r.g() - this.f1951r.b(q4);
                e5 = this.f1958y;
            } else {
                e5 = this.f1951r.e(q4) - this.f1951r.k();
                i15 = this.f1958y;
            }
            int i19 = i15 - e5;
            if (i19 > 0) {
                k6 += i19;
            } else {
                h4 -= i19;
            }
        }
        if (!wVar.f2305d ? !this.f1954u : this.f1954u) {
            i17 = 1;
        }
        U0(b1Var, i1Var, wVar, i17);
        p(b1Var);
        y yVar2 = this.f1950q;
        if (this.f1951r.i() == 0 && this.f1951r.f() == 0) {
            z6 = true;
        } else {
            z6 = false;
        }
        yVar2.f2328l = z6;
        this.f1950q.getClass();
        this.f1950q.f2325i = 0;
        if (wVar.f2305d) {
            d1(wVar.f2303b, wVar.f2304c);
            y yVar3 = this.f1950q;
            yVar3.f2324h = k6;
            G0(b1Var, yVar3, i1Var, false);
            y yVar4 = this.f1950q;
            i11 = yVar4.f2318b;
            int i20 = yVar4.f2320d;
            int i21 = yVar4.f2319c;
            if (i21 > 0) {
                h4 += i21;
            }
            c1(wVar.f2303b, wVar.f2304c);
            y yVar5 = this.f1950q;
            yVar5.f2324h = h4;
            yVar5.f2320d += yVar5.f2321e;
            G0(b1Var, yVar5, i1Var, false);
            y yVar6 = this.f1950q;
            i10 = yVar6.f2318b;
            int i22 = yVar6.f2319c;
            if (i22 > 0) {
                d1(i20, i11);
                y yVar7 = this.f1950q;
                yVar7.f2324h = i22;
                G0(b1Var, yVar7, i1Var, false);
                i11 = this.f1950q.f2318b;
            }
        } else {
            c1(wVar.f2303b, wVar.f2304c);
            y yVar8 = this.f1950q;
            yVar8.f2324h = h4;
            G0(b1Var, yVar8, i1Var, false);
            y yVar9 = this.f1950q;
            i10 = yVar9.f2318b;
            int i23 = yVar9.f2320d;
            int i24 = yVar9.f2319c;
            if (i24 > 0) {
                k6 += i24;
            }
            d1(wVar.f2303b, wVar.f2304c);
            y yVar10 = this.f1950q;
            yVar10.f2324h = k6;
            yVar10.f2320d += yVar10.f2321e;
            G0(b1Var, yVar10, i1Var, false);
            y yVar11 = this.f1950q;
            i11 = yVar11.f2318b;
            int i25 = yVar11.f2319c;
            if (i25 > 0) {
                c1(i23, i10);
                y yVar12 = this.f1950q;
                yVar12.f2324h = i25;
                G0(b1Var, yVar12, i1Var, false);
                i10 = this.f1950q.f2318b;
            }
        }
        if (v() > 0) {
            if (this.f1954u ^ this.f1955v) {
                int O02 = O0(i10, b1Var, i1Var, true);
                i12 = i11 + O02;
                i13 = i10 + O02;
                O0 = P0(i12, b1Var, i1Var, false);
            } else {
                int P0 = P0(i11, b1Var, i1Var, true);
                i12 = i11 + P0;
                i13 = i10 + P0;
                O0 = O0(i13, b1Var, i1Var, false);
            }
            i11 = i12 + O0;
            i10 = i13 + O0;
        }
        if (i1Var.f2136k && v() != 0 && !i1Var.f2132g && y0()) {
            List list2 = b1Var.f2064d;
            int size = list2.size();
            int F = u0.F(u(0));
            int i26 = 0;
            int i27 = 0;
            for (int i28 = 0; i28 < size; i28++) {
                l1 l1Var = (l1) list2.get(i28);
                if (!l1Var.j()) {
                    if (l1Var.c() < F) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    boolean z10 = this.f1954u;
                    View view = l1Var.f2170a;
                    if (z7 != z10) {
                        i26 += this.f1951r.c(view);
                    } else {
                        i27 += this.f1951r.c(view);
                    }
                }
            }
            this.f1950q.f2327k = list2;
            if (i26 > 0) {
                d1(u0.F(R0()), i11);
                y yVar13 = this.f1950q;
                yVar13.f2324h = i26;
                yVar13.f2319c = 0;
                yVar13.a(null);
                G0(b1Var, this.f1950q, i1Var, false);
            }
            if (i27 > 0) {
                c1(u0.F(Q0()), i10);
                y yVar14 = this.f1950q;
                yVar14.f2324h = i27;
                yVar14.f2319c = 0;
                list = null;
                yVar14.a(null);
                G0(b1Var, this.f1950q, i1Var, false);
            } else {
                list = null;
            }
            this.f1950q.f2327k = list;
        }
        if (!i1Var.f2132g) {
            d0 d0Var = this.f1951r;
            d0Var.f2075b = d0Var.l();
        } else {
            wVar.d();
        }
        this.f1952s = this.f1955v;
    }

    public final void Z0(int i4) {
        if (i4 != 0 && i4 != 1) {
            throw new IllegalArgumentException(androidx.activity.j.b("invalid orientation:", i4));
        }
        c(null);
        if (i4 != this.f1949p || this.f1951r == null) {
            d0 a5 = d0.a(this, i4);
            this.f1951r = a5;
            this.A.f2302a = a5;
            this.f1949p = i4;
            k0();
        }
    }

    @Override // androidx.recyclerview.widget.g1
    public final PointF a(int i4) {
        if (v() == 0) {
            return null;
        }
        int i5 = (i4 < u0.F(u(0))) != this.f1954u ? -1 : 1;
        return this.f1949p == 0 ? new PointF(i5, 0.0f) : new PointF(0.0f, i5);
    }

    @Override // androidx.recyclerview.widget.u0
    public void a0(i1 i1Var) {
        this.f1959z = null;
        this.f1957x = -1;
        this.f1958y = Integer.MIN_VALUE;
        this.A.d();
    }

    public void a1(boolean z4) {
        c(null);
        if (this.f1955v == z4) {
            return;
        }
        this.f1955v = z4;
        k0();
    }

    @Override // androidx.recyclerview.widget.u0
    public final void b0(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.f1959z = (SavedState) parcelable;
            k0();
        }
    }

    public final void b1(int i4, int i5, boolean z4, i1 i1Var) {
        boolean z5;
        int i6;
        int k4;
        y yVar = this.f1950q;
        boolean z6 = false;
        int i7 = 1;
        if (this.f1951r.i() == 0 && this.f1951r.f() == 0) {
            z5 = true;
        } else {
            z5 = false;
        }
        yVar.f2328l = z5;
        this.f1950q.f2322f = i4;
        int[] iArr = this.D;
        iArr[0] = 0;
        iArr[1] = 0;
        z0(i1Var, iArr);
        int max = Math.max(0, iArr[0]);
        int max2 = Math.max(0, iArr[1]);
        if (i4 == 1) {
            z6 = true;
        }
        y yVar2 = this.f1950q;
        if (z6) {
            i6 = max2;
        } else {
            i6 = max;
        }
        yVar2.f2324h = i6;
        if (!z6) {
            max = max2;
        }
        yVar2.f2325i = max;
        if (z6) {
            yVar2.f2324h = this.f1951r.h() + i6;
            View Q0 = Q0();
            y yVar3 = this.f1950q;
            if (this.f1954u) {
                i7 = -1;
            }
            yVar3.f2321e = i7;
            int F = u0.F(Q0);
            y yVar4 = this.f1950q;
            yVar3.f2320d = F + yVar4.f2321e;
            yVar4.f2318b = this.f1951r.b(Q0);
            k4 = this.f1951r.b(Q0) - this.f1951r.g();
        } else {
            View R0 = R0();
            y yVar5 = this.f1950q;
            yVar5.f2324h = this.f1951r.k() + yVar5.f2324h;
            y yVar6 = this.f1950q;
            if (!this.f1954u) {
                i7 = -1;
            }
            yVar6.f2321e = i7;
            int F2 = u0.F(R0);
            y yVar7 = this.f1950q;
            yVar6.f2320d = F2 + yVar7.f2321e;
            yVar7.f2318b = this.f1951r.e(R0);
            k4 = (-this.f1951r.e(R0)) + this.f1951r.k();
        }
        y yVar8 = this.f1950q;
        yVar8.f2319c = i5;
        if (z4) {
            yVar8.f2319c = i5 - k4;
        }
        yVar8.f2323g = k4;
    }

    @Override // androidx.recyclerview.widget.u0
    public final void c(String str) {
        if (this.f1959z == null) {
            super.c(str);
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [android.os.Parcelable, androidx.recyclerview.widget.LinearLayoutManager$SavedState, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v9, types: [android.os.Parcelable, androidx.recyclerview.widget.LinearLayoutManager$SavedState, java.lang.Object] */
    @Override // androidx.recyclerview.widget.u0
    public final Parcelable c0() {
        SavedState savedState = this.f1959z;
        if (savedState != null) {
            ?? obj = new Object();
            obj.f1960a = savedState.f1960a;
            obj.f1961b = savedState.f1961b;
            obj.f1962c = savedState.f1962c;
            return obj;
        }
        ?? obj2 = new Object();
        if (v() > 0) {
            F0();
            boolean z4 = this.f1952s ^ this.f1954u;
            obj2.f1962c = z4;
            if (z4) {
                View Q0 = Q0();
                obj2.f1961b = this.f1951r.g() - this.f1951r.b(Q0);
                obj2.f1960a = u0.F(Q0);
            } else {
                View R0 = R0();
                obj2.f1960a = u0.F(R0);
                obj2.f1961b = this.f1951r.e(R0) - this.f1951r.k();
            }
        } else {
            obj2.f1960a = -1;
        }
        return obj2;
    }

    public final void c1(int i4, int i5) {
        this.f1950q.f2319c = this.f1951r.g() - i5;
        y yVar = this.f1950q;
        yVar.f2321e = this.f1954u ? -1 : 1;
        yVar.f2320d = i4;
        yVar.f2322f = 1;
        yVar.f2318b = i5;
        yVar.f2323g = Integer.MIN_VALUE;
    }

    @Override // androidx.recyclerview.widget.u0
    public final boolean d() {
        return this.f1949p == 0;
    }

    public final void d1(int i4, int i5) {
        this.f1950q.f2319c = i5 - this.f1951r.k();
        y yVar = this.f1950q;
        yVar.f2320d = i4;
        yVar.f2321e = this.f1954u ? 1 : -1;
        yVar.f2322f = -1;
        yVar.f2318b = i5;
        yVar.f2323g = Integer.MIN_VALUE;
    }

    @Override // androidx.recyclerview.widget.u0
    public final boolean e() {
        return this.f1949p == 1;
    }

    @Override // androidx.recyclerview.widget.u0
    public final void h(int i4, int i5, i1 i1Var, r rVar) {
        int i6;
        if (this.f1949p != 0) {
            i4 = i5;
        }
        if (v() != 0 && i4 != 0) {
            F0();
            if (i4 > 0) {
                i6 = 1;
            } else {
                i6 = -1;
            }
            b1(i6, Math.abs(i4), true, i1Var);
            A0(i1Var, this.f1950q, rVar);
        }
    }

    @Override // androidx.recyclerview.widget.u0
    public final void i(int i4, r rVar) {
        boolean z4;
        int i5;
        SavedState savedState = this.f1959z;
        int i6 = -1;
        if (savedState != null && (i5 = savedState.f1960a) >= 0) {
            z4 = savedState.f1962c;
        } else {
            X0();
            z4 = this.f1954u;
            i5 = this.f1957x;
            if (i5 == -1) {
                i5 = z4 ? i4 - 1 : 0;
            }
        }
        if (!z4) {
            i6 = 1;
        }
        for (int i7 = 0; i7 < this.C && i5 >= 0 && i5 < i4; i7++) {
            rVar.a(i5, 0);
            i5 += i6;
        }
    }

    @Override // androidx.recyclerview.widget.u0
    public final int j(i1 i1Var) {
        return B0(i1Var);
    }

    @Override // androidx.recyclerview.widget.u0
    public int k(i1 i1Var) {
        return C0(i1Var);
    }

    @Override // androidx.recyclerview.widget.u0
    public int l(i1 i1Var) {
        return D0(i1Var);
    }

    @Override // androidx.recyclerview.widget.u0
    public int l0(int i4, b1 b1Var, i1 i1Var) {
        if (this.f1949p == 1) {
            return 0;
        }
        return Y0(i4, b1Var, i1Var);
    }

    @Override // androidx.recyclerview.widget.u0
    public final int m(i1 i1Var) {
        return B0(i1Var);
    }

    @Override // androidx.recyclerview.widget.u0
    public final void m0(int i4) {
        this.f1957x = i4;
        this.f1958y = Integer.MIN_VALUE;
        SavedState savedState = this.f1959z;
        if (savedState != null) {
            savedState.f1960a = -1;
        }
        k0();
    }

    @Override // androidx.recyclerview.widget.u0
    public int n(i1 i1Var) {
        return C0(i1Var);
    }

    @Override // androidx.recyclerview.widget.u0
    public int n0(int i4, b1 b1Var, i1 i1Var) {
        if (this.f1949p == 0) {
            return 0;
        }
        return Y0(i4, b1Var, i1Var);
    }

    @Override // androidx.recyclerview.widget.u0
    public int o(i1 i1Var) {
        return D0(i1Var);
    }

    @Override // androidx.recyclerview.widget.u0
    public final View q(int i4) {
        int v2 = v();
        if (v2 == 0) {
            return null;
        }
        int F = i4 - u0.F(u(0));
        if (F >= 0 && F < v2) {
            View u4 = u(F);
            if (u0.F(u4) == i4) {
                return u4;
            }
        }
        return super.q(i4);
    }

    @Override // androidx.recyclerview.widget.u0
    public RecyclerView.LayoutParams r() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    @Override // androidx.recyclerview.widget.u0
    public final boolean u0() {
        if (this.f2285m == 1073741824 || this.f2284l == 1073741824) {
            return false;
        }
        int v2 = v();
        for (int i4 = 0; i4 < v2; i4++) {
            ViewGroup.LayoutParams layoutParams = u(i4).getLayoutParams();
            if (layoutParams.width < 0 && layoutParams.height < 0) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.u0
    public void w0(RecyclerView recyclerView, int i4) {
        a0 a0Var = new a0(recyclerView.getContext());
        a0Var.f2111a = i4;
        x0(a0Var);
    }

    @Override // androidx.recyclerview.widget.u0
    public boolean y0() {
        return this.f1959z == null && this.f1952s == this.f1955v;
    }

    public void z0(i1 i1Var, int[] iArr) {
        int i4;
        int i5;
        if (i1Var.f2126a != -1) {
            i4 = this.f1951r.l();
        } else {
            i4 = 0;
        }
        if (this.f1950q.f2322f == -1) {
            i5 = 0;
        } else {
            i5 = i4;
            i4 = 0;
        }
        iArr[0] = i4;
        iArr[1] = i5;
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [androidx.recyclerview.widget.x, java.lang.Object] */
    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i4, int i5) {
        this.f1949p = 1;
        this.f1953t = false;
        this.f1954u = false;
        this.f1955v = false;
        this.f1956w = true;
        this.f1957x = -1;
        this.f1958y = Integer.MIN_VALUE;
        this.f1959z = null;
        this.A = new w();
        this.B = new Object();
        this.C = 2;
        this.D = new int[2];
        t0 G = u0.G(context, attributeSet, i4, i5);
        Z0(G.f2261a);
        boolean z4 = G.f2263c;
        c(null);
        if (z4 != this.f1953t) {
            this.f1953t = z4;
            k0();
        }
        a1(G.f2264d);
    }
}