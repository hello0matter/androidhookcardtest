package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.o0;
import androidx.appcompat.widget.q3;
import com.example.msphone.R;
import com.google.android.material.internal.h0;
import com.google.android.material.internal.n0;
import com.google.android.material.navigation.NavigationBarMenuView;
import com.google.android.material.navigation.NavigationBarView;
import s1.a;
import s1.b;

/* loaded from: classes.dex */
public class BottomNavigationView extends NavigationBarView {
    public BottomNavigationView(@NonNull Context context) {
        this(context, null);
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    public final NavigationBarMenuView a(Context context) {
        return new BottomNavigationMenuView(context);
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    public int getMaxItemCount() {
        return 5;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i4, int i5) {
        int suggestedMinimumHeight = getSuggestedMinimumHeight();
        if (View.MeasureSpec.getMode(i5) != 1073741824 && suggestedMinimumHeight > 0) {
            int paddingTop = getPaddingTop();
            i5 = View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i5), getPaddingBottom() + paddingTop + suggestedMinimumHeight), 1073741824);
        }
        super.onMeasure(i4, i5);
    }

    public void setItemHorizontalTranslationEnabled(boolean z4) {
        BottomNavigationMenuView bottomNavigationMenuView = (BottomNavigationMenuView) getMenuView();
        if (bottomNavigationMenuView.L != z4) {
            bottomNavigationMenuView.setItemHorizontalTranslationEnabled(z4);
            getPresenter().m(false);
        }
    }

    @Deprecated
    public void setOnNavigationItemReselectedListener(@Nullable a aVar) {
        setOnItemReselectedListener(aVar);
    }

    @Deprecated
    public void setOnNavigationItemSelectedListener(@Nullable b bVar) {
        setOnItemSelectedListener(bVar);
    }

    public BottomNavigationView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.bottomNavigationStyle);
    }

    public BottomNavigationView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4, 2131755824);
        q3 e4 = h0.e(getContext(), attributeSet, o1.a.f5946f, i4, 2131755824, new int[0]);
        TypedArray typedArray = e4.f879b;
        setItemHorizontalTranslationEnabled(typedArray.getBoolean(2, true));
        if (typedArray.hasValue(0)) {
            setMinimumHeight(typedArray.getDimensionPixelSize(0, 0));
        }
        typedArray.getBoolean(1, true);
        e4.g();
        n0.b(this, new o0(28, this));
    }
}