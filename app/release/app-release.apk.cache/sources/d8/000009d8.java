package u3;

import java.security.KeyStore;
import java.security.Provider;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import org.bouncycastle.jsse.BCSSLParameters;
import org.bouncycastle.jsse.BCSSLSocket;
import org.bouncycastle.jsse.provider.BouncyCastleJsseProvider;

/* loaded from: classes.dex */
public final class d extends l {

    /* renamed from: d  reason: collision with root package name */
    public static final t3.a f6915d = new t3.a(10, 0);

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f6916e;

    /* renamed from: c  reason: collision with root package name */
    public final Provider f6917c = new BouncyCastleJsseProvider();

    static {
        boolean z4 = false;
        try {
            Class.forName("org.bouncycastle.jsse.provider.BouncyCastleJsseProvider", false, t3.a.class.getClassLoader());
            z4 = true;
        } catch (ClassNotFoundException unused) {
        }
        f6916e = z4;
    }

    @Override // u3.l
    public final void d(SSLSocket sSLSocket, String str, List list) {
        com.google.common.collect.c.F(list, "protocols");
        if (sSLSocket instanceof BCSSLSocket) {
            BCSSLSocket bCSSLSocket = (BCSSLSocket) sSLSocket;
            BCSSLParameters parameters = bCSSLSocket.getParameters();
            parameters.setApplicationProtocols((String[]) t3.a.b(list).toArray(new String[0]));
            bCSSLSocket.setParameters(parameters);
            return;
        }
        super.d(sSLSocket, str, list);
    }

    @Override // u3.l
    public final String f(SSLSocket sSLSocket) {
        String applicationProtocol;
        if (!(sSLSocket instanceof BCSSLSocket) || (applicationProtocol = ((BCSSLSocket) sSLSocket).getApplicationProtocol()) == null || com.google.common.collect.c.n(applicationProtocol, "")) {
            return null;
        }
        return applicationProtocol;
    }

    @Override // u3.l
    public final SSLContext k() {
        SSLContext sSLContext = SSLContext.getInstance("TLS", this.f6917c);
        com.google.common.collect.c.E(sSLContext, "getInstance(\"TLS\", provider)");
        return sSLContext;
    }

    @Override // u3.l
    public final X509TrustManager m() {
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance("PKIX", "BCJSSE");
        trustManagerFactory.init((KeyStore) null);
        TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
        com.google.common.collect.c.C(trustManagers);
        if (trustManagers.length == 1) {
            TrustManager trustManager = trustManagers[0];
            if (trustManager instanceof X509TrustManager) {
                com.google.common.collect.c.D(trustManager, "null cannot be cast to non-null type javax.net.ssl.X509TrustManager");
                return (X509TrustManager) trustManager;
            }
        }
        String arrays = Arrays.toString(trustManagers);
        com.google.common.collect.c.E(arrays, "toString(this)");
        throw new IllegalStateException("Unexpected default trust managers: ".concat(arrays).toString());
    }
}