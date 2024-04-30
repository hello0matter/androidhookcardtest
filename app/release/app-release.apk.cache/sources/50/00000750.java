package i0;

import android.graphics.Rect;
import android.view.View;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public abstract class i0 {
    @DoNotInline
    public static Rect a(@NonNull View view) {
        return view.getClipBounds();
    }

    @DoNotInline
    public static boolean b(@NonNull View view) {
        return view.isInLayout();
    }

    @DoNotInline
    public static void c(@NonNull View view, Rect rect) {
        view.setClipBounds(rect);
    }
}