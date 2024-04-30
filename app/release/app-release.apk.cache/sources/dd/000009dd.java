package u3;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLSocket;
import okhttp3.Protocol;

/* loaded from: classes.dex */
public final class i extends l {

    /* renamed from: h  reason: collision with root package name */
    public static final t3.a f6924h = new t3.a(11, 0);

    /* renamed from: c  reason: collision with root package name */
    public final Method f6925c;

    /* renamed from: d  reason: collision with root package name */
    public final Method f6926d;

    /* renamed from: e  reason: collision with root package name */
    public final Method f6927e;

    /* renamed from: f  reason: collision with root package name */
    public final Class f6928f;

    /* renamed from: g  reason: collision with root package name */
    public final Class f6929g;

    public i(Method method, Method method2, Method method3, Class cls, Class cls2) {
        this.f6925c = method;
        this.f6926d = method2;
        this.f6927e = method3;
        this.f6928f = cls;
        this.f6929g = cls2;
    }

    @Override // u3.l
    public final void a(SSLSocket sSLSocket) {
        try {
            this.f6927e.invoke(null, sSLSocket);
        } catch (IllegalAccessException e4) {
            throw new AssertionError("failed to remove ALPN", e4);
        } catch (InvocationTargetException e5) {
            throw new AssertionError("failed to remove ALPN", e5);
        }
    }

    @Override // u3.l
    public final void d(SSLSocket sSLSocket, String str, List list) {
        com.google.common.collect.c.F(list, "protocols");
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((Protocol) obj) != Protocol.HTTP_1_0) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(y2.h.h2(arrayList));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((Protocol) it.next()).f5996a);
        }
        try {
            this.f6925c.invoke(null, sSLSocket, Proxy.newProxyInstance(l.class.getClassLoader(), new Class[]{this.f6928f, this.f6929g}, new h(arrayList2)));
        } catch (IllegalAccessException e4) {
            throw new AssertionError("failed to set ALPN", e4);
        } catch (InvocationTargetException e5) {
            throw new AssertionError("failed to set ALPN", e5);
        }
    }

    @Override // u3.l
    public final String f(SSLSocket sSLSocket) {
        try {
            InvocationHandler invocationHandler = Proxy.getInvocationHandler(this.f6926d.invoke(null, sSLSocket));
            com.google.common.collect.c.D(invocationHandler, "null cannot be cast to non-null type okhttp3.internal.platform.Jdk8WithJettyBootPlatform.AlpnProvider");
            h hVar = (h) invocationHandler;
            boolean z4 = hVar.f6922b;
            if (!z4 && hVar.f6923c == null) {
                l.i("ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", 4, null);
                return null;
            } else if (z4) {
                return null;
            } else {
                return hVar.f6923c;
            }
        } catch (IllegalAccessException e4) {
            throw new AssertionError("failed to get ALPN selected protocol", e4);
        } catch (InvocationTargetException e5) {
            throw new AssertionError("failed to get ALPN selected protocol", e5);
        }
    }
}