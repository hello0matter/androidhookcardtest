package j2;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.util.Log;
import android.util.StateSet;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public static final int[] f5097a = {16842919};

    /* renamed from: b  reason: collision with root package name */
    public static final int[] f5098b = {16842908};

    /* renamed from: c  reason: collision with root package name */
    public static final int[] f5099c = {16842913, 16842919};

    /* renamed from: d  reason: collision with root package name */
    public static final int[] f5100d = {16842913};

    /* renamed from: e  reason: collision with root package name */
    public static final int[] f5101e = {16842910, 16842919};

    /* renamed from: f  reason: collision with root package name */
    public static final String f5102f = a.class.getSimpleName();

    public static ColorStateList a(ColorStateList colorStateList) {
        int[] iArr = f5098b;
        return new ColorStateList(new int[][]{f5100d, iArr, StateSet.NOTHING}, new int[]{b(colorStateList, f5099c), b(colorStateList, iArr), b(colorStateList, f5097a)});
    }

    public static int b(ColorStateList colorStateList, int[] iArr) {
        int i4;
        if (colorStateList != null) {
            i4 = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        } else {
            i4 = 0;
        }
        return b0.a.e(i4, Math.min(Color.alpha(i4) * 2, 255));
    }

    public static ColorStateList c(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (Build.VERSION.SDK_INT <= 27 && Color.alpha(colorStateList.getDefaultColor()) == 0 && Color.alpha(colorStateList.getColorForState(f5101e, 0)) != 0) {
                Log.w(f5102f, "Use a non-transparent color for the default color as it will be used to finish ripple animations.");
            }
            return colorStateList;
        }
        return ColorStateList.valueOf(0);
    }

    public static boolean d(int[] iArr) {
        boolean z4 = false;
        boolean z5 = false;
        for (int i4 : iArr) {
            if (i4 == 16842910) {
                z4 = true;
            } else if (i4 == 16842908 || i4 == 16842919 || i4 == 16843623) {
                z5 = true;
            }
        }
        if (!z4 || !z5) {
            return false;
        }
        return true;
    }
}