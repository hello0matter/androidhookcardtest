package q3;

import java.io.IOException;
import java.net.ProtocolException;
import y3.r;
import y3.v;

/* loaded from: classes.dex */
public final class c implements r {

    /* renamed from: a  reason: collision with root package name */
    public final r f6362a;

    /* renamed from: b  reason: collision with root package name */
    public final long f6363b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f6364c;

    /* renamed from: d  reason: collision with root package name */
    public long f6365d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f6366e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ e f6367f;

    public c(e eVar, r rVar, long j4) {
        com.google.common.collect.c.F(rVar, "delegate");
        this.f6367f = eVar;
        this.f6362a = rVar;
        this.f6363b = j4;
    }

    /* renamed from: A */
    public final String toString() {
        return c.class.getSimpleName() + '(' + this.f6362a + ')';
    }

    @Override // y3.r
    public final v a() {
        return this.f6362a.a();
    }

    @Override // y3.r, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f6366e) {
            return;
        }
        this.f6366e = true;
        long j4 = this.f6363b;
        if (j4 != -1 && this.f6365d != j4) {
            throw new ProtocolException("unexpected end of stream");
        }
        try {
            x();
            y(null);
        } catch (IOException e4) {
            throw y(e4);
        }
    }

    @Override // y3.r
    public final void f(y3.f fVar, long j4) {
        com.google.common.collect.c.F(fVar, "source");
        if (!this.f6366e) {
            long j5 = this.f6363b;
            if (j5 != -1 && this.f6365d + j4 > j5) {
                throw new ProtocolException("expected " + j5 + " bytes but received " + (this.f6365d + j4));
            }
            try {
                this.f6362a.f(fVar, j4);
                this.f6365d += j4;
                return;
            } catch (IOException e4) {
                throw y(e4);
            }
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // y3.r, java.io.Flushable
    public final void flush() {
        try {
            z();
        } catch (IOException e4) {
            throw y(e4);
        }
    }

    public final void x() {
        this.f6362a.close();
    }

    public final IOException y(IOException iOException) {
        if (this.f6364c) {
            return iOException;
        }
        this.f6364c = true;
        return this.f6367f.a(false, true, iOException);
    }

    public final void z() {
        this.f6362a.flush();
    }
}