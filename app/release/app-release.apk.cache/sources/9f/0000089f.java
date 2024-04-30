package m3;

import java.net.InetSocketAddress;
import java.net.Proxy;

/* loaded from: classes.dex */
public final class z {

    /* renamed from: a  reason: collision with root package name */
    public final a f5641a;

    /* renamed from: b  reason: collision with root package name */
    public final Proxy f5642b;

    /* renamed from: c  reason: collision with root package name */
    public final InetSocketAddress f5643c;

    public z(a aVar, Proxy proxy, InetSocketAddress inetSocketAddress) {
        com.google.common.collect.c.F(aVar, "address");
        com.google.common.collect.c.F(inetSocketAddress, "socketAddress");
        this.f5641a = aVar;
        this.f5642b = proxy;
        this.f5643c = inetSocketAddress;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof z) {
            z zVar = (z) obj;
            if (com.google.common.collect.c.n(zVar.f5641a, this.f5641a) && com.google.common.collect.c.n(zVar.f5642b, this.f5642b) && com.google.common.collect.c.n(zVar.f5643c, this.f5643c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.f5642b.hashCode();
        return this.f5643c.hashCode() + ((hashCode + ((this.f5641a.hashCode() + 527) * 31)) * 31);
    }

    public final String toString() {
        return "Route{" + this.f5643c + '}';
    }
}