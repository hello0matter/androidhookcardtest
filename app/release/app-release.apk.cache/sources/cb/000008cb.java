package o;

import android.util.SparseArray;
import android.view.View;
import androidx.appcompat.app.o0;
import java.lang.reflect.Array;

/* loaded from: classes.dex */
public final class g0 extends j0 {

    /* renamed from: g  reason: collision with root package name */
    public SparseArray f5812g;

    /* renamed from: h  reason: collision with root package name */
    public SparseArray f5813h;

    /* renamed from: i  reason: collision with root package name */
    public float[] f5814i;

    /* renamed from: j  reason: collision with root package name */
    public float[] f5815j;

    @Override // o.j0
    public final boolean b(float f4, long j4, View view, o0 o0Var) {
        float f5;
        boolean z4;
        this.f5821a.K0(f4, this.f5814i);
        float[] fArr = this.f5814i;
        float f6 = fArr[fArr.length - 2];
        float f7 = fArr[fArr.length - 1];
        this.f5826f = (float) (((((j4 - this.f5825e) * 1.0E-9d) * f6) + this.f5826f) % 1.0d);
        this.f5825e = j4;
        float sin = (float) Math.sin(f5 * 6.2831855f);
        this.f5824d = false;
        int i4 = 0;
        while (true) {
            float[] fArr2 = this.f5815j;
            if (i4 >= fArr2.length) {
                break;
            }
            boolean z5 = this.f5824d;
            float f8 = this.f5814i[i4];
            if (f8 != 0.0d) {
                z4 = true;
            } else {
                z4 = false;
            }
            this.f5824d = z5 | z4;
            fArr2[i4] = (f8 * sin) + f7;
            i4++;
        }
        ((t.a) this.f5812g.valueAt(0)).f(view, this.f5815j);
        if (f6 != 0.0f) {
            this.f5824d = true;
        }
        return this.f5824d;
    }

    @Override // o.j0
    public final void c(int i4) {
        float[] fArr;
        SparseArray sparseArray = this.f5812g;
        int size = sparseArray.size();
        int d4 = ((t.a) sparseArray.valueAt(0)).d();
        double[] dArr = new double[size];
        int i5 = d4 + 2;
        this.f5814i = new float[i5];
        this.f5815j = new float[d4];
        double[][] dArr2 = (double[][]) Array.newInstance(Double.TYPE, size, i5);
        for (int i6 = 0; i6 < size; i6++) {
            int keyAt = sparseArray.keyAt(i6);
            float[] fArr2 = (float[]) this.f5813h.valueAt(i6);
            dArr[i6] = keyAt * 0.01d;
            ((t.a) sparseArray.valueAt(i6)).c(this.f5814i);
            int i7 = 0;
            while (true) {
                if (i7 < this.f5814i.length) {
                    dArr2[i6][i7] = fArr[i7];
                    i7++;
                }
            }
            double[] dArr3 = dArr2[i6];
            dArr3[d4] = fArr2[0];
            dArr3[d4 + 1] = fArr2[1];
        }
        this.f5821a = com.google.common.collect.c.n0(i4, dArr, dArr2);
    }
}