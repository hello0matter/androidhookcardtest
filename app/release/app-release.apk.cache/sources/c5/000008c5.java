package o;

import android.util.Log;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionLayout;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class d0 extends e0 {

    /* renamed from: f  reason: collision with root package name */
    public boolean f5795f;

    @Override // o.e0
    public final void c(View view, float f4) {
        Method method;
        if (view instanceof MotionLayout) {
            ((MotionLayout) view).setProgress(a(f4));
        } else if (this.f5795f) {
        } else {
            try {
                method = view.getClass().getMethod("setProgress", Float.TYPE);
            } catch (NoSuchMethodException unused) {
                this.f5795f = true;
                method = null;
            }
            if (method != null) {
                try {
                    method.invoke(view, Float.valueOf(a(f4)));
                } catch (IllegalAccessException | InvocationTargetException e4) {
                    Log.e("SplineSet", "unable to setProgress", e4);
                }
            }
        }
    }
}