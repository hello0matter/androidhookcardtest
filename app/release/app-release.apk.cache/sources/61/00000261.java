package androidx.fragment.app;

import androidx.lifecycle.Lifecycle$Event;

/* loaded from: classes.dex */
public final class c1 implements androidx.lifecycle.h, z0.f, androidx.lifecycle.l0 {

    /* renamed from: a  reason: collision with root package name */
    public final androidx.lifecycle.k0 f1669a;

    /* renamed from: b  reason: collision with root package name */
    public androidx.lifecycle.s f1670b = null;

    /* renamed from: c  reason: collision with root package name */
    public z0.e f1671c = null;

    public c1(androidx.lifecycle.k0 k0Var) {
        this.f1669a = k0Var;
    }

    @Override // z0.f
    public final z0.d b() {
        d();
        return this.f1671c.f7226b;
    }

    public final void c(Lifecycle$Event lifecycle$Event) {
        this.f1670b.e(lifecycle$Event);
    }

    public final void d() {
        if (this.f1670b == null) {
            this.f1670b = new androidx.lifecycle.s(this);
            this.f1671c = l2.f.c(this);
        }
    }

    @Override // androidx.lifecycle.l0
    public final androidx.lifecycle.k0 e() {
        d();
        return this.f1669a;
    }

    @Override // androidx.lifecycle.q
    public final androidx.lifecycle.s f() {
        d();
        return this.f1670b;
    }
}