package h2;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import com.google.android.material.progressindicator.LinearProgressIndicatorSpec;

/* loaded from: classes.dex */
public final class n extends l {

    /* renamed from: c  reason: collision with root package name */
    public float f4867c;

    /* renamed from: d  reason: collision with root package name */
    public float f4868d;

    /* renamed from: e  reason: collision with root package name */
    public float f4869e;

    /* renamed from: f  reason: collision with root package name */
    public Path f4870f;

    public n(LinearProgressIndicatorSpec linearProgressIndicatorSpec) {
        super(linearProgressIndicatorSpec);
        this.f4867c = 300.0f;
    }

    @Override // h2.l
    public final void a(Canvas canvas, Rect rect, float f4) {
        this.f4867c = rect.width();
        d dVar = this.f4863a;
        float f5 = ((LinearProgressIndicatorSpec) dVar).f4819a;
        canvas.translate((rect.width() / 2.0f) + rect.left, Math.max(0.0f, (rect.height() - ((LinearProgressIndicatorSpec) dVar).f4819a) / 2.0f) + (rect.height() / 2.0f) + rect.top);
        if (((LinearProgressIndicatorSpec) dVar).f3724i) {
            canvas.scale(-1.0f, 1.0f);
        }
        if ((this.f4864b.d() && ((LinearProgressIndicatorSpec) dVar).f4823e == 1) || (this.f4864b.c() && ((LinearProgressIndicatorSpec) dVar).f4824f == 2)) {
            canvas.scale(1.0f, -1.0f);
        }
        if (this.f4864b.d() || this.f4864b.c()) {
            canvas.translate(0.0f, ((f4 - 1.0f) * ((LinearProgressIndicatorSpec) dVar).f4819a) / 2.0f);
        }
        float f6 = this.f4867c;
        canvas.clipRect((-f6) / 2.0f, (-f5) / 2.0f, f6 / 2.0f, f5 / 2.0f);
        this.f4868d = ((LinearProgressIndicatorSpec) dVar).f4819a * f4;
        this.f4869e = ((LinearProgressIndicatorSpec) dVar).f4820b * f4;
    }

    @Override // h2.l
    public final void b(Canvas canvas, Paint paint, float f4, float f5, int i4) {
        if (f4 == f5) {
            return;
        }
        float f6 = this.f4867c;
        float f7 = (-f6) / 2.0f;
        float f8 = (f5 * f6) + f7;
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        paint.setColor(i4);
        canvas.save();
        canvas.clipPath(this.f4870f);
        float f9 = this.f4868d;
        RectF rectF = new RectF(((f4 * f6) + f7) - (this.f4869e * 2.0f), (-f9) / 2.0f, f8, f9 / 2.0f);
        float f10 = this.f4869e;
        canvas.drawRoundRect(rectF, f10, f10, paint);
        canvas.restore();
    }

    @Override // h2.l
    public final void c(Canvas canvas, Paint paint) {
        int a5 = y1.a.a(((LinearProgressIndicatorSpec) this.f4863a).f4822d, this.f4864b.f4862j);
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        paint.setColor(a5);
        Path path = new Path();
        this.f4870f = path;
        float f4 = this.f4867c;
        float f5 = this.f4868d;
        RectF rectF = new RectF((-f4) / 2.0f, (-f5) / 2.0f, f4 / 2.0f, f5 / 2.0f);
        float f6 = this.f4869e;
        path.addRoundRect(rectF, f6, f6, Path.Direction.CCW);
        canvas.drawPath(this.f4870f, paint);
    }

    @Override // h2.l
    public final int d() {
        return ((LinearProgressIndicatorSpec) this.f4863a).f4819a;
    }

    @Override // h2.l
    public final int e() {
        return -1;
    }
}