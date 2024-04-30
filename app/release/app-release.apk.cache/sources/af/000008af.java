package n1;

import android.opengl.Matrix;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final float[] f5739a = new float[16];

    /* renamed from: b  reason: collision with root package name */
    public final float[] f5740b = new float[16];

    /* renamed from: c  reason: collision with root package name */
    public final androidx.activity.result.h f5741c = new androidx.activity.result.h();

    /* renamed from: d  reason: collision with root package name */
    public boolean f5742d;

    public static void a(float[] fArr, float[] fArr2) {
        Matrix.setIdentityM(fArr, 0);
        float f4 = fArr2[10];
        float f5 = fArr2[8];
        float sqrt = (float) Math.sqrt((f5 * f5) + (f4 * f4));
        float f6 = fArr2[10];
        fArr[0] = f6 / sqrt;
        float f7 = fArr2[8];
        fArr[2] = f7 / sqrt;
        fArr[8] = (-f7) / sqrt;
        fArr[10] = f6 / sqrt;
    }
}