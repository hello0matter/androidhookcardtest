package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.example.msphone.R;
import i0.y0;
import java.util.WeakHashMap;

@RestrictTo({RestrictTo.Scope.f170b})
/* loaded from: classes.dex */
public class FlowLayout extends ViewGroup {

    /* renamed from: a  reason: collision with root package name */
    public int f3445a;

    /* renamed from: b  reason: collision with root package name */
    public int f3446b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f3447c;

    /* renamed from: d  reason: collision with root package name */
    public int f3448d;

    public FlowLayout(@NonNull Context context) {
        this(context, null);
    }

    public boolean a() {
        return this.f3447c;
    }

    public int getItemSpacing() {
        return this.f3446b;
    }

    public int getLineSpacing() {
        return this.f3445a;
    }

    public int getRowCount() {
        return this.f3448d;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z4, int i4, int i5, int i6, int i7) {
        boolean z5;
        int paddingLeft;
        int paddingRight;
        int i8;
        int i9;
        if (getChildCount() == 0) {
            this.f3448d = 0;
            return;
        }
        this.f3448d = 1;
        WeakHashMap weakHashMap = y0.f4999a;
        if (i0.h0.d(this) == 1) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (z5) {
            paddingLeft = getPaddingRight();
        } else {
            paddingLeft = getPaddingLeft();
        }
        if (z5) {
            paddingRight = getPaddingLeft();
        } else {
            paddingRight = getPaddingRight();
        }
        int paddingTop = getPaddingTop();
        int i10 = (i6 - i4) - paddingRight;
        int i11 = paddingLeft;
        int i12 = paddingTop;
        for (int i13 = 0; i13 < getChildCount(); i13++) {
            View childAt = getChildAt(i13);
            if (childAt.getVisibility() == 8) {
                childAt.setTag(R.id.row_index_key, -1);
            } else {
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    i9 = i0.p.c(marginLayoutParams);
                    i8 = i0.p.b(marginLayoutParams);
                } else {
                    i8 = 0;
                    i9 = 0;
                }
                int measuredWidth = childAt.getMeasuredWidth() + i11 + i9;
                if (!this.f3447c && measuredWidth > i10) {
                    i12 = this.f3445a + paddingTop;
                    this.f3448d++;
                    i11 = paddingLeft;
                }
                childAt.setTag(R.id.row_index_key, Integer.valueOf(this.f3448d - 1));
                int i14 = i11 + i9;
                int measuredWidth2 = childAt.getMeasuredWidth() + i14;
                int measuredHeight = childAt.getMeasuredHeight() + i12;
                if (z5) {
                    i14 = i10 - measuredWidth2;
                    measuredWidth2 = (i10 - i11) - i9;
                }
                childAt.layout(i14, i12, measuredWidth2, measuredHeight);
                i11 += childAt.getMeasuredWidth() + i9 + i8 + this.f3446b;
                paddingTop = measuredHeight;
            }
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i4, int i5) {
        int i6;
        int i7;
        int i8;
        int i9;
        int size = View.MeasureSpec.getSize(i4);
        int mode = View.MeasureSpec.getMode(i4);
        int size2 = View.MeasureSpec.getSize(i5);
        int mode2 = View.MeasureSpec.getMode(i5);
        if (mode != Integer.MIN_VALUE && mode != 1073741824) {
            i6 = Integer.MAX_VALUE;
        } else {
            i6 = size;
        }
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = i6 - getPaddingRight();
        int i10 = paddingTop;
        int i11 = 0;
        for (int i12 = 0; i12 < getChildCount(); i12++) {
            View childAt = getChildAt(i12);
            if (childAt.getVisibility() != 8) {
                measureChild(childAt, i4, i5);
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    i8 = marginLayoutParams.leftMargin;
                    i7 = marginLayoutParams.rightMargin;
                } else {
                    i7 = 0;
                    i8 = 0;
                }
                int i13 = paddingLeft;
                if (childAt.getMeasuredWidth() + paddingLeft + i8 > paddingRight && !a()) {
                    i9 = getPaddingLeft();
                    i10 = this.f3445a + paddingTop;
                } else {
                    i9 = i13;
                }
                int measuredWidth = childAt.getMeasuredWidth() + i9 + i8;
                int measuredHeight = childAt.getMeasuredHeight() + i10;
                if (measuredWidth > i11) {
                    i11 = measuredWidth;
                }
                int measuredWidth2 = childAt.getMeasuredWidth() + i8 + i7 + this.f3446b + i9;
                if (i12 == getChildCount() - 1) {
                    i11 += i7;
                }
                paddingLeft = measuredWidth2;
                paddingTop = measuredHeight;
            }
        }
        int paddingRight2 = getPaddingRight() + i11;
        int paddingBottom = getPaddingBottom() + paddingTop;
        if (mode != Integer.MIN_VALUE) {
            if (mode != 1073741824) {
                size = paddingRight2;
            }
        } else {
            size = Math.min(paddingRight2, size);
        }
        if (mode2 != Integer.MIN_VALUE) {
            if (mode2 != 1073741824) {
                size2 = paddingBottom;
            }
        } else {
            size2 = Math.min(paddingBottom, size2);
        }
        setMeasuredDimension(size, size2);
    }

    public void setItemSpacing(int i4) {
        this.f3446b = i4;
    }

    public void setLineSpacing(int i4) {
        this.f3445a = i4;
    }

    public void setSingleLine(boolean z4) {
        this.f3447c = z4;
    }

    public FlowLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FlowLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f3447c = false;
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, o1.a.f5963t, 0, 0);
        this.f3445a = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        this.f3446b = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        obtainStyledAttributes.recycle();
    }
}