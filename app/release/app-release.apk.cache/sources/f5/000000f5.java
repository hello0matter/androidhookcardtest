package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.example.msphone.R;

/* loaded from: classes.dex */
public class AppCompatButton extends Button {

    /* renamed from: a  reason: collision with root package name */
    public final w f487a;

    /* renamed from: b  reason: collision with root package name */
    public final y0 f488b;

    /* renamed from: c  reason: collision with root package name */
    public d0 f489c;

    public AppCompatButton(@NonNull Context context) {
        this(context, null);
    }

    @NonNull
    private d0 getEmojiTextViewHelper() {
        if (this.f489c == null) {
            this.f489c = new d0(this);
        }
        return this.f489c;
    }

    @Override // android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        w wVar = this.f487a;
        if (wVar != null) {
            wVar.a();
        }
        y0 y0Var = this.f488b;
        if (y0Var != null) {
            y0Var.b();
        }
    }

    @Override // android.widget.TextView
    @RestrictTo({RestrictTo.Scope.f171c})
    public int getAutoSizeMaxTextSize() {
        if (e4.f744b) {
            return super.getAutoSizeMaxTextSize();
        }
        y0 y0Var = this.f488b;
        if (y0Var != null) {
            return Math.round(y0Var.f980i.f777e);
        }
        return -1;
    }

    @Override // android.widget.TextView
    @RestrictTo({RestrictTo.Scope.f171c})
    public int getAutoSizeMinTextSize() {
        if (e4.f744b) {
            return super.getAutoSizeMinTextSize();
        }
        y0 y0Var = this.f488b;
        if (y0Var != null) {
            return Math.round(y0Var.f980i.f776d);
        }
        return -1;
    }

    @Override // android.widget.TextView
    @RestrictTo({RestrictTo.Scope.f171c})
    public int getAutoSizeStepGranularity() {
        if (e4.f744b) {
            return super.getAutoSizeStepGranularity();
        }
        y0 y0Var = this.f488b;
        if (y0Var != null) {
            return Math.round(y0Var.f980i.f775c);
        }
        return -1;
    }

    @Override // android.widget.TextView
    @RestrictTo({RestrictTo.Scope.f171c})
    public int[] getAutoSizeTextAvailableSizes() {
        if (e4.f744b) {
            return super.getAutoSizeTextAvailableSizes();
        }
        y0 y0Var = this.f488b;
        if (y0Var != null) {
            return y0Var.f980i.f778f;
        }
        return new int[0];
    }

    @Override // android.widget.TextView
    @SuppressLint({"WrongConstant"})
    @RestrictTo({RestrictTo.Scope.f171c})
    public int getAutoSizeTextType() {
        if (e4.f744b) {
            if (super.getAutoSizeTextType() != 1) {
                return 0;
            }
            return 1;
        }
        y0 y0Var = this.f488b;
        if (y0Var == null) {
            return 0;
        }
        return y0Var.f980i.f773a;
    }

    @Override // android.widget.TextView
    @Nullable
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return androidx.core.widget.v.d(super.getCustomSelectionActionModeCallback());
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.f171c})
    public ColorStateList getSupportBackgroundTintList() {
        w wVar = this.f487a;
        if (wVar != null) {
            return wVar.c();
        }
        return null;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.f171c})
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        w wVar = this.f487a;
        if (wVar != null) {
            return wVar.d();
        }
        return null;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.f171c})
    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f488b.d();
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.f171c})
    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f488b.e();
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(Button.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(Button.class.getName());
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z4, int i4, int i5, int i6, int i7) {
        super.onLayout(z4, i4, i5, i6, i7);
        y0 y0Var = this.f488b;
        if (y0Var != null && !e4.f744b) {
            y0Var.f980i.a();
        }
    }

    @Override // android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
        super.onTextChanged(charSequence, i4, i5, i6);
        y0 y0Var = this.f488b;
        if (y0Var != null && !e4.f744b) {
            i1 i1Var = y0Var.f980i;
            if (i1Var.f()) {
                i1Var.a();
            }
        }
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z4) {
        super.setAllCaps(z4);
        getEmojiTextViewHelper().c(z4);
    }

    @Override // android.widget.TextView
    @RestrictTo({RestrictTo.Scope.f171c})
    public void setAutoSizeTextTypeUniformWithConfiguration(int i4, int i5, int i6, int i7) {
        if (e4.f744b) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i4, i5, i6, i7);
            return;
        }
        y0 y0Var = this.f488b;
        if (y0Var != null) {
            y0Var.i(i4, i5, i6, i7);
        }
    }

    @Override // android.widget.TextView
    @RestrictTo({RestrictTo.Scope.f171c})
    public void setAutoSizeTextTypeUniformWithPresetSizes(@NonNull int[] iArr, int i4) {
        if (e4.f744b) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i4);
            return;
        }
        y0 y0Var = this.f488b;
        if (y0Var != null) {
            y0Var.j(iArr, i4);
        }
    }

    @Override // android.widget.TextView
    @RestrictTo({RestrictTo.Scope.f171c})
    public void setAutoSizeTextTypeWithDefaults(int i4) {
        if (e4.f744b) {
            super.setAutoSizeTextTypeWithDefaults(i4);
            return;
        }
        y0 y0Var = this.f488b;
        if (y0Var != null) {
            y0Var.k(i4);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(@Nullable Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        w wVar = this.f487a;
        if (wVar != null) {
            wVar.f();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(@DrawableRes int i4) {
        super.setBackgroundResource(i4);
        w wVar = this.f487a;
        if (wVar != null) {
            wVar.g(i4);
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(@Nullable ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(androidx.core.widget.v.e(callback, this));
    }

    public void setEmojiCompatEnabled(boolean z4) {
        getEmojiTextViewHelper().d(z4);
    }

    @Override // android.widget.TextView
    public void setFilters(@NonNull InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    public void setSupportAllCaps(boolean z4) {
        y0 y0Var = this.f488b;
        if (y0Var != null) {
            y0Var.f972a.setAllCaps(z4);
        }
    }

    @RestrictTo({RestrictTo.Scope.f171c})
    public void setSupportBackgroundTintList(@Nullable ColorStateList colorStateList) {
        w wVar = this.f487a;
        if (wVar != null) {
            wVar.i(colorStateList);
        }
    }

    @RestrictTo({RestrictTo.Scope.f171c})
    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        w wVar = this.f487a;
        if (wVar != null) {
            wVar.j(mode);
        }
    }

    @RestrictTo({RestrictTo.Scope.f171c})
    public void setSupportCompoundDrawablesTintList(@Nullable ColorStateList colorStateList) {
        y0 y0Var = this.f488b;
        y0Var.l(colorStateList);
        y0Var.b();
    }

    @RestrictTo({RestrictTo.Scope.f171c})
    public void setSupportCompoundDrawablesTintMode(@Nullable PorterDuff.Mode mode) {
        y0 y0Var = this.f488b;
        y0Var.m(mode);
        y0Var.b();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i4) {
        super.setTextAppearance(context, i4);
        y0 y0Var = this.f488b;
        if (y0Var != null) {
            y0Var.g(context, i4);
        }
    }

    @Override // android.widget.TextView
    public void setTextSize(int i4, float f4) {
        boolean z4 = e4.f744b;
        if (z4) {
            super.setTextSize(i4, f4);
            return;
        }
        y0 y0Var = this.f488b;
        if (y0Var != null && !z4) {
            i1 i1Var = y0Var.f980i;
            if (!i1Var.f()) {
                i1Var.g(i4, f4);
            }
        }
    }

    public AppCompatButton(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.buttonStyle);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppCompatButton(@NonNull Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        n3.a(context);
        m3.a(this, getContext());
        w wVar = new w(this);
        this.f487a = wVar;
        wVar.e(attributeSet, i4);
        y0 y0Var = new y0(this);
        this.f488b = y0Var;
        y0Var.f(attributeSet, i4);
        y0Var.b();
        getEmojiTextViewHelper().b(attributeSet, i4);
    }
}