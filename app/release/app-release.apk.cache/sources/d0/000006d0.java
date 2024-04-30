package g;

import android.graphics.Point;
import android.view.Display;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class a0 {
    @DoNotInline
    public static void a(Display display, Point point) {
        display.getRealSize(point);
    }
}