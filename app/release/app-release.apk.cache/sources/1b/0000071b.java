package h2;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* loaded from: classes.dex */
public final class f extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f4829a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ g f4830b;

    public /* synthetic */ f(g gVar, int i4) {
        this.f4829a = i4;
        this.f4830b = gVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        switch (this.f4829a) {
            case 1:
                super.onAnimationEnd(animator);
                g gVar = this.f4830b;
                gVar.c();
                d1.c cVar = gVar.f4843k;
                if (cVar != null) {
                    cVar.a((m) gVar.f4618a);
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
        switch (this.f4829a) {
            case 0:
                super.onAnimationRepeat(animator);
                g gVar = this.f4830b;
                gVar.f4840h = (gVar.f4840h + 4) % gVar.f4839g.f4821c.length;
                return;
            default:
                super.onAnimationRepeat(animator);
                return;
        }
    }
}