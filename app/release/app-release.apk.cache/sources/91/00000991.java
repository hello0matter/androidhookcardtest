package s3;

import java.io.IOException;
import y3.i;
import y3.t;
import y3.v;

/* loaded from: classes.dex */
public abstract class b implements t {

    /* renamed from: a  reason: collision with root package name */
    public final i f6537a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f6538b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ h f6539c;

    public b(h hVar) {
        this.f6539c = hVar;
        this.f6537a = new i(hVar.f6555c.a());
    }

    @Override // y3.t
    public final v a() {
        return this.f6537a;
    }

    @Override // y3.t
    public long w(y3.f fVar, long j4) {
        h hVar = this.f6539c;
        com.google.common.collect.c.F(fVar, "sink");
        try {
            return hVar.f6555c.w(fVar, j4);
        } catch (IOException e4) {
            hVar.f6554b.k();
            x();
            throw e4;
        }
    }

    public final void x() {
        h hVar = this.f6539c;
        int i4 = hVar.f6557e;
        if (i4 == 6) {
            return;
        }
        if (i4 == 5) {
            i iVar = this.f6537a;
            v vVar = iVar.f7181e;
            iVar.f7181e = v.f7211d;
            vVar.a();
            vVar.b();
            hVar.f6557e = 6;
            return;
        }
        throw new IllegalStateException("state: " + hVar.f6557e);
    }
}