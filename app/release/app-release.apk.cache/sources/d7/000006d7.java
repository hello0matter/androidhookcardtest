package g;

import android.content.Context;
import android.view.MenuItem;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public abstract class e {

    /* renamed from: a  reason: collision with root package name */
    public Object f4618a;

    /* renamed from: b  reason: collision with root package name */
    public Object f4619b;

    /* renamed from: c  reason: collision with root package name */
    public Object f4620c;

    public e(int i4) {
        this.f4619b = new float[i4 * 2];
        this.f4620c = new int[i4];
    }

    public static boolean m(Set set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                if (set.size() == set2.size()) {
                    if (set.containsAll(set2)) {
                        return true;
                    }
                }
                return false;
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    public static boolean r(Map map, Collection collection) {
        int size = map.size();
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        if (size != map.size()) {
            return true;
        }
        return false;
    }

    public abstract void c();

    public abstract void d();

    public abstract Object e(int i4, int i5);

    public abstract l.b f();

    public abstract int g();

    public abstract int h(Object obj);

    public abstract int i(Object obj);

    public abstract void j(Object obj, Object obj2);

    public abstract void k(int i4);

    public abstract Object l(int i4, Object obj);

    public final MenuItem n(MenuItem menuItem) {
        if (menuItem instanceof d0.b) {
            d0.b bVar = (d0.b) menuItem;
            if (((l.k) this.f4619b) == null) {
                this.f4619b = new l.k();
            }
            MenuItem menuItem2 = (MenuItem) ((l.k) this.f4619b).getOrDefault(bVar, null);
            if (menuItem2 == null) {
                x xVar = new x((Context) this.f4618a, bVar);
                ((l.k) this.f4619b).put(bVar, xVar);
                return xVar;
            }
            return menuItem2;
        }
        return menuItem;
    }

    public abstract void o();

    public abstract void p(h2.c cVar);

    public abstract void q();

    public abstract void s();

    public final Object[] t(int i4, Object[] objArr) {
        int g4 = g();
        if (objArr.length < g4) {
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), g4);
        }
        for (int i5 = 0; i5 < g4; i5++) {
            objArr[i5] = e(i5, i4);
        }
        if (objArr.length > g4) {
            objArr[g4] = null;
        }
        return objArr;
    }

    public abstract void u();

    public e(Context context) {
        this.f4618a = context;
    }
}