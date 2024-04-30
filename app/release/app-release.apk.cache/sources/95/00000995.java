package s3;

import y3.i;
import y3.r;
import y3.v;

/* loaded from: classes.dex */
public final class f implements r {

    /* renamed from: a  reason: collision with root package name */
    public final i f6549a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f6550b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ h f6551c;

    public f(h hVar) {
        this.f6551c = hVar;
        this.f6549a = new i(hVar.f6556d.a());
    }

    @Override // y3.r
    public final v a() {
        return this.f6549a;
    }

    @Override // y3.r, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f6550b) {
            return;
        }
        this.f6550b = true;
        h hVar = this.f6551c;
        hVar.getClass();
        i iVar = this.f6549a;
        v vVar = iVar.f7181e;
        iVar.f7181e = v.f7211d;
        vVar.a();
        vVar.b();
        hVar.f6557e = 3;
    }

    @Override // y3.r
    public final void f(y3.f fVar, long j4) {
        com.google.common.collect.c.F(fVar, "source");
        if (!this.f6550b) {
            n3.b.c(fVar.f7180b, 0L, j4);
            this.f6551c.f6556d.f(fVar, j4);
            return;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // y3.r, java.io.Flushable
    public final void flush() {
        if (this.f6550b) {
            return;
        }
        this.f6551c.f6556d.flush();
    }
}