package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ViewOffsetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {

    /* renamed from: a  reason: collision with root package name */
    public m f2947a;

    /* renamed from: b  reason: collision with root package name */
    public int f2948b;

    public ViewOffsetBehavior() {
        this.f2948b = 0;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean l(CoordinatorLayout coordinatorLayout, View view, int i4) {
        y(coordinatorLayout, view, i4);
        if (this.f2947a == null) {
            this.f2947a = new m(view);
        }
        m mVar = this.f2947a;
        View view2 = mVar.f2969a;
        mVar.f2970b = view2.getTop();
        mVar.f2971c = view2.getLeft();
        this.f2947a.a();
        int i5 = this.f2948b;
        if (i5 != 0) {
            this.f2947a.b(i5);
            this.f2948b = 0;
            return true;
        }
        return true;
    }

    public int w() {
        m mVar = this.f2947a;
        if (mVar != null) {
            return mVar.f2972d;
        }
        return 0;
    }

    public int x() {
        return w();
    }

    public void y(CoordinatorLayout coordinatorLayout, View view, int i4) {
        coordinatorLayout.v(i4, view);
    }

    public boolean z(int i4) {
        m mVar = this.f2947a;
        if (mVar != null) {
            return mVar.b(i4);
        }
        this.f2948b = i4;
        return false;
    }

    public ViewOffsetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2948b = 0;
    }
}