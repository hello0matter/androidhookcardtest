package y3;

import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class i extends v {

    /* renamed from: e  reason: collision with root package name */
    public v f7181e;

    public i(v vVar) {
        com.google.common.collect.c.F(vVar, "delegate");
        this.f7181e = vVar;
    }

    @Override // y3.v
    public final v a() {
        return this.f7181e.a();
    }

    @Override // y3.v
    public final v b() {
        return this.f7181e.b();
    }

    @Override // y3.v
    public final long c() {
        return this.f7181e.c();
    }

    @Override // y3.v
    public final v d(long j4) {
        return this.f7181e.d(j4);
    }

    @Override // y3.v
    public final boolean e() {
        return this.f7181e.e();
    }

    @Override // y3.v
    public final void f() {
        this.f7181e.f();
    }

    @Override // y3.v
    public final v g(long j4, TimeUnit timeUnit) {
        com.google.common.collect.c.F(timeUnit, "unit");
        return this.f7181e.g(j4, timeUnit);
    }
}