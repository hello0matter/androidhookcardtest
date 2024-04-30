package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import i0.g2;
import i0.y0;
import java.util.WeakHashMap;

@RestrictTo({RestrictTo.Scope.f170b})
/* loaded from: classes.dex */
public class ScrimInsetsFrameLayout extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    public Drawable f3460a;

    /* renamed from: b  reason: collision with root package name */
    public Rect f3461b;

    /* renamed from: c  reason: collision with root package name */
    public final Rect f3462c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f3463d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f3464e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f3465f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f3466g;

    public ScrimInsetsFrameLayout(@NonNull Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        super.draw(canvas);
        int width = getWidth();
        int height = getHeight();
        if (this.f3461b == null || this.f3460a == null) {
            return;
        }
        int save = canvas.save();
        canvas.translate(getScrollX(), getScrollY());
        boolean z4 = this.f3463d;
        Rect rect = this.f3462c;
        if (z4) {
            rect.set(0, 0, width, this.f3461b.top);
            this.f3460a.setBounds(rect);
            this.f3460a.draw(canvas);
        }
        if (this.f3464e) {
            rect.set(0, height - this.f3461b.bottom, width, height);
            this.f3460a.setBounds(rect);
            this.f3460a.draw(canvas);
        }
        if (this.f3465f) {
            Rect rect2 = this.f3461b;
            rect.set(0, rect2.top, rect2.left, height - rect2.bottom);
            this.f3460a.setBounds(rect);
            this.f3460a.draw(canvas);
        }
        if (this.f3466g) {
            Rect rect3 = this.f3461b;
            rect.set(width - rect3.right, rect3.top, width, height - rect3.bottom);
            this.f3460a.setBounds(rect);
            this.f3460a.draw(canvas);
        }
        canvas.restoreToCount(save);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable drawable = this.f3460a;
        if (drawable != null) {
            drawable.setCallback(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Drawable drawable = this.f3460a;
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    public void setDrawBottomInsetForeground(boolean z4) {
        this.f3464e = z4;
    }

    public void setDrawLeftInsetForeground(boolean z4) {
        this.f3465f = z4;
    }

    public void setDrawRightInsetForeground(boolean z4) {
        this.f3466g = z4;
    }

    public void setDrawTopInsetForeground(boolean z4) {
        this.f3463d = z4;
    }

    public void setScrimInsetForeground(@Nullable Drawable drawable) {
        this.f3460a = drawable;
    }

    public ScrimInsetsFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScrimInsetsFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f3462c = new Rect();
        this.f3463d = true;
        this.f3464e = true;
        this.f3465f = true;
        this.f3466g = true;
        TypedArray d4 = h0.d(context, attributeSet, o1.a.R, i4, 2131755829, new int[0]);
        this.f3460a = d4.getDrawable(0);
        d4.recycle();
        setWillNotDraw(true);
        w1.g gVar = new w1.g(4, this);
        WeakHashMap weakHashMap = y0.f4999a;
        i0.m0.u(this, gVar);
    }

    public void e(g2 g2Var) {
    }
}