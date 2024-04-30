package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.example.msphone.R;
import com.google.android.material.navigation.NavigationBarItemView;
import com.google.android.material.navigation.NavigationBarMenuView;
import g.p;
import i0.h0;
import i0.y0;
import java.util.ArrayList;
import java.util.WeakHashMap;

@RestrictTo({RestrictTo.Scope.f170b})
/* loaded from: classes.dex */
public class BottomNavigationMenuView extends NavigationBarMenuView {
    public final int H;
    public final int I;
    public final int J;
    public final int K;
    public boolean L;
    public final ArrayList M;

    public BottomNavigationMenuView(@NonNull Context context) {
        super(context);
        this.M = new ArrayList();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        setLayoutParams(layoutParams);
        Resources resources = getResources();
        this.H = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_item_max_width);
        this.I = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_item_min_width);
        this.J = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_active_item_max_width);
        this.K = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_active_item_min_width);
    }

    @Override // com.google.android.material.navigation.NavigationBarMenuView
    public final NavigationBarItemView e(Context context) {
        return new BottomNavigationItemView(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z4, int i4, int i5, int i6, int i7) {
        int childCount = getChildCount();
        int i8 = i6 - i4;
        int i9 = i7 - i5;
        int i10 = 0;
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() != 8) {
                WeakHashMap weakHashMap = y0.f4999a;
                if (h0.d(this) == 1) {
                    int i12 = i8 - i10;
                    childAt.layout(i12 - childAt.getMeasuredWidth(), 0, i12, i9);
                } else {
                    childAt.layout(i10, 0, childAt.getMeasuredWidth() + i10, i9);
                }
                i10 += childAt.getMeasuredWidth();
            }
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i4, int i5) {
        int i6;
        int i7;
        int i8;
        p menu = getMenu();
        int size = View.MeasureSpec.getSize(i4);
        int size2 = menu.l().size();
        int childCount = getChildCount();
        ArrayList arrayList = this.M;
        arrayList.clear();
        int size3 = View.MeasureSpec.getSize(i5);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size3, 1073741824);
        boolean f4 = NavigationBarMenuView.f(getLabelVisibilityMode(), size2);
        int i9 = this.J;
        int i10 = 1;
        if (f4 && this.L) {
            View childAt = getChildAt(getSelectedItemPosition());
            int visibility = childAt.getVisibility();
            int i11 = this.K;
            if (visibility != 8) {
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i9, Integer.MIN_VALUE), makeMeasureSpec);
                i11 = Math.max(i11, childAt.getMeasuredWidth());
            }
            if (childAt.getVisibility() != 8) {
                i7 = 1;
            } else {
                i7 = 0;
            }
            int i12 = size2 - i7;
            int min = Math.min(size - (this.I * i12), Math.min(i11, i9));
            int i13 = size - min;
            if (i12 != 0) {
                i10 = i12;
            }
            int min2 = Math.min(i13 / i10, this.H);
            int i14 = i13 - (i12 * min2);
            for (int i15 = 0; i15 < childCount; i15++) {
                if (getChildAt(i15).getVisibility() != 8) {
                    if (i15 == getSelectedItemPosition()) {
                        i8 = min;
                    } else {
                        i8 = min2;
                    }
                    if (i14 > 0) {
                        i8++;
                        i14--;
                    }
                } else {
                    i8 = 0;
                }
                arrayList.add(Integer.valueOf(i8));
            }
        } else {
            if (size2 != 0) {
                i10 = size2;
            }
            int min3 = Math.min(size / i10, i9);
            int i16 = size - (size2 * min3);
            for (int i17 = 0; i17 < childCount; i17++) {
                if (getChildAt(i17).getVisibility() != 8) {
                    if (i16 > 0) {
                        i6 = min3 + 1;
                        i16--;
                    } else {
                        i6 = min3;
                    }
                } else {
                    i6 = 0;
                }
                arrayList.add(Integer.valueOf(i6));
            }
        }
        int i18 = 0;
        for (int i19 = 0; i19 < childCount; i19++) {
            View childAt2 = getChildAt(i19);
            if (childAt2.getVisibility() != 8) {
                childAt2.measure(View.MeasureSpec.makeMeasureSpec(((Integer) arrayList.get(i19)).intValue(), 1073741824), makeMeasureSpec);
                childAt2.getLayoutParams().width = childAt2.getMeasuredWidth();
                i18 = childAt2.getMeasuredWidth() + i18;
            }
        }
        setMeasuredDimension(i18, size3);
    }

    public void setItemHorizontalTranslationEnabled(boolean z4) {
        this.L = z4;
    }
}