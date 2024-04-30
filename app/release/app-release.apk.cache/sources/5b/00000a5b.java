package y3;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes.dex */
public class e extends v {

    /* renamed from: h  reason: collision with root package name */
    public static final ReentrantLock f7171h;

    /* renamed from: i  reason: collision with root package name */
    public static final Condition f7172i;

    /* renamed from: j  reason: collision with root package name */
    public static final long f7173j;

    /* renamed from: k  reason: collision with root package name */
    public static final long f7174k;

    /* renamed from: l  reason: collision with root package name */
    public static e f7175l;

    /* renamed from: e  reason: collision with root package name */
    public boolean f7176e;

    /* renamed from: f  reason: collision with root package name */
    public e f7177f;

    /* renamed from: g  reason: collision with root package name */
    public long f7178g;

    static {
        ReentrantLock reentrantLock = new ReentrantLock();
        f7171h = reentrantLock;
        Condition newCondition = reentrantLock.newCondition();
        com.google.common.collect.c.E(newCondition, "newCondition(...)");
        f7172i = newCondition;
        long millis = TimeUnit.SECONDS.toMillis(60L);
        f7173j = millis;
        f7174k = TimeUnit.MILLISECONDS.toNanos(millis);
    }

    /* JADX WARN: Type inference failed for: r5v4, types: [y3.e, java.lang.Object] */
    public final void h() {
        long c4;
        e eVar;
        long j4 = this.f7214c;
        boolean z4 = this.f7212a;
        int i4 = (j4 > 0L ? 1 : (j4 == 0L ? 0 : -1));
        if (i4 == 0 && !z4) {
            return;
        }
        ReentrantLock reentrantLock = f7171h;
        reentrantLock.lock();
        try {
            if (!this.f7176e) {
                this.f7176e = true;
                if (f7175l == null) {
                    f7175l = new Object();
                    Thread thread = new Thread("Okio Watchdog");
                    thread.setDaemon(true);
                    thread.start();
                }
                long nanoTime = System.nanoTime();
                if (i4 != 0 && z4) {
                    c4 = Math.min(j4, c() - nanoTime) + nanoTime;
                } else if (i4 != 0) {
                    c4 = j4 + nanoTime;
                } else if (z4) {
                    c4 = c();
                } else {
                    throw new AssertionError();
                }
                this.f7178g = c4;
                long j5 = this.f7178g - nanoTime;
                e eVar2 = f7175l;
                com.google.common.collect.c.C(eVar2);
                while (true) {
                    eVar = eVar2.f7177f;
                    if (eVar == null || j5 < eVar.f7178g - nanoTime) {
                        break;
                    }
                    eVar2 = eVar;
                }
                this.f7177f = eVar;
                eVar2.f7177f = this;
                if (eVar2 == f7175l) {
                    f7172i.signal();
                }
                reentrantLock.unlock();
                return;
            }
            throw new IllegalStateException("Unbalanced enter/exit".toString());
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final boolean i() {
        ReentrantLock reentrantLock = f7171h;
        reentrantLock.lock();
        try {
            if (this.f7176e) {
                this.f7176e = false;
                e eVar = f7175l;
                while (eVar != null) {
                    e eVar2 = eVar.f7177f;
                    if (eVar2 == this) {
                        eVar.f7177f = this.f7177f;
                        this.f7177f = null;
                    } else {
                        eVar = eVar2;
                    }
                }
                reentrantLock.unlock();
                return true;
            }
            return false;
        } finally {
            reentrantLock.unlock();
        }
    }

    public IOException j(IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    public void k() {
    }
}