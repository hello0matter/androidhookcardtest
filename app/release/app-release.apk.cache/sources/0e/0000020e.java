package androidx.core.widget;

import android.widget.PopupWindow;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class o {
    @DoNotInline
    public static boolean a(PopupWindow popupWindow) {
        return popupWindow.getOverlapAnchor();
    }

    @DoNotInline
    public static int b(PopupWindow popupWindow) {
        return popupWindow.getWindowLayoutType();
    }

    @DoNotInline
    public static void c(PopupWindow popupWindow, boolean z4) {
        popupWindow.setOverlapAnchor(z4);
    }

    @DoNotInline
    public static void d(PopupWindow popupWindow, int i4) {
        popupWindow.setWindowLayoutType(i4);
    }
}