package i0;

import android.view.Window;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public abstract class j1 {
    @DoNotInline
    public static void a(@NonNull Window window, boolean z4) {
        window.setDecorFitsSystemWindows(z4);
    }
}