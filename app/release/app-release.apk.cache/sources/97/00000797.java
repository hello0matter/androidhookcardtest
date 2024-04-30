package i2;

import android.content.res.Configuration;
import android.graphics.Typeface;
import android.os.Build;

/* loaded from: classes.dex */
public abstract class i {
    public static Typeface a(Configuration configuration, Typeface typeface) {
        int i4;
        int i5;
        int weight;
        int i6;
        Typeface create;
        if (Build.VERSION.SDK_INT >= 31) {
            i4 = configuration.fontWeightAdjustment;
            if (i4 != Integer.MAX_VALUE) {
                i5 = configuration.fontWeightAdjustment;
                if (i5 != 0 && typeface != null) {
                    weight = typeface.getWeight();
                    i6 = configuration.fontWeightAdjustment;
                    create = Typeface.create(typeface, com.google.common.collect.c.L(i6 + weight, 1, 1000), typeface.isItalic());
                    return create;
                }
                return null;
            }
            return null;
        }
        return null;
    }
}