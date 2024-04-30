package y3;

import java.nio.ByteBuffer;
import okio.ByteString;

/* loaded from: classes.dex */
public final class n implements g {

    /* renamed from: a  reason: collision with root package name */
    public final r f7194a;

    /* renamed from: b  reason: collision with root package name */
    public final f f7195b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f7196c;

    /* JADX WARN: Type inference failed for: r2v1, types: [y3.f, java.lang.Object] */
    public n(r rVar) {
        com.google.common.collect.c.F(rVar, "sink");
        this.f7194a = rVar;
        this.f7195b = new Object();
    }

    @Override // y3.r
    public final v a() {
        return this.f7194a.a();
    }

    @Override // y3.g
    public final g b(byte[] bArr) {
        if (!this.f7196c) {
            f fVar = this.f7195b;
            fVar.getClass();
            fVar.F(bArr, 0, bArr.length);
            x();
            return this;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // y3.g
    public final g c(ByteString byteString) {
        com.google.common.collect.c.F(byteString, "byteString");
        if (!this.f7196c) {
            this.f7195b.E(byteString);
            x();
            return this;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // y3.r, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        r rVar = this.f7194a;
        if (!this.f7196c) {
            try {
                f fVar = this.f7195b;
                long j4 = fVar.f7180b;
                if (j4 > 0) {
                    rVar.f(fVar, j4);
                }
                th = null;
            } catch (Throwable th) {
                th = th;
            }
            try {
                rVar.close();
            } catch (Throwable th2) {
                if (th == null) {
                    th = th2;
                }
            }
            this.f7196c = true;
            if (th != null) {
                throw th;
            }
        }
    }

    @Override // y3.g
    public final g d(long j4) {
        if (!this.f7196c) {
            this.f7195b.I(j4);
            x();
            return this;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // y3.r
    public final void f(f fVar, long j4) {
        com.google.common.collect.c.F(fVar, "source");
        if (!this.f7196c) {
            this.f7195b.f(fVar, j4);
            x();
            return;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // y3.g, y3.r, java.io.Flushable
    public final void flush() {
        if (!this.f7196c) {
            f fVar = this.f7195b;
            long j4 = fVar.f7180b;
            int i4 = (j4 > 0L ? 1 : (j4 == 0L ? 0 : -1));
            r rVar = this.f7194a;
            if (i4 > 0) {
                rVar.f(fVar, j4);
            }
            rVar.flush();
            return;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return !this.f7196c;
    }

    @Override // y3.g
    public final g j(int i4) {
        if (!this.f7196c) {
            this.f7195b.K(i4);
            x();
            return this;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // y3.g
    public final g l(int i4) {
        if (!this.f7196c) {
            this.f7195b.J(i4);
            x();
            return this;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // y3.g
    public final g p(String str) {
        com.google.common.collect.c.F(str, "string");
        if (!this.f7196c) {
            this.f7195b.M(str);
            x();
            return this;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // y3.g
    public final g s(int i4) {
        if (!this.f7196c) {
            this.f7195b.H(i4);
            x();
            return this;
        }
        throw new IllegalStateException("closed".toString());
    }

    public final String toString() {
        return "buffer(" + this.f7194a + ')';
    }

    @Override // java.nio.channels.WritableByteChannel
    public final int write(ByteBuffer byteBuffer) {
        com.google.common.collect.c.F(byteBuffer, "source");
        if (!this.f7196c) {
            int write = this.f7195b.write(byteBuffer);
            x();
            return write;
        }
        throw new IllegalStateException("closed".toString());
    }

    public final g x() {
        int i4;
        if (!this.f7196c) {
            f fVar = this.f7195b;
            long j4 = fVar.f7180b;
            if (j4 == 0) {
                j4 = 0;
            } else {
                p pVar = fVar.f7179a;
                com.google.common.collect.c.C(pVar);
                p pVar2 = pVar.f7206g;
                com.google.common.collect.c.C(pVar2);
                if (pVar2.f7202c < 8192 && pVar2.f7204e) {
                    j4 -= i4 - pVar2.f7201b;
                }
            }
            if (j4 > 0) {
                this.f7194a.f(fVar, j4);
            }
            return this;
        }
        throw new IllegalStateException("closed".toString());
    }

    public final g y(byte[] bArr, int i4, int i5) {
        com.google.common.collect.c.F(bArr, "source");
        if (!this.f7196c) {
            this.f7195b.F(bArr, i4, i5);
            x();
            return this;
        }
        throw new IllegalStateException("closed".toString());
    }
}