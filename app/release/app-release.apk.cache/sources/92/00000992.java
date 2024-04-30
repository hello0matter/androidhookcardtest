package s3;

import y3.i;
import y3.r;
import y3.v;

/* loaded from: classes.dex */
public final class c implements r {

    /* renamed from: a  reason: collision with root package name */
    public final i f6540a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f6541b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ h f6542c;

    public c(h hVar) {
        this.f6542c = hVar;
        this.f6540a = new i(hVar.f6556d.a());
    }

    @Override // y3.r
    public final v a() {
        return this.f6540a;
    }

    @Override // y3.r, java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        if (this.f6541b) {
            return;
        }
        this.f6541b = true;
        this.f6542c.f6556d.p("0\r\n\r\n");
        h hVar = this.f6542c;
        i iVar = this.f6540a;
        hVar.getClass();
        v vVar = iVar.f7181e;
        iVar.f7181e = v.f7211d;
        vVar.a();
        vVar.b();
        this.f6542c.f6557e = 3;
    }

    @Override // y3.r
    public final void f(y3.f fVar, long j4) {
        com.google.common.collect.c.F(fVar, "source");
        if (!this.f6541b) {
            if (j4 == 0) {
                return;
            }
            h hVar = this.f6542c;
            hVar.f6556d.d(j4);
            y3.g gVar = hVar.f6556d;
            gVar.p("\r\n");
            gVar.f(fVar, j4);
            gVar.p("\r\n");
            return;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // y3.r, java.io.Flushable
    public final synchronized void flush() {
        if (this.f6541b) {
            return;
        }
        this.f6542c.f6556d.flush();
    }
}