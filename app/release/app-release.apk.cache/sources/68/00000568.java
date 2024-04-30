package com.google.android.material.radiobutton;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.core.widget.b;
import com.example.msphone.R;
import com.google.android.material.internal.h0;
import i2.d;
import y1.a;

/* loaded from: classes.dex */
public class MaterialRadioButton extends AppCompatRadioButton {

    /* renamed from: g  reason: collision with root package name */
    public static final int[][] f3725g = {new int[]{16842910, 16842912}, new int[]{16842910, -16842912}, new int[]{-16842910, 16842912}, new int[]{-16842910, -16842912}};

    /* renamed from: e  reason: collision with root package name */
    public ColorStateList f3726e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f3727f;

    public MaterialRadioButton(@NonNull Context context) {
        this(context, null);
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.f3726e == null) {
            int b5 = a.b(R.attr.colorControlActivated, this);
            int b6 = a.b(R.attr.colorOnSurface, this);
            int b7 = a.b(R.attr.colorSurface, this);
            this.f3726e = new ColorStateList(f3725g, new int[]{a.e(b7, 1.0f, b5), a.e(b7, 0.54f, b6), a.e(b7, 0.38f, b6), a.e(b7, 0.38f, b6)});
        }
        return this.f3726e;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f3727f && b.a(this) == null) {
            setUseMaterialThemeColors(true);
        }
    }

    public void setUseMaterialThemeColors(boolean z4) {
        ColorStateList colorStateList;
        this.f3727f = z4;
        if (z4) {
            colorStateList = getMaterialThemeColorsTintList();
        } else {
            colorStateList = null;
        }
        b.c(this, colorStateList);
    }

    public MaterialRadioButton(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.radioButtonStyle);
    }

    public MaterialRadioButton(@NonNull Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(p2.a.a(context, attributeSet, i4, 2131756043), attributeSet, i4);
        Context context2 = getContext();
        TypedArray d4 = h0.d(context2, attributeSet, o1.a.F, i4, 2131756043, new int[0]);
        if (d4.hasValue(0)) {
            b.c(this, d.a(context2, d4, 0));
        }
        this.f3727f = d4.getBoolean(1, false);
        d4.recycle();
    }
}