package u3;

import java.security.KeyStore;
import java.security.Provider;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import org.conscrypt.Conscrypt;

/* loaded from: classes.dex */
public final class g extends l {

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f6919d;

    /* renamed from: c  reason: collision with root package name */
    public final Provider f6920c;

    static {
        boolean z4 = false;
        try {
            Class.forName("org.conscrypt.Conscrypt$Version", false, e.class.getClassLoader());
            if (Conscrypt.isAvailable()) {
                if (e.a()) {
                    z4 = true;
                }
            }
        } catch (ClassNotFoundException | NoClassDefFoundError unused) {
        }
        f6919d = z4;
    }

    public g() {
        Provider newProvider = Conscrypt.newProvider();
        com.google.common.collect.c.E(newProvider, "newProvider()");
        this.f6920c = newProvider;
    }

    @Override // u3.l
    public final void d(SSLSocket sSLSocket, String str, List list) {
        com.google.common.collect.c.F(list, "protocols");
        if (Conscrypt.isConscrypt(sSLSocket)) {
            Conscrypt.setUseSessionTickets(sSLSocket, true);
            Conscrypt.setApplicationProtocols(sSLSocket, (String[]) t3.a.b(list).toArray(new String[0]));
            return;
        }
        super.d(sSLSocket, str, list);
    }

    @Override // u3.l
    public final String f(SSLSocket sSLSocket) {
        if (Conscrypt.isConscrypt(sSLSocket)) {
            return Conscrypt.getApplicationProtocol(sSLSocket);
        }
        return null;
    }

    @Override // u3.l
    public final SSLContext k() {
        SSLContext sSLContext = SSLContext.getInstance("TLS", this.f6920c);
        com.google.common.collect.c.E(sSLContext, "getInstance(\"TLS\", provider)");
        return sSLContext;
    }

    @Override // u3.l
    public final SSLSocketFactory l(X509TrustManager x509TrustManager) {
        SSLContext k4 = k();
        k4.init(null, new TrustManager[]{x509TrustManager}, null);
        SSLSocketFactory socketFactory = k4.getSocketFactory();
        com.google.common.collect.c.E(socketFactory, "newSSLContext().apply {\n…null)\n    }.socketFactory");
        return socketFactory;
    }

    @Override // u3.l
    public final X509TrustManager m() {
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init((KeyStore) null);
        TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
        com.google.common.collect.c.C(trustManagers);
        if (trustManagers.length == 1) {
            TrustManager trustManager = trustManagers[0];
            if (trustManager instanceof X509TrustManager) {
                com.google.common.collect.c.D(trustManager, "null cannot be cast to non-null type javax.net.ssl.X509TrustManager");
                X509TrustManager x509TrustManager = (X509TrustManager) trustManager;
                Conscrypt.setHostnameVerifier(x509TrustManager, f.f6918a);
                return x509TrustManager;
            }
        }
        String arrays = Arrays.toString(trustManagers);
        com.google.common.collect.c.E(arrays, "toString(this)");
        throw new IllegalStateException("Unexpected default trust managers: ".concat(arrays).toString());
    }
}