package androidx.lifecycle;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Landroidx/lifecycle/SavedStateHandleAttacher;", "Landroidx/lifecycle/o;", "lifecycle-viewmodel-savedstate_release"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes.dex */
public final class SavedStateHandleAttacher implements o {

    /* renamed from: a  reason: collision with root package name */
    public final f0 f1874a;

    public SavedStateHandleAttacher(f0 f0Var) {
        this.f1874a = f0Var;
    }

    @Override // androidx.lifecycle.o
    public final void b(q qVar, Lifecycle$Event lifecycle$Event) {
        if (lifecycle$Event == Lifecycle$Event.ON_CREATE) {
            qVar.f().b(this);
            f0 f0Var = this.f1874a;
            if (!f0Var.f1900b) {
                f0Var.f1901c = f0Var.f1899a.a("androidx.lifecycle.internal.SavedStateHandlesProvider");
                f0Var.f1900b = true;
                g0 g0Var = (g0) f0Var.f1902d.getValue();
                return;
            }
            return;
        }
        throw new IllegalStateException(("Next event must be ON_CREATE, it was " + lifecycle$Event).toString());
    }
}