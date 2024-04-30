package v3;

import android.net.ssl.SSLSockets;
import java.io.IOException;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;

/* loaded from: classes.dex */
public final class a implements m {

    /* renamed from: a  reason: collision with root package name */
    public static final t3.a f6992a = new t3.a(15, 0);

    @Override // v3.m
    public final boolean a(SSLSocket sSLSocket) {
        boolean isSupportedSocket;
        isSupportedSocket = SSLSockets.isSupportedSocket(sSLSocket);
        return isSupportedSocket;
    }

    @Override // v3.m
    public final String b(SSLSocket sSLSocket) {
        String applicationProtocol;
        applicationProtocol = sSLSocket.getApplicationProtocol();
        if (applicationProtocol == null || com.google.common.collect.c.n(applicationProtocol, "")) {
            return null;
        }
        return applicationProtocol;
    }

    @Override // v3.m
    public final boolean c() {
        return f6992a.i();
    }

    @Override // v3.m
    public final void d(SSLSocket sSLSocket, String str, List list) {
        com.google.common.collect.c.F(list, "protocols");
        try {
            SSLSockets.setUseSessionTickets(sSLSocket, true);
            SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            u3.l lVar = u3.l.f6934a;
            sSLParameters.setApplicationProtocols((String[]) t3.a.b(list).toArray(new String[0]));
            sSLSocket.setSSLParameters(sSLParameters);
        } catch (IllegalArgumentException e4) {
            throw new IOException("Android internal error", e4);
        }
    }
}