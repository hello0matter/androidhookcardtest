package o;

import android.util.SparseArray;
import android.view.View;
import java.lang.reflect.Array;

/* loaded from: classes.dex */
public final class b0 extends e0 {

    /* renamed from: f  reason: collision with root package name */
    public SparseArray f5791f;

    /* renamed from: g  reason: collision with root package name */
    public float[] f5792g;

    @Override // o.e0
    public final void b(int i4, float f4) {
        throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute)");
    }

    @Override // o.e0
    public final void c(View view, float f4) {
        this.f5797a.K0(f4, this.f5792g);
        ((t.a) this.f5791f.valueAt(0)).f(view, this.f5792g);
    }

    @Override // o.e0
    public final void d(int i4) {
        float[] fArr;
        SparseArray sparseArray = this.f5791f;
        int size = sparseArray.size();
        int d4 = ((t.a) sparseArray.valueAt(0)).d();
        double[] dArr = new double[size];
        this.f5792g = new float[d4];
        double[][] dArr2 = (double[][]) Array.newInstance(Double.TYPE, size, d4);
        for (int i5 = 0; i5 < size; i5++) {
            dArr[i5] = sparseArray.keyAt(i5) * 0.01d;
            ((t.a) sparseArray.valueAt(i5)).c(this.f5792g);
            int i6 = 0;
            while (true) {
                if (i6 < this.f5792g.length) {
                    dArr2[i5][i6] = fArr[i6];
                    i6++;
                }
            }
        }
        this.f5797a = com.google.common.collect.c.n0(i4, dArr, dArr2);
    }
}