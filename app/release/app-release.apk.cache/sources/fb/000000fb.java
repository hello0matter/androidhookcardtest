package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import com.example.msphone.R;

/* loaded from: classes.dex */
public class AppCompatMultiAutoCompleteTextView extends MultiAutoCompleteTextView {

    /* renamed from: d  reason: collision with root package name */
    public static final int[] f510d = {16843126};

    /* renamed from: a  reason: collision with root package name */
    public final w f511a;

    /* renamed from: b  reason: collision with root package name */
    public final y0 f512b;

    /* renamed from: c  reason: collision with root package name */
    public final c0 f513c;

    public AppCompatMultiAutoCompleteTextView(@NonNull Context context) {
        this(context, null);
    }

    @Override // android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        w wVar = this.f511a;
        if (wVar != null) {
            wVar.a();
        }
        y0 y0Var = this.f512b;
        if (y0Var != null) {
            y0Var.b();
        }
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.f171c})
    public ColorStateList getSupportBackgroundTintList() {
        w wVar = this.f511a;
        if (wVar != null) {
            return wVar.c();
        }
        return null;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.f171c})
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        w wVar = this.f511a;
        if (wVar != null) {
            return wVar.d();
        }
        return null;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.f171c})
    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f512b.d();
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.f171c})
    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f512b.e();
    }

    @Override // android.widget.TextView, android.view.View
    public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        com.google.common.collect.c.h1(this, editorInfo, onCreateInputConnection);
        return this.f513c.f(onCreateInputConnection, editorInfo);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(@Nullable Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        w wVar = this.f511a;
        if (wVar != null) {
            wVar.f();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(@DrawableRes int i4) {
        super.setBackgroundResource(i4);
        w wVar = this.f511a;
        if (wVar != null) {
            wVar.g(i4);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        y0 y0Var = this.f512b;
        if (y0Var != null) {
            y0Var.b();
        }
    }

    @Override // android.widget.TextView
    @RequiresApi(17)
    public void setCompoundDrawablesRelative(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        y0 y0Var = this.f512b;
        if (y0Var != null) {
            y0Var.b();
        }
    }

    @Override // android.widget.AutoCompleteTextView
    public void setDropDownBackgroundResource(@DrawableRes int i4) {
        setDropDownBackgroundDrawable(com.google.common.collect.c.t0(getContext(), i4));
    }

    public void setEmojiCompatEnabled(boolean z4) {
        ((s0.b) this.f513c.f726c).f6498a.r(z4);
    }

    @Override // android.widget.TextView
    public void setKeyListener(@Nullable KeyListener keyListener) {
        super.setKeyListener(this.f513c.a(keyListener));
    }

    @RestrictTo({RestrictTo.Scope.f171c})
    public void setSupportBackgroundTintList(@Nullable ColorStateList colorStateList) {
        w wVar = this.f511a;
        if (wVar != null) {
            wVar.i(colorStateList);
        }
    }

    @RestrictTo({RestrictTo.Scope.f171c})
    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        w wVar = this.f511a;
        if (wVar != null) {
            wVar.j(mode);
        }
    }

    @RestrictTo({RestrictTo.Scope.f171c})
    public void setSupportCompoundDrawablesTintList(@Nullable ColorStateList colorStateList) {
        y0 y0Var = this.f512b;
        y0Var.l(colorStateList);
        y0Var.b();
    }

    @RestrictTo({RestrictTo.Scope.f171c})
    public void setSupportCompoundDrawablesTintMode(@Nullable PorterDuff.Mode mode) {
        y0 y0Var = this.f512b;
        y0Var.m(mode);
        y0Var.b();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i4) {
        super.setTextAppearance(context, i4);
        y0 y0Var = this.f512b;
        if (y0Var != null) {
            y0Var.g(context, i4);
        }
    }

    public AppCompatMultiAutoCompleteTextView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.autoCompleteTextViewStyle);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppCompatMultiAutoCompleteTextView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        n3.a(context);
        m3.a(this, getContext());
        q3 f4 = q3.f(getContext(), attributeSet, f510d, i4, 0);
        if (f4.f879b.hasValue(0)) {
            setDropDownBackgroundDrawable(f4.b(0));
        }
        f4.g();
        w wVar = new w(this);
        this.f511a = wVar;
        wVar.e(attributeSet, i4);
        y0 y0Var = new y0(this);
        this.f512b = y0Var;
        y0Var.f(attributeSet, i4);
        y0Var.b();
        c0 c0Var = new c0((EditText) this);
        this.f513c = c0Var;
        c0Var.b(attributeSet, i4);
        KeyListener keyListener = getKeyListener();
        if (!(keyListener instanceof NumberKeyListener)) {
            boolean isFocusable = super.isFocusable();
            boolean isClickable = super.isClickable();
            boolean isLongClickable = super.isLongClickable();
            int inputType = super.getInputType();
            KeyListener a5 = c0Var.a(keyListener);
            if (a5 == keyListener) {
                return;
            }
            super.setKeyListener(a5);
            super.setRawInputType(inputType);
            super.setFocusable(isFocusable);
            super.setClickable(isClickable);
            super.setLongClickable(isLongClickable);
        }
    }
}