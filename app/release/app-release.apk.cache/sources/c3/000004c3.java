package com.google.android.material.checkbox;

import a0.k;
import a0.s;
import a2.b;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.AnimatedStateListDrawable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.autofill.AutofillManager;
import android.widget.CompoundButton;
import androidx.activity.j;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.e;
import androidx.appcompat.widget.q3;
import com.example.msphone.R;
import com.google.android.material.internal.h0;
import com.google.android.material.internal.n0;
import d1.d;
import d1.f;
import h2.c;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* loaded from: classes.dex */
public class MaterialCheckBox extends AppCompatCheckBox {

    /* renamed from: e  reason: collision with root package name */
    public final LinkedHashSet f3191e;

    /* renamed from: f  reason: collision with root package name */
    public final LinkedHashSet f3192f;

    /* renamed from: g  reason: collision with root package name */
    public ColorStateList f3193g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f3194h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f3195i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f3196j;

    /* renamed from: k  reason: collision with root package name */
    public CharSequence f3197k;

    /* renamed from: l  reason: collision with root package name */
    public Drawable f3198l;

    /* renamed from: m  reason: collision with root package name */
    public Drawable f3199m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f3200n;

    /* renamed from: o  reason: collision with root package name */
    public ColorStateList f3201o;

    /* renamed from: p  reason: collision with root package name */
    public ColorStateList f3202p;

    /* renamed from: q  reason: collision with root package name */
    public PorterDuff.Mode f3203q;

    /* renamed from: r  reason: collision with root package name */
    public int f3204r;

    /* renamed from: s  reason: collision with root package name */
    public int[] f3205s;

    /* renamed from: t  reason: collision with root package name */
    public boolean f3206t;

    /* renamed from: u  reason: collision with root package name */
    public CharSequence f3207u;

    /* renamed from: v  reason: collision with root package name */
    public CompoundButton.OnCheckedChangeListener f3208v;

    /* renamed from: w  reason: collision with root package name */
    public final f f3209w;

    /* renamed from: x  reason: collision with root package name */
    public final c f3210x;

    /* renamed from: y  reason: collision with root package name */
    public static final int[] f3189y = {R.attr.state_indeterminate};

    /* renamed from: z  reason: collision with root package name */
    public static final int[] f3190z = {R.attr.state_error};
    public static final int[][] A = {new int[]{16842910, R.attr.state_error}, new int[]{16842910, 16842912}, new int[]{16842910, -16842912}, new int[]{-16842910, 16842912}, new int[]{-16842910, -16842912}};
    public static final int B = Resources.getSystem().getIdentifier("btn_check_material_anim", "drawable", "android");

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.f170b})
    /* loaded from: classes.dex */
    public @interface CheckedState {
    }

    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        @NonNull
        public static final Parcelable.Creator<SavedState> CREATOR = new Object();

        /* renamed from: a  reason: collision with root package name */
        public int f3211a;

        public final String toString() {
            String str;
            StringBuilder sb = new StringBuilder("MaterialCheckBox.SavedState{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" CheckedState=");
            int i4 = this.f3211a;
            if (i4 != 1) {
                if (i4 != 2) {
                    str = "unchecked";
                } else {
                    str = "indeterminate";
                }
            } else {
                str = "checked";
            }
            return j.e(sb, str, "}");
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i4) {
            super.writeToParcel(parcel, i4);
            parcel.writeValue(Integer.valueOf(this.f3211a));
        }
    }

    public MaterialCheckBox(Context context) {
        this(context, null);
    }

    @NonNull
    private String getButtonStateDescription() {
        Resources resources;
        int i4;
        int i5 = this.f3204r;
        if (i5 == 1) {
            resources = getResources();
            i4 = R.string.mtrl_checkbox_state_description_checked;
        } else if (i5 == 0) {
            resources = getResources();
            i4 = R.string.mtrl_checkbox_state_description_unchecked;
        } else {
            resources = getResources();
            i4 = R.string.mtrl_checkbox_state_description_indeterminate;
        }
        return resources.getString(i4);
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.f3193g == null) {
            int b5 = y1.a.b(R.attr.colorControlActivated, this);
            int b6 = y1.a.b(R.attr.colorError, this);
            int b7 = y1.a.b(R.attr.colorSurface, this);
            int b8 = y1.a.b(R.attr.colorOnSurface, this);
            this.f3193g = new ColorStateList(A, new int[]{y1.a.e(b7, 1.0f, b6), y1.a.e(b7, 1.0f, b5), y1.a.e(b7, 0.54f, b8), y1.a.e(b7, 0.38f, b8), y1.a.e(b7, 0.38f, b8)});
        }
        return this.f3193g;
    }

    @Nullable
    private ColorStateList getSuperButtonTintList() {
        ColorStateList colorStateList = this.f3201o;
        return colorStateList != null ? colorStateList : super.getButtonTintList() != null ? super.getButtonTintList() : getSupportButtonTintList();
    }

    public final void a() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        e eVar;
        this.f3198l = b.b(this.f3198l, this.f3201o, androidx.core.widget.b.b(this));
        this.f3199m = b.b(this.f3199m, this.f3202p, this.f3203q);
        if (this.f3200n) {
            f fVar = this.f3209w;
            if (fVar != null) {
                Drawable drawable = fVar.f4268a;
                c cVar = this.f3210x;
                if (drawable != null) {
                    AnimatedVectorDrawable animatedVectorDrawable = (AnimatedVectorDrawable) drawable;
                    if (cVar.f4256a == null) {
                        cVar.f4256a = new d1.b(cVar);
                    }
                    animatedVectorDrawable.unregisterAnimationCallback(cVar.f4256a);
                }
                ArrayList arrayList = fVar.f4266e;
                d dVar = fVar.f4263b;
                if (arrayList != null && cVar != null) {
                    arrayList.remove(cVar);
                    if (fVar.f4266e.size() == 0 && (eVar = fVar.f4265d) != null) {
                        dVar.f4258b.removeListener(eVar);
                        fVar.f4265d = null;
                    }
                }
                Drawable drawable2 = fVar.f4268a;
                if (drawable2 != null) {
                    AnimatedVectorDrawable animatedVectorDrawable2 = (AnimatedVectorDrawable) drawable2;
                    if (cVar.f4256a == null) {
                        cVar.f4256a = new d1.b(cVar);
                    }
                    animatedVectorDrawable2.registerAnimationCallback(cVar.f4256a);
                } else if (cVar != null) {
                    if (fVar.f4266e == null) {
                        fVar.f4266e = new ArrayList();
                    }
                    if (!fVar.f4266e.contains(cVar)) {
                        fVar.f4266e.add(cVar);
                        if (fVar.f4265d == null) {
                            fVar.f4265d = new e(2, fVar);
                        }
                        dVar.f4258b.addListener(fVar.f4265d);
                    }
                }
            }
            Drawable drawable3 = this.f3198l;
            if ((drawable3 instanceof AnimatedStateListDrawable) && fVar != null) {
                ((AnimatedStateListDrawable) drawable3).addTransition(R.id.checked, R.id.unchecked, fVar, false);
                ((AnimatedStateListDrawable) this.f3198l).addTransition(R.id.indeterminate, R.id.unchecked, fVar, false);
            }
        }
        Drawable drawable4 = this.f3198l;
        if (drawable4 != null && (colorStateList2 = this.f3201o) != null) {
            c0.b.h(drawable4, colorStateList2);
        }
        Drawable drawable5 = this.f3199m;
        if (drawable5 != null && (colorStateList = this.f3202p) != null) {
            c0.b.h(drawable5, colorStateList);
        }
        super.setButtonDrawable(b.a(this.f3198l, this.f3199m, -1, -1));
        refreshDrawableState();
    }

    @Override // android.widget.CompoundButton
    @Nullable
    public Drawable getButtonDrawable() {
        return this.f3198l;
    }

    @Nullable
    public Drawable getButtonIconDrawable() {
        return this.f3199m;
    }

    @Nullable
    public ColorStateList getButtonIconTintList() {
        return this.f3202p;
    }

    @NonNull
    public PorterDuff.Mode getButtonIconTintMode() {
        return this.f3203q;
    }

    @Override // android.widget.CompoundButton
    @Nullable
    public ColorStateList getButtonTintList() {
        return this.f3201o;
    }

    public int getCheckedState() {
        return this.f3204r;
    }

    @Nullable
    public CharSequence getErrorAccessibilityLabel() {
        return this.f3197k;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public final boolean isChecked() {
        return this.f3204r == 1;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f3194h && this.f3201o == null && this.f3202p == null) {
            setUseMaterialThemeColors(true);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final int[] onCreateDrawableState(int i4) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i4 + 2);
        if (getCheckedState() == 2) {
            View.mergeDrawableStates(onCreateDrawableState, f3189y);
        }
        if (this.f3196j) {
            View.mergeDrawableStates(onCreateDrawableState, f3190z);
        }
        this.f3205s = b.c(onCreateDrawableState);
        return onCreateDrawableState;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void onDraw(Canvas canvas) {
        Drawable a5;
        int i4;
        if (this.f3195i && TextUtils.isEmpty(getText()) && (a5 = androidx.core.widget.c.a(this)) != null) {
            if (n0.f(this)) {
                i4 = -1;
            } else {
                i4 = 1;
            }
            int width = ((getWidth() - a5.getIntrinsicWidth()) / 2) * i4;
            int save = canvas.save();
            canvas.translate(width, 0.0f);
            super.onDraw(canvas);
            canvas.restoreToCount(save);
            if (getBackground() != null) {
                Rect bounds = a5.getBounds();
                c0.b.f(getBackground(), bounds.left + width, bounds.top, bounds.right + width, bounds.bottom);
                return;
            }
            return;
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        if (accessibilityNodeInfo != null && this.f3196j) {
            accessibilityNodeInfo.setText(((Object) accessibilityNodeInfo.getText()) + ", " + ((Object) this.f3197k));
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setCheckedState(savedState.f3211a);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [android.view.View$BaseSavedState, com.google.android.material.checkbox.MaterialCheckBox$SavedState, android.os.Parcelable] */
    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final Parcelable onSaveInstanceState() {
        ?? baseSavedState = new View.BaseSavedState(super.onSaveInstanceState());
        baseSavedState.f3211a = getCheckedState();
        return baseSavedState;
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.CompoundButton
    public void setButtonDrawable(@DrawableRes int i4) {
        setButtonDrawable(com.google.common.collect.c.t0(getContext(), i4));
    }

    public void setButtonIconDrawable(@Nullable Drawable drawable) {
        this.f3199m = drawable;
        a();
    }

    public void setButtonIconDrawableResource(@DrawableRes int i4) {
        setButtonIconDrawable(com.google.common.collect.c.t0(getContext(), i4));
    }

    public void setButtonIconTintList(@Nullable ColorStateList colorStateList) {
        if (this.f3202p == colorStateList) {
            return;
        }
        this.f3202p = colorStateList;
        a();
    }

    public void setButtonIconTintMode(@NonNull PorterDuff.Mode mode) {
        if (this.f3203q == mode) {
            return;
        }
        this.f3203q = mode;
        a();
    }

    @Override // android.widget.CompoundButton
    public void setButtonTintList(@Nullable ColorStateList colorStateList) {
        if (this.f3201o == colorStateList) {
            return;
        }
        this.f3201o = colorStateList;
        a();
    }

    @Override // android.widget.CompoundButton
    public void setButtonTintMode(@Nullable PorterDuff.Mode mode) {
        setSupportButtonTintMode(mode);
        a();
    }

    public void setCenterIfNoTextEnabled(boolean z4) {
        this.f3195i = z4;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z4) {
        setCheckedState(z4 ? 1 : 0);
    }

    public void setCheckedState(int i4) {
        boolean z4;
        AutofillManager autofillManager;
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener;
        if (this.f3204r != i4) {
            this.f3204r = i4;
            if (i4 == 1) {
                z4 = true;
            } else {
                z4 = false;
            }
            super.setChecked(z4);
            refreshDrawableState();
            int i5 = Build.VERSION.SDK_INT;
            if (i5 >= 30 && this.f3207u == null) {
                super.setStateDescription(getButtonStateDescription());
            }
            if (this.f3206t) {
                return;
            }
            this.f3206t = true;
            LinkedHashSet linkedHashSet = this.f3192f;
            if (linkedHashSet != null) {
                Iterator it = linkedHashSet.iterator();
                if (it.hasNext()) {
                    j.f(it.next());
                    throw null;
                }
            }
            if (this.f3204r != 2 && (onCheckedChangeListener = this.f3208v) != null) {
                onCheckedChangeListener.onCheckedChanged(this, isChecked());
            }
            if (i5 >= 26 && (autofillManager = (AutofillManager) getContext().getSystemService(AutofillManager.class)) != null) {
                autofillManager.notifyValueChanged(this);
            }
            this.f3206t = false;
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean z4) {
        super.setEnabled(z4);
    }

    public void setErrorAccessibilityLabel(@Nullable CharSequence charSequence) {
        this.f3197k = charSequence;
    }

    public void setErrorAccessibilityLabelResource(@StringRes int i4) {
        setErrorAccessibilityLabel(i4 != 0 ? getResources().getText(i4) : null);
    }

    public void setErrorShown(boolean z4) {
        if (this.f3196j == z4) {
            return;
        }
        this.f3196j = z4;
        refreshDrawableState();
        Iterator it = this.f3191e.iterator();
        if (it.hasNext()) {
            j.f(it.next());
            throw null;
        }
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(@Nullable CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.f3208v = onCheckedChangeListener;
    }

    @Override // android.widget.CompoundButton, android.view.View
    @RequiresApi(30)
    public void setStateDescription(@Nullable CharSequence charSequence) {
        this.f3207u = charSequence;
        if (charSequence == null) {
            if (Build.VERSION.SDK_INT >= 30 && charSequence == null) {
                super.setStateDescription(getButtonStateDescription());
                return;
            }
            return;
        }
        super.setStateDescription(charSequence);
    }

    public void setUseMaterialThemeColors(boolean z4) {
        ColorStateList colorStateList;
        this.f3194h = z4;
        if (z4) {
            colorStateList = getMaterialThemeColorsTintList();
        } else {
            colorStateList = null;
        }
        androidx.core.widget.b.c(this, colorStateList);
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public final void toggle() {
        setChecked(!isChecked());
    }

    public MaterialCheckBox(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.checkboxStyle);
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.CompoundButton
    public void setButtonDrawable(@Nullable Drawable drawable) {
        this.f3198l = drawable;
        this.f3200n = false;
        a();
    }

    public MaterialCheckBox(Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(p2.a.a(context, attributeSet, i4, 2131756042), attributeSet, i4);
        this.f3191e = new LinkedHashSet();
        this.f3192f = new LinkedHashSet();
        Context context2 = getContext();
        f fVar = new f(context2);
        Resources resources = context2.getResources();
        Resources.Theme theme = context2.getTheme();
        ThreadLocal threadLocal = s.f38a;
        Drawable a5 = k.a(resources, R.drawable.mtrl_checkbox_button_checked_unchecked, theme);
        fVar.f4268a = a5;
        a5.setCallback(fVar.f4267f);
        new d1.e(fVar.f4268a.getConstantState());
        this.f3209w = fVar;
        this.f3210x = new c(2, this);
        Context context3 = getContext();
        this.f3198l = androidx.core.widget.c.a(this);
        this.f3201o = getSuperButtonTintList();
        setSupportButtonTintList(null);
        q3 e4 = h0.e(context3, attributeSet, o1.a.D, i4, 2131756042, new int[0]);
        this.f3199m = e4.b(2);
        Drawable drawable = this.f3198l;
        TypedArray typedArray = e4.f879b;
        if (drawable != null && i2.c.b(context3, R.attr.isMaterial3Theme, false)) {
            int resourceId = typedArray.getResourceId(0, 0);
            int resourceId2 = typedArray.getResourceId(1, 0);
            if (resourceId == B && resourceId2 == 0) {
                super.setButtonDrawable((Drawable) null);
                this.f3198l = com.google.common.collect.c.t0(context3, R.drawable.mtrl_checkbox_button);
                this.f3200n = true;
                if (this.f3199m == null) {
                    this.f3199m = com.google.common.collect.c.t0(context3, R.drawable.mtrl_checkbox_button_icon);
                }
            }
        }
        this.f3202p = i2.d.b(context3, e4, 3);
        this.f3203q = n0.g(typedArray.getInt(4, -1), PorterDuff.Mode.SRC_IN);
        this.f3194h = typedArray.getBoolean(10, false);
        this.f3195i = typedArray.getBoolean(6, true);
        this.f3196j = typedArray.getBoolean(9, false);
        this.f3197k = typedArray.getText(8);
        if (typedArray.hasValue(7)) {
            setCheckedState(typedArray.getInt(7, 0));
        }
        e4.g();
        a();
    }
}