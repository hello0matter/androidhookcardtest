package h2;

import android.animation.ObjectAnimator;
import androidx.appcompat.widget.j3;
import com.google.android.material.progressindicator.CircularProgressIndicatorSpec;

/* loaded from: classes.dex */
public final class g extends g.e {

    /* renamed from: l  reason: collision with root package name */
    public static final int[] f4831l = {0, 1350, 2700, 4050};

    /* renamed from: m  reason: collision with root package name */
    public static final int[] f4832m = {667, 2017, 3367, 4717};

    /* renamed from: n  reason: collision with root package name */
    public static final int[] f4833n = {1000, 2350, 3700, 5050};

    /* renamed from: o  reason: collision with root package name */
    public static final j3 f4834o = new j3(Float.class, "animationFraction", 15);

    /* renamed from: p  reason: collision with root package name */
    public static final j3 f4835p = new j3(Float.class, "completeEndFraction", 16);

    /* renamed from: d  reason: collision with root package name */
    public ObjectAnimator f4836d;

    /* renamed from: e  reason: collision with root package name */
    public ObjectAnimator f4837e;

    /* renamed from: f  reason: collision with root package name */
    public final u0.b f4838f;

    /* renamed from: g  reason: collision with root package name */
    public final CircularProgressIndicatorSpec f4839g;

    /* renamed from: h  reason: collision with root package name */
    public int f4840h;

    /* renamed from: i  reason: collision with root package name */
    public float f4841i;

    /* renamed from: j  reason: collision with root package name */
    public float f4842j;

    /* renamed from: k  reason: collision with root package name */
    public d1.c f4843k;

    public g(CircularProgressIndicatorSpec circularProgressIndicatorSpec) {
        super(1);
        this.f4840h = 0;
        this.f4843k = null;
        this.f4839g = circularProgressIndicatorSpec;
        this.f4838f = new u0.b();
    }

    @Override // g.e
    public final void c() {
        ObjectAnimator objectAnimator = this.f4836d;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    @Override // g.e
    public final void o() {
        v();
    }

    @Override // g.e
    public final void p(c cVar) {
        this.f4843k = cVar;
    }

    @Override // g.e
    public final void q() {
        ObjectAnimator objectAnimator = this.f4837e;
        if (objectAnimator != null && !objectAnimator.isRunning()) {
            if (((m) this.f4618a).isVisible()) {
                this.f4837e.start();
            } else {
                c();
            }
        }
    }

    @Override // g.e
    public final void s() {
        if (this.f4836d == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, f4834o, 0.0f, 1.0f);
            this.f4836d = ofFloat;
            ofFloat.setDuration(5400L);
            this.f4836d.setInterpolator(null);
            this.f4836d.setRepeatCount(-1);
            this.f4836d.addListener(new f(this, 0));
        }
        if (this.f4837e == null) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, f4835p, 0.0f, 1.0f);
            this.f4837e = ofFloat2;
            ofFloat2.setDuration(333L);
            this.f4837e.setInterpolator(this.f4838f);
            this.f4837e.addListener(new f(this, 1));
        }
        v();
        this.f4836d.start();
    }

    @Override // g.e
    public final void u() {
        this.f4843k = null;
    }

    public final void v() {
        this.f4840h = 0;
        ((int[]) this.f4620c)[0] = y1.a.a(this.f4839g.f4821c[0], ((m) this.f4618a).f4862j);
        this.f4842j = 0.0f;
    }
}