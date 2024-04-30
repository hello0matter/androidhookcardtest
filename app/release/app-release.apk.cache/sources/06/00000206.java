package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.widget.ImageView;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class g {
    @DoNotInline
    public static ColorStateList a(ImageView imageView) {
        return imageView.getImageTintList();
    }

    @DoNotInline
    public static PorterDuff.Mode b(ImageView imageView) {
        return imageView.getImageTintMode();
    }

    @DoNotInline
    public static void c(ImageView imageView, ColorStateList colorStateList) {
        imageView.setImageTintList(colorStateList);
    }

    @DoNotInline
    public static void d(ImageView imageView, PorterDuff.Mode mode) {
        imageView.setImageTintMode(mode);
    }
}