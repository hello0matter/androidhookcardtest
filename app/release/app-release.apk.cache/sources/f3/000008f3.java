package okhttp3;

import androidx.activity.j;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.EmptyList;
import kotlin.collections.EmptySet;
import y2.h;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: c  reason: collision with root package name */
    public static final a f6004c;

    /* renamed from: a  reason: collision with root package name */
    public final Set f6005a;

    /* renamed from: b  reason: collision with root package name */
    public final com.google.common.collect.c f6006b;

    static {
        Set set;
        ArrayList<Object> arrayList = new ArrayList();
        int size = arrayList.size();
        if (size != 0) {
            if (size != 1) {
                set = new LinkedHashSet(com.google.common.collect.c.f1(arrayList.size()));
                for (Object obj : arrayList) {
                    set.add(obj);
                }
            } else {
                set = Collections.singleton(arrayList.get(0));
                com.google.common.collect.c.E(set, "singleton(element)");
            }
        } else {
            set = EmptySet.f5183a;
        }
        f6004c = new a(set, null);
    }

    public a(Set set, com.google.common.collect.c cVar) {
        com.google.common.collect.c.F(set, "pins");
        this.f6005a = set;
        this.f6006b = cVar;
    }

    public final void a(final String str, final List list) {
        com.google.common.collect.c.F(str, "hostname");
        com.google.common.collect.c.F(list, "peerCertificates");
        b(str, new e3.a() { // from class: okhttp3.CertificatePinner$check$1
            @Override // e3.a
            public final Object a() {
                com.google.common.collect.c cVar = a.this.f6006b;
                List<Certificate> list2 = list;
                if (cVar != null) {
                    list2 = cVar.O(str, list2);
                }
                ArrayList arrayList = new ArrayList(h.h2(list2));
                for (Certificate certificate : list2) {
                    com.google.common.collect.c.D(certificate, "null cannot be cast to non-null type java.security.cert.X509Certificate");
                    arrayList.add((X509Certificate) certificate);
                }
                return arrayList;
            }
        });
    }

    public final void b(String str, e3.a aVar) {
        com.google.common.collect.c.F(str, "hostname");
        EmptyList emptyList = EmptyList.f5181a;
        Iterator it = this.f6005a.iterator();
        if (!it.hasNext()) {
            emptyList.getClass();
        } else {
            j.f(it.next());
            throw null;
        }
    }

    public final boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (com.google.common.collect.c.n(aVar.f6005a, this.f6005a) && com.google.common.collect.c.n(aVar.f6006b, this.f6006b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = (this.f6005a.hashCode() + 1517) * 41;
        com.google.common.collect.c cVar = this.f6006b;
        return hashCode + (cVar != null ? cVar.hashCode() : 0);
    }
}