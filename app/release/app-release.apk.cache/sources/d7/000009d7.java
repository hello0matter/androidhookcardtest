package u3;

import android.net.http.X509TrustManagerExtensions;
import android.os.Build;
import android.security.NetworkSecurityPolicy;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;
import v3.m;

/* loaded from: classes.dex */
public final class c extends l {

    /* renamed from: e  reason: collision with root package name */
    public static final t3.a f6911e = new t3.a(9, 0);

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f6912f;

    /* renamed from: c  reason: collision with root package name */
    public final ArrayList f6913c;

    /* renamed from: d  reason: collision with root package name */
    public final v3.h f6914d;

    static {
        boolean z4 = false;
        if (com.google.common.collect.c.n("Dalvik", System.getProperty("java.vm.name")) && Build.VERSION.SDK_INT < 30) {
            z4 = true;
        }
        f6912f = z4;
    }

    public c() {
        v3.e eVar;
        v3.k kVar;
        v3.k kVar2;
        Method method;
        Method method2;
        m[] mVarArr = new m[4];
        Method method3 = null;
        try {
            Class<?> cls = Class.forName("com.android.org.conscrypt".concat(".OpenSSLSocketImpl"));
            Class.forName("com.android.org.conscrypt".concat(".OpenSSLSocketFactoryImpl"));
            Class.forName("com.android.org.conscrypt".concat(".SSLParametersImpl"));
            eVar = new v3.e(cls);
        } catch (Exception e4) {
            l.f6934a.getClass();
            l.i("unable to load android socket classes", 5, e4);
            eVar = null;
        }
        mVarArr[0] = eVar;
        mVarArr[1] = new v3.l(v3.e.f6998f);
        switch (v3.j.f7009a.f6694a) {
            case 18:
                kVar = v3.g.f7005b;
                break;
            default:
                kVar = v3.j.f7010b;
                break;
        }
        mVarArr[2] = new v3.l(kVar);
        switch (v3.g.f7004a.f6694a) {
            case 18:
                kVar2 = v3.g.f7005b;
                break;
            default:
                kVar2 = v3.j.f7010b;
                break;
        }
        mVarArr[3] = new v3.l(kVar2);
        ArrayList m22 = y2.h.m2(mVarArr);
        ArrayList arrayList = new ArrayList();
        Iterator it = m22.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (((m) next).c()) {
                arrayList.add(next);
            }
        }
        this.f6913c = arrayList;
        try {
            Class<?> cls2 = Class.forName("dalvik.system.CloseGuard");
            Method method4 = cls2.getMethod("get", new Class[0]);
            method2 = cls2.getMethod("open", String.class);
            method = cls2.getMethod("warnIfOpen", new Class[0]);
            method3 = method4;
        } catch (Exception unused) {
            method = null;
            method2 = null;
        }
        this.f6914d = new v3.h(method3, method2, method);
    }

    @Override // u3.l
    public final com.google.common.collect.c b(X509TrustManager x509TrustManager) {
        X509TrustManagerExtensions x509TrustManagerExtensions;
        v3.b bVar = null;
        try {
            x509TrustManagerExtensions = new X509TrustManagerExtensions(x509TrustManager);
        } catch (IllegalArgumentException unused) {
            x509TrustManagerExtensions = null;
        }
        if (x509TrustManagerExtensions != null) {
            bVar = new v3.b(x509TrustManager, x509TrustManagerExtensions);
        }
        if (bVar == null) {
            return new x3.a(c(x509TrustManager));
        }
        return bVar;
    }

    @Override // u3.l
    public final x3.d c(X509TrustManager x509TrustManager) {
        try {
            Method declaredMethod = x509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", X509Certificate.class);
            declaredMethod.setAccessible(true);
            return new b(x509TrustManager, declaredMethod);
        } catch (NoSuchMethodException unused) {
            return super.c(x509TrustManager);
        }
    }

    @Override // u3.l
    public final void d(SSLSocket sSLSocket, String str, List list) {
        Object obj;
        com.google.common.collect.c.F(list, "protocols");
        Iterator it = this.f6913c.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((m) obj).a(sSLSocket)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        m mVar = (m) obj;
        if (mVar != null) {
            mVar.d(sSLSocket, str, list);
        }
    }

    @Override // u3.l
    public final void e(Socket socket, InetSocketAddress inetSocketAddress, int i4) {
        com.google.common.collect.c.F(inetSocketAddress, "address");
        try {
            socket.connect(inetSocketAddress, i4);
        } catch (ClassCastException e4) {
            if (Build.VERSION.SDK_INT == 26) {
                throw new IOException("Exception in connect", e4);
            }
            throw e4;
        }
    }

    @Override // u3.l
    public final String f(SSLSocket sSLSocket) {
        Object obj;
        Iterator it = this.f6913c.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((m) obj).a(sSLSocket)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        m mVar = (m) obj;
        if (mVar == null) {
            return null;
        }
        return mVar.b(sSLSocket);
    }

    @Override // u3.l
    public final Object g() {
        v3.h hVar = this.f6914d;
        hVar.getClass();
        Method method = hVar.f7006a;
        if (method == null) {
            return null;
        }
        try {
            Object invoke = method.invoke(null, new Object[0]);
            Method method2 = hVar.f7007b;
            com.google.common.collect.c.C(method2);
            method2.invoke(invoke, "response.body().close()");
            return invoke;
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // u3.l
    public final boolean h(String str) {
        com.google.common.collect.c.F(str, "hostname");
        return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(str);
    }

    @Override // u3.l
    public final void j(Object obj, String str) {
        com.google.common.collect.c.F(str, "message");
        v3.h hVar = this.f6914d;
        hVar.getClass();
        if (obj != null) {
            try {
                Method method = hVar.f7008c;
                com.google.common.collect.c.C(method);
                method.invoke(obj, new Object[0]);
                return;
            } catch (Exception unused) {
            }
        }
        l.i(str, 5, null);
    }
}