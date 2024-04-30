package d2;

import android.animation.TypeEvaluator;
import android.graphics.Matrix;

/* loaded from: classes.dex */
public final class l implements TypeEvaluator {

    /* renamed from: a  reason: collision with root package name */
    public final float[] f4374a = new float[9];

    /* renamed from: b  reason: collision with root package name */
    public final float[] f4375b = new float[9];

    /* renamed from: c  reason: collision with root package name */
    public final Matrix f4376c = new Matrix();

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ q f4377d;

    public l(q qVar) {
        this.f4377d = qVar;
    }

    @Override // android.animation.TypeEvaluator
    public final Object evaluate(float f4, Object obj, Object obj2) {
        this.f4377d.f4409p = f4;
        float[] fArr = this.f4374a;
        ((Matrix) obj).getValues(fArr);
        float[] fArr2 = this.f4375b;
        ((Matrix) obj2).getValues(fArr2);
        for (int i4 = 0; i4 < 9; i4++) {
            float f5 = fArr2[i4];
            float f6 = fArr[i4];
            fArr2[i4] = androidx.activity.j.a(f5, f6, f4, f6);
        }
        Matrix matrix = this.f4376c;
        matrix.setValues(fArr2);
        return matrix;
    }
}