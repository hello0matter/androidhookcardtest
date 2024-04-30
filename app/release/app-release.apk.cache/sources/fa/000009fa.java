package v3;

import android.net.http.X509TrustManagerExtensions;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.X509TrustManager;

/* loaded from: classes.dex */
public final class b extends com.google.common.collect.c {

    /* renamed from: q  reason: collision with root package name */
    public final X509TrustManager f6993q;

    /* renamed from: r  reason: collision with root package name */
    public final X509TrustManagerExtensions f6994r;

    public b(X509TrustManager x509TrustManager, X509TrustManagerExtensions x509TrustManagerExtensions) {
        this.f6993q = x509TrustManager;
        this.f6994r = x509TrustManagerExtensions;
    }

    @Override // com.google.common.collect.c
    public final List O(String str, List list) {
        com.google.common.collect.c.F(list, "chain");
        com.google.common.collect.c.F(str, "hostname");
        try {
            List<X509Certificate> checkServerTrusted = this.f6994r.checkServerTrusted((X509Certificate[]) list.toArray(new X509Certificate[0]), "RSA", str);
            com.google.common.collect.c.E(checkServerTrusted, "x509TrustManagerExtensio…ficates, \"RSA\", hostname)");
            return checkServerTrusted;
        } catch (CertificateException e4) {
            SSLPeerUnverifiedException sSLPeerUnverifiedException = new SSLPeerUnverifiedException(e4.getMessage());
            sSLPeerUnverifiedException.initCause(e4);
            throw sSLPeerUnverifiedException;
        }
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof b) && ((b) obj).f6993q == this.f6993q) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return System.identityHashCode(this.f6993q);
    }
}