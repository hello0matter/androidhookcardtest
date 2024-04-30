package okio;

import com.google.common.collect.c;
import java.security.MessageDigest;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import y2.h;
import y3.f;
import y3.p;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lokio/SegmentedByteString;", "Lokio/ByteString;", "Ljava/lang/Object;", "writeReplace", "()Ljava/lang/Object;", "okio"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nSegmentedByteString.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SegmentedByteString.kt\nokio/SegmentedByteString\n+ 2 SegmentedByteString.kt\nokio/internal/-SegmentedByteString\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,140:1\n63#2,12:141\n63#2,12:153\n104#2,2:165\n106#2,26:168\n135#2,5:194\n142#2:199\n145#2,3:200\n63#2,8:203\n148#2,8:211\n71#2,4:219\n156#2:223\n63#2,12:224\n160#2:236\n85#2,10:237\n161#2,9:247\n95#2,4:256\n170#2,2:260\n179#2,4:262\n85#2,10:266\n183#2,3:276\n95#2,4:279\n186#2:283\n195#2,8:284\n85#2,10:292\n203#2,3:302\n95#2,4:305\n206#2:309\n215#2,5:310\n85#2,10:315\n220#2,3:325\n95#2,4:328\n223#2:332\n226#2,4:333\n234#2,6:337\n63#2,8:343\n240#2,7:351\n71#2,4:358\n247#2,2:362\n1#3:167\n*S KotlinDebug\n*F\n+ 1 SegmentedByteString.kt\nokio/SegmentedByteString\n*L\n54#1:141,12\n66#1:153,12\n78#1:165,2\n78#1:168,26\n80#1:194,5\n82#1:199\n84#1:200,3\n84#1:203,8\n84#1:211,8\n84#1:219,4\n84#1:223\n90#1:224,12\n96#1:236\n96#1:237,10\n96#1:247,9\n96#1:256,4\n96#1:260,2\n103#1:262,4\n103#1:266,10\n103#1:276,3\n103#1:279,4\n103#1:283\n110#1:284,8\n110#1:292,10\n110#1:302,3\n110#1:305,4\n110#1:309\n117#1:310,5\n117#1:315,10\n117#1:325,3\n117#1:328,4\n117#1:332\n131#1:333,4\n133#1:337,6\n133#1:343,8\n133#1:351,7\n133#1:358,4\n133#1:362,2\n78#1:167\n*E\n"})
/* loaded from: classes.dex */
public final class SegmentedByteString extends ByteString {

    /* renamed from: e  reason: collision with root package name */
    public final transient byte[][] f6053e;

    /* renamed from: f  reason: collision with root package name */
    public final transient int[] f6054f;

    public SegmentedByteString(byte[][] bArr, int[] iArr) {
        super(ByteString.f6049d.f6050a);
        this.f6053e = bArr;
        this.f6054f = iArr;
    }

    private final Object writeReplace() {
        return new ByteString(l());
    }

    @Override // okio.ByteString
    public final String a() {
        throw null;
    }

    @Override // okio.ByteString
    public final ByteString b(String str) {
        MessageDigest messageDigest = MessageDigest.getInstance(str);
        byte[][] bArr = this.f6053e;
        int length = bArr.length;
        int i4 = 0;
        int i5 = 0;
        while (i4 < length) {
            int[] iArr = this.f6054f;
            int i6 = iArr[length + i4];
            int i7 = iArr[i4];
            messageDigest.update(bArr[i4], i6, i7 - i5);
            i4++;
            i5 = i7;
        }
        byte[] digest = messageDigest.digest();
        c.C(digest);
        return new ByteString(digest);
    }

    @Override // okio.ByteString
    public final int c() {
        return this.f6054f[this.f6053e.length - 1];
    }

    @Override // okio.ByteString
    public final String d() {
        return new ByteString(l()).d();
    }

    @Override // okio.ByteString
    public final byte[] e() {
        return l();
    }

    @Override // okio.ByteString
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            if (byteString.c() == c() && h(byteString, c())) {
                return true;
            }
        }
        return false;
    }

    @Override // okio.ByteString
    public final byte f(int i4) {
        byte[][] bArr = this.f6053e;
        int[] iArr = this.f6054f;
        c.G(iArr[bArr.length - 1], i4, 1L);
        int N1 = c.N1(this, i4);
        return bArr[N1][(i4 - (N1 == 0 ? 0 : iArr[N1 - 1])) + iArr[bArr.length + N1]];
    }

    @Override // okio.ByteString
    public final boolean g(int i4, byte[] bArr, int i5, int i6) {
        int i7;
        c.F(bArr, "other");
        if (i4 < 0 || i4 > c() - i6 || i5 < 0 || i5 > bArr.length - i6) {
            return false;
        }
        int i8 = i6 + i4;
        int N1 = c.N1(this, i4);
        while (i4 < i8) {
            int[] iArr = this.f6054f;
            if (N1 == 0) {
                i7 = 0;
            } else {
                i7 = iArr[N1 - 1];
            }
            byte[][] bArr2 = this.f6053e;
            int i9 = iArr[bArr2.length + N1];
            int min = Math.min(i8, (iArr[N1] - i7) + i7) - i4;
            if (!c.o((i4 - i7) + i9, i5, min, bArr2[N1], bArr)) {
                return false;
            }
            i5 += min;
            i4 += min;
            N1++;
        }
        return true;
    }

    @Override // okio.ByteString
    public final boolean h(ByteString byteString, int i4) {
        int i5;
        c.F(byteString, "other");
        if (c() - i4 < 0) {
            return false;
        }
        int N1 = c.N1(this, 0);
        int i6 = 0;
        int i7 = 0;
        while (i6 < i4) {
            int[] iArr = this.f6054f;
            if (N1 == 0) {
                i5 = 0;
            } else {
                i5 = iArr[N1 - 1];
            }
            byte[][] bArr = this.f6053e;
            int i8 = iArr[bArr.length + N1];
            int min = Math.min(i4, (iArr[N1] - i5) + i5) - i6;
            if (!byteString.g(i7, bArr[N1], (i6 - i5) + i8, min)) {
                return false;
            }
            i7 += min;
            i6 += min;
            N1++;
        }
        return true;
    }

    @Override // okio.ByteString
    public final int hashCode() {
        int i4 = this.f6051b;
        if (i4 == 0) {
            byte[][] bArr = this.f6053e;
            int length = bArr.length;
            int i5 = 0;
            int i6 = 1;
            int i7 = 0;
            while (i5 < length) {
                int[] iArr = this.f6054f;
                int i8 = iArr[length + i5];
                int i9 = iArr[i5];
                byte[] bArr2 = bArr[i5];
                int i10 = (i9 - i7) + i8;
                while (i8 < i10) {
                    i6 = (i6 * 31) + bArr2[i8];
                    i8++;
                }
                i5++;
                i7 = i9;
            }
            this.f6051b = i6;
            return i6;
        }
        return i4;
    }

    @Override // okio.ByteString
    public final ByteString i() {
        return new ByteString(l()).i();
    }

    @Override // okio.ByteString
    public final void k(f fVar, int i4) {
        int i5;
        c.F(fVar, "buffer");
        int N1 = c.N1(this, 0);
        int i6 = 0;
        while (i6 < i4) {
            int[] iArr = this.f6054f;
            if (N1 == 0) {
                i5 = 0;
            } else {
                i5 = iArr[N1 - 1];
            }
            byte[][] bArr = this.f6053e;
            int i7 = iArr[bArr.length + N1];
            int min = Math.min(i4, (iArr[N1] - i5) + i5) - i6;
            int i8 = (i6 - i5) + i7;
            p pVar = new p(bArr[N1], i8, i8 + min, true);
            p pVar2 = fVar.f7179a;
            if (pVar2 == null) {
                pVar.f7206g = pVar;
                pVar.f7205f = pVar;
                fVar.f7179a = pVar;
            } else {
                p pVar3 = pVar2.f7206g;
                c.C(pVar3);
                pVar3.b(pVar);
            }
            i6 += min;
            N1++;
        }
        fVar.f7180b += i4;
    }

    public final byte[] l() {
        byte[] bArr = new byte[c()];
        byte[][] bArr2 = this.f6053e;
        int length = bArr2.length;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (i4 < length) {
            int[] iArr = this.f6054f;
            int i7 = iArr[length + i4];
            int i8 = iArr[i4];
            int i9 = i8 - i5;
            h.i2(i6, i7, i7 + i9, bArr2[i4], bArr);
            i6 += i9;
            i4++;
            i5 = i8;
        }
        return bArr;
    }

    @Override // okio.ByteString
    public final String toString() {
        return new ByteString(l()).toString();
    }
}