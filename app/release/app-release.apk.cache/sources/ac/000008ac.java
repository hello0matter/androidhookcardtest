package n0;

import android.view.animation.Interpolator;

/* loaded from: classes.dex */
public final class d implements Interpolator {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f5714a;

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float f4) {
        switch (this.f5714a) {
            case 0:
                float f5 = f4 - 1.0f;
                return (f5 * f5 * f5 * f5 * f5) + 1.0f;
            default:
                float f6 = f4 - 1.0f;
                return (f6 * f6 * f6 * f6 * f6) + 1.0f;
        }
    }
}