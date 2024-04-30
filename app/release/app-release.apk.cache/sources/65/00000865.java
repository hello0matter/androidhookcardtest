package l2;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;

/* loaded from: classes.dex */
public final class t extends y {

    /* renamed from: c  reason: collision with root package name */
    public final v f5375c;

    public t(v vVar) {
        this.f5375c = vVar;
    }

    @Override // l2.y
    public final void a(Matrix matrix, k2.a aVar, int i4, Canvas canvas) {
        boolean z4;
        v vVar = this.f5375c;
        float f4 = vVar.f5384f;
        float f5 = vVar.f5385g;
        RectF rectF = new RectF(vVar.f5380b, vVar.f5381c, vVar.f5382d, vVar.f5383e);
        aVar.getClass();
        if (f5 < 0.0f) {
            z4 = true;
        } else {
            z4 = false;
        }
        Path path = aVar.f5142g;
        int[] iArr = k2.a.f5134k;
        if (z4) {
            iArr[0] = 0;
            iArr[1] = aVar.f5141f;
            iArr[2] = aVar.f5140e;
            iArr[3] = aVar.f5139d;
        } else {
            path.rewind();
            path.moveTo(rectF.centerX(), rectF.centerY());
            path.arcTo(rectF, f4, f5);
            path.close();
            float f6 = -i4;
            rectF.inset(f6, f6);
            iArr[0] = 0;
            iArr[1] = aVar.f5139d;
            iArr[2] = aVar.f5140e;
            iArr[3] = aVar.f5141f;
        }
        float width = rectF.width() / 2.0f;
        if (width > 0.0f) {
            float f7 = 1.0f - (i4 / width);
            float[] fArr = k2.a.f5135l;
            fArr[1] = f7;
            fArr[2] = ((1.0f - f7) / 2.0f) + f7;
            RadialGradient radialGradient = new RadialGradient(rectF.centerX(), rectF.centerY(), width, iArr, fArr, Shader.TileMode.CLAMP);
            Paint paint = aVar.f5137b;
            paint.setShader(radialGradient);
            canvas.save();
            canvas.concat(matrix);
            canvas.scale(1.0f, rectF.height() / rectF.width());
            if (!z4) {
                canvas.clipPath(path, Region.Op.DIFFERENCE);
                canvas.drawPath(path, aVar.f5143h);
            }
            canvas.drawArc(rectF, f4, f5, true, paint);
            canvas.restore();
        }
    }
}