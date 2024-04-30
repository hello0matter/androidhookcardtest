package q3;

import androidx.fragment.app.n;
import java.io.IOException;
import m3.o;
import m3.z;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.StreamResetException;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    public final l f6382a;

    /* renamed from: b  reason: collision with root package name */
    public final m3.a f6383b;

    /* renamed from: c  reason: collision with root package name */
    public final j f6384c;

    /* renamed from: d  reason: collision with root package name */
    public final m3.k f6385d;

    /* renamed from: e  reason: collision with root package name */
    public n f6386e;

    /* renamed from: f  reason: collision with root package name */
    public m f6387f;

    /* renamed from: g  reason: collision with root package name */
    public int f6388g;

    /* renamed from: h  reason: collision with root package name */
    public int f6389h;

    /* renamed from: i  reason: collision with root package name */
    public int f6390i;

    /* renamed from: j  reason: collision with root package name */
    public z f6391j;

    public f(l lVar, m3.a aVar, j jVar, m3.k kVar) {
        com.google.common.collect.c.F(lVar, "connectionPool");
        com.google.common.collect.c.F(kVar, "eventListener");
        this.f6382a = lVar;
        this.f6383b = aVar;
        this.f6384c = jVar;
        this.f6385d = kVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:141:0x034a  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x02df A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0349 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final okhttp3.internal.connection.a a(int r15, int r16, int r17, boolean r18, boolean r19) {
        /*
            Method dump skipped, instructions count: 919
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: q3.f.a(int, int, int, boolean, boolean):okhttp3.internal.connection.a");
    }

    public final boolean b(o oVar) {
        com.google.common.collect.c.F(oVar, "url");
        o oVar2 = this.f6383b.f5468i;
        if (oVar.f5547e == oVar2.f5547e && com.google.common.collect.c.n(oVar.f5546d, oVar2.f5546d)) {
            return true;
        }
        return false;
    }

    public final void c(IOException iOException) {
        com.google.common.collect.c.F(iOException, "e");
        this.f6391j = null;
        if (iOException instanceof StreamResetException) {
            if (((StreamResetException) iOException).f6041a == ErrorCode.f6037f) {
                this.f6388g++;
                return;
            }
        }
        if (iOException instanceof ConnectionShutdownException) {
            this.f6389h++;
        } else {
            this.f6390i++;
        }
    }
}