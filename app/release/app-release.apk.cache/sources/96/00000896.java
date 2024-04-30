package m3;

import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class q {

    /* renamed from: c  reason: collision with root package name */
    public static final Pattern f5552c = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");

    /* renamed from: d  reason: collision with root package name */
    public static final Pattern f5553d = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");

    /* renamed from: a  reason: collision with root package name */
    public final String f5554a;

    /* renamed from: b  reason: collision with root package name */
    public final String[] f5555b;

    public q(String str, String[] strArr) {
        this.f5554a = str;
        this.f5555b = strArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0024 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0025 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.nio.charset.Charset a(java.nio.charset.Charset r6) {
        /*
            r5 = this;
            java.lang.String[] r0 = r5.f5555b
            int r1 = r0.length
            int r1 = r1 + (-1)
            r2 = 0
            r3 = 2
            int r1 = com.google.common.collect.c.L0(r2, r1, r3)
            if (r1 < 0) goto L21
        Ld:
            r3 = r0[r2]
            java.lang.String r4 = "charset"
            boolean r3 = l3.g.j2(r3, r4)
            if (r3 == 0) goto L1c
            int r2 = r2 + 1
            r0 = r0[r2]
            goto L22
        L1c:
            if (r2 == r1) goto L21
            int r2 = r2 + 2
            goto Ld
        L21:
            r0 = 0
        L22:
            if (r0 != 0) goto L25
            return r6
        L25:
            java.nio.charset.Charset r6 = java.nio.charset.Charset.forName(r0)     // Catch: java.lang.IllegalArgumentException -> L29
        L29:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: m3.q.a(java.nio.charset.Charset):java.nio.charset.Charset");
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof q) && com.google.common.collect.c.n(((q) obj).f5554a, this.f5554a)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.f5554a.hashCode();
    }

    public final String toString() {
        return this.f5554a;
    }
}