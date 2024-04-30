package o;

import android.util.Log;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionLayout;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class i extends j {

    /* renamed from: d  reason: collision with root package name */
    public boolean f5816d;

    @Override // o.j
    public final void c(View view, float f4) {
        Method method;
        if (view instanceof MotionLayout) {
            ((MotionLayout) view).setProgress(a(f4));
        } else if (this.f5816d) {
        } else {
            try {
                method = view.getClass().getMethod("setProgress", Float.TYPE);
            } catch (NoSuchMethodException unused) {
                this.f5816d = true;
                method = null;
            }
            if (method != null) {
                try {
                    method.invoke(view, Float.valueOf(a(f4)));
                } catch (IllegalAccessException | InvocationTargetException e4) {
                    Log.e("KeyCycleOscillator", "unable to setProgress", e4);
                }
            }
        }
    }
}