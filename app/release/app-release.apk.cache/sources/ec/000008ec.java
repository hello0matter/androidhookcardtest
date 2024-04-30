package o3;

import androidx.appcompat.widget.z;
import androidx.fragment.app.m0;
import com.google.common.collect.c;
import java.util.ArrayList;
import l3.g;
import m3.k;
import m3.m;
import m3.p;
import m3.v;
import m3.w;
import m3.y;
import okhttp3.Protocol;
import q3.j;
import r3.f;

/* loaded from: classes.dex */
public final class a implements p {
    @Override // m3.p
    public final w a(f fVar) {
        j jVar;
        String str;
        m mVar;
        String str2;
        System.currentTimeMillis();
        z zVar = fVar.f6476e;
        c.F(zVar, "request");
        b bVar = new b(zVar, null);
        m3.c cVar = (m3.c) zVar.f994g;
        if (cVar == null) {
            int i4 = m3.c.f5472n;
            cVar = m0.q((m) zVar.f991d);
            zVar.f994g = cVar;
        }
        if (cVar.f5482j) {
            bVar = new b(null, null);
        }
        j jVar2 = fVar.f6472a;
        if (jVar2 instanceof j) {
            jVar = jVar2;
        } else {
            jVar = null;
        }
        if (jVar != null) {
            k kVar = jVar.f6401e;
        }
        z zVar2 = bVar.f5982a;
        w wVar = bVar.f5983b;
        if (zVar2 == null && wVar == null) {
            v vVar = new v();
            vVar.f5611a = zVar;
            vVar.f5612b = Protocol.HTTP_1_1;
            vVar.f5613c = 504;
            vVar.f5614d = "Unsatisfiable Request (only-if-cached)";
            vVar.f5617g = n3.b.f5785c;
            vVar.f5621k = -1L;
            vVar.f5622l = System.currentTimeMillis();
            w a5 = vVar.a();
            c.F(jVar2, "call");
            return a5;
        } else if (zVar2 == null) {
            c.C(wVar);
            v y4 = wVar.y();
            w d4 = m0.d(wVar);
            v.b("cacheResponse", d4);
            y4.f5619i = d4;
            w a6 = y4.a();
            c.F(jVar2, "call");
            return a6;
        } else {
            if (wVar != null) {
                c.F(jVar2, "call");
            }
            w b5 = fVar.b(zVar2);
            String str3 = "networkResponse";
            if (wVar == null) {
                str = "networkResponse";
            } else if (b5.f5627d != 304) {
                str = "networkResponse";
                y yVar = wVar.f5630g;
                if (yVar != null) {
                    n3.b.d(yVar);
                }
            } else {
                v y5 = wVar.y();
                ArrayList arrayList = new ArrayList(20);
                m mVar2 = wVar.f5629f;
                int size = mVar2.size();
                int i5 = 0;
                while (true) {
                    mVar = b5.f5629f;
                    if (i5 >= size) {
                        break;
                    }
                    String b6 = mVar2.b(i5);
                    int i6 = size;
                    String d5 = mVar2.d(i5);
                    m mVar3 = mVar2;
                    if (g.j2("Warning", b6)) {
                        str2 = str3;
                        if (g.o2(d5, "1", false)) {
                            i5++;
                            size = i6;
                            mVar2 = mVar3;
                            str3 = str2;
                        }
                    } else {
                        str2 = str3;
                    }
                    if (g.j2("Content-Length", b6) || g.j2("Content-Encoding", b6) || g.j2("Content-Type", b6) || !m0.n(b6) || mVar.a(b6) == null) {
                        c.F(b6, "name");
                        c.F(d5, "value");
                        arrayList.add(b6);
                        arrayList.add(kotlin.text.b.C2(d5).toString());
                    }
                    i5++;
                    size = i6;
                    mVar2 = mVar3;
                    str3 = str2;
                }
                String str4 = str3;
                int size2 = mVar.size();
                for (int i7 = 0; i7 < size2; i7++) {
                    String b7 = mVar.b(i7);
                    if (!g.j2("Content-Length", b7) && !g.j2("Content-Encoding", b7) && !g.j2("Content-Type", b7) && m0.n(b7)) {
                        String d6 = mVar.d(i7);
                        c.F(b7, "name");
                        c.F(d6, "value");
                        arrayList.add(b7);
                        arrayList.add(kotlin.text.b.C2(d6).toString());
                    }
                }
                y5.f5616f = new m((String[]) arrayList.toArray(new String[0])).c();
                y5.f5621k = b5.f5634k;
                y5.f5622l = b5.f5635l;
                w d7 = m0.d(wVar);
                v.b("cacheResponse", d7);
                y5.f5619i = d7;
                w d8 = m0.d(b5);
                v.b(str4, d8);
                y5.f5618h = d8;
                y5.a();
                y yVar2 = b5.f5630g;
                c.C(yVar2);
                yVar2.close();
                c.C(null);
                throw null;
            }
            v y6 = b5.y();
            w d9 = m0.d(wVar);
            v.b("cacheResponse", d9);
            y6.f5619i = d9;
            w d10 = m0.d(b5);
            v.b(str, d10);
            y6.f5618h = d10;
            return y6.a();
        }
    }
}