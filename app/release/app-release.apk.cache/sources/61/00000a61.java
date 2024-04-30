package y3;

import java.util.zip.Inflater;

/* loaded from: classes.dex */
public final class k implements t {

    /* renamed from: a  reason: collision with root package name */
    public final h f7187a;

    /* renamed from: b  reason: collision with root package name */
    public final Inflater f7188b;

    /* renamed from: c  reason: collision with root package name */
    public int f7189c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f7190d;

    public k(o oVar, Inflater inflater) {
        this.f7187a = oVar;
        this.f7188b = inflater;
    }

    @Override // y3.t
    public final v a() {
        return this.f7187a.a();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f7190d) {
            return;
        }
        this.f7188b.end();
        this.f7190d = true;
        this.f7187a.close();
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x008a A[SYNTHETIC] */
    @Override // y3.t
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long w(y3.f r11, long r12) {
        /*
            r10 = this;
            java.lang.String r0 = "sink"
            com.google.common.collect.c.F(r11, r0)
        L5:
            r0 = 0
            int r2 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r2 < 0) goto Lbd
            boolean r3 = r10.f7190d
            r4 = 1
            r3 = r3 ^ r4
            if (r3 == 0) goto Lb1
            y3.h r3 = r10.f7187a
            java.util.zip.Inflater r5 = r10.f7188b
            if (r2 != 0) goto L1a
        L17:
            r8 = r0
            goto L86
        L1a:
            y3.p r2 = r11.D(r4)     // Catch: java.util.zip.DataFormatException -> L74
            int r4 = r2.f7202c     // Catch: java.util.zip.DataFormatException -> L74
            int r4 = 8192 - r4
            long r6 = (long) r4     // Catch: java.util.zip.DataFormatException -> L74
            long r6 = java.lang.Math.min(r12, r6)     // Catch: java.util.zip.DataFormatException -> L74
            int r4 = (int) r6     // Catch: java.util.zip.DataFormatException -> L74
            boolean r6 = r5.needsInput()     // Catch: java.util.zip.DataFormatException -> L74
            if (r6 != 0) goto L2f
            goto L4b
        L2f:
            boolean r6 = r3.r()     // Catch: java.util.zip.DataFormatException -> L74
            if (r6 == 0) goto L36
            goto L4b
        L36:
            y3.f r6 = r3.q()     // Catch: java.util.zip.DataFormatException -> L74
            y3.p r6 = r6.f7179a     // Catch: java.util.zip.DataFormatException -> L74
            com.google.common.collect.c.C(r6)     // Catch: java.util.zip.DataFormatException -> L74
            int r7 = r6.f7202c     // Catch: java.util.zip.DataFormatException -> L74
            int r8 = r6.f7201b     // Catch: java.util.zip.DataFormatException -> L74
            int r7 = r7 - r8
            r10.f7189c = r7     // Catch: java.util.zip.DataFormatException -> L74
            byte[] r6 = r6.f7200a     // Catch: java.util.zip.DataFormatException -> L74
            r5.setInput(r6, r8, r7)     // Catch: java.util.zip.DataFormatException -> L74
        L4b:
            byte[] r6 = r2.f7200a     // Catch: java.util.zip.DataFormatException -> L74
            int r7 = r2.f7202c     // Catch: java.util.zip.DataFormatException -> L74
            int r4 = r5.inflate(r6, r7, r4)     // Catch: java.util.zip.DataFormatException -> L74
            int r6 = r10.f7189c     // Catch: java.util.zip.DataFormatException -> L74
            if (r6 != 0) goto L58
            goto L66
        L58:
            int r7 = r5.getRemaining()     // Catch: java.util.zip.DataFormatException -> L74
            int r6 = r6 - r7
            int r7 = r10.f7189c     // Catch: java.util.zip.DataFormatException -> L74
            int r7 = r7 - r6
            r10.f7189c = r7     // Catch: java.util.zip.DataFormatException -> L74
            long r6 = (long) r6     // Catch: java.util.zip.DataFormatException -> L74
            r3.h(r6)     // Catch: java.util.zip.DataFormatException -> L74
        L66:
            if (r4 <= 0) goto L76
            int r6 = r2.f7202c     // Catch: java.util.zip.DataFormatException -> L74
            int r6 = r6 + r4
            r2.f7202c = r6     // Catch: java.util.zip.DataFormatException -> L74
            long r6 = r11.f7180b     // Catch: java.util.zip.DataFormatException -> L74
            long r8 = (long) r4     // Catch: java.util.zip.DataFormatException -> L74
            long r6 = r6 + r8
            r11.f7180b = r6     // Catch: java.util.zip.DataFormatException -> L74
            goto L86
        L74:
            r11 = move-exception
            goto Lab
        L76:
            int r4 = r2.f7201b     // Catch: java.util.zip.DataFormatException -> L74
            int r6 = r2.f7202c     // Catch: java.util.zip.DataFormatException -> L74
            if (r4 != r6) goto L17
            y3.p r4 = r2.a()     // Catch: java.util.zip.DataFormatException -> L74
            r11.f7179a = r4     // Catch: java.util.zip.DataFormatException -> L74
            y3.q.a(r2)     // Catch: java.util.zip.DataFormatException -> L74
            goto L17
        L86:
            int r0 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r0 <= 0) goto L8b
            return r8
        L8b:
            boolean r0 = r5.finished()
            if (r0 != 0) goto La8
            boolean r0 = r5.needsDictionary()
            if (r0 == 0) goto L98
            goto La8
        L98:
            boolean r0 = r3.r()
            if (r0 != 0) goto La0
            goto L5
        La0:
            java.io.EOFException r11 = new java.io.EOFException
            java.lang.String r12 = "source exhausted prematurely"
            r11.<init>(r12)
            throw r11
        La8:
            r11 = -1
            return r11
        Lab:
            java.io.IOException r12 = new java.io.IOException
            r12.<init>(r11)
            throw r12
        Lb1:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "closed"
            java.lang.String r12 = r12.toString()
            r11.<init>(r12)
            throw r11
        Lbd:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            java.lang.String r0 = "byteCount < 0: "
            r11.<init>(r0)
            r11.append(r12)
            java.lang.String r11 = r11.toString()
            java.lang.IllegalArgumentException r12 = new java.lang.IllegalArgumentException
            java.lang.String r11 = r11.toString()
            r12.<init>(r11)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: y3.k.w(y3.f, long):long");
    }
}