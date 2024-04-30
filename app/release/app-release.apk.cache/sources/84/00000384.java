package b4;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: a  reason: collision with root package name */
    public static final char[] f2542a;

    static {
        Charset charset = StandardCharsets.UTF_8;
        int i4 = a4.a.f57a;
        f2542a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    }

    public static byte[] a(String str) {
        char[] charArray = str.toCharArray();
        int length = charArray.length >> 1;
        byte[] bArr = new byte[length];
        int length2 = charArray.length;
        if ((length2 & 1) == 0) {
            if (length >= (length2 >> 1)) {
                int i4 = 0;
                int i5 = 0;
                while (i4 < length2) {
                    int i6 = i4 + 1;
                    i4 += 2;
                    bArr[i5] = (byte) (((c(charArray[i4], i4) << 4) | c(charArray[i6], i6)) & 255);
                    i5++;
                }
                return bArr;
            }
            throw new Exception("Output array is not large enough to accommodate decoded data.");
        }
        throw new Exception("Odd number of characters.");
    }

    public static String b(byte[] bArr) {
        char[] cArr = new char[bArr.length << 1];
        int i4 = 0;
        for (byte b5 : bArr) {
            int i5 = i4 + 1;
            char[] cArr2 = f2542a;
            cArr[i4] = cArr2[(b5 & 240) >>> 4];
            i4 += 2;
            cArr[i5] = cArr2[b5 & 15];
        }
        return new String(cArr);
    }

    public static int c(char c4, int i4) {
        int digit = Character.digit(c4, 16);
        if (digit != -1) {
            return digit;
        }
        throw new Exception("Illegal hexadecimal character " + c4 + " at index " + i4);
    }
}