package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.MenuRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.customview.view.AbsSavedState;
import com.example.msphone.R;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.internal.h0;
import com.google.android.material.internal.k0;
import com.google.android.material.internal.n0;
import i0.g0;
import i0.h2;
import i0.j0;
import i0.m0;
import i0.y0;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.WeakHashMap;
import l2.j;

/* loaded from: classes.dex */
public class BottomAppBar extends Toolbar implements androidx.coordinatorlayout.widget.a {

    /* renamed from: u0 */
    public static final /* synthetic */ int f3017u0 = 0;
    public Integer T;
    public final j U;
    public Animator V;
    public Animator W;

    /* renamed from: a0 */
    public int f3018a0;

    /* renamed from: b0 */
    public int f3019b0;

    /* renamed from: c0 */
    public int f3020c0;

    /* renamed from: d0 */
    public final int f3021d0;

    /* renamed from: e0 */
    public int f3022e0;

    /* renamed from: f0 */
    public int f3023f0;

    /* renamed from: g0 */
    public final boolean f3024g0;

    /* renamed from: h0 */
    public boolean f3025h0;

    /* renamed from: i0 */
    public final boolean f3026i0;

    /* renamed from: j0 */
    public final boolean f3027j0;

    /* renamed from: k0 */
    public final boolean f3028k0;

    /* renamed from: l0 */
    public int f3029l0;

    /* renamed from: m0 */
    public boolean f3030m0;

    /* renamed from: n0 */
    public boolean f3031n0;

    /* renamed from: o0 */
    public Behavior f3032o0;

    /* renamed from: p0 */
    public int f3033p0;

    /* renamed from: q0 */
    public int f3034q0;

    /* renamed from: r0 */
    public int f3035r0;

    /* renamed from: s0 */
    public final a f3036s0;

    /* renamed from: t0 */
    public final b f3037t0;

    /* loaded from: classes.dex */
    public static class Behavior extends HideBottomViewOnScrollBehavior<BottomAppBar> {

        /* renamed from: j */
        public final Rect f3038j;

        /* renamed from: k */
        public WeakReference f3039k;

        /* renamed from: l */
        public int f3040l;

        /* renamed from: m */
        public final g f3041m;

        public Behavior() {
            this.f3041m = new g(this);
            this.f3038j = new Rect();
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final boolean l(CoordinatorLayout coordinatorLayout, View view, int i4) {
            BottomAppBar bottomAppBar = (BottomAppBar) view;
            this.f3039k = new WeakReference(bottomAppBar);
            int i5 = BottomAppBar.f3017u0;
            View C = bottomAppBar.C();
            if (C != null) {
                WeakHashMap weakHashMap = y0.f4999a;
                if (!j0.c(C)) {
                    BottomAppBar.L(bottomAppBar, C);
                    this.f3040l = ((ViewGroup.MarginLayoutParams) ((androidx.coordinatorlayout.widget.b) C.getLayoutParams())).bottomMargin;
                    if (C instanceof FloatingActionButton) {
                        FloatingActionButton floatingActionButton = (FloatingActionButton) C;
                        if (bottomAppBar.f3020c0 == 0 && bottomAppBar.f3024g0) {
                            m0.s(floatingActionButton, 0.0f);
                            floatingActionButton.setCompatElevation(0.0f);
                        }
                        if (floatingActionButton.getShowMotionSpec() == null) {
                            floatingActionButton.setShowMotionSpecResource(R.animator.mtrl_fab_show_motion_spec);
                        }
                        if (floatingActionButton.getHideMotionSpec() == null) {
                            floatingActionButton.setHideMotionSpecResource(R.animator.mtrl_fab_hide_motion_spec);
                        }
                        floatingActionButton.c(bottomAppBar.f3036s0);
                        floatingActionButton.d(new a(bottomAppBar, 3));
                        floatingActionButton.e(bottomAppBar.f3037t0);
                    }
                    C.addOnLayoutChangeListener(this.f3041m);
                    bottomAppBar.I();
                }
            }
            coordinatorLayout.v(i4, bottomAppBar);
            super.l(coordinatorLayout, bottomAppBar, i4);
            return false;
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final boolean t(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i4, int i5) {
            BottomAppBar bottomAppBar = (BottomAppBar) view;
            if (bottomAppBar.getHideOnScroll() && super.t(coordinatorLayout, bottomAppBar, view2, view3, i4, i5)) {
                return true;
            }
            return false;
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f3041m = new g(this);
            this.f3038j = new Rect();
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface FabAlignmentMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.f170b})
    /* loaded from: classes.dex */
    public @interface FabAnchorMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface FabAnimationMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.f170b})
    /* loaded from: classes.dex */
    public @interface MenuAlignmentMode {
    }

    /* loaded from: classes.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Object();

        /* renamed from: c */
        public int f3042c;

        /* renamed from: d */
        public boolean f3043d;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f3042c = parcel.readInt();
            this.f3043d = parcel.readInt() != 0;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i4) {
            super.writeToParcel(parcel, i4);
            parcel.writeInt(this.f3042c);
            parcel.writeInt(this.f3043d ? 1 : 0);
        }
    }

    public BottomAppBar(@NonNull Context context) {
        this(context, null);
    }

    public static void L(BottomAppBar bottomAppBar, View view) {
        androidx.coordinatorlayout.widget.b bVar = (androidx.coordinatorlayout.widget.b) view.getLayoutParams();
        bVar.f1350d = 17;
        int i4 = bottomAppBar.f3020c0;
        if (i4 == 1) {
            bVar.f1350d = 49;
        }
        if (i4 == 0) {
            bVar.f1350d |= 80;
        }
    }

    @Nullable
    private ActionMenuView getActionMenuView() {
        for (int i4 = 0; i4 < getChildCount(); i4++) {
            View childAt = getChildAt(i4);
            if (childAt instanceof ActionMenuView) {
                return (ActionMenuView) childAt;
            }
        }
        return null;
    }

    public int getBottomInset() {
        return this.f3033p0;
    }

    private int getFabAlignmentAnimationDuration() {
        return com.google.common.collect.c.K1(getContext(), R.attr.motionDurationLong2, 300);
    }

    public float getFabTranslationX() {
        return E(this.f3018a0);
    }

    private float getFabTranslationY() {
        int i4;
        if (this.f3020c0 == 1) {
            return -getTopEdgeTreatment().f3063f;
        }
        View C = C();
        if (C != null) {
            i4 = (-((getMeasuredHeight() + getBottomInset()) - C.getMeasuredHeight())) / 2;
        } else {
            i4 = 0;
        }
        return i4;
    }

    public int getLeftInset() {
        return this.f3035r0;
    }

    public int getRightInset() {
        return this.f3034q0;
    }

    @NonNull
    public i getTopEdgeTreatment() {
        return (i) this.U.f5310a.f5288a.f5356i;
    }

    public final FloatingActionButton B() {
        View C = C();
        if (C instanceof FloatingActionButton) {
            return (FloatingActionButton) C;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.view.View C() {
        /*
            r4 = this;
            android.view.ViewParent r0 = r4.getParent()
            boolean r0 = r0 instanceof androidx.coordinatorlayout.widget.CoordinatorLayout
            r1 = 0
            if (r0 != 0) goto La
            return r1
        La:
            android.view.ViewParent r0 = r4.getParent()
            androidx.coordinatorlayout.widget.CoordinatorLayout r0 = (androidx.coordinatorlayout.widget.CoordinatorLayout) r0
            v.d r2 = r0.f1328b
            l.k r2 = r2.f6941b
            java.lang.Object r2 = r2.getOrDefault(r4, r1)
            java.util.List r2 = (java.util.List) r2
            java.util.ArrayList r0 = r0.f1330d
            r0.clear()
            if (r2 == 0) goto L24
            r0.addAll(r2)
        L24:
            java.util.Iterator r0 = r0.iterator()
        L28:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L3d
            java.lang.Object r2 = r0.next()
            android.view.View r2 = (android.view.View) r2
            boolean r3 = r2 instanceof com.google.android.material.floatingactionbutton.FloatingActionButton
            if (r3 != 0) goto L3c
            boolean r3 = r2 instanceof com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
            if (r3 == 0) goto L28
        L3c:
            return r2
        L3d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomappbar.BottomAppBar.C():android.view.View");
    }

    public final int D(ActionMenuView actionMenuView, int i4, boolean z4) {
        int i5 = 0;
        if (this.f3023f0 == 1 || (i4 == 1 && z4)) {
            boolean f4 = n0.f(this);
            int measuredWidth = f4 ? getMeasuredWidth() : 0;
            for (int i6 = 0; i6 < getChildCount(); i6++) {
                View childAt = getChildAt(i6);
                if ((childAt.getLayoutParams() instanceof Toolbar.LayoutParams) && (((Toolbar.LayoutParams) childAt.getLayoutParams()).f177a & 8388615) == 8388611) {
                    measuredWidth = f4 ? Math.min(measuredWidth, childAt.getLeft()) : Math.max(measuredWidth, childAt.getRight());
                }
            }
            int right = f4 ? actionMenuView.getRight() : actionMenuView.getLeft();
            int i7 = f4 ? this.f3034q0 : -this.f3035r0;
            if (getNavigationIcon() == null) {
                i5 = getResources().getDimensionPixelOffset(R.dimen.m3_bottomappbar_horizontal_padding);
                if (!f4) {
                    i5 = -i5;
                }
            }
            return measuredWidth - ((right + i7) + i5);
        }
        return 0;
    }

    public final float E(int i4) {
        boolean f4 = n0.f(this);
        if (i4 == 1) {
            View C = C();
            int i5 = f4 ? this.f3035r0 : this.f3034q0;
            return ((getMeasuredWidth() / 2) - ((this.f3022e0 == -1 || C == null) ? this.f3021d0 + i5 : ((C.getMeasuredWidth() / 2) + this.f3022e0) + i5)) * (f4 ? -1 : 1);
        }
        return 0.0f;
    }

    public final boolean F() {
        FloatingActionButton B = B();
        return B != null && B.i();
    }

    public final void G(int i4, boolean z4) {
        WeakHashMap weakHashMap = y0.f4999a;
        if (!j0.c(this)) {
            this.f3030m0 = false;
            int i5 = this.f3029l0;
            if (i5 != 0) {
                this.f3029l0 = 0;
                getMenu().clear();
                n(i5);
                return;
            }
            return;
        }
        Animator animator = this.W;
        if (animator != null) {
            animator.cancel();
        }
        ArrayList arrayList = new ArrayList();
        if (!F()) {
            i4 = 0;
            z4 = false;
        }
        ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView != null) {
            float fabAlignmentAnimationDuration = getFabAlignmentAnimationDuration();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(actionMenuView, "alpha", 1.0f);
            ofFloat.setDuration(0.8f * fabAlignmentAnimationDuration);
            if (Math.abs(actionMenuView.getTranslationX() - D(actionMenuView, i4, z4)) > 1.0f) {
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(actionMenuView, "alpha", 0.0f);
                ofFloat2.setDuration(fabAlignmentAnimationDuration * 0.2f);
                ofFloat2.addListener(new e(this, actionMenuView, i4, z4));
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playSequentially(ofFloat2, ofFloat);
                arrayList.add(animatorSet);
            } else if (actionMenuView.getAlpha() < 1.0f) {
                arrayList.add(ofFloat);
            }
        }
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.playTogether(arrayList);
        this.W = animatorSet2;
        animatorSet2.addListener(new a(this, 2));
        this.W.start();
    }

    public final void H() {
        ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView != null && this.W == null) {
            actionMenuView.setAlpha(1.0f);
            if (!F()) {
                K(actionMenuView, 0, false, false);
            } else {
                K(actionMenuView, this.f3018a0, this.f3031n0, false);
            }
        }
    }

    public final void I() {
        float f4;
        getTopEdgeTreatment().f3064g = getFabTranslationX();
        j jVar = this.U;
        if (this.f3031n0 && F() && this.f3020c0 == 1) {
            f4 = 1.0f;
        } else {
            f4 = 0.0f;
        }
        jVar.p(f4);
        View C = C();
        if (C != null) {
            C.setTranslationY(getFabTranslationY());
            C.setTranslationX(getFabTranslationX());
        }
    }

    public final void J(int i4) {
        float f4 = i4;
        if (f4 != getTopEdgeTreatment().f3062e) {
            getTopEdgeTreatment().f3062e = f4;
            this.U.invalidateSelf();
        }
    }

    public final void K(ActionMenuView actionMenuView, int i4, boolean z4, boolean z5) {
        f fVar = new f(this, actionMenuView, i4, z4);
        if (z5) {
            actionMenuView.post(fVar);
        } else {
            fVar.run();
        }
    }

    @Nullable
    public ColorStateList getBackgroundTint() {
        return this.U.f5310a.f5293f;
    }

    @Dimension
    public float getCradleVerticalOffset() {
        return getTopEdgeTreatment().f3063f;
    }

    public int getFabAlignmentMode() {
        return this.f3018a0;
    }

    @Px
    public int getFabAlignmentModeEndMargin() {
        return this.f3022e0;
    }

    public int getFabAnchorMode() {
        return this.f3020c0;
    }

    public int getFabAnimationMode() {
        return this.f3019b0;
    }

    public float getFabCradleMargin() {
        return getTopEdgeTreatment().f3061d;
    }

    @Dimension
    public float getFabCradleRoundedCornerRadius() {
        return getTopEdgeTreatment().f3060c;
    }

    public boolean getHideOnScroll() {
        return this.f3025h0;
    }

    public int getMenuAlignmentMode() {
        return this.f3023f0;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.google.common.collect.c.R1(this, this.U);
        if (getParent() instanceof ViewGroup) {
            ((ViewGroup) getParent()).setClipChildren(false);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z4, int i4, int i5, int i6, int i7) {
        super.onLayout(z4, i4, i5, i6, i7);
        if (z4) {
            Animator animator = this.W;
            if (animator != null) {
                animator.cancel();
            }
            Animator animator2 = this.V;
            if (animator2 != null) {
                animator2.cancel();
            }
            I();
            View C = C();
            if (C != null) {
                WeakHashMap weakHashMap = y0.f4999a;
                if (j0.c(C)) {
                    C.post(new h2(1, C));
                }
            }
        }
        H();
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.f1460a);
        this.f3018a0 = savedState.f3042c;
        this.f3031n0 = savedState.f3043d;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [android.os.Parcelable, androidx.customview.view.AbsSavedState, com.google.android.material.bottomappbar.BottomAppBar$SavedState] */
    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public final Parcelable onSaveInstanceState() {
        ?? absSavedState = new AbsSavedState(super.onSaveInstanceState());
        absSavedState.f3042c = this.f3018a0;
        absSavedState.f3043d = this.f3031n0;
        return absSavedState;
    }

    public void setBackgroundTint(@Nullable ColorStateList colorStateList) {
        c0.b.h(this.U, colorStateList);
    }

    public void setCradleVerticalOffset(@Dimension float f4) {
        if (f4 != getCradleVerticalOffset()) {
            getTopEdgeTreatment().u(f4);
            this.U.invalidateSelf();
            I();
        }
    }

    @Override // android.view.View
    public void setElevation(float f4) {
        j jVar = this.U;
        jVar.n(f4);
        int i4 = jVar.f5310a.f5304q - jVar.i();
        Behavior behavior = getBehavior();
        behavior.f3007h = i4;
        if (behavior.f3006g == 1) {
            setTranslationY(behavior.f3005f + i4);
        }
    }

    public void setFabAlignmentMode(int i4) {
        setFabAlignmentModeAndReplaceMenu(i4, 0);
    }

    public void setFabAlignmentModeAndReplaceMenu(int i4, @MenuRes int i5) {
        this.f3029l0 = i5;
        this.f3030m0 = true;
        G(i4, this.f3031n0);
        if (this.f3018a0 != i4) {
            WeakHashMap weakHashMap = y0.f4999a;
            if (j0.c(this)) {
                Animator animator = this.V;
                if (animator != null) {
                    animator.cancel();
                }
                ArrayList arrayList = new ArrayList();
                if (this.f3019b0 == 1) {
                    ObjectAnimator ofFloat = ObjectAnimator.ofFloat(B(), "translationX", E(i4));
                    ofFloat.setDuration(getFabAlignmentAnimationDuration());
                    arrayList.add(ofFloat);
                } else {
                    FloatingActionButton B = B();
                    if (B != null && !B.h()) {
                        B.g(new d(this, i4), true);
                    }
                }
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(arrayList);
                animatorSet.setInterpolator(com.google.common.collect.c.L1(getContext(), R.attr.motionEasingEmphasizedInterpolator, p1.a.f6128a));
                this.V = animatorSet;
                animatorSet.addListener(new a(this, 1));
                this.V.start();
            }
        }
        this.f3018a0 = i4;
    }

    public void setFabAlignmentModeEndMargin(@Px int i4) {
        if (this.f3022e0 != i4) {
            this.f3022e0 = i4;
            I();
        }
    }

    public void setFabAnchorMode(int i4) {
        this.f3020c0 = i4;
        I();
        View C = C();
        if (C != null) {
            L(this, C);
            C.requestLayout();
            this.U.invalidateSelf();
        }
    }

    public void setFabAnimationMode(int i4) {
        this.f3019b0 = i4;
    }

    public void setFabCornerSize(@Dimension float f4) {
        if (f4 != getTopEdgeTreatment().f3065h) {
            getTopEdgeTreatment().f3065h = f4;
            this.U.invalidateSelf();
        }
    }

    public void setFabCradleMargin(@Dimension float f4) {
        if (f4 != getFabCradleMargin()) {
            getTopEdgeTreatment().f3061d = f4;
            this.U.invalidateSelf();
        }
    }

    public void setFabCradleRoundedCornerRadius(@Dimension float f4) {
        if (f4 != getFabCradleRoundedCornerRadius()) {
            getTopEdgeTreatment().f3060c = f4;
            this.U.invalidateSelf();
        }
    }

    public void setHideOnScroll(boolean z4) {
        this.f3025h0 = z4;
    }

    public void setMenuAlignmentMode(int i4) {
        if (this.f3023f0 != i4) {
            this.f3023f0 = i4;
            ActionMenuView actionMenuView = getActionMenuView();
            if (actionMenuView != null) {
                K(actionMenuView, this.f3018a0, F(), false);
            }
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(@Nullable Drawable drawable) {
        if (drawable != null && this.T != null) {
            drawable = drawable.mutate();
            c0.b.g(drawable, this.T.intValue());
        }
        super.setNavigationIcon(drawable);
    }

    public void setNavigationIconTint(@ColorInt int i4) {
        this.T = Integer.valueOf(i4);
        Drawable navigationIcon = getNavigationIcon();
        if (navigationIcon != null) {
            setNavigationIcon(navigationIcon);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setSubtitle(CharSequence charSequence) {
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setTitle(CharSequence charSequence) {
    }

    public BottomAppBar(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.bottomAppBarStyle);
    }

    @Override // androidx.coordinatorlayout.widget.a
    @NonNull
    public Behavior getBehavior() {
        if (this.f3032o0 == null) {
            this.f3032o0 = new Behavior();
        }
        return this.f3032o0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v3, types: [java.lang.Object, com.google.common.collect.c] */
    /* JADX WARN: Type inference failed for: r15v3, types: [java.lang.Object, com.google.common.collect.c] */
    /* JADX WARN: Type inference failed for: r1v8, types: [com.google.android.material.bottomappbar.i, l2.f] */
    /* JADX WARN: Type inference failed for: r4v3, types: [l2.p, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v4, types: [java.lang.Object, com.google.common.collect.c] */
    /* JADX WARN: Type inference failed for: r9v16, types: [java.lang.Object, com.google.common.collect.c] */
    public BottomAppBar(@NonNull Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(p2.a.a(context, attributeSet, i4, 2131756010), attributeSet, i4);
        j jVar = new j();
        this.U = jVar;
        this.f3029l0 = 0;
        this.f3030m0 = false;
        this.f3031n0 = true;
        this.f3036s0 = new a(this, 0);
        this.f3037t0 = new b(this);
        Context context2 = getContext();
        TypedArray d4 = h0.d(context2, attributeSet, o1.a.f5944e, i4, 2131756010, new int[0]);
        ColorStateList a5 = i2.d.a(context2, d4, 1);
        if (d4.hasValue(12)) {
            setNavigationIconTint(d4.getColor(12, -1));
        }
        int dimensionPixelSize = d4.getDimensionPixelSize(2, 0);
        this.f3018a0 = d4.getInt(3, 0);
        this.f3019b0 = d4.getInt(6, 0);
        this.f3020c0 = d4.getInt(5, 1);
        this.f3024g0 = d4.getBoolean(16, true);
        this.f3023f0 = d4.getInt(11, 0);
        this.f3025h0 = d4.getBoolean(10, false);
        this.f3026i0 = d4.getBoolean(13, false);
        this.f3027j0 = d4.getBoolean(14, false);
        this.f3028k0 = d4.getBoolean(15, false);
        this.f3022e0 = d4.getDimensionPixelOffset(4, -1);
        boolean z4 = d4.getBoolean(0, true);
        d4.recycle();
        this.f3021d0 = getResources().getDimensionPixelOffset(R.dimen.mtrl_bottomappbar_fabOffsetEndMode);
        ?? fVar = new l2.f(0, 0);
        fVar.f3065h = -1.0f;
        fVar.f3061d = d4.getDimensionPixelOffset(7, 0);
        fVar.f3060c = d4.getDimensionPixelOffset(8, 0);
        fVar.u(d4.getDimensionPixelOffset(9, 0));
        fVar.f3064g = 0.0f;
        ?? obj = new Object();
        ?? obj2 = new Object();
        ?? obj3 = new Object();
        ?? obj4 = new Object();
        l2.a aVar = new l2.a(0.0f);
        l2.a aVar2 = new l2.a(0.0f);
        l2.a aVar3 = new l2.a(0.0f);
        l2.a aVar4 = new l2.a(0.0f);
        l2.f b02 = com.google.common.collect.c.b0();
        l2.f b03 = com.google.common.collect.c.b0();
        l2.f b04 = com.google.common.collect.c.b0();
        ?? obj5 = new Object();
        obj5.f5348a = obj;
        obj5.f5349b = obj2;
        obj5.f5350c = obj3;
        obj5.f5351d = obj4;
        obj5.f5352e = aVar;
        obj5.f5353f = aVar2;
        obj5.f5354g = aVar3;
        obj5.f5355h = aVar4;
        obj5.f5356i = fVar;
        obj5.f5357j = b02;
        obj5.f5358k = b03;
        obj5.f5359l = b04;
        jVar.setShapeAppearanceModel(obj5);
        if (z4) {
            jVar.s(2);
        } else {
            jVar.s(1);
            if (Build.VERSION.SDK_INT >= 28) {
                setOutlineAmbientShadowColor(0);
                setOutlineSpotShadowColor(0);
            }
        }
        jVar.q(Paint.Style.FILL);
        jVar.l(context2);
        setElevation(dimensionPixelSize);
        c0.b.h(jVar, a5);
        WeakHashMap weakHashMap = y0.f4999a;
        g0.q(this, jVar);
        b bVar = new b(this);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, o1.a.f5965v, i4, 2131756010);
        boolean z5 = obtainStyledAttributes.getBoolean(3, false);
        boolean z6 = obtainStyledAttributes.getBoolean(4, false);
        boolean z7 = obtainStyledAttributes.getBoolean(5, false);
        obtainStyledAttributes.recycle();
        n0.b(this, new k0(z5, z6, z7, bVar));
    }
}