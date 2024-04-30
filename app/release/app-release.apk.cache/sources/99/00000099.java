package androidx.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;

@Target({ElementType.ANNOTATION_TYPE})
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\u0002\u0018\u00002\u00020\u0001:\u0001\u0005B\n\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003R\u000f\u0010\u0002\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004¨\u0006\u0006"}, d2 = {"Landroidx/annotation/RequiresOptIn;", "", "level", "Landroidx/annotation/RequiresOptIn$Level;", "()Landroidx/annotation/RequiresOptIn$Level;", "Level", "annotation-experimental_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.f5165b})
@Retention(RetentionPolicy.CLASS)
@kotlin.annotation.Retention(AnnotationRetention.f5161b)
/* loaded from: classes.dex */
public @interface RequiresOptIn {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Landroidx/annotation/RequiresOptIn$Level;", "", "annotation-experimental_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes.dex */
    public static final class Level {

        /* renamed from: a  reason: collision with root package name */
        public static final Level f167a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ Level[] f168b;
        /* JADX INFO: Fake field, exist only in values array */
        Level EF0;

        /* JADX WARN: Type inference failed for: r0v0, types: [androidx.annotation.RequiresOptIn$Level, java.lang.Enum] */
        /* JADX WARN: Type inference failed for: r1v1, types: [androidx.annotation.RequiresOptIn$Level, java.lang.Enum] */
        static {
            ?? r02 = new Enum("WARNING", 0);
            ?? r12 = new Enum("ERROR", 1);
            f167a = r12;
            f168b = new Level[]{r02, r12};
        }

        public static Level valueOf(String str) {
            return (Level) Enum.valueOf(Level.class, str);
        }

        public static Level[] values() {
            return (Level[]) f168b.clone();
        }
    }

    Level level() default Level.f167a;
}