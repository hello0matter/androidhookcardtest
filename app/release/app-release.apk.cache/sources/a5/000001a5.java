package androidx.constraintlayout.motion.widget;

import androidx.constraintlayout.motion.widget.MotionLayout;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public float f1072a = Float.NaN;

    /* renamed from: b  reason: collision with root package name */
    public float f1073b = Float.NaN;

    /* renamed from: c  reason: collision with root package name */
    public int f1074c = -1;

    /* renamed from: d  reason: collision with root package name */
    public int f1075d = -1;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ MotionLayout f1076e;

    public a(MotionLayout motionLayout) {
        this.f1076e = motionLayout;
    }

    public final void a() {
        int i4 = this.f1074c;
        MotionLayout motionLayout = this.f1076e;
        if (i4 != -1 || this.f1075d != -1) {
            if (i4 == -1) {
                motionLayout.z(this.f1075d);
            } else {
                int i5 = this.f1075d;
                if (i5 == -1) {
                    motionLayout.setState(i4, -1, -1);
                } else {
                    motionLayout.setTransition(i4, i5);
                }
            }
            motionLayout.setState(MotionLayout.TransitionState.f1068b);
        }
        if (Float.isNaN(this.f1073b)) {
            if (Float.isNaN(this.f1072a)) {
                return;
            }
            motionLayout.setProgress(this.f1072a);
            return;
        }
        motionLayout.setProgress(this.f1072a, this.f1073b);
        this.f1072a = Float.NaN;
        this.f1073b = Float.NaN;
        this.f1074c = -1;
        this.f1075d = -1;
    }
}