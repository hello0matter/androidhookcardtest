package i0;

import android.view.View;
import android.view.WindowInsetsController;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public abstract class t0 {
    @DoNotInline
    public static CharSequence a(View view) {
        return view.getStateDescription();
    }

    @Nullable
    public static n2 b(@NonNull View view) {
        WindowInsetsController windowInsetsController = view.getWindowInsetsController();
        if (windowInsetsController != null) {
            return new n2(windowInsetsController);
        }
        return null;
    }

    @DoNotInline
    public static void c(View view, CharSequence charSequence) {
        view.setStateDescription(charSequence);
    }
}