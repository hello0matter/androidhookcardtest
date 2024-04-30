package p3;

import androidx.activity.j;
import androidx.fragment.app.m0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: h  reason: collision with root package name */
    public static final m0 f6159h = new Object();

    /* renamed from: i  reason: collision with root package name */
    public static final f f6160i;

    /* renamed from: j  reason: collision with root package name */
    public static final Logger f6161j;

    /* renamed from: a  reason: collision with root package name */
    public final d f6162a;

    /* renamed from: c  reason: collision with root package name */
    public boolean f6164c;

    /* renamed from: d  reason: collision with root package name */
    public long f6165d;

    /* renamed from: b  reason: collision with root package name */
    public int f6163b = 10000;

    /* renamed from: e  reason: collision with root package name */
    public final ArrayList f6166e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public final ArrayList f6167f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    public final e f6168g = new e(this);

    /* JADX WARN: Type inference failed for: r0v0, types: [androidx.fragment.app.m0, java.lang.Object] */
    static {
        String str = n3.b.f5789g + " TaskRunner";
        com.google.common.collect.c.F(str, "name");
        f6160i = new f(new d(new n3.a(str, true)));
        Logger logger = Logger.getLogger(f.class.getName());
        com.google.common.collect.c.E(logger, "getLogger(TaskRunner::class.java.name)");
        f6161j = logger;
    }

    public f(d dVar) {
        this.f6162a = dVar;
    }

    public static final void a(f fVar, a aVar) {
        fVar.getClass();
        byte[] bArr = n3.b.f5783a;
        Thread currentThread = Thread.currentThread();
        String name = currentThread.getName();
        currentThread.setName(aVar.f6145a);
        try {
            long a5 = aVar.a();
            synchronized (fVar) {
                fVar.b(aVar, a5);
            }
            currentThread.setName(name);
        } catch (Throwable th) {
            synchronized (fVar) {
                fVar.b(aVar, -1L);
                currentThread.setName(name);
                throw th;
            }
        }
    }

    public final void b(a aVar, long j4) {
        byte[] bArr = n3.b.f5783a;
        c cVar = aVar.f6147c;
        com.google.common.collect.c.C(cVar);
        if (cVar.f6154d == aVar) {
            boolean z4 = cVar.f6156f;
            cVar.f6156f = false;
            cVar.f6154d = null;
            this.f6166e.remove(cVar);
            if (j4 != -1 && !z4 && !cVar.f6153c) {
                cVar.d(aVar, j4, true);
            }
            if (!cVar.f6155e.isEmpty()) {
                this.f6167f.add(cVar);
                return;
            }
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public final a c() {
        boolean z4;
        boolean z5;
        long j4;
        long j5;
        byte[] bArr = n3.b.f5783a;
        while (true) {
            ArrayList arrayList = this.f6167f;
            if (arrayList.isEmpty()) {
                return null;
            }
            d dVar = this.f6162a;
            dVar.getClass();
            long nanoTime = System.nanoTime();
            Iterator it = arrayList.iterator();
            long j6 = Long.MAX_VALUE;
            a aVar = null;
            while (true) {
                if (it.hasNext()) {
                    a aVar2 = (a) ((c) it.next()).f6155e.get(0);
                    long max = Math.max(0L, aVar2.f6148d - nanoTime);
                    if (max > 0) {
                        j6 = Math.min(max, j6);
                    } else if (aVar != null) {
                        z4 = true;
                        break;
                    } else {
                        aVar = aVar2;
                    }
                } else {
                    z4 = false;
                    break;
                }
            }
            if (aVar != null) {
                byte[] bArr2 = n3.b.f5783a;
                aVar.f6148d = -1L;
                c cVar = aVar.f6147c;
                com.google.common.collect.c.C(cVar);
                cVar.f6155e.remove(aVar);
                arrayList.remove(cVar);
                cVar.f6154d = aVar;
                this.f6166e.add(cVar);
                if (z4 || (!this.f6164c && (!arrayList.isEmpty()))) {
                    e eVar = this.f6168g;
                    com.google.common.collect.c.F(eVar, "runnable");
                    dVar.f6157a.execute(eVar);
                }
                return aVar;
            } else if (this.f6164c) {
                if (j6 < this.f6165d - nanoTime) {
                    notify();
                }
                return null;
            } else {
                this.f6164c = true;
                this.f6165d = nanoTime + j6;
                try {
                    try {
                        j4 = j6 / 1000000;
                        j5 = j6 - (1000000 * j4);
                    } catch (InterruptedException unused) {
                        d();
                        z5 = false;
                    }
                    if (j4 <= 0) {
                        if (j6 > 0) {
                        }
                        z5 = false;
                        this.f6164c = z5;
                    }
                    wait(j4, (int) j5);
                    z5 = false;
                    this.f6164c = z5;
                } catch (Throwable th) {
                    this.f6164c = false;
                    throw th;
                }
            }
        }
    }

    public final void d() {
        ArrayList arrayList = this.f6166e;
        int size = arrayList.size();
        while (true) {
            size--;
            if (-1 >= size) {
                break;
            }
            ((c) arrayList.get(size)).b();
        }
        ArrayList arrayList2 = this.f6167f;
        for (int size2 = arrayList2.size() - 1; -1 < size2; size2--) {
            c cVar = (c) arrayList2.get(size2);
            cVar.b();
            if (cVar.f6155e.isEmpty()) {
                arrayList2.remove(size2);
            }
        }
    }

    public final void e(c cVar) {
        com.google.common.collect.c.F(cVar, "taskQueue");
        byte[] bArr = n3.b.f5783a;
        if (cVar.f6154d == null) {
            boolean z4 = !cVar.f6155e.isEmpty();
            ArrayList arrayList = this.f6167f;
            if (z4) {
                com.google.common.collect.c.F(arrayList, "<this>");
                if (!arrayList.contains(cVar)) {
                    arrayList.add(cVar);
                }
            } else {
                arrayList.remove(cVar);
            }
        }
        boolean z5 = this.f6164c;
        d dVar = this.f6162a;
        dVar.getClass();
        if (z5) {
            notify();
            return;
        }
        e eVar = this.f6168g;
        com.google.common.collect.c.F(eVar, "runnable");
        dVar.f6157a.execute(eVar);
    }

    public final c f() {
        int i4;
        synchronized (this) {
            i4 = this.f6163b;
            this.f6163b = i4 + 1;
        }
        return new c(this, j.b("Q", i4));
    }
}