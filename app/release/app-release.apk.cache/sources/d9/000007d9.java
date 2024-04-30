package kotlin;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;

@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.CONSTRUCTOR, ElementType.LOCAL_VARIABLE, ElementType.ANNOTATION_TYPE})
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0014\u0012\u0012\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\"\u00020\u0004R\u0017\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lkotlin/Suppress;", "", "names", "", "", "()[Ljava/lang/String;", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.f5164a, AnnotationTarget.f5165b, AnnotationTarget.f5166c, AnnotationTarget.f5167d, AnnotationTarget.f5168e, AnnotationTarget.f5169f, AnnotationTarget.f5170g, AnnotationTarget.f5171h, AnnotationTarget.f5172i, AnnotationTarget.f5173j, AnnotationTarget.f5174k, AnnotationTarget.f5175l, AnnotationTarget.f5176m, AnnotationTarget.f5177n, AnnotationTarget.f5178o})
@Retention(RetentionPolicy.SOURCE)
@kotlin.annotation.Retention(AnnotationRetention.f5160a)
/* loaded from: classes.dex */
public @interface Suppress {
    String[] names();
}