package com.google.android.material.appbar;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.search.SearchBar;
import i0.g0;
import i0.g2;
import i0.y0;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class HeaderScrollingViewBehavior extends ViewOffsetBehavior<View> {

    /* renamed from: c  reason: collision with root package name */
    public final Rect f2941c;

    /* renamed from: d  reason: collision with root package name */
    public final Rect f2942d;

    /* renamed from: e  reason: collision with root package name */
    public int f2943e;

    /* renamed from: f  reason: collision with root package name */
    public int f2944f;

    public HeaderScrollingViewBehavior() {
        this.f2941c = new Rect();
        this.f2942d = new Rect();
        this.f2943e = 0;
    }

    public abstract AppBarLayout A(ArrayList arrayList);

    public float B(View view) {
        return 1.0f;
    }

    public int C(View view) {
        return view.getMeasuredHeight();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean m(CoordinatorLayout coordinatorLayout, View view, int i4, int i5, int i6) {
        AppBarLayout A;
        int i7;
        g2 lastWindowInsets;
        int i8 = view.getLayoutParams().height;
        if ((i8 == -1 || i8 == -2) && (A = A(coordinatorLayout.o(view))) != null) {
            int size = View.MeasureSpec.getSize(i6);
            if (size > 0) {
                WeakHashMap weakHashMap = y0.f4999a;
                if (g0.b(A) && (lastWindowInsets = coordinatorLayout.getLastWindowInsets()) != null) {
                    size += lastWindowInsets.a() + lastWindowInsets.d();
                }
            } else {
                size = coordinatorLayout.getHeight();
            }
            int C = size + C(A);
            int measuredHeight = A.getMeasuredHeight();
            if (this instanceof SearchBar.ScrollingViewBehavior) {
                view.setTranslationY(-measuredHeight);
            } else {
                view.setTranslationY(0.0f);
                C -= measuredHeight;
            }
            if (i8 == -1) {
                i7 = 1073741824;
            } else {
                i7 = Integer.MIN_VALUE;
            }
            coordinatorLayout.w(view, i4, i5, View.MeasureSpec.makeMeasureSpec(C, i7));
            return true;
        }
        return false;
    }

    @Override // com.google.android.material.appbar.ViewOffsetBehavior
    public final void y(CoordinatorLayout coordinatorLayout, View view, int i4) {
        AppBarLayout A = A(coordinatorLayout.o(view));
        int i5 = 0;
        if (A != null) {
            androidx.coordinatorlayout.widget.b bVar = (androidx.coordinatorlayout.widget.b) view.getLayoutParams();
            int paddingLeft = coordinatorLayout.getPaddingLeft() + ((ViewGroup.MarginLayoutParams) bVar).leftMargin;
            int bottom = A.getBottom() + ((ViewGroup.MarginLayoutParams) bVar).topMargin;
            int width = (coordinatorLayout.getWidth() - coordinatorLayout.getPaddingRight()) - ((ViewGroup.MarginLayoutParams) bVar).rightMargin;
            int height = coordinatorLayout.getHeight();
            Rect rect = this.f2941c;
            rect.set(paddingLeft, bottom, width, ((A.getBottom() + height) - coordinatorLayout.getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) bVar).bottomMargin);
            g2 lastWindowInsets = coordinatorLayout.getLastWindowInsets();
            if (lastWindowInsets != null) {
                WeakHashMap weakHashMap = y0.f4999a;
                if (g0.b(coordinatorLayout) && !g0.b(view)) {
                    rect.left = lastWindowInsets.b() + rect.left;
                    rect.right -= lastWindowInsets.c();
                }
            }
            int i6 = bVar.f1349c;
            if (i6 == 0) {
                i6 = 8388659;
            }
            int i7 = i6;
            int measuredWidth = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            Rect rect2 = this.f2942d;
            i0.m.b(i7, measuredWidth, measuredHeight, rect, rect2, i4);
            if (this.f2944f != 0) {
                float B = B(A);
                int i8 = this.f2944f;
                i5 = com.google.common.collect.c.L((int) (B * i8), 0, i8);
            }
            view.layout(rect2.left, rect2.top - i5, rect2.right, rect2.bottom - i5);
            this.f2943e = rect2.top - A.getBottom();
            return;
        }
        coordinatorLayout.v(i4, view);
        this.f2943e = 0;
    }

    public HeaderScrollingViewBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2941c = new Rect();
        this.f2942d = new Rect();
        this.f2943e = 0;
    }
}