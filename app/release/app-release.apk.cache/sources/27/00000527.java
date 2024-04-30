package com.google.android.material.internal;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
public final class f extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    public final Drawable f3546a;

    /* renamed from: b  reason: collision with root package name */
    public final Drawable f3547b;

    /* renamed from: c  reason: collision with root package name */
    public final float[] f3548c;

    /* renamed from: d  reason: collision with root package name */
    public float f3549d;

    public f(Drawable drawable, Drawable drawable2) {
        this.f3546a = drawable.getConstantState().newDrawable().mutate();
        Drawable mutate = drawable2.getConstantState().newDrawable().mutate();
        this.f3547b = mutate;
        mutate.setAlpha(0);
        this.f3548c = new float[2];
    }

    public final void a(float f4) {
        if (this.f3549d != f4) {
            this.f3549d = f4;
            float[] fArr = this.f3548c;
            com.google.common.collect.c.t(f4, fArr);
            this.f3546a.setAlpha((int) (fArr[0] * 255.0f));
            this.f3547b.setAlpha((int) (fArr[1] * 255.0f));
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        this.f3546a.draw(canvas);
        this.f3547b.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return Math.max(this.f3546a.getIntrinsicHeight(), this.f3547b.getIntrinsicHeight());
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return Math.max(this.f3546a.getIntrinsicWidth(), this.f3547b.getIntrinsicWidth());
    }

    @Override // android.graphics.drawable.Drawable
    public final int getMinimumHeight() {
        return Math.max(this.f3546a.getMinimumHeight(), this.f3547b.getMinimumHeight());
    }

    @Override // android.graphics.drawable.Drawable
    public final int getMinimumWidth() {
        return Math.max(this.f3546a.getMinimumWidth(), this.f3547b.getMinimumWidth());
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        return this.f3546a.isStateful() || this.f3547b.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i4) {
        int i5 = (this.f3549d > 0.5f ? 1 : (this.f3549d == 0.5f ? 0 : -1));
        Drawable drawable = this.f3547b;
        Drawable drawable2 = this.f3546a;
        if (i5 <= 0) {
            drawable2.setAlpha(i4);
            drawable.setAlpha(0);
        } else {
            drawable2.setAlpha(0);
            drawable.setAlpha(i4);
        }
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setBounds(int i4, int i5, int i6, int i7) {
        super.setBounds(i4, i5, i6, i7);
        this.f3546a.setBounds(i4, i5, i6, i7);
        this.f3547b.setBounds(i4, i5, i6, i7);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.f3546a.setColorFilter(colorFilter);
        this.f3547b.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setState(int[] iArr) {
        return this.f3546a.setState(iArr) || this.f3547b.setState(iArr);
    }
}