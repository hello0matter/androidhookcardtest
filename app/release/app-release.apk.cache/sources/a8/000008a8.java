package n;

import o.q;

/* loaded from: classes.dex */
public final class i extends q {

    /* renamed from: a  reason: collision with root package name */
    public float f5683a;

    /* renamed from: b  reason: collision with root package name */
    public float f5684b;

    /* renamed from: c  reason: collision with root package name */
    public float f5685c;

    /* renamed from: d  reason: collision with root package name */
    public float f5686d;

    /* renamed from: e  reason: collision with root package name */
    public float f5687e;

    /* renamed from: f  reason: collision with root package name */
    public float f5688f;

    /* renamed from: g  reason: collision with root package name */
    public float f5689g;

    /* renamed from: h  reason: collision with root package name */
    public float f5690h;

    /* renamed from: i  reason: collision with root package name */
    public float f5691i;

    /* renamed from: j  reason: collision with root package name */
    public int f5692j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f5693k = false;

    /* renamed from: l  reason: collision with root package name */
    public float f5694l;

    /* renamed from: m  reason: collision with root package name */
    public float f5695m;

    @Override // o.q
    public final float a() {
        if (this.f5693k) {
            return -b(this.f5695m);
        }
        return b(this.f5695m);
    }

    public final float b(float f4) {
        float f5;
        float f6;
        float f7 = this.f5686d;
        if (f4 <= f7) {
            f5 = this.f5683a;
            f6 = this.f5684b;
        } else {
            int i4 = this.f5692j;
            if (i4 == 1) {
                return 0.0f;
            }
            f4 -= f7;
            f7 = this.f5687e;
            if (f4 < f7) {
                f5 = this.f5684b;
                f6 = this.f5685c;
            } else if (i4 == 2) {
                return this.f5690h;
            } else {
                float f8 = f4 - f7;
                float f9 = this.f5688f;
                if (f8 < f9) {
                    float f10 = this.f5685c;
                    return f10 - ((f8 * f10) / f9);
                }
                return this.f5691i;
            }
        }
        return (((f6 - f5) * f4) / f7) + f5;
    }

    public final void c(float f4, float f5, float f6, float f7, float f8) {
        if (f4 == 0.0f) {
            f4 = 1.0E-4f;
        }
        this.f5683a = f4;
        float f9 = f4 / f6;
        float f10 = (f9 * f4) / 2.0f;
        if (f4 < 0.0f) {
            float sqrt = (float) Math.sqrt((f5 - ((((-f4) / f6) * f4) / 2.0f)) * f6);
            if (sqrt < f7) {
                this.f5692j = 2;
                this.f5683a = f4;
                this.f5684b = sqrt;
                this.f5685c = 0.0f;
                float f11 = (sqrt - f4) / f6;
                this.f5686d = f11;
                this.f5687e = sqrt / f6;
                this.f5689g = ((f4 + sqrt) * f11) / 2.0f;
                this.f5690h = f5;
                this.f5691i = f5;
                return;
            }
            this.f5692j = 3;
            this.f5683a = f4;
            this.f5684b = f7;
            this.f5685c = f7;
            float f12 = (f7 - f4) / f6;
            this.f5686d = f12;
            float f13 = f7 / f6;
            this.f5688f = f13;
            float f14 = ((f4 + f7) * f12) / 2.0f;
            float f15 = (f13 * f7) / 2.0f;
            this.f5687e = ((f5 - f14) - f15) / f7;
            this.f5689g = f14;
            this.f5690h = f5 - f15;
            this.f5691i = f5;
        } else if (f10 >= f5) {
            this.f5692j = 1;
            this.f5683a = f4;
            this.f5684b = 0.0f;
            this.f5689g = f5;
            this.f5686d = (2.0f * f5) / f4;
        } else {
            float f16 = f5 - f10;
            float f17 = f16 / f4;
            if (f17 + f9 < f8) {
                this.f5692j = 2;
                this.f5683a = f4;
                this.f5684b = f4;
                this.f5685c = 0.0f;
                this.f5689g = f16;
                this.f5690h = f5;
                this.f5686d = f17;
                this.f5687e = f9;
                return;
            }
            float sqrt2 = (float) Math.sqrt(((f4 * f4) / 2.0f) + (f6 * f5));
            float f18 = (sqrt2 - f4) / f6;
            this.f5686d = f18;
            float f19 = sqrt2 / f6;
            this.f5687e = f19;
            if (sqrt2 < f7) {
                this.f5692j = 2;
                this.f5683a = f4;
                this.f5684b = sqrt2;
                this.f5685c = 0.0f;
                this.f5686d = f18;
                this.f5687e = f19;
                this.f5689g = ((f4 + sqrt2) * f18) / 2.0f;
                this.f5690h = f5;
                return;
            }
            this.f5692j = 3;
            this.f5683a = f4;
            this.f5684b = f7;
            this.f5685c = f7;
            float f20 = (f7 - f4) / f6;
            this.f5686d = f20;
            float f21 = f7 / f6;
            this.f5688f = f21;
            float f22 = ((f4 + f7) * f20) / 2.0f;
            float f23 = (f21 * f7) / 2.0f;
            this.f5687e = ((f5 - f22) - f23) / f7;
            this.f5689g = f22;
            this.f5690h = f5 - f23;
            this.f5691i = f5;
        }
    }

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float f4) {
        float f5;
        float f6 = this.f5686d;
        if (f4 <= f6) {
            float f7 = this.f5683a;
            f5 = ((((this.f5684b - f7) * f4) * f4) / (f6 * 2.0f)) + (f7 * f4);
        } else {
            int i4 = this.f5692j;
            if (i4 == 1) {
                f5 = this.f5689g;
            } else {
                float f8 = f4 - f6;
                float f9 = this.f5687e;
                if (f8 < f9) {
                    float f10 = this.f5689g;
                    float f11 = this.f5684b;
                    f5 = ((((this.f5685c - f11) * f8) * f8) / (f9 * 2.0f)) + (f11 * f8) + f10;
                } else if (i4 == 2) {
                    f5 = this.f5690h;
                } else {
                    float f12 = f8 - f9;
                    float f13 = this.f5688f;
                    if (f12 < f13) {
                        float f14 = this.f5690h;
                        float f15 = this.f5685c * f12;
                        f5 = (f14 + f15) - ((f15 * f12) / (f13 * 2.0f));
                    } else {
                        f5 = this.f5691i;
                    }
                }
            }
        }
        this.f5695m = f4;
        if (this.f5693k) {
            return this.f5694l - f5;
        }
        return this.f5694l + f5;
    }
}