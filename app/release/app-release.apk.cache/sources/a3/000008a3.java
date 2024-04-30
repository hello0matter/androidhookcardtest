package n;

/* loaded from: classes.dex */
public final class d extends e {

    /* renamed from: d  reason: collision with root package name */
    public final double f5667d;

    /* renamed from: e  reason: collision with root package name */
    public final double f5668e;

    /* renamed from: f  reason: collision with root package name */
    public final double f5669f;

    /* renamed from: g  reason: collision with root package name */
    public final double f5670g;

    public d(String str) {
        this.f5673a = str;
        int indexOf = str.indexOf(40);
        int indexOf2 = str.indexOf(44, indexOf);
        this.f5667d = Double.parseDouble(str.substring(indexOf + 1, indexOf2).trim());
        int i4 = indexOf2 + 1;
        int indexOf3 = str.indexOf(44, i4);
        this.f5668e = Double.parseDouble(str.substring(i4, indexOf3).trim());
        int i5 = indexOf3 + 1;
        int indexOf4 = str.indexOf(44, i5);
        this.f5669f = Double.parseDouble(str.substring(i5, indexOf4).trim());
        int i6 = indexOf4 + 1;
        this.f5670g = Double.parseDouble(str.substring(i6, str.indexOf(41, i6)).trim());
    }

    @Override // n.e
    public final double a(double d4) {
        if (d4 <= 0.0d) {
            return 0.0d;
        }
        if (d4 >= 1.0d) {
            return 1.0d;
        }
        double d5 = 0.5d;
        double d6 = 0.5d;
        while (d5 > 0.01d) {
            d5 *= 0.5d;
            if (d(d6) < d4) {
                d6 += d5;
            } else {
                d6 -= d5;
            }
        }
        double d7 = d6 - d5;
        double d8 = d(d7);
        double d9 = d6 + d5;
        double d10 = d(d9);
        double e4 = e(d7);
        return (((d4 - d8) * (e(d9) - e4)) / (d10 - d8)) + e4;
    }

    @Override // n.e
    public final double b(double d4) {
        double d5 = 0.5d;
        double d6 = 0.5d;
        while (d5 > 1.0E-4d) {
            d5 *= 0.5d;
            if (d(d6) < d4) {
                d6 += d5;
            } else {
                d6 -= d5;
            }
        }
        double d7 = d6 - d5;
        double d8 = d(d7);
        double d9 = d6 + d5;
        return (e(d9) - e(d7)) / (d(d9) - d8);
    }

    public final double d(double d4) {
        double d5 = 1.0d - d4;
        double d6 = 3.0d * d5;
        double d7 = d5 * d6 * d4;
        double d8 = d6 * d4 * d4;
        return (this.f5669f * d8) + (this.f5667d * d7) + (d4 * d4 * d4);
    }

    public final double e(double d4) {
        double d5 = 1.0d - d4;
        double d6 = 3.0d * d5;
        double d7 = d5 * d6 * d4;
        double d8 = d6 * d4 * d4;
        return (this.f5670g * d8) + (this.f5668e * d7) + (d4 * d4 * d4);
    }
}