package y3;

import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class v {

    /* renamed from: d  reason: collision with root package name */
    public static final u f7211d = new Object();

    /* renamed from: a  reason: collision with root package name */
    public boolean f7212a;

    /* renamed from: b  reason: collision with root package name */
    public long f7213b;

    /* renamed from: c  reason: collision with root package name */
    public long f7214c;

    public v a() {
        this.f7212a = false;
        return this;
    }

    public v b() {
        this.f7214c = 0L;
        return this;
    }

    public long c() {
        if (this.f7212a) {
            return this.f7213b;
        }
        throw new IllegalStateException("No deadline".toString());
    }

    public v d(long j4) {
        this.f7212a = true;
        this.f7213b = j4;
        return this;
    }

    public boolean e() {
        return this.f7212a;
    }

    public void f() {
        if (!Thread.currentThread().isInterrupted()) {
            if (this.f7212a && this.f7213b - System.nanoTime() <= 0) {
                throw new InterruptedIOException("deadline reached");
            }
            return;
        }
        throw new InterruptedIOException("interrupted");
    }

    public v g(long j4, TimeUnit timeUnit) {
        com.google.common.collect.c.F(timeUnit, "unit");
        if (j4 >= 0) {
            this.f7214c = timeUnit.toNanos(j4);
            return this;
        }
        throw new IllegalArgumentException(("timeout < 0: " + j4).toString());
    }
}