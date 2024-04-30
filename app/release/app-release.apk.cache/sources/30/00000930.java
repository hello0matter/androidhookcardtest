package p1;

import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.activity.j;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public static final LinearInterpolator f6128a = new LinearInterpolator();

    /* renamed from: b  reason: collision with root package name */
    public static final u0.b f6129b = new u0.b();

    /* renamed from: c  reason: collision with root package name */
    public static final u0.a f6130c = new u0.a();

    /* renamed from: d  reason: collision with root package name */
    public static final u0.c f6131d = new u0.c();

    /* renamed from: e  reason: collision with root package name */
    public static final DecelerateInterpolator f6132e = new DecelerateInterpolator();

    public static float a(float f4, float f5, float f6) {
        return j.a(f5, f4, f6, f4);
    }

    public static float b(float f4, float f5, float f6, float f7, float f8) {
        if (f8 <= f6) {
            return f4;
        }
        if (f8 >= f7) {
            return f5;
        }
        return a(f4, f5, (f8 - f6) / (f7 - f6));
    }

    public static int c(int i4, float f4, int i5) {
        return Math.round(f4 * (i5 - i4)) + i4;
    }
}