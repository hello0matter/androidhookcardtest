package androidx.activity;

import android.window.BackEvent;
import androidx.annotation.DoNotInline;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f90a = new Object();

    @DoNotInline
    @NotNull
    public final BackEvent a(float f4, float f5, float f6, int i4) {
        return new BackEvent(f4, f5, f6, i4);
    }

    @DoNotInline
    public final float b(@NotNull BackEvent backEvent) {
        com.google.common.collect.c.F(backEvent, "backEvent");
        return backEvent.getProgress();
    }

    @DoNotInline
    public final int c(@NotNull BackEvent backEvent) {
        com.google.common.collect.c.F(backEvent, "backEvent");
        return backEvent.getSwipeEdge();
    }

    @DoNotInline
    public final float d(@NotNull BackEvent backEvent) {
        com.google.common.collect.c.F(backEvent, "backEvent");
        return backEvent.getTouchX();
    }

    @DoNotInline
    public final float e(@NotNull BackEvent backEvent) {
        com.google.common.collect.c.F(backEvent, "backEvent");
        return backEvent.getTouchY();
    }
}