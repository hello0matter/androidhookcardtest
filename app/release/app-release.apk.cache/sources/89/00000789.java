package i0;

import android.view.ViewConfiguration;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class z0 {
    @DoNotInline
    public static float a(ViewConfiguration viewConfiguration) {
        return viewConfiguration.getScaledHorizontalScrollFactor();
    }

    @DoNotInline
    public static float b(ViewConfiguration viewConfiguration) {
        return viewConfiguration.getScaledVerticalScrollFactor();
    }
}