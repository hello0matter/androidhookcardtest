package d2;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import androidx.appcompat.widget.c0;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/* loaded from: classes.dex */
public final class j extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public boolean f4367a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f4368b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ c0 f4369c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ q f4370d;

    public j(q qVar, boolean z4, c0 c0Var) {
        this.f4370d = qVar;
        this.f4368b = z4;
        this.f4369c = c0Var;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        this.f4367a = true;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        int i4;
        q qVar = this.f4370d;
        qVar.f4411r = 0;
        qVar.f4405l = null;
        if (!this.f4367a) {
            boolean z4 = this.f4368b;
            if (z4) {
                i4 = 8;
            } else {
                i4 = 4;
            }
            qVar.f4415v.a(i4, z4);
            c0 c0Var = this.f4369c;
            if (c0Var != null) {
                ((com.google.common.collect.c) c0Var.f725b).p1((FloatingActionButton) c0Var.f726c);
            }
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        q qVar = this.f4370d;
        qVar.f4415v.a(0, this.f4368b);
        qVar.f4411r = 1;
        qVar.f4405l = animator;
        this.f4367a = false;
    }
}