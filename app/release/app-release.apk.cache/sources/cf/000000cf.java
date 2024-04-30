package androidx.appcompat.app;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class m0 implements Executor {

    /* renamed from: a  reason: collision with root package name */
    public final Object f302a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public final ArrayDeque f303b = new ArrayDeque();

    /* renamed from: c  reason: collision with root package name */
    public final Executor f304c;

    /* renamed from: d  reason: collision with root package name */
    public Runnable f305d;

    public m0(n0 n0Var) {
        this.f304c = n0Var;
    }

    public final void a() {
        synchronized (this.f302a) {
            try {
                Runnable runnable = (Runnable) this.f303b.poll();
                this.f305d = runnable;
                if (runnable != null) {
                    this.f304c.execute(runnable);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        synchronized (this.f302a) {
            try {
                this.f303b.add(new l0(0, this, runnable));
                if (this.f305d == null) {
                    a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}