package androidx.constraintlayout.widget;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class ConstraintAttribute$AttributeType {

    /* renamed from: a  reason: collision with root package name */
    public static final ConstraintAttribute$AttributeType f1215a;

    /* renamed from: b  reason: collision with root package name */
    public static final ConstraintAttribute$AttributeType f1216b;

    /* renamed from: c  reason: collision with root package name */
    public static final ConstraintAttribute$AttributeType f1217c;

    /* renamed from: d  reason: collision with root package name */
    public static final ConstraintAttribute$AttributeType f1218d;

    /* renamed from: e  reason: collision with root package name */
    public static final ConstraintAttribute$AttributeType f1219e;

    /* renamed from: f  reason: collision with root package name */
    public static final ConstraintAttribute$AttributeType f1220f;

    /* renamed from: g  reason: collision with root package name */
    public static final ConstraintAttribute$AttributeType f1221g;

    /* renamed from: h  reason: collision with root package name */
    public static final /* synthetic */ ConstraintAttribute$AttributeType[] f1222h;

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Enum, androidx.constraintlayout.widget.ConstraintAttribute$AttributeType] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Enum, androidx.constraintlayout.widget.ConstraintAttribute$AttributeType] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Enum, androidx.constraintlayout.widget.ConstraintAttribute$AttributeType] */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.Enum, androidx.constraintlayout.widget.ConstraintAttribute$AttributeType] */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.Enum, androidx.constraintlayout.widget.ConstraintAttribute$AttributeType] */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.lang.Enum, androidx.constraintlayout.widget.ConstraintAttribute$AttributeType] */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.lang.Enum, androidx.constraintlayout.widget.ConstraintAttribute$AttributeType] */
    static {
        ?? r02 = new Enum("INT_TYPE", 0);
        f1215a = r02;
        ?? r12 = new Enum("FLOAT_TYPE", 1);
        f1216b = r12;
        ?? r22 = new Enum("COLOR_TYPE", 2);
        f1217c = r22;
        ?? r32 = new Enum("COLOR_DRAWABLE_TYPE", 3);
        f1218d = r32;
        ?? r4 = new Enum("STRING_TYPE", 4);
        f1219e = r4;
        ?? r5 = new Enum("BOOLEAN_TYPE", 5);
        f1220f = r5;
        ?? r6 = new Enum("DIMENSION_TYPE", 6);
        f1221g = r6;
        f1222h = new ConstraintAttribute$AttributeType[]{r02, r12, r22, r32, r4, r5, r6};
    }

    public static ConstraintAttribute$AttributeType valueOf(String str) {
        return (ConstraintAttribute$AttributeType) Enum.valueOf(ConstraintAttribute$AttributeType.class, str);
    }

    public static ConstraintAttribute$AttributeType[] values() {
        return (ConstraintAttribute$AttributeType[]) f1222h.clone();
    }
}