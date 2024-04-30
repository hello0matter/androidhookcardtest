package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public final class c extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ViewGroup f1663a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f1664b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f1665c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ f1 f1666d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ h f1667e;

    public c(ViewGroup viewGroup, View view, boolean z4, f1 f1Var, h hVar) {
        this.f1663a = viewGroup;
        this.f1664b = view;
        this.f1665c = z4;
        this.f1666d = f1Var;
        this.f1667e = hVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        ViewGroup viewGroup = this.f1663a;
        View view = this.f1664b;
        viewGroup.endViewTransition(view);
        if (this.f1665c) {
            this.f1666d.f1695a.a(view);
        }
        this.f1667e.a();
    }
}