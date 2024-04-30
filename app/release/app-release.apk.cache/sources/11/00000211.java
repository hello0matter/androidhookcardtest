package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.widget.TextView;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class r {
    @DoNotInline
    public static int a(TextView textView) {
        return textView.getBreakStrategy();
    }

    @DoNotInline
    public static ColorStateList b(TextView textView) {
        return textView.getCompoundDrawableTintList();
    }

    @DoNotInline
    public static PorterDuff.Mode c(TextView textView) {
        return textView.getCompoundDrawableTintMode();
    }

    @DoNotInline
    public static int d(TextView textView) {
        return textView.getHyphenationFrequency();
    }

    @DoNotInline
    public static void e(TextView textView, int i4) {
        textView.setBreakStrategy(i4);
    }

    @DoNotInline
    public static void f(TextView textView, ColorStateList colorStateList) {
        textView.setCompoundDrawableTintList(colorStateList);
    }

    @DoNotInline
    public static void g(TextView textView, PorterDuff.Mode mode) {
        textView.setCompoundDrawableTintMode(mode);
    }

    @DoNotInline
    public static void h(TextView textView, int i4) {
        textView.setHyphenationFrequency(i4);
    }
}