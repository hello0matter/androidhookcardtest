package b4;

import androidx.activity.j;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import org.apache.commons.codec.CodecPolicy;

/* loaded from: classes.dex */
public final class a extends c {

    /* renamed from: k  reason: collision with root package name */
    public static final byte[] f2523k = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

    /* renamed from: l  reason: collision with root package name */
    public static final byte[] f2524l = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, 62, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51};

    /* renamed from: f  reason: collision with root package name */
    public final byte[] f2525f;

    /* renamed from: g  reason: collision with root package name */
    public final byte[] f2526g;

    /* renamed from: h  reason: collision with root package name */
    public final byte[] f2527h;

    /* renamed from: i  reason: collision with root package name */
    public final int f2528i;

    /* renamed from: j  reason: collision with root package name */
    public final int f2529j;

    public a(int i4, byte[] bArr) {
        super(i4, bArr.length);
        this.f2526g = f2524l;
        for (byte b5 : bArr) {
            if (this.f2538a != b5) {
                if (b5 >= 0) {
                    byte[] bArr2 = this.f2526g;
                    if (b5 < bArr2.length && bArr2[b5] != -1) {
                    }
                }
            }
            throw new IllegalArgumentException(j.d("lineSeparator must not contain base64 characters: [", new String(bArr, StandardCharsets.UTF_8), "]"));
        }
        if (i4 > 0) {
            this.f2529j = bArr.length + 4;
            this.f2527h = (byte[]) bArr.clone();
        } else {
            this.f2529j = 4;
            this.f2527h = null;
        }
        this.f2528i = this.f2529j - 1;
        this.f2525f = f2523k;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Object, b4.b] */
    public static byte[] d(String str) {
        byte[] bytes;
        a aVar = new a(0, c.f2537e);
        Charset charset = StandardCharsets.UTF_8;
        if (str == null) {
            bytes = null;
        } else {
            bytes = str.getBytes(charset);
        }
        if (bytes != null && bytes.length != 0) {
            ?? obj = new Object();
            aVar.c(bytes, bytes.length, obj);
            aVar.c(bytes, -1, obj);
            int i4 = obj.f2532c;
            byte[] bArr = new byte[i4];
            c.b(bArr, i4, obj);
            return bArr;
        }
        return bytes;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.lang.Object, b4.b] */
    public static String f(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            a aVar = new a(0, c.f2537e);
            long length = ((bArr.length + 2) / 3) * 4;
            int i4 = aVar.f2539b;
            if (i4 > 0) {
                long j4 = i4;
                length += (((length + j4) - 1) / j4) * aVar.f2540c;
            }
            if (length <= Integer.MAX_VALUE) {
                if (bArr.length != 0) {
                    int length2 = bArr.length;
                    if (bArr.length != 0) {
                        ?? obj = new Object();
                        aVar.e(bArr, length2, obj);
                        aVar.e(bArr, -1, obj);
                        int i5 = obj.f2532c - obj.f2533d;
                        byte[] bArr2 = new byte[i5];
                        c.b(bArr2, i5, obj);
                        bArr = bArr2;
                    }
                }
            } else {
                throw new IllegalArgumentException("Input array too big, the output array would be bigger (" + length + ") than the specified maximum size of 2147483647");
            }
        }
        Charset charset = StandardCharsets.US_ASCII;
        if (bArr == null) {
            return null;
        }
        return new String(bArr, charset);
    }

    public final void c(byte[] bArr, int i4, b bVar) {
        int i5;
        byte b5;
        if (bVar.f2534e) {
            return;
        }
        if (i4 < 0) {
            bVar.f2534e = true;
        }
        int i6 = 0;
        int i7 = 0;
        while (true) {
            i5 = this.f2528i;
            if (i6 >= i4) {
                break;
            }
            byte[] a5 = c.a(i5, bVar);
            int i8 = i7 + 1;
            byte b6 = bArr[i7];
            if (b6 == this.f2538a) {
                bVar.f2534e = true;
                break;
            }
            if (b6 >= 0 && b6 < 123 && (b5 = f2524l[b6]) >= 0) {
                int i9 = (bVar.f2536g + 1) % 4;
                bVar.f2536g = i9;
                int i10 = (bVar.f2530a << 6) + b5;
                bVar.f2530a = i10;
                if (i9 == 0) {
                    int i11 = bVar.f2532c;
                    a5[i11] = (byte) ((i10 >> 16) & 255);
                    a5[i11 + 1] = (byte) ((i10 >> 8) & 255);
                    bVar.f2532c = i11 + 3;
                    a5[i11 + 2] = (byte) (i10 & 255);
                }
            }
            i6++;
            i7 = i8;
        }
        if (bVar.f2534e && bVar.f2536g != 0) {
            byte[] a6 = c.a(i5, bVar);
            int i12 = bVar.f2536g;
            CodecPolicy codecPolicy = this.f2541d;
            CodecPolicy codecPolicy2 = CodecPolicy.f6055a;
            if (i12 != 1) {
                if (i12 != 2) {
                    if (i12 == 3) {
                        if (codecPolicy == codecPolicy2 && (bVar.f2530a & 3) != 0) {
                            throw new IllegalArgumentException("Strict decoding: Last encoded character (before the paddings if any) is a valid base 64 alphabet but not a possible encoding. Expected the discarded bits from the character to be zero.");
                        }
                        int i13 = bVar.f2530a;
                        int i14 = i13 >> 2;
                        bVar.f2530a = i14;
                        int i15 = bVar.f2532c;
                        a6[i15] = (byte) ((i13 >> 10) & 255);
                        bVar.f2532c = i15 + 2;
                        a6[i15 + 1] = (byte) (i14 & 255);
                        return;
                    }
                    throw new IllegalStateException("Impossible modulus " + bVar.f2536g);
                } else if (codecPolicy == codecPolicy2 && (bVar.f2530a & 15) != 0) {
                    throw new IllegalArgumentException("Strict decoding: Last encoded character (before the paddings if any) is a valid base 64 alphabet but not a possible encoding. Expected the discarded bits from the character to be zero.");
                } else {
                    int i16 = bVar.f2530a >> 4;
                    bVar.f2530a = i16;
                    int i17 = bVar.f2532c;
                    bVar.f2532c = i17 + 1;
                    a6[i17] = (byte) (i16 & 255);
                }
            } else if (codecPolicy == codecPolicy2) {
                throw new IllegalArgumentException("Strict decoding: Last encoded character (before the paddings if any) is a valid base 64 alphabet but not a possible encoding. Decoding requires at least two trailing 6-bit characters to create bytes.");
            }
        }
    }

    public final void e(byte[] bArr, int i4, b bVar) {
        if (bVar.f2534e) {
            return;
        }
        int i5 = this.f2529j;
        byte[] bArr2 = this.f2525f;
        int i6 = this.f2539b;
        byte[] bArr3 = this.f2527h;
        if (i4 < 0) {
            bVar.f2534e = true;
            if (bVar.f2536g == 0 && i6 == 0) {
                return;
            }
            byte[] a5 = c.a(i5, bVar);
            int i7 = bVar.f2532c;
            int i8 = bVar.f2536g;
            if (i8 != 0) {
                byte[] bArr4 = f2523k;
                byte b5 = this.f2538a;
                if (i8 != 1) {
                    if (i8 == 2) {
                        int i9 = bVar.f2530a;
                        a5[i7] = bArr2[(i9 >> 10) & 63];
                        a5[i7 + 1] = bArr2[(i9 >> 4) & 63];
                        int i10 = i7 + 3;
                        bVar.f2532c = i10;
                        a5[i7 + 2] = bArr2[(i9 << 2) & 63];
                        if (bArr2 == bArr4) {
                            bVar.f2532c = i7 + 4;
                            a5[i10] = b5;
                        }
                    } else {
                        throw new IllegalStateException("Impossible modulus " + bVar.f2536g);
                    }
                } else {
                    int i11 = bVar.f2530a;
                    a5[i7] = bArr2[(i11 >> 2) & 63];
                    int i12 = i7 + 2;
                    bVar.f2532c = i12;
                    a5[i7 + 1] = bArr2[(i11 << 4) & 63];
                    if (bArr2 == bArr4) {
                        a5[i12] = b5;
                        bVar.f2532c = i7 + 4;
                        a5[i7 + 3] = b5;
                    }
                }
            }
            int i13 = bVar.f2535f;
            int i14 = bVar.f2532c;
            int i15 = (i14 - i7) + i13;
            bVar.f2535f = i15;
            if (i6 > 0 && i15 > 0) {
                System.arraycopy(bArr3, 0, a5, i14, bArr3.length);
                bVar.f2532c += bArr3.length;
                return;
            }
            return;
        }
        int i16 = 0;
        int i17 = 0;
        while (i16 < i4) {
            byte[] a6 = c.a(i5, bVar);
            int i18 = (bVar.f2536g + 1) % 3;
            bVar.f2536g = i18;
            int i19 = i17 + 1;
            int i20 = bArr[i17];
            if (i20 < 0) {
                i20 += 256;
            }
            int i21 = (bVar.f2530a << 8) + i20;
            bVar.f2530a = i21;
            if (i18 == 0) {
                int i22 = bVar.f2532c;
                a6[i22] = bArr2[(i21 >> 18) & 63];
                a6[i22 + 1] = bArr2[(i21 >> 12) & 63];
                int i23 = i22 + 3;
                a6[i22 + 2] = bArr2[(i21 >> 6) & 63];
                int i24 = i22 + 4;
                bVar.f2532c = i24;
                a6[i23] = bArr2[i21 & 63];
                int i25 = bVar.f2535f + 4;
                bVar.f2535f = i25;
                if (i6 > 0 && i6 <= i25) {
                    System.arraycopy(bArr3, 0, a6, i24, bArr3.length);
                    bVar.f2532c += bArr3.length;
                    bVar.f2535f = 0;
                }
            }
            i16++;
            i17 = i19;
        }
    }
}