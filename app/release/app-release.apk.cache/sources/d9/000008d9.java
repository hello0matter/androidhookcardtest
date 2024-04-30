package o;

import androidx.constraintlayout.motion.widget.MotionLayout;

/* loaded from: classes.dex */
public final class r extends q {

    /* renamed from: a  reason: collision with root package name */
    public float f5871a = 0.0f;

    /* renamed from: b  reason: collision with root package name */
    public float f5872b = 0.0f;

    /* renamed from: c  reason: collision with root package name */
    public float f5873c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ MotionLayout f5874d;

    public r(MotionLayout motionLayout) {
        this.f5874d = motionLayout;
    }

    @Override // o.q
    public final float a() {
        return this.f5874d.f1052s;
    }

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float f4) {
        float f5 = this.f5871a;
        int i4 = (f5 > 0.0f ? 1 : (f5 == 0.0f ? 0 : -1));
        MotionLayout motionLayout = this.f5874d;
        if (i4 > 0) {
            float f6 = this.f5873c;
            if (f5 / f6 < f4) {
                f4 = f5 / f6;
            }
            motionLayout.f1052s = f5 - (f6 * f4);
            return ((f5 * f4) - (((f6 * f4) * f4) / 2.0f)) + this.f5872b;
        }
        float f7 = this.f5873c;
        if ((-f5) / f7 < f4) {
            f4 = (-f5) / f7;
        }
        motionLayout.f1052s = (f7 * f4) + f5;
        return (((f7 * f4) * f4) / 2.0f) + (f5 * f4) + this.f5872b;
    }
}