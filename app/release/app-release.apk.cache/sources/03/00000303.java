package androidx.recyclerview.widget;

import android.view.animation.Interpolator;
import android.widget.OverScroller;
import java.util.Arrays;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class k1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public int f2160a;

    /* renamed from: b  reason: collision with root package name */
    public int f2161b;

    /* renamed from: c  reason: collision with root package name */
    public OverScroller f2162c;

    /* renamed from: d  reason: collision with root package name */
    public Interpolator f2163d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f2164e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f2165f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ RecyclerView f2166g;

    public k1(RecyclerView recyclerView) {
        this.f2166g = recyclerView;
        h0 h0Var = RecyclerView.f1965v0;
        this.f2163d = h0Var;
        this.f2164e = false;
        this.f2165f = false;
        this.f2162c = new OverScroller(recyclerView.getContext(), h0Var);
    }

    public final void a() {
        if (this.f2164e) {
            this.f2165f = true;
            return;
        }
        RecyclerView recyclerView = this.f2166g;
        recyclerView.removeCallbacks(this);
        WeakHashMap weakHashMap = i0.y0.f4999a;
        i0.g0.m(recyclerView, this);
    }

    public final void b(int i4, int i5, int i6, Interpolator interpolator) {
        boolean z4;
        int height;
        int i7;
        RecyclerView recyclerView = this.f2166g;
        if (i6 == Integer.MIN_VALUE) {
            int abs = Math.abs(i4);
            int abs2 = Math.abs(i5);
            if (abs > abs2) {
                z4 = true;
            } else {
                z4 = false;
            }
            int sqrt = (int) Math.sqrt(0);
            int sqrt2 = (int) Math.sqrt((i5 * i5) + (i4 * i4));
            if (z4) {
                height = recyclerView.getWidth();
            } else {
                height = recyclerView.getHeight();
            }
            int i8 = height / 2;
            float f4 = height;
            float f5 = i8;
            float sin = (((float) Math.sin((Math.min(1.0f, (sqrt2 * 1.0f) / f4) - 0.5f) * 0.47123894f)) * f5) + f5;
            if (sqrt > 0) {
                i7 = Math.round(Math.abs(sin / sqrt) * 1000.0f) * 4;
            } else {
                if (!z4) {
                    abs = abs2;
                }
                i7 = (int) (((abs / f4) + 1.0f) * 300.0f);
            }
            i6 = Math.min(i7, 2000);
        }
        int i9 = i6;
        if (interpolator == null) {
            interpolator = RecyclerView.f1965v0;
        }
        if (this.f2163d != interpolator) {
            this.f2163d = interpolator;
            this.f2162c = new OverScroller(recyclerView.getContext(), interpolator);
        }
        this.f2161b = 0;
        this.f2160a = 0;
        recyclerView.setScrollState(2);
        this.f2162c.startScroll(0, 0, i4, i5, i9);
        a();
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i4;
        int i5;
        int i6;
        int i7;
        boolean awakenScrollBars;
        boolean z4;
        boolean z5;
        boolean z6;
        int i8;
        RecyclerView recyclerView = this.f2166g;
        if (recyclerView.f1988l == null) {
            recyclerView.removeCallbacks(this);
            this.f2162c.abortAnimation();
            return;
        }
        this.f2165f = false;
        this.f2164e = true;
        recyclerView.m();
        OverScroller overScroller = this.f2162c;
        if (overScroller.computeScrollOffset()) {
            int currX = overScroller.getCurrX();
            int currY = overScroller.getCurrY();
            int i9 = currX - this.f2160a;
            int i10 = currY - this.f2161b;
            this.f2160a = currX;
            this.f2161b = currY;
            int[] iArr = recyclerView.f1997p0;
            iArr[0] = 0;
            iArr[1] = 0;
            boolean s4 = recyclerView.s(i9, i10, iArr, null, 1);
            int[] iArr2 = recyclerView.f1997p0;
            if (s4) {
                i9 -= iArr2[0];
                i10 -= iArr2[1];
            }
            if (recyclerView.getOverScrollMode() != 2) {
                recyclerView.l(i9, i10);
            }
            if (recyclerView.f1986k != null) {
                iArr2[0] = 0;
                iArr2[1] = 0;
                recyclerView.a0(i9, i10, iArr2);
                int i11 = iArr2[0];
                int i12 = iArr2[1];
                int i13 = i9 - i11;
                int i14 = i10 - i12;
                h1 h1Var = recyclerView.f1988l.f2277e;
                if (h1Var != null && !h1Var.f2114d && h1Var.f2115e) {
                    int b5 = recyclerView.f1973d0.b();
                    if (b5 == 0) {
                        h1Var.d();
                    } else {
                        if (h1Var.f2111a >= b5) {
                            h1Var.f2111a = b5 - 1;
                        }
                        h1Var.b(i11, i12);
                    }
                }
                i7 = i11;
                i4 = i13;
                i5 = i14;
                i6 = i12;
            } else {
                i4 = i9;
                i5 = i10;
                i6 = 0;
                i7 = 0;
            }
            if (!recyclerView.f1990m.isEmpty()) {
                recyclerView.invalidate();
            }
            int[] iArr3 = recyclerView.f1997p0;
            iArr3[0] = 0;
            iArr3[1] = 0;
            int i15 = i6;
            recyclerView.t(i7, i6, i4, i5, null, 1, iArr3);
            int i16 = i4 - iArr2[0];
            int i17 = i5 - iArr2[1];
            if (i7 != 0 || i15 != 0) {
                recyclerView.u(i7, i15);
            }
            awakenScrollBars = recyclerView.awakenScrollBars();
            if (!awakenScrollBars) {
                recyclerView.invalidate();
            }
            if (overScroller.getCurrX() == overScroller.getFinalX()) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (overScroller.getCurrY() == overScroller.getFinalY()) {
                z5 = true;
            } else {
                z5 = false;
            }
            if (!overScroller.isFinished() && ((!z4 && i16 == 0) || (!z5 && i17 == 0))) {
                z6 = false;
            } else {
                z6 = true;
            }
            h1 h1Var2 = recyclerView.f1988l.f2277e;
            if ((h1Var2 == null || !h1Var2.f2114d) && z6) {
                if (recyclerView.getOverScrollMode() != 2) {
                    int currVelocity = (int) overScroller.getCurrVelocity();
                    if (i16 < 0) {
                        i8 = -currVelocity;
                    } else if (i16 > 0) {
                        i8 = currVelocity;
                    } else {
                        i8 = 0;
                    }
                    if (i17 < 0) {
                        currVelocity = -currVelocity;
                    } else if (i17 <= 0) {
                        currVelocity = 0;
                    }
                    if (i8 < 0) {
                        recyclerView.w();
                        if (recyclerView.E.isFinished()) {
                            recyclerView.E.onAbsorb(-i8);
                        }
                    } else if (i8 > 0) {
                        recyclerView.x();
                        if (recyclerView.G.isFinished()) {
                            recyclerView.G.onAbsorb(i8);
                        }
                    }
                    if (currVelocity < 0) {
                        recyclerView.y();
                        if (recyclerView.F.isFinished()) {
                            recyclerView.F.onAbsorb(-currVelocity);
                        }
                    } else if (currVelocity > 0) {
                        recyclerView.v();
                        if (recyclerView.H.isFinished()) {
                            recyclerView.H.onAbsorb(currVelocity);
                        }
                    }
                    if (i8 != 0 || currVelocity != 0) {
                        WeakHashMap weakHashMap = i0.y0.f4999a;
                        i0.g0.k(recyclerView);
                    }
                }
                r rVar = recyclerView.f1971c0;
                int[] iArr4 = rVar.f2244c;
                if (iArr4 != null) {
                    Arrays.fill(iArr4, -1);
                }
                rVar.f2245d = 0;
            } else {
                a();
                t tVar = recyclerView.f1969b0;
                if (tVar != null) {
                    tVar.a(recyclerView, i7, i15);
                }
            }
        }
        h1 h1Var3 = recyclerView.f1988l.f2277e;
        if (h1Var3 != null && h1Var3.f2114d) {
            h1Var3.b(0, 0);
        }
        this.f2164e = false;
        if (this.f2165f) {
            recyclerView.removeCallbacks(this);
            WeakHashMap weakHashMap2 = i0.y0.f4999a;
            i0.g0.m(recyclerView, this);
            return;
        }
        recyclerView.setScrollState(0);
        recyclerView.g0(1);
    }
}