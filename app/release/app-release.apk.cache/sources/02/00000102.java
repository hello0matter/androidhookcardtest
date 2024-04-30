package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.InputFilter;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.UiThread;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* loaded from: classes.dex */
public class AppCompatTextView extends TextView {

    /* renamed from: a  reason: collision with root package name */
    public final w f530a;

    /* renamed from: b  reason: collision with root package name */
    public final y0 f531b;

    /* renamed from: c  reason: collision with root package name */
    public final c0 f532c;

    /* renamed from: d  reason: collision with root package name */
    public d0 f533d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f534e;

    /* renamed from: f  reason: collision with root package name */
    public androidx.appcompat.app.o0 f535f;

    /* renamed from: g  reason: collision with root package name */
    public Future f536g;

    public AppCompatTextView(@NonNull Context context) {
        this(context, null);
    }

    @NonNull
    private d0 getEmojiTextViewHelper() {
        if (this.f533d == null) {
            this.f533d = new d0(this);
        }
        return this.f533d;
    }

    @Override // android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        w wVar = this.f530a;
        if (wVar != null) {
            wVar.a();
        }
        y0 y0Var = this.f531b;
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
        y0 y0Var = this.f531b;
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
        y0 y0Var = this.f531b;
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
        y0 y0Var = this.f531b;
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
        y0 y0Var = this.f531b;
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
        y0 y0Var = this.f531b;
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

    @Override // android.widget.TextView
    public int getFirstBaselineToTopHeight() {
        return getPaddingTop() - getPaint().getFontMetricsInt().top;
    }

    @Override // android.widget.TextView
    public int getLastBaselineToBottomHeight() {
        return getPaddingBottom() + getPaint().getFontMetricsInt().bottom;
    }

    @RequiresApi(api = 26)
    @UiThread
    public z0 getSuperCaller() {
        androidx.appcompat.app.o0 o0Var;
        if (this.f535f == null) {
            int i4 = Build.VERSION.SDK_INT;
            if (i4 >= 28) {
                o0Var = new a1(this);
            } else if (i4 >= 26) {
                o0Var = new androidx.appcompat.app.o0(6, this);
            }
            this.f535f = o0Var;
        }
        return this.f535f;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.f171c})
    public ColorStateList getSupportBackgroundTintList() {
        w wVar = this.f530a;
        if (wVar != null) {
            return wVar.c();
        }
        return null;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.f171c})
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        w wVar = this.f530a;
        if (wVar != null) {
            return wVar.d();
        }
        return null;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.f171c})
    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f531b.d();
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.f171c})
    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f531b.e();
    }

    @Override // android.widget.TextView
    public CharSequence getText() {
        l();
        return super.getText();
    }

    @Override // android.widget.TextView
    @NonNull
    @RequiresApi(api = 26)
    public TextClassifier getTextClassifier() {
        c0 c0Var;
        if (Build.VERSION.SDK_INT < 28 && (c0Var = this.f532c) != null) {
            TextClassifier textClassifier = (TextClassifier) c0Var.f726c;
            if (textClassifier == null) {
                return r0.a((TextView) c0Var.f725b);
            }
            return textClassifier;
        }
        return super.getTextClassifier();
    }

    @NonNull
    public g0.e getTextMetricsParamsCompat() {
        return androidx.core.widget.v.a(this);
    }

    public final void l() {
        Future future = this.f536g;
        if (future != null) {
            try {
                this.f536g = null;
                androidx.activity.j.f(future.get());
                if (Build.VERSION.SDK_INT >= 29) {
                    throw null;
                }
                androidx.core.widget.v.a(this);
                throw null;
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        this.f531b.getClass();
        y0.h(this, onCreateInputConnection, editorInfo);
        com.google.common.collect.c.h1(this, editorInfo, onCreateInputConnection);
        return onCreateInputConnection;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onLayout(boolean z4, int i4, int i5, int i6, int i7) {
        super.onLayout(z4, i4, i5, i6, i7);
        y0 y0Var = this.f531b;
        if (y0Var != null && !e4.f744b) {
            y0Var.f980i.a();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i4, int i5) {
        l();
        super.onMeasure(i4, i5);
    }

    @Override // android.widget.TextView
    public final void onTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
        super.onTextChanged(charSequence, i4, i5, i6);
        y0 y0Var = this.f531b;
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
        y0 y0Var = this.f531b;
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
        y0 y0Var = this.f531b;
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
        y0 y0Var = this.f531b;
        if (y0Var != null) {
            y0Var.k(i4);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(@Nullable Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        w wVar = this.f530a;
        if (wVar != null) {
            wVar.f();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(@DrawableRes int i4) {
        super.setBackgroundResource(i4);
        w wVar = this.f530a;
        if (wVar != null) {
            wVar.g(i4);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        y0 y0Var = this.f531b;
        if (y0Var != null) {
            y0Var.b();
        }
    }

    @Override // android.widget.TextView
    @RequiresApi(17)
    public void setCompoundDrawablesRelative(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        y0 y0Var = this.f531b;
        if (y0Var != null) {
            y0Var.b();
        }
    }

    @Override // android.widget.TextView
    @RequiresApi(17)
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i4, int i5, int i6, int i7) {
        Context context = getContext();
        setCompoundDrawablesRelativeWithIntrinsicBounds(i4 != 0 ? com.google.common.collect.c.t0(context, i4) : null, i5 != 0 ? com.google.common.collect.c.t0(context, i5) : null, i6 != 0 ? com.google.common.collect.c.t0(context, i6) : null, i7 != 0 ? com.google.common.collect.c.t0(context, i7) : null);
        y0 y0Var = this.f531b;
        if (y0Var != null) {
            y0Var.b();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int i4, int i5, int i6, int i7) {
        Context context = getContext();
        setCompoundDrawablesWithIntrinsicBounds(i4 != 0 ? com.google.common.collect.c.t0(context, i4) : null, i5 != 0 ? com.google.common.collect.c.t0(context, i5) : null, i6 != 0 ? com.google.common.collect.c.t0(context, i6) : null, i7 != 0 ? com.google.common.collect.c.t0(context, i7) : null);
        y0 y0Var = this.f531b;
        if (y0Var != null) {
            y0Var.b();
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

    @Override // android.widget.TextView
    public void setFirstBaselineToTopHeight(@IntRange(from = 0) @Px int i4) {
        if (Build.VERSION.SDK_INT >= 28) {
            getSuperCaller().o(i4);
        } else {
            androidx.core.widget.v.b(this, i4);
        }
    }

    @Override // android.widget.TextView
    public void setLastBaselineToBottomHeight(@IntRange(from = 0) @Px int i4) {
        if (Build.VERSION.SDK_INT >= 28) {
            getSuperCaller().n(i4);
        } else {
            androidx.core.widget.v.c(this, i4);
        }
    }

    @Override // android.widget.TextView
    public void setLineHeight(@IntRange(from = 0) @Px int i4) {
        h0.e.b(i4);
        int fontMetricsInt = getPaint().getFontMetricsInt(null);
        if (i4 != fontMetricsInt) {
            setLineSpacing(i4 - fontMetricsInt, 1.0f);
        }
    }

    public void setPrecomputedText(@NonNull g0.f fVar) {
        if (Build.VERSION.SDK_INT >= 29) {
            throw null;
        }
        androidx.core.widget.v.a(this);
        throw null;
    }

    @RestrictTo({RestrictTo.Scope.f171c})
    public void setSupportBackgroundTintList(@Nullable ColorStateList colorStateList) {
        w wVar = this.f530a;
        if (wVar != null) {
            wVar.i(colorStateList);
        }
    }

    @RestrictTo({RestrictTo.Scope.f171c})
    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        w wVar = this.f530a;
        if (wVar != null) {
            wVar.j(mode);
        }
    }

    @RestrictTo({RestrictTo.Scope.f171c})
    public void setSupportCompoundDrawablesTintList(@Nullable ColorStateList colorStateList) {
        y0 y0Var = this.f531b;
        y0Var.l(colorStateList);
        y0Var.b();
    }

    @RestrictTo({RestrictTo.Scope.f171c})
    public void setSupportCompoundDrawablesTintMode(@Nullable PorterDuff.Mode mode) {
        y0 y0Var = this.f531b;
        y0Var.m(mode);
        y0Var.b();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i4) {
        super.setTextAppearance(context, i4);
        y0 y0Var = this.f531b;
        if (y0Var != null) {
            y0Var.g(context, i4);
        }
    }

    @Override // android.widget.TextView
    @RequiresApi(api = 26)
    public void setTextClassifier(@Nullable TextClassifier textClassifier) {
        c0 c0Var;
        if (Build.VERSION.SDK_INT >= 28 || (c0Var = this.f532c) == null) {
            super.setTextClassifier(textClassifier);
        } else {
            c0Var.f726c = textClassifier;
        }
    }

    public void setTextFuture(@Nullable Future<g0.f> future) {
        this.f536g = future;
        if (future != null) {
            requestLayout();
        }
    }

    public void setTextMetricsParamsCompat(@NonNull g0.e eVar) {
        TextDirectionHeuristic textDirectionHeuristic;
        TextDirectionHeuristic textDirectionHeuristic2 = eVar.f4776b;
        TextDirectionHeuristic textDirectionHeuristic3 = TextDirectionHeuristics.FIRSTSTRONG_RTL;
        int i4 = 1;
        if (textDirectionHeuristic2 != textDirectionHeuristic3 && textDirectionHeuristic2 != (textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_LTR)) {
            if (textDirectionHeuristic2 == TextDirectionHeuristics.ANYRTL_LTR) {
                i4 = 2;
            } else if (textDirectionHeuristic2 == TextDirectionHeuristics.LTR) {
                i4 = 3;
            } else if (textDirectionHeuristic2 == TextDirectionHeuristics.RTL) {
                i4 = 4;
            } else if (textDirectionHeuristic2 == TextDirectionHeuristics.LOCALE) {
                i4 = 5;
            } else if (textDirectionHeuristic2 == textDirectionHeuristic) {
                i4 = 6;
            } else if (textDirectionHeuristic2 == textDirectionHeuristic3) {
                i4 = 7;
            }
        }
        androidx.core.widget.q.h(this, i4);
        getPaint().set(eVar.f4775a);
        androidx.core.widget.r.e(this, eVar.f4777c);
        androidx.core.widget.r.h(this, eVar.f4778d);
    }

    @Override // android.widget.TextView
    public void setTextSize(int i4, float f4) {
        boolean z4 = e4.f744b;
        if (z4) {
            super.setTextSize(i4, f4);
            return;
        }
        y0 y0Var = this.f531b;
        if (y0Var != null && !z4) {
            i1 i1Var = y0Var.f980i;
            if (!i1Var.f()) {
                i1Var.g(i4, f4);
            }
        }
    }

    @Override // android.widget.TextView
    public void setTypeface(@Nullable Typeface typeface, int i4) {
        Typeface typeface2;
        if (this.f534e) {
            return;
        }
        if (typeface != null && i4 > 0) {
            Context context = getContext();
            b0.n nVar = b0.h.f2498a;
            if (context != null) {
                typeface2 = Typeface.create(typeface, i4);
            } else {
                throw new IllegalArgumentException("Context cannot be null");
            }
        } else {
            typeface2 = null;
        }
        this.f534e = true;
        if (typeface2 != null) {
            typeface = typeface2;
        }
        try {
            super.setTypeface(typeface, i4);
        } finally {
            this.f534e = false;
        }
    }

    public AppCompatTextView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 16842884);
    }

    @Override // android.widget.TextView
    @RequiresApi(17)
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        y0 y0Var = this.f531b;
        if (y0Var != null) {
            y0Var.b();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        y0 y0Var = this.f531b;
        if (y0Var != null) {
            y0Var.b();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppCompatTextView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        n3.a(context);
        this.f534e = false;
        this.f535f = null;
        m3.a(this, getContext());
        w wVar = new w(this);
        this.f530a = wVar;
        wVar.e(attributeSet, i4);
        y0 y0Var = new y0(this);
        this.f531b = y0Var;
        y0Var.f(attributeSet, i4);
        y0Var.b();
        this.f532c = new c0(this);
        getEmojiTextViewHelper().b(attributeSet, i4);
    }
}