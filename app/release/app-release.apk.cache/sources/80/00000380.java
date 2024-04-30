package b3;

import com.google.common.collect.c;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public static final Method f2522a;

    static {
        Method method;
        Method[] methods = Throwable.class.getMethods();
        c.E(methods, "throwableMethods");
        int length = methods.length;
        int i4 = 0;
        while (true) {
            method = null;
            if (i4 >= length) {
                break;
            }
            Method method2 = methods[i4];
            if (c.n(method2.getName(), "addSuppressed")) {
                Class<?>[] parameterTypes = method2.getParameterTypes();
                c.E(parameterTypes, "it.parameterTypes");
                if (parameterTypes.length == 1) {
                    method = parameterTypes[0];
                }
                if (c.n(method, Throwable.class)) {
                    method = method2;
                    break;
                }
            }
            i4++;
        }
        f2522a = method;
        int length2 = methods.length;
        for (int i5 = 0; i5 < length2 && !c.n(methods[i5].getName(), "getSuppressed"); i5++) {
        }
    }
}