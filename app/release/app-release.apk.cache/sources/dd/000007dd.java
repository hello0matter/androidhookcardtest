package kotlin;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;

@Target({ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR})
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0081\u0002\u0018\u00002\u00020\u0001B+\u0012\"\u0010\u0004\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u00030\u0002\"\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007R!\u0010\u0004\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u00030\u00028\u0006¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lkotlin/WasExperimental;", "", "", "Lj3/a;", "markerClass", "()[Ljava/lang/Class;", "<init>", "(Lkotlin/Array;)V", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.f5164a, AnnotationTarget.f5167d, AnnotationTarget.f5171h, AnnotationTarget.f5172i, AnnotationTarget.f5178o})
@Retention(RetentionPolicy.CLASS)
@kotlin.annotation.Retention(AnnotationRetention.f5161b)
/* loaded from: classes.dex */
public @interface WasExperimental {
    Class<? extends Annotation>[] markerClass();
}