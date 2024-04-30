package p3;

import androidx.fragment.app.m0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.RejectedExecutionException;
import java.util.logging.Level;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final f f6151a;

    /* renamed from: b  reason: collision with root package name */
    public final String f6152b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f6153c;

    /* renamed from: d  reason: collision with root package name */
    public a f6154d;

    /* renamed from: e  reason: collision with root package name */
    public final ArrayList f6155e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f6156f;

    public c(f fVar, String str) {
        com.google.common.collect.c.F(fVar, "taskRunner");
        com.google.common.collect.c.F(str, "name");
        this.f6151a = fVar;
        this.f6152b = str;
        this.f6155e = new ArrayList();
    }

    public final void a() {
        byte[] bArr = n3.b.f5783a;
        synchronized (this.f6151a) {
            if (b()) {
                this.f6151a.e(this);
            }
        }
    }

    public final boolean b() {
        a aVar = this.f6154d;
        if (aVar != null && aVar.f6146b) {
            this.f6156f = true;
        }
        ArrayList arrayList = this.f6155e;
        boolean z4 = false;
        for (int size = arrayList.size() - 1; -1 < size; size--) {
            if (((a) arrayList.get(size)).f6146b) {
                a aVar2 = (a) arrayList.get(size);
                m0 m0Var = f.f6159h;
                if (f.f6161j.isLoggable(Level.FINE)) {
                    com.google.common.collect.c.j(aVar2, this, "canceled");
                }
                arrayList.remove(size);
                z4 = true;
            }
        }
        return z4;
    }

    public final void c(a aVar, long j4) {
        com.google.common.collect.c.F(aVar, "task");
        synchronized (this.f6151a) {
            if (this.f6153c) {
                if (aVar.f6146b) {
                    f.f6159h.getClass();
                    if (f.f6161j.isLoggable(Level.FINE)) {
                        com.google.common.collect.c.j(aVar, this, "schedule canceled (queue is shutdown)");
                    }
                    return;
                }
                f.f6159h.getClass();
                if (f.f6161j.isLoggable(Level.FINE)) {
                    com.google.common.collect.c.j(aVar, this, "schedule failed (queue is shutdown)");
                }
                throw new RejectedExecutionException();
            }
            if (d(aVar, j4, false)) {
                this.f6151a.e(this);
            }
        }
    }

    public final boolean d(a aVar, long j4, boolean z4) {
        String m02;
        String str;
        com.google.common.collect.c.F(aVar, "task");
        c cVar = aVar.f6147c;
        if (cVar != this) {
            if (cVar == null) {
                aVar.f6147c = this;
            } else {
                throw new IllegalStateException("task is in multiple queues".toString());
            }
        }
        this.f6151a.f6162a.getClass();
        long nanoTime = System.nanoTime();
        long j5 = nanoTime + j4;
        ArrayList arrayList = this.f6155e;
        int indexOf = arrayList.indexOf(aVar);
        if (indexOf != -1) {
            if (aVar.f6148d <= j5) {
                m0 m0Var = f.f6159h;
                if (f.f6161j.isLoggable(Level.FINE)) {
                    com.google.common.collect.c.j(aVar, this, "already scheduled");
                }
                return false;
            }
            arrayList.remove(indexOf);
        }
        aVar.f6148d = j5;
        m0 m0Var2 = f.f6159h;
        if (f.f6161j.isLoggable(Level.FINE)) {
            long j6 = j5 - nanoTime;
            if (z4) {
                m02 = com.google.common.collect.c.m0(j6);
                str = "run again after ";
            } else {
                m02 = com.google.common.collect.c.m0(j6);
                str = "scheduled after ";
            }
            com.google.common.collect.c.j(aVar, this, str.concat(m02));
        }
        Iterator it = arrayList.iterator();
        int i4 = 0;
        while (true) {
            if (it.hasNext()) {
                if (((a) it.next()).f6148d - nanoTime > j4) {
                    break;
                }
                i4++;
            } else {
                i4 = -1;
                break;
            }
        }
        if (i4 == -1) {
            i4 = arrayList.size();
        }
        arrayList.add(i4, aVar);
        if (i4 != 0) {
            return false;
        }
        return true;
    }

    public final void e() {
        byte[] bArr = n3.b.f5783a;
        synchronized (this.f6151a) {
            this.f6153c = true;
            if (b()) {
                this.f6151a.e(this);
            }
        }
    }

    public final String toString() {
        return this.f6152b;
    }
}