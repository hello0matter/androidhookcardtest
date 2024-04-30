package h2;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* loaded from: classes.dex */
public final class p extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f4878a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ q f4879b;

    public /* synthetic */ p(q qVar, int i4) {
        this.f4878a = i4;
        this.f4879b = qVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        switch (this.f4878a) {
            case 1:
                super.onAnimationEnd(animator);
                q qVar = this.f4879b;
                qVar.c();
                d1.c cVar = qVar.f4890k;
                if (cVar != null) {
                    cVar.a((m) qVar.f4618a);
                    return;
                }
                return;
            default:
                super.onAnimationEnd(animator);
                return;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator animator) {
        switch (this.f4878a) {
            case 0:
                super.onAnimationRepeat(animator);
                q qVar = this.f4879b;
                qVar.f4887h = (qVar.f4887h + 1) % qVar.f4886g.f4821c.length;
                qVar.f4888i = true;
                return;
            default:
                super.onAnimationRepeat(animator);
                return;
        }
    }
}