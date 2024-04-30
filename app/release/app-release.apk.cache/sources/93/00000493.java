package com.google.android.material.appbar;

import android.view.View;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import i0.g0;
import i0.y0;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class l implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final CoordinatorLayout f2966a;

    /* renamed from: b  reason: collision with root package name */
    public final View f2967b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ HeaderBehavior f2968c;

    public l(HeaderBehavior headerBehavior, CoordinatorLayout coordinatorLayout, View view) {
        this.f2968c = headerBehavior;
        this.f2966a = coordinatorLayout;
        this.f2967b = view;
    }

    @Override // java.lang.Runnable
    public final void run() {
        HeaderBehavior headerBehavior;
        OverScroller overScroller;
        View view = this.f2967b;
        if (view != null && (overScroller = (headerBehavior = this.f2968c).f2935d) != null) {
            boolean computeScrollOffset = overScroller.computeScrollOffset();
            CoordinatorLayout coordinatorLayout = this.f2966a;
            if (computeScrollOffset) {
                headerBehavior.F(coordinatorLayout, view, headerBehavior.f2935d.getCurrY());
                WeakHashMap weakHashMap = y0.f4999a;
                g0.m(view, this);
                return;
            }
            headerBehavior.D(view, coordinatorLayout);
        }
    }
}