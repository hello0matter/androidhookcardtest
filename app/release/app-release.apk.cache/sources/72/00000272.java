package androidx.fragment.app;

import android.transition.Transition;

/* loaded from: classes.dex */
public final class j extends i {

    /* renamed from: c  reason: collision with root package name */
    public final Object f1717c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f1718d;

    /* renamed from: e  reason: collision with root package name */
    public final Object f1719e;

    public j(f1 f1Var, e0.c cVar, boolean z4, boolean z5) {
        super(f1Var, cVar);
        Object obj;
        Object obj2;
        SpecialEffectsController$Operation$State specialEffectsController$Operation$State = f1Var.f1695a;
        SpecialEffectsController$Operation$State specialEffectsController$Operation$State2 = SpecialEffectsController$Operation$State.f1627b;
        t tVar = f1Var.f1697c;
        if (specialEffectsController$Operation$State == specialEffectsController$Operation$State2) {
            if (z4) {
                obj2 = tVar.l();
            } else {
                tVar.getClass();
                obj2 = null;
            }
            this.f1717c = obj2;
            tVar.getClass();
        } else {
            if (z4) {
                obj = tVar.m();
            } else {
                tVar.getClass();
                obj = null;
            }
            this.f1717c = obj;
        }
        this.f1718d = true;
        if (z5) {
            if (z4) {
                this.f1719e = tVar.n();
                return;
            }
            tVar.getClass();
        }
        this.f1719e = null;
    }

    public final b1 c(Object obj) {
        if (obj == null) {
            return null;
        }
        z0 z0Var = u0.f1832a;
        if (obj instanceof Transition) {
            return z0Var;
        }
        b1 b1Var = u0.f1833b;
        if (b1Var != null && b1Var.e(obj)) {
            return b1Var;
        }
        throw new IllegalArgumentException("Transition " + obj + " for fragment " + this.f1715a.f1697c + " is not a valid framework Transition or AndroidX Transition");
    }
}