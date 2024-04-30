package androidx.appcompat.widget;

import android.graphics.Insets;
import android.graphics.drawable.Drawable;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class n1 {
    @DoNotInline
    public static Insets a(Drawable drawable) {
        return drawable.getOpticalInsets();
    }
}