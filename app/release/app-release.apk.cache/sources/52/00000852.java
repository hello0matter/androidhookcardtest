package l2;

import android.graphics.RectF;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class c implements d {

    /* renamed from: a  reason: collision with root package name */
    public final float f5281a;

    public c(float f4) {
        this.f5281a = f4;
    }

    @Override // l2.d
    public final float a(RectF rectF) {
        return Math.min(this.f5281a, Math.min(rectF.width() / 2.0f, rectF.height() / 2.0f));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof c) && this.f5281a == ((c) obj).f5281a) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f5281a)});
    }
}