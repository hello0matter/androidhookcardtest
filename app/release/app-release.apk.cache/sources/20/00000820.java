package kotlin.jvm.internal;

import com.google.common.collect.c;
import f3.e;
import java.io.Serializable;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\u00020\u0003¨\u0006\u0004"}, d2 = {"Lkotlin/jvm/internal/Lambda;", "R", "", "Ljava/io/Serializable;", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes.dex */
public abstract class Lambda<R> implements Serializable {
    public final String toString() {
        e.f4578a.getClass();
        String obj = getClass().getGenericInterfaces()[0].toString();
        if (obj.startsWith("kotlin.jvm.functions.")) {
            obj = obj.substring(21);
        }
        c.E(obj, "renderLambdaToString(this)");
        return obj;
    }
}