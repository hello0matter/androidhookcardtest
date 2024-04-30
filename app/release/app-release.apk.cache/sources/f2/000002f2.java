package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;

/* loaded from: classes.dex */
public final class f extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f2083a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f2084b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View f2085c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Object f2086d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Object f2087e;

    public f(k kVar, l1 l1Var, ViewPropertyAnimator viewPropertyAnimator, View view) {
        this.f2083a = 0;
        this.f2087e = kVar;
        this.f2084b = l1Var;
        this.f2086d = viewPropertyAnimator;
        this.f2085c = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        switch (this.f2083a) {
            case 1:
                this.f2085c.setAlpha(1.0f);
                return;
            default:
                super.onAnimationCancel(animator);
                return;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        int i4 = this.f2083a;
        Object obj = this.f2087e;
        View view = this.f2085c;
        Object obj2 = this.f2086d;
        Object obj3 = this.f2084b;
        switch (i4) {
            case 0:
                ((ViewPropertyAnimator) obj2).setListener(null);
                view.setAlpha(1.0f);
                k kVar = (k) obj;
                l1 l1Var = (l1) obj3;
                kVar.c(l1Var);
                kVar.f2158q.remove(l1Var);
                kVar.i();
                return;
            case 1:
                ((ViewPropertyAnimator) obj2).setListener(null);
                k kVar2 = (k) obj;
                l1 l1Var2 = (l1) obj3;
                kVar2.c(l1Var2);
                kVar2.f2156o.remove(l1Var2);
                kVar2.i();
                return;
            default:
                ((ViewGroup) obj3).endViewTransition(view);
                animator.removeListener(this);
                androidx.fragment.app.t tVar = (androidx.fragment.app.t) obj2;
                View view2 = tVar.E;
                if (view2 != null && tVar.f1825y) {
                    view2.setVisibility(8);
                    return;
                }
                return;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        int i4 = this.f2083a;
        Object obj = this.f2087e;
        switch (i4) {
            case 0:
                ((k) obj).getClass();
                return;
            case 1:
                ((k) obj).getClass();
                return;
            default:
                super.onAnimationStart(animator);
                return;
        }
    }

    public /* synthetic */ f(k kVar, Object obj, View view, ViewPropertyAnimator viewPropertyAnimator, int i4) {
        this.f2083a = i4;
        this.f2087e = kVar;
        this.f2084b = obj;
        this.f2085c = view;
        this.f2086d = viewPropertyAnimator;
    }
}