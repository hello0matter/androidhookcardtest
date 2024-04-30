package x3;

/* loaded from: classes.dex */
public final class a extends com.google.common.collect.c {

    /* renamed from: q  reason: collision with root package name */
    public final d f7144q;

    public a(d dVar) {
        com.google.common.collect.c.F(dVar, "trustRootIndex");
        this.f7144q = dVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0076  */
    @Override // com.google.common.collect.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List O(java.lang.String r9, java.util.List r10) {
        /*
            r8 = this;
            java.lang.String r0 = "chain"
            com.google.common.collect.c.F(r10, r0)
            java.lang.String r0 = "hostname"
            com.google.common.collect.c.F(r9, r0)
            java.util.ArrayDeque r9 = new java.util.ArrayDeque
            r9.<init>(r10)
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            java.lang.Object r0 = r9.removeFirst()
            java.lang.String r1 = "queue.removeFirst()"
            com.google.common.collect.c.E(r0, r1)
            r10.add(r0)
            r0 = 0
            r1 = r0
        L22:
            r2 = 9
            if (r0 >= r2) goto Lb5
            int r2 = r10.size()
            r3 = 1
            int r2 = r2 - r3
            java.lang.Object r2 = r10.get(r2)
            java.lang.String r4 = "null cannot be cast to non-null type java.security.cert.X509Certificate"
            com.google.common.collect.c.D(r2, r4)
            java.security.cert.X509Certificate r2 = (java.security.cert.X509Certificate) r2
            x3.d r5 = r8.f7144q
            java.security.cert.X509Certificate r5 = r5.a(r2)
            if (r5 == 0) goto L67
            int r1 = r10.size()
            if (r1 > r3) goto L4b
            boolean r1 = com.google.common.collect.c.n(r2, r5)
            if (r1 != 0) goto L4e
        L4b:
            r10.add(r5)
        L4e:
            java.security.Principal r1 = r5.getIssuerDN()
            java.security.Principal r2 = r5.getSubjectDN()
            boolean r1 = com.google.common.collect.c.n(r1, r2)
            if (r1 != 0) goto L5d
            goto L65
        L5d:
            java.security.PublicKey r1 = r5.getPublicKey()     // Catch: java.security.GeneralSecurityException -> L65
            r5.verify(r1)     // Catch: java.security.GeneralSecurityException -> L65
            return r10
        L65:
            r1 = r3
            goto L9b
        L67:
            java.util.Iterator r3 = r9.iterator()
            java.lang.String r5 = "queue.iterator()"
            com.google.common.collect.c.E(r3, r5)
        L70:
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L9e
            java.lang.Object r5 = r3.next()
            com.google.common.collect.c.D(r5, r4)
            java.security.cert.X509Certificate r5 = (java.security.cert.X509Certificate) r5
            java.security.Principal r6 = r2.getIssuerDN()
            java.security.Principal r7 = r5.getSubjectDN()
            boolean r6 = com.google.common.collect.c.n(r6, r7)
            if (r6 != 0) goto L8e
            goto L70
        L8e:
            java.security.PublicKey r6 = r5.getPublicKey()     // Catch: java.security.GeneralSecurityException -> L70
            r2.verify(r6)     // Catch: java.security.GeneralSecurityException -> L70
            r3.remove()
            r10.add(r5)
        L9b:
            int r0 = r0 + 1
            goto L22
        L9e:
            if (r1 == 0) goto La1
            return r10
        La1:
            javax.net.ssl.SSLPeerUnverifiedException r9 = new javax.net.ssl.SSLPeerUnverifiedException
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r0 = "Failed to find a trusted cert that signed "
            r10.<init>(r0)
            r10.append(r2)
            java.lang.String r10 = r10.toString()
            r9.<init>(r10)
            throw r9
        Lb5:
            javax.net.ssl.SSLPeerUnverifiedException r9 = new javax.net.ssl.SSLPeerUnverifiedException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Certificate chain too long: "
            r0.<init>(r1)
            r0.append(r10)
            java.lang.String r10 = r0.toString()
            r9.<init>(r10)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: x3.a.O(java.lang.String, java.util.List):java.util.List");
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof a) && com.google.common.collect.c.n(((a) obj).f7144q, this.f7144q)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.f7144q.hashCode();
    }
}