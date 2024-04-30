package i0;

import android.view.View;
import android.view.Window;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public abstract class i1 {
    @DoNotInline
    public static void a(@NonNull Window window, boolean z4) {
        int i4;
        View decorView = window.getDecorView();
        int systemUiVisibility = decorView.getSystemUiVisibility();
        if (z4) {
            i4 = systemUiVisibility & (-1793);
        } else {
            i4 = systemUiVisibility | 1792;
        }
        decorView.setSystemUiVisibility(i4);
    }
}