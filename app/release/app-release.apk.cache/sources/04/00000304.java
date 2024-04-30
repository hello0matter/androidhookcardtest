package androidx.recyclerview.widget;

import android.animation.ValueAnimator;

/* loaded from: classes.dex */
public final class l implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f2167a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f2168b;

    public /* synthetic */ l(int i4, Object obj) {
        this.f2167a = i4;
        this.f2168b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i4 = this.f2167a;
        Object obj = this.f2168b;
        switch (i4) {
            case 0:
                p pVar = (p) obj;
                int i5 = pVar.A;
                ValueAnimator valueAnimator = pVar.f2228z;
                if (i5 != 1) {
                    if (i5 != 2) {
                        return;
                    }
                } else {
                    valueAnimator.cancel();
                }
                pVar.A = 3;
                valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 0.0f);
                valueAnimator.setDuration(500);
                valueAnimator.start();
                return;
            default:
                ((StaggeredGridLayoutManager) obj).A0();
                return;
        }
    }
}