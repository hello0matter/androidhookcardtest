package n;

/* loaded from: classes.dex */
public final class b extends com.google.common.collect.c {

    /* renamed from: q  reason: collision with root package name */
    public final double[] f5663q;

    /* renamed from: r  reason: collision with root package name */
    public final a[] f5664r;

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0026, code lost:
        if (r5 == r3) goto L75;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r8v2, types: [n.a, java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public b(int[] r29, double[] r30, double[][] r31) {
        /*
            Method dump skipped, instructions count: 378
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: n.b.<init>(int[], double[], double[][]):void");
    }

    @Override // com.google.common.collect.c
    public final double I0(double d4) {
        a[] aVarArr = this.f5664r;
        double d5 = aVarArr[0].f5647c;
        if (d4 < d5) {
            d4 = d5;
        } else if (d4 > aVarArr[aVarArr.length - 1].f5648d) {
            d4 = aVarArr[aVarArr.length - 1].f5648d;
        }
        for (int i4 = 0; i4 < aVarArr.length; i4++) {
            a aVar = aVarArr[i4];
            if (d4 <= aVar.f5648d) {
                if (aVar.f5662r) {
                    return aVar.c(d4);
                }
                aVar.e(d4);
                a aVar2 = aVarArr[i4];
                return (aVar2.f5654j * aVar2.f5659o) + aVar2.f5656l;
            }
        }
        return Double.NaN;
    }

    @Override // com.google.common.collect.c
    public final void J0(double d4, double[] dArr) {
        a[] aVarArr = this.f5664r;
        double d5 = aVarArr[0].f5647c;
        if (d4 < d5) {
            d4 = d5;
        }
        if (d4 > aVarArr[aVarArr.length - 1].f5648d) {
            d4 = aVarArr[aVarArr.length - 1].f5648d;
        }
        for (int i4 = 0; i4 < aVarArr.length; i4++) {
            a aVar = aVarArr[i4];
            if (d4 <= aVar.f5648d) {
                if (aVar.f5662r) {
                    dArr[0] = aVar.c(d4);
                    dArr[1] = aVarArr[i4].d(d4);
                    return;
                }
                aVar.e(d4);
                a aVar2 = aVarArr[i4];
                dArr[0] = (aVar2.f5654j * aVar2.f5659o) + aVar2.f5656l;
                dArr[1] = (aVar2.f5655k * aVar2.f5660p) + aVar2.f5657m;
                return;
            }
        }
    }

    @Override // com.google.common.collect.c
    public final void K0(double d4, float[] fArr) {
        a[] aVarArr = this.f5664r;
        double d5 = aVarArr[0].f5647c;
        if (d4 < d5) {
            d4 = d5;
        } else if (d4 > aVarArr[aVarArr.length - 1].f5648d) {
            d4 = aVarArr[aVarArr.length - 1].f5648d;
        }
        for (int i4 = 0; i4 < aVarArr.length; i4++) {
            a aVar = aVarArr[i4];
            if (d4 <= aVar.f5648d) {
                if (aVar.f5662r) {
                    fArr[0] = (float) aVar.c(d4);
                    fArr[1] = (float) aVarArr[i4].d(d4);
                    return;
                }
                aVar.e(d4);
                a aVar2 = aVarArr[i4];
                fArr[0] = (float) ((aVar2.f5654j * aVar2.f5659o) + aVar2.f5656l);
                fArr[1] = (float) ((aVar2.f5655k * aVar2.f5660p) + aVar2.f5657m);
                return;
            }
        }
    }

    @Override // com.google.common.collect.c
    public final double M0(double d4) {
        a[] aVarArr = this.f5664r;
        double d5 = aVarArr[0].f5647c;
        if (d4 < d5) {
            d4 = d5;
        }
        if (d4 > aVarArr[aVarArr.length - 1].f5648d) {
            d4 = aVarArr[aVarArr.length - 1].f5648d;
        }
        for (int i4 = 0; i4 < aVarArr.length; i4++) {
            a aVar = aVarArr[i4];
            if (d4 <= aVar.f5648d) {
                if (aVar.f5662r) {
                    return aVar.f5656l;
                }
                aVar.e(d4);
                return aVarArr[i4].a();
            }
        }
        return Double.NaN;
    }

    @Override // com.google.common.collect.c
    public final void N0(double d4, double[] dArr) {
        a[] aVarArr = this.f5664r;
        double d5 = aVarArr[0].f5647c;
        if (d4 < d5) {
            d4 = d5;
        } else if (d4 > aVarArr[aVarArr.length - 1].f5648d) {
            d4 = aVarArr[aVarArr.length - 1].f5648d;
        }
        for (int i4 = 0; i4 < aVarArr.length; i4++) {
            a aVar = aVarArr[i4];
            if (d4 <= aVar.f5648d) {
                if (aVar.f5662r) {
                    dArr[0] = aVar.f5656l;
                    dArr[1] = aVar.f5657m;
                    return;
                }
                aVar.e(d4);
                dArr[0] = aVarArr[i4].a();
                dArr[1] = aVarArr[i4].b();
                return;
            }
        }
    }

    @Override // com.google.common.collect.c
    public final double[] Q0() {
        return this.f5663q;
    }
}