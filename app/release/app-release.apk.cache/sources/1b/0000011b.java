package androidx.appcompat.widget;

import android.view.View;
import android.widget.PopupWindow;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class a2 {
    @DoNotInline
    public static int a(PopupWindow popupWindow, View view, int i4, boolean z4) {
        return popupWindow.getMaxAvailableHeight(view, i4, z4);
    }
}