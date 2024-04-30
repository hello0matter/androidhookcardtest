package n;

/* loaded from: classes.dex */
public final class f extends com.google.common.collect.c {

    /* renamed from: q  reason: collision with root package name */
    public double[] f5674q;

    /* renamed from: r  reason: collision with root package name */
    public double[][] f5675r;

    @Override // com.google.common.collect.c
    public final double I0(double d4) {
        double[] dArr = this.f5674q;
        int length = dArr.length;
        int i4 = (d4 > dArr[0] ? 1 : (d4 == dArr[0] ? 0 : -1));
        double[][] dArr2 = this.f5675r;
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
                double d7 = (d4 - d5) / (d6 - d5);
                return (dArr2[i7][0] * d7) + ((1.0d - d7) * dArr2[i6][0]);
            }
            i6 = i7;
        }
        return 0.0d;
    }

    @Override // com.google.common.collect.c
    public final void J0(double d4, double[] dArr) {
        double[] dArr2 = this.f5674q;
        int length = dArr2.length;
        double[][] dArr3 = this.f5675r;
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
                double d7 = (d4 - d6) / (d5 - d6);
                while (i4 < length2) {
                    dArr[i4] = (dArr3[i9][i4] * d7) + ((1.0d - d7) * dArr3[i7][i4]);
                    i4++;
                }
                return;
            }
            i7 = i9;
        }
    }

    @Override // com.google.common.collect.c
    public final void K0(double d4, float[] fArr) {
        double[] dArr = this.f5674q;
        int length = dArr.length;
        double[][] dArr2 = this.f5675r;
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
                double d7 = (d4 - d6) / (d5 - d6);
                while (i4 < length2) {
                    fArr[i4] = (float) ((dArr2[i9][i4] * d7) + ((1.0d - d7) * dArr2[i7][i4]));
                    i4++;
                }
                return;
            }
            i7 = i9;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0012, code lost:
        if (r9 >= r3) goto L3;
     */
    @Override // com.google.common.collect.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final double M0(double r9) {
        /*
            r8 = this;
            double[] r0 = r8.f5674q
            int r1 = r0.length
            r2 = 0
            r3 = r0[r2]
            int r5 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r5 >= 0) goto Lc
        La:
            r9 = r3
            goto L15
        Lc:
            int r3 = r1 + (-1)
            r3 = r0[r3]
            int r5 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r5 < 0) goto L15
            goto La
        L15:
            r3 = r2
        L16:
            int r4 = r1 + (-1)
            if (r3 >= r4) goto L34
            int r4 = r3 + 1
            r5 = r0[r4]
            int r7 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1))
            if (r7 > 0) goto L32
            r9 = r0[r3]
            double r5 = r5 - r9
            double[][] r9 = r8.f5675r
            r10 = r9[r3]
            r0 = r10[r2]
            r9 = r9[r4]
            r2 = r9[r2]
            double r2 = r2 - r0
            double r2 = r2 / r5
            return r2
        L32:
            r3 = r4
            goto L16
        L34:
            r9 = 0
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: n.f.M0(double):double");
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0017, code lost:
        if (r12 >= r5) goto L3;
     */
    @Override // com.google.common.collect.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void N0(double r12, double[] r14) {
        /*
            r11 = this;
            double[] r0 = r11.f5674q
            int r1 = r0.length
            double[][] r2 = r11.f5675r
            r3 = 0
            r4 = r2[r3]
            int r4 = r4.length
            r5 = r0[r3]
            int r7 = (r12 > r5 ? 1 : (r12 == r5 ? 0 : -1))
            if (r7 > 0) goto L11
        Lf:
            r12 = r5
            goto L1a
        L11:
            int r5 = r1 + (-1)
            r5 = r0[r5]
            int r7 = (r12 > r5 ? 1 : (r12 == r5 ? 0 : -1))
            if (r7 < 0) goto L1a
            goto Lf
        L1a:
            r5 = r3
        L1b:
            int r6 = r1 + (-1)
            if (r5 >= r6) goto L3d
            int r6 = r5 + 1
            r7 = r0[r6]
            int r9 = (r12 > r7 ? 1 : (r12 == r7 ? 0 : -1))
            if (r9 > 0) goto L3b
            r12 = r0[r5]
            double r7 = r7 - r12
        L2a:
            if (r3 >= r4) goto L3d
            r12 = r2[r5]
            r0 = r12[r3]
            r12 = r2[r6]
            r9 = r12[r3]
            double r9 = r9 - r0
            double r9 = r9 / r7
            r14[r3] = r9
            int r3 = r3 + 1
            goto L2a
        L3b:
            r5 = r6
            goto L1b
        L3d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: n.f.N0(double, double[]):void");
    }

    @Override // com.google.common.collect.c
    public final double[] Q0() {
        return this.f5674q;
    }
}