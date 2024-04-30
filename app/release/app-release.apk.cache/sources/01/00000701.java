package g2;

import android.view.View;
import com.example.msphone.R;
import com.google.android.material.navigation.NavigationBarItemView;

/* loaded from: classes.dex */
public final class a extends NavigationBarItemView {
    @Override // com.google.android.material.navigation.NavigationBarItemView
    public final int getItemDefaultMarginResId() {
        return R.dimen.mtrl_navigation_rail_icon_margin;
    }

    @Override // com.google.android.material.navigation.NavigationBarItemView
    public final int getItemLayoutResId() {
        return R.layout.mtrl_navigation_rail_item;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i4, int i5) {
        super.onMeasure(i4, i5);
        if (View.MeasureSpec.getMode(i5) == 0) {
            setMeasuredDimension(getMeasuredWidthAndState(), Math.max(getMeasuredHeight(), View.MeasureSpec.getSize(i5)));
        }
    }
}