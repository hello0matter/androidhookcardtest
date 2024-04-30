package i0;

import android.graphics.Rect;
import android.view.DisplayCutout;
import androidx.annotation.DoNotInline;
import java.util.List;

/* loaded from: classes.dex */
public abstract class k {
    @DoNotInline
    public static DisplayCutout a(Rect rect, List<Rect> list) {
        return new DisplayCutout(rect, list);
    }

    @DoNotInline
    public static List<Rect> b(DisplayCutout displayCutout) {
        return displayCutout.getBoundingRects();
    }

    @DoNotInline
    public static int c(DisplayCutout displayCutout) {
        return displayCutout.getSafeInsetBottom();
    }

    @DoNotInline
    public static int d(DisplayCutout displayCutout) {
        return displayCutout.getSafeInsetLeft();
    }

    @DoNotInline
    public static int e(DisplayCutout displayCutout) {
        return displayCutout.getSafeInsetRight();
    }

    @DoNotInline
    public static int f(DisplayCutout displayCutout) {
        return displayCutout.getSafeInsetTop();
    }
}