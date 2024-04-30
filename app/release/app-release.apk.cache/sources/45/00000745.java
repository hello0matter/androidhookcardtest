package i0;

import android.animation.ValueAnimator;
import android.view.ViewPropertyAnimator;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class f1 {
    @DoNotInline
    public static ViewPropertyAnimator a(ViewPropertyAnimator viewPropertyAnimator, ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        return viewPropertyAnimator.setUpdateListener(animatorUpdateListener);
    }
}