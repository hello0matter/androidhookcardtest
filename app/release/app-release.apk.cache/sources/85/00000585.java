package com.google.android.material.sidesheet;

import a0.o;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.sidesheet.SideSheetBehavior;
import f2.b;
import i0.j0;
import i0.y0;
import j0.g;
import j0.v;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.WeakHashMap;
import l2.j;
import l2.p;
import m2.d;
import n0.e;

/* loaded from: classes.dex */
public class SideSheetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> implements b {

    /* renamed from: a  reason: collision with root package name */
    public m2.a f3810a;

    /* renamed from: b  reason: collision with root package name */
    public final j f3811b;

    /* renamed from: c  reason: collision with root package name */
    public final ColorStateList f3812c;

    /* renamed from: d  reason: collision with root package name */
    public final p f3813d;

    /* renamed from: e  reason: collision with root package name */
    public final t1.b f3814e;

    /* renamed from: f  reason: collision with root package name */
    public final float f3815f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f3816g;

    /* renamed from: h  reason: collision with root package name */
    public int f3817h;

    /* renamed from: i  reason: collision with root package name */
    public e f3818i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f3819j;

    /* renamed from: k  reason: collision with root package name */
    public final float f3820k;

    /* renamed from: l  reason: collision with root package name */
    public int f3821l;

    /* renamed from: m  reason: collision with root package name */
    public int f3822m;

    /* renamed from: n  reason: collision with root package name */
    public int f3823n;

    /* renamed from: o  reason: collision with root package name */
    public int f3824o;

    /* renamed from: p  reason: collision with root package name */
    public WeakReference f3825p;

    /* renamed from: q  reason: collision with root package name */
    public WeakReference f3826q;

    /* renamed from: r  reason: collision with root package name */
    public final int f3827r;

    /* renamed from: s  reason: collision with root package name */
    public VelocityTracker f3828s;

    /* renamed from: t  reason: collision with root package name */
    public f2.j f3829t;

    /* renamed from: u  reason: collision with root package name */
    public int f3830u;

    /* renamed from: v  reason: collision with root package name */
    public final LinkedHashSet f3831v;

    /* renamed from: w  reason: collision with root package name */
    public final d f3832w;

    /* loaded from: classes.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Object();

        /* renamed from: c  reason: collision with root package name */
        public final int f3833c;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f3833c = parcel.readInt();
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i4) {
            super.writeToParcel(parcel, i4);
            parcel.writeInt(this.f3833c);
        }

        public SavedState(android.view.AbsSavedState absSavedState, SideSheetBehavior sideSheetBehavior) {
            super(absSavedState);
            this.f3833c = sideSheetBehavior.f3817h;
        }
    }

    public SideSheetBehavior() {
        this.f3814e = new t1.b(this);
        this.f3816g = true;
        this.f3817h = 5;
        this.f3820k = 0.1f;
        this.f3827r = -1;
        this.f3831v = new LinkedHashSet();
        this.f3832w = new d(this);
    }

    public final void A() {
        View view;
        WeakReference weakReference = this.f3825p;
        if (weakReference == null || (view = (View) weakReference.get()) == null) {
            return;
        }
        y0.m(262144, view);
        y0.i(0, view);
        y0.m(1048576, view);
        y0.i(0, view);
        if (this.f3817h != 5) {
            y0.n(view, g.f5084l, null, new v() { // from class: m2.b
                @Override // j0.v
                public final boolean e(View view2) {
                    SideSheetBehavior.this.w(r2);
                    return true;
                }
            });
        }
        if (this.f3817h != 3) {
            y0.n(view, g.f5082j, null, new v() { // from class: m2.b
                @Override // j0.v
                public final boolean e(View view2) {
                    SideSheetBehavior.this.w(r2);
                    return true;
                }
            });
        }
    }

    @Override // f2.b
    public final void a() {
        final View view;
        final ViewGroup.MarginLayoutParams marginLayoutParams;
        final int i4;
        f2.j jVar = this.f3829t;
        if (jVar == null) {
            return;
        }
        androidx.activity.b bVar = jVar.f4556f;
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener = null;
        jVar.f4556f = null;
        int i5 = 5;
        if (bVar != null && Build.VERSION.SDK_INT >= 34) {
            m2.a aVar = this.f3810a;
            if (aVar != null) {
                switch (aVar.f5451q) {
                    case 0:
                        i5 = 3;
                        break;
                }
            }
            androidx.appcompat.widget.e eVar = new androidx.appcompat.widget.e(9, this);
            WeakReference weakReference = this.f3826q;
            if (weakReference != null) {
                view = (View) weakReference.get();
            } else {
                view = null;
            }
            if (view != null && (marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams()) != null) {
                switch (this.f3810a.f5451q) {
                    case 0:
                        i4 = marginLayoutParams.leftMargin;
                        break;
                    default:
                        i4 = marginLayoutParams.rightMargin;
                        break;
                }
                animatorUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: m2.c
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        a aVar2 = SideSheetBehavior.this.f3810a;
                        int c4 = p1.a.c(i4, valueAnimator.getAnimatedFraction(), 0);
                        int i6 = aVar2.f5451q;
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = marginLayoutParams;
                        switch (i6) {
                            case 0:
                                marginLayoutParams2.leftMargin = c4;
                                break;
                            default:
                                marginLayoutParams2.rightMargin = c4;
                                break;
                        }
                        view.requestLayout();
                    }
                };
            }
            jVar.c(bVar, i5, eVar, animatorUpdateListener);
            return;
        }
        w(5);
    }

    @Override // f2.b
    public final void b(androidx.activity.b bVar) {
        f2.j jVar = this.f3829t;
        if (jVar == null) {
            return;
        }
        jVar.f4556f = bVar;
    }

    @Override // f2.b
    public final void c(androidx.activity.b bVar) {
        View view;
        ViewGroup.MarginLayoutParams marginLayoutParams;
        boolean z4;
        f2.j jVar = this.f3829t;
        if (jVar == null) {
            return;
        }
        m2.a aVar = this.f3810a;
        int i4 = 5;
        if (aVar != null) {
            switch (aVar.f5451q) {
                case 0:
                    i4 = 3;
                    break;
            }
        }
        if (jVar.f4556f == null) {
            Log.w("MaterialBackHelper", "Must call startBackProgress() before updateBackProgress()");
        }
        androidx.activity.b bVar2 = jVar.f4556f;
        jVar.f4556f = bVar;
        if (bVar2 != null) {
            if (bVar.f94d == 0) {
                z4 = true;
            } else {
                z4 = false;
            }
            jVar.d(i4, bVar.f93c, z4);
        }
        WeakReference weakReference = this.f3825p;
        if (weakReference != null && weakReference.get() != null) {
            View view2 = (View) this.f3825p.get();
            WeakReference weakReference2 = this.f3826q;
            if (weakReference2 != null) {
                view = (View) weakReference2.get();
            } else {
                view = null;
            }
            if (view != null && (marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams()) != null) {
                int scaleX = (int) ((view2.getScaleX() * this.f3821l) + this.f3824o);
                switch (this.f3810a.f5451q) {
                    case 0:
                        marginLayoutParams.leftMargin = scaleX;
                        break;
                    default:
                        marginLayoutParams.rightMargin = scaleX;
                        break;
                }
                view.requestLayout();
            }
        }
    }

    @Override // f2.b
    public final void d() {
        f2.j jVar = this.f3829t;
        if (jVar == null) {
            return;
        }
        jVar.b();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void g(androidx.coordinatorlayout.widget.b bVar) {
        this.f3825p = null;
        this.f3818i = null;
        this.f3829t = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void j() {
        this.f3825p = null;
        this.f3818i = null;
        this.f3829t = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean k(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        e eVar;
        VelocityTracker velocityTracker;
        if ((view.isShown() || y0.e(view) != null) && this.f3816g) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0 && (velocityTracker = this.f3828s) != null) {
                velocityTracker.recycle();
                this.f3828s = null;
            }
            if (this.f3828s == null) {
                this.f3828s = VelocityTracker.obtain();
            }
            this.f3828s.addMovement(motionEvent);
            if (actionMasked != 0) {
                if ((actionMasked == 1 || actionMasked == 3) && this.f3819j) {
                    this.f3819j = false;
                    return false;
                }
            } else {
                this.f3830u = (int) motionEvent.getX();
            }
            if (!this.f3819j && (eVar = this.f3818i) != null && eVar.r(motionEvent)) {
                return true;
            }
            return false;
        }
        this.f3819j = true;
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x0094, code lost:
        if (r5 != r0) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00df, code lost:
        if (r5 != null) goto L102;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00e1, code lost:
        r5.setShapeAppearanceModel(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x012a, code lost:
        if (r5 != null) goto L102;
     */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean l(androidx.coordinatorlayout.widget.CoordinatorLayout r10, android.view.View r11, int r12) {
        /*
            Method dump skipped, instructions count: 566
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.sidesheet.SideSheetBehavior.l(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, int):boolean");
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean m(CoordinatorLayout coordinatorLayout, View view, int i4, int i5, int i6) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(ViewGroup.getChildMeasureSpec(i4, coordinatorLayout.getPaddingRight() + coordinatorLayout.getPaddingLeft() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i5, marginLayoutParams.width), ViewGroup.getChildMeasureSpec(i6, coordinatorLayout.getPaddingBottom() + coordinatorLayout.getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, marginLayoutParams.height));
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void r(View view, Parcelable parcelable) {
        int i4 = ((SavedState) parcelable).f3833c;
        this.f3817h = (i4 == 1 || i4 == 2) ? 5 : 5;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final Parcelable s(View view) {
        return new SavedState(View.BaseSavedState.EMPTY_STATE, this);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean v(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        VelocityTracker velocityTracker;
        if (!view.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.f3817h == 1 && actionMasked == 0) {
            return true;
        }
        if (y()) {
            this.f3818i.k(motionEvent);
        }
        if (actionMasked == 0 && (velocityTracker = this.f3828s) != null) {
            velocityTracker.recycle();
            this.f3828s = null;
        }
        if (this.f3828s == null) {
            this.f3828s = VelocityTracker.obtain();
        }
        this.f3828s.addMovement(motionEvent);
        if (y() && actionMasked == 2 && !this.f3819j && y()) {
            float abs = Math.abs(this.f3830u - motionEvent.getX());
            e eVar = this.f3818i;
            if (abs > eVar.f5717b) {
                eVar.b(motionEvent.getPointerId(motionEvent.getActionIndex()), view);
            }
        }
        return !this.f3819j;
    }

    public final void w(int i4) {
        String str;
        if (i4 != 1 && i4 != 2) {
            WeakReference weakReference = this.f3825p;
            if (weakReference != null && weakReference.get() != null) {
                View view = (View) this.f3825p.get();
                o oVar = new o(i4, 1, this);
                ViewParent parent = view.getParent();
                if (parent != null && parent.isLayoutRequested()) {
                    WeakHashMap weakHashMap = y0.f4999a;
                    if (j0.b(view)) {
                        view.post(oVar);
                        return;
                    }
                }
                oVar.run();
                return;
            }
            x(i4);
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

    public final void x(int i4) {
        View view;
        int i5;
        if (this.f3817h == i4) {
            return;
        }
        this.f3817h = i4;
        WeakReference weakReference = this.f3825p;
        if (weakReference == null || (view = (View) weakReference.get()) == null) {
            return;
        }
        if (this.f3817h == 5) {
            i5 = 4;
        } else {
            i5 = 0;
        }
        if (view.getVisibility() != i5) {
            view.setVisibility(i5);
        }
        Iterator it = this.f3831v.iterator();
        if (!it.hasNext()) {
            A();
        } else {
            androidx.activity.j.f(it.next());
            throw null;
        }
    }

    public final boolean y() {
        if (this.f3818i != null && (this.f3816g || this.f3817h == 1)) {
            return true;
        }
        return false;
    }

    public final void z(View view, int i4, boolean z4) {
        int i22;
        if (i4 != 3) {
            if (i4 == 5) {
                i22 = this.f3810a.j2();
            } else {
                throw new IllegalArgumentException(androidx.activity.j.b("Invalid state to get outer edge offset: ", i4));
            }
        } else {
            i22 = this.f3810a.i2();
        }
        e eVar = this.f3818i;
        if (eVar != null && (!z4 ? eVar.s(view, i22, view.getTop()) : eVar.q(i22, view.getTop()))) {
            x(2);
            this.f3814e.a(i4);
            return;
        }
        x(i4);
    }

    public SideSheetBehavior(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3814e = new t1.b(this);
        this.f3816g = true;
        this.f3817h = 5;
        this.f3820k = 0.1f;
        this.f3827r = -1;
        this.f3831v = new LinkedHashSet();
        this.f3832w = new d(this);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, o1.a.X);
        if (obtainStyledAttributes.hasValue(3)) {
            this.f3812c = i2.d.a(context, obtainStyledAttributes, 3);
        }
        if (obtainStyledAttributes.hasValue(6)) {
            this.f3813d = p.c(context, attributeSet, 0, 2131755969).a();
        }
        if (obtainStyledAttributes.hasValue(5)) {
            int resourceId = obtainStyledAttributes.getResourceId(5, -1);
            this.f3827r = resourceId;
            WeakReference weakReference = this.f3826q;
            if (weakReference != null) {
                weakReference.clear();
            }
            this.f3826q = null;
            WeakReference weakReference2 = this.f3825p;
            if (weakReference2 != null) {
                View view = (View) weakReference2.get();
                if (resourceId != -1) {
                    WeakHashMap weakHashMap = y0.f4999a;
                    if (j0.c(view)) {
                        view.requestLayout();
                    }
                }
            }
        }
        p pVar = this.f3813d;
        if (pVar != null) {
            j jVar = new j(pVar);
            this.f3811b = jVar;
            jVar.l(context);
            ColorStateList colorStateList = this.f3812c;
            if (colorStateList != null) {
                this.f3811b.o(colorStateList);
            } else {
                TypedValue typedValue = new TypedValue();
                context.getTheme().resolveAttribute(16842801, typedValue, true);
                this.f3811b.setTint(typedValue.data);
            }
        }
        this.f3815f = obtainStyledAttributes.getDimension(2, -1.0f);
        this.f3816g = obtainStyledAttributes.getBoolean(4, true);
        obtainStyledAttributes.recycle();
        ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }
}