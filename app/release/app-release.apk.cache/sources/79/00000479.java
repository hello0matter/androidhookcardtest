package com.google.android.material.appbar;

import android.animation.AnimatorInflater;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.app.o0;
import androidx.appcompat.widget.c0;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.customview.view.AbsSavedState;
import com.example.msphone.R;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import i0.g0;
import i0.g2;
import i0.h0;
import i0.i0;
import i0.j0;
import i0.m0;
import i0.r;
import i0.y0;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class AppBarLayout extends LinearLayout implements androidx.coordinatorlayout.widget.a {

    /* renamed from: y  reason: collision with root package name */
    public static final /* synthetic */ int f2867y = 0;

    /* renamed from: a  reason: collision with root package name */
    public int f2868a;

    /* renamed from: b  reason: collision with root package name */
    public int f2869b;

    /* renamed from: c  reason: collision with root package name */
    public int f2870c;

    /* renamed from: d  reason: collision with root package name */
    public int f2871d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f2872e;

    /* renamed from: f  reason: collision with root package name */
    public int f2873f;

    /* renamed from: g  reason: collision with root package name */
    public g2 f2874g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList f2875h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f2876i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f2877j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f2878k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f2879l;

    /* renamed from: m  reason: collision with root package name */
    public int f2880m;

    /* renamed from: n  reason: collision with root package name */
    public WeakReference f2881n;

    /* renamed from: o  reason: collision with root package name */
    public final ColorStateList f2882o;

    /* renamed from: p  reason: collision with root package name */
    public ValueAnimator f2883p;

    /* renamed from: q  reason: collision with root package name */
    public final a f2884q;

    /* renamed from: r  reason: collision with root package name */
    public final ArrayList f2885r;

    /* renamed from: s  reason: collision with root package name */
    public final long f2886s;

    /* renamed from: t  reason: collision with root package name */
    public final TimeInterpolator f2887t;

    /* renamed from: u  reason: collision with root package name */
    public int[] f2888u;

    /* renamed from: v  reason: collision with root package name */
    public Drawable f2889v;

    /* renamed from: w  reason: collision with root package name */
    public final float f2890w;

    /* renamed from: x  reason: collision with root package name */
    public Behavior f2891x;

    /* loaded from: classes.dex */
    public static class BaseBehavior<T extends AppBarLayout> extends HeaderBehavior<T> {

        /* renamed from: j  reason: collision with root package name */
        public int f2892j;

        /* renamed from: k  reason: collision with root package name */
        public int f2893k;

        /* renamed from: l  reason: collision with root package name */
        public ValueAnimator f2894l;

        /* renamed from: m  reason: collision with root package name */
        public SavedState f2895m;

        /* renamed from: n  reason: collision with root package name */
        public WeakReference f2896n;

        /* renamed from: o  reason: collision with root package name */
        public boolean f2897o;

        /* loaded from: classes.dex */
        public static class SavedState extends AbsSavedState {
            public static final Parcelable.Creator<SavedState> CREATOR = new Object();

            /* renamed from: c  reason: collision with root package name */
            public boolean f2898c;

            /* renamed from: d  reason: collision with root package name */
            public boolean f2899d;

            /* renamed from: e  reason: collision with root package name */
            public int f2900e;

            /* renamed from: f  reason: collision with root package name */
            public float f2901f;

            /* renamed from: g  reason: collision with root package name */
            public boolean f2902g;

            public SavedState(Parcel parcel, ClassLoader classLoader) {
                super(parcel, classLoader);
                this.f2898c = parcel.readByte() != 0;
                this.f2899d = parcel.readByte() != 0;
                this.f2900e = parcel.readInt();
                this.f2901f = parcel.readFloat();
                this.f2902g = parcel.readByte() != 0;
            }

            @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
            public final void writeToParcel(Parcel parcel, int i4) {
                super.writeToParcel(parcel, i4);
                parcel.writeByte(this.f2898c ? (byte) 1 : (byte) 0);
                parcel.writeByte(this.f2899d ? (byte) 1 : (byte) 0);
                parcel.writeInt(this.f2900e);
                parcel.writeFloat(this.f2901f);
                parcel.writeByte(this.f2902g ? (byte) 1 : (byte) 0);
            }
        }

        public BaseBehavior() {
            this.f2937f = -1;
            this.f2939h = -1;
        }

        public static View H(CoordinatorLayout coordinatorLayout) {
            int childCount = coordinatorLayout.getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = coordinatorLayout.getChildAt(i4);
                if ((childAt instanceof r) || (childAt instanceof AbsListView) || (childAt instanceof ScrollView)) {
                    return childAt;
                }
            }
            return null;
        }

        public static void M(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i4, int i5, boolean z4) {
            View view;
            boolean z5;
            int abs = Math.abs(i4);
            int childCount = appBarLayout.getChildCount();
            int i6 = 0;
            while (true) {
                if (i6 < childCount) {
                    view = appBarLayout.getChildAt(i6);
                    if (abs >= view.getTop() && abs <= view.getBottom()) {
                        break;
                    }
                    i6++;
                } else {
                    view = null;
                    break;
                }
            }
            if (view != null) {
                int i7 = ((LayoutParams) view.getLayoutParams()).f2903a;
                if ((i7 & 1) != 0) {
                    WeakHashMap weakHashMap = y0.f4999a;
                    int d4 = g0.d(view);
                    z5 = true;
                    if (i5 > 0) {
                    }
                }
            }
            z5 = false;
            if (appBarLayout.f2879l) {
                z5 = appBarLayout.e(H(coordinatorLayout));
            }
            boolean d5 = appBarLayout.d(z5);
            if (!z4) {
                if (d5) {
                    List list = (List) coordinatorLayout.f1328b.f6941b.getOrDefault(appBarLayout, null);
                    ArrayList arrayList = coordinatorLayout.f1330d;
                    arrayList.clear();
                    if (list != null) {
                        arrayList.addAll(list);
                    }
                    int size = arrayList.size();
                    for (int i8 = 0; i8 < size; i8++) {
                        CoordinatorLayout.Behavior behavior = ((androidx.coordinatorlayout.widget.b) ((View) arrayList.get(i8)).getLayoutParams()).f1347a;
                        if (behavior instanceof ScrollingViewBehavior) {
                            if (((ScrollingViewBehavior) behavior).f2944f == 0) {
                                return;
                            }
                        }
                    }
                    return;
                }
                return;
            }
            if (appBarLayout.getBackground() != null) {
                appBarLayout.getBackground().jumpToCurrentState();
            }
            if (appBarLayout.getForeground() != null) {
                appBarLayout.getForeground().jumpToCurrentState();
            }
            if (appBarLayout.getStateListAnimator() != null) {
                appBarLayout.getStateListAnimator().jumpToCurrentState();
            }
        }

        @Override // com.google.android.material.appbar.HeaderBehavior
        public final boolean A(View view) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            WeakReference weakReference = this.f2896n;
            if (weakReference == null) {
                return true;
            }
            View view2 = (View) weakReference.get();
            if (view2 != null && view2.isShown() && !view2.canScrollVertically(-1)) {
                return true;
            }
            return false;
        }

        @Override // com.google.android.material.appbar.HeaderBehavior
        public final int B(View view) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            return appBarLayout.getTopInset() + (-appBarLayout.getDownNestedScrollRange());
        }

        @Override // com.google.android.material.appbar.HeaderBehavior
        public final int C(View view) {
            return ((AppBarLayout) view).getTotalScrollRange();
        }

        @Override // com.google.android.material.appbar.HeaderBehavior
        public final void D(View view, CoordinatorLayout coordinatorLayout) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            K(coordinatorLayout, appBarLayout);
            if (appBarLayout.f2879l) {
                appBarLayout.d(appBarLayout.e(H(coordinatorLayout)));
            }
        }

        @Override // com.google.android.material.appbar.HeaderBehavior
        public final int E(CoordinatorLayout coordinatorLayout, View view, int i4, int i5, int i6) {
            int i7;
            int i8;
            AppBarLayout appBarLayout = (AppBarLayout) view;
            int x4 = x();
            int i9 = 0;
            if (i5 != 0 && x4 >= i5 && x4 <= i6) {
                int L = com.google.common.collect.c.L(i4, i5, i6);
                if (x4 != L) {
                    if (appBarLayout.f2872e) {
                        int abs = Math.abs(L);
                        int childCount = appBarLayout.getChildCount();
                        int i10 = 0;
                        while (true) {
                            if (i10 >= childCount) {
                                break;
                            }
                            View childAt = appBarLayout.getChildAt(i10);
                            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                            Interpolator interpolator = layoutParams.f2905c;
                            if (abs >= childAt.getTop() && abs <= childAt.getBottom()) {
                                if (interpolator != null) {
                                    int i11 = layoutParams.f2903a;
                                    if ((i11 & 1) != 0) {
                                        i8 = childAt.getHeight() + ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                                        if ((i11 & 2) != 0) {
                                            WeakHashMap weakHashMap = y0.f4999a;
                                            i8 -= g0.d(childAt);
                                        }
                                    } else {
                                        i8 = 0;
                                    }
                                    WeakHashMap weakHashMap2 = y0.f4999a;
                                    if (g0.b(childAt)) {
                                        i8 -= appBarLayout.getTopInset();
                                    }
                                    if (i8 > 0) {
                                        float f4 = i8;
                                        i7 = (childAt.getTop() + Math.round(interpolator.getInterpolation((abs - childAt.getTop()) / f4) * f4)) * Integer.signum(L);
                                    }
                                }
                            } else {
                                i10++;
                            }
                        }
                    }
                    i7 = L;
                    boolean z4 = z(i7);
                    int i12 = x4 - L;
                    this.f2892j = L - i7;
                    int i13 = 1;
                    if (z4) {
                        for (int i14 = 0; i14 < appBarLayout.getChildCount(); i14++) {
                            LayoutParams layoutParams2 = (LayoutParams) appBarLayout.getChildAt(i14).getLayoutParams();
                            c0 c0Var = layoutParams2.f2904b;
                            if (c0Var != null && (layoutParams2.f2903a & 1) != 0) {
                                View childAt2 = appBarLayout.getChildAt(i14);
                                Rect rect = (Rect) c0Var.f725b;
                                childAt2.getDrawingRect(rect);
                                appBarLayout.offsetDescendantRectToMyCoords(childAt2, rect);
                                rect.offset(0, -appBarLayout.getTopInset());
                                float abs2 = ((Rect) c0Var.f725b).top - Math.abs(w());
                                if (abs2 <= 0.0f) {
                                    float K = 1.0f - com.google.common.collect.c.K(Math.abs(abs2 / ((Rect) c0Var.f725b).height()), 0.0f, 1.0f);
                                    float height = (-abs2) - ((((Rect) c0Var.f725b).height() * 0.3f) * (1.0f - (K * K)));
                                    childAt2.setTranslationY(height);
                                    childAt2.getDrawingRect((Rect) c0Var.f726c);
                                    ((Rect) c0Var.f726c).offset(0, (int) (-height));
                                    WeakHashMap weakHashMap3 = y0.f4999a;
                                    i0.c(childAt2, (Rect) c0Var.f726c);
                                } else {
                                    WeakHashMap weakHashMap4 = y0.f4999a;
                                    i0.c(childAt2, null);
                                    childAt2.setTranslationY(0.0f);
                                }
                            }
                        }
                    }
                    if (!z4 && appBarLayout.f2872e) {
                        coordinatorLayout.m(appBarLayout);
                    }
                    appBarLayout.c(w());
                    if (L < x4) {
                        i13 = -1;
                    }
                    M(coordinatorLayout, appBarLayout, L, i13, false);
                    i9 = i12;
                }
            } else {
                this.f2892j = 0;
            }
            L(coordinatorLayout, appBarLayout);
            return i9;
        }

        public final void G(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i4) {
            int height;
            int abs = Math.abs(x() - i4);
            float abs2 = Math.abs(0.0f);
            float f4 = abs;
            if (abs2 > 0.0f) {
                height = Math.round((f4 / abs2) * 1000.0f) * 3;
            } else {
                height = (int) (((f4 / appBarLayout.getHeight()) + 1.0f) * 150.0f);
            }
            int x4 = x();
            if (x4 == i4) {
                ValueAnimator valueAnimator = this.f2894l;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    this.f2894l.cancel();
                    return;
                }
                return;
            }
            ValueAnimator valueAnimator2 = this.f2894l;
            if (valueAnimator2 == null) {
                ValueAnimator valueAnimator3 = new ValueAnimator();
                this.f2894l = valueAnimator3;
                valueAnimator3.setInterpolator(p1.a.f6132e);
                this.f2894l.addUpdateListener(new b(this, coordinatorLayout, appBarLayout));
            } else {
                valueAnimator2.cancel();
            }
            this.f2894l.setDuration(Math.min(height, 600));
            this.f2894l.setIntValues(x4, i4);
            this.f2894l.start();
        }

        public final void I(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i4, int[] iArr) {
            int i5;
            int i6;
            if (i4 != 0) {
                if (i4 < 0) {
                    i5 = -appBarLayout.getTotalScrollRange();
                    i6 = appBarLayout.getDownNestedPreScrollRange() + i5;
                } else {
                    i5 = -appBarLayout.getUpNestedPreScrollRange();
                    i6 = 0;
                }
                int i7 = i5;
                int i8 = i6;
                if (i7 != i8) {
                    iArr[1] = E(coordinatorLayout, appBarLayout, x() - i4, i7, i8);
                }
            }
            if (appBarLayout.f2879l) {
                appBarLayout.d(appBarLayout.e(view));
            }
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [com.google.android.material.appbar.AppBarLayout$BaseBehavior$SavedState, androidx.customview.view.AbsSavedState] */
        public final SavedState J(Parcelable parcelable, AppBarLayout appBarLayout) {
            boolean z4;
            boolean z5;
            int w4 = w();
            int childCount = appBarLayout.getChildCount();
            boolean z6 = false;
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = appBarLayout.getChildAt(i4);
                int bottom = childAt.getBottom() + w4;
                if (childAt.getTop() + w4 <= 0 && bottom >= 0) {
                    if (parcelable == null) {
                        parcelable = AbsSavedState.f1459b;
                    }
                    ?? absSavedState = new AbsSavedState(parcelable);
                    if (w4 == 0) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    absSavedState.f2899d = z4;
                    if (!z4 && (-w4) >= appBarLayout.getTotalScrollRange()) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    absSavedState.f2898c = z5;
                    absSavedState.f2900e = i4;
                    WeakHashMap weakHashMap = y0.f4999a;
                    if (bottom == appBarLayout.getTopInset() + g0.d(childAt)) {
                        z6 = true;
                    }
                    absSavedState.f2902g = z6;
                    absSavedState.f2901f = bottom / childAt.getHeight();
                    return absSavedState;
                }
            }
            return null;
        }

        public final void K(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            int paddingTop = appBarLayout.getPaddingTop() + appBarLayout.getTopInset();
            int x4 = x() - paddingTop;
            int childCount = appBarLayout.getChildCount();
            int i4 = 0;
            while (true) {
                if (i4 < childCount) {
                    View childAt = appBarLayout.getChildAt(i4);
                    int top = childAt.getTop();
                    int bottom = childAt.getBottom();
                    LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                    if ((layoutParams.f2903a & 32) == 32) {
                        top -= ((LinearLayout.LayoutParams) layoutParams).topMargin;
                        bottom += ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                    }
                    int i5 = -x4;
                    if (top <= i5 && bottom >= i5) {
                        break;
                    }
                    i4++;
                } else {
                    i4 = -1;
                    break;
                }
            }
            if (i4 >= 0) {
                View childAt2 = appBarLayout.getChildAt(i4);
                LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
                int i6 = layoutParams2.f2903a;
                if ((i6 & 17) == 17) {
                    int i7 = -childAt2.getTop();
                    int i8 = -childAt2.getBottom();
                    if (i4 == 0) {
                        WeakHashMap weakHashMap = y0.f4999a;
                        if (g0.b(appBarLayout) && g0.b(childAt2)) {
                            i7 -= appBarLayout.getTopInset();
                        }
                    }
                    if ((i6 & 2) == 2) {
                        WeakHashMap weakHashMap2 = y0.f4999a;
                        i8 += g0.d(childAt2);
                    } else if ((i6 & 5) == 5) {
                        WeakHashMap weakHashMap3 = y0.f4999a;
                        int d4 = g0.d(childAt2) + i8;
                        if (x4 < d4) {
                            i7 = d4;
                        } else {
                            i8 = d4;
                        }
                    }
                    if ((i6 & 32) == 32) {
                        i7 += ((LinearLayout.LayoutParams) layoutParams2).topMargin;
                        i8 -= ((LinearLayout.LayoutParams) layoutParams2).bottomMargin;
                    }
                    if (x4 < (i8 + i7) / 2) {
                        i7 = i8;
                    }
                    G(coordinatorLayout, appBarLayout, com.google.common.collect.c.L(i7 + paddingTop, -appBarLayout.getTotalScrollRange(), 0));
                }
            }
        }

        public final void L(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            View view;
            y0.l(j0.g.f5080h.a(), coordinatorLayout);
            y0.m(j0.g.f5081i.a(), coordinatorLayout);
            boolean z4 = false;
            y0.i(0, coordinatorLayout);
            if (appBarLayout.getTotalScrollRange() == 0) {
                return;
            }
            int childCount = coordinatorLayout.getChildCount();
            int i4 = 0;
            while (true) {
                if (i4 < childCount) {
                    View childAt = coordinatorLayout.getChildAt(i4);
                    if (((androidx.coordinatorlayout.widget.b) childAt.getLayoutParams()).f1347a instanceof ScrollingViewBehavior) {
                        view = childAt;
                        break;
                    }
                    i4++;
                } else {
                    view = null;
                    break;
                }
            }
            if (view == null) {
                return;
            }
            int childCount2 = appBarLayout.getChildCount();
            for (int i5 = 0; i5 < childCount2; i5++) {
                if (((LayoutParams) appBarLayout.getChildAt(i5).getLayoutParams()).f2903a != 0) {
                    if (y0.d(coordinatorLayout) == null) {
                        y0.p(coordinatorLayout, new c(this));
                    }
                    boolean z5 = true;
                    if (x() != (-appBarLayout.getTotalScrollRange())) {
                        y0.n(coordinatorLayout, j0.g.f5080h, null, new e(appBarLayout, false));
                        z4 = true;
                    }
                    if (x() != 0) {
                        if (view.canScrollVertically(-1)) {
                            int i6 = -appBarLayout.getDownNestedPreScrollRange();
                            if (i6 != 0) {
                                y0.n(coordinatorLayout, j0.g.f5081i, null, new d(this, coordinatorLayout, appBarLayout, view, i6));
                            }
                        } else {
                            y0.n(coordinatorLayout, j0.g.f5081i, null, new e(appBarLayout, true));
                        }
                        this.f2897o = z5;
                        return;
                    }
                    z5 = z4;
                    this.f2897o = z5;
                    return;
                }
            }
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final boolean l(CoordinatorLayout coordinatorLayout, View view, int i4) {
            boolean z4;
            int round;
            AppBarLayout appBarLayout = (AppBarLayout) view;
            super.l(coordinatorLayout, appBarLayout, i4);
            int pendingAction = appBarLayout.getPendingAction();
            SavedState savedState = this.f2895m;
            if (savedState != null && (pendingAction & 8) == 0) {
                if (savedState.f2898c) {
                    F(coordinatorLayout, appBarLayout, -appBarLayout.getTotalScrollRange());
                } else if (savedState.f2899d) {
                    F(coordinatorLayout, appBarLayout, 0);
                } else {
                    View childAt = appBarLayout.getChildAt(savedState.f2900e);
                    int i5 = -childAt.getBottom();
                    if (this.f2895m.f2902g) {
                        WeakHashMap weakHashMap = y0.f4999a;
                        round = appBarLayout.getTopInset() + g0.d(childAt) + i5;
                    } else {
                        round = Math.round(childAt.getHeight() * this.f2895m.f2901f) + i5;
                    }
                    F(coordinatorLayout, appBarLayout, round);
                }
            } else if (pendingAction != 0) {
                if ((pendingAction & 4) != 0) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if ((pendingAction & 2) != 0) {
                    int i6 = -appBarLayout.getUpNestedPreScrollRange();
                    if (z4) {
                        G(coordinatorLayout, appBarLayout, i6);
                    } else {
                        F(coordinatorLayout, appBarLayout, i6);
                    }
                } else if ((pendingAction & 1) != 0) {
                    if (z4) {
                        G(coordinatorLayout, appBarLayout, 0);
                    } else {
                        F(coordinatorLayout, appBarLayout, 0);
                    }
                }
            }
            appBarLayout.f2873f = 0;
            this.f2895m = null;
            z(com.google.common.collect.c.L(w(), -appBarLayout.getTotalScrollRange(), 0));
            M(coordinatorLayout, appBarLayout, w(), 0, true);
            appBarLayout.c(w());
            L(coordinatorLayout, appBarLayout);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final boolean m(CoordinatorLayout coordinatorLayout, View view, int i4, int i5, int i6) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            if (((ViewGroup.MarginLayoutParams) ((androidx.coordinatorlayout.widget.b) appBarLayout.getLayoutParams())).height != -2) {
                return false;
            }
            coordinatorLayout.w(appBarLayout, i4, i5, View.MeasureSpec.makeMeasureSpec(0, 0));
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final /* bridge */ /* synthetic */ void o(CoordinatorLayout coordinatorLayout, View view, View view2, int i4, int i5, int[] iArr, int i6) {
            I(coordinatorLayout, (AppBarLayout) view, view2, i5, iArr);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final void p(CoordinatorLayout coordinatorLayout, View view, int i4, int i5, int i6, int[] iArr) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            if (i6 < 0) {
                iArr[1] = E(coordinatorLayout, appBarLayout, x() - i6, -appBarLayout.getDownNestedScrollRange(), 0);
            }
            if (i6 == 0) {
                L(coordinatorLayout, appBarLayout);
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final void r(View view, Parcelable parcelable) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            if (parcelable instanceof SavedState) {
                this.f2895m = (SavedState) parcelable;
            } else {
                this.f2895m = null;
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final Parcelable s(View view) {
            android.view.AbsSavedState absSavedState = View.BaseSavedState.EMPTY_STATE;
            SavedState J = J(absSavedState, (AppBarLayout) view);
            if (J != null) {
                return J;
            }
            return absSavedState;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final boolean t(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i4, int i5) {
            boolean z4;
            ValueAnimator valueAnimator;
            AppBarLayout appBarLayout = (AppBarLayout) view;
            if ((i4 & 2) != 0 && (appBarLayout.f2879l || (appBarLayout.getTotalScrollRange() != 0 && coordinatorLayout.getHeight() - view2.getHeight() <= appBarLayout.getHeight()))) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (z4 && (valueAnimator = this.f2894l) != null) {
                valueAnimator.cancel();
            }
            this.f2896n = null;
            this.f2893k = i5;
            return z4;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final void u(CoordinatorLayout coordinatorLayout, View view, View view2, int i4) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            if (this.f2893k == 0 || i4 == 1) {
                K(coordinatorLayout, appBarLayout);
                if (appBarLayout.f2879l) {
                    appBarLayout.d(appBarLayout.e(view2));
                }
            }
            this.f2896n = new WeakReference(view2);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public final int x() {
            return w() + this.f2892j;
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    /* loaded from: classes.dex */
    public static class Behavior extends BaseBehavior<AppBarLayout> {
        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    /* loaded from: classes.dex */
    public static class LayoutParams extends LinearLayout.LayoutParams {

        /* renamed from: a  reason: collision with root package name */
        public int f2903a;

        /* renamed from: b  reason: collision with root package name */
        public final c0 f2904b;

        /* renamed from: c  reason: collision with root package name */
        public final Interpolator f2905c;

        @Retention(RetentionPolicy.SOURCE)
        @RestrictTo({RestrictTo.Scope.f170b})
        /* loaded from: classes.dex */
        public @interface ScrollEffect {
        }

        @Retention(RetentionPolicy.SOURCE)
        @RestrictTo({RestrictTo.Scope.f170b})
        /* loaded from: classes.dex */
        public @interface ScrollFlags {
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            c0 c0Var;
            this.f2903a = 1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, o1.a.f5938b);
            this.f2903a = obtainStyledAttributes.getInt(1, 0);
            if (obtainStyledAttributes.getInt(0, 0) != 1) {
                c0Var = null;
            } else {
                c0Var = new c0(7);
            }
            this.f2904b = c0Var;
            if (obtainStyledAttributes.hasValue(2)) {
                this.f2905c = AnimationUtils.loadInterpolator(context, obtainStyledAttributes.getResourceId(2, 0));
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* loaded from: classes.dex */
    public static class ScrollingViewBehavior extends HeaderScrollingViewBehavior {
        public ScrollingViewBehavior() {
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior
        public final AppBarLayout A(ArrayList arrayList) {
            int size = arrayList.size();
            for (int i4 = 0; i4 < size; i4++) {
                View view = (View) arrayList.get(i4);
                if (view instanceof AppBarLayout) {
                    return (AppBarLayout) view;
                }
            }
            return null;
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior
        public final float B(View view) {
            int i4;
            int i5;
            if (view instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view;
                int totalScrollRange = appBarLayout.getTotalScrollRange();
                int downNestedPreScrollRange = appBarLayout.getDownNestedPreScrollRange();
                CoordinatorLayout.Behavior behavior = ((androidx.coordinatorlayout.widget.b) appBarLayout.getLayoutParams()).f1347a;
                if (behavior instanceof BaseBehavior) {
                    i4 = ((BaseBehavior) behavior).x();
                } else {
                    i4 = 0;
                }
                if ((downNestedPreScrollRange == 0 || totalScrollRange + i4 > downNestedPreScrollRange) && (i5 = totalScrollRange - downNestedPreScrollRange) != 0) {
                    return (i4 / i5) + 1.0f;
                }
            }
            return 0.0f;
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior
        public final int C(View view) {
            if (view instanceof AppBarLayout) {
                return ((AppBarLayout) view).getTotalScrollRange();
            }
            return view.getMeasuredHeight();
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final boolean f(View view, View view2) {
            return view2 instanceof AppBarLayout;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean h(CoordinatorLayout coordinatorLayout, View view, View view2) {
            int L;
            CoordinatorLayout.Behavior behavior = ((androidx.coordinatorlayout.widget.b) view2.getLayoutParams()).f1347a;
            if (behavior instanceof BaseBehavior) {
                int bottom = (view2.getBottom() - view.getTop()) + ((BaseBehavior) behavior).f2892j + this.f2943e;
                if (this.f2944f == 0) {
                    L = 0;
                } else {
                    float B = B(view2);
                    int i4 = this.f2944f;
                    L = com.google.common.collect.c.L((int) (B * i4), 0, i4);
                }
                int i5 = bottom - L;
                WeakHashMap weakHashMap = y0.f4999a;
                view.offsetTopAndBottom(i5);
            }
            if (view2 instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view2;
                if (appBarLayout.f2879l) {
                    appBarLayout.d(appBarLayout.e(view));
                }
            }
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final void i(CoordinatorLayout coordinatorLayout, View view) {
            if (view instanceof AppBarLayout) {
                y0.l(j0.g.f5080h.a(), coordinatorLayout);
                y0.m(j0.g.f5081i.a(), coordinatorLayout);
                y0.i(0, coordinatorLayout);
                y0.p(coordinatorLayout, null);
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final boolean q(CoordinatorLayout coordinatorLayout, View view, Rect rect, boolean z4) {
            AppBarLayout appBarLayout;
            ArrayList o4 = coordinatorLayout.o(view);
            int size = o4.size();
            int i4 = 0;
            while (true) {
                if (i4 < size) {
                    View view2 = (View) o4.get(i4);
                    if (view2 instanceof AppBarLayout) {
                        appBarLayout = (AppBarLayout) view2;
                        break;
                    }
                    i4++;
                } else {
                    appBarLayout = null;
                    break;
                }
            }
            if (appBarLayout != null) {
                Rect rect2 = new Rect(rect);
                rect2.offset(view.getLeft(), view.getTop());
                int width = coordinatorLayout.getWidth();
                int height = coordinatorLayout.getHeight();
                Rect rect3 = this.f2941c;
                rect3.set(0, 0, width, height);
                if (!rect3.contains(rect2)) {
                    appBarLayout.setExpanded(false, !z4);
                    return true;
                }
            }
            return false;
        }

        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, o1.a.S);
            this.f2944f = obtainStyledAttributes.getDimensionPixelSize(0, 0);
            obtainStyledAttributes.recycle();
        }
    }

    public AppBarLayout(@NonNull Context context) {
        this(context, null);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.google.android.material.appbar.AppBarLayout$LayoutParams, android.widget.LinearLayout$LayoutParams] */
    /* JADX WARN: Type inference failed for: r0v3, types: [com.google.android.material.appbar.AppBarLayout$LayoutParams, android.widget.LinearLayout$LayoutParams] */
    /* JADX WARN: Type inference failed for: r0v4, types: [com.google.android.material.appbar.AppBarLayout$LayoutParams, android.widget.LinearLayout$LayoutParams] */
    public static LayoutParams a(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            ?? layoutParams2 = new LinearLayout.LayoutParams((LinearLayout.LayoutParams) layoutParams);
            layoutParams2.f2903a = 1;
            return layoutParams2;
        } else if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ?? layoutParams3 = new LinearLayout.LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
            layoutParams3.f2903a = 1;
            return layoutParams3;
        } else {
            ?? layoutParams4 = new LinearLayout.LayoutParams(layoutParams);
            layoutParams4.f2903a = 1;
            return layoutParams4;
        }
    }

    @Nullable
    private ColorStateList getBackgroundCSL() {
        ColorStateList b5;
        Drawable background = getBackground();
        if (background instanceof ColorDrawable) {
            return ColorStateList.valueOf(((ColorDrawable) background).getColor());
        }
        if (Build.VERSION.SDK_INT >= 29) {
            b5 = h.b(background);
            return b5;
        }
        return null;
    }

    public final void b() {
        BaseBehavior.SavedState savedState;
        Behavior behavior = this.f2891x;
        if (behavior != null && this.f2869b != -1 && this.f2873f == 0) {
            savedState = behavior.J(AbsSavedState.f1459b, this);
        } else {
            savedState = null;
        }
        this.f2869b = -1;
        this.f2870c = -1;
        this.f2871d = -1;
        if (savedState != null) {
            Behavior behavior2 = this.f2891x;
            if (behavior2.f2895m == null) {
                behavior2.f2895m = savedState;
            }
        }
    }

    public final void c(int i4) {
        int i5;
        int L;
        this.f2868a = i4;
        if (!willNotDraw()) {
            WeakHashMap weakHashMap = y0.f4999a;
            g0.k(this);
        }
        ArrayList arrayList = this.f2875h;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i6 = 0; i6 < size; i6++) {
                g gVar = (g) this.f2875h.get(i6);
                if (gVar != null) {
                    CollapsingToolbarLayout collapsingToolbarLayout = ((j) gVar).f2965a;
                    collapsingToolbarLayout.f2930y = i4;
                    g2 g2Var = collapsingToolbarLayout.A;
                    if (g2Var != null) {
                        i5 = g2Var.d();
                    } else {
                        i5 = 0;
                    }
                    int childCount = collapsingToolbarLayout.getChildCount();
                    for (int i7 = 0; i7 < childCount; i7++) {
                        View childAt = collapsingToolbarLayout.getChildAt(i7);
                        CollapsingToolbarLayout.LayoutParams layoutParams = (CollapsingToolbarLayout.LayoutParams) childAt.getLayoutParams();
                        m b5 = CollapsingToolbarLayout.b(childAt);
                        int i8 = layoutParams.f2932a;
                        if (i8 != 1) {
                            if (i8 == 2) {
                                L = Math.round((-i4) * layoutParams.f2933b);
                            }
                        } else {
                            L = com.google.common.collect.c.L(-i4, 0, ((collapsingToolbarLayout.getHeight() - CollapsingToolbarLayout.b(childAt).f2970b) - childAt.getHeight()) - ((FrameLayout.LayoutParams) ((CollapsingToolbarLayout.LayoutParams) childAt.getLayoutParams())).bottomMargin);
                        }
                        b5.b(L);
                    }
                    collapsingToolbarLayout.d();
                    if (collapsingToolbarLayout.f2921p != null && i5 > 0) {
                        WeakHashMap weakHashMap2 = y0.f4999a;
                        g0.k(collapsingToolbarLayout);
                    }
                    int height = collapsingToolbarLayout.getHeight();
                    WeakHashMap weakHashMap3 = y0.f4999a;
                    int d4 = (height - g0.d(collapsingToolbarLayout)) - i5;
                    float scrimVisibleHeightTrigger = height - collapsingToolbarLayout.getScrimVisibleHeightTrigger();
                    float f4 = d4;
                    float min = Math.min(1.0f, scrimVisibleHeightTrigger / f4);
                    com.google.android.material.internal.d dVar = collapsingToolbarLayout.f2916k;
                    dVar.f3497d = min;
                    dVar.f3499e = androidx.activity.j.a(1.0f, min, 0.5f, min);
                    dVar.f3501f = collapsingToolbarLayout.f2930y + d4;
                    dVar.p(Math.abs(i4) / f4);
                }
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0027, code lost:
        if (r5 != false) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0029, code lost:
        r2 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002a, code lost:
        g(r3, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0035, code lost:
        if (r5 != false) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:?, code lost:
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean d(boolean r5) {
        /*
            r4 = this;
            boolean r0 = r4.f2876i
            r1 = 1
            r0 = r0 ^ r1
            if (r0 == 0) goto L38
            boolean r0 = r4.f2878k
            if (r0 == r5) goto L38
            r4.f2878k = r5
            r4.refreshDrawableState()
            boolean r0 = r4.f2879l
            if (r0 == 0) goto L39
            android.graphics.drawable.Drawable r0 = r4.getBackground()
            boolean r0 = r0 instanceof l2.j
            if (r0 == 0) goto L39
            android.content.res.ColorStateList r0 = r4.f2882o
            r2 = 0
            if (r0 == 0) goto L2e
            r0 = 1132396544(0x437f0000, float:255.0)
            if (r5 == 0) goto L26
            r3 = r2
            goto L27
        L26:
            r3 = r0
        L27:
            if (r5 == 0) goto L2a
        L29:
            r2 = r0
        L2a:
            r4.g(r3, r2)
            goto L39
        L2e:
            float r0 = r4.f2890w
            if (r5 == 0) goto L34
            r3 = r2
            goto L35
        L34:
            r3 = r0
        L35:
            if (r5 == 0) goto L2a
            goto L29
        L38:
            r1 = 0
        L39:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.AppBarLayout.d(boolean):boolean");
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f2889v != null && getTopInset() > 0) {
            int save = canvas.save();
            canvas.translate(0.0f, -this.f2868a);
            this.f2889v.draw(canvas);
            canvas.restoreToCount(save);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f2889v;
        if (drawable != null && drawable.isStateful() && drawable.setState(drawableState)) {
            invalidateDrawable(drawable);
        }
    }

    public final boolean e(View view) {
        int i4;
        View view2;
        View view3 = null;
        if (this.f2881n == null && (i4 = this.f2880m) != -1) {
            if (view != null) {
                view2 = view.findViewById(i4);
            } else {
                view2 = null;
            }
            if (view2 == null && (getParent() instanceof ViewGroup)) {
                view2 = ((ViewGroup) getParent()).findViewById(this.f2880m);
            }
            if (view2 != null) {
                this.f2881n = new WeakReference(view2);
            }
        }
        WeakReference weakReference = this.f2881n;
        if (weakReference != null) {
            view3 = (View) weakReference.get();
        }
        if (view3 != null) {
            view = view3;
        }
        if (view != null && (view.canScrollVertically(-1) || view.getScrollY() > 0)) {
            return true;
        }
        return false;
    }

    public final boolean f() {
        if (getChildCount() <= 0) {
            return false;
        }
        View childAt = getChildAt(0);
        if (childAt.getVisibility() == 8) {
            return false;
        }
        WeakHashMap weakHashMap = y0.f4999a;
        if (g0.b(childAt)) {
            return false;
        }
        return true;
    }

    public final void g(float f4, float f5) {
        ValueAnimator valueAnimator = this.f2883p;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f4, f5);
        this.f2883p = ofFloat;
        ofFloat.setDuration(this.f2886s);
        this.f2883p.setInterpolator(this.f2887t);
        a aVar = this.f2884q;
        if (aVar != null) {
            this.f2883p.addUpdateListener(aVar);
        }
        this.f2883p.start();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [android.view.ViewGroup$LayoutParams, com.google.android.material.appbar.AppBarLayout$LayoutParams, android.widget.LinearLayout$LayoutParams] */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        ?? layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.f2903a = 1;
        return layoutParams;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // androidx.coordinatorlayout.widget.a
    @NonNull
    public CoordinatorLayout.Behavior<AppBarLayout> getBehavior() {
        Behavior behavior = new Behavior();
        this.f2891x = behavior;
        return behavior;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int getDownNestedPreScrollRange() {
        /*
            r9 = this;
            int r0 = r9.f2870c
            r1 = -1
            if (r0 == r1) goto L6
            return r0
        L6:
            int r0 = r9.getChildCount()
            int r0 = r0 + (-1)
            r1 = 0
            r2 = r1
        Le:
            if (r0 < 0) goto L69
            android.view.View r3 = r9.getChildAt(r0)
            int r4 = r3.getVisibility()
            r5 = 8
            if (r4 != r5) goto L1d
            goto L66
        L1d:
            android.view.ViewGroup$LayoutParams r4 = r3.getLayoutParams()
            com.google.android.material.appbar.AppBarLayout$LayoutParams r4 = (com.google.android.material.appbar.AppBarLayout.LayoutParams) r4
            int r5 = r3.getMeasuredHeight()
            int r6 = r4.f2903a
            r7 = r6 & 5
            r8 = 5
            if (r7 != r8) goto L63
            int r7 = r4.topMargin
            int r4 = r4.bottomMargin
            int r7 = r7 + r4
            r4 = r6 & 8
            if (r4 == 0) goto L3f
            java.util.WeakHashMap r4 = i0.y0.f4999a
            int r4 = i0.g0.d(r3)
        L3d:
            int r4 = r4 + r7
            goto L4e
        L3f:
            r4 = r6 & 2
            if (r4 == 0) goto L4c
            java.util.WeakHashMap r4 = i0.y0.f4999a
            int r4 = i0.g0.d(r3)
            int r4 = r5 - r4
            goto L3d
        L4c:
            int r4 = r7 + r5
        L4e:
            if (r0 != 0) goto L61
            java.util.WeakHashMap r6 = i0.y0.f4999a
            boolean r3 = i0.g0.b(r3)
            if (r3 == 0) goto L61
            int r3 = r9.getTopInset()
            int r5 = r5 - r3
            int r4 = java.lang.Math.min(r4, r5)
        L61:
            int r2 = r2 + r4
            goto L66
        L63:
            if (r2 <= 0) goto L66
            goto L69
        L66:
            int r0 = r0 + (-1)
            goto Le
        L69:
            int r0 = java.lang.Math.max(r1, r2)
            r9.f2870c = r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.AppBarLayout.getDownNestedPreScrollRange():int");
    }

    public int getDownNestedScrollRange() {
        int i4 = this.f2871d;
        if (i4 != -1) {
            return i4;
        }
        int childCount = getChildCount();
        int i5 = 0;
        int i6 = 0;
        while (true) {
            if (i5 >= childCount) {
                break;
            }
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredHeight = ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin + childAt.getMeasuredHeight();
                int i7 = layoutParams.f2903a;
                if ((i7 & 1) == 0) {
                    break;
                }
                i6 += measuredHeight;
                if ((i7 & 2) != 0) {
                    WeakHashMap weakHashMap = y0.f4999a;
                    i6 -= g0.d(childAt);
                    break;
                }
            }
            i5++;
        }
        int max = Math.max(0, i6);
        this.f2871d = max;
        return max;
    }

    @IdRes
    public int getLiftOnScrollTargetViewId() {
        return this.f2880m;
    }

    public final int getMinimumHeightForVisibleOverlappingContent() {
        int topInset = getTopInset();
        WeakHashMap weakHashMap = y0.f4999a;
        int d4 = g0.d(this);
        if (d4 == 0) {
            int childCount = getChildCount();
            if (childCount >= 1) {
                d4 = g0.d(getChildAt(childCount - 1));
            } else {
                d4 = 0;
            }
            if (d4 == 0) {
                return getHeight() / 3;
            }
        }
        return (d4 * 2) + topInset;
    }

    public int getPendingAction() {
        return this.f2873f;
    }

    @Nullable
    public Drawable getStatusBarForeground() {
        return this.f2889v;
    }

    @Deprecated
    public float getTargetElevation() {
        return 0.0f;
    }

    @VisibleForTesting
    public final int getTopInset() {
        g2 g2Var = this.f2874g;
        if (g2Var != null) {
            return g2Var.d();
        }
        return 0;
    }

    public final int getTotalScrollRange() {
        int i4 = this.f2869b;
        if (i4 != -1) {
            return i4;
        }
        int childCount = getChildCount();
        int i5 = 0;
        int i6 = 0;
        while (true) {
            if (i5 >= childCount) {
                break;
            }
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredHeight = childAt.getMeasuredHeight();
                int i7 = layoutParams.f2903a;
                if ((i7 & 1) == 0) {
                    break;
                }
                int i8 = measuredHeight + ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin + i6;
                if (i5 == 0) {
                    WeakHashMap weakHashMap = y0.f4999a;
                    if (g0.b(childAt)) {
                        i8 -= getTopInset();
                    }
                }
                i6 = i8;
                if ((i7 & 2) != 0) {
                    WeakHashMap weakHashMap2 = y0.f4999a;
                    i6 -= g0.d(childAt);
                    break;
                }
            }
            i5++;
        }
        int max = Math.max(0, i6);
        this.f2869b = max;
        return max;
    }

    public int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.google.common.collect.c.Q1(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final int[] onCreateDrawableState(int i4) {
        if (this.f2888u == null) {
            this.f2888u = new int[4];
        }
        int[] iArr = this.f2888u;
        int[] onCreateDrawableState = super.onCreateDrawableState(i4 + iArr.length);
        boolean z4 = this.f2877j;
        iArr[0] = z4 ? R.attr.state_liftable : -2130903979;
        iArr[1] = (z4 && this.f2878k) ? R.attr.state_lifted : -2130903980;
        iArr[2] = z4 ? R.attr.state_collapsible : -2130903975;
        iArr[3] = (z4 && this.f2878k) ? R.attr.state_collapsed : -2130903974;
        return View.mergeDrawableStates(onCreateDrawableState, iArr);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        WeakReference weakReference = this.f2881n;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.f2881n = null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z4, int i4, int i5, int i6, int i7) {
        super.onLayout(z4, i4, i5, i6, i7);
        WeakHashMap weakHashMap = y0.f4999a;
        boolean z5 = true;
        if (g0.b(this) && f()) {
            int topInset = getTopInset();
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                getChildAt(childCount).offsetTopAndBottom(topInset);
            }
        }
        b();
        this.f2872e = false;
        int childCount2 = getChildCount();
        int i8 = 0;
        while (true) {
            if (i8 >= childCount2) {
                break;
            } else if (((LayoutParams) getChildAt(i8).getLayoutParams()).f2905c != null) {
                this.f2872e = true;
                break;
            } else {
                i8++;
            }
        }
        Drawable drawable = this.f2889v;
        if (drawable != null) {
            drawable.setBounds(0, 0, getWidth(), getTopInset());
        }
        if (!this.f2876i) {
            if (!this.f2879l) {
                int childCount3 = getChildCount();
                int i9 = 0;
                while (true) {
                    if (i9 < childCount3) {
                        int i10 = ((LayoutParams) getChildAt(i9).getLayoutParams()).f2903a;
                        if ((i10 & 1) == 1 && (i10 & 10) != 0) {
                            break;
                        }
                        i9++;
                    } else {
                        z5 = false;
                        break;
                    }
                }
            }
            if (this.f2877j != z5) {
                this.f2877j = z5;
                refreshDrawableState();
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i4, int i5) {
        super.onMeasure(i4, i5);
        int mode = View.MeasureSpec.getMode(i5);
        if (mode != 1073741824) {
            WeakHashMap weakHashMap = y0.f4999a;
            if (g0.b(this) && f()) {
                int measuredHeight = getMeasuredHeight();
                if (mode != Integer.MIN_VALUE) {
                    if (mode == 0) {
                        measuredHeight += getTopInset();
                    }
                } else {
                    measuredHeight = com.google.common.collect.c.L(getTopInset() + getMeasuredHeight(), 0, View.MeasureSpec.getSize(i5));
                }
                setMeasuredDimension(getMeasuredWidth(), measuredHeight);
            }
        }
        b();
    }

    @Override // android.view.View
    @RequiresApi(21)
    public void setElevation(float f4) {
        super.setElevation(f4);
        com.google.common.collect.c.O1(this, f4);
    }

    public void setExpanded(boolean z4) {
        WeakHashMap weakHashMap = y0.f4999a;
        setExpanded(z4, j0.c(this));
    }

    public void setLiftOnScroll(boolean z4) {
        this.f2879l = z4;
    }

    public void setLiftOnScrollTargetView(@Nullable View view) {
        this.f2880m = -1;
        if (view == null) {
            WeakReference weakReference = this.f2881n;
            if (weakReference != null) {
                weakReference.clear();
            }
            this.f2881n = null;
            return;
        }
        this.f2881n = new WeakReference(view);
    }

    public void setLiftOnScrollTargetViewId(@IdRes int i4) {
        this.f2880m = i4;
        WeakReference weakReference = this.f2881n;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.f2881n = null;
    }

    public void setLiftableOverrideEnabled(boolean z4) {
        this.f2876i = z4;
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i4) {
        if (i4 != 1) {
            throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
        }
        super.setOrientation(i4);
    }

    public void setStatusBarForeground(@Nullable Drawable drawable) {
        boolean z4;
        Drawable drawable2 = this.f2889v;
        if (drawable2 != drawable) {
            Drawable drawable3 = null;
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            if (drawable != null) {
                drawable3 = drawable.mutate();
            }
            this.f2889v = drawable3;
            boolean z5 = false;
            if (drawable3 != null) {
                if (drawable3.isStateful()) {
                    this.f2889v.setState(getDrawableState());
                }
                Drawable drawable4 = this.f2889v;
                WeakHashMap weakHashMap = y0.f4999a;
                c0.c.b(drawable4, h0.d(this));
                Drawable drawable5 = this.f2889v;
                if (getVisibility() == 0) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                drawable5.setVisible(z4, false);
                this.f2889v.setCallback(this);
            }
            if (this.f2889v != null && getTopInset() > 0) {
                z5 = true;
            }
            setWillNotDraw(true ^ z5);
            WeakHashMap weakHashMap2 = y0.f4999a;
            g0.k(this);
        }
    }

    public void setStatusBarForegroundColor(@ColorInt int i4) {
        setStatusBarForeground(new ColorDrawable(i4));
    }

    public void setStatusBarForegroundResource(@DrawableRes int i4) {
        setStatusBarForeground(com.google.common.collect.c.t0(getContext(), i4));
    }

    @Deprecated
    public void setTargetElevation(float f4) {
        n.a(this, f4);
    }

    @Override // android.view.View
    public void setVisibility(int i4) {
        super.setVisibility(i4);
        boolean z4 = i4 == 0;
        Drawable drawable = this.f2889v;
        if (drawable != null) {
            drawable.setVisible(z4, false);
        }
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f2889v;
    }

    public AppBarLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.appBarLayoutStyle);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.material.appbar.AppBarLayout$LayoutParams, android.widget.LinearLayout$LayoutParams] */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final LinearLayout.LayoutParams generateDefaultLayoutParams() {
        ?? layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.f2903a = 1;
        return layoutParams;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return a(layoutParams);
    }

    /* JADX WARN: Finally extract failed */
    public AppBarLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(p2.a.a(context, attributeSet, i4, 2131755823), attributeSet, i4);
        this.f2869b = -1;
        this.f2870c = -1;
        this.f2871d = -1;
        this.f2873f = 0;
        this.f2885r = new ArrayList();
        Context context2 = getContext();
        setOrientation(1);
        int i5 = Build.VERSION.SDK_INT;
        if (getOutlineProvider() == ViewOutlineProvider.BACKGROUND) {
            setOutlineProvider(ViewOutlineProvider.BOUNDS);
        }
        Context context3 = getContext();
        TypedArray d4 = com.google.android.material.internal.h0.d(context3, attributeSet, n.f2973a, i4, 2131755823, new int[0]);
        try {
            if (d4.hasValue(0)) {
                setStateListAnimator(AnimatorInflater.loadStateListAnimator(context3, d4.getResourceId(0, 0)));
            }
            d4.recycle();
            TypedArray d5 = com.google.android.material.internal.h0.d(context2, attributeSet, o1.a.f5936a, i4, 2131755823, new int[0]);
            Drawable drawable = d5.getDrawable(0);
            WeakHashMap weakHashMap = y0.f4999a;
            g0.q(this, drawable);
            ColorStateList a5 = i2.d.a(context2, d5, 6);
            this.f2882o = a5;
            ColorStateList backgroundCSL = getBackgroundCSL();
            if (backgroundCSL != null) {
                l2.j jVar = new l2.j();
                jVar.o(backgroundCSL);
                if (a5 != null) {
                    jVar.setAlpha(this.f2878k ? 255 : 0);
                    jVar.o(a5);
                    this.f2884q = new a(1, this, jVar);
                } else {
                    jVar.l(context2);
                    this.f2884q = new a(0, this, jVar);
                }
                g0.q(this, jVar);
            }
            this.f2886s = com.google.common.collect.c.K1(context2, R.attr.motionDurationMedium2, getResources().getInteger(R.integer.app_bar_elevation_anim_duration));
            this.f2887t = com.google.common.collect.c.L1(context2, R.attr.motionEasingStandardInterpolator, p1.a.f6128a);
            if (d5.hasValue(4)) {
                this.f2873f = d5.getBoolean(4, false) ? 1 : 2;
                requestLayout();
            }
            if (d5.hasValue(3)) {
                n.a(this, d5.getDimensionPixelSize(3, 0));
            }
            if (i5 >= 26) {
                if (d5.hasValue(2)) {
                    setKeyboardNavigationCluster(d5.getBoolean(2, false));
                }
                if (d5.hasValue(1)) {
                    setTouchscreenBlocksFocus(d5.getBoolean(1, false));
                }
            }
            this.f2890w = getResources().getDimension(R.dimen.design_appbar_elevation);
            this.f2879l = d5.getBoolean(5, false);
            this.f2880m = d5.getResourceId(7, -1);
            setStatusBarForeground(d5.getDrawable(8));
            d5.recycle();
            m0.u(this, new o0(25, this));
        } catch (Throwable th) {
            d4.recycle();
            throw th;
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final LinearLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public void setExpanded(boolean z4, boolean z5) {
        this.f2873f = (z4 ? 1 : 2) | (z5 ? 4 : 0) | 8;
        requestLayout();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ LinearLayout.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return a(layoutParams);
    }
}