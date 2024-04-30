package androidx.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EdgeEffect;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class f {
    @DoNotInline
    public static EdgeEffect a(Context context, AttributeSet attributeSet) {
        try {
            return new EdgeEffect(context, attributeSet);
        } catch (Throwable unused) {
            return new EdgeEffect(context);
        }
    }

    @DoNotInline
    public static float b(EdgeEffect edgeEffect) {
        try {
            return edgeEffect.getDistance();
        } catch (Throwable unused) {
            return 0.0f;
        }
    }

    @DoNotInline
    public static float c(EdgeEffect edgeEffect, float f4, float f5) {
        try {
            return edgeEffect.onPullDistance(f4, f5);
        } catch (Throwable unused) {
            edgeEffect.onPull(f4, f5);
            return 0.0f;
        }
    }
}