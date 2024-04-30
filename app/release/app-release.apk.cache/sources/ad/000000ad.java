package androidx.annotation.experimental;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;

@Target({ElementType.TYPE, ElementType.METHOD, ElementType.PARAMETER, ElementType.CONSTRUCTOR, ElementType.LOCAL_VARIABLE})
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\u0002\u0018\u00002\u00020\u0001B+\u0012\"\u0010\u0004\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u00030\u0002\"\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007R!\u0010\u0004\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u00030\u00028\u0006¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Landroidx/annotation/experimental/UseExperimental;", "", "", "Lj3/a;", "markerClass", "()[Ljava/lang/Class;", "<init>", "(Lkotlin/Array;)V", "annotation-experimental_release"}, k = 1, mv = {1, 7, 1})
@Deprecated(message = "This annotation has been replaced by `@OptIn`", replaceWith = @ReplaceWith(expression = "OptIn", imports = {"androidx.annotation.OptIn"}))
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.f5164a, AnnotationTarget.f5167d, AnnotationTarget.f5169f, AnnotationTarget.f5170g, AnnotationTarget.f5171h, AnnotationTarget.f5172i, AnnotationTarget.f5173j, AnnotationTarget.f5174k, AnnotationTarget.f5177n, AnnotationTarget.f5178o})
@Retention(RetentionPolicy.CLASS)
@kotlin.annotation.Retention(AnnotationRetention.f5161b)
/* loaded from: classes.dex */
public @interface UseExperimental {
    Class<? extends Annotation>[] markerClass();
}