package androidx.lifecycle;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: c  reason: collision with root package name */
    public static final c f1892c = new c();

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f1893a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public final HashMap f1894b = new HashMap();

    public static void b(HashMap hashMap, b bVar, Lifecycle$Event lifecycle$Event, Class cls) {
        Lifecycle$Event lifecycle$Event2 = (Lifecycle$Event) hashMap.get(bVar);
        if (lifecycle$Event2 != null && lifecycle$Event != lifecycle$Event2) {
            Method method = bVar.f1882b;
            throw new IllegalArgumentException("Method " + method.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous value " + lifecycle$Event2 + ", new value " + lifecycle$Event);
        } else if (lifecycle$Event2 == null) {
            hashMap.put(bVar, lifecycle$Event);
        }
    }

    public final a a(Class cls, Method[] methodArr) {
        Class<?>[] interfaces;
        int i4;
        Class superclass = cls.getSuperclass();
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = this.f1893a;
        if (superclass != null) {
            a aVar = (a) hashMap2.get(superclass);
            if (aVar == null) {
                aVar = a(superclass, null);
            }
            hashMap.putAll(aVar.f1879b);
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            a aVar2 = (a) hashMap2.get(cls2);
            if (aVar2 == null) {
                aVar2 = a(cls2, null);
            }
            for (Map.Entry entry : aVar2.f1879b.entrySet()) {
                b(hashMap, (b) entry.getKey(), (Lifecycle$Event) entry.getValue(), cls);
            }
        }
        if (methodArr == null) {
            try {
                methodArr = cls.getDeclaredMethods();
            } catch (NoClassDefFoundError e4) {
                throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e4);
            }
        }
        boolean z4 = false;
        for (Method method : methodArr) {
            OnLifecycleEvent onLifecycleEvent = (OnLifecycleEvent) method.getAnnotation(OnLifecycleEvent.class);
            if (onLifecycleEvent != null) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length > 0) {
                    if (q.class.isAssignableFrom(parameterTypes[0])) {
                        i4 = 1;
                    } else {
                        throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                    }
                } else {
                    i4 = 0;
                }
                Lifecycle$Event value = onLifecycleEvent.value();
                if (parameterTypes.length > 1) {
                    if (Lifecycle$Event.class.isAssignableFrom(parameterTypes[1])) {
                        if (value == Lifecycle$Event.ON_ANY) {
                            i4 = 2;
                        } else {
                            throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                        }
                    } else {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    }
                }
                if (parameterTypes.length <= 2) {
                    b(hashMap, new b(i4, method), value, cls);
                    z4 = true;
                } else {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
            }
        }
        a aVar3 = new a(hashMap);
        hashMap2.put(cls, aVar3);
        this.f1894b.put(cls, Boolean.valueOf(z4));
        return aVar3;
    }
}