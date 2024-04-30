package androidx.fragment.app;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AndroidRuntimeException;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.VisibleForTesting;
import androidx.lifecycle.Lifecycle$Event;
import androidx.lifecycle.Lifecycle$State;
import com.example.msphone.R;
import com.google.android.material.bottomnavigation.LabelVisibilityMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class p0 {

    /* renamed from: a  reason: collision with root package name */
    public final d f1769a;

    /* renamed from: b  reason: collision with root package name */
    public final q0 f1770b;

    /* renamed from: c  reason: collision with root package name */
    public final t f1771c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f1772d = false;

    /* renamed from: e  reason: collision with root package name */
    public int f1773e = -1;

    public p0(d dVar, q0 q0Var, t tVar) {
        this.f1769a = dVar;
        this.f1770b = q0Var;
        this.f1771c = tVar;
    }

    public final void a() {
        boolean isLoggable = Log.isLoggable("FragmentManager", 3);
        t tVar = this.f1771c;
        if (isLoggable) {
            Log.d("FragmentManager", "moveto ACTIVITY_CREATED: " + tVar);
        }
        Bundle bundle = tVar.f1802b;
        tVar.f1820t.L();
        tVar.f1801a = 3;
        tVar.C = true;
        if (Log.isLoggable("FragmentManager", 3)) {
            Log.d("FragmentManager", "moveto RESTORE_VIEW_STATE: " + tVar);
        }
        View view = tVar.E;
        if (view != null) {
            Bundle bundle2 = tVar.f1802b;
            SparseArray<Parcelable> sparseArray = tVar.f1803c;
            if (sparseArray != null) {
                view.restoreHierarchyState(sparseArray);
                tVar.f1803c = null;
            }
            if (tVar.E != null) {
                c1 c1Var = tVar.N;
                c1Var.f1671c.b(tVar.f1804d);
                tVar.f1804d = null;
            }
            tVar.C = false;
            tVar.z(bundle2);
            if (tVar.C) {
                if (tVar.E != null) {
                    tVar.N.c(Lifecycle$Event.ON_CREATE);
                }
            } else {
                throw new AndroidRuntimeException("Fragment " + tVar + " did not call through to super.onViewStateRestored()");
            }
        }
        tVar.f1802b = null;
        l0 l0Var = tVar.f1820t;
        l0Var.A = false;
        l0Var.B = false;
        l0Var.H.f1759h = false;
        l0Var.s(4);
        this.f1769a.b(false);
    }

    public final void b() {
        View view;
        View view2;
        q0 q0Var = this.f1770b;
        q0Var.getClass();
        t tVar = this.f1771c;
        ViewGroup viewGroup = tVar.D;
        int i4 = -1;
        if (viewGroup != null) {
            ArrayList arrayList = q0Var.f1775a;
            int indexOf = arrayList.indexOf(tVar);
            int i5 = indexOf - 1;
            while (true) {
                if (i5 < 0) {
                    while (true) {
                        indexOf++;
                        if (indexOf >= arrayList.size()) {
                            break;
                        }
                        t tVar2 = (t) arrayList.get(indexOf);
                        if (tVar2.D == viewGroup && (view = tVar2.E) != null) {
                            i4 = viewGroup.indexOfChild(view);
                            break;
                        }
                    }
                } else {
                    t tVar3 = (t) arrayList.get(i5);
                    if (tVar3.D == viewGroup && (view2 = tVar3.E) != null) {
                        i4 = viewGroup.indexOfChild(view2) + 1;
                        break;
                    }
                    i5--;
                }
            }
        }
        tVar.D.addView(tVar.E, i4);
    }

    public final void c() {
        p0 p0Var;
        boolean isLoggable = Log.isLoggable("FragmentManager", 3);
        t tVar = this.f1771c;
        if (isLoggable) {
            Log.d("FragmentManager", "moveto ATTACHED: " + tVar);
        }
        t tVar2 = tVar.f1807g;
        q0 q0Var = this.f1770b;
        if (tVar2 != null) {
            p0Var = (p0) q0Var.f1776b.get(tVar2.f1805e);
            if (p0Var != null) {
                tVar.f1808h = tVar.f1807g.f1805e;
                tVar.f1807g = null;
            } else {
                throw new IllegalStateException("Fragment " + tVar + " declared target fragment " + tVar.f1807g + " that does not belong to this FragmentManager!");
            }
        } else {
            String str = tVar.f1808h;
            if (str != null) {
                p0Var = (p0) q0Var.f1776b.get(str);
                if (p0Var == null) {
                    StringBuilder sb = new StringBuilder("Fragment ");
                    sb.append(tVar);
                    sb.append(" declared target fragment ");
                    throw new IllegalStateException(androidx.activity.j.e(sb, tVar.f1808h, " that does not belong to this FragmentManager!"));
                }
            } else {
                p0Var = null;
            }
        }
        if (p0Var != null) {
            p0Var.k();
        }
        k0 k0Var = tVar.f1818r;
        tVar.f1819s = k0Var.f1738p;
        tVar.f1821u = k0Var.f1740r;
        d dVar = this.f1769a;
        dVar.h(false);
        ArrayList arrayList = tVar.Q;
        Iterator it = arrayList.iterator();
        if (!it.hasNext()) {
            arrayList.clear();
            tVar.f1820t.b(tVar.f1819s, tVar.c(), tVar);
            tVar.f1801a = 0;
            tVar.C = false;
            tVar.q(tVar.f1819s.f1838r);
            if (tVar.C) {
                Iterator it2 = tVar.f1818r.f1736n.iterator();
                while (it2.hasNext()) {
                    ((o0) it2.next()).c();
                }
                l0 l0Var = tVar.f1820t;
                l0Var.A = false;
                l0Var.B = false;
                l0Var.H.f1759h = false;
                l0Var.s(0);
                dVar.c(false);
                return;
            }
            throw new AndroidRuntimeException("Fragment " + tVar + " did not call through to super.onAttach()");
        }
        androidx.activity.j.f(it.next());
        throw null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v5, types: [androidx.fragment.app.SpecialEffectsController$Operation$LifecycleImpact] */
    /* JADX WARN: Type inference failed for: r2v17, types: [androidx.fragment.app.SpecialEffectsController$Operation$LifecycleImpact] */
    public final int d() {
        f1 f1Var;
        t tVar = this.f1771c;
        if (tVar.f1818r == null) {
            return tVar.f1801a;
        }
        int i4 = this.f1773e;
        int ordinal = tVar.L.ordinal();
        if (ordinal != 1) {
            if (ordinal != 2) {
                if (ordinal != 3) {
                    if (ordinal != 4) {
                        i4 = Math.min(i4, -1);
                    }
                } else {
                    i4 = Math.min(i4, 5);
                }
            } else {
                i4 = Math.min(i4, 1);
            }
        } else {
            i4 = Math.min(i4, 0);
        }
        if (tVar.f1813m) {
            if (tVar.f1814n) {
                i4 = Math.max(this.f1773e, 2);
                View view = tVar.E;
                if (view != null && view.getParent() == null) {
                    i4 = Math.min(i4, 2);
                }
            } else {
                i4 = this.f1773e < 4 ? Math.min(i4, tVar.f1801a) : Math.min(i4, 1);
            }
        }
        if (!tVar.f1811k) {
            i4 = Math.min(i4, 1);
        }
        ViewGroup viewGroup = tVar.D;
        f1 f1Var2 = null;
        if (viewGroup != null) {
            g1 f4 = g1.f(viewGroup, tVar.k().E());
            f4.getClass();
            f1 d4 = f4.d(tVar);
            if (d4 != null) {
                f1Var = d4.f1696b;
            } else {
                f1Var = null;
            }
            Iterator it = f4.f1709c.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                f1 f1Var3 = (f1) it.next();
                if (f1Var3.f1697c.equals(tVar) && !f1Var3.f1700f) {
                    f1Var2 = f1Var3;
                    break;
                }
            }
            if (f1Var2 != null && (f1Var == null || f1Var == SpecialEffectsController$Operation$LifecycleImpact.f1622a)) {
                f1Var2 = f1Var2.f1696b;
            } else {
                f1Var2 = f1Var;
            }
        }
        if (f1Var2 == SpecialEffectsController$Operation$LifecycleImpact.f1623b) {
            i4 = Math.min(i4, 6);
        } else if (f1Var2 == SpecialEffectsController$Operation$LifecycleImpact.f1624c) {
            i4 = Math.max(i4, 3);
        } else if (tVar.f1812l) {
            if (tVar.f1817q > 0) {
                i4 = Math.min(i4, 1);
            } else {
                i4 = Math.min(i4, -1);
            }
        }
        if (tVar.F && tVar.f1801a < 5) {
            i4 = Math.min(i4, 4);
        }
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "computeExpectedState() of " + i4 + " for " + tVar);
        }
        return i4;
    }

    public final void e() {
        boolean isLoggable = Log.isLoggable("FragmentManager", 3);
        final t tVar = this.f1771c;
        if (isLoggable) {
            Log.d("FragmentManager", "moveto CREATED: " + tVar);
        }
        if (!tVar.K) {
            d dVar = this.f1769a;
            dVar.i(false);
            Bundle bundle = tVar.f1802b;
            tVar.f1820t.L();
            tVar.f1801a = 1;
            tVar.C = false;
            tVar.M.a(new androidx.lifecycle.o() { // from class: androidx.fragment.app.Fragment$5
                @Override // androidx.lifecycle.o
                public final void b(androidx.lifecycle.q qVar, Lifecycle$Event lifecycle$Event) {
                    View view;
                    if (lifecycle$Event != Lifecycle$Event.ON_STOP || (view = t.this.E) == null) {
                        return;
                    }
                    view.cancelPendingInputEvents();
                }
            });
            tVar.P.b(bundle);
            tVar.r(bundle);
            tVar.K = true;
            if (tVar.C) {
                tVar.M.e(Lifecycle$Event.ON_CREATE);
                dVar.d(false);
                return;
            }
            throw new AndroidRuntimeException("Fragment " + tVar + " did not call through to super.onCreate()");
        }
        tVar.E(tVar.f1802b);
        tVar.f1801a = 1;
    }

    public final void f() {
        String str;
        t tVar = this.f1771c;
        if (tVar.f1813m) {
            return;
        }
        if (Log.isLoggable("FragmentManager", 3)) {
            Log.d("FragmentManager", "moveto CREATE_VIEW: " + tVar);
        }
        LayoutInflater v2 = tVar.v(tVar.f1802b);
        ViewGroup viewGroup = tVar.D;
        if (viewGroup == null) {
            int i4 = tVar.f1823w;
            if (i4 != 0) {
                if (i4 != -1) {
                    viewGroup = (ViewGroup) tVar.f1818r.f1739q.l1(i4);
                    if (viewGroup == null && !tVar.f1815o) {
                        try {
                            str = tVar.C().getResources().getResourceName(tVar.f1823w);
                        } catch (Resources.NotFoundException unused) {
                            str = "unknown";
                        }
                        throw new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(tVar.f1823w) + " (" + str + ") for fragment " + tVar);
                    }
                } else {
                    throw new IllegalArgumentException("Cannot create fragment " + tVar + " for a container view with no id");
                }
            } else {
                viewGroup = null;
            }
        }
        tVar.D = viewGroup;
        tVar.A(v2, viewGroup, tVar.f1802b);
        View view = tVar.E;
        if (view != null) {
            view.setSaveFromParentEnabled(false);
            tVar.E.setTag(R.id.fragment_container_view_tag, tVar);
            if (viewGroup != null) {
                b();
            }
            if (tVar.f1825y) {
                tVar.E.setVisibility(8);
            }
            View view2 = tVar.E;
            WeakHashMap weakHashMap = i0.y0.f4999a;
            if (i0.j0.b(view2)) {
                i0.k0.c(tVar.E);
            } else {
                View view3 = tVar.E;
                view3.addOnAttachStateChangeListener(new b0(this, view3));
            }
            tVar.f1820t.s(2);
            this.f1769a.n(false);
            int visibility = tVar.E.getVisibility();
            tVar.g().f1791n = tVar.E.getAlpha();
            if (tVar.D != null && visibility == 0) {
                View findFocus = tVar.E.findFocus();
                if (findFocus != null) {
                    tVar.g().f1792o = findFocus;
                    if (Log.isLoggable("FragmentManager", 2)) {
                        Log.v("FragmentManager", "requestFocus: Saved focused view " + findFocus + " for Fragment " + tVar);
                    }
                }
                tVar.E.setAlpha(0.0f);
            }
        }
        tVar.f1801a = 2;
    }

    public final void g() {
        boolean z4;
        boolean z5;
        t b5;
        boolean isLoggable = Log.isLoggable("FragmentManager", 3);
        t tVar = this.f1771c;
        if (isLoggable) {
            Log.d("FragmentManager", "movefrom CREATED: " + tVar);
        }
        if (tVar.f1812l && tVar.f1817q <= 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        q0 q0Var = this.f1770b;
        if (!z4) {
            n0 n0Var = q0Var.f1777c;
            if (n0Var.f1754c.containsKey(tVar.f1805e) && n0Var.f1757f && !n0Var.f1758g) {
                String str = tVar.f1808h;
                if (str != null && (b5 = q0Var.b(str)) != null && b5.A) {
                    tVar.f1807g = b5;
                }
                tVar.f1801a = 0;
                return;
            }
        }
        w wVar = tVar.f1819s;
        if (wVar instanceof androidx.lifecycle.l0) {
            z5 = q0Var.f1777c.f1758g;
        } else {
            Context context = wVar.f1838r;
            if (context instanceof Activity) {
                z5 = !((Activity) context).isChangingConfigurations();
            } else {
                z5 = true;
            }
        }
        if (z4 || z5) {
            n0 n0Var2 = q0Var.f1777c;
            n0Var2.getClass();
            if (Log.isLoggable("FragmentManager", 3)) {
                Log.d("FragmentManager", "Clearing non-config state for " + tVar);
            }
            HashMap hashMap = n0Var2.f1755d;
            n0 n0Var3 = (n0) hashMap.get(tVar.f1805e);
            if (n0Var3 != null) {
                n0Var3.a();
                hashMap.remove(tVar.f1805e);
            }
            HashMap hashMap2 = n0Var2.f1756e;
            androidx.lifecycle.k0 k0Var = (androidx.lifecycle.k0) hashMap2.get(tVar.f1805e);
            if (k0Var != null) {
                k0Var.a();
                hashMap2.remove(tVar.f1805e);
            }
        }
        tVar.f1820t.k();
        tVar.M.e(Lifecycle$Event.ON_DESTROY);
        tVar.f1801a = 0;
        tVar.K = false;
        tVar.C = true;
        this.f1769a.e(false);
        Iterator it = q0Var.d().iterator();
        while (it.hasNext()) {
            p0 p0Var = (p0) it.next();
            if (p0Var != null) {
                String str2 = tVar.f1805e;
                t tVar2 = p0Var.f1771c;
                if (str2.equals(tVar2.f1808h)) {
                    tVar2.f1807g = tVar;
                    tVar2.f1808h = null;
                }
            }
        }
        String str3 = tVar.f1808h;
        if (str3 != null) {
            tVar.f1807g = q0Var.b(str3);
        }
        q0Var.h(this);
    }

    public final void h() {
        View view;
        boolean isLoggable = Log.isLoggable("FragmentManager", 3);
        t tVar = this.f1771c;
        if (isLoggable) {
            Log.d("FragmentManager", "movefrom CREATE_VIEW: " + tVar);
        }
        ViewGroup viewGroup = tVar.D;
        if (viewGroup != null && (view = tVar.E) != null) {
            viewGroup.removeView(view);
        }
        tVar.B();
        this.f1769a.o(false);
        tVar.D = null;
        tVar.E = null;
        tVar.N = null;
        tVar.O.e(null);
        tVar.f1814n = false;
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [androidx.fragment.app.k0, androidx.fragment.app.l0] */
    /* JADX WARN: Type inference failed for: r5v9, types: [androidx.fragment.app.k0, androidx.fragment.app.l0] */
    public final void i() {
        boolean isLoggable = Log.isLoggable("FragmentManager", 3);
        t tVar = this.f1771c;
        if (isLoggable) {
            Log.d("FragmentManager", "movefrom ATTACHED: " + tVar);
        }
        tVar.f1801a = -1;
        tVar.C = false;
        tVar.u();
        if (tVar.C) {
            l0 l0Var = tVar.f1820t;
            if (!l0Var.C) {
                l0Var.k();
                tVar.f1820t = new k0();
            }
            this.f1769a.f(false);
            tVar.f1801a = -1;
            tVar.f1819s = null;
            tVar.f1821u = null;
            tVar.f1818r = null;
            if (!tVar.f1812l || tVar.f1817q > 0) {
                n0 n0Var = this.f1770b.f1777c;
                if (n0Var.f1754c.containsKey(tVar.f1805e) && n0Var.f1757f && !n0Var.f1758g) {
                    return;
                }
            }
            if (Log.isLoggable("FragmentManager", 3)) {
                Log.d("FragmentManager", "initState called for fragment: " + tVar);
            }
            tVar.M = new androidx.lifecycle.s(tVar);
            tVar.P = l2.f.c(tVar);
            tVar.f1805e = UUID.randomUUID().toString();
            tVar.f1811k = false;
            tVar.f1812l = false;
            tVar.f1813m = false;
            tVar.f1814n = false;
            tVar.f1815o = false;
            tVar.f1817q = 0;
            tVar.f1818r = null;
            tVar.f1820t = new k0();
            tVar.f1819s = null;
            tVar.f1822v = 0;
            tVar.f1823w = 0;
            tVar.f1824x = null;
            tVar.f1825y = false;
            tVar.f1826z = false;
            return;
        }
        throw new AndroidRuntimeException("Fragment " + tVar + " did not call through to super.onDetach()");
    }

    public final void j() {
        t tVar = this.f1771c;
        if (tVar.f1813m && tVar.f1814n && !tVar.f1816p) {
            if (Log.isLoggable("FragmentManager", 3)) {
                Log.d("FragmentManager", "moveto CREATE_VIEW: " + tVar);
            }
            tVar.A(tVar.v(tVar.f1802b), null, tVar.f1802b);
            View view = tVar.E;
            if (view != null) {
                view.setSaveFromParentEnabled(false);
                tVar.E.setTag(R.id.fragment_container_view_tag, tVar);
                if (tVar.f1825y) {
                    tVar.E.setVisibility(8);
                }
                tVar.f1820t.s(2);
                this.f1769a.n(false);
                tVar.f1801a = 2;
            }
        }
    }

    public final void k() {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        ViewGroup viewGroup3;
        boolean z4 = this.f1772d;
        t tVar = this.f1771c;
        if (z4) {
            if (Log.isLoggable("FragmentManager", 2)) {
                Log.v("FragmentManager", "Ignoring re-entrant call to moveToExpectedState() for " + tVar);
                return;
            }
            return;
        }
        try {
            this.f1772d = true;
            while (true) {
                int d4 = d();
                int i4 = tVar.f1801a;
                if (d4 != i4) {
                    if (d4 > i4) {
                        switch (i4 + 1) {
                            case 0:
                                c();
                                continue;
                            case 1:
                                e();
                                continue;
                            case 2:
                                j();
                                f();
                                continue;
                            case VisibleForTesting.PACKAGE_PRIVATE /* 3 */:
                                a();
                                continue;
                            case VisibleForTesting.PROTECTED /* 4 */:
                                if (tVar.E != null && (viewGroup2 = tVar.D) != null) {
                                    g1 f4 = g1.f(viewGroup2, tVar.k().E());
                                    SpecialEffectsController$Operation$State b5 = SpecialEffectsController$Operation$State.b(tVar.E.getVisibility());
                                    f4.getClass();
                                    if (Log.isLoggable("FragmentManager", 2)) {
                                        Log.v("FragmentManager", "SpecialEffectsController: Enqueuing add operation for fragment " + tVar);
                                    }
                                    f4.a(b5, SpecialEffectsController$Operation$LifecycleImpact.f1623b, this);
                                }
                                tVar.f1801a = 4;
                                continue;
                            case VisibleForTesting.NONE /* 5 */:
                                p();
                                continue;
                            case 6:
                                tVar.f1801a = 6;
                                continue;
                            case 7:
                                n();
                                continue;
                            default:
                                continue;
                        }
                    } else {
                        switch (i4 - 1) {
                            case LabelVisibilityMode.LABEL_VISIBILITY_AUTO /* -1 */:
                                i();
                                continue;
                            case 0:
                                g();
                                continue;
                            case 1:
                                h();
                                tVar.f1801a = 1;
                                continue;
                            case 2:
                                tVar.f1814n = false;
                                tVar.f1801a = 2;
                                continue;
                            case VisibleForTesting.PACKAGE_PRIVATE /* 3 */:
                                if (Log.isLoggable("FragmentManager", 3)) {
                                    Log.d("FragmentManager", "movefrom ACTIVITY_CREATED: " + tVar);
                                }
                                if (tVar.E != null && tVar.f1803c == null) {
                                    o();
                                }
                                if (tVar.E != null && (viewGroup3 = tVar.D) != null) {
                                    g1 f5 = g1.f(viewGroup3, tVar.k().E());
                                    f5.getClass();
                                    if (Log.isLoggable("FragmentManager", 2)) {
                                        Log.v("FragmentManager", "SpecialEffectsController: Enqueuing remove operation for fragment " + tVar);
                                    }
                                    f5.a(SpecialEffectsController$Operation$State.f1626a, SpecialEffectsController$Operation$LifecycleImpact.f1624c, this);
                                }
                                tVar.f1801a = 3;
                                continue;
                            case VisibleForTesting.PROTECTED /* 4 */:
                                q();
                                continue;
                            case VisibleForTesting.NONE /* 5 */:
                                tVar.f1801a = 5;
                                continue;
                            case 6:
                                l();
                                continue;
                            default:
                                continue;
                        }
                    }
                } else {
                    if (tVar.I) {
                        if (tVar.E != null && (viewGroup = tVar.D) != null) {
                            g1 f6 = g1.f(viewGroup, tVar.k().E());
                            boolean z5 = tVar.f1825y;
                            SpecialEffectsController$Operation$LifecycleImpact specialEffectsController$Operation$LifecycleImpact = SpecialEffectsController$Operation$LifecycleImpact.f1622a;
                            if (z5) {
                                f6.getClass();
                                if (Log.isLoggable("FragmentManager", 2)) {
                                    Log.v("FragmentManager", "SpecialEffectsController: Enqueuing hide operation for fragment " + tVar);
                                }
                                f6.a(SpecialEffectsController$Operation$State.f1628c, specialEffectsController$Operation$LifecycleImpact, this);
                            } else {
                                f6.getClass();
                                if (Log.isLoggable("FragmentManager", 2)) {
                                    Log.v("FragmentManager", "SpecialEffectsController: Enqueuing show operation for fragment " + tVar);
                                }
                                f6.a(SpecialEffectsController$Operation$State.f1627b, specialEffectsController$Operation$LifecycleImpact, this);
                            }
                        }
                        k0 k0Var = tVar.f1818r;
                        if (k0Var != null && tVar.f1811k && k0.G(tVar)) {
                            k0Var.f1748z = true;
                        }
                        tVar.I = false;
                    }
                    this.f1772d = false;
                    return;
                }
            }
        } catch (Throwable th) {
            this.f1772d = false;
            throw th;
        }
    }

    public final void l() {
        boolean isLoggable = Log.isLoggable("FragmentManager", 3);
        t tVar = this.f1771c;
        if (isLoggable) {
            Log.d("FragmentManager", "movefrom RESUMED: " + tVar);
        }
        tVar.f1820t.s(5);
        if (tVar.E != null) {
            tVar.N.c(Lifecycle$Event.ON_PAUSE);
        }
        tVar.M.e(Lifecycle$Event.ON_PAUSE);
        tVar.f1801a = 6;
        tVar.C = true;
        this.f1769a.g(false);
    }

    public final void m(ClassLoader classLoader) {
        t tVar = this.f1771c;
        Bundle bundle = tVar.f1802b;
        if (bundle == null) {
            return;
        }
        bundle.setClassLoader(classLoader);
        tVar.f1803c = tVar.f1802b.getSparseParcelableArray("android:view_state");
        tVar.f1804d = tVar.f1802b.getBundle("android:view_registry_state");
        String string = tVar.f1802b.getString("android:target_state");
        tVar.f1808h = string;
        if (string != null) {
            tVar.f1809i = tVar.f1802b.getInt("android:target_req_state", 0);
        }
        boolean z4 = tVar.f1802b.getBoolean("android:user_visible_hint", true);
        tVar.G = z4;
        if (z4) {
            return;
        }
        tVar.F = true;
    }

    public final void n() {
        View view;
        String str;
        boolean isLoggable = Log.isLoggable("FragmentManager", 3);
        t tVar = this.f1771c;
        if (isLoggable) {
            Log.d("FragmentManager", "moveto RESUMED: " + tVar);
        }
        r rVar = tVar.H;
        if (rVar == null) {
            view = null;
        } else {
            view = rVar.f1792o;
        }
        if (view != null) {
            if (view != tVar.E) {
                for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
                    if (parent != tVar.E) {
                    }
                }
            }
            boolean requestFocus = view.requestFocus();
            if (Log.isLoggable("FragmentManager", 2)) {
                StringBuilder sb = new StringBuilder("requestFocus: Restoring focused view ");
                sb.append(view);
                sb.append(" ");
                if (requestFocus) {
                    str = "succeeded";
                } else {
                    str = "failed";
                }
                sb.append(str);
                sb.append(" on Fragment ");
                sb.append(tVar);
                sb.append(" resulting in focused view ");
                sb.append(tVar.E.findFocus());
                Log.v("FragmentManager", sb.toString());
            }
        }
        tVar.g().f1792o = null;
        tVar.f1820t.L();
        tVar.f1820t.x(true);
        tVar.f1801a = 7;
        tVar.C = true;
        androidx.lifecycle.s sVar = tVar.M;
        Lifecycle$Event lifecycle$Event = Lifecycle$Event.ON_RESUME;
        sVar.e(lifecycle$Event);
        if (tVar.E != null) {
            tVar.N.f1670b.e(lifecycle$Event);
        }
        l0 l0Var = tVar.f1820t;
        l0Var.A = false;
        l0Var.B = false;
        l0Var.H.f1759h = false;
        l0Var.s(7);
        this.f1769a.j(false);
        tVar.f1802b = null;
        tVar.f1803c = null;
        tVar.f1804d = null;
    }

    public final void o() {
        t tVar = this.f1771c;
        if (tVar.E == null) {
            return;
        }
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        tVar.E.saveHierarchyState(sparseArray);
        if (sparseArray.size() > 0) {
            tVar.f1803c = sparseArray;
        }
        Bundle bundle = new Bundle();
        tVar.N.f1671c.c(bundle);
        if (!bundle.isEmpty()) {
            tVar.f1804d = bundle;
        }
    }

    public final void p() {
        boolean isLoggable = Log.isLoggable("FragmentManager", 3);
        t tVar = this.f1771c;
        if (isLoggable) {
            Log.d("FragmentManager", "moveto STARTED: " + tVar);
        }
        tVar.f1820t.L();
        tVar.f1820t.x(true);
        tVar.f1801a = 5;
        tVar.C = false;
        tVar.x();
        if (tVar.C) {
            androidx.lifecycle.s sVar = tVar.M;
            Lifecycle$Event lifecycle$Event = Lifecycle$Event.ON_START;
            sVar.e(lifecycle$Event);
            if (tVar.E != null) {
                tVar.N.f1670b.e(lifecycle$Event);
            }
            l0 l0Var = tVar.f1820t;
            l0Var.A = false;
            l0Var.B = false;
            l0Var.H.f1759h = false;
            l0Var.s(5);
            this.f1769a.l(false);
            return;
        }
        throw new AndroidRuntimeException("Fragment " + tVar + " did not call through to super.onStart()");
    }

    public final void q() {
        boolean isLoggable = Log.isLoggable("FragmentManager", 3);
        t tVar = this.f1771c;
        if (isLoggable) {
            Log.d("FragmentManager", "movefrom STARTED: " + tVar);
        }
        l0 l0Var = tVar.f1820t;
        l0Var.B = true;
        l0Var.H.f1759h = true;
        l0Var.s(4);
        if (tVar.E != null) {
            tVar.N.c(Lifecycle$Event.ON_STOP);
        }
        tVar.M.e(Lifecycle$Event.ON_STOP);
        tVar.f1801a = 4;
        tVar.C = false;
        tVar.y();
        if (tVar.C) {
            this.f1769a.m(false);
            return;
        }
        throw new AndroidRuntimeException("Fragment " + tVar + " did not call through to super.onStop()");
    }

    public p0(d dVar, q0 q0Var, t tVar, FragmentState fragmentState) {
        this.f1769a = dVar;
        this.f1770b = q0Var;
        this.f1771c = tVar;
        tVar.f1803c = null;
        tVar.f1804d = null;
        tVar.f1817q = 0;
        tVar.f1814n = false;
        tVar.f1811k = false;
        t tVar2 = tVar.f1807g;
        tVar.f1808h = tVar2 != null ? tVar2.f1805e : null;
        tVar.f1807g = null;
        Bundle bundle = fragmentState.f1615m;
        tVar.f1802b = bundle == null ? new Bundle() : bundle;
    }

    public p0(d dVar, q0 q0Var, ClassLoader classLoader, f0 f0Var, FragmentState fragmentState) {
        this.f1769a = dVar;
        this.f1770b = q0Var;
        t a5 = f0Var.a(fragmentState.f1603a);
        this.f1771c = a5;
        Bundle bundle = fragmentState.f1612j;
        if (bundle != null) {
            bundle.setClassLoader(classLoader);
        }
        a5.G(bundle);
        a5.f1805e = fragmentState.f1604b;
        a5.f1813m = fragmentState.f1605c;
        a5.f1815o = true;
        a5.f1822v = fragmentState.f1606d;
        a5.f1823w = fragmentState.f1607e;
        a5.f1824x = fragmentState.f1608f;
        a5.A = fragmentState.f1609g;
        a5.f1812l = fragmentState.f1610h;
        a5.f1826z = fragmentState.f1611i;
        a5.f1825y = fragmentState.f1613k;
        a5.L = Lifecycle$State.values()[fragmentState.f1614l];
        Bundle bundle2 = fragmentState.f1615m;
        a5.f1802b = bundle2 == null ? new Bundle() : bundle2;
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "Instantiated fragment " + a5);
        }
    }
}