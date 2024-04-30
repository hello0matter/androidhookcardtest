package m;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public abstract class f implements Future {

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f5425d = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));

    /* renamed from: e  reason: collision with root package name */
    public static final Logger f5426e = Logger.getLogger(f.class.getName());

    /* renamed from: f  reason: collision with root package name */
    public static final com.google.common.collect.c f5427f;

    /* renamed from: g  reason: collision with root package name */
    public static final Object f5428g;

    /* renamed from: a  reason: collision with root package name */
    public volatile Object f5429a;

    /* renamed from: b  reason: collision with root package name */
    public volatile c f5430b;

    /* renamed from: c  reason: collision with root package name */
    public volatile e f5431c;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v4, types: [com.google.common.collect.c] */
    /* JADX WARN: Type inference failed for: r2v7 */
    static {
        d dVar;
        try {
            th = null;
            dVar = new d(AtomicReferenceFieldUpdater.newUpdater(e.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(e.class, e.class, "b"), AtomicReferenceFieldUpdater.newUpdater(f.class, e.class, "c"), AtomicReferenceFieldUpdater.newUpdater(f.class, c.class, "b"), AtomicReferenceFieldUpdater.newUpdater(f.class, Object.class, "a"));
        } catch (Throwable th) {
            th = th;
            dVar = new Object();
        }
        f5427f = dVar;
        if (th != null) {
            f5426e.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
        f5428g = new Object();
    }

    public static void b(f fVar) {
        e eVar;
        c cVar;
        do {
            eVar = fVar.f5431c;
        } while (!f5427f.y(fVar, eVar, e.f5422c));
        while (eVar != null) {
            Thread thread = eVar.f5423a;
            if (thread != null) {
                eVar.f5423a = null;
                LockSupport.unpark(thread);
            }
            eVar = eVar.f5424b;
        }
        do {
            cVar = fVar.f5430b;
        } while (!f5427f.w(fVar, cVar));
        c cVar2 = null;
        while (cVar != null) {
            c cVar3 = cVar.f5416a;
            cVar.f5416a = cVar2;
            cVar2 = cVar;
            cVar = cVar3;
        }
        while (cVar2 != null) {
            cVar2 = cVar2.f5416a;
            try {
                throw null;
                break;
            } catch (RuntimeException e4) {
                f5426e.log(Level.SEVERE, "RuntimeException while executing runnable null with executor null", (Throwable) e4);
            }
        }
    }

    public static Object c(Object obj) {
        if (!(obj instanceof a)) {
            if (!(obj instanceof b)) {
                if (obj == f5428g) {
                    return null;
                }
                return obj;
            }
            ((b) obj).getClass();
            throw new ExecutionException((Throwable) null);
        }
        Throwable th = ((a) obj).f5414a;
        CancellationException cancellationException = new CancellationException("Task was cancelled.");
        cancellationException.initCause(th);
        throw cancellationException;
    }

    public final void a(StringBuilder sb) {
        Object obj;
        String valueOf;
        String str = "]";
        boolean z4 = false;
        while (true) {
            try {
                try {
                    obj = get();
                    break;
                } catch (CancellationException unused) {
                    str = "CANCELLED";
                    sb.append(str);
                    return;
                } catch (RuntimeException e4) {
                    sb.append("UNKNOWN, cause=[");
                    sb.append(e4.getClass());
                    str = " thrown from get()]";
                    sb.append(str);
                    return;
                } catch (ExecutionException e5) {
                    sb.append("FAILURE, cause=[");
                    sb.append(e5.getCause());
                    sb.append(str);
                    return;
                }
            } catch (InterruptedException unused2) {
                z4 = true;
            } catch (Throwable th) {
                if (z4) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z4) {
            Thread.currentThread().interrupt();
        }
        sb.append("SUCCESS, result=[");
        if (obj == this) {
            valueOf = "this future";
        } else {
            valueOf = String.valueOf(obj);
        }
        sb.append(valueOf);
        sb.append("]");
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z4) {
        boolean z5;
        a aVar;
        Object obj = this.f5429a;
        if (obj == null) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (z5) {
            if (f5425d) {
                aVar = new a(z4, new CancellationException("Future.cancel() was called."));
            } else if (z4) {
                aVar = a.f5412b;
            } else {
                aVar = a.f5413c;
            }
            if (f5427f.x(this, obj, aVar)) {
                b(this);
                return true;
            }
        }
        return false;
    }

    public final void d(e eVar) {
        eVar.f5423a = null;
        while (true) {
            e eVar2 = this.f5431c;
            if (eVar2 == e.f5422c) {
                return;
            }
            e eVar3 = null;
            while (eVar2 != null) {
                e eVar4 = eVar2.f5424b;
                if (eVar2.f5423a != null) {
                    eVar3 = eVar2;
                } else if (eVar3 != null) {
                    eVar3.f5424b = eVar4;
                    if (eVar3.f5423a == null) {
                        break;
                    }
                } else if (!f5427f.y(this, eVar2, eVar4)) {
                    break;
                }
                eVar2 = eVar4;
            }
            return;
        }
    }

    @Override // java.util.concurrent.Future
    public final Object get() {
        Object obj;
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj2 = this.f5429a;
        if ((obj2 != null) && true) {
            return c(obj2);
        }
        e eVar = this.f5431c;
        e eVar2 = e.f5422c;
        if (eVar != eVar2) {
            e eVar3 = new e();
            do {
                com.google.common.collect.c cVar = f5427f;
                cVar.D1(eVar3, eVar);
                if (cVar.y(this, eVar, eVar3)) {
                    do {
                        LockSupport.park(this);
                        if (Thread.interrupted()) {
                            d(eVar3);
                            throw new InterruptedException();
                        }
                        obj = this.f5429a;
                    } while (!((obj != null) & true));
                    return c(obj);
                }
                eVar = this.f5431c;
            } while (eVar != eVar2);
            return c(this.f5429a);
        }
        return c(this.f5429a);
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.f5429a instanceof a;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        boolean z4;
        if (this.f5429a != null) {
            z4 = true;
        } else {
            z4 = false;
        }
        return z4 & true;
    }

    public final String toString() {
        String str;
        String str2;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("[status=");
        if (this.f5429a instanceof a) {
            str2 = "CANCELLED";
        } else {
            if (!isDone()) {
                try {
                    if (this instanceof ScheduledFuture) {
                        str = "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
                    } else {
                        str = null;
                    }
                } catch (RuntimeException e4) {
                    str = "Exception thrown from implementation: " + e4.getClass();
                }
                if (str != null && !str.isEmpty()) {
                    sb.append("PENDING, info=[");
                    sb.append(str);
                    sb.append("]");
                    sb.append("]");
                    return sb.toString();
                }
                str2 = isDone() ? "PENDING" : "PENDING";
            }
            a(sb);
            sb.append("]");
            return sb.toString();
        }
        sb.append(str2);
        sb.append("]");
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00ac  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:56:0x009f -> B:36:0x006e). Please submit an issue!!! */
    @Override // java.util.concurrent.Future
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object get(long r20, java.util.concurrent.TimeUnit r22) {
        /*
            Method dump skipped, instructions count: 370
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: m.f.get(long, java.util.concurrent.TimeUnit):java.lang.Object");
    }
}