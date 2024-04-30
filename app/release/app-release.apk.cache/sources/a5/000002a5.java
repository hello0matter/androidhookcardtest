package androidx.lifecycle;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f1878a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public final Map f1879b;

    public a(HashMap hashMap) {
        this.f1879b = hashMap;
        for (Map.Entry entry : hashMap.entrySet()) {
            Lifecycle$Event lifecycle$Event = (Lifecycle$Event) entry.getValue();
            List list = (List) this.f1878a.get(lifecycle$Event);
            if (list == null) {
                list = new ArrayList();
                this.f1878a.put(lifecycle$Event, list);
            }
            list.add((b) entry.getKey());
        }
    }

    public static void a(List list, q qVar, Lifecycle$Event lifecycle$Event, Object obj) {
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                b bVar = (b) list.get(size);
                bVar.getClass();
                try {
                    int i4 = bVar.f1881a;
                    Method method = bVar.f1882b;
                    if (i4 != 0) {
                        if (i4 != 1) {
                            if (i4 == 2) {
                                method.invoke(obj, qVar, lifecycle$Event);
                            }
                        } else {
                            method.invoke(obj, qVar);
                        }
                    } else {
                        method.invoke(obj, new Object[0]);
                    }
                } catch (IllegalAccessException e4) {
                    throw new RuntimeException(e4);
                } catch (InvocationTargetException e5) {
                    throw new RuntimeException("Failed to call observer method", e5.getCause());
                }
            }
        }
    }
}