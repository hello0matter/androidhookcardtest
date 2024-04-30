package androidx.transition;

import android.content.Context;
import android.util.AttributeSet;

/* loaded from: classes.dex */
public class AutoTransition extends TransitionSet {
    public AutoTransition() {
        L();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [androidx.transition.Transition, androidx.transition.ChangeBounds] */
    public final void L() {
        K(1);
        H(new Fade(2));
        ?? transition = new Transition();
        transition.f2339y = false;
        H(transition);
        H(new Fade(1));
    }

    public AutoTransition(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        L();
    }
}