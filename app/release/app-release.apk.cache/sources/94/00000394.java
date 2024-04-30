package c1;

import android.graphics.Path;
import androidx.transition.PathMotion;

/* loaded from: classes.dex */
public final class d0 extends PathMotion {
    @Override // androidx.transition.PathMotion
    public final Path a(float f4, float f5, float f6, float f7) {
        Path path = new Path();
        path.moveTo(f4, f5);
        path.lineTo(f6, f7);
        return path;
    }
}