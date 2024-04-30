package c1;

import android.animation.TypeEvaluator;
import android.graphics.Matrix;

/* loaded from: classes.dex */
public final class k0 implements TypeEvaluator {

    /* renamed from: a  reason: collision with root package name */
    public final float[] f2632a = new float[9];

    /* renamed from: b  reason: collision with root package name */
    public final float[] f2633b = new float[9];

    /* renamed from: c  reason: collision with root package name */
    public final Matrix f2634c = new Matrix();

    @Override // android.animation.TypeEvaluator
    public final Object evaluate(float f4, Object obj, Object obj2) {
        float[] fArr = this.f2632a;
        ((Matrix) obj).getValues(fArr);
        float[] fArr2 = this.f2633b;
        ((Matrix) obj2).getValues(fArr2);
        for (int i4 = 0; i4 < 9; i4++) {
            float f5 = fArr2[i4];
            float f6 = fArr[i4];
            fArr2[i4] = androidx.activity.j.a(f5, f6, f4, f6);
        }
        Matrix matrix = this.f2634c;
        matrix.setValues(fArr2);
        return matrix;
    }
}