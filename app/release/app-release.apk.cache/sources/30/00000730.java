package i0;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.view.PointerIcon;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class a0 {
    @DoNotInline
    public static PointerIcon a(Bitmap bitmap, float f4, float f5) {
        return PointerIcon.create(bitmap, f4, f5);
    }

    @DoNotInline
    public static PointerIcon b(Context context, int i4) {
        return PointerIcon.getSystemIcon(context, i4);
    }

    @DoNotInline
    public static PointerIcon c(Resources resources, int i4) {
        return PointerIcon.load(resources, i4);
    }
}