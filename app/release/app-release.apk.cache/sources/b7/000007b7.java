package k;

import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
public abstract class b extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    public static final double f5114a = Math.cos(Math.toRadians(45.0d));

    public static float a(float f4, float f5, boolean z4) {
        if (z4) {
            return (float) (((1.0d - f5114a) * f5) + f4);
        }
        return f4;
    }

    public static float b(float f4, float f5, boolean z4) {
        float f6 = f4 * 1.5f;
        if (z4) {
            return (float) (((1.0d - f5114a) * f5) + f6);
        }
        return f6;
    }
}