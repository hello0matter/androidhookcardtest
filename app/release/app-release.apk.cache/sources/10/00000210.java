package androidx.core.widget;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.DoNotInline;
import java.util.Locale;

/* loaded from: classes.dex */
public abstract class q {
    @DoNotInline
    public static Drawable[] a(TextView textView) {
        return textView.getCompoundDrawablesRelative();
    }

    @DoNotInline
    public static int b(View view) {
        return view.getLayoutDirection();
    }

    @DoNotInline
    public static int c(View view) {
        return view.getTextDirection();
    }

    @DoNotInline
    public static Locale d(TextView textView) {
        return textView.getTextLocale();
    }

    @DoNotInline
    public static void e(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        textView.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
    }

    @DoNotInline
    public static void f(TextView textView, int i4, int i5, int i6, int i7) {
        textView.setCompoundDrawablesRelativeWithIntrinsicBounds(i4, i5, i6, i7);
    }

    @DoNotInline
    public static void g(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
    }

    @DoNotInline
    public static void h(View view, int i4) {
        view.setTextDirection(i4);
    }
}