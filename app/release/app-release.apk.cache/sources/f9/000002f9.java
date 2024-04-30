package androidx.recyclerview.widget;

import android.view.animation.Interpolator;

/* loaded from: classes.dex */
public final class h0 implements Interpolator {
    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float f4) {
        float f5 = f4 - 1.0f;
        return (f5 * f5 * f5 * f5 * f5) + 1.0f;
    }
}