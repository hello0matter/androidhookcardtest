package androidx.activity;

import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.annotation.DoNotInline;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes.dex */
public final class s {

    /* renamed from: a  reason: collision with root package name */
    public static final s f150a = new Object();

    @DoNotInline
    @NotNull
    public final OnBackInvokedCallback a(@NotNull e3.a aVar) {
        com.google.common.collect.c.F(aVar, "onBackInvoked");
        return new r(0, aVar);
    }

    @DoNotInline
    public final void b(@NotNull Object obj, int i4, @NotNull Object obj2) {
        com.google.common.collect.c.F(obj, "dispatcher");
        com.google.common.collect.c.F(obj2, "callback");
        ((OnBackInvokedDispatcher) obj).registerOnBackInvokedCallback(i4, (OnBackInvokedCallback) obj2);
    }

    @DoNotInline
    public final void c(@NotNull Object obj, @NotNull Object obj2) {
        com.google.common.collect.c.F(obj, "dispatcher");
        com.google.common.collect.c.F(obj2, "callback");
        ((OnBackInvokedDispatcher) obj).unregisterOnBackInvokedCallback((OnBackInvokedCallback) obj2);
    }
}