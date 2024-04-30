package a2;

import android.content.res.ColorStateList;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import java.util.Arrays;

/* loaded from: classes.dex */
public abstract class b {
    public static Drawable a(Drawable drawable, Drawable drawable2, int i4, int i5) {
        if (drawable == null) {
            return drawable2;
        }
        if (drawable2 == null) {
            return drawable;
        }
        if (i4 == -1 && (i4 = drawable2.getIntrinsicWidth()) == -1) {
            i4 = drawable.getIntrinsicWidth();
        }
        if (i5 == -1 && (i5 = drawable2.getIntrinsicHeight()) == -1) {
            i5 = drawable.getIntrinsicHeight();
        }
        if (i4 > drawable.getIntrinsicWidth() || i5 > drawable.getIntrinsicHeight()) {
            float f4 = i4 / i5;
            if (f4 >= drawable.getIntrinsicWidth() / drawable.getIntrinsicHeight()) {
                int intrinsicWidth = drawable.getIntrinsicWidth();
                i5 = (int) (intrinsicWidth / f4);
                i4 = intrinsicWidth;
            } else {
                i5 = drawable.getIntrinsicHeight();
                i4 = (int) (f4 * i5);
            }
        }
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{drawable, drawable2});
        layerDrawable.setLayerSize(1, i4, i5);
        layerDrawable.setLayerGravity(1, 17);
        return layerDrawable;
    }

    public static Drawable b(Drawable drawable, ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (drawable == null) {
            return null;
        }
        if (colorStateList != null) {
            drawable = drawable.mutate();
            if (mode != null) {
                c0.b.i(drawable, mode);
            }
        }
        return drawable;
    }

    public static int[] c(int[] iArr) {
        for (int i4 = 0; i4 < iArr.length; i4++) {
            int i5 = iArr[i4];
            if (i5 == 16842912) {
                return iArr;
            }
            if (i5 == 0) {
                int[] iArr2 = (int[]) iArr.clone();
                iArr2[i4] = 16842912;
                return iArr2;
            }
        }
        int[] copyOf = Arrays.copyOf(iArr, iArr.length + 1);
        copyOf[iArr.length] = 16842912;
        return copyOf;
    }

    public static void d(Outline outline, Path path) {
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 30) {
            outline.setPath(path);
        } else if (i4 >= 29) {
            try {
                outline.setConvexPath(path);
            } catch (IllegalArgumentException unused) {
            }
        } else if (path.isConvex()) {
            outline.setConvexPath(path);
        }
    }
}