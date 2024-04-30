package b0;

import android.graphics.Paint;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class d {
    @DoNotInline
    public static boolean a(Paint paint, String str) {
        return paint.hasGlyph(str);
    }
}