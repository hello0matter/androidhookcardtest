package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.RadioButton;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import com.example.msphone.R;

/* loaded from: classes.dex */
public class AppCompatRadioButton extends RadioButton implements androidx.core.widget.x {

    /* renamed from: a  reason: collision with root package name */
    public final y f514a;

    /* renamed from: b  reason: collision with root package name */
    public final w f515b;

    /* renamed from: c  reason: collision with root package name */
    public final y0 f516c;

    /* renamed from: d  reason: collision with root package name */
    public d0 f517d;

    public AppCompatRadioButton(Context context) {
        this(context, null);
    }

    @NonNull
    private d0 getEmojiTextViewHelper() {
        if (this.f517d == null) {
            this.f517d = new d0(this);
        }
        return this.f517d;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        w wVar = this.f515b;
        if (wVar != null) {
            wVar.a();
        }
        y0 y0Var = this.f516c;
        if (y0Var != null) {
            y0Var.b();
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        y yVar = this.f514a;
        if (yVar != null) {
            yVar.getClass();
        }
        return compoundPaddingLeft;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.f171c})
    public ColorStateList getSupportBackgroundTintList() {
        w wVar = this.f515b;
        if (wVar != null) {
            return wVar.c();
        }
        return null;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.f171c})
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        w wVar = this.f515b;
        if (wVar != null) {
            return wVar.d();
        }
        return null;
    }

    @Override // androidx.core.widget.x
    @Nullable
    @RestrictTo({RestrictTo.Scope.f171c})
    public ColorStateList getSupportButtonTintList() {
        y yVar = this.f514a;
        if (yVar != null) {
            return yVar.f967b;
        }
        return null;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.f171c})
    public PorterDuff.Mode getSupportButtonTintMode() {
        y yVar = this.f514a;
        if (yVar != null) {
            return yVar.f968c;
        }
        return null;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.f171c})
    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f516c.d();
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.f171c})
    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f516c.e();
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z4) {
        super.setAllCaps(z4);
        getEmojiTextViewHelper().c(z4);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(@Nullable Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        w wVar = this.f515b;
        if (wVar != null) {
            wVar.f();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(@DrawableRes int i4) {
        super.setBackgroundResource(i4);
        w wVar = this.f515b;
        if (wVar != null) {
            wVar.g(i4);
        }
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(@DrawableRes int i4) {
        setButtonDrawable(com.google.common.collect.c.t0(getContext(), i4));
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        y0 y0Var = this.f516c;
        if (y0Var != null) {
            y0Var.b();
        }
    }

    @Override // android.widget.TextView
    @RequiresApi(17)
    public void setCompoundDrawablesRelative(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        y0 y0Var = this.f516c;
        if (y0Var != null) {
            y0Var.b();
        }
    }

    public void setEmojiCompatEnabled(boolean z4) {
        getEmojiTextViewHelper().d(z4);
    }

    @Override // android.widget.TextView
    public void setFilters(@NonNull InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    @RestrictTo({RestrictTo.Scope.f171c})
    public void setSupportBackgroundTintList(@Nullable ColorStateList colorStateList) {
        w wVar = this.f515b;
        if (wVar != null) {
            wVar.i(colorStateList);
        }
    }

    @RestrictTo({RestrictTo.Scope.f171c})
    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        w wVar = this.f515b;
        if (wVar != null) {
            wVar.j(mode);
        }
    }

    @Override // androidx.core.widget.x
    @RestrictTo({RestrictTo.Scope.f171c})
    public void setSupportButtonTintList(@Nullable ColorStateList colorStateList) {
        y yVar = this.f514a;
        if (yVar != null) {
            yVar.f967b = colorStateList;
            yVar.f969d = true;
            yVar.a();
        }
    }

    @Override // androidx.core.widget.x
    @RestrictTo({RestrictTo.Scope.f171c})
    public void setSupportButtonTintMode(@Nullable PorterDuff.Mode mode) {
        y yVar = this.f514a;
        if (yVar != null) {
            yVar.f968c = mode;
            yVar.f970e = true;
            yVar.a();
        }
    }

    @RestrictTo({RestrictTo.Scope.f171c})
    public void setSupportCompoundDrawablesTintList(@Nullable ColorStateList colorStateList) {
        y0 y0Var = this.f516c;
        y0Var.l(colorStateList);
        y0Var.b();
    }

    @RestrictTo({RestrictTo.Scope.f171c})
    public void setSupportCompoundDrawablesTintMode(@Nullable PorterDuff.Mode mode) {
        y0 y0Var = this.f516c;
        y0Var.m(mode);
        y0Var.b();
    }

    public AppCompatRadioButton(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.radioButtonStyle);
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        y yVar = this.f514a;
        if (yVar != null) {
            if (yVar.f971f) {
                yVar.f971f = false;
                return;
            }
            yVar.f971f = true;
            yVar.a();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppCompatRadioButton(Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        n3.a(context);
        m3.a(this, getContext());
        y yVar = new y(this);
        this.f514a = yVar;
        yVar.b(attributeSet, i4);
        w wVar = new w(this);
        this.f515b = wVar;
        wVar.e(attributeSet, i4);
        y0 y0Var = new y0(this);
        this.f516c = y0Var;
        y0Var.f(attributeSet, i4);
        getEmojiTextViewHelper().b(attributeSet, i4);
    }
}