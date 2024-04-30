package com.google.android.material.tabs;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.google.android.material.internal.n0;
import com.google.android.material.tabs.TabLayout;

/* loaded from: classes.dex */
public class a {
    public static RectF a(TabLayout tabLayout, View view) {
        if (view == null) {
            return new RectF();
        }
        if (!tabLayout.E && (view instanceof TabLayout.TabView)) {
            TabLayout.TabView tabView = (TabLayout.TabView) view;
            int contentWidth = tabView.getContentWidth();
            int contentHeight = tabView.getContentHeight();
            int c4 = (int) n0.c(tabView.getContext(), 24);
            if (contentWidth < c4) {
                contentWidth = c4;
            }
            int right = (tabView.getRight() + tabView.getLeft()) / 2;
            int bottom = (tabView.getBottom() + tabView.getTop()) / 2;
            int i4 = contentWidth / 2;
            return new RectF(right - i4, bottom - (contentHeight / 2), i4 + right, (right / 2) + bottom);
        }
        return new RectF(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
    }

    public void b(TabLayout tabLayout, View view, View view2, float f4, Drawable drawable) {
        RectF a5 = a(tabLayout, view);
        RectF a6 = a(tabLayout, view2);
        drawable.setBounds(p1.a.c((int) a5.left, f4, (int) a6.left), drawable.getBounds().top, p1.a.c((int) a5.right, f4, (int) a6.right), drawable.getBounds().bottom);
    }
}