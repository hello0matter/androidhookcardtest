package androidx.fragment.app;

import java.util.HashSet;

/* loaded from: classes.dex */
public abstract class i {

    /* renamed from: a  reason: collision with root package name */
    public final f1 f1715a;

    /* renamed from: b  reason: collision with root package name */
    public final e0.c f1716b;

    public i(f1 f1Var, e0.c cVar) {
        this.f1715a = f1Var;
        this.f1716b = cVar;
    }

    public final void a() {
        f1 f1Var = this.f1715a;
        HashSet hashSet = f1Var.f1699e;
        if (hashSet.remove(this.f1716b) && hashSet.isEmpty()) {
            f1Var.b();
        }
    }

    public final boolean b() {
        SpecialEffectsController$Operation$State specialEffectsController$Operation$State;
        f1 f1Var = this.f1715a;
        SpecialEffectsController$Operation$State c4 = SpecialEffectsController$Operation$State.c(f1Var.f1697c.E);
        SpecialEffectsController$Operation$State specialEffectsController$Operation$State2 = f1Var.f1695a;
        if (c4 != specialEffectsController$Operation$State2 && (c4 == (specialEffectsController$Operation$State = SpecialEffectsController$Operation$State.f1627b) || specialEffectsController$Operation$State2 == specialEffectsController$Operation$State)) {
            return false;
        }
        return true;
    }
}