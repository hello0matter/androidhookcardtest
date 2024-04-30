package r3;

import androidx.appcompat.widget.z;
import kotlin.collections.EmptyList;
import m3.i;
import m3.k;
import m3.l;
import m3.m;
import m3.o;
import m3.p;
import m3.q;
import m3.t;
import m3.u;
import m3.v;
import m3.w;
import m3.x;
import m3.y;
import y3.j;

/* loaded from: classes.dex */
public final class a implements p {

    /* renamed from: a  reason: collision with root package name */
    public final i f6469a;

    public a(k kVar) {
        com.google.common.collect.c.F(kVar, "cookieJar");
        this.f6469a = kVar;
    }

    @Override // m3.p
    public final w a(f fVar) {
        y yVar;
        z zVar = fVar.f6476e;
        t e4 = zVar.e();
        u uVar = (u) zVar.f992e;
        if (uVar != null) {
            q qVar = uVar.f5607a;
            if (qVar != null) {
                e4.b("Content-Type", qVar.f5554a);
            }
            long j4 = uVar.f5608b;
            if (j4 != -1) {
                e4.b("Content-Length", String.valueOf(j4));
                e4.f5604c.c("Transfer-Encoding");
            } else {
                e4.b("Transfer-Encoding", "chunked");
                e4.f5604c.c("Content-Length");
            }
        }
        Object obj = zVar.f991d;
        String a5 = ((m) obj).a("Host");
        boolean z4 = false;
        Object obj2 = zVar.f989b;
        if (a5 == null) {
            e4.b("Host", n3.b.w((o) obj2, false));
        }
        if (((m) obj).a("Connection") == null) {
            e4.b("Connection", "Keep-Alive");
        }
        if (((m) obj).a("Accept-Encoding") == null && ((m) obj).a("Range") == null) {
            e4.b("Accept-Encoding", "gzip");
            z4 = true;
        }
        o oVar = (o) obj2;
        i iVar = this.f6469a;
        ((k) iVar).getClass();
        com.google.common.collect.c.F(oVar, "url");
        EmptyList.f5181a.getClass();
        if (((m) obj).a("User-Agent") == null) {
            e4.b("User-Agent", "okhttp/4.12.0");
        }
        w b5 = fVar.b(e4.a());
        m mVar = b5.f5629f;
        e.b(iVar, oVar, mVar);
        v y4 = b5.y();
        y4.f5611a = zVar;
        if (z4 && l3.g.j2("gzip", w.x(b5, "Content-Encoding")) && e.a(b5) && (yVar = b5.f5630g) != null) {
            j jVar = new j(((x) yVar).f5639c);
            l c4 = mVar.c();
            c4.c("Content-Encoding");
            c4.c("Content-Length");
            y4.f5616f = c4.b().c();
            y4.f5617g = new x(w.x(b5, "Content-Type"), -1L, new y3.o(jVar));
        }
        return y4.a();
    }
}