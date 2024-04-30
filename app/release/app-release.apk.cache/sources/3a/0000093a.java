package p3;

import java.io.IOException;
import java.net.Socket;
import java.util.Iterator;
import q3.l;
import t3.s;

/* loaded from: classes.dex */
public final class b extends a {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ int f6149e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ Object f6150f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(int i4, Object obj, String str) {
        super(str, true);
        this.f6149e = i4;
        this.f6150f = obj;
    }

    @Override // p3.a
    public final long a() {
        int i4 = 0;
        switch (this.f6149e) {
            case 0:
                ((e3.a) this.f6150f).a();
                return -1L;
            case 1:
                l lVar = (l) this.f6150f;
                long nanoTime = System.nanoTime();
                Iterator it = lVar.f6420e.iterator();
                long j4 = Long.MIN_VALUE;
                okhttp3.internal.connection.a aVar = null;
                int i5 = 0;
                while (it.hasNext()) {
                    okhttp3.internal.connection.a aVar2 = (okhttp3.internal.connection.a) it.next();
                    com.google.common.collect.c.E(aVar2, "connection");
                    synchronized (aVar2) {
                        if (lVar.b(aVar2, nanoTime) > 0) {
                            i5++;
                        } else {
                            i4++;
                            long j5 = nanoTime - aVar2.f6032q;
                            if (j5 > j4) {
                                aVar = aVar2;
                                j4 = j5;
                            }
                        }
                    }
                }
                long j6 = lVar.f6417b;
                if (j4 < j6 && i4 <= lVar.f6416a) {
                    if (i4 > 0) {
                        return j6 - j4;
                    }
                    if (i5 <= 0) {
                        return -1L;
                    }
                    return j6;
                }
                com.google.common.collect.c.C(aVar);
                synchronized (aVar) {
                    if (!(!aVar.f6031p.isEmpty()) && aVar.f6032q + j4 == nanoTime) {
                        aVar.f6025j = true;
                        lVar.f6420e.remove(aVar);
                        Socket socket = aVar.f6019d;
                        com.google.common.collect.c.C(socket);
                        n3.b.e(socket);
                        if (lVar.f6420e.isEmpty()) {
                            lVar.f6418c.a();
                        }
                    }
                }
                return 0L;
            default:
                s sVar = (s) this.f6150f;
                sVar.getClass();
                try {
                    sVar.f6801y.B(2, 0, false);
                } catch (IOException e4) {
                    sVar.y(e4);
                }
                return -1L;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(l lVar, String str) {
        super(str, true);
        this.f6149e = 1;
        this.f6150f = lVar;
    }
}