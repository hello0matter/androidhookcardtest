package androidx.recyclerview.widget;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class i0 {

    /* renamed from: a  reason: collision with root package name */
    public final Object f2125a;

    public i0() {
        j0.i iVar;
        if (Build.VERSION.SDK_INT >= 26) {
            iVar = new j0.i(this);
        } else {
            iVar = new j0.i(this);
        }
        this.f2125a = iVar;
    }

    public static i0 h(int i4, int i5, int i6) {
        return new i0(AccessibilityNodeInfo.CollectionInfo.obtain(i4, i5, false, i6));
    }

    public static i0 i(int i4, int i5, int i6, int i7, boolean z4, boolean z5) {
        return new i0(AccessibilityNodeInfo.CollectionItemInfo.obtain(i4, i5, i6, i7, z4, z5));
    }

    public j0.h a(int i4) {
        return null;
    }

    public void b(a aVar) {
        int i4 = aVar.f2042a;
        Object obj = this.f2125a;
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 != 4) {
                    if (i4 == 8) {
                        ((RecyclerView) obj).f1988l.W(aVar.f2043b, aVar.f2045d);
                        return;
                    }
                    return;
                }
                ((RecyclerView) obj).f1988l.Y(aVar.f2043b, aVar.f2045d);
                return;
            }
            ((RecyclerView) obj).f1988l.X(aVar.f2043b, aVar.f2045d);
            return;
        }
        ((RecyclerView) obj).f1988l.U(aVar.f2043b, aVar.f2045d);
    }

    public j0.h c(int i4) {
        return null;
    }

    public l1 d(int i4) {
        Object obj = this.f2125a;
        RecyclerView recyclerView = (RecyclerView) obj;
        int f4 = recyclerView.f1974e.f2071a.f();
        int i5 = 0;
        l1 l1Var = null;
        while (true) {
            if (i5 >= f4) {
                break;
            }
            l1 J = RecyclerView.J(recyclerView.f1974e.f2071a.e(i5));
            if (J != null && !J.j() && J.f2172c == i4) {
                if (recyclerView.f1974e.h(J.f2170a)) {
                    l1Var = J;
                } else {
                    l1Var = J;
                    break;
                }
            }
            i5++;
        }
        if (l1Var == null || ((RecyclerView) obj).f1974e.h(l1Var.f2170a)) {
            return null;
        }
        return l1Var;
    }

    public View e(int i4) {
        return ((RecyclerView) this.f2125a).getChildAt(i4);
    }

    public int f() {
        return ((RecyclerView) this.f2125a).getChildCount();
    }

    public void g(int i4, int i5, Object obj) {
        int i6;
        int i7;
        Object obj2 = this.f2125a;
        RecyclerView recyclerView = (RecyclerView) obj2;
        int f4 = recyclerView.f1974e.f2071a.f();
        int i8 = i5 + i4;
        for (int i9 = 0; i9 < f4; i9++) {
            View e4 = recyclerView.f1974e.f2071a.e(i9);
            l1 J = RecyclerView.J(e4);
            if (J != null && !J.q() && (i7 = J.f2172c) >= i4 && i7 < i8) {
                J.b(2);
                J.a(obj);
                ((RecyclerView.LayoutParams) e4.getLayoutParams()).f2013c = true;
            }
        }
        b1 b1Var = recyclerView.f1968b;
        ArrayList arrayList = b1Var.f2063c;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            l1 l1Var = (l1) arrayList.get(size);
            if (l1Var != null && (i6 = l1Var.f2172c) >= i4 && i6 < i8) {
                l1Var.b(2);
                b1Var.e(size);
            }
        }
        ((RecyclerView) obj2).f1981h0 = true;
    }

    public void j(int i4, int i5) {
        Object obj = this.f2125a;
        RecyclerView recyclerView = (RecyclerView) obj;
        int f4 = recyclerView.f1974e.f2071a.f();
        for (int i6 = 0; i6 < f4; i6++) {
            l1 J = RecyclerView.J(recyclerView.f1974e.f2071a.e(i6));
            if (J != null && !J.q() && J.f2172c >= i4) {
                J.n(i5, false);
                recyclerView.f1973d0.f2131f = true;
            }
        }
        ArrayList arrayList = recyclerView.f1968b.f2063c;
        int size = arrayList.size();
        for (int i7 = 0; i7 < size; i7++) {
            l1 l1Var = (l1) arrayList.get(i7);
            if (l1Var != null && l1Var.f2172c >= i4) {
                l1Var.n(i5, true);
            }
        }
        recyclerView.requestLayout();
        ((RecyclerView) obj).f1979g0 = true;
    }

    public void k(int i4, int i5) {
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        Object obj = this.f2125a;
        RecyclerView recyclerView = (RecyclerView) obj;
        int f4 = recyclerView.f1974e.f2071a.f();
        int i13 = -1;
        if (i4 < i5) {
            i7 = i4;
            i6 = i5;
            i8 = -1;
        } else {
            i6 = i4;
            i7 = i5;
            i8 = 1;
        }
        for (int i14 = 0; i14 < f4; i14++) {
            l1 J = RecyclerView.J(recyclerView.f1974e.f2071a.e(i14));
            if (J != null && (i12 = J.f2172c) >= i7 && i12 <= i6) {
                if (i12 == i4) {
                    J.n(i5 - i4, false);
                } else {
                    J.n(i8, false);
                }
                recyclerView.f1973d0.f2131f = true;
            }
        }
        b1 b1Var = recyclerView.f1968b;
        b1Var.getClass();
        if (i4 < i5) {
            i10 = i4;
            i9 = i5;
        } else {
            i9 = i4;
            i10 = i5;
            i13 = 1;
        }
        ArrayList arrayList = b1Var.f2063c;
        int size = arrayList.size();
        for (int i15 = 0; i15 < size; i15++) {
            l1 l1Var = (l1) arrayList.get(i15);
            if (l1Var != null && (i11 = l1Var.f2172c) >= i10 && i11 <= i9) {
                if (i11 == i4) {
                    l1Var.n(i5 - i4, false);
                } else {
                    l1Var.n(i13, false);
                }
            }
        }
        recyclerView.requestLayout();
        ((RecyclerView) obj).f1979g0 = true;
    }

    public boolean l(int i4, int i5, Bundle bundle) {
        return false;
    }

    public void m(l1 l1Var, o0 o0Var, o0 o0Var2) {
        RecyclerView recyclerView = (RecyclerView) this.f2125a;
        recyclerView.getClass();
        l1Var.p(false);
        k kVar = (k) recyclerView.I;
        if (o0Var != null) {
            kVar.getClass();
            int i4 = o0Var.f2197a;
            int i5 = o0Var2.f2197a;
            if (i4 != i5 || o0Var.f2198b != o0Var2.f2198b) {
                if (!kVar.g(l1Var, i4, o0Var.f2198b, i5, o0Var2.f2198b)) {
                    return;
                }
                recyclerView.T();
            }
        }
        kVar.l(l1Var);
        l1Var.f2170a.setAlpha(0.0f);
        kVar.f2150i.add(l1Var);
        recyclerView.T();
    }

    public void n(l1 l1Var, o0 o0Var, o0 o0Var2) {
        int i4;
        int i5;
        Object obj = this.f2125a;
        ((RecyclerView) obj).f1968b.j(l1Var);
        RecyclerView recyclerView = (RecyclerView) obj;
        recyclerView.f(l1Var);
        l1Var.p(false);
        k kVar = (k) recyclerView.I;
        kVar.getClass();
        int i6 = o0Var.f2197a;
        int i7 = o0Var.f2198b;
        View view = l1Var.f2170a;
        if (o0Var2 == null) {
            i4 = view.getLeft();
        } else {
            i4 = o0Var2.f2197a;
        }
        int i8 = i4;
        if (o0Var2 == null) {
            i5 = view.getTop();
        } else {
            i5 = o0Var2.f2198b;
        }
        int i9 = i5;
        if (!l1Var.j() && (i6 != i8 || i7 != i9)) {
            view.layout(i8, i9, view.getWidth() + i8, view.getHeight() + i9);
            if (!kVar.g(l1Var, i6, i7, i8, i9)) {
                return;
            }
        } else {
            kVar.l(l1Var);
            kVar.f2149h.add(l1Var);
        }
        recyclerView.T();
    }

    public void o(int i4) {
        Object obj = this.f2125a;
        View childAt = ((RecyclerView) obj).getChildAt(i4);
        if (childAt != null) {
            ((RecyclerView) obj).o(childAt);
            childAt.clearAnimation();
        }
        ((RecyclerView) obj).removeViewAt(i4);
    }

    public /* synthetic */ i0(Object obj) {
        this.f2125a = obj;
    }
}