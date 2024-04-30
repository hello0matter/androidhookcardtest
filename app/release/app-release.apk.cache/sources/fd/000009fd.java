package v3;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* loaded from: classes.dex */
public class e implements m {

    /* renamed from: f  reason: collision with root package name */
    public static final i1.c f6998f = new i1.c();

    /* renamed from: a  reason: collision with root package name */
    public final Class f6999a;

    /* renamed from: b  reason: collision with root package name */
    public final Method f7000b;

    /* renamed from: c  reason: collision with root package name */
    public final Method f7001c;

    /* renamed from: d  reason: collision with root package name */
    public final Method f7002d;

    /* renamed from: e  reason: collision with root package name */
    public final Method f7003e;

    public e(Class cls) {
        this.f6999a = cls;
        Method declaredMethod = cls.getDeclaredMethod("setUseSessionTickets", Boolean.TYPE);
        com.google.common.collect.c.E(declaredMethod, "sslSocketClass.getDeclar…:class.javaPrimitiveType)");
        this.f7000b = declaredMethod;
        this.f7001c = cls.getMethod("setHostname", String.class);
        this.f7002d = cls.getMethod("getAlpnSelectedProtocol", new Class[0]);
        this.f7003e = cls.getMethod("setAlpnProtocols", byte[].class);
    }

    @Override // v3.m
    public final boolean a(SSLSocket sSLSocket) {
        return this.f6999a.isInstance(sSLSocket);
    }

    @Override // v3.m
    public final String b(SSLSocket sSLSocket) {
        if (!this.f6999a.isInstance(sSLSocket)) {
            return null;
        }
        try {
            byte[] bArr = (byte[]) this.f7002d.invoke(sSLSocket, new Object[0]);
            if (bArr == null) {
                return null;
            }
            return new String(bArr, l3.a.f5399a);
        } catch (IllegalAccessException e4) {
            throw new AssertionError(e4);
        } catch (InvocationTargetException e5) {
            Throwable cause = e5.getCause();
            if ((cause instanceof NullPointerException) && com.google.common.collect.c.n(((NullPointerException) cause).getMessage(), "ssl == null")) {
                return null;
            }
            throw new AssertionError(e5);
        }
    }

    @Override // v3.m
    public final boolean c() {
        return u3.c.f6911e.i();
    }

    @Override // v3.m
    public final void d(SSLSocket sSLSocket, String str, List list) {
        com.google.common.collect.c.F(list, "protocols");
        if (this.f6999a.isInstance(sSLSocket)) {
            try {
                this.f7000b.invoke(sSLSocket, Boolean.TRUE);
                if (str != null) {
                    this.f7001c.invoke(sSLSocket, str);
                }
                Method method = this.f7003e;
                u3.l lVar = u3.l.f6934a;
                method.invoke(sSLSocket, t3.a.f(list));
            } catch (IllegalAccessException e4) {
                throw new AssertionError(e4);
            } catch (InvocationTargetException e5) {
                throw new AssertionError(e5);
            }
        }
    }
}