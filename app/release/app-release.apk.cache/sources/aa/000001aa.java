package androidx.constraintlayout.solver.widgets;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class ConstraintWidget$DimensionBehaviour {

    /* renamed from: a  reason: collision with root package name */
    public static final ConstraintWidget$DimensionBehaviour f1131a;

    /* renamed from: b  reason: collision with root package name */
    public static final ConstraintWidget$DimensionBehaviour f1132b;

    /* renamed from: c  reason: collision with root package name */
    public static final ConstraintWidget$DimensionBehaviour f1133c;

    /* renamed from: d  reason: collision with root package name */
    public static final ConstraintWidget$DimensionBehaviour f1134d;

    /* renamed from: e  reason: collision with root package name */
    public static final /* synthetic */ ConstraintWidget$DimensionBehaviour[] f1135e;

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Enum, androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Enum, androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Enum, androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour] */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.Enum, androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour] */
    static {
        ?? r02 = new Enum("FIXED", 0);
        f1131a = r02;
        ?? r12 = new Enum("WRAP_CONTENT", 1);
        f1132b = r12;
        ?? r22 = new Enum("MATCH_CONSTRAINT", 2);
        f1133c = r22;
        ?? r32 = new Enum("MATCH_PARENT", 3);
        f1134d = r32;
        f1135e = new ConstraintWidget$DimensionBehaviour[]{r02, r12, r22, r32};
    }

    public static ConstraintWidget$DimensionBehaviour valueOf(String str) {
        return (ConstraintWidget$DimensionBehaviour) Enum.valueOf(ConstraintWidget$DimensionBehaviour.class, str);
    }

    public static ConstraintWidget$DimensionBehaviour[] values() {
        return (ConstraintWidget$DimensionBehaviour[]) f1135e.clone();
    }
}