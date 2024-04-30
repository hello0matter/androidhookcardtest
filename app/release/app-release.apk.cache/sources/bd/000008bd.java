package n3;

import androidx.fragment.app.m0;
import com.google.common.collect.c;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import kotlin.collections.EmptyList;
import kotlin.text.Regex;
import l3.g;
import m3.m;
import m3.o;
import m3.w;
import m3.x;
import y3.h;
import y3.t;
import y3.v;

/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f5783a;

    /* renamed from: b  reason: collision with root package name */
    public static final m f5784b = m0.p(new String[0]);

    /* renamed from: c  reason: collision with root package name */
    public static final x f5785c;

    /* renamed from: d  reason: collision with root package name */
    public static final y3.m f5786d;

    /* renamed from: e  reason: collision with root package name */
    public static final TimeZone f5787e;

    /* renamed from: f  reason: collision with root package name */
    public static final Regex f5788f;

    /* renamed from: g  reason: collision with root package name */
    public static final String f5789g;

    /* JADX WARN: Code restructure failed: missing block: B:83:0x0196, code lost:
        continue;
     */
    /* JADX WARN: Type inference failed for: r11v0, types: [y3.f, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v2, types: [y3.f, java.lang.Object] */
    static {
        /*
            Method dump skipped, instructions count: 541
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: n3.b.<clinit>():void");
    }

    public static final boolean a(o oVar, o oVar2) {
        c.F(oVar, "<this>");
        c.F(oVar2, "other");
        if (c.n(oVar.f5546d, oVar2.f5546d) && oVar.f5547e == oVar2.f5547e && c.n(oVar.f5543a, oVar2.f5543a)) {
            return true;
        }
        return false;
    }

    public static final int b(long j4, TimeUnit timeUnit) {
        int i4 = (j4 > 0L ? 1 : (j4 == 0L ? 0 : -1));
        if (i4 >= 0) {
            long millis = timeUnit.toMillis(j4);
            if (millis <= 2147483647L) {
                if (millis == 0 && i4 > 0) {
                    throw new IllegalArgumentException("timeout".concat(" too small.").toString());
                }
                return (int) millis;
            }
            throw new IllegalArgumentException("timeout".concat(" too large.").toString());
        }
        throw new IllegalStateException("timeout".concat(" < 0").toString());
    }

    public static final void c(long j4, long j5, long j6) {
        if ((j5 | j6) >= 0 && j5 <= j4 && j4 - j5 >= j6) {
            return;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public static final void d(Closeable closeable) {
        c.F(closeable, "<this>");
        try {
            closeable.close();
        } catch (RuntimeException e4) {
            throw e4;
        } catch (Exception unused) {
        }
    }

    public static final void e(Socket socket) {
        try {
            socket.close();
        } catch (AssertionError e4) {
            throw e4;
        } catch (RuntimeException e5) {
            if (c.n(e5.getMessage(), "bio == null")) {
                return;
            }
            throw e5;
        } catch (Exception unused) {
        }
    }

    public static final int f(String str, char c4, int i4, int i5) {
        c.F(str, "<this>");
        while (i4 < i5) {
            if (str.charAt(i4) == c4) {
                return i4;
            }
            i4++;
        }
        return i5;
    }

    public static final int g(String str, String str2, int i4, int i5) {
        c.F(str, "<this>");
        while (i4 < i5) {
            if (kotlin.text.b.p2(str2, str.charAt(i4))) {
                return i4;
            }
            i4++;
        }
        return i5;
    }

    public static final boolean h(t tVar, TimeUnit timeUnit) {
        c.F(tVar, "<this>");
        c.F(timeUnit, "timeUnit");
        try {
            return u(tVar, 100, timeUnit);
        } catch (IOException unused) {
            return false;
        }
    }

    public static final String i(String str, Object... objArr) {
        c.F(str, "format");
        Locale locale = Locale.US;
        Object[] copyOf = Arrays.copyOf(objArr, objArr.length);
        return String.format(locale, str, Arrays.copyOf(copyOf, copyOf.length));
    }

    public static final boolean j(String[] strArr, String[] strArr2, Comparator comparator) {
        c.F(strArr, "<this>");
        if (strArr.length != 0 && strArr2 != null && strArr2.length != 0) {
            for (String str : strArr) {
                y2.a aVar = new y2.a(strArr2);
                while (aVar.hasNext()) {
                    if (comparator.compare(str, (String) aVar.next()) == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static final long k(w wVar) {
        String a5 = wVar.f5629f.a("Content-Length");
        if (a5 == null) {
            return -1L;
        }
        try {
            return Long.parseLong(a5);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    public static final List l(Object... objArr) {
        List list;
        c.F(objArr, "elements");
        Object[] objArr2 = (Object[]) objArr.clone();
        Object[] copyOf = Arrays.copyOf(objArr2, objArr2.length);
        c.F(copyOf, "elements");
        if (copyOf.length > 0) {
            list = Arrays.asList(copyOf);
            c.E(list, "asList(this)");
        } else {
            list = EmptyList.f5181a;
        }
        List unmodifiableList = Collections.unmodifiableList(list);
        c.E(unmodifiableList, "unmodifiableList(listOf(*elements.clone()))");
        return unmodifiableList;
    }

    public static final int m(String str) {
        int length = str.length();
        for (int i4 = 0; i4 < length; i4++) {
            char charAt = str.charAt(i4);
            if (c.Q(charAt, 31) <= 0 || c.Q(charAt, 127) >= 0) {
                return i4;
            }
        }
        return -1;
    }

    public static final int n(int i4, int i5, String str) {
        while (i4 < i5) {
            char charAt = str.charAt(i4);
            if (charAt == '\t' || charAt == '\n' || charAt == '\f' || charAt == '\r' || charAt == ' ') {
                i4++;
            } else {
                return i4;
            }
        }
        return i5;
    }

    public static final int o(int i4, int i5, String str) {
        int i6 = i5 - 1;
        if (i4 <= i6) {
            while (true) {
                char charAt = str.charAt(i6);
                if (charAt == '\t' || charAt == '\n' || charAt == '\f' || charAt == '\r' || charAt == ' ') {
                    if (i6 == i4) {
                        break;
                    }
                    i6--;
                } else {
                    return i6 + 1;
                }
            }
        }
        return i4;
    }

    public static final String[] p(String[] strArr, String[] strArr2, Comparator comparator) {
        c.F(strArr2, "other");
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            int length = strArr2.length;
            int i4 = 0;
            while (true) {
                if (i4 >= length) {
                    break;
                } else if (comparator.compare(str, strArr2[i4]) == 0) {
                    arrayList.add(str);
                    break;
                } else {
                    i4++;
                }
            }
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public static final boolean q(String str) {
        c.F(str, "name");
        if (!g.j2(str, "Authorization") && !g.j2(str, "Cookie") && !g.j2(str, "Proxy-Authorization") && !g.j2(str, "Set-Cookie")) {
            return false;
        }
        return true;
    }

    public static final int r(char c4) {
        if ('0' <= c4 && c4 < ':') {
            return c4 - '0';
        }
        if ('a' <= c4 && c4 < 'g') {
            return c4 - 'W';
        }
        if ('A' <= c4 && c4 < 'G') {
            return c4 - '7';
        }
        return -1;
    }

    public static final Charset s(h hVar, Charset charset) {
        Charset charset2;
        String str;
        Charset charset3;
        c.F(hVar, "<this>");
        c.F(charset, "default");
        int m4 = hVar.m(f5786d);
        if (m4 != -1) {
            if (m4 != 0) {
                if (m4 != 1) {
                    if (m4 != 2) {
                        if (m4 != 3) {
                            if (m4 == 4) {
                                Charset charset4 = l3.a.f5399a;
                                charset3 = l3.a.f5400b;
                                if (charset3 == null) {
                                    charset3 = Charset.forName("UTF-32LE");
                                    c.E(charset3, "forName(\"UTF-32LE\")");
                                    l3.a.f5400b = charset3;
                                }
                            } else {
                                throw new AssertionError();
                            }
                        } else {
                            Charset charset5 = l3.a.f5399a;
                            charset3 = l3.a.f5401c;
                            if (charset3 == null) {
                                charset3 = Charset.forName("UTF-32BE");
                                c.E(charset3, "forName(\"UTF-32BE\")");
                                l3.a.f5401c = charset3;
                            }
                        }
                        return charset3;
                    }
                    charset2 = StandardCharsets.UTF_16LE;
                    str = "UTF_16LE";
                } else {
                    charset2 = StandardCharsets.UTF_16BE;
                    str = "UTF_16BE";
                }
            } else {
                charset2 = StandardCharsets.UTF_8;
                str = "UTF_8";
            }
            c.E(charset2, str);
            return charset2;
        }
        return charset;
    }

    public static final int t(h hVar) {
        c.F(hVar, "<this>");
        return (hVar.v() & 255) | ((hVar.v() & 255) << 16) | ((hVar.v() & 255) << 8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v6, types: [y3.f, java.lang.Object] */
    public static final boolean u(t tVar, int i4, TimeUnit timeUnit) {
        long j4;
        c.F(tVar, "<this>");
        c.F(timeUnit, "timeUnit");
        long nanoTime = System.nanoTime();
        if (tVar.a().e()) {
            j4 = tVar.a().c() - nanoTime;
        } else {
            j4 = Long.MAX_VALUE;
        }
        tVar.a().d(Math.min(j4, timeUnit.toNanos(i4)) + nanoTime);
        try {
            ?? obj = new Object();
            while (tVar.w(obj, 8192L) != -1) {
                obj.h(obj.f7180b);
            }
            int i5 = (j4 > Long.MAX_VALUE ? 1 : (j4 == Long.MAX_VALUE ? 0 : -1));
            v a5 = tVar.a();
            if (i5 == 0) {
                a5.a();
            } else {
                a5.d(nanoTime + j4);
            }
            return true;
        } catch (InterruptedIOException unused) {
            int i6 = (j4 > Long.MAX_VALUE ? 1 : (j4 == Long.MAX_VALUE ? 0 : -1));
            v a6 = tVar.a();
            if (i6 == 0) {
                a6.a();
            } else {
                a6.d(nanoTime + j4);
            }
            return false;
        } catch (Throwable th) {
            int i7 = (j4 > Long.MAX_VALUE ? 1 : (j4 == Long.MAX_VALUE ? 0 : -1));
            v a7 = tVar.a();
            if (i7 == 0) {
                a7.a();
            } else {
                a7.d(nanoTime + j4);
            }
            throw th;
        }
    }

    public static final m v(List list) {
        ArrayList arrayList = new ArrayList(20);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            t3.b bVar = (t3.b) it.next();
            String j4 = bVar.f6708a.j();
            String j5 = bVar.f6709b.j();
            arrayList.add(j4);
            arrayList.add(kotlin.text.b.C2(j5).toString());
        }
        return new m((String[]) arrayList.toArray(new String[0]));
    }

    public static final String w(o oVar, boolean z4) {
        int i4;
        c.F(oVar, "<this>");
        String str = oVar.f5546d;
        if (kotlin.text.b.q2(str, ":")) {
            str = "[" + str + ']';
        }
        int i5 = oVar.f5547e;
        if (!z4) {
            String str2 = oVar.f5543a;
            c.F(str2, "scheme");
            if (c.n(str2, "http")) {
                i4 = 80;
            } else if (c.n(str2, "https")) {
                i4 = 443;
            } else {
                i4 = -1;
            }
            if (i5 == i4) {
                return str;
            }
        }
        return str + ':' + i5;
    }

    public static final List x(List list) {
        c.F(list, "<this>");
        List unmodifiableList = Collections.unmodifiableList(new ArrayList(list));
        c.E(unmodifiableList, "unmodifiableList(toMutableList())");
        return unmodifiableList;
    }

    public static final int y(String str, int i4) {
        if (str != null) {
            try {
                long parseLong = Long.parseLong(str);
                if (parseLong > 2147483647L) {
                    return Integer.MAX_VALUE;
                }
                if (parseLong < 0) {
                    return 0;
                }
                return (int) parseLong;
            } catch (NumberFormatException unused) {
            }
        }
        return i4;
    }

    public static final String z(int i4, int i5, String str) {
        int n4 = n(i4, i5, str);
        String substring = str.substring(n4, o(n4, i5, str));
        c.E(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }
}