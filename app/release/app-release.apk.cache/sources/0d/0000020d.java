package androidx.core.widget;

import android.view.View;
import android.widget.PopupWindow;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class n {
    @DoNotInline
    public static void a(PopupWindow popupWindow, View view, int i4, int i5, int i6) {
        popupWindow.showAsDropDown(view, i4, i5, i6);
    }
}