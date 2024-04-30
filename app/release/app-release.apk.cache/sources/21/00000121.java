package androidx.appcompat.widget;

import android.graphics.Rect;
import android.widget.PopupWindow;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class b2 {
    @DoNotInline
    public static void a(PopupWindow popupWindow, Rect rect) {
        popupWindow.setEpicenterBounds(rect);
    }

    @DoNotInline
    public static void b(PopupWindow popupWindow, boolean z4) {
        popupWindow.setIsClippedToScreen(z4);
    }
}