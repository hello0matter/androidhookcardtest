package l2;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;

/* loaded from: classes.dex */
public final class u extends y {

    /* renamed from: c  reason: collision with root package name */
    public final w f5376c;

    /* renamed from: d  reason: collision with root package name */
    public final float f5377d;

    /* renamed from: e  reason: collision with root package name */
    public final float f5378e;

    public u(w wVar, float f4, float f5) {
        this.f5376c = wVar;
        this.f5377d = f4;
        this.f5378e = f5;
    }

    @Override // l2.y
    public final void a(Matrix matrix, k2.a aVar, int i4, Canvas canvas) {
        w wVar = this.f5376c;
        float f4 = wVar.f5387c;
        float f5 = this.f5378e;
        float f6 = wVar.f5386b;
        float f7 = this.f5377d;
        RectF rectF = new RectF(0.0f, 0.0f, (float) Math.hypot(f4 - f5, f6 - f7), 0.0f);
        Matrix matrix2 = this.f5390a;
        matrix2.set(matrix);
        matrix2.preTranslate(f7, f5);
        matrix2.preRotate(b());
        aVar.getClass();
        rectF.bottom += i4;
        rectF.offset(0.0f, -i4);
        int[] iArr = k2.a.f5132i;
        iArr[0] = aVar.f5141f;
        iArr[1] = aVar.f5140e;
        iArr[2] = aVar.f5139d;
        Paint paint = aVar.f5138c;
        float f8 = rectF.left;
        paint.setShader(new LinearGradient(f8, rectF.top, f8, rectF.bottom, iArr, k2.a.f5133j, Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(matrix2);
        canvas.drawRect(rectF, paint);
        canvas.restore();
    }

    public final float b() {
        w wVar = this.f5376c;
        return (float) Math.toDegrees(Math.atan((wVar.f5387c - this.f5378e) / (wVar.f5386b - this.f5377d)));
    }
}