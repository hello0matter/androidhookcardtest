package androidx.lifecycle;

import androidx.annotation.VisibleForTesting;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0001\u0018\u0000 \u00032\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"androidx/lifecycle/Lifecycle$Event", "", "Landroidx/lifecycle/Lifecycle$Event;", "Companion", "androidx/lifecycle/j", "ON_CREATE", "ON_START", "ON_RESUME", "ON_PAUSE", "ON_STOP", "ON_DESTROY", "ON_ANY", "lifecycle-common"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes.dex */
public final class Lifecycle$Event {
    private static final /* synthetic */ Lifecycle$Event[] $VALUES;
    @NotNull
    public static final j Companion;
    public static final Lifecycle$Event ON_ANY;
    public static final Lifecycle$Event ON_CREATE;
    public static final Lifecycle$Event ON_DESTROY;
    public static final Lifecycle$Event ON_PAUSE;
    public static final Lifecycle$Event ON_RESUME;
    public static final Lifecycle$Event ON_START;
    public static final Lifecycle$Event ON_STOP;

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Enum, androidx.lifecycle.Lifecycle$Event] */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, androidx.lifecycle.j] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Enum, androidx.lifecycle.Lifecycle$Event] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Enum, androidx.lifecycle.Lifecycle$Event] */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.Enum, androidx.lifecycle.Lifecycle$Event] */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.Enum, androidx.lifecycle.Lifecycle$Event] */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.lang.Enum, androidx.lifecycle.Lifecycle$Event] */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.lang.Enum, androidx.lifecycle.Lifecycle$Event] */
    static {
        ?? r02 = new Enum("ON_CREATE", 0);
        ON_CREATE = r02;
        ?? r12 = new Enum("ON_START", 1);
        ON_START = r12;
        ?? r22 = new Enum("ON_RESUME", 2);
        ON_RESUME = r22;
        ?? r32 = new Enum("ON_PAUSE", 3);
        ON_PAUSE = r32;
        ?? r4 = new Enum("ON_STOP", 4);
        ON_STOP = r4;
        ?? r5 = new Enum("ON_DESTROY", 5);
        ON_DESTROY = r5;
        ?? r6 = new Enum("ON_ANY", 6);
        ON_ANY = r6;
        $VALUES = new Lifecycle$Event[]{r02, r12, r22, r32, r4, r5, r6};
        Companion = new Object();
    }

    public static Lifecycle$Event valueOf(String str) {
        return (Lifecycle$Event) Enum.valueOf(Lifecycle$Event.class, str);
    }

    public static Lifecycle$Event[] values() {
        return (Lifecycle$Event[]) $VALUES.clone();
    }

    public final Lifecycle$State a() {
        switch (k.f1908a[ordinal()]) {
            case 1:
            case 2:
                return Lifecycle$State.f1866c;
            case VisibleForTesting.PACKAGE_PRIVATE /* 3 */:
            case VisibleForTesting.PROTECTED /* 4 */:
                return Lifecycle$State.f1867d;
            case VisibleForTesting.NONE /* 5 */:
                return Lifecycle$State.f1868e;
            case 6:
                return Lifecycle$State.f1864a;
            default:
                throw new IllegalArgumentException(this + " has no target state");
        }
    }
}