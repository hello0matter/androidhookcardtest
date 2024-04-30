package okio;

import androidx.activity.j;
import com.google.common.collect.c;
import java.io.EOFException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.security.MessageDigest;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import y3.a;
import y3.f;
import z3.b;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u0012J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000bR\u001a\u0010\u0011\u001a\u00020\f8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lokio/ByteString;", "Ljava/io/Serializable;", "", "Ljava/io/ObjectInputStream;", "in", "Lx2/c;", "readObject", "(Ljava/io/ObjectInputStream;)V", "Ljava/io/ObjectOutputStream;", "out", "writeObject", "(Ljava/io/ObjectOutputStream;)V", "", "a", "[B", "getData$okio", "()[B", "data", "t3/a", "okio"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nByteString.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ByteString.kt\nokio/ByteString\n+ 2 ByteString.kt\nokio/internal/-ByteString\n+ 3 Util.kt\nokio/-SegmentedByteString\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,364:1\n43#2,7:365\n53#2:372\n56#2:373\n64#2,4:374\n68#2:379\n70#2:381\n76#2,23:382\n104#2,23:405\n131#2,2:428\n133#2,9:431\n145#2:440\n148#2:441\n151#2:442\n154#2:443\n162#2:444\n172#2,3:445\n171#2:448\n185#2,2:449\n190#2:451\n194#2:452\n198#2:453\n202#2:454\n206#2,7:455\n219#2:462\n223#2,8:463\n235#2,4:471\n244#2,5:475\n253#2,6:480\n259#2,9:487\n322#2,8:496\n131#2,2:504\n133#2,9:507\n333#2,9:516\n68#3:378\n74#3:380\n74#3:486\n1#4:430\n1#4:506\n*S KotlinDebug\n*F\n+ 1 ByteString.kt\nokio/ByteString\n*L\n66#1:365,7\n71#1:372\n108#1:373\n110#1:374,4\n110#1:379\n110#1:381\n112#1:382,23\n114#1:405,23\n118#1:428,2\n118#1:431,9\n120#1:440\n129#1:441\n131#1:442\n133#1:443\n152#1:444\n159#1:445,3\n159#1:448\n166#1:449,2\n168#1:451\n170#1:452\n172#1:453\n174#1:454\n180#1:455,7\n183#1:462\n186#1:463,8\n188#1:471,4\n190#1:475,5\n192#1:480,6\n192#1:487,9\n194#1:496,8\n194#1:504,2\n194#1:507,9\n194#1:516,9\n110#1:378\n110#1:380\n192#1:486\n118#1:430\n194#1:506\n*E\n"})
/* loaded from: classes.dex */
public class ByteString implements Serializable, Comparable<ByteString> {

    /* renamed from: d  reason: collision with root package name */
    public static final ByteString f6049d = new ByteString(new byte[0]);
    private static final long serialVersionUID = 1;

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f6050a;

    /* renamed from: b  reason: collision with root package name */
    public transient int f6051b;

    /* renamed from: c  reason: collision with root package name */
    public transient String f6052c;

    public ByteString(byte[] bArr) {
        c.F(bArr, "data");
        this.f6050a = bArr;
    }

    private final void readObject(ObjectInputStream objectInputStream) {
        int readInt = objectInputStream.readInt();
        if (readInt >= 0) {
            byte[] bArr = new byte[readInt];
            int i4 = 0;
            while (i4 < readInt) {
                int read = objectInputStream.read(bArr, i4, readInt - i4);
                if (read != -1) {
                    i4 += read;
                } else {
                    throw new EOFException();
                }
            }
            ByteString byteString = new ByteString(bArr);
            Field declaredField = ByteString.class.getDeclaredField("a");
            declaredField.setAccessible(true);
            declaredField.set(this, byteString.f6050a);
            return;
        }
        throw new IllegalArgumentException(j.b("byteCount < 0: ", readInt).toString());
    }

    private final void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.writeInt(this.f6050a.length);
        objectOutputStream.write(this.f6050a);
    }

    public String a() {
        byte[] bArr = this.f6050a;
        byte[] bArr2 = a.f7164a;
        c.F(bArr, "<this>");
        c.F(bArr2, "map");
        byte[] bArr3 = new byte[((bArr.length + 2) / 3) * 4];
        int length = bArr.length - (bArr.length % 3);
        int i4 = 0;
        int i5 = 0;
        while (i4 < length) {
            byte b5 = bArr[i4];
            int i6 = i4 + 2;
            byte b6 = bArr[i4 + 1];
            i4 += 3;
            byte b7 = bArr[i6];
            bArr3[i5] = bArr2[(b5 & 255) >> 2];
            bArr3[i5 + 1] = bArr2[((b5 & 3) << 4) | ((b6 & 255) >> 4)];
            int i7 = i5 + 3;
            bArr3[i5 + 2] = bArr2[((b6 & 15) << 2) | ((b7 & 255) >> 6)];
            i5 += 4;
            bArr3[i7] = bArr2[b7 & 63];
        }
        int length2 = bArr.length - length;
        if (length2 != 1) {
            if (length2 == 2) {
                int i8 = i4 + 1;
                byte b8 = bArr[i4];
                byte b9 = bArr[i8];
                bArr3[i5] = bArr2[(b8 & 255) >> 2];
                bArr3[i5 + 1] = bArr2[((b8 & 3) << 4) | ((b9 & 255) >> 4)];
                bArr3[i5 + 2] = bArr2[(b9 & 15) << 2];
                bArr3[i5 + 3] = 61;
            }
        } else {
            byte b10 = bArr[i4];
            bArr3[i5] = bArr2[(b10 & 255) >> 2];
            bArr3[i5 + 1] = bArr2[(b10 & 3) << 4];
            bArr3[i5 + 2] = 61;
            bArr3[i5 + 3] = 61;
        }
        return new String(bArr3, l3.a.f5399a);
    }

    public ByteString b(String str) {
        MessageDigest messageDigest = MessageDigest.getInstance(str);
        messageDigest.update(this.f6050a, 0, c());
        byte[] digest = messageDigest.digest();
        c.C(digest);
        return new ByteString(digest);
    }

    public int c() {
        return this.f6050a.length;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0033, code lost:
        if (r0 < r1) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0036, code lost:
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:?, code lost:
        return 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x002a, code lost:
        if (r7 < r8) goto L9;
     */
    @Override // java.lang.Comparable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int compareTo(okio.ByteString r10) {
        /*
            r9 = this;
            okio.ByteString r10 = (okio.ByteString) r10
            java.lang.String r0 = "other"
            com.google.common.collect.c.F(r10, r0)
            int r0 = r9.c()
            int r1 = r10.c()
            int r2 = java.lang.Math.min(r0, r1)
            r3 = 0
            r4 = r3
        L15:
            r5 = 1
            r6 = -1
            if (r4 >= r2) goto L30
            byte r7 = r9.f(r4)
            r7 = r7 & 255(0xff, float:3.57E-43)
            byte r8 = r10.f(r4)
            r8 = r8 & 255(0xff, float:3.57E-43)
            if (r7 != r8) goto L2a
            int r4 = r4 + 1
            goto L15
        L2a:
            if (r7 >= r8) goto L2e
        L2c:
            r3 = r6
            goto L36
        L2e:
            r3 = r5
            goto L36
        L30:
            if (r0 != r1) goto L33
            goto L36
        L33:
            if (r0 >= r1) goto L2e
            goto L2c
        L36:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.ByteString.compareTo(java.lang.Object):int");
    }

    public String d() {
        byte[] bArr = this.f6050a;
        char[] cArr = new char[bArr.length * 2];
        int i4 = 0;
        for (byte b5 : bArr) {
            int i5 = i4 + 1;
            char[] cArr2 = b.f7235a;
            cArr[i4] = cArr2[(b5 >> 4) & 15];
            i4 += 2;
            cArr[i5] = cArr2[b5 & 15];
        }
        return new String(cArr);
    }

    public byte[] e() {
        return this.f6050a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            int c4 = byteString.c();
            byte[] bArr = this.f6050a;
            if (c4 == bArr.length && byteString.g(0, bArr, 0, bArr.length)) {
                return true;
            }
        }
        return false;
    }

    public byte f(int i4) {
        return this.f6050a[i4];
    }

    public boolean g(int i4, byte[] bArr, int i5, int i6) {
        c.F(bArr, "other");
        if (i4 >= 0) {
            byte[] bArr2 = this.f6050a;
            if (i4 <= bArr2.length - i6 && i5 >= 0 && i5 <= bArr.length - i6 && c.o(i4, i5, i6, bArr2, bArr)) {
                return true;
            }
        }
        return false;
    }

    public boolean h(ByteString byteString, int i4) {
        c.F(byteString, "other");
        return byteString.g(0, this.f6050a, 0, i4);
    }

    public int hashCode() {
        int i4 = this.f6051b;
        if (i4 == 0) {
            int hashCode = Arrays.hashCode(this.f6050a);
            this.f6051b = hashCode;
            return hashCode;
        }
        return i4;
    }

    public ByteString i() {
        int i4 = 0;
        while (true) {
            byte[] bArr = this.f6050a;
            if (i4 < bArr.length) {
                byte b5 = bArr[i4];
                if (b5 >= 65 && b5 <= 90) {
                    byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
                    c.E(copyOf, "copyOf(this, size)");
                    copyOf[i4] = (byte) (b5 + 32);
                    for (int i5 = i4 + 1; i5 < copyOf.length; i5++) {
                        byte b6 = copyOf[i5];
                        if (b6 >= 65 && b6 <= 90) {
                            copyOf[i5] = (byte) (b6 + 32);
                        }
                    }
                    return new ByteString(copyOf);
                }
                i4++;
            } else {
                return this;
            }
        }
    }

    public final String j() {
        String str = this.f6052c;
        if (str == null) {
            byte[] e4 = e();
            c.F(e4, "<this>");
            String str2 = new String(e4, l3.a.f5399a);
            this.f6052c = str2;
            return str2;
        }
        return str;
    }

    public void k(f fVar, int i4) {
        c.F(fVar, "buffer");
        fVar.F(this.f6050a, 0, i4);
    }

    /* JADX WARN: Code restructure failed: missing block: B:122:0x0120, code lost:
        if (r6 == 64) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x0124, code lost:
        if (r6 == 64) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x0130, code lost:
        if (r6 == 64) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x015c, code lost:
        if (r6 == 64) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x0163, code lost:
        if (r6 == 64) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x016a, code lost:
        if (r6 == 64) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:173:0x019b, code lost:
        if (r6 == 64) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:175:0x019e, code lost:
        if (r6 == 64) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:177:0x01a1, code lost:
        if (r6 == 64) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:179:0x01a4, code lost:
        if (r6 == 64) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x007a, code lost:
        if (r6 == 64) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x008b, code lost:
        if (r6 == 64) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x00b6, code lost:
        if (r6 == 64) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x00c8, code lost:
        if (r6 == 64) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x00e8, code lost:
        if (r6 == 64) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x00f0, code lost:
        if (r6 == 64) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String toString() {
        /*
            Method dump skipped, instructions count: 619
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.ByteString.toString():java.lang.String");
    }
}