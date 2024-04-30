package kotlin;

import com.google.common.collect.c;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public abstract class a {
    public static void a(Throwable th, Throwable th2) {
        c.F(th, "<this>");
        c.F(th2, "exception");
        if (th != th2) {
            Integer num = c3.a.f2720a;
            if (num != null && num.intValue() < 19) {
                Method method = b3.a.f2522a;
                if (method != null) {
                    method.invoke(th, th2);
                    return;
                }
                return;
            }
            th.addSuppressed(th2);
        }
    }

    public static x2.a b(e3.a aVar) {
        return new SynchronizedLazyImpl(aVar);
    }
}