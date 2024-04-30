package s3;

/* loaded from: classes.dex */
public final class g extends b {

    /* renamed from: d  reason: collision with root package name */
    public boolean f6552d;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f6538b) {
            return;
        }
        if (!this.f6552d) {
            x();
        }
        this.f6538b = true;
    }

    @Override // s3.b, y3.t
    public final long w(y3.f fVar, long j4) {
        com.google.common.collect.c.F(fVar, "sink");
        if (j4 >= 0) {
            if (!this.f6538b) {
                if (this.f6552d) {
                    return -1L;
                }
                long w4 = super.w(fVar, j4);
                if (w4 == -1) {
                    this.f6552d = true;
                    x();
                    return -1L;
                }
                return w4;
            }
            throw new IllegalStateException("closed".toString());
        }
        throw new IllegalArgumentException(("byteCount < 0: " + j4).toString());
    }
}