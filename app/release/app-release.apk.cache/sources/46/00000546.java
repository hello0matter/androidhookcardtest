package com.google.android.material.materialswitch;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.q3;
import b0.a;
import c0.b;
import com.example.msphone.R;
import com.google.android.material.internal.h0;
import com.google.android.material.internal.n0;
import com.google.common.collect.c;

/* loaded from: classes.dex */
public class MaterialSwitch extends SwitchCompat {

    /* renamed from: j0  reason: collision with root package name */
    public static final int[] f3605j0 = {R.attr.state_with_icon};
    public Drawable T;
    public Drawable U;
    public int V;
    public Drawable W;

    /* renamed from: a0  reason: collision with root package name */
    public Drawable f3606a0;

    /* renamed from: b0  reason: collision with root package name */
    public ColorStateList f3607b0;

    /* renamed from: c0  reason: collision with root package name */
    public ColorStateList f3608c0;

    /* renamed from: d0  reason: collision with root package name */
    public PorterDuff.Mode f3609d0;

    /* renamed from: e0  reason: collision with root package name */
    public ColorStateList f3610e0;

    /* renamed from: f0  reason: collision with root package name */
    public ColorStateList f3611f0;

    /* renamed from: g0  reason: collision with root package name */
    public PorterDuff.Mode f3612g0;

    /* renamed from: h0  reason: collision with root package name */
    public int[] f3613h0;

    /* renamed from: i0  reason: collision with root package name */
    public int[] f3614i0;

    public MaterialSwitch(@NonNull Context context) {
        this(context, null);
    }

    public static void g(Drawable drawable, ColorStateList colorStateList, int[] iArr, int[] iArr2, float f4) {
        if (drawable != null && colorStateList != null) {
            b.g(drawable, a.b(colorStateList.getColorForState(iArr, 0), f4, colorStateList.getColorForState(iArr2, 0)));
        }
    }

    public final void e() {
        this.T = a2.b.b(this.T, this.f3607b0, getThumbTintMode());
        this.U = a2.b.b(this.U, this.f3608c0, this.f3609d0);
        h();
        Drawable drawable = this.T;
        Drawable drawable2 = this.U;
        int i4 = this.V;
        super.setThumbDrawable(a2.b.a(drawable, drawable2, i4, i4));
        refreshDrawableState();
    }

    public final void f() {
        this.W = a2.b.b(this.W, this.f3610e0, getTrackTintMode());
        this.f3606a0 = a2.b.b(this.f3606a0, this.f3611f0, this.f3612g0);
        h();
        Drawable drawable = this.W;
        if (drawable != null && this.f3606a0 != null) {
            drawable = new LayerDrawable(new Drawable[]{this.W, this.f3606a0});
        } else if (drawable == null) {
            drawable = this.f3606a0;
        }
        if (drawable != null) {
            setSwitchMinWidth(drawable.getIntrinsicWidth());
        }
        super.setTrackDrawable(drawable);
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    @Nullable
    public Drawable getThumbDrawable() {
        return this.T;
    }

    @Nullable
    public Drawable getThumbIconDrawable() {
        return this.U;
    }

    @Px
    public int getThumbIconSize() {
        return this.V;
    }

    @Nullable
    public ColorStateList getThumbIconTintList() {
        return this.f3608c0;
    }

    @NonNull
    public PorterDuff.Mode getThumbIconTintMode() {
        return this.f3609d0;
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    @Nullable
    public ColorStateList getThumbTintList() {
        return this.f3607b0;
    }

    @Nullable
    public Drawable getTrackDecorationDrawable() {
        return this.f3606a0;
    }

    @Nullable
    public ColorStateList getTrackDecorationTintList() {
        return this.f3611f0;
    }

    @NonNull
    public PorterDuff.Mode getTrackDecorationTintMode() {
        return this.f3612g0;
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    @Nullable
    public Drawable getTrackDrawable() {
        return this.W;
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    @Nullable
    public ColorStateList getTrackTintList() {
        return this.f3610e0;
    }

    public final void h() {
        if (this.f3607b0 == null && this.f3608c0 == null && this.f3610e0 == null && this.f3611f0 == null) {
            return;
        }
        float thumbPosition = getThumbPosition();
        ColorStateList colorStateList = this.f3607b0;
        if (colorStateList != null) {
            g(this.T, colorStateList, this.f3613h0, this.f3614i0, thumbPosition);
        }
        ColorStateList colorStateList2 = this.f3608c0;
        if (colorStateList2 != null) {
            g(this.U, colorStateList2, this.f3613h0, this.f3614i0, thumbPosition);
        }
        ColorStateList colorStateList3 = this.f3610e0;
        if (colorStateList3 != null) {
            g(this.W, colorStateList3, this.f3613h0, this.f3614i0, thumbPosition);
        }
        ColorStateList colorStateList4 = this.f3611f0;
        if (colorStateList4 != null) {
            g(this.f3606a0, colorStateList4, this.f3613h0, this.f3614i0, thumbPosition);
        }
    }

    @Override // android.view.View
    public final void invalidate() {
        h();
        super.invalidate();
    }

    @Override // androidx.appcompat.widget.SwitchCompat, android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final int[] onCreateDrawableState(int i4) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i4 + 1);
        if (this.U != null) {
            View.mergeDrawableStates(onCreateDrawableState, f3605j0);
        }
        int[] iArr = new int[onCreateDrawableState.length];
        int i5 = 0;
        for (int i6 : onCreateDrawableState) {
            if (i6 != 16842912) {
                iArr[i5] = i6;
                i5++;
            }
        }
        this.f3613h0 = iArr;
        this.f3614i0 = a2.b.c(onCreateDrawableState);
        return onCreateDrawableState;
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    public void setThumbDrawable(@Nullable Drawable drawable) {
        this.T = drawable;
        e();
    }

    public void setThumbIconDrawable(@Nullable Drawable drawable) {
        this.U = drawable;
        e();
    }

    public void setThumbIconResource(@DrawableRes int i4) {
        setThumbIconDrawable(c.t0(getContext(), i4));
    }

    public void setThumbIconSize(@Px int i4) {
        if (this.V != i4) {
            this.V = i4;
            e();
        }
    }

    public void setThumbIconTintList(@Nullable ColorStateList colorStateList) {
        this.f3608c0 = colorStateList;
        e();
    }

    public void setThumbIconTintMode(@NonNull PorterDuff.Mode mode) {
        this.f3609d0 = mode;
        e();
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    public void setThumbTintList(@Nullable ColorStateList colorStateList) {
        this.f3607b0 = colorStateList;
        e();
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    public void setThumbTintMode(@Nullable PorterDuff.Mode mode) {
        super.setThumbTintMode(mode);
        e();
    }

    public void setTrackDecorationDrawable(@Nullable Drawable drawable) {
        this.f3606a0 = drawable;
        f();
    }

    public void setTrackDecorationResource(@DrawableRes int i4) {
        setTrackDecorationDrawable(c.t0(getContext(), i4));
    }

    public void setTrackDecorationTintList(@Nullable ColorStateList colorStateList) {
        this.f3611f0 = colorStateList;
        f();
    }

    public void setTrackDecorationTintMode(@NonNull PorterDuff.Mode mode) {
        this.f3612g0 = mode;
        f();
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    public void setTrackDrawable(@Nullable Drawable drawable) {
        this.W = drawable;
        f();
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    public void setTrackTintList(@Nullable ColorStateList colorStateList) {
        this.f3610e0 = colorStateList;
        f();
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    public void setTrackTintMode(@Nullable PorterDuff.Mode mode) {
        super.setTrackTintMode(mode);
        f();
    }

    public MaterialSwitch(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.materialSwitchStyle);
    }

    public MaterialSwitch(@NonNull Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(p2.a.a(context, attributeSet, i4, 2131755893), attributeSet, i4);
        this.V = -1;
        Context context2 = getContext();
        this.T = super.getThumbDrawable();
        this.f3607b0 = super.getThumbTintList();
        super.setThumbTintList(null);
        this.W = super.getTrackDrawable();
        this.f3610e0 = super.getTrackTintList();
        super.setTrackTintList(null);
        q3 e4 = h0.e(context2, attributeSet, o1.a.H, i4, 2131755893, new int[0]);
        this.U = e4.b(0);
        TypedArray typedArray = e4.f879b;
        this.V = typedArray.getDimensionPixelSize(1, -1);
        this.f3608c0 = e4.a(2);
        int i5 = typedArray.getInt(3, -1);
        PorterDuff.Mode mode = PorterDuff.Mode.SRC_IN;
        this.f3609d0 = n0.g(i5, mode);
        this.f3606a0 = e4.b(4);
        this.f3611f0 = e4.a(5);
        this.f3612g0 = n0.g(typedArray.getInt(6, -1), mode);
        e4.g();
        setEnforceSwitchWidth(false);
        e();
        f();
    }
}