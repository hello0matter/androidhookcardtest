package com.google.android.material.divider;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import com.example.msphone.R;
import i0.h0;
import i0.y0;
import java.util.WeakHashMap;
import l2.j;
import p2.a;
import z.d;
import z.e;

/* loaded from: classes.dex */
public class MaterialDivider extends View {

    /* renamed from: a  reason: collision with root package name */
    public final j f3379a;

    /* renamed from: b  reason: collision with root package name */
    public int f3380b;

    /* renamed from: c  reason: collision with root package name */
    public int f3381c;

    /* renamed from: d  reason: collision with root package name */
    public int f3382d;

    /* renamed from: e  reason: collision with root package name */
    public int f3383e;

    public MaterialDivider(@NonNull Context context) {
        this(context, null);
    }

    public int getDividerColor() {
        return this.f3381c;
    }

    @Px
    public int getDividerInsetEnd() {
        return this.f3383e;
    }

    @Px
    public int getDividerInsetStart() {
        return this.f3382d;
    }

    public int getDividerThickness() {
        return this.f3380b;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        int i4;
        int width;
        int i5;
        super.onDraw(canvas);
        WeakHashMap weakHashMap = y0.f4999a;
        boolean z4 = true;
        if (h0.d(this) != 1) {
            z4 = false;
        }
        if (z4) {
            i4 = this.f3383e;
        } else {
            i4 = this.f3382d;
        }
        if (z4) {
            width = getWidth();
            i5 = this.f3382d;
        } else {
            width = getWidth();
            i5 = this.f3383e;
        }
        int i6 = width - i5;
        j jVar = this.f3379a;
        jVar.setBounds(i4, 0, i6, getBottom() - getTop());
        jVar.draw(canvas);
    }

    @Override // android.view.View
    public final void onMeasure(int i4, int i5) {
        super.onMeasure(i4, i5);
        int mode = View.MeasureSpec.getMode(i5);
        int measuredHeight = getMeasuredHeight();
        if (mode == Integer.MIN_VALUE || mode == 0) {
            int i6 = this.f3380b;
            if (i6 > 0 && measuredHeight != i6) {
                measuredHeight = i6;
            }
            setMeasuredDimension(getMeasuredWidth(), measuredHeight);
        }
    }

    public void setDividerColor(@ColorInt int i4) {
        if (this.f3381c != i4) {
            this.f3381c = i4;
            this.f3379a.o(ColorStateList.valueOf(i4));
            invalidate();
        }
    }

    public void setDividerColorResource(@ColorRes int i4) {
        Context context = getContext();
        Object obj = e.f7215a;
        setDividerColor(d.a(context, i4));
    }

    public void setDividerInsetEnd(@Px int i4) {
        this.f3383e = i4;
    }

    public void setDividerInsetEndResource(@DimenRes int i4) {
        setDividerInsetEnd(getContext().getResources().getDimensionPixelOffset(i4));
    }

    public void setDividerInsetStart(@Px int i4) {
        this.f3382d = i4;
    }

    public void setDividerInsetStartResource(@DimenRes int i4) {
        setDividerInsetStart(getContext().getResources().getDimensionPixelOffset(i4));
    }

    public void setDividerThickness(@Px int i4) {
        if (this.f3380b != i4) {
            this.f3380b = i4;
            requestLayout();
        }
    }

    public void setDividerThicknessResource(@DimenRes int i4) {
        setDividerThickness(getContext().getResources().getDimensionPixelSize(i4));
    }

    public MaterialDivider(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.materialDividerStyle);
    }

    public MaterialDivider(@NonNull Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(a.a(context, attributeSet, i4, 2131756075), attributeSet, i4);
        Context context2 = getContext();
        this.f3379a = new j();
        TypedArray d4 = com.google.android.material.internal.h0.d(context2, attributeSet, o1.a.E, i4, 2131756075, new int[0]);
        this.f3380b = d4.getDimensionPixelSize(3, getResources().getDimensionPixelSize(R.dimen.material_divider_thickness));
        this.f3382d = d4.getDimensionPixelOffset(2, 0);
        this.f3383e = d4.getDimensionPixelOffset(1, 0);
        setDividerColor(i2.d.a(context2, d4, 0).getDefaultColor());
        d4.recycle();
    }
}