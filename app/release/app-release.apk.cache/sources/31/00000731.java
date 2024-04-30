package i0;

import android.view.ViewConfiguration;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class a1 {
    @DoNotInline
    public static int a(ViewConfiguration viewConfiguration) {
        return viewConfiguration.getScaledHoverSlop();
    }

    @DoNotInline
    public static boolean b(ViewConfiguration viewConfiguration) {
        return viewConfiguration.shouldShowMenuShortcutsWhenKeyboardPresent();
    }
}