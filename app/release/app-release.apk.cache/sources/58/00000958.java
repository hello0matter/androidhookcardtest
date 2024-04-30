package q3;

import java.net.UnknownServiceException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final List f6358a;

    /* renamed from: b  reason: collision with root package name */
    public int f6359b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f6360c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f6361d;

    public b(List list) {
        com.google.common.collect.c.F(list, "connectionSpecs");
        this.f6358a = list;
    }

    /* JADX WARN: Type inference failed for: r0v8, types: [java.lang.Object, m3.f] */
    public final m3.g a(SSLSocket sSLSocket) {
        m3.g gVar;
        int i4;
        boolean z4;
        int i5 = this.f6359b;
        List list = this.f6358a;
        int size = list.size();
        while (true) {
            if (i5 < size) {
                gVar = (m3.g) list.get(i5);
                if (gVar.b(sSLSocket)) {
                    this.f6359b = i5 + 1;
                    break;
                }
                i5++;
            } else {
                gVar = null;
                break;
            }
        }
        if (gVar != null) {
            int i6 = this.f6359b;
            int size2 = list.size();
            while (true) {
                i4 = 0;
                if (i6 < size2) {
                    if (((m3.g) list.get(i6)).b(sSLSocket)) {
                        z4 = true;
                        break;
                    }
                    i6++;
                } else {
                    z4 = false;
                    break;
                }
            }
            this.f6360c = z4;
            boolean z5 = this.f6361d;
            String[] strArr = gVar.f5514c;
            String[] enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
            if (strArr != null) {
                com.google.common.collect.c.E(enabledCipherSuites, "sslSocket.enabledCipherSuites");
                enabledCipherSuites = n3.b.p(enabledCipherSuites, strArr, m3.e.f5487c);
            }
            String[] strArr2 = gVar.f5515d;
            String[] enabledProtocols = sSLSocket.getEnabledProtocols();
            if (strArr2 != null) {
                com.google.common.collect.c.E(enabledProtocols, "sslSocket.enabledProtocols");
                enabledProtocols = n3.b.p(enabledProtocols, strArr2, z2.a.f7232a);
            }
            String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
            com.google.common.collect.c.E(supportedCipherSuites, "supportedCipherSuites");
            v.c cVar = m3.e.f5487c;
            byte[] bArr = n3.b.f5783a;
            int length = supportedCipherSuites.length;
            while (true) {
                if (i4 < length) {
                    if (cVar.compare(supportedCipherSuites[i4], "TLS_FALLBACK_SCSV") == 0) {
                        break;
                    }
                    i4++;
                } else {
                    i4 = -1;
                    break;
                }
            }
            if (z5 && i4 != -1) {
                com.google.common.collect.c.E(enabledCipherSuites, "cipherSuitesIntersection");
                String str = supportedCipherSuites[i4];
                com.google.common.collect.c.E(str, "supportedCipherSuites[indexOfFallbackScsv]");
                Object[] copyOf = Arrays.copyOf(enabledCipherSuites, enabledCipherSuites.length + 1);
                com.google.common.collect.c.E(copyOf, "copyOf(this, newSize)");
                enabledCipherSuites = (String[]) copyOf;
                enabledCipherSuites[enabledCipherSuites.length - 1] = str;
            }
            ?? obj = new Object();
            obj.f5506a = gVar.f5512a;
            obj.f5507b = strArr;
            obj.f5508c = strArr2;
            obj.f5509d = gVar.f5513b;
            com.google.common.collect.c.E(enabledCipherSuites, "cipherSuitesIntersection");
            obj.b((String[]) Arrays.copyOf(enabledCipherSuites, enabledCipherSuites.length));
            com.google.common.collect.c.E(enabledProtocols, "tlsVersionsIntersection");
            obj.e((String[]) Arrays.copyOf(enabledProtocols, enabledProtocols.length));
            m3.g a5 = obj.a();
            if (a5.c() != null) {
                sSLSocket.setEnabledProtocols(a5.f5515d);
            }
            if (a5.a() != null) {
                sSLSocket.setEnabledCipherSuites(a5.f5514c);
            }
            return gVar;
        }
        StringBuilder sb = new StringBuilder("Unable to find acceptable protocols. isFallback=");
        sb.append(this.f6361d);
        sb.append(", modes=");
        sb.append(list);
        sb.append(", supported protocols=");
        String[] enabledProtocols2 = sSLSocket.getEnabledProtocols();
        com.google.common.collect.c.C(enabledProtocols2);
        String arrays = Arrays.toString(enabledProtocols2);
        com.google.common.collect.c.E(arrays, "toString(this)");
        sb.append(arrays);
        throw new UnknownServiceException(sb.toString());
    }
}