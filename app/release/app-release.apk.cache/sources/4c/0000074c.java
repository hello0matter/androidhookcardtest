package i0;

import android.graphics.Paint;
import android.view.Display;
import android.view.View;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public abstract class h0 {
    @DoNotInline
    public static int a() {
        return View.generateViewId();
    }

    @DoNotInline
    public static Display b(@NonNull View view) {
        return view.getDisplay();
    }

    @DoNotInline
    public static int c(View view) {
        return view.getLabelFor();
    }

    @DoNotInline
    public static int d(View view) {
        return view.getLayoutDirection();
    }

    @DoNotInline
    public static int e(View view) {
        return view.getPaddingEnd();
    }

    @DoNotInline
    public static int f(View view) {
        return view.getPaddingStart();
    }

    @DoNotInline
    public static boolean g(View view) {
        return view.isPaddingRelative();
    }

    @DoNotInline
    public static void h(View view, int i4) {
        view.setLabelFor(i4);
    }

    @DoNotInline
    public static void i(View view, Paint paint) {
        view.setLayerPaint(paint);
    }

    @DoNotInline
    public static void j(View view, int i4) {
        view.setLayoutDirection(i4);
    }

    @DoNotInline
    public static void k(View view, int i4, int i5, int i6, int i7) {
        view.setPaddingRelative(i4, i5, i6, i7);
    }
}