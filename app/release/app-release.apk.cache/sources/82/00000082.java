package androidx.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Deprecated
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes.dex */
public @interface InspectableProperty {

    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface EnumEntry {
        String name();

        int value();
    }

    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface FlagEntry {
        int mask() default 0;

        String name();

        int target();
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* loaded from: classes.dex */
    public static final class ValueType {

        /* renamed from: a  reason: collision with root package name */
        public static final ValueType f165a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ ValueType[] f166b;
        /* JADX INFO: Fake field, exist only in values array */
        ValueType EF0;

        /* JADX WARN: Type inference failed for: r0v0, types: [androidx.annotation.InspectableProperty$ValueType, java.lang.Enum] */
        /* JADX WARN: Type inference failed for: r1v1, types: [androidx.annotation.InspectableProperty$ValueType, java.lang.Enum] */
        /* JADX WARN: Type inference failed for: r2v2, types: [androidx.annotation.InspectableProperty$ValueType, java.lang.Enum] */
        /* JADX WARN: Type inference failed for: r3v2, types: [androidx.annotation.InspectableProperty$ValueType, java.lang.Enum] */
        /* JADX WARN: Type inference failed for: r4v2, types: [androidx.annotation.InspectableProperty$ValueType, java.lang.Enum] */
        /* JADX WARN: Type inference failed for: r5v2, types: [androidx.annotation.InspectableProperty$ValueType, java.lang.Enum] */
        /* JADX WARN: Type inference failed for: r6v2, types: [androidx.annotation.InspectableProperty$ValueType, java.lang.Enum] */
        static {
            ?? r02 = new Enum("NONE", 0);
            ?? r12 = new Enum("INFERRED", 1);
            f165a = r12;
            f166b = new ValueType[]{r02, r12, new Enum("INT_ENUM", 2), new Enum("INT_FLAG", 3), new Enum("COLOR", 4), new Enum("GRAVITY", 5), new Enum("RESOURCE_ID", 6)};
        }

        public static ValueType valueOf(String str) {
            return (ValueType) Enum.valueOf(ValueType.class, str);
        }

        public static ValueType[] values() {
            return (ValueType[]) f166b.clone();
        }
    }

    int attributeId() default 0;

    EnumEntry[] enumMapping() default {};

    FlagEntry[] flagMapping() default {};

    boolean hasAttributeId() default true;

    String name() default "";

    ValueType valueType() default ValueType.f165a;
}