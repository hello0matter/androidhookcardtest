package i0;

import android.animation.ValueAnimator;
import android.view.View;

/* loaded from: classes.dex */
public final class l1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ View f4952a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ androidx.appcompat.widget.c0 f4953b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ValueAnimator f4954c;

    public l1(View view, r1 r1Var, androidx.appcompat.widget.c0 c0Var, ValueAnimator valueAnimator) {
        this.f4952a = view;
        this.f4953b = c0Var;
        this.f4954c = valueAnimator;
    }

    @Override // java.lang.Runnable
    public final void run() {
        n1.h(this.f4952a, this.f4953b);
        this.f4954c.start();
    }
}