package i0;

import android.view.DisplayCutout;

/* loaded from: classes.dex */
public final class l {

    /* renamed from: a  reason: collision with root package name */
    public final DisplayCutout f4948a;

    public l(DisplayCutout displayCutout) {
        this.f4948a = displayCutout;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && l.class == obj.getClass()) {
            return h0.b.a(this.f4948a, ((l) obj).f4948a);
        }
        return false;
    }

    public final int hashCode() {
        int hashCode;
        DisplayCutout displayCutout = this.f4948a;
        if (displayCutout != null) {
            hashCode = displayCutout.hashCode();
            return hashCode;
        }
        return 0;
    }

    public final String toString() {
        return "DisplayCutoutCompat{" + this.f4948a + "}";
    }
}