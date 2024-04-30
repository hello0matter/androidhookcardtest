package com.google.android.material.internal;

import android.animation.TimeInterpolator;
import android.view.animation.Interpolator;

/* loaded from: classes.dex */
public final class z implements TimeInterpolator {

    /* renamed from: a  reason: collision with root package name */
    public final TimeInterpolator f3604a;

    public z(Interpolator interpolator) {
        this.f3604a = interpolator;
    }

    public static TimeInterpolator a(boolean z4, Interpolator interpolator) {
        if (z4) {
            return interpolator;
        }
        return new z(interpolator);
    }

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float f4) {
        return 1.0f - this.f3604a.getInterpolation(f4);
    }
}