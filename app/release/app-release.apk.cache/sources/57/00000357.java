package androidx.viewpager2.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.recyclerview.widget.j0;
import androidx.recyclerview.widget.p0;
import androidx.recyclerview.widget.u0;
import i0.h0;
import i0.y0;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class ViewPager2 extends ViewGroup {

    /* renamed from: a  reason: collision with root package name */
    public final Rect f2433a;

    /* renamed from: b  reason: collision with root package name */
    public final Rect f2434b;

    /* renamed from: c  reason: collision with root package name */
    public final f f2435c;

    /* renamed from: d  reason: collision with root package name */
    public int f2436d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f2437e;

    /* renamed from: f  reason: collision with root package name */
    public final e f2438f;

    /* renamed from: g  reason: collision with root package name */
    public i f2439g;

    /* renamed from: h  reason: collision with root package name */
    public int f2440h;

    /* renamed from: i  reason: collision with root package name */
    public Parcelable f2441i;

    /* renamed from: j  reason: collision with root package name */
    public o f2442j;

    /* renamed from: k  reason: collision with root package name */
    public n f2443k;

    /* renamed from: l  reason: collision with root package name */
    public d f2444l;

    /* renamed from: m  reason: collision with root package name */
    public f f2445m;

    /* renamed from: n  reason: collision with root package name */
    public androidx.appcompat.app.c f2446n;

    /* renamed from: o  reason: collision with root package name */
    public b f2447o;

    /* renamed from: p  reason: collision with root package name */
    public p0 f2448p;

    /* renamed from: q  reason: collision with root package name */
    public boolean f2449q;

    /* renamed from: r  reason: collision with root package name */
    public boolean f2450r;

    /* renamed from: s  reason: collision with root package name */
    public int f2451s;

    /* renamed from: t  reason: collision with root package name */
    public l f2452t;

    @IntRange(from = 1)
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.f171c})
    /* loaded from: classes.dex */
    public @interface OffscreenPageLimit {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.f171c})
    /* loaded from: classes.dex */
    public @interface Orientation {
    }

    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Object();

        /* renamed from: a  reason: collision with root package name */
        public int f2453a;

        /* renamed from: b  reason: collision with root package name */
        public int f2454b;

        /* renamed from: c  reason: collision with root package name */
        public Parcelable f2455c;

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i4) {
            super.writeToParcel(parcel, i4);
            parcel.writeInt(this.f2453a);
            parcel.writeInt(this.f2454b);
            parcel.writeParcelable(this.f2455c, i4);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.f171c})
    /* loaded from: classes.dex */
    public @interface ScrollState {
    }

    public ViewPager2(@NonNull Context context) {
        super(context);
        this.f2433a = new Rect();
        this.f2434b = new Rect();
        this.f2435c = new f();
        this.f2437e = false;
        this.f2438f = new e(0, this);
        this.f2440h = -1;
        this.f2448p = null;
        this.f2449q = false;
        this.f2450r = true;
        this.f2451s = -1;
        a(context, null);
    }

    /* JADX WARN: Type inference failed for: r7v18, types: [androidx.viewpager2.widget.b, java.lang.Object] */
    public final void a(Context context, AttributeSet attributeSet) {
        this.f2452t = new l(this);
        o oVar = new o(this, context);
        this.f2442j = oVar;
        WeakHashMap weakHashMap = y0.f4999a;
        oVar.setId(h0.a());
        this.f2442j.setDescendantFocusability(131072);
        i iVar = new i(this);
        this.f2439g = iVar;
        this.f2442j.setLayoutManager(iVar);
        this.f2442j.setScrollingTouchSlop(1);
        int[] iArr = g1.a.f4787a;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        if (Build.VERSION.SDK_INT >= 29) {
            saveAttributeDataForStyleable(context, iArr, attributeSet, obtainStyledAttributes, 0, 0);
        }
        try {
            setOrientation(obtainStyledAttributes.getInt(0, 0));
            obtainStyledAttributes.recycle();
            this.f2442j.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            o oVar2 = this.f2442j;
            Object obj = new Object();
            if (oVar2.f2009y == null) {
                oVar2.f2009y = new ArrayList();
            }
            oVar2.f2009y.add(obj);
            d dVar = new d(this);
            this.f2444l = dVar;
            this.f2446n = new androidx.appcompat.app.c(this, dVar, this.f2442j);
            n nVar = new n(this);
            this.f2443k = nVar;
            nVar.a(this.f2442j);
            this.f2442j.h(this.f2444l);
            f fVar = new f();
            this.f2445m = fVar;
            this.f2444l.f2460a = fVar;
            f fVar2 = new f(this, 0);
            f fVar3 = new f(this, 1);
            ((List) fVar.f2476b).add(fVar2);
            ((List) this.f2445m.f2476b).add(fVar3);
            this.f2452t.g(this.f2442j);
            f fVar4 = this.f2445m;
            ((List) fVar4.f2476b).add(this.f2435c);
            ?? obj2 = new Object();
            this.f2447o = obj2;
            ((List) this.f2445m.f2476b).add(obj2);
            o oVar3 = this.f2442j;
            attachViewToParent(oVar3, 0, oVar3.getLayoutParams());
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    public final void b() {
        j0 adapter;
        if (this.f2440h == -1 || (adapter = getAdapter()) == null) {
            return;
        }
        if (this.f2441i != null) {
            this.f2441i = null;
        }
        int max = Math.max(0, Math.min(this.f2440h, adapter.a() - 1));
        this.f2436d = max;
        this.f2440h = -1;
        this.f2442j.b0(max);
        this.f2452t.k();
    }

    public final void c(int i4, boolean z4) {
        int i5;
        int i6;
        j jVar;
        j0 adapter = getAdapter();
        boolean z5 = false;
        if (adapter == null) {
            if (this.f2440h != -1) {
                this.f2440h = Math.max(i4, 0);
            }
        } else if (adapter.a() <= 0) {
        } else {
            int min = Math.min(Math.max(i4, 0), adapter.a() - 1);
            int i7 = this.f2436d;
            if (min == i7 && this.f2444l.f2465f == 0) {
                return;
            }
            if (min == i7 && z4) {
                return;
            }
            double d4 = i7;
            this.f2436d = min;
            this.f2452t.k();
            d dVar = this.f2444l;
            if (dVar.f2465f != 0) {
                dVar.e();
                c cVar = dVar.f2466g;
                d4 = cVar.f2457a + cVar.f2458b;
            }
            d dVar2 = this.f2444l;
            dVar2.getClass();
            if (z4) {
                i5 = 2;
            } else {
                i5 = 3;
            }
            dVar2.f2464e = i5;
            dVar2.f2472m = false;
            if (dVar2.f2468i != min) {
                z5 = true;
            }
            dVar2.f2468i = min;
            dVar2.c(2);
            if (z5 && (jVar = dVar2.f2460a) != null) {
                jVar.c(min);
            }
            if (!z4) {
                this.f2442j.b0(min);
                return;
            }
            double d5 = min;
            if (Math.abs(d5 - d4) > 3.0d) {
                o oVar = this.f2442j;
                if (d5 > d4) {
                    i6 = min - 3;
                } else {
                    i6 = min + 3;
                }
                oVar.b0(i6);
                o oVar2 = this.f2442j;
                oVar2.post(new q(min, oVar2));
                return;
            }
            this.f2442j.d0(min);
        }
    }

    @Override // android.view.View
    public final boolean canScrollHorizontally(int i4) {
        return this.f2442j.canScrollHorizontally(i4);
    }

    @Override // android.view.View
    public final boolean canScrollVertically(int i4) {
        return this.f2442j.canScrollVertically(i4);
    }

    public final void d() {
        n nVar = this.f2443k;
        if (nVar == null) {
            throw new IllegalStateException("Design assumption violated.");
        }
        View e4 = nVar.e(this.f2439g);
        if (e4 == null) {
            return;
        }
        this.f2439g.getClass();
        int F = u0.F(e4);
        if (F != this.f2436d && getScrollState() == 0) {
            this.f2445m.c(F);
        }
        this.f2437e = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchRestoreInstanceState(SparseArray sparseArray) {
        Parcelable parcelable = (Parcelable) sparseArray.get(getId());
        if (parcelable instanceof SavedState) {
            int i4 = ((SavedState) parcelable).f2453a;
            sparseArray.put(this.f2442j.getId(), sparseArray.get(i4));
            sparseArray.remove(i4);
        }
        super.dispatchRestoreInstanceState(sparseArray);
        b();
    }

    @Override // android.view.ViewGroup, android.view.View
    @RequiresApi(23)
    public CharSequence getAccessibilityClassName() {
        this.f2452t.getClass();
        this.f2452t.getClass();
        return "androidx.viewpager.widget.ViewPager";
    }

    @Nullable
    public j0 getAdapter() {
        return this.f2442j.getAdapter();
    }

    public int getCurrentItem() {
        return this.f2436d;
    }

    public int getItemDecorationCount() {
        return this.f2442j.getItemDecorationCount();
    }

    public int getOffscreenPageLimit() {
        return this.f2451s;
    }

    public int getOrientation() {
        return this.f2439g.f1949p;
    }

    public int getPageSize() {
        int height;
        int paddingBottom;
        o oVar = this.f2442j;
        if (getOrientation() == 0) {
            height = oVar.getWidth() - oVar.getPaddingLeft();
            paddingBottom = oVar.getPaddingRight();
        } else {
            height = oVar.getHeight() - oVar.getPaddingTop();
            paddingBottom = oVar.getPaddingBottom();
        }
        return height - paddingBottom;
    }

    public int getScrollState() {
        return this.f2444l.f2465f;
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        this.f2452t.h(accessibilityNodeInfo);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z4, int i4, int i5, int i6, int i7) {
        int measuredWidth = this.f2442j.getMeasuredWidth();
        int measuredHeight = this.f2442j.getMeasuredHeight();
        int paddingLeft = getPaddingLeft();
        Rect rect = this.f2433a;
        rect.left = paddingLeft;
        rect.right = (i6 - i4) - getPaddingRight();
        rect.top = getPaddingTop();
        rect.bottom = (i7 - i5) - getPaddingBottom();
        Rect rect2 = this.f2434b;
        Gravity.apply(8388659, measuredWidth, measuredHeight, rect, rect2);
        this.f2442j.layout(rect2.left, rect2.top, rect2.right, rect2.bottom);
        if (this.f2437e) {
            d();
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i4, int i5) {
        measureChild(this.f2442j, i4, i5);
        int measuredWidth = this.f2442j.getMeasuredWidth();
        int measuredHeight = this.f2442j.getMeasuredHeight();
        int measuredState = this.f2442j.getMeasuredState();
        int paddingRight = getPaddingRight() + getPaddingLeft() + measuredWidth;
        int paddingTop = getPaddingTop();
        setMeasuredDimension(View.resolveSizeAndState(Math.max(paddingRight, getSuggestedMinimumWidth()), i4, measuredState), View.resolveSizeAndState(Math.max(getPaddingBottom() + paddingTop + measuredHeight, getSuggestedMinimumHeight()), i5, measuredState << 16));
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f2440h = savedState.f2454b;
        this.f2441i = savedState.f2455c;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [android.view.View$BaseSavedState, android.os.Parcelable, androidx.viewpager2.widget.ViewPager2$SavedState] */
    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        ?? baseSavedState = new View.BaseSavedState(super.onSaveInstanceState());
        baseSavedState.f2453a = this.f2442j.getId();
        int i4 = this.f2440h;
        if (i4 == -1) {
            i4 = this.f2436d;
        }
        baseSavedState.f2454b = i4;
        Parcelable parcelable = this.f2441i;
        if (parcelable != null) {
            baseSavedState.f2455c = parcelable;
        } else {
            this.f2442j.getAdapter();
        }
        return baseSavedState;
    }

    @Override // android.view.ViewGroup
    public final void onViewAdded(View view) {
        throw new IllegalStateException("ViewPager2 does not support direct child views");
    }

    @Override // android.view.View
    public final boolean performAccessibilityAction(int i4, Bundle bundle) {
        this.f2452t.getClass();
        if (i4 != 8192 && i4 != 4096) {
            return super.performAccessibilityAction(i4, bundle);
        }
        this.f2452t.i(i4, bundle);
        return true;
    }

    public void setAdapter(@Nullable j0 j0Var) {
        j0 adapter = this.f2442j.getAdapter();
        this.f2452t.f(adapter);
        e eVar = this.f2438f;
        if (adapter != null) {
            adapter.f2145a.unregisterObserver(eVar);
        }
        this.f2442j.setAdapter(j0Var);
        this.f2436d = 0;
        b();
        this.f2452t.e(j0Var);
        if (j0Var != null) {
            j0Var.f2145a.registerObserver(eVar);
        }
    }

    public void setCurrentItem(int i4) {
        setCurrentItem(i4, true);
    }

    @Override // android.view.View
    @RequiresApi(17)
    public void setLayoutDirection(int i4) {
        super.setLayoutDirection(i4);
        this.f2452t.k();
    }

    public void setOffscreenPageLimit(int i4) {
        if (i4 < 1 && i4 != -1) {
            throw new IllegalArgumentException("Offscreen page limit must be OFFSCREEN_PAGE_LIMIT_DEFAULT or a number > 0");
        }
        this.f2451s = i4;
        this.f2442j.requestLayout();
    }

    public void setOrientation(int i4) {
        this.f2439g.Z0(i4);
        this.f2452t.k();
    }

    public void setPageTransformer(@Nullable m mVar) {
        boolean z4 = this.f2449q;
        if (mVar != null) {
            if (!z4) {
                this.f2448p = this.f2442j.getItemAnimator();
                this.f2449q = true;
            }
            this.f2442j.setItemAnimator(null);
        } else if (z4) {
            this.f2442j.setItemAnimator(this.f2448p);
            this.f2448p = null;
            this.f2449q = false;
        }
        this.f2447o.getClass();
        if (mVar == null) {
            return;
        }
        this.f2447o.getClass();
        this.f2447o.getClass();
    }

    public void setUserInputEnabled(boolean z4) {
        this.f2450r = z4;
        this.f2452t.k();
    }

    public ViewPager2(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2433a = new Rect();
        this.f2434b = new Rect();
        this.f2435c = new f();
        this.f2437e = false;
        this.f2438f = new e(0, this);
        this.f2440h = -1;
        this.f2448p = null;
        this.f2449q = false;
        this.f2450r = true;
        this.f2451s = -1;
        a(context, attributeSet);
    }

    public void setCurrentItem(int i4, boolean z4) {
        if (((d) this.f2446n.f193b).f2472m) {
            throw new IllegalStateException("Cannot change current item when ViewPager2 is fake dragging");
        }
        c(i4, z4);
    }

    public ViewPager2(@NonNull Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f2433a = new Rect();
        this.f2434b = new Rect();
        this.f2435c = new f();
        this.f2437e = false;
        this.f2438f = new e(0, this);
        this.f2440h = -1;
        this.f2448p = null;
        this.f2449q = false;
        this.f2450r = true;
        this.f2451s = -1;
        a(context, attributeSet);
    }
}