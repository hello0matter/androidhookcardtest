package com.google.android.material.switchmaterial;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;
import b2.a;
import com.example.msphone.R;
import com.google.android.material.internal.h0;
import i0.m0;
import i0.y0;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class SwitchMaterial extends SwitchCompat {

    /* renamed from: a0  reason: collision with root package name */
    public static final int[][] f3898a0 = {new int[]{16842910, 16842912}, new int[]{16842910, -16842912}, new int[]{-16842910, 16842912}, new int[]{-16842910, -16842912}};
    public final a T;
    public ColorStateList U;
    public ColorStateList V;
    public boolean W;

    public SwitchMaterial(@NonNull Context context) {
        this(context, null);
    }

    private ColorStateList getMaterialThemeColorsThumbTintList() {
        if (this.U == null) {
            int b5 = y1.a.b(R.attr.colorSurface, this);
            int b6 = y1.a.b(R.attr.colorControlActivated, this);
            float dimension = getResources().getDimension(R.dimen.mtrl_switch_thumb_elevation);
            a aVar = this.T;
            if (aVar.f2517a) {
                float f4 = 0.0f;
                for (ViewParent parent = getParent(); parent instanceof View; parent = parent.getParent()) {
                    WeakHashMap weakHashMap = y0.f4999a;
                    f4 += m0.i((View) parent);
                }
                dimension += f4;
            }
            int a5 = aVar.a(b5, dimension);
            this.U = new ColorStateList(f3898a0, new int[]{y1.a.e(b5, 1.0f, b6), a5, y1.a.e(b5, 0.38f, b6), a5});
        }
        return this.U;
    }

    private ColorStateList getMaterialThemeColorsTrackTintList() {
        if (this.V == null) {
            int b5 = y1.a.b(R.attr.colorSurface, this);
            int b6 = y1.a.b(R.attr.colorControlActivated, this);
            int b7 = y1.a.b(R.attr.colorOnSurface, this);
            this.V = new ColorStateList(f3898a0, new int[]{y1.a.e(b5, 0.54f, b6), y1.a.e(b5, 0.32f, b7), y1.a.e(b5, 0.12f, b6), y1.a.e(b5, 0.12f, b7)});
        }
        return this.V;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.W && getThumbTintList() == null) {
            setThumbTintList(getMaterialThemeColorsThumbTintList());
        }
        if (this.W && getTrackTintList() == null) {
            setTrackTintList(getMaterialThemeColorsTrackTintList());
        }
    }

    public void setUseMaterialThemeColors(boolean z4) {
        ColorStateList colorStateList;
        this.W = z4;
        if (z4) {
            setThumbTintList(getMaterialThemeColorsThumbTintList());
            colorStateList = getMaterialThemeColorsTrackTintList();
        } else {
            colorStateList = null;
            setThumbTintList(null);
        }
        setTrackTintList(colorStateList);
    }

    public SwitchMaterial(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.switchStyle);
    }

    public SwitchMaterial(@NonNull Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(p2.a.a(context, attributeSet, i4, 2131756044), attributeSet, i4);
        Context context2 = getContext();
        this.T = new a(context2);
        int[] iArr = o1.a.f5937a0;
        h0.a(context2, attributeSet, i4, 2131756044);
        h0.b(context2, attributeSet, iArr, i4, 2131756044, new int[0]);
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, iArr, i4, 2131756044);
        this.W = obtainStyledAttributes.getBoolean(0, false);
        obtainStyledAttributes.recycle();
    }
}