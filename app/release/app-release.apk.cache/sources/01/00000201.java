package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.widget.CompoundButton;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class b {
    @DoNotInline
    public static ColorStateList a(CompoundButton compoundButton) {
        return compoundButton.getButtonTintList();
    }

    @DoNotInline
    public static PorterDuff.Mode b(CompoundButton compoundButton) {
        return compoundButton.getButtonTintMode();
    }

    @DoNotInline
    public static void c(CompoundButton compoundButton, ColorStateList colorStateList) {
        compoundButton.setButtonTintList(colorStateList);
    }

    @DoNotInline
    public static void d(CompoundButton compoundButton, PorterDuff.Mode mode) {
        compoundButton.setButtonTintMode(mode);
    }
}