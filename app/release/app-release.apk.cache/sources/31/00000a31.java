package x0;

import android.view.Choreographer;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class g {
    @DoNotInline
    public static void a(final Runnable runnable) {
        Choreographer.getInstance().postFrameCallback(new Choreographer.FrameCallback() { // from class: x0.f
            @Override // android.view.Choreographer.FrameCallback
            public final void doFrame(long j4) {
                runnable.run();
            }
        });
    }
}