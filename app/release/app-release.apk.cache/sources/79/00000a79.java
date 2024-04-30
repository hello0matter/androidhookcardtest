package z0;

import android.os.Bundle;
import androidx.lifecycle.Lifecycle$Event;
import androidx.lifecycle.Lifecycle$State;
import androidx.lifecycle.o;
import androidx.lifecycle.q;
import androidx.lifecycle.s;
import androidx.savedstate.Recreator;
import i.g;
import java.util.Map;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public final f f7225a;

    /* renamed from: b  reason: collision with root package name */
    public final d f7226b = new d();

    /* renamed from: c  reason: collision with root package name */
    public boolean f7227c;

    public e(f fVar) {
        this.f7225a = fVar;
    }

    public final void a() {
        f fVar = this.f7225a;
        s f4 = fVar.f();
        if (f4.f1915c == Lifecycle$State.f1865b) {
            f4.a(new Recreator(fVar));
            final d dVar = this.f7226b;
            dVar.getClass();
            if (!dVar.f7220b) {
                f4.a(new o() { // from class: z0.a
                    @Override // androidx.lifecycle.o
                    public final void b(q qVar, Lifecycle$Event lifecycle$Event) {
                        boolean z4;
                        d dVar2 = d.this;
                        com.google.common.collect.c.F(dVar2, "this$0");
                        if (lifecycle$Event == Lifecycle$Event.ON_START) {
                            z4 = true;
                        } else if (lifecycle$Event == Lifecycle$Event.ON_STOP) {
                            z4 = false;
                        } else {
                            return;
                        }
                        dVar2.f7224f = z4;
                    }
                });
                dVar.f7220b = true;
                this.f7227c = true;
                return;
            }
            throw new IllegalStateException("SavedStateRegistry was already attached.".toString());
        }
        throw new IllegalStateException("Restarter must be created only during owner's initialization stage".toString());
    }

    public final void b(Bundle bundle) {
        s f4;
        boolean z4;
        Bundle bundle2;
        if (!this.f7227c) {
            a();
        }
        if (this.f7225a.f().f1915c.compareTo(Lifecycle$State.f1867d) >= 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (!z4) {
            d dVar = this.f7226b;
            if (dVar.f7220b) {
                if (!dVar.f7222d) {
                    if (bundle != null) {
                        bundle2 = bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key");
                    } else {
                        bundle2 = null;
                    }
                    dVar.f7221c = bundle2;
                    dVar.f7222d = true;
                    return;
                }
                throw new IllegalStateException("SavedStateRegistry was already restored.".toString());
            }
            throw new IllegalStateException("You must call performAttach() before calling performRestore(Bundle).".toString());
        }
        throw new IllegalStateException(("performRestore cannot be called when owner is " + f4.f1915c).toString());
    }

    public final void c(Bundle bundle) {
        com.google.common.collect.c.F(bundle, "outBundle");
        d dVar = this.f7226b;
        dVar.getClass();
        Bundle bundle2 = new Bundle();
        Bundle bundle3 = dVar.f7221c;
        if (bundle3 != null) {
            bundle2.putAll(bundle3);
        }
        g gVar = dVar.f7219a;
        gVar.getClass();
        i.d dVar2 = new i.d(gVar);
        gVar.f4904c.put(dVar2, Boolean.FALSE);
        while (dVar2.hasNext()) {
            Map.Entry entry = (Map.Entry) dVar2.next();
            bundle2.putBundle((String) entry.getKey(), ((c) entry.getValue()).a());
        }
        if (!bundle2.isEmpty()) {
            bundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", bundle2);
        }
    }
}