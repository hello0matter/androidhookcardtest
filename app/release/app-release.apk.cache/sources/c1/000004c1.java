package com.google.android.material.carousel;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.appcompat.widget.c0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.b1;
import androidx.recyclerview.widget.e0;
import androidx.recyclerview.widget.g1;
import androidx.recyclerview.widget.i1;
import androidx.recyclerview.widget.u0;
import com.google.common.collect.c;
import i0.h0;
import i0.y0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.WeakHashMap;
import p1.a;
import v1.b;
import v1.d;
import v1.e;
import v1.f;
import v1.g;
import v1.h;
import v1.i;
import v1.j;
import v1.k;
import v1.l;

/* loaded from: classes.dex */
public class CarouselLayoutManager extends u0 implements b, g1 {

    /* renamed from: p  reason: collision with root package name */
    public int f3173p;

    /* renamed from: q  reason: collision with root package name */
    public int f3174q;

    /* renamed from: r  reason: collision with root package name */
    public int f3175r;

    /* renamed from: s  reason: collision with root package name */
    public final d f3176s;

    /* renamed from: t  reason: collision with root package name */
    public final c f3177t;

    /* renamed from: u  reason: collision with root package name */
    public k f3178u;

    /* renamed from: v  reason: collision with root package name */
    public j f3179v;

    /* renamed from: w  reason: collision with root package name */
    public int f3180w;

    /* renamed from: x  reason: collision with root package name */
    public HashMap f3181x;

    /* renamed from: y  reason: collision with root package name */
    public g f3182y;

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, com.google.common.collect.c] */
    public CarouselLayoutManager() {
        ?? obj = new Object();
        this.f3176s = new d();
        this.f3180w = 0;
        this.f3177t = obj;
        this.f3178u = null;
        k0();
        R0(0);
    }

    public static float H0(float f4, c0 c0Var) {
        i iVar = (i) c0Var.f725b;
        float f5 = iVar.f6978d;
        i iVar2 = (i) c0Var.f726c;
        return a.b(f5, iVar2.f6978d, iVar.f6976b, iVar2.f6976b, f4);
    }

    public static c0 J0(float f4, List list, boolean z4) {
        float f5;
        float f6 = Float.MAX_VALUE;
        int i4 = -1;
        int i5 = -1;
        int i6 = -1;
        int i7 = -1;
        float f7 = -3.4028235E38f;
        float f8 = Float.MAX_VALUE;
        float f9 = Float.MAX_VALUE;
        for (int i8 = 0; i8 < list.size(); i8++) {
            i iVar = (i) list.get(i8);
            if (z4) {
                f5 = iVar.f6976b;
            } else {
                f5 = iVar.f6975a;
            }
            float abs = Math.abs(f5 - f4);
            if (f5 <= f4 && abs <= f6) {
                i4 = i8;
                f6 = abs;
            }
            if (f5 > f4 && abs <= f8) {
                i6 = i8;
                f8 = abs;
            }
            if (f5 <= f9) {
                i5 = i8;
                f9 = f5;
            }
            if (f5 > f7) {
                i7 = i8;
                f7 = f5;
            }
        }
        if (i4 == -1) {
            i4 = i5;
        }
        if (i6 == -1) {
            i6 = i7;
        }
        return new c0((i) list.get(i4), (i) list.get(i6));
    }

    public final int A0(int i4, int i5) {
        return L0() ? i4 - i5 : i4 + i5;
    }

    public final void B0(int i4, b1 b1Var, i1 i1Var) {
        int E0 = E0(i4);
        while (i4 < i1Var.b()) {
            v1.c O0 = O0(b1Var, E0, i4);
            float f4 = O0.f6961c;
            c0 c0Var = O0.f6962d;
            if (!M0(f4, c0Var)) {
                E0 = A0(E0, (int) this.f3179v.f6979a);
                if (!N0(f4, c0Var)) {
                    z0(O0.f6959a, -1, O0);
                }
                i4++;
            } else {
                return;
            }
        }
    }

    public final void C0(int i4, b1 b1Var) {
        int E0 = E0(i4);
        while (i4 >= 0) {
            v1.c O0 = O0(b1Var, E0, i4);
            float f4 = O0.f6961c;
            c0 c0Var = O0.f6962d;
            if (!N0(f4, c0Var)) {
                int i5 = (int) this.f3179v.f6979a;
                if (L0()) {
                    E0 += i5;
                } else {
                    E0 -= i5;
                }
                if (!M0(f4, c0Var)) {
                    z0(O0.f6959a, 0, O0);
                }
                i4--;
            } else {
                return;
            }
        }
    }

    public final float D0(View view, float f4, c0 c0Var) {
        i iVar = (i) c0Var.f725b;
        float f5 = iVar.f6976b;
        i iVar2 = (i) c0Var.f726c;
        float b5 = a.b(f5, iVar2.f6976b, iVar.f6975a, iVar2.f6975a, f4);
        if (((i) c0Var.f726c) == this.f3179v.b() || ((i) c0Var.f725b) == this.f3179v.d()) {
            float b6 = this.f3182y.b((RecyclerView.LayoutParams) view.getLayoutParams()) / this.f3179v.f6979a;
            i iVar3 = (i) c0Var.f726c;
            return b5 + (((1.0f - iVar3.f6977c) + b6) * (f4 - iVar3.f6975a));
        }
        return b5;
    }

    public final int E0(int i4) {
        return A0(this.f3182y.h() - this.f3173p, (int) (this.f3179v.f6979a * i4));
    }

    public final void F0(b1 b1Var, i1 i1Var) {
        while (v() > 0) {
            View u4 = u(0);
            Rect rect = new Rect();
            super.y(u4, rect);
            float centerX = rect.centerX();
            if (!N0(centerX, J0(centerX, this.f3179v.f6980b, true))) {
                break;
            }
            h0(u4, b1Var);
        }
        while (v() - 1 >= 0) {
            View u5 = u(v() - 1);
            Rect rect2 = new Rect();
            super.y(u5, rect2);
            float centerX2 = rect2.centerX();
            if (!M0(centerX2, J0(centerX2, this.f3179v.f6980b, true))) {
                break;
            }
            h0(u5, b1Var);
        }
        if (v() == 0) {
            C0(this.f3180w - 1, b1Var);
            B0(this.f3180w, b1Var, i1Var);
            return;
        }
        int F = u0.F(u(0));
        int F2 = u0.F(u(v() - 1));
        C0(F - 1, b1Var);
        B0(F2 + 1, b1Var, i1Var);
    }

    public final j G0(int i4) {
        j jVar;
        HashMap hashMap = this.f3181x;
        if (hashMap != null && (jVar = (j) hashMap.get(Integer.valueOf(c.L(i4, 0, Math.max(0, z() - 1))))) != null) {
            return jVar;
        }
        return this.f3178u.f6983a;
    }

    public final int I0(int i4, j jVar) {
        int i5;
        if (L0()) {
            if (K0()) {
                i5 = this.f2286n;
            } else {
                i5 = this.f2287o;
            }
            float f4 = jVar.f6979a;
            return (int) (((i5 - jVar.c().f6975a) - (i4 * f4)) - (f4 / 2.0f));
        }
        return (int) ((jVar.f6979a / 2.0f) + ((i4 * jVar.f6979a) - jVar.a().f6975a));
    }

    public final boolean K0() {
        return this.f3182y.f6967a == 0;
    }

    public final boolean L0() {
        return K0() && A() == 1;
    }

    public final boolean M0(float f4, c0 c0Var) {
        int i4;
        int i5;
        float H0 = H0(f4, c0Var);
        int i6 = (int) f4;
        int i7 = (int) (H0 / 2.0f);
        if (L0()) {
            i4 = i6 + i7;
        } else {
            i4 = i6 - i7;
        }
        if (L0()) {
            if (i4 >= 0) {
                return false;
            }
        } else {
            if (K0()) {
                i5 = this.f2286n;
            } else {
                i5 = this.f2287o;
            }
            if (i4 <= i5) {
                return false;
            }
        }
        return true;
    }

    public final boolean N0(float f4, c0 c0Var) {
        int i4;
        int A0 = A0((int) f4, (int) (H0(f4, c0Var) / 2.0f));
        if (L0()) {
            if (K0()) {
                i4 = this.f2286n;
            } else {
                i4 = this.f2287o;
            }
            if (A0 <= i4) {
                return false;
            }
        } else if (A0 >= 0) {
            return false;
        }
        return true;
    }

    public final v1.c O0(b1 b1Var, float f4, int i4) {
        View view = b1Var.i(i4, Long.MAX_VALUE).f2170a;
        P0(view);
        float A0 = A0((int) f4, (int) (this.f3179v.f6979a / 2.0f));
        c0 J0 = J0(A0, this.f3179v.f6980b, false);
        return new v1.c(view, A0, D0(view, A0, J0), J0);
    }

    public final void P0(View view) {
        float f4;
        float f5;
        if (view instanceof l) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            Rect rect = new Rect();
            RecyclerView recyclerView = this.f2274b;
            if (recyclerView == null) {
                rect.set(0, 0, 0, 0);
            } else {
                rect.set(recyclerView.K(view));
            }
            int i4 = rect.left + rect.right;
            int i5 = rect.top + rect.bottom;
            k kVar = this.f3178u;
            if (kVar != null && this.f3182y.f6967a == 0) {
                f4 = kVar.f6983a.f6979a;
            } else {
                f4 = ((ViewGroup.MarginLayoutParams) layoutParams).width;
            }
            if (kVar != null && this.f3182y.f6967a == 1) {
                f5 = kVar.f6983a.f6979a;
            } else {
                f5 = ((ViewGroup.MarginLayoutParams) layoutParams).height;
            }
            int i6 = (int) f5;
            view.measure(u0.w(K0(), this.f2286n, this.f2284l, D() + C() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + i4, (int) f4), u0.w(e(), this.f2287o, this.f2285m, B() + E() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + i5, i6));
            return;
        }
        throw new IllegalStateException("All children of a RecyclerView using CarouselLayoutManager must use MaskableFrameLayout as their root ViewGroup.");
    }

    @Override // androidx.recyclerview.widget.u0
    public final void Q(AccessibilityEvent accessibilityEvent) {
        super.Q(accessibilityEvent);
        if (v() > 0) {
            accessibilityEvent.setFromIndex(u0.F(u(0)));
            accessibilityEvent.setToIndex(u0.F(u(v() - 1)));
        }
    }

    public final int Q0(int i4, b1 b1Var, i1 i1Var) {
        if (v() == 0 || i4 == 0) {
            return 0;
        }
        int i5 = this.f3173p;
        int i6 = this.f3174q;
        int i7 = this.f3175r;
        int i8 = i5 + i4;
        if (i8 < i6) {
            i4 = i6 - i5;
        } else if (i8 > i7) {
            i4 = i7 - i5;
        }
        this.f3173p = i5 + i4;
        T0();
        float f4 = this.f3179v.f6979a / 2.0f;
        int E0 = E0(u0.F(u(0)));
        Rect rect = new Rect();
        for (int i9 = 0; i9 < v(); i9++) {
            View u4 = u(i9);
            float A0 = A0(E0, (int) f4);
            c0 J0 = J0(A0, this.f3179v.f6980b, false);
            float D0 = D0(u4, A0, J0);
            super.y(u4, rect);
            S0(u4, A0, J0);
            this.f3182y.l(f4, D0, rect, u4);
            E0 = A0(E0, (int) this.f3179v.f6979a);
        }
        F0(b1Var, i1Var);
        return i4;
    }

    public final void R0(int i4) {
        g fVar;
        if (i4 != 0 && i4 != 1) {
            throw new IllegalArgumentException(androidx.activity.j.b("invalid orientation:", i4));
        }
        c(null);
        g gVar = this.f3182y;
        if (gVar == null || i4 != gVar.f6967a) {
            if (i4 != 0) {
                if (i4 == 1) {
                    fVar = new e(this);
                } else {
                    throw new IllegalArgumentException("invalid orientation");
                }
            } else {
                fVar = new f(this);
            }
            this.f3182y = fVar;
            this.f3178u = null;
            k0();
        }
    }

    public final void S0(View view, float f4, c0 c0Var) {
        if (!(view instanceof l)) {
            return;
        }
        i iVar = (i) c0Var.f725b;
        float f5 = iVar.f6977c;
        i iVar2 = (i) c0Var.f726c;
        float b5 = a.b(f5, iVar2.f6977c, iVar.f6975a, iVar2.f6975a, f4);
        float height = view.getHeight();
        float width = view.getWidth();
        RectF c4 = this.f3182y.c(height, width, a.b(0.0f, height / 2.0f, 0.0f, 1.0f, b5), a.b(0.0f, width / 2.0f, 0.0f, 1.0f, b5));
        float D0 = D0(view, f4, c0Var);
        RectF rectF = new RectF(D0 - (c4.width() / 2.0f), D0 - (c4.height() / 2.0f), (c4.width() / 2.0f) + D0, (c4.height() / 2.0f) + D0);
        RectF rectF2 = new RectF(this.f3182y.f(), this.f3182y.i(), this.f3182y.g(), this.f3182y.d());
        this.f3177t.getClass();
        this.f3182y.a(c4, rectF, rectF2);
        this.f3182y.k(c4, rectF, rectF2);
        ((l) view).setMaskRectF(c4);
    }

    public final void T0() {
        j jVar;
        float b5;
        List list;
        float[] fArr;
        float[] fArr2;
        j jVar2;
        int i4 = this.f3175r;
        int i5 = this.f3174q;
        if (i4 <= i5) {
            if (L0()) {
                List list2 = this.f3178u.f6985c;
                jVar2 = (j) list2.get(list2.size() - 1);
            } else {
                List list3 = this.f3178u.f6984b;
                jVar2 = (j) list3.get(list3.size() - 1);
            }
            this.f3179v = jVar2;
        } else {
            k kVar = this.f3178u;
            float f4 = this.f3173p;
            float f5 = i5;
            float f6 = i4;
            float f7 = kVar.f6988f + f5;
            float f8 = f6 - kVar.f6989g;
            if (f4 < f7) {
                b5 = a.b(1.0f, 0.0f, f5, f7, f4);
                list = kVar.f6984b;
                fArr = kVar.f6986d;
            } else if (f4 > f8) {
                b5 = a.b(0.0f, 1.0f, f8, f6, f4);
                list = kVar.f6985c;
                fArr = kVar.f6987e;
            } else {
                jVar = kVar.f6983a;
                this.f3179v = jVar;
            }
            int size = list.size();
            float f9 = fArr[0];
            int i6 = 1;
            while (true) {
                if (i6 < size) {
                    float f10 = fArr[i6];
                    if (b5 <= f10) {
                        fArr2 = new float[]{a.b(0.0f, 1.0f, f9, f10, b5), (float) (i6 - 1), i6};
                        break;
                    } else {
                        i6++;
                        f9 = f10;
                    }
                } else {
                    fArr2 = new float[]{0.0f, 0.0f, 0.0f};
                    break;
                }
            }
            j jVar3 = (j) list.get((int) fArr2[1]);
            j jVar4 = (j) list.get((int) fArr2[2]);
            float f11 = fArr2[0];
            if (jVar3.f6979a == jVar4.f6979a) {
                List list4 = jVar3.f6980b;
                int size2 = list4.size();
                List list5 = jVar4.f6980b;
                if (size2 == list5.size()) {
                    ArrayList arrayList = new ArrayList();
                    for (int i7 = 0; i7 < list4.size(); i7++) {
                        i iVar = (i) list4.get(i7);
                        i iVar2 = (i) list5.get(i7);
                        arrayList.add(new i(a.a(iVar.f6975a, iVar2.f6975a, f11), a.a(iVar.f6976b, iVar2.f6976b, f11), a.a(iVar.f6977c, iVar2.f6977c, f11), a.a(iVar.f6978d, iVar2.f6978d, f11)));
                    }
                    jVar = new j(jVar3.f6979a, arrayList, a.c(jVar3.f6981c, f11, jVar4.f6981c), a.c(jVar3.f6982d, f11, jVar4.f6982d));
                    this.f3179v = jVar;
                } else {
                    throw new IllegalArgumentException("Keylines being linearly interpolated must have the same number of keylines.");
                }
            } else {
                throw new IllegalArgumentException("Keylines being linearly interpolated must have the same item size.");
            }
        }
        List list6 = this.f3179v.f6980b;
        d dVar = this.f3176s;
        dVar.getClass();
        dVar.f6964b = Collections.unmodifiableList(list6);
    }

    @Override // androidx.recyclerview.widget.u0
    public final void Z(b1 b1Var, i1 i1Var) {
        boolean z4;
        boolean z5;
        j jVar;
        i a5;
        int i4;
        int i5;
        int i6;
        int i7;
        j jVar2;
        i c4;
        int i8;
        float f4;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        List list;
        int i16;
        int i17;
        boolean z6;
        int i18;
        int i19;
        int i20;
        boolean z7;
        if (i1Var.b() <= 0) {
            f0(b1Var);
            this.f3180w = 0;
            return;
        }
        boolean L0 = L0();
        boolean z8 = true;
        if (this.f3178u == null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z4) {
            View view = b1Var.i(0, Long.MAX_VALUE).f2170a;
            P0(view);
            j m12 = this.f3177t.m1(this, view);
            if (L0) {
                h hVar = new h(m12.f6979a);
                float f5 = m12.b().f6976b - (m12.b().f6978d / 2.0f);
                List list2 = m12.f6980b;
                int size = list2.size() - 1;
                while (size >= 0) {
                    i iVar = (i) list2.get(size);
                    float f6 = iVar.f6978d;
                    float f7 = (f6 / 2.0f) + f5;
                    if (size >= m12.f6981c && size <= m12.f6982d) {
                        z7 = z8;
                    } else {
                        z7 = false;
                    }
                    hVar.a(f7, iVar.f6977c, f6, z7);
                    f5 += iVar.f6978d;
                    size--;
                    z8 = true;
                }
                m12 = hVar.b();
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(m12);
            int i21 = 0;
            while (true) {
                list = m12.f6980b;
                if (i21 < list.size()) {
                    if (((i) list.get(i21)).f6976b >= 0.0f) {
                        break;
                    }
                    i21++;
                } else {
                    i21 = -1;
                    break;
                }
            }
            int i22 = ((m12.a().f6976b - (m12.a().f6978d / 2.0f)) > 0.0f ? 1 : ((m12.a().f6976b - (m12.a().f6978d / 2.0f)) == 0.0f ? 0 : -1));
            int i23 = m12.f6982d;
            int i24 = m12.f6981c;
            if (i22 > 0 && m12.a() != m12.b() && i21 != -1) {
                int i25 = (i24 - 1) - i21;
                float f8 = m12.b().f6976b - (m12.b().f6978d / 2.0f);
                int i26 = 0;
                while (i26 <= i25) {
                    j jVar3 = (j) arrayList.get(arrayList.size() - 1);
                    int size2 = list.size() - 1;
                    int i27 = (i21 + i26) - 1;
                    if (i27 >= 0) {
                        float f9 = ((i) list.get(i27)).f6977c;
                        int i28 = jVar3.f6982d;
                        i18 = i25;
                        while (true) {
                            List list3 = jVar3.f6980b;
                            z6 = z4;
                            if (i28 < list3.size()) {
                                if (f9 == ((i) list3.get(i28)).f6977c) {
                                    i20 = 1;
                                    break;
                                } else {
                                    i28++;
                                    z4 = z6;
                                }
                            } else {
                                i20 = 1;
                                i28 = list3.size() - 1;
                                break;
                            }
                        }
                        i19 = i28 - i20;
                    } else {
                        z6 = z4;
                        i18 = i25;
                        i19 = size2;
                    }
                    arrayList.add(k.b(jVar3, i21, i19, f8, (i24 - i26) - 1, (i23 - i26) - 1));
                    i26++;
                    i25 = i18;
                    z4 = z6;
                }
            }
            z5 = z4;
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(m12);
            int i29 = this.f2287o;
            if (K0()) {
                i29 = this.f2286n;
            }
            int size3 = list.size() - 1;
            while (true) {
                if (size3 >= 0) {
                    if (((i) list.get(size3)).f6976b <= i29) {
                        break;
                    }
                    size3--;
                } else {
                    size3 = -1;
                    break;
                }
            }
            int i30 = this.f2287o;
            if (K0()) {
                i30 = this.f2286n;
            }
            if ((m12.c().f6978d / 2.0f) + m12.c().f6976b < i30 && m12.c() != m12.d() && size3 != -1) {
                int i31 = size3 - i23;
                float f10 = m12.b().f6976b - (m12.b().f6978d / 2.0f);
                int i32 = 0;
                while (i32 < i31) {
                    j jVar4 = (j) arrayList2.get(arrayList2.size() - 1);
                    int i33 = (size3 - i32) + 1;
                    if (i33 < list.size()) {
                        float f11 = ((i) list.get(i33)).f6977c;
                        int i34 = jVar4.f6981c - 1;
                        while (true) {
                            i16 = i31;
                            if (i34 >= 0) {
                                if (f11 == ((i) jVar4.f6980b.get(i34)).f6977c) {
                                    break;
                                }
                                i34--;
                                i31 = i16;
                            } else {
                                i34 = 0;
                                break;
                            }
                        }
                        i17 = i34 + 1;
                    } else {
                        i16 = i31;
                        i17 = 0;
                    }
                    arrayList2.add(k.b(jVar4, size3, i17, f10, i24 + i32 + 1, i23 + i32 + 1));
                    i32++;
                    i31 = i16;
                }
            }
            this.f3178u = new k(m12, arrayList, arrayList2);
        } else {
            z5 = z4;
        }
        k kVar = this.f3178u;
        boolean L02 = L0();
        if (L02) {
            List list4 = kVar.f6985c;
            jVar = (j) list4.get(list4.size() - 1);
        } else {
            List list5 = kVar.f6984b;
            jVar = (j) list5.get(list5.size() - 1);
        }
        if (L02) {
            a5 = jVar.c();
        } else {
            a5 = jVar.a();
        }
        RecyclerView recyclerView = this.f2274b;
        if (recyclerView != null) {
            WeakHashMap weakHashMap = y0.f4999a;
            i4 = h0.f(recyclerView);
        } else {
            i4 = 0;
        }
        if (L02) {
            i5 = 1;
        } else {
            i5 = -1;
        }
        float f12 = i4 * i5;
        int i35 = (int) a5.f6975a;
        int i36 = (int) (jVar.f6979a / 2.0f);
        if (L0()) {
            i6 = i35 + i36;
        } else {
            i6 = i35 - i36;
        }
        int h4 = (int) ((f12 + this.f3182y.h()) - i6);
        k kVar2 = this.f3178u;
        boolean L03 = L0();
        if (L03) {
            List list6 = kVar2.f6984b;
            i7 = 1;
            jVar2 = (j) list6.get(list6.size() - 1);
        } else {
            i7 = 1;
            List list7 = kVar2.f6985c;
            jVar2 = (j) list7.get(list7.size() - 1);
        }
        if (L03) {
            c4 = jVar2.a();
        } else {
            c4 = jVar2.c();
        }
        float b5 = (i1Var.b() - i7) * jVar2.f6979a;
        RecyclerView recyclerView2 = this.f2274b;
        if (recyclerView2 != null) {
            WeakHashMap weakHashMap2 = y0.f4999a;
            i8 = h0.e(recyclerView2);
        } else {
            i8 = 0;
        }
        float f13 = b5 + i8;
        if (L03) {
            f4 = -1.0f;
        } else {
            f4 = 1.0f;
        }
        float f14 = f13 * f4;
        float h5 = c4.f6975a - this.f3182y.h();
        float e4 = this.f3182y.e() - c4.f6975a;
        if (Math.abs(h5) > Math.abs(f14)) {
            i9 = 0;
        } else {
            i9 = (int) ((f14 - h5) + e4);
        }
        if (L0) {
            i10 = i9;
        } else {
            i10 = h4;
        }
        this.f3174q = i10;
        if (L0) {
            i9 = h4;
        }
        this.f3175r = i9;
        if (z5) {
            this.f3173p = h4;
            k kVar3 = this.f3178u;
            int z9 = z();
            int i37 = this.f3174q;
            int i38 = this.f3175r;
            boolean L04 = L0();
            float f15 = kVar3.f6983a.f6979a;
            HashMap hashMap = new HashMap();
            int i39 = 0;
            for (int i40 = 0; i40 < z9; i40++) {
                if (L04) {
                    i14 = (z9 - i40) - 1;
                } else {
                    i14 = i40;
                }
                float f16 = i14 * f15;
                if (L04) {
                    i15 = -1;
                } else {
                    i15 = 1;
                }
                int i41 = ((f16 * i15) > (i38 - kVar3.f6989g) ? 1 : ((f16 * i15) == (i38 - kVar3.f6989g) ? 0 : -1));
                List list8 = kVar3.f6985c;
                if (i41 > 0 || i40 >= z9 - list8.size()) {
                    hashMap.put(Integer.valueOf(i14), (j) list8.get(c.L(i39, 0, list8.size() - 1)));
                    i39++;
                }
            }
            int i42 = 0;
            for (int i43 = z9 - 1; i43 >= 0; i43--) {
                if (L04) {
                    i12 = (z9 - i43) - 1;
                } else {
                    i12 = i43;
                }
                float f17 = i12 * f15;
                if (L04) {
                    i13 = -1;
                } else {
                    i13 = 1;
                }
                int i44 = ((f17 * i13) > (i37 + kVar3.f6988f) ? 1 : ((f17 * i13) == (i37 + kVar3.f6988f) ? 0 : -1));
                List list9 = kVar3.f6984b;
                if (i44 < 0 || i43 < list9.size()) {
                    hashMap.put(Integer.valueOf(i12), (j) list9.get(c.L(i42, 0, list9.size() - 1)));
                    i42++;
                }
            }
            this.f3181x = hashMap;
        } else {
            int i45 = this.f3173p;
            if (i45 < i10) {
                i11 = i10 - i45;
            } else if (i45 > i9) {
                i11 = i9 - i45;
            } else {
                i11 = 0;
            }
            this.f3173p = i11 + i45;
        }
        this.f3180w = c.L(this.f3180w, 0, i1Var.b());
        T0();
        p(b1Var);
        F0(b1Var, i1Var);
    }

    @Override // androidx.recyclerview.widget.g1
    public final PointF a(int i4) {
        if (this.f3178u == null) {
            return null;
        }
        int I0 = I0(i4, G0(i4)) - this.f3173p;
        if (K0()) {
            return new PointF(I0, 0.0f);
        }
        return new PointF(0.0f, I0);
    }

    @Override // androidx.recyclerview.widget.u0
    public final void a0(i1 i1Var) {
        if (v() == 0) {
            this.f3180w = 0;
        } else {
            this.f3180w = u0.F(u(0));
        }
    }

    @Override // androidx.recyclerview.widget.u0
    public final boolean d() {
        return K0();
    }

    @Override // androidx.recyclerview.widget.u0
    public final boolean e() {
        return !K0();
    }

    @Override // androidx.recyclerview.widget.u0
    public final int j(i1 i1Var) {
        return (int) this.f3178u.f6983a.f6979a;
    }

    @Override // androidx.recyclerview.widget.u0
    public final boolean j0(RecyclerView recyclerView, View view, Rect rect, boolean z4, boolean z5) {
        if (this.f3178u == null) {
            return false;
        }
        int I0 = I0(u0.F(view), G0(u0.F(view))) - this.f3173p;
        if (z5 || I0 == 0) {
            return false;
        }
        recyclerView.scrollBy(I0, 0);
        return true;
    }

    @Override // androidx.recyclerview.widget.u0
    public final int k(i1 i1Var) {
        return this.f3173p;
    }

    @Override // androidx.recyclerview.widget.u0
    public final int l(i1 i1Var) {
        return this.f3175r - this.f3174q;
    }

    @Override // androidx.recyclerview.widget.u0
    public final int l0(int i4, b1 b1Var, i1 i1Var) {
        if (K0()) {
            return Q0(i4, b1Var, i1Var);
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.u0
    public final int m(i1 i1Var) {
        return (int) this.f3178u.f6983a.f6979a;
    }

    @Override // androidx.recyclerview.widget.u0
    public final void m0(int i4) {
        if (this.f3178u == null) {
            return;
        }
        this.f3173p = I0(i4, G0(i4));
        this.f3180w = c.L(i4, 0, Math.max(0, z() - 1));
        T0();
        k0();
    }

    @Override // androidx.recyclerview.widget.u0
    public final int n(i1 i1Var) {
        return this.f3173p;
    }

    @Override // androidx.recyclerview.widget.u0
    public final int n0(int i4, b1 b1Var, i1 i1Var) {
        if (e()) {
            return Q0(i4, b1Var, i1Var);
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.u0
    public final int o(i1 i1Var) {
        return this.f3175r - this.f3174q;
    }

    @Override // androidx.recyclerview.widget.u0
    public final RecyclerView.LayoutParams r() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    @Override // androidx.recyclerview.widget.u0
    public final void w0(RecyclerView recyclerView, int i4) {
        e0 e0Var = new e0(this, recyclerView.getContext(), 1);
        e0Var.f2111a = i4;
        x0(e0Var);
    }

    @Override // androidx.recyclerview.widget.u0
    public final void y(View view, Rect rect) {
        super.y(view, rect);
        float centerX = rect.centerX();
        float width = (rect.width() - H0(centerX, J0(centerX, this.f3179v.f6980b, true))) / 2.0f;
        rect.set((int) (rect.left + width), rect.top, (int) (rect.right - width), rect.bottom);
    }

    public final void z0(View view, int i4, v1.c cVar) {
        float f4 = this.f3179v.f6979a / 2.0f;
        b(view, i4, false);
        float f5 = cVar.f6961c;
        this.f3182y.j(view, (int) (f5 - f4), (int) (f5 + f4));
        S0(view, cVar.f6960b, cVar.f6962d);
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object, com.google.common.collect.c] */
    @SuppressLint({"UnknownNullness"})
    public CarouselLayoutManager(Context context, AttributeSet attributeSet, int i4, int i5) {
        this.f3176s = new d();
        this.f3180w = 0;
        R0(u0.G(context, attributeSet, i4, i5).f2261a);
        this.f3177t = new Object();
        this.f3178u = null;
        k0();
    }
}