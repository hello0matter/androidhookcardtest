package u3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import okhttp3.Protocol;

/* loaded from: classes.dex */
public final class j extends l {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f6930c;

    /* JADX WARN: Code restructure failed: missing block: B:39:0x0078, code lost:
        if (r1.intValue() < 9) goto L39;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0062 A[SYNTHETIC] */
    static {
        /*
            java.lang.String r0 = "java.specification.version"
            java.lang.String r0 = java.lang.System.getProperty(r0)
            r1 = 0
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L70
            r4 = 10
            com.google.common.collect.c.I(r4)
            int r5 = r0.length()
            if (r5 != 0) goto L18
            goto L70
        L18:
            char r6 = r0.charAt(r3)
            r7 = 48
            int r7 = com.google.common.collect.c.Q(r6, r7)
            r8 = -2147483647(0xffffffff80000001, float:-1.4E-45)
            if (r7 >= 0) goto L3a
            if (r5 != r2) goto L2a
            goto L70
        L2a:
            r7 = 45
            if (r6 != r7) goto L33
            r8 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = r2
        L31:
            r7 = r6
            goto L3c
        L33:
            r7 = 43
            if (r6 != r7) goto L70
            r6 = r2
            r7 = r3
            goto L3c
        L3a:
            r6 = r3
            goto L31
        L3c:
            r9 = -59652323(0xfffffffffc71c71d, float:-5.0215282E36)
            r10 = r3
            r11 = r9
        L41:
            if (r6 >= r5) goto L62
            char r12 = r0.charAt(r6)
            int r12 = java.lang.Character.digit(r12, r4)
            if (r12 >= 0) goto L4e
            goto L70
        L4e:
            if (r10 >= r11) goto L57
            if (r11 != r9) goto L70
            int r11 = r8 / 10
            if (r10 >= r11) goto L57
            goto L70
        L57:
            int r10 = r10 * 10
            int r13 = r8 + r12
            if (r10 >= r13) goto L5e
            goto L70
        L5e:
            int r10 = r10 - r12
            int r6 = r6 + 1
            goto L41
        L62:
            if (r7 == 0) goto L6a
            java.lang.Integer r0 = java.lang.Integer.valueOf(r10)
        L68:
            r1 = r0
            goto L70
        L6a:
            int r0 = -r10
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L68
        L70:
            if (r1 == 0) goto L7d
            int r0 = r1.intValue()
            r1 = 9
            if (r0 < r1) goto L7b
            goto L86
        L7b:
            r2 = r3
            goto L86
        L7d:
            java.lang.Class<javax.net.ssl.SSLSocket> r0 = javax.net.ssl.SSLSocket.class
            java.lang.String r1 = "getApplicationProtocol"
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch: java.lang.NoSuchMethodException -> L7b
            r0.getMethod(r1, r4)     // Catch: java.lang.NoSuchMethodException -> L7b
        L86:
            u3.j.f6930c = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: u3.j.<clinit>():void");
    }

    @Override // u3.l
    public final void d(SSLSocket sSLSocket, String str, List list) {
        com.google.common.collect.c.F(list, "protocols");
        SSLParameters sSLParameters = sSLSocket.getSSLParameters();
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((Protocol) obj) != Protocol.HTTP_1_0) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(y2.h.h2(arrayList));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((Protocol) it.next()).f5996a);
        }
        sSLParameters.setApplicationProtocols((String[]) arrayList2.toArray(new String[0]));
        sSLSocket.setSSLParameters(sSLParameters);
    }

    @Override // u3.l
    public final String f(SSLSocket sSLSocket) {
        String applicationProtocol;
        try {
            applicationProtocol = sSLSocket.getApplicationProtocol();
            if (applicationProtocol == null) {
                return null;
            }
            if (com.google.common.collect.c.n(applicationProtocol, "")) {
                return null;
            }
            return applicationProtocol;
        } catch (UnsupportedOperationException unused) {
            return null;
        }
    }
}