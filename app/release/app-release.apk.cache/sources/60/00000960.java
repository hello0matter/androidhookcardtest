package q3;

import androidx.appcompat.widget.z;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.Reference;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import m3.o;
import m3.s;

/* loaded from: classes.dex */
public final class j implements m3.d {

    /* renamed from: a  reason: collision with root package name */
    public final s f6397a;

    /* renamed from: b  reason: collision with root package name */
    public final z f6398b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f6399c;

    /* renamed from: d  reason: collision with root package name */
    public final l f6400d;

    /* renamed from: e  reason: collision with root package name */
    public final m3.k f6401e;

    /* renamed from: f  reason: collision with root package name */
    public final i f6402f;

    /* renamed from: g  reason: collision with root package name */
    public final AtomicBoolean f6403g;

    /* renamed from: h  reason: collision with root package name */
    public Object f6404h;

    /* renamed from: i  reason: collision with root package name */
    public f f6405i;

    /* renamed from: j  reason: collision with root package name */
    public okhttp3.internal.connection.a f6406j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f6407k;

    /* renamed from: l  reason: collision with root package name */
    public e f6408l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f6409m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f6410n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f6411o;

    /* renamed from: p  reason: collision with root package name */
    public volatile boolean f6412p;

    /* renamed from: q  reason: collision with root package name */
    public volatile e f6413q;

    /* renamed from: r  reason: collision with root package name */
    public volatile okhttp3.internal.connection.a f6414r;

    public j(s sVar, z zVar, boolean z4) {
        com.google.common.collect.c.F(sVar, "client");
        com.google.common.collect.c.F(zVar, "originalRequest");
        this.f6397a = sVar;
        this.f6398b = zVar;
        this.f6399c = z4;
        this.f6400d = (l) sVar.f5578b.f7056b;
        m3.k kVar = (m3.k) sVar.f5581e.f5259b;
        byte[] bArr = n3.b.f5783a;
        com.google.common.collect.c.F(kVar, "$this_asFactory");
        this.f6401e = kVar;
        i iVar = new i(this);
        iVar.g(0, TimeUnit.MILLISECONDS);
        this.f6402f = iVar;
        this.f6403g = new AtomicBoolean();
        this.f6411o = true;
    }

    public static final String a(j jVar) {
        String str;
        String str2;
        StringBuilder sb = new StringBuilder();
        if (jVar.f6412p) {
            str = "canceled ";
        } else {
            str = "";
        }
        sb.append(str);
        if (jVar.f6399c) {
            str2 = "web socket";
        } else {
            str2 = "call";
        }
        sb.append(str2);
        sb.append(" to ");
        sb.append(((o) jVar.f6398b.f989b).f());
        return sb.toString();
    }

    public final void b(okhttp3.internal.connection.a aVar) {
        byte[] bArr = n3.b.f5783a;
        if (this.f6406j == null) {
            this.f6406j = aVar;
            aVar.f6031p.add(new h(this, this.f6404h));
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public final IOException c(IOException iOException) {
        IOException interruptedIOException;
        m3.k kVar;
        Socket i4;
        byte[] bArr = n3.b.f5783a;
        okhttp3.internal.connection.a aVar = this.f6406j;
        if (aVar != null) {
            synchronized (aVar) {
                i4 = i();
            }
            if (this.f6406j == null) {
                if (i4 != null) {
                    n3.b.e(i4);
                }
                this.f6401e.getClass();
            } else if (i4 != null) {
                throw new IllegalStateException("Check failed.".toString());
            }
        }
        if (this.f6407k || !this.f6402f.i()) {
            interruptedIOException = iOException;
        } else {
            interruptedIOException = new InterruptedIOException("timeout");
            if (iOException != null) {
                interruptedIOException.initCause(iOException);
            }
        }
        if (iOException != null) {
            kVar = this.f6401e;
            com.google.common.collect.c.C(interruptedIOException);
        } else {
            kVar = this.f6401e;
        }
        kVar.getClass();
        return interruptedIOException;
    }

    public final Object clone() {
        return new j(this.f6397a, this.f6398b, this.f6399c);
    }

    public final void d() {
        Socket socket;
        if (this.f6412p) {
            return;
        }
        this.f6412p = true;
        e eVar = this.f6413q;
        if (eVar != null) {
            eVar.f6378d.cancel();
        }
        okhttp3.internal.connection.a aVar = this.f6414r;
        if (aVar != null && (socket = aVar.f6018c) != null) {
            n3.b.e(socket);
        }
        this.f6401e.getClass();
    }

    public final void e(boolean z4) {
        e eVar;
        synchronized (this) {
            if (!this.f6411o) {
                throw new IllegalStateException("released".toString());
            }
        }
        if (z4 && (eVar = this.f6413q) != null) {
            eVar.f6378d.cancel();
            eVar.f6375a.g(eVar, true, true, null);
        }
        this.f6408l = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x008b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final m3.w f() {
        /*
            r11 = this;
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            m3.s r0 = r11.f6397a
            java.util.List r0 = r0.f5579c
            y2.j.o2(r0, r2)
            r3.g r0 = new r3.g
            m3.s r1 = r11.f6397a
            r0.<init>(r1)
            r2.add(r0)
            r3.a r0 = new r3.a
            m3.s r1 = r11.f6397a
            m3.k r1 = r1.f5586j
            r0.<init>(r1)
            r2.add(r0)
            o3.a r0 = new o3.a
            m3.s r1 = r11.f6397a
            r1.getClass()
            r0.<init>()
            r2.add(r0)
            q3.a r0 = q3.a.f6357a
            r2.add(r0)
            boolean r0 = r11.f6399c
            if (r0 != 0) goto L3f
            m3.s r0 = r11.f6397a
            java.util.List r0 = r0.f5580d
            y2.j.o2(r0, r2)
        L3f:
            r3.b r0 = new r3.b
            boolean r1 = r11.f6399c
            r0.<init>(r1)
            r2.add(r0)
            r3.f r9 = new r3.f
            androidx.appcompat.widget.z r5 = r11.f6398b
            m3.s r0 = r11.f6397a
            int r6 = r0.f5598v
            int r7 = r0.f5599w
            int r8 = r0.f5600x
            r3 = 0
            r4 = 0
            r0 = r9
            r1 = r11
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            r0 = 0
            r1 = 0
            androidx.appcompat.widget.z r2 = r11.f6398b     // Catch: java.lang.Throwable -> L77 java.io.IOException -> L79
            m3.w r2 = r9.b(r2)     // Catch: java.lang.Throwable -> L77 java.io.IOException -> L79
            boolean r3 = r11.f6412p     // Catch: java.lang.Throwable -> L77 java.io.IOException -> L79
            if (r3 != 0) goto L6c
            r11.h(r0)
            return r2
        L6c:
            n3.b.d(r2)     // Catch: java.lang.Throwable -> L77 java.io.IOException -> L79
            java.io.IOException r2 = new java.io.IOException     // Catch: java.lang.Throwable -> L77 java.io.IOException -> L79
            java.lang.String r3 = "Canceled"
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L77 java.io.IOException -> L79
            throw r2     // Catch: java.lang.Throwable -> L77 java.io.IOException -> L79
        L77:
            r2 = move-exception
            goto L89
        L79:
            r1 = move-exception
            r2 = 1
            java.io.IOException r1 = r11.h(r1)     // Catch: java.lang.Throwable -> L85
            java.lang.String r3 = "null cannot be cast to non-null type kotlin.Throwable"
            com.google.common.collect.c.D(r1, r3)     // Catch: java.lang.Throwable -> L85
            throw r1     // Catch: java.lang.Throwable -> L85
        L85:
            r1 = move-exception
            r10 = r2
            r2 = r1
            r1 = r10
        L89:
            if (r1 != 0) goto L8e
            r11.h(r0)
        L8e:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: q3.j.f():m3.w");
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0022 A[Catch: all -> 0x0018, TryCatch #1 {all -> 0x0018, blocks: (B:8:0x0013, B:17:0x0022, B:19:0x0026, B:20:0x0028, B:22:0x002c, B:27:0x0035, B:29:0x0039, B:14:0x001c), top: B:53:0x0013 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0026 A[Catch: all -> 0x0018, TryCatch #1 {all -> 0x0018, blocks: (B:8:0x0013, B:17:0x0022, B:19:0x0026, B:20:0x0028, B:22:0x002c, B:27:0x0035, B:29:0x0039, B:14:0x001c), top: B:53:0x0013 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.io.IOException g(q3.e r3, boolean r4, boolean r5, java.io.IOException r6) {
        /*
            r2 = this;
            java.lang.String r0 = "exchange"
            com.google.common.collect.c.F(r3, r0)
            q3.e r0 = r2.f6413q
            boolean r3 = com.google.common.collect.c.n(r3, r0)
            if (r3 != 0) goto Le
            return r6
        Le:
            monitor-enter(r2)
            r3 = 1
            r0 = 0
            if (r4 == 0) goto L1a
            boolean r1 = r2.f6409m     // Catch: java.lang.Throwable -> L18
            if (r1 != 0) goto L20
            goto L1a
        L18:
            r3 = move-exception
            goto L41
        L1a:
            if (r5 == 0) goto L43
            boolean r1 = r2.f6410n     // Catch: java.lang.Throwable -> L18
            if (r1 == 0) goto L43
        L20:
            if (r4 == 0) goto L24
            r2.f6409m = r0     // Catch: java.lang.Throwable -> L18
        L24:
            if (r5 == 0) goto L28
            r2.f6410n = r0     // Catch: java.lang.Throwable -> L18
        L28:
            boolean r4 = r2.f6409m     // Catch: java.lang.Throwable -> L18
            if (r4 != 0) goto L32
            boolean r5 = r2.f6410n     // Catch: java.lang.Throwable -> L18
            if (r5 != 0) goto L32
            r5 = r3
            goto L33
        L32:
            r5 = r0
        L33:
            if (r4 != 0) goto L3e
            boolean r4 = r2.f6410n     // Catch: java.lang.Throwable -> L18
            if (r4 != 0) goto L3e
            boolean r4 = r2.f6411o     // Catch: java.lang.Throwable -> L18
            if (r4 != 0) goto L3e
            r0 = r3
        L3e:
            r4 = r0
            r0 = r5
            goto L44
        L41:
            monitor-exit(r2)
            throw r3
        L43:
            r4 = r0
        L44:
            monitor-exit(r2)
            if (r0 == 0) goto L59
            r5 = 0
            r2.f6413q = r5
            okhttp3.internal.connection.a r5 = r2.f6406j
            if (r5 == 0) goto L59
            monitor-enter(r5)
            int r0 = r5.f6028m     // Catch: java.lang.Throwable -> L56
            int r0 = r0 + r3
            r5.f6028m = r0     // Catch: java.lang.Throwable -> L56
            monitor-exit(r5)
            goto L59
        L56:
            r3 = move-exception
            monitor-exit(r5)
            throw r3
        L59:
            if (r4 == 0) goto L60
            java.io.IOException r3 = r2.c(r6)
            return r3
        L60:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: q3.j.g(q3.e, boolean, boolean, java.io.IOException):java.io.IOException");
    }

    public final IOException h(IOException iOException) {
        boolean z4;
        synchronized (this) {
            z4 = false;
            if (this.f6411o) {
                this.f6411o = false;
                if (!this.f6409m) {
                    if (!this.f6410n) {
                        z4 = true;
                    }
                }
            }
        }
        if (z4) {
            return c(iOException);
        }
        return iOException;
    }

    public final Socket i() {
        okhttp3.internal.connection.a aVar = this.f6406j;
        com.google.common.collect.c.C(aVar);
        byte[] bArr = n3.b.f5783a;
        ArrayList arrayList = aVar.f6031p;
        Iterator it = arrayList.iterator();
        int i4 = 0;
        while (true) {
            if (it.hasNext()) {
                if (com.google.common.collect.c.n(((Reference) it.next()).get(), this)) {
                    break;
                }
                i4++;
            } else {
                i4 = -1;
                break;
            }
        }
        if (i4 != -1) {
            arrayList.remove(i4);
            this.f6406j = null;
            if (arrayList.isEmpty()) {
                aVar.f6032q = System.nanoTime();
                l lVar = this.f6400d;
                lVar.getClass();
                byte[] bArr2 = n3.b.f5783a;
                boolean z4 = aVar.f6025j;
                p3.c cVar = lVar.f6418c;
                if (!z4 && lVar.f6416a != 0) {
                    cVar.c(lVar.f6419d, 0L);
                } else {
                    aVar.f6025j = true;
                    ConcurrentLinkedQueue concurrentLinkedQueue = lVar.f6420e;
                    concurrentLinkedQueue.remove(aVar);
                    if (concurrentLinkedQueue.isEmpty()) {
                        cVar.a();
                    }
                    Socket socket = aVar.f6019d;
                    com.google.common.collect.c.C(socket);
                    return socket;
                }
            }
            return null;
        }
        throw new IllegalStateException("Check failed.".toString());
    }
}