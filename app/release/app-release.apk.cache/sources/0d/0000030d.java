package androidx.recyclerview.widget;

import android.animation.ValueAnimator;

/* loaded from: classes.dex */
public final class o implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ p f2196a;

    public o(p pVar) {
        this.f2196a = pVar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
        p pVar = this.f2196a;
        pVar.f2205c.setAlpha(floatValue);
        pVar.f2206d.setAlpha(floatValue);
        pVar.f2221s.invalidate();
    }
}