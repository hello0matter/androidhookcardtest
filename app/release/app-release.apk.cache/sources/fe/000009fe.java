package v3;

import javax.net.ssl.SSLSocket;
import org.bouncycastle.jsse.BCSSLSocket;

/* loaded from: classes.dex */
public final class f implements k {
    @Override // v3.k
    public final boolean a(SSLSocket sSLSocket) {
        if (u3.d.f6915d.i() && (sSLSocket instanceof BCSSLSocket)) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, v3.m] */
    @Override // v3.k
    public final m b(SSLSocket sSLSocket) {
        return new Object();
    }
}