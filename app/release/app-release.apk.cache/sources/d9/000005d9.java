package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import c2.a;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import i0.j0;
import i0.y0;
import java.util.ArrayList;
import java.util.WeakHashMap;

@Deprecated
/* loaded from: classes.dex */
public abstract class ExpandableBehavior extends CoordinatorLayout.Behavior<View> {

    /* renamed from: a  reason: collision with root package name */
    public int f4164a;

    public ExpandableBehavior() {
        this.f4164a = 0;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public abstract boolean f(View view, View view2);

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean h(CoordinatorLayout coordinatorLayout, View view, View view2) {
        a aVar = (a) view2;
        boolean z4 = ((FloatingActionButton) aVar).f3415o.f4760a;
        int i4 = 2;
        int i5 = this.f4164a;
        if (z4) {
            if (i5 != 0 && i5 != 2) {
                return false;
            }
        } else if (i5 != 1) {
            return false;
        }
        if (z4) {
            i4 = 1;
        }
        this.f4164a = i4;
        w((View) aVar, view, z4, true);
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean l(CoordinatorLayout coordinatorLayout, View view, int i4) {
        a aVar;
        WeakHashMap weakHashMap = y0.f4999a;
        if (!j0.c(view)) {
            ArrayList o4 = coordinatorLayout.o(view);
            int size = o4.size();
            int i5 = 0;
            while (true) {
                if (i5 < size) {
                    View view2 = (View) o4.get(i5);
                    if (f(view, view2)) {
                        aVar = (a) view2;
                        break;
                    }
                    i5++;
                } else {
                    aVar = null;
                    break;
                }
            }
            if (aVar != null) {
                boolean z4 = ((FloatingActionButton) aVar).f3415o.f4760a;
                int i6 = 2;
                int i7 = this.f4164a;
                if (!z4 ? i7 == 1 : !(i7 != 0 && i7 != 2)) {
                    if (z4) {
                        i6 = 1;
                    }
                    this.f4164a = i6;
                    view.getViewTreeObserver().addOnPreDrawListener(new r2.a(this, view, i6, aVar));
                }
            }
        }
        return false;
    }

    public abstract void w(View view, View view2, boolean z4, boolean z5);

    public ExpandableBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4164a = 0;
    }
}