package d2;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
public final class b extends Drawable {

    /* renamed from: b  reason: collision with root package name */
    public final Paint f4341b;

    /* renamed from: h  reason: collision with root package name */
    public float f4347h;

    /* renamed from: i  reason: collision with root package name */
    public int f4348i;

    /* renamed from: j  reason: collision with root package name */
    public int f4349j;

    /* renamed from: k  reason: collision with root package name */
    public int f4350k;

    /* renamed from: l  reason: collision with root package name */
    public int f4351l;

    /* renamed from: m  reason: collision with root package name */
    public int f4352m;

    /* renamed from: o  reason: collision with root package name */
    public l2.p f4354o;

    /* renamed from: p  reason: collision with root package name */
    public ColorStateList f4355p;

    /* renamed from: a  reason: collision with root package name */
    public final l2.r f4340a = l2.q.f5360a;

    /* renamed from: c  reason: collision with root package name */
    public final Path f4342c = new Path();

    /* renamed from: d  reason: collision with root package name */
    public final Rect f4343d = new Rect();

    /* renamed from: e  reason: collision with root package name */
    public final RectF f4344e = new RectF();

    /* renamed from: f  reason: collision with root package name */
    public final RectF f4345f = new RectF();

    /* renamed from: g  reason: collision with root package name */
    public final d1.e f4346g = new d1.e(this, 0);

    /* renamed from: n  reason: collision with root package name */
    public boolean f4353n = true;

    public b(l2.p pVar) {
        this.f4354o = pVar;
        Paint paint = new Paint(1);
        this.f4341b = paint;
        paint.setStyle(Paint.Style.STROKE);
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        boolean z4 = this.f4353n;
        Paint paint = this.f4341b;
        Rect rect = this.f4343d;
        if (z4) {
            copyBounds(rect);
            float height = this.f4347h / rect.height();
            paint.setShader(new LinearGradient(0.0f, rect.top, 0.0f, rect.bottom, new int[]{b0.a.c(this.f4348i, this.f4352m), b0.a.c(this.f4349j, this.f4352m), b0.a.c(b0.a.e(this.f4349j, 0), this.f4352m), b0.a.c(b0.a.e(this.f4351l, 0), this.f4352m), b0.a.c(this.f4351l, this.f4352m), b0.a.c(this.f4350k, this.f4352m)}, new float[]{0.0f, height, 0.5f, 0.5f, 1.0f - height, 1.0f}, Shader.TileMode.CLAMP));
            this.f4353n = false;
        }
        float strokeWidth = paint.getStrokeWidth() / 2.0f;
        copyBounds(rect);
        RectF rectF = this.f4344e;
        rectF.set(rect);
        l2.d dVar = this.f4354o.f5352e;
        RectF rectF2 = this.f4345f;
        rectF2.set(getBounds());
        float min = Math.min(dVar.a(rectF2), rectF.width() / 2.0f);
        l2.p pVar = this.f4354o;
        rectF2.set(getBounds());
        if (pVar.f(rectF2)) {
            rectF.inset(strokeWidth, strokeWidth);
            canvas.drawRoundRect(rectF, min, min, paint);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        return this.f4346g;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        if (this.f4347h > 0.0f) {
            return -3;
        }
        return -2;
    }

    @Override // android.graphics.drawable.Drawable
    public final void getOutline(Outline outline) {
        l2.p pVar = this.f4354o;
        RectF rectF = this.f4345f;
        rectF.set(getBounds());
        if (pVar.f(rectF)) {
            l2.d dVar = this.f4354o.f5352e;
            rectF.set(getBounds());
            outline.setRoundRect(getBounds(), dVar.a(rectF));
            return;
        }
        Rect rect = this.f4343d;
        copyBounds(rect);
        RectF rectF2 = this.f4344e;
        rectF2.set(rect);
        l2.p pVar2 = this.f4354o;
        Path path = this.f4342c;
        this.f4340a.a(pVar2, 1.0f, rectF2, null, path);
        a2.b.d(outline, path);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean getPadding(Rect rect) {
        l2.p pVar = this.f4354o;
        RectF rectF = this.f4345f;
        rectF.set(getBounds());
        if (pVar.f(rectF)) {
            int round = Math.round(this.f4347h);
            rect.set(round, round, round, round);
            return true;
        }
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        ColorStateList colorStateList = this.f4355p;
        if ((colorStateList != null && colorStateList.isStateful()) || super.isStateful()) {
            return true;
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        this.f4353n = true;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] iArr) {
        int colorForState;
        ColorStateList colorStateList = this.f4355p;
        if (colorStateList != null && (colorForState = colorStateList.getColorForState(iArr, this.f4352m)) != this.f4352m) {
            this.f4353n = true;
            this.f4352m = colorForState;
        }
        if (this.f4353n) {
            invalidateSelf();
        }
        return this.f4353n;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i4) {
        this.f4341b.setAlpha(i4);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.f4341b.setColorFilter(colorFilter);
        invalidateSelf();
    }
}