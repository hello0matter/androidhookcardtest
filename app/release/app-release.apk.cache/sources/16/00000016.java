package a0;

/* loaded from: classes.dex */
public final class u {

    /* renamed from: k  reason: collision with root package name */
    public static final u f41k;

    /* renamed from: a  reason: collision with root package name */
    public final float f42a;

    /* renamed from: b  reason: collision with root package name */
    public final float f43b;

    /* renamed from: c  reason: collision with root package name */
    public final float f44c;

    /* renamed from: d  reason: collision with root package name */
    public final float f45d;

    /* renamed from: e  reason: collision with root package name */
    public final float f46e;

    /* renamed from: f  reason: collision with root package name */
    public final float f47f;

    /* renamed from: g  reason: collision with root package name */
    public final float[] f48g;

    /* renamed from: h  reason: collision with root package name */
    public final float f49h;

    /* renamed from: i  reason: collision with root package name */
    public final float f50i;

    /* renamed from: j  reason: collision with root package name */
    public final float f51j;

    static {
        float f4;
        float[] fArr = b.f10c;
        float c4 = (float) ((b.c() * 63.66197723675813d) / 100.0d);
        float[][] fArr2 = b.f8a;
        float f5 = fArr[0];
        float[] fArr3 = fArr2[0];
        float f6 = fArr[1];
        float f7 = (fArr3[1] * f6) + (fArr3[0] * f5);
        float f8 = fArr[2];
        float f9 = (fArr3[2] * f8) + f7;
        float[] fArr4 = fArr2[1];
        float f10 = (fArr4[2] * f8) + (fArr4[1] * f6) + (fArr4[0] * f5);
        float[] fArr5 = fArr2[2];
        float f11 = (f8 * fArr5[2]) + (f6 * fArr5[1]) + (f5 * fArr5[0]);
        if (1.0f >= 0.9d) {
            f4 = 0.69f;
        } else {
            f4 = 0.655f;
        }
        float f12 = f4;
        float exp = (1.0f - (((float) Math.exp(((-c4) - 42.0f) / 92.0f)) * 0.2777778f)) * 1.0f;
        double d4 = exp;
        if (d4 > 1.0d) {
            exp = 1.0f;
        } else if (d4 < 0.0d) {
            exp = 0.0f;
        }
        float[] fArr6 = {(((100.0f / f9) * exp) + 1.0f) - exp, (((100.0f / f10) * exp) + 1.0f) - exp, (((100.0f / f11) * exp) + 1.0f) - exp};
        float f13 = 1.0f / ((5.0f * c4) + 1.0f);
        float f14 = f13 * f13 * f13 * f13;
        float f15 = 1.0f - f14;
        float cbrt = (0.1f * f15 * f15 * ((float) Math.cbrt(c4 * 5.0d))) + (f14 * c4);
        float c5 = b.c() / fArr[1];
        double d5 = c5;
        float sqrt = ((float) Math.sqrt(d5)) + 1.48f;
        float pow = 0.725f / ((float) Math.pow(d5, 0.2d));
        float[] fArr7 = {(float) Math.pow(((fArr6[0] * cbrt) * f9) / 100.0d, 0.42d), (float) Math.pow(((fArr6[1] * cbrt) * f10) / 100.0d, 0.42d), (float) Math.pow(((fArr6[2] * cbrt) * f11) / 100.0d, 0.42d)};
        float f16 = fArr7[0];
        float f17 = (f16 * 400.0f) / (f16 + 27.13f);
        float f18 = fArr7[1];
        float f19 = (f18 * 400.0f) / (f18 + 27.13f);
        float f20 = fArr7[2];
        float[] fArr8 = {f17, f19, (400.0f * f20) / (f20 + 27.13f)};
        f41k = new u(c5, ((fArr8[2] * 0.05f) + (fArr8[0] * 2.0f) + fArr8[1]) * pow, pow, pow, f12, 1.0f, fArr6, cbrt, (float) Math.pow(cbrt, 0.25d), sqrt);
    }

    public u(float f4, float f5, float f6, float f7, float f8, float f9, float[] fArr, float f10, float f11, float f12) {
        this.f47f = f4;
        this.f42a = f5;
        this.f43b = f6;
        this.f44c = f7;
        this.f45d = f8;
        this.f46e = f9;
        this.f48g = fArr;
        this.f49h = f10;
        this.f50i = f11;
        this.f51j = f12;
    }
}