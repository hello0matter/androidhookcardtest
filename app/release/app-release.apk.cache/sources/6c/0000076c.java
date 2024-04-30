package i0;

import android.view.WindowInsetsAnimation;

/* loaded from: classes.dex */
public final class p1 extends q1 {

    /* renamed from: e  reason: collision with root package name */
    public final WindowInsetsAnimation f4968e;

    public p1(WindowInsetsAnimation windowInsetsAnimation) {
        super(0, null, 0L);
        this.f4968e = windowInsetsAnimation;
    }

    public static WindowInsetsAnimation.Bounds e(androidx.appcompat.widget.c0 c0Var) {
        return new WindowInsetsAnimation.Bounds(((b0.c) c0Var.f725b).d(), ((b0.c) c0Var.f726c).d());
    }

    @Override // i0.q1
    public final long a() {
        long durationMillis;
        durationMillis = this.f4968e.getDurationMillis();
        return durationMillis;
    }

    @Override // i0.q1
    public final float b() {
        float interpolatedFraction;
        interpolatedFraction = this.f4968e.getInterpolatedFraction();
        return interpolatedFraction;
    }

    @Override // i0.q1
    public final int c() {
        int typeMask;
        typeMask = this.f4968e.getTypeMask();
        return typeMask;
    }

    @Override // i0.q1
    public final void d(float f4) {
        this.f4968e.setFraction(f4);
    }
}