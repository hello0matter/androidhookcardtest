package l2;

import android.graphics.RectF;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class b implements d {

    /* renamed from: a  reason: collision with root package name */
    public final d f5274a;

    /* renamed from: b  reason: collision with root package name */
    public final float f5275b;

    public b(float f4, d dVar) {
        while (dVar instanceof b) {
            dVar = ((b) dVar).f5274a;
            f4 += ((b) dVar).f5275b;
        }
        this.f5274a = dVar;
        this.f5275b = f4;
    }

    @Override // l2.d
    public final float a(RectF rectF) {
        return Math.max(0.0f, this.f5274a.a(rectF) + this.f5275b);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (this.f5274a.equals(bVar.f5274a) && this.f5275b == bVar.f5275b) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f5274a, Float.valueOf(this.f5275b)});
    }
}