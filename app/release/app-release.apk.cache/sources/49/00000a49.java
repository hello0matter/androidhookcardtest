package y1;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.View;
import i2.c;
import z.d;
import z.e;

/* loaded from: classes.dex */
public abstract class a {
    public static int a(int i4, int i5) {
        return b0.a.e(i4, (Color.alpha(i4) * i5) / 255);
    }

    public static int b(int i4, View view) {
        Context context = view.getContext();
        TypedValue c4 = c.c(i4, view.getContext(), view.getClass().getCanonicalName());
        int i5 = c4.resourceId;
        if (i5 != 0) {
            Object obj = e.f7215a;
            return d.a(context, i5);
        }
        return c4.data;
    }

    public static int c(Context context, int i4, int i5) {
        TypedValue a5 = c.a(context, i4);
        if (a5 != null) {
            int i6 = a5.resourceId;
            if (i6 != 0) {
                Object obj = e.f7215a;
                return d.a(context, i6);
            }
            return a5.data;
        }
        return i5;
    }

    public static boolean d(int i4) {
        boolean z4;
        double pow;
        double pow2;
        double pow3;
        if (i4 != 0) {
            ThreadLocal threadLocal = b0.a.f2488a;
            double[] dArr = (double[]) threadLocal.get();
            if (dArr == null) {
                dArr = new double[3];
                threadLocal.set(dArr);
            }
            int red = Color.red(i4);
            int green = Color.green(i4);
            int blue = Color.blue(i4);
            if (dArr.length == 3) {
                double d4 = red / 255.0d;
                if (d4 < 0.04045d) {
                    pow = d4 / 12.92d;
                } else {
                    pow = Math.pow((d4 + 0.055d) / 1.055d, 2.4d);
                }
                double d5 = green / 255.0d;
                if (d5 < 0.04045d) {
                    pow2 = d5 / 12.92d;
                } else {
                    pow2 = Math.pow((d5 + 0.055d) / 1.055d, 2.4d);
                }
                double d6 = blue / 255.0d;
                if (d6 < 0.04045d) {
                    pow3 = d6 / 12.92d;
                } else {
                    pow3 = Math.pow((d6 + 0.055d) / 1.055d, 2.4d);
                }
                z4 = false;
                dArr[0] = ((0.1805d * pow3) + (0.3576d * pow2) + (0.4124d * pow)) * 100.0d;
                double d7 = ((0.0722d * pow3) + (0.7152d * pow2) + (0.2126d * pow)) * 100.0d;
                dArr[1] = d7;
                double d8 = pow3 * 0.9505d;
                dArr[2] = (d8 + (pow2 * 0.1192d) + (pow * 0.0193d)) * 100.0d;
                if (d7 / 100.0d > 0.5d) {
                    return true;
                }
            } else {
                throw new IllegalArgumentException("outXyz must have a length of 3.");
            }
        } else {
            z4 = false;
        }
        return z4;
    }

    public static int e(int i4, float f4, int i5) {
        return b0.a.c(b0.a.e(i5, Math.round(Color.alpha(i5) * f4)), i4);
    }
}