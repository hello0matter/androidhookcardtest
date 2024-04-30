package com.google.android.material.navigationrail;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import com.google.android.material.navigation.NavigationBarItemView;
import com.google.android.material.navigation.NavigationBarMenuView;

@RestrictTo({RestrictTo.Scope.f170b})
/* loaded from: classes.dex */
public class NavigationRailMenuView extends NavigationBarMenuView {
    public int H;
    public final FrameLayout.LayoutParams I;

    public NavigationRailMenuView(@NonNull Context context) {
        super(context);
        this.H = -1;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        this.I = layoutParams;
        layoutParams.gravity = 49;
        setLayoutParams(layoutParams);
        setItemActiveIndicatorResizeable(true);
    }

    @Override // com.google.android.material.navigation.NavigationBarMenuView
    public final NavigationBarItemView e(Context context) {
        return new NavigationBarItemView(context);
    }

    public final int g(View view, int i4, int i5, int i6) {
        int makeMeasureSpec;
        int i7;
        if (view == null) {
            int max = i5 / Math.max(1, i6);
            int i8 = this.H;
            if (i8 == -1) {
                i8 = View.MeasureSpec.getSize(i4);
            }
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(Math.min(i8, max), 0);
        } else {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(view.getMeasuredHeight(), 0);
        }
        int childCount = getChildCount();
        int i9 = 0;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt != view) {
                if (childAt.getVisibility() != 8) {
                    childAt.measure(i4, makeMeasureSpec);
                    i7 = childAt.getMeasuredHeight();
                } else {
                    i7 = 0;
                }
                i9 += i7;
            }
        }
        return i9;
    }

    @Px
    public int getItemMinimumHeight() {
        return this.H;
    }

    public int getMenuGravity() {
        return this.I.gravity;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z4, int i4, int i5, int i6, int i7) {
        int childCount = getChildCount();
        int i8 = i6 - i4;
        int i9 = 0;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() != 8) {
                int measuredHeight = childAt.getMeasuredHeight() + i9;
                childAt.layout(0, i9, i8, measuredHeight);
                i9 = measuredHeight;
            }
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i4, int i5) {
        int g4;
        int i6;
        int size = View.MeasureSpec.getSize(i5);
        int size2 = getMenu().l().size();
        if (size2 > 1 && NavigationBarMenuView.f(getLabelVisibilityMode(), size2)) {
            View childAt = getChildAt(getSelectedItemPosition());
            if (childAt != null) {
                int max = size / Math.max(1, size2);
                int i7 = this.H;
                if (i7 == -1) {
                    i7 = View.MeasureSpec.getSize(i4);
                }
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(Math.min(i7, max), 0);
                if (childAt.getVisibility() != 8) {
                    childAt.measure(i4, makeMeasureSpec);
                    i6 = childAt.getMeasuredHeight();
                } else {
                    i6 = 0;
                }
                size -= i6;
                size2--;
            } else {
                i6 = 0;
            }
            g4 = g(childAt, i4, size, size2) + i6;
        } else {
            g4 = g(null, i4, size, size2);
        }
        setMeasuredDimension(View.MeasureSpec.getSize(i4), View.resolveSizeAndState(g4, i5, 0));
    }

    public void setItemMinimumHeight(@Px int i4) {
        if (this.H != i4) {
            this.H = i4;
            requestLayout();
        }
    }

    public void setMenuGravity(int i4) {
        FrameLayout.LayoutParams layoutParams = this.I;
        if (layoutParams.gravity != i4) {
            layoutParams.gravity = i4;
            setLayoutParams(layoutParams);
        }
    }
}