package androidx.core.widget;

import android.widget.EdgeEffect;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class e {
    @DoNotInline
    public static void a(EdgeEffect edgeEffect, float f4, float f5) {
        edgeEffect.onPull(f4, f5);
    }
}