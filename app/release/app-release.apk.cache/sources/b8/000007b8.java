package k0;

import android.graphics.Path;
import android.view.animation.PathInterpolator;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class a {
    @DoNotInline
    public static PathInterpolator a(float f4, float f5) {
        return new PathInterpolator(f4, f5);
    }

    @DoNotInline
    public static PathInterpolator b(float f4, float f5, float f6, float f7) {
        return new PathInterpolator(f4, f5, f6, f7);
    }

    @DoNotInline
    public static PathInterpolator c(Path path) {
        return new PathInterpolator(path);
    }
}