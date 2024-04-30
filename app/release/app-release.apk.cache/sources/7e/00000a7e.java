package z3;

import com.google.common.collect.c;
import y3.f;
import y3.m;
import y3.p;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f7234a;

    static {
        byte[] bytes = "0123456789abcdef".getBytes(l3.a.f5399a);
        c.E(bytes, "this as java.lang.String).getBytes(charset)");
        f7234a = bytes;
    }

    public static final String a(f fVar, long j4) {
        c.F(fVar, "<this>");
        if (j4 > 0) {
            long j5 = j4 - 1;
            if (fVar.y(j5) == 13) {
                String B = fVar.B(j5, l3.a.f5399a);
                fVar.h(2L);
                return B;
            }
        }
        String B2 = fVar.B(j4, l3.a.f5399a);
        fVar.h(1L);
        return B2;
    }

    public static final int b(f fVar, m mVar, boolean z4) {
        int i4;
        int i5;
        boolean z5;
        p pVar;
        byte[] bArr;
        int i6;
        c.F(fVar, "<this>");
        c.F(mVar, "options");
        p pVar2 = fVar.f7179a;
        int i7 = -2;
        if (pVar2 == null) {
            if (z4) {
                return -2;
            }
            return -1;
        }
        int i8 = pVar2.f7201b;
        int i9 = pVar2.f7202c;
        byte[] bArr2 = pVar2.f7200a;
        p pVar3 = pVar2;
        int i10 = -1;
        int i11 = 0;
        loop0: while (true) {
            int i12 = i11 + 1;
            int[] iArr = mVar.f7193b;
            int i13 = iArr[i11];
            int i14 = i11 + 2;
            int i15 = iArr[i12];
            if (i15 != -1) {
                i10 = i15;
            }
            if (pVar3 == null) {
                break;
            }
            if (i13 < 0) {
                int i16 = (i13 * (-1)) + i14;
                while (true) {
                    int i17 = i8 + 1;
                    int i18 = i14 + 1;
                    if ((bArr2[i8] & 255) != iArr[i14]) {
                        return i10;
                    }
                    if (i18 == i16) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    if (i17 == i9) {
                        c.C(pVar3);
                        p pVar4 = pVar3.f7205f;
                        c.C(pVar4);
                        i6 = pVar4.f7201b;
                        int i19 = pVar4.f7202c;
                        bArr = pVar4.f7200a;
                        if (pVar4 == pVar2) {
                            if (!z5) {
                                break loop0;
                            }
                            i9 = i19;
                            pVar = null;
                        } else {
                            pVar = pVar4;
                            i9 = i19;
                        }
                    } else {
                        pVar = pVar3;
                        bArr = bArr2;
                        i6 = i17;
                    }
                    if (z5) {
                        i4 = iArr[i18];
                        i5 = i6;
                        bArr2 = bArr;
                        pVar3 = pVar;
                        break;
                    }
                    i8 = i6;
                    bArr2 = bArr;
                    pVar3 = pVar;
                    i14 = i18;
                }
            } else {
                int i20 = i8 + 1;
                int i21 = bArr2[i8] & 255;
                int i22 = i14 + i13;
                while (i14 != i22) {
                    if (i21 == iArr[i14]) {
                        i4 = iArr[i14 + i13];
                        if (i20 == i9) {
                            pVar3 = pVar3.f7205f;
                            c.C(pVar3);
                            i5 = pVar3.f7201b;
                            i9 = pVar3.f7202c;
                            bArr2 = pVar3.f7200a;
                            if (pVar3 == pVar2) {
                                pVar3 = null;
                            }
                        } else {
                            i5 = i20;
                        }
                    } else {
                        i14++;
                    }
                }
                return i10;
            }
            if (i4 >= 0) {
                return i4;
            }
            i11 = -i4;
            i8 = i5;
            i7 = -2;
        }
        if (z4) {
            return i7;
        }
        return i10;
    }
}