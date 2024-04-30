package androidx.appcompat.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* loaded from: classes.dex */
public final class r2 extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f881a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f882b;

    /* renamed from: c  reason: collision with root package name */
    public final int f883c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Object f884d;

    public r2(ScrollingTabContainerView scrollingTabContainerView) {
        this.f881a = 0;
        this.f884d = scrollingTabContainerView;
        this.f882b = false;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        switch (this.f881a) {
            case 0:
                this.f882b = true;
                return;
            default:
                super.onAnimationCancel(animator);
                return;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        int i4 = this.f881a;
        Object obj = this.f884d;
        switch (i4) {
            case 0:
                if (!this.f882b) {
                    ScrollingTabContainerView scrollingTabContainerView = (ScrollingTabContainerView) obj;
                    scrollingTabContainerView.getClass();
                    scrollingTabContainerView.setVisibility(this.f883c);
                    return;
                }
                return;
            default:
                f2.j jVar = (f2.j) obj;
                jVar.f4552b.setTranslationX(0.0f);
                jVar.d(this.f883c, 0.0f, this.f882b);
                return;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        switch (this.f881a) {
            case 0:
                ((ScrollingTabContainerView) this.f884d).setVisibility(0);
                this.f882b = false;
                return;
            default:
                super.onAnimationStart(animator);
                return;
        }
    }

    public r2(f2.j jVar, boolean z4, int i4) {
        this.f881a = 1;
        this.f884d = jVar;
        this.f882b = z4;
        this.f883c = i4;
    }
}