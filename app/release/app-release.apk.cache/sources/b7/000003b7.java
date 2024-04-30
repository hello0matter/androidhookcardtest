package c1;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.View;
import android.view.ViewGroup;
import com.example.msphone.R;

/* loaded from: classes.dex */
public final class v extends ViewGroup implements s {

    /* renamed from: g  reason: collision with root package name */
    public static final /* synthetic */ int f2692g = 0;

    /* renamed from: a  reason: collision with root package name */
    public ViewGroup f2693a;

    /* renamed from: b  reason: collision with root package name */
    public View f2694b;

    /* renamed from: c  reason: collision with root package name */
    public final View f2695c;

    /* renamed from: d  reason: collision with root package name */
    public int f2696d;

    /* renamed from: e  reason: collision with root package name */
    public Matrix f2697e;

    /* renamed from: f  reason: collision with root package name */
    public final v.b f2698f;

    public v(View view) {
        super(view.getContext());
        this.f2698f = new v.b(1, this);
        this.f2695c = view;
        setWillNotDraw(false);
        setLayerType(2, null);
    }

    @Override // c1.s
    public final void a(ViewGroup viewGroup, View view) {
        this.f2693a = viewGroup;
        this.f2694b = view;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        View view = this.f2695c;
        view.setTag(R.id.ghost_view, this);
        view.getViewTreeObserver().addOnPreDrawListener(this.f2698f);
        p0.c(4, view);
        if (view.getParent() != null) {
            ((View) view.getParent()).invalidate();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        View view = this.f2695c;
        view.getViewTreeObserver().removeOnPreDrawListener(this.f2698f);
        p0.c(0, view);
        view.setTag(R.id.ghost_view, null);
        if (view.getParent() != null) {
            ((View) view.getParent()).invalidate();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        com.google.common.collect.c.k0(canvas, true);
        canvas.setMatrix(this.f2697e);
        View view = this.f2695c;
        p0.c(0, view);
        view.invalidate();
        p0.c(4, view);
        drawChild(canvas, view, getDrawingTime());
        com.google.common.collect.c.k0(canvas, false);
    }

    @Override // android.view.View, c1.s
    public final void setVisibility(int i4) {
        int i5;
        super.setVisibility(i4);
        View view = this.f2695c;
        if (((v) view.getTag(R.id.ghost_view)) == this) {
            if (i4 == 0) {
                i5 = 4;
            } else {
                i5 = 0;
            }
            p0.c(i5, view);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z4, int i4, int i5, int i6, int i7) {
    }
}