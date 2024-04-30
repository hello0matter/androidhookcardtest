package q3;

import java.io.IOException;
import m3.p;
import m3.s;
import m3.w;
import okhttp3.internal.connection.RouteException;

/* loaded from: classes.dex */
public final class a implements p {

    /* renamed from: a  reason: collision with root package name */
    public static final a f6357a = new Object();

    @Override // m3.p
    public final w a(r3.f fVar) {
        j jVar = fVar.f6472a;
        jVar.getClass();
        synchronized (jVar) {
            try {
                if (jVar.f6411o) {
                    if (!jVar.f6410n) {
                        if (!(!jVar.f6409m)) {
                            throw new IllegalStateException("Check failed.".toString());
                        }
                    } else {
                        throw new IllegalStateException("Check failed.".toString());
                    }
                } else {
                    throw new IllegalStateException("released".toString());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        f fVar2 = jVar.f6405i;
        com.google.common.collect.c.C(fVar2);
        s sVar = jVar.f6397a;
        com.google.common.collect.c.F(sVar, "client");
        try {
            e eVar = new e(jVar, jVar.f6401e, fVar2, fVar2.a(fVar.f6477f, fVar.f6478g, fVar.f6479h, sVar.f5582f, !com.google.common.collect.c.n((String) fVar.f6476e.f990c, "GET")).j(sVar, fVar));
            jVar.f6408l = eVar;
            jVar.f6413q = eVar;
            synchronized (jVar) {
                jVar.f6409m = true;
                jVar.f6410n = true;
            }
            if (!jVar.f6412p) {
                return r3.f.a(fVar, 0, eVar, null, 61).b(fVar.f6476e);
            }
            throw new IOException("Canceled");
        } catch (IOException e4) {
            fVar2.c(e4);
            throw new RouteException(e4);
        } catch (RouteException e5) {
            fVar2.c(e5.f6016b);
            throw e5;
        }
    }
}