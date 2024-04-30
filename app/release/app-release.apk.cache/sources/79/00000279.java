package androidx.fragment.app;

import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import androidx.cardview.widget.CardView;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.Protocol;
import okhttp3.TlsVersion;

/* loaded from: classes.dex */
public final class m0 implements androidx.lifecycle.j0, t3.c0 {
    public m0(int[] iArr, ValueAnimator valueAnimator) {
    }

    public static final m3.e c(m0 m0Var, String str) {
        m3.e eVar = new m3.e(str);
        m3.e.f5488d.put(str, eVar);
        return eVar;
    }

    public static final m3.w d(m3.w wVar) {
        m3.y yVar;
        if (wVar != null) {
            yVar = wVar.f5630g;
        } else {
            yVar = null;
        }
        if (yVar != null) {
            m3.v y4 = wVar.y();
            y4.f5617g = null;
            return y4.a();
        }
        return wVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v6, types: [y3.f] */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r9v1, types: [y3.f, java.lang.Object] */
    public static String e(String str, int i4, int i5, String str2, boolean z4, boolean z5, boolean z6, boolean z7, int i6) {
        int i7 = (i6 & 1) != 0 ? 0 : i4;
        int length = (i6 & 2) != 0 ? str.length() : i5;
        boolean z8 = (i6 & 8) != 0 ? false : z4;
        boolean z9 = (i6 & 16) != 0 ? false : z5;
        boolean z10 = (i6 & 32) != 0 ? false : z6;
        boolean z11 = (i6 & 64) == 0 ? z7 : false;
        com.google.common.collect.c.F(str, "<this>");
        int i8 = i7;
        while (i8 < length) {
            int codePointAt = str.codePointAt(i8);
            int i9 = 32;
            int i10 = 128;
            if (codePointAt < 32 || codePointAt == 127 || ((codePointAt >= 128 && !z11) || kotlin.text.b.p2(str2, (char) codePointAt) || ((codePointAt == 37 && (!z8 || (z9 && !o(i8, length, str)))) || (codePointAt == 43 && z10)))) {
                ?? obj = new Object();
                obj.L(i7, i8, str);
                ?? r22 = 0;
                while (i8 < length) {
                    int codePointAt2 = str.codePointAt(i8);
                    if (!z8 || (codePointAt2 != 9 && codePointAt2 != 10 && codePointAt2 != 12 && codePointAt2 != 13)) {
                        if (codePointAt2 == 43 && z10) {
                            obj.M(z8 ? "+" : "%2B");
                        } else if (codePointAt2 < i9 || codePointAt2 == 127 || ((codePointAt2 >= i10 && !z11) || kotlin.text.b.p2(str2, (char) codePointAt2) || (codePointAt2 == 37 && (!z8 || (z9 && !o(i8, length, str)))))) {
                            if (r22 == 0) {
                                r22 = new Object();
                            }
                            r22.N(codePointAt2);
                            while (!r22.r()) {
                                byte v2 = r22.v();
                                obj.H(37);
                                char[] cArr = m3.o.f5542j;
                                obj.H(cArr[((v2 & 255) >> 4) & 15]);
                                obj.H(cArr[v2 & 15]);
                            }
                        } else {
                            obj.N(codePointAt2);
                        }
                    }
                    i8 += Character.charCount(codePointAt2);
                    i9 = 32;
                    i10 = 128;
                    r22 = r22;
                }
                return obj.B(obj.f7180b, l3.a.f5399a);
            }
            i8 += Character.charCount(codePointAt);
        }
        String substring = str.substring(i7, length);
        com.google.common.collect.c.E(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static void f(String str) {
        if (str.length() > 0) {
            int length = str.length();
            for (int i4 = 0; i4 < length; i4++) {
                char charAt = str.charAt(i4);
                if ('!' > charAt || charAt >= 127) {
                    throw new IllegalArgumentException(n3.b.i("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(charAt), Integer.valueOf(i4), str).toString());
                }
            }
            return;
        }
        throw new IllegalArgumentException("name is empty".toString());
    }

    public static void g(String str, String str2) {
        String concat;
        int length = str.length();
        for (int i4 = 0; i4 < length; i4++) {
            char charAt = str.charAt(i4);
            if (charAt != '\t' && (' ' > charAt || charAt >= 127)) {
                StringBuilder sb = new StringBuilder();
                sb.append(n3.b.i("Unexpected char %#04x at %d in %s value", Integer.valueOf(charAt), Integer.valueOf(i4), str2));
                if (n3.b.q(str2)) {
                    concat = "";
                } else {
                    concat = ": ".concat(str);
                }
                sb.append(concat);
                throw new IllegalArgumentException(sb.toString().toString());
            }
        }
    }

    public static int h(String str, int i4, int i5, boolean z4) {
        boolean z5;
        while (i4 < i5) {
            char charAt = str.charAt(i4);
            if ((charAt >= ' ' || charAt == '\t') && charAt < 127 && (('0' > charAt || charAt >= ':') && (('a' > charAt || charAt >= '{') && (('A' > charAt || charAt >= '[') && charAt != ':')))) {
                z5 = false;
            } else {
                z5 = true;
            }
            if (z5 == (!z4)) {
                return i4;
            }
            i4++;
        }
        return i5;
    }

    public static TlsVersion j(String str) {
        com.google.common.collect.c.F(str, "javaName");
        int hashCode = str.hashCode();
        if (hashCode != 79201641) {
            if (hashCode != 79923350) {
                switch (hashCode) {
                    case -503070503:
                        if (str.equals("TLSv1.1")) {
                            return TlsVersion.TLS_1_1;
                        }
                        break;
                    case -503070502:
                        if (str.equals("TLSv1.2")) {
                            return TlsVersion.TLS_1_2;
                        }
                        break;
                    case -503070501:
                        if (str.equals("TLSv1.3")) {
                            return TlsVersion.TLS_1_3;
                        }
                        break;
                }
            } else if (str.equals("TLSv1")) {
                return TlsVersion.TLS_1_0;
            }
        } else if (str.equals("SSLv3")) {
            return TlsVersion.SSL_3_0;
        }
        throw new IllegalArgumentException("Unexpected TLS version: ".concat(str));
    }

    public static m3.q k(String str) {
        com.google.common.collect.c.F(str, "<this>");
        Matcher matcher = m3.q.f5552c.matcher(str);
        if (matcher.lookingAt()) {
            String group = matcher.group(1);
            com.google.common.collect.c.E(group, "typeSubtype.group(1)");
            Locale locale = Locale.US;
            com.google.common.collect.c.E(locale, "US");
            com.google.common.collect.c.E(group.toLowerCase(locale), "this as java.lang.String).toLowerCase(locale)");
            String group2 = matcher.group(2);
            com.google.common.collect.c.E(group2, "typeSubtype.group(2)");
            com.google.common.collect.c.E(group2.toLowerCase(locale), "this as java.lang.String).toLowerCase(locale)");
            ArrayList arrayList = new ArrayList();
            Matcher matcher2 = m3.q.f5553d.matcher(str);
            for (int end = matcher.end(); end < str.length(); end = matcher2.end()) {
                matcher2.region(end, str.length());
                if (matcher2.lookingAt()) {
                    String group3 = matcher2.group(1);
                    if (group3 != null) {
                        String group4 = matcher2.group(2);
                        if (group4 == null) {
                            group4 = matcher2.group(3);
                        } else if (l3.g.o2(group4, "'", false) && group4.endsWith("'") && group4.length() > 2) {
                            group4 = group4.substring(1, group4.length() - 1);
                            com.google.common.collect.c.E(group4, "this as java.lang.String…ing(startIndex, endIndex)");
                        }
                        arrayList.add(group3);
                        arrayList.add(group4);
                    }
                } else {
                    StringBuilder sb = new StringBuilder("Parameter is not formatted correctly: \"");
                    String substring = str.substring(end);
                    com.google.common.collect.c.E(substring, "this as java.lang.String).substring(startIndex)");
                    sb.append(substring);
                    sb.append("\" for: \"");
                    sb.append(str);
                    sb.append('\"');
                    throw new IllegalArgumentException(sb.toString().toString());
                }
            }
            return new m3.q(str, (String[]) arrayList.toArray(new String[0]));
        }
        throw new IllegalArgumentException(("No subtype found for: \"" + str + '\"').toString());
    }

    public static Protocol l(String str) {
        if (com.google.common.collect.c.n(str, "http/1.0")) {
            return Protocol.HTTP_1_0;
        }
        if (com.google.common.collect.c.n(str, "http/1.1")) {
            return Protocol.HTTP_1_1;
        }
        if (com.google.common.collect.c.n(str, "h2_prior_knowledge")) {
            return Protocol.H2_PRIOR_KNOWLEDGE;
        }
        if (com.google.common.collect.c.n(str, "h2")) {
            return Protocol.HTTP_2;
        }
        if (com.google.common.collect.c.n(str, "spdy/3.1")) {
            return Protocol.SPDY_3;
        }
        if (com.google.common.collect.c.n(str, "quic")) {
            return Protocol.QUIC;
        }
        throw new IOException("Unexpected protocol: ".concat(str));
    }

    public static k.a m(androidx.appcompat.widget.c0 c0Var) {
        return (k.a) ((Drawable) c0Var.f725b);
    }

    public static boolean n(String str) {
        if (!l3.g.j2("Connection", str) && !l3.g.j2("Keep-Alive", str) && !l3.g.j2("Proxy-Authenticate", str) && !l3.g.j2("Proxy-Authorization", str) && !l3.g.j2("TE", str) && !l3.g.j2("Trailers", str) && !l3.g.j2("Transfer-Encoding", str) && !l3.g.j2("Upgrade", str)) {
            return true;
        }
        return false;
    }

    public static boolean o(int i4, int i5, String str) {
        int i6 = i4 + 2;
        if (i6 < i5 && str.charAt(i4) == '%' && n3.b.r(str.charAt(i4 + 1)) != -1 && n3.b.r(str.charAt(i6)) != -1) {
            return true;
        }
        return false;
    }

    public static m3.m p(String... strArr) {
        if (strArr.length % 2 == 0) {
            String[] strArr2 = (String[]) strArr.clone();
            int length = strArr2.length;
            int i4 = 0;
            for (int i5 = 0; i5 < length; i5++) {
                String str = strArr2[i5];
                if (str != null) {
                    strArr2[i5] = kotlin.text.b.C2(str).toString();
                } else {
                    throw new IllegalArgumentException("Headers cannot be null".toString());
                }
            }
            int L0 = com.google.common.collect.c.L0(0, strArr2.length - 1, 2);
            if (L0 >= 0) {
                while (true) {
                    String str2 = strArr2[i4];
                    String str3 = strArr2[i4 + 1];
                    f(str2);
                    g(str3, str2);
                    if (i4 == L0) {
                        break;
                    }
                    i4 += 2;
                }
            }
            return new m3.m(strArr2);
        }
        throw new IllegalArgumentException("Expected alternating header names and values".toString());
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static m3.c q(m3.m r25) {
        /*
            Method dump skipped, instructions count: 512
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.m0.q(m3.m):m3.c");
    }

    public static r3.h r(String str) {
        int i4;
        String str2;
        com.google.common.collect.c.F(str, "statusLine");
        boolean o22 = l3.g.o2(str, "HTTP/1.", false);
        Protocol protocol = Protocol.HTTP_1_0;
        if (o22) {
            i4 = 9;
            if (str.length() >= 9 && str.charAt(8) == ' ') {
                int charAt = str.charAt(7) - '0';
                if (charAt != 0) {
                    if (charAt == 1) {
                        protocol = Protocol.HTTP_1_1;
                    } else {
                        throw new ProtocolException("Unexpected status line: ".concat(str));
                    }
                }
            } else {
                throw new ProtocolException("Unexpected status line: ".concat(str));
            }
        } else if (l3.g.o2(str, "ICY ", false)) {
            i4 = 4;
        } else {
            throw new ProtocolException("Unexpected status line: ".concat(str));
        }
        int i5 = i4 + 3;
        if (str.length() >= i5) {
            try {
                String substring = str.substring(i4, i5);
                com.google.common.collect.c.E(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                int parseInt = Integer.parseInt(substring);
                if (str.length() > i5) {
                    if (str.charAt(i5) == ' ') {
                        str2 = str.substring(i4 + 4);
                        com.google.common.collect.c.E(str2, "this as java.lang.String).substring(startIndex)");
                    } else {
                        throw new ProtocolException("Unexpected status line: ".concat(str));
                    }
                } else {
                    str2 = "";
                }
                return new r3.h(protocol, parseInt, str2);
            } catch (NumberFormatException unused) {
                throw new ProtocolException("Unexpected status line: ".concat(str));
            }
        }
        throw new ProtocolException("Unexpected status line: ".concat(str));
    }

    public static long s(int i4, String str) {
        int h4 = h(str, 0, i4, false);
        Matcher matcher = m3.h.f5519m.matcher(str);
        int i5 = -1;
        int i6 = -1;
        int i7 = -1;
        int i8 = -1;
        int i9 = -1;
        int i10 = -1;
        while (h4 < i4) {
            int h5 = h(str, h4 + 1, i4, true);
            matcher.region(h4, h5);
            if (i6 == -1 && matcher.usePattern(m3.h.f5519m).matches()) {
                String group = matcher.group(1);
                com.google.common.collect.c.E(group, "matcher.group(1)");
                i6 = Integer.parseInt(group);
                String group2 = matcher.group(2);
                com.google.common.collect.c.E(group2, "matcher.group(2)");
                i9 = Integer.parseInt(group2);
                String group3 = matcher.group(3);
                com.google.common.collect.c.E(group3, "matcher.group(3)");
                i10 = Integer.parseInt(group3);
            } else if (i7 == -1 && matcher.usePattern(m3.h.f5518l).matches()) {
                String group4 = matcher.group(1);
                com.google.common.collect.c.E(group4, "matcher.group(1)");
                i7 = Integer.parseInt(group4);
            } else {
                if (i8 == -1) {
                    Pattern pattern = m3.h.f5517k;
                    if (matcher.usePattern(pattern).matches()) {
                        String group5 = matcher.group(1);
                        com.google.common.collect.c.E(group5, "matcher.group(1)");
                        Locale locale = Locale.US;
                        com.google.common.collect.c.E(locale, "US");
                        String lowerCase = group5.toLowerCase(locale);
                        com.google.common.collect.c.E(lowerCase, "this as java.lang.String).toLowerCase(locale)");
                        String pattern2 = pattern.pattern();
                        com.google.common.collect.c.E(pattern2, "MONTH_PATTERN.pattern()");
                        i8 = kotlin.text.b.u2(pattern2, lowerCase, 0, false, 6) / 4;
                    }
                }
                if (i5 == -1 && matcher.usePattern(m3.h.f5516j).matches()) {
                    String group6 = matcher.group(1);
                    com.google.common.collect.c.E(group6, "matcher.group(1)");
                    i5 = Integer.parseInt(group6);
                }
            }
            h4 = h(str, h5 + 1, i4, false);
        }
        if (70 <= i5 && i5 < 100) {
            i5 += 1900;
        }
        if (i5 >= 0 && i5 < 70) {
            i5 += 2000;
        }
        if (i5 >= 1601) {
            if (i8 != -1) {
                if (1 <= i7 && i7 < 32) {
                    if (i6 >= 0 && i6 < 24) {
                        if (i9 >= 0 && i9 < 60) {
                            if (i10 >= 0 && i10 < 60) {
                                GregorianCalendar gregorianCalendar = new GregorianCalendar(n3.b.f5787e);
                                gregorianCalendar.setLenient(false);
                                gregorianCalendar.set(1, i5);
                                gregorianCalendar.set(2, i8 - 1);
                                gregorianCalendar.set(5, i7);
                                gregorianCalendar.set(11, i6);
                                gregorianCalendar.set(12, i9);
                                gregorianCalendar.set(13, i10);
                                gregorianCalendar.set(14, 0);
                                return gregorianCalendar.getTimeInMillis();
                            }
                            throw new IllegalArgumentException("Failed requirement.".toString());
                        }
                        throw new IllegalArgumentException("Failed requirement.".toString());
                    }
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [y3.f, java.lang.Object] */
    public static String t(String str, int i4, int i5, boolean z4, int i6) {
        int i7;
        if ((i6 & 1) != 0) {
            i4 = 0;
        }
        if ((i6 & 2) != 0) {
            i5 = str.length();
        }
        if ((i6 & 4) != 0) {
            z4 = false;
        }
        com.google.common.collect.c.F(str, "<this>");
        int i8 = i4;
        while (i8 < i5) {
            char charAt = str.charAt(i8);
            if (charAt != '%' && (charAt != '+' || !z4)) {
                i8++;
            } else {
                ?? obj = new Object();
                obj.L(i4, i8, str);
                while (i8 < i5) {
                    int codePointAt = str.codePointAt(i8);
                    if (codePointAt == 37 && (i7 = i8 + 2) < i5) {
                        int r4 = n3.b.r(str.charAt(i8 + 1));
                        int r5 = n3.b.r(str.charAt(i7));
                        if (r4 != -1 && r5 != -1) {
                            obj.H((r4 << 4) + r5);
                            i8 = Character.charCount(codePointAt) + i7;
                        }
                        obj.N(codePointAt);
                        i8 += Character.charCount(codePointAt);
                    } else {
                        if (codePointAt == 43 && z4) {
                            obj.H(32);
                            i8++;
                        }
                        obj.N(codePointAt);
                        i8 += Character.charCount(codePointAt);
                    }
                }
                return obj.B(obj.f7180b, l3.a.f5399a);
            }
        }
        String substring = str.substring(i4, i5);
        com.google.common.collect.c.E(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static ArrayList v(String str) {
        String str2;
        ArrayList arrayList = new ArrayList();
        int i4 = 0;
        while (i4 <= str.length()) {
            int t22 = kotlin.text.b.t2(str, '&', i4, false, 4);
            if (t22 == -1) {
                t22 = str.length();
            }
            int t23 = kotlin.text.b.t2(str, '=', i4, false, 4);
            if (t23 != -1 && t23 <= t22) {
                String substring = str.substring(i4, t23);
                com.google.common.collect.c.E(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                arrayList.add(substring);
                str2 = str.substring(t23 + 1, t22);
                com.google.common.collect.c.E(str2, "this as java.lang.String…ing(startIndex, endIndex)");
            } else {
                String substring2 = str.substring(i4, t22);
                com.google.common.collect.c.E(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
                arrayList.add(substring2);
                str2 = null;
            }
            arrayList.add(str2);
            i4 = t22 + 1;
        }
        return arrayList;
    }

    @Override // androidx.lifecycle.j0
    public androidx.lifecycle.h0 a(Class cls) {
        return new n0(true);
    }

    public synchronized m3.e i(String str) {
        m3.e eVar;
        String str2;
        try {
            com.google.common.collect.c.F(str, "javaName");
            LinkedHashMap linkedHashMap = m3.e.f5488d;
            eVar = (m3.e) linkedHashMap.get(str);
            if (eVar == null) {
                if (l3.g.o2(str, "TLS_", false)) {
                    String substring = str.substring(4);
                    com.google.common.collect.c.E(substring, "this as java.lang.String).substring(startIndex)");
                    str2 = "SSL_".concat(substring);
                } else if (l3.g.o2(str, "SSL_", false)) {
                    String substring2 = str.substring(4);
                    com.google.common.collect.c.E(substring2, "this as java.lang.String).substring(startIndex)");
                    str2 = "TLS_".concat(substring2);
                } else {
                    str2 = str;
                }
                eVar = (m3.e) linkedHashMap.get(str2);
                if (eVar == null) {
                    eVar = new m3.e(str);
                }
                linkedHashMap.put(str, eVar);
            }
        } catch (Throwable th) {
            throw th;
        }
        return eVar;
    }

    public void u(float f4, androidx.appcompat.widget.c0 c0Var) {
        k.a m4 = m(c0Var);
        boolean useCompatPadding = ((CardView) c0Var.f726c).getUseCompatPadding();
        boolean preventCornerOverlap = ((CardView) c0Var.f726c).getPreventCornerOverlap();
        if (f4 != m4.f5107e || m4.f5108f != useCompatPadding || m4.f5109g != preventCornerOverlap) {
            m4.f5107e = f4;
            m4.f5108f = useCompatPadding;
            m4.f5109g = preventCornerOverlap;
            m4.b(null);
            m4.invalidateSelf();
        }
        w(c0Var);
    }

    public void w(androidx.appcompat.widget.c0 c0Var) {
        if (!((CardView) c0Var.f726c).getUseCompatPadding()) {
            c0Var.k(0, 0, 0, 0);
            return;
        }
        Object obj = c0Var.f725b;
        float f4 = ((k.a) ((Drawable) obj)).f5107e;
        float f5 = ((k.a) ((Drawable) obj)).f5103a;
        int ceil = (int) Math.ceil(k.b.a(f4, f5, ((CardView) c0Var.f726c).getPreventCornerOverlap()));
        int ceil2 = (int) Math.ceil(k.b.b(f4, f5, ((CardView) c0Var.f726c).getPreventCornerOverlap()));
        c0Var.k(ceil, ceil2, ceil, ceil2);
    }
}