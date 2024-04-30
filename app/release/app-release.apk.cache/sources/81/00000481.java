package com.google.android.material.appbar;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.app.o0;
import androidx.appcompat.widget.Toolbar;
import com.example.msphone.R;
import i0.g0;
import i0.g2;
import i0.h0;
import i0.j0;
import i0.k0;
import i0.m0;
import i0.y0;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class CollapsingToolbarLayout extends FrameLayout {
    public g2 A;
    public int B;
    public boolean C;
    public int D;
    public boolean E;

    /* renamed from: a  reason: collision with root package name */
    public boolean f2906a;

    /* renamed from: b  reason: collision with root package name */
    public final int f2907b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f2908c;

    /* renamed from: d  reason: collision with root package name */
    public View f2909d;

    /* renamed from: e  reason: collision with root package name */
    public View f2910e;

    /* renamed from: f  reason: collision with root package name */
    public int f2911f;

    /* renamed from: g  reason: collision with root package name */
    public int f2912g;

    /* renamed from: h  reason: collision with root package name */
    public int f2913h;

    /* renamed from: i  reason: collision with root package name */
    public int f2914i;

    /* renamed from: j  reason: collision with root package name */
    public final Rect f2915j;

    /* renamed from: k  reason: collision with root package name */
    public final com.google.android.material.internal.d f2916k;

    /* renamed from: l  reason: collision with root package name */
    public final b2.a f2917l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f2918m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f2919n;

    /* renamed from: o  reason: collision with root package name */
    public Drawable f2920o;

    /* renamed from: p  reason: collision with root package name */
    public Drawable f2921p;

    /* renamed from: q  reason: collision with root package name */
    public int f2922q;

    /* renamed from: r  reason: collision with root package name */
    public boolean f2923r;

    /* renamed from: s  reason: collision with root package name */
    public ValueAnimator f2924s;

    /* renamed from: t  reason: collision with root package name */
    public long f2925t;

    /* renamed from: u  reason: collision with root package name */
    public final TimeInterpolator f2926u;

    /* renamed from: v  reason: collision with root package name */
    public final TimeInterpolator f2927v;

    /* renamed from: w  reason: collision with root package name */
    public int f2928w;

    /* renamed from: x  reason: collision with root package name */
    public j f2929x;

    /* renamed from: y  reason: collision with root package name */
    public int f2930y;

    /* renamed from: z  reason: collision with root package name */
    public int f2931z;

    /* loaded from: classes.dex */
    public static class LayoutParams extends FrameLayout.LayoutParams {

        /* renamed from: a  reason: collision with root package name */
        public int f2932a;

        /* renamed from: b  reason: collision with root package name */
        public float f2933b;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f2932a = 0;
            this.f2933b = 0.5f;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, o1.a.f5958o);
            this.f2932a = obtainStyledAttributes.getInt(0, 0);
            this.f2933b = obtainStyledAttributes.getFloat(1, 0.5f);
            obtainStyledAttributes.recycle();
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.f170b})
    /* loaded from: classes.dex */
    public @interface TitleCollapseMode {
    }

    public CollapsingToolbarLayout(@NonNull Context context) {
        this(context, null);
    }

    public static m b(View view) {
        m mVar = (m) view.getTag(R.id.view_offset_helper);
        if (mVar == null) {
            m mVar2 = new m(view);
            view.setTag(R.id.view_offset_helper, mVar2);
            return mVar2;
        }
        return mVar;
    }

    public final void a() {
        if (!this.f2906a) {
            return;
        }
        ViewGroup viewGroup = null;
        this.f2908c = null;
        this.f2909d = null;
        int i4 = this.f2907b;
        if (i4 != -1) {
            ViewGroup viewGroup2 = (ViewGroup) findViewById(i4);
            this.f2908c = viewGroup2;
            if (viewGroup2 != null) {
                ViewParent parent = viewGroup2.getParent();
                View view = viewGroup2;
                while (parent != this && parent != null) {
                    if (parent instanceof View) {
                        view = (View) parent;
                    }
                    parent = parent.getParent();
                    view = view;
                }
                this.f2909d = view;
            }
        }
        if (this.f2908c == null) {
            int childCount = getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = getChildAt(i5);
                if ((childAt instanceof Toolbar) || (childAt instanceof android.widget.Toolbar)) {
                    viewGroup = (ViewGroup) childAt;
                    break;
                }
            }
            this.f2908c = viewGroup;
        }
        c();
        this.f2906a = false;
    }

    public final void c() {
        View view;
        if (!this.f2918m && (view = this.f2910e) != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f2910e);
            }
        }
        if (!this.f2918m || this.f2908c == null) {
            return;
        }
        if (this.f2910e == null) {
            this.f2910e = new View(getContext());
        }
        if (this.f2910e.getParent() == null) {
            this.f2908c.addView(this.f2910e, -1, -1);
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public final void d() {
        if (this.f2920o == null && this.f2921p == null) {
            return;
        }
        setScrimsShown(getHeight() + this.f2930y < getScrimVisibleHeightTrigger());
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        int i4;
        Drawable drawable;
        super.draw(canvas);
        a();
        if (this.f2908c == null && (drawable = this.f2920o) != null && this.f2922q > 0) {
            drawable.mutate().setAlpha(this.f2922q);
            this.f2920o.draw(canvas);
        }
        if (this.f2918m && this.f2919n) {
            ViewGroup viewGroup = this.f2908c;
            com.google.android.material.internal.d dVar = this.f2916k;
            if (viewGroup != null && this.f2920o != null && this.f2922q > 0 && this.f2931z == 1 && dVar.f3493b < dVar.f3499e) {
                int save = canvas.save();
                canvas.clipRect(this.f2920o.getBounds(), Region.Op.DIFFERENCE);
                dVar.d(canvas);
                canvas.restoreToCount(save);
            } else {
                dVar.d(canvas);
            }
        }
        if (this.f2921p != null && this.f2922q > 0) {
            g2 g2Var = this.A;
            if (g2Var != null) {
                i4 = g2Var.d();
            } else {
                i4 = 0;
            }
            if (i4 > 0) {
                this.f2921p.setBounds(0, -this.f2930y, getWidth(), i4 - this.f2930y);
                this.f2921p.mutate().setAlpha(this.f2922q);
                this.f2921p.draw(canvas);
            }
        }
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas canvas, View view, long j4) {
        boolean z4;
        View view2;
        Drawable drawable = this.f2920o;
        if (drawable != null && this.f2922q > 0 && ((view2 = this.f2909d) == null || view2 == this ? view == this.f2908c : view == view2)) {
            int width = getWidth();
            int height = getHeight();
            if (this.f2931z == 1 && view != null && this.f2918m) {
                height = view.getBottom();
            }
            drawable.setBounds(0, 0, width, height);
            this.f2920o.mutate().setAlpha(this.f2922q);
            this.f2920o.draw(canvas);
            z4 = true;
        } else {
            z4 = false;
        }
        if (super.drawChild(canvas, view, j4) || z4) {
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        boolean z4;
        ColorStateList colorStateList;
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f2921p;
        boolean z5 = false;
        if (drawable != null && drawable.isStateful()) {
            z4 = drawable.setState(drawableState);
        } else {
            z4 = false;
        }
        Drawable drawable2 = this.f2920o;
        if (drawable2 != null && drawable2.isStateful()) {
            z4 |= drawable2.setState(drawableState);
        }
        com.google.android.material.internal.d dVar = this.f2916k;
        if (dVar != null) {
            dVar.R = drawableState;
            ColorStateList colorStateList2 = dVar.f3519o;
            if ((colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = dVar.f3517n) != null && colorStateList.isStateful())) {
                dVar.i(false);
                z5 = true;
            }
            z4 |= z5;
        }
        if (z4) {
            invalidate();
        }
    }

    public final void e(boolean z4, int i4, int i5, int i6, int i7) {
        View view;
        boolean z5;
        boolean z6;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        if (this.f2918m && (view = this.f2910e) != null) {
            WeakHashMap weakHashMap = y0.f4999a;
            int i14 = 0;
            if (j0.b(view) && this.f2910e.getVisibility() == 0) {
                z5 = true;
            } else {
                z5 = false;
            }
            this.f2919n = z5;
            if (z5 || z4) {
                if (h0.d(this) == 1) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                View view2 = this.f2909d;
                if (view2 == null) {
                    view2 = this.f2908c;
                }
                int height = ((getHeight() - b(view2).f2970b) - view2.getHeight()) - ((FrameLayout.LayoutParams) ((LayoutParams) view2.getLayoutParams())).bottomMargin;
                View view3 = this.f2910e;
                Rect rect = this.f2915j;
                com.google.android.material.internal.e.a(this, view3, rect);
                ViewGroup viewGroup = this.f2908c;
                if (viewGroup instanceof Toolbar) {
                    Toolbar toolbar = (Toolbar) viewGroup;
                    i14 = toolbar.getTitleMarginStart();
                    i9 = toolbar.getTitleMarginEnd();
                    i10 = toolbar.getTitleMarginTop();
                    i8 = toolbar.getTitleMarginBottom();
                } else if (viewGroup instanceof android.widget.Toolbar) {
                    android.widget.Toolbar toolbar2 = (android.widget.Toolbar) viewGroup;
                    i14 = toolbar2.getTitleMarginStart();
                    i9 = toolbar2.getTitleMarginEnd();
                    i10 = toolbar2.getTitleMarginTop();
                    i8 = toolbar2.getTitleMarginBottom();
                } else {
                    i8 = 0;
                    i9 = 0;
                    i10 = 0;
                }
                int i15 = rect.left;
                if (z6) {
                    i11 = i9;
                } else {
                    i11 = i14;
                }
                int i16 = i15 + i11;
                int i17 = rect.top + height + i10;
                int i18 = rect.right;
                if (!z6) {
                    i14 = i9;
                }
                int i19 = i18 - i14;
                int i20 = (rect.bottom + height) - i8;
                com.google.android.material.internal.d dVar = this.f2916k;
                Rect rect2 = dVar.f3505h;
                if (rect2.left != i16 || rect2.top != i17 || rect2.right != i19 || rect2.bottom != i20) {
                    rect2.set(i16, i17, i19, i20);
                    dVar.S = true;
                }
                if (z6) {
                    i12 = this.f2913h;
                } else {
                    i12 = this.f2911f;
                }
                int i21 = rect.top + this.f2912g;
                int i22 = i6 - i4;
                if (z6) {
                    i13 = this.f2911f;
                } else {
                    i13 = this.f2913h;
                }
                int i23 = i22 - i13;
                int i24 = (i7 - i5) - this.f2914i;
                Rect rect3 = dVar.f3503g;
                if (rect3.left != i12 || rect3.top != i21 || rect3.right != i23 || rect3.bottom != i24) {
                    rect3.set(i12, i21, i23, i24);
                    dVar.S = true;
                }
                dVar.i(z4);
            }
        }
    }

    public final void f() {
        CharSequence charSequence;
        if (this.f2908c != null && this.f2918m && TextUtils.isEmpty(this.f2916k.G)) {
            ViewGroup viewGroup = this.f2908c;
            if (viewGroup instanceof Toolbar) {
                charSequence = ((Toolbar) viewGroup).getTitle();
            } else if (viewGroup instanceof android.widget.Toolbar) {
                charSequence = ((android.widget.Toolbar) viewGroup).getTitle();
            } else {
                charSequence = null;
            }
            setTitle(charSequence);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [android.view.ViewGroup$LayoutParams, com.google.android.material.appbar.CollapsingToolbarLayout$LayoutParams, android.widget.FrameLayout$LayoutParams] */
    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        ?? layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.f2932a = 0;
        layoutParams.f2933b = 0.5f;
        return layoutParams;
    }

    public int getCollapsedTitleGravity() {
        return this.f2916k.f3511k;
    }

    public float getCollapsedTitleTextSize() {
        return this.f2916k.f3515m;
    }

    @NonNull
    public Typeface getCollapsedTitleTypeface() {
        Typeface typeface = this.f2916k.f3530w;
        if (typeface == null) {
            return Typeface.DEFAULT;
        }
        return typeface;
    }

    @Nullable
    public Drawable getContentScrim() {
        return this.f2920o;
    }

    public int getExpandedTitleGravity() {
        return this.f2916k.f3509j;
    }

    public int getExpandedTitleMarginBottom() {
        return this.f2914i;
    }

    public int getExpandedTitleMarginEnd() {
        return this.f2913h;
    }

    public int getExpandedTitleMarginStart() {
        return this.f2911f;
    }

    public int getExpandedTitleMarginTop() {
        return this.f2912g;
    }

    public float getExpandedTitleTextSize() {
        return this.f2916k.f3513l;
    }

    @NonNull
    public Typeface getExpandedTitleTypeface() {
        Typeface typeface = this.f2916k.f3533z;
        if (typeface == null) {
            return Typeface.DEFAULT;
        }
        return typeface;
    }

    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.f170b})
    public int getHyphenationFrequency() {
        return this.f2916k.f3524q0;
    }

    @RestrictTo({RestrictTo.Scope.f170b})
    public int getLineCount() {
        StaticLayout staticLayout = this.f2916k.f3508i0;
        if (staticLayout != null) {
            return staticLayout.getLineCount();
        }
        return 0;
    }

    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.f170b})
    public float getLineSpacingAdd() {
        return this.f2916k.f3508i0.getSpacingAdd();
    }

    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.f170b})
    public float getLineSpacingMultiplier() {
        return this.f2916k.f3508i0.getSpacingMultiplier();
    }

    @RestrictTo({RestrictTo.Scope.f170b})
    public int getMaxLines() {
        return this.f2916k.f3518n0;
    }

    public int getScrimAlpha() {
        return this.f2922q;
    }

    public long getScrimAnimationDuration() {
        return this.f2925t;
    }

    public int getScrimVisibleHeightTrigger() {
        int i4;
        int i5 = this.f2928w;
        if (i5 >= 0) {
            return i5 + this.B + this.D;
        }
        g2 g2Var = this.A;
        if (g2Var != null) {
            i4 = g2Var.d();
        } else {
            i4 = 0;
        }
        WeakHashMap weakHashMap = y0.f4999a;
        int d4 = g0.d(this);
        if (d4 > 0) {
            return Math.min((d4 * 2) + i4, getHeight());
        }
        return getHeight() / 3;
    }

    @Nullable
    public Drawable getStatusBarScrim() {
        return this.f2921p;
    }

    @Nullable
    public CharSequence getTitle() {
        if (this.f2918m) {
            return this.f2916k.G;
        }
        return null;
    }

    public int getTitleCollapseMode() {
        return this.f2931z;
    }

    @Nullable
    public TimeInterpolator getTitlePositionInterpolator() {
        return this.f2916k.V;
    }

    @NonNull
    public TextUtils.TruncateAt getTitleTextEllipsize() {
        return this.f2916k.F;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof AppBarLayout) {
            AppBarLayout appBarLayout = (AppBarLayout) parent;
            if (this.f2931z == 1) {
                appBarLayout.setLiftOnScroll(false);
            }
            WeakHashMap weakHashMap = y0.f4999a;
            setFitsSystemWindows(g0.b(appBarLayout));
            if (this.f2929x == null) {
                this.f2929x = new j(this);
            }
            j jVar = this.f2929x;
            if (appBarLayout.f2875h == null) {
                appBarLayout.f2875h = new ArrayList();
            }
            if (jVar != null && !appBarLayout.f2875h.contains(jVar)) {
                appBarLayout.f2875h.add(jVar);
            }
            k0.c(this);
        }
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f2916k.h(configuration);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        ArrayList arrayList;
        ViewParent parent = getParent();
        j jVar = this.f2929x;
        if (jVar != null && (parent instanceof AppBarLayout) && (arrayList = ((AppBarLayout) parent).f2875h) != null) {
            arrayList.remove(jVar);
        }
        super.onDetachedFromWindow();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z4, int i4, int i5, int i6, int i7) {
        super.onLayout(z4, i4, i5, i6, i7);
        g2 g2Var = this.A;
        if (g2Var != null) {
            int d4 = g2Var.d();
            int childCount = getChildCount();
            for (int i8 = 0; i8 < childCount; i8++) {
                View childAt = getChildAt(i8);
                WeakHashMap weakHashMap = y0.f4999a;
                if (!g0.b(childAt) && childAt.getTop() < d4) {
                    childAt.offsetTopAndBottom(d4);
                }
            }
        }
        int childCount2 = getChildCount();
        for (int i9 = 0; i9 < childCount2; i9++) {
            m b5 = b(getChildAt(i9));
            View view = b5.f2969a;
            b5.f2970b = view.getTop();
            b5.f2971c = view.getLeft();
        }
        e(false, i4, i5, i6, i7);
        f();
        d();
        int childCount3 = getChildCount();
        for (int i10 = 0; i10 < childCount3; i10++) {
            b(getChildAt(i10)).a();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i4, int i5) {
        int i6;
        int measuredHeight;
        int measuredHeight2;
        a();
        super.onMeasure(i4, i5);
        int mode = View.MeasureSpec.getMode(i5);
        g2 g2Var = this.A;
        if (g2Var != null) {
            i6 = g2Var.d();
        } else {
            i6 = 0;
        }
        if ((mode == 0 || this.C) && i6 > 0) {
            this.B = i6;
            super.onMeasure(i4, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() + i6, 1073741824));
        }
        if (this.E) {
            com.google.android.material.internal.d dVar = this.f2916k;
            if (dVar.f3518n0 > 1) {
                f();
                e(true, 0, 0, getMeasuredWidth(), getMeasuredHeight());
                int i7 = dVar.f3521p;
                if (i7 > 1) {
                    TextPaint textPaint = dVar.U;
                    textPaint.setTextSize(dVar.f3513l);
                    textPaint.setTypeface(dVar.f3533z);
                    textPaint.setLetterSpacing(dVar.f3504g0);
                    int i8 = i7 - 1;
                    this.D = i8 * Math.round(textPaint.descent() + (-textPaint.ascent()));
                    super.onMeasure(i4, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() + this.D, 1073741824));
                }
            }
        }
        ViewGroup viewGroup = this.f2908c;
        if (viewGroup != null) {
            View view = this.f2909d;
            if (view != null && view != this) {
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    measuredHeight2 = view.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
                } else {
                    measuredHeight2 = view.getMeasuredHeight();
                }
                setMinimumHeight(measuredHeight2);
                return;
            }
            ViewGroup.LayoutParams layoutParams2 = viewGroup.getLayoutParams();
            if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
                measuredHeight = viewGroup.getMeasuredHeight() + marginLayoutParams2.topMargin + marginLayoutParams2.bottomMargin;
            } else {
                measuredHeight = viewGroup.getMeasuredHeight();
            }
            setMinimumHeight(measuredHeight);
        }
    }

    @Override // android.view.View
    public final void onSizeChanged(int i4, int i5, int i6, int i7) {
        super.onSizeChanged(i4, i5, i6, i7);
        Drawable drawable = this.f2920o;
        if (drawable != null) {
            ViewGroup viewGroup = this.f2908c;
            if (this.f2931z == 1 && viewGroup != null && this.f2918m) {
                i5 = viewGroup.getBottom();
            }
            drawable.setBounds(0, 0, i4, i5);
        }
    }

    public void setCollapsedTitleGravity(int i4) {
        this.f2916k.l(i4);
    }

    public void setCollapsedTitleTextAppearance(@StyleRes int i4) {
        this.f2916k.k(i4);
    }

    public void setCollapsedTitleTextColor(@ColorInt int i4) {
        setCollapsedTitleTextColor(ColorStateList.valueOf(i4));
    }

    public void setCollapsedTitleTextSize(float f4) {
        com.google.android.material.internal.d dVar = this.f2916k;
        if (dVar.f3515m != f4) {
            dVar.f3515m = f4;
            dVar.i(false);
        }
    }

    public void setCollapsedTitleTypeface(@Nullable Typeface typeface) {
        com.google.android.material.internal.d dVar = this.f2916k;
        if (dVar.m(typeface)) {
            dVar.i(false);
        }
    }

    public void setContentScrim(@Nullable Drawable drawable) {
        Drawable drawable2 = this.f2920o;
        if (drawable2 != drawable) {
            Drawable drawable3 = null;
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            if (drawable != null) {
                drawable3 = drawable.mutate();
            }
            this.f2920o = drawable3;
            if (drawable3 != null) {
                int width = getWidth();
                int height = getHeight();
                ViewGroup viewGroup = this.f2908c;
                if (this.f2931z == 1 && viewGroup != null && this.f2918m) {
                    height = viewGroup.getBottom();
                }
                drawable3.setBounds(0, 0, width, height);
                this.f2920o.setCallback(this);
                this.f2920o.setAlpha(this.f2922q);
            }
            WeakHashMap weakHashMap = y0.f4999a;
            g0.k(this);
        }
    }

    public void setContentScrimColor(@ColorInt int i4) {
        setContentScrim(new ColorDrawable(i4));
    }

    public void setContentScrimResource(@DrawableRes int i4) {
        Context context = getContext();
        Object obj = z.e.f7215a;
        setContentScrim(z.c.b(context, i4));
    }

    public void setExpandedTitleColor(@ColorInt int i4) {
        setExpandedTitleTextColor(ColorStateList.valueOf(i4));
    }

    public void setExpandedTitleGravity(int i4) {
        com.google.android.material.internal.d dVar = this.f2916k;
        if (dVar.f3509j != i4) {
            dVar.f3509j = i4;
            dVar.i(false);
        }
    }

    public void setExpandedTitleMargin(int i4, int i5, int i6, int i7) {
        this.f2911f = i4;
        this.f2912g = i5;
        this.f2913h = i6;
        this.f2914i = i7;
        requestLayout();
    }

    public void setExpandedTitleMarginBottom(int i4) {
        this.f2914i = i4;
        requestLayout();
    }

    public void setExpandedTitleMarginEnd(int i4) {
        this.f2913h = i4;
        requestLayout();
    }

    public void setExpandedTitleMarginStart(int i4) {
        this.f2911f = i4;
        requestLayout();
    }

    public void setExpandedTitleMarginTop(int i4) {
        this.f2912g = i4;
        requestLayout();
    }

    public void setExpandedTitleTextAppearance(@StyleRes int i4) {
        this.f2916k.n(i4);
    }

    public void setExpandedTitleTextColor(@NonNull ColorStateList colorStateList) {
        com.google.android.material.internal.d dVar = this.f2916k;
        if (dVar.f3517n != colorStateList) {
            dVar.f3517n = colorStateList;
            dVar.i(false);
        }
    }

    public void setExpandedTitleTextSize(float f4) {
        com.google.android.material.internal.d dVar = this.f2916k;
        if (dVar.f3513l != f4) {
            dVar.f3513l = f4;
            dVar.i(false);
        }
    }

    public void setExpandedTitleTypeface(@Nullable Typeface typeface) {
        com.google.android.material.internal.d dVar = this.f2916k;
        if (dVar.o(typeface)) {
            dVar.i(false);
        }
    }

    @RestrictTo({RestrictTo.Scope.f170b})
    public void setExtraMultilineHeightEnabled(boolean z4) {
        this.E = z4;
    }

    @RestrictTo({RestrictTo.Scope.f170b})
    public void setForceApplySystemWindowInsetTop(boolean z4) {
        this.C = z4;
    }

    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.f170b})
    public void setHyphenationFrequency(int i4) {
        this.f2916k.f3524q0 = i4;
    }

    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.f170b})
    public void setLineSpacingAdd(float f4) {
        this.f2916k.f3520o0 = f4;
    }

    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.f170b})
    public void setLineSpacingMultiplier(@FloatRange(from = 0.0d) float f4) {
        this.f2916k.f3522p0 = f4;
    }

    @RestrictTo({RestrictTo.Scope.f170b})
    public void setMaxLines(int i4) {
        com.google.android.material.internal.d dVar = this.f2916k;
        if (i4 != dVar.f3518n0) {
            dVar.f3518n0 = i4;
            Bitmap bitmap = dVar.K;
            if (bitmap != null) {
                bitmap.recycle();
                dVar.K = null;
            }
            dVar.i(false);
        }
    }

    @RestrictTo({RestrictTo.Scope.f170b})
    public void setRtlTextDirectionHeuristicsEnabled(boolean z4) {
        this.f2916k.J = z4;
    }

    public void setScrimAlpha(int i4) {
        ViewGroup viewGroup;
        if (i4 != this.f2922q) {
            if (this.f2920o != null && (viewGroup = this.f2908c) != null) {
                WeakHashMap weakHashMap = y0.f4999a;
                g0.k(viewGroup);
            }
            this.f2922q = i4;
            WeakHashMap weakHashMap2 = y0.f4999a;
            g0.k(this);
        }
    }

    public void setScrimAnimationDuration(@IntRange(from = 0) long j4) {
        this.f2925t = j4;
    }

    public void setScrimVisibleHeightTrigger(@IntRange(from = 0) int i4) {
        if (this.f2928w != i4) {
            this.f2928w = i4;
            d();
        }
    }

    public void setScrimsShown(boolean z4) {
        WeakHashMap weakHashMap = y0.f4999a;
        setScrimsShown(z4, j0.c(this) && !isInEditMode());
    }

    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.f170b})
    public void setStaticLayoutBuilderConfigurer(@Nullable k kVar) {
        com.google.android.material.internal.d dVar = this.f2916k;
        if (kVar != null) {
            dVar.i(true);
        } else {
            dVar.getClass();
        }
    }

    public void setStatusBarScrim(@Nullable Drawable drawable) {
        boolean z4;
        Drawable drawable2 = this.f2921p;
        if (drawable2 != drawable) {
            Drawable drawable3 = null;
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            if (drawable != null) {
                drawable3 = drawable.mutate();
            }
            this.f2921p = drawable3;
            if (drawable3 != null) {
                if (drawable3.isStateful()) {
                    this.f2921p.setState(getDrawableState());
                }
                Drawable drawable4 = this.f2921p;
                WeakHashMap weakHashMap = y0.f4999a;
                c0.c.b(drawable4, h0.d(this));
                Drawable drawable5 = this.f2921p;
                if (getVisibility() == 0) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                drawable5.setVisible(z4, false);
                this.f2921p.setCallback(this);
                this.f2921p.setAlpha(this.f2922q);
            }
            WeakHashMap weakHashMap2 = y0.f4999a;
            g0.k(this);
        }
    }

    public void setStatusBarScrimColor(@ColorInt int i4) {
        setStatusBarScrim(new ColorDrawable(i4));
    }

    public void setStatusBarScrimResource(@DrawableRes int i4) {
        Context context = getContext();
        Object obj = z.e.f7215a;
        setStatusBarScrim(z.c.b(context, i4));
    }

    public void setTitle(@Nullable CharSequence charSequence) {
        com.google.android.material.internal.d dVar = this.f2916k;
        if (charSequence == null || !TextUtils.equals(dVar.G, charSequence)) {
            dVar.G = charSequence;
            dVar.H = null;
            Bitmap bitmap = dVar.K;
            if (bitmap != null) {
                bitmap.recycle();
                dVar.K = null;
            }
            dVar.i(false);
        }
        setContentDescription(getTitle());
    }

    public void setTitleCollapseMode(int i4) {
        boolean z4;
        this.f2931z = i4;
        if (i4 == 1) {
            z4 = true;
        } else {
            z4 = false;
        }
        this.f2916k.f3495c = z4;
        ViewParent parent = getParent();
        if (parent instanceof AppBarLayout) {
            AppBarLayout appBarLayout = (AppBarLayout) parent;
            if (this.f2931z == 1) {
                appBarLayout.setLiftOnScroll(false);
            }
        }
        if (z4 && this.f2920o == null) {
            float dimension = getResources().getDimension(R.dimen.design_appbar_elevation);
            b2.a aVar = this.f2917l;
            setContentScrimColor(aVar.a(aVar.f2520d, dimension));
        }
    }

    public void setTitleEllipsize(@NonNull TextUtils.TruncateAt truncateAt) {
        com.google.android.material.internal.d dVar = this.f2916k;
        dVar.F = truncateAt;
        dVar.i(false);
    }

    public void setTitleEnabled(boolean z4) {
        if (z4 != this.f2918m) {
            this.f2918m = z4;
            setContentDescription(getTitle());
            c();
            requestLayout();
        }
    }

    public void setTitlePositionInterpolator(@Nullable TimeInterpolator timeInterpolator) {
        com.google.android.material.internal.d dVar = this.f2916k;
        dVar.V = timeInterpolator;
        dVar.i(false);
    }

    @Override // android.view.View
    public void setVisibility(int i4) {
        super.setVisibility(i4);
        boolean z4 = i4 == 0;
        Drawable drawable = this.f2921p;
        if (drawable != null && drawable.isVisible() != z4) {
            this.f2921p.setVisible(z4, false);
        }
        Drawable drawable2 = this.f2920o;
        if (drawable2 == null || drawable2.isVisible() == z4) {
            return;
        }
        this.f2920o.setVisible(z4, false);
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f2920o || drawable == this.f2921p;
    }

    public CollapsingToolbarLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.collapsingToolbarLayoutStyle);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.material.appbar.CollapsingToolbarLayout$LayoutParams, android.widget.FrameLayout$LayoutParams] */
    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final FrameLayout.LayoutParams generateDefaultLayoutParams() {
        ?? layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.f2932a = 0;
        layoutParams.f2933b = 0.5f;
        return layoutParams;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [android.view.ViewGroup$LayoutParams, com.google.android.material.appbar.CollapsingToolbarLayout$LayoutParams, android.widget.FrameLayout$LayoutParams] */
    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        ?? layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
        layoutParams2.f2932a = 0;
        layoutParams2.f2933b = 0.5f;
        return layoutParams2;
    }

    public void setCollapsedTitleTextColor(@NonNull ColorStateList colorStateList) {
        com.google.android.material.internal.d dVar = this.f2916k;
        if (dVar.f3519o != colorStateList) {
            dVar.f3519o = colorStateList;
            dVar.i(false);
        }
    }

    public CollapsingToolbarLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(p2.a.a(context, attributeSet, i4, 2131755826), attributeSet, i4);
        int i5;
        ColorStateList a5;
        ColorStateList a6;
        TextUtils.TruncateAt truncateAt;
        this.f2906a = true;
        this.f2915j = new Rect();
        this.f2928w = -1;
        this.B = 0;
        this.D = 0;
        Context context2 = getContext();
        com.google.android.material.internal.d dVar = new com.google.android.material.internal.d(this);
        this.f2916k = dVar;
        dVar.W = p1.a.f6132e;
        dVar.i(false);
        dVar.J = false;
        this.f2917l = new b2.a(context2);
        int[] iArr = o1.a.f5957n;
        com.google.android.material.internal.h0.a(context2, attributeSet, i4, 2131755826);
        com.google.android.material.internal.h0.b(context2, attributeSet, iArr, i4, 2131755826, new int[0]);
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, iArr, i4, 2131755826);
        int i6 = obtainStyledAttributes.getInt(4, 8388691);
        if (dVar.f3509j != i6) {
            dVar.f3509j = i6;
            dVar.i(false);
        }
        dVar.l(obtainStyledAttributes.getInt(0, 8388627));
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(5, 0);
        this.f2914i = dimensionPixelSize;
        this.f2913h = dimensionPixelSize;
        this.f2912g = dimensionPixelSize;
        this.f2911f = dimensionPixelSize;
        if (obtainStyledAttributes.hasValue(8)) {
            this.f2911f = obtainStyledAttributes.getDimensionPixelSize(8, 0);
        }
        if (obtainStyledAttributes.hasValue(7)) {
            this.f2913h = obtainStyledAttributes.getDimensionPixelSize(7, 0);
        }
        if (obtainStyledAttributes.hasValue(9)) {
            this.f2912g = obtainStyledAttributes.getDimensionPixelSize(9, 0);
        }
        if (obtainStyledAttributes.hasValue(6)) {
            this.f2914i = obtainStyledAttributes.getDimensionPixelSize(6, 0);
        }
        this.f2918m = obtainStyledAttributes.getBoolean(20, true);
        setTitle(obtainStyledAttributes.getText(18));
        dVar.n(2131755464);
        dVar.k(2131755443);
        if (obtainStyledAttributes.hasValue(10)) {
            dVar.n(obtainStyledAttributes.getResourceId(10, 0));
        }
        if (obtainStyledAttributes.hasValue(1)) {
            dVar.k(obtainStyledAttributes.getResourceId(1, 0));
        }
        if (obtainStyledAttributes.hasValue(22)) {
            int i7 = obtainStyledAttributes.getInt(22, -1);
            if (i7 == 0) {
                truncateAt = TextUtils.TruncateAt.START;
            } else if (i7 != 1) {
                truncateAt = i7 != 3 ? TextUtils.TruncateAt.END : TextUtils.TruncateAt.MARQUEE;
            } else {
                truncateAt = TextUtils.TruncateAt.MIDDLE;
            }
            setTitleEllipsize(truncateAt);
        }
        if (obtainStyledAttributes.hasValue(11) && dVar.f3517n != (a6 = i2.d.a(context2, obtainStyledAttributes, 11))) {
            dVar.f3517n = a6;
            dVar.i(false);
        }
        if (obtainStyledAttributes.hasValue(2) && dVar.f3519o != (a5 = i2.d.a(context2, obtainStyledAttributes, 2))) {
            dVar.f3519o = a5;
            dVar.i(false);
        }
        this.f2928w = obtainStyledAttributes.getDimensionPixelSize(16, -1);
        if (obtainStyledAttributes.hasValue(14) && (i5 = obtainStyledAttributes.getInt(14, 1)) != dVar.f3518n0) {
            dVar.f3518n0 = i5;
            Bitmap bitmap = dVar.K;
            if (bitmap != null) {
                bitmap.recycle();
                dVar.K = null;
            }
            dVar.i(false);
        }
        if (obtainStyledAttributes.hasValue(21)) {
            dVar.V = AnimationUtils.loadInterpolator(context2, obtainStyledAttributes.getResourceId(21, 0));
            dVar.i(false);
        }
        this.f2925t = obtainStyledAttributes.getInt(15, 600);
        this.f2926u = com.google.common.collect.c.L1(context2, R.attr.motionEasingStandardInterpolator, p1.a.f6130c);
        this.f2927v = com.google.common.collect.c.L1(context2, R.attr.motionEasingStandardInterpolator, p1.a.f6131d);
        setContentScrim(obtainStyledAttributes.getDrawable(3));
        setStatusBarScrim(obtainStyledAttributes.getDrawable(17));
        setTitleCollapseMode(obtainStyledAttributes.getInt(19, 0));
        this.f2907b = obtainStyledAttributes.getResourceId(23, -1);
        this.C = obtainStyledAttributes.getBoolean(13, false);
        this.E = obtainStyledAttributes.getBoolean(12, false);
        obtainStyledAttributes.recycle();
        setWillNotDraw(false);
        o0 o0Var = new o0(26, this);
        WeakHashMap weakHashMap = y0.f4999a;
        m0.u(this, o0Var);
    }

    public void setScrimsShown(boolean z4, boolean z5) {
        if (this.f2923r != z4) {
            if (z5) {
                int i4 = z4 ? 255 : 0;
                a();
                ValueAnimator valueAnimator = this.f2924s;
                if (valueAnimator == null) {
                    ValueAnimator valueAnimator2 = new ValueAnimator();
                    this.f2924s = valueAnimator2;
                    valueAnimator2.setInterpolator(i4 > this.f2922q ? this.f2926u : this.f2927v);
                    this.f2924s.addUpdateListener(new i(0, this));
                } else if (valueAnimator.isRunning()) {
                    this.f2924s.cancel();
                }
                this.f2924s.setDuration(this.f2925t);
                this.f2924s.setIntValues(this.f2922q, i4);
                this.f2924s.start();
            } else {
                setScrimAlpha(z4 ? 255 : 0);
            }
            this.f2923r = z4;
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }
}