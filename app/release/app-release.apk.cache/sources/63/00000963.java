package q3;

import java.net.Proxy;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.EmptyList;
import m3.o;

/* loaded from: classes.dex */
public final class m {

    /* renamed from: a  reason: collision with root package name */
    public final m3.a f6421a;

    /* renamed from: b  reason: collision with root package name */
    public final w1.g f6422b;

    /* renamed from: c  reason: collision with root package name */
    public final m3.d f6423c;

    /* renamed from: d  reason: collision with root package name */
    public final m3.k f6424d;

    /* renamed from: e  reason: collision with root package name */
    public final List f6425e;

    /* renamed from: f  reason: collision with root package name */
    public int f6426f;

    /* renamed from: g  reason: collision with root package name */
    public List f6427g;

    /* renamed from: h  reason: collision with root package name */
    public final ArrayList f6428h;

    public m(m3.a aVar, w1.g gVar, j jVar, m3.k kVar) {
        List l4;
        com.google.common.collect.c.F(aVar, "address");
        com.google.common.collect.c.F(gVar, "routeDatabase");
        com.google.common.collect.c.F(jVar, "call");
        com.google.common.collect.c.F(kVar, "eventListener");
        this.f6421a = aVar;
        this.f6422b = gVar;
        this.f6423c = jVar;
        this.f6424d = kVar;
        EmptyList emptyList = EmptyList.f5181a;
        this.f6425e = emptyList;
        this.f6427g = emptyList;
        this.f6428h = new ArrayList();
        o oVar = aVar.f5468i;
        com.google.common.collect.c.F(oVar, "url");
        Proxy proxy = aVar.f5466g;
        if (proxy != null) {
            l4 = com.google.common.collect.c.c1(proxy);
        } else {
            URI g4 = oVar.g();
            if (g4.getHost() == null) {
                l4 = n3.b.l(Proxy.NO_PROXY);
            } else {
                List<Proxy> select = aVar.f5467h.select(g4);
                if (select != null && !select.isEmpty()) {
                    l4 = n3.b.x(select);
                } else {
                    l4 = n3.b.l(Proxy.NO_PROXY);
                }
            }
        }
        this.f6425e = l4;
        this.f6426f = 0;
    }

    public final boolean a() {
        boolean z4;
        if (this.f6426f < this.f6425e.size()) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (!z4 && !(!this.f6428h.isEmpty())) {
            return false;
        }
        return true;
    }
}