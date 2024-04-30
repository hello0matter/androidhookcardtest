package d2;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: a  reason: collision with root package name */
    public final com.google.android.material.bottomappbar.b f4365a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FloatingActionButton f4366b;

    public i(FloatingActionButton floatingActionButton, com.google.android.material.bottomappbar.b bVar) {
        this.f4366b = floatingActionButton;
        this.f4365a = bVar;
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof i) && ((i) obj).f4365a.equals(this.f4365a)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.f4365a.hashCode();
    }
}