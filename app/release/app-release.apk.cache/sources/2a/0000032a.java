package androidx.recyclerview.widget;

import android.view.View;

/* loaded from: classes.dex */
public final class x1 {

    /* renamed from: a  reason: collision with root package name */
    public final Object f2315a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f2316b;

    public x1() {
        this.f2315a = new l.k();
        this.f2316b = new l.e();
    }

    public final void a(l1 l1Var) {
        Object obj = this.f2315a;
        w1 w1Var = (w1) ((l.k) obj).getOrDefault(l1Var, null);
        if (w1Var == null) {
            w1Var = w1.a();
            ((l.k) obj).put(l1Var, w1Var);
        }
        w1Var.f2308a |= 1;
    }

    public final void b(l1 l1Var, o0 o0Var) {
        l.k kVar = (l.k) this.f2315a;
        w1 w1Var = (w1) kVar.getOrDefault(l1Var, null);
        if (w1Var == null) {
            w1Var = w1.a();
            kVar.put(l1Var, w1Var);
        }
        w1Var.f2310c = o0Var;
        w1Var.f2308a |= 8;
    }

    public final void c(l1 l1Var, o0 o0Var) {
        l.k kVar = (l.k) this.f2315a;
        w1 w1Var = (w1) kVar.getOrDefault(l1Var, null);
        if (w1Var == null) {
            w1Var = w1.a();
            kVar.put(l1Var, w1Var);
        }
        w1Var.f2309b = o0Var;
        w1Var.f2308a |= 4;
    }

    public final View d(int i4, int i5, int i6, int i7) {
        int i8;
        v1 v1Var = (v1) this.f2315a;
        int c4 = v1Var.c();
        int b5 = v1Var.b();
        if (i5 > i4) {
            i8 = 1;
        } else {
            i8 = -1;
        }
        View view = null;
        while (i4 != i5) {
            View a5 = v1Var.a(i4);
            int e4 = v1Var.e(a5);
            int d4 = v1Var.d(a5);
            u1 u1Var = (u1) this.f2316b;
            u1Var.f2289b = c4;
            u1Var.f2290c = b5;
            u1Var.f2291d = e4;
            u1Var.f2292e = d4;
            if (i6 != 0) {
                u1Var.f2288a = i6;
                if (u1Var.a()) {
                    return a5;
                }
            }
            if (i7 != 0) {
                u1Var.f2288a = i7;
                if (u1Var.a()) {
                    view = a5;
                }
            }
            i4 += i8;
        }
        return view;
    }

    public final boolean e(View view) {
        u1 u1Var = (u1) this.f2316b;
        v1 v1Var = (v1) this.f2315a;
        int c4 = v1Var.c();
        int b5 = v1Var.b();
        int e4 = v1Var.e(view);
        int d4 = v1Var.d(view);
        u1Var.f2289b = c4;
        u1Var.f2290c = b5;
        u1Var.f2291d = e4;
        u1Var.f2292e = d4;
        u1Var.f2288a = 24579;
        return u1Var.a();
    }

    public final o0 f(l1 l1Var, int i4) {
        w1 w1Var;
        o0 o0Var;
        l.k kVar = (l.k) this.f2315a;
        int e4 = kVar.e(l1Var);
        if (e4 >= 0 && (w1Var = (w1) kVar.j(e4)) != null) {
            int i5 = w1Var.f2308a;
            if ((i5 & i4) != 0) {
                int i6 = i5 & (~i4);
                w1Var.f2308a = i6;
                if (i4 == 4) {
                    o0Var = w1Var.f2309b;
                } else if (i4 == 8) {
                    o0Var = w1Var.f2310c;
                } else {
                    throw new IllegalArgumentException("Must provide flag PRE or POST");
                }
                if ((i6 & 12) == 0) {
                    kVar.i(e4);
                    w1Var.f2308a = 0;
                    w1Var.f2309b = null;
                    w1Var.f2310c = null;
                    w1.f2307d.b(w1Var);
                }
                return o0Var;
            }
        }
        return null;
    }

    public final void g(l1 l1Var) {
        w1 w1Var = (w1) ((l.k) this.f2315a).getOrDefault(l1Var, null);
        if (w1Var == null) {
            return;
        }
        w1Var.f2308a &= -2;
    }

    public final void h(l1 l1Var) {
        l.e eVar = (l.e) this.f2316b;
        int f4 = eVar.f() - 1;
        while (true) {
            if (f4 < 0) {
                break;
            } else if (l1Var == eVar.g(f4)) {
                Object[] objArr = eVar.f5227c;
                Object obj = objArr[f4];
                Object obj2 = l.e.f5224e;
                if (obj != obj2) {
                    objArr[f4] = obj2;
                    eVar.f5225a = true;
                }
            } else {
                f4--;
            }
        }
        w1 w1Var = (w1) ((l.k) this.f2315a).remove(l1Var);
        if (w1Var != null) {
            w1Var.f2308a = 0;
            w1Var.f2309b = null;
            w1Var.f2310c = null;
            w1.f2307d.b(w1Var);
        }
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [androidx.recyclerview.widget.u1, java.lang.Object] */
    public x1(v1 v1Var) {
        this.f2315a = v1Var;
        ?? obj = new Object();
        obj.f2288a = 0;
        this.f2316b = obj;
    }
}