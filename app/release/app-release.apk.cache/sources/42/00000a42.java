package x3;

import java.security.cert.X509Certificate;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.security.auth.x500.X500Principal;

/* loaded from: classes.dex */
public final class b implements d {

    /* renamed from: a  reason: collision with root package name */
    public final LinkedHashMap f7145a;

    public b(X509Certificate... x509CertificateArr) {
        com.google.common.collect.c.F(x509CertificateArr, "caCerts");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (X509Certificate x509Certificate : x509CertificateArr) {
            X500Principal subjectX500Principal = x509Certificate.getSubjectX500Principal();
            com.google.common.collect.c.E(subjectX500Principal, "caCert.subjectX500Principal");
            Object obj = linkedHashMap.get(subjectX500Principal);
            if (obj == null) {
                obj = new LinkedHashSet();
                linkedHashMap.put(subjectX500Principal, obj);
            }
            ((Set) obj).add(x509Certificate);
        }
        this.f7145a = linkedHashMap;
    }

    @Override // x3.d
    public final X509Certificate a(X509Certificate x509Certificate) {
        Set set = (Set) this.f7145a.get(x509Certificate.getIssuerX500Principal());
        Object obj = null;
        if (set == null) {
            return null;
        }
        Iterator it = set.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            try {
                x509Certificate.verify(((X509Certificate) next).getPublicKey());
                obj = next;
                break;
            } catch (Exception unused) {
            }
        }
        return (X509Certificate) obj;
    }

    public final boolean equals(Object obj) {
        if (obj != this && (!(obj instanceof b) || !com.google.common.collect.c.n(((b) obj).f7145a, this.f7145a))) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return this.f7145a.hashCode();
    }
}