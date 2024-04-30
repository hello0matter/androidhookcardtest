package i0;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class g0 {
    @DoNotInline
    public static AccessibilityNodeProvider a(View view) {
        return view.getAccessibilityNodeProvider();
    }

    @DoNotInline
    public static boolean b(View view) {
        return view.getFitsSystemWindows();
    }

    @DoNotInline
    public static int c(View view) {
        return view.getImportantForAccessibility();
    }

    @DoNotInline
    public static int d(View view) {
        return view.getMinimumHeight();
    }

    @DoNotInline
    public static int e(View view) {
        return view.getMinimumWidth();
    }

    @DoNotInline
    public static ViewParent f(View view) {
        return view.getParentForAccessibility();
    }

    @DoNotInline
    public static int g(View view) {
        return view.getWindowSystemUiVisibility();
    }

    @DoNotInline
    public static boolean h(View view) {
        return view.hasOverlappingRendering();
    }

    @DoNotInline
    public static boolean i(View view) {
        return view.hasTransientState();
    }

    @DoNotInline
    public static boolean j(View view, int i4, Bundle bundle) {
        return view.performAccessibilityAction(i4, bundle);
    }

    @DoNotInline
    public static void k(View view) {
        view.postInvalidateOnAnimation();
    }

    @DoNotInline
    public static void l(View view, int i4, int i5, int i6, int i7) {
        view.postInvalidateOnAnimation(i4, i5, i6, i7);
    }

    @DoNotInline
    public static void m(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }

    @DoNotInline
    public static void n(View view, Runnable runnable, long j4) {
        view.postOnAnimationDelayed(runnable, j4);
    }

    @DoNotInline
    public static void o(ViewTreeObserver viewTreeObserver, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
    }

    @DoNotInline
    public static void p(View view) {
        view.requestFitSystemWindows();
    }

    @DoNotInline
    public static void q(View view, Drawable drawable) {
        view.setBackground(drawable);
    }

    @DoNotInline
    public static void r(View view, boolean z4) {
        view.setHasTransientState(z4);
    }

    @DoNotInline
    public static void s(View view, int i4) {
        view.setImportantForAccessibility(i4);
    }
}