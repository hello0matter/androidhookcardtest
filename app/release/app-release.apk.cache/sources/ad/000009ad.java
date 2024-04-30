package t3;

import java.io.Closeable;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.internal.http2.ErrorCode;

/* loaded from: classes.dex */
public final class a0 implements Closeable {

    /* renamed from: g  reason: collision with root package name */
    public static final Logger f6695g = Logger.getLogger(f.class.getName());

    /* renamed from: a  reason: collision with root package name */
    public final y3.g f6696a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f6697b;

    /* renamed from: c  reason: collision with root package name */
    public final y3.f f6698c;

    /* renamed from: d  reason: collision with root package name */
    public int f6699d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f6700e;

    /* renamed from: f  reason: collision with root package name */
    public final d f6701f;

    /* JADX WARN: Type inference failed for: r1v1, types: [y3.f, java.lang.Object] */
    public a0(y3.g gVar, boolean z4) {
        this.f6696a = gVar;
        this.f6697b = z4;
        ?? obj = new Object();
        this.f6698c = obj;
        this.f6699d = 16384;
        this.f6701f = new d(obj);
    }

    public final synchronized void A(int i4, ErrorCode errorCode, byte[] bArr) {
        try {
            if (!this.f6700e) {
                if (errorCode.f6040a != -1) {
                    boolean z4 = false;
                    z(0, bArr.length + 8, 7, 0);
                    this.f6696a.l(i4);
                    this.f6696a.l(errorCode.f6040a);
                    if (bArr.length == 0) {
                        z4 = true;
                    }
                    if (!z4) {
                        this.f6696a.b(bArr);
                    }
                    this.f6696a.flush();
                } else {
                    throw new IllegalArgumentException("errorCode.httpCode == -1".toString());
                }
            } else {
                throw new IOException("closed");
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void B(int i4, int i5, boolean z4) {
        if (!this.f6700e) {
            z(0, 8, 6, z4 ? 1 : 0);
            this.f6696a.l(i4);
            this.f6696a.l(i5);
            this.f6696a.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public final synchronized void C(int i4, ErrorCode errorCode) {
        com.google.common.collect.c.F(errorCode, "errorCode");
        if (!this.f6700e) {
            if (errorCode.f6040a != -1) {
                z(i4, 4, 3, 0);
                this.f6696a.l(errorCode.f6040a);
                this.f6696a.flush();
            } else {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
        } else {
            throw new IOException("closed");
        }
    }

    public final synchronized void D(int i4, long j4) {
        if (!this.f6700e) {
            if (j4 != 0 && j4 <= 2147483647L) {
                z(i4, 4, 8, 0);
                this.f6696a.l((int) j4);
                this.f6696a.flush();
            } else {
                throw new IllegalArgumentException(("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: " + j4).toString());
            }
        } else {
            throw new IOException("closed");
        }
    }

    public final void E(int i4, long j4) {
        int i5;
        while (j4 > 0) {
            long min = Math.min(this.f6699d, j4);
            j4 -= min;
            int i6 = (int) min;
            if (j4 == 0) {
                i5 = 4;
            } else {
                i5 = 0;
            }
            z(i4, i6, 9, i5);
            this.f6696a.f(this.f6698c, min);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        this.f6700e = true;
        this.f6696a.close();
    }

    public final synchronized void flush() {
        if (!this.f6700e) {
            this.f6696a.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public final synchronized void x(d0 d0Var) {
        int i4;
        try {
            com.google.common.collect.c.F(d0Var, "peerSettings");
            if (!this.f6700e) {
                int i5 = this.f6699d;
                int i6 = d0Var.f6732a;
                if ((i6 & 32) != 0) {
                    i5 = d0Var.f6733b[5];
                }
                this.f6699d = i5;
                int i7 = -1;
                if ((i6 & 2) != 0) {
                    i4 = d0Var.f6733b[1];
                } else {
                    i4 = -1;
                }
                if (i4 != -1) {
                    d dVar = this.f6701f;
                    if ((i6 & 2) != 0) {
                        i7 = d0Var.f6733b[1];
                    }
                    dVar.getClass();
                    int min = Math.min(i7, 16384);
                    int i8 = dVar.f6727e;
                    if (i8 != min) {
                        if (min < i8) {
                            dVar.f6725c = Math.min(dVar.f6725c, min);
                        }
                        dVar.f6726d = true;
                        dVar.f6727e = min;
                        int i9 = dVar.f6731i;
                        if (min < i9) {
                            if (min == 0) {
                                b[] bVarArr = dVar.f6728f;
                                y2.h.l2(bVarArr, 0, bVarArr.length);
                                dVar.f6729g = dVar.f6728f.length - 1;
                                dVar.f6730h = 0;
                                dVar.f6731i = 0;
                            } else {
                                dVar.a(i9 - min);
                            }
                        }
                    }
                }
                z(0, 0, 4, 1);
                this.f6696a.flush();
            } else {
                throw new IOException("closed");
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void y(boolean z4, int i4, y3.f fVar, int i5) {
        if (!this.f6700e) {
            z(i4, i5, 0, z4 ? 1 : 0);
            if (i5 > 0) {
                com.google.common.collect.c.C(fVar);
                this.f6696a.f(fVar, i5);
            }
        } else {
            throw new IOException("closed");
        }
    }

    public final void z(int i4, int i5, int i6, int i7) {
        Level level = Level.FINE;
        Logger logger = f6695g;
        if (logger.isLoggable(level)) {
            logger.fine(f.a(false, i4, i5, i6, i7));
        }
        if (i5 <= this.f6699d) {
            if ((Integer.MIN_VALUE & i4) == 0) {
                byte[] bArr = n3.b.f5783a;
                y3.g gVar = this.f6696a;
                com.google.common.collect.c.F(gVar, "<this>");
                gVar.s((i5 >>> 16) & 255);
                gVar.s((i5 >>> 8) & 255);
                gVar.s(i5 & 255);
                gVar.s(i6 & 255);
                gVar.s(i7 & 255);
                gVar.l(i4 & Integer.MAX_VALUE);
                return;
            }
            throw new IllegalArgumentException(androidx.activity.j.b("reserved bit set: ", i4).toString());
        }
        throw new IllegalArgumentException(("FRAME_SIZE_ERROR length > " + this.f6699d + ": " + i5).toString());
    }
}