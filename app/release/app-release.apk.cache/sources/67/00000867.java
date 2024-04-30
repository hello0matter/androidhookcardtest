package l2;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;

/* loaded from: classes.dex */
public final class v extends x {

    /* renamed from: h  reason: collision with root package name */
    public static final RectF f5379h = new RectF();

    /* renamed from: b  reason: collision with root package name */
    public final float f5380b;

    /* renamed from: c  reason: collision with root package name */
    public final float f5381c;

    /* renamed from: d  reason: collision with root package name */
    public final float f5382d;

    /* renamed from: e  reason: collision with root package name */
    public final float f5383e;

    /* renamed from: f  reason: collision with root package name */
    public float f5384f;

    /* renamed from: g  reason: collision with root package name */
    public float f5385g;

    public v(float f4, float f5, float f6, float f7) {
        this.f5380b = f4;
        this.f5381c = f5;
        this.f5382d = f6;
        this.f5383e = f7;
    }

    @Override // l2.x
    public final void a(Matrix matrix, Path path) {
        Matrix matrix2 = this.f5388a;
        matrix.invert(matrix2);
        path.transform(matrix2);
        RectF rectF = f5379h;
        rectF.set(this.f5380b, this.f5381c, this.f5382d, this.f5383e);
        path.arcTo(rectF, this.f5384f, this.f5385g, false);
        path.transform(matrix);
    }
}