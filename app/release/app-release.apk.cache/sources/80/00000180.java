package androidx.appcompat.widget;

import android.view.View;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Objects;

/* loaded from: classes.dex */
public abstract class t3 {
    @Nullable
    @DoNotInline
    public static OnBackInvokedDispatcher a(@NonNull View view) {
        return view.findOnBackInvokedDispatcher();
    }

    @NonNull
    @DoNotInline
    public static OnBackInvokedCallback b(@NonNull Runnable runnable) {
        Objects.requireNonNull(runnable);
        return new androidx.activity.r(2, runnable);
    }

    @DoNotInline
    public static void c(@NonNull Object obj, @NonNull Object obj2) {
        ((OnBackInvokedDispatcher) obj).registerOnBackInvokedCallback(1000000, (OnBackInvokedCallback) obj2);
    }

    @DoNotInline
    public static void d(@NonNull Object obj, @NonNull Object obj2) {
        ((OnBackInvokedDispatcher) obj).unregisterOnBackInvokedCallback((OnBackInvokedCallback) obj2);
    }
}