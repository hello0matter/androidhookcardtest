package com.google.android.material.snackbar;

import android.view.MotionEvent;
import android.view.View;
import androidx.activity.j;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.behavior.SwipeDismissBehavior;
import n2.b;
import p.d;

/* loaded from: classes.dex */
public class BaseTransientBottomBar$Behavior extends SwipeDismissBehavior<View> {

    /* renamed from: i  reason: collision with root package name */
    public final b f3884i;

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, n2.b] */
    public BaseTransientBottomBar$Behavior() {
        ?? obj = new Object();
        this.f3014f = Math.min(Math.max(0.0f, 0.1f), 1.0f);
        this.f3015g = Math.min(Math.max(0.0f, 0.6f), 1.0f);
        this.f3012d = 0;
        this.f3884i = obj;
    }

    @Override // com.google.android.material.behavior.SwipeDismissBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean k(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        this.f3884i.getClass();
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked == 1 || actionMasked == 3) {
                if (d.f6073e == null) {
                    d.f6073e = new d(3);
                }
                d dVar = d.f6073e;
                synchronized (dVar.f6074a) {
                    j.f(dVar.f6076c);
                }
            }
        } else if (coordinatorLayout.t(view, (int) motionEvent.getX(), (int) motionEvent.getY())) {
            if (d.f6073e == null) {
                d.f6073e = new d(3);
            }
            d dVar2 = d.f6073e;
            synchronized (dVar2.f6074a) {
                j.f(dVar2.f6076c);
            }
        }
        return super.k(coordinatorLayout, view, motionEvent);
    }

    @Override // com.google.android.material.behavior.SwipeDismissBehavior
    public final boolean w(View view) {
        this.f3884i.getClass();
        return view instanceof BaseTransientBottomBar$SnackbarBaseLayout;
    }
}