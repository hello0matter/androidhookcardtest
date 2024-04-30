package androidx.appcompat.app;

import android.app.Activity;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.annotation.DoNotInline;
import java.util.Objects;

/* loaded from: classes.dex */
public abstract class x {
    @DoNotInline
    public static OnBackInvokedDispatcher a(Activity activity) {
        OnBackInvokedDispatcher onBackInvokedDispatcher;
        onBackInvokedDispatcher = activity.getOnBackInvokedDispatcher();
        return onBackInvokedDispatcher;
    }

    @DoNotInline
    public static OnBackInvokedCallback b(Object obj, f0 f0Var) {
        Objects.requireNonNull(f0Var);
        androidx.activity.r rVar = new androidx.activity.r(1, f0Var);
        androidx.activity.o.f(obj).registerOnBackInvokedCallback(1000000, rVar);
        return rVar;
    }

    @DoNotInline
    public static void c(Object obj, Object obj2) {
        androidx.activity.o.f(obj).unregisterOnBackInvokedCallback(androidx.activity.o.b(obj2));
    }
}