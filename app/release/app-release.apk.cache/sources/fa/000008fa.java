package okhttp3.internal.connection;

import androidx.fragment.app.m0;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Socket;
import java.net.UnknownServiceException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import m3.k;
import m3.m;
import m3.t;
import m3.v;
import m3.w;
import m3.z;
import okhttp3.Protocol;
import okhttp3.c;
import okhttp3.internal.http2.ErrorCode;
import okio.ByteString;
import q3.b;
import q3.j;
import q3.l;
import r3.d;
import r3.f;
import s3.e;
import s3.h;
import t3.a0;
import t3.d0;
import t3.i;
import t3.s;
import w1.g;
import y3.n;
import y3.o;

/* loaded from: classes.dex */
public final class a extends i {

    /* renamed from: b  reason: collision with root package name */
    public final z f6017b;

    /* renamed from: c  reason: collision with root package name */
    public Socket f6018c;

    /* renamed from: d  reason: collision with root package name */
    public Socket f6019d;

    /* renamed from: e  reason: collision with root package name */
    public c f6020e;

    /* renamed from: f  reason: collision with root package name */
    public Protocol f6021f;

    /* renamed from: g  reason: collision with root package name */
    public s f6022g;

    /* renamed from: h  reason: collision with root package name */
    public o f6023h;

    /* renamed from: i  reason: collision with root package name */
    public n f6024i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f6025j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f6026k;

    /* renamed from: l  reason: collision with root package name */
    public int f6027l;

    /* renamed from: m  reason: collision with root package name */
    public int f6028m;

    /* renamed from: n  reason: collision with root package name */
    public int f6029n;

    /* renamed from: o  reason: collision with root package name */
    public int f6030o;

    /* renamed from: p  reason: collision with root package name */
    public final ArrayList f6031p;

    /* renamed from: q  reason: collision with root package name */
    public long f6032q;

    public a(l lVar, z zVar) {
        com.google.common.collect.c.F(lVar, "connectionPool");
        com.google.common.collect.c.F(zVar, "route");
        this.f6017b = zVar;
        this.f6030o = 1;
        this.f6031p = new ArrayList();
        this.f6032q = Long.MAX_VALUE;
    }

    public static void d(m3.s sVar, z zVar, IOException iOException) {
        com.google.common.collect.c.F(sVar, "client");
        com.google.common.collect.c.F(zVar, "failedRoute");
        com.google.common.collect.c.F(iOException, "failure");
        if (zVar.f5642b.type() != Proxy.Type.DIRECT) {
            m3.a aVar = zVar.f5641a;
            aVar.f5467h.connectFailed(aVar.f5468i.g(), zVar.f5642b.address(), iOException);
        }
        g gVar = sVar.f5601y;
        synchronized (gVar) {
            ((Set) gVar.f7056b).add(zVar);
        }
    }

    @Override // t3.i
    public final synchronized void a(s sVar, d0 d0Var) {
        int i4;
        com.google.common.collect.c.F(sVar, "connection");
        com.google.common.collect.c.F(d0Var, "settings");
        if ((d0Var.f6732a & 16) != 0) {
            i4 = d0Var.f6733b[4];
        } else {
            i4 = Integer.MAX_VALUE;
        }
        this.f6030o = i4;
    }

    @Override // t3.i
    public final void b(t3.z zVar) {
        com.google.common.collect.c.F(zVar, "stream");
        zVar.c(ErrorCode.f6037f, null);
    }

    public final void c(int i4, int i5, int i6, boolean z4, j jVar, k kVar) {
        z zVar;
        com.google.common.collect.c.F(jVar, "call");
        com.google.common.collect.c.F(kVar, "eventListener");
        if (this.f6021f == null) {
            List list = this.f6017b.f5641a.f5470k;
            b bVar = new b(list);
            m3.a aVar = this.f6017b.f5641a;
            if (aVar.f5462c == null) {
                if (list.contains(m3.g.f5511f)) {
                    String str = this.f6017b.f5641a.f5468i.f5546d;
                    u3.l lVar = u3.l.f6934a;
                    if (!u3.l.f6934a.h(str)) {
                        throw new RouteException(new UnknownServiceException(androidx.activity.j.d("CLEARTEXT communication to ", str, " not permitted by network security policy")));
                    }
                } else {
                    throw new RouteException(new UnknownServiceException("CLEARTEXT communication not enabled for client"));
                }
            } else if (aVar.f5469j.contains(Protocol.H2_PRIOR_KNOWLEDGE)) {
                throw new RouteException(new UnknownServiceException("H2_PRIOR_KNOWLEDGE cannot be used with HTTPS"));
            }
            RouteException routeException = null;
            do {
                try {
                    z zVar2 = this.f6017b;
                    if (zVar2.f5641a.f5462c != null && zVar2.f5642b.type() == Proxy.Type.HTTP) {
                        f(i4, i5, i6, jVar, kVar);
                        if (this.f6018c == null) {
                            zVar = this.f6017b;
                            if (zVar.f5641a.f5462c == null && zVar.f5642b.type() == Proxy.Type.HTTP && this.f6018c == null) {
                                throw new RouteException(new ProtocolException("Too many tunnel connections attempted: 21"));
                            }
                            this.f6032q = System.nanoTime();
                            return;
                        }
                    } else {
                        try {
                            e(i4, i5, jVar, kVar);
                        } catch (IOException e4) {
                            e = e4;
                            Socket socket = this.f6019d;
                            if (socket != null) {
                                n3.b.e(socket);
                            }
                            Socket socket2 = this.f6018c;
                            if (socket2 != null) {
                                n3.b.e(socket2);
                            }
                            this.f6019d = null;
                            this.f6018c = null;
                            this.f6023h = null;
                            this.f6024i = null;
                            this.f6020e = null;
                            this.f6021f = null;
                            this.f6022g = null;
                            this.f6030o = 1;
                            z zVar3 = this.f6017b;
                            InetSocketAddress inetSocketAddress = zVar3.f5643c;
                            Proxy proxy = zVar3.f5642b;
                            com.google.common.collect.c.F(inetSocketAddress, "inetSocketAddress");
                            com.google.common.collect.c.F(proxy, "proxy");
                            if (routeException == null) {
                                routeException = new RouteException(e);
                            } else {
                                kotlin.a.a(routeException.f6015a, e);
                                routeException.f6016b = e;
                            }
                            if (!z4) {
                                break;
                            }
                            bVar.f6361d = true;
                            if (!bVar.f6360c) {
                                break;
                            } else if (e instanceof ProtocolException) {
                                break;
                            } else if (e instanceof InterruptedIOException) {
                                break;
                            } else {
                                if (e instanceof SSLHandshakeException) {
                                    if (e.getCause() instanceof CertificateException) {
                                        break;
                                    }
                                }
                                if (e instanceof SSLPeerUnverifiedException) {
                                    break;
                                } else if (!(e instanceof SSLException)) {
                                }
                            }
                            throw routeException;
                        }
                    }
                    g(bVar, jVar, kVar);
                    z zVar4 = this.f6017b;
                    InetSocketAddress inetSocketAddress2 = zVar4.f5643c;
                    Proxy proxy2 = zVar4.f5642b;
                    com.google.common.collect.c.F(inetSocketAddress2, "inetSocketAddress");
                    com.google.common.collect.c.F(proxy2, "proxy");
                    zVar = this.f6017b;
                    if (zVar.f5641a.f5462c == null) {
                    }
                    this.f6032q = System.nanoTime();
                    return;
                } catch (IOException e5) {
                    e = e5;
                }
            } while (!(e instanceof SSLException));
            throw routeException;
        }
        throw new IllegalStateException("already connected".toString());
    }

    public final void e(int i4, int i5, j jVar, k kVar) {
        int i6;
        Socket createSocket;
        z zVar = this.f6017b;
        Proxy proxy = zVar.f5642b;
        m3.a aVar = zVar.f5641a;
        Proxy.Type type = proxy.type();
        if (type == null) {
            i6 = -1;
        } else {
            i6 = q3.k.f6415a[type.ordinal()];
        }
        if (i6 != 1 && i6 != 2) {
            createSocket = new Socket(proxy);
        } else {
            createSocket = aVar.f5461b.createSocket();
            com.google.common.collect.c.C(createSocket);
        }
        this.f6018c = createSocket;
        InetSocketAddress inetSocketAddress = this.f6017b.f5643c;
        kVar.getClass();
        com.google.common.collect.c.F(jVar, "call");
        com.google.common.collect.c.F(inetSocketAddress, "inetSocketAddress");
        createSocket.setSoTimeout(i5);
        try {
            u3.l lVar = u3.l.f6934a;
            u3.l.f6934a.e(createSocket, this.f6017b.f5643c, i4);
            try {
                this.f6023h = new o(com.google.common.collect.c.X1(createSocket));
                this.f6024i = new n(com.google.common.collect.c.W1(createSocket));
            } catch (NullPointerException e4) {
                if (!com.google.common.collect.c.n(e4.getMessage(), "throw with null exception")) {
                    return;
                }
                throw new IOException(e4);
            }
        } catch (ConnectException e5) {
            ConnectException connectException = new ConnectException("Failed to connect to " + this.f6017b.f5643c);
            connectException.initCause(e5);
            throw connectException;
        }
    }

    public final void f(int i4, int i5, int i6, j jVar, k kVar) {
        t tVar = new t();
        z zVar = this.f6017b;
        m3.o oVar = zVar.f5641a.f5468i;
        com.google.common.collect.c.F(oVar, "url");
        tVar.f5602a = oVar;
        tVar.c("CONNECT", null);
        m3.a aVar = zVar.f5641a;
        tVar.b("Host", n3.b.w(aVar.f5468i, true));
        tVar.b("Proxy-Connection", "Keep-Alive");
        tVar.b("User-Agent", "okhttp/4.12.0");
        androidx.appcompat.widget.z a5 = tVar.a();
        v vVar = new v();
        vVar.f5611a = a5;
        vVar.f5612b = Protocol.HTTP_1_1;
        vVar.f5613c = 407;
        vVar.f5614d = "Preemptive Authenticate";
        vVar.f5617g = n3.b.f5785c;
        vVar.f5621k = -1L;
        vVar.f5622l = -1L;
        m3.l lVar = vVar.f5616f;
        lVar.getClass();
        m0.f("Proxy-Authenticate");
        m0.g("OkHttp-Preemptive", "Proxy-Authenticate");
        lVar.c("Proxy-Authenticate");
        lVar.a("Proxy-Authenticate", "OkHttp-Preemptive");
        vVar.a();
        ((k) aVar.f5465f).getClass();
        e(i4, i5, jVar, kVar);
        o oVar2 = this.f6023h;
        com.google.common.collect.c.C(oVar2);
        n nVar = this.f6024i;
        com.google.common.collect.c.C(nVar);
        h hVar = new h(null, this, oVar2, nVar);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        oVar2.f7197a.a().g(i5, timeUnit);
        nVar.f7194a.a().g(i6, timeUnit);
        hVar.j((m) a5.f991d, "CONNECT " + n3.b.w((m3.o) a5.f989b, true) + " HTTP/1.1");
        hVar.c();
        v f4 = hVar.f(false);
        com.google.common.collect.c.C(f4);
        f4.f5611a = a5;
        w a6 = f4.a();
        long k4 = n3.b.k(a6);
        if (k4 != -1) {
            e i7 = hVar.i(k4);
            n3.b.u(i7, Integer.MAX_VALUE, timeUnit);
            i7.close();
        }
        int i8 = a6.f5627d;
        if (i8 != 200) {
            if (i8 == 407) {
                ((k) aVar.f5465f).getClass();
                throw new IOException("Failed to authenticate with proxy");
            }
            throw new IOException(androidx.activity.j.b("Unexpected response code for CONNECT: ", i8));
        } else if (oVar2.f7198b.r() && nVar.f7195b.r()) {
        } else {
            throw new IOException("TLS tunnel buffered too many bytes!");
        }
    }

    public final void g(b bVar, j jVar, k kVar) {
        SSLSocket sSLSocket;
        m3.a aVar = this.f6017b.f5641a;
        SSLSocketFactory sSLSocketFactory = aVar.f5462c;
        Protocol protocol = Protocol.HTTP_1_1;
        if (sSLSocketFactory == null) {
            List list = aVar.f5469j;
            Protocol protocol2 = Protocol.H2_PRIOR_KNOWLEDGE;
            if (list.contains(protocol2)) {
                this.f6019d = this.f6018c;
                this.f6021f = protocol2;
                l();
                return;
            }
            this.f6019d = this.f6018c;
            this.f6021f = protocol;
            return;
        }
        kVar.getClass();
        com.google.common.collect.c.F(jVar, "call");
        final m3.a aVar2 = this.f6017b.f5641a;
        SSLSocketFactory sSLSocketFactory2 = aVar2.f5462c;
        SSLSocket sSLSocket2 = null;
        String str = null;
        try {
            com.google.common.collect.c.C(sSLSocketFactory2);
            Socket socket = this.f6018c;
            m3.o oVar = aVar2.f5468i;
            Socket createSocket = sSLSocketFactory2.createSocket(socket, oVar.f5546d, oVar.f5547e, true);
            com.google.common.collect.c.D(createSocket, "null cannot be cast to non-null type javax.net.ssl.SSLSocket");
            sSLSocket = (SSLSocket) createSocket;
        } catch (Throwable th) {
            th = th;
        }
        try {
            m3.g a5 = bVar.a(sSLSocket);
            if (a5.f5513b) {
                u3.l lVar = u3.l.f6934a;
                u3.l.f6934a.d(sSLSocket, aVar2.f5468i.f5546d, aVar2.f5469j);
            }
            sSLSocket.startHandshake();
            SSLSession session = sSLSocket.getSession();
            com.google.common.collect.c.E(session, "sslSocketSession");
            final c a6 = okhttp3.b.a(session);
            HostnameVerifier hostnameVerifier = aVar2.f5463d;
            com.google.common.collect.c.C(hostnameVerifier);
            if (!hostnameVerifier.verify(aVar2.f5468i.f5546d, session)) {
                List a7 = a6.a();
                if (!a7.isEmpty()) {
                    Object obj = a7.get(0);
                    com.google.common.collect.c.D(obj, "null cannot be cast to non-null type java.security.cert.X509Certificate");
                    X509Certificate x509Certificate = (X509Certificate) obj;
                    StringBuilder sb = new StringBuilder("\n              |Hostname ");
                    sb.append(aVar2.f5468i.f5546d);
                    sb.append(" not verified:\n              |    certificate: ");
                    okhttp3.a aVar3 = okhttp3.a.f6004c;
                    StringBuilder sb2 = new StringBuilder("sha256/");
                    ByteString byteString = ByteString.f6049d;
                    byte[] encoded = x509Certificate.getPublicKey().getEncoded();
                    com.google.common.collect.c.E(encoded, "publicKey.encoded");
                    sb2.append(t3.a.k(encoded).b("SHA-256").a());
                    sb.append(sb2.toString());
                    sb.append("\n              |    DN: ");
                    sb.append(x509Certificate.getSubjectDN().getName());
                    sb.append("\n              |    subjectAltNames: ");
                    List a8 = x3.c.a(x509Certificate, 7);
                    List a9 = x3.c.a(x509Certificate, 2);
                    com.google.common.collect.c.F(a8, "<this>");
                    com.google.common.collect.c.F(a9, "elements");
                    ArrayList arrayList = new ArrayList(a9.size() + a8.size());
                    arrayList.addAll(a8);
                    arrayList.addAll(a9);
                    sb.append(arrayList);
                    sb.append("\n              ");
                    throw new SSLPeerUnverifiedException(kotlin.text.a.h2(sb.toString()));
                }
                throw new SSLPeerUnverifiedException("Hostname " + aVar2.f5468i.f5546d + " not verified (no certificates)");
            }
            final okhttp3.a aVar4 = aVar2.f5464e;
            com.google.common.collect.c.C(aVar4);
            this.f6020e = new c(a6.f6007a, a6.f6008b, a6.f6009c, new e3.a() { // from class: okhttp3.internal.connection.RealConnection$connectTls$1
                @Override // e3.a
                public final Object a() {
                    com.google.common.collect.c cVar = okhttp3.a.this.f6006b;
                    com.google.common.collect.c.C(cVar);
                    return cVar.O(aVar2.f5468i.f5546d, a6.a());
                }
            });
            aVar4.b(aVar2.f5468i.f5546d, new e3.a() { // from class: okhttp3.internal.connection.RealConnection$connectTls$2
                @Override // e3.a
                public final Object a() {
                    c cVar = a.this.f6020e;
                    com.google.common.collect.c.C(cVar);
                    List<Certificate> a10 = cVar.a();
                    ArrayList arrayList2 = new ArrayList(y2.h.h2(a10));
                    for (Certificate certificate : a10) {
                        com.google.common.collect.c.D(certificate, "null cannot be cast to non-null type java.security.cert.X509Certificate");
                        arrayList2.add((X509Certificate) certificate);
                    }
                    return arrayList2;
                }
            });
            if (a5.f5513b) {
                u3.l lVar2 = u3.l.f6934a;
                str = u3.l.f6934a.f(sSLSocket);
            }
            this.f6019d = sSLSocket;
            this.f6023h = new o(com.google.common.collect.c.X1(sSLSocket));
            this.f6024i = new n(com.google.common.collect.c.W1(sSLSocket));
            if (str != null) {
                protocol = m0.l(str);
            }
            this.f6021f = protocol;
            u3.l lVar3 = u3.l.f6934a;
            u3.l.f6934a.a(sSLSocket);
            if (this.f6021f == Protocol.HTTP_2) {
                l();
            }
        } catch (Throwable th2) {
            th = th2;
            sSLSocket2 = sSLSocket;
            if (sSLSocket2 != null) {
                u3.l lVar4 = u3.l.f6934a;
                u3.l.f6934a.a(sSLSocket2);
            }
            if (sSLSocket2 != null) {
                n3.b.e(sSLSocket2);
            }
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x00af, code lost:
        if (x3.c.c(r0, (java.security.cert.X509Certificate) r10) != false) goto L45;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean h(m3.a r9, java.util.List r10) {
        /*
            r8 = this;
            java.lang.String r0 = "address"
            com.google.common.collect.c.F(r9, r0)
            byte[] r0 = n3.b.f5783a
            java.util.ArrayList r0 = r8.f6031p
            int r0 = r0.size()
            int r1 = r8.f6030o
            r2 = 0
            if (r0 >= r1) goto Lc3
            boolean r0 = r8.f6025j
            if (r0 == 0) goto L18
            goto Lc3
        L18:
            m3.z r0 = r8.f6017b
            m3.a r1 = r0.f5641a
            boolean r1 = r1.a(r9)
            if (r1 != 0) goto L23
            return r2
        L23:
            m3.o r1 = r9.f5468i
            java.lang.String r3 = r1.f5546d
            m3.a r4 = r0.f5641a
            m3.o r5 = r4.f5468i
            java.lang.String r5 = r5.f5546d
            boolean r3 = com.google.common.collect.c.n(r3, r5)
            r5 = 1
            if (r3 == 0) goto L35
            return r5
        L35:
            t3.s r3 = r8.f6022g
            if (r3 != 0) goto L3a
            return r2
        L3a:
            if (r10 == 0) goto Lc3
            boolean r3 = r10.isEmpty()
            if (r3 == 0) goto L44
            goto Lc3
        L44:
            java.util.Iterator r10 = r10.iterator()
        L48:
            boolean r3 = r10.hasNext()
            if (r3 == 0) goto Lc3
            java.lang.Object r3 = r10.next()
            m3.z r3 = (m3.z) r3
            java.net.Proxy r6 = r3.f5642b
            java.net.Proxy$Type r6 = r6.type()
            java.net.Proxy$Type r7 = java.net.Proxy.Type.DIRECT
            if (r6 != r7) goto L48
            java.net.Proxy r6 = r0.f5642b
            java.net.Proxy$Type r6 = r6.type()
            if (r6 != r7) goto L48
            java.net.InetSocketAddress r3 = r3.f5643c
            java.net.InetSocketAddress r6 = r0.f5643c
            boolean r3 = com.google.common.collect.c.n(r6, r3)
            if (r3 == 0) goto L48
            x3.c r10 = x3.c.f7146a
            javax.net.ssl.HostnameVerifier r0 = r9.f5463d
            if (r0 == r10) goto L77
            return r2
        L77:
            byte[] r10 = n3.b.f5783a
            m3.o r10 = r4.f5468i
            int r0 = r10.f5547e
            int r3 = r1.f5547e
            if (r3 == r0) goto L82
            goto Lc3
        L82:
            java.lang.String r10 = r10.f5546d
            java.lang.String r0 = r1.f5546d
            boolean r10 = com.google.common.collect.c.n(r0, r10)
            if (r10 == 0) goto L8d
            goto Lb1
        L8d:
            boolean r10 = r8.f6026k
            if (r10 != 0) goto Lc3
            okhttp3.c r10 = r8.f6020e
            if (r10 == 0) goto Lc3
            java.util.List r10 = r10.a()
            boolean r1 = r10.isEmpty()
            r1 = r1 ^ r5
            if (r1 == 0) goto Lc3
            java.lang.Object r10 = r10.get(r2)
            java.lang.String r1 = "null cannot be cast to non-null type java.security.cert.X509Certificate"
            com.google.common.collect.c.D(r10, r1)
            java.security.cert.X509Certificate r10 = (java.security.cert.X509Certificate) r10
            boolean r10 = x3.c.c(r0, r10)
            if (r10 == 0) goto Lc3
        Lb1:
            okhttp3.a r9 = r9.f5464e     // Catch: javax.net.ssl.SSLPeerUnverifiedException -> Lc3
            com.google.common.collect.c.C(r9)     // Catch: javax.net.ssl.SSLPeerUnverifiedException -> Lc3
            okhttp3.c r10 = r8.f6020e     // Catch: javax.net.ssl.SSLPeerUnverifiedException -> Lc3
            com.google.common.collect.c.C(r10)     // Catch: javax.net.ssl.SSLPeerUnverifiedException -> Lc3
            java.util.List r10 = r10.a()     // Catch: javax.net.ssl.SSLPeerUnverifiedException -> Lc3
            r9.a(r0, r10)     // Catch: javax.net.ssl.SSLPeerUnverifiedException -> Lc3
            return r5
        Lc3:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.a.h(m3.a, java.util.List):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0047, code lost:
        if (r0 >= r2.f6793q) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean i(boolean r10) {
        /*
            r9 = this;
            byte[] r0 = n3.b.f5783a
            long r0 = java.lang.System.nanoTime()
            java.net.Socket r2 = r9.f6018c
            com.google.common.collect.c.C(r2)
            java.net.Socket r3 = r9.f6019d
            com.google.common.collect.c.C(r3)
            y3.o r4 = r9.f6023h
            com.google.common.collect.c.C(r4)
            boolean r2 = r2.isClosed()
            r5 = 0
            if (r2 != 0) goto L7d
            boolean r2 = r3.isClosed()
            if (r2 != 0) goto L7d
            boolean r2 = r3.isInputShutdown()
            if (r2 != 0) goto L7d
            boolean r2 = r3.isOutputShutdown()
            if (r2 == 0) goto L2f
            goto L7d
        L2f:
            t3.s r2 = r9.f6022g
            r6 = 1
            if (r2 == 0) goto L51
            monitor-enter(r2)
            boolean r10 = r2.f6783g     // Catch: java.lang.Throwable -> L4a
            if (r10 == 0) goto L3b
        L39:
            monitor-exit(r2)
            goto L4e
        L3b:
            long r3 = r2.f6792p     // Catch: java.lang.Throwable -> L4a
            long r7 = r2.f6791o     // Catch: java.lang.Throwable -> L4a
            int r10 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r10 >= 0) goto L4c
            long r3 = r2.f6793q     // Catch: java.lang.Throwable -> L4a
            int r10 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r10 < 0) goto L4c
            goto L39
        L4a:
            r10 = move-exception
            goto L4f
        L4c:
            monitor-exit(r2)
            r5 = r6
        L4e:
            return r5
        L4f:
            monitor-exit(r2)
            throw r10
        L51:
            monitor-enter(r9)
            long r7 = r9.f6032q     // Catch: java.lang.Throwable -> L7a
            long r0 = r0 - r7
            monitor-exit(r9)
            r7 = 10000000000(0x2540be400, double:4.9406564584E-314)
            int r0 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r0 < 0) goto L79
            if (r10 == 0) goto L79
            int r10 = r3.getSoTimeout()     // Catch: java.net.SocketTimeoutException -> L77 java.io.IOException -> L78
            r3.setSoTimeout(r6)     // Catch: java.lang.Throwable -> L72
            boolean r0 = r4.r()     // Catch: java.lang.Throwable -> L72
            r0 = r0 ^ r6
            r3.setSoTimeout(r10)     // Catch: java.net.SocketTimeoutException -> L77 java.io.IOException -> L78
            r5 = r0
            goto L78
        L72:
            r0 = move-exception
            r3.setSoTimeout(r10)     // Catch: java.net.SocketTimeoutException -> L77 java.io.IOException -> L78
            throw r0     // Catch: java.net.SocketTimeoutException -> L77 java.io.IOException -> L78
        L77:
            r5 = r6
        L78:
            return r5
        L79:
            return r6
        L7a:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        L7d:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.a.i(boolean):boolean");
    }

    public final d j(m3.s sVar, f fVar) {
        Socket socket = this.f6019d;
        com.google.common.collect.c.C(socket);
        o oVar = this.f6023h;
        com.google.common.collect.c.C(oVar);
        n nVar = this.f6024i;
        com.google.common.collect.c.C(nVar);
        s sVar2 = this.f6022g;
        if (sVar2 != null) {
            return new t3.t(sVar, this, fVar, sVar2);
        }
        int i4 = fVar.f6478g;
        socket.setSoTimeout(i4);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        oVar.f7197a.a().g(i4, timeUnit);
        nVar.f7194a.a().g(fVar.f6479h, timeUnit);
        return new h(sVar, this, oVar, nVar);
    }

    public final synchronized void k() {
        this.f6025j = true;
    }

    public final void l() {
        String concat;
        int i4;
        int a5;
        int i5;
        Socket socket = this.f6019d;
        com.google.common.collect.c.C(socket);
        o oVar = this.f6023h;
        com.google.common.collect.c.C(oVar);
        n nVar = this.f6024i;
        com.google.common.collect.c.C(nVar);
        socket.setSoTimeout(0);
        p3.f fVar = p3.f.f6160i;
        t3.g gVar = new t3.g(fVar);
        String str = this.f6017b.f5641a.f5468i.f5546d;
        com.google.common.collect.c.F(str, "peerName");
        gVar.f6742c = socket;
        if (gVar.f6740a) {
            concat = n3.b.f5789g + ' ' + str;
        } else {
            concat = "MockWebServer ".concat(str);
        }
        com.google.common.collect.c.F(concat, "<set-?>");
        gVar.f6743d = concat;
        gVar.f6744e = oVar;
        gVar.f6745f = nVar;
        gVar.f6746g = this;
        gVar.f6748i = 0;
        s sVar = new s(gVar);
        this.f6022g = sVar;
        d0 d0Var = s.B;
        if ((d0Var.f6732a & 16) != 0) {
            i4 = d0Var.f6733b[4];
        } else {
            i4 = Integer.MAX_VALUE;
        }
        this.f6030o = i4;
        a0 a0Var = sVar.f6801y;
        synchronized (a0Var) {
            try {
                if (!a0Var.f6700e) {
                    if (a0Var.f6697b) {
                        Logger logger = a0.f6695g;
                        if (logger.isLoggable(Level.FINE)) {
                            logger.fine(n3.b.i(">> CONNECTION " + t3.f.f6736a.d(), new Object[0]));
                        }
                        a0Var.f6696a.c(t3.f.f6736a);
                        a0Var.f6696a.flush();
                    }
                } else {
                    throw new IOException("closed");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        a0 a0Var2 = sVar.f6801y;
        d0 d0Var2 = sVar.f6794r;
        synchronized (a0Var2) {
            try {
                com.google.common.collect.c.F(d0Var2, "settings");
                if (!a0Var2.f6700e) {
                    a0Var2.z(0, Integer.bitCount(d0Var2.f6732a) * 6, 4, 0);
                    for (int i6 = 0; i6 < 10; i6++) {
                        if (((1 << i6) & d0Var2.f6732a) != 0) {
                            if (i6 != 4) {
                                if (i6 != 7) {
                                    i5 = i6;
                                } else {
                                    i5 = 4;
                                }
                            } else {
                                i5 = 3;
                            }
                            a0Var2.f6696a.j(i5);
                            a0Var2.f6696a.l(d0Var2.f6733b[i6]);
                        }
                    }
                    a0Var2.f6696a.flush();
                } else {
                    throw new IOException("closed");
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (sVar.f6794r.a() != 65535) {
            sVar.f6801y.D(0, a5 - 65535);
        }
        fVar.f().c(new p3.b(0, sVar.f6802z, sVar.f6780d), 0L);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Connection{");
        z zVar = this.f6017b;
        sb.append(zVar.f5641a.f5468i.f5546d);
        sb.append(':');
        sb.append(zVar.f5641a.f5468i.f5547e);
        sb.append(", proxy=");
        sb.append(zVar.f5642b);
        sb.append(" hostAddress=");
        sb.append(zVar.f5643c);
        sb.append(" cipherSuite=");
        c cVar = this.f6020e;
        sb.append((cVar == null || (r1 = cVar.f6008b) == null) ? "none" : "none");
        sb.append(" protocol=");
        sb.append(this.f6021f);
        sb.append('}');
        return sb.toString();
    }
}