package c0;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.annotation.DoNotInline;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes.dex */
public abstract class b {
    @DoNotInline
    public static void a(Drawable drawable, Resources.Theme theme) {
        drawable.applyTheme(theme);
    }

    @DoNotInline
    public static boolean b(Drawable drawable) {
        return drawable.canApplyTheme();
    }

    @DoNotInline
    public static ColorFilter c(Drawable drawable) {
        return drawable.getColorFilter();
    }

    @DoNotInline
    public static void d(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        drawable.inflate(resources, xmlPullParser, attributeSet, theme);
    }

    @DoNotInline
    public static void e(Drawable drawable, float f4, float f5) {
        drawable.setHotspot(f4, f5);
    }

    @DoNotInline
    public static void f(Drawable drawable, int i4, int i5, int i6, int i7) {
        drawable.setHotspotBounds(i4, i5, i6, i7);
    }

    @DoNotInline
    public static void g(Drawable drawable, int i4) {
        drawable.setTint(i4);
    }

    @DoNotInline
    public static void h(Drawable drawable, ColorStateList colorStateList) {
        drawable.setTintList(colorStateList);
    }

    @DoNotInline
    public static void i(Drawable drawable, PorterDuff.Mode mode) {
        drawable.setTintMode(mode);
    }
}