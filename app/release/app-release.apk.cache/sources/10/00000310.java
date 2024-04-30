package androidx.recyclerview.widget;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class p extends q0 implements x0 {
    public static final int[] C = {16842919};
    public static final int[] D = new int[0];
    public int A;
    public final l B;

    /* renamed from: a  reason: collision with root package name */
    public final int f2203a;

    /* renamed from: b  reason: collision with root package name */
    public final int f2204b;

    /* renamed from: c  reason: collision with root package name */
    public final StateListDrawable f2205c;

    /* renamed from: d  reason: collision with root package name */
    public final Drawable f2206d;

    /* renamed from: e  reason: collision with root package name */
    public final int f2207e;

    /* renamed from: f  reason: collision with root package name */
    public final int f2208f;

    /* renamed from: g  reason: collision with root package name */
    public final StateListDrawable f2209g;

    /* renamed from: h  reason: collision with root package name */
    public final Drawable f2210h;

    /* renamed from: i  reason: collision with root package name */
    public final int f2211i;

    /* renamed from: j  reason: collision with root package name */
    public final int f2212j;

    /* renamed from: k  reason: collision with root package name */
    public int f2213k;

    /* renamed from: l  reason: collision with root package name */
    public int f2214l;

    /* renamed from: m  reason: collision with root package name */
    public float f2215m;

    /* renamed from: n  reason: collision with root package name */
    public int f2216n;

    /* renamed from: o  reason: collision with root package name */
    public int f2217o;

    /* renamed from: p  reason: collision with root package name */
    public float f2218p;

    /* renamed from: s  reason: collision with root package name */
    public final RecyclerView f2221s;

    /* renamed from: z  reason: collision with root package name */
    public final ValueAnimator f2228z;

    /* renamed from: q  reason: collision with root package name */
    public int f2219q = 0;

    /* renamed from: r  reason: collision with root package name */
    public int f2220r = 0;

    /* renamed from: t  reason: collision with root package name */
    public boolean f2222t = false;

    /* renamed from: u  reason: collision with root package name */
    public boolean f2223u = false;

    /* renamed from: v  reason: collision with root package name */
    public int f2224v = 0;

    /* renamed from: w  reason: collision with root package name */
    public int f2225w = 0;

    /* renamed from: x  reason: collision with root package name */
    public final int[] f2226x = new int[2];

    /* renamed from: y  reason: collision with root package name */
    public final int[] f2227y = new int[2];

    public p(RecyclerView recyclerView, StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2, int i4, int i5, int i6) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f2228z = ofFloat;
        this.A = 0;
        l lVar = new l(0, this);
        this.B = lVar;
        m mVar = new m(this);
        this.f2205c = stateListDrawable;
        this.f2206d = drawable;
        this.f2209g = stateListDrawable2;
        this.f2210h = drawable2;
        this.f2207e = Math.max(i4, stateListDrawable.getIntrinsicWidth());
        this.f2208f = Math.max(i4, drawable.getIntrinsicWidth());
        this.f2211i = Math.max(i4, stateListDrawable2.getIntrinsicWidth());
        this.f2212j = Math.max(i4, drawable2.getIntrinsicWidth());
        this.f2203a = i5;
        this.f2204b = i6;
        stateListDrawable.setAlpha(255);
        drawable.setAlpha(255);
        ofFloat.addListener(new n(this));
        ofFloat.addUpdateListener(new o(this));
        RecyclerView recyclerView2 = this.f2221s;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            u0 u0Var = recyclerView2.f1988l;
            if (u0Var != null) {
                u0Var.c("Cannot remove item decoration during a scroll  or layout");
            }
            ArrayList arrayList = recyclerView2.f1990m;
            arrayList.remove(this);
            if (arrayList.isEmpty()) {
                recyclerView2.setWillNotDraw(recyclerView2.getOverScrollMode() == 2);
            }
            recyclerView2.O();
            recyclerView2.requestLayout();
            RecyclerView recyclerView3 = this.f2221s;
            recyclerView3.f1992n.remove(this);
            if (recyclerView3.f1994o == this) {
                recyclerView3.f1994o = null;
            }
            ArrayList arrayList2 = this.f2221s.f1977f0;
            if (arrayList2 != null) {
                arrayList2.remove(mVar);
            }
            this.f2221s.removeCallbacks(lVar);
        }
        this.f2221s = recyclerView;
        if (recyclerView != null) {
            recyclerView.g(this);
            this.f2221s.f1992n.add(this);
            this.f2221s.h(mVar);
        }
    }

    public static int f(float f4, float f5, int[] iArr, int i4, int i5, int i6) {
        int i7 = iArr[1] - iArr[0];
        if (i7 == 0) {
            return 0;
        }
        int i8 = i4 - i6;
        int i9 = (int) (((f5 - f4) / i7) * i8);
        int i10 = i5 + i9;
        if (i10 >= i8 || i10 < 0) {
            return 0;
        }
        return i9;
    }

    @Override // androidx.recyclerview.widget.q0
    public final void c(Canvas canvas, RecyclerView recyclerView) {
        int i4;
        if (this.f2219q == this.f2221s.getWidth() && this.f2220r == this.f2221s.getHeight()) {
            if (this.A != 0) {
                if (this.f2222t) {
                    int i5 = this.f2219q;
                    int i6 = this.f2207e;
                    int i7 = i5 - i6;
                    int i8 = this.f2214l;
                    int i9 = this.f2213k;
                    int i10 = i8 - (i9 / 2);
                    StateListDrawable stateListDrawable = this.f2205c;
                    stateListDrawable.setBounds(0, 0, i6, i9);
                    int i11 = this.f2220r;
                    int i12 = this.f2208f;
                    Drawable drawable = this.f2206d;
                    drawable.setBounds(0, 0, i12, i11);
                    RecyclerView recyclerView2 = this.f2221s;
                    WeakHashMap weakHashMap = i0.y0.f4999a;
                    if (i0.h0.d(recyclerView2) == 1) {
                        drawable.draw(canvas);
                        canvas.translate(i6, i10);
                        canvas.scale(-1.0f, 1.0f);
                        stateListDrawable.draw(canvas);
                        canvas.scale(1.0f, 1.0f);
                        i4 = -i6;
                    } else {
                        canvas.translate(i7, 0.0f);
                        drawable.draw(canvas);
                        canvas.translate(0.0f, i10);
                        stateListDrawable.draw(canvas);
                        i4 = -i7;
                    }
                    canvas.translate(i4, -i10);
                }
                if (this.f2223u) {
                    int i13 = this.f2220r;
                    int i14 = this.f2211i;
                    int i15 = i13 - i14;
                    int i16 = this.f2217o;
                    int i17 = this.f2216n;
                    int i18 = i16 - (i17 / 2);
                    StateListDrawable stateListDrawable2 = this.f2209g;
                    stateListDrawable2.setBounds(0, 0, i17, i14);
                    int i19 = this.f2219q;
                    int i20 = this.f2212j;
                    Drawable drawable2 = this.f2210h;
                    drawable2.setBounds(0, 0, i19, i20);
                    canvas.translate(0.0f, i15);
                    drawable2.draw(canvas);
                    canvas.translate(i18, 0.0f);
                    stateListDrawable2.draw(canvas);
                    canvas.translate(-i18, -i15);
                    return;
                }
                return;
            }
            return;
        }
        this.f2219q = this.f2221s.getWidth();
        this.f2220r = this.f2221s.getHeight();
        g(0);
    }

    public final boolean d(float f4, float f5) {
        if (f5 >= this.f2220r - this.f2211i) {
            int i4 = this.f2217o;
            int i5 = this.f2216n;
            if (f4 >= i4 - (i5 / 2) && f4 <= (i5 / 2) + i4) {
                return true;
            }
        }
        return false;
    }

    public final boolean e(float f4, float f5) {
        boolean z4;
        RecyclerView recyclerView = this.f2221s;
        WeakHashMap weakHashMap = i0.y0.f4999a;
        if (i0.h0.d(recyclerView) == 1) {
            z4 = true;
        } else {
            z4 = false;
        }
        int i4 = this.f2207e;
        if (z4) {
            if (f4 > i4 / 2) {
                return false;
            }
        } else if (f4 < this.f2219q - i4) {
            return false;
        }
        int i5 = this.f2214l;
        int i6 = this.f2213k / 2;
        if (f5 < i5 - i6 || f5 > i6 + i5) {
            return false;
        }
        return true;
    }

    public final void g(int i4) {
        RecyclerView recyclerView;
        int i5;
        l lVar = this.B;
        StateListDrawable stateListDrawable = this.f2205c;
        if (i4 == 2 && this.f2224v != 2) {
            stateListDrawable.setState(C);
            this.f2221s.removeCallbacks(lVar);
        }
        if (i4 == 0) {
            this.f2221s.invalidate();
        } else {
            h();
        }
        if (this.f2224v == 2 && i4 != 2) {
            stateListDrawable.setState(D);
            this.f2221s.removeCallbacks(lVar);
            recyclerView = this.f2221s;
            i5 = 1200;
        } else {
            if (i4 == 1) {
                this.f2221s.removeCallbacks(lVar);
                recyclerView = this.f2221s;
                i5 = 1500;
            }
            this.f2224v = i4;
        }
        recyclerView.postDelayed(lVar, i5);
        this.f2224v = i4;
    }

    public final void h() {
        int i4 = this.A;
        ValueAnimator valueAnimator = this.f2228z;
        if (i4 != 0) {
            if (i4 != 3) {
                return;
            }
            valueAnimator.cancel();
        }
        this.A = 1;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 1.0f);
        valueAnimator.setDuration(500L);
        valueAnimator.setStartDelay(0L);
        valueAnimator.start();
    }
}