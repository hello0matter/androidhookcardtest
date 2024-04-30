package h2;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import androidx.appcompat.widget.j3;
import com.example.msphone.R;
import com.google.android.material.progressindicator.LinearProgressIndicatorSpec;

/* loaded from: classes.dex */
public final class q extends g.e {

    /* renamed from: l  reason: collision with root package name */
    public static final int[] f4880l = {533, 567, 850, 750};

    /* renamed from: m  reason: collision with root package name */
    public static final int[] f4881m = {1267, 1000, 333, 0};

    /* renamed from: n  reason: collision with root package name */
    public static final j3 f4882n = new j3(Float.class, "animationFraction", 19);

    /* renamed from: d  reason: collision with root package name */
    public ObjectAnimator f4883d;

    /* renamed from: e  reason: collision with root package name */
    public ObjectAnimator f4884e;

    /* renamed from: f  reason: collision with root package name */
    public final Interpolator[] f4885f;

    /* renamed from: g  reason: collision with root package name */
    public final LinearProgressIndicatorSpec f4886g;

    /* renamed from: h  reason: collision with root package name */
    public int f4887h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f4888i;

    /* renamed from: j  reason: collision with root package name */
    public float f4889j;

    /* renamed from: k  reason: collision with root package name */
    public d1.c f4890k;

    public q(Context context, LinearProgressIndicatorSpec linearProgressIndicatorSpec) {
        super(2);
        this.f4887h = 0;
        this.f4890k = null;
        this.f4886g = linearProgressIndicatorSpec;
        this.f4885f = new Interpolator[]{AnimationUtils.loadInterpolator(context, R.anim.linear_indeterminate_line1_head_interpolator), AnimationUtils.loadInterpolator(context, R.anim.linear_indeterminate_line1_tail_interpolator), AnimationUtils.loadInterpolator(context, R.anim.linear_indeterminate_line2_head_interpolator), AnimationUtils.loadInterpolator(context, R.anim.linear_indeterminate_line2_tail_interpolator)};
    }

    @Override // g.e
    public final void c() {
        ObjectAnimator objectAnimator = this.f4883d;
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
        this.f4890k = cVar;
    }

    @Override // g.e
    public final void q() {
        ObjectAnimator objectAnimator = this.f4884e;
        if (objectAnimator != null && !objectAnimator.isRunning()) {
            c();
            if (((m) this.f4618a).isVisible()) {
                this.f4884e.setFloatValues(this.f4889j, 1.0f);
                this.f4884e.setDuration((1.0f - this.f4889j) * 1800.0f);
                this.f4884e.start();
            }
        }
    }

    @Override // g.e
    public final void s() {
        ObjectAnimator objectAnimator = this.f4883d;
        j3 j3Var = f4882n;
        if (objectAnimator == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, j3Var, 0.0f, 1.0f);
            this.f4883d = ofFloat;
            ofFloat.setDuration(1800L);
            this.f4883d.setInterpolator(null);
            this.f4883d.setRepeatCount(-1);
            this.f4883d.addListener(new p(this, 0));
        }
        if (this.f4884e == null) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, j3Var, 1.0f);
            this.f4884e = ofFloat2;
            ofFloat2.setDuration(1800L);
            this.f4884e.setInterpolator(null);
            this.f4884e.addListener(new p(this, 1));
        }
        v();
        this.f4883d.start();
    }

    @Override // g.e
    public final void u() {
        this.f4890k = null;
    }

    public final void v() {
        this.f4887h = 0;
        int a5 = y1.a.a(this.f4886g.f4821c[0], ((m) this.f4618a).f4862j);
        int[] iArr = (int[]) this.f4620c;
        iArr[0] = a5;
        iArr[1] = a5;
    }
}