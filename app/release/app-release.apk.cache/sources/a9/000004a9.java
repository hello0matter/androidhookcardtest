package com.google.android.material.bottomappbar;

import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import com.example.msphone.R;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.internal.n0;

/* loaded from: classes.dex */
public final class g implements View.OnLayoutChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BottomAppBar.Behavior f3059a;

    public g(BottomAppBar.Behavior behavior) {
        this.f3059a = behavior;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View view, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
        int leftInset;
        int rightInset;
        int bottomInset;
        BottomAppBar.Behavior behavior = this.f3059a;
        BottomAppBar bottomAppBar = (BottomAppBar) behavior.f3039k.get();
        if (bottomAppBar != null && ((view instanceof FloatingActionButton) || (view instanceof ExtendedFloatingActionButton))) {
            int height = view.getHeight();
            if (view instanceof FloatingActionButton) {
                FloatingActionButton floatingActionButton = (FloatingActionButton) view;
                int measuredWidth = floatingActionButton.getMeasuredWidth();
                int measuredHeight = floatingActionButton.getMeasuredHeight();
                Rect rect = behavior.f3038j;
                rect.set(0, 0, measuredWidth, measuredHeight);
                floatingActionButton.j(rect);
                int height2 = rect.height();
                bottomAppBar.J(height2);
                bottomAppBar.setFabCornerSize(floatingActionButton.getShapeAppearanceModel().f5352e.a(new RectF(rect)));
                height = height2;
            }
            androidx.coordinatorlayout.widget.b bVar = (androidx.coordinatorlayout.widget.b) view.getLayoutParams();
            if (behavior.f3040l == 0) {
                if (bottomAppBar.f3020c0 == 1) {
                    int dimensionPixelOffset = bottomAppBar.getResources().getDimensionPixelOffset(R.dimen.mtrl_bottomappbar_fab_bottom_margin) - ((view.getMeasuredHeight() - height) / 2);
                    bottomInset = bottomAppBar.getBottomInset();
                    ((ViewGroup.MarginLayoutParams) bVar).bottomMargin = bottomInset + dimensionPixelOffset;
                }
                leftInset = bottomAppBar.getLeftInset();
                ((ViewGroup.MarginLayoutParams) bVar).leftMargin = leftInset;
                rightInset = bottomAppBar.getRightInset();
                ((ViewGroup.MarginLayoutParams) bVar).rightMargin = rightInset;
                boolean f4 = n0.f(view);
                int i12 = bottomAppBar.f3021d0;
                if (f4) {
                    ((ViewGroup.MarginLayoutParams) bVar).leftMargin += i12;
                } else {
                    ((ViewGroup.MarginLayoutParams) bVar).rightMargin += i12;
                }
            }
            int i13 = BottomAppBar.f3017u0;
            bottomAppBar.I();
            return;
        }
        view.removeOnLayoutChangeListener(this);
    }
}