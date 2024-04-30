package i2;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import androidx.appcompat.widget.q3;

/* loaded from: classes.dex */
public abstract class d {
    public static ColorStateList a(Context context, TypedArray typedArray, int i4) {
        int resourceId;
        ColorStateList b5;
        if (typedArray.hasValue(i4) && (resourceId = typedArray.getResourceId(i4, 0)) != 0 && (b5 = z.e.b(context, resourceId)) != null) {
            return b5;
        }
        return typedArray.getColorStateList(i4);
    }

    public static ColorStateList b(Context context, q3 q3Var, int i4) {
        int resourceId;
        ColorStateList b5;
        TypedArray typedArray = q3Var.f879b;
        if (typedArray.hasValue(i4) && (resourceId = typedArray.getResourceId(i4, 0)) != 0 && (b5 = z.e.b(context, resourceId)) != null) {
            return b5;
        }
        return q3Var.a(i4);
    }

    public static int c(Context context, TypedArray typedArray, int i4, int i5) {
        TypedValue typedValue = new TypedValue();
        if (typedArray.getValue(i4, typedValue) && typedValue.type == 2) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{typedValue.data});
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(0, i5);
            obtainStyledAttributes.recycle();
            return dimensionPixelSize;
        }
        return typedArray.getDimensionPixelSize(i4, i5);
    }

    public static Drawable d(Context context, TypedArray typedArray, int i4) {
        int resourceId;
        Drawable t02;
        if (typedArray.hasValue(i4) && (resourceId = typedArray.getResourceId(i4, 0)) != 0 && (t02 = com.google.common.collect.c.t0(context, resourceId)) != null) {
            return t02;
        }
        return typedArray.getDrawable(i4);
    }

    public static boolean e(Context context) {
        if (context.getResources().getConfiguration().fontScale >= 1.3f) {
            return true;
        }
        return false;
    }
}