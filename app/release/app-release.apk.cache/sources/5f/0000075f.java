package i0;

import android.graphics.Rect;
import android.view.Gravity;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class m {
    @DoNotInline
    public static void a(int i4, int i5, int i6, Rect rect, int i7, int i8, Rect rect2, int i9) {
        Gravity.apply(i4, i5, i6, rect, i7, i8, rect2, i9);
    }

    @DoNotInline
    public static void b(int i4, int i5, int i6, Rect rect, Rect rect2, int i7) {
        Gravity.apply(i4, i5, i6, rect, rect2, i7);
    }

    @DoNotInline
    public static void c(int i4, Rect rect, Rect rect2, int i5) {
        Gravity.applyDisplay(i4, rect, rect2, i5);
    }
}