package i0;

import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;

/* loaded from: classes.dex */
public abstract class q1 {

    /* renamed from: a  reason: collision with root package name */
    public final int f4969a;

    /* renamed from: b  reason: collision with root package name */
    public float f4970b;

    /* renamed from: c  reason: collision with root package name */
    public final Interpolator f4971c;

    /* renamed from: d  reason: collision with root package name */
    public final long f4972d;

    public q1(int i4, DecelerateInterpolator decelerateInterpolator, long j4) {
        this.f4969a = i4;
        this.f4971c = decelerateInterpolator;
        this.f4972d = j4;
    }

    public long a() {
        return this.f4972d;
    }

    public float b() {
        Interpolator interpolator = this.f4971c;
        if (interpolator != null) {
            return interpolator.getInterpolation(this.f4970b);
        }
        return this.f4970b;
    }

    public int c() {
        return this.f4969a;
    }

    public void d(float f4) {
        this.f4970b = f4;
    }
}