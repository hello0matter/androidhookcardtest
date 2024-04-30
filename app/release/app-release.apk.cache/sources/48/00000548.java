package com.google.android.material.navigation;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ImageView;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.recyclerview.widget.i0;
import androidx.transition.AutoTransition;
import androidx.transition.Transition;
import com.example.msphone.R;
import g.f0;
import g.r;
import i0.g0;
import i0.y0;
import java.util.HashSet;
import java.util.WeakHashMap;
import l2.p;

@RestrictTo({RestrictTo.Scope.f170b})
/* loaded from: classes.dex */
public abstract class NavigationBarMenuView extends ViewGroup implements f0 {
    public static final int[] F = {16842912};
    public static final int[] G = {-16842910};
    public p A;
    public boolean B;
    public ColorStateList C;
    public g D;
    public g.p E;

    /* renamed from: a  reason: collision with root package name */
    public final AutoTransition f3641a;

    /* renamed from: b  reason: collision with root package name */
    public final androidx.appcompat.app.b f3642b;

    /* renamed from: c  reason: collision with root package name */
    public final h0.d f3643c;

    /* renamed from: d  reason: collision with root package name */
    public final SparseArray f3644d;

    /* renamed from: e  reason: collision with root package name */
    public int f3645e;

    /* renamed from: f  reason: collision with root package name */
    public NavigationBarItemView[] f3646f;

    /* renamed from: g  reason: collision with root package name */
    public int f3647g;

    /* renamed from: h  reason: collision with root package name */
    public int f3648h;

    /* renamed from: i  reason: collision with root package name */
    public ColorStateList f3649i;

    /* renamed from: j  reason: collision with root package name */
    public int f3650j;

    /* renamed from: k  reason: collision with root package name */
    public ColorStateList f3651k;

    /* renamed from: l  reason: collision with root package name */
    public final ColorStateList f3652l;

    /* renamed from: m  reason: collision with root package name */
    public int f3653m;

    /* renamed from: n  reason: collision with root package name */
    public int f3654n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f3655o;

    /* renamed from: p  reason: collision with root package name */
    public Drawable f3656p;

    /* renamed from: q  reason: collision with root package name */
    public ColorStateList f3657q;

    /* renamed from: r  reason: collision with root package name */
    public int f3658r;

    /* renamed from: s  reason: collision with root package name */
    public final SparseArray f3659s;

    /* renamed from: t  reason: collision with root package name */
    public int f3660t;

    /* renamed from: u  reason: collision with root package name */
    public int f3661u;

    /* renamed from: v  reason: collision with root package name */
    public int f3662v;

    /* renamed from: w  reason: collision with root package name */
    public boolean f3663w;

    /* renamed from: x  reason: collision with root package name */
    public int f3664x;

    /* renamed from: y  reason: collision with root package name */
    public int f3665y;

    /* renamed from: z  reason: collision with root package name */
    public int f3666z;

    public NavigationBarMenuView(@NonNull Context context) {
        super(context);
        this.f3643c = new h0.d(5);
        this.f3644d = new SparseArray(5);
        this.f3647g = 0;
        this.f3648h = 0;
        this.f3659s = new SparseArray(5);
        this.f3660t = -1;
        this.f3661u = -1;
        this.f3662v = -1;
        this.B = false;
        this.f3652l = b();
        if (isInEditMode()) {
            this.f3641a = null;
        } else {
            AutoTransition autoTransition = new AutoTransition();
            this.f3641a = autoTransition;
            autoTransition.K(0);
            autoTransition.z(com.google.common.collect.c.K1(getContext(), R.attr.motionDurationMedium4, getResources().getInteger(R.integer.material_motion_duration_long_1)));
            autoTransition.B(com.google.common.collect.c.L1(getContext(), R.attr.motionEasingStandard, p1.a.f6129b));
            autoTransition.H(new Transition());
        }
        this.f3642b = new androidx.appcompat.app.b(5, this);
        WeakHashMap weakHashMap = y0.f4999a;
        g0.s(this, 1);
    }

    public static boolean f(int i4, int i5) {
        if (i4 == -1) {
            if (i5 <= 3) {
                return false;
            }
        } else if (i4 != 0) {
            return false;
        }
        return true;
    }

    private NavigationBarItemView getNewItem() {
        NavigationBarItemView navigationBarItemView = (NavigationBarItemView) this.f3643c.a();
        return navigationBarItemView == null ? e(getContext()) : navigationBarItemView;
    }

    private void setBadgeIfNeeded(@NonNull NavigationBarItemView navigationBarItemView) {
        q1.a aVar;
        int id = navigationBarItemView.getId();
        if (id != -1 && (aVar = (q1.a) this.f3659s.get(id)) != null) {
            navigationBarItemView.setBadge(aVar);
        }
    }

    public final void a() {
        removeAllViews();
        NavigationBarItemView[] navigationBarItemViewArr = this.f3646f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                if (navigationBarItemView != null) {
                    this.f3643c.b(navigationBarItemView);
                    if (navigationBarItemView.F != null) {
                        ImageView imageView = navigationBarItemView.f3628n;
                        if (imageView != null) {
                            navigationBarItemView.setClipChildren(true);
                            navigationBarItemView.setClipToPadding(true);
                            q1.a aVar = navigationBarItemView.F;
                            if (aVar != null) {
                                if (aVar.d() != null) {
                                    aVar.d().setForeground(null);
                                } else {
                                    imageView.getOverlay().remove(aVar);
                                }
                            }
                        }
                        navigationBarItemView.F = null;
                    }
                    navigationBarItemView.f3634t = null;
                    navigationBarItemView.f3640z = 0.0f;
                    navigationBarItemView.f3615a = false;
                }
            }
        }
        if (this.E.f4700f.size() == 0) {
            this.f3647g = 0;
            this.f3648h = 0;
            this.f3646f = null;
            return;
        }
        HashSet hashSet = new HashSet();
        for (int i4 = 0; i4 < this.E.f4700f.size(); i4++) {
            hashSet.add(Integer.valueOf(this.E.getItem(i4).getItemId()));
        }
        int i5 = 0;
        while (true) {
            SparseArray sparseArray = this.f3659s;
            if (i5 >= sparseArray.size()) {
                break;
            }
            int keyAt = sparseArray.keyAt(i5);
            if (!hashSet.contains(Integer.valueOf(keyAt))) {
                sparseArray.delete(keyAt);
            }
            i5++;
        }
        this.f3646f = new NavigationBarItemView[this.E.f4700f.size()];
        boolean f4 = f(this.f3645e, this.E.l().size());
        for (int i6 = 0; i6 < this.E.f4700f.size(); i6++) {
            this.D.f3696b = true;
            this.E.getItem(i6).setCheckable(true);
            this.D.f3696b = false;
            NavigationBarItemView newItem = getNewItem();
            this.f3646f[i6] = newItem;
            newItem.setIconTintList(this.f3649i);
            newItem.setIconSize(this.f3650j);
            newItem.setTextColor(this.f3652l);
            newItem.setTextAppearanceInactive(this.f3653m);
            newItem.setTextAppearanceActive(this.f3654n);
            newItem.setTextAppearanceActiveBoldEnabled(this.f3655o);
            newItem.setTextColor(this.f3651k);
            int i7 = this.f3660t;
            if (i7 != -1) {
                newItem.setItemPaddingTop(i7);
            }
            int i8 = this.f3661u;
            if (i8 != -1) {
                newItem.setItemPaddingBottom(i8);
            }
            int i9 = this.f3662v;
            if (i9 != -1) {
                newItem.setActiveIndicatorLabelPadding(i9);
            }
            newItem.setActiveIndicatorWidth(this.f3664x);
            newItem.setActiveIndicatorHeight(this.f3665y);
            newItem.setActiveIndicatorMarginHorizontal(this.f3666z);
            newItem.setActiveIndicatorDrawable(c());
            newItem.setActiveIndicatorResizeable(this.B);
            newItem.setActiveIndicatorEnabled(this.f3663w);
            Drawable drawable = this.f3656p;
            if (drawable != null) {
                newItem.setItemBackground(drawable);
            } else {
                newItem.setItemBackground(this.f3658r);
            }
            newItem.setItemRippleColor(this.f3657q);
            newItem.setShifting(f4);
            newItem.setLabelVisibilityMode(this.f3645e);
            r rVar = (r) this.E.getItem(i6);
            newItem.c(rVar);
            newItem.setItemPosition(i6);
            SparseArray sparseArray2 = this.f3644d;
            int i10 = rVar.f4722a;
            newItem.setOnTouchListener((View.OnTouchListener) sparseArray2.get(i10));
            newItem.setOnClickListener(this.f3642b);
            int i11 = this.f3647g;
            if (i11 != 0 && i10 == i11) {
                this.f3648h = i6;
            }
            setBadgeIfNeeded(newItem);
            addView(newItem);
        }
        int min = Math.min(this.E.f4700f.size() - 1, this.f3648h);
        this.f3648h = min;
        this.E.getItem(min).setChecked(true);
    }

    public final ColorStateList b() {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(16842808, typedValue, true)) {
            return null;
        }
        ColorStateList b5 = z.e.b(getContext(), typedValue.resourceId);
        if (!getContext().getTheme().resolveAttribute(R.attr.colorPrimary, typedValue, true)) {
            return null;
        }
        int i4 = typedValue.data;
        int defaultColor = b5.getDefaultColor();
        int[] iArr = G;
        return new ColorStateList(new int[][]{iArr, F, ViewGroup.EMPTY_STATE_SET}, new int[]{b5.getColorForState(iArr, defaultColor), i4, defaultColor});
    }

    public final l2.j c() {
        if (this.A != null && this.C != null) {
            l2.j jVar = new l2.j(this.A);
            jVar.o(this.C);
            return jVar;
        }
        return null;
    }

    @Override // g.f0
    public final void d(g.p pVar) {
        this.E = pVar;
    }

    public abstract NavigationBarItemView e(Context context);

    @Px
    public int getActiveIndicatorLabelPadding() {
        return this.f3662v;
    }

    public SparseArray<q1.a> getBadgeDrawables() {
        return this.f3659s;
    }

    @Nullable
    public ColorStateList getIconTintList() {
        return this.f3649i;
    }

    @Nullable
    public ColorStateList getItemActiveIndicatorColor() {
        return this.C;
    }

    public boolean getItemActiveIndicatorEnabled() {
        return this.f3663w;
    }

    @Px
    public int getItemActiveIndicatorHeight() {
        return this.f3665y;
    }

    @Px
    public int getItemActiveIndicatorMarginHorizontal() {
        return this.f3666z;
    }

    @Nullable
    public p getItemActiveIndicatorShapeAppearance() {
        return this.A;
    }

    @Px
    public int getItemActiveIndicatorWidth() {
        return this.f3664x;
    }

    @Nullable
    public Drawable getItemBackground() {
        NavigationBarItemView[] navigationBarItemViewArr = this.f3646f;
        return (navigationBarItemViewArr == null || navigationBarItemViewArr.length <= 0) ? this.f3656p : navigationBarItemViewArr[0].getBackground();
    }

    @Deprecated
    public int getItemBackgroundRes() {
        return this.f3658r;
    }

    @Dimension
    public int getItemIconSize() {
        return this.f3650j;
    }

    @Px
    public int getItemPaddingBottom() {
        return this.f3661u;
    }

    @Px
    public int getItemPaddingTop() {
        return this.f3660t;
    }

    @Nullable
    public ColorStateList getItemRippleColor() {
        return this.f3657q;
    }

    @StyleRes
    public int getItemTextAppearanceActive() {
        return this.f3654n;
    }

    @StyleRes
    public int getItemTextAppearanceInactive() {
        return this.f3653m;
    }

    @Nullable
    public ColorStateList getItemTextColor() {
        return this.f3651k;
    }

    public int getLabelVisibilityMode() {
        return this.f3645e;
    }

    @Nullable
    public g.p getMenu() {
        return this.E;
    }

    public int getSelectedItemId() {
        return this.f3647g;
    }

    public int getSelectedItemPosition() {
        return this.f3648h;
    }

    public int getWindowAnimations() {
        return 0;
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setCollectionInfo((AccessibilityNodeInfo.CollectionInfo) i0.h(1, this.E.l().size(), 1).f2125a);
    }

    public void setActiveIndicatorLabelPadding(@Px int i4) {
        this.f3662v = i4;
        NavigationBarItemView[] navigationBarItemViewArr = this.f3646f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setActiveIndicatorLabelPadding(i4);
            }
        }
    }

    public void setIconTintList(@Nullable ColorStateList colorStateList) {
        this.f3649i = colorStateList;
        NavigationBarItemView[] navigationBarItemViewArr = this.f3646f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setIconTintList(colorStateList);
            }
        }
    }

    public void setItemActiveIndicatorColor(@Nullable ColorStateList colorStateList) {
        this.C = colorStateList;
        NavigationBarItemView[] navigationBarItemViewArr = this.f3646f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setActiveIndicatorDrawable(c());
            }
        }
    }

    public void setItemActiveIndicatorEnabled(boolean z4) {
        this.f3663w = z4;
        NavigationBarItemView[] navigationBarItemViewArr = this.f3646f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setActiveIndicatorEnabled(z4);
            }
        }
    }

    public void setItemActiveIndicatorHeight(@Px int i4) {
        this.f3665y = i4;
        NavigationBarItemView[] navigationBarItemViewArr = this.f3646f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setActiveIndicatorHeight(i4);
            }
        }
    }

    public void setItemActiveIndicatorMarginHorizontal(@Px int i4) {
        this.f3666z = i4;
        NavigationBarItemView[] navigationBarItemViewArr = this.f3646f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setActiveIndicatorMarginHorizontal(i4);
            }
        }
    }

    public void setItemActiveIndicatorResizeable(boolean z4) {
        this.B = z4;
        NavigationBarItemView[] navigationBarItemViewArr = this.f3646f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setActiveIndicatorResizeable(z4);
            }
        }
    }

    public void setItemActiveIndicatorShapeAppearance(@Nullable p pVar) {
        this.A = pVar;
        NavigationBarItemView[] navigationBarItemViewArr = this.f3646f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setActiveIndicatorDrawable(c());
            }
        }
    }

    public void setItemActiveIndicatorWidth(@Px int i4) {
        this.f3664x = i4;
        NavigationBarItemView[] navigationBarItemViewArr = this.f3646f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setActiveIndicatorWidth(i4);
            }
        }
    }

    public void setItemBackground(@Nullable Drawable drawable) {
        this.f3656p = drawable;
        NavigationBarItemView[] navigationBarItemViewArr = this.f3646f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setItemBackground(drawable);
            }
        }
    }

    public void setItemBackgroundRes(int i4) {
        this.f3658r = i4;
        NavigationBarItemView[] navigationBarItemViewArr = this.f3646f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setItemBackground(i4);
            }
        }
    }

    public void setItemIconSize(@Dimension int i4) {
        this.f3650j = i4;
        NavigationBarItemView[] navigationBarItemViewArr = this.f3646f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setIconSize(i4);
            }
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void setItemOnTouchListener(int i4, @Nullable View.OnTouchListener onTouchListener) {
        SparseArray sparseArray = this.f3644d;
        if (onTouchListener == null) {
            sparseArray.remove(i4);
        } else {
            sparseArray.put(i4, onTouchListener);
        }
        NavigationBarItemView[] navigationBarItemViewArr = this.f3646f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                if (navigationBarItemView.getItemData().f4722a == i4) {
                    navigationBarItemView.setOnTouchListener(onTouchListener);
                }
            }
        }
    }

    public void setItemPaddingBottom(@Px int i4) {
        this.f3661u = i4;
        NavigationBarItemView[] navigationBarItemViewArr = this.f3646f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setItemPaddingBottom(i4);
            }
        }
    }

    public void setItemPaddingTop(@Px int i4) {
        this.f3660t = i4;
        NavigationBarItemView[] navigationBarItemViewArr = this.f3646f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setItemPaddingTop(i4);
            }
        }
    }

    public void setItemRippleColor(@Nullable ColorStateList colorStateList) {
        this.f3657q = colorStateList;
        NavigationBarItemView[] navigationBarItemViewArr = this.f3646f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setItemRippleColor(colorStateList);
            }
        }
    }

    public void setItemTextAppearanceActive(@StyleRes int i4) {
        this.f3654n = i4;
        NavigationBarItemView[] navigationBarItemViewArr = this.f3646f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setTextAppearanceActive(i4);
                ColorStateList colorStateList = this.f3651k;
                if (colorStateList != null) {
                    navigationBarItemView.setTextColor(colorStateList);
                }
            }
        }
    }

    public void setItemTextAppearanceActiveBoldEnabled(boolean z4) {
        this.f3655o = z4;
        NavigationBarItemView[] navigationBarItemViewArr = this.f3646f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setTextAppearanceActiveBoldEnabled(z4);
            }
        }
    }

    public void setItemTextAppearanceInactive(@StyleRes int i4) {
        this.f3653m = i4;
        NavigationBarItemView[] navigationBarItemViewArr = this.f3646f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setTextAppearanceInactive(i4);
                ColorStateList colorStateList = this.f3651k;
                if (colorStateList != null) {
                    navigationBarItemView.setTextColor(colorStateList);
                }
            }
        }
    }

    public void setItemTextColor(@Nullable ColorStateList colorStateList) {
        this.f3651k = colorStateList;
        NavigationBarItemView[] navigationBarItemViewArr = this.f3646f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setTextColor(colorStateList);
            }
        }
    }

    public void setLabelVisibilityMode(int i4) {
        this.f3645e = i4;
    }

    public void setPresenter(@NonNull g gVar) {
        this.D = gVar;
    }
}