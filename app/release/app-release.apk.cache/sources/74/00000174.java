package androidx.appcompat.widget;

import android.widget.AbsListView;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class r1 {
    @DoNotInline
    public static boolean a(AbsListView absListView) {
        return absListView.isSelectedChildViewEnabled();
    }

    @DoNotInline
    public static void b(AbsListView absListView, boolean z4) {
        absListView.setSelectedChildViewEnabled(z4);
    }
}