package com.google.android.material.search;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.customview.view.AbsSavedState;
import androidx.fragment.app.m0;
import com.example.msphone.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.internal.i0;
import i0.g0;
import i0.h0;
import i0.y0;
import java.util.LinkedHashSet;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class SearchBar extends Toolbar {

    /* renamed from: l0  reason: collision with root package name */
    public static final /* synthetic */ int f3728l0 = 0;
    public final TextView T;
    public final boolean U;
    public final boolean V;
    public final m0 W;

    /* renamed from: a0  reason: collision with root package name */
    public final Drawable f3729a0;

    /* renamed from: b0  reason: collision with root package name */
    public final boolean f3730b0;

    /* renamed from: c0  reason: collision with root package name */
    public final boolean f3731c0;

    /* renamed from: d0  reason: collision with root package name */
    public View f3732d0;

    /* renamed from: e0  reason: collision with root package name */
    public final Integer f3733e0;

    /* renamed from: f0  reason: collision with root package name */
    public Drawable f3734f0;

    /* renamed from: g0  reason: collision with root package name */
    public int f3735g0;

    /* renamed from: h0  reason: collision with root package name */
    public boolean f3736h0;

    /* renamed from: i0  reason: collision with root package name */
    public final l2.j f3737i0;

    /* renamed from: j0  reason: collision with root package name */
    public final AccessibilityManager f3738j0;

    /* renamed from: k0  reason: collision with root package name */
    public final l0.d f3739k0;

    /* loaded from: classes.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Object();

        /* renamed from: c  reason: collision with root package name */
        public String f3740c;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f3740c = parcel.readString();
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i4) {
            super.writeToParcel(parcel, i4);
            parcel.writeString(this.f3740c);
        }
    }

    /* loaded from: classes.dex */
    public static class ScrollingViewBehavior extends AppBarLayout.ScrollingViewBehavior {

        /* renamed from: g  reason: collision with root package name */
        public boolean f3741g;

        public ScrollingViewBehavior() {
            this.f3741g = false;
        }

        @Override // com.google.android.material.appbar.AppBarLayout.ScrollingViewBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final boolean h(CoordinatorLayout coordinatorLayout, View view, View view2) {
            super.h(coordinatorLayout, view, view2);
            if (!this.f3741g && (view2 instanceof AppBarLayout)) {
                this.f3741g = true;
                AppBarLayout appBarLayout = (AppBarLayout) view2;
                appBarLayout.setBackgroundColor(0);
                appBarLayout.setTargetElevation(0.0f);
            }
            return false;
        }

        public ScrollingViewBehavior(@NonNull Context context, @Nullable AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f3741g = false;
        }
    }

    public SearchBar(@NonNull Context context) {
        this(context, null);
    }

    private void setNavigationIconDecorative(boolean z4) {
        ImageButton b5 = i0.b(this);
        if (b5 == null) {
            return;
        }
        b5.setClickable(!z4);
        b5.setFocusable(!z4);
        Drawable background = b5.getBackground();
        if (background != null) {
            this.f3734f0 = background;
        }
        b5.setBackgroundDrawable(z4 ? null : this.f3734f0);
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i4, ViewGroup.LayoutParams layoutParams) {
        if (this.U && this.f3732d0 == null && !(view instanceof ActionMenuView)) {
            this.f3732d0 = view;
            view.setAlpha(0.0f);
        }
        super.addView(view, i4, layoutParams);
    }

    @Nullable
    public View getCenterView() {
        return this.f3732d0;
    }

    public float getCompatElevation() {
        l2.j jVar = this.f3737i0;
        if (jVar != null) {
            return jVar.f5310a.f5301n;
        }
        WeakHashMap weakHashMap = y0.f4999a;
        return i0.m0.i(this);
    }

    public float getCornerSize() {
        return this.f3737i0.j();
    }

    @DimenRes
    @RestrictTo({RestrictTo.Scope.f170b})
    public int getDefaultMarginVerticalResource() {
        return R.dimen.m3_searchbar_margin_vertical;
    }

    @DrawableRes
    @RestrictTo({RestrictTo.Scope.f170b})
    public int getDefaultNavigationIconResource() {
        return R.drawable.ic_search_black_24;
    }

    @Nullable
    public CharSequence getHint() {
        return this.T.getHint();
    }

    public int getMenuResId() {
        return this.f3735g0;
    }

    @ColorInt
    public int getStrokeColor() {
        return this.f3737i0.f5310a.f5291d.getDefaultColor();
    }

    @Dimension
    public float getStrokeWidth() {
        return this.f3737i0.f5310a.f5298k;
    }

    @NonNull
    public CharSequence getText() {
        return this.T.getText();
    }

    @NonNull
    public TextView getTextView() {
        return this.T;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public final void n(int i4) {
        Menu menu = getMenu();
        boolean z4 = menu instanceof g.p;
        if (z4) {
            ((g.p) menu).y();
        }
        super.n(i4);
        this.f3735g0 = i4;
        if (z4) {
            ((g.p) menu).x();
        }
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.google.common.collect.c.R1(this, this.f3737i0);
        if (this.V && (getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            Resources resources = getResources();
            int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.m3_searchbar_margin_horizontal);
            int dimensionPixelSize2 = resources.getDimensionPixelSize(getDefaultMarginVerticalResource());
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
            int i4 = marginLayoutParams.leftMargin;
            if (i4 == 0) {
                i4 = dimensionPixelSize;
            }
            marginLayoutParams.leftMargin = i4;
            int i5 = marginLayoutParams.topMargin;
            if (i5 == 0) {
                i5 = dimensionPixelSize2;
            }
            marginLayoutParams.topMargin = i5;
            int i6 = marginLayoutParams.rightMargin;
            if (i6 != 0) {
                dimensionPixelSize = i6;
            }
            marginLayoutParams.rightMargin = dimensionPixelSize;
            int i7 = marginLayoutParams.bottomMargin;
            if (i7 != 0) {
                dimensionPixelSize2 = i7;
            }
            marginLayoutParams.bottomMargin = dimensionPixelSize2;
        }
        w();
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(EditText.class.getCanonicalName());
        CharSequence text = getText();
        boolean isEmpty = TextUtils.isEmpty(text);
        if (Build.VERSION.SDK_INT >= 26) {
            accessibilityNodeInfo.setHintText(getHint());
            accessibilityNodeInfo.setShowingHintText(isEmpty);
        }
        if (isEmpty) {
            text = getHint();
        }
        accessibilityNodeInfo.setText(text);
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z4, int i4, int i5, int i6, int i7) {
        super.onLayout(z4, i4, i5, i6, i7);
        View view = this.f3732d0;
        if (view != null) {
            int measuredWidth = view.getMeasuredWidth();
            int measuredWidth2 = (getMeasuredWidth() / 2) - (measuredWidth / 2);
            int i8 = measuredWidth + measuredWidth2;
            int measuredHeight = this.f3732d0.getMeasuredHeight();
            int measuredHeight2 = (getMeasuredHeight() / 2) - (measuredHeight / 2);
            int i9 = measuredHeight + measuredHeight2;
            View view2 = this.f3732d0;
            WeakHashMap weakHashMap = y0.f4999a;
            if (h0.d(this) == 1) {
                view2.layout(getMeasuredWidth() - i8, measuredHeight2, getMeasuredWidth() - measuredWidth2, i9);
            } else {
                view2.layout(measuredWidth2, measuredHeight2, i8, i9);
            }
        }
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public final void onMeasure(int i4, int i5) {
        super.onMeasure(i4, i5);
        View view = this.f3732d0;
        if (view != null) {
            view.measure(i4, i5);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.f1460a);
        setText(savedState.f3740c);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [android.os.Parcelable, androidx.customview.view.AbsSavedState, com.google.android.material.search.SearchBar$SavedState] */
    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public final Parcelable onSaveInstanceState() {
        String charSequence;
        ?? absSavedState = new AbsSavedState(super.onSaveInstanceState());
        CharSequence text = getText();
        if (text == null) {
            charSequence = null;
        } else {
            charSequence = text.toString();
        }
        absSavedState.f3740c = charSequence;
        return absSavedState;
    }

    public void setCenterView(@Nullable View view) {
        View view2 = this.f3732d0;
        if (view2 != null) {
            removeView(view2);
            this.f3732d0 = null;
        }
        if (view != null) {
            addView(view);
        }
    }

    public void setDefaultScrollFlagsEnabled(boolean z4) {
        this.f3736h0 = z4;
        w();
    }

    @Override // android.view.View
    @RequiresApi(21)
    public void setElevation(float f4) {
        super.setElevation(f4);
        l2.j jVar = this.f3737i0;
        if (jVar != null) {
            jVar.n(f4);
        }
    }

    public void setHint(@StringRes int i4) {
        this.T.setHint(i4);
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(@Nullable Drawable drawable) {
        int i4;
        int b5;
        if (this.f3730b0 && drawable != null) {
            Integer num = this.f3733e0;
            if (num != null) {
                b5 = num.intValue();
            } else {
                if (drawable == this.f3729a0) {
                    i4 = R.attr.colorOnSurfaceVariant;
                } else {
                    i4 = R.attr.colorOnSurface;
                }
                b5 = y1.a.b(i4, this);
            }
            drawable = drawable.mutate();
            c0.b.g(drawable, b5);
        }
        super.setNavigationIcon(drawable);
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        if (this.f3731c0) {
            return;
        }
        super.setNavigationOnClickListener(onClickListener);
        setNavigationIconDecorative(onClickListener == null);
    }

    public void setOnLoadAnimationFadeInEnabled(boolean z4) {
        this.W.getClass();
    }

    public void setStrokeColor(@ColorInt int i4) {
        if (getStrokeColor() != i4) {
            this.f3737i0.t(ColorStateList.valueOf(i4));
        }
    }

    public void setStrokeWidth(@Dimension float f4) {
        if (getStrokeWidth() != f4) {
            this.f3737i0.u(f4);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setSubtitle(CharSequence charSequence) {
    }

    public void setText(@StringRes int i4) {
        this.T.setText(i4);
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setTitle(CharSequence charSequence) {
    }

    public final void w() {
        if (getLayoutParams() instanceof AppBarLayout.LayoutParams) {
            AppBarLayout.LayoutParams layoutParams = (AppBarLayout.LayoutParams) getLayoutParams();
            if (this.f3736h0) {
                if (layoutParams.f2903a == 0) {
                    layoutParams.f2903a = 53;
                }
            } else if (layoutParams.f2903a == 53) {
                layoutParams.f2903a = 0;
            }
        }
    }

    public SearchBar(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.materialSearchBarStyle);
    }

    public void setHint(@Nullable CharSequence charSequence) {
        this.T.setHint(charSequence);
    }

    public void setText(@Nullable CharSequence charSequence) {
        this.T.setText(charSequence);
    }

    /* JADX WARN: Type inference failed for: r1v4, types: [androidx.fragment.app.m0, java.lang.Object] */
    public SearchBar(@NonNull Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(p2.a.a(context, attributeSet, i4, 2131755964), attributeSet, i4);
        this.f3735g0 = -1;
        this.f3739k0 = new l0.d(4, this);
        Context context2 = getContext();
        if (attributeSet != null) {
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "title") != null) {
                throw new UnsupportedOperationException("SearchBar does not support title. Use hint or text instead.");
            }
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "subtitle") != null) {
                throw new UnsupportedOperationException("SearchBar does not support subtitle. Use hint or text instead.");
            }
        }
        Drawable t02 = com.google.common.collect.c.t0(context2, getDefaultNavigationIconResource());
        this.f3729a0 = t02;
        ?? obj = new Object();
        new LinkedHashSet();
        new LinkedHashSet();
        new LinkedHashSet();
        this.W = obj;
        TypedArray d4 = com.google.android.material.internal.h0.d(context2, attributeSet, o1.a.T, i4, 2131755964, new int[0]);
        l2.p a5 = l2.p.c(context2, attributeSet, i4, 2131755964).a();
        int color = d4.getColor(3, 0);
        float dimension = d4.getDimension(6, 0.0f);
        this.V = d4.getBoolean(4, true);
        this.f3736h0 = d4.getBoolean(5, true);
        boolean z4 = d4.getBoolean(8, false);
        this.f3731c0 = d4.getBoolean(7, false);
        this.f3730b0 = d4.getBoolean(12, true);
        if (d4.hasValue(9)) {
            this.f3733e0 = Integer.valueOf(d4.getColor(9, -1));
        }
        int resourceId = d4.getResourceId(0, -1);
        String string = d4.getString(1);
        String string2 = d4.getString(2);
        float dimension2 = d4.getDimension(11, -1.0f);
        int color2 = d4.getColor(10, 0);
        d4.recycle();
        if (!z4) {
            setNavigationIcon(getNavigationIcon() != null ? getNavigationIcon() : t02);
            setNavigationIconDecorative(true);
        }
        setClickable(true);
        setFocusable(true);
        LayoutInflater.from(context2).inflate(R.layout.mtrl_search_bar, this);
        this.U = true;
        TextView textView = (TextView) findViewById(R.id.open_search_bar_text_view);
        this.T = textView;
        WeakHashMap weakHashMap = y0.f4999a;
        i0.m0.s(this, dimension);
        if (resourceId != -1) {
            textView.setTextAppearance(resourceId);
        }
        setText(string);
        setHint(string2);
        if (getNavigationIcon() == null) {
            i0.p.h((ViewGroup.MarginLayoutParams) textView.getLayoutParams(), getResources().getDimensionPixelSize(R.dimen.m3_searchbar_text_margin_start_no_navigation_icon));
        }
        l2.j jVar = new l2.j(a5);
        this.f3737i0 = jVar;
        jVar.l(getContext());
        this.f3737i0.n(dimension);
        if (dimension2 >= 0.0f) {
            l2.j jVar2 = this.f3737i0;
            jVar2.u(dimension2);
            jVar2.t(ColorStateList.valueOf(color2));
        }
        int b5 = y1.a.b(R.attr.colorControlHighlight, this);
        this.f3737i0.o(ColorStateList.valueOf(color));
        ColorStateList valueOf = ColorStateList.valueOf(b5);
        l2.j jVar3 = this.f3737i0;
        g0.q(this, new RippleDrawable(valueOf, jVar3, jVar3));
        AccessibilityManager accessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
        this.f3738j0 = accessibilityManager;
        if (accessibilityManager != null) {
            if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
                setFocusableInTouchMode(true);
            }
            addOnAttachStateChangeListener(new g.g(2, this));
        }
    }
}