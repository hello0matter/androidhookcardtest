package kotlin;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;

@Target({ElementType.ANNOTATION_TYPE})
@SinceKotlin(version = "1.3")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\u0002\u0018\u00002\u00020\u0001:\u0001\bB\u0014\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005R\u000f\u0010\u0004\u001a\u00020\u0005¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0006R\u000f\u0010\u0002\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0007¨\u0006\t"}, d2 = {"Lkotlin/RequiresOptIn;", "", "message", "", "level", "Lkotlin/RequiresOptIn$Level;", "()Lkotlin/RequiresOptIn$Level;", "()Ljava/lang/String;", "Level", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.f5165b})
@Retention(RetentionPolicy.CLASS)
@kotlin.annotation.Retention(AnnotationRetention.f5161b)
/* loaded from: classes.dex */
public @interface RequiresOptIn {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lkotlin/RequiresOptIn$Level;", "", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
    /* loaded from: classes.dex */
    public static final class Level {

        /* renamed from: a  reason: collision with root package name */
        public static final Level f5154a;

        /* renamed from: b  reason: collision with root package name */
        public static final Level f5155b;

        /* renamed from: c  reason: collision with root package name */
        public static final /* synthetic */ Level[] f5156c;

        /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.RequiresOptIn$Level, java.lang.Enum] */
        /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.RequiresOptIn$Level, java.lang.Enum] */
        static {
            ?? r02 = new Enum("WARNING", 0);
            f5154a = r02;
            ?? r12 = new Enum("ERROR", 1);
            f5155b = r12;
            f5156c = new Level[]{r02, r12};
        }

        public static Level valueOf(String str) {
            return (Level) Enum.valueOf(Level.class, str);
        }

        public static Level[] values() {
            return (Level[]) f5156c.clone();
        }
    }

    Level level() default Level.f5155b;

    String message() default "";
}