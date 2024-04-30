package n;

/* loaded from: classes.dex */
public final class c extends com.google.common.collect.c {

    /* renamed from: q  reason: collision with root package name */
    public double f5665q;

    /* renamed from: r  reason: collision with root package name */
    public double[] f5666r;

    @Override // com.google.common.collect.c
    public final double I0(double d4) {
        return this.f5666r[0];
    }

    @Override // com.google.common.collect.c
    public final void J0(double d4, double[] dArr) {
        double[] dArr2 = this.f5666r;
        System.arraycopy(dArr2, 0, dArr, 0, dArr2.length);
    }

    @Override // com.google.common.collect.c
    public final void K0(double d4, float[] fArr) {
        int i4 = 0;
        while (true) {
            double[] dArr = this.f5666r;
            if (i4 < dArr.length) {
                fArr[i4] = (float) dArr[i4];
                i4++;
            } else {
                return;
            }
        }
    }

    @Override // com.google.common.collect.c
    public final double M0(double d4) {
        return 0.0d;
    }

    @Override // com.google.common.collect.c
    public final void N0(double d4, double[] dArr) {
        for (int i4 = 0; i4 < this.f5666r.length; i4++) {
            dArr[i4] = 0.0d;
        }
    }

    @Override // com.google.common.collect.c
    public final double[] Q0() {
        return new double[]{this.f5665q};
    }
}