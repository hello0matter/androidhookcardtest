package androidx.transition;

import android.content.Context;
import android.graphics.Path;
import android.util.AttributeSet;

/* loaded from: classes.dex */
public abstract class PathMotion {
    public PathMotion(Context context, AttributeSet attributeSet) {
    }

    public abstract Path a(float f4, float f5, float f6, float f7);
}