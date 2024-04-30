package y3;

import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes.dex */
public final class b extends Thread {
    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        ReentrantLock reentrantLock;
        e c4;
        while (true) {
            try {
                reentrantLock = e.f7171h;
                reentrantLock.lock();
                c4 = t3.a.c();
            } catch (InterruptedException unused) {
            }
            if (c4 == e.f7175l) {
                e.f7175l = null;
                reentrantLock.unlock();
                return;
            }
            reentrantLock.unlock();
            if (c4 != null) {
                c4.k();
            }
        }
    }
}