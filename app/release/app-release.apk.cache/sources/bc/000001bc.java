package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.HashMap;
import t.e;
import t.k;

/* loaded from: classes.dex */
public class Constraints extends ViewGroup {

    /* renamed from: a  reason: collision with root package name */
    public d f1284a;

    /* loaded from: classes.dex */
    public static class LayoutParams extends ConstraintLayout.LayoutParams {

        /* renamed from: m0  reason: collision with root package name */
        public final float f1285m0;

        /* renamed from: n0  reason: collision with root package name */
        public final boolean f1286n0;

        /* renamed from: o0  reason: collision with root package name */
        public final float f1287o0;

        /* renamed from: p0  reason: collision with root package name */
        public final float f1288p0;

        /* renamed from: q0  reason: collision with root package name */
        public final float f1289q0;

        /* renamed from: r0  reason: collision with root package name */
        public final float f1290r0;

        /* renamed from: s0  reason: collision with root package name */
        public final float f1291s0;

        /* renamed from: t0  reason: collision with root package name */
        public final float f1292t0;

        /* renamed from: u0  reason: collision with root package name */
        public final float f1293u0;

        /* renamed from: v0  reason: collision with root package name */
        public final float f1294v0;

        /* renamed from: w0  reason: collision with root package name */
        public final float f1295w0;

        /* renamed from: x0  reason: collision with root package name */
        public final float f1296x0;

        /* renamed from: y0  reason: collision with root package name */
        public final float f1297y0;

        public LayoutParams() {
            this.f1285m0 = 1.0f;
            this.f1286n0 = false;
            this.f1287o0 = 0.0f;
            this.f1288p0 = 0.0f;
            this.f1289q0 = 0.0f;
            this.f1290r0 = 0.0f;
            this.f1291s0 = 1.0f;
            this.f1292t0 = 1.0f;
            this.f1293u0 = 0.0f;
            this.f1294v0 = 0.0f;
            this.f1295w0 = 0.0f;
            this.f1296x0 = 0.0f;
            this.f1297y0 = 0.0f;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f1285m0 = 1.0f;
            this.f1286n0 = false;
            this.f1287o0 = 0.0f;
            this.f1288p0 = 0.0f;
            this.f1289q0 = 0.0f;
            this.f1290r0 = 0.0f;
            this.f1291s0 = 1.0f;
            this.f1292t0 = 1.0f;
            this.f1293u0 = 0.0f;
            this.f1294v0 = 0.0f;
            this.f1295w0 = 0.0f;
            this.f1296x0 = 0.0f;
            this.f1297y0 = 0.0f;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.f6651d);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i4 = 0; i4 < indexCount; i4++) {
                int index = obtainStyledAttributes.getIndex(i4);
                if (index == 15) {
                    this.f1285m0 = obtainStyledAttributes.getFloat(index, this.f1285m0);
                } else if (index == 28) {
                    this.f1287o0 = obtainStyledAttributes.getFloat(index, this.f1287o0);
                    this.f1286n0 = true;
                } else if (index == 23) {
                    this.f1289q0 = obtainStyledAttributes.getFloat(index, this.f1289q0);
                } else if (index == 24) {
                    this.f1290r0 = obtainStyledAttributes.getFloat(index, this.f1290r0);
                } else if (index == 22) {
                    this.f1288p0 = obtainStyledAttributes.getFloat(index, this.f1288p0);
                } else if (index == 20) {
                    this.f1291s0 = obtainStyledAttributes.getFloat(index, this.f1291s0);
                } else if (index == 21) {
                    this.f1292t0 = obtainStyledAttributes.getFloat(index, this.f1292t0);
                } else if (index == 16) {
                    this.f1293u0 = obtainStyledAttributes.getFloat(index, this.f1293u0);
                } else if (index == 17) {
                    this.f1294v0 = obtainStyledAttributes.getFloat(index, this.f1294v0);
                } else if (index == 18) {
                    this.f1295w0 = obtainStyledAttributes.getFloat(index, this.f1295w0);
                } else if (index == 19) {
                    this.f1296x0 = obtainStyledAttributes.getFloat(index, this.f1296x0);
                } else if (index == 27) {
                    this.f1297y0 = obtainStyledAttributes.getFloat(index, this.f1297y0);
                }
            }
        }
    }

    public Constraints(Context context) {
        super(context);
        super.setVisibility(8);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public d getConstraintSet() {
        if (this.f1284a == null) {
            this.f1284a = new d();
        }
        d dVar = this.f1284a;
        dVar.getClass();
        int childCount = getChildCount();
        HashMap hashMap = dVar.f1321c;
        hashMap.clear();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int id = childAt.getId();
            if (dVar.f1320b && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!hashMap.containsKey(Integer.valueOf(id))) {
                hashMap.put(Integer.valueOf(id), new c());
            }
            c cVar = (c) hashMap.get(Integer.valueOf(id));
            if (childAt instanceof ConstraintHelper) {
                ConstraintHelper constraintHelper = (ConstraintHelper) childAt;
                cVar.c(id, layoutParams);
                if (constraintHelper instanceof Barrier) {
                    e eVar = cVar.f1314d;
                    eVar.f6592d0 = 1;
                    Barrier barrier = (Barrier) constraintHelper;
                    eVar.f6588b0 = barrier.getType();
                    eVar.f6594e0 = barrier.getReferencedIds();
                    eVar.f6590c0 = barrier.getMargin();
                }
            }
            cVar.c(id, layoutParams);
        }
        return this.f1284a;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z4, int i4, int i5, int i6, int i7) {
    }

    public Constraints(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Log.v("Constraints", " ################# init");
        super.setVisibility(8);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new ConstraintLayout.LayoutParams(layoutParams);
    }

    public Constraints(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        Log.v("Constraints", " ################# init");
        super.setVisibility(8);
    }
}