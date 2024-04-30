package h2;

import android.animation.ObjectAnimator;
import androidx.appcompat.widget.j3;
import com.google.android.material.progressindicator.LinearProgressIndicatorSpec;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class o extends g.e {

    /* renamed from: j  reason: collision with root package name */
    public static final j3 f4871j = new j3(Float.class, "animationFraction", 18);

    /* renamed from: d  reason: collision with root package name */
    public ObjectAnimator f4872d;

    /* renamed from: e  reason: collision with root package name */
    public final u0.b f4873e;

    /* renamed from: f  reason: collision with root package name */
    public final LinearProgressIndicatorSpec f4874f;

    /* renamed from: g  reason: collision with root package name */
    public int f4875g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f4876h;

    /* renamed from: i  reason: collision with root package name */
    public float f4877i;

    public o(LinearProgressIndicatorSpec linearProgressIndicatorSpec) {
        super(3);
        this.f4875g = 1;
        this.f4874f = linearProgressIndicatorSpec;
        this.f4873e = new u0.b();
    }

    @Override // g.e
    public final void c() {
        ObjectAnimator objectAnimator = this.f4872d;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    @Override // g.e
    public final void o() {
        v();
    }

    @Override // g.e
    public final void s() {
        if (this.f4872d == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, f4871j, 0.0f, 1.0f);
            this.f4872d = ofFloat;
            ofFloat.setDuration(333L);
            this.f4872d.setInterpolator(null);
            this.f4872d.setRepeatCount(-1);
            this.f4872d.addListener(new androidx.appcompat.widget.e(8, this));
        }
        v();
        this.f4872d.start();
    }

    public final void v() {
        this.f4876h = true;
        this.f4875g = 1;
        Arrays.fill((int[]) this.f4620c, y1.a.a(this.f4874f.f4821c[0], ((m) this.f4618a).f4862j));
    }

    @Override // g.e
    public final void p(c cVar) {
    }

    @Override // g.e
    public final void q() {
    }

    @Override // g.e
    public final void u() {
    }
}