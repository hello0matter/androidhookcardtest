package r2;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

/* loaded from: classes.dex */
public final class b extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ boolean f6464a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f6465b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View f6466c;

    public b(boolean z4, View view, View view2) {
        this.f6464a = z4;
        this.f6465b = view;
        this.f6466c = view2;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        if (!this.f6464a) {
            this.f6465b.setVisibility(4);
            View view = this.f6466c;
            view.setAlpha(1.0f);
            view.setVisibility(0);
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        if (this.f6464a) {
            this.f6465b.setVisibility(0);
            View view = this.f6466c;
            view.setAlpha(0.0f);
            view.setVisibility(4);
        }
    }
}