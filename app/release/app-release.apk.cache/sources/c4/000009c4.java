package t3;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import okio.ByteString;

/* loaded from: classes.dex */
public final class u implements y3.t {

    /* renamed from: a  reason: collision with root package name */
    public final y3.h f6811a;

    /* renamed from: b  reason: collision with root package name */
    public int f6812b;

    /* renamed from: c  reason: collision with root package name */
    public int f6813c;

    /* renamed from: d  reason: collision with root package name */
    public int f6814d;

    /* renamed from: e  reason: collision with root package name */
    public int f6815e;

    /* renamed from: f  reason: collision with root package name */
    public int f6816f;

    public u(y3.h hVar) {
        this.f6811a = hVar;
    }

    @Override // y3.t
    public final y3.v a() {
        return this.f6811a.a();
    }

    @Override // y3.t
    public final long w(y3.f fVar, long j4) {
        int i4;
        int k4;
        com.google.common.collect.c.F(fVar, "sink");
        do {
            int i5 = this.f6815e;
            y3.h hVar = this.f6811a;
            if (i5 == 0) {
                hVar.h(this.f6816f);
                this.f6816f = 0;
                if ((this.f6813c & 4) != 0) {
                    return -1L;
                }
                i4 = this.f6814d;
                int t4 = n3.b.t(hVar);
                this.f6815e = t4;
                this.f6812b = t4;
                int v2 = hVar.v() & 255;
                this.f6813c = hVar.v() & 255;
                Logger logger = v.f6817e;
                if (logger.isLoggable(Level.FINE)) {
                    ByteString byteString = f.f6736a;
                    logger.fine(f.a(true, this.f6814d, this.f6812b, v2, this.f6813c));
                }
                k4 = hVar.k() & Integer.MAX_VALUE;
                this.f6814d = k4;
                if (v2 != 9) {
                    throw new IOException(v2 + " != TYPE_CONTINUATION");
                }
            } else {
                long w4 = hVar.w(fVar, Math.min(j4, i5));
                if (w4 == -1) {
                    return -1L;
                }
                this.f6815e -= (int) w4;
                return w4;
            }
        } while (k4 == i4);
        throw new IOException("TYPE_CONTINUATION streamId changed");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }
}