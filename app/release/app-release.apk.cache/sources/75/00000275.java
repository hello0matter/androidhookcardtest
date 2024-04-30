package androidx.fragment.app;

import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle$State;
import com.example.msphone.R;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public abstract class k0 {
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean D;
    public ArrayList E;
    public ArrayList F;
    public ArrayList G;
    public n0 H;
    public final x I;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1724b;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList f1726d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList f1727e;

    /* renamed from: g  reason: collision with root package name */
    public androidx.activity.w f1729g;

    /* renamed from: k  reason: collision with root package name */
    public final Map f1733k;

    /* renamed from: l  reason: collision with root package name */
    public final d0 f1734l;

    /* renamed from: m  reason: collision with root package name */
    public final d f1735m;

    /* renamed from: n  reason: collision with root package name */
    public final CopyOnWriteArrayList f1736n;

    /* renamed from: o  reason: collision with root package name */
    public int f1737o;

    /* renamed from: p  reason: collision with root package name */
    public w f1738p;

    /* renamed from: q  reason: collision with root package name */
    public com.google.common.collect.c f1739q;

    /* renamed from: r  reason: collision with root package name */
    public t f1740r;

    /* renamed from: s  reason: collision with root package name */
    public t f1741s;

    /* renamed from: t  reason: collision with root package name */
    public final f0 f1742t;

    /* renamed from: u  reason: collision with root package name */
    public final d0 f1743u;

    /* renamed from: v  reason: collision with root package name */
    public androidx.activity.result.c f1744v;

    /* renamed from: w  reason: collision with root package name */
    public androidx.activity.result.c f1745w;

    /* renamed from: x  reason: collision with root package name */
    public androidx.activity.result.c f1746x;

    /* renamed from: y  reason: collision with root package name */
    public ArrayDeque f1747y;

    /* renamed from: z  reason: collision with root package name */
    public boolean f1748z;

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList f1723a = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public final q0 f1725c = new q0();

    /* renamed from: f  reason: collision with root package name */
    public final c0 f1728f = new c0(this);

    /* renamed from: h  reason: collision with root package name */
    public final e0 f1730h = new e0(this);

    /* renamed from: i  reason: collision with root package name */
    public final AtomicInteger f1731i = new AtomicInteger();

    /* renamed from: j  reason: collision with root package name */
    public final Map f1732j = Collections.synchronizedMap(new HashMap());

    public k0() {
        Collections.synchronizedMap(new HashMap());
        this.f1733k = Collections.synchronizedMap(new HashMap());
        this.f1734l = new d0(this, 3);
        this.f1735m = new d(this);
        this.f1736n = new CopyOnWriteArrayList();
        this.f1737o = -1;
        this.f1742t = new f0(this);
        this.f1743u = new d0(this, 4);
        this.f1747y = new ArrayDeque();
        this.I = new x(3, this);
    }

    public static boolean G(t tVar) {
        tVar.getClass();
        Iterator it = tVar.f1820t.f1725c.e().iterator();
        boolean z4 = false;
        while (it.hasNext()) {
            t tVar2 = (t) it.next();
            if (tVar2 != null) {
                z4 = G(tVar2);
                continue;
            }
            if (z4) {
                return true;
            }
        }
        return false;
    }

    public static boolean H(t tVar) {
        if (tVar == null) {
            return true;
        }
        if (tVar.B && (tVar.f1818r == null || H(tVar.f1821u))) {
            return true;
        }
        return false;
    }

    public static boolean I(t tVar) {
        if (tVar == null) {
            return true;
        }
        k0 k0Var = tVar.f1818r;
        if (tVar.equals(k0Var.f1741s) && I(k0Var.f1740r)) {
            return true;
        }
        return false;
    }

    public static void X(t tVar) {
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "show: " + tVar);
        }
        if (tVar.f1825y) {
            tVar.f1825y = false;
            tVar.I = !tVar.I;
        }
    }

    public final void A(ArrayList arrayList, ArrayList arrayList2) {
    }

    public final t B(int i4) {
        q0 q0Var = this.f1725c;
        ArrayList arrayList = q0Var.f1775a;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            t tVar = (t) arrayList.get(size);
            if (tVar != null && tVar.f1822v == i4) {
                return tVar;
            }
        }
        for (p0 p0Var : q0Var.f1776b.values()) {
            if (p0Var != null) {
                t tVar2 = p0Var.f1771c;
                if (tVar2.f1822v == i4) {
                    return tVar2;
                }
            }
        }
        return null;
    }

    public final ViewGroup C(t tVar) {
        ViewGroup viewGroup = tVar.D;
        if (viewGroup != null) {
            return viewGroup;
        }
        if (tVar.f1823w > 0 && this.f1739q.o1()) {
            View l12 = this.f1739q.l1(tVar.f1823w);
            if (l12 instanceof ViewGroup) {
                return (ViewGroup) l12;
            }
        }
        return null;
    }

    public final f0 D() {
        t tVar = this.f1740r;
        if (tVar != null) {
            return tVar.f1818r.D();
        }
        return this.f1742t;
    }

    public final d0 E() {
        t tVar = this.f1740r;
        if (tVar != null) {
            return tVar.f1818r.E();
        }
        return this.f1743u;
    }

    public final void F(t tVar) {
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "hide: " + tVar);
        }
        if (!tVar.f1825y) {
            tVar.f1825y = true;
            tVar.I = true ^ tVar.I;
            W(tVar);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0094, code lost:
        if (r1 != 5) goto L33;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x01db A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00b8  */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.Object, e0.c] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void J(int r20, androidx.fragment.app.t r21) {
        /*
            Method dump skipped, instructions count: 557
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.k0.J(int, androidx.fragment.app.t):void");
    }

    public final void K(int i4, boolean z4) {
        HashMap hashMap;
        w wVar;
        if (this.f1738p == null && i4 != -1) {
            throw new IllegalStateException("No activity");
        }
        if (!z4 && i4 == this.f1737o) {
            return;
        }
        this.f1737o = i4;
        q0 q0Var = this.f1725c;
        Iterator it = q0Var.f1775a.iterator();
        while (true) {
            boolean hasNext = it.hasNext();
            hashMap = q0Var.f1776b;
            if (!hasNext) {
                break;
            }
            p0 p0Var = (p0) hashMap.get(((t) it.next()).f1805e);
            if (p0Var != null) {
                p0Var.k();
            }
        }
        for (p0 p0Var2 : hashMap.values()) {
            if (p0Var2 != null) {
                p0Var2.k();
                t tVar = p0Var2.f1771c;
                if (tVar.f1812l && tVar.f1817q <= 0) {
                    q0Var.h(p0Var2);
                }
            }
        }
        Y();
        if (this.f1748z && (wVar = this.f1738p) != null && this.f1737o == 7) {
            wVar.f1841u.d();
            this.f1748z = false;
        }
    }

    public final void L() {
        if (this.f1738p == null) {
            return;
        }
        this.A = false;
        this.B = false;
        this.H.f1759h = false;
        for (t tVar : this.f1725c.f()) {
            if (tVar != null) {
                tVar.f1820t.L();
            }
        }
    }

    public final boolean M() {
        x(false);
        w(true);
        t tVar = this.f1741s;
        if (tVar != null && tVar.h().M()) {
            return true;
        }
        boolean N = N(this.E, this.F, -1, 0);
        if (N) {
            this.f1724b = true;
            try {
                P(this.E, this.F);
            } finally {
                d();
            }
        }
        Z();
        t();
        this.f1725c.f1776b.values().removeAll(Collections.singleton(null));
        return N;
    }

    public final boolean N(ArrayList arrayList, ArrayList arrayList2, int i4, int i5) {
        int i6;
        a aVar;
        ArrayList arrayList3 = this.f1726d;
        if (arrayList3 == null) {
            return false;
        }
        if (i4 < 0 && (i5 & 1) == 0) {
            int size = arrayList3.size() - 1;
            if (size < 0) {
                return false;
            }
            arrayList.add(this.f1726d.remove(size));
            arrayList2.add(Boolean.TRUE);
        } else {
            if (i4 >= 0) {
                i6 = arrayList3.size() - 1;
                while (i6 >= 0) {
                    a aVar2 = (a) this.f1726d.get(i6);
                    if (i4 >= 0 && i4 == aVar2.f1648r) {
                        break;
                    }
                    i6--;
                }
                if (i6 < 0) {
                    return false;
                }
                if ((i5 & 1) != 0) {
                    do {
                        i6--;
                        if (i6 < 0) {
                            break;
                        }
                        aVar = (a) this.f1726d.get(i6);
                        if (i4 < 0) {
                            break;
                        }
                    } while (i4 == aVar.f1648r);
                }
            } else {
                i6 = -1;
            }
            if (i6 == this.f1726d.size() - 1) {
                return false;
            }
            for (int size2 = this.f1726d.size() - 1; size2 > i6; size2--) {
                arrayList.add(this.f1726d.remove(size2));
                arrayList2.add(Boolean.TRUE);
            }
        }
        return true;
    }

    public final void O(t tVar) {
        boolean z4;
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "remove: " + tVar + " nesting=" + tVar.f1817q);
        }
        if (tVar.f1817q > 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        boolean z5 = !z4;
        if (!tVar.f1826z || z5) {
            q0 q0Var = this.f1725c;
            synchronized (q0Var.f1775a) {
                q0Var.f1775a.remove(tVar);
            }
            tVar.f1811k = false;
            if (G(tVar)) {
                this.f1748z = true;
            }
            tVar.f1812l = true;
            W(tVar);
        }
    }

    public final void P(ArrayList arrayList, ArrayList arrayList2) {
        if (arrayList.isEmpty()) {
            return;
        }
        if (arrayList.size() != arrayList2.size()) {
            throw new IllegalStateException("Internal error with the back stack records");
        }
        int size = arrayList.size();
        int i4 = 0;
        int i5 = 0;
        while (i4 < size) {
            if (!((a) arrayList.get(i4)).f1645o) {
                if (i5 != i4) {
                    z(arrayList, arrayList2, i5, i4);
                }
                i5 = i4 + 1;
                if (((Boolean) arrayList2.get(i4)).booleanValue()) {
                    while (i5 < size && ((Boolean) arrayList2.get(i5)).booleanValue() && !((a) arrayList.get(i5)).f1645o) {
                        i5++;
                    }
                }
                z(arrayList, arrayList2, i4, i5);
                i4 = i5 - 1;
            }
            i4++;
        }
        if (i5 != size) {
            z(arrayList, arrayList2, i5, size);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v1, types: [java.lang.Object, androidx.fragment.app.s0] */
    public final void Q(Parcelable parcelable) {
        int i4;
        d dVar;
        int i5;
        boolean z4;
        p0 p0Var;
        if (parcelable == null) {
            return;
        }
        FragmentManagerState fragmentManagerState = (FragmentManagerState) parcelable;
        if (fragmentManagerState.f1595a == null) {
            return;
        }
        q0 q0Var = this.f1725c;
        q0Var.f1776b.clear();
        Iterator it = fragmentManagerState.f1595a.iterator();
        while (true) {
            boolean hasNext = it.hasNext();
            i4 = 2;
            dVar = this.f1735m;
            if (!hasNext) {
                break;
            }
            FragmentState fragmentState = (FragmentState) it.next();
            if (fragmentState != null) {
                t tVar = (t) this.H.f1754c.get(fragmentState.f1604b);
                if (tVar != null) {
                    if (Log.isLoggable("FragmentManager", 2)) {
                        Log.v("FragmentManager", "restoreSaveState: re-attaching retained " + tVar);
                    }
                    p0Var = new p0(dVar, q0Var, tVar, fragmentState);
                } else {
                    p0Var = new p0(this.f1735m, this.f1725c, this.f1738p.f1838r.getClassLoader(), D(), fragmentState);
                }
                t tVar2 = p0Var.f1771c;
                tVar2.f1818r = this;
                if (Log.isLoggable("FragmentManager", 2)) {
                    Log.v("FragmentManager", "restoreSaveState: active (" + tVar2.f1805e + "): " + tVar2);
                }
                p0Var.m(this.f1738p.f1838r.getClassLoader());
                q0Var.g(p0Var);
                p0Var.f1773e = this.f1737o;
            }
        }
        n0 n0Var = this.H;
        n0Var.getClass();
        Iterator it2 = new ArrayList(n0Var.f1754c.values()).iterator();
        while (it2.hasNext()) {
            t tVar3 = (t) it2.next();
            if (q0Var.f1776b.get(tVar3.f1805e) != null) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (!z4) {
                if (Log.isLoggable("FragmentManager", 2)) {
                    Log.v("FragmentManager", "Discarding retained Fragment " + tVar3 + " that was not found in the set of active Fragments " + fragmentManagerState.f1595a);
                }
                this.H.b(tVar3);
                tVar3.f1818r = this;
                p0 p0Var2 = new p0(dVar, q0Var, tVar3);
                p0Var2.f1773e = 1;
                p0Var2.k();
                tVar3.f1812l = true;
                p0Var2.k();
            }
        }
        ArrayList<String> arrayList = fragmentManagerState.f1596b;
        q0Var.f1775a.clear();
        if (arrayList != null) {
            for (String str : arrayList) {
                t b5 = q0Var.b(str);
                if (b5 != null) {
                    if (Log.isLoggable("FragmentManager", 2)) {
                        Log.v("FragmentManager", "restoreSaveState: added (" + str + "): " + b5);
                    }
                    q0Var.a(b5);
                } else {
                    throw new IllegalStateException(androidx.activity.j.d("No instantiated fragment for (", str, ")"));
                }
            }
        }
        t tVar4 = null;
        if (fragmentManagerState.f1597c != null) {
            this.f1726d = new ArrayList(fragmentManagerState.f1597c.length);
            int i6 = 0;
            while (true) {
                BackStackState[] backStackStateArr = fragmentManagerState.f1597c;
                if (i6 >= backStackStateArr.length) {
                    break;
                }
                BackStackState backStackState = backStackStateArr[i6];
                backStackState.getClass();
                a aVar = new a(this);
                int i7 = 0;
                int i8 = 0;
                while (true) {
                    int[] iArr = backStackState.f1568a;
                    if (i7 >= iArr.length) {
                        break;
                    }
                    ?? obj = new Object();
                    int i9 = i7 + 1;
                    obj.f1793a = iArr[i7];
                    if (Log.isLoggable("FragmentManager", i4)) {
                        Log.v("FragmentManager", "Instantiate " + aVar + " op #" + i8 + " base fragment #" + iArr[i9]);
                    }
                    String str2 = (String) backStackState.f1569b.get(i8);
                    if (str2 != null) {
                        obj.f1794b = q0Var.b(str2);
                    } else {
                        obj.f1794b = tVar4;
                    }
                    obj.f1799g = Lifecycle$State.values()[backStackState.f1570c[i8]];
                    obj.f1800h = Lifecycle$State.values()[backStackState.f1571d[i8]];
                    int i10 = iArr[i9];
                    obj.f1795c = i10;
                    int i11 = iArr[i7 + 2];
                    obj.f1796d = i11;
                    int i12 = i7 + 4;
                    int i13 = iArr[i7 + 3];
                    obj.f1797e = i13;
                    i7 += 5;
                    int i14 = iArr[i12];
                    obj.f1798f = i14;
                    aVar.f1632b = i10;
                    aVar.f1633c = i11;
                    aVar.f1634d = i13;
                    aVar.f1635e = i14;
                    aVar.b(obj);
                    i8++;
                    tVar4 = null;
                    i4 = 2;
                }
                aVar.f1636f = backStackState.f1572e;
                aVar.f1638h = backStackState.f1573f;
                aVar.f1648r = backStackState.f1574g;
                aVar.f1637g = true;
                aVar.f1639i = backStackState.f1575h;
                aVar.f1640j = backStackState.f1576i;
                aVar.f1641k = backStackState.f1577j;
                aVar.f1642l = backStackState.f1578k;
                aVar.f1643m = backStackState.f1579l;
                aVar.f1644n = backStackState.f1580m;
                aVar.f1645o = backStackState.f1581n;
                aVar.c(1);
                if (Log.isLoggable("FragmentManager", 2)) {
                    Log.v("FragmentManager", "restoreAllState: back stack #" + i6 + " (index " + aVar.f1648r + "): " + aVar);
                    PrintWriter printWriter = new PrintWriter(new d1());
                    aVar.f("  ", printWriter, false);
                    printWriter.close();
                }
                this.f1726d.add(aVar);
                i6++;
                i4 = 2;
                tVar4 = null;
            }
            i5 = 0;
        } else {
            i5 = 0;
            this.f1726d = null;
        }
        this.f1731i.set(fragmentManagerState.f1598d);
        String str3 = fragmentManagerState.f1599e;
        if (str3 != null) {
            t b6 = q0Var.b(str3);
            this.f1741s = b6;
            p(b6);
        }
        ArrayList arrayList2 = fragmentManagerState.f1600f;
        if (arrayList2 != null) {
            while (i5 < arrayList2.size()) {
                Bundle bundle = (Bundle) fragmentManagerState.f1601g.get(i5);
                bundle.setClassLoader(this.f1738p.f1838r.getClassLoader());
                this.f1732j.put(arrayList2.get(i5), bundle);
                i5++;
            }
        }
        this.f1747y = new ArrayDeque(fragmentManagerState.f1602h);
    }

    /* JADX WARN: Type inference failed for: r0v15, types: [android.os.Parcelable, androidx.fragment.app.FragmentManagerState, java.lang.Object] */
    public final Parcelable R() {
        int i4;
        ArrayList arrayList;
        BackStackState[] backStackStateArr;
        int size;
        Iterator it = e().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            g1 g1Var = (g1) it.next();
            if (g1Var.f1711e) {
                g1Var.f1711e = false;
                g1Var.c();
            }
        }
        Iterator it2 = e().iterator();
        while (it2.hasNext()) {
            ((g1) it2.next()).e();
        }
        x(true);
        this.A = true;
        this.H.f1759h = true;
        q0 q0Var = this.f1725c;
        q0Var.getClass();
        HashMap hashMap = q0Var.f1776b;
        ArrayList arrayList2 = new ArrayList(hashMap.size());
        Iterator it3 = hashMap.values().iterator();
        while (true) {
            Bundle bundle = null;
            if (!it3.hasNext()) {
                break;
            }
            p0 p0Var = (p0) it3.next();
            if (p0Var != null) {
                t tVar = p0Var.f1771c;
                FragmentState fragmentState = new FragmentState(tVar);
                if (tVar.f1801a > -1 && fragmentState.f1615m == null) {
                    Bundle bundle2 = new Bundle();
                    tVar.w(bundle2);
                    tVar.P.c(bundle2);
                    Parcelable R = tVar.f1820t.R();
                    if (R != null) {
                        bundle2.putParcelable("android:support:fragments", R);
                    }
                    p0Var.f1769a.k(false);
                    if (!bundle2.isEmpty()) {
                        bundle = bundle2;
                    }
                    if (tVar.E != null) {
                        p0Var.o();
                    }
                    if (tVar.f1803c != null) {
                        if (bundle == null) {
                            bundle = new Bundle();
                        }
                        bundle.putSparseParcelableArray("android:view_state", tVar.f1803c);
                    }
                    if (tVar.f1804d != null) {
                        if (bundle == null) {
                            bundle = new Bundle();
                        }
                        bundle.putBundle("android:view_registry_state", tVar.f1804d);
                    }
                    if (!tVar.G) {
                        if (bundle == null) {
                            bundle = new Bundle();
                        }
                        bundle.putBoolean("android:user_visible_hint", tVar.G);
                    }
                    fragmentState.f1615m = bundle;
                    if (tVar.f1808h != null) {
                        if (bundle == null) {
                            fragmentState.f1615m = new Bundle();
                        }
                        fragmentState.f1615m.putString("android:target_state", tVar.f1808h);
                        int i5 = tVar.f1809i;
                        if (i5 != 0) {
                            fragmentState.f1615m.putInt("android:target_req_state", i5);
                        }
                    }
                } else {
                    fragmentState.f1615m = tVar.f1802b;
                }
                arrayList2.add(fragmentState);
                if (Log.isLoggable("FragmentManager", 2)) {
                    Log.v("FragmentManager", "Saved state of " + tVar + ": " + fragmentState.f1615m);
                }
            }
        }
        if (arrayList2.isEmpty()) {
            if (Log.isLoggable("FragmentManager", 2)) {
                Log.v("FragmentManager", "saveAllState: no fragments!");
            }
            return null;
        }
        q0 q0Var2 = this.f1725c;
        synchronized (q0Var2.f1775a) {
            try {
                if (q0Var2.f1775a.isEmpty()) {
                    arrayList = null;
                } else {
                    arrayList = new ArrayList(q0Var2.f1775a.size());
                    Iterator it4 = q0Var2.f1775a.iterator();
                    while (it4.hasNext()) {
                        t tVar2 = (t) it4.next();
                        arrayList.add(tVar2.f1805e);
                        if (Log.isLoggable("FragmentManager", 2)) {
                            Log.v("FragmentManager", "saveAllState: adding fragment (" + tVar2.f1805e + "): " + tVar2);
                        }
                    }
                }
            } finally {
            }
        }
        ArrayList arrayList3 = this.f1726d;
        if (arrayList3 != null && (size = arrayList3.size()) > 0) {
            backStackStateArr = new BackStackState[size];
            for (i4 = 0; i4 < size; i4++) {
                backStackStateArr[i4] = new BackStackState((a) this.f1726d.get(i4));
                if (Log.isLoggable("FragmentManager", 2)) {
                    Log.v("FragmentManager", "saveAllState: adding back stack #" + i4 + ": " + this.f1726d.get(i4));
                }
            }
        } else {
            backStackStateArr = null;
        }
        ?? obj = new Object();
        obj.f1599e = null;
        ArrayList arrayList4 = new ArrayList();
        obj.f1600f = arrayList4;
        ArrayList arrayList5 = new ArrayList();
        obj.f1601g = arrayList5;
        obj.f1595a = arrayList2;
        obj.f1596b = arrayList;
        obj.f1597c = backStackStateArr;
        obj.f1598d = this.f1731i.get();
        t tVar3 = this.f1741s;
        if (tVar3 != null) {
            obj.f1599e = tVar3.f1805e;
        }
        arrayList4.addAll(this.f1732j.keySet());
        arrayList5.addAll(this.f1732j.values());
        obj.f1602h = new ArrayList(this.f1747y);
        return obj;
    }

    public final void S() {
        synchronized (this.f1723a) {
            try {
                if (this.f1723a.size() == 1) {
                    this.f1738p.f1839s.removeCallbacks(this.I);
                    this.f1738p.f1839s.post(this.I);
                    Z();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void T(t tVar, boolean z4) {
        ViewGroup C = C(tVar);
        if (C == null || !(C instanceof FragmentContainerView)) {
            return;
        }
        ((FragmentContainerView) C).setDrawDisappearingViewsLast(!z4);
    }

    public final void U(t tVar, Lifecycle$State lifecycle$State) {
        if (tVar.equals(this.f1725c.b(tVar.f1805e)) && (tVar.f1819s == null || tVar.f1818r == this)) {
            tVar.L = lifecycle$State;
            return;
        }
        throw new IllegalArgumentException("Fragment " + tVar + " is not an active fragment of FragmentManager " + this);
    }

    public final void V(t tVar) {
        if (tVar != null) {
            if (!tVar.equals(this.f1725c.b(tVar.f1805e)) || (tVar.f1819s != null && tVar.f1818r != this)) {
                throw new IllegalArgumentException("Fragment " + tVar + " is not an active fragment of FragmentManager " + this);
            }
        }
        t tVar2 = this.f1741s;
        this.f1741s = tVar;
        p(tVar2);
        p(this.f1741s);
    }

    public final void W(t tVar) {
        int i4;
        int i5;
        int i6;
        int i7;
        ViewGroup C = C(tVar);
        if (C != null) {
            r rVar = tVar.H;
            boolean z4 = false;
            if (rVar == null) {
                i4 = 0;
            } else {
                i4 = rVar.f1781d;
            }
            if (rVar == null) {
                i5 = 0;
            } else {
                i5 = rVar.f1782e;
            }
            int i8 = i5 + i4;
            if (rVar == null) {
                i6 = 0;
            } else {
                i6 = rVar.f1783f;
            }
            int i9 = i6 + i8;
            if (rVar == null) {
                i7 = 0;
            } else {
                i7 = rVar.f1784g;
            }
            if (i7 + i9 > 0) {
                if (C.getTag(R.id.visible_removing_fragment_view_tag) == null) {
                    C.setTag(R.id.visible_removing_fragment_view_tag, tVar);
                }
                t tVar2 = (t) C.getTag(R.id.visible_removing_fragment_view_tag);
                r rVar2 = tVar.H;
                if (rVar2 != null) {
                    z4 = rVar2.f1780c;
                }
                if (tVar2.H != null) {
                    tVar2.g().f1780c = z4;
                }
            }
        }
    }

    public final void Y() {
        Iterator it = this.f1725c.d().iterator();
        while (it.hasNext()) {
            p0 p0Var = (p0) it.next();
            t tVar = p0Var.f1771c;
            if (tVar.F) {
                if (this.f1724b) {
                    this.D = true;
                } else {
                    tVar.F = false;
                    p0Var.k();
                }
            }
        }
    }

    public final void Z() {
        synchronized (this.f1723a) {
            try {
                boolean z4 = true;
                if (!this.f1723a.isEmpty()) {
                    e0 e0Var = this.f1730h;
                    e0Var.f1683a = true;
                    e3.a aVar = e0Var.f1685c;
                    if (aVar != null) {
                        aVar.a();
                    }
                    return;
                }
                e0 e0Var2 = this.f1730h;
                ArrayList arrayList = this.f1726d;
                e0Var2.f1683a = (arrayList == null || arrayList.size() <= 0 || !I(this.f1740r)) ? false : false;
                e3.a aVar2 = e0Var2.f1685c;
                if (aVar2 != null) {
                    aVar2.a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final p0 a(t tVar) {
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "add: " + tVar);
        }
        p0 f4 = f(tVar);
        tVar.f1818r = this;
        q0 q0Var = this.f1725c;
        q0Var.g(f4);
        if (!tVar.f1826z) {
            q0Var.a(tVar);
            tVar.f1812l = false;
            if (tVar.E == null) {
                tVar.I = false;
            }
            if (G(tVar)) {
                this.f1748z = true;
            }
        }
        return f4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Object, com.google.common.collect.c] */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object, com.google.common.collect.c] */
    /* JADX WARN: Type inference failed for: r8v4, types: [java.lang.Object, com.google.common.collect.c] */
    public final void b(w wVar, com.google.common.collect.c cVar, t tVar) {
        n0 n0Var;
        boolean z4;
        String str;
        w wVar2;
        if (this.f1738p == null) {
            this.f1738p = wVar;
            this.f1739q = cVar;
            this.f1740r = tVar;
            CopyOnWriteArrayList copyOnWriteArrayList = this.f1736n;
            if (tVar != 0) {
                copyOnWriteArrayList.add(new g0(tVar));
            } else if (wVar instanceof o0) {
                copyOnWriteArrayList.add(wVar);
            }
            if (this.f1740r != null) {
                Z();
            }
            if (wVar instanceof androidx.activity.x) {
                androidx.activity.w i4 = wVar.f1841u.i();
                this.f1729g = i4;
                if (tVar != 0) {
                    wVar2 = tVar;
                } else {
                    wVar2 = wVar;
                }
                i4.a(wVar2, this.f1730h);
            }
            if (tVar != 0) {
                n0 n0Var2 = tVar.f1818r.H;
                HashMap hashMap = n0Var2.f1755d;
                n0 n0Var3 = (n0) hashMap.get(tVar.f1805e);
                if (n0Var3 == null) {
                    n0Var3 = new n0(n0Var2.f1757f);
                    hashMap.put(tVar.f1805e, n0Var3);
                }
                this.H = n0Var3;
            } else {
                if (wVar instanceof androidx.lifecycle.l0) {
                    androidx.appcompat.app.c cVar2 = new androidx.appcompat.app.c(wVar.f1841u.e(), n0.f1753i);
                    String canonicalName = n0.class.getCanonicalName();
                    if (canonicalName != null) {
                        n0Var = (n0) cVar2.k(n0.class, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(canonicalName));
                    } else {
                        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
                    }
                } else {
                    n0Var = new n0(false);
                }
                this.H = n0Var;
            }
            n0 n0Var4 = this.H;
            if (!this.A && !this.B) {
                z4 = false;
            } else {
                z4 = true;
            }
            n0Var4.f1759h = z4;
            this.f1725c.f1777c = n0Var4;
            w wVar3 = this.f1738p;
            if (wVar3 instanceof androidx.activity.result.g) {
                androidx.activity.i iVar = wVar3.f1841u.f68k;
                if (tVar != 0) {
                    str = androidx.activity.j.e(new StringBuilder(), tVar.f1805e, ":");
                } else {
                    str = "";
                }
                String str2 = "FragmentManager:" + str;
                this.f1744v = iVar.d(androidx.activity.j.c(str2, "StartActivityForResult"), new Object(), new d0(this, 2));
                this.f1745w = iVar.d(androidx.activity.j.c(str2, "StartIntentSenderForResult"), new Object(), new d0(this, 0));
                this.f1746x = iVar.d(androidx.activity.j.c(str2, "RequestPermissions"), new Object(), new d0(this, 1));
                return;
            }
            return;
        }
        throw new IllegalStateException("Already attached");
    }

    public final void c(t tVar) {
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "attach: " + tVar);
        }
        if (tVar.f1826z) {
            tVar.f1826z = false;
            if (!tVar.f1811k) {
                this.f1725c.a(tVar);
                if (Log.isLoggable("FragmentManager", 2)) {
                    Log.v("FragmentManager", "add from attach: " + tVar);
                }
                if (G(tVar)) {
                    this.f1748z = true;
                }
            }
        }
    }

    public final void d() {
        this.f1724b = false;
        this.F.clear();
        this.E.clear();
    }

    public final HashSet e() {
        HashSet hashSet = new HashSet();
        Iterator it = this.f1725c.d().iterator();
        while (it.hasNext()) {
            ViewGroup viewGroup = ((p0) it.next()).f1771c.D;
            if (viewGroup != null) {
                hashSet.add(g1.f(viewGroup, E()));
            }
        }
        return hashSet;
    }

    public final p0 f(t tVar) {
        String str = tVar.f1805e;
        q0 q0Var = this.f1725c;
        p0 p0Var = (p0) q0Var.f1776b.get(str);
        if (p0Var != null) {
            return p0Var;
        }
        p0 p0Var2 = new p0(this.f1735m, q0Var, tVar);
        p0Var2.m(this.f1738p.f1838r.getClassLoader());
        p0Var2.f1773e = this.f1737o;
        return p0Var2;
    }

    public final void g(t tVar) {
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "detach: " + tVar);
        }
        if (!tVar.f1826z) {
            tVar.f1826z = true;
            if (tVar.f1811k) {
                if (Log.isLoggable("FragmentManager", 2)) {
                    Log.v("FragmentManager", "remove from detach: " + tVar);
                }
                q0 q0Var = this.f1725c;
                synchronized (q0Var.f1775a) {
                    q0Var.f1775a.remove(tVar);
                }
                tVar.f1811k = false;
                if (G(tVar)) {
                    this.f1748z = true;
                }
                W(tVar);
            }
        }
    }

    public final void h() {
        for (t tVar : this.f1725c.f()) {
            if (tVar != null) {
                tVar.C = true;
                tVar.f1820t.h();
            }
        }
    }

    public final boolean i() {
        if (this.f1737o < 1) {
            return false;
        }
        for (t tVar : this.f1725c.f()) {
            if (tVar != null && !tVar.f1825y && tVar.f1820t.i()) {
                return true;
            }
        }
        return false;
    }

    public final boolean j() {
        if (this.f1737o < 1) {
            return false;
        }
        ArrayList arrayList = null;
        boolean z4 = false;
        for (t tVar : this.f1725c.f()) {
            if (tVar != null && H(tVar) && !tVar.f1825y && tVar.f1820t.j()) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(tVar);
                z4 = true;
            }
        }
        if (this.f1727e != null) {
            for (int i4 = 0; i4 < this.f1727e.size(); i4++) {
                t tVar2 = (t) this.f1727e.get(i4);
                if (arrayList == null || !arrayList.contains(tVar2)) {
                    tVar2.getClass();
                }
            }
        }
        this.f1727e = arrayList;
        return z4;
    }

    public final void k() {
        this.C = true;
        x(true);
        Iterator it = e().iterator();
        while (it.hasNext()) {
            ((g1) it.next()).e();
        }
        s(-1);
        this.f1738p = null;
        this.f1739q = null;
        this.f1740r = null;
        if (this.f1729g != null) {
            Iterator it2 = this.f1730h.f1684b.iterator();
            while (it2.hasNext()) {
                ((androidx.activity.c) it2.next()).cancel();
            }
            this.f1729g = null;
        }
        androidx.activity.result.c cVar = this.f1744v;
        if (cVar != null) {
            int i4 = cVar.f131q;
            String str = cVar.f132r;
            androidx.activity.result.f fVar = cVar.f134t;
            switch (i4) {
                case 0:
                    fVar.f(str);
                    break;
                default:
                    fVar.f(str);
                    break;
            }
            androidx.activity.result.c cVar2 = this.f1745w;
            int i5 = cVar2.f131q;
            String str2 = cVar2.f132r;
            androidx.activity.result.f fVar2 = cVar2.f134t;
            switch (i5) {
                case 0:
                    fVar2.f(str2);
                    break;
                default:
                    fVar2.f(str2);
                    break;
            }
            androidx.activity.result.c cVar3 = this.f1746x;
            int i6 = cVar3.f131q;
            String str3 = cVar3.f132r;
            androidx.activity.result.f fVar3 = cVar3.f134t;
            switch (i6) {
                case 0:
                    fVar3.f(str3);
                    return;
                default:
                    fVar3.f(str3);
                    return;
            }
        }
    }

    public final void l() {
        for (t tVar : this.f1725c.f()) {
            if (tVar != null) {
                tVar.C = true;
                tVar.f1820t.l();
            }
        }
    }

    public final void m(boolean z4) {
        for (t tVar : this.f1725c.f()) {
            if (tVar != null) {
                tVar.f1820t.m(z4);
            }
        }
    }

    public final boolean n() {
        if (this.f1737o < 1) {
            return false;
        }
        for (t tVar : this.f1725c.f()) {
            if (tVar != null && !tVar.f1825y && tVar.f1820t.n()) {
                return true;
            }
        }
        return false;
    }

    public final void o() {
        if (this.f1737o < 1) {
            return;
        }
        for (t tVar : this.f1725c.f()) {
            if (tVar != null && !tVar.f1825y) {
                tVar.f1820t.o();
            }
        }
    }

    public final void p(t tVar) {
        if (tVar != null) {
            if (tVar.equals(this.f1725c.b(tVar.f1805e))) {
                tVar.f1818r.getClass();
                boolean I = I(tVar);
                Boolean bool = tVar.f1810j;
                if (bool == null || bool.booleanValue() != I) {
                    tVar.f1810j = Boolean.valueOf(I);
                    l0 l0Var = tVar.f1820t;
                    l0Var.Z();
                    l0Var.p(l0Var.f1741s);
                }
            }
        }
    }

    public final void q(boolean z4) {
        for (t tVar : this.f1725c.f()) {
            if (tVar != null) {
                tVar.f1820t.q(z4);
            }
        }
    }

    public final boolean r() {
        boolean z4 = false;
        if (this.f1737o < 1) {
            return false;
        }
        for (t tVar : this.f1725c.f()) {
            if (tVar != null && H(tVar) && !tVar.f1825y && tVar.f1820t.r()) {
                z4 = true;
            }
        }
        return z4;
    }

    public final void s(int i4) {
        try {
            this.f1724b = true;
            for (p0 p0Var : this.f1725c.f1776b.values()) {
                if (p0Var != null) {
                    p0Var.f1773e = i4;
                }
            }
            K(i4, false);
            Iterator it = e().iterator();
            while (it.hasNext()) {
                ((g1) it.next()).e();
            }
            this.f1724b = false;
            x(true);
        } catch (Throwable th) {
            this.f1724b = false;
            throw th;
        }
    }

    public final void t() {
        if (this.D) {
            this.D = false;
            Y();
        }
    }

    public final String toString() {
        Object obj;
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        t tVar = this.f1740r;
        if (tVar != null) {
            sb.append(tVar.getClass().getSimpleName());
            sb.append("{");
            obj = this.f1740r;
        } else {
            w wVar = this.f1738p;
            if (wVar == null) {
                sb.append("null");
                sb.append("}}");
                return sb.toString();
            }
            sb.append(wVar.getClass().getSimpleName());
            sb.append("{");
            obj = this.f1738p;
        }
        sb.append(Integer.toHexString(System.identityHashCode(obj)));
        sb.append("}");
        sb.append("}}");
        return sb.toString();
    }

    public final void u(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        String c4 = androidx.activity.j.c(str, "    ");
        q0 q0Var = this.f1725c;
        q0Var.getClass();
        String str2 = str + "    ";
        HashMap hashMap = q0Var.f1776b;
        if (!hashMap.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Active Fragments:");
            for (p0 p0Var : hashMap.values()) {
                printWriter.print(str);
                if (p0Var != null) {
                    t tVar = p0Var.f1771c;
                    printWriter.println(tVar);
                    tVar.d(str2, fileDescriptor, printWriter, strArr);
                } else {
                    printWriter.println("null");
                }
            }
        }
        ArrayList arrayList = q0Var.f1775a;
        int size3 = arrayList.size();
        if (size3 > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i4 = 0; i4 < size3; i4++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i4);
                printWriter.print(": ");
                printWriter.println(((t) arrayList.get(i4)).toString());
            }
        }
        ArrayList arrayList2 = this.f1727e;
        if (arrayList2 != null && (size2 = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i5 = 0; i5 < size2; i5++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i5);
                printWriter.print(": ");
                printWriter.println(((t) this.f1727e.get(i5)).toString());
            }
        }
        ArrayList arrayList3 = this.f1726d;
        if (arrayList3 != null && (size = arrayList3.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i6 = 0; i6 < size; i6++) {
                a aVar = (a) this.f1726d.get(i6);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i6);
                printWriter.print(": ");
                printWriter.println(aVar.toString());
                aVar.f(c4, printWriter, true);
            }
        }
        printWriter.print(str);
        printWriter.println("Back Stack Index: " + this.f1731i.get());
        synchronized (this.f1723a) {
            try {
                int size4 = this.f1723a.size();
                if (size4 > 0) {
                    printWriter.print(str);
                    printWriter.println("Pending Actions:");
                    for (int i7 = 0; i7 < size4; i7++) {
                        printWriter.print(str);
                        printWriter.print("  #");
                        printWriter.print(i7);
                        printWriter.print(": ");
                        printWriter.println((i0) this.f1723a.get(i7));
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.f1738p);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.f1739q);
        if (this.f1740r != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.f1740r);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.f1737o);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.A);
        printWriter.print(" mStopped=");
        printWriter.print(this.B);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.C);
        if (this.f1748z) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.f1748z);
        }
    }

    public final void v(i0 i0Var, boolean z4) {
        if (!z4) {
            if (this.f1738p == null) {
                if (this.C) {
                    throw new IllegalStateException("FragmentManager has been destroyed");
                }
                throw new IllegalStateException("FragmentManager has not been attached to a host.");
            } else if (this.A || this.B) {
                throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
            }
        }
        synchronized (this.f1723a) {
            try {
                if (this.f1738p == null) {
                    if (z4) {
                        return;
                    }
                    throw new IllegalStateException("Activity has been destroyed");
                }
                this.f1723a.add(i0Var);
                S();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void w(boolean z4) {
        if (!this.f1724b) {
            if (this.f1738p == null) {
                if (this.C) {
                    throw new IllegalStateException("FragmentManager has been destroyed");
                }
                throw new IllegalStateException("FragmentManager has not been attached to a host.");
            } else if (Looper.myLooper() == this.f1738p.f1839s.getLooper()) {
                if (!z4 && (this.A || this.B)) {
                    throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
                }
                if (this.E == null) {
                    this.E = new ArrayList();
                    this.F = new ArrayList();
                }
                this.f1724b = false;
                return;
            } else {
                throw new IllegalStateException("Must be called from main thread of fragment host");
            }
        }
        throw new IllegalStateException("FragmentManager is already executing transactions");
    }

    public final boolean x(boolean z4) {
        w(z4);
        boolean z5 = false;
        while (true) {
            ArrayList arrayList = this.E;
            ArrayList arrayList2 = this.F;
            synchronized (this.f1723a) {
                try {
                    if (this.f1723a.isEmpty()) {
                        break;
                    }
                    int size = this.f1723a.size();
                    boolean z6 = false;
                    for (int i4 = 0; i4 < size; i4++) {
                        z6 |= ((i0) this.f1723a.get(i4)).a(arrayList, arrayList2);
                    }
                    this.f1723a.clear();
                    this.f1738p.f1839s.removeCallbacks(this.I);
                    if (!z6) {
                        break;
                    }
                    z5 = true;
                    this.f1724b = true;
                    try {
                        P(this.E, this.F);
                    } finally {
                        d();
                    }
                } finally {
                }
            }
        }
        Z();
        t();
        this.f1725c.f1776b.values().removeAll(Collections.singleton(null));
        return z5;
    }

    public final void y(a aVar, boolean z4) {
        if (z4 && (this.f1738p == null || this.C)) {
            return;
        }
        w(z4);
        aVar.a(this.E, this.F);
        this.f1724b = true;
        try {
            P(this.E, this.F);
            d();
            Z();
            t();
            this.f1725c.f1776b.values().removeAll(Collections.singleton(null));
        } catch (Throwable th) {
            d();
            throw th;
        }
    }

    public final void z(ArrayList arrayList, ArrayList arrayList2, int i4, int i5) {
        ViewGroup viewGroup;
        q0 q0Var;
        q0 q0Var2;
        q0 q0Var3;
        int i6;
        int i7;
        ArrayList arrayList3 = arrayList2;
        boolean z4 = ((a) arrayList.get(i4)).f1645o;
        ArrayList arrayList4 = this.G;
        if (arrayList4 == null) {
            this.G = new ArrayList();
        } else {
            arrayList4.clear();
        }
        ArrayList arrayList5 = this.G;
        q0 q0Var4 = this.f1725c;
        arrayList5.addAll(q0Var4.f());
        t tVar = this.f1741s;
        int i8 = i4;
        boolean z5 = false;
        while (true) {
            int i9 = 1;
            if (i8 < i5) {
                a aVar = (a) arrayList.get(i8);
                if (!((Boolean) arrayList3.get(i8)).booleanValue()) {
                    ArrayList arrayList6 = this.G;
                    int i10 = 0;
                    while (i10 < aVar.f1631a.size()) {
                        s0 s0Var = (s0) aVar.f1631a.get(i10);
                        int i11 = s0Var.f1793a;
                        if (i11 != i9) {
                            if (i11 != 2) {
                                if (i11 != 3 && i11 != 6) {
                                    if (i11 != 7) {
                                        if (i11 == 8) {
                                            aVar.f1631a.add(i10, new s0(9, tVar));
                                            i10++;
                                            tVar = s0Var.f1794b;
                                        }
                                    } else {
                                        q0Var3 = q0Var4;
                                        i6 = 1;
                                    }
                                } else {
                                    arrayList6.remove(s0Var.f1794b);
                                    t tVar2 = s0Var.f1794b;
                                    if (tVar2 == tVar) {
                                        aVar.f1631a.add(i10, new s0(9, tVar2));
                                        i10++;
                                        q0Var3 = q0Var4;
                                        i6 = 1;
                                        tVar = null;
                                        i10 += i6;
                                        i9 = i6;
                                        q0Var4 = q0Var3;
                                    }
                                }
                                q0Var3 = q0Var4;
                                i6 = 1;
                                i10 += i6;
                                i9 = i6;
                                q0Var4 = q0Var3;
                            } else {
                                t tVar3 = s0Var.f1794b;
                                int i12 = tVar3.f1823w;
                                int size = arrayList6.size() - 1;
                                boolean z6 = false;
                                while (size >= 0) {
                                    t tVar4 = (t) arrayList6.get(size);
                                    q0 q0Var5 = q0Var4;
                                    if (tVar4.f1823w == i12) {
                                        if (tVar4 == tVar3) {
                                            i7 = i12;
                                            z6 = true;
                                        } else {
                                            if (tVar4 == tVar) {
                                                i7 = i12;
                                                aVar.f1631a.add(i10, new s0(9, tVar4));
                                                i10++;
                                                tVar = null;
                                            } else {
                                                i7 = i12;
                                            }
                                            s0 s0Var2 = new s0(3, tVar4);
                                            s0Var2.f1795c = s0Var.f1795c;
                                            s0Var2.f1797e = s0Var.f1797e;
                                            s0Var2.f1796d = s0Var.f1796d;
                                            s0Var2.f1798f = s0Var.f1798f;
                                            aVar.f1631a.add(i10, s0Var2);
                                            arrayList6.remove(tVar4);
                                            i10++;
                                        }
                                    } else {
                                        i7 = i12;
                                    }
                                    size--;
                                    q0Var4 = q0Var5;
                                    i12 = i7;
                                }
                                q0Var3 = q0Var4;
                                if (z6) {
                                    aVar.f1631a.remove(i10);
                                    i10--;
                                    i6 = 1;
                                    i10 += i6;
                                    i9 = i6;
                                    q0Var4 = q0Var3;
                                } else {
                                    i6 = 1;
                                    s0Var.f1793a = 1;
                                    arrayList6.add(tVar3);
                                    i10 += i6;
                                    i9 = i6;
                                    q0Var4 = q0Var3;
                                }
                            }
                        } else {
                            q0Var3 = q0Var4;
                            i6 = i9;
                        }
                        arrayList6.add(s0Var.f1794b);
                        i10 += i6;
                        i9 = i6;
                        q0Var4 = q0Var3;
                    }
                    q0Var2 = q0Var4;
                } else {
                    q0Var2 = q0Var4;
                    int i13 = 1;
                    ArrayList arrayList7 = this.G;
                    int size2 = aVar.f1631a.size() - 1;
                    while (size2 >= 0) {
                        s0 s0Var3 = (s0) aVar.f1631a.get(size2);
                        int i14 = s0Var3.f1793a;
                        if (i14 != i13) {
                            if (i14 != 3) {
                                switch (i14) {
                                    case 8:
                                        tVar = null;
                                        break;
                                    case 9:
                                        tVar = s0Var3.f1794b;
                                        break;
                                    case 10:
                                        s0Var3.f1800h = s0Var3.f1799g;
                                        break;
                                }
                                size2--;
                                i13 = 1;
                            }
                            arrayList7.add(s0Var3.f1794b);
                            size2--;
                            i13 = 1;
                        }
                        arrayList7.remove(s0Var3.f1794b);
                        size2--;
                        i13 = 1;
                    }
                }
                if (!z5 && !aVar.f1637g) {
                    z5 = false;
                } else {
                    z5 = true;
                }
                i8++;
                arrayList3 = arrayList2;
                q0Var4 = q0Var2;
            } else {
                q0 q0Var6 = q0Var4;
                this.G.clear();
                if (!z4 && this.f1737o >= 1) {
                    for (int i15 = i4; i15 < i5; i15++) {
                        Iterator it = ((a) arrayList.get(i15)).f1631a.iterator();
                        while (it.hasNext()) {
                            t tVar5 = ((s0) it.next()).f1794b;
                            if (tVar5 != null && tVar5.f1818r != null) {
                                q0Var = q0Var6;
                                q0Var.g(f(tVar5));
                            } else {
                                q0Var = q0Var6;
                            }
                            q0Var6 = q0Var;
                        }
                    }
                }
                for (int i16 = i4; i16 < i5; i16++) {
                    a aVar2 = (a) arrayList.get(i16);
                    if (((Boolean) arrayList2.get(i16)).booleanValue()) {
                        aVar2.c(-1);
                        aVar2.h();
                    } else {
                        aVar2.c(1);
                        aVar2.g();
                    }
                }
                boolean booleanValue = ((Boolean) arrayList2.get(i5 - 1)).booleanValue();
                for (int i17 = i4; i17 < i5; i17++) {
                    a aVar3 = (a) arrayList.get(i17);
                    if (booleanValue) {
                        for (int size3 = aVar3.f1631a.size() - 1; size3 >= 0; size3--) {
                            t tVar6 = ((s0) aVar3.f1631a.get(size3)).f1794b;
                            if (tVar6 != null) {
                                f(tVar6).k();
                            }
                        }
                    } else {
                        Iterator it2 = aVar3.f1631a.iterator();
                        while (it2.hasNext()) {
                            t tVar7 = ((s0) it2.next()).f1794b;
                            if (tVar7 != null) {
                                f(tVar7).k();
                            }
                        }
                    }
                }
                K(this.f1737o, true);
                HashSet hashSet = new HashSet();
                for (int i18 = i4; i18 < i5; i18++) {
                    Iterator it3 = ((a) arrayList.get(i18)).f1631a.iterator();
                    while (it3.hasNext()) {
                        t tVar8 = ((s0) it3.next()).f1794b;
                        if (tVar8 != null && (viewGroup = tVar8.D) != null) {
                            hashSet.add(g1.f(viewGroup, E()));
                        }
                    }
                }
                Iterator it4 = hashSet.iterator();
                while (it4.hasNext()) {
                    g1 g1Var = (g1) it4.next();
                    g1Var.f1710d = booleanValue;
                    g1Var.g();
                    g1Var.c();
                }
                for (int i19 = i4; i19 < i5; i19++) {
                    a aVar4 = (a) arrayList.get(i19);
                    if (((Boolean) arrayList2.get(i19)).booleanValue() && aVar4.f1648r >= 0) {
                        aVar4.f1648r = -1;
                    }
                    aVar4.getClass();
                }
                return;
            }
        }
    }
}