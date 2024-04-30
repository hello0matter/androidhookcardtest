package d;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.activity.j;
import com.example.msphone.R;

/* loaded from: classes.dex */
public final class d extends Drawable {

    /* renamed from: l  reason: collision with root package name */
    public static final float f4237l = (float) Math.toRadians(45.0d);

    /* renamed from: a  reason: collision with root package name */
    public final Paint f4238a;

    /* renamed from: b  reason: collision with root package name */
    public final float f4239b;

    /* renamed from: c  reason: collision with root package name */
    public final float f4240c;

    /* renamed from: d  reason: collision with root package name */
    public final float f4241d;

    /* renamed from: e  reason: collision with root package name */
    public final float f4242e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f4243f;

    /* renamed from: g  reason: collision with root package name */
    public final Path f4244g;

    /* renamed from: h  reason: collision with root package name */
    public final int f4245h;

    /* renamed from: i  reason: collision with root package name */
    public float f4246i;

    /* renamed from: j  reason: collision with root package name */
    public final float f4247j;

    /* renamed from: k  reason: collision with root package name */
    public final int f4248k;

    public d(Context context) {
        Paint paint = new Paint();
        this.f4238a = paint;
        this.f4244g = new Path();
        this.f4248k = 2;
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.MITER);
        paint.setStrokeCap(Paint.Cap.BUTT);
        paint.setAntiAlias(true);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, c.a.f2557o, R.attr.drawerArrowStyle, 2131755224);
        int color = obtainStyledAttributes.getColor(3, 0);
        if (color != paint.getColor()) {
            paint.setColor(color);
            invalidateSelf();
        }
        float dimension = obtainStyledAttributes.getDimension(7, 0.0f);
        if (paint.getStrokeWidth() != dimension) {
            paint.setStrokeWidth(dimension);
            this.f4247j = (float) (Math.cos(f4237l) * (dimension / 2.0f));
            invalidateSelf();
        }
        boolean z4 = obtainStyledAttributes.getBoolean(6, true);
        if (this.f4243f != z4) {
            this.f4243f = z4;
            invalidateSelf();
        }
        float round = Math.round(obtainStyledAttributes.getDimension(5, 0.0f));
        if (round != this.f4242e) {
            this.f4242e = round;
            invalidateSelf();
        }
        this.f4245h = obtainStyledAttributes.getDimensionPixelSize(4, 0);
        this.f4240c = Math.round(obtainStyledAttributes.getDimension(2, 0.0f));
        this.f4239b = Math.round(obtainStyledAttributes.getDimension(0, 0.0f));
        this.f4241d = obtainStyledAttributes.getDimension(1, 0.0f);
        obtainStyledAttributes.recycle();
    }

    public static float a(float f4, float f5, float f6) {
        return j.a(f5, f4, f6, f4);
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        float f4;
        float f5;
        int i4;
        Rect bounds = getBounds();
        boolean z4 = false;
        int i5 = this.f4248k;
        if (i5 != 0 && (i5 == 1 || (i5 == 3 ? c0.c.a(this) == 0 : c0.c.a(this) == 1))) {
            z4 = true;
        }
        float f6 = this.f4239b;
        float sqrt = (float) Math.sqrt(f6 * f6 * 2.0f);
        float f7 = this.f4246i;
        float f8 = this.f4240c;
        float a5 = a(f8, sqrt, f7);
        float a6 = a(f8, this.f4241d, this.f4246i);
        float round = Math.round(a(0.0f, this.f4247j, this.f4246i));
        float a7 = a(0.0f, f4237l, this.f4246i);
        if (z4) {
            f4 = 0.0f;
        } else {
            f4 = -180.0f;
        }
        if (z4) {
            f5 = 180.0f;
        } else {
            f5 = 0.0f;
        }
        float a8 = a(f4, f5, this.f4246i);
        double d4 = a5;
        double d5 = a7;
        float round2 = (float) Math.round(Math.cos(d5) * d4);
        float round3 = (float) Math.round(Math.sin(d5) * d4);
        Path path = this.f4244g;
        path.rewind();
        float f9 = this.f4242e;
        Paint paint = this.f4238a;
        float a9 = a(paint.getStrokeWidth() + f9, -this.f4247j, this.f4246i);
        float f10 = (-a6) / 2.0f;
        path.moveTo(f10 + round, 0.0f);
        path.rLineTo(a6 - (round * 2.0f), 0.0f);
        path.moveTo(f10, a9);
        path.rLineTo(round2, round3);
        path.moveTo(f10, -a9);
        path.rLineTo(round2, -round3);
        path.close();
        canvas.save();
        float strokeWidth = paint.getStrokeWidth();
        float height = bounds.height() - (3.0f * strokeWidth);
        float f11 = this.f4242e;
        canvas.translate(bounds.centerX(), (strokeWidth * 1.5f) + f11 + ((((int) (height - (2.0f * f11))) / 4) * 2));
        if (this.f4243f) {
            if (z4) {
                i4 = -1;
            } else {
                i4 = 1;
            }
            canvas.rotate(a8 * i4);
        } else if (z4) {
            canvas.rotate(180.0f);
        }
        canvas.drawPath(path, paint);
        canvas.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return this.f4245h;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return this.f4245h;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i4) {
        Paint paint = this.f4238a;
        if (i4 != paint.getAlpha()) {
            paint.setAlpha(i4);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.f4238a.setColorFilter(colorFilter);
        invalidateSelf();
    }
}