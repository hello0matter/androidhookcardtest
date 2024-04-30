package r3;

import androidx.appcompat.widget.z;
import java.util.List;
import m3.o;
import m3.p;
import m3.w;
import q3.j;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    public final j f6472a;

    /* renamed from: b  reason: collision with root package name */
    public final List f6473b;

    /* renamed from: c  reason: collision with root package name */
    public final int f6474c;

    /* renamed from: d  reason: collision with root package name */
    public final q3.e f6475d;

    /* renamed from: e  reason: collision with root package name */
    public final z f6476e;

    /* renamed from: f  reason: collision with root package name */
    public final int f6477f;

    /* renamed from: g  reason: collision with root package name */
    public final int f6478g;

    /* renamed from: h  reason: collision with root package name */
    public final int f6479h;

    /* renamed from: i  reason: collision with root package name */
    public int f6480i;

    public f(j jVar, List list, int i4, q3.e eVar, z zVar, int i5, int i6, int i7) {
        com.google.common.collect.c.F(jVar, "call");
        com.google.common.collect.c.F(list, "interceptors");
        com.google.common.collect.c.F(zVar, "request");
        this.f6472a = jVar;
        this.f6473b = list;
        this.f6474c = i4;
        this.f6475d = eVar;
        this.f6476e = zVar;
        this.f6477f = i5;
        this.f6478g = i6;
        this.f6479h = i7;
    }

    public static f a(f fVar, int i4, q3.e eVar, z zVar, int i5) {
        if ((i5 & 1) != 0) {
            i4 = fVar.f6474c;
        }
        int i6 = i4;
        if ((i5 & 2) != 0) {
            eVar = fVar.f6475d;
        }
        q3.e eVar2 = eVar;
        if ((i5 & 4) != 0) {
            zVar = fVar.f6476e;
        }
        z zVar2 = zVar;
        int i7 = fVar.f6477f;
        int i8 = fVar.f6478g;
        int i9 = fVar.f6479h;
        fVar.getClass();
        com.google.common.collect.c.F(zVar2, "request");
        return new f(fVar.f6472a, fVar.f6473b, i6, eVar2, zVar2, i7, i8, i9);
    }

    public final w b(z zVar) {
        com.google.common.collect.c.F(zVar, "request");
        List list = this.f6473b;
        int size = list.size();
        int i4 = this.f6474c;
        if (i4 < size) {
            this.f6480i++;
            q3.e eVar = this.f6475d;
            if (eVar != null) {
                if (eVar.f6377c.b((o) zVar.f989b)) {
                    if (this.f6480i != 1) {
                        throw new IllegalStateException(("network interceptor " + list.get(i4 - 1) + " must call proceed() exactly once").toString());
                    }
                } else {
                    throw new IllegalStateException(("network interceptor " + list.get(i4 - 1) + " must retain the same host and port").toString());
                }
            }
            int i5 = i4 + 1;
            f a5 = a(this, i5, null, zVar, 58);
            p pVar = (p) list.get(i4);
            w a6 = pVar.a(a5);
            if (a6 != null) {
                if (eVar != null && i5 < list.size() && a5.f6480i != 1) {
                    throw new IllegalStateException(("network interceptor " + pVar + " must call proceed() exactly once").toString());
                } else if (a6.f5630g != null) {
                    return a6;
                } else {
                    throw new IllegalStateException(("interceptor " + pVar + " returned a response with no body").toString());
                }
            }
            throw new NullPointerException("interceptor " + pVar + " returned null");
        }
        throw new IllegalStateException("Check failed.".toString());
    }
}