package y3;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public final class d implements t {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f7168a = 1;

    /* renamed from: b  reason: collision with root package name */
    public final Object f7169b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f7170c;

    public d(InputStream inputStream, v vVar) {
        this.f7169b = inputStream;
        this.f7170c = vVar;
    }

    @Override // y3.t
    public final v a() {
        switch (this.f7168a) {
            case 0:
                return (e) this.f7169b;
            default:
                return (v) this.f7170c;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        int i4 = this.f7168a;
        Object obj = this.f7169b;
        switch (i4) {
            case 0:
                e eVar = (e) obj;
                t tVar = (t) this.f7170c;
                eVar.h();
                try {
                    tVar.close();
                    if (!eVar.i()) {
                        return;
                    }
                    throw eVar.j(null);
                } catch (IOException e4) {
                    if (!eVar.i()) {
                        throw e4;
                    }
                    throw eVar.j(e4);
                } finally {
                    eVar.i();
                }
            default:
                ((InputStream) obj).close();
                return;
        }
    }

    public final String toString() {
        switch (this.f7168a) {
            case 0:
                return "AsyncTimeout.source(" + ((t) this.f7170c) + ')';
            default:
                return "source(" + ((InputStream) this.f7169b) + ')';
        }
    }

    @Override // y3.t
    public final long w(f fVar, long j4) {
        int i4 = this.f7168a;
        Object obj = this.f7169b;
        Object obj2 = this.f7170c;
        switch (i4) {
            case 0:
                com.google.common.collect.c.F(fVar, "sink");
                e eVar = (e) obj;
                t tVar = (t) obj2;
                eVar.h();
                try {
                    long w4 = tVar.w(fVar, j4);
                    if (!eVar.i()) {
                        return w4;
                    }
                    throw eVar.j(null);
                } catch (IOException e4) {
                    if (!eVar.i()) {
                        throw e4;
                    }
                    throw eVar.j(e4);
                } finally {
                    eVar.i();
                }
            default:
                com.google.common.collect.c.F(fVar, "sink");
                int i5 = (j4 > 0L ? 1 : (j4 == 0L ? 0 : -1));
                if (i5 == 0) {
                    return 0L;
                }
                if (i5 >= 0) {
                    try {
                        ((v) obj2).f();
                        p D = fVar.D(1);
                        int read = ((InputStream) obj).read(D.f7200a, D.f7202c, (int) Math.min(j4, 8192 - D.f7202c));
                        if (read == -1) {
                            if (D.f7201b == D.f7202c) {
                                fVar.f7179a = D.a();
                                q.a(D);
                            }
                            return -1L;
                        }
                        D.f7202c += read;
                        long j5 = read;
                        fVar.f7180b += j5;
                        return j5;
                    } catch (AssertionError e5) {
                        if (com.google.common.collect.c.V0(e5)) {
                            throw new IOException(e5);
                        }
                        throw e5;
                    }
                }
                throw new IllegalArgumentException(("byteCount < 0: " + j4).toString());
        }
    }

    public d(s sVar, d dVar) {
        this.f7169b = sVar;
        this.f7170c = dVar;
    }
}