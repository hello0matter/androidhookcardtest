package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import q.d;
import t.k;

/* loaded from: classes.dex */
public class Layer extends ConstraintHelper {

    /* renamed from: h  reason: collision with root package name */
    public float f1009h;

    /* renamed from: i  reason: collision with root package name */
    public float f1010i;

    /* renamed from: j  reason: collision with root package name */
    public float f1011j;

    /* renamed from: k  reason: collision with root package name */
    public ConstraintLayout f1012k;

    /* renamed from: l  reason: collision with root package name */
    public float f1013l;

    /* renamed from: m  reason: collision with root package name */
    public float f1014m;

    /* renamed from: n  reason: collision with root package name */
    public float f1015n;

    /* renamed from: o  reason: collision with root package name */
    public float f1016o;

    /* renamed from: p  reason: collision with root package name */
    public float f1017p;

    /* renamed from: q  reason: collision with root package name */
    public float f1018q;

    /* renamed from: r  reason: collision with root package name */
    public float f1019r;

    /* renamed from: s  reason: collision with root package name */
    public float f1020s;

    /* renamed from: t  reason: collision with root package name */
    public final boolean f1021t;

    /* renamed from: u  reason: collision with root package name */
    public View[] f1022u;

    /* renamed from: v  reason: collision with root package name */
    public float f1023v;

    /* renamed from: w  reason: collision with root package name */
    public float f1024w;

    /* renamed from: x  reason: collision with root package name */
    public boolean f1025x;

    /* renamed from: y  reason: collision with root package name */
    public boolean f1026y;

    public Layer(Context context) {
        super(context);
        this.f1009h = Float.NaN;
        this.f1010i = Float.NaN;
        this.f1011j = Float.NaN;
        this.f1013l = 1.0f;
        this.f1014m = 1.0f;
        this.f1015n = Float.NaN;
        this.f1016o = Float.NaN;
        this.f1017p = Float.NaN;
        this.f1018q = Float.NaN;
        this.f1019r = Float.NaN;
        this.f1020s = Float.NaN;
        this.f1021t = true;
        this.f1022u = null;
        this.f1023v = 0.0f;
        this.f1024w = 0.0f;
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public final void g(AttributeSet attributeSet) {
        super.g(attributeSet);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, k.f6649b);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i4 = 0; i4 < indexCount; i4++) {
                int index = obtainStyledAttributes.getIndex(i4);
                if (index == 6) {
                    this.f1025x = true;
                } else if (index == 13) {
                    this.f1026y = true;
                }
            }
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public final void j() {
        n();
        this.f1015n = Float.NaN;
        this.f1016o = Float.NaN;
        d dVar = ((ConstraintLayout.LayoutParams) getLayoutParams()).f1269l0;
        dVar.A(0);
        dVar.x(0);
        m();
        layout(((int) this.f1019r) - getPaddingLeft(), ((int) this.f1020s) - getPaddingTop(), getPaddingRight() + ((int) this.f1017p), getPaddingBottom() + ((int) this.f1018q));
        if (!Float.isNaN(this.f1011j)) {
            o();
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public final void k(ConstraintLayout constraintLayout) {
        this.f1012k = constraintLayout;
        float rotation = getRotation();
        if (rotation == 0.0f && Float.isNaN(this.f1011j)) {
            return;
        }
        this.f1011j = rotation;
    }

    public final void m() {
        if (this.f1012k == null) {
            return;
        }
        if (this.f1021t || Float.isNaN(this.f1015n) || Float.isNaN(this.f1016o)) {
            if (!Float.isNaN(this.f1009h) && !Float.isNaN(this.f1010i)) {
                this.f1016o = this.f1010i;
                this.f1015n = this.f1009h;
                return;
            }
            View[] f4 = f(this.f1012k);
            int left = f4[0].getLeft();
            int top = f4[0].getTop();
            int right = f4[0].getRight();
            int bottom = f4[0].getBottom();
            for (int i4 = 0; i4 < this.f1224b; i4++) {
                View view = f4[i4];
                left = Math.min(left, view.getLeft());
                top = Math.min(top, view.getTop());
                right = Math.max(right, view.getRight());
                bottom = Math.max(bottom, view.getBottom());
            }
            this.f1017p = right;
            this.f1018q = bottom;
            this.f1019r = left;
            this.f1020s = top;
            this.f1015n = Float.isNaN(this.f1009h) ? (left + right) / 2 : this.f1009h;
            this.f1016o = Float.isNaN(this.f1010i) ? (top + bottom) / 2 : this.f1010i;
        }
    }

    public final void n() {
        int i4;
        if (this.f1012k == null || (i4 = this.f1224b) == 0) {
            return;
        }
        View[] viewArr = this.f1022u;
        if (viewArr == null || viewArr.length != i4) {
            this.f1022u = new View[i4];
        }
        for (int i5 = 0; i5 < this.f1224b; i5++) {
            this.f1022u[i5] = this.f1012k.c(this.f1223a[i5]);
        }
    }

    public final void o() {
        if (this.f1012k == null) {
            return;
        }
        if (this.f1022u == null) {
            n();
        }
        m();
        double radians = Math.toRadians(this.f1011j);
        float sin = (float) Math.sin(radians);
        float cos = (float) Math.cos(radians);
        float f4 = this.f1013l;
        float f5 = f4 * cos;
        float f6 = this.f1014m;
        float f7 = (-f6) * sin;
        float f8 = f4 * sin;
        float f9 = f6 * cos;
        for (int i4 = 0; i4 < this.f1224b; i4++) {
            View view = this.f1022u[i4];
            int left = view.getLeft();
            int top = view.getTop();
            float right = ((view.getRight() + left) / 2) - this.f1015n;
            float bottom = ((view.getBottom() + top) / 2) - this.f1016o;
            view.setTranslationX((((f7 * bottom) + (f5 * right)) - right) + this.f1023v);
            view.setTranslationY((((f9 * bottom) + (right * f8)) - bottom) + this.f1024w);
            view.setScaleY(this.f1014m);
            view.setScaleX(this.f1013l);
            view.setRotation(this.f1011j);
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f1012k = (ConstraintLayout) getParent();
        if (this.f1025x || this.f1026y) {
            int visibility = getVisibility();
            float elevation = getElevation();
            for (int i4 = 0; i4 < this.f1224b; i4++) {
                View c4 = this.f1012k.c(this.f1223a[i4]);
                if (c4 != null) {
                    if (this.f1025x) {
                        c4.setVisibility(visibility);
                    }
                    if (this.f1026y && elevation > 0.0f) {
                        c4.setTranslationZ(c4.getTranslationZ() + elevation);
                    }
                }
            }
        }
    }

    @Override // android.view.View
    public void setElevation(float f4) {
        super.setElevation(f4);
        c();
    }

    @Override // android.view.View
    public void setPivotX(float f4) {
        this.f1009h = f4;
        o();
    }

    @Override // android.view.View
    public void setPivotY(float f4) {
        this.f1010i = f4;
        o();
    }

    @Override // android.view.View
    public void setRotation(float f4) {
        this.f1011j = f4;
        o();
    }

    @Override // android.view.View
    public void setScaleX(float f4) {
        this.f1013l = f4;
        o();
    }

    @Override // android.view.View
    public void setScaleY(float f4) {
        this.f1014m = f4;
        o();
    }

    @Override // android.view.View
    public void setTranslationX(float f4) {
        this.f1023v = f4;
        o();
    }

    @Override // android.view.View
    public void setTranslationY(float f4) {
        this.f1024w = f4;
        o();
    }

    @Override // android.view.View
    public void setVisibility(int i4) {
        super.setVisibility(i4);
        c();
    }

    public Layer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1009h = Float.NaN;
        this.f1010i = Float.NaN;
        this.f1011j = Float.NaN;
        this.f1013l = 1.0f;
        this.f1014m = 1.0f;
        this.f1015n = Float.NaN;
        this.f1016o = Float.NaN;
        this.f1017p = Float.NaN;
        this.f1018q = Float.NaN;
        this.f1019r = Float.NaN;
        this.f1020s = Float.NaN;
        this.f1021t = true;
        this.f1022u = null;
        this.f1023v = 0.0f;
        this.f1024w = 0.0f;
    }

    public Layer(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f1009h = Float.NaN;
        this.f1010i = Float.NaN;
        this.f1011j = Float.NaN;
        this.f1013l = 1.0f;
        this.f1014m = 1.0f;
        this.f1015n = Float.NaN;
        this.f1016o = Float.NaN;
        this.f1017p = Float.NaN;
        this.f1018q = Float.NaN;
        this.f1019r = Float.NaN;
        this.f1020s = Float.NaN;
        this.f1021t = true;
        this.f1022u = null;
        this.f1023v = 0.0f;
        this.f1024w = 0.0f;
    }
}