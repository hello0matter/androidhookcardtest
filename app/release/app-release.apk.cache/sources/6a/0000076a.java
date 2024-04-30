package i0;

import android.view.ViewGroup;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class p {
    @DoNotInline
    public static int a(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.getLayoutDirection();
    }

    @DoNotInline
    public static int b(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.getMarginEnd();
    }

    @DoNotInline
    public static int c(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.getMarginStart();
    }

    @DoNotInline
    public static boolean d(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.isMarginRelative();
    }

    @DoNotInline
    public static void e(ViewGroup.MarginLayoutParams marginLayoutParams, int i4) {
        marginLayoutParams.resolveLayoutDirection(i4);
    }

    @DoNotInline
    public static void f(ViewGroup.MarginLayoutParams marginLayoutParams, int i4) {
        marginLayoutParams.setLayoutDirection(i4);
    }

    @DoNotInline
    public static void g(ViewGroup.MarginLayoutParams marginLayoutParams, int i4) {
        marginLayoutParams.setMarginEnd(i4);
    }

    @DoNotInline
    public static void h(ViewGroup.MarginLayoutParams marginLayoutParams, int i4) {
        marginLayoutParams.setMarginStart(i4);
    }
}