package q3;

import androidx.appcompat.app.o0;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;
import m3.o;

/* loaded from: classes.dex */
public final class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final o0 f6392a;

    /* renamed from: b  reason: collision with root package name */
    public volatile AtomicInteger f6393b = new AtomicInteger(0);

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ j f6394c;

    public g(j jVar, o0 o0Var) {
        this.f6394c = jVar;
        this.f6392a = o0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        t.d dVar;
        j jVar = this.f6394c;
        Thread currentThread = Thread.currentThread();
        String name = currentThread.getName();
        currentThread.setName("OkHttp " + ((o) this.f6394c.f6398b.f989b).f());
        try {
            jVar.f6402f.h();
            boolean z4 = false;
            try {
            } catch (IOException e4) {
                e = e4;
            } catch (Throwable th) {
                th = th;
            }
            try {
                this.f6392a.u(jVar.f());
                dVar = jVar.f6397a.f5577a;
            } catch (IOException e5) {
                e = e5;
                z4 = true;
                if (z4) {
                    u3.l lVar = u3.l.f6934a;
                    u3.l.f6934a.getClass();
                    u3.l.i("Callback failure for " + j.a(jVar), 4, e);
                } else {
                    ((CompletableFuture) this.f6392a.f311b).completeExceptionally(e);
                }
                dVar = jVar.f6397a.f5577a;
                dVar.b(this);
            } catch (Throwable th2) {
                th = th2;
                z4 = true;
                jVar.d();
                if (!z4) {
                    IOException iOException = new IOException("canceled due to " + th);
                    kotlin.a.a(iOException, th);
                    ((CompletableFuture) this.f6392a.f311b).completeExceptionally(iOException);
                }
                throw th;
            }
            dVar.b(this);
        } finally {
            currentThread.setName(name);
        }
    }
}