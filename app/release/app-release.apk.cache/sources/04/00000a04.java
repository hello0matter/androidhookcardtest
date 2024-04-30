package v3;

import java.util.List;
import javax.net.ssl.SSLSocket;

/* loaded from: classes.dex */
public final class l implements m {

    /* renamed from: a  reason: collision with root package name */
    public final k f7011a;

    /* renamed from: b  reason: collision with root package name */
    public m f7012b;

    public l(k kVar) {
        this.f7011a = kVar;
    }

    @Override // v3.m
    public final boolean a(SSLSocket sSLSocket) {
        return this.f7011a.a(sSLSocket);
    }

    @Override // v3.m
    public final String b(SSLSocket sSLSocket) {
        m e4 = e(sSLSocket);
        if (e4 != null) {
            return e4.b(sSLSocket);
        }
        return null;
    }

    @Override // v3.m
    public final boolean c() {
        return true;
    }

    @Override // v3.m
    public final void d(SSLSocket sSLSocket, String str, List list) {
        com.google.common.collect.c.F(list, "protocols");
        m e4 = e(sSLSocket);
        if (e4 != null) {
            e4.d(sSLSocket, str, list);
        }
    }

    public final synchronized m e(SSLSocket sSLSocket) {
        try {
            if (this.f7012b == null && this.f7011a.a(sSLSocket)) {
                this.f7012b = this.f7011a.b(sSLSocket);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f7012b;
    }
}