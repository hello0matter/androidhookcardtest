package com.google.android.material.internal;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public class BaselineLayout extends ViewGroup {

    /* renamed from: a  reason: collision with root package name */
    public int f3437a;

    public BaselineLayout(Context context) {
        super(context, null, 0);
        this.f3437a = -1;
    }

    @Override // android.view.View
    public int getBaseline() {
        return this.f3437a;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z4, int i4, int i5, int i6, int i7) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingRight = ((i6 - i4) - getPaddingRight()) - paddingLeft;
        int paddingTop = getPaddingTop();
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i9 = ((paddingRight - measuredWidth) / 2) + paddingLeft;
                int baseline = (this.f3437a == -1 || childAt.getBaseline() == -1) ? paddingTop : (this.f3437a + paddingTop) - childAt.getBaseline();
                childAt.layout(i9, baseline, measuredWidth + i9, measuredHeight + baseline);
            }
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i4, int i5) {
        int childCount = getChildCount();
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = -1;
        int i10 = -1;
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() != 8) {
                measureChild(childAt, i4, i5);
                int baseline = childAt.getBaseline();
                if (baseline != -1) {
                    i9 = Math.max(i9, baseline);
                    i10 = Math.max(i10, childAt.getMeasuredHeight() - baseline);
                }
                i7 = Math.max(i7, childAt.getMeasuredWidth());
                i6 = Math.max(i6, childAt.getMeasuredHeight());
                i8 = View.combineMeasuredStates(i8, childAt.getMeasuredState());
            }
        }
        if (i9 != -1) {
            i6 = Math.max(i6, Math.max(i10, getPaddingBottom()) + i9);
            this.f3437a = i9;
        }
        setMeasuredDimension(View.resolveSizeAndState(Math.max(i7, getSuggestedMinimumWidth()), i4, i8), View.resolveSizeAndState(Math.max(i6, getSuggestedMinimumHeight()), i5, i8 << 16));
    }

    public BaselineLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f3437a = -1;
    }

    public BaselineLayout(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f3437a = -1;
    }
}