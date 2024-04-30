package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public class a0 extends h1 {

    /* renamed from: k  reason: collision with root package name */
    public PointF f2048k;

    /* renamed from: l  reason: collision with root package name */
    public final DisplayMetrics f2049l;

    /* renamed from: n  reason: collision with root package name */
    public float f2051n;

    /* renamed from: i  reason: collision with root package name */
    public final LinearInterpolator f2046i = new LinearInterpolator();

    /* renamed from: j  reason: collision with root package name */
    public final DecelerateInterpolator f2047j = new DecelerateInterpolator();

    /* renamed from: m  reason: collision with root package name */
    public boolean f2050m = false;

    /* renamed from: o  reason: collision with root package name */
    public int f2052o = 0;

    /* renamed from: p  reason: collision with root package name */
    public int f2053p = 0;

    public a0(Context context) {
        this.f2049l = context.getResources().getDisplayMetrics();
    }

    public static int e(int i4, int i5, int i6, int i7, int i8) {
        if (i8 != -1) {
            if (i8 != 0) {
                if (i8 == 1) {
                    return i7 - i5;
                }
                throw new IllegalArgumentException("snap preference should be one of the constants defined in SmoothScroller, starting with SNAP_");
            }
            int i9 = i6 - i4;
            if (i9 > 0) {
                return i9;
            }
            int i10 = i7 - i5;
            if (i10 < 0) {
                return i10;
            }
            return 0;
        }
        return i6 - i4;
    }

    @Override // androidx.recyclerview.widget.h1
    public void c(View view, i1 i1Var, f1 f1Var) {
        int i4;
        int i5;
        int i6;
        PointF pointF = this.f2048k;
        int i7 = 0;
        if (pointF != null && pointF.x != 0.0f) {
            if (i6 > 0) {
                i4 = 1;
            } else {
                i4 = -1;
            }
        } else {
            i4 = 0;
        }
        int f4 = f(view, i4);
        PointF pointF2 = this.f2048k;
        if (pointF2 != null && pointF2.y != 0.0f) {
            i7 = i5 > 0 ? 1 : -1;
        }
        int g4 = g(view, i7);
        int ceil = (int) Math.ceil(i((int) Math.sqrt((g4 * g4) + (f4 * f4))) / 0.3356d);
        if (ceil > 0) {
            DecelerateInterpolator decelerateInterpolator = this.f2047j;
            f1Var.f2092a = -f4;
            f1Var.f2093b = -g4;
            f1Var.f2094c = ceil;
            f1Var.f2096e = decelerateInterpolator;
            f1Var.f2097f = true;
        }
    }

    public int f(View view, int i4) {
        u0 u0Var = this.f2113c;
        if (u0Var != null && u0Var.d()) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            return e((view.getLeft() - ((RecyclerView.LayoutParams) view.getLayoutParams()).f2012b.left) - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, view.getRight() + ((RecyclerView.LayoutParams) view.getLayoutParams()).f2012b.right + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, u0Var.C(), u0Var.f2286n - u0Var.D(), i4);
        }
        return 0;
    }

    public int g(View view, int i4) {
        u0 u0Var = this.f2113c;
        if (u0Var != null && u0Var.e()) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            return e((view.getTop() - ((RecyclerView.LayoutParams) view.getLayoutParams()).f2012b.top) - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, view.getBottom() + ((RecyclerView.LayoutParams) view.getLayoutParams()).f2012b.bottom + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin, u0Var.E(), u0Var.f2287o - u0Var.B(), i4);
        }
        return 0;
    }

    public float h(DisplayMetrics displayMetrics) {
        return 25.0f / displayMetrics.densityDpi;
    }

    public int i(int i4) {
        float abs = Math.abs(i4);
        if (!this.f2050m) {
            this.f2051n = h(this.f2049l);
            this.f2050m = true;
        }
        return (int) Math.ceil(abs * this.f2051n);
    }
}