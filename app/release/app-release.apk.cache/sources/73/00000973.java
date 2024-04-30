package r2;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

/* loaded from: classes.dex */
public final class c extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ boolean f6467a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f6468b;

    public c(boolean z4, View view) {
        this.f6467a = z4;
        this.f6468b = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        if (!this.f6467a) {
            this.f6468b.setVisibility(4);
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        if (this.f6467a) {
            this.f6468b.setVisibility(0);
        }
    }
}