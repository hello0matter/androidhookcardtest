package com.google.android.material.navigationrail;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.appcompat.widget.q3;
import com.example.msphone.R;
import com.google.android.material.internal.h0;
import com.google.android.material.internal.n0;
import com.google.android.material.navigation.NavigationBarMenuView;
import com.google.android.material.navigation.NavigationBarView;
import o1.a;
import w1.g;

/* loaded from: classes.dex */
public class NavigationRailView extends NavigationBarView {

    /* renamed from: f  reason: collision with root package name */
    public final int f3699f;

    /* renamed from: g  reason: collision with root package name */
    public final View f3700g;

    /* renamed from: h  reason: collision with root package name */
    public final Boolean f3701h;

    /* renamed from: i  reason: collision with root package name */
    public final Boolean f3702i;

    /* renamed from: j  reason: collision with root package name */
    public final Boolean f3703j;

    public NavigationRailView(@NonNull Context context) {
        this(context, null);
    }

    private NavigationRailMenuView getNavigationRailMenuView() {
        return (NavigationRailMenuView) getMenuView();
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    public final NavigationBarMenuView a(Context context) {
        return new NavigationRailMenuView(context);
    }

    @Nullable
    public View getHeaderView() {
        return this.f3700g;
    }

    public int getItemMinimumHeight() {
        return ((NavigationRailMenuView) getMenuView()).getItemMinimumHeight();
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    public int getMaxItemCount() {
        return 7;
    }

    public int getMenuGravity() {
        return getNavigationRailMenuView().getMenuGravity();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z4, int i4, int i5, int i6, int i7) {
        boolean z5;
        super.onLayout(z4, i4, i5, i6, i7);
        NavigationRailMenuView navigationRailMenuView = getNavigationRailMenuView();
        View view = this.f3700g;
        int i8 = 0;
        if (view != null && view.getVisibility() != 8) {
            z5 = true;
        } else {
            z5 = false;
        }
        int i9 = this.f3699f;
        if (z5) {
            int bottom = this.f3700g.getBottom() + i9;
            int top = navigationRailMenuView.getTop();
            if (top < bottom) {
                i8 = bottom - top;
            }
        } else if ((navigationRailMenuView.I.gravity & 112) == 48) {
            i8 = i9;
        }
        if (i8 > 0) {
            navigationRailMenuView.layout(navigationRailMenuView.getLeft(), navigationRailMenuView.getTop() + i8, navigationRailMenuView.getRight(), navigationRailMenuView.getBottom() + i8);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i4, int i5) {
        int suggestedMinimumWidth = getSuggestedMinimumWidth();
        if (View.MeasureSpec.getMode(i4) != 1073741824 && suggestedMinimumWidth > 0) {
            int paddingLeft = getPaddingLeft();
            i4 = View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i4), getPaddingRight() + paddingLeft + suggestedMinimumWidth), 1073741824);
        }
        super.onMeasure(i4, i5);
        View view = this.f3700g;
        if (view != null && view.getVisibility() != 8) {
            measureChild(getNavigationRailMenuView(), i4, View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - this.f3700g.getMeasuredHeight()) - this.f3699f, Integer.MIN_VALUE));
        }
    }

    public void setItemMinimumHeight(@Px int i4) {
        ((NavigationRailMenuView) getMenuView()).setItemMinimumHeight(i4);
    }

    public void setMenuGravity(int i4) {
        getNavigationRailMenuView().setMenuGravity(i4);
    }

    public NavigationRailView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.navigationRailStyle);
    }

    public NavigationRailView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4, 2131756076);
        this.f3701h = null;
        this.f3702i = null;
        this.f3703j = null;
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.mtrl_navigation_rail_margin);
        this.f3699f = dimensionPixelSize;
        Context context2 = getContext();
        q3 e4 = h0.e(context2, attributeSet, a.N, i4, 2131756076, new int[0]);
        TypedArray typedArray = e4.f879b;
        int resourceId = typedArray.getResourceId(0, 0);
        if (resourceId != 0) {
            View inflate = LayoutInflater.from(getContext()).inflate(resourceId, (ViewGroup) this, false);
            View view = this.f3700g;
            if (view != null) {
                removeView(view);
                this.f3700g = null;
            }
            this.f3700g = inflate;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 49;
            layoutParams.topMargin = dimensionPixelSize;
            addView(inflate, 0, layoutParams);
        }
        setMenuGravity(typedArray.getInt(2, 49));
        if (typedArray.hasValue(1)) {
            setItemMinimumHeight(typedArray.getDimensionPixelSize(1, -1));
        }
        if (typedArray.hasValue(5)) {
            this.f3701h = Boolean.valueOf(typedArray.getBoolean(5, false));
        }
        if (typedArray.hasValue(3)) {
            this.f3702i = Boolean.valueOf(typedArray.getBoolean(3, false));
        }
        if (typedArray.hasValue(4)) {
            this.f3703j = Boolean.valueOf(typedArray.getBoolean(4, false));
        }
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.m3_navigation_rail_item_padding_top_with_large_font);
        int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(R.dimen.m3_navigation_rail_item_padding_bottom_with_large_font);
        float b5 = p1.a.b(0.0f, 1.0f, 0.3f, 1.0f, context2.getResources().getConfiguration().fontScale - 1.0f);
        setItemPaddingTop(Math.round(p1.a.c(getItemPaddingTop(), b5, dimensionPixelOffset)));
        setItemPaddingBottom(Math.round(p1.a.c(getItemPaddingBottom(), b5, dimensionPixelOffset2)));
        e4.g();
        n0.b(this, new g(8, this));
    }
}