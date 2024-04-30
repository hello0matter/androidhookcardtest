package i0;

import android.os.Build;
import android.view.animation.DecelerateInterpolator;

/* loaded from: classes.dex */
public final class r1 {

    /* renamed from: a  reason: collision with root package name */
    public q1 f4973a;

    public r1(int i4, DecelerateInterpolator decelerateInterpolator, long j4) {
        q1 q1Var;
        if (Build.VERSION.SDK_INT >= 30) {
            q1Var = new p1(a2.a.i(i4, decelerateInterpolator, j4));
        } else {
            q1Var = new q1(i4, decelerateInterpolator, j4);
        }
        this.f4973a = q1Var;
    }
}