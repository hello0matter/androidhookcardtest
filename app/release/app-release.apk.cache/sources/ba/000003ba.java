package c1;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.Transition;

/* loaded from: classes.dex */
public final class w0 extends AnimatorListenerAdapter implements f0 {

    /* renamed from: a  reason: collision with root package name */
    public final View f2703a;

    /* renamed from: b  reason: collision with root package name */
    public final int f2704b;

    /* renamed from: c  reason: collision with root package name */
    public final ViewGroup f2705c;

    /* renamed from: e  reason: collision with root package name */
    public boolean f2707e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f2708f = false;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f2706d = true;

    public w0(View view, int i4) {
        this.f2703a = view;
        this.f2704b = i4;
        this.f2705c = (ViewGroup) view.getParent();
        f(true);
    }

    @Override // c1.f0
    public final void c() {
        f(false);
    }

    @Override // c1.f0
    public final void d(Transition transition) {
        if (!this.f2708f) {
            p0.c(this.f2704b, this.f2703a);
            ViewGroup viewGroup = this.f2705c;
            if (viewGroup != null) {
                viewGroup.invalidate();
            }
        }
        f(false);
        transition.v(this);
    }

    @Override // c1.f0
    public final void e() {
        f(true);
    }

    public final void f(boolean z4) {
        ViewGroup viewGroup;
        if (this.f2706d && this.f2707e != z4 && (viewGroup = this.f2705c) != null) {
            this.f2707e = z4;
            c0.a(viewGroup, z4);
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        this.f2708f = true;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        if (!this.f2708f) {
            p0.c(this.f2704b, this.f2703a);
            ViewGroup viewGroup = this.f2705c;
            if (viewGroup != null) {
                viewGroup.invalidate();
            }
        }
        f(false);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
    public final void onAnimationPause(Animator animator) {
        if (!this.f2708f) {
            p0.c(this.f2704b, this.f2703a);
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
    public final void onAnimationResume(Animator animator) {
        if (!this.f2708f) {
            p0.c(0, this.f2703a);
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
    }

    @Override // c1.f0
    public final void a() {
    }

    @Override // c1.f0
    public final void b() {
    }
}