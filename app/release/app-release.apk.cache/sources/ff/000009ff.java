package v3;

import java.util.List;
import javax.net.ssl.SSLSocket;
import org.bouncycastle.jsse.BCSSLParameters;
import org.bouncycastle.jsse.BCSSLSocket;

/* loaded from: classes.dex */
public final class g implements m {

    /* renamed from: a  reason: collision with root package name */
    public static final t3.a f7004a = new t3.a(18, 0);

    /* renamed from: b  reason: collision with root package name */
    public static final f f7005b = new Object();

    @Override // v3.m
    public final boolean a(SSLSocket sSLSocket) {
        return sSLSocket instanceof BCSSLSocket;
    }

    @Override // v3.m
    public final String b(SSLSocket sSLSocket) {
        String applicationProtocol = ((BCSSLSocket) sSLSocket).getApplicationProtocol();
        if (applicationProtocol == null || com.google.common.collect.c.n(applicationProtocol, "")) {
            return null;
        }
        return applicationProtocol;
    }

    @Override // v3.m
    public final boolean c() {
        return u3.d.f6915d.i();
    }

    @Override // v3.m
    public final void d(SSLSocket sSLSocket, String str, List list) {
        com.google.common.collect.c.F(list, "protocols");
        if (a(sSLSocket)) {
            BCSSLSocket bCSSLSocket = (BCSSLSocket) sSLSocket;
            BCSSLParameters parameters = bCSSLSocket.getParameters();
            u3.l lVar = u3.l.f6934a;
            parameters.setApplicationProtocols((String[]) t3.a.b(list).toArray(new String[0]));
            bCSSLSocket.setParameters(parameters);
        }
    }
}