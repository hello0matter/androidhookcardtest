package c1;

import android.view.View;

/* loaded from: classes.dex */
public abstract class q0 extends androidx.appcompat.app.o0 {

    /* renamed from: e  reason: collision with root package name */
    public static boolean f2676e = true;

    public q0() {
        super(22);
    }

    public float y(View view) {
        float transitionAlpha;
        if (f2676e) {
            try {
                transitionAlpha = view.getTransitionAlpha();
                return transitionAlpha;
            } catch (NoSuchMethodError unused) {
                f2676e = false;
            }
        }
        return view.getAlpha();
    }

    public void z(View view, float f4) {
        if (f2676e) {
            try {
                view.setTransitionAlpha(f4);
                return;
            } catch (NoSuchMethodError unused) {
                f2676e = false;
            }
        }
        view.setAlpha(f4);
    }
}