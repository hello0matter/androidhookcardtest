package t3;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayDeque;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.StreamResetException;

/* loaded from: classes.dex */
public final class z {

    /* renamed from: a  reason: collision with root package name */
    public final int f6833a;

    /* renamed from: b  reason: collision with root package name */
    public final s f6834b;

    /* renamed from: c  reason: collision with root package name */
    public long f6835c;

    /* renamed from: d  reason: collision with root package name */
    public long f6836d;

    /* renamed from: e  reason: collision with root package name */
    public long f6837e;

    /* renamed from: f  reason: collision with root package name */
    public long f6838f;

    /* renamed from: g  reason: collision with root package name */
    public final ArrayDeque f6839g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f6840h;

    /* renamed from: i  reason: collision with root package name */
    public final x f6841i;

    /* renamed from: j  reason: collision with root package name */
    public final w f6842j;

    /* renamed from: k  reason: collision with root package name */
    public final y f6843k;

    /* renamed from: l  reason: collision with root package name */
    public final y f6844l;

    /* renamed from: m  reason: collision with root package name */
    public ErrorCode f6845m;

    /* renamed from: n  reason: collision with root package name */
    public IOException f6846n;

    public z(int i4, s sVar, boolean z4, boolean z5, m3.m mVar) {
        this.f6833a = i4;
        this.f6834b = sVar;
        this.f6838f = sVar.f6795s.a();
        ArrayDeque arrayDeque = new ArrayDeque();
        this.f6839g = arrayDeque;
        this.f6841i = new x(this, sVar.f6794r.a(), z5);
        this.f6842j = new w(this, z4);
        this.f6843k = new y(this);
        this.f6844l = new y(this);
        if (mVar != null) {
            if (!g()) {
                arrayDeque.add(mVar);
                return;
            }
            throw new IllegalStateException("locally-initiated streams shouldn't have headers yet".toString());
        } else if (g()) {
        } else {
            throw new IllegalStateException("remotely-initiated streams should have headers".toString());
        }
    }

    public final void a() {
        boolean z4;
        boolean h4;
        byte[] bArr = n3.b.f5783a;
        synchronized (this) {
            try {
                x xVar = this.f6841i;
                if (!xVar.f6827b && xVar.f6830e) {
                    w wVar = this.f6842j;
                    if (wVar.f6822a || wVar.f6824c) {
                        z4 = true;
                        h4 = h();
                    }
                }
                z4 = false;
                h4 = h();
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z4) {
            c(ErrorCode.f6038g, null);
        } else if (!h4) {
            this.f6834b.A(this.f6833a);
        }
    }

    public final void b() {
        w wVar = this.f6842j;
        if (!wVar.f6824c) {
            if (!wVar.f6822a) {
                if (this.f6845m != null) {
                    IOException iOException = this.f6846n;
                    if (iOException == null) {
                        ErrorCode errorCode = this.f6845m;
                        com.google.common.collect.c.C(errorCode);
                        throw new StreamResetException(errorCode);
                    }
                    throw iOException;
                }
                return;
            }
            throw new IOException("stream finished");
        }
        throw new IOException("stream closed");
    }

    public final void c(ErrorCode errorCode, IOException iOException) {
        if (!d(errorCode, iOException)) {
            return;
        }
        s sVar = this.f6834b;
        sVar.getClass();
        sVar.f6801y.C(this.f6833a, errorCode);
    }

    public final boolean d(ErrorCode errorCode, IOException iOException) {
        byte[] bArr = n3.b.f5783a;
        synchronized (this) {
            if (this.f6845m != null) {
                return false;
            }
            this.f6845m = errorCode;
            this.f6846n = iOException;
            notifyAll();
            if (this.f6841i.f6827b) {
                if (this.f6842j.f6822a) {
                    return false;
                }
            }
            this.f6834b.A(this.f6833a);
            return true;
        }
    }

    public final void e(ErrorCode errorCode) {
        if (!d(errorCode, null)) {
            return;
        }
        this.f6834b.E(this.f6833a, errorCode);
    }

    public final w f() {
        synchronized (this) {
            if (!this.f6840h && !g()) {
                throw new IllegalStateException("reply before requesting the sink".toString());
            }
        }
        return this.f6842j;
    }

    public final boolean g() {
        boolean z4;
        if ((this.f6833a & 1) == 1) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (this.f6834b.f6777a == z4) {
            return true;
        }
        return false;
    }

    public final synchronized boolean h() {
        if (this.f6845m != null) {
            return false;
        }
        x xVar = this.f6841i;
        if (xVar.f6827b || xVar.f6830e) {
            w wVar = this.f6842j;
            if (wVar.f6822a || wVar.f6824c) {
                if (this.f6840h) {
                    return false;
                }
            }
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0021 A[Catch: all -> 0x0016, TryCatch #0 {all -> 0x0016, blocks: (B:4:0x0008, B:8:0x0010, B:13:0x0021, B:14:0x0025, B:11:0x0018), top: B:21:0x0008 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void i(m3.m r3, boolean r4) {
        /*
            r2 = this;
            java.lang.String r0 = "headers"
            com.google.common.collect.c.F(r3, r0)
            byte[] r0 = n3.b.f5783a
            monitor-enter(r2)
            boolean r0 = r2.f6840h     // Catch: java.lang.Throwable -> L16
            r1 = 1
            if (r0 == 0) goto L18
            if (r4 != 0) goto L10
            goto L18
        L10:
            t3.x r3 = r2.f6841i     // Catch: java.lang.Throwable -> L16
            r3.getClass()     // Catch: java.lang.Throwable -> L16
            goto L1f
        L16:
            r3 = move-exception
            goto L37
        L18:
            r2.f6840h = r1     // Catch: java.lang.Throwable -> L16
            java.util.ArrayDeque r0 = r2.f6839g     // Catch: java.lang.Throwable -> L16
            r0.add(r3)     // Catch: java.lang.Throwable -> L16
        L1f:
            if (r4 == 0) goto L25
            t3.x r3 = r2.f6841i     // Catch: java.lang.Throwable -> L16
            r3.f6827b = r1     // Catch: java.lang.Throwable -> L16
        L25:
            boolean r3 = r2.h()     // Catch: java.lang.Throwable -> L16
            r2.notifyAll()     // Catch: java.lang.Throwable -> L16
            monitor-exit(r2)
            if (r3 != 0) goto L36
            t3.s r3 = r2.f6834b
            int r4 = r2.f6833a
            r3.A(r4)
        L36:
            return
        L37:
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: t3.z.i(m3.m, boolean):void");
    }

    public final synchronized void j(ErrorCode errorCode) {
        if (this.f6845m == null) {
            this.f6845m = errorCode;
            notifyAll();
        }
    }

    public final void k() {
        try {
            wait();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        }
    }
}