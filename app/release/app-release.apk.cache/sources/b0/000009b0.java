package t3;

import java.io.IOException;
import java.util.ArrayList;
import okio.ByteString;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: d  reason: collision with root package name */
    public final y3.o f6717d;

    /* renamed from: g  reason: collision with root package name */
    public int f6720g;

    /* renamed from: h  reason: collision with root package name */
    public int f6721h;

    /* renamed from: a  reason: collision with root package name */
    public final int f6714a = 4096;

    /* renamed from: b  reason: collision with root package name */
    public int f6715b = 4096;

    /* renamed from: c  reason: collision with root package name */
    public final ArrayList f6716c = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public b[] f6718e = new b[8];

    /* renamed from: f  reason: collision with root package name */
    public int f6719f = 7;

    public c(u uVar) {
        this.f6717d = new y3.o(uVar);
    }

    public final int a(int i4) {
        int i5;
        int i6 = 0;
        if (i4 > 0) {
            int length = this.f6718e.length;
            while (true) {
                length--;
                i5 = this.f6719f;
                if (length < i5 || i4 <= 0) {
                    break;
                }
                b bVar = this.f6718e[length];
                com.google.common.collect.c.C(bVar);
                int i7 = bVar.f6710c;
                i4 -= i7;
                this.f6721h -= i7;
                this.f6720g--;
                i6++;
            }
            b[] bVarArr = this.f6718e;
            System.arraycopy(bVarArr, i5 + 1, bVarArr, i5 + 1 + i6, this.f6720g);
            this.f6719f += i6;
        }
        return i6;
    }

    public final ByteString b(int i4) {
        b bVar;
        if (i4 >= 0) {
            b[] bVarArr = e.f6734a;
            if (i4 <= bVarArr.length - 1) {
                bVar = bVarArr[i4];
                return bVar.f6708a;
            }
        }
        int length = this.f6719f + 1 + (i4 - e.f6734a.length);
        if (length >= 0) {
            b[] bVarArr2 = this.f6718e;
            if (length < bVarArr2.length) {
                bVar = bVarArr2[length];
                com.google.common.collect.c.C(bVar);
                return bVar.f6708a;
            }
        }
        throw new IOException("Header index too large " + (i4 + 1));
    }

    public final void c(b bVar) {
        this.f6716c.add(bVar);
        int i4 = this.f6715b;
        int i5 = bVar.f6710c;
        if (i5 > i4) {
            b[] bVarArr = this.f6718e;
            y2.h.l2(bVarArr, 0, bVarArr.length);
            this.f6719f = this.f6718e.length - 1;
            this.f6720g = 0;
            this.f6721h = 0;
            return;
        }
        a((this.f6721h + i5) - i4);
        int i6 = this.f6720g + 1;
        b[] bVarArr2 = this.f6718e;
        if (i6 > bVarArr2.length) {
            b[] bVarArr3 = new b[bVarArr2.length * 2];
            System.arraycopy(bVarArr2, 0, bVarArr3, bVarArr2.length, bVarArr2.length);
            this.f6719f = this.f6718e.length - 1;
            this.f6718e = bVarArr3;
        }
        int i7 = this.f6719f;
        this.f6719f = i7 - 1;
        this.f6718e[i7] = bVar;
        this.f6720g++;
        this.f6721h += i5;
    }

    /* JADX WARN: Type inference failed for: r1v4, types: [y3.f, java.lang.Object] */
    public final ByteString d() {
        boolean z4;
        int i4;
        y3.o oVar = this.f6717d;
        byte v2 = oVar.v();
        byte[] bArr = n3.b.f5783a;
        int i5 = v2 & 255;
        int i6 = 0;
        if ((v2 & 128) == 128) {
            z4 = true;
        } else {
            z4 = false;
        }
        long e4 = e(i5, 127);
        if (z4) {
            ?? obj = new Object();
            int[] iArr = b0.f6711a;
            com.google.common.collect.c.F(oVar, "source");
            l1.a aVar = b0.f6713c;
            l1.a aVar2 = aVar;
            int i7 = 0;
            for (long j4 = 0; j4 < e4; j4++) {
                byte v4 = oVar.v();
                byte[] bArr2 = n3.b.f5783a;
                i6 = (i6 << 8) | (v4 & 255);
                i7 += 8;
                while (i7 >= 8) {
                    l1.a[] aVarArr = (l1.a[]) aVar2.f5265c;
                    com.google.common.collect.c.C(aVarArr);
                    aVar2 = aVarArr[(i6 >>> (i7 - 8)) & 255];
                    com.google.common.collect.c.C(aVar2);
                    if (((l1.a[]) aVar2.f5265c) == null) {
                        obj.H(aVar2.f5263a);
                        i7 -= aVar2.f5264b;
                        aVar2 = aVar;
                    } else {
                        i7 -= 8;
                    }
                }
            }
            while (i7 > 0) {
                l1.a[] aVarArr2 = (l1.a[]) aVar2.f5265c;
                com.google.common.collect.c.C(aVarArr2);
                l1.a aVar3 = aVarArr2[(i6 << (8 - i7)) & 255];
                com.google.common.collect.c.C(aVar3);
                if (((l1.a[]) aVar3.f5265c) != null || (i4 = aVar3.f5264b) > i7) {
                    break;
                }
                obj.H(aVar3.f5263a);
                i7 -= i4;
                aVar2 = aVar;
            }
            return obj.e(obj.f7180b);
        }
        return oVar.e(e4);
    }

    public final int e(int i4, int i5) {
        int i6 = i4 & i5;
        if (i6 < i5) {
            return i6;
        }
        int i7 = 0;
        while (true) {
            byte v2 = this.f6717d.v();
            byte[] bArr = n3.b.f5783a;
            int i8 = v2 & 255;
            if ((v2 & 128) != 0) {
                i5 += (v2 & Byte.MAX_VALUE) << i7;
                i7 += 7;
            } else {
                return i5 + (i8 << i7);
            }
        }
    }
}