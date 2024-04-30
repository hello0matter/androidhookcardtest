package y3;

import java.io.EOFException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import okio.ByteString;

/* loaded from: classes.dex */
public final class o implements h {

    /* renamed from: a  reason: collision with root package name */
    public final t f7197a;

    /* renamed from: b  reason: collision with root package name */
    public final f f7198b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f7199c;

    /* JADX WARN: Type inference failed for: r2v1, types: [y3.f, java.lang.Object] */
    public o(t tVar) {
        com.google.common.collect.c.F(tVar, "source");
        this.f7197a = tVar;
        this.f7198b = new Object();
    }

    @Override // y3.t
    public final v a() {
        return this.f7197a.a();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public final void close() {
        if (!this.f7199c) {
            this.f7199c = true;
            this.f7197a.close();
            f fVar = this.f7198b;
            fVar.h(fVar.f7180b);
        }
    }

    @Override // y3.h
    public final ByteString e(long j4) {
        o(j4);
        return this.f7198b.e(j4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [y3.f, java.lang.Object] */
    @Override // y3.h
    public final String g(long j4) {
        long j5;
        ?? obj;
        if (j4 >= 0) {
            if (j4 == Long.MAX_VALUE) {
                j5 = Long.MAX_VALUE;
            } else {
                j5 = j4 + 1;
            }
            long x4 = x((byte) 10, 0L, j5);
            int i4 = (x4 > (-1L) ? 1 : (x4 == (-1L) ? 0 : -1));
            f fVar = this.f7198b;
            if (i4 != 0) {
                return z3.a.a(fVar, x4);
            }
            if (j5 < Long.MAX_VALUE && z(j5) && fVar.y(j5 - 1) == 13 && z(1 + j5) && fVar.y(j5) == 10) {
                return z3.a.a(fVar, j5);
            }
            fVar.x(new Object(), 0L, Math.min(32, fVar.f7180b));
            throw new EOFException("\\n not found: limit=" + Math.min(fVar.f7180b, j4) + " content=" + obj.e(obj.f7180b).d() + (char) 8230);
        }
        throw new IllegalArgumentException(("limit < 0: " + j4).toString());
    }

    @Override // y3.h
    public final void h(long j4) {
        if (!this.f7199c) {
            while (j4 > 0) {
                f fVar = this.f7198b;
                if (fVar.f7180b == 0 && this.f7197a.w(fVar, 8192L) == -1) {
                    throw new EOFException();
                }
                long min = Math.min(j4, fVar.f7180b);
                fVar.h(min);
                j4 -= min;
            }
            return;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // y3.h
    public final short i() {
        o(2L);
        return this.f7198b.i();
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return !this.f7199c;
    }

    @Override // y3.h
    public final int k() {
        o(4L);
        return this.f7198b.k();
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:?, code lost:
        return -1;
     */
    @Override // y3.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int m(y3.m r8) {
        /*
            r7 = this;
            java.lang.String r0 = "options"
            com.google.common.collect.c.F(r8, r0)
            boolean r0 = r7.f7199c
            r1 = 1
            r0 = r0 ^ r1
            if (r0 == 0) goto L36
        Lb:
            y3.f r0 = r7.f7198b
            int r2 = z3.a.b(r0, r8, r1)
            r3 = -2
            r4 = -1
            if (r2 == r3) goto L26
            if (r2 == r4) goto L24
            okio.ByteString[] r8 = r8.f7192a
            r8 = r8[r2]
            int r8 = r8.c()
            long r3 = (long) r8
            r0.h(r3)
            goto L35
        L24:
            r2 = r4
            goto L35
        L26:
            y3.t r2 = r7.f7197a
            r5 = 8192(0x2000, double:4.0474E-320)
            long r2 = r2.w(r0, r5)
            r5 = -1
            int r0 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r0 != 0) goto Lb
            goto L24
        L35:
            return r2
        L36:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "closed"
            java.lang.String r0 = r0.toString()
            r8.<init>(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: y3.o.m(y3.m):int");
    }

    @Override // y3.h
    public final String n() {
        return g(Long.MAX_VALUE);
    }

    @Override // y3.h
    public final void o(long j4) {
        if (z(j4)) {
            return;
        }
        throw new EOFException();
    }

    @Override // y3.h
    public final f q() {
        return this.f7198b;
    }

    @Override // y3.h
    public final boolean r() {
        if (!this.f7199c) {
            f fVar = this.f7198b;
            if (fVar.r() && this.f7197a.w(fVar, 8192L) == -1) {
                return true;
            }
            return false;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // java.nio.channels.ReadableByteChannel
    public final int read(ByteBuffer byteBuffer) {
        com.google.common.collect.c.F(byteBuffer, "sink");
        f fVar = this.f7198b;
        if (fVar.f7180b == 0 && this.f7197a.w(fVar, 8192L) == -1) {
            return -1;
        }
        return fVar.read(byteBuffer);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0031, code lost:
        if (r0 == 0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0034, code lost:
        com.google.common.collect.c.I(16);
        com.google.common.collect.c.I(16);
        r1 = java.lang.Integer.toString(r2, 16);
        com.google.common.collect.c.E(r1, "toString(this, checkRadix(radix))");
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0050, code lost:
        throw new java.lang.NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x".concat(r1));
     */
    @Override // y3.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long t() {
        /*
            r6 = this;
            r0 = 1
            r6.o(r0)
            r0 = 0
        L6:
            int r1 = r0 + 1
            long r2 = (long) r1
            boolean r2 = r6.z(r2)
            y3.f r3 = r6.f7198b
            if (r2 == 0) goto L51
            long r4 = (long) r0
            byte r2 = r3.y(r4)
            r4 = 48
            if (r2 < r4) goto L1e
            r4 = 57
            if (r2 <= r4) goto L2f
        L1e:
            r4 = 97
            if (r2 < r4) goto L26
            r4 = 102(0x66, float:1.43E-43)
            if (r2 <= r4) goto L2f
        L26:
            r4 = 65
            if (r2 < r4) goto L31
            r4 = 70
            if (r2 <= r4) goto L2f
            goto L31
        L2f:
            r0 = r1
            goto L6
        L31:
            if (r0 == 0) goto L34
            goto L51
        L34:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            r1 = 16
            com.google.common.collect.c.I(r1)
            com.google.common.collect.c.I(r1)
            java.lang.String r1 = java.lang.Integer.toString(r2, r1)
            java.lang.String r2 = "toString(this, checkRadix(radix))"
            com.google.common.collect.c.E(r1, r2)
            java.lang.String r2 = "Expected leading [0-9a-fA-F] character but was 0x"
            java.lang.String r1 = r2.concat(r1)
            r0.<init>(r1)
            throw r0
        L51:
            long r0 = r3.t()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: y3.o.t():long");
    }

    public final String toString() {
        return "buffer(" + this.f7197a + ')';
    }

    @Override // y3.h
    public final String u(Charset charset) {
        f fVar = this.f7198b;
        fVar.G(this.f7197a);
        return fVar.B(fVar.f7180b, charset);
    }

    @Override // y3.h
    public final byte v() {
        o(1L);
        return this.f7198b.v();
    }

    @Override // y3.t
    public final long w(f fVar, long j4) {
        com.google.common.collect.c.F(fVar, "sink");
        if (j4 >= 0) {
            if (!this.f7199c) {
                f fVar2 = this.f7198b;
                if (fVar2.f7180b == 0 && this.f7197a.w(fVar2, 8192L) == -1) {
                    return -1L;
                }
                return fVar2.w(fVar, Math.min(j4, fVar2.f7180b));
            }
            throw new IllegalStateException("closed".toString());
        }
        throw new IllegalArgumentException(("byteCount < 0: " + j4).toString());
    }

    public final long x(byte b5, long j4, long j5) {
        if (!this.f7199c) {
            long j6 = 0;
            if (0 <= j5) {
                while (j6 < j5) {
                    long z4 = this.f7198b.z(b5, j6, j5);
                    if (z4 != -1) {
                        return z4;
                    }
                    f fVar = this.f7198b;
                    long j7 = fVar.f7180b;
                    if (j7 >= j5 || this.f7197a.w(fVar, 8192L) == -1) {
                        return -1L;
                    }
                    j6 = Math.max(j6, j7);
                }
                return -1L;
            }
            throw new IllegalArgumentException(("fromIndex=0 toIndex=" + j5).toString());
        }
        throw new IllegalStateException("closed".toString());
    }

    public final int y() {
        o(4L);
        int k4 = this.f7198b.k();
        return ((k4 & 255) << 24) | (((-16777216) & k4) >>> 24) | ((16711680 & k4) >>> 8) | ((65280 & k4) << 8);
    }

    public final boolean z(long j4) {
        f fVar;
        if (j4 >= 0) {
            if (!this.f7199c) {
                do {
                    fVar = this.f7198b;
                    if (fVar.f7180b >= j4) {
                        return true;
                    }
                } while (this.f7197a.w(fVar, 8192L) != -1);
                return false;
            }
            throw new IllegalStateException("closed".toString());
        }
        throw new IllegalArgumentException(("byteCount < 0: " + j4).toString());
    }
}