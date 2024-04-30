package c0;

import android.graphics.drawable.Drawable;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class c {
    @DoNotInline
    public static int a(Drawable drawable) {
        return drawable.getLayoutDirection();
    }

    @DoNotInline
    public static boolean b(Drawable drawable, int i4) {
        return drawable.setLayoutDirection(i4);
    }
}