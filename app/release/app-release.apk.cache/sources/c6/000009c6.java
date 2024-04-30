package t3;

import okhttp3.internal.http2.ErrorCode;

/* loaded from: classes.dex */
public final class w implements y3.r {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f6822a;

    /* renamed from: b  reason: collision with root package name */
    public final y3.f f6823b = new Object();

    /* renamed from: c  reason: collision with root package name */
    public boolean f6824c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ z f6825d;

    /* JADX WARN: Type inference failed for: r1v1, types: [y3.f, java.lang.Object] */
    public w(z zVar, boolean z4) {
        this.f6825d = zVar;
        this.f6822a = z4;
    }

    @Override // y3.r
    public final y3.v a() {
        return this.f6825d.f6844l;
    }

    @Override // y3.r, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        boolean z4;
        z zVar = this.f6825d;
        byte[] bArr = n3.b.f5783a;
        synchronized (zVar) {
            if (this.f6824c) {
                return;
            }
            synchronized (zVar) {
                ErrorCode errorCode = zVar.f6845m;
                if (errorCode == null) {
                    z4 = true;
                } else {
                    z4 = false;
                }
            }
            z zVar2 = this.f6825d;
            if (!zVar2.f6842j.f6822a) {
                if (this.f6823b.f7180b > 0) {
                    while (this.f6823b.f7180b > 0) {
                        x(true);
                    }
                } else if (z4) {
                    zVar2.f6834b.D(zVar2.f6833a, true, null, 0L);
                }
            }
            synchronized (this.f6825d) {
                this.f6824c = true;
            }
            this.f6825d.f6834b.flush();
            this.f6825d.a();
        }
    }

    @Override // y3.r
    public final void f(y3.f fVar, long j4) {
        com.google.common.collect.c.F(fVar, "source");
        byte[] bArr = n3.b.f5783a;
        y3.f fVar2 = this.f6823b;
        fVar2.f(fVar, j4);
        while (fVar2.f7180b >= 16384) {
            x(false);
        }
    }

    @Override // y3.r, java.io.Flushable
    public final void flush() {
        z zVar = this.f6825d;
        byte[] bArr = n3.b.f5783a;
        synchronized (zVar) {
            zVar.b();
        }
        while (this.f6823b.f7180b > 0) {
            x(false);
            this.f6825d.f6834b.flush();
        }
    }

    public final void x(boolean z4) {
        long min;
        boolean z5;
        boolean z6;
        z zVar = this.f6825d;
        synchronized (zVar) {
            zVar.f6844l.h();
            while (zVar.f6837e >= zVar.f6838f && !this.f6822a && !this.f6824c) {
                synchronized (zVar) {
                    ErrorCode errorCode = zVar.f6845m;
                    if (errorCode != null) {
                        break;
                    }
                    zVar.k();
                }
            }
            zVar.f6844l.l();
            zVar.b();
            min = Math.min(zVar.f6838f - zVar.f6837e, this.f6823b.f7180b);
            zVar.f6837e += min;
            if (z4) {
                if (min == this.f6823b.f7180b) {
                    z5 = true;
                    z6 = z5;
                }
            }
            z5 = false;
            z6 = z5;
        }
        this.f6825d.f6844l.h();
        try {
            z zVar2 = this.f6825d;
            zVar2.f6834b.D(zVar2.f6833a, z6, this.f6823b, min);
        } finally {
            this.f6825d.f6844l.l();
        }
    }
}