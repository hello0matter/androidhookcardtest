package k;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
public final class a extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    public float f5103a;

    /* renamed from: b  reason: collision with root package name */
    public final Paint f5104b;

    /* renamed from: c  reason: collision with root package name */
    public final RectF f5105c;

    /* renamed from: d  reason: collision with root package name */
    public final Rect f5106d;

    /* renamed from: e  reason: collision with root package name */
    public float f5107e;

    /* renamed from: h  reason: collision with root package name */
    public ColorStateList f5110h;

    /* renamed from: i  reason: collision with root package name */
    public PorterDuffColorFilter f5111i;

    /* renamed from: j  reason: collision with root package name */
    public ColorStateList f5112j;

    /* renamed from: f  reason: collision with root package name */
    public boolean f5108f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f5109g = true;

    /* renamed from: k  reason: collision with root package name */
    public PorterDuff.Mode f5113k = PorterDuff.Mode.SRC_IN;

    public a(float f4, ColorStateList colorStateList) {
        this.f5103a = f4;
        Paint paint = new Paint(5);
        this.f5104b = paint;
        colorStateList = colorStateList == null ? ColorStateList.valueOf(0) : colorStateList;
        this.f5110h = colorStateList;
        paint.setColor(colorStateList.getColorForState(getState(), this.f5110h.getDefaultColor()));
        this.f5105c = new RectF();
        this.f5106d = new Rect();
    }

    public final PorterDuffColorFilter a(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList != null && mode != null) {
            return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
        }
        return null;
    }

    public final void b(Rect rect) {
        if (rect == null) {
            rect = getBounds();
        }
        RectF rectF = this.f5105c;
        rectF.set(rect.left, rect.top, rect.right, rect.bottom);
        Rect rect2 = this.f5106d;
        rect2.set(rect);
        if (this.f5108f) {
            rect2.inset((int) Math.ceil(b.a(this.f5107e, this.f5103a, this.f5109g)), (int) Math.ceil(b.b(this.f5107e, this.f5103a, this.f5109g)));
            rectF.set(rect2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        boolean z4;
        Paint paint = this.f5104b;
        if (this.f5111i != null && paint.getColorFilter() == null) {
            paint.setColorFilter(this.f5111i);
            z4 = true;
        } else {
            z4 = false;
        }
        RectF rectF = this.f5105c;
        float f4 = this.f5103a;
        canvas.drawRoundRect(rectF, f4, f4, paint);
        if (z4) {
            paint.setColorFilter(null);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void getOutline(Outline outline) {
        outline.setRoundRect(this.f5106d, this.f5103a);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.f5112j;
        if ((colorStateList2 != null && colorStateList2.isStateful()) || (((colorStateList = this.f5110h) != null && colorStateList.isStateful()) || super.isStateful())) {
            return true;
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        b(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] iArr) {
        boolean z4;
        PorterDuff.Mode mode;
        ColorStateList colorStateList = this.f5110h;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        Paint paint = this.f5104b;
        if (colorForState != paint.getColor()) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z4) {
            paint.setColor(colorForState);
        }
        ColorStateList colorStateList2 = this.f5112j;
        if (colorStateList2 != null && (mode = this.f5113k) != null) {
            this.f5111i = a(colorStateList2, mode);
            return true;
        }
        return z4;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i4) {
        this.f5104b.setAlpha(i4);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.f5104b.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintList(ColorStateList colorStateList) {
        this.f5112j = colorStateList;
        this.f5111i = a(colorStateList, this.f5113k);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintMode(PorterDuff.Mode mode) {
        this.f5113k = mode;
        this.f5111i = a(this.f5112j, mode);
        invalidateSelf();
    }
}