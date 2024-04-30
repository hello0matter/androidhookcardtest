package d2;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;

/* loaded from: classes.dex */
public abstract class p extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public boolean f4390a;

    /* renamed from: b  reason: collision with root package name */
    public float f4391b;

    /* renamed from: c  reason: collision with root package name */
    public float f4392c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ q f4393d;

    public p(s sVar) {
        this.f4393d = sVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        float f4 = (int) this.f4392c;
        l2.j jVar = this.f4393d.f4395b;
        if (jVar != null) {
            jVar.n(f4);
        }
        this.f4390a = false;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        float f4;
        float f5;
        float f6;
        boolean z4 = this.f4390a;
        q qVar = this.f4393d;
        if (!z4) {
            l2.j jVar = qVar.f4395b;
            float f7 = 0.0f;
            if (jVar == null) {
                f4 = 0.0f;
            } else {
                f4 = jVar.f5310a.f5301n;
            }
            this.f4391b = f4;
            o oVar = (o) this;
            int i4 = oVar.f4388e;
            q qVar2 = oVar.f4389f;
            switch (i4) {
                case 0:
                    break;
                case 1:
                    f5 = qVar2.f4401h;
                    f6 = qVar2.f4402i;
                    f7 = f5 + f6;
                    break;
                case 2:
                    f5 = qVar2.f4401h;
                    f6 = qVar2.f4403j;
                    f7 = f5 + f6;
                    break;
                default:
                    f7 = qVar2.f4401h;
                    break;
            }
            this.f4392c = f7;
            this.f4390a = true;
        }
        float f8 = this.f4391b;
        float animatedFraction = (int) ((valueAnimator.getAnimatedFraction() * (this.f4392c - f8)) + f8);
        l2.j jVar2 = qVar.f4395b;
        if (jVar2 != null) {
            jVar2.n(animatedFraction);
        }
    }
}