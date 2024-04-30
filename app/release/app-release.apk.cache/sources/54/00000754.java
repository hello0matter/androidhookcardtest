package i0;

import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public abstract class j0 {
    @DoNotInline
    public static int a(View view) {
        return view.getAccessibilityLiveRegion();
    }

    @DoNotInline
    public static boolean b(@NonNull View view) {
        return view.isAttachedToWindow();
    }

    @DoNotInline
    public static boolean c(@NonNull View view) {
        return view.isLaidOut();
    }

    @DoNotInline
    public static boolean d(@NonNull View view) {
        return view.isLayoutDirectionResolved();
    }

    @DoNotInline
    public static void e(ViewParent viewParent, View view, View view2, int i4) {
        viewParent.notifySubtreeAccessibilityStateChanged(view, view2, i4);
    }

    @DoNotInline
    public static void f(View view, int i4) {
        view.setAccessibilityLiveRegion(i4);
    }

    @DoNotInline
    public static void g(AccessibilityEvent accessibilityEvent, int i4) {
        accessibilityEvent.setContentChangeTypes(i4);
    }
}