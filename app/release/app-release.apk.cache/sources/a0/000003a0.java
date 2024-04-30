package c1;

import androidx.transition.Transition;
import androidx.transition.TransitionSet;

/* loaded from: classes.dex */
public final class j0 extends g0 {

    /* renamed from: a  reason: collision with root package name */
    public TransitionSet f2626a;

    @Override // c1.g0, c1.f0
    public final void b() {
        TransitionSet transitionSet = this.f2626a;
        if (!transitionSet.B) {
            transitionSet.F();
            transitionSet.B = true;
        }
    }

    @Override // c1.f0
    public final void d(Transition transition) {
        TransitionSet transitionSet = this.f2626a;
        int i4 = transitionSet.A - 1;
        transitionSet.A = i4;
        if (i4 == 0) {
            transitionSet.B = false;
            transitionSet.m();
        }
        transition.v(this);
    }
}