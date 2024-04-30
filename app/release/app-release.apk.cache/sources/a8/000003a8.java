package c1;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import androidx.transition.Transition;
import com.example.msphone.R;

/* loaded from: classes.dex */
public final class n0 extends AnimatorListenerAdapter implements f0 {

    /* renamed from: a  reason: collision with root package name */
    public final View f2651a;

    /* renamed from: b  reason: collision with root package name */
    public final View f2652b;

    /* renamed from: c  reason: collision with root package name */
    public final int f2653c;

    /* renamed from: d  reason: collision with root package name */
    public final int f2654d;

    /* renamed from: e  reason: collision with root package name */
    public int[] f2655e;

    /* renamed from: f  reason: collision with root package name */
    public float f2656f;

    /* renamed from: g  reason: collision with root package name */
    public float f2657g;

    /* renamed from: h  reason: collision with root package name */
    public final float f2658h;

    /* renamed from: i  reason: collision with root package name */
    public final float f2659i;

    public n0(View view, View view2, int i4, int i5, float f4, float f5) {
        this.f2652b = view;
        this.f2651a = view2;
        this.f2653c = i4 - Math.round(view.getTranslationX());
        this.f2654d = i5 - Math.round(view.getTranslationY());
        this.f2658h = f4;
        this.f2659i = f5;
        int[] iArr = (int[]) view2.getTag(R.id.transition_position);
        this.f2655e = iArr;
        if (iArr != null) {
            view2.setTag(R.id.transition_position, null);
        }
    }

    @Override // c1.f0
    public final void d(Transition transition) {
        View view = this.f2652b;
        view.setTranslationX(this.f2658h);
        view.setTranslationY(this.f2659i);
        transition.v(this);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        if (this.f2655e == null) {
            this.f2655e = new int[2];
        }
        int[] iArr = this.f2655e;
        View view = this.f2652b;
        iArr[0] = Math.round(view.getTranslationX() + this.f2653c);
        this.f2655e[1] = Math.round(view.getTranslationY() + this.f2654d);
        this.f2651a.setTag(R.id.transition_position, this.f2655e);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
    public final void onAnimationPause(Animator animator) {
        View view = this.f2652b;
        this.f2656f = view.getTranslationX();
        this.f2657g = view.getTranslationY();
        view.setTranslationX(this.f2658h);
        view.setTranslationY(this.f2659i);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
    public final void onAnimationResume(Animator animator) {
        float f4 = this.f2656f;
        View view = this.f2652b;
        view.setTranslationX(f4);
        view.setTranslationY(this.f2657g);
    }

    @Override // c1.f0
    public final void a() {
    }

    @Override // c1.f0
    public final void b() {
    }

    @Override // c1.f0
    public final void c() {
    }

    @Override // c1.f0
    public final void e() {
    }
}