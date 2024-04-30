package com.google.android.material.card;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Checkable;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import c0.b;
import com.example.msphone.R;
import com.google.android.material.internal.h0;
import com.google.common.collect.c;
import j2.a;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import l2.a0;
import l2.j;
import l2.n;
import l2.p;
import u1.d;
import z.e;

/* loaded from: classes.dex */
public class MaterialCardView extends CardView implements Checkable, a0 {

    /* renamed from: l  reason: collision with root package name */
    public static final int[] f3166l = {16842911};

    /* renamed from: m  reason: collision with root package name */
    public static final int[] f3167m = {16842912};

    /* renamed from: n  reason: collision with root package name */
    public static final int[] f3168n = {R.attr.state_dragged};

    /* renamed from: h  reason: collision with root package name */
    public final d f3169h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f3170i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f3171j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f3172k;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface CheckedIconGravity {
    }

    public MaterialCardView(Context context) {
        this(context, null);
    }

    @NonNull
    private RectF getBoundsAsRectF() {
        RectF rectF = new RectF();
        rectF.set(this.f3169h.f6860c.getBounds());
        return rectF;
    }

    public final void d() {
        d dVar;
        RippleDrawable rippleDrawable;
        if (Build.VERSION.SDK_INT > 26 && (rippleDrawable = (dVar = this.f3169h).f6872o) != null) {
            Rect bounds = rippleDrawable.getBounds();
            int i4 = bounds.bottom;
            dVar.f6872o.setBounds(bounds.left, bounds.top, bounds.right, i4 - 1);
            dVar.f6872o.setBounds(bounds.left, bounds.top, bounds.right, i4);
        }
    }

    public final void e(int i4, int i5, int i6, int i7) {
        super.setContentPadding(i4, i5, i6, i7);
    }

    @Override // androidx.cardview.widget.CardView
    @NonNull
    public ColorStateList getCardBackgroundColor() {
        return this.f3169h.f6860c.f5310a.f5290c;
    }

    @NonNull
    public ColorStateList getCardForegroundColor() {
        return this.f3169h.f6861d.f5310a.f5290c;
    }

    public float getCardViewRadius() {
        return super.getRadius();
    }

    @Nullable
    public Drawable getCheckedIcon() {
        return this.f3169h.f6867j;
    }

    public int getCheckedIconGravity() {
        return this.f3169h.f6864g;
    }

    @Dimension
    public int getCheckedIconMargin() {
        return this.f3169h.f6862e;
    }

    @Dimension
    public int getCheckedIconSize() {
        return this.f3169h.f6863f;
    }

    @Nullable
    public ColorStateList getCheckedIconTint() {
        return this.f3169h.f6869l;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingBottom() {
        return this.f3169h.f6859b.bottom;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingLeft() {
        return this.f3169h.f6859b.left;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingRight() {
        return this.f3169h.f6859b.right;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingTop() {
        return this.f3169h.f6859b.top;
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float getProgress() {
        return this.f3169h.f6860c.f5310a.f5297j;
    }

    @Override // androidx.cardview.widget.CardView
    public float getRadius() {
        return this.f3169h.f6860c.j();
    }

    public ColorStateList getRippleColor() {
        return this.f3169h.f6868k;
    }

    @NonNull
    public p getShapeAppearanceModel() {
        return this.f3169h.f6870m;
    }

    @ColorInt
    @Deprecated
    public int getStrokeColor() {
        ColorStateList colorStateList = this.f3169h.f6871n;
        if (colorStateList == null) {
            return -1;
        }
        return colorStateList.getDefaultColor();
    }

    @Nullable
    public ColorStateList getStrokeColorStateList() {
        return this.f3169h.f6871n;
    }

    @Dimension
    public int getStrokeWidth() {
        return this.f3169h.f6865h;
    }

    @Override // android.widget.Checkable
    public final boolean isChecked() {
        return this.f3171j;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        c.R1(this, this.f3169h.f6860c);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final int[] onCreateDrawableState(int i4) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i4 + 3);
        d dVar = this.f3169h;
        if (dVar != null && dVar.f6876s) {
            View.mergeDrawableStates(onCreateDrawableState, f3166l);
        }
        if (this.f3171j) {
            View.mergeDrawableStates(onCreateDrawableState, f3167m);
        }
        if (this.f3172k) {
            View.mergeDrawableStates(onCreateDrawableState, f3168n);
        }
        return onCreateDrawableState;
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.cardview.widget.CardView");
        accessibilityEvent.setChecked(this.f3171j);
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        boolean z4;
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.cardview.widget.CardView");
        d dVar = this.f3169h;
        if (dVar != null && dVar.f6876s) {
            z4 = true;
        } else {
            z4 = false;
        }
        accessibilityNodeInfo.setCheckable(z4);
        accessibilityNodeInfo.setClickable(isClickable());
        accessibilityNodeInfo.setChecked(this.f3171j);
    }

    @Override // androidx.cardview.widget.CardView, android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i4, int i5) {
        super.onMeasure(i4, i5);
        this.f3169h.e(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (this.f3170i) {
            d dVar = this.f3169h;
            if (!dVar.f6875r) {
                Log.i("MaterialCardView", "Setting a custom background is not supported.");
                dVar.f6875r = true;
            }
            super.setBackgroundDrawable(drawable);
        }
    }

    public void setBackgroundInternal(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardBackgroundColor(@ColorInt int i4) {
        this.f3169h.f6860c.o(ColorStateList.valueOf(i4));
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardElevation(float f4) {
        super.setCardElevation(f4);
        d dVar = this.f3169h;
        dVar.f6860c.n(dVar.f6858a.getCardElevation());
    }

    public void setCardForegroundColor(@Nullable ColorStateList colorStateList) {
        j jVar = this.f3169h.f6861d;
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        jVar.o(colorStateList);
    }

    public void setCheckable(boolean z4) {
        this.f3169h.f6876s = z4;
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z4) {
        if (this.f3171j != z4) {
            toggle();
        }
    }

    public void setCheckedIcon(@Nullable Drawable drawable) {
        this.f3169h.g(drawable);
    }

    public void setCheckedIconGravity(int i4) {
        d dVar = this.f3169h;
        if (dVar.f6864g != i4) {
            dVar.f6864g = i4;
            MaterialCardView materialCardView = dVar.f6858a;
            dVar.e(materialCardView.getMeasuredWidth(), materialCardView.getMeasuredHeight());
        }
    }

    public void setCheckedIconMargin(@Dimension int i4) {
        this.f3169h.f6862e = i4;
    }

    public void setCheckedIconMarginResource(@DimenRes int i4) {
        if (i4 != -1) {
            this.f3169h.f6862e = getResources().getDimensionPixelSize(i4);
        }
    }

    public void setCheckedIconResource(@DrawableRes int i4) {
        this.f3169h.g(c.t0(getContext(), i4));
    }

    public void setCheckedIconSize(@Dimension int i4) {
        this.f3169h.f6863f = i4;
    }

    public void setCheckedIconSizeResource(@DimenRes int i4) {
        if (i4 != 0) {
            this.f3169h.f6863f = getResources().getDimensionPixelSize(i4);
        }
    }

    public void setCheckedIconTint(@Nullable ColorStateList colorStateList) {
        d dVar = this.f3169h;
        dVar.f6869l = colorStateList;
        Drawable drawable = dVar.f6867j;
        if (drawable != null) {
            b.h(drawable, colorStateList);
        }
    }

    @Override // android.view.View
    public void setClickable(boolean z4) {
        Drawable drawable;
        super.setClickable(z4);
        d dVar = this.f3169h;
        if (dVar != null) {
            Drawable drawable2 = dVar.f6866i;
            MaterialCardView materialCardView = dVar.f6858a;
            if (materialCardView.isClickable()) {
                drawable = dVar.c();
            } else {
                drawable = dVar.f6861d;
            }
            dVar.f6866i = drawable;
            if (drawable2 != drawable) {
                if (materialCardView.getForeground() instanceof InsetDrawable) {
                    ((InsetDrawable) materialCardView.getForeground()).setDrawable(drawable);
                } else {
                    materialCardView.setForeground(dVar.d(drawable));
                }
            }
        }
    }

    @Override // androidx.cardview.widget.CardView
    public void setContentPadding(int i4, int i5, int i6, int i7) {
        d dVar = this.f3169h;
        dVar.f6859b.set(i4, i5, i6, i7);
        dVar.j();
    }

    public void setDragged(boolean z4) {
        if (this.f3172k != z4) {
            this.f3172k = z4;
            refreshDrawableState();
            d();
            invalidate();
        }
    }

    @Override // androidx.cardview.widget.CardView
    public void setMaxCardElevation(float f4) {
        super.setMaxCardElevation(f4);
        this.f3169h.k();
    }

    @Override // androidx.cardview.widget.CardView
    public void setPreventCornerOverlap(boolean z4) {
        super.setPreventCornerOverlap(z4);
        d dVar = this.f3169h;
        dVar.k();
        dVar.j();
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f4) {
        d dVar = this.f3169h;
        dVar.f6860c.p(f4);
        j jVar = dVar.f6861d;
        if (jVar != null) {
            jVar.p(f4);
        }
        j jVar2 = dVar.f6874q;
        if (jVar2 != null) {
            jVar2.p(f4);
        }
    }

    @Override // androidx.cardview.widget.CardView
    public void setRadius(float f4) {
        super.setRadius(f4);
        d dVar = this.f3169h;
        n g4 = dVar.f6870m.g();
        g4.c(f4);
        dVar.h(g4.a());
        dVar.f6866i.invalidateSelf();
        if (dVar.i() || (dVar.f6858a.getPreventCornerOverlap() && !dVar.f6860c.m())) {
            dVar.j();
        }
        if (dVar.i()) {
            dVar.k();
        }
    }

    public void setRippleColor(@Nullable ColorStateList colorStateList) {
        d dVar = this.f3169h;
        dVar.f6868k = colorStateList;
        int[] iArr = a.f5097a;
        RippleDrawable rippleDrawable = dVar.f6872o;
        if (rippleDrawable != null) {
            rippleDrawable.setColor(colorStateList);
        }
    }

    public void setRippleColorResource(@ColorRes int i4) {
        ColorStateList b5 = e.b(getContext(), i4);
        d dVar = this.f3169h;
        dVar.f6868k = b5;
        int[] iArr = a.f5097a;
        RippleDrawable rippleDrawable = dVar.f6872o;
        if (rippleDrawable != null) {
            rippleDrawable.setColor(b5);
        }
    }

    @Override // l2.a0
    public void setShapeAppearanceModel(@NonNull p pVar) {
        setClipToOutline(pVar.f(getBoundsAsRectF()));
        this.f3169h.h(pVar);
    }

    public void setStrokeColor(@ColorInt int i4) {
        setStrokeColor(ColorStateList.valueOf(i4));
    }

    public void setStrokeWidth(@Dimension int i4) {
        d dVar = this.f3169h;
        if (i4 != dVar.f6865h) {
            dVar.f6865h = i4;
            j jVar = dVar.f6861d;
            ColorStateList colorStateList = dVar.f6871n;
            jVar.u(i4);
            jVar.t(colorStateList);
        }
        invalidate();
    }

    @Override // androidx.cardview.widget.CardView
    public void setUseCompatPadding(boolean z4) {
        super.setUseCompatPadding(z4);
        d dVar = this.f3169h;
        dVar.k();
        dVar.j();
    }

    @Override // android.widget.Checkable
    public final void toggle() {
        d dVar = this.f3169h;
        if (dVar != null && dVar.f6876s && isEnabled()) {
            this.f3171j = !this.f3171j;
            refreshDrawableState();
            d();
            dVar.f(this.f3171j, true);
        }
    }

    public MaterialCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.materialCardViewStyle);
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        d dVar = this.f3169h;
        if (dVar.f6871n != colorStateList) {
            dVar.f6871n = colorStateList;
            j jVar = dVar.f6861d;
            jVar.u(dVar.f6865h);
            jVar.t(colorStateList);
        }
        invalidate();
    }

    public MaterialCardView(Context context, AttributeSet attributeSet, int i4) {
        super(p2.a.a(context, attributeSet, i4, 2131756030), attributeSet, i4);
        this.f3171j = false;
        this.f3172k = false;
        this.f3170i = true;
        TypedArray d4 = h0.d(getContext(), attributeSet, o1.a.C, i4, 2131756030, new int[0]);
        d dVar = new d(this, attributeSet, i4);
        this.f3169h = dVar;
        ColorStateList cardBackgroundColor = super.getCardBackgroundColor();
        j jVar = dVar.f6860c;
        jVar.o(cardBackgroundColor);
        dVar.f6859b.set(super.getContentPaddingLeft(), super.getContentPaddingTop(), super.getContentPaddingRight(), super.getContentPaddingBottom());
        dVar.j();
        MaterialCardView materialCardView = dVar.f6858a;
        ColorStateList a5 = i2.d.a(materialCardView.getContext(), d4, 11);
        dVar.f6871n = a5;
        if (a5 == null) {
            dVar.f6871n = ColorStateList.valueOf(-1);
        }
        dVar.f6865h = d4.getDimensionPixelSize(12, 0);
        boolean z4 = d4.getBoolean(0, false);
        dVar.f6876s = z4;
        materialCardView.setLongClickable(z4);
        dVar.f6869l = i2.d.a(materialCardView.getContext(), d4, 6);
        dVar.g(i2.d.d(materialCardView.getContext(), d4, 2));
        dVar.f6863f = d4.getDimensionPixelSize(5, 0);
        dVar.f6862e = d4.getDimensionPixelSize(4, 0);
        dVar.f6864g = d4.getInteger(3, 8388661);
        ColorStateList a6 = i2.d.a(materialCardView.getContext(), d4, 7);
        dVar.f6868k = a6;
        if (a6 == null) {
            dVar.f6868k = ColorStateList.valueOf(y1.a.b(R.attr.colorControlHighlight, materialCardView));
        }
        ColorStateList a7 = i2.d.a(materialCardView.getContext(), d4, 1);
        j jVar2 = dVar.f6861d;
        jVar2.o(a7 == null ? ColorStateList.valueOf(0) : a7);
        int[] iArr = a.f5097a;
        RippleDrawable rippleDrawable = dVar.f6872o;
        if (rippleDrawable != null) {
            rippleDrawable.setColor(dVar.f6868k);
        }
        jVar.n(materialCardView.getCardElevation());
        ColorStateList colorStateList = dVar.f6871n;
        jVar2.u(dVar.f6865h);
        jVar2.t(colorStateList);
        materialCardView.setBackgroundInternal(dVar.d(jVar));
        LayerDrawable c4 = materialCardView.isClickable() ? dVar.c() : jVar2;
        dVar.f6866i = c4;
        materialCardView.setForeground(dVar.d(c4));
        d4.recycle();
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardBackgroundColor(@Nullable ColorStateList colorStateList) {
        this.f3169h.f6860c.o(colorStateList);
    }

    public void setOnCheckedChangeListener(@Nullable u1.a aVar) {
    }
}