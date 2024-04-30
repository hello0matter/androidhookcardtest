package androidx.fragment.app;

import androidx.lifecycle.Lifecycle$Event;

/* loaded from: classes.dex */
class FragmentManager$6 implements androidx.lifecycle.o {
    @Override // androidx.lifecycle.o
    public final void b(androidx.lifecycle.q qVar, Lifecycle$Event lifecycle$Event) {
        if (lifecycle$Event != Lifecycle$Event.ON_START) {
            if (lifecycle$Event != Lifecycle$Event.ON_DESTROY) {
                return;
            }
            throw null;
        }
        throw null;
    }
}