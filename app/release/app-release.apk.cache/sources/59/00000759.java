package i0;

import android.animation.ValueAnimator;
import android.os.Build;
import android.view.View;
import java.util.Collections;

/* loaded from: classes.dex */
public final class k1 implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ r1 f4943a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ g2 f4944b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ g2 f4945c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f4946d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ View f4947e;

    public k1(r1 r1Var, g2 g2Var, g2 g2Var2, int i4, View view) {
        this.f4943a = r1Var;
        this.f4944b = g2Var;
        this.f4945c = g2Var2;
        this.f4946d = i4;
        this.f4947e = view;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        x1 t1Var;
        b0.c e4;
        float animatedFraction = valueAnimator.getAnimatedFraction();
        r1 r1Var = this.f4943a;
        r1Var.f4973a.d(animatedFraction);
        float b5 = r1Var.f4973a.b();
        int i4 = Build.VERSION.SDK_INT;
        g2 g2Var = this.f4944b;
        if (i4 >= 30) {
            t1Var = new w1(g2Var);
        } else if (i4 >= 29) {
            t1Var = new v1(g2Var);
        } else {
            t1Var = new t1(g2Var);
        }
        for (int i5 = 1; i5 <= 256; i5 <<= 1) {
            if ((this.f4946d & i5) == 0) {
                e4 = g2Var.f4931a.f(i5);
            } else {
                b0.c f4 = g2Var.f4931a.f(i5);
                b0.c f5 = this.f4945c.f4931a.f(i5);
                float f6 = 1.0f - b5;
                e4 = g2.e(f4, (int) (((f4.f2490a - f5.f2490a) * f6) + 0.5d), (int) (((f4.f2491b - f5.f2491b) * f6) + 0.5d), (int) (((f4.f2492c - f5.f2492c) * f6) + 0.5d), (int) (((f4.f2493d - f5.f2493d) * f6) + 0.5d));
            }
            t1Var.c(i5, e4);
        }
        n1.g(this.f4947e, t1Var.b(), Collections.singletonList(r1Var));
    }
}