package i0;

import android.view.View;
import android.view.ViewParent;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class d1 {
    @DoNotInline
    public static boolean a(ViewParent viewParent, View view, float f4, float f5, boolean z4) {
        return viewParent.onNestedFling(view, f4, f5, z4);
    }

    @DoNotInline
    public static boolean b(ViewParent viewParent, View view, float f4, float f5) {
        return viewParent.onNestedPreFling(view, f4, f5);
    }

    @DoNotInline
    public static void c(ViewParent viewParent, View view, int i4, int i5, int[] iArr) {
        viewParent.onNestedPreScroll(view, i4, i5, iArr);
    }

    @DoNotInline
    public static void d(ViewParent viewParent, View view, int i4, int i5, int i6, int i7) {
        viewParent.onNestedScroll(view, i4, i5, i6, i7);
    }

    @DoNotInline
    public static void e(ViewParent viewParent, View view, View view2, int i4) {
        viewParent.onNestedScrollAccepted(view, view2, i4);
    }

    @DoNotInline
    public static boolean f(ViewParent viewParent, View view, View view2, int i4) {
        return viewParent.onStartNestedScroll(view, view2, i4);
    }

    @DoNotInline
    public static void g(ViewParent viewParent, View view) {
        viewParent.onStopNestedScroll(view);
    }
}