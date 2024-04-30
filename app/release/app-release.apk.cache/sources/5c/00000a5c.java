package y3;

import java.io.EOFException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import okio.ByteString;
import okio.SegmentedByteString;

/* loaded from: classes.dex */
public final class f implements h, g, Cloneable, ByteChannel {

    /* renamed from: a  reason: collision with root package name */
    public p f7179a;

    /* renamed from: b  reason: collision with root package name */
    public long f7180b;

    public final byte[] A(long j4) {
        int min;
        if (j4 >= 0 && j4 <= 2147483647L) {
            if (this.f7180b >= j4) {
                int i4 = (int) j4;
                byte[] bArr = new byte[i4];
                int i5 = 0;
                while (i5 < i4) {
                    int i6 = i4 - i5;
                    com.google.common.collect.c.G(i4, i5, i6);
                    p pVar = this.f7179a;
                    if (pVar == null) {
                        min = -1;
                    } else {
                        min = Math.min(i6, pVar.f7202c - pVar.f7201b);
                        int i7 = pVar.f7201b;
                        y2.h.i2(i5, i7, i7 + min, pVar.f7200a, bArr);
                        int i8 = pVar.f7201b + min;
                        pVar.f7201b = i8;
                        this.f7180b -= min;
                        if (i8 == pVar.f7202c) {
                            this.f7179a = pVar.a();
                            q.a(pVar);
                        }
                    }
                    if (min != -1) {
                        i5 += min;
                    } else {
                        throw new EOFException();
                    }
                }
                return bArr;
            }
            throw new EOFException();
        }
        throw new IllegalArgumentException(("byteCount: " + j4).toString());
    }

    public final String B(long j4, Charset charset) {
        com.google.common.collect.c.F(charset, "charset");
        int i4 = (j4 > 0L ? 1 : (j4 == 0L ? 0 : -1));
        if (i4 >= 0 && j4 <= 2147483647L) {
            if (this.f7180b >= j4) {
                if (i4 == 0) {
                    return "";
                }
                p pVar = this.f7179a;
                com.google.common.collect.c.C(pVar);
                int i5 = pVar.f7201b;
                if (i5 + j4 > pVar.f7202c) {
                    return new String(A(j4), charset);
                }
                int i6 = (int) j4;
                String str = new String(pVar.f7200a, i5, i6, charset);
                int i7 = pVar.f7201b + i6;
                pVar.f7201b = i7;
                this.f7180b -= j4;
                if (i7 == pVar.f7202c) {
                    this.f7179a = pVar.a();
                    q.a(pVar);
                }
                return str;
            }
            throw new EOFException();
        }
        throw new IllegalArgumentException(("byteCount: " + j4).toString());
    }

    public final ByteString C(int i4) {
        if (i4 == 0) {
            return ByteString.f6049d;
        }
        com.google.common.collect.c.G(this.f7180b, 0L, i4);
        p pVar = this.f7179a;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i6 < i4) {
            com.google.common.collect.c.C(pVar);
            int i8 = pVar.f7202c;
            int i9 = pVar.f7201b;
            if (i8 != i9) {
                i6 += i8 - i9;
                i7++;
                pVar = pVar.f7205f;
            } else {
                throw new AssertionError("s.limit == s.pos");
            }
        }
        byte[][] bArr = new byte[i7];
        int[] iArr = new int[i7 * 2];
        p pVar2 = this.f7179a;
        int i10 = 0;
        while (i5 < i4) {
            com.google.common.collect.c.C(pVar2);
            bArr[i10] = pVar2.f7200a;
            i5 += pVar2.f7202c - pVar2.f7201b;
            iArr[i10] = Math.min(i5, i4);
            iArr[i10 + i7] = pVar2.f7201b;
            pVar2.f7203d = true;
            i10++;
            pVar2 = pVar2.f7205f;
        }
        return new SegmentedByteString(bArr, iArr);
    }

    public final p D(int i4) {
        if (i4 >= 1 && i4 <= 8192) {
            p pVar = this.f7179a;
            if (pVar == null) {
                p b5 = q.b();
                this.f7179a = b5;
                b5.f7206g = b5;
                b5.f7205f = b5;
                return b5;
            }
            p pVar2 = pVar.f7206g;
            com.google.common.collect.c.C(pVar2);
            if (pVar2.f7202c + i4 <= 8192 && pVar2.f7204e) {
                return pVar2;
            }
            p b6 = q.b();
            pVar2.b(b6);
            return b6;
        }
        throw new IllegalArgumentException("unexpected capacity".toString());
    }

    public final void E(ByteString byteString) {
        com.google.common.collect.c.F(byteString, "byteString");
        byteString.k(this, byteString.c());
    }

    public final void F(byte[] bArr, int i4, int i5) {
        com.google.common.collect.c.F(bArr, "source");
        long j4 = i5;
        com.google.common.collect.c.G(bArr.length, i4, j4);
        int i6 = i5 + i4;
        while (i4 < i6) {
            p D = D(1);
            int min = Math.min(i6 - i4, 8192 - D.f7202c);
            int i7 = i4 + min;
            y2.h.i2(D.f7202c, i4, i7, bArr, D.f7200a);
            D.f7202c += min;
            i4 = i7;
        }
        this.f7180b += j4;
    }

    public final void G(t tVar) {
        com.google.common.collect.c.F(tVar, "source");
        do {
        } while (tVar.w(this, 8192L) != -1);
    }

    public final void H(int i4) {
        p D = D(1);
        int i5 = D.f7202c;
        D.f7202c = i5 + 1;
        D.f7200a[i5] = (byte) i4;
        this.f7180b++;
    }

    public final void I(long j4) {
        if (j4 == 0) {
            H(48);
            return;
        }
        long j5 = (j4 >>> 1) | j4;
        long j6 = j5 | (j5 >>> 2);
        long j7 = j6 | (j6 >>> 4);
        long j8 = j7 | (j7 >>> 8);
        long j9 = j8 | (j8 >>> 16);
        long j10 = j9 | (j9 >>> 32);
        long j11 = j10 - ((j10 >>> 1) & 6148914691236517205L);
        long j12 = ((j11 >>> 2) & 3689348814741910323L) + (j11 & 3689348814741910323L);
        long j13 = ((j12 >>> 4) + j12) & 1085102592571150095L;
        long j14 = j13 + (j13 >>> 8);
        long j15 = j14 + (j14 >>> 16);
        int i4 = (int) ((((j15 & 63) + ((j15 >>> 32) & 63)) + 3) / 4);
        p D = D(i4);
        int i5 = D.f7202c;
        for (int i6 = (i5 + i4) - 1; i6 >= i5; i6--) {
            D.f7200a[i6] = z3.a.f7234a[(int) (15 & j4)];
            j4 >>>= 4;
        }
        D.f7202c += i4;
        this.f7180b += i4;
    }

    public final void J(int i4) {
        p D = D(4);
        int i5 = D.f7202c;
        byte[] bArr = D.f7200a;
        bArr[i5] = (byte) ((i4 >>> 24) & 255);
        bArr[i5 + 1] = (byte) ((i4 >>> 16) & 255);
        bArr[i5 + 2] = (byte) ((i4 >>> 8) & 255);
        bArr[i5 + 3] = (byte) (i4 & 255);
        D.f7202c = i5 + 4;
        this.f7180b += 4;
    }

    public final void K(int i4) {
        p D = D(2);
        int i5 = D.f7202c;
        byte[] bArr = D.f7200a;
        bArr[i5] = (byte) ((i4 >>> 8) & 255);
        bArr[i5 + 1] = (byte) (i4 & 255);
        D.f7202c = i5 + 2;
        this.f7180b += 2;
    }

    public final void L(int i4, int i5, String str) {
        char charAt;
        long j4;
        long j5;
        char c4;
        com.google.common.collect.c.F(str, "string");
        if (i4 >= 0) {
            if (i5 >= i4) {
                if (i5 <= str.length()) {
                    while (i4 < i5) {
                        char charAt2 = str.charAt(i4);
                        if (charAt2 < 128) {
                            p D = D(1);
                            int i6 = D.f7202c - i4;
                            int min = Math.min(i5, 8192 - i6);
                            int i7 = i4 + 1;
                            byte[] bArr = D.f7200a;
                            bArr[i4 + i6] = (byte) charAt2;
                            while (true) {
                                i4 = i7;
                                if (i4 >= min || (charAt = str.charAt(i4)) >= 128) {
                                    break;
                                }
                                i7 = i4 + 1;
                                bArr[i4 + i6] = (byte) charAt;
                            }
                            int i8 = D.f7202c;
                            int i9 = (i6 + i4) - i8;
                            D.f7202c = i8 + i9;
                            this.f7180b += i9;
                        } else {
                            if (charAt2 < 2048) {
                                p D2 = D(2);
                                int i10 = D2.f7202c;
                                byte[] bArr2 = D2.f7200a;
                                bArr2[i10] = (byte) ((charAt2 >> 6) | 192);
                                bArr2[i10 + 1] = (byte) ((charAt2 & '?') | 128);
                                D2.f7202c = i10 + 2;
                                j4 = this.f7180b;
                                j5 = 2;
                            } else if (charAt2 >= 55296 && charAt2 <= 57343) {
                                int i11 = i4 + 1;
                                if (i11 < i5) {
                                    c4 = str.charAt(i11);
                                } else {
                                    c4 = 0;
                                }
                                if (charAt2 <= 56319 && 56320 <= c4 && c4 < 57344) {
                                    int i12 = (((charAt2 & 1023) << 10) | (c4 & 1023)) + 65536;
                                    p D3 = D(4);
                                    int i13 = D3.f7202c;
                                    byte[] bArr3 = D3.f7200a;
                                    bArr3[i13] = (byte) ((i12 >> 18) | 240);
                                    bArr3[i13 + 1] = (byte) (((i12 >> 12) & 63) | 128);
                                    bArr3[i13 + 2] = (byte) (((i12 >> 6) & 63) | 128);
                                    bArr3[i13 + 3] = (byte) ((i12 & 63) | 128);
                                    D3.f7202c = i13 + 4;
                                    this.f7180b += 4;
                                    i4 += 2;
                                } else {
                                    H(63);
                                    i4 = i11;
                                }
                            } else {
                                p D4 = D(3);
                                int i14 = D4.f7202c;
                                byte[] bArr4 = D4.f7200a;
                                bArr4[i14] = (byte) ((charAt2 >> '\f') | 224);
                                bArr4[i14 + 1] = (byte) ((63 & (charAt2 >> 6)) | 128);
                                bArr4[i14 + 2] = (byte) ((charAt2 & '?') | 128);
                                D4.f7202c = i14 + 3;
                                j4 = this.f7180b;
                                j5 = 3;
                            }
                            this.f7180b = j4 + j5;
                            i4++;
                        }
                    }
                    return;
                }
                throw new IllegalArgumentException(("endIndex > string.length: " + i5 + " > " + str.length()).toString());
            }
            throw new IllegalArgumentException(("endIndex < beginIndex: " + i5 + " < " + i4).toString());
        }
        throw new IllegalArgumentException(androidx.activity.j.b("beginIndex < 0: ", i4).toString());
    }

    public final void M(String str) {
        com.google.common.collect.c.F(str, "string");
        L(0, str.length(), str);
    }

    public final void N(int i4) {
        String str;
        long j4;
        long j5;
        int i5 = 0;
        if (i4 < 128) {
            H(i4);
            return;
        }
        if (i4 < 2048) {
            p D = D(2);
            int i6 = D.f7202c;
            byte[] bArr = D.f7200a;
            bArr[i6] = (byte) ((i4 >> 6) | 192);
            bArr[1 + i6] = (byte) ((i4 & 63) | 128);
            D.f7202c = i6 + 2;
            j4 = this.f7180b;
            j5 = 2;
        } else if (55296 <= i4 && i4 < 57344) {
            H(63);
            return;
        } else if (i4 < 65536) {
            p D2 = D(3);
            int i7 = D2.f7202c;
            byte[] bArr2 = D2.f7200a;
            bArr2[i7] = (byte) ((i4 >> 12) | 224);
            bArr2[1 + i7] = (byte) (((i4 >> 6) & 63) | 128);
            bArr2[2 + i7] = (byte) ((i4 & 63) | 128);
            D2.f7202c = i7 + 3;
            j4 = this.f7180b;
            j5 = 3;
        } else if (i4 <= 1114111) {
            p D3 = D(4);
            int i8 = D3.f7202c;
            byte[] bArr3 = D3.f7200a;
            bArr3[i8] = (byte) ((i4 >> 18) | 240);
            bArr3[1 + i8] = (byte) (((i4 >> 12) & 63) | 128);
            bArr3[2 + i8] = (byte) (((i4 >> 6) & 63) | 128);
            bArr3[3 + i8] = (byte) ((i4 & 63) | 128);
            D3.f7202c = i8 + 4;
            j4 = this.f7180b;
            j5 = 4;
        } else {
            StringBuilder sb = new StringBuilder("Unexpected code point: 0x");
            if (i4 != 0) {
                char[] cArr = z3.b.f7235a;
                char[] cArr2 = {cArr[(i4 >> 28) & 15], cArr[(i4 >> 24) & 15], cArr[(i4 >> 20) & 15], cArr[(i4 >> 16) & 15], cArr[(i4 >> 12) & 15], cArr[(i4 >> 8) & 15], cArr[(i4 >> 4) & 15], cArr[i4 & 15]};
                while (i5 < 8 && cArr2[i5] == '0') {
                    i5++;
                }
                if (i5 >= 0) {
                    if (i5 <= 8) {
                        str = new String(cArr2, i5, 8 - i5);
                    } else {
                        throw new IllegalArgumentException("startIndex: " + i5 + " > endIndex: 8");
                    }
                } else {
                    throw new IndexOutOfBoundsException("startIndex: " + i5 + ", endIndex: 8, size: 8");
                }
            } else {
                str = "0";
            }
            sb.append(str);
            throw new IllegalArgumentException(sb.toString());
        }
        this.f7180b = j4 + j5;
    }

    @Override // y3.t
    public final v a() {
        return v.f7211d;
    }

    @Override // y3.g
    public final g b(byte[] bArr) {
        F(bArr, 0, bArr.length);
        return this;
    }

    @Override // y3.g
    public final /* bridge */ /* synthetic */ g c(ByteString byteString) {
        E(byteString);
        return this;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [y3.f, java.lang.Object] */
    public final Object clone() {
        ?? obj = new Object();
        if (this.f7180b != 0) {
            p pVar = this.f7179a;
            com.google.common.collect.c.C(pVar);
            p c4 = pVar.c();
            obj.f7179a = c4;
            c4.f7206g = c4;
            c4.f7205f = c4;
            for (p pVar2 = pVar.f7205f; pVar2 != pVar; pVar2 = pVar2.f7205f) {
                p pVar3 = c4.f7206g;
                com.google.common.collect.c.C(pVar3);
                com.google.common.collect.c.C(pVar2);
                pVar3.b(pVar2.c());
            }
            obj.f7180b = this.f7180b;
        }
        return obj;
    }

    @Override // y3.g
    public final /* bridge */ /* synthetic */ g d(long j4) {
        I(j4);
        return this;
    }

    @Override // y3.h
    public final ByteString e(long j4) {
        if (j4 >= 0 && j4 <= 2147483647L) {
            if (this.f7180b >= j4) {
                if (j4 >= 4096) {
                    ByteString C = C((int) j4);
                    h(j4);
                    return C;
                }
                return new ByteString(A(j4));
            }
            throw new EOFException();
        }
        throw new IllegalArgumentException(("byteCount: " + j4).toString());
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof f) {
                long j4 = this.f7180b;
                f fVar = (f) obj;
                if (j4 == fVar.f7180b) {
                    if (j4 != 0) {
                        p pVar = this.f7179a;
                        com.google.common.collect.c.C(pVar);
                        p pVar2 = fVar.f7179a;
                        com.google.common.collect.c.C(pVar2);
                        int i4 = pVar.f7201b;
                        int i5 = pVar2.f7201b;
                        long j5 = 0;
                        while (j5 < this.f7180b) {
                            long min = Math.min(pVar.f7202c - i4, pVar2.f7202c - i5);
                            long j6 = 0;
                            while (j6 < min) {
                                int i6 = i4 + 1;
                                byte b5 = pVar.f7200a[i4];
                                int i7 = i5 + 1;
                                if (b5 == pVar2.f7200a[i5]) {
                                    j6++;
                                    i5 = i7;
                                    i4 = i6;
                                }
                            }
                            if (i4 == pVar.f7202c) {
                                p pVar3 = pVar.f7205f;
                                com.google.common.collect.c.C(pVar3);
                                i4 = pVar3.f7201b;
                                pVar = pVar3;
                            }
                            if (i5 == pVar2.f7202c) {
                                pVar2 = pVar2.f7205f;
                                com.google.common.collect.c.C(pVar2);
                                i5 = pVar2.f7201b;
                            }
                            j5 += min;
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    @Override // y3.r
    public final void f(f fVar, long j4) {
        p pVar;
        p pVar2;
        p b5;
        int i4;
        com.google.common.collect.c.F(fVar, "source");
        if (fVar != this) {
            com.google.common.collect.c.G(fVar.f7180b, 0L, j4);
            while (j4 > 0) {
                p pVar3 = fVar.f7179a;
                com.google.common.collect.c.C(pVar3);
                int i5 = pVar3.f7202c;
                com.google.common.collect.c.C(fVar.f7179a);
                int i6 = (j4 > (i5 - pVar.f7201b) ? 1 : (j4 == (i5 - pVar.f7201b) ? 0 : -1));
                int i7 = 0;
                if (i6 < 0) {
                    p pVar4 = this.f7179a;
                    if (pVar4 != null) {
                        pVar2 = pVar4.f7206g;
                    } else {
                        pVar2 = null;
                    }
                    if (pVar2 != null && pVar2.f7204e) {
                        long j5 = pVar2.f7202c + j4;
                        if (pVar2.f7203d) {
                            i4 = 0;
                        } else {
                            i4 = pVar2.f7201b;
                        }
                        if (j5 - i4 <= 8192) {
                            p pVar5 = fVar.f7179a;
                            com.google.common.collect.c.C(pVar5);
                            pVar5.d(pVar2, (int) j4);
                            fVar.f7180b -= j4;
                            this.f7180b += j4;
                            return;
                        }
                    }
                    p pVar6 = fVar.f7179a;
                    com.google.common.collect.c.C(pVar6);
                    int i8 = (int) j4;
                    if (i8 > 0 && i8 <= pVar6.f7202c - pVar6.f7201b) {
                        if (i8 >= 1024) {
                            b5 = pVar6.c();
                        } else {
                            b5 = q.b();
                            int i9 = pVar6.f7201b;
                            y2.h.i2(0, i9, i9 + i8, pVar6.f7200a, b5.f7200a);
                        }
                        b5.f7202c = b5.f7201b + i8;
                        pVar6.f7201b += i8;
                        p pVar7 = pVar6.f7206g;
                        com.google.common.collect.c.C(pVar7);
                        pVar7.b(b5);
                        fVar.f7179a = b5;
                    } else {
                        throw new IllegalArgumentException("byteCount out of range".toString());
                    }
                }
                p pVar8 = fVar.f7179a;
                com.google.common.collect.c.C(pVar8);
                long j6 = pVar8.f7202c - pVar8.f7201b;
                fVar.f7179a = pVar8.a();
                p pVar9 = this.f7179a;
                if (pVar9 == null) {
                    this.f7179a = pVar8;
                    pVar8.f7206g = pVar8;
                    pVar8.f7205f = pVar8;
                } else {
                    p pVar10 = pVar9.f7206g;
                    com.google.common.collect.c.C(pVar10);
                    pVar10.b(pVar8);
                    p pVar11 = pVar8.f7206g;
                    if (pVar11 != pVar8) {
                        com.google.common.collect.c.C(pVar11);
                        if (pVar11.f7204e) {
                            int i10 = pVar8.f7202c - pVar8.f7201b;
                            p pVar12 = pVar8.f7206g;
                            com.google.common.collect.c.C(pVar12);
                            int i11 = 8192 - pVar12.f7202c;
                            p pVar13 = pVar8.f7206g;
                            com.google.common.collect.c.C(pVar13);
                            if (!pVar13.f7203d) {
                                p pVar14 = pVar8.f7206g;
                                com.google.common.collect.c.C(pVar14);
                                i7 = pVar14.f7201b;
                            }
                            if (i10 <= i11 + i7) {
                                p pVar15 = pVar8.f7206g;
                                com.google.common.collect.c.C(pVar15);
                                pVar8.d(pVar15, i10);
                                pVar8.a();
                                q.a(pVar8);
                            }
                        }
                    } else {
                        throw new IllegalStateException("cannot compact".toString());
                    }
                }
                fVar.f7180b -= j6;
                this.f7180b += j6;
                j4 -= j6;
            }
            return;
        }
        throw new IllegalArgumentException("source == this".toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v1, types: [y3.f, java.lang.Object] */
    @Override // y3.h
    public final String g(long j4) {
        if (j4 >= 0) {
            long j5 = Long.MAX_VALUE;
            if (j4 != Long.MAX_VALUE) {
                j5 = j4 + 1;
            }
            long z4 = z((byte) 10, 0L, j5);
            if (z4 != -1) {
                return z3.a.a(this, z4);
            }
            if (j5 < this.f7180b && y(j5 - 1) == 13 && y(j5) == 10) {
                return z3.a.a(this, j5);
            }
            ?? obj = new Object();
            x(obj, 0L, Math.min(32, this.f7180b));
            throw new EOFException("\\n not found: limit=" + Math.min(this.f7180b, j4) + " content=" + obj.e(obj.f7180b).d() + (char) 8230);
        }
        throw new IllegalArgumentException(("limit < 0: " + j4).toString());
    }

    @Override // y3.h
    public final void h(long j4) {
        while (j4 > 0) {
            p pVar = this.f7179a;
            if (pVar != null) {
                int min = (int) Math.min(j4, pVar.f7202c - pVar.f7201b);
                long j5 = min;
                this.f7180b -= j5;
                j4 -= j5;
                int i4 = pVar.f7201b + min;
                pVar.f7201b = i4;
                if (i4 == pVar.f7202c) {
                    this.f7179a = pVar.a();
                    q.a(pVar);
                }
            } else {
                throw new EOFException();
            }
        }
    }

    public final int hashCode() {
        p pVar = this.f7179a;
        if (pVar == null) {
            return 0;
        }
        int i4 = 1;
        do {
            int i5 = pVar.f7202c;
            for (int i6 = pVar.f7201b; i6 < i5; i6++) {
                i4 = (i4 * 31) + pVar.f7200a[i6];
            }
            pVar = pVar.f7205f;
            com.google.common.collect.c.C(pVar);
        } while (pVar != this.f7179a);
        return i4;
    }

    @Override // y3.h
    public final short i() {
        if (this.f7180b >= 2) {
            p pVar = this.f7179a;
            com.google.common.collect.c.C(pVar);
            int i4 = pVar.f7201b;
            int i5 = pVar.f7202c;
            if (i5 - i4 < 2) {
                return (short) (((v() & 255) << 8) | (v() & 255));
            }
            int i6 = i4 + 1;
            byte[] bArr = pVar.f7200a;
            int i7 = i4 + 2;
            int i8 = (bArr[i6] & 255) | ((bArr[i4] & 255) << 8);
            this.f7180b -= 2;
            if (i7 == i5) {
                this.f7179a = pVar.a();
                q.a(pVar);
            } else {
                pVar.f7201b = i7;
            }
            return (short) i8;
        }
        throw new EOFException();
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return true;
    }

    @Override // y3.g
    public final /* bridge */ /* synthetic */ g j(int i4) {
        K(i4);
        return this;
    }

    @Override // y3.h
    public final int k() {
        if (this.f7180b >= 4) {
            p pVar = this.f7179a;
            com.google.common.collect.c.C(pVar);
            int i4 = pVar.f7201b;
            int i5 = pVar.f7202c;
            if (i5 - i4 < 4) {
                return ((v() & 255) << 24) | ((v() & 255) << 16) | ((v() & 255) << 8) | (v() & 255);
            }
            byte[] bArr = pVar.f7200a;
            int i6 = ((bArr[i4 + 1] & 255) << 16) | ((bArr[i4] & 255) << 24);
            int i7 = i4 + 3;
            int i8 = i4 + 4;
            int i9 = i6 | ((bArr[i4 + 2] & 255) << 8) | (bArr[i7] & 255);
            this.f7180b -= 4;
            if (i8 == i5) {
                this.f7179a = pVar.a();
                q.a(pVar);
            } else {
                pVar.f7201b = i8;
            }
            return i9;
        }
        throw new EOFException();
    }

    @Override // y3.g
    public final /* bridge */ /* synthetic */ g l(int i4) {
        J(i4);
        return this;
    }

    @Override // y3.h
    public final int m(m mVar) {
        com.google.common.collect.c.F(mVar, "options");
        int b5 = z3.a.b(this, mVar, false);
        if (b5 == -1) {
            return -1;
        }
        h(mVar.f7192a[b5].c());
        return b5;
    }

    @Override // y3.h
    public final String n() {
        return g(Long.MAX_VALUE);
    }

    @Override // y3.h
    public final void o(long j4) {
        if (this.f7180b >= j4) {
            return;
        }
        throw new EOFException();
    }

    @Override // y3.g
    public final /* bridge */ /* synthetic */ g p(String str) {
        M(str);
        return this;
    }

    @Override // y3.h
    public final boolean r() {
        if (this.f7180b == 0) {
            return true;
        }
        return false;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public final int read(ByteBuffer byteBuffer) {
        com.google.common.collect.c.F(byteBuffer, "sink");
        p pVar = this.f7179a;
        if (pVar == null) {
            return -1;
        }
        int min = Math.min(byteBuffer.remaining(), pVar.f7202c - pVar.f7201b);
        byteBuffer.put(pVar.f7200a, pVar.f7201b, min);
        int i4 = pVar.f7201b + min;
        pVar.f7201b = i4;
        this.f7180b -= min;
        if (i4 == pVar.f7202c) {
            this.f7179a = pVar.a();
            q.a(pVar);
        }
        return min;
    }

    @Override // y3.g
    public final /* bridge */ /* synthetic */ g s(int i4) {
        H(i4);
        return this;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00a8 A[EDGE_INSN: B:42:0x00a8->B:37:0x00a8 ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v9, types: [y3.f, java.lang.Object] */
    @Override // y3.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long t() {
        /*
            r18 = this;
            r0 = r18
            r1 = 4
            r2 = 48
            r3 = 0
            r4 = 1
            long r5 = r0.f7180b
            r7 = 0
            int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r5 == 0) goto Laf
            r9 = r3
            r10 = r9
            r5 = r7
        L12:
            y3.p r11 = r0.f7179a
            com.google.common.collect.c.C(r11)
            int r12 = r11.f7201b
            int r13 = r11.f7202c
        L1b:
            if (r12 >= r13) goto L94
            byte[] r14 = r11.f7200a
            r14 = r14[r12]
            if (r14 < r2) goto L2a
            r15 = 57
            if (r14 > r15) goto L2a
            int r15 = r14 + (-48)
            goto L3f
        L2a:
            r15 = 97
            if (r14 < r15) goto L35
            r15 = 102(0x66, float:1.43E-43)
            if (r14 > r15) goto L35
            int r15 = r14 + (-87)
            goto L3f
        L35:
            r15 = 65
            if (r14 < r15) goto L6c
            r15 = 70
            if (r14 > r15) goto L6c
            int r15 = r14 + (-55)
        L3f:
            r16 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r16 = r5 & r16
            int r16 = (r16 > r7 ? 1 : (r16 == r7 ? 0 : -1))
            if (r16 != 0) goto L4d
            long r5 = r5 << r1
            long r14 = (long) r15
            long r5 = r5 | r14
            int r12 = r12 + r4
            int r9 = r9 + r4
            goto L1b
        L4d:
            y3.f r1 = new y3.f
            r1.<init>()
            r1.I(r5)
            r1.H(r14)
            java.lang.NumberFormatException r2 = new java.lang.NumberFormatException
            long r3 = r1.f7180b
            java.nio.charset.Charset r5 = l3.a.f5399a
            java.lang.String r1 = r1.B(r3, r5)
            java.lang.String r3 = "Number too large: "
            java.lang.String r1 = r3.concat(r1)
            r2.<init>(r1)
            throw r2
        L6c:
            if (r9 == 0) goto L70
            r10 = r4
            goto L94
        L70:
            java.lang.NumberFormatException r2 = new java.lang.NumberFormatException
            char[] r5 = z3.b.f7235a
            int r1 = r14 >> 4
            r1 = r1 & 15
            char r1 = r5[r1]
            r6 = r14 & 15
            char r5 = r5[r6]
            r6 = 2
            char[] r6 = new char[r6]
            r6[r3] = r1
            r6[r4] = r5
            java.lang.String r1 = new java.lang.String
            r1.<init>(r6)
            java.lang.String r3 = "Expected leading [0-9a-fA-F] character but was 0x"
            java.lang.String r1 = r3.concat(r1)
            r2.<init>(r1)
            throw r2
        L94:
            if (r12 != r13) goto La0
            y3.p r12 = r11.a()
            r0.f7179a = r12
            y3.q.a(r11)
            goto La2
        La0:
            r11.f7201b = r12
        La2:
            if (r10 != 0) goto La8
            y3.p r11 = r0.f7179a
            if (r11 != 0) goto L12
        La8:
            long r1 = r0.f7180b
            long r3 = (long) r9
            long r1 = r1 - r3
            r0.f7180b = r1
            return r5
        Laf:
            java.io.EOFException r1 = new java.io.EOFException
            r1.<init>()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: y3.f.t():long");
    }

    public final String toString() {
        long j4 = this.f7180b;
        if (j4 <= 2147483647L) {
            return C((int) j4).toString();
        }
        throw new IllegalStateException(("size > Int.MAX_VALUE: " + this.f7180b).toString());
    }

    @Override // y3.h
    public final String u(Charset charset) {
        return B(this.f7180b, charset);
    }

    @Override // y3.h
    public final byte v() {
        if (this.f7180b != 0) {
            p pVar = this.f7179a;
            com.google.common.collect.c.C(pVar);
            int i4 = pVar.f7201b;
            int i5 = pVar.f7202c;
            int i6 = i4 + 1;
            byte b5 = pVar.f7200a[i4];
            this.f7180b--;
            if (i6 == i5) {
                this.f7179a = pVar.a();
                q.a(pVar);
            } else {
                pVar.f7201b = i6;
            }
            return b5;
        }
        throw new EOFException();
    }

    @Override // y3.t
    public final long w(f fVar, long j4) {
        com.google.common.collect.c.F(fVar, "sink");
        if (j4 >= 0) {
            long j5 = this.f7180b;
            if (j5 == 0) {
                return -1L;
            }
            if (j4 > j5) {
                j4 = j5;
            }
            fVar.f(this, j4);
            return j4;
        }
        throw new IllegalArgumentException(("byteCount < 0: " + j4).toString());
    }

    @Override // java.nio.channels.WritableByteChannel
    public final int write(ByteBuffer byteBuffer) {
        com.google.common.collect.c.F(byteBuffer, "source");
        int remaining = byteBuffer.remaining();
        int i4 = remaining;
        while (i4 > 0) {
            p D = D(1);
            int min = Math.min(i4, 8192 - D.f7202c);
            byteBuffer.get(D.f7200a, D.f7202c, min);
            i4 -= min;
            D.f7202c += min;
        }
        this.f7180b += remaining;
        return remaining;
    }

    public final void x(f fVar, long j4, long j5) {
        com.google.common.collect.c.F(fVar, "out");
        com.google.common.collect.c.G(this.f7180b, j4, j5);
        if (j5 != 0) {
            fVar.f7180b += j5;
            p pVar = this.f7179a;
            while (true) {
                com.google.common.collect.c.C(pVar);
                long j6 = pVar.f7202c - pVar.f7201b;
                if (j4 < j6) {
                    break;
                }
                j4 -= j6;
                pVar = pVar.f7205f;
            }
            while (j5 > 0) {
                com.google.common.collect.c.C(pVar);
                p c4 = pVar.c();
                int i4 = c4.f7201b + ((int) j4);
                c4.f7201b = i4;
                c4.f7202c = Math.min(i4 + ((int) j5), c4.f7202c);
                p pVar2 = fVar.f7179a;
                if (pVar2 == null) {
                    c4.f7206g = c4;
                    c4.f7205f = c4;
                    fVar.f7179a = c4;
                } else {
                    p pVar3 = pVar2.f7206g;
                    com.google.common.collect.c.C(pVar3);
                    pVar3.b(c4);
                }
                j5 -= c4.f7202c - c4.f7201b;
                pVar = pVar.f7205f;
                j4 = 0;
            }
        }
    }

    public final byte y(long j4) {
        com.google.common.collect.c.G(this.f7180b, j4, 1L);
        p pVar = this.f7179a;
        if (pVar != null) {
            long j5 = this.f7180b;
            if (j5 - j4 < j4) {
                while (j5 > j4) {
                    pVar = pVar.f7206g;
                    com.google.common.collect.c.C(pVar);
                    j5 -= pVar.f7202c - pVar.f7201b;
                }
                return pVar.f7200a[(int) ((pVar.f7201b + j4) - j5)];
            }
            long j6 = 0;
            while (true) {
                int i4 = pVar.f7202c;
                int i5 = pVar.f7201b;
                long j7 = (i4 - i5) + j6;
                if (j7 <= j4) {
                    pVar = pVar.f7205f;
                    com.google.common.collect.c.C(pVar);
                    j6 = j7;
                } else {
                    return pVar.f7200a[(int) ((i5 + j4) - j6)];
                }
            }
        } else {
            com.google.common.collect.c.C(null);
            throw null;
        }
    }

    public final long z(byte b5, long j4, long j5) {
        p pVar;
        long j6 = 0;
        if (0 <= j4 && j4 <= j5) {
            long j7 = this.f7180b;
            if (j5 > j7) {
                j5 = j7;
            }
            if (j4 == j5 || (pVar = this.f7179a) == null) {
                return -1L;
            }
            if (j7 - j4 < j4) {
                while (j7 > j4) {
                    pVar = pVar.f7206g;
                    com.google.common.collect.c.C(pVar);
                    j7 -= pVar.f7202c - pVar.f7201b;
                }
                while (j7 < j5) {
                    int min = (int) Math.min(pVar.f7202c, (pVar.f7201b + j5) - j7);
                    for (int i4 = (int) ((pVar.f7201b + j4) - j7); i4 < min; i4++) {
                        if (pVar.f7200a[i4] == b5) {
                            return (i4 - pVar.f7201b) + j7;
                        }
                    }
                    j7 += pVar.f7202c - pVar.f7201b;
                    pVar = pVar.f7205f;
                    com.google.common.collect.c.C(pVar);
                    j4 = j7;
                }
                return -1L;
            }
            while (true) {
                long j8 = (pVar.f7202c - pVar.f7201b) + j6;
                if (j8 > j4) {
                    break;
                }
                pVar = pVar.f7205f;
                com.google.common.collect.c.C(pVar);
                j6 = j8;
            }
            while (j6 < j5) {
                int min2 = (int) Math.min(pVar.f7202c, (pVar.f7201b + j5) - j6);
                for (int i5 = (int) ((pVar.f7201b + j4) - j6); i5 < min2; i5++) {
                    if (pVar.f7200a[i5] == b5) {
                        return (i5 - pVar.f7201b) + j6;
                    }
                }
                j6 += pVar.f7202c - pVar.f7201b;
                pVar = pVar.f7205f;
                com.google.common.collect.c.C(pVar);
                j4 = j6;
            }
            return -1L;
        }
        throw new IllegalArgumentException(("size=" + this.f7180b + " fromIndex=" + j4 + " toIndex=" + j5).toString());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel, y3.r
    public final void close() {
    }

    @Override // y3.g, y3.r, java.io.Flushable
    public final void flush() {
    }

    @Override // y3.h
    public final f q() {
        return this;
    }
}