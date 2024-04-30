package androidx.constraintlayout.solver.widgets.analyzer;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
final class WidgetRun$RunType {

    /* renamed from: a  reason: collision with root package name */
    public static final WidgetRun$RunType f1145a;

    /* renamed from: b  reason: collision with root package name */
    public static final WidgetRun$RunType f1146b;

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ WidgetRun$RunType[] f1147c;

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Enum, androidx.constraintlayout.solver.widgets.analyzer.WidgetRun$RunType] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Enum, androidx.constraintlayout.solver.widgets.analyzer.WidgetRun$RunType] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Enum, androidx.constraintlayout.solver.widgets.analyzer.WidgetRun$RunType] */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.Enum, androidx.constraintlayout.solver.widgets.analyzer.WidgetRun$RunType] */
    static {
        ?? r02 = new Enum("NONE", 0);
        f1145a = r02;
        ?? r12 = new Enum("START", 1);
        ?? r22 = new Enum("END", 2);
        ?? r32 = new Enum("CENTER", 3);
        f1146b = r32;
        f1147c = new WidgetRun$RunType[]{r02, r12, r22, r32};
    }

    public static WidgetRun$RunType valueOf(String str) {
        return (WidgetRun$RunType) Enum.valueOf(WidgetRun$RunType.class, str);
    }

    public static WidgetRun$RunType[] values() {
        return (WidgetRun$RunType[]) f1147c.clone();
    }
}