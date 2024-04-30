package q3;

import java.io.IOException;
import m3.v;
import m3.w;
import m3.x;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.StreamResetException;
import y3.o;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public final j f6375a;

    /* renamed from: b  reason: collision with root package name */
    public final m3.k f6376b;

    /* renamed from: c  reason: collision with root package name */
    public final f f6377c;

    /* renamed from: d  reason: collision with root package name */
    public final r3.d f6378d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f6379e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f6380f;

    /* renamed from: g  reason: collision with root package name */
    public final okhttp3.internal.connection.a f6381g;

    public e(j jVar, m3.k kVar, f fVar, r3.d dVar) {
        com.google.common.collect.c.F(kVar, "eventListener");
        this.f6375a = jVar;
        this.f6376b = kVar;
        this.f6377c = fVar;
        this.f6378d = dVar;
        this.f6381g = dVar.h();
    }

    public final IOException a(boolean z4, boolean z5, IOException iOException) {
        if (iOException != null) {
            d(iOException);
        }
        m3.k kVar = this.f6376b;
        j jVar = this.f6375a;
        if (z5) {
            kVar.getClass();
            if (iOException != null) {
                com.google.common.collect.c.F(jVar, "call");
            } else {
                com.google.common.collect.c.F(jVar, "call");
            }
        }
        if (z4) {
            kVar.getClass();
            if (iOException != null) {
                com.google.common.collect.c.F(jVar, "call");
            } else {
                com.google.common.collect.c.F(jVar, "call");
            }
        }
        return jVar.g(this, z5, z4, iOException);
    }

    public final x b(w wVar) {
        r3.d dVar = this.f6378d;
        try {
            String x4 = w.x(wVar, "Content-Type");
            long d4 = dVar.d(wVar);
            return new x(x4, d4, new o(new d(this, dVar.a(wVar), d4)));
        } catch (IOException e4) {
            this.f6376b.getClass();
            com.google.common.collect.c.F(this.f6375a, "call");
            d(e4);
            throw e4;
        }
    }

    public final v c(boolean z4) {
        try {
            v f4 = this.f6378d.f(z4);
            if (f4 != null) {
                f4.f5623m = this;
            }
            return f4;
        } catch (IOException e4) {
            this.f6376b.getClass();
            com.google.common.collect.c.F(this.f6375a, "call");
            d(e4);
            throw e4;
        }
    }

    public final void d(IOException iOException) {
        int i4;
        this.f6380f = true;
        this.f6377c.c(iOException);
        okhttp3.internal.connection.a h4 = this.f6378d.h();
        j jVar = this.f6375a;
        synchronized (h4) {
            try {
                com.google.common.collect.c.F(jVar, "call");
                if (iOException instanceof StreamResetException) {
                    if (((StreamResetException) iOException).f6041a == ErrorCode.f6037f) {
                        int i5 = h4.f6029n + 1;
                        h4.f6029n = i5;
                        if (i5 > 1) {
                            h4.f6025j = true;
                            h4.f6027l++;
                        }
                    } else if (((StreamResetException) iOException).f6041a != ErrorCode.f6038g || !jVar.f6412p) {
                        h4.f6025j = true;
                        i4 = h4.f6027l;
                        h4.f6027l = i4 + 1;
                    }
                } else if (h4.f6022g == null || (iOException instanceof ConnectionShutdownException)) {
                    h4.f6025j = true;
                    if (h4.f6028m == 0) {
                        okhttp3.internal.connection.a.d(jVar.f6397a, h4.f6017b, iOException);
                        i4 = h4.f6027l;
                        h4.f6027l = i4 + 1;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}