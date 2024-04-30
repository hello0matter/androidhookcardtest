package l2;

import android.graphics.RectF;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class a implements d {

    /* renamed from: a  reason: collision with root package name */
    public final float f5273a;

    public a(float f4) {
        this.f5273a = f4;
    }

    @Override // l2.d
    public final float a(RectF rectF) {
        return this.f5273a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof a) && this.f5273a == ((a) obj).f5273a) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f5273a)});
    }
}