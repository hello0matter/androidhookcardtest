package t3;

import android.os.Build;
import androidx.annotation.VisibleForTesting;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLSocket;
import okhttp3.Protocol;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import okio.ByteString;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f6694a;

    public /* synthetic */ a(int i4) {
        this.f6694a = i4;
    }

    public static final String a(byte[] bArr, byte[][] bArr2, int i4) {
        int i5;
        boolean z4;
        int i6;
        int i7;
        byte[] bArr3 = PublicSuffixDatabase.f6042e;
        int length = bArr.length;
        int i8 = 0;
        while (i8 < length) {
            int i9 = (i8 + length) / 2;
            while (i9 > -1 && bArr[i9] != 10) {
                i9--;
            }
            int i10 = i9 + 1;
            int i11 = 1;
            while (true) {
                i5 = i10 + i11;
                if (bArr[i5] == 10) {
                    break;
                }
                i11++;
            }
            int i12 = i5 - i10;
            int i13 = i4;
            boolean z5 = false;
            int i14 = 0;
            int i15 = 0;
            while (true) {
                if (z5) {
                    i6 = 46;
                    z4 = false;
                } else {
                    byte b5 = bArr2[i13][i14];
                    byte[] bArr4 = n3.b.f5783a;
                    int i16 = b5 & 255;
                    z4 = z5;
                    i6 = i16;
                }
                byte b6 = bArr[i10 + i15];
                byte[] bArr5 = n3.b.f5783a;
                i7 = i6 - (b6 & 255);
                if (i7 != 0) {
                    break;
                }
                i15++;
                i14++;
                if (i15 == i12) {
                    break;
                } else if (bArr2[i13].length == i14) {
                    if (i13 == bArr2.length - 1) {
                        break;
                    }
                    i13++;
                    i14 = -1;
                    z5 = true;
                } else {
                    z5 = z4;
                }
            }
            if (i7 >= 0) {
                if (i7 <= 0) {
                    int i17 = i12 - i15;
                    int length2 = bArr2[i13].length - i14;
                    int length3 = bArr2.length;
                    for (int i18 = i13 + 1; i18 < length3; i18++) {
                        length2 += bArr2[i18].length;
                    }
                    if (length2 >= i17) {
                        if (length2 <= i17) {
                            Charset charset = StandardCharsets.UTF_8;
                            com.google.common.collect.c.E(charset, "UTF_8");
                            return new String(bArr, i10, i12, charset);
                        }
                    }
                }
                i8 = i5 + 1;
            }
            length = i9;
        }
        return null;
    }

    public static ArrayList b(List list) {
        com.google.common.collect.c.F(list, "protocols");
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
        return arrayList2;
    }

    public static y3.e c() {
        y3.e eVar = y3.e.f7175l;
        com.google.common.collect.c.C(eVar);
        y3.e eVar2 = eVar.f7177f;
        long nanoTime = System.nanoTime();
        if (eVar2 == null) {
            y3.e.f7172i.await(y3.e.f7173j, TimeUnit.MILLISECONDS);
            y3.e eVar3 = y3.e.f7175l;
            com.google.common.collect.c.C(eVar3);
            if (eVar3.f7177f != null || System.nanoTime() - nanoTime < y3.e.f7174k) {
                return null;
            }
            return y3.e.f7175l;
        }
        long j4 = eVar2.f7178g - nanoTime;
        if (j4 > 0) {
            y3.e.f7172i.await(j4, TimeUnit.NANOSECONDS);
            return null;
        }
        y3.e eVar4 = y3.e.f7175l;
        com.google.common.collect.c.C(eVar4);
        eVar4.f7177f = eVar2.f7177f;
        eVar2.f7177f = null;
        return eVar2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v1, types: [y3.f, y3.t, java.lang.Object] */
    public static void e(long j4, y3.f fVar, int i4, ArrayList arrayList, int i5, int i6, ArrayList arrayList2) {
        int i7;
        int i8;
        int i9;
        int i10;
        Object obj;
        int i11 = i4;
        if (i5 >= i6) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        for (int i12 = i5; i12 < i6; i12++) {
            if (((ByteString) arrayList.get(i12)).c() < i11) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
        }
        ByteString byteString = (ByteString) arrayList.get(i5);
        ByteString byteString2 = (ByteString) arrayList.get(i6 - 1);
        int i13 = -1;
        if (i11 == byteString.c()) {
            int i14 = i5 + 1;
            i7 = i14;
            i8 = ((Number) arrayList2.get(i5)).intValue();
            byteString = (ByteString) arrayList.get(i14);
        } else {
            i7 = i5;
            i8 = -1;
        }
        if (byteString.f(i11) != byteString2.f(i11)) {
            int i15 = 1;
            for (int i16 = i7 + 1; i16 < i6; i16++) {
                if (((ByteString) arrayList.get(i16 - 1)).f(i11) != ((ByteString) arrayList.get(i16)).f(i11)) {
                    i15++;
                }
            }
            long j5 = 4;
            long j6 = (fVar.f7180b / j5) + j4 + 2 + (i15 * 2);
            fVar.J(i15);
            fVar.J(i8);
            for (int i17 = i7; i17 < i6; i17++) {
                byte f4 = ((ByteString) arrayList.get(i17)).f(i11);
                if (i17 == i7 || f4 != ((ByteString) arrayList.get(i17 - 1)).f(i11)) {
                    fVar.J(f4 & 255);
                }
            }
            int i18 = i7;
            y3.f fVar2 = new Object();
            while (i18 < i6) {
                byte f5 = ((ByteString) arrayList.get(i18)).f(i11);
                int i19 = i18 + 1;
                int i20 = i19;
                while (true) {
                    if (i20 >= i6) {
                        i9 = i6;
                        break;
                    } else if (f5 != ((ByteString) arrayList.get(i20)).f(i11)) {
                        i9 = i20;
                        break;
                    } else {
                        i20++;
                    }
                }
                if (i19 == i9 && i11 + 1 == ((ByteString) arrayList.get(i18)).c()) {
                    fVar.J(((Number) arrayList2.get(i18)).intValue());
                    i10 = i9;
                    obj = fVar2;
                } else {
                    fVar.J(((int) ((fVar2.f7180b / j5) + j6)) * i13);
                    i10 = i9;
                    obj = fVar2;
                    e(j6, fVar2, i11 + 1, arrayList, i18, i9, arrayList2);
                }
                fVar2 = obj;
                i18 = i10;
                i13 = -1;
            }
            fVar.G(fVar2);
            return;
        }
        int min = Math.min(byteString.c(), byteString2.c());
        int i21 = 0;
        for (int i22 = i11; i22 < min && byteString.f(i22) == byteString2.f(i22); i22++) {
            i21++;
        }
        long j7 = 4;
        long j8 = (fVar.f7180b / j7) + j4 + 2 + i21 + 1;
        fVar.J(-i21);
        fVar.J(i8);
        int i23 = i21 + i11;
        while (i11 < i23) {
            fVar.J(byteString.f(i11) & 255);
            i11++;
        }
        if (i7 + 1 == i6) {
            if (i23 != ((ByteString) arrayList.get(i7)).c()) {
                throw new IllegalStateException("Check failed.".toString());
            }
            fVar.J(((Number) arrayList2.get(i7)).intValue());
            return;
        }
        ?? obj2 = new Object();
        fVar.J(((int) ((obj2.f7180b / j7) + j8)) * (-1));
        e(j8, obj2, i23, arrayList, i7, i6, arrayList2);
        fVar.G(obj2);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [y3.f, java.lang.Object] */
    public static byte[] f(List list) {
        com.google.common.collect.c.F(list, "protocols");
        ?? obj = new Object();
        Iterator it = b(list).iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            obj.H(str.length());
            obj.M(str);
        }
        return obj.A(obj.f7180b);
    }

    public static ByteString g(String str) {
        if (str.length() % 2 == 0) {
            int length = str.length() / 2;
            byte[] bArr = new byte[length];
            for (int i4 = 0; i4 < length; i4++) {
                int i5 = i4 * 2;
                bArr[i4] = (byte) (z3.b.a(str.charAt(i5 + 1)) + (z3.b.a(str.charAt(i5)) << 4));
            }
            return new ByteString(bArr);
        }
        throw new IllegalArgumentException("Unexpected hex string: ".concat(str).toString());
    }

    public static ByteString h(String str) {
        com.google.common.collect.c.F(str, "<this>");
        byte[] bytes = str.getBytes(l3.a.f5399a);
        com.google.common.collect.c.E(bytes, "this as java.lang.String).getBytes(charset)");
        ByteString byteString = new ByteString(bytes);
        byteString.f6052c = str;
        return byteString;
    }

    public static int j(int i4, int i5, int i6) {
        if ((i5 & 8) != 0) {
            i4--;
        }
        if (i6 <= i4) {
            return i4 - i6;
        }
        throw new IOException("PROTOCOL_ERROR padding " + i6 + " > remaining length " + i4);
    }

    public static ByteString k(byte[] bArr) {
        ByteString byteString = ByteString.f6049d;
        int length = bArr.length;
        com.google.common.collect.c.G(bArr.length, 0, length);
        return new ByteString(y2.h.k2(bArr, 0, length));
    }

    public final u3.l d() {
        switch (this.f6694a) {
            case 8:
                if (!i()) {
                    return null;
                }
                return new u3.a();
            case 9:
                if (!i()) {
                    return null;
                }
                return new u3.c();
            default:
                String property = System.getProperty("java.specification.version", "unknown");
                try {
                    com.google.common.collect.c.E(property, "jvmVersion");
                    if (Integer.parseInt(property) >= 9) {
                        return null;
                    }
                } catch (NumberFormatException unused) {
                }
                try {
                    Class<?> cls = Class.forName("org.eclipse.jetty.alpn.ALPN", true, null);
                    Class<?> cls2 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider", true, null);
                    Class<?> cls3 = Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider", true, null);
                    Class<?> cls4 = Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider", true, null);
                    Method method = cls.getMethod("put", SSLSocket.class, cls2);
                    Method method2 = cls.getMethod("get", SSLSocket.class);
                    Method method3 = cls.getMethod("remove", SSLSocket.class);
                    com.google.common.collect.c.E(method, "putMethod");
                    com.google.common.collect.c.E(method2, "getMethod");
                    com.google.common.collect.c.E(method3, "removeMethod");
                    com.google.common.collect.c.E(cls3, "clientProviderClass");
                    com.google.common.collect.c.E(cls4, "serverProviderClass");
                    return new u3.i(method, method2, method3, cls3, cls4);
                } catch (ClassNotFoundException | NoSuchMethodException unused2) {
                    return null;
                }
        }
    }

    public final boolean i() {
        switch (this.f6694a) {
            case 8:
                return u3.a.f6907e;
            case 9:
                return u3.c.f6912f;
            case 10:
                return u3.d.f6916e;
            case 11:
            case 12:
            default:
                u3.l lVar = u3.l.f6934a;
                if (com.google.common.collect.c.n("Dalvik", System.getProperty("java.vm.name")) && Build.VERSION.SDK_INT >= 29) {
                    return true;
                }
                return false;
            case 13:
                return u3.k.f6932e;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(int i4, int i5) {
        this(0);
        this.f6694a = i4;
        switch (i4) {
            case 1:
                this(1);
                return;
            case 2:
                this(2);
                return;
            case VisibleForTesting.PACKAGE_PRIVATE /* 3 */:
                this(3);
                return;
            case VisibleForTesting.PROTECTED /* 4 */:
                this(4);
                return;
            case VisibleForTesting.NONE /* 5 */:
                this(5);
                return;
            case 6:
                this(6);
                return;
            case 7:
                this(7);
                return;
            case 8:
                this(8);
                return;
            case 9:
                this(9);
                return;
            case 10:
                this(10);
                return;
            case 11:
                this(11);
                return;
            case 12:
                this(12);
                return;
            case 13:
                this(13);
                return;
            case 14:
                this(14);
                return;
            case 15:
                this(15);
                return;
            case 16:
                this(16);
                return;
            case 17:
                this(17);
                return;
            case 18:
                this(18);
                return;
            case 19:
                this(19);
                return;
            case 20:
                this(20);
                return;
            case 21:
                this(21);
                return;
            case 22:
                this(22);
                return;
            case 23:
                this(23);
                return;
            case 24:
                this(24);
                return;
            case 25:
                this(25);
                return;
            case 26:
                this(26);
                return;
            case 27:
                this(27);
                return;
            case 28:
                this(28);
                return;
            case 29:
                this(29);
                return;
            default:
                return;
        }
    }
}