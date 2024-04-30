package androidx.transition;

import a0.t;
import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.InflateException;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowId;
import android.view.animation.AnimationUtils;
import android.widget.ListView;
import androidx.activity.j;
import androidx.annotation.RestrictTo;
import c1.a1;
import c1.c0;
import c1.d0;
import c1.e0;
import c1.f;
import c1.f0;
import c1.m0;
import c1.p0;
import c1.t0;
import c1.z0;
import com.google.common.collect.c;
import i0.g0;
import i0.y0;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.WeakHashMap;
import l.b;
import l.e;
import l.k;
import p.d;

/* loaded from: classes.dex */
public abstract class Transition implements Cloneable {

    /* renamed from: v  reason: collision with root package name */
    public static final int[] f2348v = {2, 1, 3, 4};

    /* renamed from: w  reason: collision with root package name */
    public static final d0 f2349w = new Object();

    /* renamed from: x  reason: collision with root package name */
    public static final ThreadLocal f2350x = new ThreadLocal();

    /* renamed from: a  reason: collision with root package name */
    public final String f2351a;

    /* renamed from: b  reason: collision with root package name */
    public long f2352b;

    /* renamed from: c  reason: collision with root package name */
    public long f2353c;

    /* renamed from: d  reason: collision with root package name */
    public TimeInterpolator f2354d;

    /* renamed from: e  reason: collision with root package name */
    public final ArrayList f2355e;

    /* renamed from: f  reason: collision with root package name */
    public final ArrayList f2356f;

    /* renamed from: g  reason: collision with root package name */
    public d f2357g;

    /* renamed from: h  reason: collision with root package name */
    public d f2358h;

    /* renamed from: i  reason: collision with root package name */
    public TransitionSet f2359i;

    /* renamed from: j  reason: collision with root package name */
    public final int[] f2360j;

    /* renamed from: k  reason: collision with root package name */
    public ArrayList f2361k;

    /* renamed from: l  reason: collision with root package name */
    public ArrayList f2362l;

    /* renamed from: m  reason: collision with root package name */
    public final ArrayList f2363m;

    /* renamed from: n  reason: collision with root package name */
    public int f2364n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f2365o;

    /* renamed from: p  reason: collision with root package name */
    public boolean f2366p;

    /* renamed from: q  reason: collision with root package name */
    public ArrayList f2367q;

    /* renamed from: r  reason: collision with root package name */
    public ArrayList f2368r;

    /* renamed from: s  reason: collision with root package name */
    public c f2369s;

    /* renamed from: t  reason: collision with root package name */
    public c f2370t;

    /* renamed from: u  reason: collision with root package name */
    public PathMotion f2371u;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.f171c})
    /* loaded from: classes.dex */
    public @interface MatchOrder {
    }

    public Transition() {
        this.f2351a = getClass().getName();
        this.f2352b = -1L;
        this.f2353c = -1L;
        this.f2354d = null;
        this.f2355e = new ArrayList();
        this.f2356f = new ArrayList();
        this.f2357g = new d(2);
        this.f2358h = new d(2);
        this.f2359i = null;
        this.f2360j = f2348v;
        this.f2363m = new ArrayList();
        this.f2364n = 0;
        this.f2365o = false;
        this.f2366p = false;
        this.f2367q = null;
        this.f2368r = new ArrayList();
        this.f2371u = f2349w;
    }

    public static void c(d dVar, View view, m0 m0Var) {
        ((b) dVar.f6074a).put(view, m0Var);
        int id = view.getId();
        if (id >= 0) {
            if (((SparseArray) dVar.f6075b).indexOfKey(id) >= 0) {
                ((SparseArray) dVar.f6075b).put(id, null);
            } else {
                ((SparseArray) dVar.f6075b).put(id, view);
            }
        }
        WeakHashMap weakHashMap = y0.f4999a;
        String k4 = i0.m0.k(view);
        if (k4 != null) {
            if (((b) dVar.f6077d).containsKey(k4)) {
                ((b) dVar.f6077d).put(k4, null);
            } else {
                ((b) dVar.f6077d).put(k4, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                e eVar = (e) dVar.f6076c;
                if (eVar.f5225a) {
                    eVar.c();
                }
                if (l.d.b(eVar.f5226b, eVar.f5228d, itemIdAtPosition) >= 0) {
                    View view2 = (View) ((e) dVar.f6076c).d(itemIdAtPosition, null);
                    if (view2 != null) {
                        g0.r(view2, false);
                        ((e) dVar.f6076c).e(itemIdAtPosition, null);
                        return;
                    }
                    return;
                }
                g0.r(view, true);
                ((e) dVar.f6076c).e(itemIdAtPosition, view);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [l.b, l.k, java.lang.Object] */
    public static b o() {
        ThreadLocal threadLocal = f2350x;
        b bVar = (b) threadLocal.get();
        if (bVar == null) {
            ?? kVar = new k();
            threadLocal.set(kVar);
            return kVar;
        }
        return bVar;
    }

    public static boolean t(m0 m0Var, m0 m0Var2, String str) {
        Object obj = m0Var.f2646a.get(str);
        Object obj2 = m0Var2.f2646a.get(str);
        if (obj == null && obj2 == null) {
            return false;
        }
        if (obj == null || obj2 == null) {
            return true;
        }
        return !obj.equals(obj2);
    }

    public void A(c cVar) {
        this.f2370t = cVar;
    }

    public void B(TimeInterpolator timeInterpolator) {
        this.f2354d = timeInterpolator;
    }

    public void C(PathMotion pathMotion) {
        if (pathMotion == null) {
            pathMotion = f2349w;
        }
        this.f2371u = pathMotion;
    }

    public void D(c cVar) {
        this.f2369s = cVar;
    }

    public void E(long j4) {
        this.f2352b = j4;
    }

    public final void F() {
        if (this.f2364n == 0) {
            ArrayList arrayList = this.f2367q;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.f2367q.clone();
                int size = arrayList2.size();
                for (int i4 = 0; i4 < size; i4++) {
                    ((f0) arrayList2.get(i4)).b();
                }
            }
            this.f2366p = false;
        }
        this.f2364n++;
    }

    public String G(String str) {
        String str2 = str + getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + ": ";
        if (this.f2353c != -1) {
            str2 = str2 + "dur(" + this.f2353c + ") ";
        }
        if (this.f2352b != -1) {
            str2 = str2 + "dly(" + this.f2352b + ") ";
        }
        if (this.f2354d != null) {
            str2 = str2 + "interp(" + this.f2354d + ") ";
        }
        ArrayList arrayList = this.f2355e;
        int size = arrayList.size();
        ArrayList arrayList2 = this.f2356f;
        if (size > 0 || arrayList2.size() > 0) {
            String c4 = j.c(str2, "tgts(");
            if (arrayList.size() > 0) {
                for (int i4 = 0; i4 < arrayList.size(); i4++) {
                    if (i4 > 0) {
                        c4 = j.c(c4, ", ");
                    }
                    c4 = c4 + arrayList.get(i4);
                }
            }
            if (arrayList2.size() > 0) {
                for (int i5 = 0; i5 < arrayList2.size(); i5++) {
                    if (i5 > 0) {
                        c4 = j.c(c4, ", ");
                    }
                    c4 = c4 + arrayList2.get(i5);
                }
            }
            return j.c(c4, ")");
        }
        return str2;
    }

    public void a(f0 f0Var) {
        if (this.f2367q == null) {
            this.f2367q = new ArrayList();
        }
        this.f2367q.add(f0Var);
    }

    public void b(View view) {
        this.f2356f.add(view);
    }

    public abstract void d(m0 m0Var);

    public final void e(View view, boolean z4) {
        if (view == null) {
            return;
        }
        view.getId();
        if (view.getParent() instanceof ViewGroup) {
            m0 m0Var = new m0(view);
            if (z4) {
                g(m0Var);
            } else {
                d(m0Var);
            }
            m0Var.f2648c.add(this);
            f(m0Var);
            c(z4 ? this.f2357g : this.f2358h, view, m0Var);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i4 = 0; i4 < viewGroup.getChildCount(); i4++) {
                e(viewGroup.getChildAt(i4), z4);
            }
        }
    }

    public void f(m0 m0Var) {
        if (this.f2369s != null) {
            HashMap hashMap = m0Var.f2646a;
            if (!hashMap.isEmpty()) {
                this.f2369s.getClass();
                String[] strArr = c1.y0.f2717q;
                for (int i4 = 0; i4 < 2; i4++) {
                    if (!hashMap.containsKey(strArr[i4])) {
                        this.f2369s.v(m0Var);
                        return;
                    }
                }
            }
        }
    }

    public abstract void g(m0 m0Var);

    public final void h(ViewGroup viewGroup, boolean z4) {
        i(z4);
        ArrayList arrayList = this.f2355e;
        int size = arrayList.size();
        ArrayList arrayList2 = this.f2356f;
        if (size <= 0 && arrayList2.size() <= 0) {
            e(viewGroup, z4);
            return;
        }
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            View findViewById = viewGroup.findViewById(((Integer) arrayList.get(i4)).intValue());
            if (findViewById != null) {
                m0 m0Var = new m0(findViewById);
                if (z4) {
                    g(m0Var);
                } else {
                    d(m0Var);
                }
                m0Var.f2648c.add(this);
                f(m0Var);
                c(z4 ? this.f2357g : this.f2358h, findViewById, m0Var);
            }
        }
        for (int i5 = 0; i5 < arrayList2.size(); i5++) {
            View view = (View) arrayList2.get(i5);
            m0 m0Var2 = new m0(view);
            if (z4) {
                g(m0Var2);
            } else {
                d(m0Var2);
            }
            m0Var2.f2648c.add(this);
            f(m0Var2);
            c(z4 ? this.f2357g : this.f2358h, view, m0Var2);
        }
    }

    public final void i(boolean z4) {
        d dVar;
        if (z4) {
            ((b) this.f2357g.f6074a).clear();
            ((SparseArray) this.f2357g.f6075b).clear();
            dVar = this.f2357g;
        } else {
            ((b) this.f2358h.f6074a).clear();
            ((SparseArray) this.f2358h.f6075b).clear();
            dVar = this.f2358h;
        }
        ((e) dVar.f6076c).a();
    }

    @Override // 
    /* renamed from: j */
    public Transition clone() {
        try {
            Transition transition = (Transition) super.clone();
            transition.f2368r = new ArrayList();
            transition.f2357g = new d(2);
            transition.f2358h = new d(2);
            transition.f2361k = null;
            transition.f2362l = null;
            return transition;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public Animator k(ViewGroup viewGroup, m0 m0Var, m0 m0Var2) {
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v3, types: [c1.e0, java.lang.Object] */
    public void l(ViewGroup viewGroup, d dVar, d dVar2, ArrayList arrayList, ArrayList arrayList2) {
        Animator k4;
        int i4;
        int i5;
        m0 m0Var;
        View view;
        Animator animator;
        m0 m0Var2;
        b o4 = o();
        SparseIntArray sparseIntArray = new SparseIntArray();
        int size = arrayList.size();
        long j4 = Long.MAX_VALUE;
        int i6 = 0;
        while (i6 < size) {
            m0 m0Var3 = (m0) arrayList.get(i6);
            m0 m0Var4 = (m0) arrayList2.get(i6);
            if (m0Var3 != null && !m0Var3.f2648c.contains(this)) {
                m0Var3 = null;
            }
            if (m0Var4 != null && !m0Var4.f2648c.contains(this)) {
                m0Var4 = null;
            }
            if ((m0Var3 == null && m0Var4 == null) || ((m0Var3 != null && m0Var4 != null && !r(m0Var3, m0Var4)) || (k4 = k(viewGroup, m0Var3, m0Var4)) == null)) {
                i4 = size;
                i5 = i6;
            } else {
                String str = this.f2351a;
                if (m0Var4 != null) {
                    String[] p4 = p();
                    view = m0Var4.f2647b;
                    i4 = size;
                    if (p4 != null && p4.length > 0) {
                        m0Var2 = new m0(view);
                        m0 m0Var5 = (m0) ((b) dVar2.f6074a).getOrDefault(view, null);
                        if (m0Var5 != null) {
                            animator = k4;
                            int i7 = 0;
                            while (i7 < p4.length) {
                                HashMap hashMap = m0Var2.f2646a;
                                int i8 = i6;
                                String str2 = p4[i7];
                                hashMap.put(str2, m0Var5.f2646a.get(str2));
                                i7++;
                                i6 = i8;
                                p4 = p4;
                            }
                            i5 = i6;
                        } else {
                            i5 = i6;
                            animator = k4;
                        }
                        int i9 = o4.f5252c;
                        int i10 = 0;
                        while (true) {
                            if (i10 >= i9) {
                                break;
                            }
                            e0 e0Var = (e0) o4.getOrDefault((Animator) o4.h(i10), null);
                            if (e0Var.f2603c != null && e0Var.f2601a == view && e0Var.f2602b.equals(str) && e0Var.f2603c.equals(m0Var2)) {
                                animator = null;
                                break;
                            }
                            i10++;
                        }
                    } else {
                        i5 = i6;
                        animator = k4;
                        m0Var2 = null;
                    }
                    m0Var = m0Var2;
                    k4 = animator;
                } else {
                    i4 = size;
                    i5 = i6;
                    m0Var = null;
                    view = m0Var3.f2647b;
                }
                if (k4 != null) {
                    c cVar = this.f2369s;
                    if (cVar != null) {
                        long O0 = cVar.O0(viewGroup, this, m0Var3, m0Var4);
                        sparseIntArray.put(this.f2368r.size(), (int) O0);
                        j4 = Math.min(O0, j4);
                    }
                    t0 t0Var = p0.f2666a;
                    z0 z0Var = new z0(viewGroup);
                    ?? obj = new Object();
                    obj.f2601a = view;
                    obj.f2602b = str;
                    obj.f2603c = m0Var;
                    obj.f2604d = z0Var;
                    obj.f2605e = this;
                    o4.put(k4, obj);
                    this.f2368r.add(k4);
                }
            }
            i6 = i5 + 1;
            size = i4;
        }
        if (sparseIntArray.size() != 0) {
            for (int i11 = 0; i11 < sparseIntArray.size(); i11++) {
                Animator animator2 = (Animator) this.f2368r.get(sparseIntArray.keyAt(i11));
                animator2.setStartDelay(animator2.getStartDelay() + (sparseIntArray.valueAt(i11) - j4));
            }
        }
    }

    public final void m() {
        int i4 = this.f2364n - 1;
        this.f2364n = i4;
        if (i4 == 0) {
            ArrayList arrayList = this.f2367q;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.f2367q.clone();
                int size = arrayList2.size();
                for (int i5 = 0; i5 < size; i5++) {
                    ((f0) arrayList2.get(i5)).d(this);
                }
            }
            for (int i6 = 0; i6 < ((e) this.f2357g.f6076c).f(); i6++) {
                View view = (View) ((e) this.f2357g.f6076c).g(i6);
                if (view != null) {
                    WeakHashMap weakHashMap = y0.f4999a;
                    g0.r(view, false);
                }
            }
            for (int i7 = 0; i7 < ((e) this.f2358h.f6076c).f(); i7++) {
                View view2 = (View) ((e) this.f2358h.f6076c).g(i7);
                if (view2 != null) {
                    WeakHashMap weakHashMap2 = y0.f4999a;
                    g0.r(view2, false);
                }
            }
            this.f2366p = true;
        }
    }

    public final m0 n(View view, boolean z4) {
        ArrayList arrayList;
        ArrayList arrayList2;
        TransitionSet transitionSet = this.f2359i;
        if (transitionSet != null) {
            return transitionSet.n(view, z4);
        }
        if (z4) {
            arrayList = this.f2361k;
        } else {
            arrayList = this.f2362l;
        }
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        int i4 = 0;
        while (true) {
            if (i4 < size) {
                m0 m0Var = (m0) arrayList.get(i4);
                if (m0Var == null) {
                    return null;
                }
                if (m0Var.f2647b == view) {
                    break;
                }
                i4++;
            } else {
                i4 = -1;
                break;
            }
        }
        if (i4 < 0) {
            return null;
        }
        if (z4) {
            arrayList2 = this.f2362l;
        } else {
            arrayList2 = this.f2361k;
        }
        return (m0) arrayList2.get(i4);
    }

    public String[] p() {
        return null;
    }

    public final m0 q(View view, boolean z4) {
        d dVar;
        TransitionSet transitionSet = this.f2359i;
        if (transitionSet != null) {
            return transitionSet.q(view, z4);
        }
        if (z4) {
            dVar = this.f2357g;
        } else {
            dVar = this.f2358h;
        }
        return (m0) ((b) dVar.f6074a).getOrDefault(view, null);
    }

    public boolean r(m0 m0Var, m0 m0Var2) {
        if (m0Var == null || m0Var2 == null) {
            return false;
        }
        String[] p4 = p();
        if (p4 != null) {
            for (String str : p4) {
                if (!t(m0Var, m0Var2, str)) {
                }
            }
            return false;
        }
        for (String str2 : m0Var.f2646a.keySet()) {
            if (t(m0Var, m0Var2, str2)) {
            }
        }
        return false;
        return true;
    }

    public final boolean s(View view) {
        int id = view.getId();
        ArrayList arrayList = this.f2355e;
        int size = arrayList.size();
        ArrayList arrayList2 = this.f2356f;
        return (size == 0 && arrayList2.size() == 0) || arrayList.contains(Integer.valueOf(id)) || arrayList2.contains(view);
    }

    public final String toString() {
        return G("");
    }

    public void u(View view) {
        if (!this.f2366p) {
            b o4 = o();
            int i4 = o4.f5252c;
            t0 t0Var = p0.f2666a;
            WindowId windowId = view.getWindowId();
            for (int i5 = i4 - 1; i5 >= 0; i5--) {
                e0 e0Var = (e0) o4.j(i5);
                if (e0Var.f2601a != null) {
                    a1 a1Var = e0Var.f2604d;
                    if ((a1Var instanceof z0) && ((z0) a1Var).f2719a.equals(windowId)) {
                        ((Animator) o4.h(i5)).pause();
                    }
                }
            }
            ArrayList arrayList = this.f2367q;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.f2367q.clone();
                int size = arrayList2.size();
                for (int i6 = 0; i6 < size; i6++) {
                    ((f0) arrayList2.get(i6)).c();
                }
            }
            this.f2365o = true;
        }
    }

    public void v(f0 f0Var) {
        ArrayList arrayList = this.f2367q;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(f0Var);
        if (this.f2367q.size() == 0) {
            this.f2367q = null;
        }
    }

    public void w(View view) {
        this.f2356f.remove(view);
    }

    public void x(ViewGroup viewGroup) {
        if (this.f2365o) {
            if (!this.f2366p) {
                b o4 = o();
                int i4 = o4.f5252c;
                t0 t0Var = p0.f2666a;
                WindowId windowId = viewGroup.getWindowId();
                for (int i5 = i4 - 1; i5 >= 0; i5--) {
                    e0 e0Var = (e0) o4.j(i5);
                    if (e0Var.f2601a != null) {
                        a1 a1Var = e0Var.f2604d;
                        if ((a1Var instanceof z0) && ((z0) a1Var).f2719a.equals(windowId)) {
                            ((Animator) o4.h(i5)).resume();
                        }
                    }
                }
                ArrayList arrayList = this.f2367q;
                if (arrayList != null && arrayList.size() > 0) {
                    ArrayList arrayList2 = (ArrayList) this.f2367q.clone();
                    int size = arrayList2.size();
                    for (int i6 = 0; i6 < size; i6++) {
                        ((f0) arrayList2.get(i6)).e();
                    }
                }
            }
            this.f2365o = false;
        }
    }

    public void y() {
        F();
        b o4 = o();
        Iterator it = this.f2368r.iterator();
        while (it.hasNext()) {
            Animator animator = (Animator) it.next();
            if (o4.containsKey(animator)) {
                F();
                if (animator != null) {
                    animator.addListener(new f(1, this, o4));
                    long j4 = this.f2353c;
                    if (j4 >= 0) {
                        animator.setDuration(j4);
                    }
                    long j5 = this.f2352b;
                    if (j5 >= 0) {
                        animator.setStartDelay(animator.getStartDelay() + j5);
                    }
                    TimeInterpolator timeInterpolator = this.f2354d;
                    if (timeInterpolator != null) {
                        animator.setInterpolator(timeInterpolator);
                    }
                    animator.addListener(new androidx.appcompat.widget.e(1, this));
                    animator.start();
                }
            }
        }
        this.f2368r.clear();
        m();
    }

    public void z(long j4) {
        this.f2353c = j4;
    }

    @SuppressLint({"RestrictedApi"})
    public Transition(Context context, AttributeSet attributeSet) {
        this.f2351a = getClass().getName();
        this.f2352b = -1L;
        this.f2353c = -1L;
        this.f2354d = null;
        this.f2355e = new ArrayList();
        this.f2356f = new ArrayList();
        this.f2357g = new d(2);
        this.f2358h = new d(2);
        this.f2359i = null;
        int[] iArr = f2348v;
        this.f2360j = iArr;
        this.f2363m = new ArrayList();
        this.f2364n = 0;
        this.f2365o = false;
        this.f2366p = false;
        this.f2367q = null;
        this.f2368r = new ArrayList();
        this.f2371u = f2349w;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c0.f2579a);
        XmlResourceParser xmlResourceParser = (XmlResourceParser) attributeSet;
        long b5 = t.b(obtainStyledAttributes, xmlResourceParser, "duration", 1, -1);
        if (b5 >= 0) {
            z(b5);
        }
        long j4 = t.d(xmlResourceParser, "startDelay") ? obtainStyledAttributes.getInt(2, -1) : -1;
        if (j4 > 0) {
            E(j4);
        }
        int resourceId = !t.d(xmlResourceParser, "interpolator") ? 0 : obtainStyledAttributes.getResourceId(0, 0);
        if (resourceId > 0) {
            B(AnimationUtils.loadInterpolator(context, resourceId));
        }
        String c4 = t.c(obtainStyledAttributes, xmlResourceParser, "matchOrder", 3);
        if (c4 != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(c4, ",");
            int[] iArr2 = new int[stringTokenizer.countTokens()];
            int i4 = 0;
            while (stringTokenizer.hasMoreTokens()) {
                String trim = stringTokenizer.nextToken().trim();
                if ("id".equalsIgnoreCase(trim)) {
                    iArr2[i4] = 3;
                } else if ("instance".equalsIgnoreCase(trim)) {
                    iArr2[i4] = 1;
                } else if ("name".equalsIgnoreCase(trim)) {
                    iArr2[i4] = 2;
                } else if ("itemId".equalsIgnoreCase(trim)) {
                    iArr2[i4] = 4;
                } else if (!trim.isEmpty()) {
                    throw new InflateException(j.d("Unknown match type in matchOrder: '", trim, "'"));
                } else {
                    int[] iArr3 = new int[iArr2.length - 1];
                    System.arraycopy(iArr2, 0, iArr3, 0, i4);
                    i4--;
                    iArr2 = iArr3;
                }
                i4++;
            }
            if (iArr2.length == 0) {
                this.f2360j = iArr;
            } else {
                for (int i5 = 0; i5 < iArr2.length; i5++) {
                    int i6 = iArr2[i5];
                    if (i6 < 1 || i6 > 4) {
                        throw new IllegalArgumentException("matches contains invalid value");
                    }
                    for (int i7 = 0; i7 < i5; i7++) {
                        if (iArr2[i7] == i6) {
                            throw new IllegalArgumentException("matches contains a duplicate value");
                        }
                    }
                }
                this.f2360j = (int[]) iArr2.clone();
            }
        }
        obtainStyledAttributes.recycle();
    }
}