package b4;

import java.util.Arrays;
import org.apache.commons.codec.CodecPolicy;

/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: e  reason: collision with root package name */
    public static final byte[] f2537e = {13, 10};

    /* renamed from: a  reason: collision with root package name */
    public final byte f2538a;

    /* renamed from: b  reason: collision with root package name */
    public final int f2539b;

    /* renamed from: c  reason: collision with root package name */
    public final int f2540c;

    /* renamed from: d  reason: collision with root package name */
    public final CodecPolicy f2541d;

    public c(int i4, int i5) {
        int i6;
        CodecPolicy codecPolicy = CodecPolicy.f6056b;
        if (i4 > 0 && i5 > 0) {
            i6 = (i4 / 4) * 4;
        } else {
            i6 = 0;
        }
        this.f2539b = i6;
        this.f2540c = i5;
        this.f2538a = (byte) 61;
        this.f2541d = codecPolicy;
    }

    public static byte[] a(int i4, b bVar) {
        byte[] bArr = bVar.f2531b;
        if (bArr == null) {
            bVar.f2531b = new byte[Math.max(i4, 8192)];
            bVar.f2532c = 0;
            bVar.f2533d = 0;
        } else {
            int i5 = bVar.f2532c + i4;
            if (i5 - bArr.length > 0) {
                int length = bArr.length * 2;
                if (Integer.compare(length ^ Integer.MIN_VALUE, i5 ^ Integer.MIN_VALUE) < 0) {
                    length = i5;
                }
                if (Integer.compare(Integer.MIN_VALUE ^ length, -9) > 0) {
                    if (i5 >= 0) {
                        length = Math.max(i5, 2147483639);
                    } else {
                        throw new OutOfMemoryError("Unable to allocate array size: " + (i5 & 4294967295L));
                    }
                }
                byte[] copyOf = Arrays.copyOf(bVar.f2531b, length);
                bVar.f2531b = copyOf;
                return copyOf;
            }
        }
        return bVar.f2531b;
    }

    public static void b(byte[] bArr, int i4, b bVar) {
        boolean z4;
        int i5;
        int i6 = bVar.f2532c;
        int i7 = bVar.f2533d;
        if (i6 > i7) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z4) {
            if (i6 > i7) {
                i5 = i6 - i7;
            } else {
                i5 = 0;
            }
            int min = Math.min(i5, i4);
            System.arraycopy(bVar.f2531b, bVar.f2533d, bArr, 0, min);
            int i8 = bVar.f2533d + min;
            bVar.f2533d = i8;
            if (bVar.f2532c <= i8) {
                bVar.f2533d = 0;
                bVar.f2532c = 0;
            }
        }
    }
}