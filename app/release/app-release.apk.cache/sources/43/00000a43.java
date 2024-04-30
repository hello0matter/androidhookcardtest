package x3;

import java.security.cert.Certificate;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import kotlin.collections.EmptyList;
import kotlin.text.Regex;
import l3.g;

/* loaded from: classes.dex */
public final class c implements HostnameVerifier {

    /* renamed from: a  reason: collision with root package name */
    public static final c f7146a = new Object();

    public static List a(X509Certificate x509Certificate, int i4) {
        Object obj;
        try {
            Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames == null) {
                return EmptyList.f5181a;
            }
            ArrayList arrayList = new ArrayList();
            for (List<?> list : subjectAlternativeNames) {
                if (list != null && list.size() >= 2 && com.google.common.collect.c.n(list.get(0), Integer.valueOf(i4)) && (obj = list.get(1)) != null) {
                    arrayList.add((String) obj);
                }
            }
            return arrayList;
        } catch (CertificateParsingException unused) {
            return EmptyList.f5181a;
        }
    }

    public static boolean b(String str) {
        int i4;
        char c4;
        int length = str.length();
        int length2 = str.length();
        if (length2 >= 0) {
            if (length2 <= str.length()) {
                long j4 = 0;
                int i5 = 0;
                while (i5 < length2) {
                    char charAt = str.charAt(i5);
                    if (charAt < 128) {
                        j4++;
                    } else {
                        if (charAt < 2048) {
                            i4 = 2;
                        } else if (charAt >= 55296 && charAt <= 57343) {
                            int i6 = i5 + 1;
                            if (i6 < length2) {
                                c4 = str.charAt(i6);
                            } else {
                                c4 = 0;
                            }
                            if (charAt <= 56319 && c4 >= 56320 && c4 <= 57343) {
                                j4 += 4;
                                i5 += 2;
                            } else {
                                j4++;
                                i5 = i6;
                            }
                        } else {
                            i4 = 3;
                        }
                        j4 += i4;
                    }
                    i5++;
                }
                if (length != ((int) j4)) {
                    return false;
                }
                return true;
            }
            throw new IllegalArgumentException(("endIndex > string.length: " + length2 + " > " + str.length()).toString());
        }
        throw new IllegalArgumentException(("endIndex < beginIndex: " + length2 + " < 0").toString());
    }

    public static boolean c(String str, X509Certificate x509Certificate) {
        String str2;
        int length;
        com.google.common.collect.c.F(str, "host");
        byte[] bArr = n3.b.f5783a;
        Regex regex = n3.b.f5788f;
        regex.getClass();
        if (regex.f5200a.matcher(str).matches()) {
            String a22 = com.google.common.collect.c.a2(str);
            List<String> a5 = a(x509Certificate, 7);
            if (!(a5 instanceof Collection) || !a5.isEmpty()) {
                for (String str3 : a5) {
                    if (com.google.common.collect.c.n(a22, com.google.common.collect.c.a2(str3))) {
                        return true;
                    }
                }
            }
        } else {
            if (b(str)) {
                Locale locale = Locale.US;
                com.google.common.collect.c.E(locale, "US");
                str = str.toLowerCase(locale);
                com.google.common.collect.c.E(str, "this as java.lang.String).toLowerCase(locale)");
            }
            List<String> a6 = a(x509Certificate, 2);
            if (!(a6 instanceof Collection) || !a6.isEmpty()) {
                for (String str4 : a6) {
                    if (str.length() != 0 && !g.o2(str, ".", false) && !str.endsWith("..") && str4 != null && str4.length() != 0 && !g.o2(str4, ".", false) && !str4.endsWith("..")) {
                        if (!str.endsWith(".")) {
                            str2 = str.concat(".");
                        } else {
                            str2 = str;
                        }
                        if (!str4.endsWith(".")) {
                            str4 = str4.concat(".");
                        }
                        if (b(str4)) {
                            Locale locale2 = Locale.US;
                            com.google.common.collect.c.E(locale2, "US");
                            str4 = str4.toLowerCase(locale2);
                            com.google.common.collect.c.E(str4, "this as java.lang.String).toLowerCase(locale)");
                        }
                        if (!kotlin.text.b.q2(str4, "*")) {
                            if (com.google.common.collect.c.n(str2, str4)) {
                                return true;
                            }
                        } else if (g.o2(str4, "*.", false) && kotlin.text.b.t2(str4, '*', 1, false, 4) == -1 && str2.length() >= str4.length() && !com.google.common.collect.c.n("*.", str4)) {
                            String substring = str4.substring(1);
                            com.google.common.collect.c.E(substring, "this as java.lang.String).substring(startIndex)");
                            if (str2.endsWith(substring) && ((length = str2.length() - substring.length()) <= 0 || kotlin.text.b.w2(str2, '.', length - 1, 4) == -1)) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override // javax.net.ssl.HostnameVerifier
    public final boolean verify(String str, SSLSession sSLSession) {
        Certificate certificate;
        com.google.common.collect.c.F(str, "host");
        com.google.common.collect.c.F(sSLSession, "session");
        if (b(str)) {
            try {
                certificate = sSLSession.getPeerCertificates()[0];
                com.google.common.collect.c.D(certificate, "null cannot be cast to non-null type java.security.cert.X509Certificate");
            } catch (SSLException unused) {
                return false;
            }
        }
        return c(str, (X509Certificate) certificate);
    }
}