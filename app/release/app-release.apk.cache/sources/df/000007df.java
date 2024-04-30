package kotlin.annotation;

import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lkotlin/annotation/AnnotationRetention;", "", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes.dex */
public final class AnnotationRetention {

    /* renamed from: a  reason: collision with root package name */
    public static final AnnotationRetention f5160a;

    /* renamed from: b  reason: collision with root package name */
    public static final AnnotationRetention f5161b;

    /* renamed from: c  reason: collision with root package name */
    public static final AnnotationRetention f5162c;

    /* renamed from: d  reason: collision with root package name */
    public static final /* synthetic */ AnnotationRetention[] f5163d;

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Enum, kotlin.annotation.AnnotationRetention] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Enum, kotlin.annotation.AnnotationRetention] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Enum, kotlin.annotation.AnnotationRetention] */
    static {
        ?? r02 = new Enum("SOURCE", 0);
        f5160a = r02;
        ?? r12 = new Enum("BINARY", 1);
        f5161b = r12;
        ?? r22 = new Enum("RUNTIME", 2);
        f5162c = r22;
        f5163d = new AnnotationRetention[]{r02, r12, r22};
    }

    public static AnnotationRetention valueOf(String str) {
        return (AnnotationRetention) Enum.valueOf(AnnotationRetention.class, str);
    }

    public static AnnotationRetention[] values() {
        return (AnnotationRetention[]) f5163d.clone();
    }
}