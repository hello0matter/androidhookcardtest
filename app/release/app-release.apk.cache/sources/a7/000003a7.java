package c1;

import android.animation.TypeEvaluator;
import android.graphics.Rect;

/* loaded from: classes.dex */
public final class n implements TypeEvaluator {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f2649a;

    /* renamed from: b  reason: collision with root package name */
    public Object f2650b;

    public /* synthetic */ n(int i4) {
        this.f2649a = i4;
    }

    @Override // android.animation.TypeEvaluator
    public final Object evaluate(float f4, Object obj, Object obj2) {
        int i4;
        int i5;
        int i6;
        int i7;
        switch (this.f2649a) {
            case 0:
                float[] fArr = (float[]) obj;
                float[] fArr2 = (float[]) obj2;
                float[] fArr3 = (float[]) this.f2650b;
                if (fArr3 == null) {
                    fArr3 = new float[fArr.length];
                }
                for (int i8 = 0; i8 < fArr3.length; i8++) {
                    float f5 = fArr[i8];
                    fArr3[i8] = androidx.activity.j.a(fArr2[i8], f5, f4, f5);
                }
                return fArr3;
            case 1:
                Rect rect = (Rect) obj;
                Rect rect2 = (Rect) obj2;
                int i9 = rect.left + ((int) ((rect2.left - i4) * f4));
                int i10 = rect.top + ((int) ((rect2.top - i5) * f4));
                int i11 = rect.right + ((int) ((rect2.right - i6) * f4));
                int i12 = rect.bottom + ((int) ((rect2.bottom - i7) * f4));
                Rect rect3 = (Rect) this.f2650b;
                if (rect3 == null) {
                    return new Rect(i9, i10, i11, i12);
                }
                rect3.set(i9, i10, i11, i12);
                return (Rect) this.f2650b;
            default:
                b0.f[] fVarArr = (b0.f[]) obj;
                b0.f[] fVarArr2 = (b0.f[]) obj2;
                if (com.google.common.collect.c.u(fVarArr, fVarArr2)) {
                    if (!com.google.common.collect.c.u((b0.f[]) this.f2650b, fVarArr)) {
                        this.f2650b = com.google.common.collect.c.g0(fVarArr);
                    }
                    for (int i13 = 0; i13 < fVarArr.length; i13++) {
                        b0.f fVar = ((b0.f[]) this.f2650b)[i13];
                        b0.f fVar2 = fVarArr[i13];
                        b0.f fVar3 = fVarArr2[i13];
                        fVar.getClass();
                        fVar.f2495a = fVar2.f2495a;
                        int i14 = 0;
                        while (true) {
                            float[] fArr4 = fVar2.f2496b;
                            if (i14 < fArr4.length) {
                                fVar.f2496b[i14] = (fVar3.f2496b[i14] * f4) + ((1.0f - f4) * fArr4[i14]);
                                i14++;
                            }
                        }
                    }
                    return (b0.f[]) this.f2650b;
                }
                throw new IllegalArgumentException("Can't interpolate between two incompatible pathData");
        }
    }

    public /* synthetic */ n(int i4, Object obj) {
        this.f2649a = i4;
        this.f2650b = obj;
    }
}