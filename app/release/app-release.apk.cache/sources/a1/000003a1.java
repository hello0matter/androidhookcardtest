package c1;

import android.graphics.Matrix;
import android.view.View;

/* loaded from: classes.dex */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    public final Matrix f2627a = new Matrix();

    /* renamed from: b  reason: collision with root package name */
    public final View f2628b;

    /* renamed from: c  reason: collision with root package name */
    public final float[] f2629c;

    /* renamed from: d  reason: collision with root package name */
    public float f2630d;

    /* renamed from: e  reason: collision with root package name */
    public float f2631e;

    public k(View view, float[] fArr) {
        this.f2628b = view;
        float[] fArr2 = (float[]) fArr.clone();
        this.f2629c = fArr2;
        this.f2630d = fArr2[2];
        this.f2631e = fArr2[5];
        a();
    }

    public final void a() {
        float f4 = this.f2630d;
        float[] fArr = this.f2629c;
        fArr[2] = f4;
        fArr[5] = this.f2631e;
        Matrix matrix = this.f2627a;
        matrix.setValues(fArr);
        p0.f2666a.A(this.f2628b, matrix);
    }
}