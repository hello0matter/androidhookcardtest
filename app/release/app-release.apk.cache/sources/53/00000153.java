package androidx.appcompat.widget;

import android.animation.ObjectAnimator;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class k3 {
    @DoNotInline
    public static void a(ObjectAnimator objectAnimator, boolean z4) {
        objectAnimator.setAutoCancel(z4);
    }
}