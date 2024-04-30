package i0;

import android.view.ViewGroup;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class c1 {
    @DoNotInline
    public static int a(ViewGroup viewGroup) {
        return viewGroup.getNestedScrollAxes();
    }

    @DoNotInline
    public static boolean b(ViewGroup viewGroup) {
        return viewGroup.isTransitionGroup();
    }

    @DoNotInline
    public static void c(ViewGroup viewGroup, boolean z4) {
        viewGroup.setTransitionGroup(z4);
    }
}