package com.google.android.material.navigation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
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
import androidx.appcompat.widget.q3;
import androidx.customview.view.AbsSavedState;
import com.example.msphone.R;
import com.google.android.material.internal.h0;
import g.f0;
import i0.g0;
import i0.y0;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.WeakHashMap;
import l2.p;

/* loaded from: classes.dex */
public abstract class NavigationBarView extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public static final /* synthetic */ int f3669e = 0;

    /* renamed from: a  reason: collision with root package name */
    public final e f3670a;

    /* renamed from: b  reason: collision with root package name */
    public final NavigationBarMenuView f3671b;

    /* renamed from: c  reason: collision with root package name */
    public final g f3672c;

    /* renamed from: d  reason: collision with root package name */
    public f.l f3673d;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.f170b})
    /* loaded from: classes.dex */
    public @interface LabelVisibility {
    }

    /* loaded from: classes.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Object();

        /* renamed from: c  reason: collision with root package name */
        public Bundle f3674c;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f3674c = parcel.readBundle(classLoader == null ? getClass().getClassLoader() : classLoader);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i4) {
            super.writeToParcel(parcel, i4);
            parcel.writeBundle(this.f3674c);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0, types: [com.google.android.material.navigation.g, java.lang.Object, g.d0] */
    public NavigationBarView(Context context, AttributeSet attributeSet, int i4, int i5) {
        super(p2.a.a(context, attributeSet, i4, i5), attributeSet, i4);
        ColorStateList b5;
        ?? obj = new Object();
        obj.f3696b = false;
        this.f3672c = obj;
        Context context2 = getContext();
        q3 e4 = h0.e(context2, attributeSet, o1.a.M, i4, i5, 12, 10);
        e eVar = new e(context2, getClass(), getMaxItemCount());
        this.f3670a = eVar;
        NavigationBarMenuView a5 = a(context2);
        this.f3671b = a5;
        obj.f3695a = a5;
        obj.f3697c = 1;
        a5.setPresenter(obj);
        eVar.b(obj, eVar.f4695a);
        getContext();
        obj.f3695a.E = eVar;
        TypedArray typedArray = e4.f879b;
        if (typedArray.hasValue(6)) {
            b5 = e4.a(6);
        } else {
            b5 = a5.b();
        }
        a5.setIconTintList(b5);
        setItemIconSize(typedArray.getDimensionPixelSize(5, getResources().getDimensionPixelSize(R.dimen.mtrl_navigation_bar_item_default_icon_size)));
        if (typedArray.hasValue(12)) {
            setItemTextAppearanceInactive(typedArray.getResourceId(12, 0));
        }
        if (typedArray.hasValue(10)) {
            setItemTextAppearanceActive(typedArray.getResourceId(10, 0));
        }
        setItemTextAppearanceActiveBoldEnabled(typedArray.getBoolean(11, true));
        if (typedArray.hasValue(13)) {
            setItemTextColor(e4.a(13));
        }
        if (getBackground() == null || (getBackground() instanceof ColorDrawable)) {
            p a6 = p.c(context2, attributeSet, i4, i5).a();
            l2.j jVar = new l2.j();
            Drawable background = getBackground();
            if (background instanceof ColorDrawable) {
                jVar.o(ColorStateList.valueOf(((ColorDrawable) background).getColor()));
            }
            jVar.l(context2);
            jVar.setShapeAppearanceModel(a6);
            WeakHashMap weakHashMap = y0.f4999a;
            g0.q(this, jVar);
        }
        if (typedArray.hasValue(8)) {
            setItemPaddingTop(typedArray.getDimensionPixelSize(8, 0));
        }
        if (typedArray.hasValue(7)) {
            setItemPaddingBottom(typedArray.getDimensionPixelSize(7, 0));
        }
        if (typedArray.hasValue(0)) {
            setActiveIndicatorLabelPadding(typedArray.getDimensionPixelSize(0, 0));
        }
        if (typedArray.hasValue(2)) {
            setElevation(typedArray.getDimensionPixelSize(2, 0));
        }
        c0.b.h(getBackground().mutate(), i2.d.b(context2, e4, 1));
        setLabelVisibilityMode(typedArray.getInteger(14, -1));
        int resourceId = typedArray.getResourceId(4, 0);
        if (resourceId != 0) {
            a5.setItemBackgroundRes(resourceId);
        } else {
            setItemRippleColor(i2.d.b(context2, e4, 9));
        }
        int resourceId2 = typedArray.getResourceId(3, 0);
        if (resourceId2 != 0) {
            setItemActiveIndicatorEnabled(true);
            TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(resourceId2, o1.a.L);
            setItemActiveIndicatorWidth(obtainStyledAttributes.getDimensionPixelSize(1, 0));
            setItemActiveIndicatorHeight(obtainStyledAttributes.getDimensionPixelSize(0, 0));
            setItemActiveIndicatorMarginHorizontal(obtainStyledAttributes.getDimensionPixelOffset(3, 0));
            setItemActiveIndicatorColor(i2.d.a(context2, obtainStyledAttributes, 2));
            setItemActiveIndicatorShapeAppearance(p.a(context2, obtainStyledAttributes.getResourceId(4, 0), 0).a());
            obtainStyledAttributes.recycle();
        }
        if (typedArray.hasValue(15)) {
            int resourceId3 = typedArray.getResourceId(15, 0);
            obj.f3696b = true;
            getMenuInflater().inflate(resourceId3, eVar);
            obj.f3696b = false;
            obj.m(true);
        }
        e4.g();
        addView(a5);
        eVar.f4699e = new w1.g(6, this);
    }

    private MenuInflater getMenuInflater() {
        if (this.f3673d == null) {
            this.f3673d = new f.l(getContext());
        }
        return this.f3673d;
    }

    public abstract NavigationBarMenuView a(Context context);

    @Px
    public int getActiveIndicatorLabelPadding() {
        return this.f3671b.getActiveIndicatorLabelPadding();
    }

    @Nullable
    public ColorStateList getItemActiveIndicatorColor() {
        return this.f3671b.getItemActiveIndicatorColor();
    }

    @Px
    public int getItemActiveIndicatorHeight() {
        return this.f3671b.getItemActiveIndicatorHeight();
    }

    @Px
    public int getItemActiveIndicatorMarginHorizontal() {
        return this.f3671b.getItemActiveIndicatorMarginHorizontal();
    }

    @Nullable
    public p getItemActiveIndicatorShapeAppearance() {
        return this.f3671b.getItemActiveIndicatorShapeAppearance();
    }

    @Px
    public int getItemActiveIndicatorWidth() {
        return this.f3671b.getItemActiveIndicatorWidth();
    }

    @Nullable
    public Drawable getItemBackground() {
        return this.f3671b.getItemBackground();
    }

    @DrawableRes
    @Deprecated
    public int getItemBackgroundResource() {
        return this.f3671b.getItemBackgroundRes();
    }

    @Dimension
    public int getItemIconSize() {
        return this.f3671b.getItemIconSize();
    }

    @Nullable
    public ColorStateList getItemIconTintList() {
        return this.f3671b.getIconTintList();
    }

    @Px
    public int getItemPaddingBottom() {
        return this.f3671b.getItemPaddingBottom();
    }

    @Px
    public int getItemPaddingTop() {
        return this.f3671b.getItemPaddingTop();
    }

    @Nullable
    public ColorStateList getItemRippleColor() {
        return this.f3671b.getItemRippleColor();
    }

    @StyleRes
    public int getItemTextAppearanceActive() {
        return this.f3671b.getItemTextAppearanceActive();
    }

    @StyleRes
    public int getItemTextAppearanceInactive() {
        return this.f3671b.getItemTextAppearanceInactive();
    }

    @Nullable
    public ColorStateList getItemTextColor() {
        return this.f3671b.getItemTextColor();
    }

    public int getLabelVisibilityMode() {
        return this.f3671b.getLabelVisibilityMode();
    }

    public abstract int getMaxItemCount();

    @NonNull
    public Menu getMenu() {
        return this.f3670a;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.f170b})
    public f0 getMenuView() {
        return this.f3671b;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.f170b})
    public g getPresenter() {
        return this.f3672c;
    }

    @IdRes
    public int getSelectedItemId() {
        return this.f3671b.getSelectedItemId();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.google.common.collect.c.Q1(this);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.f1460a);
        this.f3670a.t(savedState.f3674c);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [android.os.Parcelable, com.google.android.material.navigation.NavigationBarView$SavedState, androidx.customview.view.AbsSavedState] */
    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        ?? absSavedState = new AbsSavedState(super.onSaveInstanceState());
        Bundle bundle = new Bundle();
        absSavedState.f3674c = bundle;
        this.f3670a.v(bundle);
        return absSavedState;
    }

    public void setActiveIndicatorLabelPadding(@Px int i4) {
        this.f3671b.setActiveIndicatorLabelPadding(i4);
    }

    @Override // android.view.View
    public void setElevation(float f4) {
        super.setElevation(f4);
        com.google.common.collect.c.O1(this, f4);
    }

    public void setItemActiveIndicatorColor(@Nullable ColorStateList colorStateList) {
        this.f3671b.setItemActiveIndicatorColor(colorStateList);
    }

    public void setItemActiveIndicatorEnabled(boolean z4) {
        this.f3671b.setItemActiveIndicatorEnabled(z4);
    }

    public void setItemActiveIndicatorHeight(@Px int i4) {
        this.f3671b.setItemActiveIndicatorHeight(i4);
    }

    public void setItemActiveIndicatorMarginHorizontal(@Px int i4) {
        this.f3671b.setItemActiveIndicatorMarginHorizontal(i4);
    }

    public void setItemActiveIndicatorShapeAppearance(@Nullable p pVar) {
        this.f3671b.setItemActiveIndicatorShapeAppearance(pVar);
    }

    public void setItemActiveIndicatorWidth(@Px int i4) {
        this.f3671b.setItemActiveIndicatorWidth(i4);
    }

    public void setItemBackground(@Nullable Drawable drawable) {
        this.f3671b.setItemBackground(drawable);
    }

    public void setItemBackgroundResource(@DrawableRes int i4) {
        this.f3671b.setItemBackgroundRes(i4);
    }

    public void setItemIconSize(@Dimension int i4) {
        this.f3671b.setItemIconSize(i4);
    }

    public void setItemIconSizeRes(@DimenRes int i4) {
        setItemIconSize(getResources().getDimensionPixelSize(i4));
    }

    public void setItemIconTintList(@Nullable ColorStateList colorStateList) {
        this.f3671b.setIconTintList(colorStateList);
    }

    public void setItemOnTouchListener(int i4, @Nullable View.OnTouchListener onTouchListener) {
        this.f3671b.setItemOnTouchListener(i4, onTouchListener);
    }

    public void setItemPaddingBottom(@Px int i4) {
        this.f3671b.setItemPaddingBottom(i4);
    }

    public void setItemPaddingTop(@Px int i4) {
        this.f3671b.setItemPaddingTop(i4);
    }

    public void setItemRippleColor(@Nullable ColorStateList colorStateList) {
        this.f3671b.setItemRippleColor(colorStateList);
    }

    public void setItemTextAppearanceActive(@StyleRes int i4) {
        this.f3671b.setItemTextAppearanceActive(i4);
    }

    public void setItemTextAppearanceActiveBoldEnabled(boolean z4) {
        this.f3671b.setItemTextAppearanceActiveBoldEnabled(z4);
    }

    public void setItemTextAppearanceInactive(@StyleRes int i4) {
        this.f3671b.setItemTextAppearanceInactive(i4);
    }

    public void setItemTextColor(@Nullable ColorStateList colorStateList) {
        this.f3671b.setItemTextColor(colorStateList);
    }

    public void setLabelVisibilityMode(int i4) {
        NavigationBarMenuView navigationBarMenuView = this.f3671b;
        if (navigationBarMenuView.getLabelVisibilityMode() != i4) {
            navigationBarMenuView.setLabelVisibilityMode(i4);
            this.f3672c.m(false);
        }
    }

    public void setOnItemReselectedListener(@Nullable h hVar) {
    }

    public void setOnItemSelectedListener(@Nullable i iVar) {
    }

    public void setSelectedItemId(@IdRes int i4) {
        e eVar = this.f3670a;
        MenuItem findItem = eVar.findItem(i4);
        if (findItem == null || eVar.q(findItem, this.f3672c, 0)) {
            return;
        }
        findItem.setChecked(true);
    }
}