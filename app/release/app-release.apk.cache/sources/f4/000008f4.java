package okhttp3;

import androidx.fragment.app.m0;
import java.io.IOException;
import java.security.cert.Certificate;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import kotlin.collections.EmptyList;
import m3.e;

/* loaded from: classes.dex */
public abstract class b {
    public static c a(SSLSession sSLSession) {
        final List list;
        List list2;
        String cipherSuite = sSLSession.getCipherSuite();
        if (cipherSuite != null) {
            if (!com.google.common.collect.c.n(cipherSuite, "TLS_NULL_WITH_NULL_NULL") && !com.google.common.collect.c.n(cipherSuite, "SSL_NULL_WITH_NULL_NULL")) {
                e i4 = e.f5486b.i(cipherSuite);
                String protocol = sSLSession.getProtocol();
                if (protocol != null) {
                    if (!com.google.common.collect.c.n("NONE", protocol)) {
                        TlsVersion j4 = m0.j(protocol);
                        try {
                            Certificate[] peerCertificates = sSLSession.getPeerCertificates();
                            if (peerCertificates != null) {
                                list = n3.b.l(Arrays.copyOf(peerCertificates, peerCertificates.length));
                            } else {
                                list = EmptyList.f5181a;
                            }
                        } catch (SSLPeerUnverifiedException unused) {
                            list = EmptyList.f5181a;
                        }
                        Certificate[] localCertificates = sSLSession.getLocalCertificates();
                        if (localCertificates != null) {
                            list2 = n3.b.l(Arrays.copyOf(localCertificates, localCertificates.length));
                        } else {
                            list2 = EmptyList.f5181a;
                        }
                        return new c(j4, i4, list2, new e3.a() { // from class: okhttp3.Handshake$Companion$handshake$1
                            @Override // e3.a
                            public final Object a() {
                                return list;
                            }
                        });
                    }
                    throw new IOException("tlsVersion == NONE");
                }
                throw new IllegalStateException("tlsVersion == null".toString());
            }
            throw new IOException("cipherSuite == ".concat(cipherSuite));
        }
        throw new IllegalStateException("cipherSuite == null".toString());
    }
}