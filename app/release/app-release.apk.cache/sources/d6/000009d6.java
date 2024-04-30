package u3;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

/* loaded from: classes.dex */
public final class b implements x3.d {

    /* renamed from: a  reason: collision with root package name */
    public final X509TrustManager f6909a;

    /* renamed from: b  reason: collision with root package name */
    public final Method f6910b;

    public b(X509TrustManager x509TrustManager, Method method) {
        this.f6909a = x509TrustManager;
        this.f6910b = method;
    }

    @Override // x3.d
    public final X509Certificate a(X509Certificate x509Certificate) {
        try {
            Object invoke = this.f6910b.invoke(this.f6909a, x509Certificate);
            com.google.common.collect.c.D(invoke, "null cannot be cast to non-null type java.security.cert.TrustAnchor");
            return ((TrustAnchor) invoke).getTrustedCert();
        } catch (IllegalAccessException e4) {
            throw new AssertionError("unable to get issues and signature", e4);
        } catch (InvocationTargetException unused) {
            return null;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (com.google.common.collect.c.n(this.f6909a, bVar.f6909a) && com.google.common.collect.c.n(this.f6910b, bVar.f6910b)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.f6910b.hashCode() + (this.f6909a.hashCode() * 31);
    }

    public final String toString() {
        return "CustomTrustRootIndex(trustManager=" + this.f6909a + ", findByIssuerAndSignatureMethod=" + this.f6910b + ')';
    }
}