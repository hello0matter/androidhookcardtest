package y3;

import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

/* loaded from: classes.dex */
public final class j implements t {

    /* renamed from: a  reason: collision with root package name */
    public byte f7182a;

    /* renamed from: b  reason: collision with root package name */
    public final o f7183b;

    /* renamed from: c  reason: collision with root package name */
    public final Inflater f7184c;

    /* renamed from: d  reason: collision with root package name */
    public final k f7185d;

    /* renamed from: e  reason: collision with root package name */
    public final CRC32 f7186e;

    public j(t tVar) {
        com.google.common.collect.c.F(tVar, "source");
        o oVar = new o(tVar);
        this.f7183b = oVar;
        Inflater inflater = new Inflater(true);
        this.f7184c = inflater;
        this.f7185d = new k(oVar, inflater);
        this.f7186e = new CRC32();
    }

    public static void x(int i4, int i5, String str) {
        if (i5 == i4) {
            return;
        }
        throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", Arrays.copyOf(new Object[]{str, Integer.valueOf(i5), Integer.valueOf(i4)}, 3)));
    }

    @Override // y3.t
    public final v a() {
        return this.f7183b.f7197a.a();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f7185d.close();
    }

    @Override // y3.t
    public final long w(f fVar, long j4) {
        o oVar;
        boolean z4;
        f fVar2;
        long j5;
        com.google.common.collect.c.F(fVar, "sink");
        int i4 = (j4 > 0L ? 1 : (j4 == 0L ? 0 : -1));
        if (i4 >= 0) {
            if (i4 == 0) {
                return 0L;
            }
            byte b5 = this.f7182a;
            CRC32 crc32 = this.f7186e;
            o oVar2 = this.f7183b;
            if (b5 == 0) {
                oVar2.o(10L);
                f fVar3 = oVar2.f7198b;
                byte y4 = fVar3.y(3L);
                if (((y4 >> 1) & 1) == 1) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (z4) {
                    y(oVar2.f7198b, 0L, 10L);
                }
                x(8075, oVar2.i(), "ID1ID2");
                oVar2.h(8L);
                if (((y4 >> 2) & 1) == 1) {
                    oVar2.o(2L);
                    if (z4) {
                        y(oVar2.f7198b, 0L, 2L);
                    }
                    short i5 = fVar3.i();
                    long j6 = ((short) (((i5 & 255) << 8) | ((i5 & 65280) >>> 8))) & 65535;
                    oVar2.o(j6);
                    if (z4) {
                        y(oVar2.f7198b, 0L, j6);
                        j5 = j6;
                    } else {
                        j5 = j6;
                    }
                    oVar2.h(j5);
                }
                if (((y4 >> 3) & 1) == 1) {
                    fVar2 = fVar3;
                    long x4 = oVar2.x((byte) 0, 0L, Long.MAX_VALUE);
                    if (x4 != -1) {
                        if (z4) {
                            oVar = oVar2;
                            y(oVar2.f7198b, 0L, x4 + 1);
                        } else {
                            oVar = oVar2;
                        }
                        oVar.h(x4 + 1);
                    } else {
                        throw new EOFException();
                    }
                } else {
                    fVar2 = fVar3;
                    oVar = oVar2;
                }
                if (((y4 >> 4) & 1) == 1) {
                    long x5 = oVar.x((byte) 0, 0L, Long.MAX_VALUE);
                    if (x5 != -1) {
                        if (z4) {
                            y(oVar.f7198b, 0L, x5 + 1);
                        }
                        oVar.h(x5 + 1);
                    } else {
                        throw new EOFException();
                    }
                }
                if (z4) {
                    oVar.o(2L);
                    short i6 = fVar2.i();
                    x((short) (((i6 & 255) << 8) | ((i6 & 65280) >>> 8)), (short) crc32.getValue(), "FHCRC");
                    crc32.reset();
                }
                this.f7182a = (byte) 1;
            } else {
                oVar = oVar2;
            }
            if (this.f7182a == 1) {
                long j7 = fVar.f7180b;
                long w4 = this.f7185d.w(fVar, j4);
                if (w4 != -1) {
                    y(fVar, j7, w4);
                    return w4;
                }
                this.f7182a = (byte) 2;
            }
            if (this.f7182a == 2) {
                x(oVar.y(), (int) crc32.getValue(), "CRC");
                x(oVar.y(), (int) this.f7184c.getBytesWritten(), "ISIZE");
                this.f7182a = (byte) 3;
                if (oVar.r()) {
                    return -1L;
                }
                throw new IOException("gzip finished without exhausting source");
            }
            return -1L;
        }
        throw new IllegalArgumentException(("byteCount < 0: " + j4).toString());
    }

    public final void y(f fVar, long j4, long j5) {
        int i4;
        p pVar = fVar.f7179a;
        while (true) {
            com.google.common.collect.c.C(pVar);
            int i5 = pVar.f7202c;
            int i6 = pVar.f7201b;
            if (j4 < i5 - i6) {
                break;
            }
            j4 -= i5 - i6;
            pVar = pVar.f7205f;
        }
        while (j5 > 0) {
            int min = (int) Math.min(pVar.f7202c - i4, j5);
            this.f7186e.update(pVar.f7200a, (int) (pVar.f7201b + j4), min);
            j5 -= min;
            pVar = pVar.f7205f;
            com.google.common.collect.c.C(pVar);
            j4 = 0;
        }
    }
}