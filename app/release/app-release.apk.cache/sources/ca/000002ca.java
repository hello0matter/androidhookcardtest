package androidx.lifecycle;

import android.app.Activity;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes.dex */
public final class y extends f {
    final /* synthetic */ b0 this$0;

    public y(b0 b0Var) {
        this.this$0 = b0Var;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostResumed(@NotNull Activity activity) {
        com.google.common.collect.c.F(activity, "activity");
        this.this$0.a();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostStarted(@NotNull Activity activity) {
        com.google.common.collect.c.F(activity, "activity");
        b0 b0Var = this.this$0;
        int i4 = b0Var.f1884a + 1;
        b0Var.f1884a = i4;
        if (i4 == 1 && b0Var.f1887d) {
            b0Var.f1889f.e(Lifecycle$Event.ON_START);
            b0Var.f1887d = false;
        }
    }
}