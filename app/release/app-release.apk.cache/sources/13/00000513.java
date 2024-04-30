package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.LinearLayoutCompat;

@RestrictTo({RestrictTo.Scope.f170b})
/* loaded from: classes.dex */
public class ForegroundLinearLayout extends LinearLayoutCompat {

    /* renamed from: p  reason: collision with root package name */
    public Drawable f3449p;

    /* renamed from: q  reason: collision with root package name */
    public final Rect f3450q;

    /* renamed from: r  reason: collision with root package name */
    public final Rect f3451r;

    /* renamed from: s  reason: collision with root package name */
    public int f3452s;

    /* renamed from: t  reason: collision with root package name */
    public final boolean f3453t;

    /* renamed from: u  reason: collision with root package name */
    public boolean f3454u;

    public ForegroundLinearLayout(@NonNull Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        super.draw(canvas);
        Drawable drawable = this.f3449p;
        if (drawable != null) {
            if (this.f3454u) {
                this.f3454u = false;
                int right = getRight() - getLeft();
                int bottom = getBottom() - getTop();
                boolean z4 = this.f3453t;
                Rect rect = this.f3450q;
                if (z4) {
                    rect.set(0, 0, right, bottom);
                } else {
                    rect.set(getPaddingLeft(), getPaddingTop(), right - getPaddingRight(), bottom - getPaddingBottom());
                }
                int i4 = this.f3452s;
                int intrinsicWidth = drawable.getIntrinsicWidth();
                int intrinsicHeight = drawable.getIntrinsicHeight();
                Rect rect2 = this.f3451r;
                Gravity.apply(i4, intrinsicWidth, intrinsicHeight, rect, rect2);
                drawable.setBounds(rect2);
            }
            drawable.draw(canvas);
        }
    }

    @Override // android.view.View
    public final void drawableHotspotChanged(float f4, float f5) {
        super.drawableHotspotChanged(f4, f5);
        Drawable drawable = this.f3449p;
        if (drawable != null) {
            drawable.setHotspot(f4, f5);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f3449p;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        this.f3449p.setState(getDrawableState());
    }

    @Override // android.view.View
    @Nullable
    public Drawable getForeground() {
        return this.f3449p;
    }

    @Override // android.view.View
    public int getForegroundGravity() {
        return this.f3452s;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f3449p;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z4, int i4, int i5, int i6, int i7) {
        super.onLayout(z4, i4, i5, i6, i7);
        this.f3454u = z4 | this.f3454u;
    }

    @Override // android.view.View
    public final void onSizeChanged(int i4, int i5, int i6, int i7) {
        super.onSizeChanged(i4, i5, i6, i7);
        this.f3454u = true;
    }

    @Override // android.view.View
    public void setForeground(@Nullable Drawable drawable) {
        Drawable drawable2 = this.f3449p;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
                unscheduleDrawable(this.f3449p);
            }
            this.f3449p = drawable;
            this.f3454u = true;
            if (drawable != null) {
                setWillNotDraw(false);
                drawable.setCallback(this);
                if (drawable.isStateful()) {
                    drawable.setState(getDrawableState());
                }
                if (this.f3452s == 119) {
                    drawable.getPadding(new Rect());
                }
            } else {
                setWillNotDraw(true);
            }
            requestLayout();
            invalidate();
        }
    }

    @Override // android.view.View
    public void setForegroundGravity(int i4) {
        if (this.f3452s != i4) {
            if ((8388615 & i4) == 0) {
                i4 |= 8388611;
            }
            if ((i4 & 112) == 0) {
                i4 |= 48;
            }
            this.f3452s = i4;
            if (i4 == 119 && this.f3449p != null) {
                this.f3449p.getPadding(new Rect());
            }
            requestLayout();
        }
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f3449p;
    }

    public ForegroundLinearLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ForegroundLinearLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f3450q = new Rect();
        this.f3451r = new Rect();
        this.f3452s = 119;
        this.f3453t = true;
        this.f3454u = false;
        TypedArray d4 = h0.d(context, attributeSet, o1.a.f5964u, i4, 0, new int[0]);
        this.f3452s = d4.getInt(1, this.f3452s);
        Drawable drawable = d4.getDrawable(0);
        if (drawable != null) {
            setForeground(drawable);
        }
        this.f3453t = d4.getBoolean(2, true);
        d4.recycle();
    }
}