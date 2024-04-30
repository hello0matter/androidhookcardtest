package androidx.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.PACKAGE})
@Documented
@Retention(RetentionPolicy.CLASS)
/* loaded from: classes.dex */
public @interface RestrictTo {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* loaded from: classes.dex */
    public static final class Scope {

        /* renamed from: a  reason: collision with root package name */
        public static final Scope f169a;

        /* renamed from: b  reason: collision with root package name */
        public static final Scope f170b;

        /* renamed from: c  reason: collision with root package name */
        public static final Scope f171c;

        /* renamed from: d  reason: collision with root package name */
        public static final Scope f172d;

        /* renamed from: e  reason: collision with root package name */
        public static final /* synthetic */ Scope[] f173e;

        /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Enum, androidx.annotation.RestrictTo$Scope] */
        /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Enum, androidx.annotation.RestrictTo$Scope] */
        /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Enum, androidx.annotation.RestrictTo$Scope] */
        /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.Enum, androidx.annotation.RestrictTo$Scope] */
        /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.Enum, androidx.annotation.RestrictTo$Scope] */
        /* JADX WARN: Type inference failed for: r5v2, types: [java.lang.Enum, androidx.annotation.RestrictTo$Scope] */
        static {
            ?? r02 = new Enum("LIBRARY", 0);
            f169a = r02;
            ?? r12 = new Enum("LIBRARY_GROUP", 1);
            f170b = r12;
            ?? r22 = new Enum("LIBRARY_GROUP_PREFIX", 2);
            f171c = r22;
            ?? r32 = new Enum("GROUP_ID", 3);
            ?? r4 = new Enum("TESTS", 4);
            f172d = r4;
            f173e = new Scope[]{r02, r12, r22, r32, r4, new Enum("SUBCLASSES", 5)};
        }

        public static Scope valueOf(String str) {
            return (Scope) Enum.valueOf(Scope.class, str);
        }

        public static Scope[] values() {
            return (Scope[]) f173e.clone();
        }
    }

    Scope[] value();
}