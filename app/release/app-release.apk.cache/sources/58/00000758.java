package i0;

import android.view.View;
import android.view.WindowInsets;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class k0 {
    @DoNotInline
    public static WindowInsets a(View view, WindowInsets windowInsets) {
        return view.dispatchApplyWindowInsets(windowInsets);
    }

    @DoNotInline
    public static WindowInsets b(View view, WindowInsets windowInsets) {
        return view.onApplyWindowInsets(windowInsets);
    }

    @DoNotInline
    public static void c(View view) {
        view.requestApplyInsets();
    }
}