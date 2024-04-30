package androidx.lifecycle;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

/* loaded from: classes.dex */
public abstract class t {

    /* renamed from: a  reason: collision with root package name */
    public static final HashMap f1921a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public static final HashMap f1922b = new HashMap();

    public static void a(Constructor constructor, Object obj) {
        try {
            Object newInstance = constructor.newInstance(obj);
            com.google.common.collect.c.E(newInstance, "{\n            constructo…tance(`object`)\n        }");
            androidx.activity.j.g(newInstance);
            throw null;
        } catch (IllegalAccessException e4) {
            throw new RuntimeException(e4);
        } catch (InstantiationException e5) {
            throw new RuntimeException(e5);
        } catch (InvocationTargetException e6) {
            throw new RuntimeException(e6);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x00b6, code lost:
        if (r7.booleanValue() != false) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x013b, code lost:
        if (r1 != null) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int b(java.lang.Class r13) {
        /*
            Method dump skipped, instructions count: 336
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.t.b(java.lang.Class):int");
    }
}