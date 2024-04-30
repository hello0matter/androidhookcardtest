package l2;

import android.graphics.Matrix;
import android.graphics.Path;

/* loaded from: classes.dex */
public final class w extends x {

    /* renamed from: b  reason: collision with root package name */
    public float f5386b;

    /* renamed from: c  reason: collision with root package name */
    public float f5387c;

    @Override // l2.x
    public final void a(Matrix matrix, Path path) {
        Matrix matrix2 = this.f5388a;
        matrix.invert(matrix2);
        path.transform(matrix2);
        path.lineTo(this.f5386b, this.f5387c);
        path.transform(matrix);
    }
}