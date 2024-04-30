package r3;

import m3.w;
import okio.ByteString;

/* loaded from: classes.dex */
public abstract class e {
    static {
        ByteString byteString = ByteString.f6049d;
        t3.a.h("\"\\");
        t3.a.h("\t ,=");
    }

    public static final boolean a(w wVar) {
        if (com.google.common.collect.c.n((String) wVar.f5624a.f990c, "HEAD")) {
            return false;
        }
        int i4 = wVar.f5627d;
        if (((i4 >= 100 && i4 < 200) || i4 == 204 || i4 == 304) && n3.b.k(wVar) == -1 && !l3.g.j2("chunked", w.x(wVar, "Transfer-Encoding"))) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:107:0x01eb, code lost:
        if (r3.f5200a.matcher(r0).matches() == false) goto L129;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r21v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void b(m3.i r34, m3.o r35, m3.m r36) {
        /*
            Method dump skipped, instructions count: 604
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: r3.e.b(m3.i, m3.o, m3.m):void");
    }
}