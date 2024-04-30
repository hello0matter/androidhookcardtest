package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class f1 {

    /* renamed from: a  reason: collision with root package name */
    public SpecialEffectsController$Operation$State f1695a;

    /* renamed from: b  reason: collision with root package name */
    public SpecialEffectsController$Operation$LifecycleImpact f1696b;

    /* renamed from: c  reason: collision with root package name */
    public final t f1697c;

    /* renamed from: d  reason: collision with root package name */
    public final ArrayList f1698d;

    /* renamed from: e  reason: collision with root package name */
    public final HashSet f1699e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f1700f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f1701g;

    /* renamed from: h  reason: collision with root package name */
    public final p0 f1702h;

    public f1(SpecialEffectsController$Operation$State specialEffectsController$Operation$State, SpecialEffectsController$Operation$LifecycleImpact specialEffectsController$Operation$LifecycleImpact, p0 p0Var, e0.c cVar) {
        t tVar = p0Var.f1771c;
        this.f1698d = new ArrayList();
        this.f1699e = new HashSet();
        this.f1700f = false;
        this.f1701g = false;
        this.f1695a = specialEffectsController$Operation$State;
        this.f1696b = specialEffectsController$Operation$LifecycleImpact;
        this.f1697c = tVar;
        cVar.b(new n(3, this));
        this.f1702h = p0Var;
    }

    public final void a() {
        if (!this.f1700f) {
            this.f1700f = true;
            HashSet hashSet = this.f1699e;
            if (hashSet.isEmpty()) {
                b();
                return;
            }
            Iterator it = new ArrayList(hashSet).iterator();
            while (it.hasNext()) {
                ((e0.c) it.next()).a();
            }
        }
    }

    public final void b() {
        if (!this.f1701g) {
            if (Log.isLoggable("FragmentManager", 2)) {
                Log.v("FragmentManager", "SpecialEffectsController: " + this + " has called complete.");
            }
            this.f1701g = true;
            Iterator it = this.f1698d.iterator();
            while (it.hasNext()) {
                ((Runnable) it.next()).run();
            }
        }
        this.f1702h.k();
    }

    public final void c(SpecialEffectsController$Operation$State specialEffectsController$Operation$State, SpecialEffectsController$Operation$LifecycleImpact specialEffectsController$Operation$LifecycleImpact) {
        SpecialEffectsController$Operation$LifecycleImpact specialEffectsController$Operation$LifecycleImpact2;
        int ordinal = specialEffectsController$Operation$LifecycleImpact.ordinal();
        SpecialEffectsController$Operation$State specialEffectsController$Operation$State2 = SpecialEffectsController$Operation$State.f1626a;
        t tVar = this.f1697c;
        if (ordinal != 0) {
            if (ordinal != 1) {
                if (ordinal == 2) {
                    if (Log.isLoggable("FragmentManager", 2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: For fragment " + tVar + " mFinalState = " + this.f1695a + " -> REMOVED. mLifecycleImpact  = " + this.f1696b + " to REMOVING.");
                    }
                    this.f1695a = specialEffectsController$Operation$State2;
                    specialEffectsController$Operation$LifecycleImpact2 = SpecialEffectsController$Operation$LifecycleImpact.f1624c;
                } else {
                    return;
                }
            } else if (this.f1695a == specialEffectsController$Operation$State2) {
                if (Log.isLoggable("FragmentManager", 2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: For fragment " + tVar + " mFinalState = REMOVED -> VISIBLE. mLifecycleImpact = " + this.f1696b + " to ADDING.");
                }
                this.f1695a = SpecialEffectsController$Operation$State.f1627b;
                specialEffectsController$Operation$LifecycleImpact2 = SpecialEffectsController$Operation$LifecycleImpact.f1623b;
            } else {
                return;
            }
            this.f1696b = specialEffectsController$Operation$LifecycleImpact2;
        } else if (this.f1695a != specialEffectsController$Operation$State2) {
            if (Log.isLoggable("FragmentManager", 2)) {
                Log.v("FragmentManager", "SpecialEffectsController: For fragment " + tVar + " mFinalState = " + this.f1695a + " -> " + specialEffectsController$Operation$State + ". ");
            }
            this.f1695a = specialEffectsController$Operation$State;
        }
    }

    public final void d() {
        float f4;
        if (this.f1696b == SpecialEffectsController$Operation$LifecycleImpact.f1623b) {
            p0 p0Var = this.f1702h;
            t tVar = p0Var.f1771c;
            View findFocus = tVar.E.findFocus();
            if (findFocus != null) {
                tVar.g().f1792o = findFocus;
                if (Log.isLoggable("FragmentManager", 2)) {
                    Log.v("FragmentManager", "requestFocus: Saved focused view " + findFocus + " for Fragment " + tVar);
                }
            }
            View D = this.f1697c.D();
            if (D.getParent() == null) {
                p0Var.b();
                D.setAlpha(0.0f);
            }
            if (D.getAlpha() == 0.0f && D.getVisibility() == 0) {
                D.setVisibility(4);
            }
            r rVar = tVar.H;
            if (rVar == null) {
                f4 = 1.0f;
            } else {
                f4 = rVar.f1791n;
            }
            D.setAlpha(f4);
        }
    }

    /* renamed from: e */
    public final String toString() {
        return "Operation {" + Integer.toHexString(System.identityHashCode(this)) + "} {mFinalState = " + this.f1695a + "} {mLifecycleImpact = " + this.f1696b + "} {mFragment = " + this.f1697c + "}";
    }
}