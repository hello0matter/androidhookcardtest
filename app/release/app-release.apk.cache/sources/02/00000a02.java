package v3;

import java.util.List;
import javax.net.ssl.SSLSocket;
import org.conscrypt.Conscrypt;

/* loaded from: classes.dex */
public final class j implements m {

    /* renamed from: a  reason: collision with root package name */
    public static final t3.a f7009a = new t3.a(20, 0);

    /* renamed from: b  reason: collision with root package name */
    public static final i f7010b = new Object();

    @Override // v3.m
    public final boolean a(SSLSocket sSLSocket) {
        return Conscrypt.isConscrypt(sSLSocket);
    }

    @Override // v3.m
    public final String b(SSLSocket sSLSocket) {
        if (a(sSLSocket)) {
            return Conscrypt.getApplicationProtocol(sSLSocket);
        }
        return null;
    }

    @Override // v3.m
    public final boolean c() {
        boolean z4 = u3.g.f6919d;
        return u3.g.f6919d;
    }

    @Override // v3.m
    public final void d(SSLSocket sSLSocket, String str, List list) {
        com.google.common.collect.c.F(list, "protocols");
        if (a(sSLSocket)) {
            Conscrypt.setUseSessionTickets(sSLSocket, true);
            u3.l lVar = u3.l.f6934a;
            Conscrypt.setApplicationProtocols(sSLSocket, (String[]) t3.a.b(list).toArray(new String[0]));
        }
    }
}