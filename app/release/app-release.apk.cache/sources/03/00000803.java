package kotlin.internal;

import kotlin.Metadata;
import kotlin.SinceKotlin;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@SinceKotlin(version = "1.2")
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0081\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lkotlin/internal/RequireKotlinVersionKind;", "", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes.dex */
public final class RequireKotlinVersionKind {

    /* renamed from: a  reason: collision with root package name */
    public static final RequireKotlinVersionKind f5186a;

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ RequireKotlinVersionKind[] f5187b;

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Enum, kotlin.internal.RequireKotlinVersionKind] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Enum, kotlin.internal.RequireKotlinVersionKind] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Enum, kotlin.internal.RequireKotlinVersionKind] */
    static {
        ?? r02 = new Enum("LANGUAGE_VERSION", 0);
        f5186a = r02;
        f5187b = new RequireKotlinVersionKind[]{r02, new Enum("COMPILER_VERSION", 1), new Enum("API_VERSION", 2)};
    }

    public static RequireKotlinVersionKind valueOf(String str) {
        return (RequireKotlinVersionKind) Enum.valueOf(RequireKotlinVersionKind.class, str);
    }

    public static RequireKotlinVersionKind[] values() {
        return (RequireKotlinVersionKind[]) f5187b.clone();
    }
}