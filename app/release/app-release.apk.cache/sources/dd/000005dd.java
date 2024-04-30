package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import androidx.appcompat.widget.c0;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.b;
import com.example.msphone.R;
import i0.g0;
import i0.y0;
import java.util.HashMap;
import java.util.WeakHashMap;
import p1.f;

@Deprecated
/* loaded from: classes.dex */
public class FabTransformationSheetBehavior extends FabTransformationBehavior {

    /* renamed from: i  reason: collision with root package name */
    public HashMap f4174i;

    public FabTransformationSheetBehavior() {
    }

    @Override // com.google.android.material.transformation.FabTransformationBehavior
    public final c0 D(Context context, boolean z4) {
        int i4;
        if (z4) {
            i4 = R.animator.mtrl_fab_transformation_sheet_expand_spec;
        } else {
            i4 = R.animator.mtrl_fab_transformation_sheet_collapse_spec;
        }
        c0 c0Var = new c0(13);
        c0Var.f725b = f.b(context, i4);
        c0Var.f726c = new Object();
        return c0Var;
    }

    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior, com.google.android.material.transformation.ExpandableBehavior
    public final void w(View view, View view2, boolean z4, boolean z5) {
        boolean z6;
        int i4;
        ViewParent parent = view2.getParent();
        if (parent instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount();
            if (z4) {
                this.f4174i = new HashMap(childCount);
            }
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = coordinatorLayout.getChildAt(i5);
                if ((childAt.getLayoutParams() instanceof b) && (((b) childAt.getLayoutParams()).f1347a instanceof FabTransformationScrimBehavior)) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                if (childAt != view2 && !z6) {
                    HashMap hashMap = this.f4174i;
                    if (!z4) {
                        if (hashMap != null && hashMap.containsKey(childAt)) {
                            i4 = ((Integer) this.f4174i.get(childAt)).intValue();
                            WeakHashMap weakHashMap = y0.f4999a;
                        }
                    } else {
                        hashMap.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                        WeakHashMap weakHashMap2 = y0.f4999a;
                        i4 = 4;
                    }
                    g0.s(childAt, i4);
                }
            }
            if (!z4) {
                this.f4174i = null;
            }
        }
        super.w(view, view2, z4, z5);
    }

    public FabTransformationSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}