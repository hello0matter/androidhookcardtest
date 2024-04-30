package androidx.lifecycle;

import androidx.annotation.VisibleForTesting;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Landroidx/lifecycle/DefaultLifecycleObserverAdapter;", "Landroidx/lifecycle/o;", "lifecycle-common"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes.dex */
public final class DefaultLifecycleObserverAdapter implements o {

    /* renamed from: a  reason: collision with root package name */
    public final d f1862a;

    /* renamed from: b  reason: collision with root package name */
    public final o f1863b;

    public DefaultLifecycleObserverAdapter(d dVar, o oVar) {
        com.google.common.collect.c.F(dVar, "defaultLifecycleObserver");
        this.f1862a = dVar;
        this.f1863b = oVar;
    }

    @Override // androidx.lifecycle.o
    public final void b(q qVar, Lifecycle$Event lifecycle$Event) {
        int i4 = e.f1895a[lifecycle$Event.ordinal()];
        d dVar = this.f1862a;
        switch (i4) {
            case 1:
            case 2:
            case VisibleForTesting.PROTECTED /* 4 */:
            case VisibleForTesting.NONE /* 5 */:
                dVar.getClass();
                break;
            case VisibleForTesting.PACKAGE_PRIVATE /* 3 */:
                dVar.a();
                break;
            case 6:
                dVar.getClass();
                break;
            case 7:
                throw new IllegalArgumentException("ON_ANY must not been send by anybody");
        }
        o oVar = this.f1863b;
        if (oVar != null) {
            oVar.b(qVar, lifecycle$Event);
        }
    }
}