package y3;

/* loaded from: classes.dex */
public final class p {

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f7200a;

    /* renamed from: b  reason: collision with root package name */
    public int f7201b;

    /* renamed from: c  reason: collision with root package name */
    public int f7202c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f7203d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f7204e;

    /* renamed from: f  reason: collision with root package name */
    public p f7205f;

    /* renamed from: g  reason: collision with root package name */
    public p f7206g;

    public p() {
        this.f7200a = new byte[8192];
        this.f7204e = true;
        this.f7203d = false;
    }

    public final p a() {
        p pVar = this.f7205f;
        if (pVar == this) {
            pVar = null;
        }
        p pVar2 = this.f7206g;
        com.google.common.collect.c.C(pVar2);
        pVar2.f7205f = this.f7205f;
        p pVar3 = this.f7205f;
        com.google.common.collect.c.C(pVar3);
        pVar3.f7206g = this.f7206g;
        this.f7205f = null;
        this.f7206g = null;
        return pVar;
    }

    public final void b(p pVar) {
        pVar.f7206g = this;
        pVar.f7205f = this.f7205f;
        p pVar2 = this.f7205f;
        com.google.common.collect.c.C(pVar2);
        pVar2.f7206g = pVar;
        this.f7205f = pVar;
    }

    public final p c() {
        this.f7203d = true;
        return new p(this.f7200a, this.f7201b, this.f7202c, true);
    }

    public final void d(p pVar, int i4) {
        if (pVar.f7204e) {
            int i5 = pVar.f7202c;
            int i6 = i5 + i4;
            byte[] bArr = pVar.f7200a;
            if (i6 > 8192) {
                if (!pVar.f7203d) {
                    int i7 = pVar.f7201b;
                    if (i6 - i7 <= 8192) {
                        y2.h.i2(0, i7, i5, bArr, bArr);
                        pVar.f7202c -= pVar.f7201b;
                        pVar.f7201b = 0;
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else {
                    throw new IllegalArgumentException();
                }
            }
            int i8 = pVar.f7202c;
            int i9 = this.f7201b;
            y2.h.i2(i8, i9, i9 + i4, this.f7200a, bArr);
            pVar.f7202c += i4;
            this.f7201b += i4;
            return;
        }
        throw new IllegalStateException("only owner can write".toString());
    }

    public p(byte[] bArr, int i4, int i5, boolean z4) {
        com.google.common.collect.c.F(bArr, "data");
        this.f7200a = bArr;
        this.f7201b = i4;
        this.f7202c = i5;
        this.f7203d = z4;
        this.f7204e = false;
    }
}