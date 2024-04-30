package t3;

import androidx.fragment.app.m0;
import java.io.Closeable;
import java.io.IOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Ref$IntRef;
import okhttp3.internal.http2.ErrorCode;

/* loaded from: classes.dex */
public final class s implements Closeable {
    public static final d0 B;
    public final LinkedHashSet A;

    /* renamed from: a  reason: collision with root package name */
    public final boolean f6777a;

    /* renamed from: b  reason: collision with root package name */
    public final i f6778b;

    /* renamed from: c  reason: collision with root package name */
    public final LinkedHashMap f6779c;

    /* renamed from: d  reason: collision with root package name */
    public final String f6780d;

    /* renamed from: e  reason: collision with root package name */
    public int f6781e;

    /* renamed from: f  reason: collision with root package name */
    public int f6782f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f6783g;

    /* renamed from: h  reason: collision with root package name */
    public final p3.f f6784h;

    /* renamed from: i  reason: collision with root package name */
    public final p3.c f6785i;

    /* renamed from: j  reason: collision with root package name */
    public final p3.c f6786j;

    /* renamed from: k  reason: collision with root package name */
    public final p3.c f6787k;

    /* renamed from: l  reason: collision with root package name */
    public final m0 f6788l;

    /* renamed from: m  reason: collision with root package name */
    public long f6789m;

    /* renamed from: n  reason: collision with root package name */
    public long f6790n;

    /* renamed from: o  reason: collision with root package name */
    public long f6791o;

    /* renamed from: p  reason: collision with root package name */
    public long f6792p;

    /* renamed from: q  reason: collision with root package name */
    public long f6793q;

    /* renamed from: r  reason: collision with root package name */
    public final d0 f6794r;

    /* renamed from: s  reason: collision with root package name */
    public d0 f6795s;

    /* renamed from: t  reason: collision with root package name */
    public long f6796t;

    /* renamed from: u  reason: collision with root package name */
    public long f6797u;

    /* renamed from: v  reason: collision with root package name */
    public long f6798v;

    /* renamed from: w  reason: collision with root package name */
    public long f6799w;

    /* renamed from: x  reason: collision with root package name */
    public final Socket f6800x;

    /* renamed from: y  reason: collision with root package name */
    public final a0 f6801y;

    /* renamed from: z  reason: collision with root package name */
    public final m f6802z;

    static {
        d0 d0Var = new d0();
        d0Var.c(7, 65535);
        d0Var.c(5, 16384);
        B = d0Var;
    }

    public s(g gVar) {
        int i4;
        boolean z4 = gVar.f6740a;
        this.f6777a = z4;
        this.f6778b = gVar.f6746g;
        this.f6779c = new LinkedHashMap();
        String str = gVar.f6743d;
        if (str != null) {
            this.f6780d = str;
            if (z4) {
                i4 = 3;
            } else {
                i4 = 2;
            }
            this.f6782f = i4;
            p3.f fVar = gVar.f6741b;
            this.f6784h = fVar;
            p3.c f4 = fVar.f();
            this.f6785i = f4;
            this.f6786j = fVar.f();
            this.f6787k = fVar.f();
            this.f6788l = gVar.f6747h;
            d0 d0Var = new d0();
            if (z4) {
                d0Var.c(7, 16777216);
            }
            this.f6794r = d0Var;
            d0 d0Var2 = B;
            this.f6795s = d0Var2;
            this.f6799w = d0Var2.a();
            Socket socket = gVar.f6742c;
            if (socket != null) {
                this.f6800x = socket;
                y3.g gVar2 = gVar.f6745f;
                if (gVar2 != null) {
                    this.f6801y = new a0(gVar2, z4);
                    y3.h hVar = gVar.f6744e;
                    if (hVar != null) {
                        this.f6802z = new m(this, new v(hVar, z4));
                        this.A = new LinkedHashSet();
                        int i5 = gVar.f6748i;
                        if (i5 != 0) {
                            long nanos = TimeUnit.MILLISECONDS.toNanos(i5);
                            f4.c(new q(str.concat(" ping"), this, nanos), nanos);
                            return;
                        }
                        return;
                    }
                    com.google.common.collect.c.Z1("source");
                    throw null;
                }
                com.google.common.collect.c.Z1("sink");
                throw null;
            }
            com.google.common.collect.c.Z1("socket");
            throw null;
        }
        com.google.common.collect.c.Z1("connectionName");
        throw null;
    }

    public final synchronized z A(int i4) {
        z zVar;
        zVar = (z) this.f6779c.remove(Integer.valueOf(i4));
        notifyAll();
        return zVar;
    }

    public final void B(ErrorCode errorCode) {
        synchronized (this.f6801y) {
            Ref$IntRef ref$IntRef = new Ref$IntRef();
            synchronized (this) {
                if (this.f6783g) {
                    return;
                }
                this.f6783g = true;
                int i4 = this.f6781e;
                ref$IntRef.f5197a = i4;
                this.f6801y.A(i4, errorCode, n3.b.f5783a);
            }
        }
    }

    public final synchronized void C(long j4) {
        long j5 = this.f6796t + j4;
        this.f6796t = j5;
        long j6 = j5 - this.f6797u;
        if (j6 >= this.f6794r.a() / 2) {
            F(0, j6);
            this.f6797u += j6;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0033, code lost:
        throw new java.io.IOException("stream closed");
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0035, code lost:
        r2 = java.lang.Math.min((int) java.lang.Math.min(r12, r6 - r4), r8.f6801y.f6699d);
        r6 = r2;
        r8.f6798v += r6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void D(int r9, boolean r10, y3.f r11, long r12) {
        /*
            r8 = this;
            r0 = 0
            int r2 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            r3 = 0
            if (r2 != 0) goto Ld
            t3.a0 r12 = r8.f6801y
            r12.y(r10, r9, r11, r3)
            return
        Ld:
            int r2 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r2 <= 0) goto L68
            monitor-enter(r8)
        L12:
            long r4 = r8.f6798v     // Catch: java.lang.Throwable -> L2a java.lang.InterruptedException -> L59
            long r6 = r8.f6799w     // Catch: java.lang.Throwable -> L2a java.lang.InterruptedException -> L59
            int r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r2 < 0) goto L34
            java.util.LinkedHashMap r2 = r8.f6779c     // Catch: java.lang.Throwable -> L2a java.lang.InterruptedException -> L59
            java.lang.Integer r4 = java.lang.Integer.valueOf(r9)     // Catch: java.lang.Throwable -> L2a java.lang.InterruptedException -> L59
            boolean r2 = r2.containsKey(r4)     // Catch: java.lang.Throwable -> L2a java.lang.InterruptedException -> L59
            if (r2 == 0) goto L2c
            r8.wait()     // Catch: java.lang.Throwable -> L2a java.lang.InterruptedException -> L59
            goto L12
        L2a:
            r9 = move-exception
            goto L66
        L2c:
            java.io.IOException r9 = new java.io.IOException     // Catch: java.lang.Throwable -> L2a java.lang.InterruptedException -> L59
            java.lang.String r10 = "stream closed"
            r9.<init>(r10)     // Catch: java.lang.Throwable -> L2a java.lang.InterruptedException -> L59
            throw r9     // Catch: java.lang.Throwable -> L2a java.lang.InterruptedException -> L59
        L34:
            long r6 = r6 - r4
            long r4 = java.lang.Math.min(r12, r6)     // Catch: java.lang.Throwable -> L2a
            int r2 = (int) r4     // Catch: java.lang.Throwable -> L2a
            t3.a0 r4 = r8.f6801y     // Catch: java.lang.Throwable -> L2a
            int r4 = r4.f6699d     // Catch: java.lang.Throwable -> L2a
            int r2 = java.lang.Math.min(r2, r4)     // Catch: java.lang.Throwable -> L2a
            long r4 = r8.f6798v     // Catch: java.lang.Throwable -> L2a
            long r6 = (long) r2     // Catch: java.lang.Throwable -> L2a
            long r4 = r4 + r6
            r8.f6798v = r4     // Catch: java.lang.Throwable -> L2a
            monitor-exit(r8)
            long r12 = r12 - r6
            t3.a0 r4 = r8.f6801y
            if (r10 == 0) goto L54
            int r5 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r5 != 0) goto L54
            r5 = 1
            goto L55
        L54:
            r5 = r3
        L55:
            r4.y(r5, r9, r11, r2)
            goto Ld
        L59:
            java.lang.Thread r9 = java.lang.Thread.currentThread()     // Catch: java.lang.Throwable -> L2a
            r9.interrupt()     // Catch: java.lang.Throwable -> L2a
            java.io.InterruptedIOException r9 = new java.io.InterruptedIOException     // Catch: java.lang.Throwable -> L2a
            r9.<init>()     // Catch: java.lang.Throwable -> L2a
            throw r9     // Catch: java.lang.Throwable -> L2a
        L66:
            monitor-exit(r8)
            throw r9
        L68:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: t3.s.D(int, boolean, y3.f, long):void");
    }

    public final void E(int i4, ErrorCode errorCode) {
        this.f6785i.c(new p(this.f6780d + '[' + i4 + "] writeSynReset", this, i4, errorCode, 1), 0L);
    }

    public final void F(int i4, long j4) {
        this.f6785i.c(new r(this.f6780d + '[' + i4 + "] windowUpdate", this, i4, j4), 0L);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        x(ErrorCode.f6033b, ErrorCode.f6038g, null);
    }

    public final void flush() {
        this.f6801y.flush();
    }

    public final void x(ErrorCode errorCode, ErrorCode errorCode2, IOException iOException) {
        int i4;
        Object[] objArr;
        byte[] bArr = n3.b.f5783a;
        try {
            B(errorCode);
        } catch (IOException unused) {
        }
        synchronized (this) {
            if (!this.f6779c.isEmpty()) {
                objArr = this.f6779c.values().toArray(new z[0]);
                this.f6779c.clear();
            } else {
                objArr = null;
            }
        }
        z[] zVarArr = (z[]) objArr;
        if (zVarArr != null) {
            for (z zVar : zVarArr) {
                try {
                    zVar.c(errorCode2, iOException);
                } catch (IOException unused2) {
                }
            }
        }
        try {
            this.f6801y.close();
        } catch (IOException unused3) {
        }
        try {
            this.f6800x.close();
        } catch (IOException unused4) {
        }
        this.f6785i.e();
        this.f6786j.e();
        this.f6787k.e();
    }

    public final void y(IOException iOException) {
        ErrorCode errorCode = ErrorCode.f6034c;
        x(errorCode, errorCode, iOException);
    }

    public final synchronized z z(int i4) {
        return (z) this.f6779c.get(Integer.valueOf(i4));
    }
}