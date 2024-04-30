package s3;

import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class e extends b {

    /* renamed from: d  reason: collision with root package name */
    public long f6547d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ h f6548e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(h hVar, long j4) {
        super(hVar);
        this.f6548e = hVar;
        this.f6547d = j4;
        if (j4 == 0) {
            x();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f6538b) {
            return;
        }
        if (this.f6547d != 0 && !n3.b.h(this, TimeUnit.MILLISECONDS)) {
            this.f6548e.f6554b.k();
            x();
        }
        this.f6538b = true;
    }

    @Override // s3.b, y3.t
    public final long w(y3.f fVar, long j4) {
        com.google.common.collect.c.F(fVar, "sink");
        if (j4 >= 0) {
            if (!this.f6538b) {
                long j5 = this.f6547d;
                if (j5 == 0) {
                    return -1L;
                }
                long w4 = super.w(fVar, Math.min(j5, j4));
                if (w4 != -1) {
                    long j6 = this.f6547d - w4;
                    this.f6547d = j6;
                    if (j6 == 0) {
                        x();
                    }
                    return w4;
                }
                this.f6548e.f6554b.k();
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                x();
                throw protocolException;
            }
            throw new IllegalStateException("closed".toString());
        }
        throw new IllegalArgumentException(("byteCount < 0: " + j4).toString());
    }
}