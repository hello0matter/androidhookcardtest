package h2;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.google.android.material.progressindicator.CircularProgressIndicatorSpec;

/* loaded from: classes.dex */
public final class e extends l {

    /* renamed from: c  reason: collision with root package name */
    public int f4825c;

    /* renamed from: d  reason: collision with root package name */
    public float f4826d;

    /* renamed from: e  reason: collision with root package name */
    public float f4827e;

    /* renamed from: f  reason: collision with root package name */
    public float f4828f;

    public e(CircularProgressIndicatorSpec circularProgressIndicatorSpec) {
        super(circularProgressIndicatorSpec);
        this.f4825c = 1;
    }

    @Override // h2.l
    public final void a(Canvas canvas, Rect rect, float f4) {
        int i4;
        float width = rect.width() / g();
        float height = rect.height() / g();
        d dVar = this.f4863a;
        float f5 = (((CircularProgressIndicatorSpec) dVar).f3718g / 2.0f) + ((CircularProgressIndicatorSpec) dVar).f3719h;
        canvas.translate((f5 * width) + rect.left, (f5 * height) + rect.top);
        canvas.scale(width, height);
        canvas.rotate(-90.0f);
        float f6 = -f5;
        canvas.clipRect(f6, f6, f5, f5);
        if (((CircularProgressIndicatorSpec) dVar).f3720i == 0) {
            i4 = 1;
        } else {
            i4 = -1;
        }
        this.f4825c = i4;
        this.f4826d = ((CircularProgressIndicatorSpec) dVar).f4819a * f4;
        this.f4827e = ((CircularProgressIndicatorSpec) dVar).f4820b * f4;
        this.f4828f = (((CircularProgressIndicatorSpec) dVar).f3718g - ((CircularProgressIndicatorSpec) dVar).f4819a) / 2.0f;
        if ((this.f4864b.d() && ((CircularProgressIndicatorSpec) dVar).f4823e == 2) || (this.f4864b.c() && ((CircularProgressIndicatorSpec) dVar).f4824f == 1)) {
            this.f4828f = (((1.0f - f4) * ((CircularProgressIndicatorSpec) dVar).f4819a) / 2.0f) + this.f4828f;
        } else if ((this.f4864b.d() && ((CircularProgressIndicatorSpec) dVar).f4823e == 1) || (this.f4864b.c() && ((CircularProgressIndicatorSpec) dVar).f4824f == 2)) {
            this.f4828f -= ((1.0f - f4) * ((CircularProgressIndicatorSpec) dVar).f4819a) / 2.0f;
        }
    }

    @Override // h2.l
    public final void b(Canvas canvas, Paint paint, float f4, float f5, int i4) {
        float f6;
        if (f4 == f5) {
            return;
        }
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.BUTT);
        paint.setAntiAlias(true);
        paint.setColor(i4);
        paint.setStrokeWidth(this.f4826d);
        float f7 = this.f4825c;
        float f8 = f4 * 360.0f * f7;
        if (f5 >= f4) {
            f6 = f5 - f4;
        } else {
            f6 = (1.0f + f5) - f4;
        }
        float f9 = f6 * 360.0f * f7;
        float f10 = this.f4828f;
        float f11 = -f10;
        canvas.drawArc(new RectF(f11, f11, f10, f10), f8, f9, false, paint);
        if (this.f4827e > 0.0f && Math.abs(f9) < 360.0f) {
            paint.setStyle(Paint.Style.FILL);
            f(canvas, paint, this.f4826d, this.f4827e, f8);
            f(canvas, paint, this.f4826d, this.f4827e, f8 + f9);
        }
    }

    @Override // h2.l
    public final void c(Canvas canvas, Paint paint) {
        int a5 = y1.a.a(((CircularProgressIndicatorSpec) this.f4863a).f4822d, this.f4864b.f4862j);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.BUTT);
        paint.setAntiAlias(true);
        paint.setColor(a5);
        paint.setStrokeWidth(this.f4826d);
        float f4 = this.f4828f;
        canvas.drawArc(new RectF(-f4, -f4, f4, f4), 0.0f, 360.0f, false, paint);
    }

    @Override // h2.l
    public final int d() {
        return g();
    }

    @Override // h2.l
    public final int e() {
        return g();
    }

    public final void f(Canvas canvas, Paint paint, float f4, float f5, float f6) {
        canvas.save();
        canvas.rotate(f6);
        float f7 = this.f4828f;
        float f8 = f4 / 2.0f;
        canvas.drawRoundRect(new RectF(f7 - f8, f5, f7 + f8, -f5), f5, f5, paint);
        canvas.restore();
    }

    public final int g() {
        d dVar = this.f4863a;
        return (((CircularProgressIndicatorSpec) dVar).f3719h * 2) + ((CircularProgressIndicatorSpec) dVar).f3718g;
    }
}