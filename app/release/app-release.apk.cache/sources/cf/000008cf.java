package o;

import android.util.Log;
import android.view.View;
import androidx.appcompat.app.o0;
import androidx.constraintlayout.motion.widget.MotionLayout;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class i0 extends j0 {

    /* renamed from: g  reason: collision with root package name */
    public boolean f5817g;

    @Override // o.j0
    public final boolean b(float f4, long j4, View view, o0 o0Var) {
        Method method;
        if (view instanceof MotionLayout) {
            ((MotionLayout) view).setProgress(a(f4, j4, view, o0Var));
        } else if (this.f5817g) {
            return false;
        } else {
            try {
                method = view.getClass().getMethod("setProgress", Float.TYPE);
            } catch (NoSuchMethodException unused) {
                this.f5817g = true;
                method = null;
            }
            if (method != null) {
                try {
                    method.invoke(view, Float.valueOf(a(f4, j4, view, o0Var)));
                } catch (IllegalAccessException | InvocationTargetException e4) {
                    Log.e("SplineSet", "unable to setProgress", e4);
                }
            }
        }
        return this.f5824d;
    }
}