package u3;

import android.net.http.X509TrustManagerExtensions;
import android.os.Build;
import android.security.NetworkSecurityPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;
import v3.m;

/* loaded from: classes.dex */
public final class a extends l {

    /* renamed from: d  reason: collision with root package name */
    public static final t3.a f6906d = new t3.a(8, 0);

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f6907e;

    /* renamed from: c  reason: collision with root package name */
    public final ArrayList f6908c;

    static {
        boolean z4 = false;
        if (com.google.common.collect.c.n("Dalvik", System.getProperty("java.vm.name")) && Build.VERSION.SDK_INT >= 29) {
            z4 = true;
        }
        f6907e = z4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a() {
        Object obj;
        v3.k kVar;
        v3.k kVar2;
        m[] mVarArr = new m[4];
        if (v3.a.f6992a.i()) {
            obj = new Object();
        } else {
            obj = null;
        }
        mVarArr[0] = obj;
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
        this.f6908c = arrayList;
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
    public final void d(SSLSocket sSLSocket, String str, List list) {
        Object obj;
        com.google.common.collect.c.F(list, "protocols");
        Iterator it = this.f6908c.iterator();
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
    public final String f(SSLSocket sSLSocket) {
        Object obj;
        Iterator it = this.f6908c.iterator();
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
    public final boolean h(String str) {
        com.google.common.collect.c.F(str, "hostname");
        return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(str);
    }
}