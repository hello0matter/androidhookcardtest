package com.google.android.material.button;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.CompoundButton;
import androidx.activity.j;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.app.o0;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.widget.q;
import androidx.customview.view.AbsSavedState;
import com.example.msphone.R;
import com.google.android.material.internal.n0;
import i0.h0;
import i0.y0;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.WeakHashMap;
import l2.a0;
import l2.n;
import l2.p;
import z.e;

/* loaded from: classes.dex */
public class MaterialButton extends AppCompatButton implements Checkable, a0 {

    /* renamed from: r  reason: collision with root package name */
    public static final int[] f3113r = {16842911};

    /* renamed from: s  reason: collision with root package name */
    public static final int[] f3114s = {16842912};

    /* renamed from: d  reason: collision with root package name */
    public final c f3115d;

    /* renamed from: e  reason: collision with root package name */
    public final LinkedHashSet f3116e;

    /* renamed from: f  reason: collision with root package name */
    public a f3117f;

    /* renamed from: g  reason: collision with root package name */
    public PorterDuff.Mode f3118g;

    /* renamed from: h  reason: collision with root package name */
    public ColorStateList f3119h;

    /* renamed from: i  reason: collision with root package name */
    public Drawable f3120i;

    /* renamed from: j  reason: collision with root package name */
    public String f3121j;

    /* renamed from: k  reason: collision with root package name */
    public int f3122k;

    /* renamed from: l  reason: collision with root package name */
    public int f3123l;

    /* renamed from: m  reason: collision with root package name */
    public int f3124m;

    /* renamed from: n  reason: collision with root package name */
    public int f3125n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f3126o;

    /* renamed from: p  reason: collision with root package name */
    public boolean f3127p;

    /* renamed from: q  reason: collision with root package name */
    public int f3128q;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface IconGravity {
    }

    /* loaded from: classes.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Object();

        /* renamed from: c  reason: collision with root package name */
        public boolean f3129c;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            if (classLoader == null) {
                getClass().getClassLoader();
            }
            this.f3129c = parcel.readInt() == 1;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i4) {
            super.writeToParcel(parcel, i4);
            parcel.writeInt(this.f3129c ? 1 : 0);
        }
    }

    public MaterialButton(@NonNull Context context) {
        this(context, null);
    }

    private Layout.Alignment getActualTextAlignment() {
        int textAlignment = getTextAlignment();
        return textAlignment != 1 ? (textAlignment == 6 || textAlignment == 3) ? Layout.Alignment.ALIGN_OPPOSITE : textAlignment != 4 ? Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_CENTER : getGravityTextAlignment();
    }

    private Layout.Alignment getGravityTextAlignment() {
        int gravity = getGravity() & 8388615;
        return gravity != 1 ? (gravity == 5 || gravity == 8388613) ? Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_CENTER;
    }

    private int getTextHeight() {
        if (getLineCount() > 1) {
            return getLayout().getHeight();
        }
        TextPaint paint = getPaint();
        String charSequence = getText().toString();
        if (getTransformationMethod() != null) {
            charSequence = getTransformationMethod().getTransformation(charSequence, this).toString();
        }
        Rect rect = new Rect();
        paint.getTextBounds(charSequence, 0, charSequence.length(), rect);
        return Math.min(rect.height(), getLayout().getHeight());
    }

    private int getTextLayoutWidth() {
        int lineCount = getLineCount();
        float f4 = 0.0f;
        for (int i4 = 0; i4 < lineCount; i4++) {
            f4 = Math.max(f4, getLayout().getLineWidth(i4));
        }
        return (int) Math.ceil(f4);
    }

    public final boolean a() {
        c cVar = this.f3115d;
        if (cVar != null && cVar.f3157q) {
            return true;
        }
        return false;
    }

    public final boolean b() {
        c cVar = this.f3115d;
        if (cVar != null && !cVar.f3155o) {
            return true;
        }
        return false;
    }

    public final void c() {
        int i4 = this.f3128q;
        boolean z4 = true;
        if (i4 != 1 && i4 != 2) {
            z4 = false;
        }
        if (z4) {
            q.e(this, this.f3120i, null, null, null);
        } else if (i4 != 3 && i4 != 4) {
            if (i4 == 16 || i4 == 32) {
                q.e(this, null, this.f3120i, null, null);
            }
        } else {
            q.e(this, null, null, this.f3120i, null);
        }
    }

    public final void d(boolean z4) {
        Drawable drawable = this.f3120i;
        if (drawable != null) {
            Drawable mutate = drawable.mutate();
            this.f3120i = mutate;
            c0.b.h(mutate, this.f3119h);
            PorterDuff.Mode mode = this.f3118g;
            if (mode != null) {
                c0.b.i(this.f3120i, mode);
            }
            int i4 = this.f3122k;
            if (i4 == 0) {
                i4 = this.f3120i.getIntrinsicWidth();
            }
            int i5 = this.f3122k;
            if (i5 == 0) {
                i5 = this.f3120i.getIntrinsicHeight();
            }
            Drawable drawable2 = this.f3120i;
            int i6 = this.f3123l;
            int i7 = this.f3124m;
            drawable2.setBounds(i6, i7, i4 + i6, i5 + i7);
            this.f3120i.setVisible(true, z4);
        }
        if (z4) {
            c();
            return;
        }
        Drawable[] a5 = q.a(this);
        Drawable drawable3 = a5[0];
        Drawable drawable4 = a5[1];
        Drawable drawable5 = a5[2];
        int i8 = this.f3128q;
        if (((i8 == 1 || i8 == 2) && drawable3 != this.f3120i) || (((i8 == 3 || i8 == 4) && drawable5 != this.f3120i) || ((i8 == 16 || i8 == 32) && drawable4 != this.f3120i))) {
            c();
        }
    }

    public final void e(int i4, int i5) {
        boolean z4;
        boolean z5;
        if (this.f3120i != null && getLayout() != null) {
            int i6 = this.f3128q;
            boolean z6 = true;
            if (i6 != 1 && i6 != 2) {
                z4 = false;
            } else {
                z4 = true;
            }
            if (!z4 && i6 != 3 && i6 != 4) {
                if (i6 == 16 || i6 == 32) {
                    this.f3123l = 0;
                    if (i6 == 16) {
                        this.f3124m = 0;
                        d(false);
                    }
                    int i7 = this.f3122k;
                    if (i7 == 0) {
                        i7 = this.f3120i.getIntrinsicHeight();
                    }
                    int max = Math.max(0, (((((i5 - getTextHeight()) - getPaddingTop()) - i7) - this.f3125n) - getPaddingBottom()) / 2);
                    if (this.f3124m != max) {
                        this.f3124m = max;
                        d(false);
                        return;
                    }
                    return;
                }
                return;
            }
            this.f3124m = 0;
            Layout.Alignment actualTextAlignment = getActualTextAlignment();
            int i8 = this.f3128q;
            if (i8 != 1 && i8 != 3 && ((i8 != 2 || actualTextAlignment != Layout.Alignment.ALIGN_NORMAL) && (i8 != 4 || actualTextAlignment != Layout.Alignment.ALIGN_OPPOSITE))) {
                int i9 = this.f3122k;
                if (i9 == 0) {
                    i9 = this.f3120i.getIntrinsicWidth();
                }
                int textLayoutWidth = i4 - getTextLayoutWidth();
                WeakHashMap weakHashMap = y0.f4999a;
                int e4 = (((textLayoutWidth - h0.e(this)) - i9) - this.f3125n) - h0.f(this);
                if (actualTextAlignment == Layout.Alignment.ALIGN_CENTER) {
                    e4 /= 2;
                }
                if (h0.d(this) == 1) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (this.f3128q != 4) {
                    z6 = false;
                }
                if (z5 != z6) {
                    e4 = -e4;
                }
                if (this.f3123l != e4) {
                    this.f3123l = e4;
                    d(false);
                    return;
                }
                return;
            }
            this.f3123l = 0;
            d(false);
        }
    }

    @NonNull
    public String getA11yClassName() {
        if (TextUtils.isEmpty(this.f3121j)) {
            return (a() ? CompoundButton.class : Button.class).getName();
        }
        return this.f3121j;
    }

    @Override // android.view.View
    @Nullable
    public ColorStateList getBackgroundTintList() {
        return getSupportBackgroundTintList();
    }

    @Override // android.view.View
    @Nullable
    public PorterDuff.Mode getBackgroundTintMode() {
        return getSupportBackgroundTintMode();
    }

    @Px
    public int getCornerRadius() {
        if (b()) {
            return this.f3115d.f3147g;
        }
        return 0;
    }

    public Drawable getIcon() {
        return this.f3120i;
    }

    public int getIconGravity() {
        return this.f3128q;
    }

    @Px
    public int getIconPadding() {
        return this.f3125n;
    }

    @Px
    public int getIconSize() {
        return this.f3122k;
    }

    public ColorStateList getIconTint() {
        return this.f3119h;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.f3118g;
    }

    @Dimension
    public int getInsetBottom() {
        return this.f3115d.f3146f;
    }

    @Dimension
    public int getInsetTop() {
        return this.f3115d.f3145e;
    }

    @Nullable
    public ColorStateList getRippleColor() {
        if (b()) {
            return this.f3115d.f3152l;
        }
        return null;
    }

    @NonNull
    public p getShapeAppearanceModel() {
        if (b()) {
            return this.f3115d.f3142b;
        }
        throw new IllegalStateException("Attempted to get ShapeAppearanceModel from a MaterialButton which has an overwritten background.");
    }

    public ColorStateList getStrokeColor() {
        if (b()) {
            return this.f3115d.f3151k;
        }
        return null;
    }

    @Px
    public int getStrokeWidth() {
        if (b()) {
            return this.f3115d.f3148h;
        }
        return 0;
    }

    @Override // androidx.appcompat.widget.AppCompatButton
    @Nullable
    @RestrictTo({RestrictTo.Scope.f170b})
    public ColorStateList getSupportBackgroundTintList() {
        if (b()) {
            return this.f3115d.f3150j;
        }
        return super.getSupportBackgroundTintList();
    }

    @Override // androidx.appcompat.widget.AppCompatButton
    @Nullable
    @RestrictTo({RestrictTo.Scope.f170b})
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (b()) {
            return this.f3115d.f3149i;
        }
        return super.getSupportBackgroundTintMode();
    }

    @Override // android.widget.Checkable
    public final boolean isChecked() {
        return this.f3126o;
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (b()) {
            com.google.common.collect.c.R1(this, this.f3115d.b(false));
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final int[] onCreateDrawableState(int i4) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i4 + 2);
        if (a()) {
            View.mergeDrawableStates(onCreateDrawableState, f3113r);
        }
        if (this.f3126o) {
            View.mergeDrawableStates(onCreateDrawableState, f3114s);
        }
        return onCreateDrawableState;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(getA11yClassName());
        accessibilityEvent.setChecked(this.f3126o);
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getA11yClassName());
        accessibilityNodeInfo.setCheckable(a());
        accessibilityNodeInfo.setChecked(this.f3126o);
        accessibilityNodeInfo.setClickable(isClickable());
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView, android.view.View
    public final void onLayout(boolean z4, int i4, int i5, int i6, int i7) {
        super.onLayout(z4, i4, i5, i6, i7);
        e(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.widget.TextView, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.f1460a);
        setChecked(savedState.f3129c);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [android.os.Parcelable, androidx.customview.view.AbsSavedState, com.google.android.material.button.MaterialButton$SavedState] */
    @Override // android.widget.TextView, android.view.View
    public final Parcelable onSaveInstanceState() {
        ?? absSavedState = new AbsSavedState(super.onSaveInstanceState());
        absSavedState.f3129c = this.f3126o;
        return absSavedState;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView
    public final void onTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
        super.onTextChanged(charSequence, i4, i5, i6);
        e(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.view.View
    public final boolean performClick() {
        if (this.f3115d.f3158r) {
            toggle();
        }
        return super.performClick();
    }

    @Override // android.view.View
    public final void refreshDrawableState() {
        super.refreshDrawableState();
        if (this.f3120i != null) {
            if (this.f3120i.setState(getDrawableState())) {
                invalidate();
            }
        }
    }

    public void setA11yClassName(@Nullable String str) {
        this.f3121j = str;
    }

    @Override // android.view.View
    public void setBackground(@NonNull Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundColor(@ColorInt int i4) {
        if (b()) {
            c cVar = this.f3115d;
            if (cVar.b(false) != null) {
                cVar.b(false).setTint(i4);
                return;
            }
            return;
        }
        super.setBackgroundColor(i4);
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void setBackgroundDrawable(@NonNull Drawable drawable) {
        if (b()) {
            if (drawable != getBackground()) {
                Log.w("MaterialButton", "MaterialButton manages its own background to control elevation, shape, color and states. Consider using backgroundTint, shapeAppearance and other attributes where available. A custom background will ignore these attributes and you should consider handling interaction states such as pressed, focused and disabled");
                c cVar = this.f3115d;
                cVar.f3155o = true;
                ColorStateList colorStateList = cVar.f3150j;
                MaterialButton materialButton = cVar.f3141a;
                materialButton.setSupportBackgroundTintList(colorStateList);
                materialButton.setSupportBackgroundTintMode(cVar.f3149i);
            } else {
                getBackground().setState(drawable.getState());
                return;
            }
        }
        super.setBackgroundDrawable(drawable);
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void setBackgroundResource(@DrawableRes int i4) {
        setBackgroundDrawable(i4 != 0 ? com.google.common.collect.c.t0(getContext(), i4) : null);
    }

    @Override // android.view.View
    public void setBackgroundTintList(@Nullable ColorStateList colorStateList) {
        setSupportBackgroundTintList(colorStateList);
    }

    @Override // android.view.View
    public void setBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        setSupportBackgroundTintMode(mode);
    }

    public void setCheckable(boolean z4) {
        if (b()) {
            this.f3115d.f3157q = z4;
        }
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z4) {
        if (a() && isEnabled() && this.f3126o != z4) {
            this.f3126o = z4;
            refreshDrawableState();
            if (getParent() instanceof MaterialButtonToggleGroup) {
                MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) getParent();
                boolean z5 = this.f3126o;
                if (!materialButtonToggleGroup.f3136f) {
                    materialButtonToggleGroup.b(getId(), z5);
                }
            }
            if (this.f3127p) {
                return;
            }
            this.f3127p = true;
            Iterator it = this.f3116e.iterator();
            if (!it.hasNext()) {
                this.f3127p = false;
            } else {
                j.f(it.next());
                throw null;
            }
        }
    }

    public void setCornerRadius(@Px int i4) {
        if (b()) {
            c cVar = this.f3115d;
            if (!cVar.f3156p || cVar.f3147g != i4) {
                cVar.f3147g = i4;
                cVar.f3156p = true;
                n g4 = cVar.f3142b.g();
                g4.c(i4);
                cVar.c(g4.a());
            }
        }
    }

    public void setCornerRadiusResource(@DimenRes int i4) {
        if (b()) {
            setCornerRadius(getResources().getDimensionPixelSize(i4));
        }
    }

    @Override // android.view.View
    @RequiresApi(21)
    public void setElevation(float f4) {
        super.setElevation(f4);
        if (b()) {
            this.f3115d.b(false).n(f4);
        }
    }

    public void setIcon(@Nullable Drawable drawable) {
        if (this.f3120i != drawable) {
            this.f3120i = drawable;
            d(true);
            e(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconGravity(int i4) {
        if (this.f3128q != i4) {
            this.f3128q = i4;
            e(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconPadding(@Px int i4) {
        if (this.f3125n != i4) {
            this.f3125n = i4;
            setCompoundDrawablePadding(i4);
        }
    }

    public void setIconResource(@DrawableRes int i4) {
        setIcon(i4 != 0 ? com.google.common.collect.c.t0(getContext(), i4) : null);
    }

    public void setIconSize(@Px int i4) {
        if (i4 < 0) {
            throw new IllegalArgumentException("iconSize cannot be less than 0");
        }
        if (this.f3122k != i4) {
            this.f3122k = i4;
            d(true);
        }
    }

    public void setIconTint(@Nullable ColorStateList colorStateList) {
        if (this.f3119h != colorStateList) {
            this.f3119h = colorStateList;
            d(false);
        }
    }

    public void setIconTintMode(PorterDuff.Mode mode) {
        if (this.f3118g != mode) {
            this.f3118g = mode;
            d(false);
        }
    }

    public void setIconTintResource(@ColorRes int i4) {
        setIconTint(e.b(getContext(), i4));
    }

    public void setInsetBottom(@Dimension int i4) {
        c cVar = this.f3115d;
        cVar.d(cVar.f3145e, i4);
    }

    public void setInsetTop(@Dimension int i4) {
        c cVar = this.f3115d;
        cVar.d(i4, cVar.f3146f);
    }

    public void setInternalBackground(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    public void setOnPressedChangeListenerInternal(@Nullable a aVar) {
        this.f3117f = aVar;
    }

    @Override // android.view.View
    public void setPressed(boolean z4) {
        a aVar = this.f3117f;
        if (aVar != null) {
            ((MaterialButtonToggleGroup) ((o0) aVar).f311b).invalidate();
        }
        super.setPressed(z4);
    }

    public void setRippleColor(@Nullable ColorStateList colorStateList) {
        if (b()) {
            c cVar = this.f3115d;
            if (cVar.f3152l != colorStateList) {
                cVar.f3152l = colorStateList;
                MaterialButton materialButton = cVar.f3141a;
                if (materialButton.getBackground() instanceof RippleDrawable) {
                    ((RippleDrawable) materialButton.getBackground()).setColor(j2.a.c(colorStateList));
                }
            }
        }
    }

    public void setRippleColorResource(@ColorRes int i4) {
        if (b()) {
            setRippleColor(e.b(getContext(), i4));
        }
    }

    @Override // l2.a0
    public void setShapeAppearanceModel(@NonNull p pVar) {
        if (b()) {
            this.f3115d.c(pVar);
            return;
        }
        throw new IllegalStateException("Attempted to set ShapeAppearanceModel on a MaterialButton which has an overwritten background.");
    }

    public void setShouldDrawSurfaceColorStroke(boolean z4) {
        if (b()) {
            c cVar = this.f3115d;
            cVar.f3154n = z4;
            cVar.f();
        }
    }

    public void setStrokeColor(@Nullable ColorStateList colorStateList) {
        if (b()) {
            c cVar = this.f3115d;
            if (cVar.f3151k != colorStateList) {
                cVar.f3151k = colorStateList;
                cVar.f();
            }
        }
    }

    public void setStrokeColorResource(@ColorRes int i4) {
        if (b()) {
            setStrokeColor(e.b(getContext(), i4));
        }
    }

    public void setStrokeWidth(@Px int i4) {
        if (b()) {
            c cVar = this.f3115d;
            if (cVar.f3148h != i4) {
                cVar.f3148h = i4;
                cVar.f();
            }
        }
    }

    public void setStrokeWidthResource(@DimenRes int i4) {
        if (b()) {
            setStrokeWidth(getResources().getDimensionPixelSize(i4));
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton
    @RestrictTo({RestrictTo.Scope.f170b})
    public void setSupportBackgroundTintList(@Nullable ColorStateList colorStateList) {
        if (b()) {
            c cVar = this.f3115d;
            if (cVar.f3150j != colorStateList) {
                cVar.f3150j = colorStateList;
                if (cVar.b(false) != null) {
                    c0.b.h(cVar.b(false), cVar.f3150j);
                    return;
                }
                return;
            }
            return;
        }
        super.setSupportBackgroundTintList(colorStateList);
    }

    @Override // androidx.appcompat.widget.AppCompatButton
    @RestrictTo({RestrictTo.Scope.f170b})
    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        if (b()) {
            c cVar = this.f3115d;
            if (cVar.f3149i != mode) {
                cVar.f3149i = mode;
                if (cVar.b(false) != null && cVar.f3149i != null) {
                    c0.b.i(cVar.b(false), cVar.f3149i);
                    return;
                }
                return;
            }
            return;
        }
        super.setSupportBackgroundTintMode(mode);
    }

    @Override // android.view.View
    @RequiresApi(17)
    public void setTextAlignment(int i4) {
        super.setTextAlignment(i4);
        e(getMeasuredWidth(), getMeasuredHeight());
    }

    public void setToggleCheckedStateOnClick(boolean z4) {
        this.f3115d.f3158r = z4;
    }

    @Override // android.widget.Checkable
    public final void toggle() {
        setChecked(!this.f3126o);
    }

    public MaterialButton(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.materialButtonStyle);
    }

    public MaterialButton(@NonNull Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(p2.a.a(context, attributeSet, i4, 2131756018), attributeSet, i4);
        this.f3116e = new LinkedHashSet();
        this.f3126o = false;
        this.f3127p = false;
        Context context2 = getContext();
        TypedArray d4 = com.google.android.material.internal.h0.d(context2, attributeSet, o1.a.f5968y, i4, 2131756018, new int[0]);
        this.f3125n = d4.getDimensionPixelSize(12, 0);
        int i5 = d4.getInt(15, -1);
        PorterDuff.Mode mode = PorterDuff.Mode.SRC_IN;
        this.f3118g = n0.g(i5, mode);
        this.f3119h = i2.d.a(getContext(), d4, 14);
        this.f3120i = i2.d.d(getContext(), d4, 10);
        this.f3128q = d4.getInteger(11, 1);
        this.f3122k = d4.getDimensionPixelSize(13, 0);
        c cVar = new c(this, p.c(context2, attributeSet, i4, 2131756018).a());
        this.f3115d = cVar;
        cVar.f3143c = d4.getDimensionPixelOffset(1, 0);
        cVar.f3144d = d4.getDimensionPixelOffset(2, 0);
        cVar.f3145e = d4.getDimensionPixelOffset(3, 0);
        cVar.f3146f = d4.getDimensionPixelOffset(4, 0);
        if (d4.hasValue(8)) {
            int dimensionPixelSize = d4.getDimensionPixelSize(8, -1);
            cVar.f3147g = dimensionPixelSize;
            n g4 = cVar.f3142b.g();
            g4.c(dimensionPixelSize);
            cVar.c(g4.a());
            cVar.f3156p = true;
        }
        cVar.f3148h = d4.getDimensionPixelSize(20, 0);
        cVar.f3149i = n0.g(d4.getInt(7, -1), mode);
        cVar.f3150j = i2.d.a(getContext(), d4, 6);
        cVar.f3151k = i2.d.a(getContext(), d4, 19);
        cVar.f3152l = i2.d.a(getContext(), d4, 16);
        cVar.f3157q = d4.getBoolean(5, false);
        cVar.f3160t = d4.getDimensionPixelSize(9, 0);
        cVar.f3158r = d4.getBoolean(21, true);
        WeakHashMap weakHashMap = y0.f4999a;
        int f4 = h0.f(this);
        int paddingTop = getPaddingTop();
        int e4 = h0.e(this);
        int paddingBottom = getPaddingBottom();
        if (d4.hasValue(0)) {
            cVar.f3155o = true;
            setSupportBackgroundTintList(cVar.f3150j);
            setSupportBackgroundTintMode(cVar.f3149i);
        } else {
            cVar.e();
        }
        h0.k(this, f4 + cVar.f3143c, paddingTop + cVar.f3145e, e4 + cVar.f3144d, paddingBottom + cVar.f3146f);
        d4.recycle();
        setCompoundDrawablePadding(this.f3125n);
        d(this.f3120i != null);
    }
}