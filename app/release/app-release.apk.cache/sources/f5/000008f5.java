package okhttp3;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.collections.EmptyList;
import m3.e;
import y2.h;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final TlsVersion f6007a;

    /* renamed from: b  reason: collision with root package name */
    public final e f6008b;

    /* renamed from: c  reason: collision with root package name */
    public final List f6009c;

    /* renamed from: d  reason: collision with root package name */
    public final x2.a f6010d;

    public c(TlsVersion tlsVersion, e eVar, List list, final e3.a aVar) {
        com.google.common.collect.c.F(tlsVersion, "tlsVersion");
        com.google.common.collect.c.F(eVar, "cipherSuite");
        com.google.common.collect.c.F(list, "localCertificates");
        this.f6007a = tlsVersion;
        this.f6008b = eVar;
        this.f6009c = list;
        this.f6010d = kotlin.a.b(new e3.a() { // from class: okhttp3.Handshake$peerCertificates$2
            @Override // e3.a
            public final Object a() {
                try {
                    return (List) e3.a.this.a();
                } catch (SSLPeerUnverifiedException unused) {
                    return EmptyList.f5181a;
                }
            }
        });
    }

    public final List a() {
        return (List) this.f6010d.getValue();
    }

    public final boolean equals(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            if (cVar.f6007a == this.f6007a && com.google.common.collect.c.n(cVar.f6008b, this.f6008b) && com.google.common.collect.c.n(cVar.a(), a()) && com.google.common.collect.c.n(cVar.f6009c, this.f6009c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.f6008b.hashCode();
        int hashCode2 = a().hashCode();
        return this.f6009c.hashCode() + ((hashCode2 + ((hashCode + ((this.f6007a.hashCode() + 527) * 31)) * 31)) * 31);
    }

    public final String toString() {
        String type;
        String type2;
        List<Certificate> a5 = a();
        ArrayList arrayList = new ArrayList(h.h2(a5));
        for (Certificate certificate : a5) {
            if (certificate instanceof X509Certificate) {
                type2 = ((X509Certificate) certificate).getSubjectDN().toString();
            } else {
                type2 = certificate.getType();
                com.google.common.collect.c.E(type2, "type");
            }
            arrayList.add(type2);
        }
        String obj = arrayList.toString();
        StringBuilder sb = new StringBuilder("Handshake{tlsVersion=");
        sb.append(this.f6007a);
        sb.append(" cipherSuite=");
        sb.append(this.f6008b);
        sb.append(" peerCertificates=");
        sb.append(obj);
        sb.append(" localCertificates=");
        List<Certificate> list = this.f6009c;
        ArrayList arrayList2 = new ArrayList(h.h2(list));
        for (Certificate certificate2 : list) {
            if (certificate2 instanceof X509Certificate) {
                type = ((X509Certificate) certificate2).getSubjectDN().toString();
            } else {
                type = certificate2.getType();
                com.google.common.collect.c.E(type, "type");
            }
            arrayList2.add(type);
        }
        sb.append(arrayList2);
        sb.append('}');
        return sb.toString();
    }
}