package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes.dex */
public final class d0 implements Application.ActivityLifecycleCallbacks {
    @NotNull
    public static final c0 Companion = new Object();

    @JvmStatic
    public static final void registerIn(@NotNull Activity activity) {
        Companion.getClass();
        com.google.common.collect.c.F(activity, "activity");
        activity.registerActivityLifecycleCallbacks(new d0());
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(@NotNull Activity activity, @Nullable Bundle bundle) {
        com.google.common.collect.c.F(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(@NotNull Activity activity) {
        com.google.common.collect.c.F(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(@NotNull Activity activity) {
        com.google.common.collect.c.F(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostCreated(@NotNull Activity activity, @Nullable Bundle bundle) {
        com.google.common.collect.c.F(activity, "activity");
        int i4 = ReportFragment.f1872b;
        l2.f.d(activity, Lifecycle$Event.ON_CREATE);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostResumed(@NotNull Activity activity) {
        com.google.common.collect.c.F(activity, "activity");
        int i4 = ReportFragment.f1872b;
        l2.f.d(activity, Lifecycle$Event.ON_RESUME);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostStarted(@NotNull Activity activity) {
        com.google.common.collect.c.F(activity, "activity");
        int i4 = ReportFragment.f1872b;
        l2.f.d(activity, Lifecycle$Event.ON_START);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreDestroyed(@NotNull Activity activity) {
        com.google.common.collect.c.F(activity, "activity");
        int i4 = ReportFragment.f1872b;
        l2.f.d(activity, Lifecycle$Event.ON_DESTROY);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPrePaused(@NotNull Activity activity) {
        com.google.common.collect.c.F(activity, "activity");
        int i4 = ReportFragment.f1872b;
        l2.f.d(activity, Lifecycle$Event.ON_PAUSE);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreStopped(@NotNull Activity activity) {
        com.google.common.collect.c.F(activity, "activity");
        int i4 = ReportFragment.f1872b;
        l2.f.d(activity, Lifecycle$Event.ON_STOP);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(@NotNull Activity activity) {
        com.google.common.collect.c.F(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(@NotNull Activity activity, @NotNull Bundle bundle) {
        com.google.common.collect.c.F(activity, "activity");
        com.google.common.collect.c.F(bundle, "bundle");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(@NotNull Activity activity) {
        com.google.common.collect.c.F(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(@NotNull Activity activity) {
        com.google.common.collect.c.F(activity, "activity");
    }
}