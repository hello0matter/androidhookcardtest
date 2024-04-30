package m3;

import androidx.fragment.app.m0;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import java.util.Objects;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final j f5460a;

    /* renamed from: b  reason: collision with root package name */
    public final SocketFactory f5461b;

    /* renamed from: c  reason: collision with root package name */
    public final SSLSocketFactory f5462c;

    /* renamed from: d  reason: collision with root package name */
    public final HostnameVerifier f5463d;

    /* renamed from: e  reason: collision with root package name */
    public final okhttp3.a f5464e;

    /* renamed from: f  reason: collision with root package name */
    public final b f5465f;

    /* renamed from: g  reason: collision with root package name */
    public final Proxy f5466g;

    /* renamed from: h  reason: collision with root package name */
    public final ProxySelector f5467h;

    /* renamed from: i  reason: collision with root package name */
    public final o f5468i;

    /* renamed from: j  reason: collision with root package name */
    public final List f5469j;

    /* renamed from: k  reason: collision with root package name */
    public final List f5470k;

    public a(String str, int i4, k kVar, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, x3.c cVar, okhttp3.a aVar, k kVar2, List list, List list2, ProxySelector proxySelector) {
        com.google.common.collect.c.F(str, "uriHost");
        com.google.common.collect.c.F(kVar, "dns");
        com.google.common.collect.c.F(socketFactory, "socketFactory");
        com.google.common.collect.c.F(kVar2, "proxyAuthenticator");
        com.google.common.collect.c.F(list, "protocols");
        com.google.common.collect.c.F(list2, "connectionSpecs");
        com.google.common.collect.c.F(proxySelector, "proxySelector");
        this.f5460a = kVar;
        this.f5461b = socketFactory;
        this.f5462c = sSLSocketFactory;
        this.f5463d = cVar;
        this.f5464e = aVar;
        this.f5465f = kVar2;
        this.f5466g = null;
        this.f5467h = proxySelector;
        n nVar = new n();
        String str2 = sSLSocketFactory != null ? "https" : "http";
        if (l3.g.j2(str2, "http")) {
            nVar.f5534a = "http";
        } else if (!l3.g.j2(str2, "https")) {
            throw new IllegalArgumentException("unexpected scheme: ".concat(str2));
        } else {
            nVar.f5534a = "https";
        }
        String a22 = com.google.common.collect.c.a2(m0.t(str, 0, 0, false, 7));
        if (a22 == null) {
            throw new IllegalArgumentException("unexpected host: ".concat(str));
        }
        nVar.f5537d = a22;
        if (1 <= i4 && i4 < 65536) {
            nVar.f5538e = i4;
            this.f5468i = nVar.a();
            this.f5469j = n3.b.x(list);
            this.f5470k = n3.b.x(list2);
            return;
        }
        throw new IllegalArgumentException(androidx.activity.j.b("unexpected port: ", i4).toString());
    }

    public final boolean a(a aVar) {
        com.google.common.collect.c.F(aVar, "that");
        if (com.google.common.collect.c.n(this.f5460a, aVar.f5460a) && com.google.common.collect.c.n(this.f5465f, aVar.f5465f) && com.google.common.collect.c.n(this.f5469j, aVar.f5469j) && com.google.common.collect.c.n(this.f5470k, aVar.f5470k) && com.google.common.collect.c.n(this.f5467h, aVar.f5467h) && com.google.common.collect.c.n(this.f5466g, aVar.f5466g) && com.google.common.collect.c.n(this.f5462c, aVar.f5462c) && com.google.common.collect.c.n(this.f5463d, aVar.f5463d) && com.google.common.collect.c.n(this.f5464e, aVar.f5464e) && this.f5468i.f5547e == aVar.f5468i.f5547e) {
            return true;
        }
        return false;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (com.google.common.collect.c.n(this.f5468i, aVar.f5468i) && a(aVar)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.f5460a.hashCode();
        int hashCode2 = this.f5465f.hashCode();
        int hashCode3 = this.f5469j.hashCode();
        int hashCode4 = this.f5470k.hashCode();
        int hashCode5 = this.f5467h.hashCode();
        int hashCode6 = Objects.hashCode(this.f5466g);
        int hashCode7 = Objects.hashCode(this.f5462c);
        int hashCode8 = Objects.hashCode(this.f5463d);
        return Objects.hashCode(this.f5464e) + ((hashCode8 + ((hashCode7 + ((hashCode6 + ((hashCode5 + ((hashCode4 + ((hashCode3 + ((hashCode2 + ((hashCode + ((this.f5468i.f5550h.hashCode() + 527) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31);
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder("Address{");
        o oVar = this.f5468i;
        sb.append(oVar.f5546d);
        sb.append(':');
        sb.append(oVar.f5547e);
        sb.append(", ");
        Proxy proxy = this.f5466g;
        if (proxy != null) {
            str = "proxy=" + proxy;
        } else {
            str = "proxySelector=" + this.f5467h;
        }
        sb.append(str);
        sb.append('}');
        return sb.toString();
    }
}