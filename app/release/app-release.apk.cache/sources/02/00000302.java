package androidx.recyclerview.widget;

import android.database.Observable;

/* loaded from: classes.dex */
public final class k0 extends Observable {
    public final boolean a() {
        return !((Observable) this).mObservers.isEmpty();
    }

    public final void b() {
        for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
            ((l0) ((Observable) this).mObservers.get(size)).a();
        }
    }
}