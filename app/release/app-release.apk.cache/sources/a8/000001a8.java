package androidx.constraintlayout.solver;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class SolverVariable$Type {

    /* renamed from: a  reason: collision with root package name */
    public static final SolverVariable$Type f1117a;

    /* renamed from: b  reason: collision with root package name */
    public static final SolverVariable$Type f1118b;

    /* renamed from: c  reason: collision with root package name */
    public static final SolverVariable$Type f1119c;

    /* renamed from: d  reason: collision with root package name */
    public static final SolverVariable$Type f1120d;

    /* renamed from: e  reason: collision with root package name */
    public static final /* synthetic */ SolverVariable$Type[] f1121e;

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Enum, androidx.constraintlayout.solver.SolverVariable$Type] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Enum, androidx.constraintlayout.solver.SolverVariable$Type] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Enum, androidx.constraintlayout.solver.SolverVariable$Type] */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.Enum, androidx.constraintlayout.solver.SolverVariable$Type] */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.Enum, androidx.constraintlayout.solver.SolverVariable$Type] */
    static {
        ?? r02 = new Enum("UNRESTRICTED", 0);
        f1117a = r02;
        ?? r12 = new Enum("CONSTANT", 1);
        ?? r22 = new Enum("SLACK", 2);
        f1118b = r22;
        ?? r32 = new Enum("ERROR", 3);
        f1119c = r32;
        ?? r4 = new Enum("UNKNOWN", 4);
        f1120d = r4;
        f1121e = new SolverVariable$Type[]{r02, r12, r22, r32, r4};
    }

    public static SolverVariable$Type valueOf(String str) {
        return (SolverVariable$Type) Enum.valueOf(SolverVariable$Type.class, str);
    }

    public static SolverVariable$Type[] values() {
        return (SolverVariable$Type[]) f1121e.clone();
    }
}