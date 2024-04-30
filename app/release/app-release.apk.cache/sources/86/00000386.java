package c0;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.InsetDrawable;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class a {
    @DoNotInline
    public static int a(Drawable drawable) {
        return drawable.getAlpha();
    }

    @DoNotInline
    public static Drawable b(DrawableContainer.DrawableContainerState drawableContainerState, int i4) {
        return drawableContainerState.getChild(i4);
    }

    @DoNotInline
    public static Drawable c(InsetDrawable insetDrawable) {
        return insetDrawable.getDrawable();
    }

    @DoNotInline
    public static boolean d(Drawable drawable) {
        return drawable.isAutoMirrored();
    }

    @DoNotInline
    public static void e(Drawable drawable, boolean z4) {
        drawable.setAutoMirrored(z4);
    }
}