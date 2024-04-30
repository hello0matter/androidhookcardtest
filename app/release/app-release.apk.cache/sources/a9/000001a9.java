package androidx.constraintlayout.solver.widgets;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class ConstraintAnchor$Type {

    /* renamed from: a  reason: collision with root package name */
    public static final ConstraintAnchor$Type f1122a;

    /* renamed from: b  reason: collision with root package name */
    public static final ConstraintAnchor$Type f1123b;

    /* renamed from: c  reason: collision with root package name */
    public static final ConstraintAnchor$Type f1124c;

    /* renamed from: d  reason: collision with root package name */
    public static final ConstraintAnchor$Type f1125d;

    /* renamed from: e  reason: collision with root package name */
    public static final ConstraintAnchor$Type f1126e;

    /* renamed from: f  reason: collision with root package name */
    public static final ConstraintAnchor$Type f1127f;

    /* renamed from: g  reason: collision with root package name */
    public static final ConstraintAnchor$Type f1128g;

    /* renamed from: h  reason: collision with root package name */
    public static final ConstraintAnchor$Type f1129h;

    /* renamed from: i  reason: collision with root package name */
    public static final /* synthetic */ ConstraintAnchor$Type[] f1130i;
    /* JADX INFO: Fake field, exist only in values array */
    ConstraintAnchor$Type EF0;

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Enum, androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Enum, androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Enum, androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type] */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.Enum, androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type] */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.Enum, androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type] */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.lang.Enum, androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type] */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.lang.Enum, androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type] */
    /* JADX WARN: Type inference failed for: r7v2, types: [java.lang.Enum, androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type] */
    /* JADX WARN: Type inference failed for: r8v2, types: [java.lang.Enum, androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type] */
    static {
        ?? r02 = new Enum("NONE", 0);
        ?? r12 = new Enum("LEFT", 1);
        f1122a = r12;
        ?? r22 = new Enum("TOP", 2);
        f1123b = r22;
        ?? r32 = new Enum("RIGHT", 3);
        f1124c = r32;
        ?? r4 = new Enum("BOTTOM", 4);
        f1125d = r4;
        ?? r5 = new Enum("BASELINE", 5);
        f1126e = r5;
        ?? r6 = new Enum("CENTER", 6);
        f1127f = r6;
        ?? r7 = new Enum("CENTER_X", 7);
        f1128g = r7;
        ?? r8 = new Enum("CENTER_Y", 8);
        f1129h = r8;
        f1130i = new ConstraintAnchor$Type[]{r02, r12, r22, r32, r4, r5, r6, r7, r8};
    }

    public static ConstraintAnchor$Type valueOf(String str) {
        return (ConstraintAnchor$Type) Enum.valueOf(ConstraintAnchor$Type.class, str);
    }

    public static ConstraintAnchor$Type[] values() {
        return (ConstraintAnchor$Type[]) f1130i.clone();
    }
}