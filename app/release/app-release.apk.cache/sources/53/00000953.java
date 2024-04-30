package q0;

/* loaded from: classes.dex */
public final class j {

    /* renamed from: a  reason: collision with root package name */
    public double f6320a;

    /* renamed from: b  reason: collision with root package name */
    public double f6321b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f6322c;

    /* renamed from: d  reason: collision with root package name */
    public double f6323d;

    /* renamed from: e  reason: collision with root package name */
    public double f6324e;

    /* renamed from: f  reason: collision with root package name */
    public double f6325f;

    /* renamed from: g  reason: collision with root package name */
    public double f6326g;

    /* renamed from: h  reason: collision with root package name */
    public double f6327h;

    /* renamed from: i  reason: collision with root package name */
    public double f6328i;

    /* renamed from: j  reason: collision with root package name */
    public final f f6329j;

    /* JADX WARN: Type inference failed for: r0v5, types: [q0.f, java.lang.Object] */
    public j() {
        this.f6320a = Math.sqrt(1500.0d);
        this.f6321b = 0.5d;
        this.f6322c = false;
        this.f6328i = Double.MAX_VALUE;
        this.f6329j = new Object();
    }

    public final f a(double d4, double d5, long j4) {
        double cos;
        double d6;
        if (!this.f6322c) {
            if (this.f6328i != Double.MAX_VALUE) {
                double d7 = this.f6321b;
                if (d7 > 1.0d) {
                    double d8 = this.f6320a;
                    this.f6325f = (Math.sqrt((d7 * d7) - 1.0d) * d8) + ((-d7) * d8);
                    double d9 = this.f6321b;
                    double d10 = this.f6320a;
                    this.f6326g = ((-d9) * d10) - (Math.sqrt((d9 * d9) - 1.0d) * d10);
                } else if (d7 >= 0.0d && d7 < 1.0d) {
                    this.f6327h = Math.sqrt(1.0d - (d7 * d7)) * this.f6320a;
                }
                this.f6322c = true;
            } else {
                throw new IllegalStateException("Error: Final position of the spring must be set before the animation starts");
            }
        }
        double d11 = j4 / 1000.0d;
        double d12 = d4 - this.f6328i;
        double d13 = this.f6321b;
        if (d13 > 1.0d) {
            double d14 = this.f6326g;
            double d15 = this.f6325f;
            double d16 = d12 - (((d14 * d12) - d5) / (d14 - d15));
            double d17 = ((d12 * d14) - d5) / (d14 - d15);
            d6 = (Math.pow(2.718281828459045d, this.f6325f * d11) * d17) + (Math.pow(2.718281828459045d, d14 * d11) * d16);
            double d18 = this.f6326g;
            double pow = Math.pow(2.718281828459045d, d18 * d11) * d16 * d18;
            double d19 = this.f6325f;
            cos = (Math.pow(2.718281828459045d, d19 * d11) * d17 * d19) + pow;
        } else if (d13 == 1.0d) {
            double d20 = this.f6320a;
            double d21 = (d20 * d12) + d5;
            double d22 = (d21 * d11) + d12;
            double pow2 = Math.pow(2.718281828459045d, (-d20) * d11) * d22;
            double pow3 = Math.pow(2.718281828459045d, (-this.f6320a) * d11) * d22;
            double d23 = this.f6320a;
            cos = (Math.pow(2.718281828459045d, (-d23) * d11) * d21) + (pow3 * (-d23));
            d6 = pow2;
        } else {
            double d24 = 1.0d / this.f6327h;
            double d25 = this.f6320a;
            double d26 = ((d13 * d25 * d12) + d5) * d24;
            double sin = ((Math.sin(this.f6327h * d11) * d26) + (Math.cos(this.f6327h * d11) * d12)) * Math.pow(2.718281828459045d, (-d13) * d25 * d11);
            double d27 = this.f6320a;
            double d28 = this.f6321b;
            double d29 = (-d27) * sin * d28;
            double pow4 = Math.pow(2.718281828459045d, (-d28) * d27 * d11);
            double d30 = this.f6327h;
            double d31 = (-d30) * d12;
            double d32 = this.f6327h;
            cos = (((Math.cos(d32 * d11) * d26 * d32) + (Math.sin(d30 * d11) * d31)) * pow4) + d29;
            d6 = sin;
        }
        f fVar = this.f6329j;
        fVar.f6298a = (float) (d6 + this.f6328i);
        fVar.f6299b = (float) cos;
        return fVar;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [q0.f, java.lang.Object] */
    public j(float f4) {
        this.f6320a = Math.sqrt(1500.0d);
        this.f6321b = 0.5d;
        this.f6322c = false;
        this.f6329j = new Object();
        this.f6328i = f4;
    }
}