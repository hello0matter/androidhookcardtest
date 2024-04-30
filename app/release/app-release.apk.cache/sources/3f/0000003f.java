package androidx.activity;

import androidx.fragment.app.e0;
import androidx.lifecycle.Lifecycle$Event;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReference;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"androidx/activity/OnBackPressedDispatcher$LifecycleOnBackPressedCancellable", "Landroidx/lifecycle/o;", "Landroidx/activity/c;", "activity_release"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes.dex */
public final class OnBackPressedDispatcher$LifecycleOnBackPressedCancellable implements androidx.lifecycle.o, c {

    /* renamed from: a  reason: collision with root package name */
    public final androidx.lifecycle.l f86a;

    /* renamed from: b  reason: collision with root package name */
    public final e0 f87b;

    /* renamed from: c  reason: collision with root package name */
    public v f88c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ w f89d;

    public OnBackPressedDispatcher$LifecycleOnBackPressedCancellable(w wVar, androidx.lifecycle.l lVar, e0 e0Var) {
        com.google.common.collect.c.F(e0Var, "onBackPressedCallback");
        this.f89d = wVar;
        this.f86a = lVar;
        this.f87b = e0Var;
        lVar.a(this);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.jvm.internal.FunctionReference, e3.a] */
    @Override // androidx.lifecycle.o
    public final void b(androidx.lifecycle.q qVar, Lifecycle$Event lifecycle$Event) {
        if (lifecycle$Event == Lifecycle$Event.ON_START) {
            w wVar = this.f89d;
            wVar.getClass();
            e0 e0Var = this.f87b;
            com.google.common.collect.c.F(e0Var, "onBackPressedCallback");
            wVar.f159b.a(e0Var);
            v vVar = new v(wVar, e0Var);
            e0Var.f1684b.add(vVar);
            wVar.d();
            e0Var.f1685c = new FunctionReference(wVar);
            this.f88c = vVar;
        } else if (lifecycle$Event == Lifecycle$Event.ON_STOP) {
            v vVar2 = this.f88c;
            if (vVar2 != null) {
                vVar2.cancel();
            }
        } else if (lifecycle$Event == Lifecycle$Event.ON_DESTROY) {
            cancel();
        }
    }

    @Override // androidx.activity.c
    public final void cancel() {
        this.f86a.b(this);
        e0 e0Var = this.f87b;
        e0Var.getClass();
        e0Var.f1684b.remove(this);
        v vVar = this.f88c;
        if (vVar != null) {
            vVar.cancel();
        }
        this.f88c = null;
    }
}