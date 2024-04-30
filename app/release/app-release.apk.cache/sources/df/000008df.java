package o;

import android.view.animation.Interpolator;

/* loaded from: classes.dex */
public final class x implements Interpolator {

    /* renamed from: a  reason: collision with root package name */
    public final Object f5912a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f5913b;

    public x(androidx.constraintlayout.motion.widget.b bVar, n.e eVar) {
        this.f5912a = eVar;
    }

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float f4) {
        return (float) ((n.e) this.f5912a).a(f4);
    }
}