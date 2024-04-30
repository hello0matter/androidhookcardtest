package androidx.emoji2.text;

import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class t {

    /* renamed from: d  reason: collision with root package name */
    public static final ThreadLocal f1541d = new ThreadLocal();

    /* renamed from: a  reason: collision with root package name */
    public final int f1542a;

    /* renamed from: b  reason: collision with root package name */
    public final d0 f1543b;

    /* renamed from: c  reason: collision with root package name */
    public volatile int f1544c = 0;

    public t(d0 d0Var, int i4) {
        this.f1543b = d0Var;
        this.f1542a = i4;
    }

    public final int a(int i4) {
        r0.a c4 = c();
        int a5 = c4.a(16);
        if (a5 != 0) {
            ByteBuffer byteBuffer = c4.f6452b;
            int i5 = a5 + c4.f6451a;
            return byteBuffer.getInt((i4 * 4) + byteBuffer.getInt(i5) + i5 + 4);
        }
        return 0;
    }

    public final int b() {
        r0.a c4 = c();
        int a5 = c4.a(16);
        if (a5 != 0) {
            int i4 = a5 + c4.f6451a;
            return c4.f6452b.getInt(c4.f6452b.getInt(i4) + i4);
        }
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3, types: [r0.c, java.lang.Object] */
    public final r0.a c() {
        short s4;
        ThreadLocal threadLocal = f1541d;
        r0.a aVar = (r0.a) threadLocal.get();
        r0.a aVar2 = aVar;
        if (aVar == null) {
            ?? cVar = new r0.c();
            threadLocal.set(cVar);
            aVar2 = cVar;
        }
        r0.b bVar = this.f1543b.f1507a;
        int a5 = bVar.a(6);
        if (a5 != 0) {
            int i4 = a5 + bVar.f6451a;
            int i5 = (this.f1542a * 4) + bVar.f6452b.getInt(i4) + i4 + 4;
            int i6 = bVar.f6452b.getInt(i5) + i5;
            ByteBuffer byteBuffer = bVar.f6452b;
            aVar2.f6452b = byteBuffer;
            if (byteBuffer != null) {
                aVar2.f6451a = i6;
                int i7 = i6 - byteBuffer.getInt(i6);
                aVar2.f6453c = i7;
                s4 = aVar2.f6452b.getShort(i7);
            } else {
                s4 = 0;
                aVar2.f6451a = 0;
                aVar2.f6453c = 0;
            }
            aVar2.f6454d = s4;
        }
        return aVar2;
    }

    public final String toString() {
        int i4;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(", id:");
        r0.a c4 = c();
        int a5 = c4.a(4);
        if (a5 != 0) {
            i4 = c4.f6452b.getInt(a5 + c4.f6451a);
        } else {
            i4 = 0;
        }
        sb.append(Integer.toHexString(i4));
        sb.append(", codepoints:");
        int b5 = b();
        for (int i5 = 0; i5 < b5; i5++) {
            sb.append(Integer.toHexString(a(i5)));
            sb.append(" ");
        }
        return sb.toString();
    }
}