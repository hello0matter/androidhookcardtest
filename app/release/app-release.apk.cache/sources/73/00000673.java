package e0;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public boolean f4422a;

    /* renamed from: b  reason: collision with root package name */
    public b f4423b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f4424c;

    public final void a() {
        synchronized (this) {
            try {
                if (this.f4422a) {
                    return;
                }
                this.f4422a = true;
                this.f4424c = true;
                b bVar = this.f4423b;
                if (bVar != null) {
                    try {
                        bVar.a();
                    } catch (Throwable th) {
                        synchronized (this) {
                            this.f4424c = false;
                            notifyAll();
                            throw th;
                        }
                    }
                }
                synchronized (this) {
                    this.f4424c = false;
                    notifyAll();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void b(b bVar) {
        synchronized (this) {
            while (this.f4424c) {
                try {
                    try {
                        wait();
                    } catch (InterruptedException unused) {
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (this.f4423b == bVar) {
                return;
            }
            this.f4423b = bVar;
            if (this.f4422a) {
                bVar.a();
            }
        }
    }
}