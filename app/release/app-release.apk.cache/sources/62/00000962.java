package q3;

import java.lang.ref.Reference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class l {

    /* renamed from: a  reason: collision with root package name */
    public final int f6416a;

    /* renamed from: b  reason: collision with root package name */
    public final long f6417b;

    /* renamed from: c  reason: collision with root package name */
    public final p3.c f6418c;

    /* renamed from: d  reason: collision with root package name */
    public final p3.b f6419d;

    /* renamed from: e  reason: collision with root package name */
    public final ConcurrentLinkedQueue f6420e;

    public l(p3.f fVar, TimeUnit timeUnit) {
        com.google.common.collect.c.F(fVar, "taskRunner");
        com.google.common.collect.c.F(timeUnit, "timeUnit");
        this.f6416a = 5;
        this.f6417b = timeUnit.toNanos(5L);
        this.f6418c = fVar.f();
        this.f6419d = new p3.b(this, androidx.activity.j.e(new StringBuilder(), n3.b.f5789g, " ConnectionPool"));
        this.f6420e = new ConcurrentLinkedQueue();
    }

    public final boolean a(m3.a aVar, j jVar, List list, boolean z4) {
        com.google.common.collect.c.F(aVar, "address");
        com.google.common.collect.c.F(jVar, "call");
        Iterator it = this.f6420e.iterator();
        while (it.hasNext()) {
            okhttp3.internal.connection.a aVar2 = (okhttp3.internal.connection.a) it.next();
            com.google.common.collect.c.E(aVar2, "connection");
            synchronized (aVar2) {
                if (z4) {
                    if (aVar2.f6022g == null) {
                        continue;
                    }
                }
                if (aVar2.h(aVar, list)) {
                    jVar.b(aVar2);
                    return true;
                }
            }
        }
        return false;
    }

    public final int b(okhttp3.internal.connection.a aVar, long j4) {
        byte[] bArr = n3.b.f5783a;
        ArrayList arrayList = aVar.f6031p;
        int i4 = 0;
        while (i4 < arrayList.size()) {
            Reference reference = (Reference) arrayList.get(i4);
            if (reference.get() != null) {
                i4++;
            } else {
                u3.l lVar = u3.l.f6934a;
                u3.l.f6934a.j(((h) reference).f6395a, "A connection to " + aVar.f6017b.f5641a.f5468i + " was leaked. Did you forget to close a response body?");
                arrayList.remove(i4);
                aVar.f6025j = true;
                if (arrayList.isEmpty()) {
                    aVar.f6032q = j4 - this.f6417b;
                    return 0;
                }
            }
        }
        return arrayList.size();
    }
}