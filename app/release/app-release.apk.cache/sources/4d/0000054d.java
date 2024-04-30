package com.google.android.material.navigation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Pair;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.widget.q3;
import androidx.customview.view.AbsSavedState;
import androidx.drawerlayout.widget.DrawerLayout;
import com.example.msphone.R;
import com.google.android.material.internal.NavigationMenuView;
import com.google.android.material.internal.ScrimInsetsFrameLayout;
import com.google.android.material.internal.w;
import g.r;
import i0.g2;
import i0.h0;
import i0.y0;
import java.util.ArrayList;
import java.util.WeakHashMap;
import l2.b0;
import l2.n;
import l2.p;
import l2.q;

/* loaded from: classes.dex */
public class NavigationView extends ScrimInsetsFrameLayout implements f2.b {

    /* renamed from: u  reason: collision with root package name */
    public static final int[] f3675u = {16842912};

    /* renamed from: v  reason: collision with root package name */
    public static final int[] f3676v = {-16842910};

    /* renamed from: h  reason: collision with root package name */
    public final com.google.android.material.internal.l f3677h;

    /* renamed from: i  reason: collision with root package name */
    public final w f3678i;

    /* renamed from: j  reason: collision with root package name */
    public final int f3679j;

    /* renamed from: k  reason: collision with root package name */
    public final int[] f3680k;

    /* renamed from: l  reason: collision with root package name */
    public f.l f3681l;

    /* renamed from: m  reason: collision with root package name */
    public final g.f f3682m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f3683n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f3684o;

    /* renamed from: p  reason: collision with root package name */
    public final int f3685p;

    /* renamed from: q  reason: collision with root package name */
    public final b0 f3686q;

    /* renamed from: r  reason: collision with root package name */
    public final f2.j f3687r;

    /* renamed from: s  reason: collision with root package name */
    public final f2.f f3688s;

    /* renamed from: t  reason: collision with root package name */
    public final k f3689t;

    /* loaded from: classes.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Object();

        /* renamed from: c  reason: collision with root package name */
        public Bundle f3690c;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f3690c = parcel.readBundle(classLoader);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i4) {
            super.writeToParcel(parcel, i4);
            parcel.writeBundle(this.f3690c);
        }
    }

    public NavigationView(@NonNull Context context) {
        this(context, null);
    }

    private MenuInflater getMenuInflater() {
        if (this.f3681l == null) {
            this.f3681l = new f.l(getContext());
        }
        return this.f3681l;
    }

    @Override // f2.b
    public final void a() {
        Pair h4 = h();
        DrawerLayout drawerLayout = (DrawerLayout) h4.first;
        f2.j jVar = this.f3687r;
        androidx.activity.b bVar = jVar.f4556f;
        jVar.f4556f = null;
        if (bVar != null && Build.VERSION.SDK_INT >= 34) {
            int i4 = ((DrawerLayout.LayoutParams) h4.second).f1488a;
            int i5 = a.f3691a;
            jVar.c(bVar, i4, new c1.f(3, drawerLayout, this), new u1.b(2, drawerLayout));
            return;
        }
        drawerLayout.b(this, true);
    }

    @Override // f2.b
    public final void b(androidx.activity.b bVar) {
        h();
        this.f3687r.f4556f = bVar;
    }

    @Override // f2.b
    public final void c(androidx.activity.b bVar) {
        boolean z4;
        int i4 = ((DrawerLayout.LayoutParams) h().second).f1488a;
        f2.j jVar = this.f3687r;
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
    }

    @Override // f2.b
    public final void d() {
        h();
        this.f3687r.b();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        b0 b0Var = this.f3686q;
        if (b0Var.b()) {
            Path path = b0Var.f5280e;
            if (!path.isEmpty()) {
                canvas.save();
                canvas.clipPath(path);
                super.dispatchDraw(canvas);
                canvas.restore();
                return;
            }
        }
        super.dispatchDraw(canvas);
    }

    @Override // com.google.android.material.internal.ScrimInsetsFrameLayout
    public final void e(g2 g2Var) {
        int i4;
        w wVar = this.f3678i;
        wVar.getClass();
        int d4 = g2Var.d();
        if (wVar.f3602z != d4) {
            wVar.f3602z = d4;
            if (wVar.f3578b.getChildCount() <= 0 && wVar.f3600x) {
                i4 = wVar.f3602z;
            } else {
                i4 = 0;
            }
            NavigationMenuView navigationMenuView = wVar.f3577a;
            navigationMenuView.setPadding(0, i4, 0, navigationMenuView.getPaddingBottom());
        }
        NavigationMenuView navigationMenuView2 = wVar.f3577a;
        navigationMenuView2.setPadding(0, navigationMenuView2.getPaddingTop(), 0, g2Var.a());
        y0.b(wVar.f3578b, g2Var);
    }

    public final ColorStateList f(int i4) {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(i4, typedValue, true)) {
            return null;
        }
        ColorStateList b5 = z.e.b(getContext(), typedValue.resourceId);
        if (!getContext().getTheme().resolveAttribute(R.attr.colorPrimary, typedValue, true)) {
            return null;
        }
        int i5 = typedValue.data;
        int defaultColor = b5.getDefaultColor();
        int[] iArr = f3676v;
        return new ColorStateList(new int[][]{iArr, f3675u, FrameLayout.EMPTY_STATE_SET}, new int[]{b5.getColorForState(iArr, defaultColor), i5, defaultColor});
    }

    public final InsetDrawable g(q3 q3Var, ColorStateList colorStateList) {
        TypedArray typedArray = q3Var.f879b;
        l2.j jVar = new l2.j(p.a(getContext(), typedArray.getResourceId(17, 0), typedArray.getResourceId(18, 0)).a());
        jVar.o(colorStateList);
        return new InsetDrawable((Drawable) jVar, typedArray.getDimensionPixelSize(22, 0), typedArray.getDimensionPixelSize(23, 0), typedArray.getDimensionPixelSize(21, 0), typedArray.getDimensionPixelSize(20, 0));
    }

    @VisibleForTesting
    public f2.j getBackHelper() {
        return this.f3687r;
    }

    @Nullable
    public MenuItem getCheckedItem() {
        return this.f3678i.f3581e.f3568d;
    }

    @Px
    public int getDividerInsetEnd() {
        return this.f3678i.f3596t;
    }

    @Px
    public int getDividerInsetStart() {
        return this.f3678i.f3595s;
    }

    public int getHeaderCount() {
        return this.f3678i.f3578b.getChildCount();
    }

    @Nullable
    public Drawable getItemBackground() {
        return this.f3678i.f3589m;
    }

    @Dimension
    public int getItemHorizontalPadding() {
        return this.f3678i.f3591o;
    }

    @Dimension
    public int getItemIconPadding() {
        return this.f3678i.f3593q;
    }

    @Nullable
    public ColorStateList getItemIconTintList() {
        return this.f3678i.f3588l;
    }

    public int getItemMaxLines() {
        return this.f3678i.f3601y;
    }

    @Nullable
    public ColorStateList getItemTextColor() {
        return this.f3678i.f3587k;
    }

    @Px
    public int getItemVerticalPadding() {
        return this.f3678i.f3592p;
    }

    @NonNull
    public Menu getMenu() {
        return this.f3677h;
    }

    @Px
    public int getSubheaderInsetEnd() {
        return this.f3678i.f3598v;
    }

    @Px
    public int getSubheaderInsetStart() {
        return this.f3678i.f3597u;
    }

    public final Pair h() {
        ViewParent parent = getParent();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if ((parent instanceof DrawerLayout) && (layoutParams instanceof DrawerLayout.LayoutParams)) {
            return new Pair((DrawerLayout) parent, (DrawerLayout.LayoutParams) layoutParams);
        }
        throw new IllegalStateException("NavigationView back progress requires the direct parent view to be a DrawerLayout.");
    }

    @Override // com.google.android.material.internal.ScrimInsetsFrameLayout, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.google.common.collect.c.Q1(this);
        ViewParent parent = getParent();
        if ((parent instanceof DrawerLayout) && this.f3688s.f4560a != null) {
            DrawerLayout drawerLayout = (DrawerLayout) parent;
            k kVar = this.f3689t;
            if (kVar == null) {
                drawerLayout.getClass();
            } else {
                ArrayList arrayList = drawerLayout.f1481t;
                if (arrayList != null) {
                    arrayList.remove(kVar);
                }
            }
            if (kVar != null) {
                if (drawerLayout.f1481t == null) {
                    drawerLayout.f1481t = new ArrayList();
                }
                drawerLayout.f1481t.add(kVar);
            }
        }
    }

    @Override // com.google.android.material.internal.ScrimInsetsFrameLayout, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnGlobalLayoutListener(this.f3682m);
        ViewParent parent = getParent();
        if (parent instanceof DrawerLayout) {
            DrawerLayout drawerLayout = (DrawerLayout) parent;
            k kVar = this.f3689t;
            if (kVar == null) {
                drawerLayout.getClass();
                return;
            }
            ArrayList arrayList = drawerLayout.f1481t;
            if (arrayList != null) {
                arrayList.remove(kVar);
            }
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i4, int i5) {
        int mode = View.MeasureSpec.getMode(i4);
        int i6 = this.f3679j;
        if (mode == Integer.MIN_VALUE) {
            i4 = View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i4), i6), 1073741824);
        } else if (mode == 0) {
            i4 = View.MeasureSpec.makeMeasureSpec(i6, 1073741824);
        }
        super.onMeasure(i4, i5);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.f1460a);
        this.f3677h.t(savedState.f3690c);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [android.os.Parcelable, androidx.customview.view.AbsSavedState, com.google.android.material.navigation.NavigationView$SavedState] */
    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        ?? absSavedState = new AbsSavedState(super.onSaveInstanceState());
        Bundle bundle = new Bundle();
        absSavedState.f3690c = bundle;
        this.f3677h.v(bundle);
        return absSavedState;
    }

    @Override // android.view.View
    public final void onSizeChanged(int i4, int i5, int i6, int i7) {
        int i8;
        boolean z4;
        p pVar;
        p pVar2;
        super.onSizeChanged(i4, i5, i6, i7);
        if ((getParent() instanceof DrawerLayout) && (getLayoutParams() instanceof DrawerLayout.LayoutParams) && (i8 = this.f3685p) > 0 && (getBackground() instanceof l2.j)) {
            int i9 = ((DrawerLayout.LayoutParams) getLayoutParams()).f1488a;
            WeakHashMap weakHashMap = y0.f4999a;
            if (Gravity.getAbsoluteGravity(i9, h0.d(this)) == 3) {
                z4 = true;
            } else {
                z4 = false;
            }
            l2.j jVar = (l2.j) getBackground();
            n g4 = jVar.f5310a.f5288a.g();
            g4.c(i8);
            if (z4) {
                g4.f5339e = new l2.a(0.0f);
                g4.f5342h = new l2.a(0.0f);
            } else {
                g4.f5340f = new l2.a(0.0f);
                g4.f5341g = new l2.a(0.0f);
            }
            p a5 = g4.a();
            jVar.setShapeAppearanceModel(a5);
            b0 b0Var = this.f3686q;
            b0Var.f5278c = a5;
            boolean isEmpty = b0Var.f5279d.isEmpty();
            Path path = b0Var.f5280e;
            if (!isEmpty && (pVar2 = b0Var.f5278c) != null) {
                q.f5360a.a(pVar2, 1.0f, b0Var.f5279d, null, path);
            }
            b0Var.a(this);
            RectF rectF = new RectF(0.0f, 0.0f, i4, i5);
            b0Var.f5279d = rectF;
            if (!rectF.isEmpty() && (pVar = b0Var.f5278c) != null) {
                q.f5360a.a(pVar, 1.0f, b0Var.f5279d, null, path);
            }
            b0Var.a(this);
            b0Var.f5277b = true;
            b0Var.a(this);
        }
    }

    public void setBottomInsetScrimEnabled(boolean z4) {
        this.f3684o = z4;
    }

    public void setCheckedItem(@IdRes int i4) {
        MenuItem findItem = this.f3677h.findItem(i4);
        if (findItem != null) {
            this.f3678i.f3581e.h((r) findItem);
        }
    }

    public void setDividerInsetEnd(@Px int i4) {
        w wVar = this.f3678i;
        wVar.f3596t = i4;
        wVar.m(false);
    }

    public void setDividerInsetStart(@Px int i4) {
        w wVar = this.f3678i;
        wVar.f3595s = i4;
        wVar.m(false);
    }

    @Override // android.view.View
    public void setElevation(float f4) {
        super.setElevation(f4);
        com.google.common.collect.c.O1(this, f4);
    }

    @RestrictTo({RestrictTo.Scope.f170b})
    @VisibleForTesting
    public void setForceCompatClippingEnabled(boolean z4) {
        b0 b0Var = this.f3686q;
        if (z4 != b0Var.f5276a) {
            b0Var.f5276a = z4;
            b0Var.a(this);
        }
    }

    public void setItemBackground(@Nullable Drawable drawable) {
        w wVar = this.f3678i;
        wVar.f3589m = drawable;
        wVar.m(false);
    }

    public void setItemBackgroundResource(@DrawableRes int i4) {
        Context context = getContext();
        Object obj = z.e.f7215a;
        setItemBackground(z.c.b(context, i4));
    }

    public void setItemHorizontalPadding(@Dimension int i4) {
        w wVar = this.f3678i;
        wVar.f3591o = i4;
        wVar.m(false);
    }

    public void setItemHorizontalPaddingResource(@DimenRes int i4) {
        int dimensionPixelSize = getResources().getDimensionPixelSize(i4);
        w wVar = this.f3678i;
        wVar.f3591o = dimensionPixelSize;
        wVar.m(false);
    }

    public void setItemIconPadding(@Dimension int i4) {
        w wVar = this.f3678i;
        wVar.f3593q = i4;
        wVar.m(false);
    }

    public void setItemIconPaddingResource(int i4) {
        int dimensionPixelSize = getResources().getDimensionPixelSize(i4);
        w wVar = this.f3678i;
        wVar.f3593q = dimensionPixelSize;
        wVar.m(false);
    }

    public void setItemIconSize(@Dimension int i4) {
        w wVar = this.f3678i;
        if (wVar.f3594r != i4) {
            wVar.f3594r = i4;
            wVar.f3599w = true;
            wVar.m(false);
        }
    }

    public void setItemIconTintList(@Nullable ColorStateList colorStateList) {
        w wVar = this.f3678i;
        wVar.f3588l = colorStateList;
        wVar.m(false);
    }

    public void setItemMaxLines(int i4) {
        w wVar = this.f3678i;
        wVar.f3601y = i4;
        wVar.m(false);
    }

    public void setItemTextAppearance(@StyleRes int i4) {
        w wVar = this.f3678i;
        wVar.f3585i = i4;
        wVar.m(false);
    }

    public void setItemTextAppearanceActiveBoldEnabled(boolean z4) {
        w wVar = this.f3678i;
        wVar.f3586j = z4;
        wVar.m(false);
    }

    public void setItemTextColor(@Nullable ColorStateList colorStateList) {
        w wVar = this.f3678i;
        wVar.f3587k = colorStateList;
        wVar.m(false);
    }

    public void setItemVerticalPadding(@Px int i4) {
        w wVar = this.f3678i;
        wVar.f3592p = i4;
        wVar.m(false);
    }

    public void setItemVerticalPaddingResource(@DimenRes int i4) {
        int dimensionPixelSize = getResources().getDimensionPixelSize(i4);
        w wVar = this.f3678i;
        wVar.f3592p = dimensionPixelSize;
        wVar.m(false);
    }

    public void setNavigationItemSelectedListener(@Nullable l lVar) {
    }

    @Override // android.view.View
    public void setOverScrollMode(int i4) {
        super.setOverScrollMode(i4);
        w wVar = this.f3678i;
        if (wVar != null) {
            wVar.B = i4;
            NavigationMenuView navigationMenuView = wVar.f3577a;
            if (navigationMenuView != null) {
                navigationMenuView.setOverScrollMode(i4);
            }
        }
    }

    public void setSubheaderInsetEnd(@Px int i4) {
        w wVar = this.f3678i;
        wVar.f3598v = i4;
        wVar.m(false);
    }

    public void setSubheaderInsetStart(@Px int i4) {
        w wVar = this.f3678i;
        wVar.f3597u = i4;
        wVar.m(false);
    }

    public void setTopInsetScrimEnabled(boolean z4) {
        this.f3683n = z4;
    }

    public NavigationView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.navigationViewStyle);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:62:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0228  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0252  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x02a8  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x02c8  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x02d1  */
    /* JADX WARN: Type inference failed for: r4v22 */
    /* JADX WARN: Type inference failed for: r4v23, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r4v45 */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.google.android.material.internal.l, g.p, android.view.Menu] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public NavigationView(@androidx.annotation.NonNull android.content.Context r19, @androidx.annotation.Nullable android.util.AttributeSet r20, int r21) {
        /*
            Method dump skipped, instructions count: 768
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.navigation.NavigationView.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    public void setCheckedItem(@NonNull MenuItem menuItem) {
        MenuItem findItem = this.f3677h.findItem(menuItem.getItemId());
        if (findItem != null) {
            this.f3678i.f3581e.h((r) findItem);
            return;
        }
        throw new IllegalArgumentException("Called setCheckedItem(MenuItem) with an item that is not in the current menu.");
    }
}