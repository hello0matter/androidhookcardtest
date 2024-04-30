package i0;

import android.view.View;
import android.view.WindowInsets;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public abstract class n0 {
    @Nullable
    public static g2 a(@NonNull View view) {
        WindowInsets rootWindowInsets = view.getRootWindowInsets();
        if (rootWindowInsets == null) {
            return null;
        }
        g2 h4 = g2.h(null, rootWindowInsets);
        d2 d2Var = h4.f4931a;
        d2Var.p(h4);
        d2Var.d(view.getRootView());
        return h4;
    }

    @DoNotInline
    public static int b(@NonNull View view) {
        return view.getScrollIndicators();
    }

    @DoNotInline
    public static void c(@NonNull View view, int i4) {
        view.setScrollIndicators(i4);
    }

    @DoNotInline
    public static void d(@NonNull View view, int i4, int i5) {
        view.setScrollIndicators(i4, i5);
    }
}