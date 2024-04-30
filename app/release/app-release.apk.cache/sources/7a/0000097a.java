package r3;

import androidx.appcompat.widget.z;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;
import kotlin.collections.EmptyList;
import kotlin.text.Regex;
import m3.n;
import m3.o;
import m3.p;
import m3.s;
import m3.t;
import m3.u;
import m3.v;
import m3.w;
import m3.y;
import okhttp3.internal.connection.RouteException;
import okhttp3.internal.http2.ConnectionShutdownException;
import q3.j;
import q3.l;
import q3.m;

/* loaded from: classes.dex */
public final class g implements p {

    /* renamed from: a  reason: collision with root package name */
    public final s f6481a;

    public g(s sVar) {
        com.google.common.collect.c.F(sVar, "client");
        this.f6481a = sVar;
    }

    public static int d(w wVar, int i4) {
        String x4 = w.x(wVar, "Retry-After");
        if (x4 == null) {
            return i4;
        }
        if (new Regex("\\d+").f5200a.matcher(x4).matches()) {
            Integer valueOf = Integer.valueOf(x4);
            com.google.common.collect.c.E(valueOf, "valueOf(header)");
            return valueOf.intValue();
        }
        return Integer.MAX_VALUE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // m3.p
    public final w a(f fVar) {
        EmptyList emptyList;
        int i4;
        q3.e eVar;
        SSLSocketFactory sSLSocketFactory;
        x3.c cVar;
        okhttp3.a aVar;
        z zVar = fVar.f6476e;
        j jVar = fVar.f6472a;
        boolean z4 = true;
        EmptyList emptyList2 = EmptyList.f5181a;
        w wVar = null;
        int i5 = 0;
        z zVar2 = zVar;
        boolean z5 = true;
        while (true) {
            jVar.getClass();
            com.google.common.collect.c.F(zVar2, "request");
            if (jVar.f6408l == null) {
                synchronized (jVar) {
                    try {
                        if (jVar.f6410n ^ z4) {
                            if (!(jVar.f6409m ^ z4)) {
                                throw new IllegalStateException("Check failed.".toString());
                            }
                        } else {
                            throw new IllegalStateException("cannot make a new request because the previous response is still open: please call response.close()".toString());
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (z5) {
                    l lVar = jVar.f6400d;
                    o oVar = (o) zVar2.f989b;
                    boolean z6 = oVar.f5551i;
                    s sVar = jVar.f6397a;
                    if (z6) {
                        SSLSocketFactory sSLSocketFactory2 = sVar.f5591o;
                        if (sSLSocketFactory2 != null) {
                            x3.c cVar2 = sVar.f5595s;
                            aVar = sVar.f5596t;
                            sSLSocketFactory = sSLSocketFactory2;
                            cVar = cVar2;
                        } else {
                            throw new IllegalStateException("CLEARTEXT-only client");
                        }
                    } else {
                        sSLSocketFactory = null;
                        cVar = null;
                        aVar = null;
                    }
                    emptyList = emptyList2;
                    i4 = i5;
                    jVar.f6405i = new q3.f(lVar, new m3.a(oVar.f5546d, oVar.f5547e, sVar.f5587k, sVar.f5590n, sSLSocketFactory, cVar, aVar, sVar.f5589m, sVar.f5594r, sVar.f5593q, sVar.f5588l), jVar, jVar.f6401e);
                } else {
                    emptyList = emptyList2;
                    i4 = i5;
                }
                try {
                    if (!jVar.f6412p) {
                        try {
                            try {
                                w b5 = fVar.b(zVar2);
                                if (wVar != null) {
                                    v y4 = b5.y();
                                    v y5 = wVar.y();
                                    y5.f5617g = null;
                                    w a5 = y5.a();
                                    if (a5.f5630g == null) {
                                        y4.f5620j = a5;
                                        b5 = y4.a();
                                    } else {
                                        throw new IllegalArgumentException("priorResponse.body != null".toString());
                                    }
                                }
                                wVar = b5;
                                eVar = jVar.f6408l;
                                zVar2 = b(wVar, eVar);
                            } catch (IOException e4) {
                                if (c(e4, jVar, zVar2, !(e4 instanceof ConnectionShutdownException))) {
                                    EmptyList emptyList3 = emptyList;
                                    com.google.common.collect.c.F(emptyList3, "<this>");
                                    ArrayList arrayList = new ArrayList(emptyList3.size() + 1);
                                    arrayList.addAll(emptyList3);
                                    arrayList.add(e4);
                                    jVar.e(true);
                                    emptyList2 = arrayList;
                                    z4 = true;
                                    i5 = i4;
                                    z5 = false;
                                } else {
                                    EmptyList<Exception> emptyList4 = emptyList;
                                    com.google.common.collect.c.F(emptyList4, "suppressed");
                                    for (Exception exc : emptyList4) {
                                        kotlin.a.a(e4, exc);
                                    }
                                    throw e4;
                                }
                            }
                        } catch (RouteException e5) {
                            EmptyList<Exception> emptyList5 = emptyList;
                            if (c(e5.f6016b, jVar, zVar2, false)) {
                                IOException iOException = e5.f6015a;
                                com.google.common.collect.c.F(emptyList5, "<this>");
                                ArrayList arrayList2 = new ArrayList(emptyList5.size() + 1);
                                arrayList2.addAll(emptyList5);
                                arrayList2.add(iOException);
                                jVar.e(true);
                                z5 = false;
                                z4 = true;
                                i5 = i4;
                                emptyList2 = arrayList2;
                            } else {
                                IOException iOException2 = e5.f6015a;
                                com.google.common.collect.c.F(iOException2, "<this>");
                                com.google.common.collect.c.F(emptyList5, "suppressed");
                                for (Exception exc2 : emptyList5) {
                                    kotlin.a.a(iOException2, exc2);
                                }
                                throw iOException2;
                            }
                        }
                        if (zVar2 == null) {
                            if (eVar != null && eVar.f6379e) {
                                if (!jVar.f6407k) {
                                    jVar.f6407k = true;
                                    jVar.f6402f.i();
                                } else {
                                    throw new IllegalStateException("Check failed.".toString());
                                }
                            }
                            jVar.e(false);
                            return wVar;
                        }
                        y yVar = wVar.f5630g;
                        if (yVar != null) {
                            n3.b.d(yVar);
                        }
                        i5 = i4 + 1;
                        if (i5 <= 20) {
                            jVar.e(true);
                            emptyList2 = emptyList;
                            z5 = true;
                            z4 = true;
                        } else {
                            throw new ProtocolException("Too many follow-up requests: " + i5);
                        }
                    } else {
                        throw new IOException("Canceled");
                    }
                } catch (Throwable th2) {
                    jVar.e(true);
                    throw th2;
                }
            } else {
                throw new IllegalStateException("Check failed.".toString());
            }
        }
    }

    public final z b(w wVar, q3.e eVar) {
        m3.z zVar;
        String x4;
        n nVar;
        o oVar;
        okhttp3.internal.connection.a aVar;
        u uVar = null;
        if (eVar != null && (aVar = eVar.f6381g) != null) {
            zVar = aVar.f6017b;
        } else {
            zVar = null;
        }
        int i4 = wVar.f5627d;
        String str = (String) wVar.f5624a.f990c;
        boolean z4 = false;
        if (i4 != 307 && i4 != 308) {
            if (i4 != 401) {
                if (i4 != 421) {
                    if (i4 != 503) {
                        if (i4 != 407) {
                            if (i4 != 408) {
                                switch (i4) {
                                    case 300:
                                    case 301:
                                    case 302:
                                    case 303:
                                        break;
                                    default:
                                        return null;
                                }
                            } else if (!this.f6481a.f5582f) {
                                return null;
                            } else {
                                w wVar2 = wVar.f5633j;
                                if ((wVar2 != null && wVar2.f5627d == 408) || d(wVar, 0) > 0) {
                                    return null;
                                }
                                return wVar.f5624a;
                            }
                        } else {
                            com.google.common.collect.c.C(zVar);
                            if (zVar.f5642b.type() == Proxy.Type.HTTP) {
                                this.f6481a.f5589m.getClass();
                                return null;
                            }
                            throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                        }
                    } else {
                        w wVar3 = wVar.f5633j;
                        if ((wVar3 != null && wVar3.f5627d == 503) || d(wVar, Integer.MAX_VALUE) != 0) {
                            return null;
                        }
                        return wVar.f5624a;
                    }
                } else if (eVar == null || !(!com.google.common.collect.c.n(eVar.f6377c.f6383b.f5468i.f5546d, eVar.f6381g.f6017b.f5641a.f5468i.f5546d))) {
                    return null;
                } else {
                    okhttp3.internal.connection.a aVar2 = eVar.f6381g;
                    synchronized (aVar2) {
                        aVar2.f6026k = true;
                    }
                    return wVar.f5624a;
                }
            } else {
                this.f6481a.f5583g.getClass();
                return null;
            }
        }
        s sVar = this.f6481a;
        if (!sVar.f5584h || (x4 = w.x(wVar, "Location")) == null) {
            return null;
        }
        z zVar2 = wVar.f5624a;
        o oVar2 = (o) zVar2.f989b;
        oVar2.getClass();
        try {
            nVar = new n();
            nVar.c(oVar2, x4);
        } catch (IllegalArgumentException unused) {
            nVar = null;
        }
        if (nVar != null) {
            oVar = nVar.a();
        } else {
            oVar = null;
        }
        if (oVar == null) {
            return null;
        }
        if (!com.google.common.collect.c.n(oVar.f5543a, ((o) zVar2.f989b).f5543a) && !sVar.f5585i) {
            return null;
        }
        t e4 = zVar2.e();
        if (com.google.common.collect.c.B1(str)) {
            boolean n4 = com.google.common.collect.c.n(str, "PROPFIND");
            int i5 = wVar.f5627d;
            if (n4 || i5 == 308 || i5 == 307) {
                z4 = true;
            }
            if ((true ^ com.google.common.collect.c.n(str, "PROPFIND")) && i5 != 308 && i5 != 307) {
                e4.c("GET", null);
            } else {
                if (z4) {
                    uVar = (u) zVar2.f992e;
                }
                e4.c(str, uVar);
            }
            if (!z4) {
                e4.f5604c.c("Transfer-Encoding");
                e4.f5604c.c("Content-Length");
                e4.f5604c.c("Content-Type");
            }
        }
        if (!n3.b.a((o) zVar2.f989b, oVar)) {
            e4.f5604c.c("Authorization");
        }
        e4.f5602a = oVar;
        return e4.a();
    }

    public final boolean c(IOException iOException, j jVar, z zVar, boolean z4) {
        m mVar;
        okhttp3.internal.connection.a aVar;
        if (!this.f6481a.f5582f) {
            return false;
        }
        if ((z4 && (iOException instanceof FileNotFoundException)) || (iOException instanceof ProtocolException) || (!(iOException instanceof InterruptedIOException) ? !((!(iOException instanceof SSLHandshakeException) || !(iOException.getCause() instanceof CertificateException)) && !(iOException instanceof SSLPeerUnverifiedException)) : !((iOException instanceof SocketTimeoutException) && !z4))) {
            return false;
        }
        q3.f fVar = jVar.f6405i;
        com.google.common.collect.c.C(fVar);
        int i4 = fVar.f6388g;
        if (i4 != 0 || fVar.f6389h != 0 || fVar.f6390i != 0) {
            if (fVar.f6391j == null) {
                m3.z zVar2 = null;
                if (i4 <= 1 && fVar.f6389h <= 1 && fVar.f6390i <= 0 && (aVar = fVar.f6384c.f6406j) != null) {
                    synchronized (aVar) {
                        if (aVar.f6027l == 0 && n3.b.a(aVar.f6017b.f5641a.f5468i, fVar.f6383b.f5468i)) {
                            zVar2 = aVar.f6017b;
                        }
                    }
                }
                if (zVar2 != null) {
                    fVar.f6391j = zVar2;
                } else {
                    androidx.fragment.app.n nVar = fVar.f6386e;
                    if ((nVar == null || !nVar.b()) && (mVar = fVar.f6387f) != null && !mVar.a()) {
                    }
                }
            }
            return true;
        }
        return false;
    }
}