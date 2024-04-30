package androidx.lifecycle;

import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"androidx/lifecycle/Lifecycle$State", "", "Landroidx/lifecycle/Lifecycle$State;", "lifecycle-common"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes.dex */
public final class Lifecycle$State {

    /* renamed from: a  reason: collision with root package name */
    public static final Lifecycle$State f1864a;

    /* renamed from: b  reason: collision with root package name */
    public static final Lifecycle$State f1865b;

    /* renamed from: c  reason: collision with root package name */
    public static final Lifecycle$State f1866c;

    /* renamed from: d  reason: collision with root package name */
    public static final Lifecycle$State f1867d;

    /* renamed from: e  reason: collision with root package name */
    public static final Lifecycle$State f1868e;

    /* renamed from: f  reason: collision with root package name */
    public static final /* synthetic */ Lifecycle$State[] f1869f;

    /* JADX WARN: Type inference failed for: r0v0, types: [androidx.lifecycle.Lifecycle$State, java.lang.Enum] */
    /* JADX WARN: Type inference failed for: r1v1, types: [androidx.lifecycle.Lifecycle$State, java.lang.Enum] */
    /* JADX WARN: Type inference failed for: r2v2, types: [androidx.lifecycle.Lifecycle$State, java.lang.Enum] */
    /* JADX WARN: Type inference failed for: r3v2, types: [androidx.lifecycle.Lifecycle$State, java.lang.Enum] */
    /* JADX WARN: Type inference failed for: r4v2, types: [androidx.lifecycle.Lifecycle$State, java.lang.Enum] */
    static {
        ?? r02 = new Enum("DESTROYED", 0);
        f1864a = r02;
        ?? r12 = new Enum("INITIALIZED", 1);
        f1865b = r12;
        ?? r22 = new Enum("CREATED", 2);
        f1866c = r22;
        ?? r32 = new Enum("STARTED", 3);
        f1867d = r32;
        ?? r4 = new Enum("RESUMED", 4);
        f1868e = r4;
        f1869f = new Lifecycle$State[]{r02, r12, r22, r32, r4};
    }

    public static Lifecycle$State valueOf(String str) {
        return (Lifecycle$State) Enum.valueOf(Lifecycle$State.class, str);
    }

    public static Lifecycle$State[] values() {
        return (Lifecycle$State[]) f1869f.clone();
    }
}