package a0;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class k {
    @DoNotInline
    public static Drawable a(Resources resources, int i4, Resources.Theme theme) {
        return resources.getDrawable(i4, theme);
    }

    @DoNotInline
    public static Drawable b(Resources resources, int i4, int i5, Resources.Theme theme) {
        return resources.getDrawableForDensity(i4, i5, theme);
    }
}