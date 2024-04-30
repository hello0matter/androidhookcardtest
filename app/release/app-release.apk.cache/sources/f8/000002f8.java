package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;

/* loaded from: classes.dex */
public final class h extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f2106a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ i f2107b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ViewPropertyAnimator f2108c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ View f2109d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ k f2110e;

    public /* synthetic */ h(k kVar, i iVar, ViewPropertyAnimator viewPropertyAnimator, View view, int i4) {
        this.f2106a = i4;
        this.f2110e = kVar;
        this.f2107b = iVar;
        this.f2108c = viewPropertyAnimator;
        this.f2109d = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        int i4 = this.f2106a;
        k kVar = this.f2110e;
        i iVar = this.f2107b;
        View view = this.f2109d;
        ViewPropertyAnimator viewPropertyAnimator = this.f2108c;
        switch (i4) {
            case 0:
                viewPropertyAnimator.setListener(null);
                view.setAlpha(1.0f);
                view.setTranslationX(0.0f);
                view.setTranslationY(0.0f);
                kVar.c(iVar.f2119a);
                kVar.f2159r.remove(iVar.f2119a);
                kVar.i();
                return;
            default:
                viewPropertyAnimator.setListener(null);
                view.setAlpha(1.0f);
                view.setTranslationX(0.0f);
                view.setTranslationY(0.0f);
                kVar.c(iVar.f2120b);
                kVar.f2159r.remove(iVar.f2120b);
                kVar.i();
                return;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        int i4 = this.f2106a;
        k kVar = this.f2110e;
        i iVar = this.f2107b;
        switch (i4) {
            case 0:
                l1 l1Var = iVar.f2119a;
                kVar.getClass();
                return;
            default:
                l1 l1Var2 = iVar.f2120b;
                kVar.getClass();
                return;
        }
    }
}