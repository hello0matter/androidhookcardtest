package o;

import android.view.View;
import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.Arrays;

/* loaded from: classes.dex */
public abstract class e0 {

    /* renamed from: a  reason: collision with root package name */
    public com.google.common.collect.c f5797a;

    /* renamed from: b  reason: collision with root package name */
    public int[] f5798b = new int[10];

    /* renamed from: c  reason: collision with root package name */
    public float[] f5799c = new float[10];

    /* renamed from: d  reason: collision with root package name */
    public int f5800d;

    /* renamed from: e  reason: collision with root package name */
    public String f5801e;

    public final float a(float f4) {
        return (float) this.f5797a.I0(f4);
    }

    public void b(int i4, float f4) {
        int[] iArr = this.f5798b;
        if (iArr.length < this.f5800d + 1) {
            this.f5798b = Arrays.copyOf(iArr, iArr.length * 2);
            float[] fArr = this.f5799c;
            this.f5799c = Arrays.copyOf(fArr, fArr.length * 2);
        }
        int[] iArr2 = this.f5798b;
        int i5 = this.f5800d;
        iArr2[i5] = i4;
        this.f5799c[i5] = f4;
        this.f5800d = i5 + 1;
    }

    public abstract void c(View view, float f4);

    public void d(int i4) {
        int i5 = this.f5800d;
        if (i5 == 0) {
            return;
        }
        int[] iArr = this.f5798b;
        float[] fArr = this.f5799c;
        int[] iArr2 = new int[iArr.length + 10];
        iArr2[0] = i5 - 1;
        iArr2[1] = 0;
        int i6 = 2;
        while (i6 > 0) {
            int i7 = i6 - 1;
            int i8 = iArr2[i7];
            int i9 = i6 - 2;
            int i10 = iArr2[i9];
            if (i8 < i10) {
                int i11 = iArr[i10];
                int i12 = i8;
                int i13 = i12;
                while (i12 < i10) {
                    int i14 = iArr[i12];
                    if (i14 <= i11) {
                        int i15 = iArr[i13];
                        iArr[i13] = i14;
                        iArr[i12] = i15;
                        float f4 = fArr[i13];
                        fArr[i13] = fArr[i12];
                        fArr[i12] = f4;
                        i13++;
                    }
                    i12++;
                }
                int i16 = iArr[i13];
                iArr[i13] = iArr[i10];
                iArr[i10] = i16;
                float f5 = fArr[i13];
                fArr[i13] = fArr[i10];
                fArr[i10] = f5;
                iArr2[i9] = i13 - 1;
                iArr2[i7] = i8;
                int i17 = i6 + 1;
                iArr2[i6] = i10;
                i6 += 2;
                iArr2[i17] = i13 + 1;
            } else {
                i6 = i9;
            }
        }
        int i18 = 1;
        for (int i19 = 1; i19 < this.f5800d; i19++) {
            int[] iArr3 = this.f5798b;
            if (iArr3[i19 - 1] != iArr3[i19]) {
                i18++;
            }
        }
        double[] dArr = new double[i18];
        double[][] dArr2 = (double[][]) Array.newInstance(Double.TYPE, i18, 1);
        int i20 = 0;
        for (int i21 = 0; i21 < this.f5800d; i21++) {
            if (i21 > 0) {
                int[] iArr4 = this.f5798b;
                if (iArr4[i21] == iArr4[i21 - 1]) {
                }
            }
            dArr[i20] = this.f5798b[i21] * 0.01d;
            dArr2[i20][0] = this.f5799c[i21];
            i20++;
        }
        this.f5797a = com.google.common.collect.c.n0(i4, dArr, dArr2);
    }

    public final String toString() {
        String str = this.f5801e;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        for (int i4 = 0; i4 < this.f5800d; i4++) {
            str = str + "[" + this.f5798b[i4] + " , " + decimalFormat.format(this.f5799c[i4]) + "] ";
        }
        return str;
    }
}