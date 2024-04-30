package c1;

import android.view.View;
import android.view.WindowId;

/* loaded from: classes.dex */
public final class z0 implements a1 {

    /* renamed from: a  reason: collision with root package name */
    public final WindowId f2719a;

    public z0(View view) {
        this.f2719a = view.getWindowId();
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof z0) && ((z0) obj).f2719a.equals(this.f2719a)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.f2719a.hashCode();
    }
}