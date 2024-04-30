package p1;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    public long f6138a;

    /* renamed from: c  reason: collision with root package name */
    public TimeInterpolator f6140c = null;

    /* renamed from: d  reason: collision with root package name */
    public int f6141d = 0;

    /* renamed from: e  reason: collision with root package name */
    public int f6142e = 1;

    /* renamed from: b  reason: collision with root package name */
    public long f6139b = 150;

    public g(long j4) {
        this.f6138a = j4;
    }

    public final void a(Animator animator) {
        animator.setStartDelay(this.f6138a);
        animator.setDuration(this.f6139b);
        animator.setInterpolator(b());
        if (animator instanceof ValueAnimator) {
            ValueAnimator valueAnimator = (ValueAnimator) animator;
            valueAnimator.setRepeatCount(this.f6141d);
            valueAnimator.setRepeatMode(this.f6142e);
        }
    }

    public final TimeInterpolator b() {
        TimeInterpolator timeInterpolator = this.f6140c;
        if (timeInterpolator == null) {
            return a.f6129b;
        }
        return timeInterpolator;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        if (this.f6138a != gVar.f6138a || this.f6139b != gVar.f6139b || this.f6141d != gVar.f6141d || this.f6142e != gVar.f6142e) {
            return false;
        }
        return b().getClass().equals(gVar.b().getClass());
    }

    public final int hashCode() {
        long j4 = this.f6138a;
        long j5 = this.f6139b;
        return ((((b().getClass().hashCode() + (((((int) (j4 ^ (j4 >>> 32))) * 31) + ((int) ((j5 >>> 32) ^ j5))) * 31)) * 31) + this.f6141d) * 31) + this.f6142e;
    }

    public final String toString() {
        return "\n" + g.class.getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " delay: " + this.f6138a + " duration: " + this.f6139b + " interpolator: " + b().getClass() + " repeatCount: " + this.f6141d + " repeatMode: " + this.f6142e + "}\n";
    }
}