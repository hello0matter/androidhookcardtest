package n;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: s  reason: collision with root package name */
    public static final double[] f5644s = new double[91];

    /* renamed from: a  reason: collision with root package name */
    public double[] f5645a;

    /* renamed from: b  reason: collision with root package name */
    public double f5646b;

    /* renamed from: c  reason: collision with root package name */
    public double f5647c;

    /* renamed from: d  reason: collision with root package name */
    public double f5648d;

    /* renamed from: e  reason: collision with root package name */
    public double f5649e;

    /* renamed from: f  reason: collision with root package name */
    public double f5650f;

    /* renamed from: g  reason: collision with root package name */
    public double f5651g;

    /* renamed from: h  reason: collision with root package name */
    public double f5652h;

    /* renamed from: i  reason: collision with root package name */
    public double f5653i;

    /* renamed from: j  reason: collision with root package name */
    public double f5654j;

    /* renamed from: k  reason: collision with root package name */
    public double f5655k;

    /* renamed from: l  reason: collision with root package name */
    public double f5656l;

    /* renamed from: m  reason: collision with root package name */
    public double f5657m;

    /* renamed from: n  reason: collision with root package name */
    public double f5658n;

    /* renamed from: o  reason: collision with root package name */
    public double f5659o;

    /* renamed from: p  reason: collision with root package name */
    public double f5660p;

    /* renamed from: q  reason: collision with root package name */
    public boolean f5661q;

    /* renamed from: r  reason: collision with root package name */
    public boolean f5662r;

    public final double a() {
        double d4 = this.f5654j * this.f5660p;
        double hypot = this.f5658n / Math.hypot(d4, (-this.f5655k) * this.f5659o);
        if (this.f5661q) {
            d4 = -d4;
        }
        return d4 * hypot;
    }

    public final double b() {
        double d4 = this.f5654j * this.f5660p;
        double d5 = (-this.f5655k) * this.f5659o;
        double hypot = this.f5658n / Math.hypot(d4, d5);
        if (this.f5661q) {
            return (-d5) * hypot;
        }
        return d5 * hypot;
    }

    public final double c(double d4) {
        double d5 = (d4 - this.f5647c) * this.f5653i;
        double d6 = this.f5650f;
        double d7 = this.f5649e;
        return ((d6 - d7) * d5) + d7;
    }

    public final double d(double d4) {
        double d5 = (d4 - this.f5647c) * this.f5653i;
        double d6 = this.f5652h;
        double d7 = this.f5651g;
        return ((d6 - d7) * d5) + d7;
    }

    public final void e(double d4) {
        double d5;
        if (this.f5661q) {
            d5 = this.f5648d - d4;
        } else {
            d5 = d4 - this.f5647c;
        }
        double d6 = d5 * this.f5653i;
        double d7 = 0.0d;
        if (d6 > 0.0d) {
            d7 = 1.0d;
            if (d6 < 1.0d) {
                double[] dArr = this.f5645a;
                double length = d6 * (dArr.length - 1);
                int i4 = (int) length;
                double d8 = dArr[i4];
                d7 = ((dArr[i4 + 1] - d8) * (length - i4)) + d8;
            }
        }
        double d9 = d7 * 1.5707963267948966d;
        this.f5659o = Math.sin(d9);
        this.f5660p = Math.cos(d9);
    }
}