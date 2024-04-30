package s3;

import androidx.appcompat.widget.z;
import androidx.fragment.app.m0;
import java.io.EOFException;
import java.io.IOException;
import java.net.Proxy;
import java.net.Socket;
import m3.m;
import m3.o;
import m3.s;
import m3.u;
import m3.v;
import m3.w;
import okhttp3.Protocol;
import y3.r;
import y3.t;

/* loaded from: classes.dex */
public final class h implements r3.d {

    /* renamed from: a  reason: collision with root package name */
    public final s f6553a;

    /* renamed from: b  reason: collision with root package name */
    public final okhttp3.internal.connection.a f6554b;

    /* renamed from: c  reason: collision with root package name */
    public final y3.h f6555c;

    /* renamed from: d  reason: collision with root package name */
    public final y3.g f6556d;

    /* renamed from: e  reason: collision with root package name */
    public int f6557e;

    /* renamed from: f  reason: collision with root package name */
    public final a f6558f;

    /* renamed from: g  reason: collision with root package name */
    public m f6559g;

    public h(s sVar, okhttp3.internal.connection.a aVar, y3.h hVar, y3.g gVar) {
        com.google.common.collect.c.F(aVar, "connection");
        this.f6553a = sVar;
        this.f6554b = aVar;
        this.f6555c = hVar;
        this.f6556d = gVar;
        this.f6558f = new a(hVar);
    }

    @Override // r3.d
    public final t a(w wVar) {
        if (!r3.e.a(wVar)) {
            return i(0L);
        }
        if (l3.g.j2("chunked", w.x(wVar, "Transfer-Encoding"))) {
            o oVar = (o) wVar.f5624a.f989b;
            if (this.f6557e == 4) {
                this.f6557e = 5;
                return new d(this, oVar);
            }
            throw new IllegalStateException(("state: " + this.f6557e).toString());
        }
        long k4 = n3.b.k(wVar);
        if (k4 != -1) {
            return i(k4);
        }
        if (this.f6557e == 4) {
            this.f6557e = 5;
            this.f6554b.k();
            return new b(this);
        }
        throw new IllegalStateException(("state: " + this.f6557e).toString());
    }

    @Override // r3.d
    public final r b(z zVar, long j4) {
        u uVar = (u) zVar.f992e;
        if (uVar != null) {
            uVar.getClass();
        }
        if (l3.g.j2("chunked", ((m) zVar.f991d).a("Transfer-Encoding"))) {
            if (this.f6557e == 1) {
                this.f6557e = 2;
                return new c(this);
            }
            throw new IllegalStateException(("state: " + this.f6557e).toString());
        } else if (j4 != -1) {
            if (this.f6557e == 1) {
                this.f6557e = 2;
                return new f(this);
            }
            throw new IllegalStateException(("state: " + this.f6557e).toString());
        } else {
            throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
        }
    }

    @Override // r3.d
    public final void c() {
        this.f6556d.flush();
    }

    @Override // r3.d
    public final void cancel() {
        Socket socket = this.f6554b.f6018c;
        if (socket != null) {
            n3.b.e(socket);
        }
    }

    @Override // r3.d
    public final long d(w wVar) {
        if (!r3.e.a(wVar)) {
            return 0L;
        }
        if (l3.g.j2("chunked", w.x(wVar, "Transfer-Encoding"))) {
            return -1L;
        }
        return n3.b.k(wVar);
    }

    @Override // r3.d
    public final void e() {
        this.f6556d.flush();
    }

    @Override // r3.d
    public final v f(boolean z4) {
        a aVar = this.f6558f;
        int i4 = this.f6557e;
        if (i4 != 1 && i4 != 2 && i4 != 3) {
            throw new IllegalStateException(("state: " + this.f6557e).toString());
        }
        try {
            String g4 = aVar.f6535a.g(aVar.f6536b);
            aVar.f6536b -= g4.length();
            r3.h r4 = m0.r(g4);
            int i5 = r4.f6483b;
            v vVar = new v();
            Protocol protocol = r4.f6482a;
            com.google.common.collect.c.F(protocol, "protocol");
            vVar.f5612b = protocol;
            vVar.f5613c = i5;
            String str = r4.f6484c;
            com.google.common.collect.c.F(str, "message");
            vVar.f5614d = str;
            vVar.f5616f = aVar.a().c();
            if (z4 && i5 == 100) {
                return null;
            }
            if (i5 != 100 && (102 > i5 || i5 >= 200)) {
                this.f6557e = 4;
                return vVar;
            }
            this.f6557e = 3;
            return vVar;
        } catch (EOFException e4) {
            throw new IOException("unexpected end of stream on " + this.f6554b.f6017b.f5641a.f5468i.f(), e4);
        }
    }

    @Override // r3.d
    public final void g(z zVar) {
        Proxy.Type type = this.f6554b.f6017b.f5642b.type();
        com.google.common.collect.c.E(type, "connection.route().proxy.type()");
        StringBuilder sb = new StringBuilder();
        sb.append((String) zVar.f990c);
        sb.append(' ');
        Object obj = zVar.f989b;
        if (!((o) obj).f5551i && type == Proxy.Type.HTTP) {
            sb.append((o) obj);
        } else {
            o oVar = (o) obj;
            com.google.common.collect.c.F(oVar, "url");
            String b5 = oVar.b();
            String d4 = oVar.d();
            if (d4 != null) {
                b5 = b5 + '?' + d4;
            }
            sb.append(b5);
        }
        sb.append(" HTTP/1.1");
        String sb2 = sb.toString();
        com.google.common.collect.c.E(sb2, "StringBuilder().apply(builderAction).toString()");
        j((m) zVar.f991d, sb2);
    }

    @Override // r3.d
    public final okhttp3.internal.connection.a h() {
        return this.f6554b;
    }

    public final e i(long j4) {
        if (this.f6557e == 4) {
            this.f6557e = 5;
            return new e(this, j4);
        }
        throw new IllegalStateException(("state: " + this.f6557e).toString());
    }

    public final void j(m mVar, String str) {
        com.google.common.collect.c.F(mVar, "headers");
        com.google.common.collect.c.F(str, "requestLine");
        if (this.f6557e == 0) {
            y3.g gVar = this.f6556d;
            gVar.p(str).p("\r\n");
            int size = mVar.size();
            for (int i4 = 0; i4 < size; i4++) {
                gVar.p(mVar.b(i4)).p(": ").p(mVar.d(i4)).p("\r\n");
            }
            gVar.p("\r\n");
            this.f6557e = 1;
            return;
        }
        throw new IllegalStateException(("state: " + this.f6557e).toString());
    }
}