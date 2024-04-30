package androidx.lifecycle;

import android.app.Activity;
import android.os.Bundle;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes.dex */
public final class m extends f {
    @Override // androidx.lifecycle.f, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(@NotNull Activity activity, @Nullable Bundle bundle) {
        com.google.common.collect.c.F(activity, "activity");
        int i4 = ReportFragment.f1872b;
        l2.f.k(activity);
    }
}