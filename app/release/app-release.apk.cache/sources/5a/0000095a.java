package q3;

import java.io.IOException;
import java.net.ProtocolException;
import y3.t;
import y3.v;

/* loaded from: classes.dex */
public final class d implements t {

    /* renamed from: a  reason: collision with root package name */
    public final t f6368a;

    /* renamed from: b  reason: collision with root package name */
    public final long f6369b;

    /* renamed from: c  reason: collision with root package name */
    public long f6370c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f6371d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f6372e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f6373f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ e f6374g;

    public d(e eVar, t tVar, long j4) {
        com.google.common.collect.c.F(tVar, "delegate");
        this.f6374g = eVar;
        this.f6368a = tVar;
        this.f6369b = j4;
        this.f6371d = true;
        if (j4 == 0) {
            y(null);
        }
    }

    @Override // y3.t
    public final v a() {
        return this.f6368a.a();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f6373f) {
            return;
        }
        this.f6373f = true;
        try {
            x();
            y(null);
        } catch (IOException e4) {
            throw y(e4);
        }
    }

    @Override // y3.t
    public final long w(y3.f fVar, long j4) {
        com.google.common.collect.c.F(fVar, "sink");
        if (!this.f6373f) {
            try {
                long w4 = this.f6368a.w(fVar, j4);
                if (this.f6371d) {
                    this.f6371d = false;
                    e eVar = this.f6374g;
                    m3.k kVar = eVar.f6376b;
                    j jVar = eVar.f6375a;
                    kVar.getClass();
                    com.google.common.collect.c.F(jVar, "call");
                }
                if (w4 == -1) {
                    y(null);
                    return -1L;
                }
                long j5 = this.f6370c + w4;
                long j6 = this.f6369b;
                if (j6 != -1 && j5 > j6) {
                    throw new ProtocolException("expected " + j6 + " bytes but received " + j5);
                }
                this.f6370c = j5;
                if (j5 == j6) {
                    y(null);
                }
                return w4;
            } catch (IOException e4) {
                throw y(e4);
            }
        }
        throw new IllegalStateException("closed".toString());
    }

    public final void x() {
        this.f6368a.close();
    }

    public final IOException y(IOException iOException) {
        if (this.f6372e) {
            return iOException;
        }
        this.f6372e = true;
        e eVar = this.f6374g;
        if (iOException == null && this.f6371d) {
            this.f6371d = false;
            eVar.f6376b.getClass();
            com.google.common.collect.c.F(eVar.f6375a, "call");
        }
        return eVar.a(true, false, iOException);
    }

    /* renamed from: z */
    public final String toString() {
        return d.class.getSimpleName() + '(' + this.f6368a + ')';
    }
}