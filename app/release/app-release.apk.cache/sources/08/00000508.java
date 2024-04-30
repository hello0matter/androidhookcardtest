package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import androidx.annotation.AnimatorRes;
import androidx.annotation.ColorInt;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.widget.c0;
import androidx.appcompat.widget.e0;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import c2.a;
import com.example.msphone.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomappbar.b;
import com.google.android.material.bottomappbar.d;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.internal.VisibilityAwareImageButton;
import com.google.android.material.internal.e;
import com.google.android.material.internal.h0;
import com.google.android.material.internal.n0;
import com.google.android.material.stateful.ExtendableSavedState;
import com.google.common.collect.c;
import d2.i;
import d2.j;
import d2.k;
import d2.q;
import d2.s;
import i0.j0;
import i0.y0;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;
import l2.a0;
import l2.p;
import p1.f;
import w1.g;

/* loaded from: classes.dex */
public class FloatingActionButton extends VisibilityAwareImageButton implements a, a0, androidx.coordinatorlayout.widget.a {

    /* renamed from: b  reason: collision with root package name */
    public ColorStateList f3402b;

    /* renamed from: c  reason: collision with root package name */
    public PorterDuff.Mode f3403c;

    /* renamed from: d  reason: collision with root package name */
    public ColorStateList f3404d;

    /* renamed from: e  reason: collision with root package name */
    public PorterDuff.Mode f3405e;

    /* renamed from: f  reason: collision with root package name */
    public ColorStateList f3406f;

    /* renamed from: g  reason: collision with root package name */
    public int f3407g;

    /* renamed from: h  reason: collision with root package name */
    public int f3408h;

    /* renamed from: i  reason: collision with root package name */
    public int f3409i;

    /* renamed from: j  reason: collision with root package name */
    public int f3410j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f3411k;

    /* renamed from: l  reason: collision with root package name */
    public final Rect f3412l;

    /* renamed from: m  reason: collision with root package name */
    public final Rect f3413m;

    /* renamed from: n  reason: collision with root package name */
    public final e0 f3414n;

    /* renamed from: o  reason: collision with root package name */
    public final g0.a f3415o;

    /* renamed from: p  reason: collision with root package name */
    public s f3416p;

    /* loaded from: classes.dex */
    public static class Behavior extends BaseBehavior<FloatingActionButton> {
        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.f170b})
    /* loaded from: classes.dex */
    public @interface Size {
    }

    public FloatingActionButton(@NonNull Context context) {
        this(context, null);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [d2.s, d2.q] */
    private q getImpl() {
        if (this.f3416p == null) {
            this.f3416p = new q(this, new g(2, this));
        }
        return this.f3416p;
    }

    public final void c(com.google.android.material.bottomappbar.a aVar) {
        q impl = getImpl();
        if (impl.f4413t == null) {
            impl.f4413t = new ArrayList();
        }
        impl.f4413t.add(aVar);
    }

    public final void d(com.google.android.material.bottomappbar.a aVar) {
        q impl = getImpl();
        if (impl.f4412s == null) {
            impl.f4412s = new ArrayList();
        }
        impl.f4412s.add(aVar);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        getImpl().j(getDrawableState());
    }

    public final void e(b bVar) {
        q impl = getImpl();
        i iVar = new i(this, bVar);
        if (impl.f4414u == null) {
            impl.f4414u = new ArrayList();
        }
        impl.f4414u.add(iVar);
    }

    public final int f(int i4) {
        int i5 = this.f3408h;
        if (i5 != 0) {
            return i5;
        }
        Resources resources = getResources();
        if (i4 != -1) {
            return resources.getDimensionPixelSize(i4 != 1 ? R.dimen.design_fab_size_normal : R.dimen.design_fab_size_mini);
        }
        return Math.max(resources.getConfiguration().screenWidthDp, resources.getConfiguration().screenHeightDp) < 470 ? f(1) : f(0);
    }

    public final void g(d dVar, boolean z4) {
        c0 c0Var;
        int i4;
        AnimatorSet c4;
        q impl = getImpl();
        if (dVar == null) {
            c0Var = null;
        } else {
            c0Var = new c0(11, (View) this, (Object) dVar);
        }
        if (impl.f4415v.getVisibility() == 0) {
            if (impl.f4411r == 1) {
                return;
            }
        } else if (impl.f4411r != 2) {
            return;
        }
        Animator animator = impl.f4405l;
        if (animator != null) {
            animator.cancel();
        }
        WeakHashMap weakHashMap = y0.f4999a;
        FloatingActionButton floatingActionButton = impl.f4415v;
        if (j0.c(floatingActionButton) && !floatingActionButton.isInEditMode()) {
            f fVar = impl.f4407n;
            if (fVar != null) {
                c4 = impl.b(fVar, 0.0f, 0.0f, 0.0f);
            } else {
                c4 = impl.c(0.0f, 0.4f, 0.4f, q.F, q.G);
            }
            c4.addListener(new j(impl, z4, c0Var));
            ArrayList arrayList = impl.f4413t;
            if (arrayList != null) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    c4.addListener((Animator.AnimatorListener) it.next());
                }
            }
            c4.start();
            return;
        }
        if (z4) {
            i4 = 8;
        } else {
            i4 = 4;
        }
        floatingActionButton.a(i4, z4);
        if (c0Var != null) {
            ((c) c0Var.f725b).p1((FloatingActionButton) c0Var.f726c);
        }
    }

    @Override // android.view.View
    @Nullable
    public ColorStateList getBackgroundTintList() {
        return this.f3402b;
    }

    @Override // android.view.View
    @Nullable
    public PorterDuff.Mode getBackgroundTintMode() {
        return this.f3403c;
    }

    @Override // androidx.coordinatorlayout.widget.a
    @NonNull
    public CoordinatorLayout.Behavior<FloatingActionButton> getBehavior() {
        return new Behavior();
    }

    public float getCompatElevation() {
        return getImpl().e();
    }

    public float getCompatHoveredFocusedTranslationZ() {
        return getImpl().f4402i;
    }

    public float getCompatPressedTranslationZ() {
        return getImpl().f4403j;
    }

    @Nullable
    public Drawable getContentBackground() {
        return getImpl().f4398e;
    }

    @Px
    public int getCustomSize() {
        return this.f3408h;
    }

    public int getExpandedComponentIdHint() {
        return this.f3415o.f4761b;
    }

    @Nullable
    public f getHideMotionSpec() {
        return getImpl().f4407n;
    }

    @ColorInt
    @Deprecated
    public int getRippleColor() {
        ColorStateList colorStateList = this.f3406f;
        if (colorStateList != null) {
            return colorStateList.getDefaultColor();
        }
        return 0;
    }

    @Nullable
    public ColorStateList getRippleColorStateList() {
        return this.f3406f;
    }

    @NonNull
    public p getShapeAppearanceModel() {
        p pVar = getImpl().f4394a;
        pVar.getClass();
        return pVar;
    }

    @Nullable
    public f getShowMotionSpec() {
        return getImpl().f4406m;
    }

    public int getSize() {
        return this.f3407g;
    }

    public int getSizeDimension() {
        return f(this.f3407g);
    }

    @Nullable
    public ColorStateList getSupportBackgroundTintList() {
        return getBackgroundTintList();
    }

    @Nullable
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return getBackgroundTintMode();
    }

    @Nullable
    public ColorStateList getSupportImageTintList() {
        return this.f3404d;
    }

    @Nullable
    public PorterDuff.Mode getSupportImageTintMode() {
        return this.f3405e;
    }

    public boolean getUseCompatPadding() {
        return this.f3411k;
    }

    public final boolean h() {
        q impl = getImpl();
        int visibility = impl.f4415v.getVisibility();
        int i4 = impl.f4411r;
        if (visibility == 0) {
            if (i4 != 1) {
                return false;
            }
        } else if (i4 == 2) {
            return false;
        }
        return true;
    }

    public final boolean i() {
        q impl = getImpl();
        int visibility = impl.f4415v.getVisibility();
        int i4 = impl.f4411r;
        if (visibility != 0) {
            if (i4 != 2) {
                return false;
            }
        } else if (i4 == 1) {
            return false;
        }
        return true;
    }

    public final void j(Rect rect) {
        int i4 = rect.left;
        Rect rect2 = this.f3412l;
        rect.left = i4 + rect2.left;
        rect.top += rect2.top;
        rect.right -= rect2.right;
        rect.bottom -= rect2.bottom;
    }

    @Override // android.widget.ImageView, android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        getImpl().h();
    }

    public final void k() {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        ColorStateList colorStateList = this.f3404d;
        if (colorStateList == null) {
            drawable.clearColorFilter();
            return;
        }
        int colorForState = colorStateList.getColorForState(getDrawableState(), 0);
        PorterDuff.Mode mode = this.f3405e;
        if (mode == null) {
            mode = PorterDuff.Mode.SRC_IN;
        }
        drawable.mutate().setColorFilter(androidx.appcompat.widget.a0.c(colorForState, mode));
    }

    public final void l(com.google.android.material.bottomappbar.c cVar, boolean z4) {
        c0 c0Var;
        boolean z5;
        AnimatorSet c4;
        float f4;
        float f5;
        q impl = getImpl();
        if (cVar == null) {
            c0Var = null;
        } else {
            c0Var = new c0(11, (View) this, (Object) cVar);
        }
        boolean z6 = true;
        if (impl.f4415v.getVisibility() != 0) {
            if (impl.f4411r == 2) {
                return;
            }
        } else if (impl.f4411r != 1) {
            return;
        }
        Animator animator = impl.f4405l;
        if (animator != null) {
            animator.cancel();
        }
        if (impl.f4406m == null) {
            z5 = true;
        } else {
            z5 = false;
        }
        WeakHashMap weakHashMap = y0.f4999a;
        FloatingActionButton floatingActionButton = impl.f4415v;
        if (!j0.c(floatingActionButton) || floatingActionButton.isInEditMode()) {
            z6 = false;
        }
        Matrix matrix = impl.A;
        if (z6) {
            if (floatingActionButton.getVisibility() != 0) {
                float f6 = 0.0f;
                floatingActionButton.setAlpha(0.0f);
                if (z5) {
                    f4 = 0.4f;
                } else {
                    f4 = 0.0f;
                }
                floatingActionButton.setScaleY(f4);
                if (z5) {
                    f5 = 0.4f;
                } else {
                    f5 = 0.0f;
                }
                floatingActionButton.setScaleX(f5);
                if (z5) {
                    f6 = 0.4f;
                }
                impl.f4409p = f6;
                impl.a(f6, matrix);
                floatingActionButton.setImageMatrix(matrix);
            }
            f fVar = impl.f4406m;
            if (fVar != null) {
                c4 = impl.b(fVar, 1.0f, 1.0f, 1.0f);
            } else {
                c4 = impl.c(1.0f, 1.0f, 1.0f, q.D, q.E);
            }
            c4.addListener(new k(impl, z4, c0Var));
            ArrayList arrayList = impl.f4412s;
            if (arrayList != null) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    c4.addListener((Animator.AnimatorListener) it.next());
                }
            }
            c4.start();
            return;
        }
        floatingActionButton.a(0, z4);
        floatingActionButton.setAlpha(1.0f);
        floatingActionButton.setScaleY(1.0f);
        floatingActionButton.setScaleX(1.0f);
        impl.f4409p = 1.0f;
        impl.a(1.0f, matrix);
        floatingActionButton.setImageMatrix(matrix);
        if (c0Var != null) {
            ((c) c0Var.f725b).s1();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        q impl = getImpl();
        l2.j jVar = impl.f4395b;
        FloatingActionButton floatingActionButton = impl.f4415v;
        if (jVar != null) {
            c.R1(floatingActionButton, jVar);
        }
        if (!(impl instanceof s)) {
            ViewTreeObserver viewTreeObserver = floatingActionButton.getViewTreeObserver();
            if (impl.B == null) {
                impl.B = new v.b(2, impl);
            }
            viewTreeObserver.addOnPreDrawListener(impl.B);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        q impl = getImpl();
        ViewTreeObserver viewTreeObserver = impl.f4415v.getViewTreeObserver();
        v.b bVar = impl.B;
        if (bVar != null) {
            viewTreeObserver.removeOnPreDrawListener(bVar);
            impl.B = null;
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onMeasure(int i4, int i5) {
        int sizeDimension = getSizeDimension();
        this.f3409i = (sizeDimension - this.f3410j) / 2;
        getImpl().r();
        int min = Math.min(View.resolveSize(sizeDimension, i4), View.resolveSize(sizeDimension, i5));
        Rect rect = this.f3412l;
        setMeasuredDimension(rect.left + min + rect.right, min + rect.top + rect.bottom);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof ExtendableSavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        ExtendableSavedState extendableSavedState = (ExtendableSavedState) parcelable;
        super.onRestoreInstanceState(extendableSavedState.f1460a);
        Bundle bundle = (Bundle) extendableSavedState.f3897c.getOrDefault("expandableWidgetHelper", null);
        bundle.getClass();
        g0.a aVar = this.f3415o;
        aVar.getClass();
        aVar.f4760a = bundle.getBoolean("expanded", false);
        aVar.f4761b = bundle.getInt("expandedComponentIdHint", 0);
        if (aVar.f4760a) {
            ViewParent parent = ((View) aVar.f4762c).getParent();
            if (parent instanceof CoordinatorLayout) {
                ((CoordinatorLayout) parent).m((View) aVar.f4762c);
            }
        }
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        if (onSaveInstanceState == null) {
            onSaveInstanceState = new Bundle();
        }
        ExtendableSavedState extendableSavedState = new ExtendableSavedState(onSaveInstanceState);
        l.k kVar = extendableSavedState.f3897c;
        g0.a aVar = this.f3415o;
        aVar.getClass();
        Bundle bundle = new Bundle();
        bundle.putBoolean("expanded", aVar.f4760a);
        bundle.putInt("expandedComponentIdHint", aVar.f4761b);
        kVar.put("expandableWidgetHelper", bundle);
        return extendableSavedState;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int i4;
        if (motionEvent.getAction() == 0) {
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            Rect rect = this.f3413m;
            rect.set(0, 0, measuredWidth, measuredHeight);
            j(rect);
            s sVar = this.f3416p;
            if (sVar.f4399f) {
                i4 = Math.max((sVar.f4404k - sVar.f4415v.getSizeDimension()) / 2, 0);
            } else {
                i4 = 0;
            }
            int i5 = -i4;
            rect.inset(i5, i5);
            if (!rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                return false;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i4) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundResource(int i4) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundTintList(@Nullable ColorStateList colorStateList) {
        if (this.f3402b != colorStateList) {
            this.f3402b = colorStateList;
            q impl = getImpl();
            l2.j jVar = impl.f4395b;
            if (jVar != null) {
                jVar.setTintList(colorStateList);
            }
            d2.b bVar = impl.f4397d;
            if (bVar != null) {
                if (colorStateList != null) {
                    bVar.f4352m = colorStateList.getColorForState(bVar.getState(), bVar.f4352m);
                }
                bVar.f4355p = colorStateList;
                bVar.f4353n = true;
                bVar.invalidateSelf();
            }
        }
    }

    @Override // android.view.View
    public void setBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        if (this.f3403c != mode) {
            this.f3403c = mode;
            l2.j jVar = getImpl().f4395b;
            if (jVar != null) {
                jVar.setTintMode(mode);
            }
        }
    }

    public void setCompatElevation(float f4) {
        q impl = getImpl();
        if (impl.f4401h != f4) {
            impl.f4401h = f4;
            impl.k(f4, impl.f4402i, impl.f4403j);
        }
    }

    public void setCompatElevationResource(@DimenRes int i4) {
        setCompatElevation(getResources().getDimension(i4));
    }

    public void setCompatHoveredFocusedTranslationZ(float f4) {
        q impl = getImpl();
        if (impl.f4402i != f4) {
            impl.f4402i = f4;
            impl.k(impl.f4401h, f4, impl.f4403j);
        }
    }

    public void setCompatHoveredFocusedTranslationZResource(@DimenRes int i4) {
        setCompatHoveredFocusedTranslationZ(getResources().getDimension(i4));
    }

    public void setCompatPressedTranslationZ(float f4) {
        q impl = getImpl();
        if (impl.f4403j != f4) {
            impl.f4403j = f4;
            impl.k(impl.f4401h, impl.f4402i, f4);
        }
    }

    public void setCompatPressedTranslationZResource(@DimenRes int i4) {
        setCompatPressedTranslationZ(getResources().getDimension(i4));
    }

    public void setCustomSize(@Px int i4) {
        if (i4 < 0) {
            throw new IllegalArgumentException("Custom size must be non-negative");
        }
        if (i4 != this.f3408h) {
            this.f3408h = i4;
            requestLayout();
        }
    }

    @Override // android.view.View
    @RequiresApi(21)
    public void setElevation(float f4) {
        super.setElevation(f4);
        l2.j jVar = getImpl().f4395b;
        if (jVar != null) {
            jVar.n(f4);
        }
    }

    public void setEnsureMinTouchTargetSize(boolean z4) {
        if (z4 != getImpl().f4399f) {
            getImpl().f4399f = z4;
            requestLayout();
        }
    }

    public void setExpandedComponentIdHint(@IdRes int i4) {
        this.f3415o.f4761b = i4;
    }

    public void setHideMotionSpec(@Nullable f fVar) {
        getImpl().f4407n = fVar;
    }

    public void setHideMotionSpecResource(@AnimatorRes int i4) {
        setHideMotionSpec(f.b(getContext(), i4));
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(@Nullable Drawable drawable) {
        if (getDrawable() != drawable) {
            super.setImageDrawable(drawable);
            q impl = getImpl();
            float f4 = impl.f4409p;
            impl.f4409p = f4;
            Matrix matrix = impl.A;
            impl.a(f4, matrix);
            impl.f4415v.setImageMatrix(matrix);
            if (this.f3404d != null) {
                k();
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(@DrawableRes int i4) {
        this.f3414n.c(i4);
        k();
    }

    public void setMaxImageSize(int i4) {
        this.f3410j = i4;
        q impl = getImpl();
        if (impl.f4410q != i4) {
            impl.f4410q = i4;
            float f4 = impl.f4409p;
            impl.f4409p = f4;
            Matrix matrix = impl.A;
            impl.a(f4, matrix);
            impl.f4415v.setImageMatrix(matrix);
        }
    }

    public void setRippleColor(@ColorInt int i4) {
        setRippleColor(ColorStateList.valueOf(i4));
    }

    @Override // android.view.View
    public void setScaleX(float f4) {
        super.setScaleX(f4);
        getImpl().l();
    }

    @Override // android.view.View
    public void setScaleY(float f4) {
        super.setScaleY(f4);
        getImpl().l();
    }

    @RestrictTo({RestrictTo.Scope.f170b})
    @VisibleForTesting
    public void setShadowPaddingEnabled(boolean z4) {
        q impl = getImpl();
        impl.f4400g = z4;
        impl.r();
    }

    @Override // l2.a0
    public void setShapeAppearanceModel(@NonNull p pVar) {
        getImpl().o(pVar);
    }

    public void setShowMotionSpec(@Nullable f fVar) {
        getImpl().f4406m = fVar;
    }

    public void setShowMotionSpecResource(@AnimatorRes int i4) {
        setShowMotionSpec(f.b(getContext(), i4));
    }

    public void setSize(int i4) {
        this.f3408h = 0;
        if (i4 != this.f3407g) {
            this.f3407g = i4;
            requestLayout();
        }
    }

    public void setSupportBackgroundTintList(@Nullable ColorStateList colorStateList) {
        setBackgroundTintList(colorStateList);
    }

    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        setBackgroundTintMode(mode);
    }

    public void setSupportImageTintList(@Nullable ColorStateList colorStateList) {
        if (this.f3404d != colorStateList) {
            this.f3404d = colorStateList;
            k();
        }
    }

    public void setSupportImageTintMode(@Nullable PorterDuff.Mode mode) {
        if (this.f3405e != mode) {
            this.f3405e = mode;
            k();
        }
    }

    @Override // android.view.View
    public void setTranslationX(float f4) {
        super.setTranslationX(f4);
        getImpl().m();
    }

    @Override // android.view.View
    public void setTranslationY(float f4) {
        super.setTranslationY(f4);
        getImpl().m();
    }

    @Override // android.view.View
    public void setTranslationZ(float f4) {
        super.setTranslationZ(f4);
        getImpl().m();
    }

    public void setUseCompatPadding(boolean z4) {
        if (this.f3411k != z4) {
            this.f3411k = z4;
            getImpl().i();
        }
    }

    @Override // com.google.android.material.internal.VisibilityAwareImageButton, android.widget.ImageView, android.view.View
    public void setVisibility(int i4) {
        super.setVisibility(i4);
    }

    /* loaded from: classes.dex */
    public static class BaseBehavior<T extends FloatingActionButton> extends CoordinatorLayout.Behavior<T> {

        /* renamed from: a  reason: collision with root package name */
        public Rect f3417a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f3418b;

        public BaseBehavior() {
            this.f3418b = true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final boolean e(View view, Rect rect) {
            FloatingActionButton floatingActionButton = (FloatingActionButton) view;
            int left = floatingActionButton.getLeft();
            Rect rect2 = floatingActionButton.f3412l;
            rect.set(left + rect2.left, floatingActionButton.getTop() + rect2.top, floatingActionButton.getRight() - rect2.right, floatingActionButton.getBottom() - rect2.bottom);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final void g(androidx.coordinatorlayout.widget.b bVar) {
            if (bVar.f1354h == 0) {
                bVar.f1354h = 80;
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final boolean h(CoordinatorLayout coordinatorLayout, View view, View view2) {
            FloatingActionButton floatingActionButton = (FloatingActionButton) view;
            if (view2 instanceof AppBarLayout) {
                w(coordinatorLayout, (AppBarLayout) view2, floatingActionButton);
                return false;
            }
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            if ((layoutParams instanceof androidx.coordinatorlayout.widget.b) && (((androidx.coordinatorlayout.widget.b) layoutParams).f1347a instanceof BottomSheetBehavior)) {
                x(view2, floatingActionButton);
                return false;
            }
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final boolean l(CoordinatorLayout coordinatorLayout, View view, int i4) {
            int i5;
            FloatingActionButton floatingActionButton = (FloatingActionButton) view;
            ArrayList o4 = coordinatorLayout.o(floatingActionButton);
            int size = o4.size();
            int i6 = 0;
            for (int i7 = 0; i7 < size; i7++) {
                View view2 = (View) o4.get(i7);
                if (view2 instanceof AppBarLayout) {
                    if (w(coordinatorLayout, (AppBarLayout) view2, floatingActionButton)) {
                        break;
                    }
                } else {
                    ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                    if ((layoutParams instanceof androidx.coordinatorlayout.widget.b) && (((androidx.coordinatorlayout.widget.b) layoutParams).f1347a instanceof BottomSheetBehavior) && x(view2, floatingActionButton)) {
                        break;
                    }
                }
            }
            coordinatorLayout.v(i4, floatingActionButton);
            Rect rect = floatingActionButton.f3412l;
            if (rect != null && rect.centerX() > 0 && rect.centerY() > 0) {
                androidx.coordinatorlayout.widget.b bVar = (androidx.coordinatorlayout.widget.b) floatingActionButton.getLayoutParams();
                if (floatingActionButton.getRight() >= coordinatorLayout.getWidth() - ((ViewGroup.MarginLayoutParams) bVar).rightMargin) {
                    i5 = rect.right;
                } else if (floatingActionButton.getLeft() <= ((ViewGroup.MarginLayoutParams) bVar).leftMargin) {
                    i5 = -rect.left;
                } else {
                    i5 = 0;
                }
                if (floatingActionButton.getBottom() >= coordinatorLayout.getHeight() - ((ViewGroup.MarginLayoutParams) bVar).bottomMargin) {
                    i6 = rect.bottom;
                } else if (floatingActionButton.getTop() <= ((ViewGroup.MarginLayoutParams) bVar).topMargin) {
                    i6 = -rect.top;
                }
                if (i6 != 0) {
                    WeakHashMap weakHashMap = y0.f4999a;
                    floatingActionButton.offsetTopAndBottom(i6);
                }
                if (i5 != 0) {
                    WeakHashMap weakHashMap2 = y0.f4999a;
                    floatingActionButton.offsetLeftAndRight(i5);
                    return true;
                }
                return true;
            }
            return true;
        }

        public final boolean w(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, FloatingActionButton floatingActionButton) {
            boolean z4;
            androidx.coordinatorlayout.widget.b bVar = (androidx.coordinatorlayout.widget.b) floatingActionButton.getLayoutParams();
            if (!this.f3418b || bVar.f1352f != appBarLayout.getId() || floatingActionButton.getUserSetVisibility() != 0) {
                z4 = false;
            } else {
                z4 = true;
            }
            if (!z4) {
                return false;
            }
            if (this.f3417a == null) {
                this.f3417a = new Rect();
            }
            Rect rect = this.f3417a;
            e.a(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                floatingActionButton.g(null, false);
            } else {
                floatingActionButton.l(null, false);
            }
            return true;
        }

        public final boolean x(View view, FloatingActionButton floatingActionButton) {
            boolean z4;
            androidx.coordinatorlayout.widget.b bVar = (androidx.coordinatorlayout.widget.b) floatingActionButton.getLayoutParams();
            if (!this.f3418b || bVar.f1352f != view.getId() || floatingActionButton.getUserSetVisibility() != 0) {
                z4 = false;
            } else {
                z4 = true;
            }
            if (!z4) {
                return false;
            }
            if (view.getTop() < (floatingActionButton.getHeight() / 2) + ((ViewGroup.MarginLayoutParams) ((androidx.coordinatorlayout.widget.b) floatingActionButton.getLayoutParams())).topMargin) {
                floatingActionButton.g(null, false);
            } else {
                floatingActionButton.l(null, false);
            }
            return true;
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, o1.a.f5962s);
            this.f3418b = obtainStyledAttributes.getBoolean(0, true);
            obtainStyledAttributes.recycle();
        }
    }

    public FloatingActionButton(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.floatingActionButtonStyle);
    }

    public void setRippleColor(@Nullable ColorStateList colorStateList) {
        if (this.f3406f != colorStateList) {
            this.f3406f = colorStateList;
            getImpl().n(this.f3406f);
        }
    }

    /* JADX WARN: Type inference failed for: r14v1, types: [g0.a, java.lang.Object] */
    public FloatingActionButton(@NonNull Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(p2.a.a(context, attributeSet, i4, 2131755827), attributeSet, i4);
        this.f3412l = new Rect();
        this.f3413m = new Rect();
        Context context2 = getContext();
        TypedArray d4 = h0.d(context2, attributeSet, o1.a.f5961r, i4, 2131755827, new int[0]);
        this.f3402b = i2.d.a(context2, d4, 1);
        this.f3403c = n0.g(d4.getInt(2, -1), null);
        this.f3406f = i2.d.a(context2, d4, 12);
        this.f3407g = d4.getInt(7, -1);
        this.f3408h = d4.getDimensionPixelSize(6, 0);
        int dimensionPixelSize = d4.getDimensionPixelSize(3, 0);
        float dimension = d4.getDimension(4, 0.0f);
        float dimension2 = d4.getDimension(9, 0.0f);
        float dimension3 = d4.getDimension(11, 0.0f);
        this.f3411k = d4.getBoolean(16, false);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.mtrl_fab_min_touch_target);
        setMaxImageSize(d4.getDimensionPixelSize(10, 0));
        f a5 = f.a(context2, d4, 15);
        f a6 = f.a(context2, d4, 8);
        p a7 = p.d(context2, attributeSet, i4, 2131755827, p.f5347m).a();
        boolean z4 = d4.getBoolean(5, false);
        setEnabled(d4.getBoolean(0, true));
        d4.recycle();
        e0 e0Var = new e0(this);
        this.f3414n = e0Var;
        e0Var.b(attributeSet, i4);
        ?? obj = new Object();
        obj.f4760a = false;
        obj.f4761b = 0;
        obj.f4762c = this;
        this.f3415o = obj;
        getImpl().o(a7);
        getImpl().g(this.f3402b, this.f3403c, this.f3406f, dimensionPixelSize);
        getImpl().f4404k = dimensionPixelSize2;
        q impl = getImpl();
        if (impl.f4401h != dimension) {
            impl.f4401h = dimension;
            impl.k(dimension, impl.f4402i, impl.f4403j);
        }
        q impl2 = getImpl();
        if (impl2.f4402i != dimension2) {
            impl2.f4402i = dimension2;
            impl2.k(impl2.f4401h, dimension2, impl2.f4403j);
        }
        q impl3 = getImpl();
        if (impl3.f4403j != dimension3) {
            impl3.f4403j = dimension3;
            impl3.k(impl3.f4401h, impl3.f4402i, dimension3);
        }
        getImpl().f4406m = a5;
        getImpl().f4407n = a6;
        getImpl().f4399f = z4;
        setScaleType(ImageView.ScaleType.MATRIX);
    }
}