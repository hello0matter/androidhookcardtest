package t3;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.internal.http2.ErrorCode;
import okio.ByteString;

/* loaded from: classes.dex */
public final class v implements Closeable {

    /* renamed from: e  reason: collision with root package name */
    public static final Logger f6817e;

    /* renamed from: a  reason: collision with root package name */
    public final y3.h f6818a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f6819b;

    /* renamed from: c  reason: collision with root package name */
    public final u f6820c;

    /* renamed from: d  reason: collision with root package name */
    public final c f6821d;

    static {
        Logger logger = Logger.getLogger(f.class.getName());
        com.google.common.collect.c.E(logger, "getLogger(Http2::class.java.name)");
        f6817e = logger;
    }

    public v(y3.h hVar, boolean z4) {
        this.f6818a = hVar;
        this.f6819b = z4;
        u uVar = new u(hVar);
        this.f6820c = uVar;
        this.f6821d = new c(uVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x00e2, code lost:
        throw new java.io.IOException("Invalid dynamic table size update " + r3.f6715b);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List A(int r3, int r4, int r5, int r6) {
        /*
            Method dump skipped, instructions count: 299
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: t3.v.A(int, int, int, int):java.util.List");
    }

    public final void B(m mVar, int i4, int i5, int i6) {
        boolean z4;
        int i7;
        if (i6 != 0) {
            boolean z5 = false;
            if ((i5 & 1) != 0) {
                z4 = true;
            } else {
                z4 = false;
            }
            if ((i5 & 8) != 0) {
                byte v2 = this.f6818a.v();
                byte[] bArr = n3.b.f5783a;
                i7 = v2 & 255;
            } else {
                i7 = 0;
            }
            if ((i5 & 32) != 0) {
                y3.h hVar = this.f6818a;
                hVar.k();
                hVar.v();
                byte[] bArr2 = n3.b.f5783a;
                mVar.getClass();
                i4 -= 5;
            }
            List A = A(a.j(i4, i5, i7), i7, i5, i6);
            mVar.getClass();
            com.google.common.collect.c.F(A, "headerBlock");
            mVar.f6760b.getClass();
            if (i6 != 0 && (i6 & 1) == 0) {
                z5 = true;
            }
            if (z5) {
                s sVar = mVar.f6760b;
                sVar.getClass();
                sVar.f6786j.c(new o(sVar.f6780d + '[' + i6 + "] onHeaders", sVar, i6, A, z4), 0L);
                return;
            }
            s sVar2 = mVar.f6760b;
            synchronized (sVar2) {
                z z6 = sVar2.z(i6);
                if (z6 == null) {
                    if (!sVar2.f6783g && i6 > sVar2.f6781e && i6 % 2 != sVar2.f6782f % 2) {
                        z zVar = new z(i6, sVar2, false, z4, n3.b.v(A));
                        sVar2.f6781e = i6;
                        sVar2.f6779c.put(Integer.valueOf(i6), zVar);
                        sVar2.f6784h.f().c(new j(sVar2.f6780d + '[' + i6 + "] onStream", sVar2, zVar, 1), 0L);
                    }
                    return;
                }
                z6.i(n3.b.v(A), z4);
                return;
            }
        }
        throw new IOException("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0");
    }

    public final void C(m mVar, int i4, int i5, int i6) {
        int i7;
        if (i6 != 0) {
            if ((i5 & 8) != 0) {
                byte v2 = this.f6818a.v();
                byte[] bArr = n3.b.f5783a;
                i7 = v2 & 255;
            } else {
                i7 = 0;
            }
            int k4 = this.f6818a.k() & Integer.MAX_VALUE;
            List A = A(a.j(i4 - 4, i5, i7), i7, i5, i6);
            mVar.getClass();
            com.google.common.collect.c.F(A, "requestHeaders");
            s sVar = mVar.f6760b;
            sVar.getClass();
            synchronized (sVar) {
                if (sVar.A.contains(Integer.valueOf(k4))) {
                    sVar.E(k4, ErrorCode.f6034c);
                    return;
                }
                sVar.A.add(Integer.valueOf(k4));
                p3.c cVar = sVar.f6786j;
                cVar.c(new p(sVar.f6780d + '[' + k4 + "] onRequest", sVar, k4, A, 2), 0L);
                return;
            }
        }
        throw new IOException("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f6818a.close();
    }

    /* JADX WARN: Code restructure failed: missing block: B:137:0x0236, code lost:
        throw new java.io.IOException(androidx.activity.j.b("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: ", r7));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean x(boolean r17, t3.m r18) {
        /*
            Method dump skipped, instructions count: 886
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: t3.v.x(boolean, t3.m):boolean");
    }

    public final void y(m mVar) {
        com.google.common.collect.c.F(mVar, "handler");
        if (this.f6819b) {
            if (!x(true, mVar)) {
                throw new IOException("Required SETTINGS preface not received");
            }
            return;
        }
        ByteString byteString = f.f6736a;
        ByteString e4 = this.f6818a.e(byteString.f6050a.length);
        Level level = Level.FINE;
        Logger logger = f6817e;
        if (logger.isLoggable(level)) {
            logger.fine(n3.b.i("<< CONNECTION " + e4.d(), new Object[0]));
        }
        if (com.google.common.collect.c.n(byteString, e4)) {
            return;
        }
        throw new IOException("Expected a connection header but was ".concat(e4.j()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v8, types: [y3.f, java.lang.Object] */
    public final void z(m mVar, int i4, int i5, int i6) {
        boolean z4;
        int i7;
        int i8;
        boolean z5;
        boolean z6;
        boolean z7;
        long j4;
        boolean z8;
        if (i6 != 0) {
            if ((i5 & 1) != 0) {
                z4 = true;
            } else {
                z4 = false;
            }
            if ((i5 & 32) == 0) {
                if ((i5 & 8) != 0) {
                    byte v2 = this.f6818a.v();
                    byte[] bArr = n3.b.f5783a;
                    i8 = v2 & 255;
                    i7 = i4;
                } else {
                    i7 = i4;
                    i8 = 0;
                }
                int j5 = a.j(i7, i5, i8);
                y3.h hVar = this.f6818a;
                mVar.getClass();
                com.google.common.collect.c.F(hVar, "source");
                mVar.f6760b.getClass();
                if (i6 != 0 && (i6 & 1) == 0) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                long j6 = 0;
                if (z5) {
                    s sVar = mVar.f6760b;
                    sVar.getClass();
                    ?? obj = new Object();
                    long j7 = j5;
                    hVar.o(j7);
                    hVar.w(obj, j7);
                    sVar.f6786j.c(new n(sVar.f6780d + '[' + i6 + "] onData", sVar, i6, obj, j5, z4), 0L);
                } else {
                    z z9 = mVar.f6760b.z(i6);
                    if (z9 == null) {
                        mVar.f6760b.E(i6, ErrorCode.f6034c);
                        long j8 = j5;
                        mVar.f6760b.C(j8);
                        hVar.h(j8);
                    } else {
                        byte[] bArr2 = n3.b.f5783a;
                        x xVar = z9.f6841i;
                        long j9 = j5;
                        xVar.getClass();
                        long j10 = j9;
                        while (true) {
                            if (j10 > j6) {
                                synchronized (xVar.f6831f) {
                                    z6 = xVar.f6827b;
                                    if (xVar.f6829d.f7180b + j10 > xVar.f6826a) {
                                        z7 = true;
                                    } else {
                                        z7 = false;
                                    }
                                }
                                if (z7) {
                                    hVar.h(j10);
                                    xVar.f6831f.e(ErrorCode.f6036e);
                                    break;
                                } else if (z6) {
                                    hVar.h(j10);
                                    break;
                                } else {
                                    long w4 = hVar.w(xVar.f6828c, j10);
                                    if (w4 != -1) {
                                        j10 -= w4;
                                        z zVar = xVar.f6831f;
                                        synchronized (zVar) {
                                            try {
                                                if (xVar.f6830e) {
                                                    y3.f fVar = xVar.f6828c;
                                                    fVar.h(fVar.f7180b);
                                                    j4 = 0;
                                                } else {
                                                    y3.f fVar2 = xVar.f6829d;
                                                    j4 = 0;
                                                    if (fVar2.f7180b == 0) {
                                                        z8 = true;
                                                    } else {
                                                        z8 = false;
                                                    }
                                                    fVar2.G(xVar.f6828c);
                                                    if (z8) {
                                                        zVar.notifyAll();
                                                    }
                                                }
                                            } catch (Throwable th) {
                                                throw th;
                                            }
                                        }
                                        j6 = j4;
                                    } else {
                                        throw new EOFException();
                                    }
                                }
                            } else {
                                byte[] bArr3 = n3.b.f5783a;
                                xVar.f6831f.f6834b.C(j9);
                                break;
                            }
                        }
                        if (z4) {
                            z9.i(n3.b.f5784b, true);
                        }
                    }
                }
                this.f6818a.h(i8);
                return;
            }
            throw new IOException("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA");
        }
        throw new IOException("PROTOCOL_ERROR: TYPE_DATA streamId == 0");
    }
}