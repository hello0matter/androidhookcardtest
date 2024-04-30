package i0;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.view.MenuItem;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class q {
    @DoNotInline
    public static int a(MenuItem menuItem) {
        return menuItem.getAlphabeticModifiers();
    }

    @DoNotInline
    public static CharSequence b(MenuItem menuItem) {
        return menuItem.getContentDescription();
    }

    @DoNotInline
    public static ColorStateList c(MenuItem menuItem) {
        return menuItem.getIconTintList();
    }

    @DoNotInline
    public static PorterDuff.Mode d(MenuItem menuItem) {
        return menuItem.getIconTintMode();
    }

    @DoNotInline
    public static int e(MenuItem menuItem) {
        return menuItem.getNumericModifiers();
    }

    @DoNotInline
    public static CharSequence f(MenuItem menuItem) {
        return menuItem.getTooltipText();
    }

    @DoNotInline
    public static MenuItem g(MenuItem menuItem, char c4, int i4) {
        return menuItem.setAlphabeticShortcut(c4, i4);
    }

    @DoNotInline
    public static MenuItem h(MenuItem menuItem, CharSequence charSequence) {
        return menuItem.setContentDescription(charSequence);
    }

    @DoNotInline
    public static MenuItem i(MenuItem menuItem, ColorStateList colorStateList) {
        return menuItem.setIconTintList(colorStateList);
    }

    @DoNotInline
    public static MenuItem j(MenuItem menuItem, PorterDuff.Mode mode) {
        return menuItem.setIconTintMode(mode);
    }

    @DoNotInline
    public static MenuItem k(MenuItem menuItem, char c4, int i4) {
        return menuItem.setNumericShortcut(c4, i4);
    }

    @DoNotInline
    public static MenuItem l(MenuItem menuItem, char c4, char c5, int i4, int i5) {
        return menuItem.setShortcut(c4, c5, i4, i5);
    }

    @DoNotInline
    public static MenuItem m(MenuItem menuItem, CharSequence charSequence) {
        return menuItem.setTooltipText(charSequence);
    }
}