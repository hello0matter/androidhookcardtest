package androidx.activity;

import android.window.OnBackInvokedCallback;
import androidx.annotation.DoNotInline;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes.dex */
public final class u {

    /* renamed from: a  reason: collision with root package name */
    public static final u f155a = new Object();

    @DoNotInline
    @NotNull
    public final OnBackInvokedCallback a(@NotNull e3.l lVar, @NotNull e3.l lVar2, @NotNull e3.a aVar, @NotNull e3.a aVar2) {
        com.google.common.collect.c.F(lVar, "onBackStarted");
        com.google.common.collect.c.F(lVar2, "onBackProgressed");
        com.google.common.collect.c.F(aVar, "onBackInvoked");
        com.google.common.collect.c.F(aVar2, "onBackCancelled");
        return new t(lVar, lVar2, aVar, aVar2);
    }
}