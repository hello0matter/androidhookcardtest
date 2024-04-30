package androidx.constraintlayout.solver.widgets.analyzer;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
final class DependencyNode$Type {

    /* renamed from: a  reason: collision with root package name */
    public static final DependencyNode$Type f1136a;

    /* renamed from: b  reason: collision with root package name */
    public static final DependencyNode$Type f1137b;

    /* renamed from: c  reason: collision with root package name */
    public static final DependencyNode$Type f1138c;

    /* renamed from: d  reason: collision with root package name */
    public static final DependencyNode$Type f1139d;

    /* renamed from: e  reason: collision with root package name */
    public static final DependencyNode$Type f1140e;

    /* renamed from: f  reason: collision with root package name */
    public static final DependencyNode$Type f1141f;

    /* renamed from: g  reason: collision with root package name */
    public static final DependencyNode$Type f1142g;

    /* renamed from: h  reason: collision with root package name */
    public static final DependencyNode$Type f1143h;

    /* renamed from: i  reason: collision with root package name */
    public static final /* synthetic */ DependencyNode$Type[] f1144i;

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Enum, androidx.constraintlayout.solver.widgets.analyzer.DependencyNode$Type] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Enum, androidx.constraintlayout.solver.widgets.analyzer.DependencyNode$Type] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Enum, androidx.constraintlayout.solver.widgets.analyzer.DependencyNode$Type] */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.Enum, androidx.constraintlayout.solver.widgets.analyzer.DependencyNode$Type] */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.Enum, androidx.constraintlayout.solver.widgets.analyzer.DependencyNode$Type] */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.lang.Enum, androidx.constraintlayout.solver.widgets.analyzer.DependencyNode$Type] */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.lang.Enum, androidx.constraintlayout.solver.widgets.analyzer.DependencyNode$Type] */
    /* JADX WARN: Type inference failed for: r7v2, types: [java.lang.Enum, androidx.constraintlayout.solver.widgets.analyzer.DependencyNode$Type] */
    static {
        ?? r02 = new Enum("UNKNOWN", 0);
        f1136a = r02;
        ?? r12 = new Enum("HORIZONTAL_DIMENSION", 1);
        f1137b = r12;
        ?? r22 = new Enum("VERTICAL_DIMENSION", 2);
        f1138c = r22;
        ?? r32 = new Enum("LEFT", 3);
        f1139d = r32;
        ?? r4 = new Enum("RIGHT", 4);
        f1140e = r4;
        ?? r5 = new Enum("TOP", 5);
        f1141f = r5;
        ?? r6 = new Enum("BOTTOM", 6);
        f1142g = r6;
        ?? r7 = new Enum("BASELINE", 7);
        f1143h = r7;
        f1144i = new DependencyNode$Type[]{r02, r12, r22, r32, r4, r5, r6, r7};
    }

    public static DependencyNode$Type valueOf(String str) {
        return (DependencyNode$Type) Enum.valueOf(DependencyNode$Type.class, str);
    }

    public static DependencyNode$Type[] values() {
        return (DependencyNode$Type[]) f1144i.clone();
    }
}