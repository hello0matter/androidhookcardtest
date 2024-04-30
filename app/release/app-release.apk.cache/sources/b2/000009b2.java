package t3;

import java.util.ArrayList;
import java.util.Arrays;
import okio.ByteString;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: b  reason: collision with root package name */
    public final y3.f f6724b;

    /* renamed from: d  reason: collision with root package name */
    public boolean f6726d;

    /* renamed from: h  reason: collision with root package name */
    public int f6730h;

    /* renamed from: i  reason: collision with root package name */
    public int f6731i;

    /* renamed from: a  reason: collision with root package name */
    public final boolean f6723a = true;

    /* renamed from: c  reason: collision with root package name */
    public int f6725c = Integer.MAX_VALUE;

    /* renamed from: e  reason: collision with root package name */
    public int f6727e = 4096;

    /* renamed from: f  reason: collision with root package name */
    public b[] f6728f = new b[8];

    /* renamed from: g  reason: collision with root package name */
    public int f6729g = 7;

    public d(y3.f fVar) {
        this.f6724b = fVar;
    }

    public final void a(int i4) {
        int i5;
        if (i4 > 0) {
            int length = this.f6728f.length - 1;
            int i6 = 0;
            while (true) {
                i5 = this.f6729g;
                if (length < i5 || i4 <= 0) {
                    break;
                }
                b bVar = this.f6728f[length];
                com.google.common.collect.c.C(bVar);
                i4 -= bVar.f6710c;
                int i7 = this.f6731i;
                b bVar2 = this.f6728f[length];
                com.google.common.collect.c.C(bVar2);
                this.f6731i = i7 - bVar2.f6710c;
                this.f6730h--;
                i6++;
                length--;
            }
            b[] bVarArr = this.f6728f;
            int i8 = i5 + 1;
            System.arraycopy(bVarArr, i8, bVarArr, i8 + i6, this.f6730h);
            b[] bVarArr2 = this.f6728f;
            int i9 = this.f6729g + 1;
            Arrays.fill(bVarArr2, i9, i9 + i6, (Object) null);
            this.f6729g += i6;
        }
    }

    public final void b(b bVar) {
        int i4 = this.f6727e;
        int i5 = bVar.f6710c;
        if (i5 > i4) {
            b[] bVarArr = this.f6728f;
            y2.h.l2(bVarArr, 0, bVarArr.length);
            this.f6729g = this.f6728f.length - 1;
            this.f6730h = 0;
            this.f6731i = 0;
            return;
        }
        a((this.f6731i + i5) - i4);
        int i6 = this.f6730h + 1;
        b[] bVarArr2 = this.f6728f;
        if (i6 > bVarArr2.length) {
            b[] bVarArr3 = new b[bVarArr2.length * 2];
            System.arraycopy(bVarArr2, 0, bVarArr3, bVarArr2.length, bVarArr2.length);
            this.f6729g = this.f6728f.length - 1;
            this.f6728f = bVarArr3;
        }
        int i7 = this.f6729g;
        this.f6729g = i7 - 1;
        this.f6728f[i7] = bVar;
        this.f6730h++;
        this.f6731i += i5;
    }

    /* JADX WARN: Type inference failed for: r0v9, types: [y3.f, java.lang.Object] */
    public final void c(ByteString byteString) {
        int c4;
        com.google.common.collect.c.F(byteString, "data");
        boolean z4 = this.f6723a;
        y3.f fVar = this.f6724b;
        int i4 = 0;
        if (z4) {
            int[] iArr = b0.f6711a;
            int c5 = byteString.c();
            long j4 = 0;
            for (int i5 = 0; i5 < c5; i5++) {
                byte f4 = byteString.f(i5);
                byte[] bArr = n3.b.f5783a;
                j4 += b0.f6712b[f4 & 255];
            }
            if (((int) ((j4 + 7) >> 3)) < byteString.c()) {
                ?? obj = new Object();
                int[] iArr2 = b0.f6711a;
                int c6 = byteString.c();
                long j5 = 0;
                byte b5 = 0;
                while (i4 < c6) {
                    byte f5 = byteString.f(i4);
                    byte[] bArr2 = n3.b.f5783a;
                    int i6 = f5 & 255;
                    int i7 = b0.f6711a[i6];
                    byte b6 = b0.f6712b[i6];
                    j5 = (j5 << b6) | i7;
                    int i8 = b5 + b6;
                    while (i8 >= 8) {
                        i8 = (i8 == 1 ? 1 : 0) - 8;
                        obj.H((int) (j5 >> i8));
                    }
                    i4++;
                    b5 = i8;
                }
                if (b5 > 0) {
                    obj.H((int) ((255 >>> b5) | (j5 << (8 - b5))));
                }
                byteString = obj.e(obj.f7180b);
                c4 = byteString.c();
                i4 = 128;
                e(c4, 127, i4);
                fVar.E(byteString);
            }
        }
        c4 = byteString.c();
        e(c4, 127, i4);
        fVar.E(byteString);
    }

    public final void d(ArrayList arrayList) {
        int i4;
        int i5;
        if (this.f6726d) {
            int i6 = this.f6725c;
            if (i6 < this.f6727e) {
                e(i6, 31, 32);
            }
            this.f6726d = false;
            this.f6725c = Integer.MAX_VALUE;
            e(this.f6727e, 31, 32);
        }
        int size = arrayList.size();
        for (int i7 = 0; i7 < size; i7++) {
            b bVar = (b) arrayList.get(i7);
            ByteString i8 = bVar.f6708a.i();
            Integer num = (Integer) e.f6735b.get(i8);
            ByteString byteString = bVar.f6709b;
            if (num != null) {
                int intValue = num.intValue();
                i5 = intValue + 1;
                if (2 <= i5 && i5 < 8) {
                    b[] bVarArr = e.f6734a;
                    if (com.google.common.collect.c.n(bVarArr[intValue].f6709b, byteString)) {
                        i4 = i5;
                    } else if (com.google.common.collect.c.n(bVarArr[i5].f6709b, byteString)) {
                        i5 = intValue + 2;
                        i4 = i5;
                    }
                }
                i4 = i5;
                i5 = -1;
            } else {
                i4 = -1;
                i5 = -1;
            }
            if (i5 == -1) {
                int i9 = this.f6729g + 1;
                int length = this.f6728f.length;
                while (true) {
                    if (i9 >= length) {
                        break;
                    }
                    b bVar2 = this.f6728f[i9];
                    com.google.common.collect.c.C(bVar2);
                    if (com.google.common.collect.c.n(bVar2.f6708a, i8)) {
                        b bVar3 = this.f6728f[i9];
                        com.google.common.collect.c.C(bVar3);
                        if (com.google.common.collect.c.n(bVar3.f6709b, byteString)) {
                            i5 = e.f6734a.length + (i9 - this.f6729g);
                            break;
                        } else if (i4 == -1) {
                            i4 = (i9 - this.f6729g) + e.f6734a.length;
                        }
                    }
                    i9++;
                }
            }
            if (i5 != -1) {
                e(i5, 127, 128);
            } else {
                if (i4 == -1) {
                    this.f6724b.H(64);
                    c(i8);
                } else {
                    ByteString byteString2 = b.f6702d;
                    i8.getClass();
                    com.google.common.collect.c.F(byteString2, "prefix");
                    if (i8.h(byteString2, byteString2.c()) && !com.google.common.collect.c.n(b.f6707i, i8)) {
                        e(i4, 15, 0);
                        c(byteString);
                    } else {
                        e(i4, 63, 64);
                    }
                }
                c(byteString);
                b(bVar);
            }
        }
    }

    public final void e(int i4, int i5, int i6) {
        y3.f fVar = this.f6724b;
        if (i4 < i5) {
            fVar.H(i4 | i6);
            return;
        }
        fVar.H(i6 | i5);
        int i7 = i4 - i5;
        while (i7 >= 128) {
            fVar.H(128 | (i7 & 127));
            i7 >>>= 7;
        }
        fVar.H(i7);
    }
}