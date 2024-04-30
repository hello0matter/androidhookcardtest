package androidx.fragment.app;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
final class SpecialEffectsController$Operation$LifecycleImpact {

    /* renamed from: a  reason: collision with root package name */
    public static final SpecialEffectsController$Operation$LifecycleImpact f1622a;

    /* renamed from: b  reason: collision with root package name */
    public static final SpecialEffectsController$Operation$LifecycleImpact f1623b;

    /* renamed from: c  reason: collision with root package name */
    public static final SpecialEffectsController$Operation$LifecycleImpact f1624c;

    /* renamed from: d  reason: collision with root package name */
    public static final /* synthetic */ SpecialEffectsController$Operation$LifecycleImpact[] f1625d;

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Enum, androidx.fragment.app.SpecialEffectsController$Operation$LifecycleImpact] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Enum, androidx.fragment.app.SpecialEffectsController$Operation$LifecycleImpact] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Enum, androidx.fragment.app.SpecialEffectsController$Operation$LifecycleImpact] */
    static {
        ?? r02 = new Enum("NONE", 0);
        f1622a = r02;
        ?? r12 = new Enum("ADDING", 1);
        f1623b = r12;
        ?? r22 = new Enum("REMOVING", 2);
        f1624c = r22;
        f1625d = new SpecialEffectsController$Operation$LifecycleImpact[]{r02, r12, r22};
    }

    public static SpecialEffectsController$Operation$LifecycleImpact valueOf(String str) {
        return (SpecialEffectsController$Operation$LifecycleImpact) Enum.valueOf(SpecialEffectsController$Operation$LifecycleImpact.class, str);
    }

    public static SpecialEffectsController$Operation$LifecycleImpact[] values() {
        return (SpecialEffectsController$Operation$LifecycleImpact[]) f1625d.clone();
    }
}