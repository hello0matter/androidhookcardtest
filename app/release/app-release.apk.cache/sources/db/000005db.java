package com.google.android.material.transformation;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.View;
import androidx.appcompat.widget.c0;
import androidx.coordinatorlayout.widget.b;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import p1.a;
import p1.f;
import p1.g;
import p1.h;

@Deprecated
/* loaded from: classes.dex */
public abstract class FabTransformationBehavior extends ExpandableTransformationBehavior {

    /* renamed from: c  reason: collision with root package name */
    public final Rect f4166c;

    /* renamed from: d  reason: collision with root package name */
    public final RectF f4167d;

    /* renamed from: e  reason: collision with root package name */
    public final RectF f4168e;

    /* renamed from: f  reason: collision with root package name */
    public final int[] f4169f;

    /* renamed from: g  reason: collision with root package name */
    public float f4170g;

    /* renamed from: h  reason: collision with root package name */
    public float f4171h;

    public FabTransformationBehavior() {
        this.f4166c = new Rect();
        this.f4167d = new RectF();
        this.f4168e = new RectF();
        this.f4169f = new int[2];
    }

    public static float B(c0 c0Var, g gVar, float f4) {
        long j4 = gVar.f6138a;
        g f5 = ((f) c0Var.f725b).f("expansion");
        return a.a(f4, 0.0f, gVar.b().getInterpolation(((float) (((f5.f6138a + f5.f6139b) + 17) - j4)) / ((float) gVar.f6139b)));
    }

    public static Pair y(float f4, float f5, boolean z4, c0 c0Var) {
        g f6;
        f fVar;
        String str;
        int i4;
        if (f4 != 0.0f && f5 != 0.0f) {
            if ((z4 && f5 < 0.0f) || (!z4 && i4 > 0)) {
                f6 = ((f) c0Var.f725b).f("translationXCurveUpwards");
                fVar = (f) c0Var.f725b;
                str = "translationYCurveUpwards";
            } else {
                f6 = ((f) c0Var.f725b).f("translationXCurveDownwards");
                fVar = (f) c0Var.f725b;
                str = "translationYCurveDownwards";
            }
        } else {
            f6 = ((f) c0Var.f725b).f("translationXLinear");
            fVar = (f) c0Var.f725b;
            str = "translationYLinear";
        }
        return new Pair(f6, fVar.f(str));
    }

    public final float A(View view, View view2, h hVar) {
        RectF rectF = this.f4167d;
        RectF rectF2 = this.f4168e;
        C(view, rectF);
        rectF.offset(this.f4170g, this.f4171h);
        C(view2, rectF2);
        hVar.getClass();
        return (rectF2.centerY() - rectF.centerY()) + 0.0f;
    }

    public final void C(View view, RectF rectF) {
        rectF.set(0.0f, 0.0f, view.getWidth(), view.getHeight());
        int[] iArr = this.f4169f;
        view.getLocationInWindow(iArr);
        rectF.offsetTo(iArr[0], iArr[1]);
        rectF.offset((int) (-view.getTranslationX()), (int) (-view.getTranslationY()));
    }

    public abstract c0 D(Context context, boolean z4);

    @Override // com.google.android.material.transformation.ExpandableBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean f(View view, View view2) {
        if (view.getVisibility() != 8) {
            if (!(view2 instanceof FloatingActionButton)) {
                return false;
            }
            int expandedComponentIdHint = ((FloatingActionButton) view2).getExpandedComponentIdHint();
            if (expandedComponentIdHint != 0 && expandedComponentIdHint != view.getId()) {
                return false;
            }
            return true;
        }
        throw new IllegalStateException("This behavior cannot be attached to a GONE view. Set the view to INVISIBLE instead.");
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void g(b bVar) {
        if (bVar.f1354h == 0) {
            bVar.f1354h = 80;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x03d9 A[LOOP:0: B:108:0x03d7->B:109:0x03d9, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x02f9  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x02fc  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0353  */
    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.animation.AnimatorSet x(android.view.View r26, android.view.View r27, boolean r28, boolean r29) {
        /*
            Method dump skipped, instructions count: 998
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.transformation.FabTransformationBehavior.x(android.view.View, android.view.View, boolean, boolean):android.animation.AnimatorSet");
    }

    public final float z(View view, View view2, h hVar) {
        RectF rectF = this.f4167d;
        RectF rectF2 = this.f4168e;
        C(view, rectF);
        rectF.offset(this.f4170g, this.f4171h);
        C(view2, rectF2);
        hVar.getClass();
        return (rectF2.centerX() - rectF.centerX()) + 0.0f;
    }

    public FabTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4166c = new Rect();
        this.f4167d = new RectF();
        this.f4168e = new RectF();
        this.f4169f = new int[2];
    }
}