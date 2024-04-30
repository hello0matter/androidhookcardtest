package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import androidx.annotation.DoNotInline;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes.dex */
public abstract class x {
    @JvmStatic
    @DoNotInline
    public static final void a(@NotNull Activity activity, @NotNull Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        com.google.common.collect.c.F(activity, "activity");
        com.google.common.collect.c.F(activityLifecycleCallbacks, "callback");
        activity.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
    }
}