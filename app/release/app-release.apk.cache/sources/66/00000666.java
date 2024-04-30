package d2;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import androidx.appcompat.widget.c0;

/* loaded from: classes.dex */
public final class k extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ boolean f4371a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ c0 f4372b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ q f4373c;

    public k(q qVar, boolean z4, c0 c0Var) {
        this.f4373c = qVar;
        this.f4371a = z4;
        this.f4372b = c0Var;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        q qVar = this.f4373c;
        qVar.f4411r = 0;
        qVar.f4405l = null;
        c0 c0Var = this.f4372b;
        if (c0Var != null) {
            ((com.google.common.collect.c) c0Var.f725b).s1();
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        q qVar = this.f4373c;
        qVar.f4415v.a(0, this.f4371a);
        qVar.f4411r = 2;
        qVar.f4405l = animator;
    }
}