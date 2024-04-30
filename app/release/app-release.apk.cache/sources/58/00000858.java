package l2;

/* loaded from: classes.dex */
public final class g extends f {

    /* renamed from: c  reason: collision with root package name */
    public final float f5286c;

    public g(float f4) {
        super(0, 0);
        this.f5286c = f4 - 0.001f;
    }

    @Override // l2.f
    public final void f(float f4, float f5, float f6, z zVar) {
        double d4 = this.f5286c;
        float sqrt = (float) ((Math.sqrt(2.0d) * d4) / 2.0d);
        float sqrt2 = (float) Math.sqrt(Math.pow(d4, 2.0d) - Math.pow(sqrt, 2.0d));
        zVar.e(f5 - sqrt, ((float) (-((Math.sqrt(2.0d) * d4) - d4))) + sqrt2, 270.0f, 0.0f);
        zVar.d(f5, (float) (-((Math.sqrt(2.0d) * d4) - d4)));
        zVar.d(f5 + sqrt, ((float) (-((Math.sqrt(2.0d) * d4) - d4))) + sqrt2);
    }
}