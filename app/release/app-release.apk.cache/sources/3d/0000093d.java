package p3;

import java.util.logging.Level;

/* loaded from: classes.dex */
public final class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ f f6158a;

    public e(f fVar) {
        this.f6158a = fVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a c4;
        long j4;
        while (true) {
            f fVar = this.f6158a;
            synchronized (fVar) {
                c4 = fVar.c();
            }
            if (c4 == null) {
                return;
            }
            c cVar = c4.f6147c;
            com.google.common.collect.c.C(cVar);
            f fVar2 = this.f6158a;
            boolean isLoggable = f.f6161j.isLoggable(Level.FINE);
            if (isLoggable) {
                cVar.f6151a.f6162a.getClass();
                j4 = System.nanoTime();
                com.google.common.collect.c.j(c4, cVar, "starting");
            } else {
                j4 = -1;
            }
            try {
                f.a(fVar2, c4);
                if (isLoggable) {
                    cVar.f6151a.f6162a.getClass();
                    com.google.common.collect.c.j(c4, cVar, "finished run in ".concat(com.google.common.collect.c.m0(System.nanoTime() - j4)));
                }
            } finally {
            }
        }
    }
}