package o;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionLayout;

/* loaded from: classes.dex */
public final class s {

    /* renamed from: a  reason: collision with root package name */
    public float[] f5875a;

    /* renamed from: b  reason: collision with root package name */
    public final int[] f5876b;

    /* renamed from: c  reason: collision with root package name */
    public final float[] f5877c;

    /* renamed from: d  reason: collision with root package name */
    public Path f5878d;

    /* renamed from: e  reason: collision with root package name */
    public final Paint f5879e;

    /* renamed from: f  reason: collision with root package name */
    public final Paint f5880f;

    /* renamed from: g  reason: collision with root package name */
    public final Paint f5881g;

    /* renamed from: h  reason: collision with root package name */
    public final Paint f5882h;

    /* renamed from: i  reason: collision with root package name */
    public final Paint f5883i;

    /* renamed from: j  reason: collision with root package name */
    public final float[] f5884j;

    /* renamed from: k  reason: collision with root package name */
    public int f5885k;

    /* renamed from: l  reason: collision with root package name */
    public final Rect f5886l = new Rect();

    /* renamed from: m  reason: collision with root package name */
    public final int f5887m = 1;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ MotionLayout f5888n;

    public s(MotionLayout motionLayout) {
        this.f5888n = motionLayout;
        Paint paint = new Paint();
        this.f5879e = paint;
        paint.setAntiAlias(true);
        paint.setColor(-21965);
        paint.setStrokeWidth(2.0f);
        Paint.Style style = Paint.Style.STROKE;
        paint.setStyle(style);
        Paint paint2 = new Paint();
        this.f5880f = paint2;
        paint2.setAntiAlias(true);
        paint2.setColor(-2067046);
        paint2.setStrokeWidth(2.0f);
        paint2.setStyle(style);
        Paint paint3 = new Paint();
        this.f5881g = paint3;
        paint3.setAntiAlias(true);
        paint3.setColor(-13391360);
        paint3.setStrokeWidth(2.0f);
        paint3.setStyle(style);
        Paint paint4 = new Paint();
        this.f5882h = paint4;
        paint4.setAntiAlias(true);
        paint4.setColor(-13391360);
        paint4.setTextSize(motionLayout.getContext().getResources().getDisplayMetrics().density * 12.0f);
        this.f5884j = new float[8];
        Paint paint5 = new Paint();
        this.f5883i = paint5;
        paint5.setAntiAlias(true);
        paint3.setPathEffect(new DashPathEffect(new float[]{4.0f, 8.0f}, 0.0f));
        this.f5877c = new float[100];
        this.f5876b = new int[50];
    }

    public final void a(Canvas canvas, int i4, int i5, p pVar) {
        int i6;
        int i7;
        Paint paint;
        float f4;
        float f5;
        int i8;
        int[] iArr = this.f5876b;
        int i9 = 4;
        if (i4 == 4) {
            boolean z4 = false;
            boolean z5 = false;
            for (int i10 = 0; i10 < this.f5885k; i10++) {
                int i11 = iArr[i10];
                if (i11 == 1) {
                    z4 = true;
                }
                if (i11 == 2) {
                    z5 = true;
                }
            }
            if (z4) {
                float[] fArr = this.f5875a;
                canvas.drawLine(fArr[0], fArr[1], fArr[fArr.length - 2], fArr[fArr.length - 1], this.f5881g);
            }
            if (z5) {
                b(canvas);
            }
        }
        if (i4 == 2) {
            float[] fArr2 = this.f5875a;
            canvas.drawLine(fArr2[0], fArr2[1], fArr2[fArr2.length - 2], fArr2[fArr2.length - 1], this.f5881g);
        }
        if (i4 == 3) {
            b(canvas);
        }
        canvas.drawLines(this.f5875a, this.f5879e);
        View view = pVar.f5846a;
        if (view != null) {
            i6 = view.getWidth();
            i7 = pVar.f5846a.getHeight();
        } else {
            i6 = 0;
            i7 = 0;
        }
        int i12 = 1;
        while (i12 < i5 - 1) {
            if (i4 == i9 && iArr[i12 - 1] == 0) {
                i8 = i12;
            } else {
                int i13 = i12 * 2;
                float[] fArr3 = this.f5877c;
                float f6 = fArr3[i13];
                float f7 = fArr3[i13 + 1];
                this.f5878d.reset();
                this.f5878d.moveTo(f6, f7 + 10.0f);
                this.f5878d.lineTo(f6 + 10.0f, f7);
                this.f5878d.lineTo(f6, f7 - 10.0f);
                this.f5878d.lineTo(f6 - 10.0f, f7);
                this.f5878d.close();
                int i14 = i12 - 1;
                w wVar = (w) pVar.f5864s.get(i14);
                Paint paint2 = this.f5883i;
                if (i4 == i9) {
                    int i15 = iArr[i14];
                    if (i15 == 1) {
                        d(canvas, f6 - 0.0f, f7 - 0.0f);
                    } else if (i15 == 2) {
                        c(canvas, f6 - 0.0f, f7 - 0.0f);
                    } else if (i15 == 3) {
                        paint = paint2;
                        f4 = f7;
                        f5 = f6;
                        i8 = i12;
                        e(canvas, f6 - 0.0f, f7 - 0.0f, i6, i7);
                        canvas.drawPath(this.f5878d, paint);
                    }
                    paint = paint2;
                    f4 = f7;
                    f5 = f6;
                    i8 = i12;
                    canvas.drawPath(this.f5878d, paint);
                } else {
                    paint = paint2;
                    f4 = f7;
                    f5 = f6;
                    i8 = i12;
                }
                if (i4 == 2) {
                    d(canvas, f5 - 0.0f, f4 - 0.0f);
                }
                if (i4 == 3) {
                    c(canvas, f5 - 0.0f, f4 - 0.0f);
                }
                if (i4 == 6) {
                    e(canvas, f5 - 0.0f, f4 - 0.0f, i6, i7);
                }
                canvas.drawPath(this.f5878d, paint);
            }
            i12 = i8 + 1;
            i9 = 4;
        }
        float[] fArr4 = this.f5875a;
        if (fArr4.length > 1) {
            float f8 = fArr4[0];
            float f9 = fArr4[1];
            Paint paint3 = this.f5880f;
            canvas.drawCircle(f8, f9, 8.0f, paint3);
            float[] fArr5 = this.f5875a;
            canvas.drawCircle(fArr5[fArr5.length - 2], fArr5[fArr5.length - 1], 8.0f, paint3);
        }
    }

    public final void b(Canvas canvas) {
        float[] fArr = this.f5875a;
        float f4 = fArr[0];
        float f5 = fArr[1];
        float f6 = fArr[fArr.length - 2];
        float f7 = fArr[fArr.length - 1];
        float min = Math.min(f4, f6);
        float max = Math.max(f5, f7);
        float max2 = Math.max(f4, f6);
        float max3 = Math.max(f5, f7);
        Paint paint = this.f5881g;
        canvas.drawLine(min, max, max2, max3, paint);
        canvas.drawLine(Math.min(f4, f6), Math.min(f5, f7), Math.min(f4, f6), Math.max(f5, f7), paint);
    }

    public final void c(Canvas canvas, float f4, float f5) {
        float[] fArr = this.f5875a;
        float f6 = fArr[0];
        float f7 = fArr[1];
        float f8 = fArr[fArr.length - 2];
        float f9 = fArr[fArr.length - 1];
        float min = Math.min(f6, f8);
        float max = Math.max(f7, f9);
        float min2 = f4 - Math.min(f6, f8);
        float max2 = Math.max(f7, f9) - f5;
        String str = "" + (((int) (((min2 * 100.0f) / Math.abs(f8 - f6)) + 0.5d)) / 100.0f);
        Paint paint = this.f5882h;
        paint.getTextBounds(str, 0, str.length(), this.f5886l);
        Rect rect = this.f5886l;
        canvas.drawText(str, ((min2 / 2.0f) - (rect.width() / 2)) + min, f5 - 20.0f, paint);
        float min3 = Math.min(f6, f8);
        Paint paint2 = this.f5881g;
        canvas.drawLine(f4, f5, min3, f5, paint2);
        String str2 = "" + (((int) (((max2 * 100.0f) / Math.abs(f9 - f7)) + 0.5d)) / 100.0f);
        paint.getTextBounds(str2, 0, str2.length(), this.f5886l);
        canvas.drawText(str2, f4 + 5.0f, max - ((max2 / 2.0f) - (rect.height() / 2)), paint);
        canvas.drawLine(f4, f5, f4, Math.max(f7, f9), paint2);
    }

    public final void d(Canvas canvas, float f4, float f5) {
        float[] fArr = this.f5875a;
        float f6 = fArr[0];
        float f7 = fArr[1];
        float f8 = fArr[fArr.length - 2];
        float f9 = fArr[fArr.length - 1];
        float hypot = (float) Math.hypot(f6 - f8, f7 - f9);
        float f10 = f8 - f6;
        float f11 = f9 - f7;
        float f12 = (((f5 - f7) * f11) + ((f4 - f6) * f10)) / (hypot * hypot);
        float f13 = f6 + (f10 * f12);
        float f14 = f7 + (f12 * f11);
        Path path = new Path();
        path.moveTo(f4, f5);
        path.lineTo(f13, f14);
        float hypot2 = (float) Math.hypot(f13 - f4, f14 - f5);
        String str = "" + (((int) ((hypot2 * 100.0f) / hypot)) / 100.0f);
        Paint paint = this.f5882h;
        paint.getTextBounds(str, 0, str.length(), this.f5886l);
        canvas.drawTextOnPath(str, path, (hypot2 / 2.0f) - (this.f5886l.width() / 2), -20.0f, paint);
        canvas.drawLine(f4, f5, f13, f14, this.f5881g);
    }

    public final void e(Canvas canvas, float f4, float f5, int i4, int i5) {
        StringBuilder sb = new StringBuilder("");
        MotionLayout motionLayout = this.f5888n;
        sb.append(((int) ((((f4 - (i4 / 2)) * 100.0f) / (motionLayout.getWidth() - i4)) + 0.5d)) / 100.0f);
        String sb2 = sb.toString();
        Paint paint = this.f5882h;
        paint.getTextBounds(sb2, 0, sb2.length(), this.f5886l);
        Rect rect = this.f5886l;
        canvas.drawText(sb2, ((f4 / 2.0f) - (rect.width() / 2)) + 0.0f, f5 - 20.0f, paint);
        float min = Math.min(0.0f, 1.0f);
        Paint paint2 = this.f5881g;
        canvas.drawLine(f4, f5, min, f5, paint2);
        String str = "" + (((int) ((((f5 - (i5 / 2)) * 100.0f) / (motionLayout.getHeight() - i5)) + 0.5d)) / 100.0f);
        paint.getTextBounds(str, 0, str.length(), this.f5886l);
        canvas.drawText(str, f4 + 5.0f, 0.0f - ((f5 / 2.0f) - (rect.height() / 2)), paint);
        canvas.drawLine(f4, f5, f4, Math.max(0.0f, 1.0f), paint2);
    }
}