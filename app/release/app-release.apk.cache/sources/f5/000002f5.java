package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;

/* loaded from: classes.dex */
public final class g extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ l1 f2099a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f2100b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View f2101c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f2102d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ ViewPropertyAnimator f2103e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ k f2104f;

    public g(k kVar, l1 l1Var, int i4, View view, int i5, ViewPropertyAnimator viewPropertyAnimator) {
        this.f2104f = kVar;
        this.f2099a = l1Var;
        this.f2100b = i4;
        this.f2101c = view;
        this.f2102d = i5;
        this.f2103e = viewPropertyAnimator;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        int i4 = this.f2100b;
        View view = this.f2101c;
        if (i4 != 0) {
            view.setTranslationX(0.0f);
        }
        if (this.f2102d != 0) {
            view.setTranslationY(0.0f);
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        this.f2103e.setListener(null);
        k kVar = this.f2104f;
        l1 l1Var = this.f2099a;
        kVar.c(l1Var);
        kVar.f2157p.remove(l1Var);
        kVar.i();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        this.f2104f.getClass();
    }
}