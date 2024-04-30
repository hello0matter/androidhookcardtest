package kotlin;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lkotlin/DeprecationLevel;", "", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes.dex */
public final class DeprecationLevel {

    /* renamed from: a  reason: collision with root package name */
    public static final DeprecationLevel f5147a;

    /* renamed from: b  reason: collision with root package name */
    public static final DeprecationLevel f5148b;

    /* renamed from: c  reason: collision with root package name */
    public static final DeprecationLevel f5149c;

    /* renamed from: d  reason: collision with root package name */
    public static final /* synthetic */ DeprecationLevel[] f5150d;

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Enum, kotlin.DeprecationLevel] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Enum, kotlin.DeprecationLevel] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Enum, kotlin.DeprecationLevel] */
    static {
        ?? r02 = new Enum("WARNING", 0);
        f5147a = r02;
        ?? r12 = new Enum("ERROR", 1);
        f5148b = r12;
        ?? r22 = new Enum("HIDDEN", 2);
        f5149c = r22;
        f5150d = new DeprecationLevel[]{r02, r12, r22};
    }

    public static DeprecationLevel valueOf(String str) {
        return (DeprecationLevel) Enum.valueOf(DeprecationLevel.class, str);
    }

    public static DeprecationLevel[] values() {
        return (DeprecationLevel[]) f5150d.clone();
    }
}