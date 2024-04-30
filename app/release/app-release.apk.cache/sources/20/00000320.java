package androidx.recyclerview.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public abstract class u0 {

    /* renamed from: a  reason: collision with root package name */
    public d f2273a;

    /* renamed from: b  reason: collision with root package name */
    public RecyclerView f2274b;

    /* renamed from: c  reason: collision with root package name */
    public final x1 f2275c;

    /* renamed from: d  reason: collision with root package name */
    public final x1 f2276d;

    /* renamed from: e  reason: collision with root package name */
    public h1 f2277e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f2278f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f2279g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f2280h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f2281i;

    /* renamed from: j  reason: collision with root package name */
    public int f2282j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f2283k;

    /* renamed from: l  reason: collision with root package name */
    public int f2284l;

    /* renamed from: m  reason: collision with root package name */
    public int f2285m;

    /* renamed from: n  reason: collision with root package name */
    public int f2286n;

    /* renamed from: o  reason: collision with root package name */
    public int f2287o;

    public u0() {
        r0 r0Var = new r0(this);
        s0 s0Var = new s0(this);
        this.f2275c = new x1(r0Var);
        this.f2276d = new x1(s0Var);
        this.f2278f = false;
        this.f2279g = false;
        this.f2280h = true;
        this.f2281i = true;
    }

    public static int F(View view) {
        return ((RecyclerView.LayoutParams) view.getLayoutParams()).f2011a.c();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [androidx.recyclerview.widget.t0, java.lang.Object] */
    public static t0 G(Context context, AttributeSet attributeSet, int i4, int i5) {
        ?? obj = new Object();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, y0.a.f7148a, i4, i5);
        obj.f2261a = obtainStyledAttributes.getInt(0, 1);
        obj.f2262b = obtainStyledAttributes.getInt(10, 1);
        obj.f2263c = obtainStyledAttributes.getBoolean(9, false);
        obj.f2264d = obtainStyledAttributes.getBoolean(11, false);
        obtainStyledAttributes.recycle();
        return obj;
    }

    public static boolean K(int i4, int i5, int i6) {
        int mode = View.MeasureSpec.getMode(i5);
        int size = View.MeasureSpec.getSize(i5);
        if (i6 <= 0 || i4 == i6) {
            if (mode == Integer.MIN_VALUE) {
                return size >= i4;
            } else if (mode != 0) {
                return mode == 1073741824 && size == i4;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void L(View view, int i4, int i5, int i6, int i7) {
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        Rect rect = layoutParams.f2012b;
        view.layout(i4 + rect.left + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, i5 + rect.top + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, (i6 - rect.right) - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, (i7 - rect.bottom) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
    }

    public static int g(int i4, int i5, int i6) {
        int mode = View.MeasureSpec.getMode(i4);
        int size = View.MeasureSpec.getSize(i4);
        return mode != Integer.MIN_VALUE ? mode != 1073741824 ? Math.max(i5, i6) : size : Math.min(size, Math.max(i5, i6));
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0018, code lost:
        if (r6 == 1073741824) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int w(boolean r4, int r5, int r6, int r7, int r8) {
        /*
            int r5 = r5 - r7
            r7 = 0
            int r5 = java.lang.Math.max(r7, r5)
            r0 = -2
            r1 = -1
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = 1073741824(0x40000000, float:2.0)
            if (r4 == 0) goto L1d
            if (r8 < 0) goto L12
        L10:
            r6 = r3
            goto L30
        L12:
            if (r8 != r1) goto L1a
            if (r6 == r2) goto L22
            if (r6 == 0) goto L1a
            if (r6 == r3) goto L22
        L1a:
            r6 = r7
            r8 = r6
            goto L30
        L1d:
            if (r8 < 0) goto L20
            goto L10
        L20:
            if (r8 != r1) goto L24
        L22:
            r8 = r5
            goto L30
        L24:
            if (r8 != r0) goto L1a
            if (r6 == r2) goto L2e
            if (r6 != r3) goto L2b
            goto L2e
        L2b:
            r8 = r5
            r6 = r7
            goto L30
        L2e:
            r8 = r5
            r6 = r2
        L30:
            int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r8, r6)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.u0.w(boolean, int, int, int, int):int");
    }

    public final int A() {
        RecyclerView recyclerView = this.f2274b;
        WeakHashMap weakHashMap = i0.y0.f4999a;
        return i0.h0.d(recyclerView);
    }

    public final int B() {
        RecyclerView recyclerView = this.f2274b;
        if (recyclerView != null) {
            return recyclerView.getPaddingBottom();
        }
        return 0;
    }

    public final int C() {
        RecyclerView recyclerView = this.f2274b;
        if (recyclerView != null) {
            return recyclerView.getPaddingLeft();
        }
        return 0;
    }

    public final int D() {
        RecyclerView recyclerView = this.f2274b;
        if (recyclerView != null) {
            return recyclerView.getPaddingRight();
        }
        return 0;
    }

    public final int E() {
        RecyclerView recyclerView = this.f2274b;
        if (recyclerView != null) {
            return recyclerView.getPaddingTop();
        }
        return 0;
    }

    public int H(b1 b1Var, i1 i1Var) {
        RecyclerView recyclerView = this.f2274b;
        if (recyclerView == null || recyclerView.f1986k == null || !e()) {
            return 1;
        }
        return this.f2274b.f1986k.a();
    }

    public final void I(View view, Rect rect) {
        Matrix matrix;
        Rect rect2 = ((RecyclerView.LayoutParams) view.getLayoutParams()).f2012b;
        rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
        if (this.f2274b != null && (matrix = view.getMatrix()) != null && !matrix.isIdentity()) {
            RectF rectF = this.f2274b.f1984j;
            rectF.set(rect);
            matrix.mapRect(rectF);
            rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
        }
        rect.offset(view.getLeft(), view.getTop());
    }

    public boolean J() {
        return false;
    }

    public void M(int i4) {
        RecyclerView recyclerView = this.f2274b;
        if (recyclerView != null) {
            int e4 = recyclerView.f1974e.e();
            for (int i5 = 0; i5 < e4; i5++) {
                recyclerView.f1974e.d(i5).offsetLeftAndRight(i4);
            }
        }
    }

    public void N(int i4) {
        RecyclerView recyclerView = this.f2274b;
        if (recyclerView != null) {
            int e4 = recyclerView.f1974e.e();
            for (int i5 = 0; i5 < e4; i5++) {
                recyclerView.f1974e.d(i5).offsetTopAndBottom(i4);
            }
        }
    }

    public void O(RecyclerView recyclerView) {
    }

    public View P(View view, int i4, b1 b1Var, i1 i1Var) {
        return null;
    }

    public void Q(AccessibilityEvent accessibilityEvent) {
        RecyclerView recyclerView = this.f2274b;
        b1 b1Var = recyclerView.f1968b;
        i1 i1Var = recyclerView.f1973d0;
        if (recyclerView != null && accessibilityEvent != null) {
            boolean z4 = true;
            if (!recyclerView.canScrollVertically(1) && !this.f2274b.canScrollVertically(-1) && !this.f2274b.canScrollHorizontally(-1) && !this.f2274b.canScrollHorizontally(1)) {
                z4 = false;
            }
            accessibilityEvent.setScrollable(z4);
            j0 j0Var = this.f2274b.f1986k;
            if (j0Var != null) {
                accessibilityEvent.setItemCount(j0Var.a());
            }
        }
    }

    public void R(b1 b1Var, i1 i1Var, j0.h hVar) {
        if (this.f2274b.canScrollVertically(-1) || this.f2274b.canScrollHorizontally(-1)) {
            hVar.a(8192);
            hVar.j(true);
        }
        if (this.f2274b.canScrollVertically(1) || this.f2274b.canScrollHorizontally(1)) {
            hVar.a(4096);
            hVar.j(true);
        }
        hVar.f5093a.setCollectionInfo((AccessibilityNodeInfo.CollectionInfo) i0.h(H(b1Var, i1Var), x(b1Var, i1Var), 0).f2125a);
    }

    public final void S(View view, j0.h hVar) {
        l1 J = RecyclerView.J(view);
        if (J != null && !J.j() && !this.f2273a.f2073c.contains(J.f2170a)) {
            RecyclerView recyclerView = this.f2274b;
            T(recyclerView.f1968b, recyclerView.f1973d0, view, hVar);
        }
    }

    public void T(b1 b1Var, i1 i1Var, View view, j0.h hVar) {
        int i4;
        int i5 = 0;
        if (e()) {
            i4 = F(view);
        } else {
            i4 = 0;
        }
        if (d()) {
            i5 = F(view);
        }
        hVar.h(i0.i(i4, 1, i5, 1, false, false));
    }

    public void U(int i4, int i5) {
    }

    public void V() {
    }

    public void W(int i4, int i5) {
    }

    public void X(int i4, int i5) {
    }

    public void Y(int i4, int i5) {
    }

    public abstract void Z(b1 b1Var, i1 i1Var);

    public abstract void a0(i1 i1Var);

    /* JADX WARN: Removed duplicated region for block: B:24:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00bd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void b(android.view.View r7, int r8, boolean r9) {
        /*
            Method dump skipped, instructions count: 301
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.u0.b(android.view.View, int, boolean):void");
    }

    public void b0(Parcelable parcelable) {
    }

    public void c(String str) {
        RecyclerView recyclerView = this.f2274b;
        if (recyclerView != null) {
            recyclerView.i(str);
        }
    }

    public Parcelable c0() {
        return null;
    }

    public abstract boolean d();

    public void d0(int i4) {
    }

    public abstract boolean e();

    public boolean e0(b1 b1Var, i1 i1Var, int i4, Bundle bundle) {
        int i5;
        int C;
        RecyclerView recyclerView = this.f2274b;
        if (recyclerView == null) {
            return false;
        }
        if (i4 != 4096) {
            if (i4 != 8192) {
                i5 = 0;
                C = 0;
            } else {
                if (recyclerView.canScrollVertically(-1)) {
                    i5 = -((this.f2287o - E()) - B());
                } else {
                    i5 = 0;
                }
                if (this.f2274b.canScrollHorizontally(-1)) {
                    C = -((this.f2286n - C()) - D());
                }
                C = 0;
            }
        } else {
            if (recyclerView.canScrollVertically(1)) {
                i5 = (this.f2287o - E()) - B();
            } else {
                i5 = 0;
            }
            if (this.f2274b.canScrollHorizontally(1)) {
                C = (this.f2286n - C()) - D();
            }
            C = 0;
        }
        if (i5 == 0 && C == 0) {
            return false;
        }
        this.f2274b.c0(C, i5, true);
        return true;
    }

    public boolean f(RecyclerView.LayoutParams layoutParams) {
        return layoutParams != null;
    }

    public final void f0(b1 b1Var) {
        for (int v2 = v() - 1; v2 >= 0; v2--) {
            if (!RecyclerView.J(u(v2)).q()) {
                View u4 = u(v2);
                i0(v2);
                b1Var.f(u4);
            }
        }
    }

    public final void g0(b1 b1Var) {
        ArrayList arrayList;
        int size = b1Var.f2061a.size();
        int i4 = size - 1;
        while (true) {
            arrayList = b1Var.f2061a;
            if (i4 < 0) {
                break;
            }
            View view = ((l1) arrayList.get(i4)).f2170a;
            l1 J = RecyclerView.J(view);
            if (!J.q()) {
                J.p(false);
                if (J.l()) {
                    this.f2274b.removeDetachedView(view, false);
                }
                p0 p0Var = this.f2274b.I;
                if (p0Var != null) {
                    p0Var.d(J);
                }
                J.p(true);
                l1 J2 = RecyclerView.J(view);
                J2.f2183n = null;
                J2.f2184o = false;
                J2.f2179j &= -33;
                b1Var.g(J2);
            }
            i4--;
        }
        arrayList.clear();
        ArrayList arrayList2 = b1Var.f2062b;
        if (arrayList2 != null) {
            arrayList2.clear();
        }
        if (size > 0) {
            this.f2274b.invalidate();
        }
    }

    public void h(int i4, int i5, i1 i1Var, r rVar) {
    }

    public final void h0(View view, b1 b1Var) {
        d dVar = this.f2273a;
        i0 i0Var = dVar.f2071a;
        int indexOfChild = ((RecyclerView) i0Var.f2125a).indexOfChild(view);
        if (indexOfChild >= 0) {
            if (dVar.f2072b.f(indexOfChild)) {
                dVar.i(view);
            }
            i0Var.o(indexOfChild);
        }
        b1Var.f(view);
    }

    public void i(int i4, r rVar) {
    }

    public final void i0(int i4) {
        d dVar;
        int f4;
        i0 i0Var;
        View e4;
        if (u(i4) != null && (e4 = (i0Var = dVar.f2071a).e((f4 = (dVar = this.f2273a).f(i4)))) != null) {
            if (dVar.f2072b.f(f4)) {
                dVar.i(e4);
            }
            i0Var.o(f4);
        }
    }

    public abstract int j(i1 i1Var);

    /* JADX WARN: Code restructure failed: missing block: B:25:0x00a3, code lost:
        if ((r5.bottom - r1) > r13) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean j0(androidx.recyclerview.widget.RecyclerView r9, android.view.View r10, android.graphics.Rect r11, boolean r12, boolean r13) {
        /*
            r8 = this;
            int r0 = r8.C()
            int r1 = r8.E()
            int r2 = r8.f2286n
            int r3 = r8.D()
            int r2 = r2 - r3
            int r3 = r8.f2287o
            int r4 = r8.B()
            int r3 = r3 - r4
            int r4 = r10.getLeft()
            int r5 = r11.left
            int r4 = r4 + r5
            int r5 = r10.getScrollX()
            int r4 = r4 - r5
            int r5 = r10.getTop()
            int r6 = r11.top
            int r5 = r5 + r6
            int r10 = r10.getScrollY()
            int r5 = r5 - r10
            int r10 = r11.width()
            int r10 = r10 + r4
            int r11 = r11.height()
            int r11 = r11 + r5
            int r4 = r4 - r0
            r0 = 0
            int r6 = java.lang.Math.min(r0, r4)
            int r5 = r5 - r1
            int r1 = java.lang.Math.min(r0, r5)
            int r10 = r10 - r2
            int r2 = java.lang.Math.max(r0, r10)
            int r11 = r11 - r3
            int r11 = java.lang.Math.max(r0, r11)
            int r3 = r8.A()
            r7 = 1
            if (r3 != r7) goto L5c
            if (r2 == 0) goto L57
            goto L64
        L57:
            int r2 = java.lang.Math.max(r6, r10)
            goto L64
        L5c:
            if (r6 == 0) goto L5f
            goto L63
        L5f:
            int r6 = java.lang.Math.min(r4, r2)
        L63:
            r2 = r6
        L64:
            if (r1 == 0) goto L67
            goto L6b
        L67:
            int r1 = java.lang.Math.min(r5, r11)
        L6b:
            if (r13 == 0) goto La6
            android.view.View r10 = r9.getFocusedChild()
            if (r10 != 0) goto L74
            goto Lab
        L74:
            int r11 = r8.C()
            int r13 = r8.E()
            int r3 = r8.f2286n
            int r4 = r8.D()
            int r3 = r3 - r4
            int r4 = r8.f2287o
            int r5 = r8.B()
            int r4 = r4 - r5
            androidx.recyclerview.widget.RecyclerView r5 = r8.f2274b
            android.graphics.Rect r5 = r5.f1980h
            r8.y(r10, r5)
            int r10 = r5.left
            int r10 = r10 - r2
            if (r10 >= r3) goto Lab
            int r10 = r5.right
            int r10 = r10 - r2
            if (r10 <= r11) goto Lab
            int r10 = r5.top
            int r10 = r10 - r1
            if (r10 >= r4) goto Lab
            int r10 = r5.bottom
            int r10 = r10 - r1
            if (r10 > r13) goto La6
            goto Lab
        La6:
            if (r2 != 0) goto Lac
            if (r1 == 0) goto Lab
            goto Lac
        Lab:
            return r0
        Lac:
            if (r12 == 0) goto Lb2
            r9.scrollBy(r2, r1)
            goto Lb5
        Lb2:
            r9.c0(r2, r1, r0)
        Lb5:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.u0.j0(androidx.recyclerview.widget.RecyclerView, android.view.View, android.graphics.Rect, boolean, boolean):boolean");
    }

    public abstract int k(i1 i1Var);

    public final void k0() {
        RecyclerView recyclerView = this.f2274b;
        if (recyclerView != null) {
            recyclerView.requestLayout();
        }
    }

    public abstract int l(i1 i1Var);

    public abstract int l0(int i4, b1 b1Var, i1 i1Var);

    public abstract int m(i1 i1Var);

    public abstract void m0(int i4);

    public abstract int n(i1 i1Var);

    public abstract int n0(int i4, b1 b1Var, i1 i1Var);

    public abstract int o(i1 i1Var);

    public final void o0(RecyclerView recyclerView) {
        p0(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
    }

    public final void p(b1 b1Var) {
        for (int v2 = v() - 1; v2 >= 0; v2--) {
            View u4 = u(v2);
            l1 J = RecyclerView.J(u4);
            if (!J.q()) {
                if (J.h() && !J.j() && !this.f2274b.f1986k.f2146b) {
                    i0(v2);
                    b1Var.g(J);
                } else {
                    u(v2);
                    this.f2273a.c(v2);
                    b1Var.h(u4);
                    this.f2274b.f1976f.g(J);
                }
            }
        }
    }

    public final void p0(int i4, int i5) {
        this.f2286n = View.MeasureSpec.getSize(i4);
        int mode = View.MeasureSpec.getMode(i4);
        this.f2284l = mode;
        if (mode == 0) {
            int[] iArr = RecyclerView.f1963t0;
        }
        this.f2287o = View.MeasureSpec.getSize(i5);
        int mode2 = View.MeasureSpec.getMode(i5);
        this.f2285m = mode2;
        if (mode2 == 0) {
            int[] iArr2 = RecyclerView.f1963t0;
        }
    }

    public View q(int i4) {
        int v2 = v();
        for (int i5 = 0; i5 < v2; i5++) {
            View u4 = u(i5);
            l1 J = RecyclerView.J(u4);
            if (J != null && J.c() == i4 && !J.q() && (this.f2274b.f1973d0.f2132g || !J.j())) {
                return u4;
            }
        }
        return null;
    }

    public void q0(Rect rect, int i4, int i5) {
        int D = D() + C() + rect.width();
        int B = B() + E() + rect.height();
        RecyclerView recyclerView = this.f2274b;
        WeakHashMap weakHashMap = i0.y0.f4999a;
        RecyclerView.e(this.f2274b, g(i4, D, i0.g0.e(recyclerView)), g(i5, B, i0.g0.d(this.f2274b)));
    }

    public abstract RecyclerView.LayoutParams r();

    public final void r0(int i4, int i5) {
        int v2 = v();
        if (v2 == 0) {
            this.f2274b.n(i4, i5);
            return;
        }
        int i6 = Integer.MIN_VALUE;
        int i7 = Integer.MAX_VALUE;
        int i8 = Integer.MIN_VALUE;
        int i9 = Integer.MAX_VALUE;
        for (int i10 = 0; i10 < v2; i10++) {
            View u4 = u(i10);
            Rect rect = this.f2274b.f1980h;
            y(u4, rect);
            int i11 = rect.left;
            if (i11 < i9) {
                i9 = i11;
            }
            int i12 = rect.right;
            if (i12 > i6) {
                i6 = i12;
            }
            int i13 = rect.top;
            if (i13 < i7) {
                i7 = i13;
            }
            int i14 = rect.bottom;
            if (i14 > i8) {
                i8 = i14;
            }
        }
        this.f2274b.f1980h.set(i9, i7, i6, i8);
        q0(this.f2274b.f1980h, i4, i5);
    }

    public RecyclerView.LayoutParams s(Context context, AttributeSet attributeSet) {
        return new RecyclerView.LayoutParams(context, attributeSet);
    }

    public final void s0(RecyclerView recyclerView) {
        int height;
        if (recyclerView == null) {
            this.f2274b = null;
            this.f2273a = null;
            height = 0;
            this.f2286n = 0;
        } else {
            this.f2274b = recyclerView;
            this.f2273a = recyclerView.f1974e;
            this.f2286n = recyclerView.getWidth();
            height = recyclerView.getHeight();
        }
        this.f2287o = height;
        this.f2284l = 1073741824;
        this.f2285m = 1073741824;
    }

    public RecyclerView.LayoutParams t(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof RecyclerView.LayoutParams ? new RecyclerView.LayoutParams((RecyclerView.LayoutParams) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new RecyclerView.LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new RecyclerView.LayoutParams(layoutParams);
    }

    public final boolean t0(View view, int i4, int i5, RecyclerView.LayoutParams layoutParams) {
        return (!view.isLayoutRequested() && this.f2280h && K(view.getWidth(), i4, ((ViewGroup.MarginLayoutParams) layoutParams).width) && K(view.getHeight(), i5, ((ViewGroup.MarginLayoutParams) layoutParams).height)) ? false : true;
    }

    public final View u(int i4) {
        d dVar = this.f2273a;
        if (dVar != null) {
            return dVar.d(i4);
        }
        return null;
    }

    public boolean u0() {
        return false;
    }

    public final int v() {
        d dVar = this.f2273a;
        if (dVar != null) {
            return dVar.e();
        }
        return 0;
    }

    public final boolean v0(View view, int i4, int i5, RecyclerView.LayoutParams layoutParams) {
        return (this.f2280h && K(view.getMeasuredWidth(), i4, ((ViewGroup.MarginLayoutParams) layoutParams).width) && K(view.getMeasuredHeight(), i5, ((ViewGroup.MarginLayoutParams) layoutParams).height)) ? false : true;
    }

    public abstract void w0(RecyclerView recyclerView, int i4);

    public int x(b1 b1Var, i1 i1Var) {
        RecyclerView recyclerView = this.f2274b;
        if (recyclerView == null || recyclerView.f1986k == null || !d()) {
            return 1;
        }
        return this.f2274b.f1986k.a();
    }

    public final void x0(a0 a0Var) {
        h1 h1Var = this.f2277e;
        if (h1Var != null && a0Var != h1Var && h1Var.f2115e) {
            h1Var.d();
        }
        this.f2277e = a0Var;
        RecyclerView recyclerView = this.f2274b;
        k1 k1Var = recyclerView.f1967a0;
        k1Var.f2166g.removeCallbacks(k1Var);
        k1Var.f2162c.abortAnimation();
        if (a0Var.f2118h) {
            Log.w("RecyclerView", "An instance of " + a0Var.getClass().getSimpleName() + " was started more than once. Each instance of" + a0Var.getClass().getSimpleName() + " is intended to only be used once. You should create a new instance for each use.");
        }
        a0Var.f2112b = recyclerView;
        a0Var.f2113c = this;
        int i4 = a0Var.f2111a;
        if (i4 != -1) {
            recyclerView.f1973d0.f2126a = i4;
            a0Var.f2115e = true;
            a0Var.f2114d = true;
            a0Var.f2116f = recyclerView.f1988l.q(i4);
            a0Var.f2112b.f1967a0.a();
            a0Var.f2118h = true;
            return;
        }
        throw new IllegalArgumentException("Invalid target position");
    }

    public void y(View view, Rect rect) {
        int[] iArr = RecyclerView.f1963t0;
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        Rect rect2 = layoutParams.f2012b;
        rect.set((view.getLeft() - rect2.left) - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, (view.getTop() - rect2.top) - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, view.getRight() + rect2.right + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, view.getBottom() + rect2.bottom + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
    }

    public boolean y0() {
        return false;
    }

    public final int z() {
        RecyclerView recyclerView = this.f2274b;
        j0 adapter = recyclerView != null ? recyclerView.getAdapter() : null;
        if (adapter != null) {
            return adapter.a();
        }
        return 0;
    }
}