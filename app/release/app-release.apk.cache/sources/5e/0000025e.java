package androidx.fragment.app;

import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public abstract class b1 {
    public static void d(View view, List list) {
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            if (list.get(i4) == view) {
                return;
            }
        }
        WeakHashMap weakHashMap = i0.y0.f4999a;
        if (i0.m0.k(view) != null) {
            list.add(view);
        }
        for (int i5 = size; i5 < list.size(); i5++) {
            View view2 = (View) list.get(i5);
            if (view2 instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view2;
                int childCount = viewGroup.getChildCount();
                for (int i6 = 0; i6 < childCount; i6++) {
                    View childAt = viewGroup.getChildAt(i6);
                    int i7 = 0;
                    while (true) {
                        if (i7 < size) {
                            if (list.get(i7) == childAt) {
                                break;
                            }
                            i7++;
                        } else if (i0.m0.k(childAt) != null) {
                            list.add(childAt);
                        }
                    }
                }
            }
        }
    }

    public static void g(View view, Rect rect) {
        WeakHashMap weakHashMap = i0.y0.f4999a;
        if (!i0.j0.b(view)) {
            return;
        }
        RectF rectF = new RectF();
        rectF.set(0.0f, 0.0f, view.getWidth(), view.getHeight());
        view.getMatrix().mapRect(rectF);
        rectF.offset(view.getLeft(), view.getTop());
        ViewParent parent = view.getParent();
        while (parent instanceof View) {
            View view2 = (View) parent;
            rectF.offset(-view2.getScrollX(), -view2.getScrollY());
            view2.getMatrix().mapRect(rectF);
            rectF.offset(view2.getLeft(), view2.getTop());
            parent = view2.getParent();
        }
        int[] iArr = new int[2];
        view.getRootView().getLocationOnScreen(iArr);
        rectF.offset(iArr[0], iArr[1]);
        rect.set(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
    }

    public static boolean h(List list) {
        return list == null || list.isEmpty();
    }

    public static ArrayList k(ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        for (int i4 = 0; i4 < size; i4++) {
            View view = (View) arrayList.get(i4);
            WeakHashMap weakHashMap = i0.y0.f4999a;
            arrayList2.add(i0.m0.k(view));
            i0.m0.v(view, null);
        }
        return arrayList2;
    }

    public static void q(ViewGroup viewGroup, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, l.b bVar) {
        int size = arrayList2.size();
        ArrayList arrayList4 = new ArrayList();
        for (int i4 = 0; i4 < size; i4++) {
            View view = (View) arrayList.get(i4);
            WeakHashMap weakHashMap = i0.y0.f4999a;
            String k4 = i0.m0.k(view);
            arrayList4.add(k4);
            if (k4 != null) {
                i0.m0.v(view, null);
                String str = (String) bVar.getOrDefault(k4, null);
                int i5 = 0;
                while (true) {
                    if (i5 >= size) {
                        break;
                    } else if (str.equals(arrayList3.get(i5))) {
                        i0.m0.v((View) arrayList2.get(i5), k4);
                        break;
                    } else {
                        i5++;
                    }
                }
            }
        }
        i0.z.a(viewGroup, new a1(size, arrayList2, arrayList3, arrayList, arrayList4));
    }

    public abstract void a(View view, Object obj);

    public abstract void b(Object obj, ArrayList arrayList);

    public abstract void c(ViewGroup viewGroup, Object obj);

    public abstract boolean e(Object obj);

    public abstract Object f(Object obj);

    public abstract Object i(Object obj, Object obj2, Object obj3);

    public abstract Object j(Object obj, Object obj2, Object obj3);

    public abstract void l(Object obj, View view, ArrayList arrayList);

    public abstract void m(Object obj, Object obj2, ArrayList arrayList, Object obj3, ArrayList arrayList2, Object obj4, ArrayList arrayList3);

    public abstract void n(View view, Object obj);

    public abstract void o(Object obj, Rect rect);

    public void p(Object obj, Runnable runnable) {
        runnable.run();
    }

    public abstract void r(Object obj, View view, ArrayList arrayList);

    public abstract void s(Object obj, ArrayList arrayList, ArrayList arrayList2);

    public abstract Object t(Object obj);
}