package o2;

import android.animation.ValueAnimator;
import android.view.View;

/* loaded from: classes.dex */
public final class e implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ View f5972a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f5973b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ f f5974c;

    public e(f fVar, View view, View view2) {
        this.f5974c = fVar;
        this.f5972a = view;
        this.f5973b = view2;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f5974c.c(this.f5972a, this.f5973b, valueAnimator.getAnimatedFraction());
    }
}