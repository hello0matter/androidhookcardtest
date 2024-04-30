package androidx.recyclerview.widget;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class k extends p0 {

    /* renamed from: s  reason: collision with root package name */
    public static TimeInterpolator f2147s;

    /* renamed from: g  reason: collision with root package name */
    public boolean f2148g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList f2149h;

    /* renamed from: i  reason: collision with root package name */
    public ArrayList f2150i;

    /* renamed from: j  reason: collision with root package name */
    public ArrayList f2151j;

    /* renamed from: k  reason: collision with root package name */
    public ArrayList f2152k;

    /* renamed from: l  reason: collision with root package name */
    public ArrayList f2153l;

    /* renamed from: m  reason: collision with root package name */
    public ArrayList f2154m;

    /* renamed from: n  reason: collision with root package name */
    public ArrayList f2155n;

    /* renamed from: o  reason: collision with root package name */
    public ArrayList f2156o;

    /* renamed from: p  reason: collision with root package name */
    public ArrayList f2157p;

    /* renamed from: q  reason: collision with root package name */
    public ArrayList f2158q;

    /* renamed from: r  reason: collision with root package name */
    public ArrayList f2159r;

    public static void h(ArrayList arrayList) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            ((l1) arrayList.get(size)).f2170a.animate().cancel();
        }
    }

    /* JADX WARN: Type inference failed for: r12v4, types: [androidx.recyclerview.widget.i, java.lang.Object] */
    @Override // androidx.recyclerview.widget.p0
    public final boolean a(l1 l1Var, l1 l1Var2, o0 o0Var, o0 o0Var2) {
        int i4;
        int i5;
        int i6 = o0Var.f2197a;
        int i7 = o0Var.f2198b;
        if (l1Var2.q()) {
            int i8 = o0Var.f2197a;
            i5 = o0Var.f2198b;
            i4 = i8;
        } else {
            i4 = o0Var2.f2197a;
            i5 = o0Var2.f2198b;
        }
        if (l1Var == l1Var2) {
            return g(l1Var, i6, i7, i4, i5);
        }
        View view = l1Var.f2170a;
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        float alpha = view.getAlpha();
        l(l1Var);
        view.setTranslationX(translationX);
        view.setTranslationY(translationY);
        view.setAlpha(alpha);
        l(l1Var2);
        View view2 = l1Var2.f2170a;
        view2.setTranslationX(-((int) ((i4 - i6) - translationX)));
        view2.setTranslationY(-((int) ((i5 - i7) - translationY)));
        view2.setAlpha(0.0f);
        ArrayList arrayList = this.f2152k;
        ?? obj = new Object();
        obj.f2119a = l1Var;
        obj.f2120b = l1Var2;
        obj.f2121c = i6;
        obj.f2122d = i7;
        obj.f2123e = i4;
        obj.f2124f = i5;
        arrayList.add(obj);
        return true;
    }

    @Override // androidx.recyclerview.widget.p0
    public final void d(l1 l1Var) {
        View view = l1Var.f2170a;
        view.animate().cancel();
        ArrayList arrayList = this.f2151j;
        int size = arrayList.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            } else if (((j) arrayList.get(size)).f2140a == l1Var) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                c(l1Var);
                arrayList.remove(size);
            }
        }
        j(l1Var, this.f2152k);
        if (this.f2149h.remove(l1Var)) {
            view.setAlpha(1.0f);
            c(l1Var);
        }
        if (this.f2150i.remove(l1Var)) {
            view.setAlpha(1.0f);
            c(l1Var);
        }
        ArrayList arrayList2 = this.f2155n;
        for (int size2 = arrayList2.size() - 1; size2 >= 0; size2--) {
            ArrayList arrayList3 = (ArrayList) arrayList2.get(size2);
            j(l1Var, arrayList3);
            if (arrayList3.isEmpty()) {
                arrayList2.remove(size2);
            }
        }
        ArrayList arrayList4 = this.f2154m;
        for (int size3 = arrayList4.size() - 1; size3 >= 0; size3--) {
            ArrayList arrayList5 = (ArrayList) arrayList4.get(size3);
            int size4 = arrayList5.size() - 1;
            while (true) {
                if (size4 < 0) {
                    break;
                } else if (((j) arrayList5.get(size4)).f2140a == l1Var) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    c(l1Var);
                    arrayList5.remove(size4);
                    if (arrayList5.isEmpty()) {
                        arrayList4.remove(size3);
                    }
                } else {
                    size4--;
                }
            }
        }
        ArrayList arrayList6 = this.f2153l;
        for (int size5 = arrayList6.size() - 1; size5 >= 0; size5--) {
            ArrayList arrayList7 = (ArrayList) arrayList6.get(size5);
            if (arrayList7.remove(l1Var)) {
                view.setAlpha(1.0f);
                c(l1Var);
                if (arrayList7.isEmpty()) {
                    arrayList6.remove(size5);
                }
            }
        }
        this.f2158q.remove(l1Var);
        this.f2156o.remove(l1Var);
        this.f2159r.remove(l1Var);
        this.f2157p.remove(l1Var);
        i();
    }

    @Override // androidx.recyclerview.widget.p0
    public final void e() {
        ArrayList arrayList = this.f2151j;
        int size = arrayList.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            j jVar = (j) arrayList.get(size);
            View view = jVar.f2140a.f2170a;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            c(jVar.f2140a);
            arrayList.remove(size);
        }
        ArrayList arrayList2 = this.f2149h;
        for (int size2 = arrayList2.size() - 1; size2 >= 0; size2--) {
            c((l1) arrayList2.get(size2));
            arrayList2.remove(size2);
        }
        ArrayList arrayList3 = this.f2150i;
        int size3 = arrayList3.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            l1 l1Var = (l1) arrayList3.get(size3);
            l1Var.f2170a.setAlpha(1.0f);
            c(l1Var);
            arrayList3.remove(size3);
        }
        ArrayList arrayList4 = this.f2152k;
        for (int size4 = arrayList4.size() - 1; size4 >= 0; size4--) {
            i iVar = (i) arrayList4.get(size4);
            l1 l1Var2 = iVar.f2119a;
            if (l1Var2 != null) {
                k(iVar, l1Var2);
            }
            l1 l1Var3 = iVar.f2120b;
            if (l1Var3 != null) {
                k(iVar, l1Var3);
            }
        }
        arrayList4.clear();
        if (!f()) {
            return;
        }
        ArrayList arrayList5 = this.f2154m;
        for (int size5 = arrayList5.size() - 1; size5 >= 0; size5--) {
            ArrayList arrayList6 = (ArrayList) arrayList5.get(size5);
            for (int size6 = arrayList6.size() - 1; size6 >= 0; size6--) {
                j jVar2 = (j) arrayList6.get(size6);
                View view2 = jVar2.f2140a.f2170a;
                view2.setTranslationY(0.0f);
                view2.setTranslationX(0.0f);
                c(jVar2.f2140a);
                arrayList6.remove(size6);
                if (arrayList6.isEmpty()) {
                    arrayList5.remove(arrayList6);
                }
            }
        }
        ArrayList arrayList7 = this.f2153l;
        for (int size7 = arrayList7.size() - 1; size7 >= 0; size7--) {
            ArrayList arrayList8 = (ArrayList) arrayList7.get(size7);
            for (int size8 = arrayList8.size() - 1; size8 >= 0; size8--) {
                l1 l1Var4 = (l1) arrayList8.get(size8);
                l1Var4.f2170a.setAlpha(1.0f);
                c(l1Var4);
                arrayList8.remove(size8);
                if (arrayList8.isEmpty()) {
                    arrayList7.remove(arrayList8);
                }
            }
        }
        ArrayList arrayList9 = this.f2155n;
        for (int size9 = arrayList9.size() - 1; size9 >= 0; size9--) {
            ArrayList arrayList10 = (ArrayList) arrayList9.get(size9);
            for (int size10 = arrayList10.size() - 1; size10 >= 0; size10--) {
                i iVar2 = (i) arrayList10.get(size10);
                l1 l1Var5 = iVar2.f2119a;
                if (l1Var5 != null) {
                    k(iVar2, l1Var5);
                }
                l1 l1Var6 = iVar2.f2120b;
                if (l1Var6 != null) {
                    k(iVar2, l1Var6);
                }
                if (arrayList10.isEmpty()) {
                    arrayList9.remove(arrayList10);
                }
            }
        }
        h(this.f2158q);
        h(this.f2157p);
        h(this.f2156o);
        h(this.f2159r);
        ArrayList arrayList11 = this.f2230b;
        if (arrayList11.size() <= 0) {
            arrayList11.clear();
        } else {
            androidx.activity.j.f(arrayList11.get(0));
            throw null;
        }
    }

    @Override // androidx.recyclerview.widget.p0
    public final boolean f() {
        return (this.f2150i.isEmpty() && this.f2152k.isEmpty() && this.f2151j.isEmpty() && this.f2149h.isEmpty() && this.f2157p.isEmpty() && this.f2158q.isEmpty() && this.f2156o.isEmpty() && this.f2159r.isEmpty() && this.f2154m.isEmpty() && this.f2153l.isEmpty() && this.f2155n.isEmpty()) ? false : true;
    }

    /* JADX WARN: Type inference failed for: r1v6, types: [androidx.recyclerview.widget.j, java.lang.Object] */
    public final boolean g(l1 l1Var, int i4, int i5, int i6, int i7) {
        View view = l1Var.f2170a;
        int translationX = i4 + ((int) view.getTranslationX());
        int translationY = i5 + ((int) l1Var.f2170a.getTranslationY());
        l(l1Var);
        int i8 = i6 - translationX;
        int i9 = i7 - translationY;
        if (i8 == 0 && i9 == 0) {
            c(l1Var);
            return false;
        }
        if (i8 != 0) {
            view.setTranslationX(-i8);
        }
        if (i9 != 0) {
            view.setTranslationY(-i9);
        }
        ArrayList arrayList = this.f2151j;
        ?? obj = new Object();
        obj.f2140a = l1Var;
        obj.f2141b = translationX;
        obj.f2142c = translationY;
        obj.f2143d = i6;
        obj.f2144e = i7;
        arrayList.add(obj);
        return true;
    }

    public final void i() {
        if (!f()) {
            ArrayList arrayList = this.f2230b;
            if (arrayList.size() <= 0) {
                arrayList.clear();
            } else {
                androidx.activity.j.f(arrayList.get(0));
                throw null;
            }
        }
    }

    public final void j(l1 l1Var, ArrayList arrayList) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            i iVar = (i) arrayList.get(size);
            if (k(iVar, l1Var) && iVar.f2119a == null && iVar.f2120b == null) {
                arrayList.remove(iVar);
            }
        }
    }

    public final boolean k(i iVar, l1 l1Var) {
        if (iVar.f2120b == l1Var) {
            iVar.f2120b = null;
        } else if (iVar.f2119a == l1Var) {
            iVar.f2119a = null;
        } else {
            return false;
        }
        l1Var.f2170a.setAlpha(1.0f);
        View view = l1Var.f2170a;
        view.setTranslationX(0.0f);
        view.setTranslationY(0.0f);
        c(l1Var);
        return true;
    }

    public final void l(l1 l1Var) {
        if (f2147s == null) {
            f2147s = new ValueAnimator().getInterpolator();
        }
        l1Var.f2170a.animate().setInterpolator(f2147s);
        d(l1Var);
    }
}