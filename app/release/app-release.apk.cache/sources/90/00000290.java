package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public final class y extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ViewGroup f1853a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f1854b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ t f1855c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ d0 f1856d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ e0.c f1857e;

    public y(ViewGroup viewGroup, View view, t tVar, d0 d0Var, e0.c cVar) {
        this.f1853a = viewGroup;
        this.f1854b = view;
        this.f1855c = tVar;
        this.f1856d = d0Var;
        this.f1857e = cVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        Animator animator2;
        ViewGroup viewGroup = this.f1853a;
        View view = this.f1854b;
        viewGroup.endViewTransition(view);
        t tVar = this.f1855c;
        r rVar = tVar.H;
        if (rVar == null) {
            animator2 = null;
        } else {
            animator2 = rVar.f1779b;
        }
        tVar.g().f1779b = null;
        if (animator2 != null && viewGroup.indexOfChild(view) < 0) {
            this.f1856d.b(tVar, this.f1857e);
        }
    }
}