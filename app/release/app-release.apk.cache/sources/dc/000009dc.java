package u3;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public final class h implements InvocationHandler {

    /* renamed from: a  reason: collision with root package name */
    public final List f6921a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f6922b;

    /* renamed from: c  reason: collision with root package name */
    public String f6923c;

    public h(ArrayList arrayList) {
        this.f6921a = arrayList;
    }

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object obj, Method method, Object[] objArr) {
        com.google.common.collect.c.F(obj, "proxy");
        com.google.common.collect.c.F(method, "method");
        if (objArr == null) {
            objArr = new Object[0];
        }
        String name = method.getName();
        Class<?> returnType = method.getReturnType();
        if (com.google.common.collect.c.n(name, "supports") && com.google.common.collect.c.n(Boolean.TYPE, returnType)) {
            return Boolean.TRUE;
        }
        if (com.google.common.collect.c.n(name, "unsupported") && com.google.common.collect.c.n(Void.TYPE, returnType)) {
            this.f6922b = true;
            return null;
        }
        boolean n4 = com.google.common.collect.c.n(name, "protocols");
        List list = this.f6921a;
        if (n4 && objArr.length == 0) {
            return list;
        }
        if ((com.google.common.collect.c.n(name, "selectProtocol") || com.google.common.collect.c.n(name, "select")) && com.google.common.collect.c.n(String.class, returnType) && objArr.length == 1) {
            Object obj2 = objArr[0];
            if (obj2 instanceof List) {
                com.google.common.collect.c.D(obj2, "null cannot be cast to non-null type kotlin.collections.List<*>");
                List list2 = (List) obj2;
                int size = list2.size();
                if (size >= 0) {
                    int i4 = 0;
                    while (true) {
                        Object obj3 = list2.get(i4);
                        com.google.common.collect.c.D(obj3, "null cannot be cast to non-null type kotlin.String");
                        String str = (String) obj3;
                        if (list.contains(str)) {
                            this.f6923c = str;
                            return str;
                        } else if (i4 == size) {
                            break;
                        } else {
                            i4++;
                        }
                    }
                }
                String str2 = (String) list.get(0);
                this.f6923c = str2;
                return str2;
            }
        }
        if ((com.google.common.collect.c.n(name, "protocolSelected") || com.google.common.collect.c.n(name, "selected")) && objArr.length == 1) {
            Object obj4 = objArr[0];
            com.google.common.collect.c.D(obj4, "null cannot be cast to non-null type kotlin.String");
            this.f6923c = (String) obj4;
            return null;
        }
        return method.invoke(this, Arrays.copyOf(objArr, objArr.length));
    }
}