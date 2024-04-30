package v3;

import javax.net.ssl.SSLSocket;
import org.conscrypt.Conscrypt;

/* loaded from: classes.dex */
public final class i implements k {
    @Override // v3.k
    public final boolean a(SSLSocket sSLSocket) {
        boolean z4 = u3.g.f6919d;
        if (u3.e.b() && Conscrypt.isConscrypt(sSLSocket)) {
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