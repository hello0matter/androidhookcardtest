package androidx.appcompat.widget;

import android.widget.PopupWindow;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class h2 {
    @DoNotInline
    public static void a(PopupWindow popupWindow, boolean z4) {
        popupWindow.setTouchModal(z4);
    }
}