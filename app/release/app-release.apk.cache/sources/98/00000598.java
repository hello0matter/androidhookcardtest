package com.google.android.material.snackbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import c0.b;
import com.example.msphone.R;
import com.google.android.material.internal.n0;
import i0.g0;
import i0.k0;
import i0.m0;
import i0.y0;
import i2.d;
import java.util.WeakHashMap;
import l2.j;
import l2.p;
import n2.c;
import p2.a;

@RestrictTo({RestrictTo.Scope.f170b})
/* loaded from: classes.dex */
public class BaseTransientBottomBar$SnackbarBaseLayout extends FrameLayout {

    /* renamed from: i  reason: collision with root package name */
    public static final c f3885i = new Object();

    /* renamed from: a  reason: collision with root package name */
    public final p f3886a;

    /* renamed from: b  reason: collision with root package name */
    public int f3887b;

    /* renamed from: c  reason: collision with root package name */
    public final float f3888c;

    /* renamed from: d  reason: collision with root package name */
    public final float f3889d;

    /* renamed from: e  reason: collision with root package name */
    public final int f3890e;

    /* renamed from: f  reason: collision with root package name */
    public final int f3891f;

    /* renamed from: g  reason: collision with root package name */
    public ColorStateList f3892g;

    /* renamed from: h  reason: collision with root package name */
    public PorterDuff.Mode f3893h;

    /* JADX WARN: Multi-variable type inference failed */
    public BaseTransientBottomBar$SnackbarBaseLayout(Context context, AttributeSet attributeSet) {
        super(a.a(context, attributeSet, 0, 0), attributeSet);
        GradientDrawable gradientDrawable;
        Context context2 = getContext();
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, o1.a.Z);
        if (obtainStyledAttributes.hasValue(6)) {
            WeakHashMap weakHashMap = y0.f4999a;
            m0.s(this, obtainStyledAttributes.getDimensionPixelSize(6, 0));
        }
        this.f3887b = obtainStyledAttributes.getInt(2, 0);
        if (obtainStyledAttributes.hasValue(8) || obtainStyledAttributes.hasValue(9)) {
            this.f3886a = p.c(context2, attributeSet, 0, 0).a();
        }
        this.f3888c = obtainStyledAttributes.getFloat(3, 1.0f);
        setBackgroundTintList(d.a(context2, obtainStyledAttributes, 4));
        setBackgroundTintMode(n0.g(obtainStyledAttributes.getInt(5, -1), PorterDuff.Mode.SRC_IN));
        this.f3889d = obtainStyledAttributes.getFloat(1, 1.0f);
        this.f3890e = obtainStyledAttributes.getDimensionPixelSize(0, -1);
        this.f3891f = obtainStyledAttributes.getDimensionPixelSize(7, -1);
        obtainStyledAttributes.recycle();
        setOnTouchListener(f3885i);
        setFocusable(true);
        if (getBackground() == null) {
            int e4 = y1.a.e(y1.a.b(R.attr.colorSurface, this), getBackgroundOverlayColorAlpha(), y1.a.b(R.attr.colorOnSurface, this));
            p pVar = this.f3886a;
            if (pVar != null) {
                int i4 = n2.d.f5779a;
                j jVar = new j(pVar);
                jVar.o(ColorStateList.valueOf(e4));
                gradientDrawable = jVar;
            } else {
                Resources resources = getResources();
                int i5 = n2.d.f5779a;
                float dimension = resources.getDimension(R.dimen.mtrl_snackbar_background_corner_radius);
                GradientDrawable gradientDrawable2 = new GradientDrawable();
                gradientDrawable2.setShape(0);
                gradientDrawable2.setCornerRadius(dimension);
                gradientDrawable2.setColor(e4);
                gradientDrawable = gradientDrawable2;
            }
            ColorStateList colorStateList = this.f3892g;
            if (colorStateList != null) {
                b.h(gradientDrawable, colorStateList);
            }
            WeakHashMap weakHashMap2 = y0.f4999a;
            g0.q(this, gradientDrawable);
        }
    }

    public float getActionTextColorAlpha() {
        return this.f3889d;
    }

    public int getAnimationMode() {
        return this.f3887b;
    }

    public float getBackgroundOverlayColorAlpha() {
        return this.f3888c;
    }

    public int getMaxInlineActionWidth() {
        return this.f3891f;
    }

    public int getMaxWidth() {
        return this.f3890e;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        WeakHashMap weakHashMap = y0.f4999a;
        k0.c(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z4, int i4, int i5, int i6, int i7) {
        super.onLayout(z4, i4, i5, i6, i7);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i4, int i5) {
        super.onMeasure(i4, i5);
        int i6 = this.f3890e;
        if (i6 <= 0 || getMeasuredWidth() <= i6) {
            return;
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(i6, 1073741824), i5);
    }

    public void setAnimationMode(int i4) {
        this.f3887b = i4;
    }

    @Override // android.view.View
    public void setBackground(@Nullable Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(@Nullable Drawable drawable) {
        if (drawable != null && this.f3892g != null) {
            drawable = drawable.mutate();
            b.h(drawable, this.f3892g);
            b.i(drawable, this.f3893h);
        }
        super.setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundTintList(@Nullable ColorStateList colorStateList) {
        this.f3892g = colorStateList;
        if (getBackground() != null) {
            Drawable mutate = getBackground().mutate();
            b.h(mutate, colorStateList);
            b.i(mutate, this.f3893h);
            if (mutate != getBackground()) {
                super.setBackgroundDrawable(mutate);
            }
        }
    }

    @Override // android.view.View
    public void setBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        this.f3893h = mode;
        if (getBackground() != null) {
            Drawable mutate = getBackground().mutate();
            b.i(mutate, mode);
            if (mutate != getBackground()) {
                super.setBackgroundDrawable(mutate);
            }
        }
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            new Rect(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
        }
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        setOnTouchListener(onClickListener != null ? null : f3885i);
        super.setOnClickListener(onClickListener);
    }

    private void setBaseTransientBottomBar(n2.d dVar) {
    }
}