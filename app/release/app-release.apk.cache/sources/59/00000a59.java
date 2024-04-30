package y3;

import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes.dex */
public final class c implements r {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f7165a = 1;

    /* renamed from: b  reason: collision with root package name */
    public final Object f7166b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f7167c;

    public c(OutputStream outputStream, s sVar) {
        this.f7166b = outputStream;
        this.f7167c = sVar;
    }

    @Override // y3.r
    public final v a() {
        switch (this.f7165a) {
            case 0:
                return (e) this.f7166b;
            default:
                return (v) this.f7167c;
        }
    }

    @Override // y3.r, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        int i4 = this.f7165a;
        Object obj = this.f7166b;
        switch (i4) {
            case 0:
                e eVar = (e) obj;
                r rVar = (r) this.f7167c;
                eVar.h();
                try {
                    rVar.close();
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
                ((OutputStream) obj).close();
                return;
        }
    }

    @Override // y3.r
    public final void f(f fVar, long j4) {
        int i4 = this.f7165a;
        Object obj = this.f7166b;
        Object obj2 = this.f7167c;
        switch (i4) {
            case 0:
                com.google.common.collect.c.F(fVar, "source");
                com.google.common.collect.c.G(fVar.f7180b, 0L, j4);
                while (j4 > 0) {
                    p pVar = fVar.f7179a;
                    com.google.common.collect.c.C(pVar);
                    long j5 = 0;
                    while (true) {
                        if (j5 < 65536) {
                            j5 += pVar.f7202c - pVar.f7201b;
                            if (j5 >= j4) {
                                j5 = j4;
                            } else {
                                pVar = pVar.f7205f;
                                com.google.common.collect.c.C(pVar);
                            }
                        }
                    }
                    e eVar = (e) obj;
                    r rVar = (r) obj2;
                    eVar.h();
                    try {
                        rVar.f(fVar, j5);
                        if (!eVar.i()) {
                            j4 -= j5;
                        } else {
                            throw eVar.j(null);
                        }
                    } catch (IOException e4) {
                        if (!eVar.i()) {
                            throw e4;
                        }
                        throw eVar.j(e4);
                    } finally {
                        eVar.i();
                    }
                }
                return;
            default:
                com.google.common.collect.c.F(fVar, "source");
                com.google.common.collect.c.G(fVar.f7180b, 0L, j4);
                while (j4 > 0) {
                    ((v) obj2).f();
                    p pVar2 = fVar.f7179a;
                    com.google.common.collect.c.C(pVar2);
                    int min = (int) Math.min(j4, pVar2.f7202c - pVar2.f7201b);
                    ((OutputStream) obj).write(pVar2.f7200a, pVar2.f7201b, min);
                    int i5 = pVar2.f7201b + min;
                    pVar2.f7201b = i5;
                    long j6 = min;
                    j4 -= j6;
                    fVar.f7180b -= j6;
                    if (i5 == pVar2.f7202c) {
                        fVar.f7179a = pVar2.a();
                        q.a(pVar2);
                    }
                }
                return;
        }
    }

    @Override // y3.r, java.io.Flushable
    public final void flush() {
        int i4 = this.f7165a;
        Object obj = this.f7166b;
        switch (i4) {
            case 0:
                e eVar = (e) obj;
                r rVar = (r) this.f7167c;
                eVar.h();
                try {
                    rVar.flush();
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
                ((OutputStream) obj).flush();
                return;
        }
    }

    public final String toString() {
        switch (this.f7165a) {
            case 0:
                return "AsyncTimeout.sink(" + ((r) this.f7167c) + ')';
            default:
                return "sink(" + ((OutputStream) this.f7166b) + ')';
        }
    }

    public c(s sVar, c cVar) {
        this.f7166b = sVar;
        this.f7167c = cVar;
    }
}