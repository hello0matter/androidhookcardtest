package i1;

import javax.net.ssl.SSLSocket;
import l3.g;
import v3.e;
import v3.k;
import v3.m;

/* loaded from: classes.dex */
public final class c implements k {

    /* renamed from: a  reason: collision with root package name */
    public String f5021a = "com.google.android.gms.org.conscrypt";

    @Override // v3.k
    public boolean a(SSLSocket sSLSocket) {
        String name = sSLSocket.getClass().getName();
        return g.o2(name, this.f5021a + '.', false);
    }

    @Override // v3.k
    public m b(SSLSocket sSLSocket) {
        Class<?> cls = sSLSocket.getClass();
        Class<?> cls2 = cls;
        while (!com.google.common.collect.c.n(cls2.getSimpleName(), "OpenSSLSocketImpl")) {
            cls2 = cls2.getSuperclass();
            if (cls2 == null) {
                throw new AssertionError("No OpenSSLSocketImpl superclass of socket of type " + cls);
            }
        }
        return new e(cls2);
    }
}