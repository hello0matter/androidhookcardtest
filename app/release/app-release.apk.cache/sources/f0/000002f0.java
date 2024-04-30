package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import com.google.android.material.carousel.CarouselLayoutManager;

/* loaded from: classes.dex */
public final class e0 extends a0 {

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ int f2081q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ Object f2082r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e0(Object obj, Context context, int i4) {
        super(context);
        this.f2081q = i4;
        this.f2082r = obj;
    }

    @Override // androidx.recyclerview.widget.h1
    public final PointF a(int i4) {
        switch (this.f2081q) {
            case 1:
                return ((CarouselLayoutManager) this.f2082r).a(i4);
            default:
                return super.a(i4);
        }
    }

    @Override // androidx.recyclerview.widget.a0, androidx.recyclerview.widget.h1
    public final void c(View view, i1 i1Var, f1 f1Var) {
        switch (this.f2081q) {
            case 0:
                f0 f0Var = (f0) this.f2082r;
                int[] b5 = f0Var.b(f0Var.f2088a.getLayoutManager(), view);
                int i4 = b5[0];
                int i5 = b5[1];
                int ceil = (int) Math.ceil(i(Math.max(Math.abs(i4), Math.abs(i5))) / 0.3356d);
                if (ceil > 0) {
                    DecelerateInterpolator decelerateInterpolator = this.f2047j;
                    f1Var.f2092a = i4;
                    f1Var.f2093b = i5;
                    f1Var.f2094c = ceil;
                    f1Var.f2096e = decelerateInterpolator;
                    f1Var.f2097f = true;
                    return;
                }
                return;
            default:
                super.c(view, i1Var, f1Var);
                return;
        }
    }

    @Override // androidx.recyclerview.widget.a0
    public final int f(View view, int i4) {
        switch (this.f2081q) {
            case 1:
                CarouselLayoutManager carouselLayoutManager = (CarouselLayoutManager) this.f2082r;
                if (carouselLayoutManager.f3178u != null && carouselLayoutManager.K0()) {
                    int F = u0.F(view);
                    return (int) (carouselLayoutManager.f3173p - carouselLayoutManager.I0(F, carouselLayoutManager.G0(F)));
                }
                return 0;
            default:
                return super.f(view, i4);
        }
    }

    @Override // androidx.recyclerview.widget.a0
    public final int g(View view, int i4) {
        switch (this.f2081q) {
            case 1:
                CarouselLayoutManager carouselLayoutManager = (CarouselLayoutManager) this.f2082r;
                if (carouselLayoutManager.f3178u != null && !carouselLayoutManager.K0()) {
                    int F = u0.F(view);
                    return (int) (carouselLayoutManager.f3173p - carouselLayoutManager.I0(F, carouselLayoutManager.G0(F)));
                }
                return 0;
            default:
                return super.g(view, i4);
        }
    }

    @Override // androidx.recyclerview.widget.a0
    public final float h(DisplayMetrics displayMetrics) {
        switch (this.f2081q) {
            case 0:
                return 100.0f / displayMetrics.densityDpi;
            case 1:
            default:
                return super.h(displayMetrics);
            case 2:
                return 100.0f / displayMetrics.densityDpi;
        }
    }

    @Override // androidx.recyclerview.widget.a0
    public final int i(int i4) {
        switch (this.f2081q) {
            case 0:
                return Math.min(100, super.i(i4));
            default:
                return super.i(i4);
        }
    }
}