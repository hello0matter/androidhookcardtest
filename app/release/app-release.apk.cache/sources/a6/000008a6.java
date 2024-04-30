package n;

/* loaded from: classes.dex */
public final class g extends com.google.common.collect.c {

    /* renamed from: q  reason: collision with root package name */
    public double[] f5676q;

    /* renamed from: r  reason: collision with root package name */
    public double[][] f5677r;

    /* renamed from: s  reason: collision with root package name */
    public double[][] f5678s;

    public static double h2(double d4, double d5, double d6, double d7, double d8, double d9) {
        double d10 = d5 * d5;
        double d11 = d5 * 6.0d;
        double d12 = 6.0d * d10 * d6;
        double d13 = 3.0d * d4;
        double d14 = d13 * d8 * d10;
        return (d4 * d8) + (((d14 + (((d13 * d9) * d10) + ((d12 + ((d11 * d7) + (((-6.0d) * d10) * d7))) - (d11 * d6)))) - (((2.0d * d4) * d9) * d5)) - (((4.0d * d4) * d8) * d5));
    }

    public static double i2(double d4, double d5, double d6, double d7, double d8, double d9) {
        double d10 = d5 * d5;
        double d11 = d10 * d5;
        double d12 = 3.0d * d10;
        double d13 = d12 * d7;
        double d14 = d4 * d9;
        double d15 = d14 * d11;
        double d16 = d4 * d8;
        return (d16 * d5) + ((((d11 * d16) + (d15 + (((((d11 * 2.0d) * d6) + (d13 + (((-2.0d) * d11) * d7))) - (d12 * d6)) + d6))) - (d14 * d10)) - (((2.0d * d4) * d8) * d10));
    }

    @Override // com.google.common.collect.c
    public final double I0(double d4) {
        double[] dArr = this.f5676q;
        int length = dArr.length;
        int i4 = (d4 > dArr[0] ? 1 : (d4 == dArr[0] ? 0 : -1));
        double[][] dArr2 = this.f5677r;
        if (i4 <= 0) {
            return dArr2[0][0];
        }
        int i5 = length - 1;
        if (d4 >= dArr[i5]) {
            return dArr2[i5][0];
        }
        int i6 = 0;
        while (i6 < i5) {
            double d5 = dArr[i6];
            if (d4 == d5) {
                return dArr2[i6][0];
            }
            int i7 = i6 + 1;
            double d6 = dArr[i7];
            if (d4 < d6) {
                double d7 = d6 - d5;
                double d8 = (d4 - d5) / d7;
                double d9 = dArr2[i6][0];
                double d10 = dArr2[i7][0];
                double[][] dArr3 = this.f5678s;
                return i2(d7, d8, d9, d10, dArr3[i6][0], dArr3[i7][0]);
            }
            i6 = i7;
        }
        return 0.0d;
    }

    @Override // com.google.common.collect.c
    public final void J0(double d4, double[] dArr) {
        double[] dArr2 = this.f5676q;
        int length = dArr2.length;
        double[][] dArr3 = this.f5677r;
        int i4 = 0;
        int length2 = dArr3[0].length;
        if (d4 <= dArr2[0]) {
            for (int i5 = 0; i5 < length2; i5++) {
                dArr[i5] = dArr3[0][i5];
            }
            return;
        }
        int i6 = length - 1;
        if (d4 >= dArr2[i6]) {
            while (i4 < length2) {
                dArr[i4] = dArr3[i6][i4];
                i4++;
            }
            return;
        }
        int i7 = 0;
        while (i7 < i6) {
            if (d4 == dArr2[i7]) {
                for (int i8 = 0; i8 < length2; i8++) {
                    dArr[i8] = dArr3[i7][i8];
                }
            }
            int i9 = i7 + 1;
            double d5 = dArr2[i9];
            if (d4 < d5) {
                double d6 = dArr2[i7];
                double d7 = d5 - d6;
                double d8 = (d4 - d6) / d7;
                while (i4 < length2) {
                    double d9 = dArr3[i7][i4];
                    double d10 = dArr3[i9][i4];
                    double[][] dArr4 = this.f5678s;
                    dArr[i4] = i2(d7, d8, d9, d10, dArr4[i7][i4], dArr4[i9][i4]);
                    i4++;
                }
                return;
            }
            i7 = i9;
        }
    }

    @Override // com.google.common.collect.c
    public final void K0(double d4, float[] fArr) {
        double[] dArr = this.f5676q;
        int length = dArr.length;
        double[][] dArr2 = this.f5677r;
        int i4 = 0;
        int length2 = dArr2[0].length;
        if (d4 <= dArr[0]) {
            for (int i5 = 0; i5 < length2; i5++) {
                fArr[i5] = (float) dArr2[0][i5];
            }
            return;
        }
        int i6 = length - 1;
        if (d4 >= dArr[i6]) {
            while (i4 < length2) {
                fArr[i4] = (float) dArr2[i6][i4];
                i4++;
            }
            return;
        }
        int i7 = 0;
        while (i7 < i6) {
            if (d4 == dArr[i7]) {
                for (int i8 = 0; i8 < length2; i8++) {
                    fArr[i8] = (float) dArr2[i7][i8];
                }
            }
            int i9 = i7 + 1;
            double d5 = dArr[i9];
            if (d4 < d5) {
                double d6 = dArr[i7];
                double d7 = d5 - d6;
                double d8 = (d4 - d6) / d7;
                while (i4 < length2) {
                    double d9 = dArr2[i7][i4];
                    double d10 = dArr2[i9][i4];
                    double[][] dArr3 = this.f5678s;
                    fArr[i4] = (float) i2(d7, d8, d9, d10, dArr3[i7][i4], dArr3[i9][i4]);
                    i4++;
                }
                return;
            }
            i7 = i9;
        }
    }

    @Override // com.google.common.collect.c
    public final double M0(double d4) {
        double[] dArr = this.f5676q;
        int length = dArr.length;
        double d5 = dArr[0];
        if (d4 >= d5) {
            d5 = dArr[length - 1];
            if (d4 < d5) {
                d5 = d4;
            }
        }
        int i4 = 0;
        while (i4 < length - 1) {
            int i5 = i4 + 1;
            double d6 = dArr[i5];
            if (d5 <= d6) {
                double d7 = dArr[i4];
                double d8 = d6 - d7;
                double[][] dArr2 = this.f5677r;
                double d9 = dArr2[i4][0];
                double d10 = dArr2[i5][0];
                double[][] dArr3 = this.f5678s;
                return h2(d8, (d5 - d7) / d8, d9, d10, dArr3[i4][0], dArr3[i5][0]) / d8;
            }
            i4 = i5;
        }
        return 0.0d;
    }

    @Override // com.google.common.collect.c
    public final void N0(double d4, double[] dArr) {
        double[] dArr2 = this.f5676q;
        int length = dArr2.length;
        double[][] dArr3 = this.f5677r;
        int length2 = dArr3[0].length;
        double d5 = dArr2[0];
        if (d4 > d5) {
            d5 = dArr2[length - 1];
            if (d4 < d5) {
                d5 = d4;
            }
        }
        int i4 = 0;
        while (i4 < length - 1) {
            int i5 = i4 + 1;
            double d6 = dArr2[i5];
            if (d5 <= d6) {
                double d7 = dArr2[i4];
                double d8 = d6 - d7;
                double d9 = (d5 - d7) / d8;
                for (int i6 = 0; i6 < length2; i6++) {
                    double d10 = dArr3[i4][i6];
                    double d11 = dArr3[i5][i6];
                    double[][] dArr4 = this.f5678s;
                    dArr[i6] = h2(d8, d9, d10, d11, dArr4[i4][i6], dArr4[i5][i6]) / d8;
                }
                return;
            }
            i4 = i5;
        }
    }

    @Override // com.google.common.collect.c
    public final double[] Q0() {
        return this.f5676q;
    }
}