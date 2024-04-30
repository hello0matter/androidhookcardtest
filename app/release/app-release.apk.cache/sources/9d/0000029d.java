package androidx.lifecycle;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.EmptyList;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Landroidx/lifecycle/ProcessLifecycleInitializer;", "La1/b;", "Landroidx/lifecycle/q;", "<init>", "()V", "lifecycle-process_release"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes.dex */
public final class ProcessLifecycleInitializer implements a1.b {
    @Override // a1.b
    public final List a() {
        return EmptyList.f5181a;
    }

    @Override // a1.b
    public final Object b(Context context) {
        com.google.common.collect.c.F(context, "context");
        a1.a c4 = a1.a.c(context);
        com.google.common.collect.c.E(c4, "getInstance(context)");
        if (c4.f55b.contains(ProcessLifecycleInitializer.class)) {
            if (!n.f1910a.getAndSet(true)) {
                Context applicationContext = context.getApplicationContext();
                com.google.common.collect.c.D(applicationContext, "null cannot be cast to non-null type android.app.Application");
                ((Application) applicationContext).registerActivityLifecycleCallbacks(new m());
            }
            b0 b0Var = b0.f1883i;
            b0Var.getClass();
            b0Var.f1888e = new Handler();
            b0Var.f1889f.e(Lifecycle$Event.ON_CREATE);
            Context applicationContext2 = context.getApplicationContext();
            com.google.common.collect.c.D(applicationContext2, "null cannot be cast to non-null type android.app.Application");
            ((Application) applicationContext2).registerActivityLifecycleCallbacks(new z(b0Var));
            return b0Var;
        }
        throw new IllegalStateException("ProcessLifecycleInitializer cannot be initialized lazily.\n               Please ensure that you have:\n               <meta-data\n                   android:name='androidx.lifecycle.ProcessLifecycleInitializer'\n                   android:value='androidx.startup' />\n               under InitializationProvider in your AndroidManifest.xml".toString());
    }
}