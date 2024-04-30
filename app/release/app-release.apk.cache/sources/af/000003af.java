package c1;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.b1;
import androidx.transition.Transition;
import androidx.transition.TransitionSet;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class r extends b1 {
    @Override // androidx.fragment.app.b1
    public final void a(View view, Object obj) {
        if (obj != null) {
            ((Transition) obj).b(view);
        }
    }

    @Override // androidx.fragment.app.b1
    public final void b(Object obj, ArrayList arrayList) {
        Transition transition;
        Transition transition2 = (Transition) obj;
        if (transition2 == null) {
            return;
        }
        int i4 = 0;
        if (transition2 instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition2;
            int size = transitionSet.f2372y.size();
            while (i4 < size) {
                if (i4 >= 0 && i4 < transitionSet.f2372y.size()) {
                    transition = (Transition) transitionSet.f2372y.get(i4);
                } else {
                    transition = null;
                }
                b(transition, arrayList);
                i4++;
            }
        } else if (b1.h(transition2.f2355e) && b1.h(null) && b1.h(null) && b1.h(transition2.f2356f)) {
            int size2 = arrayList.size();
            while (i4 < size2) {
                transition2.b((View) arrayList.get(i4));
                i4++;
            }
        }
    }

    @Override // androidx.fragment.app.b1
    public final void c(ViewGroup viewGroup, Object obj) {
        i0.a(viewGroup, (Transition) obj);
    }

    @Override // androidx.fragment.app.b1
    public final boolean e(Object obj) {
        return obj instanceof Transition;
    }

    @Override // androidx.fragment.app.b1
    public final Object f(Object obj) {
        if (obj != null) {
            return ((Transition) obj).clone();
        }
        return null;
    }

    @Override // androidx.fragment.app.b1
    public final Object i(Object obj, Object obj2, Object obj3) {
        Transition transition = (Transition) obj;
        Transition transition2 = (Transition) obj2;
        Transition transition3 = (Transition) obj3;
        if (transition != null && transition2 != null) {
            TransitionSet transitionSet = new TransitionSet();
            transitionSet.H(transition);
            transitionSet.H(transition2);
            transitionSet.K(1);
            transition = transitionSet;
        } else if (transition == null) {
            if (transition2 != null) {
                transition = transition2;
            } else {
                transition = null;
            }
        }
        if (transition3 != null) {
            TransitionSet transitionSet2 = new TransitionSet();
            if (transition != null) {
                transitionSet2.H(transition);
            }
            transitionSet2.H(transition3);
            return transitionSet2;
        }
        return transition;
    }

    @Override // androidx.fragment.app.b1
    public final Object j(Object obj, Object obj2, Object obj3) {
        TransitionSet transitionSet = new TransitionSet();
        if (obj != null) {
            transitionSet.H((Transition) obj);
        }
        if (obj2 != null) {
            transitionSet.H((Transition) obj2);
        }
        if (obj3 != null) {
            transitionSet.H((Transition) obj3);
        }
        return transitionSet;
    }

    @Override // androidx.fragment.app.b1
    public final void l(Object obj, View view, ArrayList arrayList) {
        ((Transition) obj).a(new p(view, arrayList));
    }

    @Override // androidx.fragment.app.b1
    public final void m(Object obj, Object obj2, ArrayList arrayList, Object obj3, ArrayList arrayList2, Object obj4, ArrayList arrayList3) {
        ((Transition) obj).a(new q(this, obj2, arrayList, obj3, arrayList2, obj4, arrayList3));
    }

    @Override // androidx.fragment.app.b1
    public final void n(View view, Object obj) {
        if (view != null) {
            Rect rect = new Rect();
            b1.g(view, rect);
            ((Transition) obj).A(new o(rect, 0));
        }
    }

    @Override // androidx.fragment.app.b1
    public final void o(Object obj, Rect rect) {
        if (obj != null) {
            ((Transition) obj).A(new o(rect, 1));
        }
    }

    @Override // androidx.fragment.app.b1
    public final void r(Object obj, View view, ArrayList arrayList) {
        TransitionSet transitionSet = (TransitionSet) obj;
        ArrayList arrayList2 = transitionSet.f2356f;
        arrayList2.clear();
        int size = arrayList.size();
        for (int i4 = 0; i4 < size; i4++) {
            b1.d((View) arrayList.get(i4), arrayList2);
        }
        arrayList2.add(view);
        arrayList.add(view);
        b(transitionSet, arrayList);
    }

    @Override // androidx.fragment.app.b1
    public final void s(Object obj, ArrayList arrayList, ArrayList arrayList2) {
        TransitionSet transitionSet = (TransitionSet) obj;
        if (transitionSet != null) {
            ArrayList arrayList3 = transitionSet.f2356f;
            arrayList3.clear();
            arrayList3.addAll(arrayList2);
            u(transitionSet, arrayList, arrayList2);
        }
    }

    @Override // androidx.fragment.app.b1
    public final Object t(Object obj) {
        if (obj == null) {
            return null;
        }
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.H((Transition) obj);
        return transitionSet;
    }

    public final void u(Object obj, ArrayList arrayList, ArrayList arrayList2) {
        int size;
        Transition transition;
        Transition transition2 = (Transition) obj;
        int i4 = 0;
        if (transition2 instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition2;
            int size2 = transitionSet.f2372y.size();
            while (i4 < size2) {
                if (i4 >= 0 && i4 < transitionSet.f2372y.size()) {
                    transition = (Transition) transitionSet.f2372y.get(i4);
                } else {
                    transition = null;
                }
                u(transition, arrayList, arrayList2);
                i4++;
            }
        } else if (b1.h(transition2.f2355e) && b1.h(null) && b1.h(null)) {
            ArrayList arrayList3 = transition2.f2356f;
            if (arrayList3.size() == arrayList.size() && arrayList3.containsAll(arrayList)) {
                if (arrayList2 == null) {
                    size = 0;
                } else {
                    size = arrayList2.size();
                }
                while (i4 < size) {
                    transition2.b((View) arrayList2.get(i4));
                    i4++;
                }
                for (int size3 = arrayList.size() - 1; size3 >= 0; size3--) {
                    transition2.w((View) arrayList.get(size3));
                }
            }
        }
    }
}