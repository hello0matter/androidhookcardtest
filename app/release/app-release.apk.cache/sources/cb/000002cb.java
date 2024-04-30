package androidx.lifecycle;

import android.app.Activity;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.RequiresApi;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes.dex */
public final class z extends f {
    final /* synthetic */ b0 this$0;

    public z(b0 b0Var) {
        this.this$0 = b0Var;
    }

    @Override // androidx.lifecycle.f, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(@NotNull Activity activity, @Nullable Bundle bundle) {
        com.google.common.collect.c.F(activity, "activity");
        if (Build.VERSION.SDK_INT < 29) {
            int i4 = ReportFragment.f1872b;
            Fragment findFragmentByTag = activity.getFragmentManager().findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag");
            com.google.common.collect.c.D(findFragmentByTag, "null cannot be cast to non-null type androidx.lifecycle.ReportFragment");
            ((ReportFragment) findFragmentByTag).f1873a = this.this$0.f1891h;
        }
    }

    @Override // androidx.lifecycle.f, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(@NotNull Activity activity) {
        com.google.common.collect.c.F(activity, "activity");
        b0 b0Var = this.this$0;
        int i4 = b0Var.f1885b - 1;
        b0Var.f1885b = i4;
        if (i4 == 0) {
            Handler handler = b0Var.f1888e;
            com.google.common.collect.c.C(handler);
            handler.postDelayed(b0Var.f1890g, 700L);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    @RequiresApi(29)
    public void onActivityPreCreated(@NotNull Activity activity, @Nullable Bundle bundle) {
        com.google.common.collect.c.F(activity, "activity");
        x.a(activity, new y(this.this$0));
    }

    @Override // androidx.lifecycle.f, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(@NotNull Activity activity) {
        com.google.common.collect.c.F(activity, "activity");
        b0 b0Var = this.this$0;
        int i4 = b0Var.f1884a - 1;
        b0Var.f1884a = i4;
        if (i4 == 0 && b0Var.f1886c) {
            b0Var.f1889f.e(Lifecycle$Event.ON_STOP);
            b0Var.f1887d = true;
        }
    }
}