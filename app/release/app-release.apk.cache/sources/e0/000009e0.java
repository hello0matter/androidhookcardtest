package u3;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* loaded from: classes.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    public static volatile l f6934a;

    /* renamed from: b  reason: collision with root package name */
    public static final Logger f6935b;

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0090, code lost:
        if (r1 != null) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0092, code lost:
        r0 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00b6, code lost:
        if (r1 != null) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00da, code lost:
        if (r0 != 0) goto L24;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15, types: [u3.l] */
    /* JADX WARN: Type inference failed for: r0v20, types: [u3.l] */
    /* JADX WARN: Type inference failed for: r0v22, types: [u3.l, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v6, types: [u3.l] */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v8 */
    static {
        /*
            Method dump skipped, instructions count: 263
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: u3.l.<clinit>():void");
    }

    public static void i(String str, int i4, Throwable th) {
        Level level;
        com.google.common.collect.c.F(str, "message");
        if (i4 == 5) {
            level = Level.WARNING;
        } else {
            level = Level.INFO;
        }
        f6935b.log(level, str, th);
    }

    public com.google.common.collect.c b(X509TrustManager x509TrustManager) {
        return new x3.a(c(x509TrustManager));
    }

    public x3.d c(X509TrustManager x509TrustManager) {
        X509Certificate[] acceptedIssuers = x509TrustManager.getAcceptedIssuers();
        com.google.common.collect.c.E(acceptedIssuers, "trustManager.acceptedIssuers");
        return new x3.b((X509Certificate[]) Arrays.copyOf(acceptedIssuers, acceptedIssuers.length));
    }

    public void d(SSLSocket sSLSocket, String str, List list) {
        com.google.common.collect.c.F(list, "protocols");
    }

    public void e(Socket socket, InetSocketAddress inetSocketAddress, int i4) {
        com.google.common.collect.c.F(inetSocketAddress, "address");
        socket.connect(inetSocketAddress, i4);
    }

    public String f(SSLSocket sSLSocket) {
        return null;
    }

    public Object g() {
        if (f6935b.isLoggable(Level.FINE)) {
            return new Throwable("response.body().close()");
        }
        return null;
    }

    public boolean h(String str) {
        com.google.common.collect.c.F(str, "hostname");
        return true;
    }

    public void j(Object obj, String str) {
        com.google.common.collect.c.F(str, "message");
        if (obj == null) {
            str = str.concat(" To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);");
        }
        i(str, 5, (Throwable) obj);
    }

    public SSLContext k() {
        SSLContext sSLContext = SSLContext.getInstance("TLS");
        com.google.common.collect.c.E(sSLContext, "getInstance(\"TLS\")");
        return sSLContext;
    }

    public SSLSocketFactory l(X509TrustManager x509TrustManager) {
        try {
            SSLContext k4 = k();
            k4.init(null, new TrustManager[]{x509TrustManager}, null);
            SSLSocketFactory socketFactory = k4.getSocketFactory();
            com.google.common.collect.c.E(socketFactory, "newSSLContext().apply {\n…ll)\n      }.socketFactory");
            return socketFactory;
        } catch (GeneralSecurityException e4) {
            throw new AssertionError("No System TLS: " + e4, e4);
        }
    }

    public X509TrustManager m() {
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
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

    public final String toString() {
        return getClass().getSimpleName();
    }

    public void a(SSLSocket sSLSocket) {
    }
}