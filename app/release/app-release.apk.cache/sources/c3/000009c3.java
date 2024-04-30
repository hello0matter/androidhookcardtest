package t3;

import androidx.fragment.app.m0;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import okhttp3.Protocol;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.StreamResetException;

/* loaded from: classes.dex */
public final class t implements r3.d {

    /* renamed from: g  reason: collision with root package name */
    public static final List f6803g = n3.b.l("connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade", ":method", ":path", ":scheme", ":authority");

    /* renamed from: h  reason: collision with root package name */
    public static final List f6804h = n3.b.l("connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade");

    /* renamed from: a  reason: collision with root package name */
    public final okhttp3.internal.connection.a f6805a;

    /* renamed from: b  reason: collision with root package name */
    public final r3.f f6806b;

    /* renamed from: c  reason: collision with root package name */
    public final s f6807c;

    /* renamed from: d  reason: collision with root package name */
    public volatile z f6808d;

    /* renamed from: e  reason: collision with root package name */
    public final Protocol f6809e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f6810f;

    public t(m3.s sVar, okhttp3.internal.connection.a aVar, r3.f fVar, s sVar2) {
        com.google.common.collect.c.F(aVar, "connection");
        this.f6805a = aVar;
        this.f6806b = fVar;
        this.f6807c = sVar2;
        Protocol protocol = Protocol.H2_PRIOR_KNOWLEDGE;
        this.f6809e = sVar.f5594r.contains(protocol) ? protocol : Protocol.HTTP_2;
    }

    @Override // r3.d
    public final y3.t a(m3.w wVar) {
        z zVar = this.f6808d;
        com.google.common.collect.c.C(zVar);
        return zVar.f6841i;
    }

    @Override // r3.d
    public final y3.r b(androidx.appcompat.widget.z zVar, long j4) {
        z zVar2 = this.f6808d;
        com.google.common.collect.c.C(zVar2);
        return zVar2.f();
    }

    @Override // r3.d
    public final void c() {
        z zVar = this.f6808d;
        com.google.common.collect.c.C(zVar);
        zVar.f().close();
    }

    @Override // r3.d
    public final void cancel() {
        this.f6810f = true;
        z zVar = this.f6808d;
        if (zVar != null) {
            zVar.e(ErrorCode.f6038g);
        }
    }

    @Override // r3.d
    public final long d(m3.w wVar) {
        if (!r3.e.a(wVar)) {
            return 0L;
        }
        return n3.b.k(wVar);
    }

    @Override // r3.d
    public final void e() {
        this.f6807c.flush();
    }

    @Override // r3.d
    public final m3.v f(boolean z4) {
        m3.m mVar;
        z zVar = this.f6808d;
        if (zVar != null) {
            synchronized (zVar) {
                zVar.f6843k.h();
                while (zVar.f6839g.isEmpty() && zVar.f6845m == null) {
                    zVar.k();
                }
                zVar.f6843k.l();
                if (!zVar.f6839g.isEmpty()) {
                    Object removeFirst = zVar.f6839g.removeFirst();
                    com.google.common.collect.c.E(removeFirst, "headersQueue.removeFirst()");
                    mVar = (m3.m) removeFirst;
                } else {
                    IOException iOException = zVar.f6846n;
                    if (iOException == null) {
                        ErrorCode errorCode = zVar.f6845m;
                        com.google.common.collect.c.C(errorCode);
                        throw new StreamResetException(errorCode);
                    }
                    throw iOException;
                }
            }
            Protocol protocol = this.f6809e;
            com.google.common.collect.c.F(protocol, "protocol");
            ArrayList arrayList = new ArrayList(20);
            int size = mVar.size();
            r3.h hVar = null;
            for (int i4 = 0; i4 < size; i4++) {
                String b5 = mVar.b(i4);
                String d4 = mVar.d(i4);
                if (com.google.common.collect.c.n(b5, ":status")) {
                    hVar = m0.r("HTTP/1.1 " + d4);
                } else if (!f6804h.contains(b5)) {
                    com.google.common.collect.c.F(b5, "name");
                    com.google.common.collect.c.F(d4, "value");
                    arrayList.add(b5);
                    arrayList.add(kotlin.text.b.C2(d4).toString());
                }
            }
            if (hVar != null) {
                m3.v vVar = new m3.v();
                vVar.f5612b = protocol;
                vVar.f5613c = hVar.f6483b;
                String str = hVar.f6484c;
                com.google.common.collect.c.F(str, "message");
                vVar.f5614d = str;
                String[] strArr = (String[]) arrayList.toArray(new String[0]);
                m3.l lVar = new m3.l();
                ArrayList arrayList2 = lVar.f5532a;
                com.google.common.collect.c.F(arrayList2, "<this>");
                com.google.common.collect.c.F(strArr, "elements");
                List asList = Arrays.asList(strArr);
                com.google.common.collect.c.E(asList, "asList(this)");
                arrayList2.addAll(asList);
                vVar.f5616f = lVar;
                if (z4 && vVar.f5613c == 100) {
                    return null;
                }
                return vVar;
            }
            throw new ProtocolException("Expected ':status' header not present");
        }
        throw new IOException("stream wasn't created");
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x0119 A[Catch: all -> 0x00e1, TRY_LEAVE, TryCatch #2 {, blocks: (B:27:0x00d3, B:47:0x0122, B:48:0x0123, B:49:0x0125, B:64:0x015d, B:28:0x00d4, B:30:0x00db, B:33:0x00e4, B:35:0x00e8, B:37:0x00ff, B:39:0x0107, B:44:0x0113, B:46:0x0119, B:80:0x01ab, B:81:0x01b0, B:50:0x0126, B:52:0x012a, B:57:0x0145, B:58:0x0147, B:60:0x0156, B:74:0x019f, B:75:0x01a6), top: B:86:0x00d3 }] */
    @Override // r3.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void g(androidx.appcompat.widget.z r19) {
        /*
            Method dump skipped, instructions count: 437
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: t3.t.g(androidx.appcompat.widget.z):void");
    }

    @Override // r3.d
    public final okhttp3.internal.connection.a h() {
        return this.f6805a;
    }
}