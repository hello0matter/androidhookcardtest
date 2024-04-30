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
import org.openjsse.javax.net.ssl.SSLParameters;
import org.openjsse.net.ssl.OpenJSSE;

/* loaded from: classes.dex */
public final class k extends l {

    /* renamed from: d  reason: collision with root package name */
    public static final t3.a f6931d = new t3.a(13, 0);

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f6932e;

    /* renamed from: c  reason: collision with root package name */
    public final Provider f6933c = new OpenJSSE();

    static {
        boolean z4 = false;
        try {
            Class.forName("org.openjsse.net.ssl.OpenJSSE", false, t3.a.class.getClassLoader());
            z4 = true;
        } catch (ClassNotFoundException unused) {
        }
        f6932e = z4;
    }

    @Override // u3.l
    public final void d(SSLSocket sSLSocket, String str, List list) {
        com.google.common.collect.c.F(list, "protocols");
        if (sSLSocket instanceof org.openjsse.javax.net.ssl.SSLSocket) {
            org.openjsse.javax.net.ssl.SSLSocket sSLSocket2 = (org.openjsse.javax.net.ssl.SSLSocket) sSLSocket;
            SSLParameters sSLParameters = sSLSocket2.getSSLParameters();
            if (sSLParameters instanceof SSLParameters) {
                sSLParameters.setApplicationProtocols((String[]) t3.a.b(list).toArray(new String[0]));
                sSLSocket2.setSSLParameters(sSLParameters);
                return;
            }
            return;
        }
        super.d(sSLSocket, str, list);
    }

    @Override // u3.l
    public final String f(SSLSocket sSLSocket) {
        String applicationProtocol;
        if (!(sSLSocket instanceof org.openjsse.javax.net.ssl.SSLSocket) || (applicationProtocol = ((org.openjsse.javax.net.ssl.SSLSocket) sSLSocket).getApplicationProtocol()) == null || com.google.common.collect.c.n(applicationProtocol, "")) {
            return null;
        }
        return applicationProtocol;
    }

    @Override // u3.l
    public final SSLContext k() {
        SSLContext sSLContext = SSLContext.getInstance("TLSv1.3", this.f6933c);
        com.google.common.collect.c.E(sSLContext, "getInstance(\"TLSv1.3\", provider)");
        return sSLContext;
    }

    @Override // u3.l
    public final X509TrustManager m() {
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm(), this.f6933c);
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