package kotlin;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;

@Target({ElementType.TYPE})
@SinceKotlin(version = "1.8")
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.f5164a})
@Retention(RetentionPolicy.CLASS)
@kotlin.annotation.Retention(AnnotationRetention.f5161b)
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0019\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u00028\u0006¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lkotlin/SubclassOptInRequired;", "", "Lj3/a;", "markerClass", "()Ljava/lang/Class;", "<init>", "(Lj3/a;)V", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
@ExperimentalSubclassOptIn
/* loaded from: classes.dex */
public @interface SubclassOptInRequired {
    Class<? extends Annotation> markerClass();
}