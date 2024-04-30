package com.google.android.material.textfield;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.q3;
import com.example.msphone.R;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.n0;
import i0.h0;
import i0.j0;
import i0.y0;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class r extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    public final TextInputLayout f4112a;

    /* renamed from: b  reason: collision with root package name */
    public final AppCompatTextView f4113b;

    /* renamed from: c  reason: collision with root package name */
    public CharSequence f4114c;

    /* renamed from: d  reason: collision with root package name */
    public final CheckableImageButton f4115d;

    /* renamed from: e  reason: collision with root package name */
    public ColorStateList f4116e;

    /* renamed from: f  reason: collision with root package name */
    public PorterDuff.Mode f4117f;

    /* renamed from: g  reason: collision with root package name */
    public int f4118g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView.ScaleType f4119h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnLongClickListener f4120i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f4121j;

    public r(TextInputLayout textInputLayout, q3 q3Var) {
        super(textInputLayout.getContext());
        CharSequence text;
        this.f4112a = textInputLayout;
        setVisibility(8);
        setOrientation(0);
        setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388611));
        CheckableImageButton checkableImageButton = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(R.layout.design_text_input_start_icon, (ViewGroup) this, false);
        this.f4115d = checkableImageButton;
        AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
        this.f4113b = appCompatTextView;
        if (i2.d.e(getContext())) {
            i0.p.g((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams(), 0);
        }
        View.OnLongClickListener onLongClickListener = this.f4120i;
        checkableImageButton.setOnClickListener(null);
        com.google.common.collect.c.P1(checkableImageButton, onLongClickListener);
        this.f4120i = null;
        checkableImageButton.setOnLongClickListener(null);
        com.google.common.collect.c.P1(checkableImageButton, null);
        TypedArray typedArray = q3Var.f879b;
        if (typedArray.hasValue(69)) {
            this.f4116e = i2.d.b(getContext(), q3Var, 69);
        }
        if (typedArray.hasValue(70)) {
            this.f4117f = n0.g(typedArray.getInt(70, -1), null);
        }
        if (typedArray.hasValue(66)) {
            b(q3Var.b(66));
            if (typedArray.hasValue(65) && checkableImageButton.getContentDescription() != (text = typedArray.getText(65))) {
                checkableImageButton.setContentDescription(text);
            }
            checkableImageButton.setCheckable(typedArray.getBoolean(64, true));
        }
        int dimensionPixelSize = typedArray.getDimensionPixelSize(67, getResources().getDimensionPixelSize(R.dimen.mtrl_min_touch_target_size));
        if (dimensionPixelSize >= 0) {
            if (dimensionPixelSize != this.f4118g) {
                this.f4118g = dimensionPixelSize;
                checkableImageButton.setMinimumWidth(dimensionPixelSize);
                checkableImageButton.setMinimumHeight(dimensionPixelSize);
            }
            if (typedArray.hasValue(68)) {
                ImageView.ScaleType V = com.google.common.collect.c.V(typedArray.getInt(68, -1));
                this.f4119h = V;
                checkableImageButton.setScaleType(V);
            }
            appCompatTextView.setVisibility(8);
            appCompatTextView.setId(R.id.textinput_prefix_text);
            appCompatTextView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            WeakHashMap weakHashMap = y0.f4999a;
            j0.f(appCompatTextView, 1);
            appCompatTextView.setTextAppearance(typedArray.getResourceId(60, 0));
            if (typedArray.hasValue(61)) {
                appCompatTextView.setTextColor(q3Var.a(61));
            }
            CharSequence text2 = typedArray.getText(59);
            this.f4114c = TextUtils.isEmpty(text2) ? null : text2;
            appCompatTextView.setText(text2);
            e();
            addView(checkableImageButton);
            addView(appCompatTextView);
            return;
        }
        throw new IllegalArgumentException("startIconSize cannot be less than 0");
    }

    public final int a() {
        int i4;
        CheckableImageButton checkableImageButton = this.f4115d;
        if (checkableImageButton.getVisibility() == 0) {
            i4 = i0.p.b((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams()) + checkableImageButton.getMeasuredWidth();
        } else {
            i4 = 0;
        }
        WeakHashMap weakHashMap = y0.f4999a;
        return h0.f(this.f4113b) + h0.f(this) + i4;
    }

    public final void b(Drawable drawable) {
        CheckableImageButton checkableImageButton = this.f4115d;
        checkableImageButton.setImageDrawable(drawable);
        if (drawable != null) {
            ColorStateList colorStateList = this.f4116e;
            PorterDuff.Mode mode = this.f4117f;
            TextInputLayout textInputLayout = this.f4112a;
            com.google.common.collect.c.m(textInputLayout, checkableImageButton, colorStateList, mode);
            c(true);
            com.google.common.collect.c.J1(textInputLayout, checkableImageButton, this.f4116e);
            return;
        }
        c(false);
        View.OnLongClickListener onLongClickListener = this.f4120i;
        checkableImageButton.setOnClickListener(null);
        com.google.common.collect.c.P1(checkableImageButton, onLongClickListener);
        this.f4120i = null;
        checkableImageButton.setOnLongClickListener(null);
        com.google.common.collect.c.P1(checkableImageButton, null);
        if (checkableImageButton.getContentDescription() != null) {
            checkableImageButton.setContentDescription(null);
        }
    }

    public final void c(boolean z4) {
        boolean z5;
        CheckableImageButton checkableImageButton = this.f4115d;
        int i4 = 0;
        if (checkableImageButton.getVisibility() == 0) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (z5 != z4) {
            if (!z4) {
                i4 = 8;
            }
            checkableImageButton.setVisibility(i4);
            d();
            e();
        }
    }

    public final void d() {
        int f4;
        EditText editText = this.f4112a.f3966d;
        if (editText == null) {
            return;
        }
        if (this.f4115d.getVisibility() == 0) {
            f4 = 0;
        } else {
            WeakHashMap weakHashMap = y0.f4999a;
            f4 = h0.f(editText);
        }
        int compoundPaddingTop = editText.getCompoundPaddingTop();
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.material_input_text_to_prefix_suffix_padding);
        int compoundPaddingBottom = editText.getCompoundPaddingBottom();
        WeakHashMap weakHashMap2 = y0.f4999a;
        h0.k(this.f4113b, f4, compoundPaddingTop, dimensionPixelSize, compoundPaddingBottom);
    }

    public final void e() {
        int i4 = 8;
        int i5 = (this.f4114c == null || this.f4121j) ? 8 : 0;
        if (this.f4115d.getVisibility() == 0 || i5 == 0) {
            i4 = 0;
        }
        setVisibility(i4);
        this.f4113b.setVisibility(i5);
        this.f4112a.q();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i4, int i5) {
        super.onMeasure(i4, i5);
        d();
    }
}