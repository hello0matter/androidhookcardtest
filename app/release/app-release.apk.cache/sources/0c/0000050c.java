package com.google.android.material.imageview;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AppCompatImageView;
import i2.d;
import l2.a0;
import l2.j;
import l2.p;
import l2.q;
import l2.r;
import p2.a;
import z.e;

/* loaded from: classes.dex */
public class ShapeableImageView extends AppCompatImageView implements a0 {

    /* renamed from: d  reason: collision with root package name */
    public final r f3419d;

    /* renamed from: e  reason: collision with root package name */
    public final RectF f3420e;

    /* renamed from: f  reason: collision with root package name */
    public final RectF f3421f;

    /* renamed from: g  reason: collision with root package name */
    public final Paint f3422g;

    /* renamed from: h  reason: collision with root package name */
    public final Paint f3423h;

    /* renamed from: i  reason: collision with root package name */
    public final Path f3424i;

    /* renamed from: j  reason: collision with root package name */
    public ColorStateList f3425j;

    /* renamed from: k  reason: collision with root package name */
    public j f3426k;

    /* renamed from: l  reason: collision with root package name */
    public p f3427l;

    /* renamed from: m  reason: collision with root package name */
    public float f3428m;

    /* renamed from: n  reason: collision with root package name */
    public final Path f3429n;

    /* renamed from: o  reason: collision with root package name */
    public int f3430o;

    /* renamed from: p  reason: collision with root package name */
    public int f3431p;

    /* renamed from: q  reason: collision with root package name */
    public int f3432q;

    /* renamed from: r  reason: collision with root package name */
    public int f3433r;

    /* renamed from: s  reason: collision with root package name */
    public int f3434s;

    /* renamed from: t  reason: collision with root package name */
    public int f3435t;

    /* renamed from: u  reason: collision with root package name */
    public boolean f3436u;

    public ShapeableImageView(Context context) {
        this(context, null, 0);
    }

    public final boolean c() {
        if (getLayoutDirection() == 1) {
            return true;
        }
        return false;
    }

    public final void d(int i4, int i5) {
        RectF rectF = this.f3420e;
        rectF.set(getPaddingLeft(), getPaddingTop(), i4 - getPaddingRight(), i5 - getPaddingBottom());
        p pVar = this.f3427l;
        Path path = this.f3424i;
        this.f3419d.a(pVar, 1.0f, rectF, null, path);
        Path path2 = this.f3429n;
        path2.rewind();
        path2.addPath(path);
        RectF rectF2 = this.f3421f;
        rectF2.set(0.0f, 0.0f, i4, i5);
        path2.addRect(rectF2, Path.Direction.CCW);
    }

    @Dimension
    public int getContentPaddingBottom() {
        return this.f3433r;
    }

    @Dimension
    public final int getContentPaddingEnd() {
        int i4 = this.f3435t;
        return i4 != Integer.MIN_VALUE ? i4 : c() ? this.f3430o : this.f3432q;
    }

    @Dimension
    public int getContentPaddingLeft() {
        int i4;
        int i5;
        if (this.f3434s != Integer.MIN_VALUE || this.f3435t != Integer.MIN_VALUE) {
            if (c() && (i5 = this.f3435t) != Integer.MIN_VALUE) {
                return i5;
            }
            if (!c() && (i4 = this.f3434s) != Integer.MIN_VALUE) {
                return i4;
            }
        }
        return this.f3430o;
    }

    @Dimension
    public int getContentPaddingRight() {
        int i4;
        int i5;
        if (this.f3434s != Integer.MIN_VALUE || this.f3435t != Integer.MIN_VALUE) {
            if (c() && (i5 = this.f3434s) != Integer.MIN_VALUE) {
                return i5;
            }
            if (!c() && (i4 = this.f3435t) != Integer.MIN_VALUE) {
                return i4;
            }
        }
        return this.f3432q;
    }

    @Dimension
    public final int getContentPaddingStart() {
        int i4 = this.f3434s;
        return i4 != Integer.MIN_VALUE ? i4 : c() ? this.f3432q : this.f3430o;
    }

    @Dimension
    public int getContentPaddingTop() {
        return this.f3431p;
    }

    @Override // android.view.View
    @Dimension
    public int getPaddingBottom() {
        return super.getPaddingBottom() - getContentPaddingBottom();
    }

    @Override // android.view.View
    @Dimension
    public int getPaddingEnd() {
        return super.getPaddingEnd() - getContentPaddingEnd();
    }

    @Override // android.view.View
    @Dimension
    public int getPaddingLeft() {
        return super.getPaddingLeft() - getContentPaddingLeft();
    }

    @Override // android.view.View
    @Dimension
    public int getPaddingRight() {
        return super.getPaddingRight() - getContentPaddingRight();
    }

    @Override // android.view.View
    @Dimension
    public int getPaddingStart() {
        return super.getPaddingStart() - getContentPaddingStart();
    }

    @Override // android.view.View
    @Dimension
    public int getPaddingTop() {
        return super.getPaddingTop() - getContentPaddingTop();
    }

    @NonNull
    public p getShapeAppearanceModel() {
        return this.f3427l;
    }

    @Nullable
    public ColorStateList getStrokeColor() {
        return this.f3425j;
    }

    @Dimension
    public float getStrokeWidth() {
        return this.f3428m;
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(this.f3429n, this.f3423h);
        if (this.f3425j != null) {
            Paint paint = this.f3422g;
            paint.setStrokeWidth(this.f3428m);
            int colorForState = this.f3425j.getColorForState(getDrawableState(), this.f3425j.getDefaultColor());
            if (this.f3428m > 0.0f && colorForState != 0) {
                paint.setColor(colorForState);
                canvas.drawPath(this.f3424i, paint);
            }
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onMeasure(int i4, int i5) {
        super.onMeasure(i4, i5);
        if (this.f3436u || !isLayoutDirectionResolved()) {
            return;
        }
        this.f3436u = true;
        if (!isPaddingRelative() && this.f3434s == Integer.MIN_VALUE && this.f3435t == Integer.MIN_VALUE) {
            setPadding(super.getPaddingLeft(), super.getPaddingTop(), super.getPaddingRight(), super.getPaddingBottom());
        } else {
            setPaddingRelative(super.getPaddingStart(), super.getPaddingTop(), super.getPaddingEnd(), super.getPaddingBottom());
        }
    }

    @Override // android.view.View
    public final void onSizeChanged(int i4, int i5, int i6, int i7) {
        super.onSizeChanged(i4, i5, i6, i7);
        d(i4, i5);
    }

    public void setContentPadding(@Dimension int i4, @Dimension int i5, @Dimension int i6, @Dimension int i7) {
        this.f3434s = Integer.MIN_VALUE;
        this.f3435t = Integer.MIN_VALUE;
        super.setPadding((super.getPaddingLeft() - this.f3430o) + i4, (super.getPaddingTop() - this.f3431p) + i5, (super.getPaddingRight() - this.f3432q) + i6, (super.getPaddingBottom() - this.f3433r) + i7);
        this.f3430o = i4;
        this.f3431p = i5;
        this.f3432q = i6;
        this.f3433r = i7;
    }

    @RequiresApi(17)
    public void setContentPaddingRelative(@Dimension int i4, @Dimension int i5, @Dimension int i6, @Dimension int i7) {
        super.setPaddingRelative((super.getPaddingStart() - getContentPaddingStart()) + i4, (super.getPaddingTop() - this.f3431p) + i5, (super.getPaddingEnd() - getContentPaddingEnd()) + i6, (super.getPaddingBottom() - this.f3433r) + i7);
        this.f3430o = c() ? i6 : i4;
        this.f3431p = i5;
        if (!c()) {
            i4 = i6;
        }
        this.f3432q = i4;
        this.f3433r = i7;
    }

    @Override // android.view.View
    public void setPadding(@Dimension int i4, @Dimension int i5, @Dimension int i6, @Dimension int i7) {
        super.setPadding(getContentPaddingLeft() + i4, getContentPaddingTop() + i5, getContentPaddingRight() + i6, getContentPaddingBottom() + i7);
    }

    @Override // android.view.View
    public void setPaddingRelative(@Dimension int i4, @Dimension int i5, @Dimension int i6, @Dimension int i7) {
        super.setPaddingRelative(getContentPaddingStart() + i4, getContentPaddingTop() + i5, getContentPaddingEnd() + i6, getContentPaddingBottom() + i7);
    }

    @Override // l2.a0
    public void setShapeAppearanceModel(@NonNull p pVar) {
        this.f3427l = pVar;
        j jVar = this.f3426k;
        if (jVar != null) {
            jVar.setShapeAppearanceModel(pVar);
        }
        d(getWidth(), getHeight());
        invalidate();
        invalidateOutline();
    }

    public void setStrokeColor(@Nullable ColorStateList colorStateList) {
        this.f3425j = colorStateList;
        invalidate();
    }

    public void setStrokeColorResource(@ColorRes int i4) {
        setStrokeColor(e.b(getContext(), i4));
    }

    public void setStrokeWidth(@Dimension float f4) {
        if (this.f3428m != f4) {
            this.f3428m = f4;
            invalidate();
        }
    }

    public void setStrokeWidthResource(@DimenRes int i4) {
        setStrokeWidth(getResources().getDimensionPixelSize(i4));
    }

    public ShapeableImageView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ShapeableImageView(Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(a.a(context, attributeSet, i4, 2131756087), attributeSet, i4);
        this.f3419d = q.f5360a;
        this.f3424i = new Path();
        this.f3436u = false;
        Context context2 = getContext();
        Paint paint = new Paint();
        this.f3423h = paint;
        paint.setAntiAlias(true);
        paint.setColor(-1);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.f3420e = new RectF();
        this.f3421f = new RectF();
        this.f3429n = new Path();
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, o1.a.W, i4, 2131756087);
        setLayerType(2, null);
        this.f3425j = d.a(context2, obtainStyledAttributes, 9);
        this.f3428m = obtainStyledAttributes.getDimensionPixelSize(10, 0);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.f3430o = dimensionPixelSize;
        this.f3431p = dimensionPixelSize;
        this.f3432q = dimensionPixelSize;
        this.f3433r = dimensionPixelSize;
        this.f3430o = obtainStyledAttributes.getDimensionPixelSize(3, dimensionPixelSize);
        this.f3431p = obtainStyledAttributes.getDimensionPixelSize(6, dimensionPixelSize);
        this.f3432q = obtainStyledAttributes.getDimensionPixelSize(4, dimensionPixelSize);
        this.f3433r = obtainStyledAttributes.getDimensionPixelSize(1, dimensionPixelSize);
        this.f3434s = obtainStyledAttributes.getDimensionPixelSize(5, Integer.MIN_VALUE);
        this.f3435t = obtainStyledAttributes.getDimensionPixelSize(2, Integer.MIN_VALUE);
        obtainStyledAttributes.recycle();
        Paint paint2 = new Paint();
        this.f3422g = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setAntiAlias(true);
        this.f3427l = p.c(context2, attributeSet, i4, 2131756087).a();
        setOutlineProvider(new e2.a(this));
    }
}