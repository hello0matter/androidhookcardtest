package l2;

/* loaded from: classes.dex */
public final class k extends f {

    /* renamed from: c  reason: collision with root package name */
    public final f f5332c;

    /* renamed from: d  reason: collision with root package name */
    public final float f5333d;

    public k(g gVar, float f4) {
        super(0, 0);
        this.f5332c = gVar;
        this.f5333d = f4;
    }

    @Override // l2.f
    public final boolean e() {
        return this.f5332c.e();
    }

    @Override // l2.f
    public final void f(float f4, float f5, float f6, z zVar) {
        this.f5332c.f(f4, f5 - this.f5333d, f6, zVar);
    }
}