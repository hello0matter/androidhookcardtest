package okhttp3.internal.publicsuffix;

import com.google.common.collect.c;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Logger;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.text.b;
import t3.a;
import y2.k;
import y2.l;
import y3.d;
import y3.j;
import y3.o;
import y3.v;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lokhttp3/internal/publicsuffix/PublicSuffixDatabase;", "", "<init>", "()V", "t3/a", "okhttp"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes.dex */
public final class PublicSuffixDatabase {

    /* renamed from: e  reason: collision with root package name */
    public static final byte[] f6042e = {42};

    /* renamed from: f  reason: collision with root package name */
    public static final List f6043f = c.c1("*");

    /* renamed from: g  reason: collision with root package name */
    public static final PublicSuffixDatabase f6044g = new PublicSuffixDatabase();

    /* renamed from: a  reason: collision with root package name */
    public final AtomicBoolean f6045a = new AtomicBoolean(false);

    /* renamed from: b  reason: collision with root package name */
    public final CountDownLatch f6046b = new CountDownLatch(1);

    /* renamed from: c  reason: collision with root package name */
    public byte[] f6047c;

    /* renamed from: d  reason: collision with root package name */
    public byte[] f6048d;

    public static List c(String str) {
        List<Object> A2 = b.A2(str, new char[]{'.'});
        if (!A2.isEmpty()) {
            if (c.n(A2.get(c.x0(A2)), "")) {
                int size = A2.size() - 1;
                if (size < 0) {
                    size = 0;
                }
                if (size >= 0) {
                    if (size == 0) {
                        return EmptyList.f5181a;
                    }
                    if (size >= A2.size()) {
                        return l.q2(A2);
                    }
                    if (size == 1) {
                        if (!A2.isEmpty()) {
                            return c.c1(A2.get(0));
                        }
                        throw new NoSuchElementException("List is empty.");
                    }
                    ArrayList arrayList = new ArrayList(size);
                    int i4 = 0;
                    for (Object obj : A2) {
                        arrayList.add(obj);
                        i4++;
                        if (i4 == size) {
                            break;
                        }
                    }
                    int size2 = arrayList.size();
                    if (size2 != 0) {
                        if (size2 != 1) {
                            return arrayList;
                        }
                        return c.c1(arrayList.get(0));
                    }
                    return EmptyList.f5181a;
                }
                throw new IllegalArgumentException(("Requested element count " + size + " is less than zero.").toString());
            }
            return A2;
        }
        throw new NoSuchElementException("List is empty.");
    }

    public final String a(String str) {
        String str2;
        String str3;
        String str4;
        List list;
        List list2;
        k3.b aVar;
        int i4 = 0;
        String unicode = IDN.toUnicode(str);
        c.E(unicode, "unicodeDomain");
        List c4 = c(unicode);
        if (!this.f6045a.get() && this.f6045a.compareAndSet(false, true)) {
            boolean z4 = false;
            while (true) {
                try {
                    try {
                        b();
                        break;
                    } catch (InterruptedIOException unused) {
                        Thread.interrupted();
                        z4 = true;
                    } catch (IOException e4) {
                        u3.l lVar = u3.l.f6934a;
                        u3.l.f6934a.getClass();
                        u3.l.i("Failed to read public suffix list", 5, e4);
                        if (z4) {
                            Thread.currentThread().interrupt();
                        }
                    }
                } catch (Throwable th) {
                    if (z4) {
                        Thread.currentThread().interrupt();
                    }
                    throw th;
                }
            }
            if (z4) {
                Thread.currentThread().interrupt();
            }
        } else {
            try {
                this.f6046b.await();
            } catch (InterruptedException unused2) {
                Thread.currentThread().interrupt();
            }
        }
        if (this.f6047c != null) {
            int size = c4.size();
            byte[][] bArr = new byte[size];
            for (int i5 = 0; i5 < size; i5++) {
                Charset charset = StandardCharsets.UTF_8;
                c.E(charset, "UTF_8");
                byte[] bytes = ((String) c4.get(i5)).getBytes(charset);
                c.E(bytes, "this as java.lang.String).getBytes(charset)");
                bArr[i5] = bytes;
            }
            int i6 = 0;
            while (true) {
                if (i6 < size) {
                    byte[] bArr2 = this.f6047c;
                    if (bArr2 != null) {
                        str2 = a.a(bArr2, bArr, i6);
                        if (str2 != null) {
                            break;
                        }
                        i6++;
                    } else {
                        c.Z1("publicSuffixListBytes");
                        throw null;
                    }
                } else {
                    str2 = null;
                    break;
                }
            }
            if (size > 1) {
                byte[][] bArr3 = (byte[][]) bArr.clone();
                int length = bArr3.length - 1;
                for (int i7 = 0; i7 < length; i7++) {
                    bArr3[i7] = f6042e;
                    byte[] bArr4 = this.f6047c;
                    if (bArr4 != null) {
                        str3 = a.a(bArr4, bArr3, i7);
                        if (str3 != null) {
                            break;
                        }
                    } else {
                        c.Z1("publicSuffixListBytes");
                        throw null;
                    }
                }
            }
            str3 = null;
            if (str3 != null) {
                int i8 = size - 1;
                for (int i9 = 0; i9 < i8; i9++) {
                    byte[] bArr5 = this.f6048d;
                    if (bArr5 != null) {
                        str4 = a.a(bArr5, bArr, i9);
                        if (str4 != null) {
                            break;
                        }
                    } else {
                        c.Z1("publicSuffixExceptionListBytes");
                        throw null;
                    }
                }
            }
            str4 = null;
            if (str4 != null) {
                list2 = b.A2("!".concat(str4), new char[]{'.'});
            } else if (str2 == null && str3 == null) {
                list2 = f6043f;
            } else {
                if (str2 != null) {
                    list = b.A2(str2, new char[]{'.'});
                } else {
                    list = EmptyList.f5181a;
                }
                if (str3 != null) {
                    list2 = b.A2(str3, new char[]{'.'});
                } else {
                    list2 = EmptyList.f5181a;
                }
                if (list.size() > list2.size()) {
                    list2 = list;
                }
            }
            if (c4.size() == list2.size() && ((String) list2.get(0)).charAt(0) != '!') {
                return null;
            }
            char charAt = ((String) list2.get(0)).charAt(0);
            int size2 = c4.size();
            int size3 = list2.size();
            if (charAt != '!') {
                size3++;
            }
            int i10 = size2 - size3;
            List c5 = c(str);
            c.F(c5, "<this>");
            k3.b kVar = new k(c5);
            if (i10 >= 0) {
                if (i10 != 0) {
                    if (kVar instanceof k3.a) {
                        k3.a aVar2 = (k3.a) kVar;
                        int i11 = aVar2.f5145b + i10;
                        if (i11 < 0) {
                            aVar = new k3.a(aVar2, i10);
                        } else {
                            kVar = new k3.a(aVar2.f5144a, i11);
                        }
                    } else {
                        aVar = new k3.a(kVar, i10);
                    }
                    kVar = aVar;
                }
                StringBuilder sb = new StringBuilder();
                sb.append((CharSequence) "");
                for (Object obj : kVar) {
                    i4++;
                    if (i4 > 1) {
                        sb.append((CharSequence) ".");
                    }
                    c.k(sb, obj, null);
                }
                sb.append((CharSequence) "");
                String sb2 = sb.toString();
                c.E(sb2, "joinTo(StringBuilder(), …ed, transform).toString()");
                return sb2;
            }
            throw new IllegalArgumentException(("Requested element count " + i10 + " is less than zero.").toString());
        }
        throw new IllegalStateException("Unable to load publicsuffixes.gz resource from the classpath.".toString());
    }

    /* JADX WARN: Type inference failed for: r5v0, types: [y3.v, java.lang.Object] */
    public final void b() {
        try {
            Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
            InputStream resourceAsStream = PublicSuffixDatabase.class.getResourceAsStream("publicsuffixes.gz");
            if (resourceAsStream == null) {
                return;
            }
            Logger logger = y3.l.f7191a;
            o oVar = new o(new j(new d(resourceAsStream, (v) new Object())));
            long k4 = oVar.k();
            oVar.o(k4);
            ref$ObjectRef.f5198a = oVar.f7198b.A(k4);
            long k5 = oVar.k();
            oVar.o(k5);
            ref$ObjectRef2.f5198a = oVar.f7198b.A(k5);
            c.P(oVar, null);
            synchronized (this) {
                Object obj = ref$ObjectRef.f5198a;
                c.C(obj);
                this.f6047c = (byte[]) obj;
                Object obj2 = ref$ObjectRef2.f5198a;
                c.C(obj2);
                this.f6048d = (byte[]) obj2;
            }
        } finally {
            this.f6046b.countDown();
        }
    }
}