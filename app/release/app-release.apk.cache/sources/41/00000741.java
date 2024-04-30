package i0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.drawable.Drawable;
import android.view.View;

/* loaded from: classes.dex */
public final class e1 extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f4924a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f4925b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object f4926c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Object f4927d;

    public /* synthetic */ e1(Object obj, Object obj2, Object obj3, int i4) {
        this.f4924a = i4;
        this.f4927d = obj;
        this.f4926c = obj2;
        this.f4925b = obj3;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        switch (this.f4924a) {
            case 0:
                ((h1) this.f4926c).g((View) this.f4925b);
                return;
            default:
                super.onAnimationCancel(animator);
                return;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        int i4 = this.f4924a;
        Object obj = this.f4926c;
        switch (i4) {
            case 0:
                ((h1) obj).a();
                return;
            case 1:
                ((r1) obj).f4973a.d(1.0f);
                n1.e((View) this.f4925b);
                return;
            default:
                ((x1.g) obj).setCircularRevealOverlayDrawable(null);
                return;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        int i4 = this.f4924a;
        Object obj = this.f4926c;
        switch (i4) {
            case 0:
                ((h1) obj).i();
                return;
            case 1:
            default:
                super.onAnimationStart(animator);
                return;
            case 2:
                ((x1.g) obj).setCircularRevealOverlayDrawable((Drawable) this.f4925b);
                return;
        }
    }
}