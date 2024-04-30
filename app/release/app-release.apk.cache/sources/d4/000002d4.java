package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class GridLayoutManager extends LinearLayoutManager {
    public boolean E;
    public int F;
    public int[] G;
    public View[] H;
    public final SparseIntArray I;
    public final SparseIntArray J;
    public final u K;
    public final Rect L;

    /* loaded from: classes.dex */
    public static class LayoutParams extends RecyclerView.LayoutParams {

        /* renamed from: e  reason: collision with root package name */
        public int f1947e;

        /* renamed from: f  reason: collision with root package name */
        public int f1948f;

        public LayoutParams(int i4, int i5) {
            super(i4, i5);
            this.f1947e = -1;
            this.f1948f = 0;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f1947e = -1;
            this.f1948f = 0;
        }
    }

    public GridLayoutManager(int i4) {
        super(1);
        this.E = false;
        this.F = -1;
        this.I = new SparseIntArray();
        this.J = new SparseIntArray();
        this.K = new u();
        this.L = new Rect();
        l1(i4);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final void A0(i1 i1Var, y yVar, r rVar) {
        int i4;
        int i5 = this.F;
        for (int i6 = 0; i6 < this.F && (i4 = yVar.f2320d) >= 0 && i4 < i1Var.b() && i5 > 0; i6++) {
            rVar.a(yVar.f2320d, Math.max(0, yVar.f2323g));
            this.K.getClass();
            i5--;
            yVar.f2320d += yVar.f2321e;
        }
    }

    @Override // androidx.recyclerview.widget.u0
    public final int H(b1 b1Var, i1 i1Var) {
        if (this.f1949p == 0) {
            return this.F;
        }
        if (i1Var.b() < 1) {
            return 0;
        }
        return h1(i1Var.b() - 1, b1Var, i1Var) + 1;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final View N0(b1 b1Var, i1 i1Var, int i4, int i5, int i6) {
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
            if (F >= 0 && F < i6 && i1(F, b1Var, i1Var) == 0) {
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

    /* JADX WARN: Code restructure failed: missing block: B:63:0x00dd, code lost:
        if (r13 == r5) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0109, code lost:
        if (r13 == r5) goto L51;
     */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0124  */
    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.u0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.view.View P(android.view.View r23, int r24, androidx.recyclerview.widget.b1 r25, androidx.recyclerview.widget.i1 r26) {
        /*
            Method dump skipped, instructions count: 329
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.P(android.view.View, int, androidx.recyclerview.widget.b1, androidx.recyclerview.widget.i1):android.view.View");
    }

    @Override // androidx.recyclerview.widget.u0
    public final void T(b1 b1Var, i1 i1Var, View view, j0.h hVar) {
        int i4;
        int i5;
        boolean z4;
        int i6;
        boolean z5;
        int i7;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof LayoutParams)) {
            S(view, hVar);
            return;
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        int h12 = h1(layoutParams2.f2011a.c(), b1Var, i1Var);
        if (this.f1949p == 0) {
            i7 = layoutParams2.f1947e;
            i6 = layoutParams2.f1948f;
            z4 = false;
            i5 = 1;
            z5 = false;
            i4 = h12;
        } else {
            i4 = layoutParams2.f1947e;
            i5 = layoutParams2.f1948f;
            z4 = false;
            i6 = 1;
            z5 = false;
            i7 = h12;
        }
        hVar.h(i0.i(i7, i6, i4, i5, z5, z4));
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x009f, code lost:
        r22.f2312b = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00a1, code lost:
        return;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v21 */
    /* JADX WARN: Type inference failed for: r8v22, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r8v30 */
    /* JADX WARN: Type inference failed for: r8v31 */
    /* JADX WARN: Type inference failed for: r8v36 */
    @Override // androidx.recyclerview.widget.LinearLayoutManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void T0(androidx.recyclerview.widget.b1 r19, androidx.recyclerview.widget.i1 r20, androidx.recyclerview.widget.y r21, androidx.recyclerview.widget.x r22) {
        /*
            Method dump skipped, instructions count: 642
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.T0(androidx.recyclerview.widget.b1, androidx.recyclerview.widget.i1, androidx.recyclerview.widget.y, androidx.recyclerview.widget.x):void");
    }

    @Override // androidx.recyclerview.widget.u0
    public final void U(int i4, int i5) {
        u uVar = this.K;
        uVar.b();
        uVar.f2272b.clear();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final void U0(b1 b1Var, i1 i1Var, w wVar, int i4) {
        boolean z4;
        m1();
        if (i1Var.b() > 0 && !i1Var.f2132g) {
            if (i4 == 1) {
                z4 = true;
            } else {
                z4 = false;
            }
            int i12 = i1(wVar.f2303b, b1Var, i1Var);
            if (z4) {
                while (i12 > 0) {
                    int i5 = wVar.f2303b;
                    if (i5 <= 0) {
                        break;
                    }
                    int i6 = i5 - 1;
                    wVar.f2303b = i6;
                    i12 = i1(i6, b1Var, i1Var);
                }
            } else {
                int b5 = i1Var.b() - 1;
                int i7 = wVar.f2303b;
                while (i7 < b5) {
                    int i8 = i7 + 1;
                    int i13 = i1(i8, b1Var, i1Var);
                    if (i13 <= i12) {
                        break;
                    }
                    i7 = i8;
                    i12 = i13;
                }
                wVar.f2303b = i7;
            }
        }
        f1();
    }

    @Override // androidx.recyclerview.widget.u0
    public final void V() {
        u uVar = this.K;
        uVar.b();
        uVar.f2272b.clear();
    }

    @Override // androidx.recyclerview.widget.u0
    public final void W(int i4, int i5) {
        u uVar = this.K;
        uVar.b();
        uVar.f2272b.clear();
    }

    @Override // androidx.recyclerview.widget.u0
    public final void X(int i4, int i5) {
        u uVar = this.K;
        uVar.b();
        uVar.f2272b.clear();
    }

    @Override // androidx.recyclerview.widget.u0
    public final void Y(int i4, int i5) {
        u uVar = this.K;
        uVar.b();
        uVar.f2272b.clear();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.u0
    public final void Z(b1 b1Var, i1 i1Var) {
        boolean z4 = i1Var.f2132g;
        SparseIntArray sparseIntArray = this.J;
        SparseIntArray sparseIntArray2 = this.I;
        if (z4) {
            int v2 = v();
            for (int i4 = 0; i4 < v2; i4++) {
                LayoutParams layoutParams = (LayoutParams) u(i4).getLayoutParams();
                int c4 = layoutParams.f2011a.c();
                sparseIntArray2.put(c4, layoutParams.f1948f);
                sparseIntArray.put(c4, layoutParams.f1947e);
            }
        }
        super.Z(b1Var, i1Var);
        sparseIntArray2.clear();
        sparseIntArray.clear();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.u0
    public final void a0(i1 i1Var) {
        super.a0(i1Var);
        this.E = false;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final void a1(boolean z4) {
        if (z4) {
            throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
        }
        super.a1(false);
    }

    public final void e1(int i4) {
        int i5;
        int[] iArr = this.G;
        int i6 = this.F;
        if (iArr == null || iArr.length != i6 + 1 || iArr[iArr.length - 1] != i4) {
            iArr = new int[i6 + 1];
        }
        int i7 = 0;
        iArr[0] = 0;
        int i8 = i4 / i6;
        int i9 = i4 % i6;
        int i10 = 0;
        for (int i11 = 1; i11 <= i6; i11++) {
            i7 += i9;
            if (i7 > 0 && i6 - i7 < i9) {
                i5 = i8 + 1;
                i7 -= i6;
            } else {
                i5 = i8;
            }
            i10 += i5;
            iArr[i11] = i10;
        }
        this.G = iArr;
    }

    @Override // androidx.recyclerview.widget.u0
    public final boolean f(RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public final void f1() {
        View[] viewArr = this.H;
        if (viewArr == null || viewArr.length != this.F) {
            this.H = new View[this.F];
        }
    }

    public final int g1(int i4, int i5) {
        if (this.f1949p != 1 || !S0()) {
            int[] iArr = this.G;
            return iArr[i5 + i4] - iArr[i4];
        }
        int[] iArr2 = this.G;
        int i6 = this.F;
        return iArr2[i6 - i4] - iArr2[(i6 - i4) - i5];
    }

    public final int h1(int i4, b1 b1Var, i1 i1Var) {
        boolean z4 = i1Var.f2132g;
        u uVar = this.K;
        if (!z4) {
            int i5 = this.F;
            uVar.getClass();
            return u.a(i4, i5);
        }
        int b5 = b1Var.b(i4);
        if (b5 == -1) {
            Log.w("GridLayoutManager", "Cannot find span size for pre layout position. " + i4);
            return 0;
        }
        int i6 = this.F;
        uVar.getClass();
        return u.a(b5, i6);
    }

    public final int i1(int i4, b1 b1Var, i1 i1Var) {
        boolean z4 = i1Var.f2132g;
        u uVar = this.K;
        if (!z4) {
            int i5 = this.F;
            uVar.getClass();
            return i4 % i5;
        }
        int i6 = this.J.get(i4, -1);
        if (i6 != -1) {
            return i6;
        }
        int b5 = b1Var.b(i4);
        if (b5 == -1) {
            Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i4);
            return 0;
        }
        int i7 = this.F;
        uVar.getClass();
        return b5 % i7;
    }

    public final int j1(int i4, b1 b1Var, i1 i1Var) {
        boolean z4 = i1Var.f2132g;
        u uVar = this.K;
        if (!z4) {
            uVar.getClass();
            return 1;
        }
        int i5 = this.I.get(i4, -1);
        if (i5 != -1) {
            return i5;
        }
        if (b1Var.b(i4) == -1) {
            Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i4);
            return 1;
        }
        uVar.getClass();
        return 1;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.u0
    public final int k(i1 i1Var) {
        return C0(i1Var);
    }

    public final void k1(View view, int i4, boolean z4) {
        int i5;
        int i6;
        boolean t02;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Rect rect = layoutParams.f2012b;
        int i7 = rect.top + rect.bottom + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        int i8 = rect.left + rect.right + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
        int g12 = g1(layoutParams.f1947e, layoutParams.f1948f);
        if (this.f1949p == 1) {
            i6 = u0.w(false, g12, i4, i8, ((ViewGroup.MarginLayoutParams) layoutParams).width);
            i5 = u0.w(true, this.f1951r.l(), this.f2285m, i7, ((ViewGroup.MarginLayoutParams) layoutParams).height);
        } else {
            int w4 = u0.w(false, g12, i4, i7, ((ViewGroup.MarginLayoutParams) layoutParams).height);
            int w5 = u0.w(true, this.f1951r.l(), this.f2284l, i8, ((ViewGroup.MarginLayoutParams) layoutParams).width);
            i5 = w4;
            i6 = w5;
        }
        RecyclerView.LayoutParams layoutParams2 = (RecyclerView.LayoutParams) view.getLayoutParams();
        if (z4) {
            t02 = v0(view, i6, i5, layoutParams2);
        } else {
            t02 = t0(view, i6, i5, layoutParams2);
        }
        if (t02) {
            view.measure(i6, i5);
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.u0
    public final int l(i1 i1Var) {
        return D0(i1Var);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.u0
    public final int l0(int i4, b1 b1Var, i1 i1Var) {
        m1();
        f1();
        return super.l0(i4, b1Var, i1Var);
    }

    public final void l1(int i4) {
        if (i4 == this.F) {
            return;
        }
        this.E = true;
        if (i4 >= 1) {
            this.F = i4;
            this.K.b();
            k0();
            return;
        }
        throw new IllegalArgumentException(androidx.activity.j.b("Span count should be at least 1. Provided ", i4));
    }

    public final void m1() {
        int B;
        int E;
        if (this.f1949p == 1) {
            B = this.f2286n - D();
            E = C();
        } else {
            B = this.f2287o - B();
            E = E();
        }
        e1(B - E);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.u0
    public final int n(i1 i1Var) {
        return C0(i1Var);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.u0
    public final int n0(int i4, b1 b1Var, i1 i1Var) {
        m1();
        f1();
        return super.n0(i4, b1Var, i1Var);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.u0
    public final int o(i1 i1Var) {
        return D0(i1Var);
    }

    @Override // androidx.recyclerview.widget.u0
    public final void q0(Rect rect, int i4, int i5) {
        int g4;
        int g5;
        if (this.G == null) {
            super.q0(rect, i4, i5);
        }
        int D = D() + C();
        int B = B() + E();
        if (this.f1949p == 1) {
            int height = rect.height() + B;
            RecyclerView recyclerView = this.f2274b;
            WeakHashMap weakHashMap = i0.y0.f4999a;
            g5 = u0.g(i5, height, i0.g0.d(recyclerView));
            int[] iArr = this.G;
            g4 = u0.g(i4, iArr[iArr.length - 1] + D, i0.g0.e(this.f2274b));
        } else {
            int width = rect.width() + D;
            RecyclerView recyclerView2 = this.f2274b;
            WeakHashMap weakHashMap2 = i0.y0.f4999a;
            g4 = u0.g(i4, width, i0.g0.e(recyclerView2));
            int[] iArr2 = this.G;
            g5 = u0.g(i5, iArr2[iArr2.length - 1] + B, i0.g0.d(this.f2274b));
        }
        this.f2274b.setMeasuredDimension(g4, g5);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.u0
    public final RecyclerView.LayoutParams r() {
        return this.f1949p == 0 ? new LayoutParams(-2, -1) : new LayoutParams(-1, -2);
    }

    @Override // androidx.recyclerview.widget.u0
    public final RecyclerView.LayoutParams s(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [androidx.recyclerview.widget.GridLayoutManager$LayoutParams, androidx.recyclerview.widget.RecyclerView$LayoutParams] */
    /* JADX WARN: Type inference failed for: r0v2, types: [androidx.recyclerview.widget.GridLayoutManager$LayoutParams, androidx.recyclerview.widget.RecyclerView$LayoutParams] */
    @Override // androidx.recyclerview.widget.u0
    public final RecyclerView.LayoutParams t(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ?? layoutParams2 = new RecyclerView.LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
            layoutParams2.f1947e = -1;
            layoutParams2.f1948f = 0;
            return layoutParams2;
        }
        ?? layoutParams3 = new RecyclerView.LayoutParams(layoutParams);
        layoutParams3.f1947e = -1;
        layoutParams3.f1948f = 0;
        return layoutParams3;
    }

    @Override // androidx.recyclerview.widget.u0
    public final int x(b1 b1Var, i1 i1Var) {
        if (this.f1949p == 1) {
            return this.F;
        }
        if (i1Var.b() < 1) {
            return 0;
        }
        return h1(i1Var.b() - 1, b1Var, i1Var) + 1;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.u0
    public final boolean y0() {
        return this.f1959z == null && !this.E;
    }

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i4, int i5) {
        super(context, attributeSet, i4, i5);
        this.E = false;
        this.F = -1;
        this.I = new SparseIntArray();
        this.J = new SparseIntArray();
        this.K = new u();
        this.L = new Rect();
        l1(u0.G(context, attributeSet, i4, i5).f2262b);
    }
}