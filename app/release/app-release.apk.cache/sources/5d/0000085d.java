package l2;

import android.graphics.RectF;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class l implements d {

    /* renamed from: a  reason: collision with root package name */
    public final float f5334a;

    public l(float f4) {
        this.f5334a = f4;
    }

    @Override // l2.d
    public final float a(RectF rectF) {
        return Math.min(rectF.width(), rectF.height()) * this.f5334a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof l) && this.f5334a == ((l) obj).f5334a) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f5334a)});
    }
}