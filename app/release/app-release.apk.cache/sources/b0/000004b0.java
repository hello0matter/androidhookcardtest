package com.google.android.material.bottomsheet;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.activity.h;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.customview.view.AbsSavedState;
import androidx.fragment.app.n;
import com.example.msphone.R;
import com.google.android.material.appbar.i;
import f2.b;
import f2.g;
import i0.j0;
import i0.m0;
import i0.y0;
import i2.d;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.WeakHashMap;
import l2.j;
import l2.p;
import n0.e;
import t1.c;

/* loaded from: classes.dex */
public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> implements b {
    public final t1.b A;
    public final ValueAnimator B;
    public final int C;
    public int D;
    public int E;
    public final float F;
    public int G;
    public final float H;
    public boolean I;
    public boolean J;
    public final boolean K;
    public int L;
    public e M;
    public boolean N;
    public int O;
    public boolean P;
    public final float Q;
    public int R;
    public int S;
    public int T;
    public WeakReference U;
    public WeakReference V;
    public WeakReference W;
    public final ArrayList X;
    public VelocityTracker Y;
    public g Z;

    /* renamed from: a  reason: collision with root package name */
    public final int f3066a;

    /* renamed from: a0  reason: collision with root package name */
    public int f3067a0;

    /* renamed from: b  reason: collision with root package name */
    public boolean f3068b;

    /* renamed from: b0  reason: collision with root package name */
    public int f3069b0;

    /* renamed from: c  reason: collision with root package name */
    public final float f3070c;

    /* renamed from: c0  reason: collision with root package name */
    public boolean f3071c0;

    /* renamed from: d  reason: collision with root package name */
    public final int f3072d;

    /* renamed from: d0  reason: collision with root package name */
    public HashMap f3073d0;

    /* renamed from: e  reason: collision with root package name */
    public int f3074e;

    /* renamed from: e0  reason: collision with root package name */
    public final SparseIntArray f3075e0;

    /* renamed from: f  reason: collision with root package name */
    public boolean f3076f;

    /* renamed from: f0  reason: collision with root package name */
    public final t1.a f3077f0;

    /* renamed from: g  reason: collision with root package name */
    public int f3078g;

    /* renamed from: h  reason: collision with root package name */
    public final int f3079h;

    /* renamed from: i  reason: collision with root package name */
    public final j f3080i;

    /* renamed from: j  reason: collision with root package name */
    public final ColorStateList f3081j;

    /* renamed from: k  reason: collision with root package name */
    public final int f3082k;

    /* renamed from: l  reason: collision with root package name */
    public final int f3083l;

    /* renamed from: m  reason: collision with root package name */
    public int f3084m;

    /* renamed from: n  reason: collision with root package name */
    public final boolean f3085n;

    /* renamed from: o  reason: collision with root package name */
    public final boolean f3086o;

    /* renamed from: p  reason: collision with root package name */
    public final boolean f3087p;

    /* renamed from: q  reason: collision with root package name */
    public final boolean f3088q;

    /* renamed from: r  reason: collision with root package name */
    public final boolean f3089r;

    /* renamed from: s  reason: collision with root package name */
    public final boolean f3090s;

    /* renamed from: t  reason: collision with root package name */
    public final boolean f3091t;

    /* renamed from: u  reason: collision with root package name */
    public final boolean f3092u;

    /* renamed from: v  reason: collision with root package name */
    public int f3093v;

    /* renamed from: w  reason: collision with root package name */
    public int f3094w;

    /* renamed from: x  reason: collision with root package name */
    public final boolean f3095x;

    /* renamed from: y  reason: collision with root package name */
    public final p f3096y;

    /* renamed from: z  reason: collision with root package name */
    public boolean f3097z;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.f170b})
    /* loaded from: classes.dex */
    public @interface SaveFlags {
    }

    /* loaded from: classes.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Object();

        /* renamed from: c  reason: collision with root package name */
        public final int f3098c;

        /* renamed from: d  reason: collision with root package name */
        public final int f3099d;

        /* renamed from: e  reason: collision with root package name */
        public final boolean f3100e;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f3101f;

        /* renamed from: g  reason: collision with root package name */
        public final boolean f3102g;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f3098c = parcel.readInt();
            this.f3099d = parcel.readInt();
            this.f3100e = parcel.readInt() == 1;
            this.f3101f = parcel.readInt() == 1;
            this.f3102g = parcel.readInt() == 1;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i4) {
            super.writeToParcel(parcel, i4);
            parcel.writeInt(this.f3098c);
            parcel.writeInt(this.f3099d);
            parcel.writeInt(this.f3100e ? 1 : 0);
            parcel.writeInt(this.f3101f ? 1 : 0);
            parcel.writeInt(this.f3102g ? 1 : 0);
        }

        public SavedState(android.view.AbsSavedState absSavedState, BottomSheetBehavior bottomSheetBehavior) {
            super(absSavedState);
            this.f3098c = bottomSheetBehavior.L;
            this.f3099d = bottomSheetBehavior.f3074e;
            this.f3100e = bottomSheetBehavior.f3068b;
            this.f3101f = bottomSheetBehavior.I;
            this.f3102g = bottomSheetBehavior.J;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.f170b})
    /* loaded from: classes.dex */
    public @interface StableState {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.f170b})
    /* loaded from: classes.dex */
    public @interface State {
    }

    public BottomSheetBehavior() {
        this.f3066a = 0;
        this.f3068b = true;
        this.f3082k = -1;
        this.f3083l = -1;
        this.A = new t1.b(this, 0);
        this.F = 0.5f;
        this.H = -1.0f;
        this.K = true;
        this.L = 4;
        this.Q = 0.1f;
        this.X = new ArrayList();
        this.f3069b0 = -1;
        this.f3075e0 = new SparseIntArray();
        this.f3077f0 = new t1.a(this);
    }

    public static View B(View view) {
        if (view.getVisibility() != 0) {
            return null;
        }
        WeakHashMap weakHashMap = y0.f4999a;
        if (m0.p(view)) {
            return view;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                View B = B(viewGroup.getChildAt(i4));
                if (B != null) {
                    return B;
                }
            }
        }
        return null;
    }

    public static int C(int i4, int i5, int i6, int i7) {
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i4, i5, i7);
        if (i6 == -1) {
            return childMeasureSpec;
        }
        int mode = View.MeasureSpec.getMode(childMeasureSpec);
        int size = View.MeasureSpec.getSize(childMeasureSpec);
        if (mode != 1073741824) {
            if (size != 0) {
                i6 = Math.min(size, i6);
            }
            return View.MeasureSpec.makeMeasureSpec(i6, Integer.MIN_VALUE);
        }
        return View.MeasureSpec.makeMeasureSpec(Math.min(size, i6), 1073741824);
    }

    public final void A(int i4) {
        if (((View) this.U.get()) != null) {
            ArrayList arrayList = this.X;
            if (!arrayList.isEmpty()) {
                int i5 = this.G;
                if (i4 <= i5 && i5 != D()) {
                    D();
                }
                for (int i6 = 0; i6 < arrayList.size(); i6++) {
                    ((c) arrayList.get(i6)).getClass();
                }
            }
        }
    }

    public final int D() {
        if (this.f3068b) {
            return this.D;
        }
        return Math.max(this.C, this.f3089r ? 0 : this.f3094w);
    }

    public final int E(int i4) {
        if (i4 != 3) {
            if (i4 != 4) {
                if (i4 != 5) {
                    if (i4 == 6) {
                        return this.E;
                    }
                    throw new IllegalArgumentException(androidx.activity.j.b("Invalid state to get top offset: ", i4));
                }
                return this.T;
            }
            return this.G;
        }
        return D();
    }

    public final boolean F() {
        WeakReference weakReference = this.U;
        if (weakReference == null || weakReference.get() == null) {
            return false;
        }
        int[] iArr = new int[2];
        ((View) this.U.get()).getLocationOnScreen(iArr);
        return iArr[1] == 0;
    }

    public final void G(View view) {
        WeakReference weakReference;
        if (view != null || (weakReference = this.V) == null) {
            this.V = new WeakReference(view);
            M(1, view);
            return;
        }
        z(1, (View) weakReference.get());
        this.V = null;
    }

    public final void H(int i4) {
        if (i4 == -1) {
            if (!this.f3076f) {
                this.f3076f = true;
            } else {
                return;
            }
        } else if (this.f3076f || this.f3074e != i4) {
            this.f3076f = false;
            this.f3074e = Math.max(0, i4);
        } else {
            return;
        }
        Q();
    }

    public final void I(int i4) {
        String str;
        int i5;
        if (i4 != 1 && i4 != 2) {
            if (!this.I && i4 == 5) {
                Log.w("BottomSheetBehavior", "Cannot set state: " + i4);
                return;
            }
            if (i4 == 6 && this.f3068b && E(i4) <= this.D) {
                i5 = 3;
            } else {
                i5 = i4;
            }
            WeakReference weakReference = this.U;
            if (weakReference != null && weakReference.get() != null) {
                View view = (View) this.U.get();
                h hVar = new h(i5, 5, this, view);
                ViewParent parent = view.getParent();
                if (parent != null && parent.isLayoutRequested()) {
                    WeakHashMap weakHashMap = y0.f4999a;
                    if (j0.b(view)) {
                        view.post(hVar);
                        return;
                    }
                }
                hVar.run();
                return;
            }
            J(i4);
            return;
        }
        StringBuilder sb = new StringBuilder("STATE_");
        if (i4 == 1) {
            str = "DRAGGING";
        } else {
            str = "SETTLING";
        }
        throw new IllegalArgumentException(androidx.activity.j.e(sb, str, " should not be set externally."));
    }

    public final void J(int i4) {
        if (this.L == i4) {
            return;
        }
        this.L = i4;
        if (i4 != 4 && i4 != 3 && i4 != 6) {
            boolean z4 = this.I;
        }
        WeakReference weakReference = this.U;
        if (weakReference == null || ((View) weakReference.get()) == null) {
            return;
        }
        int i5 = 0;
        if (i4 == 3) {
            P(true);
        } else if (i4 == 6 || i4 == 5 || i4 == 4) {
            P(false);
        }
        O(i4, true);
        while (true) {
            ArrayList arrayList = this.X;
            if (i5 < arrayList.size()) {
                c cVar = (c) arrayList.get(i5);
                cVar.getClass();
                int i6 = BottomSheetDragHandleView.f3103m;
                cVar.f6691a.d(i4);
                i5++;
            } else {
                N();
                return;
            }
        }
    }

    public final boolean K(View view, float f4) {
        if (this.J) {
            return true;
        }
        if (view.getTop() < this.G) {
            return false;
        }
        return Math.abs(((f4 * this.Q) + ((float) view.getTop())) - ((float) this.G)) / ((float) y()) > 0.5f;
    }

    public final void L(View view, int i4, boolean z4) {
        int E = E(i4);
        e eVar = this.M;
        if (eVar == null || (!z4 ? eVar.s(view, view.getLeft(), E) : eVar.q(view.getLeft(), E))) {
            J(i4);
            return;
        }
        J(2);
        O(i4, true);
        this.A.a(i4);
    }

    public final void M(int i4, View view) {
        j0.g gVar;
        n nVar;
        int i5;
        boolean z4;
        i0.c cVar;
        if (view == null) {
            return;
        }
        z(i4, view);
        int i6 = 6;
        if (!this.f3068b && this.L != 6) {
            String string = view.getResources().getString(R.string.bottomsheet_action_expand_halfway);
            n nVar2 = new n(this, 6);
            ArrayList f4 = y0.f(view);
            int i7 = 0;
            while (true) {
                if (i7 < f4.size()) {
                    if (TextUtils.equals(string, ((AccessibilityNodeInfo.AccessibilityAction) ((j0.g) f4.get(i7)).f5088a).getLabel())) {
                        i5 = ((j0.g) f4.get(i7)).a();
                        break;
                    }
                    i7++;
                } else {
                    int i8 = 0;
                    int i9 = -1;
                    while (true) {
                        int[] iArr = y0.f5002d;
                        if (i8 >= iArr.length || i9 != -1) {
                            break;
                        }
                        int i10 = iArr[i8];
                        boolean z5 = true;
                        for (int i11 = 0; i11 < f4.size(); i11++) {
                            if (((j0.g) f4.get(i11)).a() != i10) {
                                z4 = true;
                            } else {
                                z4 = false;
                            }
                            z5 &= z4;
                        }
                        if (z5) {
                            i9 = i10;
                        }
                        i8++;
                    }
                    i5 = i9;
                }
            }
            if (i5 != -1) {
                j0.g gVar2 = new j0.g(null, i5, string, nVar2, null);
                View.AccessibilityDelegate d4 = y0.d(view);
                if (d4 == null) {
                    cVar = null;
                } else if (d4 instanceof i0.a) {
                    cVar = ((i0.a) d4).f4906a;
                } else {
                    cVar = new i0.c(d4);
                }
                if (cVar == null) {
                    cVar = new i0.c();
                }
                y0.p(view, cVar);
                y0.m(gVar2.a(), view);
                y0.f(view).add(gVar2);
                y0.i(0, view);
            }
            this.f3075e0.put(i4, i5);
        }
        if (this.I && this.L != 5) {
            y0.n(view, j0.g.f5084l, null, new n(this, 5));
        }
        int i12 = this.L;
        if (i12 != 3) {
            if (i12 != 4) {
                if (i12 == 6) {
                    y0.n(view, j0.g.f5083k, null, new n(this, 4));
                    y0.n(view, j0.g.f5082j, null, new n(this, 3));
                    return;
                }
                return;
            }
            if (this.f3068b) {
                i6 = 3;
            }
            gVar = j0.g.f5082j;
            nVar = new n(this, i6);
        } else {
            if (this.f3068b) {
                i6 = 4;
            }
            gVar = j0.g.f5083k;
            nVar = new n(this, i6);
        }
        y0.n(view, gVar, null, nVar);
    }

    public final void N() {
        WeakReference weakReference = this.U;
        if (weakReference != null) {
            M(0, (View) weakReference.get());
        }
        WeakReference weakReference2 = this.V;
        if (weakReference2 != null) {
            M(1, (View) weakReference2.get());
        }
    }

    public final void O(int i4, boolean z4) {
        boolean z5;
        j jVar = this.f3080i;
        ValueAnimator valueAnimator = this.B;
        if (i4 == 2) {
            return;
        }
        if (this.L == 3 && (this.f3095x || F())) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (this.f3097z != z5 && jVar != null) {
            this.f3097z = z5;
            float f4 = 1.0f;
            if (z4 && valueAnimator != null) {
                if (valueAnimator.isRunning()) {
                    valueAnimator.reverse();
                    return;
                }
                float f5 = jVar.f5310a.f5297j;
                if (z5) {
                    f4 = x();
                }
                valueAnimator.setFloatValues(f5, f4);
                valueAnimator.start();
                return;
            }
            if (valueAnimator != null && valueAnimator.isRunning()) {
                valueAnimator.cancel();
            }
            if (this.f3097z) {
                f4 = x();
            }
            jVar.p(f4);
        }
    }

    public final void P(boolean z4) {
        WeakReference weakReference = this.U;
        if (weakReference == null) {
            return;
        }
        ViewParent parent = ((View) weakReference.get()).getParent();
        if (parent instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount();
            if (z4) {
                if (this.f3073d0 != null) {
                    return;
                }
                this.f3073d0 = new HashMap(childCount);
            }
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = coordinatorLayout.getChildAt(i4);
                if (childAt != this.U.get() && z4) {
                    this.f3073d0.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                }
            }
            if (z4) {
                return;
            }
            this.f3073d0 = null;
        }
    }

    public final void Q() {
        View view;
        if (this.U != null) {
            w();
            if (this.L == 4 && (view = (View) this.U.get()) != null) {
                view.requestLayout();
            }
        }
    }

    @Override // f2.b
    public final void a() {
        g gVar = this.Z;
        if (gVar == null) {
            return;
        }
        androidx.activity.b bVar = gVar.f4556f;
        gVar.f4556f = null;
        int i4 = 4;
        if (bVar != null && Build.VERSION.SDK_INT >= 34) {
            boolean z4 = this.I;
            int i5 = gVar.f4554d;
            int i6 = gVar.f4553c;
            float f4 = bVar.f93c;
            if (z4) {
                androidx.appcompat.widget.e eVar = new androidx.appcompat.widget.e(4, this);
                View view = gVar.f4552b;
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, View.TRANSLATION_Y, view.getScaleY() * view.getHeight());
                ofFloat.setInterpolator(new u0.b());
                ofFloat.setDuration(p1.a.c(i6, f4, i5));
                ofFloat.addListener(new androidx.appcompat.widget.e(7, gVar));
                ofFloat.addListener(eVar);
                ofFloat.start();
                return;
            }
            AnimatorSet b5 = gVar.b();
            b5.setDuration(p1.a.c(i6, f4, i5));
            b5.start();
            I(4);
            return;
        }
        if (this.I) {
            i4 = 5;
        }
        I(i4);
    }

    @Override // f2.b
    public final void b(androidx.activity.b bVar) {
        g gVar = this.Z;
        if (gVar == null) {
            return;
        }
        gVar.f4556f = bVar;
    }

    @Override // f2.b
    public final void c(androidx.activity.b bVar) {
        g gVar = this.Z;
        if (gVar == null) {
            return;
        }
        if (gVar.f4556f == null) {
            Log.w("MaterialBackHelper", "Must call startBackProgress() before updateBackProgress()");
        }
        androidx.activity.b bVar2 = gVar.f4556f;
        gVar.f4556f = bVar;
        if (bVar2 != null) {
            gVar.c(bVar.f93c);
        }
    }

    @Override // f2.b
    public final void d() {
        g gVar = this.Z;
        if (gVar != null && gVar.a() != null) {
            AnimatorSet b5 = gVar.b();
            b5.setDuration(gVar.f4555e);
            b5.start();
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void g(androidx.coordinatorlayout.widget.b bVar) {
        this.U = null;
        this.M = null;
        this.Z = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void j() {
        this.U = null;
        this.M = null;
        this.Z = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean k(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        boolean z4;
        View view2;
        int i4;
        e eVar;
        if (view.isShown() && this.K) {
            int actionMasked = motionEvent.getActionMasked();
            View view3 = null;
            if (actionMasked == 0) {
                this.f3067a0 = -1;
                this.f3069b0 = -1;
                VelocityTracker velocityTracker = this.Y;
                if (velocityTracker != null) {
                    velocityTracker.recycle();
                    this.Y = null;
                }
            }
            if (this.Y == null) {
                this.Y = VelocityTracker.obtain();
            }
            this.Y.addMovement(motionEvent);
            if (actionMasked != 0) {
                if (actionMasked == 1 || actionMasked == 3) {
                    this.f3071c0 = false;
                    this.f3067a0 = -1;
                    if (this.N) {
                        this.N = false;
                        return false;
                    }
                }
            } else {
                int x4 = (int) motionEvent.getX();
                this.f3069b0 = (int) motionEvent.getY();
                if (this.L != 2) {
                    WeakReference weakReference = this.W;
                    if (weakReference != null) {
                        view2 = (View) weakReference.get();
                    } else {
                        view2 = null;
                    }
                    if (view2 != null && coordinatorLayout.t(view2, x4, this.f3069b0)) {
                        this.f3067a0 = motionEvent.getPointerId(motionEvent.getActionIndex());
                        this.f3071c0 = true;
                    }
                }
                if (this.f3067a0 == -1 && !coordinatorLayout.t(view, x4, this.f3069b0)) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                this.N = z4;
            }
            if (!this.N && (eVar = this.M) != null && eVar.r(motionEvent)) {
                return true;
            }
            WeakReference weakReference2 = this.W;
            if (weakReference2 != null) {
                view3 = (View) weakReference2.get();
            }
            if (actionMasked != 2 || view3 == null || this.N || this.L == 1 || coordinatorLayout.t(view3, (int) motionEvent.getX(), (int) motionEvent.getY()) || this.M == null || (i4 = this.f3069b0) == -1 || Math.abs(i4 - motionEvent.getY()) <= this.M.f5717b) {
                return false;
            }
            return true;
        }
        this.N = true;
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x00fd, code lost:
        if (r7 == (-1)) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0100, code lost:
        r9 = java.lang.Math.min(r9, r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0104, code lost:
        r6.R = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x010a, code lost:
        if (r7 == (-1)) goto L58;
     */
    /* JADX WARN: Removed duplicated region for block: B:86:0x016e A[LOOP:0: B:84:0x0166->B:86:0x016e, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x017a A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r4v7, types: [t.n, java.lang.Object] */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean l(androidx.coordinatorlayout.widget.CoordinatorLayout r7, android.view.View r8, int r9) {
        /*
            Method dump skipped, instructions count: 379
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.l(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, int):boolean");
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean m(CoordinatorLayout coordinatorLayout, View view, int i4, int i5, int i6) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(C(i4, coordinatorLayout.getPaddingRight() + coordinatorLayout.getPaddingLeft() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i5, this.f3082k, marginLayoutParams.width), C(i6, coordinatorLayout.getPaddingBottom() + coordinatorLayout.getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, this.f3083l, marginLayoutParams.height));
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean n(View view) {
        WeakReference weakReference = this.W;
        if (weakReference == null || view != weakReference.get() || this.L == 3) {
            return false;
        }
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void o(CoordinatorLayout coordinatorLayout, View view, View view2, int i4, int i5, int[] iArr, int i6) {
        View view3;
        int i7;
        int i8;
        if (i6 == 1) {
            return;
        }
        WeakReference weakReference = this.W;
        if (weakReference != null) {
            view3 = (View) weakReference.get();
        } else {
            view3 = null;
        }
        if (view2 != view3) {
            return;
        }
        int top = view.getTop();
        int i9 = top - i5;
        if (i5 > 0) {
            if (i9 < D()) {
                int D = top - D();
                iArr[1] = D;
                int i10 = -D;
                WeakHashMap weakHashMap = y0.f4999a;
                view.offsetTopAndBottom(i10);
                i8 = 3;
                J(i8);
            } else if (!this.K) {
                return;
            } else {
                iArr[1] = i5;
                i7 = -i5;
                WeakHashMap weakHashMap2 = y0.f4999a;
                view.offsetTopAndBottom(i7);
                J(1);
            }
        } else if (i5 < 0 && !view2.canScrollVertically(-1)) {
            int i11 = this.G;
            if (i9 > i11 && !this.I) {
                int i12 = top - i11;
                iArr[1] = i12;
                int i13 = -i12;
                WeakHashMap weakHashMap3 = y0.f4999a;
                view.offsetTopAndBottom(i13);
                i8 = 4;
                J(i8);
            } else if (!this.K) {
                return;
            } else {
                iArr[1] = i5;
                i7 = -i5;
                WeakHashMap weakHashMap4 = y0.f4999a;
                view.offsetTopAndBottom(i7);
                J(1);
            }
        }
        A(view.getTop());
        this.O = i5;
        this.P = true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void p(CoordinatorLayout coordinatorLayout, View view, int i4, int i5, int i6, int[] iArr) {
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void r(View view, Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        int i4 = this.f3066a;
        if (i4 != 0) {
            if (i4 == -1 || (i4 & 1) == 1) {
                this.f3074e = savedState.f3099d;
            }
            if (i4 == -1 || (i4 & 2) == 2) {
                this.f3068b = savedState.f3100e;
            }
            if (i4 == -1 || (i4 & 4) == 4) {
                this.I = savedState.f3101f;
            }
            if (i4 == -1 || (i4 & 8) == 8) {
                this.J = savedState.f3102g;
            }
        }
        int i5 = savedState.f3098c;
        if (i5 != 1 && i5 != 2) {
            this.L = i5;
        } else {
            this.L = 4;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final Parcelable s(View view) {
        return new SavedState(View.BaseSavedState.EMPTY_STATE, this);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean t(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i4, int i5) {
        this.O = 0;
        this.P = false;
        return (i4 & 2) != 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0030, code lost:
        if (r4.getTop() <= r2.E) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0071, code lost:
        if (java.lang.Math.abs(r3 - r2.D) < java.lang.Math.abs(r3 - r2.G)) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0080, code lost:
        if (r3 < java.lang.Math.abs(r3 - r2.G)) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0090, code lost:
        if (java.lang.Math.abs(r3 - r1) < java.lang.Math.abs(r3 - r2.G)) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00ac, code lost:
        if (java.lang.Math.abs(r3 - r2.E) < java.lang.Math.abs(r3 - r2.G)) goto L18;
     */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void u(androidx.coordinatorlayout.widget.CoordinatorLayout r3, android.view.View r4, android.view.View r5, int r6) {
        /*
            r2 = this;
            int r3 = r4.getTop()
            int r6 = r2.D()
            r0 = 3
            if (r3 != r6) goto Lf
            r2.J(r0)
            return
        Lf:
            java.lang.ref.WeakReference r3 = r2.W
            if (r3 == 0) goto Lb5
            java.lang.Object r3 = r3.get()
            if (r5 != r3) goto Lb5
            boolean r3 = r2.P
            if (r3 != 0) goto L1f
            goto Lb5
        L1f:
            int r3 = r2.O
            r5 = 6
            if (r3 <= 0) goto L34
            boolean r3 = r2.f3068b
            if (r3 == 0) goto L2a
            goto Laf
        L2a:
            int r3 = r4.getTop()
            int r6 = r2.E
            if (r3 <= r6) goto Laf
            goto Lae
        L34:
            boolean r3 = r2.I
            if (r3 == 0) goto L55
            android.view.VelocityTracker r3 = r2.Y
            if (r3 != 0) goto L3e
            r3 = 0
            goto L4d
        L3e:
            r6 = 1000(0x3e8, float:1.401E-42)
            float r1 = r2.f3070c
            r3.computeCurrentVelocity(r6, r1)
            android.view.VelocityTracker r3 = r2.Y
            int r6 = r2.f3067a0
            float r3 = r3.getYVelocity(r6)
        L4d:
            boolean r3 = r2.K(r4, r3)
            if (r3 == 0) goto L55
            r0 = 5
            goto Laf
        L55:
            int r3 = r2.O
            r6 = 4
            if (r3 != 0) goto L93
            int r3 = r4.getTop()
            boolean r1 = r2.f3068b
            if (r1 == 0) goto L74
            int r5 = r2.D
            int r5 = r3 - r5
            int r5 = java.lang.Math.abs(r5)
            int r1 = r2.G
            int r3 = r3 - r1
            int r3 = java.lang.Math.abs(r3)
            if (r5 >= r3) goto L97
            goto Laf
        L74:
            int r1 = r2.E
            if (r3 >= r1) goto L83
            int r6 = r2.G
            int r6 = r3 - r6
            int r6 = java.lang.Math.abs(r6)
            if (r3 >= r6) goto Lae
            goto Laf
        L83:
            int r0 = r3 - r1
            int r0 = java.lang.Math.abs(r0)
            int r1 = r2.G
            int r3 = r3 - r1
            int r3 = java.lang.Math.abs(r3)
            if (r0 >= r3) goto L97
            goto Lae
        L93:
            boolean r3 = r2.f3068b
            if (r3 == 0) goto L99
        L97:
            r0 = r6
            goto Laf
        L99:
            int r3 = r4.getTop()
            int r0 = r2.E
            int r0 = r3 - r0
            int r0 = java.lang.Math.abs(r0)
            int r1 = r2.G
            int r3 = r3 - r1
            int r3 = java.lang.Math.abs(r3)
            if (r0 >= r3) goto L97
        Lae:
            r0 = r5
        Laf:
            r3 = 0
            r2.L(r4, r0, r3)
            r2.P = r3
        Lb5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.u(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.View, int):void");
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean v(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        if (!view.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        int i4 = this.L;
        if (i4 == 1 && actionMasked == 0) {
            return true;
        }
        e eVar = this.M;
        if (eVar != null && (this.K || i4 == 1)) {
            eVar.k(motionEvent);
        }
        if (actionMasked == 0) {
            this.f3067a0 = -1;
            this.f3069b0 = -1;
            VelocityTracker velocityTracker = this.Y;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.Y = null;
            }
        }
        if (this.Y == null) {
            this.Y = VelocityTracker.obtain();
        }
        this.Y.addMovement(motionEvent);
        if (this.M != null && ((this.K || this.L == 1) && actionMasked == 2 && !this.N)) {
            float abs = Math.abs(this.f3069b0 - motionEvent.getY());
            e eVar2 = this.M;
            if (abs > eVar2.f5717b) {
                eVar2.b(motionEvent.getPointerId(motionEvent.getActionIndex()), view);
            }
        }
        return !this.N;
    }

    public final void w() {
        int y4 = y();
        if (this.f3068b) {
            this.G = Math.max(this.T - y4, this.D);
        } else {
            this.G = this.T - y4;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final float x() {
        /*
            r5 = this;
            l2.j r0 = r5.f3080i
            r1 = 0
            if (r0 == 0) goto L6f
            java.lang.ref.WeakReference r0 = r5.U
            if (r0 == 0) goto L6f
            java.lang.Object r0 = r0.get()
            if (r0 == 0) goto L6f
            int r0 = android.os.Build.VERSION.SDK_INT
            r2 = 31
            if (r0 < r2) goto L6f
            java.lang.ref.WeakReference r0 = r5.U
            java.lang.Object r0 = r0.get()
            android.view.View r0 = (android.view.View) r0
            boolean r2 = r5.F()
            if (r2 == 0) goto L6f
            android.view.WindowInsets r0 = r0.getRootWindowInsets()
            if (r0 == 0) goto L6f
            l2.j r2 = r5.f3080i
            float r2 = r2.j()
            android.view.RoundedCorner r3 = f2.h.h(r0)
            if (r3 == 0) goto L44
            int r3 = f2.h.n(r3)
            float r3 = (float) r3
            int r4 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r4 <= 0) goto L44
            int r4 = (r2 > r1 ? 1 : (r2 == r1 ? 0 : -1))
            if (r4 <= 0) goto L44
            float r3 = r3 / r2
            goto L45
        L44:
            r3 = r1
        L45:
            l2.j r2 = r5.f3080i
            l2.i r4 = r2.f5310a
            l2.p r4 = r4.f5288a
            l2.d r4 = r4.f5353f
            android.graphics.RectF r2 = r2.h()
            float r2 = r4.a(r2)
            android.view.RoundedCorner r0 = f2.h.p(r0)
            if (r0 == 0) goto L6a
            int r0 = f2.h.n(r0)
            float r0 = (float) r0
            int r4 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r4 <= 0) goto L6a
            int r4 = (r2 > r1 ? 1 : (r2 == r1 ? 0 : -1))
            if (r4 <= 0) goto L6a
            float r1 = r0 / r2
        L6a:
            float r0 = java.lang.Math.max(r3, r1)
            return r0
        L6f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.x():float");
    }

    public final int y() {
        int i4;
        return this.f3076f ? Math.min(Math.max(this.f3078g, this.T - ((this.S * 9) / 16)), this.R) + this.f3093v : (this.f3085n || this.f3086o || (i4 = this.f3084m) <= 0) ? this.f3074e + this.f3093v : Math.max(this.f3074e, i4 + this.f3079h);
    }

    public final void z(int i4, View view) {
        if (view == null) {
            return;
        }
        y0.m(524288, view);
        y0.i(0, view);
        y0.m(262144, view);
        y0.i(0, view);
        y0.m(1048576, view);
        y0.i(0, view);
        SparseIntArray sparseIntArray = this.f3075e0;
        int i5 = sparseIntArray.get(i4, -1);
        if (i5 != -1) {
            y0.m(i5, view);
            y0.i(0, view);
            sparseIntArray.delete(i4);
        }
    }

    public BottomSheetBehavior(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        int dimensionPixelOffset;
        int i4;
        this.f3066a = 0;
        this.f3068b = true;
        this.f3082k = -1;
        this.f3083l = -1;
        this.A = new t1.b(this, 0);
        this.F = 0.5f;
        this.H = -1.0f;
        this.K = true;
        this.L = 4;
        this.Q = 0.1f;
        this.X = new ArrayList();
        this.f3069b0 = -1;
        this.f3075e0 = new SparseIntArray();
        this.f3077f0 = new t1.a(this);
        this.f3079h = context.getResources().getDimensionPixelSize(R.dimen.mtrl_min_touch_target_size);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, o1.a.f5948g);
        int i5 = 3;
        if (obtainStyledAttributes.hasValue(3)) {
            this.f3081j = d.a(context, obtainStyledAttributes, 3);
        }
        if (obtainStyledAttributes.hasValue(21)) {
            this.f3096y = p.c(context, attributeSet, R.attr.bottomSheetStyle, 2131755825).a();
        }
        p pVar = this.f3096y;
        if (pVar != null) {
            j jVar = new j(pVar);
            this.f3080i = jVar;
            jVar.l(context);
            ColorStateList colorStateList = this.f3081j;
            if (colorStateList != null) {
                this.f3080i.o(colorStateList);
            } else {
                TypedValue typedValue = new TypedValue();
                context.getTheme().resolveAttribute(16842801, typedValue, true);
                this.f3080i.setTint(typedValue.data);
            }
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(x(), 1.0f);
        this.B = ofFloat;
        ofFloat.setDuration(500L);
        this.B.addUpdateListener(new i(1, this));
        this.H = obtainStyledAttributes.getDimension(2, -1.0f);
        if (obtainStyledAttributes.hasValue(0)) {
            this.f3082k = obtainStyledAttributes.getDimensionPixelSize(0, -1);
        }
        if (obtainStyledAttributes.hasValue(1)) {
            this.f3083l = obtainStyledAttributes.getDimensionPixelSize(1, -1);
        }
        TypedValue peekValue = obtainStyledAttributes.peekValue(9);
        if (peekValue == null || (i4 = peekValue.data) != -1) {
            H(obtainStyledAttributes.getDimensionPixelSize(9, -1));
        } else {
            H(i4);
        }
        boolean z4 = obtainStyledAttributes.getBoolean(8, false);
        if (this.I != z4) {
            this.I = z4;
            if (!z4 && this.L == 5) {
                I(4);
            }
            N();
        }
        this.f3085n = obtainStyledAttributes.getBoolean(13, false);
        boolean z5 = obtainStyledAttributes.getBoolean(6, true);
        if (this.f3068b != z5) {
            this.f3068b = z5;
            if (this.U != null) {
                w();
            }
            J((this.f3068b && this.L == 6) ? i5 : this.L);
            O(this.L, true);
            N();
        }
        this.J = obtainStyledAttributes.getBoolean(12, false);
        this.K = obtainStyledAttributes.getBoolean(4, true);
        this.f3066a = obtainStyledAttributes.getInt(10, 0);
        float f4 = obtainStyledAttributes.getFloat(7, 0.5f);
        if (f4 > 0.0f && f4 < 1.0f) {
            this.F = f4;
            if (this.U != null) {
                this.E = (int) ((1.0f - f4) * this.T);
            }
            TypedValue peekValue2 = obtainStyledAttributes.peekValue(5);
            if (peekValue2 == null || peekValue2.type != 16) {
                dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(5, 0);
                if (dimensionPixelOffset < 0) {
                    throw new IllegalArgumentException("offset must be greater than or equal to 0");
                }
            } else {
                dimensionPixelOffset = peekValue2.data;
                if (dimensionPixelOffset < 0) {
                    throw new IllegalArgumentException("offset must be greater than or equal to 0");
                }
            }
            this.C = dimensionPixelOffset;
            O(this.L, true);
            this.f3072d = obtainStyledAttributes.getInt(11, 500);
            this.f3086o = obtainStyledAttributes.getBoolean(17, false);
            this.f3087p = obtainStyledAttributes.getBoolean(18, false);
            this.f3088q = obtainStyledAttributes.getBoolean(19, false);
            this.f3089r = obtainStyledAttributes.getBoolean(20, true);
            this.f3090s = obtainStyledAttributes.getBoolean(14, false);
            this.f3091t = obtainStyledAttributes.getBoolean(15, false);
            this.f3092u = obtainStyledAttributes.getBoolean(16, false);
            this.f3095x = obtainStyledAttributes.getBoolean(23, true);
            obtainStyledAttributes.recycle();
            this.f3070c = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
            return;
        }
        throw new IllegalArgumentException("ratio must be a float value between 0 and 1");
    }
}