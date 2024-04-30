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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class StaggeredGridLayoutManager extends u0 implements g1 {
    public final r1 B;
    public final int C;
    public boolean D;
    public boolean E;
    public SavedState F;
    public final Rect G;
    public final p1 H;
    public final boolean I;
    public int[] J;
    public final l K;

    /* renamed from: p  reason: collision with root package name */
    public final int f2016p;

    /* renamed from: q  reason: collision with root package name */
    public final t1[] f2017q;

    /* renamed from: r  reason: collision with root package name */
    public final d0 f2018r;

    /* renamed from: s  reason: collision with root package name */
    public final d0 f2019s;

    /* renamed from: t  reason: collision with root package name */
    public final int f2020t;

    /* renamed from: u  reason: collision with root package name */
    public int f2021u;

    /* renamed from: v  reason: collision with root package name */
    public final v f2022v;

    /* renamed from: w  reason: collision with root package name */
    public boolean f2023w;

    /* renamed from: y  reason: collision with root package name */
    public final BitSet f2025y;

    /* renamed from: x  reason: collision with root package name */
    public boolean f2024x = false;

    /* renamed from: z  reason: collision with root package name */
    public int f2026z = -1;
    public int A = Integer.MIN_VALUE;

    /* loaded from: classes.dex */
    public static class LayoutParams extends RecyclerView.LayoutParams {

        /* renamed from: e  reason: collision with root package name */
        public t1 f2027e;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    @RestrictTo({RestrictTo.Scope.f169a})
    /* loaded from: classes.dex */
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Object();

        /* renamed from: a  reason: collision with root package name */
        public int f2032a;

        /* renamed from: b  reason: collision with root package name */
        public int f2033b;

        /* renamed from: c  reason: collision with root package name */
        public int f2034c;

        /* renamed from: d  reason: collision with root package name */
        public int[] f2035d;

        /* renamed from: e  reason: collision with root package name */
        public int f2036e;

        /* renamed from: f  reason: collision with root package name */
        public int[] f2037f;

        /* renamed from: g  reason: collision with root package name */
        public List f2038g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f2039h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f2040i;

        /* renamed from: j  reason: collision with root package name */
        public boolean f2041j;

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i4) {
            parcel.writeInt(this.f2032a);
            parcel.writeInt(this.f2033b);
            parcel.writeInt(this.f2034c);
            if (this.f2034c > 0) {
                parcel.writeIntArray(this.f2035d);
            }
            parcel.writeInt(this.f2036e);
            if (this.f2036e > 0) {
                parcel.writeIntArray(this.f2037f);
            }
            parcel.writeInt(this.f2039h ? 1 : 0);
            parcel.writeInt(this.f2040i ? 1 : 0);
            parcel.writeInt(this.f2041j ? 1 : 0);
            parcel.writeList(this.f2038g);
        }
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object, androidx.recyclerview.widget.r1] */
    /* JADX WARN: Type inference failed for: r6v3, types: [androidx.recyclerview.widget.v, java.lang.Object] */
    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i4, int i5) {
        this.f2016p = -1;
        this.f2023w = false;
        ?? obj = new Object();
        this.B = obj;
        this.C = 2;
        this.G = new Rect();
        this.H = new p1(this);
        this.I = true;
        this.K = new l(1, this);
        t0 G = u0.G(context, attributeSet, i4, i5);
        int i6 = G.f2261a;
        if (i6 != 0 && i6 != 1) {
            throw new IllegalArgumentException("invalid orientation.");
        }
        c(null);
        if (i6 != this.f2020t) {
            this.f2020t = i6;
            d0 d0Var = this.f2018r;
            this.f2018r = this.f2019s;
            this.f2019s = d0Var;
            k0();
        }
        int i7 = G.f2262b;
        c(null);
        if (i7 != this.f2016p) {
            int[] iArr = obj.f2247a;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            obj.f2248b = null;
            k0();
            this.f2016p = i7;
            this.f2025y = new BitSet(this.f2016p);
            this.f2017q = new t1[this.f2016p];
            for (int i8 = 0; i8 < this.f2016p; i8++) {
                this.f2017q[i8] = new t1(this, i8);
            }
            k0();
        }
        boolean z4 = G.f2263c;
        c(null);
        SavedState savedState = this.F;
        if (savedState != null && savedState.f2039h != z4) {
            savedState.f2039h = z4;
        }
        this.f2023w = z4;
        k0();
        ?? obj2 = new Object();
        obj2.f2293a = true;
        obj2.f2298f = 0;
        obj2.f2299g = 0;
        this.f2022v = obj2;
        this.f2018r = d0.a(this, this.f2020t);
        this.f2019s = d0.a(this, 1 - this.f2020t);
    }

    public static int c1(int i4, int i5, int i6) {
        if (i5 == 0 && i6 == 0) {
            return i4;
        }
        int mode = View.MeasureSpec.getMode(i4);
        if (mode != Integer.MIN_VALUE && mode != 1073741824) {
            return i4;
        }
        return View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i4) - i5) - i6), mode);
    }

    public final boolean A0() {
        int J0;
        if (v() != 0 && this.C != 0 && this.f2279g) {
            if (this.f2024x) {
                J0 = K0();
                J0();
            } else {
                J0 = J0();
                K0();
            }
            r1 r1Var = this.B;
            if (J0 == 0 && O0() != null) {
                int[] iArr = r1Var.f2247a;
                if (iArr != null) {
                    Arrays.fill(iArr, -1);
                }
                r1Var.f2248b = null;
                this.f2278f = true;
                k0();
                return true;
            }
        }
        return false;
    }

    public final int B0(i1 i1Var) {
        if (v() == 0) {
            return 0;
        }
        d0 d0Var = this.f2018r;
        boolean z4 = this.I;
        return com.google.common.collect.c.S(i1Var, d0Var, G0(!z4), F0(!z4), this, this.I);
    }

    public final int C0(i1 i1Var) {
        if (v() == 0) {
            return 0;
        }
        d0 d0Var = this.f2018r;
        boolean z4 = this.I;
        return com.google.common.collect.c.T(i1Var, d0Var, G0(!z4), F0(!z4), this, this.I, this.f2024x);
    }

    public final int D0(i1 i1Var) {
        if (v() == 0) {
            return 0;
        }
        d0 d0Var = this.f2018r;
        boolean z4 = this.I;
        return com.google.common.collect.c.U(i1Var, d0Var, G0(!z4), F0(!z4), this, this.I);
    }

    /* JADX WARN: Type inference failed for: r6v20 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4, types: [int, boolean] */
    public final int E0(b1 b1Var, v vVar, i1 i1Var) {
        int i4;
        int k4;
        int i5;
        int L0;
        int i6;
        t1 t1Var;
        ?? r6;
        int i7;
        int h4;
        int c4;
        int k5;
        int c5;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12 = 0;
        int i13 = 1;
        this.f2025y.set(0, this.f2016p, true);
        v vVar2 = this.f2022v;
        if (vVar2.f2301i) {
            if (vVar.f2297e == 1) {
                i4 = Integer.MAX_VALUE;
            } else {
                i4 = Integer.MIN_VALUE;
            }
        } else if (vVar.f2297e == 1) {
            i4 = vVar.f2299g + vVar.f2294b;
        } else {
            i4 = vVar.f2298f - vVar.f2294b;
        }
        int i14 = vVar.f2297e;
        for (int i15 = 0; i15 < this.f2016p; i15++) {
            if (!this.f2017q[i15].f2265a.isEmpty()) {
                b1(this.f2017q[i15], i14, i4);
            }
        }
        if (this.f2024x) {
            k4 = this.f2018r.g();
        } else {
            k4 = this.f2018r.k();
        }
        boolean z4 = false;
        while (true) {
            int i16 = vVar.f2295c;
            if (i16 >= 0 && i16 < i1Var.b()) {
                i5 = i13;
            } else {
                i5 = i12;
            }
            if (i5 == 0 || (!vVar2.f2301i && this.f2025y.isEmpty())) {
                break;
            }
            View view = b1Var.i(vVar.f2295c, Long.MAX_VALUE).f2170a;
            vVar.f2295c += vVar.f2296d;
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            int c6 = layoutParams.f2011a.c();
            r1 r1Var = this.B;
            int[] iArr = r1Var.f2247a;
            if (iArr != null && c6 < iArr.length) {
                i6 = iArr[c6];
            } else {
                i6 = -1;
            }
            if (i6 == -1) {
                if (S0(vVar.f2297e)) {
                    i11 = this.f2016p - i13;
                    i10 = -1;
                    i9 = -1;
                } else {
                    i9 = i13;
                    i10 = this.f2016p;
                    i11 = i12;
                }
                t1 t1Var2 = null;
                if (vVar.f2297e == i13) {
                    int k6 = this.f2018r.k();
                    int i17 = Integer.MAX_VALUE;
                    while (i11 != i10) {
                        t1 t1Var3 = this.f2017q[i11];
                        int f4 = t1Var3.f(k6);
                        if (f4 < i17) {
                            i17 = f4;
                            t1Var2 = t1Var3;
                        }
                        i11 += i9;
                    }
                } else {
                    int g4 = this.f2018r.g();
                    int i18 = Integer.MIN_VALUE;
                    while (i11 != i10) {
                        t1 t1Var4 = this.f2017q[i11];
                        int h5 = t1Var4.h(g4);
                        if (h5 > i18) {
                            t1Var2 = t1Var4;
                            i18 = h5;
                        }
                        i11 += i9;
                    }
                }
                t1Var = t1Var2;
                r1Var.a(c6);
                r1Var.f2247a[c6] = t1Var.f2269e;
            } else {
                t1Var = this.f2017q[i6];
            }
            layoutParams.f2027e = t1Var;
            if (vVar.f2297e == 1) {
                r6 = 0;
                b(view, -1, false);
            } else {
                r6 = 0;
                b(view, 0, false);
            }
            if (this.f2020t == 1) {
                i7 = 1;
                Q0(view, u0.w(r6, this.f2021u, this.f2284l, r6, ((ViewGroup.MarginLayoutParams) layoutParams).width), u0.w(true, this.f2287o, this.f2285m, B() + E(), ((ViewGroup.MarginLayoutParams) layoutParams).height));
            } else {
                i7 = 1;
                Q0(view, u0.w(true, this.f2286n, this.f2284l, D() + C(), ((ViewGroup.MarginLayoutParams) layoutParams).width), u0.w(false, this.f2021u, this.f2285m, 0, ((ViewGroup.MarginLayoutParams) layoutParams).height));
            }
            if (vVar.f2297e == i7) {
                c4 = t1Var.f(k4);
                h4 = this.f2018r.c(view) + c4;
            } else {
                h4 = t1Var.h(k4);
                c4 = h4 - this.f2018r.c(view);
            }
            if (vVar.f2297e == 1) {
                t1 t1Var5 = layoutParams.f2027e;
                t1Var5.getClass();
                LayoutParams layoutParams2 = (LayoutParams) view.getLayoutParams();
                layoutParams2.f2027e = t1Var5;
                ArrayList arrayList = t1Var5.f2265a;
                arrayList.add(view);
                t1Var5.f2267c = Integer.MIN_VALUE;
                if (arrayList.size() == 1) {
                    t1Var5.f2266b = Integer.MIN_VALUE;
                }
                if (layoutParams2.f2011a.j() || layoutParams2.f2011a.m()) {
                    t1Var5.f2268d = t1Var5.f2270f.f2018r.c(view) + t1Var5.f2268d;
                }
            } else {
                t1 t1Var6 = layoutParams.f2027e;
                t1Var6.getClass();
                LayoutParams layoutParams3 = (LayoutParams) view.getLayoutParams();
                layoutParams3.f2027e = t1Var6;
                ArrayList arrayList2 = t1Var6.f2265a;
                arrayList2.add(0, view);
                t1Var6.f2266b = Integer.MIN_VALUE;
                if (arrayList2.size() == 1) {
                    t1Var6.f2267c = Integer.MIN_VALUE;
                }
                if (layoutParams3.f2011a.j() || layoutParams3.f2011a.m()) {
                    t1Var6.f2268d = t1Var6.f2270f.f2018r.c(view) + t1Var6.f2268d;
                }
            }
            if (P0() && this.f2020t == 1) {
                c5 = this.f2019s.g() - (((this.f2016p - 1) - t1Var.f2269e) * this.f2021u);
                k5 = c5 - this.f2019s.c(view);
            } else {
                k5 = this.f2019s.k() + (t1Var.f2269e * this.f2021u);
                c5 = this.f2019s.c(view) + k5;
            }
            if (this.f2020t == 1) {
                u0.L(view, k5, c4, c5, h4);
            } else {
                u0.L(view, c4, k5, h4, c5);
            }
            b1(t1Var, vVar2.f2297e, i4);
            U0(b1Var, vVar2);
            if (vVar2.f2300h && view.hasFocusable()) {
                i8 = 0;
                this.f2025y.set(t1Var.f2269e, false);
            } else {
                i8 = 0;
            }
            i12 = i8;
            i13 = 1;
            z4 = true;
        }
        int i19 = i12;
        if (!z4) {
            U0(b1Var, vVar2);
        }
        if (vVar2.f2297e == -1) {
            L0 = this.f2018r.k() - M0(this.f2018r.k());
        } else {
            L0 = L0(this.f2018r.g()) - this.f2018r.g();
        }
        if (L0 > 0) {
            return Math.min(vVar.f2294b, L0);
        }
        return i19;
    }

    public final View F0(boolean z4) {
        int k4 = this.f2018r.k();
        int g4 = this.f2018r.g();
        View view = null;
        for (int v2 = v() - 1; v2 >= 0; v2--) {
            View u4 = u(v2);
            int e4 = this.f2018r.e(u4);
            int b5 = this.f2018r.b(u4);
            if (b5 > k4 && e4 < g4) {
                if (b5 <= g4 || !z4) {
                    return u4;
                }
                if (view == null) {
                    view = u4;
                }
            }
        }
        return view;
    }

    public final View G0(boolean z4) {
        int k4 = this.f2018r.k();
        int g4 = this.f2018r.g();
        int v2 = v();
        View view = null;
        for (int i4 = 0; i4 < v2; i4++) {
            View u4 = u(i4);
            int e4 = this.f2018r.e(u4);
            if (this.f2018r.b(u4) > k4 && e4 < g4) {
                if (e4 >= k4 || !z4) {
                    return u4;
                }
                if (view == null) {
                    view = u4;
                }
            }
        }
        return view;
    }

    @Override // androidx.recyclerview.widget.u0
    public final int H(b1 b1Var, i1 i1Var) {
        return this.f2020t == 0 ? this.f2016p : super.H(b1Var, i1Var);
    }

    public final void H0(b1 b1Var, i1 i1Var, boolean z4) {
        int g4;
        int L0 = L0(Integer.MIN_VALUE);
        if (L0 != Integer.MIN_VALUE && (g4 = this.f2018r.g() - L0) > 0) {
            int i4 = g4 - (-Y0(-g4, b1Var, i1Var));
            if (!z4 || i4 <= 0) {
                return;
            }
            this.f2018r.p(i4);
        }
    }

    public final void I0(b1 b1Var, i1 i1Var, boolean z4) {
        int k4;
        int M0 = M0(Integer.MAX_VALUE);
        if (M0 != Integer.MAX_VALUE && (k4 = M0 - this.f2018r.k()) > 0) {
            int Y0 = k4 - Y0(k4, b1Var, i1Var);
            if (!z4 || Y0 <= 0) {
                return;
            }
            this.f2018r.p(-Y0);
        }
    }

    @Override // androidx.recyclerview.widget.u0
    public final boolean J() {
        return this.C != 0;
    }

    public final int J0() {
        if (v() == 0) {
            return 0;
        }
        return u0.F(u(0));
    }

    public final int K0() {
        int v2 = v();
        if (v2 == 0) {
            return 0;
        }
        return u0.F(u(v2 - 1));
    }

    public final int L0(int i4) {
        int f4 = this.f2017q[0].f(i4);
        for (int i5 = 1; i5 < this.f2016p; i5++) {
            int f5 = this.f2017q[i5].f(i4);
            if (f5 > f4) {
                f4 = f5;
            }
        }
        return f4;
    }

    @Override // androidx.recyclerview.widget.u0
    public final void M(int i4) {
        super.M(i4);
        for (int i5 = 0; i5 < this.f2016p; i5++) {
            t1 t1Var = this.f2017q[i5];
            int i6 = t1Var.f2266b;
            if (i6 != Integer.MIN_VALUE) {
                t1Var.f2266b = i6 + i4;
            }
            int i7 = t1Var.f2267c;
            if (i7 != Integer.MIN_VALUE) {
                t1Var.f2267c = i7 + i4;
            }
        }
    }

    public final int M0(int i4) {
        int h4 = this.f2017q[0].h(i4);
        for (int i5 = 1; i5 < this.f2016p; i5++) {
            int h5 = this.f2017q[i5].h(i4);
            if (h5 < h4) {
                h4 = h5;
            }
        }
        return h4;
    }

    @Override // androidx.recyclerview.widget.u0
    public final void N(int i4) {
        super.N(i4);
        for (int i5 = 0; i5 < this.f2016p; i5++) {
            t1 t1Var = this.f2017q[i5];
            int i6 = t1Var.f2266b;
            if (i6 != Integer.MIN_VALUE) {
                t1Var.f2266b = i6 + i4;
            }
            int i7 = t1Var.f2267c;
            if (i7 != Integer.MIN_VALUE) {
                t1Var.f2267c = i7 + i4;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x003c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void N0(int r8, int r9, int r10) {
        /*
            r7 = this;
            boolean r0 = r7.f2024x
            if (r0 == 0) goto L9
            int r0 = r7.K0()
            goto Ld
        L9:
            int r0 = r7.J0()
        Ld:
            r1 = 8
            if (r10 != r1) goto L1b
            if (r8 >= r9) goto L17
            int r2 = r9 + 1
        L15:
            r3 = r8
            goto L1e
        L17:
            int r2 = r8 + 1
            r3 = r9
            goto L1e
        L1b:
            int r2 = r8 + r9
            goto L15
        L1e:
            androidx.recyclerview.widget.r1 r4 = r7.B
            r4.b(r3)
            r5 = 1
            if (r10 == r5) goto L37
            r6 = 2
            if (r10 == r6) goto L33
            if (r10 == r1) goto L2c
            goto L3a
        L2c:
            r4.d(r8, r5)
            r4.c(r9, r5)
            goto L3a
        L33:
            r4.d(r8, r9)
            goto L3a
        L37:
            r4.c(r8, r9)
        L3a:
            if (r2 > r0) goto L3d
            return
        L3d:
            boolean r8 = r7.f2024x
            if (r8 == 0) goto L46
            int r8 = r7.J0()
            goto L4a
        L46:
            int r8 = r7.K0()
        L4a:
            if (r3 > r8) goto L4f
            r7.k0()
        L4f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.N0(int, int, int):void");
    }

    @Override // androidx.recyclerview.widget.u0
    public final void O(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.f2274b;
        if (recyclerView2 != null) {
            recyclerView2.removeCallbacks(this.K);
        }
        for (int i4 = 0; i4 < this.f2016p; i4++) {
            this.f2017q[i4].b();
        }
        recyclerView.requestLayout();
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00f7 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x002c A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.view.View O0() {
        /*
            Method dump skipped, instructions count: 250
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.O0():android.view.View");
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x004b, code lost:
        if (r8.f2020t == 1) goto L115;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0050, code lost:
        if (r8.f2020t == 0) goto L115;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x005d, code lost:
        if (P0() == false) goto L110;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x006a, code lost:
        if (P0() == false) goto L115;
     */
    @Override // androidx.recyclerview.widget.u0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.view.View P(android.view.View r9, int r10, androidx.recyclerview.widget.b1 r11, androidx.recyclerview.widget.i1 r12) {
        /*
            Method dump skipped, instructions count: 342
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.P(android.view.View, int, androidx.recyclerview.widget.b1, androidx.recyclerview.widget.i1):android.view.View");
    }

    public final boolean P0() {
        return A() == 1;
    }

    @Override // androidx.recyclerview.widget.u0
    public final void Q(AccessibilityEvent accessibilityEvent) {
        super.Q(accessibilityEvent);
        if (v() > 0) {
            View G0 = G0(false);
            View F0 = F0(false);
            if (G0 == null || F0 == null) {
                return;
            }
            int F = u0.F(G0);
            int F2 = u0.F(F0);
            if (F < F2) {
                accessibilityEvent.setFromIndex(F);
                accessibilityEvent.setToIndex(F2);
                return;
            }
            accessibilityEvent.setFromIndex(F2);
            accessibilityEvent.setToIndex(F);
        }
    }

    public final void Q0(View view, int i4, int i5) {
        RecyclerView recyclerView = this.f2274b;
        Rect rect = this.G;
        if (recyclerView == null) {
            rect.set(0, 0, 0, 0);
        } else {
            rect.set(recyclerView.K(view));
        }
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int c12 = c1(i4, ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + rect.left, ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + rect.right);
        int c13 = c1(i5, ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + rect.top, ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + rect.bottom);
        if (t0(view, c12, c13, layoutParams)) {
            view.measure(c12, c13);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:253:0x03ef, code lost:
        if (A0() != false) goto L261;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void R0(androidx.recyclerview.widget.b1 r17, androidx.recyclerview.widget.i1 r18, boolean r19) {
        /*
            Method dump skipped, instructions count: 1037
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.R0(androidx.recyclerview.widget.b1, androidx.recyclerview.widget.i1, boolean):void");
    }

    public final boolean S0(int i4) {
        if (this.f2020t == 0) {
            return (i4 == -1) != this.f2024x;
        }
        return ((i4 == -1) == this.f2024x) == P0();
    }

    @Override // androidx.recyclerview.widget.u0
    public final void T(b1 b1Var, i1 i1Var, View view, j0.h hVar) {
        int i4;
        int i5;
        int i6;
        int i7;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof LayoutParams)) {
            S(view, hVar);
            return;
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        int i8 = -1;
        if (this.f2020t == 0) {
            t1 t1Var = layoutParams2.f2027e;
            if (t1Var != null) {
                i8 = t1Var.f2269e;
            }
            i7 = i8;
            i4 = -1;
            i6 = -1;
            i5 = 1;
        } else {
            t1 t1Var2 = layoutParams2.f2027e;
            if (t1Var2 != null) {
                i8 = t1Var2.f2269e;
            }
            i4 = i8;
            i5 = -1;
            i6 = 1;
            i7 = -1;
        }
        hVar.h(i0.i(i7, i5, i4, i6, false, false));
    }

    public final void T0(int i4, i1 i1Var) {
        int J0;
        int i5;
        if (i4 > 0) {
            J0 = K0();
            i5 = 1;
        } else {
            J0 = J0();
            i5 = -1;
        }
        v vVar = this.f2022v;
        vVar.f2293a = true;
        a1(J0, i1Var);
        Z0(i5);
        vVar.f2295c = J0 + vVar.f2296d;
        vVar.f2294b = Math.abs(i4);
    }

    @Override // androidx.recyclerview.widget.u0
    public final void U(int i4, int i5) {
        N0(i4, i5, 1);
    }

    public final void U0(b1 b1Var, v vVar) {
        int min;
        int min2;
        if (vVar.f2293a && !vVar.f2301i) {
            if (vVar.f2294b == 0) {
                if (vVar.f2297e == -1) {
                    V0(vVar.f2299g, b1Var);
                    return;
                } else {
                    W0(vVar.f2298f, b1Var);
                    return;
                }
            }
            int i4 = 1;
            if (vVar.f2297e == -1) {
                int i5 = vVar.f2298f;
                int h4 = this.f2017q[0].h(i5);
                while (i4 < this.f2016p) {
                    int h5 = this.f2017q[i4].h(i5);
                    if (h5 > h4) {
                        h4 = h5;
                    }
                    i4++;
                }
                int i6 = i5 - h4;
                if (i6 < 0) {
                    min2 = vVar.f2299g;
                } else {
                    min2 = vVar.f2299g - Math.min(i6, vVar.f2294b);
                }
                V0(min2, b1Var);
                return;
            }
            int i7 = vVar.f2299g;
            int f4 = this.f2017q[0].f(i7);
            while (i4 < this.f2016p) {
                int f5 = this.f2017q[i4].f(i7);
                if (f5 < f4) {
                    f4 = f5;
                }
                i4++;
            }
            int i8 = f4 - vVar.f2299g;
            if (i8 < 0) {
                min = vVar.f2298f;
            } else {
                min = Math.min(i8, vVar.f2294b) + vVar.f2298f;
            }
            W0(min, b1Var);
        }
    }

    @Override // androidx.recyclerview.widget.u0
    public final void V() {
        r1 r1Var = this.B;
        int[] iArr = r1Var.f2247a;
        if (iArr != null) {
            Arrays.fill(iArr, -1);
        }
        r1Var.f2248b = null;
        k0();
    }

    public final void V0(int i4, b1 b1Var) {
        for (int v2 = v() - 1; v2 >= 0; v2--) {
            View u4 = u(v2);
            if (this.f2018r.e(u4) >= i4 && this.f2018r.o(u4) >= i4) {
                LayoutParams layoutParams = (LayoutParams) u4.getLayoutParams();
                layoutParams.getClass();
                if (layoutParams.f2027e.f2265a.size() == 1) {
                    return;
                }
                t1 t1Var = layoutParams.f2027e;
                ArrayList arrayList = t1Var.f2265a;
                int size = arrayList.size();
                View view = (View) arrayList.remove(size - 1);
                LayoutParams layoutParams2 = (LayoutParams) view.getLayoutParams();
                layoutParams2.f2027e = null;
                if (layoutParams2.f2011a.j() || layoutParams2.f2011a.m()) {
                    t1Var.f2268d -= t1Var.f2270f.f2018r.c(view);
                }
                if (size == 1) {
                    t1Var.f2266b = Integer.MIN_VALUE;
                }
                t1Var.f2267c = Integer.MIN_VALUE;
                h0(u4, b1Var);
            } else {
                return;
            }
        }
    }

    @Override // androidx.recyclerview.widget.u0
    public final void W(int i4, int i5) {
        N0(i4, i5, 8);
    }

    public final void W0(int i4, b1 b1Var) {
        while (v() > 0) {
            View u4 = u(0);
            if (this.f2018r.b(u4) <= i4 && this.f2018r.n(u4) <= i4) {
                LayoutParams layoutParams = (LayoutParams) u4.getLayoutParams();
                layoutParams.getClass();
                if (layoutParams.f2027e.f2265a.size() == 1) {
                    return;
                }
                t1 t1Var = layoutParams.f2027e;
                ArrayList arrayList = t1Var.f2265a;
                View view = (View) arrayList.remove(0);
                LayoutParams layoutParams2 = (LayoutParams) view.getLayoutParams();
                layoutParams2.f2027e = null;
                if (arrayList.size() == 0) {
                    t1Var.f2267c = Integer.MIN_VALUE;
                }
                if (layoutParams2.f2011a.j() || layoutParams2.f2011a.m()) {
                    t1Var.f2268d -= t1Var.f2270f.f2018r.c(view);
                }
                t1Var.f2266b = Integer.MIN_VALUE;
                h0(u4, b1Var);
            } else {
                return;
            }
        }
    }

    @Override // androidx.recyclerview.widget.u0
    public final void X(int i4, int i5) {
        N0(i4, i5, 2);
    }

    public final void X0() {
        boolean z4;
        if (this.f2020t != 1 && P0()) {
            z4 = !this.f2023w;
        } else {
            z4 = this.f2023w;
        }
        this.f2024x = z4;
    }

    @Override // androidx.recyclerview.widget.u0
    public final void Y(int i4, int i5) {
        N0(i4, i5, 4);
    }

    public final int Y0(int i4, b1 b1Var, i1 i1Var) {
        if (v() == 0 || i4 == 0) {
            return 0;
        }
        T0(i4, i1Var);
        v vVar = this.f2022v;
        int E0 = E0(b1Var, vVar, i1Var);
        if (vVar.f2294b >= E0) {
            if (i4 < 0) {
                i4 = -E0;
            } else {
                i4 = E0;
            }
        }
        this.f2018r.p(-i4);
        this.D = this.f2024x;
        vVar.f2294b = 0;
        U0(b1Var, vVar);
        return i4;
    }

    @Override // androidx.recyclerview.widget.u0
    public final void Z(b1 b1Var, i1 i1Var) {
        R0(b1Var, i1Var, true);
    }

    public final void Z0(int i4) {
        v vVar = this.f2022v;
        vVar.f2297e = i4;
        vVar.f2296d = this.f2024x != (i4 == -1) ? -1 : 1;
    }

    @Override // androidx.recyclerview.widget.g1
    public final PointF a(int i4) {
        int z02 = z0(i4);
        PointF pointF = new PointF();
        if (z02 == 0) {
            return null;
        }
        if (this.f2020t == 0) {
            pointF.x = z02;
            pointF.y = 0.0f;
        } else {
            pointF.x = 0.0f;
            pointF.y = z02;
        }
        return pointF;
    }

    @Override // androidx.recyclerview.widget.u0
    public final void a0(i1 i1Var) {
        this.f2026z = -1;
        this.A = Integer.MIN_VALUE;
        this.F = null;
        this.H.a();
    }

    public final void a1(int i4, i1 i1Var) {
        boolean z4;
        int i5;
        int i6;
        int i7;
        boolean z5;
        v vVar = this.f2022v;
        boolean z6 = false;
        vVar.f2294b = 0;
        vVar.f2295c = i4;
        h1 h1Var = this.f2277e;
        if (h1Var != null && h1Var.f2115e) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z4 && (i7 = i1Var.f2126a) != -1) {
            boolean z7 = this.f2024x;
            if (i7 < i4) {
                z5 = true;
            } else {
                z5 = false;
            }
            if (z7 == z5) {
                i5 = this.f2018r.l();
                i6 = 0;
            } else {
                i6 = this.f2018r.l();
                i5 = 0;
            }
        } else {
            i5 = 0;
            i6 = 0;
        }
        RecyclerView recyclerView = this.f2274b;
        if (recyclerView != null && recyclerView.f1978g) {
            vVar.f2298f = this.f2018r.k() - i6;
            vVar.f2299g = this.f2018r.g() + i5;
        } else {
            vVar.f2299g = this.f2018r.f() + i5;
            vVar.f2298f = -i6;
        }
        vVar.f2300h = false;
        vVar.f2293a = true;
        if (this.f2018r.i() == 0 && this.f2018r.f() == 0) {
            z6 = true;
        }
        vVar.f2301i = z6;
    }

    @Override // androidx.recyclerview.widget.u0
    public final void b0(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.F = (SavedState) parcelable;
            k0();
        }
    }

    public final void b1(t1 t1Var, int i4, int i5) {
        int i6 = t1Var.f2268d;
        int i7 = t1Var.f2269e;
        if (i4 == -1) {
            int i8 = t1Var.f2266b;
            if (i8 == Integer.MIN_VALUE) {
                View view = (View) t1Var.f2265a.get(0);
                t1Var.f2266b = t1Var.f2270f.f2018r.e(view);
                ((LayoutParams) view.getLayoutParams()).getClass();
                i8 = t1Var.f2266b;
            }
            if (i8 + i6 > i5) {
                return;
            }
        } else {
            int i9 = t1Var.f2267c;
            if (i9 == Integer.MIN_VALUE) {
                t1Var.a();
                i9 = t1Var.f2267c;
            }
            if (i9 - i6 < i5) {
                return;
            }
        }
        this.f2025y.set(i7, false);
    }

    @Override // androidx.recyclerview.widget.u0
    public final void c(String str) {
        if (this.F == null) {
            super.c(str);
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState, android.os.Parcelable, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v27, types: [androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState, android.os.Parcelable, java.lang.Object] */
    @Override // androidx.recyclerview.widget.u0
    public final Parcelable c0() {
        int J0;
        View G0;
        int h4;
        int k4;
        int[] iArr;
        SavedState savedState = this.F;
        if (savedState != null) {
            ?? obj = new Object();
            obj.f2034c = savedState.f2034c;
            obj.f2032a = savedState.f2032a;
            obj.f2033b = savedState.f2033b;
            obj.f2035d = savedState.f2035d;
            obj.f2036e = savedState.f2036e;
            obj.f2037f = savedState.f2037f;
            obj.f2039h = savedState.f2039h;
            obj.f2040i = savedState.f2040i;
            obj.f2041j = savedState.f2041j;
            obj.f2038g = savedState.f2038g;
            return obj;
        }
        ?? obj2 = new Object();
        obj2.f2039h = this.f2023w;
        obj2.f2040i = this.D;
        obj2.f2041j = this.E;
        r1 r1Var = this.B;
        if (r1Var != null && (iArr = r1Var.f2247a) != null) {
            obj2.f2037f = iArr;
            obj2.f2036e = iArr.length;
            obj2.f2038g = r1Var.f2248b;
        } else {
            obj2.f2036e = 0;
        }
        int i4 = -1;
        if (v() > 0) {
            if (this.D) {
                J0 = K0();
            } else {
                J0 = J0();
            }
            obj2.f2032a = J0;
            if (this.f2024x) {
                G0 = F0(true);
            } else {
                G0 = G0(true);
            }
            if (G0 != null) {
                i4 = u0.F(G0);
            }
            obj2.f2033b = i4;
            int i5 = this.f2016p;
            obj2.f2034c = i5;
            obj2.f2035d = new int[i5];
            for (int i6 = 0; i6 < this.f2016p; i6++) {
                if (this.D) {
                    h4 = this.f2017q[i6].f(Integer.MIN_VALUE);
                    if (h4 != Integer.MIN_VALUE) {
                        k4 = this.f2018r.g();
                        h4 -= k4;
                        obj2.f2035d[i6] = h4;
                    } else {
                        obj2.f2035d[i6] = h4;
                    }
                } else {
                    h4 = this.f2017q[i6].h(Integer.MIN_VALUE);
                    if (h4 != Integer.MIN_VALUE) {
                        k4 = this.f2018r.k();
                        h4 -= k4;
                        obj2.f2035d[i6] = h4;
                    } else {
                        obj2.f2035d[i6] = h4;
                    }
                }
            }
        } else {
            obj2.f2032a = -1;
            obj2.f2033b = -1;
            obj2.f2034c = 0;
        }
        return obj2;
    }

    @Override // androidx.recyclerview.widget.u0
    public final boolean d() {
        return this.f2020t == 0;
    }

    @Override // androidx.recyclerview.widget.u0
    public final void d0(int i4) {
        if (i4 == 0) {
            A0();
        }
    }

    @Override // androidx.recyclerview.widget.u0
    public final boolean e() {
        return this.f2020t == 1;
    }

    @Override // androidx.recyclerview.widget.u0
    public final boolean f(RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // androidx.recyclerview.widget.u0
    public final void h(int i4, int i5, i1 i1Var, r rVar) {
        v vVar;
        int f4;
        int i6;
        if (this.f2020t != 0) {
            i4 = i5;
        }
        if (v() != 0 && i4 != 0) {
            T0(i4, i1Var);
            int[] iArr = this.J;
            if (iArr == null || iArr.length < this.f2016p) {
                this.J = new int[this.f2016p];
            }
            int i7 = 0;
            int i8 = 0;
            while (true) {
                int i9 = this.f2016p;
                vVar = this.f2022v;
                if (i7 >= i9) {
                    break;
                }
                if (vVar.f2296d == -1) {
                    f4 = vVar.f2298f;
                    i6 = this.f2017q[i7].h(f4);
                } else {
                    f4 = this.f2017q[i7].f(vVar.f2299g);
                    i6 = vVar.f2299g;
                }
                int i10 = f4 - i6;
                if (i10 >= 0) {
                    this.J[i8] = i10;
                    i8++;
                }
                i7++;
            }
            Arrays.sort(this.J, 0, i8);
            for (int i11 = 0; i11 < i8; i11++) {
                int i12 = vVar.f2295c;
                if (i12 >= 0 && i12 < i1Var.b()) {
                    rVar.a(vVar.f2295c, this.J[i11]);
                    vVar.f2295c += vVar.f2296d;
                } else {
                    return;
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.u0
    public final int j(i1 i1Var) {
        return B0(i1Var);
    }

    @Override // androidx.recyclerview.widget.u0
    public final int k(i1 i1Var) {
        return C0(i1Var);
    }

    @Override // androidx.recyclerview.widget.u0
    public final int l(i1 i1Var) {
        return D0(i1Var);
    }

    @Override // androidx.recyclerview.widget.u0
    public final int l0(int i4, b1 b1Var, i1 i1Var) {
        return Y0(i4, b1Var, i1Var);
    }

    @Override // androidx.recyclerview.widget.u0
    public final int m(i1 i1Var) {
        return B0(i1Var);
    }

    @Override // androidx.recyclerview.widget.u0
    public final void m0(int i4) {
        SavedState savedState = this.F;
        if (savedState != null && savedState.f2032a != i4) {
            savedState.f2035d = null;
            savedState.f2034c = 0;
            savedState.f2032a = -1;
            savedState.f2033b = -1;
        }
        this.f2026z = i4;
        this.A = Integer.MIN_VALUE;
        k0();
    }

    @Override // androidx.recyclerview.widget.u0
    public final int n(i1 i1Var) {
        return C0(i1Var);
    }

    @Override // androidx.recyclerview.widget.u0
    public final int n0(int i4, b1 b1Var, i1 i1Var) {
        return Y0(i4, b1Var, i1Var);
    }

    @Override // androidx.recyclerview.widget.u0
    public final int o(i1 i1Var) {
        return D0(i1Var);
    }

    @Override // androidx.recyclerview.widget.u0
    public final void q0(Rect rect, int i4, int i5) {
        int g4;
        int g5;
        int D = D() + C();
        int B = B() + E();
        if (this.f2020t == 1) {
            int height = rect.height() + B;
            RecyclerView recyclerView = this.f2274b;
            WeakHashMap weakHashMap = i0.y0.f4999a;
            g5 = u0.g(i5, height, i0.g0.d(recyclerView));
            g4 = u0.g(i4, (this.f2021u * this.f2016p) + D, i0.g0.e(this.f2274b));
        } else {
            int width = rect.width() + D;
            RecyclerView recyclerView2 = this.f2274b;
            WeakHashMap weakHashMap2 = i0.y0.f4999a;
            g4 = u0.g(i4, width, i0.g0.e(recyclerView2));
            g5 = u0.g(i5, (this.f2021u * this.f2016p) + B, i0.g0.d(this.f2274b));
        }
        this.f2274b.setMeasuredDimension(g4, g5);
    }

    @Override // androidx.recyclerview.widget.u0
    public final RecyclerView.LayoutParams r() {
        if (this.f2020t == 0) {
            return new RecyclerView.LayoutParams(-2, -1);
        }
        return new RecyclerView.LayoutParams(-1, -2);
    }

    @Override // androidx.recyclerview.widget.u0
    public final RecyclerView.LayoutParams s(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    @Override // androidx.recyclerview.widget.u0
    public final RecyclerView.LayoutParams t(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new RecyclerView.LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new RecyclerView.LayoutParams(layoutParams);
    }

    @Override // androidx.recyclerview.widget.u0
    public final void w0(RecyclerView recyclerView, int i4) {
        a0 a0Var = new a0(recyclerView.getContext());
        a0Var.f2111a = i4;
        x0(a0Var);
    }

    @Override // androidx.recyclerview.widget.u0
    public final int x(b1 b1Var, i1 i1Var) {
        return this.f2020t == 1 ? this.f2016p : super.x(b1Var, i1Var);
    }

    @Override // androidx.recyclerview.widget.u0
    public final boolean y0() {
        return this.F == null;
    }

    public final int z0(int i4) {
        if (v() == 0) {
            return this.f2024x ? 1 : -1;
        }
        return (i4 < J0()) != this.f2024x ? -1 : 1;
    }
}